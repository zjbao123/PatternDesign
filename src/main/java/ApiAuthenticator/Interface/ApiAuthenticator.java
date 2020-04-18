package ApiAuthenticator.Interface;


import main.java.ApiAuthenticator.domain.ApiRequest;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 */


public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
