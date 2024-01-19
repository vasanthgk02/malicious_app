package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope$computePropertyNames$1$1 extends Lambda implements Function1<MemberScope, Collection<? extends Name>> {
    public static final LazyJavaStaticClassScope$computePropertyNames$1$1 INSTANCE = new LazyJavaStaticClassScope$computePropertyNames$1$1();

    public LazyJavaStaticClassScope$computePropertyNames$1$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        MemberScope memberScope = (MemberScope) obj;
        Intrinsics.checkNotNullParameter(memberScope, "it");
        return memberScope.getVariableNames();
    }
}
