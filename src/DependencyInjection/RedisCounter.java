package DependencyInjection;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-05 23:49:30
 */
public class RedisCounter {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RedisCounter(String name,int age) {
        this.age = age;
        this.name = name;
    }
}
