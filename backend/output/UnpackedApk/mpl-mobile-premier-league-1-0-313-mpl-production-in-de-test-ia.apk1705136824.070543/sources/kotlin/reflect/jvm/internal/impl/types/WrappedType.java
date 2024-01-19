package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: KotlinType.kt */
public abstract class WrappedType extends KotlinType {
    public WrappedType() {
        super(null);
    }

    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract KotlinType getDelegate();

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public String toString() {
        return isComputed() ? getDelegate().toString() : "<Not computed yet>";
    }

    public final UnwrappedType unwrap() {
        KotlinType delegate = getDelegate();
        while (delegate instanceof WrappedType) {
            delegate = ((WrappedType) delegate).getDelegate();
        }
        return (UnwrappedType) delegate;
    }
}
