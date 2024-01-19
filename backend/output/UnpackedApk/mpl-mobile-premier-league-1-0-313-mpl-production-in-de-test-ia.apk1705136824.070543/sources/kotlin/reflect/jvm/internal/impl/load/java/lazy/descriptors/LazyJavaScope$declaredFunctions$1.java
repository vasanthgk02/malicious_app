package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$declaredFunctions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$declaredFunctions$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        LazyJavaScope lazyJavaScope = this.this$0.mainScope;
        if (lazyJavaScope != null) {
            return (Collection) lazyJavaScope.declaredFunctions.invoke(name);
        }
        ArrayList arrayList = new ArrayList();
        for (JavaMethod resolveMethodToFunctionDescriptor : ((DeclaredMemberIndex) this.this$0.declaredMemberIndex.invoke()).findMethodsByName(name)) {
            JavaMethodDescriptor resolveMethodToFunctionDescriptor2 = this.this$0.resolveMethodToFunctionDescriptor(resolveMethodToFunctionDescriptor);
            if (this.this$0.isVisibleAsFunction(resolveMethodToFunctionDescriptor2)) {
                if (((AnonymousClass1) this.this$0.f5943c.components.javaResolverCache) != null) {
                    arrayList.add(resolveMethodToFunctionDescriptor2);
                } else {
                    throw null;
                }
            }
        }
        this.this$0.computeImplicitlyDeclaredFunctions(arrayList, name);
        return arrayList;
    }
}
