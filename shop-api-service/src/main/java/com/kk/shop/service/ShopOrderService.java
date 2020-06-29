package com.kk.shop.service;

import com.kk.shop.domain.Order;
import com.kk.shop.domain.Shop;

import java.util.List;

public interface ShopOrderService {
    List<Order> getAllOrder(String shopId);

    Order getOrderById(String orderId);

    void acceptOrder(String orderId, Shop shop);

    void rejectOrder(String orderId);

    void prepareOrder(String orderId);
}
