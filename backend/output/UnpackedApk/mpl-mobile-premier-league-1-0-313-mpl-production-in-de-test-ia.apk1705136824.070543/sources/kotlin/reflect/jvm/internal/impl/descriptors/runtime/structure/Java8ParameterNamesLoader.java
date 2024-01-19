package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;

/* compiled from: ReflectJavaMember.kt */
public final class Java8ParameterNamesLoader {
    public static Cache cache;

    /* compiled from: ReflectJavaMember.kt */
    public static final class Cache {
        public final Method getName;
        public final Method getParameters;

        public Cache(Method method, Method method2) {
            this.getParameters = method;
            this.getName = method2;
        }
    }
}
