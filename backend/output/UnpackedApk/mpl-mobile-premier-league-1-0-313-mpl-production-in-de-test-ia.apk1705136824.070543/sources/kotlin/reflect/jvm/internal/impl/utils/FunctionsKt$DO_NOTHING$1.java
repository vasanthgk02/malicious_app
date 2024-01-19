package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
public final class FunctionsKt$DO_NOTHING$1 extends Lambda implements Function1<Object, Unit> {
    public static final FunctionsKt$DO_NOTHING$1 INSTANCE = new FunctionsKt$DO_NOTHING$1();

    public FunctionsKt$DO_NOTHING$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        return Unit.INSTANCE;
    }
}
