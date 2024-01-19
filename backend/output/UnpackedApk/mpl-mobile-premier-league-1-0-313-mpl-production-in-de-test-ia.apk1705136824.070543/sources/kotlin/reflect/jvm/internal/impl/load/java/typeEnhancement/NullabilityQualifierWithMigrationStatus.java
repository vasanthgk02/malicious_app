package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
public final class NullabilityQualifierWithMigrationStatus {
    public final boolean isForWarningOnly;
    public final NullabilityQualifier qualifier;

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        this.qualifier = nullabilityQualifier;
        this.isForWarningOnly = z;
    }

    public static NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z, int i) {
        NullabilityQualifier nullabilityQualifier2 = (i & 1) != 0 ? nullabilityQualifierWithMigrationStatus.qualifier : null;
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        if (nullabilityQualifierWithMigrationStatus != null) {
            Intrinsics.checkNotNullParameter(nullabilityQualifier2, "qualifier");
            return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier2, z);
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.qualifier == nullabilityQualifierWithMigrationStatus.qualifier && this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly;
    }

    public int hashCode() {
        int hashCode = this.qualifier.hashCode() * 31;
        boolean z = this.isForWarningOnly;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NullabilityQualifierWithMigrationStatus(qualifier=");
        outline73.append(this.qualifier);
        outline73.append(", isForWarningOnly=");
        return GeneratedOutlineSupport.outline65(outline73, this.isForWarningOnly, ')');
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z, int i) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }
}
