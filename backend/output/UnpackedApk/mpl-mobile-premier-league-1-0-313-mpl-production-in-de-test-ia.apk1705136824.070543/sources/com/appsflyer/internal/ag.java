package com.appsflyer.internal;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFLogger;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public final class ag {
    public static long AFInAppEventParameterName = 4947486484342868501L;
    public static int valueOf = 0;
    public static int values = 1;

    public static String AFInAppEventParameterName(String str) {
        String str2;
        int i = valueOf + 21;
        values = i % 128;
        String str3 = null;
        if (!(i % 2 == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                instance.update(str.getBytes());
                str2 = AFInAppEventParameterName(instance.digest());
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder("Error turning ");
                sb.append(str.substring(0, 6));
                sb.append(".. to SHA-256");
                AFLogger.valueOf(sb.toString(), e2);
            }
        } else {
            MessageDigest instance2 = MessageDigest.getInstance("SHA-256");
            instance2.update(str.getBytes());
            str3 = AFInAppEventParameterName(instance2.digest());
            try {
                int i2 = 1 / 0;
                str2 = str3;
            }
        }
        int i3 = valueOf + 95;
        values = i3 % 128;
        if ((i3 % 2 == 0 ? Tokenizer.FF : DefaultObjectDumpFormatter.TOKEN_DIVIDER) == ';') {
            return str2;
        }
        try {
            int i4 = 9 / 0;
            return str2;
        }
    }

    public static String AFKeystoreWrapper(String str) {
        String str2;
        int i = valueOf + 97;
        values = i % 128;
        int i2 = i % 2;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            str2 = values(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.valueOf(sb.toString(), e2);
            str2 = null;
        }
        int i3 = valueOf + 69;
        values = i3 % 128;
        if ((i3 % 2 == 0 ? 29 : '0') != 29) {
            return str2;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String valueOf(java.lang.String r6) {
        /*
            int r0 = valueOf
            int r0 = r0 + 43
            int r1 = r0 % 128
            values = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "SHA-1"
            r5 = 0
            if (r0 != 0) goto L_0x0031
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x002f }
            r0.reset()     // Catch:{ Exception -> 0x002f }
            byte[] r3 = r6.getBytes(r3)     // Catch:{ Exception -> 0x002f }
            r0.update(r3)     // Catch:{ Exception -> 0x002f }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x002f }
            java.lang.String r6 = values(r0)     // Catch:{ Exception -> 0x002f }
            goto L_0x0069
        L_0x002f:
            r0 = move-exception
            goto L_0x004d
        L_0x0031:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x002f }
            r0.reset()     // Catch:{ Exception -> 0x002f }
            byte[] r3 = r6.getBytes(r3)     // Catch:{ Exception -> 0x002f }
            r0.update(r3)     // Catch:{ Exception -> 0x002f }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x002f }
            java.lang.String r0 = values(r0)     // Catch:{ Exception -> 0x002f }
            throw r5     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
        L_0x0048:
            r6 = move-exception
            throw r6
        L_0x004a:
            r3 = move-exception
            r5 = r0
            r0 = r3
        L_0x004d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error turning "
            r3.<init>(r4)
            r4 = 6
            java.lang.String r6 = r6.substring(r2, r4)
            r3.append(r6)
            java.lang.String r6 = ".. to SHA1"
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.appsflyer.AFLogger.valueOf(r6, r0)
            r6 = r5
        L_0x0069:
            int r0 = values
            int r0 = r0 + 93
            int r3 = r0 % 128
            valueOf = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r1 = 0
        L_0x0077:
            if (r1 == 0) goto L_0x007f
            r0 = 10
            int r0 = r0 / r2
            return r6
        L_0x007d:
            r6 = move-exception
            throw r6
        L_0x007f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ag.valueOf(java.lang.String):java.lang.String");
    }

    public static String values(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if ((i < length ? 3 : 'O') == 'O') {
                break;
            }
            int i2 = valueOf + 119;
            values = i2 % 128;
            if (i2 % 2 == 0) {
                Object[] objArr = new Object[0];
                objArr[0] = Byte.valueOf(bArr[i]);
                formatter.format("%02x", objArr);
                i += 2;
            } else {
                formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
                i++;
            }
        }
        String obj = formatter.toString();
        formatter.close();
        int i3 = values + 27;
        valueOf = i3 % 128;
        if (i3 % 2 == 0) {
            return obj;
        }
        int i4 = 38 / 0;
        return obj;
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r6, int r7) {
        /*
            if (r6 == 0) goto L_0x0006
            char[] r6 = r6.toCharArray()
        L_0x0006:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.dn.valueOf
            monitor-enter(r0)
            com.appsflyer.internal.dn.AFInAppEventType = r7     // Catch:{ all -> 0x003b }
            int r7 = r6.length     // Catch:{ all -> 0x003b }
            char[] r7 = new char[r7]     // Catch:{ all -> 0x003b }
            r1 = 0
            com.appsflyer.internal.dn.values = r1     // Catch:{ all -> 0x003b }
        L_0x0013:
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r2 = r6.length     // Catch:{ all -> 0x003b }
            if (r1 >= r2) goto L_0x0034
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r2 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            char r2 = r6[r2]     // Catch:{ all -> 0x003b }
            int r3 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r4 = com.appsflyer.internal.dn.AFInAppEventType     // Catch:{ all -> 0x003b }
            int r3 = r3 * r4
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch:{ all -> 0x003b }
            long r4 = AFInAppEventParameterName     // Catch:{ all -> 0x003b }
            long r2 = r2 ^ r4
            int r3 = (int) r2     // Catch:{ all -> 0x003b }
            char r2 = (char) r3     // Catch:{ all -> 0x003b }
            r7[r1] = r2     // Catch:{ all -> 0x003b }
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r1 = r1 + 1
            com.appsflyer.internal.dn.values = r1     // Catch:{ all -> 0x003b }
            goto L_0x0013
        L_0x0034:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x003b }
            r6.<init>(r7)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r6
        L_0x003b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ag.AFKeystoreWrapper(java.lang.String, int):java.lang.String");
    }

    public static String values(Map<String, Object> map) {
        String str = (String) map.get(AFKeystoreWrapper("詴憦巠䤞┨ᅑಎ퓉쀉밪ꡂ", 60373 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern());
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        sb.append(((String) map.get("appsflyerKey")).substring(0, 7));
        sb.append(((String) map.get("uid")).substring(0, 7));
        sb.append(str.substring(str.length() - 7));
        String valueOf2 = valueOf(sb.toString());
        int i = values + 35;
        valueOf = i % 128;
        if (i % 2 != 0) {
            z = true;
        }
        if (!z) {
            return valueOf2;
        }
        try {
            throw null;
        }
    }

    public static String AFInAppEventParameterName(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if ((i < length ? '*' : '+') != '*') {
                String obj = sb.toString();
                int i2 = valueOf + 91;
                values = i2 % 128;
                int i3 = i2 % 2;
                return obj;
            }
            int i4 = valueOf + 67;
            values = i4 % 128;
            if (i4 % 2 != 0) {
                sb.append(Integer.toString((bArr[i] & 255) + 256, 16).substring(1));
                i++;
            } else {
                sb.append(Integer.toString((bArr[i] ^ 17933) * 20083, 47).substring(0));
                i += 84;
            }
        }
    }

    public static String valueOf(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String lowerCase = AFInAppEventParameterName(instance.doFinal(str.getBytes())).toLowerCase();
            int i = valueOf + 123;
            values = i % 128;
            if ((i % 2 == 0 ? 2 : 'O') != 2) {
                return lowerCase;
            }
            int i2 = 38 / 0;
            return lowerCase;
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            AFLogger.AFInAppEventParameterName(e2.getMessage(), e2);
            return e2.getMessage();
        }
    }

    public static String AFInAppEventParameterName(Map<String, Object> map) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73((String) map.get("appsflyerKey"));
        outline73.append(map.get(AFKeystoreWrapper("詴憦巠䤞┨ᅑಎ퓉쀉밪ꡂ", 60373 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern()));
        StringBuilder outline732 = GeneratedOutlineSupport.outline73(outline73.toString());
        outline732.append(map.get("uid"));
        StringBuilder outline733 = GeneratedOutlineSupport.outline73(outline732.toString());
        outline733.append(map.get("installDate"));
        StringBuilder outline734 = GeneratedOutlineSupport.outline73(outline733.toString());
        outline734.append(map.get("counter"));
        StringBuilder outline735 = GeneratedOutlineSupport.outline73(outline734.toString());
        outline735.append(map.get("iaecounter"));
        String valueOf2 = valueOf(AFKeystoreWrapper(outline735.toString()));
        int i = values + 29;
        valueOf = i % 128;
        if ((i % 2 != 0 ? '*' : '>') != '*') {
            return valueOf2;
        }
        try {
            int i2 = 78 / 0;
            return valueOf2;
        }
    }

    public static String AFInAppEventParameterName(String... strArr) {
        int i = valueOf + 81;
        values = i % 128;
        int i2 = i % 2;
        String join = TextUtils.join("⁣", strArr);
        int i3 = values + 65;
        valueOf = i3 % 128;
        if (i3 % 2 == 0) {
            return join;
        }
        throw null;
    }
}
