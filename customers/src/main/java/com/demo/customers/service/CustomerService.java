package com.demo.customers.service;

import com.demo.customers.entity.Customer;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {

    private final OrderServiceClient orderServiceClient;

    @Autowired
    public CustomerService(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }

    public Customer getCustomer(String customerId) {
        return Customer.builder()
                .id("1").name("Eric").orders(orderServiceClient.getOrders(customerId))
                .build();
    }

    public List<Customer> getAllCustomers() {
        log.info("Returning all customers");
        return Lists.newArrayList(
                Customer.builder().id("1").name("Eric").orders(Lists.newArrayList()).build(),
                Customer.builder().id("2").name("Fanny").orders(Lists.newArrayList()).build()
        );
    }
}
