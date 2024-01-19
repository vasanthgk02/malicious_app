package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class LazyJavaAnnotationDescriptor$fqName$2 extends Lambda implements Function0<FqName> {
    public final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        // this.this$0 = lazyJavaAnnotationDescriptor;
        super(0);
    }

    public Object invoke() {
        ClassId classId = this.this$0.javaAnnotation.getClassId();
        if (classId == null) {
            return null;
        }
        return classId.asSingleFqName();
    }
}
