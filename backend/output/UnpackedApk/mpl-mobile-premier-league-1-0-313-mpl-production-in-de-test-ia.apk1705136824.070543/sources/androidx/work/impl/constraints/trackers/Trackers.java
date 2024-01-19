package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class Trackers {
    public static Trackers sInstance;
    public BatteryChargingTracker mBatteryChargingTracker;
    public BatteryNotLowTracker mBatteryNotLowTracker;
    public NetworkStateTracker mNetworkStateTracker;
    public StorageNotLowTracker mStorageNotLowTracker;

    public Trackers(Context context, TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.mBatteryChargingTracker = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.mBatteryNotLowTracker = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.mNetworkStateTracker = new NetworkStateTracker(applicationContext, taskExecutor);
        this.mStorageNotLowTracker = new StorageNotLowTracker(applicationContext, taskExecutor);
    }

    public static synchronized Trackers getInstance(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            try {
                if (sInstance == null) {
                    sInstance = new Trackers(context, taskExecutor);
                }
                trackers = sInstance;
            }
        }
        return trackers;
    }
}
