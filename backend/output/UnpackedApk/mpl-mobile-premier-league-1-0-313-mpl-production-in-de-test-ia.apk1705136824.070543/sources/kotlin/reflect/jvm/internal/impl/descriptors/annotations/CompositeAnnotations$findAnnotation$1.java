package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class CompositeAnnotations$findAnnotation$1 extends Lambda implements Function1<Annotations, AnnotationDescriptor> {
    public final /* synthetic */ FqName $fqName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CompositeAnnotations$findAnnotation$1(FqName fqName) {
        // this.$fqName = fqName;
        super(1);
    }

    public Object invoke(Object obj) {
        Annotations annotations = (Annotations) obj;
        Intrinsics.checkNotNullParameter(annotations, "it");
        return annotations.findAnnotation(this.$fqName);
    }
}
