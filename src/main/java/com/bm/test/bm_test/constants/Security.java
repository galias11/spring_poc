package com.bm.test.bm_test.constants;

// vendors
import java.util.ArrayList;
import java.util.Arrays;

public class Security {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final int EXPIRATION_TIME = 5 * 60000; // 5 min
    public static final String ISSUER = "bm_2020";
    public static final ArrayList<String> PUBLIC_URLS = new ArrayList<String>(Arrays.asList( "/login", "/register", "/api/public/login", "/api/public/register" ));
}
