package com.zeta.LockerManagementSystem.events;

import com.zeta.LockerManagementSystem.models.Customer;
import com.zeta.LockerManagementSystem.models.Notification;
import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.models.Pack;
import com.zeta.LockerManagementSystem.services.CustomerService;
import com.zeta.LockerManagementSystem.services.NotificationService;
import com.zeta.LockerManagementSystem.services.OrderService;
import com.zeta.LockerManagementSystem.services.PackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LockerPackEventListener implements ApplicationListener<LockerPackEvent>  {

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    PackService packService;
    @Autowired
    NotificationService notificationService;

    @Override
    public void onApplicationEvent(LockerPackEvent lockerPackEvent) {
        if (!lockerPackEvent.getEventType().equals(LockerPackEvent.EVENT_TYPE.LOCKER_PACK_ADDED)) {
            return;
        }
        // Send notification  to customer here
        Pack pack = packService.getPackById(lockerPackEvent.getLockerPack().getPackId());
        Order order = pack.getOrder();
        Customer customer = customerService.getCustomerById(order.getCustomerId()).get();
        Notification notification = Notification
                .builder()
                .content("OTP: " + lockerPackEvent.getLockerPack().getOtp() + ". Order: " + order)
                .toEmail(customer.getEmail())
                .customerId(customer.getId())
                .build();
        notificationService.addNotification(notification);
        log.info("Notifications till now: {}", notificationService.getAllNotifications());
        // Can send notification to Delivery person also based on order status
    }
}
