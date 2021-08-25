package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.models.LockerPack;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LockerPackRepository {
    Map<String, LockerPack> lockerIdToLockerPackageMap = new HashMap<>();

    public LockerPack addPackToLocker(String packageId, String lockerId) {
        LockerPack lockerPack = new LockerPack(TokenUtil.generateRandomTokenDefaultLength(), lockerId, packageId);
        lockerIdToLockerPackageMap.put(lockerId, lockerPack);
        return lockerPack;
    }

    public LockerPack getByLockerId(String lockerId) {
        return lockerIdToLockerPackageMap.get(lockerId);
    }
}
