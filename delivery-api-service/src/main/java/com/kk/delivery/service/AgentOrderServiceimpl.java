package com.kk.delivery.service;

import com.kk.delivery.domain.Agent;
import com.kk.delivery.domain.Order;
import com.kk.delivery.exception.OrderNotFound;
import com.kk.delivery.repository.DeliveryAgentRepository;
import com.kk.delivery.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentOrderServiceimpl implements AgentOrderService {

    private final DeliveryAgentRepository deliveryAgentRepository;

    @Override
    public List<Order> getAllOrdersOfAgent(String agentId) {

        List<Order> orderDetails = deliveryAgentRepository.findByAgentAgentId(agentId);
        if (orderDetails.isEmpty()) {
            throw new OrderNotFound("Order details not found");
        }
        return orderDetails;
    }

    @Override
    public void updateOrderByStatus(Status status, String orderId, Agent agent) {
        Optional<Order> order = deliveryAgentRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new OrderNotFound("Order details not found");
        }
        Order orderDetails = order.get();
        orderDetails.setOrderStatus(status.name());
        orderDetails.setAgent(agent);
        deliveryAgentRepository.save(orderDetails);
    }

}
