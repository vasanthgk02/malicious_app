package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: specialBuiltinMembers.kt */
public final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 INSTANCE = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    public SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r3 != null) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r6
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0060
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r6.getName()
            boolean r0 = r0.contains(r3)
            r3 = 0
            if (r0 != 0) goto L_0x0024
            goto L_0x005d
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r4 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            r0.<init>(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(r6, r2, r0, r1)
            if (r6 != 0) goto L_0x0033
            r6 = r3
            goto L_0x0037
        L_0x0033:
            java.lang.String r6 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(r6)
        L_0x0037:
            if (r6 != 0) goto L_0x003a
            goto L_0x005d
        L_0x003a:
            java.lang.String r0 = "builtinSignature"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List<java.lang.String> r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x004b
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$SpecialSignatureInfo r6 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.ONE_COLLECTION_PARAMETER
        L_0x0049:
            r3 = r6
            goto L_0x005d
        L_0x004b:
            java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$TypeSafeBarrierDescription> r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysJvmKt.getValue(r0, r6)
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$TypeSafeBarrierDescription r6 = (kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription) r6
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$TypeSafeBarrierDescription r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.NULL
            if (r6 != r0) goto L_0x005a
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$SpecialSignatureInfo r6 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC
            goto L_0x0049
        L_0x005a:
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$SpecialSignatureInfo r6 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC
            goto L_0x0049
        L_0x005d:
            if (r3 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.invoke(java.lang.Object):java.lang.Object");
    }
}
