package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$constructors$1 extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        // this.this$0 = deserializedClassDescriptor;
        super(0);
    }

    public Object invoke() {
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
        List<ProtoBuf$Constructor> list = deserializedClassDescriptor.classProto.constructor_;
        Intrinsics.checkNotNullExpressionValue(list, "classProto.constructorList");
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (GeneratedOutlineSupport.outline108(Flags.IS_SECONDARY, ((ProtoBuf$Constructor) next).flags_, "IS_SECONDARY.get(it.flags)")) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) it.next();
            MemberDeserializer memberDeserializer = deserializedClassDescriptor.f5950c.memberDeserializer;
            Intrinsics.checkNotNullExpressionValue(protoBuf$Constructor, "it");
            arrayList2.add(memberDeserializer.loadConstructor(protoBuf$Constructor, false));
        }
        return ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) arrayList2, (Iterable<? extends T>) TweetUtils.listOfNotNull(deserializedClassDescriptor.getUnsubstitutedPrimaryConstructor())), (Iterable<? extends T>) deserializedClassDescriptor.f5950c.components.additionalClassPartsProvider.getConstructors(deserializedClassDescriptor));
    }
}
