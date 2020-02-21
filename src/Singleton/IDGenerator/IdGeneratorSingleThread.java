package Singleton.IDGenerator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-21 23:49:43
 */
public class IdGeneratorSingleThread {
    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, IdGeneratorSingleThread> instances = new ConcurrentHashMap<>();

    private IdGeneratorSingleThread(){}

    public static IdGeneratorSingleThread getInstance(){

        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId,new IdGeneratorSingleThread());
        return instances.get(currentThreadId);
    }

    public long getId(){
        return id.getAndIncrement();
    }

}
