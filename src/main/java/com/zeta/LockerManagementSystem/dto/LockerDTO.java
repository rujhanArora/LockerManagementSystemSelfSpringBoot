package com.zeta.LockerManagementSystem.dto;

import com.zeta.LockerManagementSystem.models.GeoLocation;
import com.zeta.LockerManagementSystem.models.LockerSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Builder
public class LockerDTO {
    @NonNull
    private GeoLocation geoLocation;
    @NonNull
    private LockerSize lockerSize;
}
