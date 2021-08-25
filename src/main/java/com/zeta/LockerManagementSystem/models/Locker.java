package com.zeta.LockerManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Locker {
    @Getter
    private final String id;
    @Getter
    private final LockerSize size;
    @Setter
    @Getter
    private GeoLocation geoLocation;
    private LockerStatus status;
}
