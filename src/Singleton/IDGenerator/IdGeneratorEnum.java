package Singleton.IDGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-16 23:35:12
 * 单例模式-枚举
 */
public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.getAndIncrement();
    }
}
