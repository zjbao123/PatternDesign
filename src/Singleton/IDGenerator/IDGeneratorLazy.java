package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-16 23:15:23
 */
public class IDGeneratorLazy {
    private AtomicLong id = new AtomicLong(0);
    private static IDGeneratorLazy instance;

    private IDGeneratorLazy(){}

    public synchronized static IDGeneratorLazy getInstance() {
        if(instance == null){
            instance = new IDGeneratorLazy();
        }
        return  instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
