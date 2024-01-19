package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaAnnotationDescriptor$type$2(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        // this.$c = lazyJavaResolverContext;
        // this.this$0 = javaAnnotationDescriptor;
        super(0);
    }

    public Object invoke() {
        SimpleType defaultType = this.$c.components.module.getBuiltIns().getBuiltInClassByFqName(this.this$0.fqName).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
        return defaultType;
    }
}
