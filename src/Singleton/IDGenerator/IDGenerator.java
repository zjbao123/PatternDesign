package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
 */
public class IDGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IDGenerator instance = new IDGenerator();

    private IDGenerator() {

    }

    public static IDGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
