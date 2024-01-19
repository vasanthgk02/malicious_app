package com.netcore.android.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.geofence.b;
import com.netcore.android.geofence.c;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeoFenceTable.kt */
public final class g extends a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1050b = g.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final String f1051c = "geoFenceName";

    /* renamed from: d  reason: collision with root package name */
    public final String f1052d = "latitude";

    /* renamed from: e  reason: collision with root package name */
    public final String f1053e = "longitude";

    /* renamed from: f  reason: collision with root package name */
    public final String f1054f = "radius";
    public final String g = "dwellTime";
    public final String h = "createdDate";
    public final String i = "updatedDate";
    public final c j;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public g(c cVar) {
        // Intrinsics.checkNotNullParameter(cVar, "wrapper");
        super(cVar);
        this.j = cVar;
    }

    private final SQLiteStatement c() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1050b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getGeoFenceGroupCreateStatement()");
        SQLiteDatabase d2 = this.j.d();
        if (d2 == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE IF NOT EXISTS smtgeofence ( groupId TEXT, geoFenceId TEXT PRIMARY KEY, ");
        outline73.append(this.f1051c);
        outline73.append(" TEXT NOT NULL, ");
        outline73.append(this.f1052d);
        outline73.append(" REAL NOT NULL, ");
        outline73.append(this.f1053e);
        outline73.append(" REAL NOT NULL, ");
        outline73.append(this.f1054f);
        outline73.append(" INTEGER, ");
        outline73.append(this.g);
        outline73.append(" INTEGER, ");
        outline73.append(this.h);
        outline73.append(" TEXT, ");
        GeneratedOutlineSupport.outline103(outline73, this.i, " TEXT, ", "FOREIGN KEY (", "groupId");
        GeneratedOutlineSupport.outline103(outline73, ") REFERENCES ", "smtgeofencegroup", "(", "groupId");
        outline73.append(")");
        outline73.append(" ) ");
        return d2.compileStatement(outline73.toString());
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0084 A[Catch:{ Exception -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> b(java.util.List<java.lang.String> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ids"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = r14.f1050b
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "getGeofenceByIds() "
            r0.i(r1, r2)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            com.netcore.android.e.c r1 = r14.j     // Catch:{ Exception -> 0x0088 }
            android.database.sqlite.SQLiteDatabase r2 = r1.d()     // Catch:{ Exception -> 0x0088 }
            if (r2 == 0) goto L_0x004f
            java.lang.String r3 = "smtgeofence as A , smtgeofencegroup as B"
            r4 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0088 }
            r1.<init>()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r5 = "A.groupId = B.groupId AND A.geoFenceId in ("
            r1.append(r5)     // Catch:{ Exception -> 0x0088 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r6 = r15
            java.lang.String r15 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0088 }
            r1.append(r15)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r15 = ") "
            r1.append(r15)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0088 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r15 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0050
        L_0x004f:
            r15 = 0
        L_0x0050:
            if (r15 == 0) goto L_0x0082
            boolean r1 = r15.moveToLast()     // Catch:{ Exception -> 0x0088 }
            if (r1 == 0) goto L_0x0082
        L_0x0058:
            com.netcore.android.geofence.h r1 = new com.netcore.android.geofence.h     // Catch:{ Exception -> 0x0088 }
            r1.<init>()     // Catch:{ Exception -> 0x0088 }
            com.netcore.android.geofence.b r2 = r14.a(r15)     // Catch:{ Exception -> 0x0088 }
            com.netcore.android.e.f$a r3 = com.netcore.android.e.f.f1047d     // Catch:{ Exception -> 0x0088 }
            com.netcore.android.geofence.c r3 = r3.a(r15)     // Catch:{ Exception -> 0x0088 }
            r1.a(r3)     // Catch:{ Exception -> 0x0088 }
            r1.a(r2)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r2 = r2.b()     // Catch:{ Exception -> 0x0088 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0088 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0088 }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0088 }
            boolean r1 = r15.moveToPrevious()     // Catch:{ Exception -> 0x0088 }
            if (r1 != 0) goto L_0x0058
        L_0x0082:
            if (r15 == 0) goto L_0x008c
            r15.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r15 = move-exception
            r15.printStackTrace()
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.g.b(java.util.List):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        if (r2 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        if (r2 == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.netcore.android.geofence.b d(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "geoFenceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.netcore.android.logger.SMTLogger r1 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r2 = r12.f1050b
            java.lang.String r3 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r3 = "getGeoFenceById()"
            r1.i(r2, r3)
            com.netcore.android.geofence.b r1 = new com.netcore.android.geofence.b
            r1.<init>()
            r2 = 0
            com.netcore.android.e.c r3 = r12.j     // Catch:{ all -> 0x0077 }
            android.database.sqlite.SQLiteDatabase r4 = r3.d()     // Catch:{ all -> 0x0077 }
            if (r4 == 0) goto L_0x0034
            java.lang.String r5 = "smtgeofence"
            r6 = 0
            java.lang.String r7 = " geoFenceId =? "
            r3 = 1
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ all -> 0x0077 }
            r3 = 0
            r8[r3] = r13     // Catch:{ all -> 0x0077 }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r13 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0077 }
            r2 = r13
        L_0x0034:
            if (r2 == 0) goto L_0x0079
            boolean r13 = r2.moveToLast()     // Catch:{ all -> 0x0077 }
            if (r13 == 0) goto L_0x0079
        L_0x003c:
            int r13 = r2.getColumnIndex(r0)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r2.getString(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "cursor.getString(cursor.…mnIndex(KEY_GEOFENCE_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch:{ all -> 0x0077 }
            r1.b(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = "groupId"
            int r13 = r2.getColumnIndex(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r2.getString(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "cursor.getString(cursor.…olumnIndex(KEY_GROUP_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch:{ all -> 0x0077 }
            r1.d(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r12.f1051c     // Catch:{ all -> 0x0077 }
            int r13 = r2.getColumnIndex(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r2.getString(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "cursor.getString(cursor.…Index(KEY_GEOFENCE_NAME))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch:{ all -> 0x0077 }
            r1.c(r13)     // Catch:{ all -> 0x0077 }
            boolean r13 = r2.moveToPrevious()     // Catch:{ all -> 0x0077 }
            if (r13 != 0) goto L_0x003c
            goto L_0x0079
        L_0x0077:
            r13 = move-exception
            goto L_0x0081
        L_0x0079:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ all -> 0x0077 }
        L_0x007e:
            if (r2 == 0) goto L_0x0089
            goto L_0x0086
        L_0x0081:
            r13.printStackTrace()     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0089
        L_0x0086:
            r2.close()
        L_0x0089:
            return r1
        L_0x008a:
            r13 = move-exception
            if (r2 == 0) goto L_0x0090
            r2.close()
        L_0x0090:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.g.d(java.lang.String):com.netcore.android.geofence.b");
    }

    public final boolean e(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1050b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "isRecordExist()");
        Cursor cursor = null;
        try {
            SQLiteDatabase d2 = this.j.d();
            if (d2 != null) {
                cursor = d2.query("smtgeofence", null, " geoFenceId =? ", new String[]{str}, null, null, null);
            }
            if (cursor != null) {
                boolean moveToFirst = cursor.moveToFirst();
                cursor.close();
                return moveToFirst;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return false;
    }

    public void a(int i2, int i3) {
        if (i2 <= 4) {
            try {
                a();
                b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final void a(c cVar, b bVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("groupId", cVar.f());
            contentValues.put("geoFenceId", bVar.b());
            contentValues.put(this.f1051c, bVar.c());
            contentValues.put(this.f1052d, bVar.e());
            contentValues.put(this.f1053e, bVar.f());
            contentValues.put(this.f1054f, bVar.g());
            contentValues.put(this.g, Integer.valueOf(cVar.b()));
            contentValues.put(this.h, bVar.a());
            contentValues.put(this.i, bVar.h());
            if (!e(bVar.b().toString())) {
                long a2 = this.j.a((String) "smtgeofence", (String) null, contentValues);
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1050b;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.i(str, "getGeoFenceGroupCreateStatement() insert result " + a2);
                if (a2 == ((long) -1)) {
                    String str2 = this.f1050b;
                    Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                    sMTLogger.e(str2, "Geofence record insertion failed");
                    return;
                }
                return;
            }
            c cVar2 = this.j;
            int a3 = cVar2.a("smtgeofence", contentValues, "geoFenceId = ?", new String[]{bVar.b()});
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = this.f1050b;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.i(str3, "getGeoFenceGroupCreateStatement() insert update " + a3);
            if (a3 == 0) {
                String str4 = this.f1050b;
                Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                sMTLogger2.e(str4, "None of the geofence records got updated");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c(String str) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1050b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "deleteGeoFences()");
        if (str != null) {
            try {
                c cVar = this.j;
                int a2 = cVar.a((String) "smtgeofence", "geoFenceId NOT IN " + str, (String[]) null);
                String str3 = this.f1050b;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger.i(str3, "deleteGeoFences() result " + a2 + ' ');
            } catch (Throwable th) {
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str4 = this.f1050b;
                StringBuilder outline79 = GeneratedOutlineSupport.outline79(str4, UeCustomType.TAG, "msg: ");
                outline79.append(th.getLocalizedMessage());
                sMTLogger2.i(str4, outline79.toString());
            }
        } else {
            int a3 = this.j.a((String) "smtgeofence", (String) null, (String[]) null);
            String str5 = this.f1050b;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            sMTLogger.i(str5, "deleteGeoFences() result " + a3 + ' ');
        }
    }

    private final void b() {
        try {
            this.j.a((String) "DROP TABLE IF EXISTS geoFence");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final b a(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1050b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "setCursorData()");
        b bVar = new b();
        String string = cursor.getString(cursor.getColumnIndex("geoFenceId"));
        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…mnIndex(KEY_GEOFENCE_ID))");
        bVar.b(string);
        String string2 = cursor.getString(cursor.getColumnIndex(this.f1051c));
        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…Index(KEY_GEOFENCE_NAME))");
        bVar.c(string2);
        String string3 = cursor.getString(cursor.getColumnIndex(this.f1052d));
        Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(cursor.…olumnIndex(KEY_LATITUDE))");
        bVar.e(string3);
        String string4 = cursor.getString(cursor.getColumnIndex(this.f1053e));
        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(cursor.…lumnIndex(KEY_LONGITUDE))");
        bVar.f(string4);
        String string5 = cursor.getString(cursor.getColumnIndex(this.f1054f));
        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(cursor.…tColumnIndex(KEY_RADIUS))");
        bVar.g(string5);
        String string6 = cursor.getString(cursor.getColumnIndex(this.h));
        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(cursor.…nIndex(KEY_CREATED_DATE))");
        bVar.a(string6);
        String string7 = cursor.getString(cursor.getColumnIndex(this.i));
        Intrinsics.checkNotNullExpressionValue(string7, "cursor.getString(cursor.…nIndex(KEY_UPDATED_DATE))");
        bVar.h(string7);
        return bVar;
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [double] */
    /* JADX WARNING: type inference failed for: r4v0, types: [double] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.util.LinkedHashMap] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.util.Map<java.lang.Integer, com.netcore.android.geofence.h>] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r4v9, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: type inference failed for: r20v4 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r20v5 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v2
      assigns: []
      uses: []
      mth insns count: 105
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.netcore.android.geofence.h> a(double r22, double r24) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r4 = r24
            java.lang.String r0 = ")*("
            java.lang.String r6 = " AND "
            java.lang.String r7 = " BETWEEN "
            java.lang.String r8 = " - A."
            com.netcore.android.logger.SMTLogger r9 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r10 = r1.f1050b
            java.lang.String r11 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.String r11 = "getNearByGeofence()"
            r9.i(r10, r11)
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            com.netcore.android.utility.SMTCommonUtility r10 = com.netcore.android.utility.SMTCommonUtility.INSTANCE     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = r10.getUTCDateTime$smartech_release()     // Catch:{ Exception -> 0x012e }
            com.netcore.android.e.c r11 = r1.j     // Catch:{ Exception -> 0x012e }
            android.database.sqlite.SQLiteDatabase r12 = r11.d()     // Catch:{ Exception -> 0x012e }
            if (r12 == 0) goto L_0x00e5
            java.lang.String r13 = "smtgeofence as A inner join smtgeofencegroup as B on A.groupId == B.groupId"
            r14 = 0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r11.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r15 = "B.startTime < '"
            r11.append(r15)     // Catch:{ Exception -> 0x012e }
            r11.append(r10)     // Catch:{ Exception -> 0x012e }
            java.lang.String r15 = "' AND B.endTime > '"
            r11.append(r15)     // Catch:{ Exception -> 0x012e }
            r11.append(r10)     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = "' "
            r11.append(r10)     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = " AND A."
            r11.append(r10)     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = r1.f1052d     // Catch:{ Exception -> 0x012e }
            r11.append(r10)     // Catch:{ Exception -> 0x012e }
            r11.append(r7)     // Catch:{ Exception -> 0x012e }
            r15 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            r20 = r9
            double r9 = r2 - r15
            r11.append(r9)     // Catch:{ Exception -> 0x0120 }
            r11.append(r6)     // Catch:{ Exception -> 0x0120 }
            double r9 = r2 + r15
            r11.append(r9)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = " AND  A."
            r11.append(r9)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = r1.f1053e     // Catch:{ Exception -> 0x0120 }
            r11.append(r9)     // Catch:{ Exception -> 0x0120 }
            r11.append(r7)     // Catch:{ Exception -> 0x0120 }
            double r9 = r4 - r15
            r11.append(r9)     // Catch:{ Exception -> 0x0120 }
            r11.append(r6)     // Catch:{ Exception -> 0x0120 }
            double r6 = r4 + r15
            r11.append(r6)     // Catch:{ Exception -> 0x0120 }
            r6 = 32
            r11.append(r6)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r15 = r11.toString()     // Catch:{ Exception -> 0x0120 }
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            r6.<init>()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r7 = "(("
            r6.append(r7)     // Catch:{ Exception -> 0x0120 }
            r6.append(r2)     // Catch:{ Exception -> 0x0120 }
            r6.append(r8)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r7 = r1.f1052d     // Catch:{ Exception -> 0x0120 }
            r6.append(r7)     // Catch:{ Exception -> 0x0120 }
            r6.append(r0)     // Catch:{ Exception -> 0x0120 }
            r6.append(r2)     // Catch:{ Exception -> 0x0120 }
            r6.append(r8)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = r1.f1052d     // Catch:{ Exception -> 0x0120 }
            r6.append(r2)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = ") + ("
            r6.append(r2)     // Catch:{ Exception -> 0x0120 }
            r6.append(r4)     // Catch:{ Exception -> 0x0120 }
            r6.append(r8)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = r1.f1053e     // Catch:{ Exception -> 0x0120 }
            r6.append(r2)     // Catch:{ Exception -> 0x0120 }
            r6.append(r0)     // Catch:{ Exception -> 0x0120 }
            r6.append(r4)     // Catch:{ Exception -> 0x0120 }
            r6.append(r8)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r0 = r1.f1053e     // Catch:{ Exception -> 0x0120 }
            r6.append(r0)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r0 = ")) ASC LIMIT 98"
            r6.append(r0)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r19 = r6.toString()     // Catch:{ Exception -> 0x0120 }
            android.database.Cursor r0 = r12.query(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x0120 }
            goto L_0x00e8
        L_0x00e5:
            r20 = r9
            r0 = 0
        L_0x00e8:
            if (r0 == 0) goto L_0x0124
            boolean r2 = r0.moveToLast()     // Catch:{ Exception -> 0x0120 }
            if (r2 == 0) goto L_0x0124
        L_0x00f0:
            com.netcore.android.geofence.h r2 = new com.netcore.android.geofence.h     // Catch:{ Exception -> 0x0120 }
            r2.<init>()     // Catch:{ Exception -> 0x0120 }
            com.netcore.android.geofence.b r3 = r1.a(r0)     // Catch:{ Exception -> 0x0120 }
            com.netcore.android.e.f$a r4 = com.netcore.android.e.f.f1047d     // Catch:{ Exception -> 0x0120 }
            com.netcore.android.geofence.c r4 = r4.a(r0)     // Catch:{ Exception -> 0x0120 }
            r2.a(r4)     // Catch:{ Exception -> 0x0120 }
            r2.a(r3)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r3 = r3.b()     // Catch:{ Exception -> 0x0120 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0120 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0120 }
            r4 = r20
            r4.put(r3, r2)     // Catch:{ Exception -> 0x012c }
            boolean r2 = r0.moveToPrevious()     // Catch:{ Exception -> 0x012c }
            if (r2 != 0) goto L_0x011d
            goto L_0x0126
        L_0x011d:
            r20 = r4
            goto L_0x00f0
        L_0x0120:
            r0 = move-exception
            r4 = r20
            goto L_0x0130
        L_0x0124:
            r4 = r20
        L_0x0126:
            if (r0 == 0) goto L_0x0133
            r0.close()     // Catch:{ Exception -> 0x012c }
            goto L_0x0133
        L_0x012c:
            r0 = move-exception
            goto L_0x0130
        L_0x012e:
            r0 = move-exception
            r4 = r9
        L_0x0130:
            r0.printStackTrace()
        L_0x0133:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.g.a(double, double):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[Catch:{ Exception -> 0x00a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> a(java.util.List<java.lang.String> r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "ids"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r1.f1050b
            java.lang.String r4 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = "getDeletedGroupGeofenceIds() "
            r0.i(r3, r4)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.netcore.android.e.c r0 = r1.j     // Catch:{ Exception -> 0x00a0 }
            android.database.sqlite.SQLiteDatabase r4 = r0.d()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r0 = "geoFenceId"
            if (r4 == 0) goto L_0x007c
            java.lang.String r5 = "smtgeofence"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x00a0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0 }
            r7.<init>()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r8 = " groupId in ("
            r7.append(r8)     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0 }
            r9.<init>()     // Catch:{ Exception -> 0x00a0 }
            java.util.Iterator r2 = r18.iterator()     // Catch:{ Exception -> 0x00a0 }
        L_0x003f:
            boolean r8 = r2.hasNext()     // Catch:{ Exception -> 0x00a0 }
            if (r8 == 0) goto L_0x005b
            java.lang.Object r8 = r2.next()     // Catch:{ Exception -> 0x00a0 }
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x00a0 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a0 }
            if (r10 <= 0) goto L_0x0054
            r10 = 1
            goto L_0x0055
        L_0x0054:
            r10 = 0
        L_0x0055:
            if (r10 == 0) goto L_0x003f
            r9.add(r8)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x003f
        L_0x005b:
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 63
            java.lang.String r2 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x00a0 }
            r7.append(r2)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r2 = ") "
            r7.append(r2)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00a0 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x007d
        L_0x007c:
            r2 = 0
        L_0x007d:
            if (r2 == 0) goto L_0x009a
            boolean r4 = r2.moveToLast()     // Catch:{ Exception -> 0x00a0 }
            if (r4 == 0) goto L_0x009a
        L_0x0085:
            int r4 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x00a0 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00a0 }
            r3.add(r4)     // Catch:{ Exception -> 0x00a0 }
            boolean r4 = r2.moveToPrevious()     // Catch:{ Exception -> 0x00a0 }
            if (r4 != 0) goto L_0x0085
        L_0x009a:
            if (r2 == 0) goto L_0x00a4
            r2.close()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.g.a(java.util.List):java.util.List");
    }

    public final void a(c cVar, ArrayList<b> arrayList) {
        Intrinsics.checkNotNullParameter(cVar, "geoFenceGroup");
        Intrinsics.checkNotNullParameter(arrayList, "geoFences");
        try {
            for (b a2 : arrayList) {
                a(cVar, a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
