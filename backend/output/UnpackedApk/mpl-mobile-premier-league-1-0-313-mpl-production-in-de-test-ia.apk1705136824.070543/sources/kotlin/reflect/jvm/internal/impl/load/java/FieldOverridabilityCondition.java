package kotlin.reflect.jvm.internal.impl.load.java;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result;

/* compiled from: FieldOverridabilityCondition.kt */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    public Contract getContract() {
        return Contract.BOTH;
    }

    public Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (!(callableDescriptor2 instanceof PropertyDescriptor) || !(callableDescriptor instanceof PropertyDescriptor)) {
            return Result.UNKNOWN;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor2;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor;
        if (!Intrinsics.areEqual(propertyDescriptor.getName(), propertyDescriptor2.getName())) {
            return Result.UNKNOWN;
        }
        if (TweetUtils.isJavaField(propertyDescriptor) && TweetUtils.isJavaField(propertyDescriptor2)) {
            return Result.OVERRIDABLE;
        }
        if (TweetUtils.isJavaField(propertyDescriptor) || TweetUtils.isJavaField(propertyDescriptor2)) {
            return Result.INCOMPATIBLE;
        }
        return Result.UNKNOWN;
    }
}
