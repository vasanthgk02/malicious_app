package defpackage;

import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.SDKInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bc  reason: default package */
public class bc extends ar {

    /* renamed from: a  reason: collision with root package name */
    public cb f2781a;

    /* renamed from: a  reason: collision with other field name */
    public cc f68a = null;

    /* renamed from: b  reason: collision with root package name */
    public final String f2782b;

    /* renamed from: c  reason: collision with root package name */
    public String f2783c;

    public bc(HttpResponse httpResponse, String str, String str2) {
        super(httpResponse);
        this.f2782b = str;
        this.f2783c = str2;
    }

    public cc a(JSONObject jSONObject) throws AuthError {
        cp.c("bc", "Extracting RefreshToken");
        try {
            if (!jSONObject.has("refresh_token")) {
                return null;
            }
            return new cc(this.f2782b, this.f2783c, jSONObject.getString("refresh_token"), null);
        } catch (JSONException unused) {
            throw new AuthError("Error reading JSON response", ERROR_TYPE.ERROR_JSON);
        }
    }

    public String a() {
        return SDKInfo.VERSION;
    }

    public boolean a(String str, String str2) {
        return "invalid_token".equals(str) || ("invalid_request".equals(str) && !TextUtils.isEmpty(str2) && str2.contains("access_token"));
    }

