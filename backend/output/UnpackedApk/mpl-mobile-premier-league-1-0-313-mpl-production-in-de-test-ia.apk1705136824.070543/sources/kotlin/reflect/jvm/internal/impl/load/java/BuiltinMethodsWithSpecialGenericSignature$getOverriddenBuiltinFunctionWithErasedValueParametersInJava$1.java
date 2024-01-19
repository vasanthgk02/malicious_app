package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ BuiltinMethodsWithSpecialGenericSignature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature) {
        // this.this$0 = builtinMethodsWithSpecialGenericSignature;
        super(1);
    }

    public Object invoke(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        if (this.this$0 != null) {
            return Boolean.valueOf(ArraysKt___ArraysJvmKt.contains(SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES, MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptor)));
        }
        throw null;
    }
}
