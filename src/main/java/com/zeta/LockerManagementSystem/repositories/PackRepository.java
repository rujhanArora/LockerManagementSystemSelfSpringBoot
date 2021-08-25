package com.zeta.LockerManagementSystem.repositories;

import com.zeta.LockerManagementSystem.models.Order;
import com.zeta.LockerManagementSystem.models.Pack;
import com.zeta.LockerManagementSystem.utils.TokenUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PackRepository {

    private Map<String, Pack> idToPackage = new HashMap<>();

    public Pack addPack(Order order) {
        Pack pack = new Pack(TokenUtil.generateRandomTokenDefaultLength(), order);
        idToPackage.put(pack.getId(), pack);
        return pack;
    }

    public Pack getPackById(String packId) {
        return idToPackage.get(packId);
    }
}
