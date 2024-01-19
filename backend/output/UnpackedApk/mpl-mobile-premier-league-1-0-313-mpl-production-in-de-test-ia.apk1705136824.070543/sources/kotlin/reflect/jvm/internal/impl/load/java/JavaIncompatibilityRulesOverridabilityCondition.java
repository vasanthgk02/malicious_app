package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
            boolean z = javaMethodDescriptor.getValueParameters().size() == functionDescriptor.getValueParameters().size();
            if (!_Assertions.ENABLED || z) {
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
                Iterator it = ((ArrayList) ArraysKt___ArraysJvmKt.zip(valueParameters, valueParameters2)).iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.first;
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.second;
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "subParameter");
                    boolean z2 = mapValueParameterType((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof Primitive;
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor2, "superParameter");
                    if (z2 != (mapValueParameterType(functionDescriptor, valueParameterDescriptor2) instanceof Primitive)) {
                        return true;
                    }
                }
            } else {
                throw new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType mapValueParameterType(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r7) {
        /*
            java.lang.String r0 = "f"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r6.getName()
            java.lang.String r0 = r0.asString()
            java.lang.String r1 = "remove"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x00cb
            java.util.List r0 = r6.getValueParameters()
            int r0 = r0.size()
            if (r0 != r1) goto L_0x00cb
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor
            if (r0 != 0) goto L_0x003f
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(r6)
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r0 = 0
            goto L_0x0040
        L_0x003f:
            r0 = 1
        L_0x0040:
            if (r0 == 0) goto L_0x0044
            goto L_0x00cb
        L_0x0044:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = r6.getOriginal()
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r4 = "f.original.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.lang.String r4 = "f.original.valueParameters.single().type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(r0)
            boolean r4 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive
            if (r4 == 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Primitive r0 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) r0
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            if (r0 != 0) goto L_0x0070
            r0 = r3
            goto L_0x0072
        L_0x0070:
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r0 = r0.jvmPrimitiveType
        L_0x0072:
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT
            if (r0 == r4) goto L_0x0077
            goto L_0x00cb
        L_0x0077:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r6)
            if (r0 != 0) goto L_0x0080
            goto L_0x00cb
        L_0x0080:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = r0.getOriginal()
            java.util.List r4 = r4.getValueParameters()
            java.lang.String r5 = "overridden.original.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Object r4 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            java.lang.String r5 = "overridden.original.valueParameters.single().type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            java.lang.String r5 = "overridden.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableCollection
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r5 = r5.toUnsafe()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
            if (r0 == 0) goto L_0x00cb
            boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object
            if (r0 == 0) goto L_0x00cb
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Object r4 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) r4
            java.lang.String r0 = r4.internalName
            java.lang.String r4 = "java/lang/Object"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto L_0x00cb
            r0 = 1
            goto L_0x00cc
        L_0x00cb:
            r0 = 0
        L_0x00cc:
            java.lang.String r4 = "valueParameterDescriptor.type"
            if (r0 != 0) goto L_0x0136
            java.util.List r0 = r6.getValueParameters()
            int r0 = r0.size()
            if (r0 == r1) goto L_0x00dc
            goto L_0x0127
        L_0x00dc:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r6.getContainingDeclaration()
            boolean r5 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x00e7
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x00e8
        L_0x00e7:
            r0 = r3
        L_0x00e8:
            if (r0 != 0) goto L_0x00eb
            goto L_0x0127
        L_0x00eb:
            java.util.List r6 = r6.getValueParameters()
            java.lang.String r5 = "f.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r6.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r6.getDeclarationDescriptor()
            boolean r5 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x010d
            r3 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
        L_0x010d:
            if (r3 != 0) goto L_0x0110
            goto L_0x0127
        L_0x0110:
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveClass(r0)
            if (r6 == 0) goto L_0x0125
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r3)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L_0x0125
            goto L_0x0126
        L_0x0125:
            r1 = 0
        L_0x0126:
            r2 = r1
        L_0x0127:
            if (r2 == 0) goto L_0x012a
            goto L_0x0136
        L_0x012a:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r7.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r6 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(r6)
            goto L_0x0145
        L_0x0136:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r7.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r6)
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r6 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(r6)
        L_0x0145:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.mapValueParameterType(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor):kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType");
    }

    public Contract getContract() {
        return Contract.CONFLICTS_ONLY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r3, false, false, 2)) != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ORIGINAL_SHORT_NAMES.contains(r0) == false) goto L_0x00bf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r9, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r10, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r11) {
        /*
            r8 = this;
            java.lang.String r0 = "superDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "subDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00bf
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 == 0) goto L_0x00bf
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(r10)
            if (r0 == 0) goto L_0x001e
            goto L_0x00bf
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            r3 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r3.getName()
            java.lang.String r5 = "subDescriptor.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r0 = r0.getSameAsBuiltinMethodWithErasedValueParameters(r4)
            if (r0 != 0) goto L_0x004b
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r3.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> r4 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ORIGINAL_SHORT_NAMES
            boolean r0 = r4.contains(r0)
            if (r0 != 0) goto L_0x004b
            goto L_0x00bf
        L_0x004b:
            r0 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = com.twitter.sdk.android.tweetui.TweetUtils.getOverriddenSpecialBuiltin(r0)
            boolean r4 = r3.isHiddenToOvercomeSignatureClash()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r5 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            r6 = 0
            if (r5 == 0) goto L_0x0063
            r7 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
            goto L_0x0064
        L_0x0063:
            r7 = r6
        L_0x0064:
            if (r7 != 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            boolean r6 = r7.isHiddenToOvercomeSignatureClash()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
        L_0x006f:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x00c0
            boolean r4 = r3.isHiddenToOvercomeSignatureClash()
            if (r4 != 0) goto L_0x007f
            goto L_0x00c0
        L_0x007f:
            boolean r4 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor
            if (r4 == 0) goto L_0x00bf
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = r3.getInitialSignatureDescriptor()
            if (r4 == 0) goto L_0x008a
            goto L_0x00bf
        L_0x008a:
            if (r0 == 0) goto L_0x00bf
            boolean r11 = com.twitter.sdk.android.tweetui.TweetUtils.hasRealKotlinSuperClassWithOverrideOf(r11, r0)
            if (r11 == 0) goto L_0x0093
            goto L_0x00bf
        L_0x0093:
            boolean r11 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r11 == 0) goto L_0x00c0
            if (r5 == 0) goto L_0x00c0
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r11 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r11 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r0)
            if (r11 == 0) goto L_0x00c0
            r11 = 2
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r3, r2, r2, r11)
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = r3.getOriginal()
            java.lang.String r4 = "superDescriptor.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r3, r2, r2, r11)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r11)
            if (r11 == 0) goto L_0x00c0
        L_0x00bf:
            r1 = 0
        L_0x00c0:
            if (r1 == 0) goto L_0x00c5
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE
            return r9
        L_0x00c5:
            boolean r9 = doesJavaOverrideHaveIncompatibleValueParameterKinds(r9, r10)
            if (r9 == 0) goto L_0x00ce
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE
            return r9
        L_0x00ce:
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result");
    }
}
