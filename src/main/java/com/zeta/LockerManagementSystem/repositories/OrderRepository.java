package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.dto.LockerDTO;
import com.zeta.LockerManagementSystem.models.Locker;
import com.zeta.LockerManagementSystem.models.LockerStatus;
import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    private Map<String, Order> idToOrderMap = new HashMap<>();

    public Order addOrder(Order orderToAdd) {
        Order order = new Order(TokenUtil.generateRandomTokenDefaultLength(), orderToAdd.getCustomerId(), orderToAdd.getOrderItems(),
                 orderToAdd.getDeliveryLocation());
        idToOrderMap.put(order.getId(), order);
        return order;
    }

    public Optional<Order> getOrderById(String orderId) {
        return Optional.of(idToOrderMap.get(orderId));
    }
}
