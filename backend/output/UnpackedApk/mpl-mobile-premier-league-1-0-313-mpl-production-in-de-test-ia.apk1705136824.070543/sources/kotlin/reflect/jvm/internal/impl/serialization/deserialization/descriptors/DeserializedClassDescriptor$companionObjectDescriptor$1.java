package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$companionObjectDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$companionObjectDescriptor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        // this.this$0 = deserializedClassDescriptor;
        super(0);
    }

    public Object invoke() {
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
        if (!((deserializedClassDescriptor.classProto.bitField0_ & 4) == 4)) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = ((DeserializedClassMemberScope) deserializedClassDescriptor.memberScopeHolder.getScope(deserializedClassDescriptor.f5950c.components.kotlinTypeChecker.getKotlinTypeRefiner())).getContributedClassifier(TweetUtils.getName(deserializedClassDescriptor.f5950c.nameResolver, deserializedClassDescriptor.classProto.companionObjectName_), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
