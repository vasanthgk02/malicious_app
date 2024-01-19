package com.userexperior.d.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.models.recording.f;
import com.userexperior.services.JIUploadService;
import com.userexperior.utilities.a;
import com.userexperior.utilities.b;
import com.userexperior.utilities.i;
import com.userexperior.utilities.k;
import java.io.File;
import java.util.logging.Level;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3919a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final Context f3920b;

    /* renamed from: c  reason: collision with root package name */
    public final i f3921c;

    /* renamed from: d  reason: collision with root package name */
    public final f f3922d;

    public c(Context context, f fVar) {
        this.f3920b = context == null ? a.a() : context;
        this.f3922d = fVar;
        this.f3921c = i.a();
    }

    private boolean a() {
        Context context = this.f3920b;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        return memoryInfo.lowMemory;
    }

    private boolean a(String str) {
        int i = 0;
        if (a()) {
            b.a(Level.WARNING, "!!! low memory during C&RD");
            return false;
        } else if (str == null) {
            return false;
        } else {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int i2 = 0;
            for (int i3 = 1; i3 < listFiles.length - 1; i3++) {
                if (i3 >= 0) {
                    if (k.a(listFiles[i2].getAbsolutePath(), listFiles[i3].getAbsolutePath())) {
                        new StringBuilder("deleting duplicate ").append(listFiles[i3].getName());
                        listFiles[i3].delete();
                        i++;
                    } else {
                        i2 = i3;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" duplicates removed");
            b.a(Level.INFO, "crd");
            return true;
        }
    }

    private boolean a(String str, com.userexperior.c.c.f fVar, boolean z) {
        Level level;
        String str2;
        if (!i.b()) {
            level = Level.SEVERE;
            str2 = "Device Not connected to Internet";
        } else if (str == null) {
            level = Level.WARNING;
            str2 = "there is no final path available. recording must not been started.";
        } else if (fVar == null) {
            return false;
        } else {
            JIUploadService.a(this.f3920b, fVar, z);
            return true;
        }
        b.a(level, str2);
        return false;
    }

    public static String b(String str) {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(str), File.separator, "events.json");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f9 A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0252 A[SYNTHETIC, Splitter:B:110:0x0252] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0267 A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0282 A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02a1 A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02ab A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168 A[SYNTHETIC, Splitter:B:63:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0170 A[SYNTHETIC, Splitter:B:67:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a0 A[SYNTHETIC, Splitter:B:84:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b9 A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bc A[Catch:{ Exception -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01cd A[Catch:{ Exception -> 0x02b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            java.lang.String r0 = ".zip"
            com.userexperior.models.recording.f r1 = r15.f3922d     // Catch:{ Exception -> 0x02b3 }
            if (r1 != 0) goto L_0x000e
            java.util.logging.Level r0 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r1 = "PrSt - SD NULL"
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x02b3 }
            return
        L_0x000e:
            android.content.Context r2 = com.userexperior.utilities.a.a()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r3 = r1.a()     // Catch:{ Exception -> 0x02b3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r5 = "perform stop for session id = "
            r4.<init>(r5)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r5 = r1.f4084a     // Catch:{ Exception -> 0x02b3 }
            r4.append(r5)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r5 = " uploadStatus : "
            r4.append(r5)     // Catch:{ Exception -> 0x02b3 }
            r4.append(r3)     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.a(r2, r1)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r4 = r1.f4086c     // Catch:{ Exception -> 0x02b3 }
            if (r4 != 0) goto L_0x0035
            java.lang.String r4 = com.userexperior.utilities.j.i(r2)     // Catch:{ Exception -> 0x02b3 }
        L_0x0035:
            boolean r2 = r1.k     // Catch:{ Exception -> 0x02b3 }
            boolean r5 = r1.l     // Catch:{ Exception -> 0x02b3 }
            int r6 = r3.ordinal()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r7 = com.userexperior.models.recording.enums.i.END_SQUARE_BRACKET_APPENDED     // Catch:{ Exception -> 0x02b3 }
            r7 = 1
            if (r6 >= r7) goto L_0x0104
            java.lang.String r6 = b(r4)     // Catch:{ Exception -> 0x02b3 }
            if (r6 == 0) goto L_0x00fb
            boolean r8 = r6.isEmpty()     // Catch:{ Exception -> 0x02b3 }
            if (r8 != 0) goto L_0x00fb
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x02b3 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x02b3 }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r9 = "rws"
            r6.<init>(r8, r9)     // Catch:{ Exception -> 0x00e0 }
            long r8 = r6.length()     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x007b
            long r8 = r6.length()     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            r10 = 1
            long r8 = r8 - r10
            r6.seek(r8)     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            java.lang.String r8 = "]"
            byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            r6.write(r8)     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            r6.length()     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            goto L_0x0084
        L_0x007b:
            java.lang.String r8 = "[]"
            byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
            r6.write(r8)     // Catch:{ IOException -> 0x00a6, Exception -> 0x008a }
        L_0x0084:
            r6.close()     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00fb
        L_0x0088:
            r8 = move-exception
            goto L_0x00dc
        L_0x008a:
            r8 = move-exception
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "Ex : ZAUR - aESrBr() "
            r10.<init>(r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = r8.getMessage()     // Catch:{ all -> 0x0088 }
            r10.append(r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0088 }
            com.userexperior.utilities.b.a(r9, r10)     // Catch:{ all -> 0x0088 }
            r8.getMessage()     // Catch:{ all -> 0x0088 }
            goto L_0x0084
        L_0x00a6:
            r8 = move-exception
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "Error appendEndSquareBracket(): "
            r10.<init>(r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = r8.getMessage()     // Catch:{ all -> 0x0088 }
            r10.append(r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0088 }
            com.userexperior.utilities.b.a(r9, r10)     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            java.lang.String r10 = "cause: "
            r9.<init>(r10)     // Catch:{ all -> 0x0088 }
            java.lang.Throwable r10 = r8.getCause()     // Catch:{ all -> 0x0088 }
            r9.append(r10)     // Catch:{ all -> 0x0088 }
            java.lang.String r10 = " message: "
            r9.append(r10)     // Catch:{ all -> 0x0088 }
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x0088 }
            r9.append(r10)     // Catch:{ all -> 0x0088 }
            r8.printStackTrace()     // Catch:{ all -> 0x0088 }
            goto L_0x0084
        L_0x00dc:
            r6.close()     // Catch:{ Exception -> 0x00e0 }
            throw r8     // Catch:{ Exception -> 0x00e0 }
        L_0x00e0:
            r6 = move-exception
            java.util.logging.Level r8 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x02b3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r10 = "Ex : ZAUR - aESrBr(out) "
            r9.<init>(r10)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r10 = r6.getMessage()     // Catch:{ Exception -> 0x02b3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.b.a(r8, r9)     // Catch:{ Exception -> 0x02b3 }
            r6.getMessage()     // Catch:{ Exception -> 0x02b3 }
        L_0x00fb:
            com.userexperior.models.recording.enums.i r6 = com.userexperior.models.recording.enums.i.END_SQUARE_BRACKET_APPENDED     // Catch:{ Exception -> 0x02b3 }
            r1.f4085b = r6     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r6 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.a(r6, r1)     // Catch:{ Exception -> 0x02b3 }
        L_0x0104:
            int r6 = r3.ordinal()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r8 = com.userexperior.models.recording.enums.i.JSON_FILE_CREATED     // Catch:{ Exception -> 0x02b3 }
            r8 = 2
            r9 = 0
            if (r6 >= r8) goto L_0x0193
            java.lang.String r6 = b(r4)     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.c.a.b r8 = new com.userexperior.c.a.b     // Catch:{ Exception -> 0x02b3 }
            r8.<init>()     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r10 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r6 = r8.a(r10, r6, r1)     // Catch:{ Exception -> 0x02b3 }
            if (r6 == 0) goto L_0x0183
            java.lang.String r8 = b(r4)     // Catch:{ Exception -> 0x02b3 }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x02b3 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x02b3 }
            boolean r8 = r10.exists()     // Catch:{ Exception -> 0x02b3 }
            if (r8 == 0) goto L_0x0179
            r8 = 0
            java.io.FileWriter r11 = new java.io.FileWriter     // Catch:{ Exception -> 0x0148 }
            r11.<init>(r10, r9)     // Catch:{ Exception -> 0x0148 }
            r11.write(r6)     // Catch:{ Exception -> 0x0143, all -> 0x0140 }
            r11.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x0179
        L_0x013b:
            r6 = move-exception
        L_0x013c:
            r6.printStackTrace()     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0179
        L_0x0140:
            r0 = move-exception
            r8 = r11
            goto L_0x016e
        L_0x0143:
            r6 = move-exception
            r8 = r11
            goto L_0x0149
        L_0x0146:
            r0 = move-exception
            goto L_0x016e
        L_0x0148:
            r6 = move-exception
        L_0x0149:
            java.util.logging.Level r10 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            java.lang.String r12 = "Ex : ZAUR - createJSON : "
            r11.<init>(r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r12 = r6.getMessage()     // Catch:{ all -> 0x0146 }
            r11.append(r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0146 }
            com.userexperior.utilities.b.a(r10, r11)     // Catch:{ all -> 0x0146 }
            r6.getMessage()     // Catch:{ all -> 0x0146 }
            r6.printStackTrace()     // Catch:{ all -> 0x0146 }
            if (r8 == 0) goto L_0x0179
            r8.close()     // Catch:{ IOException -> 0x016c }
            goto L_0x0179
        L_0x016c:
            r6 = move-exception
            goto L_0x013c
        L_0x016e:
            if (r8 == 0) goto L_0x0178
            r8.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0178
        L_0x0174:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x02b3 }
        L_0x0178:
            throw r0     // Catch:{ Exception -> 0x02b3 }
        L_0x0179:
            com.userexperior.models.recording.enums.i r6 = com.userexperior.models.recording.enums.i.JSON_FILE_CREATED     // Catch:{ Exception -> 0x02b3 }
            r1.f4085b = r6     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r6 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.a(r6, r1)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0193
        L_0x0183:
            android.content.Context r0 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.c.c.f r0 = com.userexperior.utilities.a.a(r0)     // Catch:{ Exception -> 0x02b3 }
            if (r2 != 0) goto L_0x018f
            if (r5 == 0) goto L_0x018e
            goto L_0x018f
        L_0x018e:
            r7 = 0
        L_0x018f:
            r15.a(r4, r0, r7)     // Catch:{ Exception -> 0x02b3 }
            return
        L_0x0193:
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x02b3 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x02b3 }
            java.io.File[] r8 = r6.listFiles()     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r10 = "screenshots"
            if (r8 == 0) goto L_0x01b9
            java.io.File[] r6 = r6.listFiles()     // Catch:{ Exception -> 0x02b3 }
            int r8 = r6.length     // Catch:{ Exception -> 0x02b3 }
            r11 = 0
            r12 = 0
        L_0x01a7:
            if (r11 >= r8) goto L_0x01ba
            r13 = r6[r11]     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r13 = r13.getName()     // Catch:{ Exception -> 0x02b3 }
            boolean r13 = r13.equals(r10)     // Catch:{ Exception -> 0x02b3 }
            if (r13 == 0) goto L_0x01b6
            r12 = 1
        L_0x01b6:
            int r11 = r11 + 1
            goto L_0x01a7
        L_0x01b9:
            r12 = 0
        L_0x01ba:
            if (r12 != 0) goto L_0x01c4
            com.userexperior.models.recording.enums.i r3 = com.userexperior.models.recording.enums.i.DUPLICATES_REMOVED     // Catch:{ Exception -> 0x02b3 }
            r1.f4085b = r3     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r3 = r1.a()     // Catch:{ Exception -> 0x02b3 }
        L_0x01c4:
            int r6 = r3.ordinal()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r8 = com.userexperior.models.recording.enums.i.DUPLICATES_REMOVED     // Catch:{ Exception -> 0x02b3 }
            r8 = 3
            if (r6 >= r8) goto L_0x01f0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            r6.<init>()     // Catch:{ Exception -> 0x02b3 }
            r6.append(r4)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Exception -> 0x02b3 }
            r6.append(r8)     // Catch:{ Exception -> 0x02b3 }
            r6.append(r10)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02b3 }
            boolean r6 = r15.a(r6)     // Catch:{ Exception -> 0x02b3 }
            if (r6 == 0) goto L_0x02b2
            com.userexperior.models.recording.enums.i r6 = com.userexperior.models.recording.enums.i.DUPLICATES_REMOVED     // Catch:{ Exception -> 0x02b3 }
            r1.f4085b = r6     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r6 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.a(r6, r1)     // Catch:{ Exception -> 0x02b3 }
        L_0x01f0:
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.models.recording.enums.i r6 = com.userexperior.models.recording.enums.i.FILES_ZIPPED     // Catch:{ Exception -> 0x02b3 }
            r6 = 4
            if (r3 >= r6) goto L_0x0299
            if (r2 == 0) goto L_0x020d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            r3.<init>()     // Catch:{ Exception -> 0x02b3 }
            r3.append(r4)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r6 = "_cr"
            r3.append(r6)     // Catch:{ Exception -> 0x02b3 }
        L_0x0208:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02b3 }
            goto L_0x021e
        L_0x020d:
            if (r5 == 0) goto L_0x021d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            r3.<init>()     // Catch:{ Exception -> 0x02b3 }
            r3.append(r4)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r6 = "_ar"
            r3.append(r6)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0208
        L_0x021d:
            r3 = r4
        L_0x021e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            r6.<init>()     // Catch:{ Exception -> 0x02b3 }
            r6.append(r3)     // Catch:{ Exception -> 0x02b3 }
            r6.append(r0)     // Catch:{ Exception -> 0x02b3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b3 }
            r6.<init>()     // Catch:{ Exception -> 0x02b3 }
            r6.append(r3)     // Catch:{ Exception -> 0x02b3 }
            r6.append(r0)     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x02b3 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r6 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r6 = com.userexperior.utilities.j.f(r6)     // Catch:{ Exception -> 0x02b3 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x02b3 }
            double r10 = com.userexperior.e.h.a(r3)     // Catch:{ Exception -> 0x02b3 }
            r12 = 4632233691727265792(0x4049000000000000, double:50.0)
            java.lang.String r6 = "zec"
            java.lang.String r8 = "!!! low memory during Z"
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0267
            boolean r3 = r15.a()     // Catch:{ Exception -> 0x02b3 }
            if (r3 != 0) goto L_0x0261
            com.userexperior.utilities.k.b(r4, r0)     // Catch:{ Exception -> 0x02b3 }
            java.util.logging.Level r0 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x02b3 }
        L_0x025d:
            com.userexperior.utilities.b.a(r0, r6)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0280
        L_0x0261:
            java.util.logging.Level r0 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x02b3 }
        L_0x0263:
            com.userexperior.utilities.b.a(r0, r8)     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0280
        L_0x0267:
            java.util.logging.Level r10 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r11 = "Buffer went beyond limit 50.....deleting data"
            com.userexperior.utilities.b.a(r10, r11)     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.e.h.b(r3)     // Catch:{ Exception -> 0x02b3 }
            boolean r3 = r15.a()     // Catch:{ Exception -> 0x02b3 }
            if (r3 != 0) goto L_0x027d
            com.userexperior.utilities.k.b(r4, r0)     // Catch:{ Exception -> 0x02b3 }
            java.util.logging.Level r0 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x02b3 }
            goto L_0x025d
        L_0x027d:
            java.util.logging.Level r0 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x02b3 }
            goto L_0x0263
        L_0x0280:
            if (r4 == 0) goto L_0x0290
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x02b3 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x02b3 }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x02b3 }
            if (r3 == 0) goto L_0x0290
            com.userexperior.e.h.b(r0)     // Catch:{ Exception -> 0x02b3 }
        L_0x0290:
            com.userexperior.models.recording.enums.i r0 = com.userexperior.models.recording.enums.i.FILES_ZIPPED     // Catch:{ Exception -> 0x02b3 }
            r1.f4085b = r0     // Catch:{ Exception -> 0x02b3 }
            android.content.Context r0 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.a(r0, r1)     // Catch:{ Exception -> 0x02b3 }
        L_0x0299:
            android.content.Context r0 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.c.c.f r0 = com.userexperior.utilities.a.a(r0)     // Catch:{ Exception -> 0x02b3 }
            if (r2 != 0) goto L_0x02a5
            if (r5 == 0) goto L_0x02a4
            goto L_0x02a5
        L_0x02a4:
            r7 = 0
        L_0x02a5:
            boolean r0 = r15.a(r4, r0, r7)     // Catch:{ Exception -> 0x02b3 }
            if (r0 == 0) goto L_0x02b2
            android.content.Context r0 = r15.f3920b     // Catch:{ Exception -> 0x02b3 }
            java.lang.String r1 = r1.r     // Catch:{ Exception -> 0x02b3 }
            com.userexperior.utilities.l.d(r0, r1)     // Catch:{ Exception -> 0x02b3 }
        L_0x02b2:
            return
        L_0x02b3:
            r0 = move-exception
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Ex : ZAUR - run() "
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.userexperior.utilities.b.a(r1, r2)
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.d.b.c.run():void");
    }
}
