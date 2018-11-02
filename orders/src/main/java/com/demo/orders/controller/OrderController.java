package com.demo.orders.controller;

import com.demo.orders.entity.Order;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{customerId}")
    @HystrixCommand(fallbackMethod = "defaultGetOrders")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("customerId") String customerId) {
        log.info("Getting orders for customerId {}", customerId);
        return ResponseEntity.ok(Lists.newArrayList(new Order("1", LocalDate.of(2010, 1,1)), new Order("2", LocalDate.of(2000,1,2))));
    }

    public ResponseEntity<List<Order>> defaultGetOrders(@PathVariable("customerId") String customerId) {
        log.info("Getting default orders for customerId {}", customerId);
        return ResponseEntity.ok(Lists.newArrayList());
    }
}
