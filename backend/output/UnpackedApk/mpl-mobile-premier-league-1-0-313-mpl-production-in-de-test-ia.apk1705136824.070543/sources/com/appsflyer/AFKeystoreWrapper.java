package com.appsflyer;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.internal.z;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

public class AFKeystoreWrapper {
    public final Object AFInAppEventParameterName = new Object();
    public int AFInAppEventType;
    public Context AFKeystoreWrapper;
    public KeyStore valueOf;
    public String values;

    public AFKeystoreWrapper(Context context) {
        this.AFKeystoreWrapper = context;
        this.values = "";
        this.AFInAppEventType = 0;
        AFLogger.values((String) "Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.valueOf = instance;
            instance.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            AFLogger.valueOf("Couldn't load keystore instance of type: AndroidKeyStore", e2);
        }
    }

    public static boolean valueOf(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final int AFInAppEventType() {
        int i;
        synchronized (this.AFInAppEventParameterName) {
            i = this.AFInAppEventType;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r1 = r4.split(",");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1.length != 3) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        com.appsflyer.AFLogger.values("Found a matching AF key with alias:\n".concat(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split(in.juspay.hypersdk.core.InflateView.SETTER_EQUALS);
        r1 = r1[2].trim().split(in.juspay.hypersdk.core.InflateView.SETTER_EQUALS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r3.length != 2) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r1.length != 2) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r7.values = r3[1].trim();
        r7.AFInAppEventType = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFKeystoreWrapper() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.AFInAppEventParameterName
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.valueOf     // Catch:{ all -> 0x008b }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0088
            java.security.KeyStore r1 = r7.valueOf     // Catch:{ all -> 0x006c }
            java.util.Enumeration r1 = r1.aliases()     // Catch:{ all -> 0x006c }
        L_0x000f:
            boolean r4 = r1.hasMoreElements()     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0088
            java.lang.Object r4 = r1.nextElement()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x000f
            boolean r5 = valueOf(r4)     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x000f
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch:{ all -> 0x006c }
            int r5 = r1.length     // Catch:{ all -> 0x006c }
            r6 = 3
            if (r5 != r6) goto L_0x0088
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x006c }
            com.appsflyer.AFLogger.values(r4)     // Catch:{ all -> 0x006c }
            r3 = r1[r2]     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x006a }
            r4 = 2
            r1 = r1[r4]     // Catch:{ all -> 0x006a }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x006a }
            int r5 = r3.length     // Catch:{ all -> 0x006a }
            if (r5 != r4) goto L_0x0089
            int r5 = r1.length     // Catch:{ all -> 0x006a }
            if (r5 != r4) goto L_0x0089
            r3 = r3[r2]     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006a }
            r7.values = r3     // Catch:{ all -> 0x006a }
            r1 = r1[r2]     // Catch:{ all -> 0x006a }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006a }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x006a }
            r7.AFInAppEventType = r1     // Catch:{ all -> 0x006a }
            goto L_0x0089
        L_0x006a:
            r1 = move-exception
            goto L_0x006e
        L_0x006c:
            r1 = move-exception
            r2 = 0
        L_0x006e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch:{ all -> 0x008b }
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x008b }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x008b }
            r3.append(r4)     // Catch:{ all -> 0x008b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008b }
            com.appsflyer.AFLogger.valueOf(r3, r1)     // Catch:{ all -> 0x008b }
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return r2
        L_0x008b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.AFKeystoreWrapper():boolean");
    }

    public final String values() {
        String str;
        synchronized (this.AFInAppEventParameterName) {
            str = this.values;
        }
        return str;
    }

    public final String valueOf() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("com.appsflyer,");
        synchronized (this.AFInAppEventParameterName) {
            outline73.append("KSAppsFlyerId=");
            outline73.append(this.values);
            outline73.append(",");
            outline73.append("KSAppsFlyerRICounter=");
            outline73.append(this.AFInAppEventType);
        }
        return outline73.toString();
    }

    public final void AFKeystoreWrapper(String str) {
        AFLogger.values("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.AFInAppEventParameterName) {
                if (!this.valueOf.containsAlias(str)) {
                    if (VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (!z.valueOf()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.AFKeystoreWrapper).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.values("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.valueOf(sb.toString(), th);
        }
    }
}