    public void c(JSONObject jSONObject) throws IOException, JSONException, AuthError {
        long j;
        try {
            if (jSONObject.has("access_token")) {
                String string = jSONObject.getString("access_token");
                long j2 = 0;
                try {
                    if (jSONObject.has("token_expires_in")) {
                        j = jSONObject.getLong("token_expires_in");
                    } else if (jSONObject.has("expires_in")) {
                        j = jSONObject.getLong("expires_in");
                    } else {
                        cp.d("ar", "Unable to find expiration time in JSON response, AccessToken will not expire locally");
                        cb cbVar = new cb(this.f2782b, this.f2783c, string, j2 * 1000, null);
                        this.f2781a = cbVar;
                        this.f68a = a(jSONObject);
                        return;
                    }
                    j2 = j;
                } catch (JSONException unused) {
                    cp.b("ar", "Unable to parse expiration time in JSON response, AccessToken will not expire locally");
                }
                cb cbVar2 = new cb(this.f2782b, this.f2783c, string, j2 * 1000, null);
                this.f2781a = cbVar2;
                this.f68a = a(jSONObject);
                return;
            }
            cp.b("bc", "Unable to find AccessAtzToken in JSON response, throwing AuthError");
            throw new AuthError("JSON response did not contain an AccessAtzToken", ERROR_TYPE.ERROR_JSON);
        } catch (JSONException unused2) {
            cp.b("bc", "Error reading JSON response, throwing AuthError");
            throw new AuthError("Error reading JSON response", ERROR_TYPE.ERROR_JSON);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.json.JSONObject r7) throws com.amazon.identity.auth.device.AuthError {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "error"
            java.lang.String r1 = r7.getString(r1)     // Catch:{ JSONException -> 0x0130 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x012e }
            if (r2 != 0) goto L_0x0137
            java.lang.String r2 = "error_description"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r3 = "invalid_grant"
            boolean r3 = r3.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "unsupported_grant_type"
            boolean r3 = r3.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r3 == 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r3 = 0
            goto L_0x0027
        L_0x0026:
            r3 = 1
        L_0x0027:
            java.lang.String r4 = "info="
            java.lang.String r5 = "bc"
            if (r3 != 0) goto L_0x0103
            boolean r2 = r6.a(r1, r2)     // Catch:{ JSONException -> 0x012e }
            if (r2 != 0) goto L_0x00ff
            java.lang.String r0 = "invalid_client"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = "invalid_scope"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r0 != 0) goto L_0x00a9
            java.lang.String r0 = "insufficient_scope"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r0 != 0) goto L_0x00a9
            java.lang.String r0 = "unauthorized_client"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x012e }
            if (r0 == 0) goto L_0x007e
            java.lang.String r0 = "Unauthorized Client.  The authenticated client is not authorized to use this authorization grant type. "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r2.<init>()     // Catch:{ JSONException -> 0x012e }
            r2.append(r4)     // Catch:{ JSONException -> 0x012e }
            r2.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x012e }
            defpackage.cp.a(r5, r0, r2)     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError r2 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x012e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r3.<init>()     // Catch:{ JSONException -> 0x012e }
            r3.append(r0)     // Catch:{ JSONException -> 0x012e }
            r3.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_UNAUTHORIZED_CLIENT     // Catch:{ JSONException -> 0x012e }
            r2.<init>(r7, r0)     // Catch:{ JSONException -> 0x012e }
            throw r2     // Catch:{ JSONException -> 0x012e }
        L_0x007e:
            java.lang.String r0 = "Server error doing authorization exchange. "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r2.<init>()     // Catch:{ JSONException -> 0x012e }
            r2.append(r4)     // Catch:{ JSONException -> 0x012e }
            r2.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x012e }
            defpackage.cp.a(r5, r0, r2)     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError r2 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x012e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r3.<init>()     // Catch:{ JSONException -> 0x012e }
            r3.append(r0)     // Catch:{ JSONException -> 0x012e }
            r3.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE     // Catch:{ JSONException -> 0x012e }
            r2.<init>(r7, r0)     // Catch:{ JSONException -> 0x012e }
            throw r2     // Catch:{ JSONException -> 0x012e }
        L_0x00a9:
            java.lang.String r0 = "Invalid Scope. Authorization not valid for the requested scopes "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r2.<init>()     // Catch:{ JSONException -> 0x012e }
            r2.append(r4)     // Catch:{ JSONException -> 0x012e }
            r2.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x012e }
            defpackage.cp.a(r5, r0, r2)     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError r2 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x012e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r3.<init>()     // Catch:{ JSONException -> 0x012e }
            r3.append(r0)     // Catch:{ JSONException -> 0x012e }
            r3.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_SCOPE     // Catch:{ JSONException -> 0x012e }
            r2.<init>(r7, r0)     // Catch:{ JSONException -> 0x012e }
            throw r2     // Catch:{ JSONException -> 0x012e }
        L_0x00d4:
            java.lang.String r0 = "Invalid Client. ApiKey is invalid "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r2.<init>()     // Catch:{ JSONException -> 0x012e }
            r2.append(r4)     // Catch:{ JSONException -> 0x012e }
            r2.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x012e }
            defpackage.cp.a(r5, r0, r2)     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError r2 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x012e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r3.<init>()     // Catch:{ JSONException -> 0x012e }
            r3.append(r0)     // Catch:{ JSONException -> 0x012e }
            r3.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_CLIENT     // Catch:{ JSONException -> 0x012e }
            r2.<init>(r7, r0)     // Catch:{ JSONException -> 0x012e }
            throw r2     // Catch:{ JSONException -> 0x012e }
        L_0x00ff:
            r6.e(r7)     // Catch:{ JSONException -> 0x012e }
            throw r0
        L_0x0103:
            java.lang.String r0 = "Invalid source authorization in exchange."
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r2.<init>()     // Catch:{ JSONException -> 0x012e }
            r2.append(r4)     // Catch:{ JSONException -> 0x012e }
            r2.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x012e }
            defpackage.cp.a(r5, r0, r2)     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError r2 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x012e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x012e }
            r3.<init>()     // Catch:{ JSONException -> 0x012e }
            r3.append(r0)     // Catch:{ JSONException -> 0x012e }
            r3.append(r7)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x012e }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_GRANT     // Catch:{ JSONException -> 0x012e }
            r2.<init>(r7, r0)     // Catch:{ JSONException -> 0x012e }
            throw r2     // Catch:{ JSONException -> 0x012e }
        L_0x012e:
            r0 = r1
            goto L_0x0131
        L_0x0130:
        L_0x0131:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L_0x0138
        L_0x0137:
            return
        L_0x0138:
            com.amazon.identity.auth.device.AuthError r7 = new com.amazon.identity.auth.device.AuthError
            java.lang.String r1 = "Server Error : "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r0)
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE
            r7.<init>(r0, r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bc.d(org.json.JSONObject):void");
    }

    public void e(JSONObject jSONObject) throws AuthError {
        cp.a((String) "bc", (String) "Invalid Token in exchange.", "info=" + jSONObject);
        throw new AuthError("Invalid Token in exchange." + jSONObject, ERROR_TYPE.ERROR_INVALID_TOKEN);
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m256a(JSONObject jSONObject) throws JSONException {
        try {
            return jSONObject.getJSONObject(Constant.TAG_RESPONSE);
        } catch (JSONException unused) {
            cp.d("bc", "No Response type in the response");
            return jSONObject;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m257a(JSONObject jSONObject) {
        super.a(jSONObject);
        Header firstHeader = this.f2753a.getFirstHeader("x-amzn-RequestId");
        if (firstHeader != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("requestId=");
            outline73.append(firstHeader.getValue());
            cp.a((String) "bc", (String) "ExchangeRepsonse", outline73.toString());
            return;
        }
        cp.d("bc", "No RequestId in OAuthTokenRepsonse headers");
    }
}
