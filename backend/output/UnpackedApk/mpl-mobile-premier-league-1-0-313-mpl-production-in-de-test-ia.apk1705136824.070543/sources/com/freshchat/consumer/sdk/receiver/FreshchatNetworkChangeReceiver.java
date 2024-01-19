package com.freshchat.consumer.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.q;
import com.paynimo.android.payment.util.Constant;

public class FreshchatNetworkChangeReceiver extends BroadcastReceiver {
    private boolean e(Intent intent) {
        return intent != null && Constant.INTENT_NETWORK_STATUS.equals(intent.getAction());
    }

    public void onReceive(Context context, Intent intent) {
        ai.d("FRESHCHAT", "NetworkChangeReceiver::onReceive() called");
        ag.a("FRESHCHAT", intent);
        try {
            if (e(intent)) {
                aa.c(context, al.aS(context.getApplicationContext()));
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
