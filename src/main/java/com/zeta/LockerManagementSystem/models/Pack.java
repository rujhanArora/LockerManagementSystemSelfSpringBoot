package com.zeta.LockerManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pack {
    private final String id;
    private Order order;
}
