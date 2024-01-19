package com.shield.android.g;

import com.shield.android.internal.NativeUtils;
import com.shield.android.internal.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java8.util.concurrent.CompletableFuture;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1660a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1661b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1662c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1663d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1664e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1665f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean p;
    public NativeUtils q;
    public String[] r = {"magisk", "/sbin/.magisk/", "/sbin/.core/db-0/magisk.db"};

    public a(NativeUtils nativeUtils) {
        this.q = nativeUtils;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|(4:2|3|4|5)(2:12|(1:14))|15|16|(7:18|19|(2:(5:21|22|23|(2:25|(1:29)(1:38))(1:37)|30)(0)|32)|29|32|33|39)(1:41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0094 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00d8 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4 A[SYNTHETIC, Splitter:B:18:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r8 = this;
            com.shield.android.internal.NativeUtils r0 = r8.q
            boolean r0 = r0.a()
            r1 = 0
            if (r0 == 0) goto L_0x0085
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isDetectedDevKeys()     // Catch:{ Exception -> 0x0072 }
            r8.f1660a = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isDetectedTestKeys()     // Catch:{ Exception -> 0x0072 }
            r8.f1661b = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isNotFoundReleaseKeys()     // Catch:{ Exception -> 0x0072 }
            r8.f1662c = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundDangerousProps()     // Catch:{ Exception -> 0x0072 }
            r8.f1663d = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isPermissiveSelinux()     // Catch:{ Exception -> 0x0072 }
            r8.f1664e = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isSuExists()     // Catch:{ Exception -> 0x0072 }
            r8.f1665f = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isAccessedSuperuserApk()     // Catch:{ Exception -> 0x0072 }
            r8.g = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundSuBinary()     // Catch:{ Exception -> 0x0072 }
            r8.h = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundBusyboxBinary()     // Catch:{ Exception -> 0x0072 }
            r8.i = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundResetprop()     // Catch:{ Exception -> 0x0072 }
            r8.k = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundWrongPathPermission()     // Catch:{ Exception -> 0x0072 }
            r8.l = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r0.isFoundZygote()     // Catch:{ Exception -> 0x0072 }
            r8.p = r0     // Catch:{ Exception -> 0x0072 }
            com.shield.android.internal.NativeUtils r0 = r8.q     // Catch:{ Exception -> 0x0094 }
            boolean r0 = r0.isFoundXposed()     // Catch:{ Exception -> 0x0094 }
            r8.j = r0     // Catch:{ Exception -> 0x0094 }
            goto L_0x0094
        L_0x0072:
            r0 = move-exception
            com.shield.android.internal.f r2 = com.shield.android.internal.f.a()
            boolean r2 = r2.f1677b
            if (r2 == 0) goto L_0x0094
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x0094
            r0.getLocalizedMessage()
            goto L_0x0094
        L_0x0085:
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            boolean r0 = r0.f1677b
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = "Something went wrong loading library"
            java.lang.String.format(r0, r2)
        L_0x0094:
            boolean r0 = r8.a()     // Catch:{ Exception -> 0x00da }
            r8.m = r0     // Catch:{ Exception -> 0x00da }
            boolean r0 = r8.c()     // Catch:{ Exception -> 0x00da }
            r8.n = r0     // Catch:{ Exception -> 0x00da }
            boolean r0 = r8.j     // Catch:{ Exception -> 0x00da }
            if (r0 != 0) goto L_0x00da
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ Exception -> 0x00d8 }
            r0.<init>()     // Catch:{ Exception -> 0x00d8 }
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()     // Catch:{ Exception -> 0x00d8 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00d8 }
            r3 = 0
        L_0x00af:
            if (r3 >= r2) goto L_0x00d8
            r4 = r0[r3]     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = r4.getClassName()     // Catch:{ Exception -> 0x00d5 }
            if (r4 == 0) goto L_0x00d5
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = r4.toLowerCase(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r7 = "xposed"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x00d5 }
            if (r6 != 0) goto L_0x00d3
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r5 = "lsphooker"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x00d5 }
            if (r4 == 0) goto L_0x00d5
        L_0x00d3:
            r1 = 1
            goto L_0x00d8
        L_0x00d5:
            int r3 = r3 + 1
            goto L_0x00af
        L_0x00d8:
            r8.j = r1     // Catch:{ Exception -> 0x00da }
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.g.a.f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r10 = this;
            int r0 = android.os.Process.myPid()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r3[r4] = r0
            java.lang.String r0 = "/proc/%d/mounts"
            java.lang.String r0 = java.lang.String.format(r1, r0, r3)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0068 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0068 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0068 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0068 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0068 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0068 }
            r3 = 0
        L_0x002b:
            java.lang.String r5 = r1.readLine()     // Catch:{ IOException -> 0x0068 }
            if (r5 == 0) goto L_0x0044
            java.lang.String[] r6 = r10.r     // Catch:{ IOException -> 0x0068 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0068 }
            r8 = 0
        L_0x0035:
            if (r8 >= r7) goto L_0x002b
            r9 = r6[r8]     // Catch:{ IOException -> 0x0068 }
            boolean r9 = r5.contains(r9)     // Catch:{ IOException -> 0x0068 }
            if (r9 == 0) goto L_0x0041
            int r3 = r3 + 1
        L_0x0041:
            int r8 = r8 + 1
            goto L_0x0035
        L_0x0044:
            r1.close()     // Catch:{ IOException -> 0x0068 }
            r0.close()     // Catch:{ IOException -> 0x0068 }
            com.shield.android.internal.f r0 = com.shield.android.internal.f.a()     // Catch:{ IOException -> 0x0068 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0068 }
            r1.<init>()     // Catch:{ IOException -> 0x0068 }
            java.lang.String r5 = "Count of paths "
            r1.append(r5)     // Catch:{ IOException -> 0x0068 }
            r1.append(r3)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0068 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0068 }
            r0.a(r1, r5)     // Catch:{ IOException -> 0x0068 }
            if (r3 <= r2) goto L_0x0068
            r0 = 1
            goto L_0x0069
        L_0x0068:
            r0 = 0
        L_0x0069:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r1 < r3) goto L_0x0097
            com.shield.android.internal.NativeUtils r1 = r10.q
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0089
            com.shield.android.internal.NativeUtils r1 = r10.q
            boolean r1 = r1.isFoundMagisk()
            if (r1 != 0) goto L_0x0087
            com.shield.android.internal.NativeUtils r1 = r10.q
            boolean r1 = r1.isZygiskDetected()
            if (r1 == 0) goto L_0x0089
        L_0x0087:
            r1 = 1
            goto L_0x008a
        L_0x0089:
            r1 = 0
        L_0x008a:
            if (r0 != 0) goto L_0x0096
            boolean r0 = r10.b()
            if (r0 != 0) goto L_0x0096
            if (r1 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r2 = 0
        L_0x0096:
            return r2
        L_0x0097:
            com.shield.android.internal.NativeUtils r1 = r10.q
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x00a6
            com.shield.android.internal.NativeUtils r1 = r10.q
            boolean r1 = r1.isFoundMagisk()
            goto L_0x00a7
        L_0x00a6:
            r1 = 0
        L_0x00a7:
            if (r0 != 0) goto L_0x00b3
            boolean r0 = r10.b()
            if (r0 != 0) goto L_0x00b3
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r2 = 0
        L_0x00b3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.g.a.a():boolean");
    }

    public final boolean b() {
        try {
            Process exec = Runtime.getRuntime().exec("which magisk");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            bufferedReader.close();
            exec.waitFor();
            if (sb.toString().length() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c() {
        try {
            Process exec = Runtime.getRuntime().exec("which su");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            bufferedReader.close();
            exec.waitFor();
            if (sb.toString().length() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String d() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        boolean z = true;
        try {
            CompletableFuture.andTree(new CompletableFuture[]{CompletableFuture.runAsync(new Runnable() {
                public final void run() {
                    a.this.f();
                }
            }, newFixedThreadPool).exceptionally($$Lambda$Ahf0sNOdDGBGIINjYo6w7WXOe0.INSTANCE)}, 0, 0).get();
        } catch (Exception unused) {
        }
        newFixedThreadPool.shutdown();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isDetectedDevKeys", this.f1660a);
            jSONObject.put("isDetectedTestKeys", this.f1661b);
            jSONObject.put("isNotFoundReleaseKeys", this.f1662c);
            jSONObject.put("isFoundDangerousProps", this.f1663d);
            jSONObject.put("isPermissiveSelinux", this.f1664e);
            jSONObject.put("isSuExists", this.f1665f);
            jSONObject.put("isAccessedSuperuserApk", this.g);
            jSONObject.put("isFoundSuBinary", this.h);
            jSONObject.put("isFoundBusyboxBinary", this.i);
            jSONObject.put("isFoundXposed", this.j);
            jSONObject.put("isFoundResetprop", this.k);
            jSONObject.put("isFoundWrongPathPermission", this.l);
            if (!this.m) {
                z = false;
            }
            jSONObject.put("isFoundMagisk", z);
            jSONObject.put("isSuCommandFound", this.n);
            jSONObject.put("isFoundZygote", this.p);
            return jSONObject.toString();
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            return "";
        }
    }
}
