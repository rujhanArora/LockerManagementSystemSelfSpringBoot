package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Notification;
import com.zeta.LockerManagementSystem.repositories.NotificationRepository;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public Notification addNotification(Notification notificationToAdd) {
        return notificationRepository.addNotification(notificationToAdd);
    }

    public Map<String, Notification> getAllNotifications() {
        return notificationRepository.getAllNotifications();
    }

}
