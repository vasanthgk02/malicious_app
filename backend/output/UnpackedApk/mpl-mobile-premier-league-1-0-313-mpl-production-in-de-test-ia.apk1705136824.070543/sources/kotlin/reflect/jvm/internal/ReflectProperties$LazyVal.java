package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;

public class ReflectProperties$LazyVal<T> extends ReflectProperties$Val<T> {
    public final Function0<T> initializer;
    public volatile Object value;

    public ReflectProperties$LazyVal(Function0<T> function0) {
        if (function0 != null) {
            this.value = null;
            this.initializer = function0;
            return;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"}));
    }

    public T invoke() {
        T t = this.value;
        if (t != null) {
            if (t == ReflectProperties$Val.NULL_VALUE) {
                t = null;
            }
            return t;
        }
        T invoke = this.initializer.invoke();
        this.value = invoke == null ? ReflectProperties$Val.NULL_VALUE : invoke;
        return invoke;
    }
}
