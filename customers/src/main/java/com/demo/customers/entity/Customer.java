package com.demo.customers.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Customer {

    private final String id;
    private final String name;

    private List<Order> orders;
}
