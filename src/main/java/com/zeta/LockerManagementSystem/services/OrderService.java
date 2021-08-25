package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order) {
        return orderRepository.addOrder(order);
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }
}
