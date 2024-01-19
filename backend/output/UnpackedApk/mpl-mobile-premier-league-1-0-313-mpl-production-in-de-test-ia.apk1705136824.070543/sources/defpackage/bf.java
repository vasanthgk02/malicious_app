package defpackage;

import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.SDKInfo;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bf  reason: default package */
public class bf extends ar {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f2786a;

    public bf(HttpResponse httpResponse) {
        super(httpResponse);
    }

    public String a() {
        return SDKInfo.VERSION;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public void c(JSONObject jSONObject) throws IOException, JSONException, AuthError {
        this.f2786a = jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[Catch:{ JSONException -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070 A[Catch:{ JSONException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.json.JSONObject r6) throws com.amazon.identity.auth.device.AuthError, org.json.JSONException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "error"
            java.lang.String r0 = r6.getString(r1)     // Catch:{ JSONException -> 0x00bb }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x00bb }
            if (r1 != 0) goto L_0x00c2
            java.lang.String r1 = "error_description"
            java.lang.String r1 = r6.getString(r1)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r2 = "insufficient_scope"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r3 = "info="
            java.lang.String r4 = "bf"
            if (r2 != 0) goto L_0x009d
            java.lang.String r2 = "invalid_token"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x00bb }
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "invalid_request"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x00bb }
            if (r2 == 0) goto L_0x003e
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00bb }
            if (r2 != 0) goto L_0x003e
            java.lang.String r2 = "access_token"
            boolean r1 = r1.contains(r2)     // Catch:{ JSONException -> 0x00bb }
            if (r1 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = 0
            goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = "Invalid Token in exchange."
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00bb }
            r2.append(r3)     // Catch:{ JSONException -> 0x00bb }
            r2.append(r6)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x00bb }
            defpackage.cp.a(r4, r1, r2)     // Catch:{ JSONException -> 0x00bb }
            com.amazon.identity.auth.device.AuthError r1 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x00bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r3 = "Invalid Token in exchange. "
            r2.append(r3)     // Catch:{ JSONException -> 0x00bb }
            r2.append(r6)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r6 = r2.toString()     // Catch:{ JSONException -> 0x00bb }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN     // Catch:{ JSONException -> 0x00bb }
            r1.<init>(r6, r2)     // Catch:{ JSONException -> 0x00bb }
            throw r1     // Catch:{ JSONException -> 0x00bb }
        L_0x0070:
            java.lang.String r1 = "Server error doing authorization exchange."
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00bb }
            r2.append(r3)     // Catch:{ JSONException -> 0x00bb }
            r2.append(r6)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x00bb }
            defpackage.cp.a(r4, r1, r2)     // Catch:{ JSONException -> 0x00bb }
            com.amazon.identity.auth.device.AuthError r1 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x00bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r3 = "Server error doing authorization exchange. "
            r2.append(r3)     // Catch:{ JSONException -> 0x00bb }
            r2.append(r6)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r6 = r2.toString()     // Catch:{ JSONException -> 0x00bb }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE     // Catch:{ JSONException -> 0x00bb }
            r1.<init>(r6, r2)     // Catch:{ JSONException -> 0x00bb }
            throw r1     // Catch:{ JSONException -> 0x00bb }
        L_0x009d:
            java.lang.String r1 = "Insufficient scope in token in exchange."
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00bb }
            r2.append(r3)     // Catch:{ JSONException -> 0x00bb }
            r2.append(r6)     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r6 = r2.toString()     // Catch:{ JSONException -> 0x00bb }
            defpackage.cp.a(r4, r1, r6)     // Catch:{ JSONException -> 0x00bb }
            com.amazon.identity.auth.device.AuthError r6 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r1 = "Profile request not valid for authorized scopes"
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_BAD_API_PARAM     // Catch:{ JSONException -> 0x00bb }
            r6.<init>(r1, r2)     // Catch:{ JSONException -> 0x00bb }
            throw r6     // Catch:{ JSONException -> 0x00bb }
        L_0x00bb:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L_0x00c3
        L_0x00c2:
            return
        L_0x00c3:
            com.amazon.identity.auth.device.AuthError r6 = new com.amazon.identity.auth.device.AuthError
            java.lang.String r1 = "Server Error : "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r0)
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE
            r6.<init>(r0, r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf.d(org.json.JSONObject):void");
    }
}
