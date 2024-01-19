package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import defpackage.af;

/* renamed from: al  reason: default package */
public abstract class al<K extends af> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2747a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ boolean f55a;

    /* renamed from: a  reason: collision with other field name */
    public SQLiteDatabase f56a;

    static {
        Class<al> cls = al.class;
        f55a = !cls.desiredAssertionStatus();
        f2747a = cls.getName();
    }

    public al(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            this.f56a = sQLiteDatabase;
            return;
        }
        throw new IllegalArgumentException("database can't be null!");
    }

    public static String a(String[] strArr, String[] strArr2) throws IllegalArgumentException {
        if (strArr == null && strArr2 == null) {
            return null;
        }
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException("Both arguments have to be either null or not null!");
        } else if (strArr.length == strArr2.length) {
            int i = 0;
            String str = "";
            while (i < strArr.length) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
                outline73.append(strArr[i]);
                outline73.append(strArr2[i] == null ? " IS NULL" : GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(" = '"), strArr2[i], "'"));
                StringBuilder outline732 = GeneratedOutlineSupport.outline73(outline73.toString());
                outline732.append(i != strArr.length + -1 ? " AND " : "");
                str = outline732.toString();
                i++;
            }
            return str;
        } else {
            throw new IllegalArgumentException("selectionFields and selectionValues differ in length!");
        }
    }

    public int a() {
        try {
            return this.f56a.delete(b(), a((String[]) null, (String[]) null), null);
        } catch (IllegalArgumentException e2) {
            String a2 = a();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
            outline73.append(e2.getMessage());
            cp.a(a2, outline73.toString(), (Throwable) e2);
            return 0;
        }
    }

    public int a(Cursor cursor, int i) throws IllegalArgumentException {
        boolean z = f55a;
        if (i >= 0 && i < a().length) {
            return cursor.getColumnIndexOrThrow(a()[i]);
        }
        throw new IllegalArgumentException("colIndex is out of bound!");
    }

    public K a(long j) {
        return a(new String[]{"rowid"}, new String[]{GeneratedOutlineSupport.outline45("", j)});
    }

    public abstract K a(Cursor cursor);

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r10 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r10 != null) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public K m232a(java.lang.String[] r10, java.lang.String[] r11) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r4 = a(r10, r11)     // Catch:{ IllegalArgumentException -> 0x0028, all -> 0x0026 }
            android.database.sqlite.SQLiteDatabase r1 = r9.f56a     // Catch:{ IllegalArgumentException -> 0x0028, all -> 0x0026 }
            java.lang.String r2 = r9.b()     // Catch:{ IllegalArgumentException -> 0x0028, all -> 0x0026 }
            java.lang.String[] r3 = r9.a()     // Catch:{ IllegalArgumentException -> 0x0028, all -> 0x0026 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalArgumentException -> 0x0028, all -> 0x0026 }
            if (r10 == 0) goto L_0x0023
            r10.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0021 }
            af r0 = r9.a(r10)     // Catch:{ IllegalArgumentException -> 0x0021 }
            goto L_0x0023
        L_0x0021:
            r11 = move-exception
            goto L_0x002b
        L_0x0023:
            if (r10 == 0) goto L_0x004c
            goto L_0x0049
        L_0x0026:
            r10 = move-exception
            goto L_0x0050
        L_0x0028:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x002b:
            java.lang.String r1 = r9.a()     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r2.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r3 = ""
            r2.append(r3)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r11.getMessage()     // Catch:{ all -> 0x004d }
            r2.append(r3)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004d }
            defpackage.cp.a(r1, r2, r11)     // Catch:{ all -> 0x004d }
            if (r10 == 0) goto L_0x004c
        L_0x0049:
            r10.close()
        L_0x004c:
            return r0
        L_0x004d:
            r11 = move-exception
            r0 = r10
            r10 = r11
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.close()
        L_0x0055:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.al.m232a(java.lang.String[], java.lang.String[]):af");
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m233a();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r1 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r1 == null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        return r0;
     */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<K> m234a(java.lang.String[] r11, java.lang.String[] r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r5 = a(r11, r12)     // Catch:{ IllegalArgumentException -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r2 = r10.f56a     // Catch:{ IllegalArgumentException -> 0x0044 }
            java.lang.String r3 = r10.b()     // Catch:{ IllegalArgumentException -> 0x0044 }
            java.lang.String[] r4 = r10.a()     // Catch:{ IllegalArgumentException -> 0x0044 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ IllegalArgumentException -> 0x0044 }
            if (r1 == 0) goto L_0x003c
            r1.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0044 }
        L_0x0021:
            boolean r11 = r1.isAfterLast()     // Catch:{ IllegalArgumentException -> 0x0044 }
            if (r11 != 0) goto L_0x003c
            af r11 = r10.a(r1)     // Catch:{ IllegalArgumentException -> 0x0044 }
            if (r11 == 0) goto L_0x0034
            r0.add(r11)     // Catch:{ IllegalArgumentException -> 0x0044 }
            r1.moveToNext()     // Catch:{ IllegalArgumentException -> 0x0044 }
            goto L_0x0021
        L_0x0034:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0044 }
            java.lang.String r12 = "cursor contains invalid object!"
            r11.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x0044 }
            throw r11     // Catch:{ IllegalArgumentException -> 0x0044 }
        L_0x003c:
            if (r1 == 0) goto L_0x0067
        L_0x003e:
            r1.close()
            goto L_0x0067
        L_0x0042:
            r11 = move-exception
            goto L_0x0068
        L_0x0044:
            r11 = move-exception
            java.lang.String r12 = r10.a()     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r2.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = ""
            r2.append(r3)     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = r11.getMessage()     // Catch:{ all -> 0x0042 }
            r2.append(r3)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0042 }
            defpackage.cp.a(r12, r2, r11)     // Catch:{ all -> 0x0042 }
            r0.clear()     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0067
            goto L_0x003e
        L_0x0067:
            return r0
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()
        L_0x006d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.al.m234a(java.lang.String[], java.lang.String[]):java.util.List");
    }

    public boolean a(long j, ContentValues contentValues) {
        boolean z = false;
        if (contentValues == null) {
            return false;
        }
        if (this.f56a.update(b(), contentValues, GeneratedOutlineSupport.outline45("rowid = ", j), null) == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String[] m235a();

    public abstract String b();

    public long a(K k) {
        String str = f2747a;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Insert Row table=");
        outline73.append(b());
        String sb = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("vals=");
        outline732.append(k.a());
        cp.a(str, sb, outline732.toString());
        long insert = this.f56a.insert(b(), null, k.a());
        k.f2703a = insert;
        return insert;
    }
}
