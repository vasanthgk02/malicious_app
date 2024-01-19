package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.Sequence;

/* compiled from: ErasedOverridabilityCondition.kt */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Result.values().length];
            Result result = Result.OVERRIDABLE;
            iArr[0] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Contract getContract() {
        return Contract.SUCCESS_ONLY;
    }

    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        boolean z;
        ExternalOverridabilityCondition.Result result;
        boolean z2;
        Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (callableDescriptor2 instanceof JavaMethodDescriptor) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
            List<TypeParameterDescriptor> typeParameters = javaMethodDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "subDescriptor.typeParameters");
            if (!(!typeParameters.isEmpty())) {
                OverrideCompatibilityInfo basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
                KotlinType kotlinType = null;
                if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
                Sequence map = TypeUtilsKt.map(ArraysKt___ArraysJvmKt.asSequence(valueParameters), ErasedOverridabilityCondition$isOverridable$signatureTypes$1.INSTANCE);
                KotlinType kotlinType2 = javaMethodDescriptor.unsubstitutedReturnType;
                Intrinsics.checkNotNull(kotlinType2);
                Sequence plus = TypeUtilsKt.plus(map, kotlinType2);
                ReceiverParameterDescriptor receiverParameterDescriptor = javaMethodDescriptor.extensionReceiverParameter;
                if (receiverParameterDescriptor != null) {
                    kotlinType = receiverParameterDescriptor.getType();
                }
                List listOfNotNull = TweetUtils.listOfNotNull(kotlinType);
                Intrinsics.checkNotNullParameter(plus, "<this>");
                Intrinsics.checkNotNullParameter(listOfNotNull, "elements");
                Iterator it = TypeUtilsKt.flatten(TypeUtilsKt.sequenceOf(plus, ArraysKt___ArraysJvmKt.asSequence(listOfNotNull))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    KotlinType kotlinType3 = (KotlinType) it.next();
                    if (!(!kotlinType3.getArguments().isEmpty()) || (kotlinType3.unwrap() instanceof RawTypeImpl)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                CallableDescriptor callableDescriptor3 = (CallableDescriptor) callableDescriptor.substitute(RawSubstitution.INSTANCE.buildSubstitutor());
                if (callableDescriptor3 == null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                if (callableDescriptor3 instanceof SimpleFunctionDescriptor) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableDescriptor3;
                    List<TypeParameterDescriptor> typeParameters2 = simpleFunctionDescriptor.getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters2, "erasedSuper.typeParameters");
                    if (!typeParameters2.isEmpty()) {
                        callableDescriptor3 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(EmptyList.INSTANCE).build();
                        Intrinsics.checkNotNull(callableDescriptor3);
                    }
                }
                Result result2 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor3, callableDescriptor2, false).getResult();
                Intrinsics.checkNotNullExpressionValue(result2, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
                if (WhenMappings.$EnumSwitchMapping$0[result2.ordinal()] == 1) {
                    result = ExternalOverridabilityCondition.Result.OVERRIDABLE;
                } else {
                    result = ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return result;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
