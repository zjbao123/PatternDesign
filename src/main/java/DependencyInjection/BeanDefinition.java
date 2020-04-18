package DependencyInjection;


import java.util.ArrayList;
import java.util.List;


public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
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

        public boolean getIsRef() {
            return isRef;
        }

        public Class getType() {
            return type;
        }

        public Object getArg() {
            return arg;
        }

        public ConstructorArg(Builder builder) {
            this.isRef = builder.getIsRef();
            this.type = builder.getType();
            this.arg = builder.getArg();
        }


        public static class Builder {
            private boolean isRef = false;
            private Class type;
            private Object arg;

            public ConstructorArg build() {
                if (this.isRef) {
                    if (this.type != null) {
                        throw new IllegalArgumentException("当参数为引用类型时，无需设置type参数！");
                    }
                    if (!(arg instanceof String)) {
                        throw new IllegalArgumentException("请设置引用ID");

                    }

                } else {
                    if (this.type == null || this.arg == null) {
                        throw new IllegalArgumentException("type 和 arg 必填！");
                    }
                }
                return new ConstructorArg(this);
            }

            public boolean getIsRef() {
                return isRef;
            }

            public Builder setIsRef(boolean ref) {
                isRef = ref;
                return this;
            }

            public Class getType() {
                return type;
            }

            public Builder setType(Class type) {
                this.type = type;
                return this;
            }

            public Object getArg() {
                return arg;
            }

            public Builder setArg(Object arg) {
                this.arg = arg;
                return this;
            }

        }
    }

}
