package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: IntegerLiteralTypeConstructor.kt */
public final class IntegerLiteralTypeConstructor$valueToString$1 extends Lambda implements Function1<KotlinType, CharSequence> {
    public static final IntegerLiteralTypeConstructor$valueToString$1 INSTANCE = new IntegerLiteralTypeConstructor$valueToString$1();

    public IntegerLiteralTypeConstructor$valueToString$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        return kotlinType.toString();
    }
}
