package DependencyInjection.Exception;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:56:20
 */
public class NoSuchBeanDefinitionException extends ReflectiveOperationException {
    private Throwable ex;
    public NoSuchBeanDefinitionException(String s) {
        super(s, null);
    }
}
