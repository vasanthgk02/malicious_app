package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
public final class FunctionsKt$DO_NOTHING_3$1 extends Lambda implements Function3<Object, Object, Object, Unit> {
    public static final FunctionsKt$DO_NOTHING_3$1 INSTANCE = new FunctionsKt$DO_NOTHING_3$1();

    public FunctionsKt$DO_NOTHING_3$1() {
        super(3);
    }

    public Object invoke(Object obj, Object obj2, Object obj3) {
        return Unit.INSTANCE;
    }
}
