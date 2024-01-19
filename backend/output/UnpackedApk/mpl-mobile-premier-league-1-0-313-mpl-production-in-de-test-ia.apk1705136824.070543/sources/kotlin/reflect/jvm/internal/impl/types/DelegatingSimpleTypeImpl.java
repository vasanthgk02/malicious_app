package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: KotlinTypeFactory.kt */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    public final SimpleType delegate;

    public DelegatingSimpleTypeImpl(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        this.delegate = simpleType;
    }

    public SimpleType getDelegate() {
        return this.delegate;
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return annotations != getAnnotations() ? new AnnotatedSimpleType(this, annotations) : this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return this.delegate.makeNullableAsSpecified(z).replaceAnnotations(getAnnotations());
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public UnwrappedType m975replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return annotations != getAnnotations() ? new AnnotatedSimpleType(this, annotations) : this;
    }
}
