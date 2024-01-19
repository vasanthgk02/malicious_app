package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    public final Annotations annotations;
    public final CaptureStatus captureStatus;
    public final NewCapturedTypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final boolean isProjectionNotNull;
    public final UnwrappedType lowerType;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NewCapturedType(CaptureStatus captureStatus2, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations2, boolean z, boolean z2, int i) {
        // if ((i & 8) != 0) {
            // if (Annotations.Companion != null) {
                // annotations2 = Companion.EMPTY;
            // } else {
                // throw null;
            // }
        // }
        this(captureStatus2, newCapturedTypeConstructor, unwrappedType, annotations2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
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
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return createErrorScope;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public NewCapturedType makeNullableAsSpecified(boolean z) {
        NewCapturedType newCapturedType = new NewCapturedType(this.captureStatus, this.constructor, this.lowerType, this.annotations, z, false, 32);
        return newCapturedType;
    }

    public NewCapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus2 = this.captureStatus;
        NewCapturedTypeConstructor refine = this.constructor.refine(kotlinTypeRefiner);
        UnwrappedType unwrappedType2 = this.lowerType;
        if (unwrappedType2 == null) {
            unwrappedType = null;
        } else {
            Intrinsics.checkNotNullParameter(unwrappedType2, "type");
            unwrappedType = unwrappedType2.unwrap();
        }
        NewCapturedType newCapturedType = new NewCapturedType(captureStatus2, refine, unwrappedType, this.annotations, this.isMarkedNullable, false, 32);
        return newCapturedType;
    }

    public NewCapturedType replaceAnnotations(Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations2, "newAnnotations");
        NewCapturedType newCapturedType = new NewCapturedType(this.captureStatus, this.constructor, this.lowerType, annotations2, this.isMarkedNullable, false, 32);
        return newCapturedType;
    }

    public NewCapturedType(CaptureStatus captureStatus2, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(captureStatus2, "captureStatus");
        Intrinsics.checkNotNullParameter(newCapturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(annotations2, "annotations");
        this.captureStatus = captureStatus2;
        this.constructor = newCapturedTypeConstructor;
        this.lowerType = unwrappedType;
        this.annotations = annotations2;
        this.isMarkedNullable = z;
        this.isProjectionNotNull = z2;
    }
}
