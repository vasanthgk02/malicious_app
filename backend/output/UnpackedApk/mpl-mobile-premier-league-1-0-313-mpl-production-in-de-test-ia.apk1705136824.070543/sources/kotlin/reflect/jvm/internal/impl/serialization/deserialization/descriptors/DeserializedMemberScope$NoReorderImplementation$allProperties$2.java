package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$allProperties$2 extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allProperties$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        List list = (List) TweetUtils.getValue(this.this$0.declaredProperties$delegate, NoReorderImplementation.$$delegatedProperties[1]);
        NoReorderImplementation noReorderImplementation = this.this$0;
        Set<Name> nonDeclaredVariableNames = noReorderImplementation.this$0.getNonDeclaredVariableNames();
        ArrayList arrayList = new ArrayList();
        for (Name name : nonDeclaredVariableNames) {
            DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
            ArrayList arrayList2 = new ArrayList();
            for (Object next : (List) TweetUtils.getValue(noReorderImplementation.declaredProperties$delegate, NoReorderImplementation.$$delegatedProperties[1])) {
                if (Intrinsics.areEqual(((DeclarationDescriptor) next).getName(), name)) {
                    arrayList2.add(next);
                }
            }
            int size = arrayList2.size();
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList2);
            TweetUtils.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
        }
        return ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) list, (Iterable<? extends T>) arrayList);
    }
}
