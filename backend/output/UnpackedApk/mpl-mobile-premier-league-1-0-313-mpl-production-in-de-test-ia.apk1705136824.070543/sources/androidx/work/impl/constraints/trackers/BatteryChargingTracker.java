package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public static final String TAG = Logger.tagWithPrefix("BatteryChrgTracker");

    public BatteryChargingTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r0.getIntExtra("plugged", 0) != 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r0 != 5) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getInitialState() {
        /*
            r5 = this;
            android.content.IntentFilter r0 = new android.content.IntentFilter
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)
            android.content.Context r1 = r5.mAppContext
            r2 = 0
            android.content.Intent r0 = r1.registerReceiver(r2, r0)
            r1 = 0
            if (r0 != 0) goto L_0x001f
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = TAG
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            java.lang.String r4 = "getInitialState - null intent received"
            r0.error(r3, r4, r1)
            goto L_0x0040
        L_0x001f:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x0033
            r2 = -1
            java.lang.String r3 = "status"
            int r0 = r0.getIntExtra(r3, r2)
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r2 = 5
            if (r0 != r2) goto L_0x003c
            goto L_0x003b
        L_0x0033:
            java.lang.String r2 = "plugged"
            int r0 = r0.getIntExtra(r2, r1)
            if (r0 == 0) goto L_0x003c
        L_0x003b:
            r1 = 1
        L_0x003c:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryChargingTracker.getInitialState():java.lang.Object");
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        if (VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r6.equals("android.os.action.CHARGING") != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBroadcastReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r6 = r7.getAction()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.work.Logger r7 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r6
            java.lang.String r4 = "Received %s"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r7.debug(r0, r2, r4)
            int r7 = r6.hashCode()
            r0 = 2
            r2 = 3
            switch(r7) {
                case -1886648615: goto L_0x0045;
                case -54942926: goto L_0x003b;
                case 948344062: goto L_0x0032;
                case 1019184907: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x004f
        L_0x0028:
            java.lang.String r7 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x004f
            r3 = 2
            goto L_0x0050
        L_0x0032:
            java.lang.String r7 = "android.os.action.CHARGING"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x004f
            goto L_0x0050
        L_0x003b:
            java.lang.String r7 = "android.os.action.DISCHARGING"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x0045:
            java.lang.String r7 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x004f
            r3 = 3
            goto L_0x0050
        L_0x004f:
            r3 = -1
        L_0x0050:
            if (r3 == 0) goto L_0x006b
            if (r3 == r1) goto L_0x0065
            if (r3 == r0) goto L_0x005f
            if (r3 == r2) goto L_0x0059
            goto L_0x0070
        L_0x0059:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
            goto L_0x0070
        L_0x005f:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
            goto L_0x0070
        L_0x0065:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
            goto L_0x0070
        L_0x006b:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryChargingTracker.onBroadcastReceive(android.content.Context, android.content.Intent):void");
    }
}
