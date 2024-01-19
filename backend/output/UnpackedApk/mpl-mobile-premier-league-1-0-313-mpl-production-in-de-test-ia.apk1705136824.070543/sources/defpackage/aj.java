package defpackage;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.GameConstant;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.CreateRoomRequest;

/* renamed from: aj  reason: default package */
public class aj extends af {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2728a = {"Id", "ExpirationTime", GameConstant.GAME_APP_ID, "Data"};

    /* renamed from: a  reason: collision with other field name */
    public String f44a;

    /* renamed from: a  reason: collision with other field name */
    public Date f45a;

    /* renamed from: b  reason: collision with root package name */
    public String f2729b;

    /* renamed from: aj$a */
    public enum a {
        ID(0),
        EXPIRATION_TIME(1),
        APP_ID(2),
        DATA(3);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f47a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f47a = i;
        }
    }

    public aj() {
    }

    public aj(String str, String str2) {
        Date date = new Date(Calendar.getInstance().getTime().getTime() + 3600000);
        this.f44a = str;
        this.f2729b = str2;
        this.f45a = date;
    }

    public ContentValues a() {
        String str;
        String str2;
        ContentValues contentValues = new ContentValues();
        contentValues.put(f2728a[a.APP_ID.f47a], this.f44a);
        if (this.f45a != null) {
            str2 = f2728a[a.EXPIRATION_TIME.f47a];
            str = ao.a().format(this.f45a);
        } else {
            str2 = f2728a[a.EXPIRATION_TIME.f47a];
            str = null;
        }
        contentValues.put(str2, str);
        contentValues.put(f2728a[a.DATA.f47a], this.f2729b);
        return contentValues;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Bundle m231a() throws AuthError {
        Bundle bundle = new Bundle();
        if (this.f2729b != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f2729b);
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle.putString(next, jSONObject.getString(next));
                    }
                } catch (JSONException e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to parse profile data in database ");
                    outline73.append(e2.getMessage());
                    cp.b(CreateRoomRequest.KEY_AUTOJOIN, outline73.toString());
                }
            } catch (JSONException e3) {
                cp.a((String) CreateRoomRequest.KEY_AUTOJOIN, (String) "JSONException while parsing profile information in database", (Throwable) e3);
                throw new AuthError("JSONException while parsing profile information in database", e3, ERROR_TYPE.ERROR_JSON);
            }
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null && (obj instanceof aj)) {
            try {
                aj ajVar = (aj) obj;
                if (TextUtils.equals(this.f44a, ajVar.f44a) && a(this.f45a, ajVar.f45a) && a(ajVar)) {
                    z = true;
                }
                return z;
            } catch (NullPointerException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.toString());
                cp.b(CreateRoomRequest.KEY_AUTOJOIN, outline73.toString());
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ rowid=");
        outline73.append(this.f2703a);
        outline73.append(", appId=");
        outline73.append(this.f44a);
        outline73.append(", expirationTime=");
        outline73.append(ao.a().format(this.f45a));
        outline73.append(", data=");
        return GeneratedOutlineSupport.outline62(outline73, this.f2729b, " }");
    }

    public final boolean a(aj ajVar) {
        try {
            JSONObject jSONObject = new JSONObject(this.f2729b);
            JSONObject jSONObject2 = new JSONObject(ajVar.f2729b);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.getString(next).equals(jSONObject2.getString(next))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return TextUtils.equals(this.f2729b, ajVar.f2729b);
        }
    }
}
