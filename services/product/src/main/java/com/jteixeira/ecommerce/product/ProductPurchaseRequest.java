package com.jteixeira.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @Positive(message = "Quantity is mandatory, and needs to be a positive value")
        double quantity
){
}
