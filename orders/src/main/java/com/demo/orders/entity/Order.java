package com.demo.orders.entity;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Order {

    private final String id;
    private final LocalDate date;
}
