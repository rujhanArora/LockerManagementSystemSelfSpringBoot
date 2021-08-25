package com.zeta.LockerManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private String id;
    private final OrderStatus orderStatus = OrderStatus.CREATED;
    @NonNull
    private final String customerId;
    @NonNull
    private List<OrderItem> orderItems = new ArrayList<>();
    @NonNull
    private GeoLocation deliveryLocation;

    public Order addOrderItem(OrderItem orderItem) {
        this.getOrderItems().add(orderItem);
        return this;
    }

}
