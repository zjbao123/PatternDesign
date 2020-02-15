package com.Pattern.design.domain;

import com.Pattern.design.util.UrlUtil;

import java.util.Map;

public class ApiRequest {
    private String token;
    private String baseUrl;
    private String userId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String userId, long timestamp) {
        this.token = token;
        this.baseUrl = baseUrl;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserId() {
        return userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    static public ApiRequest getRequestFromURL(String url) {
        UrlUtil.UrlEntity entity = UrlUtil.prase(url);
        Map<String, String> params = entity.getParams();
        ApiRequest apiRequest = new ApiRequest(entity.getBaseurl(), params.get("token"), params.get("userId"), Long.valueOf(params.get("timeStamp")));
        return apiRequest;
    }
}
