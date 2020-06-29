package com.kk.delivery.service;

import com.kk.delivery.domain.Agent;
import com.kk.delivery.domain.Order;
import com.kk.delivery.util.Status;

import java.util.List;

public interface AgentOrderService {

    List<Order> getAllOrdersOfAgent(String agentId);

    void updateOrderByStatus(Status status, String orderId, Agent agent);
}
