package defpackage;

import android.content.Context;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import defpackage.bd;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: as  reason: default package */
public abstract class as<T extends bd> extends av<T> {
    public as(Context context, ag agVar) {
        super(context, agVar);
    }

    public List<Header> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m244a() throws UnsupportedEncodingException, AuthError {
        JSONObject jSONObject = new JSONObject();
        try {
            for (NameValuePair next : this.f64a) {
                jSONObject.put(next.getName(), next.getValue());
            }
            this.f66a.setEntity(new StringEntity(jSONObject.toString(), "UTF-8"));
        } catch (JSONException e2) {
            throw new AuthError("Received JSONException while building request", e2, ERROR_TYPE.ERROR_BAD_PARAM);
        }
    }
}
