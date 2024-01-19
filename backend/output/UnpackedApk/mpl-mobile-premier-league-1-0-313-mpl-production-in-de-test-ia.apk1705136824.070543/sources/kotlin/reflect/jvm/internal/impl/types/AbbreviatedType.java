package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class AbbreviatedType extends DelegatingSimpleType {
    public final SimpleType abbreviation;
    public final SimpleType delegate;

    public AbbreviatedType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviation");
        this.delegate = simpleType;
        this.abbreviation = simpleType2;
    }

    public SimpleType getDelegate() {
        return this.delegate;
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public SimpleType m973replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new AbbreviatedType(this.delegate.replaceAnnotations(annotations), this.abbreviation);
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new AbbreviatedType(simpleType, this.abbreviation);
    }

    public AbbreviatedType makeNullableAsSpecified(boolean z) {
        return new AbbreviatedType(this.delegate.makeNullableAsSpecified(z), this.abbreviation.makeNullableAsSpecified(z));
    }

    public AbbreviatedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = this.delegate;
        Intrinsics.checkNotNullParameter(simpleType, "type");
        SimpleType simpleType2 = this.abbreviation;
        Intrinsics.checkNotNullParameter(simpleType2, "type");
        return new AbbreviatedType(simpleType, simpleType2);
    }

    /* renamed from: makeNullableAsSpecified  reason: collision with other method in class */
    public SimpleType m972makeNullableAsSpecified(boolean z) {
        return new AbbreviatedType(this.delegate.makeNullableAsSpecified(z), this.abbreviation.makeNullableAsSpecified(z));
    }

    public AbbreviatedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new AbbreviatedType(this.delegate.replaceAnnotations(annotations), this.abbreviation);
    }
}
