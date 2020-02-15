package ApiAuthenticator.Repository;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 */


public class MysqlCredentialStorageImpl implements CredentialStorage {


    @Override
    public String getPasswordFromUserId(String userId) {
        return userId + "secret";
    }
}
