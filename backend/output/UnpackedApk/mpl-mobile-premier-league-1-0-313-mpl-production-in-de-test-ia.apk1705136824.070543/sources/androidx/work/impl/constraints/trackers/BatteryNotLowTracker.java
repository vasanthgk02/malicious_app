package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public static final String TAG = Logger.tagWithPrefix("BatteryNotLowTracker");

    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public Object getInitialState() {
        Intent registerReceiver = this.mAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r6.equals("android.intent.action.BATTERY_OKAY") != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBroadcastReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r6 = r7.getAction()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.work.Logger r6 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.getAction()
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "Received %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r4]
            r6.debug(r0, r2, r3)
            java.lang.String r6 = r7.getAction()
            int r7 = r6.hashCode()
            r0 = -1980154005(0xffffffff89f93f6b, float:-6.0004207E-33)
            if (r7 == r0) goto L_0x003f
            r0 = 490310653(0x1d398bfd, float:2.4556918E-21)
            if (r7 == r0) goto L_0x0035
            goto L_0x0048
        L_0x0035:
            java.lang.String r7 = "android.intent.action.BATTERY_LOW"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0048
            r4 = 1
            goto L_0x0049
        L_0x003f:
            java.lang.String r7 = "android.intent.action.BATTERY_OKAY"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = -1
        L_0x0049:
            if (r4 == 0) goto L_0x0054
            if (r4 == r1) goto L_0x004e
            goto L_0x0059
        L_0x004e:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryNotLowTracker.onBroadcastReceive(android.content.Context, android.content.Intent):void");
    }
}
