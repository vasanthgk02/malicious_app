package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: functions.kt */
public final class FunctionsKt {
    public static final Function1<Object, Boolean> ALWAYS_TRUE = FunctionsKt$ALWAYS_TRUE$1.INSTANCE;
    public static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = FunctionsKt$DO_NOTHING_3$1.INSTANCE;

    static {
        FunctionsKt$IDENTITY$1 functionsKt$IDENTITY$1 = FunctionsKt$IDENTITY$1.INSTANCE;
        FunctionsKt$ALWAYS_NULL$1 functionsKt$ALWAYS_NULL$1 = FunctionsKt$ALWAYS_NULL$1.INSTANCE;
        FunctionsKt$DO_NOTHING$1 functionsKt$DO_NOTHING$1 = FunctionsKt$DO_NOTHING$1.INSTANCE;
        FunctionsKt$DO_NOTHING_2$1 functionsKt$DO_NOTHING_2$1 = FunctionsKt$DO_NOTHING_2$1.INSTANCE;
    }
}
