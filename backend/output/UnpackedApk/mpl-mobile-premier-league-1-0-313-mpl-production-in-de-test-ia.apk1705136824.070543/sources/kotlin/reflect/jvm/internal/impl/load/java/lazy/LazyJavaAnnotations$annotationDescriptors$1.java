package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements Function1<JavaAnnotation, AnnotationDescriptor> {
    public final /* synthetic */ LazyJavaAnnotations this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        // this.this$0 = lazyJavaAnnotations;
        super(1);
    }

    public Object invoke(Object obj) {
        JavaAnnotation javaAnnotation = (JavaAnnotation) obj;
        Intrinsics.checkNotNullParameter(javaAnnotation, "annotation");
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
        LazyJavaAnnotations lazyJavaAnnotations = this.this$0;
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaAnnotations.f5936c, lazyJavaAnnotations.areAnnotationsFreshlySupported);
    }
}
