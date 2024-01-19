package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$properties$1 extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList arrayList = new ArrayList();
        TypeUtilsKt.addIfNotNull(arrayList, this.this$0.declaredField.invoke(name));
        this.this$0.computeNonDeclaredProperties(name, arrayList);
        if (DescriptorUtils.isAnnotationClass(this.this$0.getOwnerDescriptor())) {
            return ArraysKt___ArraysJvmKt.toList(arrayList);
        }
        LazyJavaResolverContext lazyJavaResolverContext = this.this$0.f5943c;
        return ArraysKt___ArraysJvmKt.toList(lazyJavaResolverContext.components.signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, arrayList));
    }
}
