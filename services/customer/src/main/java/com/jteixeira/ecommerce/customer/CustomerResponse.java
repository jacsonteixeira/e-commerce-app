package com.jteixeira.ecommerce.customer;

import com.jteixeira.ecommerce.address.Address;

record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}