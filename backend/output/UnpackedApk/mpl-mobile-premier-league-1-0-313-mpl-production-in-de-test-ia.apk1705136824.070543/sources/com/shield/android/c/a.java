package com.shield.android.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.shield.android.internal.f;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;
import org.json.JSONObject;

public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1509b;

    public a(Context context) {
        this.f1509b = context;
    }

    public final void a(Context context) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            int i = 0;
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String str = packageInfo.versionName;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            this.f1517a.put("APPVERSION", str);
            String valueOf = String.valueOf(packageInfo.versionCode);
            if (valueOf == null) {
                valueOf = str2;
            }
            this.f1517a.put("APPBUILD", valueOf);
            String installerPackageName = packageManager.getInstallerPackageName(packageName);
            PackageManager packageManager2 = context.getPackageManager();
            try {
                applicationInfo = packageManager2.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            } catch (Exception unused) {
                applicationInfo = null;
            }
            String str3 = (String) (applicationInfo != null ? packageManager2.getApplicationLabel(applicationInfo) : Constants.DOWNLOAD_STATUS_UNKNOWN);
            boolean z = installerPackageName != null && installerPackageName.startsWith("com.android.vending");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", packageName);
            jSONObject.put("is_applisto_cloned", d(context));
            jSONObject.put(UserMetadata.KEYDATA_FILENAME, c(context));
            jSONObject.put("is_official", z);
            jSONObject.put("app_store", installerPackageName);
            jSONObject.put("app_name", str3);
            jSONObject.put("first_installation_time", packageInfo.firstInstallTime);
            ArrayList arrayList = new ArrayList();
            try {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 4096);
                if (packageInfo2 != null) {
                    String[] strArr = packageInfo2.requestedPermissions;
                    if (strArr != null && strArr.length > 0) {
                        while (true) {
                            String[] strArr2 = packageInfo2.requestedPermissions;
                            if (i >= strArr2.length) {
                                break;
                            }
                            if ((packageInfo2.requestedPermissionsFlags[i] & 2) != 0) {
                                String str4 = strArr2[i];
                                int lastIndexOf = str4.lastIndexOf(".") + 1;
                                if (str4.length() > lastIndexOf) {
                                    arrayList.add(str4.substring(lastIndexOf).toLowerCase());
                                }
                            }
                            i++;
                        }
                    }
                }
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
            jSONObject.put("permissions", TextUtils.join(",", arrayList));
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                str2 = jSONObject2;
            }
            this.f1517a.put("APP_INFO", str2);
        } catch (Exception e3) {
            if (f.a("a").f1677b && e3.getMessage() != null) {
                e3.getLocalizedMessage();
            }
        }
    }

    public final String b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(WebSocketHandshake.SHA1_PROTOCOL);
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] cArr2 = new char[(digest.length * 2)];
            for (int i = 0; i < digest.length; i++) {
                byte b2 = digest[i] & 255;
                int i2 = i * 2;
                cArr2[i2] = cArr[b2 >>> 4];
                cArr2[i2 + 1] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception e2) {
            if (f.a("a").f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }

    public final String c(Context context) {
        Signature[] signatureArr;
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (VERSION.SDK_INT >= 28) {
                try {
                    signatureArr = packageManager.getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
                } catch (Throwable th) {
                    if (f.a("a").f1677b && th.getMessage() != null) {
                        th.getLocalizedMessage();
                    }
                    return "";
                }
            } else {
                signatureArr = null;
            }
            if (signatureArr == null) {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            }
            for (Signature byteArray : signatureArr) {
                String b2 = b(byteArray.toByteArray());
                if (!TextUtils.isEmpty(b2)) {
                    arrayList.add(b2);
                }
            }
            return TextUtils.join(",", arrayList);
        } catch (Exception e2) {
            if (f.a("a").f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.String r1 = "cloneSettings.json"
            java.io.FileInputStream r4 = r4.openFileInput(r1)     // Catch:{ Exception -> 0x003e }
            if (r4 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003e }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x003e }
            r1.<init>(r4, r2)     // Catch:{ Exception -> 0x003e }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003e }
            r4.<init>(r1)     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x0032 }
        L_0x001a:
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = "applisto"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0029
            r1 = 1
            r4.close()     // Catch:{ Exception -> 0x003e }
            return r1
        L_0x0029:
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x0032 }
            goto L_0x001a
        L_0x002e:
            r4.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x003e
        L_0x0032:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r2 = move-exception
            r4.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r4 = move-exception
            r1.addSuppressed(r4)     // Catch:{ Exception -> 0x003e }
        L_0x003d:
            throw r2     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.c.a.d(android.content.Context):boolean");
    }
}
