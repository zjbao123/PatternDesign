package DependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public BeanDefinition(String id, String className, List<ConstructorArg> constructorArgs, Scope scope, boolean lazyInit) {
        this.id = id;
        this.className = className;
        this.constructorArgs = constructorArgs;
        this.scope = scope;
        this.lazyInit = lazyInit;
    }

    public BeanDefinition() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }


    public static enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    public static class ConstructorArg {
        private boolean isRef;
        private Class type;
        private Object arg;
        // 省略必要的getter/setter/constructors

        public ConstructorArg() {
        }

        public ConstructorArg(boolean isRef, Class type, Object arg) {
            this.isRef = isRef;
            this.type = type;
            this.arg = arg;
        }

        public boolean getIsRef() {
            return isRef;
        }

        public void setIsRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }


    }
}
