package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
public final class ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ ClassicBuiltinSpecialProperties this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1(ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties) {
        // this.this$0 = classicBuiltinSpecialProperties;
        super(1);
    }

    public Object invoke(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        return Boolean.valueOf(this.this$0.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor));
    }
}
