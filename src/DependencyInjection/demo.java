package DependencyInjection;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-07 22:44:21
 */
public class demo {
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/bean.xml");
            RedisCounter redisCounter = (RedisCounter)applicationContext.getBean("redisCounter");
            System.out.println(redisCounter.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
