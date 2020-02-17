package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-17 22:48:42
 */
public class IDGeneratorWithParams {
    private static IDGeneratorWithParams instance;
    private final int paramA;
    private final int paramB;
    private AtomicLong id = new AtomicLong(0);

    private IDGeneratorWithParams(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static synchronized IDGeneratorWithParams getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new IDGeneratorWithParams(paramA, paramB);
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
