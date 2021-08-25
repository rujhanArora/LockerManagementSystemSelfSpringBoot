package com.zeta.LockerManagementSystem.models;

import com.zeta.LockerManagementSystem.utils.TokenUtil;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class LockerPack {
    private static int DEFAULT_VALIDITY_IN_DAYS = 3;
    private final String id;
    private String lockerId;
    private String packId;
    private String otp;
    private Date otpValidTill;

    public LockerPack(String id, String lockerId, String packId) {
        this.id = id;
        this.setLockerId(lockerId);
        this.setPackId(packId);
        this.generateOTP();
    }

    private void generateOTP() {
        this.setOtp(TokenUtil.generateRandomTokenDefaultLength());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, DEFAULT_VALIDITY_IN_DAYS * 24);
        this.setOtpValidTill(calendar.getTime());
    }
}
