package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-16 23:19:52
 * 单例模式-双重检测
 */
public class IDGeneratorDoubleCheck {
    private AtomicLong id = new AtomicLong(0);
    private static IDGeneratorDoubleCheck instance;

    private IDGeneratorDoubleCheck() {
    }

    public static IDGeneratorDoubleCheck getInstance() {

        if (instance == null) {
            synchronized (IDGeneratorDoubleCheck.class) {
                if (instance == null) {
                    instance = new IDGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
