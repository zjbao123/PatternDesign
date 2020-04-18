package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-10 23:15:00
 */
public class UserLoginProxy {

    public Object createInstance(Object obejct){
        InvocationHandler invocationHandler = new InvocationHandlerImpl(obejct);
        ClassLoader classLoader= obejct.getClass().getClassLoader();
        Class[] interfaces = obejct.getClass().getInterfaces();
         return  Proxy.newProxyInstance(classLoader,interfaces, invocationHandler);
    }

    private class InvocationHandlerImpl implements InvocationHandler{
        Object subject;

        public InvocationHandlerImpl(Object subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(subject, args);
            long end  = System.currentTimeMillis();
            System.out.println("It spends " +(end-start)+"ms");
            return result;
        }
    }

    public static void main(String[] args) {
        UserLoginProxy userLoginProxy = new UserLoginProxy();
        IUserLoginController iUserLoginController = (IUserLoginController) userLoginProxy.createInstance(new UserLoginController());
        iUserLoginController.login();
    }
}
