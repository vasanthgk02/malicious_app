package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PrimitiveType.kt */
public final class PrimitiveType$typeFqName$2 extends Lambda implements Function0<FqName> {
    public final /* synthetic */ PrimitiveType this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrimitiveType$typeFqName$2(PrimitiveType primitiveType) {
        // this.this$0 = primitiveType;
        super(0);
    }

    public Object invoke() {
        FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.this$0.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
        return child;
    }
}
