package com.kk.shop.controller;

import com.kk.shop.domain.Shop;
import com.kk.shop.service.ShopOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/shop/orders/")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShopController {

    private final ShopOrderService restaurantOrderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrdersOfRestaurant(@RequestParam String shopId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantOrderService.getAllOrder(shopId));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable String orderId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantOrderService.getOrderById(orderId));
    }

    @PutMapping("/orders/{orderId}/accept")
    public ResponseEntity<?> acceptOrder(@PathVariable String orderId, @RequestBody Shop shop) {
        restaurantOrderService.acceptOrder(orderId, shop);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/orders/{orderId}/reject")
    public ResponseEntity<?> rejectOrder(@PathVariable String orderId, @RequestBody Shop shop) {
        restaurantOrderService.rejectOrder(orderId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/orders/{orderId}/prepared")
    public ResponseEntity<?> preparedOrder(@PathVariable String orderId, @RequestBody Shop shop) {
        restaurantOrderService.prepareOrder(orderId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }
}
