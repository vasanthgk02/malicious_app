package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;

/* renamed from: aq  reason: default package */
public final class aq extends al<ak> {

    /* renamed from: a  reason: collision with root package name */
    public static aq f2752a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f61a = ak.f48a;

    public aq(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    public static synchronized aq a(Context context) {
        aq aqVar;
        synchronized (aq.class) {
            try {
                if (f2752a == null) {
                    f2752a = new aq(cj.a(context));
                }
                aqVar = f2752a;
            }
        }
        return aqVar;
    }

    public af a(Cursor cursor) {
        if (cursor.getCount() != 0) {
            try {
                ak akVar = new ak();
                akVar.f2703a = cursor.getLong(a(cursor, a.ROW_ID.f52a));
                akVar.f50b = cursor.getString(a(cursor, a.SCOPE.f52a));
                akVar.f2736c = cursor.getString(a(cursor, a.APP_FAMILY_ID.f52a));
                akVar.f2737d = cursor.getString(a(cursor, a.DIRECTED_ID.f52a));
                akVar.f49a = cursor.getLong(a(cursor, a.AUTHORIZATION_ACCESS_TOKEN_ID.f52a));
                akVar.f2735b = cursor.getLong(a(cursor, a.AUTHORIZATION_REFRESH_TOKEN_ID.f52a));
                return akVar;
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.getMessage());
                cp.a((String) "aq", outline73.toString(), (Throwable) e2);
            }
        }
        return null;
    }

    public String a() {
        return "aq";
    }

    /* renamed from: a  reason: collision with other method in class */
    public String[] m239a() {
        return f61a;
    }

    public String b() {
        return "RequestedScope";
    }
}
