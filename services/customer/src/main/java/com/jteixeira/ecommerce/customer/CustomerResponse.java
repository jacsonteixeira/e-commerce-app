package com.jteixeira.ecommerce.customer;

import com.jteixeira.ecommerce.address.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
