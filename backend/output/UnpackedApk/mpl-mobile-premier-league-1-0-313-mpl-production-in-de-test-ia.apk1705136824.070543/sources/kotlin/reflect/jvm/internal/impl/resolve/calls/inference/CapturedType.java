package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedType extends SimpleType implements CapturedTypeMarker {
    public final Annotations annotations;
    public final CapturedTypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final TypeProjection typeProjection;

    public CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations2) {
        Intrinsics.checkNotNullParameter(typeProjection2, "typeProjection");
        Intrinsics.checkNotNullParameter(capturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(annotations2, "annotations");
        this.typeProjection = typeProjection2;
        this.constructor = capturedTypeConstructor;
        this.isMarkedNullable = z;
        this.annotations = annotations2;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public List<TypeProjection> getArguments() {
        return EmptyList.INSTANCE;
    }

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public MemberScope getMemberScope() {
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return createErrorScope;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == this.isMarkedNullable) {
            return this;
        }
        return new CapturedType(this.typeProjection, this.constructor, z, this.annotations);
    }

    public SimpleType replaceAnnotations(Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations2, "newAnnotations");
        return new CapturedType(this.typeProjection, this.constructor, this.isMarkedNullable, annotations2);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Captured(");
        outline73.append(this.typeProjection);
        outline73.append(')');
        outline73.append(this.isMarkedNullable ? ColorPropConverter.PREFIX_ATTR : "");
        return outline73.toString();
    }

    public CapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.typeProjection.refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, this.constructor, this.isMarkedNullable, this.annotations);
    }

    /* renamed from: makeNullableAsSpecified  reason: collision with other method in class */
    public UnwrappedType m969makeNullableAsSpecified(boolean z) {
        if (z == this.isMarkedNullable) {
            return this;
        }
        return new CapturedType(this.typeProjection, this.constructor, z, this.annotations);
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public UnwrappedType m970replaceAnnotations(Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations2, "newAnnotations");
        return new CapturedType(this.typeProjection, this.constructor, this.isMarkedNullable, annotations2);
    }
}
