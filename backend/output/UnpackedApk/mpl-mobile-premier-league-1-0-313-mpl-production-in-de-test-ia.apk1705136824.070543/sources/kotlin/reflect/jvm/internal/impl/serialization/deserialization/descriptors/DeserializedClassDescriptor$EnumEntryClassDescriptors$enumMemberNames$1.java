package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ EnumEntryClassDescriptors this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(EnumEntryClassDescriptors enumEntryClassDescriptors) {
        // this.this$0 = enumEntryClassDescriptors;
        super(0);
    }

    public Object invoke() {
        EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0;
        if (enumEntryClassDescriptors != null) {
            HashSet hashSet = new HashSet();
            for (KotlinType memberScope : enumEntryClassDescriptors.this$0.typeConstructor.getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : TweetUtils.getContributedDescriptors$default(memberScope.getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf$Function> list = enumEntryClassDescriptors.this$0.classProto.function_;
            Intrinsics.checkNotNullExpressionValue(list, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = enumEntryClassDescriptors.this$0;
            for (ProtoBuf$Function protoBuf$Function : list) {
                hashSet.add(TweetUtils.getName(deserializedClassDescriptor.f5950c.nameResolver, protoBuf$Function.name_));
            }
            List<ProtoBuf$Property> list2 = enumEntryClassDescriptors.this$0.classProto.property_;
            Intrinsics.checkNotNullExpressionValue(list2, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = enumEntryClassDescriptors.this$0;
            for (ProtoBuf$Property protoBuf$Property : list2) {
                hashSet.add(TweetUtils.getName(deserializedClassDescriptor2.f5950c.nameResolver, protoBuf$Property.name_));
            }
            return ArraysKt___ArraysJvmKt.plus((Set<? extends T>) hashSet, (Iterable<? extends T>) hashSet);
        }
        throw null;
    }
}
