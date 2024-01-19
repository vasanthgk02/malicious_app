package com.netcore.android.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.netcore.android.geofence.c;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeoFenceGroupTable.kt */
public final class f extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f1047d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    public final String f1048b = f.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final c f1049c;

    /* compiled from: SMTGeoFenceGroupTable.kt */
    public static final class a {
        public a() {
        }

        public final c a(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            c cVar = new c();
            String string = cursor.getString(cursor.getColumnIndex("groupId"));
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…FenceTable.KEY_GROUP_ID))");
            cVar.d(string);
            String string2 = cursor.getString(cursor.getColumnIndex("groupName"));
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…oupTable.KEY_GROUP_NAME))");
            cVar.e(string2);
            cVar.a(cursor.getInt(cursor.getColumnIndex("dwellTime")));
            String string3 = cursor.getString(cursor.getColumnIndex("startTime"));
            Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(cursor.…oupTable.KEY_START_TIME))");
            cVar.f(string3);
            String string4 = cursor.getString(cursor.getColumnIndex("endTime"));
            Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(cursor.…GroupTable.KEY_END_TIME))");
            cVar.b(string4);
            String string5 = cursor.getString(cursor.getColumnIndex("frequencyType"));
            Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(cursor.…able.KEY_FREQUENCY_TYPE))");
            cVar.c(string5);
            String string6 = cursor.getString(cursor.getColumnIndex("updatedDate"));
            Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(cursor.…pTable.KEY_UPDATED_DATE))");
            cVar.g(string6);
            return cVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public f(c cVar) {
        // Intrinsics.checkNotNullParameter(cVar, "wrapper");
        super(cVar);
        this.f1049c = cVar;
    }

    private final void b() {
        try {
            this.f1049c.a((String) "DROP TABLE IF EXISTS geoFenceGroup");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final SQLiteStatement c() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1048b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getGeoFenceGroupCreateStatement()");
        SQLiteDatabase d2 = this.f1049c.d();
        if (d2 != null) {
            return d2.compileStatement("CREATE TABLE IF NOT EXISTS smtgeofencegroup ( groupId TEXT PRIMARY KEY, groupName TEXT NOT NULL, startTime TEXT, endTime TEXT, frequencyType TEXT, dwellTime INTEGER, createdDate TEXT, updatedDate TEXT  ) ");
        }
        return null;
    }

    public void a() {
        try {
            SQLiteStatement c2 = c();
            if (c2 != null) {
                c2.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
        if (r2 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (r2 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.netcore.android.geofence.c d(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "groupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.netcore.android.logger.SMTLogger r1 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r2 = r13.f1048b
            java.lang.String r3 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = "getGeoFenceGroupById()"
            r1.i(r2, r3)
            com.netcore.android.geofence.c r1 = new com.netcore.android.geofence.c
            r1.<init>()
            r2 = 0
            com.netcore.android.e.c r3 = r13.f1049c     // Catch:{ Exception -> 0x0066 }
            android.database.sqlite.SQLiteDatabase r4 = r3.d()     // Catch:{ Exception -> 0x0066 }
            if (r4 == 0) goto L_0x0035
            java.lang.String r5 = "smtgeofencegroup"
            r6 = 0
            java.lang.String r7 = " groupId = ? "
            r3 = 1
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0066 }
            r3 = 0
            r8[r3] = r14     // Catch:{ Exception -> 0x0066 }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r14 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0066 }
            r2 = r14
        L_0x0035:
            if (r2 == 0) goto L_0x0068
            boolean r14 = r2.moveToLast()     // Catch:{ Exception -> 0x0066 }
            if (r14 == 0) goto L_0x0068
        L_0x003d:
            int r14 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r14 = r2.getString(r14)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r3 = "it.getString(it.getColumnIndex(KEY_GROUP_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)     // Catch:{ Exception -> 0x0066 }
            r1.d(r14)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r14 = "groupName"
            int r14 = r2.getColumnIndex(r14)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r14 = r2.getString(r14)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r3 = "it.getString(it.getColumnIndex(KEY_GROUP_NAME))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)     // Catch:{ Exception -> 0x0066 }
            r1.e(r14)     // Catch:{ Exception -> 0x0066 }
            boolean r14 = r2.moveToPrevious()     // Catch:{ Exception -> 0x0066 }
            if (r14 != 0) goto L_0x003d
            goto L_0x0068
        L_0x0066:
            r14 = move-exception
            goto L_0x007d
        L_0x0068:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            r14.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r0 = "getGeoFenceGroupById: "
            r14.append(r0)     // Catch:{ Exception -> 0x0066 }
            r14.append(r1)     // Catch:{ Exception -> 0x0066 }
            r14.toString()     // Catch:{ Exception -> 0x0066 }
            if (r2 == 0) goto L_0x0085
            goto L_0x0082
        L_0x007b:
            r14 = move-exception
            goto L_0x0086
        L_0x007d:
            r14.printStackTrace()     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0085
        L_0x0082:
            r2.close()
        L_0x0085:
            return r1
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.close()
        L_0x008b:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.f.d(java.lang.String):com.netcore.android.geofence.c");
    }

    public final boolean e(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1048b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "isRecordExist()");
        try {
            SQLiteDatabase d2 = this.f1049c.d();
            if (d2 != null) {
                Cursor query = d2.query("smtgeofencegroup", null, " groupId = ? ", new String[]{str}, null, null, null, null);
                if (query != null) {
                    return query.moveToFirst();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public final void c(String str) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1048b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "deleteGeoFenceGroups()");
        if (str != null) {
            try {
                c cVar = this.f1049c;
                cVar.a((String) "smtgeofencegroup", "groupId NOT IN " + str, (String[]) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            this.f1049c.a((String) "smtgeofencegroup", (String) null, (String[]) null);
        }
    }

    public void a(int i, int i2) {
        if (i <= 4) {
            try {
                a();
                b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "geoFenceGroup");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1048b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "insertGeoFenceGroup()");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("groupId", cVar.f());
            contentValues.put("groupName", cVar.g());
            contentValues.put("startTime", cVar.h());
            contentValues.put("endTime", cVar.c());
            contentValues.put("frequencyType", cVar.d());
            contentValues.put("dwellTime", Integer.valueOf(cVar.b()));
            contentValues.put("createdDate", cVar.a());
            contentValues.put("updatedDate", cVar.i());
            if (!e(cVar.f())) {
                long a2 = this.f1049c.a((String) "smtgeofencegroup", (String) null, contentValues);
                String str2 = this.f1048b;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger.i(str2, "insertGeoFenceGroup() result insert " + a2);
                if (a2 == ((long) -1)) {
                    String str3 = this.f1048b;
                    Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                    sMTLogger.e(str3, "Geofence group record insertion failed");
                    return;
                }
                return;
            }
            c cVar2 = this.f1049c;
            int a3 = cVar2.a("smtgeofencegroup", contentValues, "groupId = ?", new String[]{cVar.f()});
            String str4 = this.f1048b;
            Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
            sMTLogger.i(str4, "insertGeoFenceGroup() result update " + a3);
            if (a3 == 0) {
                String str5 = this.f1048b;
                Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
                sMTLogger.e(str5, "None of the geofence group records got updated");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
