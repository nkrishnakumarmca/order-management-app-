package com.kk.shop.service;

import com.kk.shop.domain.Order;
import com.kk.shop.domain.Shop;
import com.kk.shop.exception.OrderNotFoundException;
import com.kk.shop.repository.ShopOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
@Slf4j
public class ShopOrderServiceImpl implements ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;

    @Override
    public List<Order> getAllOrder(String shopId) {

        Optional<Order> order = Optional.ofNullable(shopOrderRepository.findByShopId(shopId));
        if (!order.isPresent()) {
            throw new OrderNotFoundException("Order details not found");
        }
        List<Order> list = new ArrayList<>();
        list.add(order.get());
        return list;
    }

    @Override
    public Order getOrderById(String orderId) {
        Optional<Order> order = shopOrderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new OrderNotFoundException("Order details not found");
        }
        return shopOrderRepository.findById(orderId).get();
    }

    @Override
    public void acceptOrder(String orderId, Shop shop) {
        Optional<Order> orderDetails = shopOrderRepository.findById(orderId);
        if (!orderDetails.isPresent()) {
            throw new OrderNotFoundException("Order details not found");
        }
        Order ord = orderDetails.get();
        ord.setShop(shop);
        ord.setOrderStatus("ACCETPTED");
        shopOrderRepository.save(ord);
    }

    @Override
    public void rejectOrder(String orderId) {
        Optional<Order> order = shopOrderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new OrderNotFoundException("Order details not found");
        }
        Order ord = order.get();
        ord.setOrderStatus("REJECTED");
        shopOrderRepository.save(ord);
    }

    @Override
    public void prepareOrder(String orderId) {
        Optional<Order> order = shopOrderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new OrderNotFoundException("Order details not found");
        }
        Order ord = order.get();
        ord.setOrderStatus("PREPARING");
        shopOrderRepository.save(ord);
    }
}
