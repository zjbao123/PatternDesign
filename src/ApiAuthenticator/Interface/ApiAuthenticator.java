package com.Pattern.design.Interface;

import com.Pattern.design.domain.ApiRequest;

public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
