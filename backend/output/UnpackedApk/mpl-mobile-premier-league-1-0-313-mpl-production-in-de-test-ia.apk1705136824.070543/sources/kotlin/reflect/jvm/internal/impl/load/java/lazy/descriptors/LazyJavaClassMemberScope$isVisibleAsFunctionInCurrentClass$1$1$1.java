package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ SimpleFunctionDescriptor $function;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        // this.$function = simpleFunctionDescriptor;
        // this.this$0 = lazyJavaClassMemberScope;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "accessorName");
        if (Intrinsics.areEqual(this.$function.getName(), name)) {
            return TweetUtils.listOf(this.$function);
        }
        return ArraysKt___ArraysJvmKt.plus(LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, name), (Iterable<? extends T>) LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, name));
    }
}
