package com.zeta.LockerManagementSystem.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {
    private String id;
    private String customerId;
    private String toEmail;
    private String content;
}
