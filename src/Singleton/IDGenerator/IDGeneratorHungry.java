package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 *
 * 饿汉式单例模式
 */
public class IDGeneratorHungry {
    private AtomicLong id = new AtomicLong(0);
    private static IDGeneratorHungry instance = new IDGeneratorHungry();

    private IDGeneratorHungry() {

    }

    public static IDGeneratorHungry getInstance() {
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
