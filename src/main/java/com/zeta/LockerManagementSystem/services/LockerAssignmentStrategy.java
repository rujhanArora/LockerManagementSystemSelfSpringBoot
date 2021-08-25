package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.models.Locker;

public interface LockerAssignmentStrategy<T> {
    Locker getLocker(T filterData);
}
