package com.kk.api.service;

import com.kk.api.domain.Order;

import java.util.List;

public interface CustomerOrderService {
    String makeOrder(Order order);

    Order fetchOrder(String orderId, String customerId);

    List<Order> fetchAllOrder(String customerId);
}
