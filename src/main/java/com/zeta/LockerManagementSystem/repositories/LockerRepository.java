package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.dto.LockerDTO;
import com.zeta.LockerManagementSystem.models.Locker;
import com.zeta.LockerManagementSystem.models.LockerStatus;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import com.zeta.LockerManagementSystem.utils.ValidationUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LockerRepository {

    private Map<String, Locker> idToLockerMap = new HashMap<>();

    public Locker addLocker(LockerDTO lockerDTO) {
        Locker locker = new Locker(TokenUtil.generateRandomTokenDefaultLength(), lockerDTO.getLockerSize(), lockerDTO.getGeoLocation(), LockerStatus.EMPTY);
        idToLockerMap.put(locker.getId(), locker);
        return locker;
    }

    public Optional<Locker> getLockerById(String lockerId) {
        return Optional.of(idToLockerMap.get(lockerId));
    }

    public Locker getRandomLocker() {
        List<String> keysAsArray = new ArrayList<>(idToLockerMap.keySet());
        Random r = new Random();
        String randomLockerId = keysAsArray.get(r.nextInt(keysAsArray.size()));
        return idToLockerMap.get(randomLockerId);
    }
}
