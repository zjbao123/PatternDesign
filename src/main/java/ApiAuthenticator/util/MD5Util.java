package ApiAuthenticator.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 */

public class MD5Util {
    public static String md5(String  plainText){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("MD5");

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new RuntimeException("No such AlgorithException!");
        }
        md.update(plainText.getBytes());
        return new BigInteger(1, md.digest()).toString(16);

    }
}
