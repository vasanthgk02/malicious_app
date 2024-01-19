package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$functionNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ NoReorderImplementation this$0;
    public final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$functionNames$2(NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
        // this.this$0 = noReorderImplementation;
        // this.this$1 = deserializedMemberScope;
        super(0);
    }

    public Object invoke() {
        NoReorderImplementation noReorderImplementation = this.this$0;
        List<ProtoBuf$Function> list = noReorderImplementation.functionList;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
        for (MessageLite messageLite : list) {
            linkedHashSet.add(TweetUtils.getName(deserializedMemberScope.f5951c.nameResolver, ((ProtoBuf$Function) messageLite).name_));
        }
        return ArraysKt___ArraysJvmKt.plus((Set<? extends T>) linkedHashSet, (Iterable<? extends T>) this.this$1.getNonDeclaredFunctionNames());
    }
}
