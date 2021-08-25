package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.models.Customer;
import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private Map<String, Customer> idToCustomerMap = new HashMap<>();

    public Customer addCustomer(Customer customerToAdd) {
        Customer customer = Customer
                .builder()
                .id(TokenUtil.generateRandomTokenDefaultLength())
                .email(customerToAdd.getEmail())
                .phone(customerToAdd.getPhone())
                .name(customerToAdd.getName())
                .build();
        idToCustomerMap.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return Optional.of(idToCustomerMap.get(customerId));
    }
}
