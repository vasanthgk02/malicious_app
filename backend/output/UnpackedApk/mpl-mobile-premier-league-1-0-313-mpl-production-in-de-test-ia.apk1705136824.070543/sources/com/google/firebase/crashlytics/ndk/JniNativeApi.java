package com.google.firebase.crashlytics.ndk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JniNativeApi implements NativeApi {
    public static final FilenameFilter APK_FILTER = $$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT0_OGVZs.INSTANCE;
    public static final boolean LIB_CRASHLYTICS_LOADED;
    public final Context context;

    static {
        boolean z;
        try {
            System.loadLibrary("crashlytics");
            z = true;
        } catch (UnsatisfiedLinkError e2) {
            Logger logger = Logger.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n");
            outline73.append(e2.getLocalizedMessage());
            logger.e(outline73.toString());
            z = false;
        }
        LIB_CRASHLYTICS_LOADED = z;
    }

    public JniNativeApi(Context context2) {
        this.context = context2;
    }

    @TargetApi(21)
    public static void addSplitSourceDirs(List<String> list, PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            Collections.addAll(list, strArr);
        }
        File file = new File(applicationInfo.dataDir, String.format("files/splitcompat/%s/verified-splits", new Object[]{getVersionCodeAsString(packageInfo)}));
        if (!file.exists()) {
            Logger logger = Logger.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("No dynamic features found at ");
            outline73.append(file.getAbsolutePath());
            logger.d(outline73.toString());
            return;
        }
        File[] listFiles = file.listFiles(APK_FILTER);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        Logger logger2 = Logger.getLogger();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Found ");
        outline732.append(listFiles.length);
        outline732.append(" APKs in ");
        outline732.append(file.getAbsolutePath());
        logger2.d(outline732.toString());
        for (File file2 : listFiles) {
            Logger logger3 = Logger.getLogger();
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Adding ");
            outline733.append(file2.getName());
            outline733.append(" to classpath.");
            logger3.d(outline733.toString());
            list.add(file2.getAbsolutePath());
        }
    }

    public static int getPackageInfoFlags() {
        return VERSION.SDK_INT >= 24 ? 9216 : 1024;
    }

    public static String getVersionCodeAsString(PackageInfo packageInfo) {
        if (VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean isAtLeastLollipop() {
        return true;
    }

    private native boolean nativeInit(String[] strArr, Object obj);

    public boolean initialize(String str, AssetManager assetManager) {
        String[] makePackagePaths = makePackagePaths(Build.CPU_ABI);
        boolean z = false;
        if (makePackagePaths.length < 2) {
            return false;
        }
        String str2 = makePackagePaths[0];
        String str3 = makePackagePaths[1];
        if (LIB_CRASHLYTICS_LOADED) {
            if (nativeInit(new String[]{str2, str3, str}, assetManager)) {
                z = true;
            }
        }
        return z;
    }

    public String[] makePackagePaths(String str) {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), getPackageInfoFlags());
            ArrayList arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            if (isAtLeastLollipop()) {
                addSplitSourceDirs(arrayList, packageInfo);
            }
            if (packageInfo.applicationInfo.sharedLibraryFiles != null) {
                Collections.addAll(arrayList, packageInfo.applicationInfo.sharedLibraryFiles);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str).getPath());
                if (str.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.endsWith(".apk")) {
                    arrayList2.add(str2 + "!/lib/" + str);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            return new String[]{TextUtils.join(File.pathSeparator, arrayList), TextUtils.join(File.pathSeparator, arrayList2)};
        } catch (NameNotFoundException e2) {
            Logger.getLogger().e("Unable to compose package paths", e2);
            throw new RuntimeException(e2);
        }
    }
}
