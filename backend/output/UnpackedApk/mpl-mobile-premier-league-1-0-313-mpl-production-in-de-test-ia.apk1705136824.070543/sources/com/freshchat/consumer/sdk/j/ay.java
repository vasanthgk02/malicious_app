package com.freshchat.consumer.sdk.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.appcompat.app.AlertDialog.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import java.util.List;

public class ay {
    public static final String TAG = "com.freshchat.consumer.sdk.j.ay";

    public static void a(Context context, boolean z) {
        e.i(context).putBoolean("XIAOMI_AUTOSTART_USER_NOTIFIED", z);
    }

    public static boolean b(Context context, List<Message> list) {
        boolean z = !e.i(context).getBoolean("XIAOMI_AUTOSTART_USER_NOTIFIED");
        if (z) {
            z = bf(context);
        }
        if (!z || list == null || list.size() > 5) {
            return z;
        }
        int i = 0;
        while (i < list.size() && i < 5) {
            if (list.get(i).isUserMessage()) {
                return false;
            }
            i++;
        }
        return z;
    }

    public static void be(Context context) {
        try {
            context.startActivity(fd());
        } catch (Exception e2) {
            String str = TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to launch AutoStart Screen - ");
            outline73.append(e2.getMessage());
            ai.e(str, outline73.toString());
        }
    }

    public static boolean bf(Context context) {
        List<ResolveInfo> list;
        try {
            list = context.getPackageManager().queryIntentActivities(fd(), 65536);
        } catch (Exception e2) {
            String str = TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to launch AutoStart Screen - ");
            outline73.append(e2.getMessage());
            ai.e(str, outline73.toString());
            list = null;
        }
        return k.a(list);
    }

    public static void c(final Context context, List<Message> list) {
        if (context.getResources().getBoolean(R.bool.freshchat_xiaomi_autostart_prompt_enabled) && p.ew() && b(context, list)) {
            String string = context.getString(R.string.freshchat_xiaomi_auto_start_prompt_message);
            if (as.a(string)) {
                Builder m = i.m(context);
                m.P.mMessage = string;
                m.setPositiveButton(R.string.freshchat_xiaomi_auto_start_prompt_positive, (OnClickListener) new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ay.be(context);
                        dialogInterface.dismiss();
                    }
                });
                m.setNegativeButton(R.string.freshchat_xiaomi_auto_start_prompt_negative, (OnClickListener) null);
                m.create().show();
            }
            a(context, true);
        }
    }

    public static Intent fd() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
        return intent;
    }
}
