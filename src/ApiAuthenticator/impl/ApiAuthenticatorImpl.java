package ApiAuthenticator.impl;

import ApiAuthenticator.Interface.ApiAuthenticator;
import ApiAuthenticator.Repository.CredentialStorage;
import ApiAuthenticator.Repository.MysqlCredentialStorageImpl;
import ApiAuthenticator.domain.ApiRequest;
import ApiAuthenticator.domain.AuthToken;

public class ApiAuthenticatorImpl implements ApiAuthenticator {
    CredentialStorage credentialStorage;

    public ApiAuthenticatorImpl() {
        this.credentialStorage = new MysqlCredentialStorageImpl();

    }

    public ApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.getRequestFromURL(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        AuthToken authToken = new AuthToken(apiRequest.getToken(), apiRequest.getTimestamp());
        if (authToken.isExpired()) {
            throw new RuntimeException("token is expired!");
        }
        String password = credentialStorage.getPasswordFromUserId(apiRequest.getUserId());
        AuthToken actualToken = AuthToken.create(apiRequest.getBaseUrl(), apiRequest.getTimestamp(), apiRequest.getUserId(), password);
        if (!authToken.match(actualToken)) {
            throw new RuntimeException("password is wrong!");
        }
        System.out.println("pass auth!");
    }
}
