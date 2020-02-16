package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-16 23:27:22
 */
public class IDGeneratorStatic {
    private AtomicLong id =new AtomicLong(0);

    private IDGeneratorStatic(){}

    private static class SingletonHolder {
        private static final IDGeneratorStatic instance = new IDGeneratorStatic();
    }


    public static IDGeneratorStatic getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
