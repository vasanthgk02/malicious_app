package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2 extends Lambda implements Function0<Map<Name, ? extends TypeAliasDescriptor>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        List list = (List) TweetUtils.getValue(this.this$0.allTypeAliases$delegate, NoReorderImplementation.$$delegatedProperties[2]);
        int mapCapacity = TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(list, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object next : list) {
            Name name = ((TypeAliasDescriptor) next).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            linkedHashMap.put(name, next);
        }
        return linkedHashMap;
    }
}
