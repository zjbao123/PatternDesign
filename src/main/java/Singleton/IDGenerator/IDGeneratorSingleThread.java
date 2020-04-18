package Singleton.IDGenerator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-21 23:49:43
 * 单一线程内单例
 */
public class IDGeneratorSingleThread {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, IDGeneratorSingleThread> instances = new ConcurrentHashMap<>();

    private IDGeneratorSingleThread(){}

    public static IDGeneratorSingleThread getInstance(){

        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId,new IDGeneratorSingleThread());
        return instances.get(currentThreadId);
    }

    public long getId(){
        return id.getAndIncrement();
    }

}
