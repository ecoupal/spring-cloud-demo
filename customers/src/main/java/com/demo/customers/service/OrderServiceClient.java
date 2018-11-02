package com.demo.customers.service;

import com.demo.customers.entity.Order;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceClient {

    private final OrderFeignClient feignClient;

    @Autowired
    public OrderServiceClient(OrderFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @HystrixCommand(fallbackMethod = "defaultGetOrders")
    public List<Order> getOrders(String customerId) {
        log.info("Returning orders for customerId {}", customerId);
        return feignClient.getOrders(customerId);
    }

    public List<Order> defaultGetOrders(String customerId) {
        log.info("*** Returning default orders for customerId {}", customerId);
        return Lists.newArrayList();
    }
}
