package com.getkeepsafe.relinker;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance {
    public final ReLinker$LibraryInstaller libraryInstaller;
    public final ReLinker$LibraryLoader libraryLoader;
    public final Set<String> loadedLibraries = new HashSet();

    public ReLinkerInstance() {
        SystemLibraryLoader systemLibraryLoader = new SystemLibraryLoader();
        ApkLibraryInstaller apkLibraryInstaller = new ApkLibraryInstaller();
        this.libraryLoader = systemLibraryLoader;
        this.libraryInstaller = apkLibraryInstaller;
    }

    public File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    public File getWorkaroundLibFile(Context context, String str, String str2) {
        String mapLibraryName = ((SystemLibraryLoader) this.libraryLoader).mapLibraryName(str);
        if (ImageOriginUtils.isEmpty(str2)) {
            return new File(getWorkaroundLibDir(context), mapLibraryName);
        }
        return new File(getWorkaroundLibDir(context), GeneratedOutlineSupport.outline52(mapLibraryName, ".", str2));
    }

    public void loadLibrary(Context context, String str, String str2, ReLinker$LoadListener reLinker$LoadListener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!ImageOriginUtils.isEmpty(str)) {
            String.format(Locale.US, "Beginning load of %s...", new Object[]{str});
            if (reLinker$LoadListener == null) {
                loadLibraryInternal(context, str, str2);
                return;
            }
            final Context context2 = context;
            final String str3 = str;
            final String str4 = str2;
            final ReLinker$LoadListener reLinker$LoadListener2 = reLinker$LoadListener;
            AnonymousClass1 r1 = new Runnable() {
                public void run() {
                    try {
                        ReLinkerInstance.this.loadLibraryInternal(context2, str3, str4);
                        reLinker$LoadListener2.success();
                    } catch (UnsatisfiedLinkError e2) {
                        reLinker$LoadListener2.failure(e2);
                    } catch (MissingLibraryException e3) {
                        reLinker$LoadListener2.failure(e3);
                    }
                }
            };
            new Thread(r1).start();
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:58|59|60|61|154|113) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:79|80|81|(2:85|86)|(2:89|90)|91|92) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:62|63|64|65|66|67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0189, code lost:
        if (r11.zipFile == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0137, code lost:
        if (r11.zipFile == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0139, code lost:
        r11.zipFile.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0121 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0129 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x012c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0165 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0179 A[SYNTHETIC, Splitter:B:109:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0181 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0181 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015b A[SYNTHETIC, Splitter:B:85:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0162 A[SYNTHETIC, Splitter:B:89:0x0162] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x016a A[SYNTHETIC, Splitter:B:98:0x016a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x0165=Splitter:B:91:0x0165, B:66:0x012c=Splitter:B:66:0x012c} */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadLibraryInternal(android.content.Context r20, java.lang.String r21, java.lang.String r22) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.util.Set<java.lang.String> r0 = r1.loadedLibraries
            boolean r0 = r0.contains(r3)
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x001c
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r4] = r3
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "%s already loaded previously!"
            java.lang.String.format(r2, r3, r0)
            return
        L_0x001c:
            r6 = 2
            r7 = 0
            com.getkeepsafe.relinker.ReLinker$LibraryLoader r0 = r1.libraryLoader     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            com.getkeepsafe.relinker.SystemLibraryLoader r0 = (com.getkeepsafe.relinker.SystemLibraryLoader) r0     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            if (r0 == 0) goto L_0x003a
            java.lang.System.loadLibrary(r21)     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            java.util.Set<java.lang.String> r0 = r1.loadedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            r0.add(r3)     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            java.lang.String r0 = "%s (%s) was loaded normally!"
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            r8[r4] = r3     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            r8[r5] = r22     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            java.lang.String.format(r9, r0, r8)     // Catch:{ UnsatisfiedLinkError -> 0x003b }
            return
        L_0x003a:
            throw r7     // Catch:{ UnsatisfiedLinkError -> 0x003b }
        L_0x003b:
            r0 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r8[r4] = r0
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r9 = "Loading the library normally failed: %s"
            java.lang.String.format(r0, r9, r8)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r4] = r3
            r0[r5] = r22
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r9 = "%s (%s) was not loaded normally, re-linking..."
            java.lang.String.format(r8, r9, r0)
            java.io.File r0 = r19.getWorkaroundLibFile(r20, r21, r22)
            boolean r8 = r0.exists()
            if (r8 == 0) goto L_0x0064
            goto L_0x018c
        L_0x0064:
            java.io.File r8 = r19.getWorkaroundLibDir(r20)
            java.io.File r9 = r19.getWorkaroundLibFile(r20, r21, r22)
            com.getkeepsafe.relinker.ReLinker$LibraryLoader r10 = r1.libraryLoader
            com.getkeepsafe.relinker.SystemLibraryLoader r10 = (com.getkeepsafe.relinker.SystemLibraryLoader) r10
            java.lang.String r10 = r10.mapLibraryName(r3)
            com.getkeepsafe.relinker.ReLinkerInstance$2 r11 = new com.getkeepsafe.relinker.ReLinkerInstance$2
            r11.<init>(r1, r10)
            java.io.File[] r8 = r8.listFiles(r11)
            if (r8 != 0) goto L_0x0080
            goto L_0x009a
        L_0x0080:
            int r10 = r8.length
            r11 = 0
        L_0x0082:
            if (r11 >= r10) goto L_0x009a
            r12 = r8[r11]
            java.lang.String r13 = r12.getAbsolutePath()
            java.lang.String r14 = r9.getAbsolutePath()
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0097
            r12.delete()
        L_0x0097:
            int r11 = r11 + 1
            goto L_0x0082
        L_0x009a:
            com.getkeepsafe.relinker.ReLinker$LibraryInstaller r8 = r1.libraryInstaller
            com.getkeepsafe.relinker.ReLinker$LibraryLoader r9 = r1.libraryLoader
            com.getkeepsafe.relinker.SystemLibraryLoader r9 = (com.getkeepsafe.relinker.SystemLibraryLoader) r9
            if (r9 == 0) goto L_0x01db
            java.lang.String[] r9 = android.os.Build.SUPPORTED_ABIS
            int r10 = r9.length
            if (r10 <= 0) goto L_0x00a8
            goto L_0x00c1
        L_0x00a8:
            java.lang.String r9 = android.os.Build.CPU_ABI2
            boolean r9 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00bb
            java.lang.String[] r9 = new java.lang.String[r6]
            java.lang.String r10 = android.os.Build.CPU_ABI
            r9[r4] = r10
            java.lang.String r10 = android.os.Build.CPU_ABI2
            r9[r5] = r10
            goto L_0x00c1
        L_0x00bb:
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = android.os.Build.CPU_ABI
            r9[r4] = r10
        L_0x00c1:
            com.getkeepsafe.relinker.ReLinker$LibraryLoader r10 = r1.libraryLoader
            com.getkeepsafe.relinker.SystemLibraryLoader r10 = (com.getkeepsafe.relinker.SystemLibraryLoader) r10
            java.lang.String r10 = r10.mapLibraryName(r3)
            com.getkeepsafe.relinker.ApkLibraryInstaller r8 = (com.getkeepsafe.relinker.ApkLibraryInstaller) r8
            if (r8 == 0) goto L_0x01d9
            com.getkeepsafe.relinker.ApkLibraryInstaller$ZipFileInZipEntry r11 = r8.findAPKWithLibrary(r2, r9, r10, r1)     // Catch:{ all -> 0x01cb }
            if (r11 == 0) goto L_0x01b0
            r2 = 0
        L_0x00d4:
            int r8 = r2 + 1
            r9 = 5
            if (r2 >= r9) goto L_0x0187
            java.lang.String r2 = "Found %s! Extracting..."
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x01b5 }
            r9[r4] = r10     // Catch:{ all -> 0x01b5 }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ all -> 0x01b5 }
            java.lang.String.format(r12, r2, r9)     // Catch:{ all -> 0x01b5 }
            boolean r2 = r0.exists()     // Catch:{ IOException -> 0x0181 }
            if (r2 != 0) goto L_0x00f2
            boolean r2 = r0.createNewFile()     // Catch:{ IOException -> 0x0181 }
            if (r2 != 0) goto L_0x00f2
            goto L_0x0181
        L_0x00f2:
            java.util.zip.ZipFile r2 = r11.zipFile     // Catch:{ FileNotFoundException -> 0x0175, IOException -> 0x0166, all -> 0x0155 }
            java.util.zip.ZipEntry r9 = r11.zipEntry     // Catch:{ FileNotFoundException -> 0x0175, IOException -> 0x0166, all -> 0x0155 }
            java.io.InputStream r2 = r2.getInputStream(r9)     // Catch:{ FileNotFoundException -> 0x0175, IOException -> 0x0166, all -> 0x0155 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0176, IOException -> 0x0167, all -> 0x014f }
            r9.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0176, IOException -> 0x0167, all -> 0x014f }
            r12 = 4096(0x1000, float:5.74E-42)
            byte[] r12 = new byte[r12]     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            r13 = 0
        L_0x0105:
            int r15 = r2.read(r12)     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            r7 = -1
            if (r15 != r7) goto L_0x013f
            r9.flush()     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            java.io.FileDescriptor r7 = r9.getFD()     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            r7.sync()     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            long r17 = r0.length()     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            int r7 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x0126
            r2.close()     // Catch:{ IOException -> 0x0121 }
        L_0x0121:
            r9.close()     // Catch:{ IOException -> 0x0181 }
            goto L_0x0181
        L_0x0126:
            r2.close()     // Catch:{ IOException -> 0x0129 }
        L_0x0129:
            r9.close()     // Catch:{ IOException -> 0x012c }
        L_0x012c:
            r0.setReadable(r5, r4)     // Catch:{ all -> 0x01b5 }
            r0.setExecutable(r5, r4)     // Catch:{ all -> 0x01b5 }
            r0.setWritable(r5)     // Catch:{ all -> 0x01b5 }
            java.util.zip.ZipFile r2 = r11.zipFile     // Catch:{ IOException -> 0x018c }
            if (r2 == 0) goto L_0x018c
        L_0x0139:
            java.util.zip.ZipFile r2 = r11.zipFile     // Catch:{ IOException -> 0x018c }
            r2.close()     // Catch:{ IOException -> 0x018c }
            goto L_0x018c
        L_0x013f:
            r9.write(r12, r4, r15)     // Catch:{ FileNotFoundException -> 0x014d, IOException -> 0x014b, all -> 0x0148 }
            long r4 = (long) r15
            long r13 = r13 + r4
            r4 = 0
            r5 = 1
            r7 = 0
            goto L_0x0105
        L_0x0148:
            r0 = move-exception
            r7 = r9
            goto L_0x0151
        L_0x014b:
            goto L_0x0168
        L_0x014d:
            goto L_0x0177
        L_0x014f:
            r0 = move-exception
            r7 = 0
        L_0x0151:
            r16 = r7
            r7 = r2
            goto L_0x0159
        L_0x0155:
            r0 = move-exception
            r7 = 0
            r16 = 0
        L_0x0159:
            if (r7 == 0) goto L_0x0160
            r7.close()     // Catch:{ IOException -> 0x015f }
            goto L_0x0160
        L_0x015f:
        L_0x0160:
            if (r16 == 0) goto L_0x0165
            r16.close()     // Catch:{ IOException -> 0x0165 }
        L_0x0165:
            throw r0     // Catch:{ all -> 0x01b5 }
        L_0x0166:
            r2 = 0
        L_0x0167:
            r9 = 0
        L_0x0168:
            if (r2 == 0) goto L_0x016f
            r2.close()     // Catch:{ IOException -> 0x016e }
            goto L_0x016f
        L_0x016e:
        L_0x016f:
            if (r9 == 0) goto L_0x0181
        L_0x0171:
            r9.close()     // Catch:{ IOException -> 0x0181 }
            goto L_0x0181
        L_0x0175:
            r2 = 0
        L_0x0176:
            r9 = 0
        L_0x0177:
            if (r2 == 0) goto L_0x017e
            r2.close()     // Catch:{ IOException -> 0x017d }
            goto L_0x017e
        L_0x017d:
        L_0x017e:
            if (r9 == 0) goto L_0x0181
            goto L_0x0171
        L_0x0181:
            r2 = r8
            r4 = 0
            r5 = 1
            r7 = 0
            goto L_0x00d4
        L_0x0187:
            java.util.zip.ZipFile r2 = r11.zipFile     // Catch:{ IOException -> 0x018c }
            if (r2 == 0) goto L_0x018c
            goto L_0x0139
        L_0x018c:
            com.getkeepsafe.relinker.ReLinker$LibraryLoader r2 = r1.libraryLoader
            java.lang.String r0 = r0.getAbsolutePath()
            com.getkeepsafe.relinker.SystemLibraryLoader r2 = (com.getkeepsafe.relinker.SystemLibraryLoader) r2
            if (r2 == 0) goto L_0x01ae
            java.lang.System.load(r0)
            java.util.Set<java.lang.String> r0 = r1.loadedLibraries
            r0.add(r3)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r2 = 0
            r0[r2] = r3
            r2 = 1
            r0[r2] = r22
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "%s (%s) was re-linked!"
            java.lang.String.format(r2, r3, r0)
            return
        L_0x01ae:
            r2 = 0
            throw r2
        L_0x01b0:
            java.lang.String[] r0 = r8.getSupportedABIs(r2, r10)     // Catch:{ Exception -> 0x01b7 }
            goto L_0x01c3
        L_0x01b5:
            r0 = move-exception
            goto L_0x01c9
        L_0x01b7:
            r0 = move-exception
            r2 = r0
            r3 = 1
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01b5 }
            r3 = 0
            r0[r3] = r2     // Catch:{ all -> 0x01b5 }
        L_0x01c3:
            com.getkeepsafe.relinker.MissingLibraryException r2 = new com.getkeepsafe.relinker.MissingLibraryException     // Catch:{ all -> 0x01b5 }
            r2.<init>(r10, r9, r0)     // Catch:{ all -> 0x01b5 }
            throw r2     // Catch:{ all -> 0x01b5 }
        L_0x01c9:
            r7 = r11
            goto L_0x01cd
        L_0x01cb:
            r0 = move-exception
            r7 = 0
        L_0x01cd:
            if (r7 == 0) goto L_0x01d8
            java.util.zip.ZipFile r2 = r7.zipFile     // Catch:{ IOException -> 0x01d8 }
            if (r2 == 0) goto L_0x01d8
            java.util.zip.ZipFile r2 = r7.zipFile     // Catch:{ IOException -> 0x01d8 }
            r2.close()     // Catch:{ IOException -> 0x01d8 }
        L_0x01d8:
            throw r0
        L_0x01d9:
            r2 = r7
            throw r2
        L_0x01db:
            r2 = r7
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.ReLinkerInstance.loadLibraryInternal(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
