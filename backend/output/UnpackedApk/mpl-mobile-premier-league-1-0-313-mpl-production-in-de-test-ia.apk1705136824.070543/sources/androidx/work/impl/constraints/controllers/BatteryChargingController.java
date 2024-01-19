package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryChargingController extends ConstraintController<Boolean> {
    public BatteryChargingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).mBatteryChargingTracker);
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.mRequiresCharging;
    }

    public boolean isConstrained(Object obj) {
        return !((Boolean) obj).booleanValue();
    }
}
