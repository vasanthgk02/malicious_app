package com.nozbe.watermelondb;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\u0002\u0010\tJ\r\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\u0010\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\u0011\u001a\u00060\u0007j\u0002`\bHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/nozbe/watermelondb/MigrationSet;", "", "from", "", "Lcom/nozbe/watermelondb/SchemaVersion;", "to", "sql", "", "Lcom/nozbe/watermelondb/SQL;", "(IILjava/lang/String;)V", "getFrom", "()I", "getSql", "()Ljava/lang/String;", "getTo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseUtils.kt */
public final class MigrationSet {
    public final int from;
    public final String sql;
    public final int to;

    public MigrationSet(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.from = i;
        this.to = i2;
        this.sql = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MigrationSet)) {
            return false;
        }
        MigrationSet migrationSet = (MigrationSet) obj;
        return this.from == migrationSet.from && this.to == migrationSet.to && Intrinsics.areEqual(this.sql, migrationSet.sql);
    }

    public int hashCode() {
        return this.sql.hashCode() + (((this.from * 31) + this.to) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MigrationSet(from=");
        outline73.append(this.from);
        outline73.append(", to=");
        outline73.append(this.to);
        outline73.append(", sql=");
        return GeneratedOutlineSupport.outline59(outline73, this.sql, ')');
    }
}
