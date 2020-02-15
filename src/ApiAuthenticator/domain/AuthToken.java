package com.Pattern.design.domain;

import com.Pattern.design.util.MD5Util;

import java.util.Date;
import java.util.Map;

public class AuthToken {
    private static final long DEFAULT_EXPRIED_TIME_INTERVAL = 100 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPRIED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.createTime = createTime;
        this.token = token;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, String userId, String password) {
        String token = null;
        if (!userId.isEmpty() && !password.isEmpty()) {
            token = MD5Util.md5(baseUrl + createTime + userId + password);
        }

        return new AuthToken(token, createTime);

    }

    public String getToken() {
        return token;
    }


    public boolean isExpired() {
        if (createTime + expiredTimeInterval < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public boolean match(AuthToken authToken) {
        return authToken.token.equals(this.token);
    }
}
