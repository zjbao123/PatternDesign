package DependencyInjection.Exception;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:56:52
 */
public class BeanCreationFailureException extends ReflectiveOperationException  {
    private Throwable ex;
    public BeanCreationFailureException(String s, ReflectiveOperationException ex) {
        super(s, null);
        this.ex = ex;
    }
}
