package com.netcore.android.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.logger.SMTLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: SMTEventTable.kt */
public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public final String f1042b = e.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final String f1043c = "id";

    /* renamed from: d  reason: collision with root package name */
    public final String f1044d = SMTEventParamKeys.SMT_EVENT_ID;

    /* renamed from: e  reason: collision with root package name */
    public final String f1045e = "eventName";

    /* renamed from: f  reason: collision with root package name */
    public final String f1046f = "payload";
    public final String g = "time";
    public final String h = "type";
    public final String i = "payload_encrypted";
    public final String j = "retry_count";
    public final String k = "event";
    public final c l;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public e(c cVar) {
        // Intrinsics.checkNotNullParameter(cVar, "wrapper");
        super(cVar);
        this.l = cVar;
    }

    private final SQLiteStatement b() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getEventTableCreateStatement()");
        SQLiteDatabase d2 = this.l.d();
        if (d2 == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE IF NOT EXISTS ");
        outline73.append(this.k);
        outline73.append(" ( ");
        outline73.append(this.f1043c);
        outline73.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline73.append(this.f1044d);
        outline73.append(" INTEGER,");
        outline73.append(this.f1045e);
        outline73.append(" TEXT,");
        outline73.append(this.f1046f);
        outline73.append(" BLOB,");
        outline73.append(this.g);
        outline73.append(" LONG NOT NULL,");
        GeneratedOutlineSupport.outline103(outline73, this.h, " TEXT,", "syncStatus", " INTEGER NOT NULL DEFAULT 0,");
        outline73.append(this.i);
        outline73.append(" INTEGER NOT NULL DEFAULT 0,");
        outline73.append(this.j);
        outline73.append(" INTEGER NOT NULL DEFAULT 0");
        outline73.append(" ) ");
        return d2.compileStatement(outline73.toString());
    }

    private final void c(String str) {
        try {
            SQLiteDatabase d2 = this.l.d();
            Cursor query = d2 != null ? d2.query(str, null, null, null, null, null, null) : null;
            if (query != null) {
                while (query.moveToNext()) {
                    int i2 = query.getInt(query.getColumnIndex(this.f1044d));
                    String string = query.getString(query.getColumnIndex(this.f1045e));
                    String string2 = query.getString(query.getColumnIndex(this.f1046f));
                    long j2 = query.getLong(query.getColumnIndex(this.g));
                    String string3 = query.getString(query.getColumnIndex(this.h));
                    int i3 = query.getInt(query.getColumnIndex("syncStatus"));
                    Intrinsics.checkNotNullExpressionValue(string2, "payload");
                    int d3 = d(string2);
                    SMTLogger sMTLogger = SMTLogger.INSTANCE;
                    String str2 = this.f1042b;
                    Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                    sMTLogger.i(str2, "plain payload value " + string2 + ' ');
                    byte[] bytes = string2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    Integer valueOf = Integer.valueOf(i2);
                    Intrinsics.checkNotNullExpressionValue(string3, "eventType");
                    a(valueOf, string, bytes, i3, j2, string3, d3);
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception unused) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.e(str3, "error migrating data from old table to new table");
        }
    }

    private final void d() {
        String outline62;
        boolean z;
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "upgradeTableFromSixToVersionSeven()");
        SQLiteStatement sQLiteStatement = null;
        try {
            String str2 = "ALTER TABLE " + this.k + " RENAME TO " + outline62;
            SQLiteDatabase d2 = this.l.d();
            SQLiteStatement compileStatement = d2 != null ? d2.compileStatement(str2) : null;
            if (compileStatement != null) {
                compileStatement.execute();
            }
            z = true;
        } catch (Exception e2) {
            SMTLogger.INSTANCE.e(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1042b, " error changing name of old table "), TweetUtils.stackTraceToString(e2));
            z = false;
        }
        if (z) {
            try {
                a();
            } catch (Exception e3) {
                SMTLogger.INSTANCE.e(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1042b, " error creating new table "), TweetUtils.stackTraceToString(e3));
            }
            c(outline62);
            try {
                String str3 = "DROP TABLE IF EXISTS " + outline62;
                SQLiteDatabase d3 = this.l.d();
                if (d3 != null) {
                    sQLiteStatement = d3.compileStatement(str3);
                }
                if (sQLiteStatement != null) {
                    sQLiteStatement.execute();
                }
            } catch (Exception e4) {
                SMTLogger.INSTANCE.e(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1042b, " error deleting old table"), TweetUtils.stackTraceToString(e4));
            }
        } else {
            try {
                String str4 = "DROP TABLE IF EXISTS " + this.k;
                SQLiteDatabase d4 = this.l.d();
                if (d4 != null) {
                    sQLiteStatement = d4.compileStatement(str4);
                }
                if (sQLiteStatement != null) {
                    sQLiteStatement.execute();
                }
            } catch (Exception e5) {
                SMTLogger.INSTANCE.e(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1042b, " error deleting old table"), TweetUtils.stackTraceToString(e5));
            }
            try {
                a();
            } catch (Exception e6) {
                SMTLogger.INSTANCE.e(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1042b, " error creating new table "), TweetUtils.stackTraceToString(e6));
            }
        }
    }

    public void a() {
        try {
            SQLiteStatement b2 = b();
            if (b2 != null) {
                b2.execute();
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1042b;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
    }

    public final void a(Integer num, String str, String str2, String str3) {
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "payload");
        Intrinsics.checkNotNullParameter(str3, "type");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str5 = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
        sMTLogger.i(str5, "insertEvent()");
        byte[] bytes = str4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        a(this, Integer.valueOf(num != null ? num.intValue() : 0), str != null ? str : "", bytes, 1, System.currentTimeMillis(), str3, 0, 64, null);
    }

    public static /* synthetic */ void a(e eVar, Integer num, String str, byte[] bArr, int i2, long j2, String str2, int i3, int i4, Object obj) {
        eVar.a(num, str, bArr, i2, j2, str2, (i4 & 64) != 0 ? 0 : i3);
    }

    private final void a(Integer num, String str, byte[] bArr, int i2, long j2, String str2, int i3) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str3 = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
        sMTLogger.i(str3, "insertEvent()");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(this.f1044d, Integer.valueOf(num != null ? num.intValue() : 0));
            String str4 = this.f1045e;
            if (str == null) {
                str = "";
            }
            contentValues.put(str4, str);
            contentValues.put(this.g, Long.valueOf(j2));
            contentValues.put(this.h, str2);
            contentValues.put("syncStatus", Integer.valueOf(i2));
            contentValues.put(this.j, Integer.valueOf(i3));
            Boolean e2 = this.l.e();
            Boolean bool = Boolean.TRUE;
            byte[] b2 = (!Intrinsics.areEqual(e2, bool) || VERSION.SDK_INT < 23) ? null : this.l.b(bArr);
            if (!Intrinsics.areEqual(e2, bool) || b2 == null) {
                contentValues.put(this.f1046f, bArr);
            } else {
                contentValues.put(this.i, Integer.valueOf(1));
                contentValues.put(this.f1046f, b2);
            }
            long a2 = this.l.a(this.k, (String) null, contentValues);
            String str5 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            sMTLogger.i(str5, "insertEvent() result " + a2);
        } catch (Exception e3) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str6 = this.f1042b;
            GeneratedOutlineSupport.outline96(str6, UeCustomType.TAG, e3, sMTLogger2, str6);
        }
    }

    public void b(int i2, int i3) {
        if (i2 < 7) {
            d();
        }
    }

    public final HashMap<String, String> b(int i2) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getInProgressEventsMapWithSize()");
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase d2 = this.l.d();
            if (d2 != null) {
                cursor = d2.query(this.k, null, " syncStatus = ? ", new String[]{"2"}, null, null, null);
            }
            if (cursor != null) {
                if (cursor.getCount() >= 1) {
                    HashMap<String, String> a2 = a(cursor, i2);
                    cursor.close();
                    return a2;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger2.e(str2, String.valueOf(e2.getMessage()));
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
        if (r1 == null) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r12 = this;
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = r12.f1042b
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r3 = "updateFailedBatchPayload()"
            r0.i(r1, r3)
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.String r1 = r12.f1043c
            r11 = 0
            r5[r11] = r1
            java.lang.String r1 = "4"
            java.lang.String[] r7 = new java.lang.String[]{r1}
            r1 = 0
            com.netcore.android.e.c r3 = r12.l     // Catch:{ Exception -> 0x0031 }
            android.database.sqlite.SQLiteDatabase r3 = r3.d()     // Catch:{ Exception -> 0x0031 }
            if (r3 == 0) goto L_0x0033
            java.lang.String r4 = r12.k     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = " syncStatus =? "
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            r0 = move-exception
            goto L_0x0098
        L_0x0033:
            if (r1 == 0) goto L_0x0090
            int r3 = r1.getCount()     // Catch:{ Exception -> 0x0031 }
            if (r3 >= r0) goto L_0x003c
            goto L_0x0090
        L_0x003c:
            boolean r3 = r1.moveToNext()     // Catch:{ Exception -> 0x0031 }
            if (r3 == 0) goto L_0x00ac
            java.lang.String r3 = r12.f1043c     // Catch:{ Exception -> 0x0031 }
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0031 }
            int r3 = r1.getInt(r3)     // Catch:{ Exception -> 0x0031 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0031 }
            r4.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = r12.j     // Catch:{ Exception -> 0x0031 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0031 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0031 }
            com.netcore.android.e.c r5 = r12.l     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r12.k     // Catch:{ Exception -> 0x0031 }
            java.lang.String r7 = " id = ? "
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0031 }
            java.lang.String r9 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0031 }
            r8[r11] = r9     // Catch:{ Exception -> 0x0031 }
            int r4 = r5.a(r6, r4, r7, r8)     // Catch:{ Exception -> 0x0031 }
            com.netcore.android.logger.SMTLogger r5 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r12.f1042b     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch:{ Exception -> 0x0031 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r7.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r8 = "update retry count for event id "
            r7.append(r8)     // Catch:{ Exception -> 0x0031 }
            r7.append(r3)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = " : result "
            r7.append(r3)     // Catch:{ Exception -> 0x0031 }
            r7.append(r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x0031 }
            r5.i(r6, r3)     // Catch:{ Exception -> 0x0031 }
            goto L_0x003c
        L_0x0090:
            if (r1 == 0) goto L_0x0095
            r1.close()
        L_0x0095:
            return
        L_0x0096:
            r0 = move-exception
            goto L_0x00b0
        L_0x0098:
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = r12.f1042b     // Catch:{ all -> 0x0096 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0096 }
            r3.e(r4, r0)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x00af
        L_0x00ac:
            r1.close()
        L_0x00af:
            return
        L_0x00b0:
            if (r1 == 0) goto L_0x00b5
            r1.close()
        L_0x00b5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.e.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if (r0 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
        if (r0 == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(int r12) {
        /*
            r11 = this;
            com.netcore.android.logger.SMTLogger r12 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r0 = r11.f1042b
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "isMoreEventsPresentForProcessing()"
            r12.i(r0, r2)
            r0 = 0
            com.netcore.android.e.c r2 = r11.l     // Catch:{ Exception -> 0x005a }
            android.database.sqlite.SQLiteDatabase r3 = r2.d()     // Catch:{ Exception -> 0x005a }
            if (r3 == 0) goto L_0x002b
            java.lang.String r4 = r11.k     // Catch:{ Exception -> 0x005a }
            r5 = 0
            java.lang.String r6 = " syncStatus = ?  OR  syncStatus = ? "
            java.lang.String r2 = "1"
            java.lang.String r7 = "4"
            java.lang.String[] r7 = new java.lang.String[]{r2, r7}     // Catch:{ Exception -> 0x005a }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x005a }
        L_0x002b:
            if (r0 == 0) goto L_0x0055
            java.lang.String r2 = r11.f1042b     // Catch:{ Exception -> 0x005a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ Exception -> 0x005a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005a }
            r3.<init>()     // Catch:{ Exception -> 0x005a }
            java.lang.String r4 = "Event count is "
            r3.append(r4)     // Catch:{ Exception -> 0x005a }
            int r4 = r0.getCount()     // Catch:{ Exception -> 0x005a }
            r3.append(r4)     // Catch:{ Exception -> 0x005a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005a }
            r12.internal(r2, r3)     // Catch:{ Exception -> 0x005a }
            int r12 = r0.getCount()     // Catch:{ Exception -> 0x005a }
            if (r12 <= 0) goto L_0x0055
            r0.close()
            r12 = 1
            return r12
        L_0x0055:
            if (r0 == 0) goto L_0x0072
            goto L_0x006f
        L_0x0058:
            r12 = move-exception
            goto L_0x0074
        L_0x005a:
            r12 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r11.f1042b     // Catch:{ all -> 0x0058 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x0058 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0058 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0058 }
            r2.e(r3, r12)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0072
        L_0x006f:
            r0.close()
        L_0x0072:
            r12 = 0
            return r12
        L_0x0074:
            if (r0 == 0) goto L_0x0079
            r0.close()
        L_0x0079:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.e.d(int):boolean");
    }

    public final void a(Integer[] numArr, String str, int i2) {
        Intrinsics.checkNotNullParameter(numArr, "rowIds");
        Intrinsics.checkNotNullParameter(str, "columnName");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "updateMultipleRowsWithSameColumnValue()");
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, Integer.valueOf(i2));
        this.l.b();
        try {
            for (Integer intValue : numArr) {
                int intValue2 = intValue.intValue();
                int a2 = this.l.a(this.k, contentValues, ' ' + this.f1043c + " = ? ", new String[]{String.valueOf(intValue2)});
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str3 = this.f1042b;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger2.i(str3, "updateMultipleRowsWithSameColumnValue() result " + a2);
            }
            this.l.f();
        } catch (Exception e2) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str4 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
            sMTLogger3.e(str4, "Error while updating multiple events " + e2);
        } catch (Throwable th) {
            this.l.c();
            throw th;
        }
        this.l.c();
    }

    private final int d(String str) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "getRetryCountFromPayloadIfExist()");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(SMTEventParamKeys.SMT_RETRY)) {
                Object obj = jSONObject.get(SMTEventParamKeys.SMT_RETRY);
                if (obj != null) {
                    int intValue = ((Integer) obj).intValue();
                    String str3 = this.f1042b;
                    Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                    sMTLogger.i(str3, "retryCount " + intValue);
                    return intValue;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str4 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
            sMTLogger2.e(str4, TweetUtils.stackTraceToString(e2));
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r11 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r11 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(int r11) {
        /*
            r10 = this;
            com.netcore.android.logger.SMTLogger r11 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r0 = r10.f1042b
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "isMoreEventsPendingFailedPresentForProcessing()"
            r11.i(r0, r2)
            r11 = 0
            com.netcore.android.e.c r0 = r10.l     // Catch:{ Exception -> 0x003d }
            android.database.sqlite.SQLiteDatabase r2 = r0.d()     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x002b
            java.lang.String r3 = r10.k     // Catch:{ Exception -> 0x003d }
            r4 = 0
            java.lang.String r5 = " syncStatus = ?  OR  syncStatus = ? "
            java.lang.String r0 = "1"
            java.lang.String r6 = "4"
            java.lang.String[] r6 = new java.lang.String[]{r0, r6}     // Catch:{ Exception -> 0x003d }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003d }
        L_0x002b:
            if (r11 == 0) goto L_0x0038
            int r0 = r11.getCount()     // Catch:{ Exception -> 0x003d }
            if (r0 <= 0) goto L_0x0038
            r11.close()
            r11 = 1
            return r11
        L_0x0038:
            if (r11 == 0) goto L_0x0055
            goto L_0x0052
        L_0x003b:
            r0 = move-exception
            goto L_0x0057
        L_0x003d:
            r0 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x003b }
            java.lang.String r3 = r10.f1042b     // Catch:{ all -> 0x003b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003b }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x003b }
            r2.e(r3, r0)     // Catch:{ all -> 0x003b }
            if (r11 == 0) goto L_0x0055
        L_0x0052:
            r11.close()
        L_0x0055:
            r11 = 0
            return r11
        L_0x0057:
            if (r11 == 0) goto L_0x005c
            r11.close()
        L_0x005c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.e.c(int):boolean");
    }

    public final void a(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "rowIds");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "deleteMultipleEventRows()");
        this.l.b();
        try {
            for (Integer intValue : numArr) {
                int intValue2 = intValue.intValue();
                int a2 = this.l.a(this.k, ' ' + this.f1043c + " = ? ", new String[]{String.valueOf(intValue2)});
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str2 = this.f1042b;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger2.i(str2, "deleteMultipleEventRows() result " + a2);
            }
            this.l.f();
        } catch (Exception e2) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str3 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger3.e(str3, "Error while updating multiple events " + e2);
        } catch (Throwable th) {
            this.l.c();
            throw th;
        }
        this.l.c();
    }

    public final HashMap<String, String> a(int i2, int i3) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getPendingAndFailedEventsMapWithSize()");
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase d2 = this.l.d();
            if (d2 != null) {
                cursor = d2.query(this.k, null, " syncStatus = ?  OR  syncStatus = ? ", new String[]{"1", "4"}, null, null, null);
            }
            if (cursor != null) {
                if (cursor.getCount() >= 1) {
                    HashMap<String, String> a2 = a(cursor, i2);
                    cursor.close();
                    return a2;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger2.e(str2, String.valueOf(e2.getMessage()));
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        if (r5 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01ce, code lost:
        if (r9 != null) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01e8, code lost:
        if (r9 != null) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ea, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ed, code lost:
        r0 = r8.toArray(new java.lang.Integer[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01f3, code lost:
        if (r0 == null) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01f5, code lost:
        a((java.lang.Integer[]) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01fa, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0202, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003a, code lost:
        if (r7 != null) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010e A[SYNTHETIC, Splitter:B:32:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.netcore.android.inapp.h.a> a(java.util.HashMap<java.lang.String, java.lang.Object> r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            java.lang.String r2 = "payloadMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r1.f1042b
            java.lang.String r4 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r5 = "getStoredEventData()"
            r2.i(r3, r5)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r5 = "eventId"
            java.lang.Object r5 = r0.get(r5)
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x002d
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r5 = r6
        L_0x002e:
            java.lang.String r7 = "eventName"
            java.lang.Object r7 = r0.get(r7)
            if (r7 == 0) goto L_0x003d
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r7 = r6
        L_0x003e:
            java.lang.String r8 = "eventTime"
            java.lang.Object r0 = r0.get(r8)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x004d
            r6 = r0
        L_0x004d:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
            boolean r0 = kotlin.text.CharsKt__CharKt.isBlank(r5)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r11 = 1
            r0 = r0 ^ r11
            java.lang.String r12 = " DESC "
            r13 = 2
            java.lang.String r14 = " >= ? "
            r15 = 32
            if (r0 == 0) goto L_0x00b3
            com.netcore.android.e.c r0 = r1.l     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            android.database.sqlite.SQLiteDatabase r16 = r0.d()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            if (r16 == 0) goto L_0x010b
            java.lang.String r0 = r1.k     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r18 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7.<init>()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7.append(r15)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = r1.f1044d     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = " = ?  AND  "
            r7.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = r1.g     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7.append(r14)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r19 = r7.toString()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7[r10] = r5     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r7[r11] = r6     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r21 = 0
            r22 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.<init>()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r15)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r6 = r1.g     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r6)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r12)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r23 = r5.toString()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r17 = r0
            r20 = r7
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            goto L_0x0109
        L_0x00b3:
            boolean r0 = kotlin.text.CharsKt__CharKt.isBlank(r7)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            if (r0 == 0) goto L_0x010b
            com.netcore.android.e.c r0 = r1.l     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            android.database.sqlite.SQLiteDatabase r16 = r0.d()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            if (r16 == 0) goto L_0x010b
            java.lang.String r0 = r1.k     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r18 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.<init>()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r15)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = r1.f1045e     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = " like ?  AND  "
            r5.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r9 = r1.g     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r9)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5.append(r14)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r19 = r5.toString()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5[r10] = r7     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r5[r11] = r6     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r21 = 0
            r22 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r6.<init>()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r6.append(r15)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r7 = r1.g     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r6.append(r7)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r6.append(r12)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            java.lang.String r23 = r6.toString()     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
            r17 = r0
            r20 = r5
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x01d4, all -> 0x01d1 }
        L_0x0109:
            r9 = r0
            goto L_0x010c
        L_0x010b:
            r9 = 0
        L_0x010c:
            if (r9 == 0) goto L_0x01ce
            boolean r0 = r9.moveToFirst()     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x01ce
            com.netcore.android.inapp.h.a r0 = new com.netcore.android.inapp.h.a     // Catch:{ Exception -> 0x01cc }
            r0.<init>()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.f1043c     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = "cursor.getString(cursor.getColumnIndex(KEY_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x01cc }
            r0.e(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.f1044d     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = "cursor.getString(cursor.…olumnIndex(KEY_EVENT_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x01cc }
            r0.b(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.f1045e     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = "cursor.getString(cursor.…umnIndex(KEY_EVENT_NAME))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x01cc }
            r0.c(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.g     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x01cc }
            long r5 = r9.getLong(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x01cc }
            r0.a(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.i     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x01cc }
            int r5 = r9.getInt(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = r1.j     // Catch:{ Exception -> 0x01cc }
            int r6 = r9.getColumnIndex(r6)     // Catch:{ Exception -> 0x01cc }
            int r6 = r9.getInt(r6)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = r1.f1046f     // Catch:{ Exception -> 0x01cc }
            int r7 = r9.getColumnIndex(r7)     // Catch:{ Exception -> 0x01cc }
            byte[] r7 = r9.getBlob(r7)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r12 = "payloadArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r12)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01cc }
            java.nio.charset.Charset r13 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x01cc }
            r12.<init>(r7, r13)     // Catch:{ Exception -> 0x01cc }
            if (r5 != r11) goto L_0x01bb
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01cc }
            r11 = 23
            if (r5 < r11) goto L_0x01bb
            com.netcore.android.e.c r5 = r1.l     // Catch:{ Exception -> 0x01cc }
            byte[] r5 = r5.a(r7)     // Catch:{ Exception -> 0x01cc }
            if (r5 != 0) goto L_0x01b4
            java.lang.String r5 = r0.c()     // Catch:{ Exception -> 0x01cc }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01cc }
            r8.add(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r1.f1042b     // Catch:{ Exception -> 0x01cc }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = "error while decrypting the payload, so skipping this value"
            r2.e(r5, r7)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01bb
        L_0x01b4:
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01cc }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x01cc }
            r12.<init>(r5, r2)     // Catch:{ Exception -> 0x01cc }
        L_0x01bb:
            if (r6 <= 0) goto L_0x01c5
            java.lang.String r2 = r1.a(r12, r6)     // Catch:{ Exception -> 0x01cc }
            r0.d(r2)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01c8
        L_0x01c5:
            r0.d(r12)     // Catch:{ Exception -> 0x01cc }
        L_0x01c8:
            r3.add(r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ce
        L_0x01cc:
            r0 = move-exception
            goto L_0x01d6
        L_0x01ce:
            if (r9 == 0) goto L_0x01ed
            goto L_0x01ea
        L_0x01d1:
            r0 = move-exception
            r9 = 0
            goto L_0x0204
        L_0x01d4:
            r0 = move-exception
            r9 = 0
        L_0x01d6:
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x0203 }
            java.lang.String r5 = r1.f1042b     // Catch:{ all -> 0x0203 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0203 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0203 }
            r2.e(r5, r0)     // Catch:{ all -> 0x0203 }
            if (r9 == 0) goto L_0x01ed
        L_0x01ea:
            r9.close()
        L_0x01ed:
            java.lang.Integer[] r0 = new java.lang.Integer[r10]
            java.lang.Object[] r0 = r8.toArray(r0)
            if (r0 == 0) goto L_0x01fb
            java.lang.Integer[] r0 = (java.lang.Integer[]) r0
            r1.a(r0)
            return r3
        L_0x01fb:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r2)
            throw r0
        L_0x0203:
            r0 = move-exception
        L_0x0204:
            if (r9 == 0) goto L_0x0209
            r9.close()
        L_0x0209:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.e.a(java.util.HashMap):java.util.List");
    }

    public final void a(int i2) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "deleteMultipleEvents()");
        Cursor cursor = null;
        try {
            SQLiteDatabase d2 = this.l.d();
            if (d2 != null) {
                String str2 = this.k;
                cursor = d2.query(str2, null, null, null, null, null, ' ' + this.g + " ASC ");
            }
            if (cursor != null && cursor.moveToFirst()) {
                int count = cursor.getCount();
                while (true) {
                    if (count > i2) {
                        String string = cursor.getString(cursor.getColumnIndex(this.f1043c));
                        c cVar = this.l;
                        String str3 = this.k;
                        int a2 = cVar.a(str3, this.f1043c + " = ?", new String[]{string.toString()});
                        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                        String str4 = this.f1042b;
                        Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                        sMTLogger2.i(str4, "deleteMultipleEvents() result " + a2);
                        count += -1;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str5 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            sMTLogger3.e(str5, String.valueOf(e2.getMessage()));
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    private final String a(String str, int i2) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "getPayLoadWithRetryCount()");
        JSONObject jSONObject = new JSONObject(str);
        try {
            jSONObject.put(SMTEventParamKeys.SMT_RETRY, i2);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str3 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger2.e(str3, TweetUtils.stackTraceToString(e2));
            return str;
        }
    }

    private final HashMap<String, String> a(Cursor cursor, int i2) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1042b;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "parseAllPayLoadsFromCursor()");
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        try {
            if (cursor.moveToFirst()) {
                int i3 = 0;
                while (true) {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(this.f1046f));
                    String valueOf = String.valueOf(cursor.getInt(cursor.getColumnIndex(this.f1043c)));
                    int i4 = cursor.getInt(cursor.getColumnIndex(this.i));
                    int i5 = cursor.getInt(cursor.getColumnIndex(this.j));
                    Intrinsics.checkNotNullExpressionValue(blob, "payloadArray");
                    String str2 = new String(blob, Charsets.UTF_8);
                    if (i4 == 1 && VERSION.SDK_INT >= 23) {
                        byte[] a2 = this.l.a(blob);
                        if (a2 == null) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(valueOf)));
                            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                            String str3 = this.f1042b;
                            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                            sMTLogger2.e(str3, "error while decrypting the payload, so skipping this value");
                        } else {
                            str2 = new String(a2, Charsets.UTF_8);
                        }
                    }
                    if (i5 > 0) {
                        hashMap.put(valueOf, a(str2, i5));
                    } else {
                        hashMap.put(valueOf, str2);
                    }
                    i3++;
                    if (i2 == cursor.getCount() || i3 < i2) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String str4 = this.f1042b;
            Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
            sMTLogger3.e(str4, String.valueOf(e2.getMessage()));
        } finally {
            cursor.close();
        }
        Object[] array = arrayList.toArray(new Integer[0]);
        if (array != null) {
            a((Integer[]) array);
            return hashMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
