package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Locker;
import com.zeta.LockerManagementSystem.repositories.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomLockerAssignmentService implements LockerAssignmentStrategy {
    @Autowired
    LockerRepository lockerRepository;

    @Override
    public Locker getLocker(Object filterData) {
        return lockerRepository.getRandomLocker();
    }
}
