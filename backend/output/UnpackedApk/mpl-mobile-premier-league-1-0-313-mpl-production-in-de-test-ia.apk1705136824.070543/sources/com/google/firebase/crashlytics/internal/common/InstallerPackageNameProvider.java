package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

public class InstallerPackageNameProvider {
    public static final String NO_INSTALLER_PACKAGE_NAME = "";
    public String installerPackageName;

    public static String loadInstallerPackageName(Context context) {
        String installerPackageName2 = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName2 == null ? "" : installerPackageName2;
    }

    public synchronized String getInstallerPackageName(Context context) {
        try {
            if (this.installerPackageName == null) {
                this.installerPackageName = loadInstallerPackageName(context);
            }
        }
        return "".equals(this.installerPackageName) ? null : this.installerPackageName;
    }
}
