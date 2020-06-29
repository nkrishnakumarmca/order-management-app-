package com.kk.delivery.repository;

import com.kk.delivery.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryAgentRepository extends MongoRepository<Order, String> {
    List<Order> findByAgentAgentId(String agentId);
}

