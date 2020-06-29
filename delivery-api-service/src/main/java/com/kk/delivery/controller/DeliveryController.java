package com.kk.delivery.controller;

import com.kk.delivery.domain.Agent;
import com.kk.delivery.service.AgentOrderService;
import com.kk.delivery.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/delivery/orders")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliveryController {

    private final AgentOrderService agentOrderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrdersOfAgent(@RequestParam String agentId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agentOrderService.getAllOrdersOfAgent(agentId));

    }

    @PutMapping("/orders/{orderId}/arrive")
    public ResponseEntity<?> orderArrive(@PathVariable String orderId, @RequestBody Agent agent) {
        agentOrderService.updateOrderByStatus(Status.ARRIVE, orderId, agent);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/orders/{orderId}/pickup")
    public ResponseEntity<?> orderPickup(@PathVariable String orderId, @RequestBody Agent agent) {

        agentOrderService.updateOrderByStatus(Status.PICKUP, orderId, agent);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/orders/{orderId}/deliver")
    public ResponseEntity<?> orderDeliverd(@PathVariable String orderId, @RequestBody Agent agent) {

        agentOrderService.updateOrderByStatus(Status.DELIVERED, orderId, agent);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED).build();
    }
}
