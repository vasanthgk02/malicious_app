package com.microsoft.codepush.react;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.crashlytics.ndk.CrashpadController;
import java.io.IOException;
import org.json.JSONObject;

public class CodePushUpdateManager {
    public String mDocumentsDirectory;

    public CodePushUpdateManager(String str) {
        this.mDocumentsDirectory = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:205:0x03aa, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x03ab, code lost:
        r2 = "Error closing IO resources.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x03ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x03ae, code lost:
        r2 = "Error closing IO resources.";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0313 A[SYNTHETIC, Splitter:B:174:0x0313] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x031b A[Catch:{ IOException -> 0x0317 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0320 A[Catch:{ IOException -> 0x0317 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03aa A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03e8 A[SYNTHETIC, Splitter:B:235:0x03e8] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x03f0 A[Catch:{ IOException -> 0x03ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03f5 A[Catch:{ IOException -> 0x03ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x03fa A[Catch:{ IOException -> 0x03ec }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadPackage(org.json.JSONObject r24, java.lang.String r25, com.microsoft.codepush.react.DownloadProgressCallback r26, java.lang.String r27) throws java.io.IOException {
        /*
            r23 = this;
            r1 = r24
            r0 = r25
            r2 = r27
            java.lang.String r3 = "Error closing IO resources."
            java.lang.String r4 = "packageHash"
            r5 = 0
            java.lang.String r4 = r1.optString(r4, r5)
            r6 = r23
            java.lang.String r7 = r6.getPackageFolderPath(r4)
            java.lang.String r8 = "app.json"
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r7, r8)
            boolean r9 = com.google.android.material.resources.TextAppearanceConfig.fileAtPathExists(r7)
            if (r9 == 0) goto L_0x0024
            com.google.android.material.resources.TextAppearanceConfig.deleteDirectoryAtPath(r7)
        L_0x0024:
            java.lang.String r9 = "downloadUrl"
            java.lang.String r5 = r1.optString(r9, r5)
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            r9.<init>(r5)     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x03d6, all -> 0x03cf }
            java.lang.String r10 = "Accept-Encoding"
            java.lang.String r11 = "identity"
            r9.setRequestProperty(r10, r11)     // Catch:{ MalformedURLException -> 0x03ca, all -> 0x03c7 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x03ca, all -> 0x03c7 }
            java.io.InputStream r11 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x03ca, all -> 0x03c7 }
            r10.<init>(r11)     // Catch:{ MalformedURLException -> 0x03ca, all -> 0x03c7 }
            int r11 = r9.getContentLength()     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            long r11 = (long) r11     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.io.File r13 = new java.io.File     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.lang.String r14 = r23.getCodePushPath()     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            r13.<init>(r14)     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            r13.mkdirs()     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.io.File r14 = new java.io.File     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.lang.String r15 = "download.zip"
            r14.<init>(r13, r15)     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            r13.<init>(r14)     // Catch:{ MalformedURLException -> 0x03c2, all -> 0x03bf }
            java.io.BufferedOutputStream r15 = new java.io.BufferedOutputStream     // Catch:{ MalformedURLException -> 0x03b9, all -> 0x03b5 }
            r6 = 262144(0x40000, float:3.67342E-40)
            r15.<init>(r13, r6)     // Catch:{ MalformedURLException -> 0x03b9, all -> 0x03b5 }
            byte[] r6 = new byte[r6]     // Catch:{ MalformedURLException -> 0x03b0, all -> 0x03aa }
            r16 = r5
            r5 = 4
            byte[] r5 = new byte[r5]     // Catch:{ MalformedURLException -> 0x03ad, all -> 0x03aa }
            r17 = 0
            r19 = r3
            r20 = r4
            r3 = r17
        L_0x007e:
            r1 = 0
            r2 = 262144(0x40000, float:3.67342E-40)
            int r1 = r10.read(r6, r1, r2)     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            if (r1 < 0) goto L_0x00c8
            r21 = 4
            int r2 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a3
            r2 = 0
        L_0x008e:
            if (r2 >= r1) goto L_0x00a3
            r21 = r8
            int r8 = (int) r3     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            int r8 = r8 + r2
            r0 = 4
            if (r8 < r0) goto L_0x0098
            goto L_0x00a5
        L_0x0098:
            byte r0 = r6[r2]     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            r5[r8] = r0     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            int r2 = r2 + 1
            r0 = r25
            r8 = r21
            goto L_0x008e
        L_0x00a3:
            r21 = r8
        L_0x00a5:
            r2 = r7
            long r7 = (long) r1     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            long r3 = r3 + r7
            r0 = 0
            r15.write(r6, r0, r1)     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            com.microsoft.codepush.react.DownloadProgress r0 = new com.microsoft.codepush.react.DownloadProgress     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            r0.<init>(r11, r3)     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            r1 = r26
            com.microsoft.codepush.react.CodePushNativeModule$3$1 r1 = (com.microsoft.codepush.react.CodePushNativeModule.AnonymousClass3.AnonymousClass1) r1
            r1.call(r0)     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            r0 = r25
            r7 = r2
            r8 = r21
            r2 = r27
            goto L_0x007e
        L_0x00c0:
            r2 = r19
            goto L_0x03e6
        L_0x00c4:
            r2 = r19
            goto L_0x03de
        L_0x00c8:
            r2 = r7
            r21 = r8
            int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x037f
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            int r0 = r0.getInt()     // Catch:{ MalformedURLException -> 0x03a7, all -> 0x03a4 }
            r1 = 1347093252(0x504b0304, float:1.362389E10)
            r3 = 1
            if (r0 != r1) goto L_0x00df
            r0 = 1
            goto L_0x00e0
        L_0x00df:
            r0 = 0
        L_0x00e0:
            r15.close()     // Catch:{ IOException -> 0x0376 }
            r13.close()     // Catch:{ IOException -> 0x0376 }
            r10.close()     // Catch:{ IOException -> 0x0376 }
            r9.disconnect()     // Catch:{ IOException -> 0x0376 }
            if (r0 == 0) goto L_0x032b
            java.lang.String r0 = r23.getCodePushPath()
            java.lang.String r1 = "unzipped"
            java.lang.String r0 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r0, r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x030b }
            r1.<init>(r14)     // Catch:{ all -> 0x030b }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0307 }
            r4.<init>(r1)     // Catch:{ all -> 0x0307 }
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x0303 }
            r5.<init>(r4)     // Catch:{ all -> 0x0303 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x02ff }
            r6.<init>(r0)     // Catch:{ all -> 0x02ff }
            boolean r7 = r6.exists()     // Catch:{ all -> 0x02ff }
            if (r7 == 0) goto L_0x0115
            com.google.android.material.resources.TextAppearanceConfig.deleteFileOrFolderSilently(r6)     // Catch:{ all -> 0x02ff }
        L_0x0115:
            r6.mkdirs()     // Catch:{ all -> 0x02ff }
            r7 = 8192(0x2000, float:1.148E-41)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x02ff }
        L_0x011c:
            java.util.zip.ZipEntry r8 = r5.getNextEntry()     // Catch:{ all -> 0x02ff }
            if (r8 == 0) goto L_0x0182
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x02ff }
            java.lang.String r10 = r6.getCanonicalPath()     // Catch:{ all -> 0x02ff }
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x02ff }
            r11.<init>(r10, r9)     // Catch:{ all -> 0x02ff }
            java.lang.String r9 = r11.getCanonicalPath()     // Catch:{ all -> 0x02ff }
            boolean r10 = r9.startsWith(r10)     // Catch:{ all -> 0x02ff }
            if (r10 == 0) goto L_0x017a
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x02ff }
            r10.<init>(r9)     // Catch:{ all -> 0x02ff }
            boolean r9 = r8.isDirectory()     // Catch:{ all -> 0x02ff }
            if (r9 == 0) goto L_0x0148
            r10.mkdirs()     // Catch:{ all -> 0x02ff }
            goto L_0x0169
        L_0x0148:
            java.io.File r9 = r10.getParentFile()     // Catch:{ all -> 0x02ff }
            boolean r11 = r9.exists()     // Catch:{ all -> 0x02ff }
            if (r11 != 0) goto L_0x0155
            r9.mkdirs()     // Catch:{ all -> 0x02ff }
        L_0x0155:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x02ff }
            r9.<init>(r10)     // Catch:{ all -> 0x02ff }
        L_0x015a:
            int r11 = r5.read(r7)     // Catch:{ all -> 0x0175 }
            r12 = -1
            if (r11 == r12) goto L_0x0166
            r12 = 0
            r9.write(r7, r12, r11)     // Catch:{ all -> 0x0175 }
            goto L_0x015a
        L_0x0166:
            r9.close()     // Catch:{ all -> 0x02ff }
        L_0x0169:
            long r8 = r8.getTime()     // Catch:{ all -> 0x02ff }
            int r11 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x011c
            r10.setLastModified(r8)     // Catch:{ all -> 0x02ff }
            goto L_0x011c
        L_0x0175:
            r0 = move-exception
            r9.close()     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x017a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "File is outside extraction target directory."
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x0182:
            r5.close()     // Catch:{ IOException -> 0x02f6 }
            r4.close()     // Catch:{ IOException -> 0x02f6 }
            r1.close()     // Catch:{ IOException -> 0x02f6 }
            com.google.android.material.resources.TextAppearanceConfig.deleteFileOrFolderSilently(r14)
            java.lang.String r1 = "hotcodepush.json"
            java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r0, r1)
            boolean r4 = com.google.android.material.resources.TextAppearanceConfig.fileAtPathExists(r1)
            if (r4 == 0) goto L_0x01a9
            java.lang.String r5 = r23.getCurrentPackageFolderPath()
            com.microsoft.codepush.react.CodePushUpdateUtils.copyNecessaryFilesFromCurrentPackage(r1, r5, r2)
            java.io.File r5 = new java.io.File
            r5.<init>(r1)
            r5.delete()
        L_0x01a9:
            com.google.android.material.resources.TextAppearanceConfig.copyDirectoryContents(r0, r2)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            com.google.android.material.resources.TextAppearanceConfig.deleteFileOrFolderSilently(r1)
            r0 = r25
            java.lang.String r1 = com.microsoft.codepush.react.CodePushUpdateUtils.findJSBundleInUpdateContents(r2, r0)
            if (r1 == 0) goto L_0x02e8
            boolean r0 = com.google.android.material.resources.TextAppearanceConfig.fileAtPathExists(r21)
            if (r0 == 0) goto L_0x01cd
            java.io.File r0 = new java.io.File
            r5 = r21
            r0.<init>(r5)
            r0.delete()
            goto L_0x01cf
        L_0x01cd:
            r5 = r21
        L_0x01cf:
            r0 = r27
            if (r0 == 0) goto L_0x01d4
            goto L_0x01d5
        L_0x01d4:
            r3 = 0
        L_0x01d5:
            java.lang.String r6 = "CodePush"
            java.lang.String r7 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r2, r6)
            java.lang.String r8 = ".codepushrelease"
            java.lang.String r7 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r7, r8)
            boolean r7 = com.google.android.material.resources.TextAppearanceConfig.fileAtPathExists(r7)
            if (r3 == 0) goto L_0x02d3
            if (r7 == 0) goto L_0x02cb
            r3 = r20
            com.microsoft.codepush.react.CodePushUpdateUtils.verifyFolderHash(r2, r3)
            java.lang.String r4 = ""
            java.lang.String r7 = "-----BEGIN PUBLIC KEY-----"
            java.lang.String r0 = r0.replace(r7, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = "-----END PUBLIC KEY-----"
            java.lang.String r0 = r0.replace(r7, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = com.microsoft.codepush.react.CodePushUpdateUtils.NEW_LINE     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = r0.replace(r7, r4)     // Catch:{ Exception -> 0x021b }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x021b }
            r4 = 0
            byte[] r0 = android.util.Base64.decode(r0, r4)     // Catch:{ Exception -> 0x021b }
            java.security.spec.X509EncodedKeySpec r4 = new java.security.spec.X509EncodedKeySpec     // Catch:{ Exception -> 0x021b }
            r4.<init>(r0)     // Catch:{ Exception -> 0x021b }
            java.lang.String r0 = "RSA"
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0)     // Catch:{ Exception -> 0x021b }
            java.security.PublicKey r0 = r0.generatePublic(r4)     // Catch:{ Exception -> 0x021b }
            goto L_0x0227
        L_0x021b:
            r0 = move-exception
            r0.getMessage()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r0.toString()
            r0 = 0
        L_0x0227:
            r4 = r0
            if (r4 == 0) goto L_0x02c3
            java.lang.String r0 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r2, r6)
            java.lang.String r0 = com.google.android.material.resources.TextAppearanceConfig.appendPathComponent(r0, r8)
            java.lang.String r0 = com.google.android.material.resources.TextAppearanceConfig.readFileToString(r0)     // Catch:{ IOException -> 0x0237 }
            goto L_0x0244
        L_0x0237:
            r0 = move-exception
            r2 = r0
            r2.getMessage()
            java.lang.StackTraceElement[] r0 = r2.getStackTrace()
            r0.toString()
            r0 = 0
        L_0x0244:
            if (r0 == 0) goto L_0x02bb
            com.nimbusds.jwt.SignedJWT r0 = com.nimbusds.jwt.SignedJWT.parse(r0)     // Catch:{ Exception -> 0x0284 }
            com.nimbusds.jose.crypto.RSASSAVerifier r2 = new com.nimbusds.jose.crypto.RSASSAVerifier     // Catch:{ Exception -> 0x0284 }
            java.security.interfaces.RSAPublicKey r4 = (java.security.interfaces.RSAPublicKey) r4     // Catch:{ Exception -> 0x0284 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0284 }
            boolean r2 = r0.verify(r2)     // Catch:{ Exception -> 0x0284 }
            if (r2 == 0) goto L_0x028f
            com.nimbusds.jose.Payload r0 = r0.payload     // Catch:{ Exception -> 0x0284 }
            net.minidev.json.JSONObject r2 = r0.jsonObject     // Catch:{ Exception -> 0x0284 }
            if (r2 == 0) goto L_0x025e
            goto L_0x026b
        L_0x025e:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0284 }
            if (r0 != 0) goto L_0x0265
            goto L_0x026a
        L_0x0265:
            net.minidev.json.JSONObject r2 = com.google.android.material.resources.TextAppearanceConfig.parse(r0)     // Catch:{ ParseException -> 0x026a }
            goto L_0x026b
        L_0x026a:
            r2 = 0
        L_0x026b:
            if (r2 == 0) goto L_0x027b
            com.nimbusds.jwt.JWTClaimsSet r0 = com.nimbusds.jwt.JWTClaimsSet.parse(r2)     // Catch:{ Exception -> 0x0284 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.claims     // Catch:{ Exception -> 0x0284 }
            java.util.Map r0 = java.util.Collections.unmodifiableMap(r0)     // Catch:{ Exception -> 0x0284 }
            r0.toString()     // Catch:{ Exception -> 0x0284 }
            goto L_0x0290
        L_0x027b:
            java.text.ParseException r0 = new java.text.ParseException     // Catch:{ Exception -> 0x0284 }
            java.lang.String r2 = "Payload of JWS object is not a valid JSON object"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x0284 }
            throw r0     // Catch:{ Exception -> 0x0284 }
        L_0x0284:
            r0 = move-exception
            r0.getMessage()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r0.toString()
        L_0x028f:
            r0 = 0
        L_0x0290:
            if (r0 == 0) goto L_0x02b3
            java.lang.String r2 = "contentHash"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x02ab
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02a3
            goto L_0x02e0
        L_0x02a3:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "The update contents failed the code signing check."
            r0.<init>(r1)
            throw r0
        L_0x02ab:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "The update could not be verified because the signature did not specify a content hash."
            r0.<init>(r1)
            throw r0
        L_0x02b3:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "The update could not be verified because it was not signed by a trusted party."
            r0.<init>(r1)
            throw r0
        L_0x02bb:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "The update could not be verified because no signature was found."
            r0.<init>(r1)
            throw r0
        L_0x02c3:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "The update could not be verified because no public key was found."
            r0.<init>(r1)
            throw r0
        L_0x02cb:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r0 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r1 = "Error! Public key was provided but there is no JWT signature within app bundle to verify. Possible reasons, why that might happen: \n1. You've been released CodePush bundle update using version of CodePush CLI that is not support code signing.\n2. You've been released CodePush bundle update without providing --privateKeyPath option."
            r0.<init>(r1)
            throw r0
        L_0x02d3:
            r3 = r20
            if (r7 == 0) goto L_0x02db
            com.microsoft.codepush.react.CodePushUpdateUtils.verifyFolderHash(r2, r3)
            goto L_0x02e0
        L_0x02db:
            if (r4 == 0) goto L_0x02e0
            com.microsoft.codepush.react.CodePushUpdateUtils.verifyFolderHash(r2, r3)
        L_0x02e0:
            java.lang.String r0 = "bundlePath"
            r3 = r24
            com.google.android.material.resources.TextAppearanceConfig.setJSONValueForKey(r3, r0, r1)
            goto L_0x034a
        L_0x02e8:
            com.microsoft.codepush.react.CodePushInvalidUpdateException r1 = new com.microsoft.codepush.react.CodePushInvalidUpdateException
            java.lang.String r2 = "Update is invalid - A JS bundle file named \""
            java.lang.String r3 = "\" could not be found within the downloaded contents. Please check that you are releasing your CodePush updates using the exact same JS bundle file name that was shipped with your app's binary."
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x02f6:
            r0 = move-exception
            com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException
            r2 = r19
            r1.<init>(r2, r0)
            throw r1
        L_0x02ff:
            r0 = move-exception
            r2 = r19
            goto L_0x0311
        L_0x0303:
            r0 = move-exception
            r2 = r19
            goto L_0x0310
        L_0x0307:
            r0 = move-exception
            r2 = r19
            goto L_0x030f
        L_0x030b:
            r0 = move-exception
            r2 = r19
            r1 = 0
        L_0x030f:
            r4 = 0
        L_0x0310:
            r5 = 0
        L_0x0311:
            if (r5 == 0) goto L_0x0319
            r5.close()     // Catch:{ IOException -> 0x0317 }
            goto L_0x0319
        L_0x0317:
            r0 = move-exception
            goto L_0x0324
        L_0x0319:
            if (r4 == 0) goto L_0x031e
            r4.close()     // Catch:{ IOException -> 0x0317 }
        L_0x031e:
            if (r1 == 0) goto L_0x032a
            r1.close()     // Catch:{ IOException -> 0x0317 }
            goto L_0x032a
        L_0x0324:
            com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException
            r1.<init>(r2, r0)
            throw r1
        L_0x032a:
            throw r0
        L_0x032b:
            r3 = r24
            r0 = r25
            r5 = r21
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            boolean r4 = r1.exists()
            if (r4 != 0) goto L_0x033f
            r1.mkdirs()
        L_0x033f:
            java.io.File r1 = new java.io.File
            r1.<init>(r2, r0)
            boolean r0 = r14.renameTo(r1)
            if (r0 == 0) goto L_0x034e
        L_0x034a:
            com.google.android.material.resources.TextAppearanceConfig.writeJsonToFile(r3, r5)
            return
        L_0x034e:
            com.microsoft.codepush.react.CodePushUnknownException r0 = new com.microsoft.codepush.react.CodePushUnknownException
            java.lang.String r2 = "Unable to move file from "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r14.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = " to "
            r2.append(r3)
            java.lang.String r1 = r1.getAbsolutePath()
            r2.append(r1)
            java.lang.String r1 = "."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0376:
            r0 = move-exception
            r2 = r19
            com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException
            r1.<init>(r2, r0)
            throw r1
        L_0x037f:
            r2 = r19
            com.microsoft.codepush.react.CodePushUnknownException r0 = new com.microsoft.codepush.react.CodePushUnknownException     // Catch:{ MalformedURLException -> 0x03a2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x03a2 }
            r1.<init>()     // Catch:{ MalformedURLException -> 0x03a2 }
            java.lang.String r5 = "Received "
            r1.append(r5)     // Catch:{ MalformedURLException -> 0x03a2 }
            r1.append(r3)     // Catch:{ MalformedURLException -> 0x03a2 }
            java.lang.String r3 = " bytes, expected "
            r1.append(r3)     // Catch:{ MalformedURLException -> 0x03a2 }
            r1.append(r11)     // Catch:{ MalformedURLException -> 0x03a2 }
            java.lang.String r1 = r1.toString()     // Catch:{ MalformedURLException -> 0x03a2 }
            r0.<init>(r1)     // Catch:{ MalformedURLException -> 0x03a2 }
            throw r0     // Catch:{ MalformedURLException -> 0x03a2 }
        L_0x03a0:
            r0 = move-exception
            goto L_0x03e6
        L_0x03a2:
            r0 = move-exception
            goto L_0x03de
        L_0x03a4:
            r0 = move-exception
            goto L_0x00c0
        L_0x03a7:
            r0 = move-exception
            goto L_0x00c4
        L_0x03aa:
            r0 = move-exception
            r2 = r3
            goto L_0x03e6
        L_0x03ad:
            r0 = move-exception
            r2 = r3
            goto L_0x03de
        L_0x03b0:
            r0 = move-exception
            r2 = r3
            r16 = r5
            goto L_0x03de
        L_0x03b5:
            r0 = move-exception
            r2 = r3
            r15 = 0
            goto L_0x03e6
        L_0x03b9:
            r0 = move-exception
            r2 = r3
            r16 = r5
            r15 = 0
            goto L_0x03de
        L_0x03bf:
            r0 = move-exception
            r2 = r3
            goto L_0x03d3
        L_0x03c2:
            r0 = move-exception
            r2 = r3
            r16 = r5
            goto L_0x03dc
        L_0x03c7:
            r0 = move-exception
            r2 = r3
            goto L_0x03d2
        L_0x03ca:
            r0 = move-exception
            r2 = r3
            r16 = r5
            goto L_0x03db
        L_0x03cf:
            r0 = move-exception
            r2 = r3
            r9 = 0
        L_0x03d2:
            r10 = 0
        L_0x03d3:
            r15 = 0
            r13 = 0
            goto L_0x03e6
        L_0x03d6:
            r0 = move-exception
            r2 = r3
            r16 = r5
            r9 = 0
        L_0x03db:
            r10 = 0
        L_0x03dc:
            r15 = 0
            r13 = 0
        L_0x03de:
            com.microsoft.codepush.react.CodePushMalformedDataException r1 = new com.microsoft.codepush.react.CodePushMalformedDataException     // Catch:{ all -> 0x03a0 }
            r3 = r16
            r1.<init>(r3, r0)     // Catch:{ all -> 0x03a0 }
            throw r1     // Catch:{ all -> 0x03a0 }
        L_0x03e6:
            if (r15 == 0) goto L_0x03ee
            r15.close()     // Catch:{ IOException -> 0x03ec }
            goto L_0x03ee
        L_0x03ec:
            r0 = move-exception
            goto L_0x03fe
        L_0x03ee:
            if (r13 == 0) goto L_0x03f3
            r13.close()     // Catch:{ IOException -> 0x03ec }
        L_0x03f3:
            if (r10 == 0) goto L_0x03f8
            r10.close()     // Catch:{ IOException -> 0x03ec }
        L_0x03f8:
            if (r9 == 0) goto L_0x0404
            r9.disconnect()     // Catch:{ IOException -> 0x03ec }
            goto L_0x0404
        L_0x03fe:
            com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException
            r1.<init>(r2, r0)
            throw r1
        L_0x0404:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.CodePushUpdateManager.downloadPackage(org.json.JSONObject, java.lang.String, com.microsoft.codepush.react.DownloadProgressCallback, java.lang.String):void");
    }

    public final String getCodePushPath() {
        return TextAppearanceConfig.appendPathComponent(this.mDocumentsDirectory, "CodePush");
    }

    public JSONObject getCurrentPackage() {
        String optString = getCurrentPackageInfo().optString("currentPackage", null);
        if (optString == null) {
            return null;
        }
        return getPackage(optString);
    }

    public String getCurrentPackageBundlePath(String str) {
        String currentPackageFolderPath = getCurrentPackageFolderPath();
        if (currentPackageFolderPath == null) {
            return null;
        }
        JSONObject currentPackage = getCurrentPackage();
        if (currentPackage == null) {
            return null;
        }
        String optString = currentPackage.optString("bundlePath", null);
        if (optString == null) {
            return TextAppearanceConfig.appendPathComponent(currentPackageFolderPath, str);
        }
        return TextAppearanceConfig.appendPathComponent(currentPackageFolderPath, optString);
    }

    public String getCurrentPackageFolderPath() {
        String optString = getCurrentPackageInfo().optString("currentPackage", null);
        if (optString == null) {
            return null;
        }
        return TextAppearanceConfig.appendPathComponent(getCodePushPath(), optString);
    }

    public JSONObject getCurrentPackageInfo() {
        String appendPathComponent = TextAppearanceConfig.appendPathComponent(getCodePushPath(), "codepush.json");
        if (!TextAppearanceConfig.fileAtPathExists(appendPathComponent)) {
            return new JSONObject();
        }
        try {
            return TextAppearanceConfig.getJsonObjectFromFile(appendPathComponent);
        } catch (IOException e2) {
            throw new CodePushUnknownException("Error getting current package info", e2);
        }
    }

    public JSONObject getPackage(String str) {
        try {
            return TextAppearanceConfig.getJsonObjectFromFile(TextAppearanceConfig.appendPathComponent(TextAppearanceConfig.appendPathComponent(getCodePushPath(), str), CrashpadController.APP_METADATA_FILE));
        } catch (IOException unused) {
            return null;
        }
    }

    public String getPackageFolderPath(String str) {
        return TextAppearanceConfig.appendPathComponent(getCodePushPath(), str);
    }

    public void installPackage(JSONObject jSONObject, boolean z) {
        String optString = jSONObject.optString("packageHash", null);
        JSONObject currentPackageInfo = getCurrentPackageInfo();
        String optString2 = currentPackageInfo.optString("currentPackage", null);
        if (optString == null || !optString.equals(optString2)) {
            if (z) {
                String currentPackageFolderPath = getCurrentPackageFolderPath();
                if (currentPackageFolderPath != null) {
                    TextAppearanceConfig.deleteDirectoryAtPath(currentPackageFolderPath);
                }
            } else {
                String optString3 = getCurrentPackageInfo().optString("previousPackage", null);
                if (optString3 != null && !optString3.equals(optString)) {
                    TextAppearanceConfig.deleteDirectoryAtPath(TextAppearanceConfig.appendPathComponent(getCodePushPath(), optString3));
                }
                TextAppearanceConfig.setJSONValueForKey(currentPackageInfo, "previousPackage", currentPackageInfo.optString("currentPackage", null));
            }
            TextAppearanceConfig.setJSONValueForKey(currentPackageInfo, "currentPackage", optString);
            updateCurrentPackageInfo(currentPackageInfo);
        }
    }

    public void updateCurrentPackageInfo(JSONObject jSONObject) {
        try {
            TextAppearanceConfig.writeJsonToFile(jSONObject, TextAppearanceConfig.appendPathComponent(getCodePushPath(), "codepush.json"));
        } catch (IOException e2) {
            throw new CodePushUnknownException("Error updating current package info", e2);
        }
    }
}
