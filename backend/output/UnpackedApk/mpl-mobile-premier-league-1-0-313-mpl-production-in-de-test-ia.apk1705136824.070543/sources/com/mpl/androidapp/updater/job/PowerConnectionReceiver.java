package com.mpl.androidapp.updater.job;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mpl.androidapp.updater.gameengine.GEInteractor;

public class PowerConnectionReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null) {
                    if (registerReceiver.getIntExtra("status", -1) != 2) {
                    }
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    boolean z = false;
                    boolean z2 = intExtra == 2;
                    if (intExtra == 1) {
                        z = true;
                    }
                    if (z2 || z) {
                        GEInteractor.getInstance().deleteAssetsBasedOnGamePlayed(null, context);
                    }
                }
            } else if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                JobSchedulerHelper.scheduleJob(context);
            }
        }
    }
}
