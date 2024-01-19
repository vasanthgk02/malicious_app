package in.juspay.vies;

import android.content.Context;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONObject;

public class VIESHelper {
    public static Boolean a(String str, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getString(i).equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static String a(Context context, String str, String str2) {
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("jp_dev_", Secure.getString(context.getContentResolver(), "android_id"), "_cust_");
        outline80.append(getSHA256Hash(new String(Base64.encode(str2.getBytes(), 2))));
        outline80.append("_card_alias_");
        outline80.append(getSHA256Hash(new String(Base64.encode(str.getBytes(), 2))));
        return outline80.toString();
    }

    public static String a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
        return !bool.booleanValue() ? "device not eligible" : !bool6.booleanValue() ? "webview version not supported" : !bool7.booleanValue() ? "os version is disabled" : !bool2.booleanValue() ? "bin not configured" : !bool3.booleanValue() ? "amount not valid" : bool4.booleanValue() ? "card deenrolled" : !bool5.booleanValue() ? "card not enrolled" : "";
    }

    public static JSONObject a(JuspayServices juspayServices, String str, String str2) {
        String read = KeyValueStore.read(juspayServices, a(juspayServices.getContext(), str, str2), "");
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        if (read.equals("")) {
            jSONObject.put("enrolled", false);
            jSONObject.put("deenrolled", false);
        } else {
            JSONObject jSONObject2 = new JSONObject(read);
            Boolean bool = Boolean.FALSE;
            if (jSONObject2.has("idToken")) {
                bool = Boolean.TRUE;
            }
            Boolean valueOf = Boolean.valueOf(jSONObject2.getBoolean("deenrolled"));
            if (bool.booleanValue() && !valueOf.booleanValue()) {
                z = true;
            }
            jSONObject.put("enrolled", z);
            jSONObject.put("deenrolled", valueOf);
        }
        return jSONObject;
    }

    public static boolean a(String str, Boolean bool, Boolean bool2) {
        if (!str.equals("ONBOARDING")) {
            bool = bool2;
        }
        return bool.booleanValue();
    }

    public static boolean a(String str, Double d2, Double d3) {
        boolean z = true;
        if (str.equals("ONBOARDING")) {
            return true;
        }
        if (d3.doubleValue() > d2.doubleValue()) {
            z = false;
        }
        return z;
    }

