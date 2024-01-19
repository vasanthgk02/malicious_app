package com.netcore.android.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.inapp.f;
import com.netcore.android.inapp.h.b;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.text.ExtendedMessageFormat;

/* compiled from: SMTInAppRulesTable.kt */
public final class h extends a {
    public static final String p = "InAppRule";
    public static final a q = new a(null);

    /* renamed from: b  reason: collision with root package name */
    public final String f1055b = "rule_id";

    /* renamed from: c  reason: collision with root package name */
    public final String f1056c = "event_name";

    /* renamed from: d  reason: collision with root package name */
    public final String f1057d = "payload";

    /* renamed from: e  reason: collision with root package name */
    public final String f1058e = "modified_date";

    /* renamed from: f  reason: collision with root package name */
    public final String f1059f = "already_viewed_count";
    public final String g = "event_id";
    public final String h = "form_date";
    public final String i = "to_date";
    public final String j = "frequency_type";
    public final String k = "frequency_type_value";
    public final String l = "max_frequency";
    public final String m = "random_number";
    public final String n = h.class.getSimpleName();
    public final c o;

    /* compiled from: SMTInAppRulesTable.kt */
    public static final class a {
        public a() {
        }

        public final String a() {
            return h.p;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public h(c cVar) {
        // Intrinsics.checkNotNullParameter(cVar, "wrapper");
        super(cVar);
        this.o = cVar;
    }

    private final SQLiteStatement d() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.n;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "getInAppRuleTableCreateStatement()");
        SQLiteDatabase d2 = this.o.d();
        if (d2 == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE IF NOT EXISTS ");
        outline73.append(p);
        outline73.append(" ( ");
        outline73.append(this.f1055b);
        outline73.append(" TEXT, ");
        outline73.append(this.f1056c);
        outline73.append(" TEXT NOT NULL, ");
        outline73.append(this.f1057d);
        outline73.append(" TEXT NOT NULL, ");
        outline73.append(this.f1058e);
        outline73.append(" TEXT , ");
        outline73.append(this.f1059f);
        outline73.append(" INTEGER NOT NULL DEFAULT 0, ");
        outline73.append(this.g);
        outline73.append(" TEXT, ");
        outline73.append(this.h);
        outline73.append(" LONG,");
        outline73.append(this.i);
        outline73.append(" LONG,");
        outline73.append(this.j);
        outline73.append(" TEXT, ");
        outline73.append(this.k);
        outline73.append(" TEXT, ");
        outline73.append(this.m);
        outline73.append(" INTEGER, ");
        outline73.append(this.l);
        outline73.append(" INTEGER");
        outline73.append(" ) ");
        return d2.compileStatement(outline73.toString());
    }

    public void b() {
        SQLiteStatement d2 = d();
        if (d2 != null) {
            d2.execute();
        }
    }

