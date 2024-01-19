package com.braintreepayments.api.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

public class ManifestValidator {
    public static ActivityInfo getActivityInfo(Context context, Class cls) {
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo.name.equals(cls.getName())) {
                        return activityInfo;
                    }
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return null;
    }

    public static String getFormattedUUID() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static boolean isUrlSchemeDeclaredInAndroidManifest(Context context, String str, Class cls) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Intent addCategory = intent.setData(Uri.parse(str + "://")).addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE");
        ActivityInfo activityInfo = getActivityInfo(context, cls);
        return activityInfo != null && activityInfo.launchMode == 2 && k.isIntentAvailable(context, addCategory);
    }
}
