package defpackage;

import a.a.a.a.d.b;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;

/* renamed from: an  reason: default package */
public final class an extends al<ah> {

    /* renamed from: a  reason: collision with root package name */
    public static an f2749a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f58a = ah.f2716a;

    public an(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    public static synchronized an a(Context context) {
        an anVar;
        synchronized (an.class) {
            try {
                if (f2749a == null) {
                    f2749a = new an(cj.a(context));
                }
                anVar = f2749a;
            }
        }
        return anVar;
    }

    public af a(Cursor cursor) {
        if (cursor.getCount() != 0) {
            try {
                ah a2 = b.a(a.values()[cursor.getInt(a(cursor, b.TYPE.f43a))]);
                a2.f2703a = cursor.getLong(a(cursor, b.ID.f43a));
                a2.f36a = cursor.getString(a(cursor, b.APP_FAMILY_ID.f43a));
                a2.f2717b = cursor.getString(a(cursor, b.TOKEN.f43a));
                a2.f37a = ao.a(ao.a(cursor.getString(a(cursor, b.CREATION_TIME.f43a))));
                a2.f39b = ao.a(ao.a(cursor.getString(a(cursor, b.EXPIRATION_TIME.f43a))));
                a2.f38a = cursor.getBlob(a(cursor, b.MISC_DATA.f43a));
                a2.f2718d = cursor.getString(a(cursor, b.DIRECTED_ID.f43a));
                return a2;
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.getMessage());
                cp.a((String) "an", outline73.toString(), (Throwable) e2);
            }
        }
        return null;
    }

    public ah a(long j) {
        return (ah) a(j);
    }

    public String a() {
        return "an";
    }

    /* renamed from: a  reason: collision with other method in class */
    public String[] m237a() {
        return f58a;
    }

    public String b() {
        return "AuthorizationToken";
    }
}