    public static boolean a(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getString(i).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(JSONArray jSONArray, String str) {
        int parseInt = Integer.parseInt(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            if (parseInt >= Integer.parseInt(jSONArray.getJSONObject(i).getString("from")) && parseInt <= Integer.parseInt(jSONArray.getJSONObject(i).getString("to"))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x011b A[SYNTHETIC, Splitter:B:26:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012d A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x013e A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0140 A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014f A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0151 A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0162 A[Catch:{ Exception -> 0x0108 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLocalEligibility(android.app.Activity r33, org.json.JSONObject r34) {
        /*
            r1 = r34
            java.lang.String r2 = "request_id"
            java.lang.String r0 = "enrolled"
            android.content.Context r3 = r33.getApplicationContext()
            in.juspay.hypersdk.core.JuspayServices r4 = new in.juspay.hypersdk.core.JuspayServices
            r5 = 0
            r6 = r33
            r4.<init>(r6, r5)
            in.juspay.hypersdk.services.FileProviderService r6 = r4.getFileProviderService()
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0283 }
            r7.<init>()     // Catch:{ Exception -> 0x0283 }
            java.lang.String r8 = "amount"
            double r8 = r1.getDouble(r8)     // Catch:{ Exception -> 0x0283 }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r9 = "customer_id"
            java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x0283 }
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x0283 }
            java.lang.String r11 = "cards"
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0283 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r11 = "payments/in.juspay.vies/v1-config.jsa"
            r12 = 60
            java.lang.String r6 = r6.readFromFile(r3, r11, r12)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r11 = "eligibilityConfigsStart"
            int r11 = r6.indexOf(r11)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r12 = "eligibilityConfigsEnd"
            int r12 = r6.indexOf(r12)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r11 = r6.substring(r11, r12)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r12 = "\\+"
            java.lang.String[] r11 = r11.split(r12)     // Catch:{ Exception -> 0x0283 }
            r12 = 1
            r11 = r11[r12]     // Catch:{ Exception -> 0x0283 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0283 }
            r13.<init>()     // Catch:{ Exception -> 0x0283 }
            java.lang.String r14 = "var "
            r13.append(r14)     // Catch:{ Exception -> 0x0283 }
            r13.append(r11)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r14 = "="
            r13.append(r14)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0283 }
            int r13 = r6.indexOf(r13)     // Catch:{ Exception -> 0x0283 }
            int r11 = r11.length()     // Catch:{ Exception -> 0x0283 }
            int r13 = r13 + r11
            int r13 = r13 + 5
            java.lang.String r11 = ";console.log(\"eligibilityConfigsStart"
            int r11 = r6.indexOf(r11)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r6 = r6.substring(r13, r11)     // Catch:{ Exception -> 0x0283 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0283 }
            r11.<init>(r6)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r6 = "max_amount"
            double r13 = r11.getDouble(r6)     // Catch:{ Exception -> 0x0283 }
            java.lang.Double r6 = java.lang.Double.valueOf(r13)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r13 = "disabled_webview_versions"
            org.json.JSONArray r13 = r11.getJSONArray(r13)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r14 = "disabled_os_versions"
            org.json.JSONArray r14 = r11.getJSONArray(r14)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r15 = "min_os_version_req"
            r11.getString(r15)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r15 = "onboarding_enabled"
            int r15 = r11.getInt(r15)     // Catch:{ Exception -> 0x0283 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x0283 }
            double r16 = java.lang.Math.random()     // Catch:{ Exception -> 0x0283 }
            r18 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r16 = r16 * r18
            int r15 = r15.intValue()     // Catch:{ Exception -> 0x0283 }
            r33 = r6
            double r5 = (double) r15     // Catch:{ Exception -> 0x0283 }
            int r19 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r19 >= 0) goto L_0x00c2
            r5 = 1
            goto L_0x00c3
        L_0x00c2:
            r5 = 0
        L_0x00c3:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r6 = "repeat_enabled"
            java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r12 = "true"
            boolean r6 = r6.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0283 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r12 = "prod_bins"
            java.lang.String r15 = "environment"
            java.lang.String r15 = r1.getString(r15)     // Catch:{ Exception -> 0x0283 }
            r19 = r12
            java.lang.String r12 = "sandbox"
            boolean r12 = r15.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0283 }
            if (r12 == 0) goto L_0x00ed
            java.lang.String r12 = "sandbox_bins"
            goto L_0x00ef
        L_0x00ed:
            r12 = r19
        L_0x00ef:
            org.json.JSONArray r12 = r11.getJSONArray(r12)     // Catch:{ Exception -> 0x0283 }
            java.lang.String r15 = "token_bin_ranges"
            org.json.JSONArray r11 = r11.getJSONArray(r15)     // Catch:{ Exception -> 0x0283 }
            android.content.pm.PackageManager r15 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0114, Exception -> 0x010f }
            java.lang.String r1 = "com.android.chrome"
            r19 = r2
            r2 = 0
            android.content.pm.PackageInfo r1 = r15.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x0116 }
            goto L_0x0117
        L_0x0108:
            r0 = move-exception
            r1 = r34
            r3 = r19
            goto L_0x0285
        L_0x010f:
            r0 = move-exception
            r1 = r34
            goto L_0x0284
        L_0x0114:
            r19 = r2
        L_0x0116:
            r1 = 0
        L_0x0117:
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x012d
            java.lang.String r15 = r1.versionName     // Catch:{ Exception -> 0x0108 }
            r18 = r2
            java.lang.String r2 = "."
            int r2 = r15.indexOf(r2)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0108 }
            r15 = 0
            java.lang.String r1 = r1.substring(r15, r2)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0132
        L_0x012d:
            r18 = r2
            r15 = 0
            r1 = r18
        L_0x0132:
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0108 }
            java.lang.Boolean r2 = a(r2, r14)     // Catch:{ Exception -> 0x0108 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0108 }
            if (r2 != 0) goto L_0x0140
            r2 = 1
            goto L_0x0141
        L_0x0140:
            r2 = 0
        L_0x0141:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0108 }
            java.lang.Boolean r1 = a(r1, r13)     // Catch:{ Exception -> 0x0108 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0108 }
            if (r1 != 0) goto L_0x0151
            r1 = 1
            goto L_0x0152
        L_0x0151:
            r1 = 0
        L_0x0152:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0108 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0108 }
            r13.<init>()     // Catch:{ Exception -> 0x0108 }
            r14 = 0
        L_0x015c:
            int r15 = r10.length()     // Catch:{ Exception -> 0x0108 }
            if (r14 >= r15) goto L_0x0236
            org.json.JSONObject r15 = r10.getJSONObject(r14)     // Catch:{ Exception -> 0x0108 }
            r27 = r7
            java.lang.String r7 = "alias"
            java.lang.String r7 = r15.getString(r7)     // Catch:{ Exception -> 0x0108 }
            org.json.JSONObject r15 = r10.getJSONObject(r14)     // Catch:{ Exception -> 0x0108 }
            r28 = r10
            java.lang.String r10 = "bin"
            java.lang.String r10 = r15.getString(r10)     // Catch:{ Exception -> 0x0108 }
            org.json.JSONObject r15 = a(r4, r7, r9)     // Catch:{ Exception -> 0x0108 }
            r29 = r4
            int r4 = r10.length()     // Catch:{ Exception -> 0x0108 }
            r30 = r9
            r9 = 6
            if (r4 != r9) goto L_0x018e
            boolean r4 = a(r12, r10)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0192
        L_0x018e:
            boolean r4 = b(r11, r10)     // Catch:{ Exception -> 0x0108 }
        L_0x0192:
            boolean r9 = r15.has(r0)     // Catch:{ Exception -> 0x0108 }
            if (r9 == 0) goto L_0x01a1
            boolean r9 = r15.getBoolean(r0)     // Catch:{ Exception -> 0x0108 }
            if (r9 == 0) goto L_0x01a1
            java.lang.String r9 = "REPEAT"
            goto L_0x01a3
        L_0x01a1:
            java.lang.String r9 = "ONBOARDING"
        L_0x01a3:
            r10 = r33
            boolean r20 = a(r9, r10, r8)     // Catch:{ Exception -> 0x0108 }
            java.lang.Boolean r22 = java.lang.Boolean.valueOf(r20)     // Catch:{ Exception -> 0x0108 }
            r33 = r8
            com.google.android.gms.common.GoogleApiAvailability r8 = com.google.android.gms.common.GoogleApiAvailability.zab     // Catch:{ Exception -> 0x0108 }
            int r8 = r8.isGooglePlayServicesAvailable(r3)     // Catch:{ Exception -> 0x0108 }
            if (r8 != 0) goto L_0x01b9
            r8 = 1
            goto L_0x01ba
        L_0x01b9:
            r8 = 0
        L_0x01ba:
            java.lang.Boolean r20 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x0108 }
            boolean r8 = r20.booleanValue()     // Catch:{ Exception -> 0x0108 }
            r31 = r3
            java.lang.String r3 = "deenrolled"
            if (r8 == 0) goto L_0x01ea
            if (r4 == 0) goto L_0x01ea
            boolean r8 = a(r9, r5, r6)     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x01ea
            boolean r8 = r1.booleanValue()     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x01ea
            boolean r8 = r2.booleanValue()     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x01ea
            boolean r8 = r15.getBoolean(r3)     // Catch:{ Exception -> 0x0108 }
            if (r8 != 0) goto L_0x01ea
            boolean r8 = r22.booleanValue()     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x01ea
            r8 = 1
            goto L_0x01eb
        L_0x01ea:
            r8 = 0
        L_0x01eb:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0108 }
            r9.<init>()     // Catch:{ Exception -> 0x0108 }
            r32 = r5
            java.lang.String r5 = "eligibility"
            r9.put(r5, r8)     // Catch:{ Exception -> 0x0108 }
            boolean r5 = r15.getBoolean(r0)     // Catch:{ Exception -> 0x0108 }
            r9.put(r0, r5)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r5 = "response_msg"
            java.lang.Boolean r21 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0108 }
            boolean r3 = r15.getBoolean(r3)     // Catch:{ Exception -> 0x0108 }
            java.lang.Boolean r23 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0108 }
            boolean r3 = r15.getBoolean(r0)     // Catch:{ Exception -> 0x0108 }
            java.lang.Boolean r24 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0108 }
            r25 = r1
            r26 = r2
            java.lang.String r3 = a(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0108 }
            r9.put(r5, r3)     // Catch:{ Exception -> 0x0108 }
            r13.put(r7, r9)     // Catch:{ Exception -> 0x0108 }
            int r14 = r14 + 1
            r8 = r33
            r33 = r10
            r7 = r27
            r10 = r28
            r4 = r29
            r9 = r30
            r3 = r31
            r5 = r32
            goto L_0x015c
        L_0x0236:
            r27 = r7
            java.lang.String r0 = "action"
            java.lang.String r1 = "VIES_ELIGIBILITY"
            r2 = r27
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r0 = "event"
            r1 = r34
            r3 = r19
            java.lang.String r4 = r1.getString(r3)     // Catch:{ Exception -> 0x0281 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r0 = r1.getString(r3)     // Catch:{ Exception -> 0x0281 }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r0 = "status"
            java.lang.String r4 = "SUCCESS"
            r13.put(r0, r4)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r0 = "session_id"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0281 }
            r4.<init>()     // Catch:{ Exception -> 0x0281 }
            java.util.UUID r5 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0281 }
            r4.append(r5)     // Catch:{ Exception -> 0x0281 }
            r5 = r18
            r4.append(r5)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0281 }
            r13.put(r0, r4)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r0 = "payload"
            r2.put(r0, r13)     // Catch:{ Exception -> 0x0281 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0281 }
            return r0
        L_0x0281:
            r0 = move-exception
            goto L_0x0285
        L_0x0283:
            r0 = move-exception
        L_0x0284:
            r3 = r2
        L_0x0285:
            r0.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "{\"action\":\"VIES_ELIGIBILITY\",\"request_id\":\""
            r0.append(r2)
            java.lang.String r1 = r1.getString(r3)
            r0.append(r1)
            java.lang.String r1 = "\",\"payload\":{\"error_code\":\"JP500\",\"error_message\":\"Error while processing eligibility check\",\"session_id\":\""
            r0.append(r1)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            r0.append(r1)
            java.lang.String r1 = "\",\"status\": \"ERROR\"}}"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.vies.VIESHelper.getLocalEligibility(android.app.Activity, org.json.JSONObject):java.lang.String");
    }

    public static String getSHA256Hash(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            return EncryptionHelper.bytesToHexString(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
