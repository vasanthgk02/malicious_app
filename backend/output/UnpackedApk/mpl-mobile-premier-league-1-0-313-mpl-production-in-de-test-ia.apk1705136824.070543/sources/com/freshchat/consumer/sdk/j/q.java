package com.freshchat.consumer.sdk.j;

import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMap;

public class q {
    public static final String TAG = "com.freshchat.consumer.sdk.j.q";

    public static void a(Throwable th) {
        String message = th != null ? th.getMessage() : "";
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception on ");
        outline73.append(Build.MANUFACTURER);
        outline73.append(CMap.SPACE);
        outline73.append(Build.MODEL);
        outline73.append(" Android API ");
        outline73.append(VERSION.RELEASE);
        outline73.append(" (");
        outline73.append(VERSION.SDK_INT);
        outline73.append(") >>>>> ");
        outline73.append(message);
        ai.e("FRESHCHAT", outline73.toString(), th);
    }
}
