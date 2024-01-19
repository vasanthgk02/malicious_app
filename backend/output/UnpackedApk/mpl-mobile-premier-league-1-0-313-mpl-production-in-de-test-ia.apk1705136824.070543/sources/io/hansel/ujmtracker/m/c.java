package io.hansel.ujmtracker.m;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import io.hansel.core.logger.HSLLogger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f5352a;

    /* renamed from: b  reason: collision with root package name */
    public String f5353b = SMTEventParamKeys.SMT_EVENT_ID;

    /* renamed from: c  reason: collision with root package name */
    public String f5354c = "groupId";

    /* renamed from: d  reason: collision with root package name */
    public String f5355d = "data_source";

    /* renamed from: e  reason: collision with root package name */
    public String f5356e = "data";

    /* renamed from: f  reason: collision with root package name */
    public String f5357f = "expiry";
    public String g = "timestamp";
    public SQLiteStatement h;

    public class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f5358a = getWritableDatabase();

        public a(Context context) {
            super(context, "batch.db", null, 2);
        }

        private String a() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE IF NOT EXISTS cache (");
            outline73.append(c.this.f5353b);
            outline73.append(" INTEGER primary key, ");
            outline73.append(c.this.f5354c);
            outline73.append(" TEXT, ");
            outline73.append(c.this.f5356e);
            outline73.append(" BLOB, ");
            outline73.append(c.this.f5357f);
            outline73.append(" INTEGER, ");
            outline73.append(c.this.g);
            outline73.append(" INTEGER, ");
            outline73.append(c.this.f5355d);
            outline73.append(" TEXT )");
            return outline73.toString();
        }

        public SQLiteDatabase b() {
            return this.f5358a;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(a());
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
                sQLiteDatabase.execSQL(a());
            }
        }
    }

    public c(Context context) {
        this.f5352a = new a(context);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("insert into cache (");
        outline73.append(this.f5353b);
        outline73.append(", ");
        outline73.append(this.f5354c);
        outline73.append(", ");
        outline73.append(this.f5356e);
        outline73.append(", ");
        outline73.append(this.f5357f);
        outline73.append(", ");
        outline73.append(this.g);
        outline73.append(", ");
        this.h = this.f5352a.b().compileStatement(GeneratedOutlineSupport.outline62(outline73, this.f5355d, ") values (?, ?, ?, ?, ?, ?)"));
    }

    public void a(long j) {
        this.f5352a.b().delete("cache", GeneratedOutlineSupport.outline62(new StringBuilder(), this.f5353b, "=?"), new String[]{GeneratedOutlineSupport.outline45("", j)});
    }

    public synchronized void a(long j, String str, byte[] bArr, String str2, long j2, long j3) {
        try {
            this.h.bindLong(1, j);
            this.h.bindString(2, str);
            this.h.bindBlob(3, bArr);
            this.h.bindLong(4, j2);
            this.h.bindLong(5, j3);
            if (str2 != null) {
                this.h.bindString(6, str2);
            } else {
                this.h.bindNull(6);
            }
            this.h.executeInsert();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return;
    }

    public void a(a aVar) {
        if (aVar != null) {
            SQLiteDatabase b2 = this.f5352a.b();
            String str = this.g;
            Cursor query = b2.query("cache", new String[]{this.f5353b, this.f5354c, this.f5356e, this.f5357f, str, this.f5355d}, null, null, null, null, str);
            if (query.moveToFirst()) {
                do {
                    try {
                        f a2 = aVar.d().a(query.getString(1));
                        if (a2 != null) {
                            d dVar = new d();
                            dVar.a(query.getLong(0));
                            dVar.a(query.getString(1));
                            dVar.a(a2.a().a(query.getBlob(2)));
                            dVar.a(io.hansel.ujmtracker.m.d.a.CSTATE_CACHED);
                            dVar.b(query.getLong(query.getColumnIndex(this.g)));
                            dVar.a(query.getString(query.getColumnIndex(this.f5355d)));
                            a2.b(dVar);
                        }
                    } catch (Throwable th) {
                        HSLLogger.printStackTrace(th);
                    }
                } while (query.moveToNext());
            } else {
                HSLLogger.d("DbManager: In loadCachedDataInBatchNetworkingInstance: No data to load");
            }
            if (!query.isClosed()) {
                query.close();
            }
        }
    }
}
