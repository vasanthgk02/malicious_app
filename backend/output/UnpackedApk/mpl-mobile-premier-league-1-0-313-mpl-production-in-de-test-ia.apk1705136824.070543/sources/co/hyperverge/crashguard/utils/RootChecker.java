package co.hyperverge.crashguard.utils;

import android.content.Context;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lco/hyperverge/crashguard/utils/RootChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDeviceRooted", "", "isDeviceRooted$crashguard_release", "()Z", "checkRootFiles", "checkRootPackages", "checkSUExist", "checkTestKeys", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RootChecker.kt */
public final class RootChecker {
    public static final Companion Companion = new Companion(null);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final String[] rootFiles = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"};
    public static final String[] rootPackages = {"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"};
    public final Context context;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lco/hyperverge/crashguard/utils/RootChecker$Companion;", "", "()V", "UTF_8", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "rootFiles", "", "", "[Ljava/lang/String;", "rootPackages", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RootChecker.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public RootChecker(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        throw r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isDeviceRooted$crashguard_release() {
        /*
            r8 = this;
            java.lang.String r0 = android.os.Build.TAGS
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
            r3 = 2
            java.lang.String r4 = "test-keys"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r4, r2, r3)
            if (r0 == 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x00a1
            java.lang.String[] r0 = rootFiles
            int r3 = r0.length
            r4 = 0
        L_0x0018:
            if (r4 >= r3) goto L_0x0030
            r5 = r0[r4]
            int r4 = r4 + 1
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x002b }
            r6.<init>(r5)     // Catch:{ all -> 0x002b }
            boolean r5 = r6.exists()     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x0018
            r0 = 1
            goto L_0x0031
        L_0x002b:
            r5 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r5)
            goto L_0x0018
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 != 0) goto L_0x00a1
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r3 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r3}
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0079, all -> 0x0070 }
            java.lang.Process r0 = r4.exec(r0)     // Catch:{ Exception -> 0x0079, all -> 0x0070 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.nio.charset.Charset r7 = UTF_8     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r4.<init>(r5)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x0064 }
            if (r5 == 0) goto L_0x005c
            r5 = 1
            goto L_0x005d
        L_0x005c:
            r5 = 0
        L_0x005d:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r3)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r0.destroy()
            goto L_0x0081
        L_0x0064:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r5 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r3)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            throw r5     // Catch:{ Exception -> 0x006e, all -> 0x006b }
        L_0x006b:
            r1 = move-exception
            r3 = r0
            goto L_0x0072
        L_0x006e:
            r3 = r0
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            r1 = r0
        L_0x0072:
            if (r3 != 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r3.destroy()
        L_0x0078:
            throw r1
        L_0x0079:
        L_0x007a:
            if (r3 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r3.destroy()
        L_0x0080:
            r5 = 0
        L_0x0081:
            if (r5 != 0) goto L_0x00a1
            android.content.Context r0 = r8.context
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto L_0x009c
            java.lang.String[] r3 = rootPackages
            int r4 = r3.length
            r5 = 0
        L_0x008f:
            if (r5 >= r4) goto L_0x009c
            r6 = r3[r5]
            int r5 = r5 + 1
            r0.getPackageInfo(r6, r2)     // Catch:{ NameNotFoundException -> 0x009a }
            r0 = 1
            goto L_0x009d
        L_0x009a:
            goto L_0x008f
        L_0x009c:
            r0 = 0
        L_0x009d:
            if (r0 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.utils.RootChecker.isDeviceRooted$crashguard_release():boolean");
    }
}
