package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Customer;
import com.zeta.LockerManagementSystem.repositories.CustomerRepository;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customerToAdd) {
        return customerRepository.addCustomer(customerToAdd);
    }

    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

}
