package DependencyInjection;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:49:34
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        // TODO:...
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // TODO:...
        return beanDefinitions;
    }

}

