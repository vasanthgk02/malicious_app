package io.hansel.segments.s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMap;

public final class b extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static b f5286b;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f5287a = getWritableDatabase();

    /* renamed from: io.hansel.segments.s.b$b  reason: collision with other inner class name */
    public class C0080b<T> {
        public C0080b(b bVar) {
        }

        public T a(Class<T> cls) {
            try {
                return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
                return null;
            }
        }
    }

    public b(Context context) {
        super(context, "HslDb.sqlite", null, 2);
    }

    private Cursor a(String str, String[] strArr) {
        return this.f5287a.rawQuery(str, strArr);
    }

    private <T extends a> Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(ConditionNode conditionNode, Cursor cursor, T t) {
        HashMap hashMap;
        try {
            int count = cursor.getCount();
            HashMap hashMap2 = new HashMap();
            Long valueOf = Long.valueOf(0);
            int i = 0;
            if (count != 0 && cursor.moveToFirst()) {
                int i2 = 0;
                while (true) {
                    Pair<HashMap<String, HashMap<Object, Integer>>, Long> a2 = t.a(conditionNode, cursor, hashMap2);
                    hashMap = (HashMap) a2.first;
                    if (((Long) a2.second).longValue() != 0) {
                        if (i == 0) {
                            valueOf = (Long) a2.second;
                        }
                        i++;
                    }
                    if (i2 == 0) {
                        i2++;
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    hashMap2 = hashMap;
                }
                hashMap2 = hashMap;
            }
            return new Pair<>(hashMap2, new Pair(Integer.valueOf(i), valueOf));
        } finally {
            cursor.close();
        }
    }

    public static b a() {
        if (f5286b == null) {
            HSLLogger.e("Did you forgot to call DBHelper.init() ?");
        }
        return f5286b;
    }

    public static void a(Context context) {
        f5286b = new b(context);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        String a2 = c.a();
        HSLLogger.d("Query: " + a2);
        sQLiteDatabase.execSQL(a2);
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        String c2 = c.c();
        HSLLogger.d("Query: " + c2);
        sQLiteDatabase.execSQL(c2);
    }

    public int a(String str) {
        return a(str, (String) null, (String[]) null);
    }

    public int a(String str, String str2, String... strArr) {
        int length = strArr == null ? 0 : strArr.length;
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("DELETE FROM ", str);
        outline78.append(HSLUtils.isSet(str2) ? GeneratedOutlineSupport.outline52(" WHERE ", str2, CMap.SPACE) : "");
        StringBuilder sb = new StringBuilder(outline78.toString());
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
        }
        HSLLogger.d(sb.toString());
        SQLiteDatabase sQLiteDatabase = this.f5287a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return 0;
        }
        return this.f5287a.delete(str, str2, strArr);
    }

    public long a(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f5287a;
        long j = -1;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return -1;
        }
        this.f5287a.beginTransaction();
        try {
            j = this.f5287a.insert(str, null, contentValues);
            this.f5287a.setTransactionSuccessful();
        } catch (Throwable th) {
            this.f5287a.endTransaction();
            throw th;
        }
        this.f5287a.endTransaction();
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r4 != null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r4 != null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends io.hansel.segments.s.a> android.util.Pair<java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.Object, java.lang.Integer>>, android.util.Pair<java.lang.Integer, java.lang.Long>> a(io.hansel.core.criteria.node.ConditionNode r2, java.lang.Class<T> r3, java.lang.String r4, java.lang.String... r5) {
        /*
            r1 = this;
            r0 = 0
            android.database.Cursor r4 = r1.a(r4, r5)     // Catch:{ all -> 0x0020 }
            io.hansel.segments.s.b$b r5 = new io.hansel.segments.s.b$b     // Catch:{ all -> 0x001e }
            r5.<init>()     // Catch:{ all -> 0x001e }
            if (r4 != 0) goto L_0x000d
            goto L_0x0018
        L_0x000d:
            java.lang.Object r3 = r5.a(r3)     // Catch:{ all -> 0x001e }
            io.hansel.segments.s.a r3 = (io.hansel.segments.s.a) r3     // Catch:{ all -> 0x001e }
            android.util.Pair r2 = r1.a(r2, r4, (T) r3)     // Catch:{ all -> 0x001e }
            r0 = r2
        L_0x0018:
            if (r4 == 0) goto L_0x0028
        L_0x001a:
            r4.close()
            goto L_0x0028
        L_0x001e:
            r2 = move-exception
            goto L_0x0022
        L_0x0020:
            r2 = move-exception
            r4 = r0
        L_0x0022:
            io.hansel.core.logger.HSLLogger.printStackTrace(r2)     // Catch:{ all -> 0x0029 }
            if (r4 == 0) goto L_0x0028
            goto L_0x001a
        L_0x0028:
            return r0
        L_0x0029:
            r2 = move-exception
            if (r4 == 0) goto L_0x002f
            r4.close()
        L_0x002f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.segments.s.b.a(io.hansel.core.criteria.node.ConditionNode, java.lang.Class, java.lang.String, java.lang.String[]):android.util.Pair");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            HSLLogger.d("onUpgrade HslEvDb: " + i + "   " + i2, LogGroup.OT);
            if (i != 1) {
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                return;
            }
            c.a(sQLiteDatabase);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }
}
