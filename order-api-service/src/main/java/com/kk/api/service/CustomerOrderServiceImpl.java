package com.kk.api.service;

import com.kk.api.domain.Order;
import com.kk.api.exception.OrderNotFound;
import com.kk.api.kafka.Producer;
import com.kk.api.repository.CustomerOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    private final Producer producer;


    @Override
    public String makeOrder(Order order) {
        Order orderDetails = customerOrderRepository.save(order);
        //this.producer.send(orderDetails.getOrderId());
        return orderDetails.getOrderId();
    }

    @Override
    public Order fetchOrder(String orderId, String customerId) {
        Optional<Order> order = customerOrderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new OrderNotFound("Order details not found");
        }
        return order.get();
    }

    @Override
    public List<Order> fetchAllOrder(String customerId) {
        List<Order> order = customerOrderRepository.findByCustomerCustomerId(customerId);
        if (order == null) {
            throw new OrderNotFound("Order not available for this customer");
        }
        return order;
    }
}