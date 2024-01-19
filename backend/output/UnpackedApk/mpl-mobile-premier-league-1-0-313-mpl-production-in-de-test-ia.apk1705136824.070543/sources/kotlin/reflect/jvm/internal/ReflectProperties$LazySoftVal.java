package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

public class ReflectProperties$LazySoftVal<T> extends ReflectProperties$Val<T> implements Function0<T> {
    public final Function0<T> initializer;
    public volatile SoftReference<Object> value;

    public ReflectProperties$LazySoftVal(T t, Function0<T> function0) {
        if (function0 != null) {
            this.value = null;
            this.initializer = function0;
            if (t != null) {
                this.value = new SoftReference<>(t);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
    }

    public T invoke() {
        SoftReference<Object> softReference = this.value;
        if (softReference != null) {
            T t = softReference.get();
            if (t != null) {
                if (t == ReflectProperties$Val.NULL_VALUE) {
                    t = null;
                }
                return t;
            }
        }
        T invoke = this.initializer.invoke();
        this.value = new SoftReference<>(invoke == null ? ReflectProperties$Val.NULL_VALUE : invoke);
        return invoke;
    }
}
