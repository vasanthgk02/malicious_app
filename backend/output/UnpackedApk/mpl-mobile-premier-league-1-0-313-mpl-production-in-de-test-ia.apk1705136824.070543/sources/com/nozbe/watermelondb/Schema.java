package com.nozbe.watermelondb;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/nozbe/watermelondb/Schema;", "", "version", "", "Lcom/nozbe/watermelondb/SchemaVersion;", "sql", "", "Lcom/nozbe/watermelondb/SQL;", "(ILjava/lang/String;)V", "getSql", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseUtils.kt */
public final class Schema {
    public final String sql;
    public final int version;

    public Schema(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.version = i;
        this.sql = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Schema)) {
            return false;
        }
        Schema schema = (Schema) obj;
        return this.version == schema.version && Intrinsics.areEqual(this.sql, schema.sql);
    }

    public int hashCode() {
        return this.sql.hashCode() + (this.version * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Schema(version=");
        outline73.append(this.version);
        outline73.append(", sql=");
        return GeneratedOutlineSupport.outline59(outline73, this.sql, ')');
    }
}
