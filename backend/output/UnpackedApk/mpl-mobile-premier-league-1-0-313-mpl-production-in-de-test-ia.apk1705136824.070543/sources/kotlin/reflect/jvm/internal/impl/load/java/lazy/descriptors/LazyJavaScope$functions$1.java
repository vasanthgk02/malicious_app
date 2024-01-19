package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$functions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) this.this$0.declaredFunctions.invoke(name));
        if (this.this$0 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) next, false, false, 2);
                Object obj2 = linkedHashMap.get(computeJvmDescriptor$default);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(computeJvmDescriptor$default, obj2);
                }
                ((List) obj2).add(next);
            }
            for (List list : linkedHashMap.values()) {
                if (list.size() != 1) {
                    Collection selectMostSpecificInEachOverridableGroup = TweetUtils.selectMostSpecificInEachOverridableGroup(list, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                    linkedHashSet.removeAll(list);
                    linkedHashSet.addAll(selectMostSpecificInEachOverridableGroup);
                }
            }
            this.this$0.computeNonDeclaredFunctions(linkedHashSet, name);
            LazyJavaResolverContext lazyJavaResolverContext = this.this$0.f5943c;
            return ArraysKt___ArraysJvmKt.toList(lazyJavaResolverContext.components.signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, linkedHashSet));
        }
        throw null;
    }
}
