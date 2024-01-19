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
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.NoReorderImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$NoReorderImplementation$allFunctions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ NoReorderImplementation this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$NoReorderImplementation$allFunctions$2(NoReorderImplementation noReorderImplementation) {
        // this.this$0 = noReorderImplementation;
        super(0);
    }

    public Object invoke() {
        List list = (List) TweetUtils.getValue(this.this$0.declaredFunctions$delegate, NoReorderImplementation.$$delegatedProperties[0]);
        NoReorderImplementation noReorderImplementation = this.this$0;
        Set<Name> nonDeclaredFunctionNames = noReorderImplementation.this$0.getNonDeclaredFunctionNames();
        ArrayList arrayList = new ArrayList();
        for (Name name : nonDeclaredFunctionNames) {
            DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
            ArrayList arrayList2 = new ArrayList();
            for (Object next : (List) TweetUtils.getValue(noReorderImplementation.declaredFunctions$delegate, NoReorderImplementation.$$delegatedProperties[0])) {
                if (Intrinsics.areEqual(((DeclarationDescriptor) next).getName(), name)) {
                    arrayList2.add(next);
                }
            }
            int size = arrayList2.size();
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList2);
            TweetUtils.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
        }
        return ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) list, (Iterable<? extends T>) arrayList);
    }
}
