package com.Pattern.design.Repository;

/**
 * Created by Enzo Cotter on 2020/2/4.
 */
public class MysqlCredentialStorageImpl implements CredentialStorage {


    @Override
    public String getPasswordFromUserId(String userId) {
        return userId + "secret";
    }
}
