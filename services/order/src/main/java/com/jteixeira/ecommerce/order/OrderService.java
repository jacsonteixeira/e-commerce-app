package com.jteixeira.ecommerce.order;

import com.jteixeira.ecommerce.customer.CustomerClient;
import com.jteixeira.ecommerce.exception.BusinessException;
import com.jteixeira.ecommerce.kafka.OrderConfirmation;
import com.jteixeira.ecommerce.kafka.OrderProducer;
import com.jteixeira.ecommerce.orderline.OrderLineRequest;
import com.jteixeira.ecommerce.orderline.OrderLineService;
import com.jteixeira.ecommerce.payment.PaymentClient;
import com.jteixeira.ecommerce.payment.PaymentRequest;
import com.jteixeira.ecommerce.product.ProductClient;
import com.jteixeira.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createdOrder(@Valid OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: " +
                        "No Customer exists with the provided ID" + request.customerId()));

        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(
                        format("No order found with the provided ID: %d", orderId)));
    }
}
