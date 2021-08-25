package com.zeta.LockerManagementSystem.services;

import com.zeta.LockerManagementSystem.dto.LockerDTO;
import com.zeta.LockerManagementSystem.events.LockerPackEvent;
import com.zeta.LockerManagementSystem.models.Locker;
import com.zeta.LockerManagementSystem.models.LockerAssignmentType;
import com.zeta.LockerManagementSystem.models.LockerPack;
import com.zeta.LockerManagementSystem.models.LockerStatus;
import com.zeta.LockerManagementSystem.repositories.LockerPackRepository;
import com.zeta.LockerManagementSystem.repositories.LockerRepository;
import com.zeta.LockerManagementSystem.repositories.PackRepository;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import com.zeta.LockerManagementSystem.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class LockerService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private LockerRepository lockerRepository;
    @Autowired
    private PackRepository packRepository;
    @Autowired
    private LockerPackRepository lockerPackRepository;
    @Autowired
    private RandomLockerAssignmentService randomLockerAssignmentService;

    public Locker addLocker(LockerDTO lockerDTO) {
        return lockerRepository.addLocker(lockerDTO);
    }

    public Optional<Locker> getLockerById(String lockerId) {
        return lockerRepository.getLockerById(lockerId);
    }

    public Locker getLocker(LockerAssignmentType lockerAssignmentType) {
        switch (lockerAssignmentType) {
            default:
                return randomLockerAssignmentService.getLocker(null);
        }
    }

    public LockerPack addPackToLocker(String lockerId, String packId) {
        Locker locker = lockerRepository.getLockerById(lockerId).get();
        ValidationUtil.ensureNotNull(locker, "Locker with id: " + lockerId);
        ValidationUtil.ensureTrue(
                LockerStatus.EMPTY.equals(locker.getStatus()), "Invalid current status for booking: " + locker.getStatus());
        // Can check sizing and other validations if required
        LockerPack lockerPack = lockerPackRepository.addPackToLocker(packId, lockerId);
        locker.setStatus(LockerStatus.BOOKED);
        eventPublisher.publishEvent(new LockerPackEvent(this, lockerPack, LockerPackEvent.EVENT_TYPE.LOCKER_PACK_ADDED));
        return lockerPack;
    }

    public boolean removePackFromLocker(String lockerId, String validationOTP) {
        LockerPack lockerPack = lockerPackRepository.getByLockerId(lockerId);
        ValidationUtil.ensureNotNull(lockerPack, "Locker Package for locker with id: " + lockerId);
        ValidationUtil.ensureNotNull(lockerPack.getPackId(), "No pack present in the locker with id: " + lockerId);
        ValidationUtil.ensureTrue(validationOTP.equals(lockerPack.getOtp()), "Mismatching OTP!");
        lockerPack.setOtp(null);
        lockerPack.setPackId(null);
        return true;
    }
}
