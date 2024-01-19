package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$computeNonDeclaredProperties$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope$computeNonDeclaredProperties$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        // this.this$0 = lazyJavaClassMemberScope;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "it");
        return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, name);
    }
}
