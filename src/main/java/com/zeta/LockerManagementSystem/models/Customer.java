package com.zeta.LockerManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String id;
    private String name;
    private String email;
    private Long phone;
}
