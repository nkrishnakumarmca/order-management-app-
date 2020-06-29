package com.kk.api.repository;

import com.kk.api.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerCustomerId(String customerId);
}
