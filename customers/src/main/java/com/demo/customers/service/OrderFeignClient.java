package com.demo.customers.service;

import com.demo.customers.entity.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("orders")
public interface OrderFeignClient {

    @GetMapping("/orders/{customerId}")
    List<Order> getOrders(@PathVariable("customerId") String customerId);
}
