package ApiAuthenticator.Repository;


public interface CredentialStorage {
    String getPasswordFromUserId(String userId);
}
