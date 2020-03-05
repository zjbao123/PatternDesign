package DependencyInjection;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:46:49
 */
public interface ApplicationContext {
    Object getBean(String beanId) throws ReflectiveOperationException;
}
