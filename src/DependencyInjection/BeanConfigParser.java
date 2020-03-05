package DependencyInjection;

import java.io.InputStream;
import java.util.List;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:48:50
 */


public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    List<BeanDefinition> parse(String configContent);
}


