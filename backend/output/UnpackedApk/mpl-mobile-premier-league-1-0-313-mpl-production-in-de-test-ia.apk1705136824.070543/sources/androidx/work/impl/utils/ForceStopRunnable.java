package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.InitializationExceptionHandler;
import androidx.work.Logger;
import androidx.work.Logger.LogcatLogger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    public static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    public final Context mContext;
    public int mRetryCount = 0;
    public final WorkManagerImpl mWorkManager;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i = ((LogcatLogger) Logger.get()).mLoggingLevel;
                ForceStopRunnable.setAlarm(context);
            }
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    public static PendingIntent getPendingIntent(Context context, int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i);
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = getPendingIntent(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    public void forceStopRunnable() {
        boolean z;
        boolean reconcileJobs = VERSION.SDK_INT >= 23 ? SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager) : false;
        WorkDatabase workDatabase = this.mWorkManager.mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
        try {
            ArrayList arrayList = (ArrayList) workSpecDao_Impl.getRunningWork();
            boolean z2 = !arrayList.isEmpty();
            if (z2) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    WorkSpec workSpec = (WorkSpec) it.next();
                    workSpecDao_Impl.setState(WorkInfo$State.ENQUEUED, workSpec.id);
                    workSpecDao_Impl.markWorkSpecScheduled(workSpec.id, -1);
                }
            }
            ((WorkProgressDao_Impl) workProgressDao).deleteAll();
            workDatabase.setTransactionSuccessful();
            boolean z3 = z2 || reconcileJobs;
            Long longValue = ((PreferenceDao_Impl) this.mWorkManager.mPreferenceUtils.mWorkDatabase.preferenceDao()).getLongValue("reschedule_needed");
            if (longValue != null && longValue.longValue() == 1) {
                Logger.get().debug(TAG, "Rescheduling Workers.", new Throwable[0]);
                this.mWorkManager.rescheduleEligibleWork();
                PreferenceUtils preferenceUtils = this.mWorkManager.mPreferenceUtils;
                if (preferenceUtils != null) {
                    ((PreferenceDao_Impl) preferenceUtils.mWorkDatabase.preferenceDao()).insertPreference(new Preference((String) "reschedule_needed", false));
                } else {
                    throw null;
                }
            } else {
                if (getPendingIntent(this.mContext, 536870912) == null) {
                    setAlarm(this.mContext);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Logger.get().debug(TAG, "Application was force-stopped, rescheduling.", new Throwable[0]);
                    this.mWorkManager.rescheduleEligibleWork();
                } else if (z3) {
                    Logger.get().debug(TAG, "Found unfinished work, scheduling it.", new Throwable[0]);
                    WorkManagerImpl workManagerImpl = this.mWorkManager;
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
            }
            WorkManagerImpl workManagerImpl2 = this.mWorkManager;
            if (workManagerImpl2 != null) {
                synchronized (WorkManagerImpl.sLock) {
                    workManagerImpl2.mForceStopRunnableCompleted = true;
                    if (workManagerImpl2.mRescheduleReceiverResult != null) {
                        workManagerImpl2.mRescheduleReceiverResult.finish();
                        workManagerImpl2.mRescheduleReceiverResult = null;
                    }
                }
                return;
            }
            throw null;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void run() {
        boolean z;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        if (workManagerImpl.mRemoteWorkManager == null) {
            synchronized (WorkManagerImpl.sLock) {
                if (workManagerImpl.mRemoteWorkManager == null) {
                    workManagerImpl.tryInitializeMultiProcessSupport();
                    if (workManagerImpl.mRemoteWorkManager == null) {
                        if (!TextUtils.isEmpty(workManagerImpl.mConfiguration.mDefaultProcessName)) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                }
            }
        }
        if (workManagerImpl.mRemoteWorkManager == null) {
            z = true;
        } else {
            Logger.get().debug(TAG, "Found a remote implementation for WorkManager", new Throwable[0]);
            z = ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManager.mConfiguration);
            Logger.get().debug(TAG, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(z)}), new Throwable[0]);
        }
        if (z) {
            while (true) {
                WorkDatabasePathHelper.migrateDatabase(this.mContext);
                Logger.get().debug(TAG, "Performing cleanup operations.", new Throwable[0]);
                try {
                    forceStopRunnable();
                    break;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    int i = this.mRetryCount + 1;
                    this.mRetryCount = i;
                    if (i >= 3) {
                        Logger.get().error(TAG, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        InitializationExceptionHandler initializationExceptionHandler = this.mWorkManager.mConfiguration.mExceptionHandler;
                        if (initializationExceptionHandler != null) {
                            Logger.get().debug(TAG, "Routing exception to the specified exception handler", illegalStateException);
                            initializationExceptionHandler.handleException(illegalStateException);
                        } else {
                            throw illegalStateException;
                        }
                    } else {
                        Logger.get().debug(TAG, String.format("Retrying after %s", new Object[]{Long.valueOf(((long) i) * 300)}), e2);
                        try {
                            Thread.sleep(((long) this.mRetryCount) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }
}
