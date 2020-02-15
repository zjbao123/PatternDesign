package ApiAuthenticator;

import ApiAuthenticator.impl.ApiAuthenticatorImpl;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 */


public class Main {

    public static void main(String[] args) {
        String url = "time.geekbang.org?userId=123&token=1c584d68e40efc44152f045de0f78d46&timeStamp=1580830131721";
        ApiAuthenticatorImpl apiAuthenticator = new ApiAuthenticatorImpl();
        try {
            apiAuthenticator.auth(url);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }
}
