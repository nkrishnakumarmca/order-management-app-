package com.kk.api.controller;

import com.kk.api.domain.Order;
import com.kk.api.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final CustomerOrderService customerOrderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrdersOfCustomer(@RequestParam String customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerOrderService.fetchAllOrder(customerId));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable String orderId, @RequestParam String customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerOrderService.fetchOrder(orderId, customerId));

    }

    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerOrderService.makeOrder(order));
    }
}
