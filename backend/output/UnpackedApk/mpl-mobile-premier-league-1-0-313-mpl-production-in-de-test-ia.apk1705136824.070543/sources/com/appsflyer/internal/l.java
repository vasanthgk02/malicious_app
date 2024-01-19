package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public final be AFKeystoreWrapper;

    public interface d {
        void valueOf(String str, String str2, String str3);

        void values(String str);
    }

    public l() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[SYNTHETIC, Splitter:B:23:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.n values(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            char[] r2 = new char[r3]     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.read(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            com.appsflyer.internal.n r3 = new com.appsflyer.internal.n     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.AFInAppEventParameterName = r4     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r4 = move-exception
            com.appsflyer.AFLogger.values(r4)
        L_0x0023:
            return r3
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            com.appsflyer.AFLogger.values(r0)
        L_0x0032:
            throw r4
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r4 = move-exception
            com.appsflyer.AFLogger.values(r4)
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.l.values(java.io.File):com.appsflyer.internal.n");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3 A[SYNTHETIC, Splitter:B:32:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e0 A[SYNTHETIC, Splitter:B:40:0x00e0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFInAppEventParameterName(com.appsflyer.internal.n r7) {
        /*
            r6 = this;
            java.lang.String r0 = "AFRequestCache"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            com.appsflyer.internal.be r3 = r6.AFKeystoreWrapper     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            android.content.Context r3 = r3.values     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            if (r3 != 0) goto L_0x001a
            r2.mkdir()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            return r1
        L_0x001a:
            java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            if (r2 == 0) goto L_0x002b
            int r2 = r2.length     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r3 = 40
            if (r2 <= r3) goto L_0x002b
            java.lang.String r7 = "CACHE: reached cache limit, not caching request"
            com.appsflyer.AFLogger.values(r7)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            return r1
        L_0x002b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = "CACHE: caching request with URL: "
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = r7.valueOf     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r2.append(r3)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            com.appsflyer.AFLogger.values(r2)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = java.lang.Long.toString(r2)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            com.appsflyer.internal.be r5 = r6.AFKeystoreWrapper     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            android.content.Context r5 = r5.values     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r4.<init>(r5, r0)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r3.createNewFile()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r5 = 1
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = "version="
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r3 = r7.AFInAppEventType     // Catch:{ Exception -> 0x00c6 }
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
            r3 = 10
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r4 = "url="
            r0.write(r4)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r4 = r7.valueOf     // Catch:{ Exception -> 0x00c6 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c6 }
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r4 = "data="
            r0.write(r4)     // Catch:{ Exception -> 0x00c6 }
            byte[] r4 = r7.AFInAppEventParameterName()     // Catch:{ Exception -> 0x00c6 }
            r5 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)     // Catch:{ Exception -> 0x00c6 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c6 }
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
            com.appsflyer.internal.bt r7 = r7.AFKeystoreWrapper     // Catch:{ Exception -> 0x00c6 }
            if (r7 == 0) goto L_0x00ad
            java.lang.String r4 = "type="
            r0.write(r4)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r7 = r7.name()     // Catch:{ Exception -> 0x00c6 }
            r0.write(r7)     // Catch:{ Exception -> 0x00c6 }
            r0.write(r3)     // Catch:{ Exception -> 0x00c6 }
        L_0x00ad:
            r0.flush()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r7 = "CACHE: done, cacheKey: "
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r7 = r7.concat(r3)     // Catch:{ Exception -> 0x00c6 }
            com.appsflyer.AFLogger.values(r7)     // Catch:{ Exception -> 0x00c6 }
            r0.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r7 = move-exception
            com.appsflyer.AFLogger.values(r7)
        L_0x00c5:
            return r2
        L_0x00c6:
            r7 = move-exception
            goto L_0x00cc
        L_0x00c8:
            r7 = move-exception
            goto L_0x00de
        L_0x00ca:
            r7 = move-exception
            r0 = r1
        L_0x00cc:
            java.lang.String r2 = "CACHE: Could not cache request"
            com.appsflyer.AFLogger.valueOf(r2, r7)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00db
            r0.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r7 = move-exception
            com.appsflyer.AFLogger.values(r7)
        L_0x00db:
            return r1
        L_0x00dc:
            r7 = move-exception
            r1 = r0
        L_0x00de:
            if (r1 == 0) goto L_0x00e8
            r1.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00e8
        L_0x00e4:
            r0 = move-exception
            com.appsflyer.AFLogger.values(r0)
        L_0x00e8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.l.AFInAppEventParameterName(com.appsflyer.internal.n):java.lang.String");
    }

    public final List<n> AFInAppEventType() {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.AFKeystoreWrapper.values.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (File file2 : listFiles) {
                StringBuilder sb = new StringBuilder("CACHE: Found cached request");
                sb.append(file2.getName());
                AFLogger.values(sb.toString());
                arrayList.add(values(file2));
            }
            return arrayList;
        } catch (Exception e2) {
            AFLogger.valueOf("CACHE: Could not get cached requests", e2);
        }
    }

    public final boolean valueOf(String str) {
        File file = new File(new File(this.AFKeystoreWrapper.values.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("CACHE: Deleting ");
        sb.append(str);
        sb.append(" from cache");
        AFLogger.values(sb.toString());
        if (!file.exists()) {
            return true;
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("CACHE: Could not delete ");
            sb2.append(str);
            sb2.append(" from cache");
            AFLogger.valueOf(sb2.toString(), e2);
            return false;
        }
    }

    public l(be beVar) {
        this.AFKeystoreWrapper = beVar;
    }
}
