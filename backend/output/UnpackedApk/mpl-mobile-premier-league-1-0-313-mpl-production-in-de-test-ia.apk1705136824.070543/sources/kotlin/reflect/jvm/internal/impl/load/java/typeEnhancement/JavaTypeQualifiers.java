package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: typeQualifiers.kt */
public final class JavaTypeQualifiers {
    public static final JavaTypeQualifiers Companion = null;
    public static final JavaTypeQualifiers NONE;
    public final boolean isNotNullTypeParameter;
    public final boolean isNullabilityQualifierForWarning;
    public final MutabilityQualifier mutability;
    public final NullabilityQualifier nullability;

    static {
        JavaTypeQualifiers javaTypeQualifiers = new JavaTypeQualifiers(null, null, false, false, 8);
        NONE = javaTypeQualifiers;
    }

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.isNotNullTypeParameter = z;
        this.isNullabilityQualifierForWarning = z2;
    }

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i) {
        z2 = (i & 8) != 0 ? false : z2;
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.isNotNullTypeParameter = z;
        this.isNullabilityQualifierForWarning = z2;
    }
}
