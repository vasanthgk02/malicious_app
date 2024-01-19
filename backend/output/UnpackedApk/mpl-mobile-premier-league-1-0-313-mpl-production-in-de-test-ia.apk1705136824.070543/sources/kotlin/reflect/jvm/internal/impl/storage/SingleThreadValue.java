package kotlin.reflect.jvm.internal.impl.storage;

public class SingleThreadValue<T> {
    public final Thread thread = Thread.currentThread();
    public final T value;

    public SingleThreadValue(T t) {
        this.value = t;
    }
}
