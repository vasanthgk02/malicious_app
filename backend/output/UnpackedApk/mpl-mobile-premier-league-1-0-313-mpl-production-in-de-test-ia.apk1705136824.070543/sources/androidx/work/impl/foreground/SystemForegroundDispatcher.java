package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    public Callback mCallback;
    public final WorkConstraintsTracker mConstraintsTracker;
    public Context mContext;
    public String mCurrentForegroundWorkSpecId;
    public final Map<String, ForegroundInfo> mForegroundInfoById;
    public final Object mLock = new Object();
    public final TaskExecutor mTaskExecutor;
    public final Set<WorkSpec> mTrackedWorkSpecs;
    public WorkManagerImpl mWorkManagerImpl;
    public final Map<String, WorkSpec> mWorkSpecById;

    public interface Callback {
    }

    public SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(this.mContext);
        this.mWorkManagerImpl = instance;
        this.mTaskExecutor = instance.mWorkTaskExecutor;
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mContext, this.mTaskExecutor, this);
        this.mWorkManagerImpl.mProcessor.addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public final void handleNotify(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.mCallback != null) {
            this.mForegroundInfoById.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId)) {
                this.mCurrentForegroundWorkSpecId = stringExtra;
                ((SystemForegroundService) this.mCallback).startForeground(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.mCallback;
            systemForegroundService.mHandler.post(new Runnable(intExtra, notification) {
                public final /* synthetic */ Notification val$notification;
                public final /* synthetic */ int val$notificationId;

                {
                    this.val$notificationId = r2;
                    this.val$notification = r3;
                }

                public void run() {
                    SystemForegroundService.this.mNotificationManager.notify(this.val$notificationId, this.val$notification);
                }
            });
            if (intExtra2 != 0 && VERSION.SDK_INT >= 29) {
                for (Entry<String, ForegroundInfo> value : this.mForegroundInfoById.entrySet()) {
                    i |= ((ForegroundInfo) value.getValue()).mForegroundServiceType;
                }
                ForegroundInfo foregroundInfo = this.mForegroundInfoById.get(this.mCurrentForegroundWorkSpecId);
                if (foregroundInfo != null) {
                    ((SystemForegroundService) this.mCallback).startForeground(foregroundInfo.mNotificationId, i, foregroundInfo.mNotification);
                }
            }
        }
    }

    public void onAllConstraintsMet(List<String> list) {
    }

    public void onAllConstraintsNotMet(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
                TaskExecutor taskExecutor = workManagerImpl.mWorkTaskExecutor;
                ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new StopWorkRunnable(workManagerImpl, next, true));
            }
        }
    }

    public void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.mProcessor.removeExecutionListener(this);
    }

    public void onExecuted(String str, boolean z) {
        Entry entry;
        synchronized (this.mLock) {
            WorkSpec remove = this.mWorkSpecById.remove(str);
            if (remove != null ? this.mTrackedWorkSpecs.remove(remove) : false) {
                this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
            }
        }
        ForegroundInfo remove2 = this.mForegroundInfoById.remove(str);
        if (str.equals(this.mCurrentForegroundWorkSpecId) && this.mForegroundInfoById.size() > 0) {
            Iterator it = this.mForegroundInfoById.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.mCurrentForegroundWorkSpecId = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                ((SystemForegroundService) this.mCallback).startForeground(foregroundInfo.mNotificationId, foregroundInfo.mForegroundServiceType, foregroundInfo.mNotification);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.mCallback;
                systemForegroundService.mHandler.post(new Runnable(foregroundInfo.mNotificationId) {
                    public final /* synthetic */ int val$notificationId;

                    {
                        this.val$notificationId = r2;
                    }

                    public void run() {
                        SystemForegroundService.this.mNotificationManager.cancel(this.val$notificationId);
                    }
                });
            }
        }
        Callback callback = this.mCallback;
        if (remove2 != null && callback != null) {
            Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.mNotificationId), str, Integer.valueOf(remove2.mForegroundServiceType)}), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) callback;
            systemForegroundService2.mHandler.post(new Runnable(remove2.mNotificationId) {
                public final /* synthetic */ int val$notificationId;

                {
                    this.val$notificationId = r2;
                }

                public void run() {
                    SystemForegroundService.this.mNotificationManager.cancel(this.val$notificationId);
                }
            });
        }
    }
}
