package com.freshchat.consumer.sdk.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.exception.PermissionNotGrantedException;
import com.netcore.android.SMTConfigConstants;
import java.util.ArrayList;

public class am {
    public static String[] iE = {"android.permission.RECORD_AUDIO", SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY};
    public static final String[] iF = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
    public static final String[] iG = new String[0];

    public static boolean a(Context context, String[] strArr) {
        for (String n : strArr) {
            if (!n(context, n)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void aT(Context context) {
        if (context != null) {
            String[] strArr = iF;
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                if (n(context, str)) {
                    i2++;
                } else {
                    throw new PermissionNotGrantedException(str);
                }
            }
            if (!aw.fa()) {
                String[] strArr2 = iG;
                int length2 = strArr2.length;
                while (i < length2) {
                    String str2 = strArr2[i];
                    if (n(context, str2) || ("android.permission.RECORD_AUDIO".equals(str2) && !e.i(context).bn())) {
                        i++;
                    } else {
                        throw new PermissionNotGrantedException(str2);
                    }
                }
            }
        }
    }

    public static boolean aU(Context context) {
        return n(context, SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY);
    }

    public static boolean aV(Context context) {
        return true;
    }

    public static final boolean aW(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(g.ab(context), 4096);
            if (!(packageInfo == null || packageInfo.requestedPermissions == null)) {
                for (String equalsIgnoreCase : packageInfo.requestedPermissions) {
                    if ("android.permission.CAMERA".equalsIgnoreCase(equalsIgnoreCase)) {
                        return true;
                    }
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    public static final boolean aX(Context context) {
        if (aW(context)) {
            return n(context, "android.permission.CAMERA");
        }
        return true;
    }

    public static String[] b(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!n(context, str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @TargetApi(23)
    public static boolean n(Context context, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (aw.fa()) {
            if (context.checkSelfPermission(str) == 0) {
                z = true;
            }
            return z;
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z = true;
        }
        return z;
    }
}
