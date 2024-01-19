package kotlin.reflect.jvm.internal.impl.load.java;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class JavaDefaultQualifiers {
    public final boolean affectsTypeParameterBasedTypes;
    public final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    public final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z, int i) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i & 4) != 0 ? nullabilityQualifierWithMigrationStatus.qualifier == NullabilityQualifier.NOT_NULL : z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual(this.nullabilityQualifier, javaDefaultQualifiers.nullabilityQualifier) && Intrinsics.areEqual(this.qualifierApplicabilityTypes, javaDefaultQualifiers.qualifierApplicabilityTypes) && this.affectsTypeParameterBasedTypes == javaDefaultQualifiers.affectsTypeParameterBasedTypes;
    }

    public int hashCode() {
        int hashCode = (this.qualifierApplicabilityTypes.hashCode() + (this.nullabilityQualifier.hashCode() * 31)) * 31;
        boolean z = this.affectsTypeParameterBasedTypes;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JavaDefaultQualifiers(nullabilityQualifier=");
        outline73.append(this.nullabilityQualifier);
        outline73.append(", qualifierApplicabilityTypes=");
        outline73.append(this.qualifierApplicabilityTypes);
        outline73.append(", affectsTypeParameterBasedTypes=");
        return GeneratedOutlineSupport.outline65(outline73, this.affectsTypeParameterBasedTypes, ')');
    }

    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifierWithMigrationStatus;
        this.qualifierApplicabilityTypes = collection;
        this.affectsTypeParameterBasedTypes = z;
    }
}
