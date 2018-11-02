package com.demo.customers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Order {

    private String id;
    private LocalDate date;
}
