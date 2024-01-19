package defpackage;

import com.amazon.identity.auth.device.AuthError;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ay  reason: default package */
public class ay extends ar {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f2763a;

    public ay(HttpResponse httpResponse) {
        super(httpResponse);
    }

    public void c(JSONObject jSONObject) throws IOException, JSONException, AuthError {
        this.f2763a = jSONObject;
    }
}
