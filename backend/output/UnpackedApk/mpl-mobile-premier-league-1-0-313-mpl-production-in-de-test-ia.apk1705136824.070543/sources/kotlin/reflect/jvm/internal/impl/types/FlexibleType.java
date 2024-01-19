package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;

/* compiled from: KotlinType.kt */
public abstract class FlexibleType extends UnwrappedType implements FlexibleTypeMarker {
    public final SimpleType lowerBound;
    public final SimpleType upperBound;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FlexibleType(SimpleType simpleType, SimpleType simpleType2) {
        // Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        // Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        super(null);
        this.lowerBound = simpleType;
        this.upperBound = simpleType2;
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

    public abstract SimpleType getDelegate();

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions);

    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.renderType(this);
    }
}
