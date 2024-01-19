package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;

/* renamed from: ap  reason: default package */
public class ap extends al<aj> {

    /* renamed from: a  reason: collision with root package name */
    public static ap f2751a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f60a = aj.f2728a;

    public ap(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    public static synchronized ap a(Context context) {
        ap apVar;
        synchronized (ap.class) {
            try {
                if (f2751a == null) {
                    f2751a = new ap(cj.a(context));
                }
                apVar = f2751a;
            }
        }
        return apVar;
    }

    public af a(Cursor cursor) {
        if (cursor.getCount() != 0) {
            try {
                aj ajVar = new aj();
                ajVar.f2703a = cursor.getLong(a(cursor, a.ID.f47a));
                ajVar.f44a = cursor.getString(a(cursor, a.APP_ID.f47a));
                ajVar.f45a = ao.a(ao.a(cursor.getString(a(cursor, a.EXPIRATION_TIME.f47a))));
                ajVar.f2729b = cursor.getString(a(cursor, a.DATA.f47a));
                return ajVar;
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.getMessage());
                cp.a((String) "ap", outline73.toString(), (Throwable) e2);
            }
        }
        return null;
    }

    public String a() {
        return "ap";
    }

    /* renamed from: a  reason: collision with other method in class */
    public String[] m238a() {
        return f60a;
    }

    public String b() {
        return "Profile";
    }
}
