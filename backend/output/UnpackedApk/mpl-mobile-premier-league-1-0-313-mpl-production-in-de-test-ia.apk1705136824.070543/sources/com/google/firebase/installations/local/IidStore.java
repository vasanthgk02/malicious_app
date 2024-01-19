package com.google.firebase.installations.local;

import android.content.SharedPreferences;

public class IidStore {
    public static final String[] ALLOWABLE_SCOPES = {"*", "FCM", "GCM", ""};
    public final String defaultSenderId;
    public final SharedPreferences iidPrefs;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        r0 = r4[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r0.isEmpty() != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IidStore(com.google.firebase.FirebaseApp r4) {
        /*
            r3 = this;
            r3.<init>()
            r4.checkNotDeleted()
            android.content.Context r0 = r4.applicationContext
            java.lang.String r1 = "com.google.android.gms.appid"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.iidPrefs = r0
            r4.checkNotDeleted()
            com.google.firebase.FirebaseOptions r0 = r4.options
            java.lang.String r0 = r0.gcmSenderId
            if (r0 == 0) goto L_0x001b
            goto L_0x0049
        L_0x001b:
            r4.checkNotDeleted()
            com.google.firebase.FirebaseOptions r4 = r4.options
            java.lang.String r0 = r4.applicationId
            java.lang.String r4 = "1:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = "2:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L_0x0033
            goto L_0x0049
        L_0x0033:
            java.lang.String r4 = ":"
            java.lang.String[] r4 = r0.split(r4)
            int r0 = r4.length
            r1 = 4
            r2 = 0
            if (r0 == r1) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            r0 = 1
            r0 = r4[r0]
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0049
        L_0x0048:
            r0 = r2
        L_0x0049:
            r3.defaultSenderId = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.IidStore.<init>(com.google.firebase.FirebaseApp):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        "Invalid key stored " + r1;
        r1 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026 A[ExcHandler: IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException (r1v6 'e' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:8:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String readPublicKeyFromLocalStorageAndCalculateInstanceId() {
        /*
            r6 = this;
            android.content.SharedPreferences r0 = r6.iidPrefs
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.iidPrefs     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "|S||P|"
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r3
        L_0x0010:
            r2 = 8
            byte[] r1 = android.util.Base64.decode(r1, r2)     // Catch:{ IllegalArgumentException -> 0x002a, InvalidKeySpecException -> 0x0028, NoSuchAlgorithmException -> 0x0026 }
            java.lang.String r4 = "RSA"
            java.security.KeyFactory r4 = java.security.KeyFactory.getInstance(r4)     // Catch:{ IllegalArgumentException -> 0x002a, InvalidKeySpecException -> 0x0028, NoSuchAlgorithmException -> 0x0026 }
            java.security.spec.X509EncodedKeySpec r5 = new java.security.spec.X509EncodedKeySpec     // Catch:{ IllegalArgumentException -> 0x002a, InvalidKeySpecException -> 0x0028, NoSuchAlgorithmException -> 0x0026 }
            r5.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x002a, InvalidKeySpecException -> 0x0028, NoSuchAlgorithmException -> 0x0026 }
            java.security.PublicKey r1 = r4.generatePublic(r5)     // Catch:{ IllegalArgumentException -> 0x002a, InvalidKeySpecException -> 0x0028, NoSuchAlgorithmException -> 0x0026 }
            goto L_0x003c
        L_0x0026:
            r1 = move-exception
            goto L_0x002b
        L_0x0028:
            r1 = move-exception
            goto L_0x002b
        L_0x002a:
            r1 = move-exception
        L_0x002b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r4.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "Invalid key stored "
            r4.append(r5)     // Catch:{ all -> 0x0062 }
            r4.append(r1)     // Catch:{ all -> 0x0062 }
            r4.toString()     // Catch:{ all -> 0x0062 }
            r1 = r3
        L_0x003c:
            if (r1 != 0) goto L_0x0040
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r3
        L_0x0040:
            byte[] r1 = r1.getEncoded()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "SHA1"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            byte[] r1 = r4.digest(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            r4 = 0
            byte r5 = r1[r4]     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            r5 = r5 & 15
            int r5 = r5 + 112
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            r1[r4] = r5     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            r5 = 11
            java.lang.String r3 = android.util.Base64.encodeToString(r1, r4, r2, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r3
        L_0x0062:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.IidStore.readPublicKeyFromLocalStorageAndCalculateInstanceId():java.lang.String");
    }
}
