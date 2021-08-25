package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.dto.LockerDTO;
import com.zeta.LockerManagementSystem.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DemoService {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    LockerService lockerService;
    @Autowired
    PackService packService;

    @PostConstruct
    public void init() {
        Customer customer = customerService
                .addCustomer(Customer.builder().email("qw@gmail.com").name("rj").phone(32321L).build());
        log.info("Customer added: " + customerService.getCustomerById(customer.getId()));

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(OrderItem.builder().name("iPhone 13").size(OrderItemSize.S).build());
        orderItems.add(OrderItem.builder().name("iPad").size(OrderItemSize.L).build());

        Order order = orderService
                .addOrder(Order.builder()
                        .orderItems(orderItems)
                        .deliveryLocation(new GeoLocation(1, 2)).customerId(customer.getId()).build());
        log.info("order added: " + orderService.getOrderById(order.getId()));

        Locker locker = lockerService.addLocker(LockerDTO.builder()
                .geoLocation(new GeoLocation(1, 2))
                .lockerSize(LockerSize.LARGE).build());
        log.info("locker added: " + lockerService.getLockerById(locker.getId()));
        locker = lockerService.addLocker(LockerDTO.builder()
                .geoLocation(new GeoLocation(4, 5))
                .lockerSize(LockerSize.LARGE).build());
        log.info("locker added: " + lockerService.getLockerById(locker.getId()));
        locker = lockerService.addLocker(LockerDTO.builder()
                .geoLocation(new GeoLocation(1, 2))
                .lockerSize(LockerSize.LARGE).build());
        log.info("locker added: " + lockerService.getLockerById(locker.getId()));

        locker = lockerService.getLocker(LockerAssignmentType.RANDOM);
        log.info("random locker assigned: " + locker);

        Pack pack = packService.addPack(order);
        log.info("pack added: " + packService.getPackById(pack.getId()));

        try {
            LockerPack lockerPack = lockerService.addPackToLocker(locker.getId(), pack.getId());
            lockerService.removePackFromLocker(locker.getId(), lockerPack.getOtp());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
