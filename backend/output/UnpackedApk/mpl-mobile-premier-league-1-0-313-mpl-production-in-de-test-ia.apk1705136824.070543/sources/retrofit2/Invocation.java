package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public final class Invocation {
    public final List<?> arguments;
    public final Method method;

    public Invocation(Method method2, List<?> list) {
        this.method = method2;
        this.arguments = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments});
    }
}
