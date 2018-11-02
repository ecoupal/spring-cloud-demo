package com.demo.customers.controller;

import com.demo.customers.entity.Customer;
import com.demo.customers.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
@RefreshScope
public class CustomerController {

    @Value("${env.random:Hello world}")
    private String random;

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        log.info("Calling getCustomers...");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        log.info("Calling getCustomers...");
        final Customer customer = customerService.getCustomer(customerId);
        customer.setRandom(random);
        return ResponseEntity.ok(customer);
    }
}
