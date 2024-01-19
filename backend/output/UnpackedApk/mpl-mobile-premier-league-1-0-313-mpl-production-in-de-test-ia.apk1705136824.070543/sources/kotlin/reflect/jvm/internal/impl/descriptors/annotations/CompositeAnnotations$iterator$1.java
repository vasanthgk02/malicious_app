package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
public final class CompositeAnnotations$iterator$1 extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 INSTANCE = new CompositeAnnotations$iterator$1();

    public CompositeAnnotations$iterator$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        Annotations annotations = (Annotations) obj;
        Intrinsics.checkNotNullParameter(annotations, "it");
        return ArraysKt___ArraysJvmKt.asSequence(annotations);
    }
}
