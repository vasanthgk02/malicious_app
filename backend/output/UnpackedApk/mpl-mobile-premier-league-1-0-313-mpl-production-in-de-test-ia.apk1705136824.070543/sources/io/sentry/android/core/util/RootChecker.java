package io.sentry.android.core.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.IBuildInfoProvider;
import io.sentry.util.Objects;
import java.io.File;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class RootChecker {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final IBuildInfoProvider buildInfoProvider;
    public final Context context;
    public final ILogger logger;
    public final String[] rootFiles;
    public final String[] rootPackages;
    public final Runtime runtime;

    public RootChecker(Context context2, IBuildInfoProvider iBuildInfoProvider, ILogger iLogger) {
        this(context2, iBuildInfoProvider, iLogger, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    private boolean checkRootFiles() {
        String[] strArr = this.rootFiles;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                if (new File(str).exists()) {
                    return true;
                }
                i++;
            } catch (RuntimeException e2) {
                this.logger.log(SentryLevel.ERROR, e2, "Error when trying to check if root file %s exists.", str);
            }
        }
        return false;
    }

    private boolean checkRootPackages() {
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager != null) {
            String[] strArr = this.rootPackages;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    packageManager.getPackageInfo(strArr[i], 0);
                    return true;
                } catch (NameNotFoundException unused) {
                    i++;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        if (r2 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkSUExist() {
        /*
            r6 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r6.runtime     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.lang.Process r2 = r3.exec(r0)     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.nio.charset.Charset r5 = UTF_8     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            r0.<init>(r3)     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            r0.close()     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
            r2.destroy()
            return r3
        L_0x0031:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
        L_0x003c:
            throw r4     // Catch:{ IOException -> 0x004f, Exception -> 0x003f }
        L_0x003d:
            r0 = move-exception
            goto L_0x005e
        L_0x003f:
            r0 = move-exception
            io.sentry.ILogger r3 = r6.logger     // Catch:{ all -> 0x003d }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x003d }
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.log(r4, r5, r0)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x005d
        L_0x004b:
            r2.destroy()
            goto L_0x005d
        L_0x004f:
            io.sentry.ILogger r0 = r6.logger     // Catch:{ all -> 0x003d }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x003d }
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x003d }
            r0.log(r3, r4, r5)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x005d
            goto L_0x004b
        L_0x005d:
            return r1
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            r2.destroy()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.util.RootChecker.checkSUExist():boolean");
    }

    private boolean checkTestKeys() {
        String buildTags = this.buildInfoProvider.getBuildTags();
        return buildTags != null && buildTags.contains("test-keys");
    }

    public boolean isDeviceRooted() {
        return checkTestKeys() || checkRootFiles() || checkSUExist() || checkRootPackages();
    }

    public RootChecker(Context context2, IBuildInfoProvider iBuildInfoProvider, ILogger iLogger, String[] strArr, String[] strArr2, Runtime runtime2) {
        this.context = (Context) Objects.requireNonNull(context2, "The application context is required.");
        this.buildInfoProvider = (IBuildInfoProvider) Objects.requireNonNull(iBuildInfoProvider, "The BuildInfoProvider is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "The Logger is required.");
        this.rootFiles = (String[]) Objects.requireNonNull(strArr, "The root Files are required.");
        this.rootPackages = (String[]) Objects.requireNonNull(strArr2, "The root packages are required.");
        this.runtime = (Runtime) Objects.requireNonNull(runtime2, "The Runtime is required.");
    }
}
