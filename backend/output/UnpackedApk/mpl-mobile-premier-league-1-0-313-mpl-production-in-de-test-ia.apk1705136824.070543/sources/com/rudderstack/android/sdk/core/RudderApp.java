package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.gson.annotations.SerializedName;

public class RudderApp {
    @SerializedName("build")
    public String build;
    @SerializedName("name")
    public String name;
    @SerializedName("namespace")
    public String nameSpace;
    @SerializedName("version")
    public String version;

    public RudderApp(Application application) {
        try {
            String packageName = application.getPackageName();
            PackageManager packageManager = application.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            if (VERSION.SDK_INT >= 28) {
                this.build = Long.toString(packageInfo.getLongVersionCode());
            } else {
                this.build = Integer.toString(packageInfo.versionCode);
            }
            this.name = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            this.nameSpace = packageName;
            this.version = packageInfo.versionName;
        } catch (NameNotFoundException e2) {
            RudderLogger.logError(e2.getCause());
        }
    }
}
