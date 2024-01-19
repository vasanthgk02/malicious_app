package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Logger.get().debug(TAG, "Requesting diagnostics", new Throwable[0]);
            try {
                WorkManagerImpl.getInstance(context).enqueue((OneTimeWorkRequest) new Builder(DiagnosticsWorker.class).build());
            } catch (IllegalStateException e2) {
                Logger.get().error(TAG, "WorkManager is not initialized", e2);
            }
        }
    }
}
