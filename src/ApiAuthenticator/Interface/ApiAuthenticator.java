package ApiAuthenticator.Interface;

import ApiAuthenticator.domain.ApiRequest;

public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
