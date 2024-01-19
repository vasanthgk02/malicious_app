package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
public final class FunctionsKt$DO_NOTHING_2$1 extends Lambda implements Function2<Object, Object, Unit> {
    public static final FunctionsKt$DO_NOTHING_2$1 INSTANCE = new FunctionsKt$DO_NOTHING_2$1();

    public FunctionsKt$DO_NOTHING_2$1() {
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        return Unit.INSTANCE;
    }
}
