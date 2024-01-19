package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: KotlinTypeFactory.kt */
public final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    public final Annotations annotations;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AnnotatedSimpleType(SimpleType simpleType, Annotations annotations2) {
        // Intrinsics.checkNotNullParameter(simpleType, "delegate");
        // Intrinsics.checkNotNullParameter(annotations2, "annotations");
        super(simpleType);
        this.annotations = annotations2;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new AnnotatedSimpleType(simpleType, this.annotations);
    }
}
