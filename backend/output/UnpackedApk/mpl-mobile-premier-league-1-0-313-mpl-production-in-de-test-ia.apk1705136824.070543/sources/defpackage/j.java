package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.squareup.picasso.NetworkRequestHandler;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: j  reason: default package */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3317a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ boolean f130a;

    /* renamed from: j$a */
    public static class a {
        public static ag a(JSONObject jSONObject) throws JSONException, AuthError {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            JSONObject jSONObject2;
            String string = jSONObject.getString("ver");
            if (string.equals("1")) {
                str2 = jSONObject.getString(SMTEventParamKeys.SMT_APP_ID);
                str = str2;
            } else {
                str2 = jSONObject.getString("appFamilyId");
                str = jSONObject.getString("appVariantId");
            }
            if (string.equals("3")) {
                try {
                    jSONObject2 = jSONObject.getJSONObject("endpoints");
                } catch (JSONException unused) {
                    cp.d("j$a", "APIKey does not contain endpoints object");
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    String string2 = jSONObject2.getString("authz");
                    String string3 = jSONObject2.getString("tokenExchange");
                    if (string2 != null && !string2.startsWith(NetworkRequestHandler.SCHEME_HTTPS)) {
                        throw new AuthError("Authorization Host in APIKey is invalid", ERROR_TYPE.ERROR_BAD_PARAM);
                    } else if (string3 == null || string3.startsWith(NetworkRequestHandler.SCHEME_HTTPS)) {
                        str3 = string3;
                        str4 = string2;
                        String string4 = jSONObject.getString("pkg");
                        String[] a2 = cf.a(jSONObject, "scopes");
                        str5 = jSONObject.getString(PaymentConstants.CLIENT_ID_CAMEL);
                        ag agVar = new ag(str2, str, string4, a2, cf.a(jSONObject, "perm"), str5, str4, str3, jSONObject);
                        return agVar;
                    } else {
                        throw new AuthError("Exchange Host in APIKey is invalid", ERROR_TYPE.ERROR_BAD_PARAM);
                    }
                }
            }
            str4 = null;
            str3 = null;
            String string42 = jSONObject.getString("pkg");
            String[] a22 = cf.a(jSONObject, "scopes");
            try {
                str5 = jSONObject.getString(PaymentConstants.CLIENT_ID_CAMEL);
            } catch (JSONException unused2) {
                cp.d("j$a", "APIKey does not contain a client id");
                str5 = null;
            }
            ag agVar2 = new ag(str2, str, string42, a22, cf.a(jSONObject, "perm"), str5, str4, str3, jSONObject);
            return agVar2;
        }

        public static void a(String str, String str2, ce ceVar, Context context) {
            if (str != null) {
                String replace = str.replace(":", "");
                List<String> a2 = cl.a(str2, ceVar, context);
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Number of signatures = ");
                ArrayList arrayList = (ArrayList) a2;
                outline73.append(arrayList.size());
                cp.c("j$a", outline73.toString());
                cp.a((String) "j$a", (String) "Fingerprint checking", a2.toString());
                if (!arrayList.contains(replace.toLowerCase(Locale.US))) {
                    throw new SecurityException(GeneratedOutlineSupport.outline50("Decoding failed: certificate fingerprint can't be verified! pkg=", str2));
                }
                return;
            }
            cp.a((String) "j$a", "App Signature is null. pkg=" + str2);
            throw new SecurityException(GeneratedOutlineSupport.outline50("Decoding failed: certificate fingerprint can't be verified! pkg=", str2));
        }

        public static void a(String str, JSONObject jSONObject, Context context) throws SecurityException, JSONException, NameNotFoundException, CertificateException, NoSuchAlgorithmException, IOException {
            cp.c("j$a", "verifyPayload for packageName=" + str);
            if (!jSONObject.getString("iss").equals("Amazon")) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Decoding fails: issuer (");
                outline73.append(jSONObject.getString("iss"));
                outline73.append(") is not = ");
                outline73.append("Amazon");
                throw new SecurityException(GeneratedOutlineSupport.outline62(outline73, " pkg=", str));
            } else if (str == null || str.equals(jSONObject.getString("pkg"))) {
                if (jSONObject.has("appsig")) {
                    String string = jSONObject.getString("appsig");
                    cp.a((String) "j$a", (String) "Validating MD5 signature in API key", String.format("pkg = %s and signature %s", new Object[]{str, string}));
                    a(string, str, ce.MD5, context);
                }
                if (jSONObject.has("appsigSha256")) {
                    String string2 = jSONObject.getString("appsigSha256");
                    cp.a((String) "j$a", (String) "Validating SHA256 signature in API key", String.format("pkg = %s and signature %s", new Object[]{str, string2}));
                    a(string2, str, ce.SHA_256, context);
                }
            } else {
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("Decoding fails: package names don't match! - ", str, " != ");
                outline80.append(jSONObject.getString("pkg"));
                throw new SecurityException(outline80.toString());
            }
        }
    }

    static {
        Class<j> cls = j.class;
        f130a = !cls.desiredAssertionStatus();
        f3317a = cls.getName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0143 A[SYNTHETIC, Splitter:B:40:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ag a(java.lang.String r10, android.content.Context r11) {
        /*
            r9 = this;
            java.lang.String r0 = f3317a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAppInfo : packageName="
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            defpackage.cp.c(r0, r1)
            java.lang.String r0 = f3317a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAppInfoFromAPIKey : packageName="
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            defpackage.cp.c(r0, r1)
            r0 = 0
            if (r10 != 0) goto L_0x0031
            goto L_0x016d
        L_0x0031:
            java.lang.String r1 = f3317a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Finding API Key for "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            defpackage.cp.c(r1, r2)
            cn r1 = new cn
            r1.<init>(r11, r10)
            java.lang.String r2 = r1.f2834c
            r3 = 1
            if (r2 == 0) goto L_0x0053
            r2 = 1
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            java.lang.String r4 = "APIKey"
            if (r2 != 0) goto L_0x006d
            java.lang.String r2 = "cn"
            java.lang.String r5 = "Unable to get API Key from Assests"
            defpackage.cp.d(r2, r5)
            java.lang.String r2 = r1.a(r4)
            if (r2 == 0) goto L_0x0066
            goto L_0x006f
        L_0x0066:
            java.lang.String r2 = "AmazonAPIKey"
            java.lang.String r2 = r1.a(r2)
            goto L_0x006f
        L_0x006d:
            java.lang.String r2 = r1.f2834c
        L_0x006f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Begin decoding API Key for packageName="
            r1.append(r5)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "j$a"
            defpackage.cp.c(r5, r1)
            cg r1 = new cg
            r1.<init>()
            java.lang.String r6 = "Failed to decode: "
            if (r2 != 0) goto L_0x0090
            goto L_0x012b
        L_0x0090:
            java.lang.String r2 = r2.trim()     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            java.lang.String[] r2 = r1.a(r2)     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            r1.a(r2)     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            cg$a r8 = defpackage.cg.a.PAYLOAD     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            r2 = r2[r3]     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            java.lang.String r1 = r1.a(r2)     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            r7.<init>(r1)     // Catch:{ UnsupportedEncodingException -> 0x0116, JSONException -> 0x010a, InvalidKeyException -> 0x00fe, NoSuchProviderException -> 0x00f2, SignatureException -> 0x00e6, NoSuchAlgorithmException -> 0x00da, CertificateException -> 0x00ce, IOException -> 0x00c2, SecurityException -> 0x00b6, IllegalArgumentException -> 0x00aa }
            goto L_0x012c
        L_0x00aa:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00b6:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00c2:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00ce:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00da:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00e6:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00f2:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x00fe:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x010a:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
            goto L_0x0121
        L_0x0116:
            r1 = move-exception
            java.lang.String r2 = defpackage.cg.f2816a
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r1 = r1.getMessage()
        L_0x0121:
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            defpackage.cp.d(r2, r1)
        L_0x012b:
            r7 = r0
        L_0x012c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "payload="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            defpackage.cp.a(r5, r4, r1)
            if (r7 != 0) goto L_0x0143
            goto L_0x016d
        L_0x0143:
            defpackage.j.a.a(r10, r7, r11)     // Catch:{ SecurityException -> 0x0169, NameNotFoundException -> 0x0164, CertificateException -> 0x015f, NoSuchAlgorithmException -> 0x015a, JSONException -> 0x0155, IOException -> 0x0150, AuthError -> 0x014b }
            ag r0 = defpackage.j.a.a(r7)     // Catch:{ SecurityException -> 0x0169, NameNotFoundException -> 0x0164, CertificateException -> 0x015f, NoSuchAlgorithmException -> 0x015a, JSONException -> 0x0155, IOException -> 0x0150, AuthError -> 0x014b }
            goto L_0x016d
        L_0x014b:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x0150:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x0155:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x015a:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x015f:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x0164:
            r10 = move-exception
            r10.getMessage()
            goto L_0x016d
        L_0x0169:
            r10 = move-exception
            r10.getMessage()
        L_0x016d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j.a(java.lang.String, android.content.Context):ag");
    }
}
