package com.mpl.androidapp.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import java.io.File;

public class MSMSBroadCastReceiver extends BroadcastReceiver {
    public static final String TAG = "MSMSBroadCastReceiver";

    public void ShareVideo(Context context, String str, int i) {
        if (Util.isYouTubeappPresent(context)) {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setAction("android.intent.action.SEND");
            intent.setType("video/mp4");
            intent.setPackage("com.google.android.youtube");
            intent.putExtra("android.intent.extra.SUBJECT", "Share on youtube");
            intent.putExtra("android.intent.extra.TITLE", "Share");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            Util.startActivitySafely(context, intent);
            return;
        }
        Toast.makeText(context, "YouTube not installed!", 0).show();
    }

    public void onReceive(Context context, Intent intent) {
        MLogger.d(TAG, "onReceive: ");
        if (intent != null && !TextUtils.isEmpty(intent.getAction()) && "share_youtube".equalsIgnoreCase(intent.getAction())) {
            intent.setClass(context, MPLReactContainerActivity.class);
            context.startActivity(intent);
        }
    }
}
