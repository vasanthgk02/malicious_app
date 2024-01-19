package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public abstract class DelegatingSimpleType extends SimpleType {
    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract SimpleType getDelegate();

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract DelegatingSimpleType replaceDelegate(SimpleType simpleType);

    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType delegate = getDelegate();
        Intrinsics.checkNotNullParameter(delegate, "type");
        return replaceDelegate(delegate);
    }
}
