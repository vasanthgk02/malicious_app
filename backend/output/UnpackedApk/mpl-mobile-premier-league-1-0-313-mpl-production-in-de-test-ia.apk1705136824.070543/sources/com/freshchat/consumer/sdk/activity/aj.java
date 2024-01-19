package com.freshchat.consumer.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class aj extends BroadcastReceiver {
    public final /* synthetic */ ah ph;

    public aj(ah ahVar) {
        this.ph = ahVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.ph.a(context, intent);
    }
}
