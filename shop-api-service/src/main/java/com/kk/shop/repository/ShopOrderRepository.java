package com.kk.shop.repository;

import com.kk.shop.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderRepository extends MongoRepository<Order, String> {
    Order findByShopId(String Id);
}


