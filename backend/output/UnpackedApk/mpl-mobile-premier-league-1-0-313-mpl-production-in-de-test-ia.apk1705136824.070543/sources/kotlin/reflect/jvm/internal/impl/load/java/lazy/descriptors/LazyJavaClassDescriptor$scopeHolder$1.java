package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor$scopeHolder$1 extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope> {
    public final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        // this.this$0 = lazyJavaClassDescriptor;
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((KotlinTypeRefiner) obj, "it");
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(lazyJavaClassDescriptor.f5941c, lazyJavaClassDescriptor, lazyJavaClassDescriptor.jClass, lazyJavaClassDescriptor.additionalSupertypeClassDescriptor != null, this.this$0.unsubstitutedMemberScope);
        return lazyJavaClassMemberScope;
    }
}
