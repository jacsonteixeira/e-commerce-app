package com.jteixeira.ecommerce.payment;

import com.jteixeira.ecommerce.customer.CustomerResponse;
import com.jteixeira.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
