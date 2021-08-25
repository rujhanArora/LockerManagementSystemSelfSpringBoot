package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.models.Pack;
import com.zeta.LockerManagementSystem.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;

    public Pack addPack(Order order) {
        return packRepository.addPack(order);
    }

    public Pack getPackById(String packId) {
        return packRepository.getPackById(packId);
    }
}
