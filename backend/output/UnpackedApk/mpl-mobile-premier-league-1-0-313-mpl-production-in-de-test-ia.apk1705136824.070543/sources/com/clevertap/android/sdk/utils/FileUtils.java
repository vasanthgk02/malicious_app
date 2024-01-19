package com.clevertap.android.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import java.io.File;

public class FileUtils {
    public final CleverTapInstanceConfig config;
    public final Context context;

    public FileUtils(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
    }

    public void deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (FileUtils.class) {
                    File file = new File(this.context.getFilesDir(), str);
                    if (file.exists()) {
                        if (file.delete()) {
                            Logger logger = this.config.getLogger();
                            String str2 = this.config.accountId;
                            logger.verbose(str2, "File Deleted:" + str);
                        } else {
                            Logger logger2 = this.config.getLogger();
                            String str3 = this.config.accountId;
                            logger2.verbose(str3, "Failed to delete file" + str);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Logger logger3 = this.config.getLogger();
                String str4 = this.config.accountId;
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("writeFileOnInternalStorage: failed", str, " Error:");
                outline80.append(e2.getLocalizedMessage());
                logger3.verbose(str4, outline80.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readFromFile(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.<init>()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            android.content.Context r2 = r7.context     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.append(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.append(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            r1.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x0034:
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x003e
            r1.append(r0)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0034
        L_0x003e:
            r8.close()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0050 }
            r8.close()
            r2.close()
            r3.close()
            goto L_0x00a0
        L_0x0050:
            r0 = move-exception
            goto L_0x006d
        L_0x0052:
            r1 = move-exception
            r3 = r0
            goto L_0x005b
        L_0x0055:
            r1 = move-exception
            r3 = r0
            goto L_0x0060
        L_0x0058:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x005b:
            r0 = r1
            goto L_0x00a2
        L_0x005d:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x0060:
            r0 = r1
            goto L_0x006d
        L_0x0062:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
            goto L_0x00a2
        L_0x0068:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
        L_0x006d:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.config     // Catch:{ all -> 0x00a1 }
            com.clevertap.android.sdk.Logger r1 = r1.getLogger()     // Catch:{ all -> 0x00a1 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r7.config     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r4.accountId     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r5.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = "[Exception While Reading: "
            r5.append(r6)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x00a1 }
            r5.append(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00a1 }
            r1.verbose(r4, r0)     // Catch:{ all -> 0x00a1 }
            if (r8 == 0) goto L_0x0094
            r8.close()
        L_0x0094:
            if (r2 == 0) goto L_0x0099
            r2.close()
        L_0x0099:
            if (r3 == 0) goto L_0x009e
            r3.close()
        L_0x009e:
            java.lang.String r0 = ""
        L_0x00a0:
            return r0
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            if (r8 == 0) goto L_0x00a7
            r8.close()
        L_0x00a7:
            if (r2 == 0) goto L_0x00ac
            r2.close()
        L_0x00ac:
            if (r3 == 0) goto L_0x00b1
            r3.close()
        L_0x00b1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.FileUtils.readFromFile(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        r5 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeJsonToFile(java.lang.String r5, java.lang.String r6, org.json.JSONObject r7) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0053 }
            if (r1 != 0) goto L_0x0050
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0050
        L_0x000e:
            java.lang.Class<com.clevertap.android.sdk.utils.FileUtils> r1 = com.clevertap.android.sdk.utils.FileUtils.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0053 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0048 }
            android.content.Context r3 = r4.context     // Catch:{ all -> 0x0048 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ all -> 0x0048 }
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0048 }
            boolean r5 = r2.exists()     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x002a
            boolean r5 = r2.mkdir()     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x002a
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            return
        L_0x002a:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0048 }
            r5.<init>(r2, r6)     // Catch:{ all -> 0x0048 }
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ all -> 0x0048 }
            r2 = 0
            r6.<init>(r5, r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0044 }
            r6.append(r5)     // Catch:{ all -> 0x0044 }
            r6.flush()     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            r6.close()
            goto L_0x007f
        L_0x0044:
            r5 = move-exception
            r0 = r6
        L_0x0046:
            r6 = r4
            goto L_0x004a
        L_0x0048:
            r5 = move-exception
            goto L_0x0046
        L_0x004a:
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            throw r5     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            r5 = move-exception
            goto L_0x0055
        L_0x004e:
            r5 = move-exception
            goto L_0x004a
        L_0x0050:
            return
        L_0x0051:
            r5 = move-exception
            goto L_0x0080
        L_0x0053:
            r5 = move-exception
            r6 = r4
        L_0x0055:
            r5.printStackTrace()     // Catch:{ all -> 0x0051 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r6.config     // Catch:{ all -> 0x0051 }
            com.clevertap.android.sdk.Logger r7 = r7.getLogger()     // Catch:{ all -> 0x0051 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r6.config     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = r6.accountId     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "writeFileOnInternalStorage: failed"
            r1.append(r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0051 }
            r1.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0051 }
            r7.verbose(r6, r5)     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x007f
            r0.close()
        L_0x007f:
            return
        L_0x0080:
            if (r0 == 0) goto L_0x0085
            r0.close()
        L_0x0085:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.FileUtils.writeJsonToFile(java.lang.String, java.lang.String, org.json.JSONObject):void");
    }
}
