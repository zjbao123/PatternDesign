package DependencyInjection;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-05 23:49:30
 */
public class RedisCounter {
    private String ipAddress;
    private String name;

    public RedisCounter(String ipAddress, String name) {
        this.ipAddress = ipAddress;
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
