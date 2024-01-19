package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: am  reason: default package */
public final class am extends al<ag> {

    /* renamed from: a  reason: collision with root package name */
    public static am f2748a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f57a = ag.f2704a;

    public am(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    public static synchronized am a(Context context) {
        am amVar;
        synchronized (am.class) {
            try {
                if (f2748a == null) {
                    f2748a = new am(cj.a(context));
                }
                amVar = f2748a;
            }
        }
        return amVar;
    }

    public af a(Cursor cursor) {
        if (cursor.getCount() != 0) {
            try {
                ag agVar = new ag();
                agVar.f2703a = cursor.getLong(a(cursor, a.ROW_ID.f34a));
                agVar.f2705b = cursor.getString(a(cursor, a.APP_FAMILY_ID.f34a));
                agVar.f2706c = cursor.getString(a(cursor, a.APP_VARIANT_ID.f34a));
                agVar.f2707d = cursor.getString(a(cursor, a.PACKAGE_NAME.f34a));
                agVar.f31b = cj.a(cursor.getString(a(cursor, a.ALLOWED_SCOPES.f34a)), (String) ",");
                agVar.f32c = cj.a(cursor.getString(a(cursor, a.GRANTED_PERMISSIONS.f34a)), (String) ",");
                agVar.f2708e = cursor.getString(a(cursor, a.CLIENT_ID.f34a));
                agVar.f2709f = cursor.getString(a(cursor, a.AUTHZ_HOST.f34a));
                agVar.g = cursor.getString(a(cursor, a.EXCHANGE_HOST.f34a));
                try {
                    agVar.f30a = new JSONObject(cursor.getString(a(cursor, a.PAYLOAD.f34a)));
                    return agVar;
                } catch (JSONException e2) {
                    cp.a((String) "ag", (String) "Payload String not correct JSON.  Setting payload to null", (Throwable) e2);
                    return agVar;
                }
            } catch (Exception e3) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e3.getMessage());
                cp.a((String) "am", outline73.toString(), (Throwable) e3);
            }
        }
        return null;
    }

    public String a() {
        return "am";
    }

    /* renamed from: a  reason: collision with other method in class */
    public String[] m236a() {
        return f57a;
    }

    public String b() {
        return "AppInfo";
    }
}
