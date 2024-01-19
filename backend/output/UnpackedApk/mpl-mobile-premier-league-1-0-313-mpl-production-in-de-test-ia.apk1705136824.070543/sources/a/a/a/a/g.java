package a.a.a.a;

import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2417a;

    /* renamed from: b  reason: collision with root package name */
    public final EntityInsertionAdapter<l> f2418b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedSQLiteStatement f2419c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedSQLiteStatement f2420d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedSQLiteStatement f2421e;

    public g(RoomDatabase roomDatabase) {
        this.f2417a = roomDatabase;
        this.f2418b = new b(roomDatabase);
        this.f2419c = new c(roomDatabase);
        this.f2420d = new d(roomDatabase);
        this.f2421e = new e(roomDatabase);
        new f(roomDatabase);
    }

    public int a() {
        this.f2417a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f2419c.acquire();
        this.f2417a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f2417a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f2417a.endTransaction();
            this.f2419c.release(acquire);
        }
    }

    public int a(long j) {
        this.f2417a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f2421e.acquire();
        acquire.bindLong(1, j);
        this.f2417a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f2417a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f2417a.endTransaction();
            this.f2421e.release(acquire);
        }
    }

    public int a(String str) {
        this.f2417a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f2420d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f2417a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f2417a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f2417a.endTransaction();
            this.f2420d.release(acquire);
        }
    }

    public List<l> a(int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM events ORDER BY _ID ASC LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.f2417a.assertNotSuspendingTransaction();
        Cursor query = CompoundButtonCompat.query(this.f2417a, acquire, false, null);
        try {
            int columnIndexOrThrow = CompoundButtonCompat.getColumnIndexOrThrow(query, "_ID");
            int columnIndexOrThrow2 = CompoundButtonCompat.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow3 = CompoundButtonCompat.getColumnIndexOrThrow(query, HSLCriteriaBuilder.VALUE);
            int columnIndexOrThrow4 = CompoundButtonCompat.getColumnIndexOrThrow(query, "timeStamp");
            int columnIndexOrThrow5 = CompoundButtonCompat.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                l lVar = new l();
                lVar.f2430a = query.getLong(columnIndexOrThrow);
                lVar.f2431b = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                lVar.f2432c = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                lVar.f2433d = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                lVar.f2434e = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                arrayList.add(lVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
