package defpackage;

import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

/* renamed from: ba  reason: default package */
public class ba extends bc {
    public ba(HttpResponse httpResponse, String str, String str2) {
        super(httpResponse, str, str2);
        cp.c("ba", "Creating OauthCodeForTokenResponse appId=" + str);
    }

    public cc a(JSONObject jSONObject) throws AuthError {
        cc a2 = super.a(jSONObject);
        if (a2 != null) {
            return a2;
        }
        throw new AuthError("JSON response did not contain an AccessAtzToken", ERROR_TYPE.ERROR_JSON);
    }

    public boolean a(String str, String str2) {
        return false;
    }
}
