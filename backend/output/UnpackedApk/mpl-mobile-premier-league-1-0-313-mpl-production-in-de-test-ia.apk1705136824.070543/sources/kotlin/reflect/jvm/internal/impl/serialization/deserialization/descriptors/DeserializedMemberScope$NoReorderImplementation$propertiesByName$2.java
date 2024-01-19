package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$propertiesByName$2 extends Lambda implements Function0<Map<Name, ? extends List<? extends PropertyDescriptor>>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : (List) TweetUtils.getValue(this.this$0.allProperties$delegate, NoReorderImplementation.$$delegatedProperties[4])) {
            Name name = ((PropertyDescriptor) next).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }
}
