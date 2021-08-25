package com.zeta.LockerManagementSystem.utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class TokenUtil {
    private static int DEFAULT_RANDOM_TOKEN_LENGTH  = 8;
    public static Long generateRandomLong(long start, long end) {
        return RandomUtils.nextLong(start, end);
    }

    public static String generateRandomToken(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateRandomTokenDefaultLength() {
        return RandomStringUtils.randomAlphanumeric(DEFAULT_RANDOM_TOKEN_LENGTH);
    }
}
