package com.paynimo.android.payment.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.EventBus;

public class NetworkStateReceiver extends BroadcastReceiver {
    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        Constant.showOutputLog("NetworkStateReceiver", " Network Availability : " + z);
        return z;
    }

    public void onReceive(Context context, Intent intent) {
        if (!isOnline(context)) {
            EventBus.getDefault().post(new g(false));
        }
    }
}
