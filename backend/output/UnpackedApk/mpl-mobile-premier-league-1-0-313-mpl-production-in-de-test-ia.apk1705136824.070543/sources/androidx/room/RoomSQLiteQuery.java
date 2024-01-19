package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0000J\u0016\u00102\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020#R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u0012\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\rR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\r¨\u00067"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "(I)V", "<set-?>", "argCount", "getArgCount", "()I", "bindingTypes", "", "getBindingTypes$annotations", "()V", "blobBindings", "", "", "getBlobBindings$annotations", "[[B", "getCapacity", "doubleBindings", "", "getDoubleBindings$annotations", "longBindings", "", "getLongBindings$annotations", "query", "", "sql", "getSql", "()Ljava/lang/String;", "stringBindings", "getStringBindings$annotations", "[Ljava/lang/String;", "bindBlob", "", "index", "value", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "bindTo", "statement", "clearBindings", "close", "copyArgumentsFrom", "other", "init", "initArgCount", "release", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomSQLiteQuery.kt */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();
    public int argCount;
    public final int[] bindingTypes;
    public final byte[][] blobBindings;
    public final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    public volatile String query;
    public final String[] stringBindings;

    public RoomSQLiteQuery(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }

    public static final RoomSQLiteQuery acquire(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "query");
        synchronized (queryPool) {
            Entry<Integer, RoomSQLiteQuery> ceilingEntry = queryPool.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                queryPool.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                if (value != null) {
                    Intrinsics.checkNotNullParameter(str, "query");
                    value.query = str;
                    value.argCount = i;
                    Intrinsics.checkNotNullExpressionValue(value, "sqliteQuery");
                    return value;
                }
                throw null;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, null);
            Intrinsics.checkNotNullParameter(str, "query");
            roomSQLiteQuery.query = str;
            roomSQLiteQuery.argCount = i;
            return roomSQLiteQuery;
        }
    }

    public void bindBlob(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, HSLCriteriaBuilder.VALUE);
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    public void bindDouble(int i, double d2) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d2;
    }

    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    public void bindString(int i, String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter(supportSQLiteProgram, "statement");
        int i = this.argCount;
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                int i3 = this.bindingTypes[i2];
                if (i3 == 1) {
                    supportSQLiteProgram.bindNull(i2);
                } else if (i3 == 2) {
                    supportSQLiteProgram.bindLong(i2, this.longBindings[i2]);
                } else if (i3 == 3) {
                    supportSQLiteProgram.bindDouble(i2, this.doubleBindings[i2]);
                } else if (i3 == 4) {
                    String str = this.stringBindings[i2];
                    if (str != null) {
                        supportSQLiteProgram.bindString(i2, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i3 == 5) {
                    byte[] bArr = this.blobBindings[i2];
                    if (bArr != null) {
                        supportSQLiteProgram.bindBlob(i2, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
    }

    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void release() {
        synchronized (queryPool) {
            queryPool.put(Integer.valueOf(this.capacity), this);
            if (queryPool.size() > 15) {
                int size = queryPool.size() - 10;
                Iterator<Integer> it = queryPool.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }
}
