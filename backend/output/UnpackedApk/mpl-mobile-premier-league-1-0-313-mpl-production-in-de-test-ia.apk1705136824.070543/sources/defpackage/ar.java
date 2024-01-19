package defpackage;

import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ar  reason: default package */
public abstract class ar implements bd {

    /* renamed from: a  reason: collision with root package name */
    public final HttpResponse f2753a;

    /* renamed from: b  reason: collision with root package name */
    public String f2754b;

    public ar(HttpResponse httpResponse) {
        this.f2753a = httpResponse;
    }

    public static boolean a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return statusCode >= 500 && statusCode <= 599;
    }

    public int a() throws AuthError {
        try {
            return this.f2753a.getStatusLine().getStatusCode();
        } catch (NullPointerException e2) {
            throw new AuthError("StatusLine is null", e2, ERROR_TYPE.ERROR_COM);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m240a() {
        return "3.5.3";
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject m241a() throws java.io.IOException, org.json.JSONException {
        /*
            r8 = this;
            org.apache.http.HttpResponse r0 = r8.f2753a
            org.apache.http.HttpEntity r0 = r0.getEntity()
            java.io.InputStream r1 = r0.getContent()     // Catch:{ all -> 0x009d }
            org.apache.http.Header r2 = r0.getContentEncoding()     // Catch:{ all -> 0x009b }
            r3 = 0
            if (r2 == 0) goto L_0x002c
            org.apache.http.HeaderElement[] r2 = r2.getElements()     // Catch:{ all -> 0x009b }
            r4 = 0
        L_0x0016:
            int r5 = r2.length     // Catch:{ all -> 0x009b }
            if (r4 >= r5) goto L_0x002c
            r5 = r2[r4]     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "gzip"
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ all -> 0x009b }
            if (r5 == 0) goto L_0x0029
            r2 = 1
            goto L_0x002d
        L_0x0029:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 == 0) goto L_0x0035
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x009b }
            r2.<init>(r1)     // Catch:{ all -> 0x009b }
            r1 = r2
        L_0x0035:
            long r4 = r0.getContentLength()     // Catch:{ all -> 0x009b }
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0093
            java.lang.String r0 = org.apache.http.util.EntityUtils.getContentCharSet(r0)     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = "UTF-8"
        L_0x0048:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x009b }
            r2.<init>()     // Catch:{ all -> 0x009b }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x009b }
        L_0x0051:
            int r5 = r1.read(r4)     // Catch:{ all -> 0x009b }
            r6 = -1
            if (r5 == r6) goto L_0x005c
            r2.write(r4, r3, r5)     // Catch:{ all -> 0x009b }
            goto L_0x0051
        L_0x005c:
            byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x009b }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x009b }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x009b }
            r1.close()
            java.lang.String r0 = r3.trim()
            r8.f2754b = r0
            java.lang.String r0 = "entity="
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r8.f2754b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ar"
            java.lang.String r2 = "Entity Extracted"
            defpackage.cp.a(r1, r2, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r1 = r8.f2754b
            r0.<init>(r1)
            org.json.JSONObject r1 = r8.a(r0)
            r8.a(r0)
            return r1
        L_0x0093:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "HTTP entity too large to be buffered in memory"
            r0.<init>(r2)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x009b }
        L_0x009b:
            r0 = move-exception
            goto L_0x009f
        L_0x009d:
            r0 = move-exception
            r1 = 0
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar.m241a():org.json.JSONObject");
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getJSONObject(Constant.TAG_RESPONSE);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m242a() throws AuthError {
        try {
            if (a(this.f2753a)) {
                String str = "500 error (status=" + a() + ")";
            }
            JSONObject a2 = a();
            d(a2);
            c(a2);
            b(a2);
            try {
                this.f2753a.getEntity().getContent().close();
            } catch (IllegalStateException e2) {
                e2.toString();
            } catch (IOException e3) {
                e3.toString();
            }
        } catch (JSONException e4) {
            if (this.f2754b == null || !this.f2754b.contains("!DOCTYPE html")) {
                cp.d("ar", "JSON exception parsing " + "" + " response:" + e4.toString());
                throw new AuthError(e4.getMessage(), e4, ERROR_TYPE.ERROR_JSON);
            }
            cp.b("ar", "Server sending back default error page - BAD request");
            throw new AuthError("Server sending back default error page - BAD request", e4, ERROR_TYPE.ERROR_JSON);
        } catch (ParseException e5) {
            cp.b("ar", "Exception parsing " + "" + " response:" + e5.toString());
            throw new AuthError(e5.getMessage(), e5, ERROR_TYPE.ERROR_PARSE);
        } catch (IOException e6) {
            cp.b("ar", "Exception accessing " + "" + " response:" + e6.toString());
            throw new AuthError(e6.getMessage(), e6, ERROR_TYPE.ERROR_COM);
        } catch (Throwable th) {
            try {
                this.f2753a.getEntity().getContent().close();
            } catch (IllegalStateException e7) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("IllegalStateException closing response ");
                outline73.append(e7.toString());
                cp.c("ar", outline73.toString());
            } catch (IOException e8) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("IOException closing response ");
                outline732.append(e8.toString());
                cp.b("ar", outline732.toString());
            }
            throw th;
        }
    }

    public void a(String str) throws AuthError {
        throw new AuthError(GeneratedOutlineSupport.outline50("Server Error : ", String.format("Error code: %s Server response: %s", new Object[]{str, this.f2754b})), ERROR_TYPE.ERROR_SERVER_REPSONSE);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m243a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("request_id");
            cp.a((String) "ar", (String) "ExchangeRepsonse", "requestId=" + string);
        } catch (JSONException unused) {
            cp.d("ar", "No RequestId in JSON response");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(org.json.JSONObject r8) throws com.amazon.identity.auth.device.AuthError {
        /*
            r7 = this;
            java.lang.String r0 = "ar"
            r1 = 0
            java.lang.String r2 = "force_update"
            java.lang.String r8 = r8.getString(r2)     // Catch:{ JSONException -> 0x0078, ParseException -> 0x0050 }
            if (r8 == 0) goto L_0x007f
            java.lang.String r2 = "1"
            boolean r2 = r8.equals(r2)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            if (r2 != 0) goto L_0x0015
            goto L_0x007f
        L_0x0015:
            java.lang.String r2 = r7.a()     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            r3.<init>()     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.String r4 = "Force update requested ver:"
            r3.append(r4)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            r3.append(r2)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            defpackage.cp.b(r0, r3)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            com.amazon.identity.auth.device.AuthError r3 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            r4.<init>()     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.String r5 = "Server denied request, requested Force Update ver:"
            r4.append(r5)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            r4.append(r2)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            java.lang.String r2 = r4.toString()     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r4 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_FORCE_UPDATE     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            r3.<init>(r2, r1, r4)     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
            throw r3     // Catch:{ JSONException -> 0x004b, ParseException -> 0x0046 }
        L_0x0046:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x0051
        L_0x004b:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x0079
        L_0x0050:
            r8 = move-exception
        L_0x0051:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0058
            goto L_0x007f
        L_0x0058:
            java.lang.String r1 = "JSON parsing exception force update parsing response:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r8.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            defpackage.cp.b(r0, r1)
            com.amazon.identity.auth.device.AuthError r0 = new com.amazon.identity.auth.device.AuthError
            java.lang.String r1 = r8.getMessage()
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_PARSE
            r0.<init>(r1, r8, r2)
            throw r0
        L_0x0078:
            r8 = move-exception
        L_0x0079:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0080
        L_0x007f:
            return
        L_0x0080:
            java.lang.String r1 = "JSON exception parsing force update response:"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r8.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            defpackage.cp.b(r0, r1)
            com.amazon.identity.auth.device.AuthError r0 = new com.amazon.identity.auth.device.AuthError
            java.lang.String r1 = r8.getMessage()
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_JSON
            r0.<init>(r1, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar.b(org.json.JSONObject):void");
    }

    public abstract void c(JSONObject jSONObject) throws IOException, JSONException, AuthError;

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.json.JSONObject r6) throws com.amazon.identity.auth.device.AuthError, org.json.JSONException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "error"
            org.json.JSONObject r6 = r6.getJSONObject(r1)     // Catch:{ JSONException -> 0x0097, ParseException -> 0x0086 }
            java.lang.String r1 = "code"
            java.lang.String r1 = r6.getString(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r2 = "ServerError"
            boolean r2 = r2.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = "message"
            java.lang.String r2 = r6.getString(r2)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r3 = "INVALID_TOKEN"
            boolean r2 = r2.startsWith(r3)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            if (r2 == 0) goto L_0x002d
            com.amazon.identity.auth.device.AuthError r0 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r1 = "Invalid Exchange parameter - SERVER_ERROR."
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r0.<init>(r1, r2)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
        L_0x002d:
            r5.a(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0
        L_0x0031:
            java.lang.String r2 = "InvalidSourceToken"
            boolean r2 = r2.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            if (r2 != 0) goto L_0x0078
            java.lang.String r2 = "InvalidToken"
            boolean r2 = r2.equals(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            if (r2 != 0) goto L_0x006e
            org.apache.http.HttpResponse r2 = r5.f2753a     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            boolean r2 = a(r2)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            if (r2 == 0) goto L_0x006a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r2.<init>()     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r3 = "500 error (status="
            r2.append(r3)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            int r3 = r5.a()     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r2.append(r3)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r2.append(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r5.a(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0
        L_0x006a:
            r5.a(r1)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0
        L_0x006e:
            com.amazon.identity.auth.device.AuthError r0 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r1 = "Token used is invalid."
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r0.<init>(r1, r2)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
        L_0x0078:
            com.amazon.identity.auth.device.AuthError r0 = new com.amazon.identity.auth.device.AuthError     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            java.lang.String r1 = "Invalid Source Token in exchange parameter"
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r2 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            r0.<init>(r1, r2)     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
            throw r0     // Catch:{ JSONException -> 0x0084, ParseException -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            goto L_0x008a
        L_0x0084:
            r0 = move-exception
            goto L_0x009b
        L_0x0086:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x008a:
            if (r6 != 0) goto L_0x008d
            goto L_0x009d
        L_0x008d:
            com.amazon.identity.auth.device.AuthError r6 = new com.amazon.identity.auth.device.AuthError
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_PARSE
            java.lang.String r2 = "Exception parsing response"
            r6.<init>(r2, r0, r1)
            throw r6
        L_0x0097:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x009b:
            if (r6 != 0) goto L_0x009e
        L_0x009d:
            return
        L_0x009e:
            com.amazon.identity.auth.device.AuthError r6 = new com.amazon.identity.auth.device.AuthError
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_JSON
            java.lang.String r2 = "JSON exception parsing json error response:"
            r6.<init>(r2, r0, r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar.d(org.json.JSONObject):void");
    }
}
