package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;

public final class DFS$1 extends DFS$AbstractNodeHandler<N, Boolean> {
    public final /* synthetic */ Function1 val$predicate;
    public final /* synthetic */ boolean[] val$result;

    public DFS$1(Function1 function1, boolean[] zArr) {
        this.val$predicate = function1;
        this.val$result = zArr;
    }

    public boolean beforeChildren(N n) {
        if (((Boolean) this.val$predicate.invoke(n)).booleanValue()) {
            this.val$result[0] = true;
        }
        return !this.val$result[0];
    }

    public Object result() {
        return Boolean.valueOf(this.val$result[0]);
    }
}
