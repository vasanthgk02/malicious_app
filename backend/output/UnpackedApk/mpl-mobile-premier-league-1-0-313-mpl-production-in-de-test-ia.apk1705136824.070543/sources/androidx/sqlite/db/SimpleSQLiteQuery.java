package androidx.sqlite.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SimpleSQLiteQuery.kt */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public final Object[] bindArgs;
    public final String query;

    public SimpleSQLiteQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(str, "query");
        this.query = str;
        this.bindArgs = null;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter(supportSQLiteProgram, "statement");
        Object[] objArr = this.bindArgs;
        Intrinsics.checkNotNullParameter(supportSQLiteProgram, "statement");
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                if (obj == null) {
                    supportSQLiteProgram.bindNull(i);
                } else if (obj instanceof byte[]) {
                    supportSQLiteProgram.bindBlob(i, (byte[]) obj);
                } else if (obj instanceof Float) {
                    supportSQLiteProgram.bindDouble(i, (double) ((Number) obj).floatValue());
                } else if (obj instanceof Double) {
                    supportSQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
                } else if (obj instanceof Long) {
                    supportSQLiteProgram.bindLong(i, ((Number) obj).longValue());
                } else if (obj instanceof Integer) {
                    supportSQLiteProgram.bindLong(i, (long) ((Number) obj).intValue());
                } else if (obj instanceof Short) {
                    supportSQLiteProgram.bindLong(i, (long) ((Number) obj).shortValue());
                } else if (obj instanceof Byte) {
                    supportSQLiteProgram.bindLong(i, (long) ((Number) obj).byteValue());
                } else if (obj instanceof String) {
                    supportSQLiteProgram.bindString(i, (String) obj);
                } else if (obj instanceof Boolean) {
                    supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
            }
        }
    }

    public String getSql() {
        return this.query;
    }

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.query = str;
        this.bindArgs = objArr;
    }
}
