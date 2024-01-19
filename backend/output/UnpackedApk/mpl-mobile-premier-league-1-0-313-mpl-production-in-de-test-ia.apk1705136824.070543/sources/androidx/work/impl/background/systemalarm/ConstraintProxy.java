package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

public abstract class ConstraintProxy extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    public static void updateAll(Context context, List<WorkSpec> list) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (WorkSpec workSpec : list) {
            Constraints constraints = workSpec.constraints;
            z |= constraints.mRequiresBatteryNotLow;
            z2 |= constraints.mRequiresCharging;
            z3 |= constraints.mRequiresStorageNotLow;
            z4 |= constraints.mRequiredNetworkType != NetworkType.NOT_REQUIRED;
            if (z && z2 && z3 && z4) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, z, z2, z3, z4));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(CommandHandler.createConstraintsChangedIntent(context));
    }
}
