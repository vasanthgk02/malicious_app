package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinType.kt */
public abstract class UnwrappedType extends KotlinType {
    public UnwrappedType() {
        super(null);
    }

    public abstract UnwrappedType makeNullableAsSpecified(boolean z);

    public abstract UnwrappedType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract UnwrappedType replaceAnnotations(Annotations annotations);

    public final UnwrappedType unwrap() {
        return this;
    }

    public UnwrappedType(DefaultConstructorMarker defaultConstructorMarker) {
        super(null);
    }
}
