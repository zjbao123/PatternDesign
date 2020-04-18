package DynamicProxy;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-10 23:13:29
 */
public class UserLoginController implements  IUserLoginController{
    @Override
    public void login() {
        System.out.println("logining...");
    }
}
