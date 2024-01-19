package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).mNetworkStateTracker);
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.mRequiredNetworkType == NetworkType.CONNECTED;
    }

    public boolean isConstrained(Object obj) {
        NetworkState networkState = (NetworkState) obj;
        if (VERSION.SDK_INT < 26) {
            return true ^ networkState.mIsConnected;
        }
        if (!networkState.mIsConnected || !networkState.mIsValidated) {
            return true;
        }
        return false;
    }
}
