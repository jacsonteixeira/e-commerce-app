package com.jteixeira.ecommerce.kafka;

import com.jteixeira.ecommerce.customer.CustomerResponse;
import com.jteixeira.ecommerce.order.PaymentMethod;
import com.jteixeira.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
