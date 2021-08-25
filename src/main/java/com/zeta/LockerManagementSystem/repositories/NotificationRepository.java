package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.models.Notification;
import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class NotificationRepository {

    private Map<String, Notification> idToNotificationMap = new HashMap<>();

    public Notification addNotification(Notification notificationToAdd) {
        Notification notification =
                Notification
                        .builder()
                        .id(TokenUtil.generateRandomTokenDefaultLength())
                        .toEmail(notificationToAdd.getToEmail())
                        .content(notificationToAdd.getContent())
                        .customerId(notificationToAdd.getCustomerId())
                        .build();
        idToNotificationMap.put(notification.getId(), notification);
        return notification;
    }

    public Map<String, Notification> getAllNotifications() {
        return idToNotificationMap;
    }
}
