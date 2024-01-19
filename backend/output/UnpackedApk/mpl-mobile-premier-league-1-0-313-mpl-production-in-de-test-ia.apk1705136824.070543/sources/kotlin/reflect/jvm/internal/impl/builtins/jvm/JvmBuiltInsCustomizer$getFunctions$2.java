package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer$getFunctions$2 extends Lambda implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ Name $name;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltInsCustomizer$getFunctions$2(Name name) {
        // this.$name = name;
        super(1);
    }

    public Object invoke(Object obj) {
        MemberScope memberScope = (MemberScope) obj;
        Intrinsics.checkNotNullParameter(memberScope, "it");
        return memberScope.getContributedFunctions(this.$name, NoLookupLocation.FROM_BUILTINS);
    }
}
