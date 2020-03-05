package DependencyInjection;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-05 23:51:20
 */
public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }
}
