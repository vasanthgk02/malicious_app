package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaTypeQualifiersByElementType.kt */
public final class JavaTypeQualifiersByElementType {
    public final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> enumMap) {
        Intrinsics.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.defaultQualifiers = enumMap;
    }
}
