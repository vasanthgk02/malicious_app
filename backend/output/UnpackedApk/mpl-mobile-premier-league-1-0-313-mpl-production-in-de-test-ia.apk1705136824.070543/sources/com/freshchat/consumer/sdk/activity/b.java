package com.freshchat.consumer.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.bg;
import com.paynimo.android.payment.util.Constant;

public abstract class b extends a {
    public LocalBroadcastManager bs;
    public BroadcastReceiver bt = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!"com.freshchat.consumer.sdk.actions.KillCurrentUserSession".equals(intent.getAction())) {
                if ("com.freshchat.consumer.sdk.actions.TokenWaitTimeout".equals(intent.getAction())) {
                    b.this.al();
                    return;
                } else if ("com.freshchat.consumer.sdk.actions.DismissFreshchatScreens".equals(intent.getAction())) {
                    b.this.gs();
                    return;
                } else if (!"com.freshchat.consumer.sdk.actions.FAQApiVersionChanged".equals(intent.getAction())) {
                    if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction()) && al.aS(context)) {
                        aa.c(context, true);
                    }
                    b.this.a(context, intent);
                    return;
                } else if (!b.this.bM()) {
                    return;
                }
            }
            b.this.finish();
        }
    };

    public LocalBroadcastManager D() {
        if (this.bs == null) {
            this.bs = LocalBroadcastManager.getInstance(getApplicationContext());
        }
        return this.bs;
    }

    public abstract void a(Context context, Intent intent);

    public abstract String[] a();

    public void attachBaseContext(Context context) {
        super.attachBaseContext(ah.bU(context));
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        if (a().length > 0) {
            D().unregisterReceiver(this.bt);
        }
        getContext().unregisterReceiver(this.bt);
    }

    public void onResume() {
        super.onResume();
        bg.bL(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.freshchat.consumer.sdk.actions.KillCurrentUserSession");
        intentFilter.addAction("com.freshchat.consumer.sdk.actions.DismissFreshchatScreens");
        for (String addAction : a()) {
            intentFilter.addAction(addAction);
        }
        if (a().length > 0) {
            D().registerReceiver(this.bt, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(Constant.INTENT_NETWORK_STATUS);
        getContext().registerReceiver(this.bt, intentFilter2);
    }
}
