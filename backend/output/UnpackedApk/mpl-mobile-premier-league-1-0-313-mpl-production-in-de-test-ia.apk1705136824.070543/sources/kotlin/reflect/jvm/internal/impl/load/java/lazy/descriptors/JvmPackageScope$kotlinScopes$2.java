package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<MemberScope[]> {
    public final /* synthetic */ JvmPackageScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        // this.this$0 = jvmPackageScope;
        super(0);
    }

    public Object invoke() {
        Collection<KotlinJvmBinaryClass> values = this.this$0.packageFragment.getBinaryClasses$descriptors_jvm().values();
        JvmPackageScope jvmPackageScope = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (KotlinJvmBinaryClass createKotlinPackagePartScope : values) {
            MemberScope createKotlinPackagePartScope2 = jvmPackageScope.f5939c.components.deserializedDescriptorResolver.createKotlinPackagePartScope(jvmPackageScope.packageFragment, createKotlinPackagePartScope);
            if (createKotlinPackagePartScope2 != null) {
                arrayList.add(createKotlinPackagePartScope2);
            }
        }
        Object[] array = TypeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
        if (array != null) {
            return (MemberScope[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
