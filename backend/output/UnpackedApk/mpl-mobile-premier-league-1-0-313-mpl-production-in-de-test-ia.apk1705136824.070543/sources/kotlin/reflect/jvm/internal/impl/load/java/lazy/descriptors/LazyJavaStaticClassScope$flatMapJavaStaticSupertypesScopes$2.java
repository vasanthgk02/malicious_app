package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS$AbstractNodeHandler;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2 extends DFS$AbstractNodeHandler<ClassDescriptor, Unit> {
    public final /* synthetic */ Function1<MemberScope, Collection<R>> $onJavaStaticScope;
    public final /* synthetic */ Set<R> $result;
    public final /* synthetic */ ClassDescriptor $root;

    public LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        this.$root = classDescriptor;
        this.$result = set;
        this.$onJavaStaticScope = function1;
    }

    public boolean beforeChildren(Object obj) {
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        Intrinsics.checkNotNullParameter(classDescriptor, "current");
        if (classDescriptor == this.$root) {
            return true;
        }
        MemberScope staticScope = classDescriptor.getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.$result.addAll((Collection) this.$onJavaStaticScope.invoke(staticScope));
        return false;
    }

    public Object result() {
        return Unit.INSTANCE;
    }
}