    public final boolean c(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        Cursor cursor = null;
        try {
            if (bVar.j() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Select * from ");
                sb.append(p);
                sb.append(" where ");
                sb.append(this.f1055b);
                sb.append(" = ");
                sb.append(bVar.i());
                sb.append(" AND ");
                sb.append(this.f1056c);
                sb.append(" = '");
                String d2 = bVar.d();
                if (d2 != null) {
                    String lowerCase = d2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb.append(lowerCase);
                    sb.append("' AND ");
                    sb.append(this.f1058e);
                    sb.append(" != ");
                    sb.append(bVar.j());
                    Cursor b2 = b(sb.toString());
                    if (b2 != null) {
                        boolean moveToFirst = b2.moveToFirst();
                        b2.close();
                        return moveToFirst;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return false;
    }

    public final void e() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.n;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "resetUsageForSessionTypeRule()");
        try {
            List<b> c2 = c();
            if (c2 == null) {
                c2 = EmptyList.INSTANCE;
            }
            for (b bVar : c2) {
                String f2 = bVar.f();
                int hashCode = f2.hashCode();
                if (hashCode != -139919088) {
                    if (hashCode == 99228) {
                        if (f2.equals("day")) {
                        }
                    }
                } else if (f2.equals("campaign")) {
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(this.f1059f, Integer.valueOf(0));
                c cVar = this.o;
                String str2 = p;
                int a2 = cVar.a(str2, contentValues, this.f1055b + " == " + bVar.i(), null);
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str3 = this.n;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger2.i(str3, "resetUsageForSessionTypeRule() result " + a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i2, int i3) {
        c cVar = this.o;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DROP TABLE IF EXISTS ");
        outline73.append(p);
        cVar.a(outline73.toString());
        b();
    }

    public final boolean b(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        Cursor cursor = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Select * from ");
            sb.append(p);
            sb.append(" where ");
            sb.append(this.f1055b);
            sb.append(" = ");
            sb.append(bVar.i());
            sb.append(" AND ");
            sb.append(this.f1056c);
            sb.append(" = '");
            String d2 = bVar.d();
            if (d2 != null) {
                String lowerCase = d2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                sb.append(ExtendedMessageFormat.QUOTE);
                Cursor b2 = b(sb.toString());
                if (b2 != null) {
                    boolean moveToFirst = b2.moveToFirst();
                    b2.close();
                    return moveToFirst;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void a(b bVar) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.n;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "insert()");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(this.f1055b, bVar.i());
            contentValues.put(this.i, bVar.m());
            contentValues.put(this.h, bVar.h());
            contentValues.put(this.g, bVar.c());
            String str2 = this.f1056c;
            String d2 = bVar.d();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            if (d2 != null) {
                String lowerCase = d2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                contentValues.put(str2, lowerCase);
                contentValues.put(this.j, bVar.f());
                contentValues.put(this.l, bVar.e());
                contentValues.put(this.f1058e, bVar.j());
                contentValues.put(this.f1057d, bVar.k());
                contentValues.put(this.m, Integer.valueOf(new Random().nextInt(100) + 1));
                if (!b(bVar)) {
                    long a2 = this.o.a(p, (String) null, contentValues);
                    String str3 = this.n;
                    Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                    sMTLogger.i(str3, "insert() result " + a2);
                    if (a2 == ((long) -1)) {
                        String str4 = this.n;
                        Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                        sMTLogger.e(str4, "Rule insertion failed");
                    }
                } else if (c(bVar)) {
                    String str5 = this.n;
                    Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
                    sMTLogger.d(str5, "Rule modified");
                    contentValues.put(this.f1059f, Integer.valueOf(0));
                    c cVar = this.o;
                    String str6 = p;
                    String str7 = this.f1055b + " = ? AND " + this.f1056c + " = ?";
                    String[] strArr = new String[2];
                    strArr[0] = bVar.i();
                    String d3 = bVar.d();
                    if (d3 != null) {
                        String lowerCase2 = d3.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                        strArr[1] = lowerCase2;
                        int a3 = cVar.a(str6, contentValues, str7, strArr);
                        String str8 = this.n;
                        Intrinsics.checkNotNullExpressionValue(str8, UeCustomType.TAG);
                        sMTLogger.i(str8, "insert() result update " + a3);
                        if (a3 == 0) {
                            String str9 = this.n;
                            Intrinsics.checkNotNullExpressionValue(str9, UeCustomType.TAG);
                            sMTLogger.e(str9, "None of the rules got updated");
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } else {
                    String str10 = this.n;
                    Intrinsics.checkNotNullExpressionValue(str10, UeCustomType.TAG);
                    sMTLogger.d(str10, "Modified date is not change. None of the rules got updated");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0111, code lost:
        if (r3 == null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0117, code lost:
        if (r3 == null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0119, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x011c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.netcore.android.inapp.h.b> c() {
        /*
            r14 = this;
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = r14.n
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "getAllInAppRule()"
            r0.i(r1, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            com.netcore.android.e.c r4 = r14.o     // Catch:{ all -> 0x010f }
            android.database.sqlite.SQLiteDatabase r5 = r4.d()     // Catch:{ all -> 0x010f }
            if (r5 == 0) goto L_0x0076
            java.lang.String r6 = p     // Catch:{ all -> 0x010f }
            r7 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r4.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r8 = "  "
            r4.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r14.h     // Catch:{ all -> 0x010f }
            r4.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = " <= ? AND "
            r4.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r14.i     // Catch:{ all -> 0x010f }
            r4.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = " >= ? "
            r4.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x010f }
            r4 = 2
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x010f }
            r4 = 0
            java.lang.String r10 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x010f }
            r9[r4] = r10     // Catch:{ all -> 0x010f }
            r4 = 1
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x010f }
            r9[r4] = r1     // Catch:{ all -> 0x010f }
            r10 = 0
            r11 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r1.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r2 = "CAST("
            r1.append(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.f1055b     // Catch:{ all -> 0x010f }
            r1.append(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = " AS INT) ASC"
            r1.append(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x010f }
            r13 = 0
            android.database.Cursor r1 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x010f }
            r3 = r1
        L_0x0076:
            if (r3 == 0) goto L_0x0111
            boolean r1 = r3.moveToLast()     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x0111
        L_0x007e:
            com.netcore.android.inapp.h.b r1 = new com.netcore.android.inapp.h.b     // Catch:{ all -> 0x010f }
            r1.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.f1055b     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r4 = "cursor.getString(cursor.…ColumnIndex(KEY_RULE_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x010f }
            r1.f(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.f1059f     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            int r2 = r3.getInt(r2)     // Catch:{ all -> 0x010f }
            r1.a(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.m     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            int r2 = r3.getInt(r2)     // Catch:{ all -> 0x010f }
            r1.d(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.g     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r4 = "cursor.getString(cursor.…olumnIndex(KEY_EVENT_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x010f }
            r1.a(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.f1056c     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r4 = "cursor.getString(cursor.…umnIndex(KEY_EVENT_NAME))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x010f }
            r1.b(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.k     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            long r4 = r3.getLong(r2)     // Catch:{ all -> 0x010f }
            r1.a(r4)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.i     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            long r4 = r3.getLong(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x010f }
            r1.i(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = r14.h     // Catch:{ all -> 0x010f }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x010f }
            long r4 = r3.getLong(r2)     // Catch:{ all -> 0x010f }
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x010f }
            r1.e(r2)     // Catch:{ all -> 0x010f }
            r14.a(r3, r1)     // Catch:{ all -> 0x010f }
            r0.add(r1)     // Catch:{ all -> 0x010f }
            boolean r1 = r3.moveToPrevious()     // Catch:{ all -> 0x010f }
            if (r1 != 0) goto L_0x007e
            goto L_0x0111
        L_0x010f:
            r1 = move-exception
            goto L_0x0114
        L_0x0111:
            if (r3 == 0) goto L_0x011c
            goto L_0x0119
        L_0x0114:
            r1.printStackTrace()     // Catch:{ all -> 0x011d }
            if (r3 == 0) goto L_0x011c
        L_0x0119:
            r3.close()
        L_0x011c:
            return r0
        L_0x011d:
            r0 = move-exception
            if (r3 == 0) goto L_0x0123
            r3.close()
        L_0x0123:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.h.c():java.util.List");
    }

    public final void c(String str) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = this.n;
        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
        sMTLogger.i(str2, "deleteOtherInAppRules()");
        if (str != null) {
            try {
                c cVar = this.o;
                String str3 = p;
                int a2 = cVar.a(str3, this.f1055b + " NOT IN " + str, (String[]) null);
                String str4 = this.n;
                Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                sMTLogger.i(str4, "deleteOtherInAppRules() result " + a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            int a3 = this.o.a(p, (String) null, (String[]) null);
            String str5 = this.n;
            Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
            sMTLogger.i(str5, "deleteOtherInAppRules() result " + a3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ all -> 0x01fb, all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a A[SYNTHETIC, Splitter:B:22:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9 A[Catch:{ all -> 0x01fb, all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00db A[Catch:{ all -> 0x01fb, all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00de A[Catch:{ all -> 0x01fb, all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0144 A[Catch:{ all -> 0x01fb, all -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01fa A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.netcore.android.inapp.h.b> a(java.util.HashMap<java.lang.String, java.lang.Object> r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            java.lang.String r2 = "payloadMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r1.n
            java.lang.String r4 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r5 = "getMatchingRules()"
            r2.i(r3, r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "eventId"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r3 = r5
        L_0x002e:
            java.lang.String r6 = "eventName"
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x01fb }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01fb }
            if (r0 == 0) goto L_0x0045
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x01fb }
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ all -> 0x01fb }
        L_0x0045:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01fb }
            java.lang.CharSequence r0 = kotlin.text.CharsKt__CharKt.trim(r3)     // Catch:{ all -> 0x01fb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01fb }
            int r0 = r0.length()     // Catch:{ all -> 0x01fb }
            r8 = 0
            if (r0 <= 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            java.lang.String r10 = " AS INT) ASC"
            java.lang.String r11 = "CAST("
            r13 = 3
            java.lang.String r14 = " >= ? "
            java.lang.String r15 = " <= ? AND "
            java.lang.String r12 = " =? AND "
            r9 = 32
            if (r0 == 0) goto L_0x00d3
            int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x01fb }
            if (r0 <= 0) goto L_0x00d3
            com.netcore.android.e.c r0 = r1.o     // Catch:{ all -> 0x01fb }
            android.database.sqlite.SQLiteDatabase r16 = r0.d()     // Catch:{ all -> 0x01fb }
            if (r16 == 0) goto L_0x0141
            java.lang.String r17 = p     // Catch:{ all -> 0x01fb }
            r18 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fb }
            r0.<init>()     // Catch:{ all -> 0x01fb }
            r0.append(r9)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.g     // Catch:{ all -> 0x01fb }
            r0.append(r5)     // Catch:{ all -> 0x01fb }
            r0.append(r12)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.h     // Catch:{ all -> 0x01fb }
            r0.append(r5)     // Catch:{ all -> 0x01fb }
            r0.append(r15)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.i     // Catch:{ all -> 0x01fb }
            r0.append(r5)     // Catch:{ all -> 0x01fb }
            r0.append(r14)     // Catch:{ all -> 0x01fb }
            java.lang.String r19 = r0.toString()     // Catch:{ all -> 0x01fb }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ all -> 0x01fb }
            r0[r8] = r3     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01fb }
            r5 = 1
            r0[r5] = r3     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01fb }
            r5 = 2
            r0[r5] = r3     // Catch:{ all -> 0x01fb }
            r21 = 0
            r22 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fb }
            r3.<init>()     // Catch:{ all -> 0x01fb }
            r3.append(r11)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.f1055b     // Catch:{ all -> 0x01fb }
            r3.append(r5)     // Catch:{ all -> 0x01fb }
            r3.append(r10)     // Catch:{ all -> 0x01fb }
            java.lang.String r23 = r3.toString()     // Catch:{ all -> 0x01fb }
            r24 = 0
            r20 = r0
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x01fb }
            goto L_0x0142
        L_0x00d3:
            int r0 = r5.length()     // Catch:{ all -> 0x01fb }
            if (r0 != 0) goto L_0x00db
            r0 = 1
            goto L_0x00dc
        L_0x00db:
            r0 = 0
        L_0x00dc:
            if (r0 != 0) goto L_0x01fa
            com.netcore.android.e.c r0 = r1.o     // Catch:{ all -> 0x01fb }
            android.database.sqlite.SQLiteDatabase r16 = r0.d()     // Catch:{ all -> 0x01fb }
            if (r16 == 0) goto L_0x0141
            java.lang.String r17 = p     // Catch:{ all -> 0x01fb }
            r18 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fb }
            r0.<init>()     // Catch:{ all -> 0x01fb }
            r0.append(r9)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = r1.f1056c     // Catch:{ all -> 0x01fb }
            r0.append(r3)     // Catch:{ all -> 0x01fb }
            r0.append(r12)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = r1.h     // Catch:{ all -> 0x01fb }
            r0.append(r3)     // Catch:{ all -> 0x01fb }
            r0.append(r15)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = r1.i     // Catch:{ all -> 0x01fb }
            r0.append(r3)     // Catch:{ all -> 0x01fb }
            r0.append(r14)     // Catch:{ all -> 0x01fb }
            java.lang.String r19 = r0.toString()     // Catch:{ all -> 0x01fb }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ all -> 0x01fb }
            r0[r8] = r5     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01fb }
            r5 = 1
            r0[r5] = r3     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01fb }
            r5 = 2
            r0[r5] = r3     // Catch:{ all -> 0x01fb }
            r21 = 0
            r22 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fb }
            r3.<init>()     // Catch:{ all -> 0x01fb }
            r3.append(r11)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.f1055b     // Catch:{ all -> 0x01fb }
            r3.append(r5)     // Catch:{ all -> 0x01fb }
            r3.append(r10)     // Catch:{ all -> 0x01fb }
            java.lang.String r23 = r3.toString()     // Catch:{ all -> 0x01fb }
            r24 = 0
            r20 = r0
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x01fb }
            goto L_0x0142
        L_0x0141:
            r0 = 0
        L_0x0142:
            if (r0 == 0) goto L_0x01da
            boolean r3 = r0.moveToLast()     // Catch:{ all -> 0x01fb }
            if (r3 == 0) goto L_0x01da
        L_0x014a:
            com.netcore.android.inapp.h.b r3 = new com.netcore.android.inapp.h.b     // Catch:{ all -> 0x01fb }
            r3.<init>()     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.f1055b     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r6 = "cursor.getString(cursor.…ColumnIndex(KEY_RULE_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x01fb }
            r3.f(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.f1059f     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            int r5 = r0.getInt(r5)     // Catch:{ all -> 0x01fb }
            r3.a(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.m     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            int r5 = r0.getInt(r5)     // Catch:{ all -> 0x01fb }
            r3.d(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.g     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r6 = "cursor.getString(cursor.…olumnIndex(KEY_EVENT_ID))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x01fb }
            r3.a(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.f1056c     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r6 = "cursor.getString(cursor.…umnIndex(KEY_EVENT_NAME))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x01fb }
            r3.b(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.k     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            long r5 = r0.getLong(r5)     // Catch:{ all -> 0x01fb }
            r3.a(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.i     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            long r5 = r0.getLong(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01fb }
            r3.i(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = r1.h     // Catch:{ all -> 0x01fb }
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x01fb }
            long r5 = r0.getLong(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01fb }
            r3.e(r5)     // Catch:{ all -> 0x01fb }
            r1.a(r0, r3)     // Catch:{ all -> 0x01fb }
            r2.add(r3)     // Catch:{ all -> 0x01fb }
            boolean r3 = r0.moveToPrevious()     // Catch:{ all -> 0x01fb }
            if (r3 != 0) goto L_0x014a
        L_0x01da:
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = r1.n     // Catch:{ all -> 0x01fb }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x01fb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fb }
            r4.<init>()     // Catch:{ all -> 0x01fb }
            java.lang.String r5 = "InApp :  "
            r4.append(r5)     // Catch:{ all -> 0x01fb }
            int r5 = r2.size()     // Catch:{ all -> 0x01fb }
            r4.append(r5)     // Catch:{ all -> 0x01fb }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01fb }
            r0.i(r3, r4)     // Catch:{ all -> 0x01fb }
            goto L_0x01ff
        L_0x01fa:
            return r2
        L_0x01fb:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0200 }
        L_0x01ff:
            return r2
        L_0x0200:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.e.h.a(java.util.HashMap):java.util.List");
    }

    private final void a(Cursor cursor, b bVar) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.n;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "setThePayloadData()");
        try {
            String string = cursor.getString(cursor.getColumnIndex(this.f1057d));
            f fVar = new f();
            Intrinsics.checkNotNullExpressionValue(string, "payload");
            fVar.a(string, bVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(b bVar, long j2) {
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.n;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "updateInAppUsage()");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(this.f1059f, Integer.valueOf(bVar.a() + 1));
            if (Intrinsics.areEqual(bVar.f(), "day")) {
                if (bVar.g() != j2) {
                    contentValues.put(this.f1059f, Integer.valueOf(1));
                }
                contentValues.put(this.k, Long.valueOf(j2));
            }
            c cVar = this.o;
            String str2 = p;
            String str3 = this.f1055b + " = ? AND " + this.f1056c + " = ?";
            String[] strArr = new String[2];
            strArr[0] = bVar.i();
            String d2 = bVar.d();
            if (d2 != null) {
                String lowerCase = d2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                strArr[1] = lowerCase;
                int a2 = cVar.a(str2, contentValues, str3, strArr);
                String str4 = this.n;
                Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                sMTLogger.i(str4, "updateInAppUsage() result " + a2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str, String str2) {
        if (str != null && str2 != null) {
            c cVar = this.o;
            String str3 = p;
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline103(sb, this.f1055b, " = '", str, "' AND ");
            sb.append(this.f1058e);
            sb.append(" != '");
            sb.append(str2);
            sb.append("' ");
            cVar.a(str3, sb.toString(), (String[]) null);
        }
    }

    public final void a(ArrayList<b> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "inAppRules");
        try {
            for (b a2 : arrayList) {
                a(a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
