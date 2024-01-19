package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: methodSignatureMapping.kt */
public final class MethodSignatureMappingKt {
    public static final void appendErasedType(StringBuilder sb, KotlinType kotlinType) {
        sb.append(mapToJvmType(kotlinType));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor) == false) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String computeJvmDescriptor$default(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3, boolean r4, boolean r5, int r6) {
        /*
            r0 = r6 & 1
            r1 = 1
            if (r0 == 0) goto L_0x0006
            r4 = 1
        L_0x0006:
            r6 = r6 & 2
            if (r6 == 0) goto L_0x000b
            r5 = 1
        L_0x000b:
            java.lang.String r6 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            if (r5 == 0) goto L_0x002e
            boolean r5 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r5 == 0) goto L_0x001e
            java.lang.String r5 = "<init>"
            goto L_0x002b
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r3.getName()
            java.lang.String r5 = r5.asString()
            java.lang.String r0 = "name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
        L_0x002b:
            r6.append(r5)
        L_0x002e:
            java.lang.String r5 = "("
            r6.append(r5)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5 = r3.getExtensionReceiverParameter()
            if (r5 != 0) goto L_0x003a
            goto L_0x0046
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r5.getType()
            java.lang.String r0 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            appendErasedType(r6, r5)
        L_0x0046:
            java.util.List r5 = r3.getValueParameters()
            java.util.Iterator r5 = r5.iterator()
        L_0x004e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.lang.String r2 = "parameter.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            appendErasedType(r6, r0)
            goto L_0x004e
        L_0x0067:
            java.lang.String r5 = ")"
            r6.append(r5)
            if (r4 == 0) goto L_0x00aa
            java.lang.String r4 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r4 == 0) goto L_0x0078
            goto L_0x0098
        L_0x0078:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r3.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnit(r4)
            if (r4 == 0) goto L_0x0097
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r3.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r4)
            if (r4 != 0) goto L_0x0097
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor
            if (r4 != 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r1 = 0
        L_0x0098:
            if (r1 == 0) goto L_0x00a0
            java.lang.String r3 = "V"
            r6.append(r3)
            goto L_0x00aa
        L_0x00a0:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            appendErasedType(r6, r3)
        L_0x00aa:
            java.lang.String r3 = r6.toString()
            java.lang.String r4 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, boolean, boolean, int):java.lang.String");
    }

    public static final String computeJvmSignature(CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().special) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        FunctionDescriptor functionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (functionDescriptor == null) {
            return null;
        }
        return TweetUtils.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(functionDescriptor, false, false, 3));
    }

    public static final JvmType mapToJvmType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return (JvmType) TweetUtils.mapType(kotlinType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, FunctionsKt.DO_NOTHING_3);
    }
}
