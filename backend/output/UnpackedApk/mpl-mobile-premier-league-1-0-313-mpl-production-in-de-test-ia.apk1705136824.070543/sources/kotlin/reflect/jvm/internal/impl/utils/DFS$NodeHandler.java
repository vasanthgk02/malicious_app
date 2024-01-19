package kotlin.reflect.jvm.internal.impl.utils;

public interface DFS$NodeHandler<N, R> {
    void afterChildren(N n);

    boolean beforeChildren(N n);

    R result();
}
