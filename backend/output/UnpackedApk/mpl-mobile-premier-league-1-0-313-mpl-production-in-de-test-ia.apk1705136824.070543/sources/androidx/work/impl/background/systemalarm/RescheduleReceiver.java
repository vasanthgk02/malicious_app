package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

public class RescheduleReceiver extends BroadcastReceiver {
    public static final String TAG = Logger.tagWithPrefix("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (VERSION.SDK_INT >= 23) {
            try {
                WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
                PendingResult goAsync = goAsync();
                if (instance != null) {
                    synchronized (WorkManagerImpl.sLock) {
                        instance.mRescheduleReceiverResult = goAsync;
                        if (instance.mForceStopRunnableCompleted) {
                            goAsync.finish();
                            instance.mRescheduleReceiverResult = null;
                        }
                    }
                    return;
                }
                throw null;
            } catch (IllegalStateException e2) {
                Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            context.startService(CommandHandler.createRescheduleIntent(context));
        }
    }
}
