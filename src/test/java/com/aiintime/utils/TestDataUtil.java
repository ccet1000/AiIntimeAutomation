package com.aiintime.utils;

import java.util.UUID;

public class TestDataUtil {

    public static String getUniqueEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 4) + "@test.com";
    }
}