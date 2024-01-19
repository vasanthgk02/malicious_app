package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;

public class BatteryState {
    public static final int VELOCITY_CHARGING = 2;
    public static final int VELOCITY_FULL = 3;
    public static final int VELOCITY_UNPLUGGED = 1;
    public final Float level;
    public final boolean powerConnected;

    public BatteryState(Float f2, boolean z) {
        this.powerConnected = z;
        this.level = f2;
    }

    public static BatteryState get(Context context) {
        Float f2 = null;
        boolean z = false;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z = isPowerConnected(registerReceiver);
                f2 = getLevel(registerReceiver);
            }
        } catch (IllegalStateException e2) {
            Logger.getLogger().e("An error occurred getting battery state.", e2);
        }
        return new BatteryState(f2, z);
    }

    public static Float getLevel(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        if (this.powerConnected) {
            Float f2 = this.level;
            if (f2 != null) {
                return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
            }
        }
        return 1;
    }

    public boolean isPowerConnected() {
        return this.powerConnected;
    }

    public static boolean isPowerConnected(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        boolean z = false;
        if (intExtra == -1) {
            return false;
        }
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        }
        return z;
    }
}
