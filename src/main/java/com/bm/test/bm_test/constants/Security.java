package com.bm.test.bm_test.constants;

public class Security {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final int EXPIRATION_TIME = 5 * 60000; // 5 min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
