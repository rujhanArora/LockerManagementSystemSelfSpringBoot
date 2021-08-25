package com.zeta.LockerManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderItem {
    private OrderItemSize size;
    private String name;
}
