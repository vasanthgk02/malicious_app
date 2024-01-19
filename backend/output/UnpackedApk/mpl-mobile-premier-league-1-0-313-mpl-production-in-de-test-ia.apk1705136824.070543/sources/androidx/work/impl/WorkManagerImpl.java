package androidx.work.impl;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Configuration.Provider;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Logger.LogcatLogger;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R$bool;
import androidx.work.WorkManager;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkManagerImpl extends WorkManager {
    public static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    public static WorkManagerImpl sDefaultInstance = null;
    public static WorkManagerImpl sDelegatedInstance = null;
    public static final Object sLock = new Object();
    public Configuration mConfiguration;
    public Context mContext;
    public boolean mForceStopRunnableCompleted;
    public PreferenceUtils mPreferenceUtils;
    public Processor mProcessor;
    public volatile RemoteWorkManager mRemoteWorkManager;
    public PendingResult mRescheduleReceiverResult;
    public List<Scheduler> mSchedulers;
    public WorkDatabase mWorkDatabase;
    public TaskExecutor mWorkTaskExecutor;

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        WorkDatabase create = WorkDatabase.create(context.getApplicationContext(), ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
        Context applicationContext = context.getApplicationContext();
        LogcatLogger logcatLogger = new LogcatLogger(configuration.mLoggingLevel);
        synchronized (Logger.class) {
            Logger.sLogger = logcatLogger;
        }
        List<Scheduler> asList = Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(applicationContext, this), new GreedyScheduler(applicationContext, configuration, taskExecutor, this)});
        Processor processor = new Processor(context, configuration, taskExecutor, create, asList);
        Context applicationContext2 = context.getApplicationContext();
        this.mContext = applicationContext2;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = create;
        this.mSchedulers = asList;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(create);
        this.mForceStopRunnableCompleted = false;
        if (VERSION.SDK_INT < 24 || !applicationContext2.isDeviceProtectedStorage()) {
            TaskExecutor taskExecutor2 = this.mWorkTaskExecutor;
            ((WorkManagerTaskExecutor) taskExecutor2).mBackgroundExecutor.execute(new ForceStopRunnable(applicationContext2, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            synchronized (sLock) {
                if (sDelegatedInstance != null) {
                    workManagerImpl = sDelegatedInstance;
                } else {
                    workManagerImpl = sDefaultInstance;
                }
            }
            if (workManagerImpl == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Provider) {
                    initialize(applicationContext, ((Provider) applicationContext).getWorkManagerConfiguration());
                    workManagerImpl = getInstance(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return workManagerImpl;
    }

    public static void initialize(Context context, Configuration configuration) {
        synchronized (sLock) {
            if (sDelegatedInstance != null) {
                if (sDefaultInstance != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (sDelegatedInstance == null) {
                Context applicationContext = context.getApplicationContext();
                if (sDefaultInstance == null) {
                    sDefaultInstance = new WorkManagerImpl(applicationContext, configuration, new WorkManagerTaskExecutor(configuration.mTaskExecutor));
                }
                sDelegatedInstance = sDefaultInstance;
            }
        }
    }

    public Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        ExistingWorkPolicy existingWorkPolicy;
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP) {
            existingWorkPolicy = ExistingWorkPolicy.KEEP;
        } else {
            existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, Collections.singletonList(periodicWorkRequest)).enqueue();
    }

    /* JADX INFO: finally extract failed */
    public void rescheduleEligibleWork() {
        if (VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelAll(this.mContext);
        }
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) this.mWorkDatabase.workSpecDao();
        workSpecDao_Impl.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = workSpecDao_Impl.__preparedStmtOfResetScheduledState.acquire();
        workSpecDao_Impl.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            workSpecDao_Impl.__db.setTransactionSuccessful();
            workSpecDao_Impl.__db.endTransaction();
            workSpecDao_Impl.__preparedStmtOfResetScheduledState.release(acquire);
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        } catch (Throwable th) {
            workSpecDao_Impl.__db.endTransaction();
            workSpecDao_Impl.__preparedStmtOfResetScheduledState.release(acquire);
            throw th;
        }
    }

    public void stopWork(String str) {
        TaskExecutor taskExecutor = this.mWorkTaskExecutor;
        ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new StopWorkRunnable(this, str, false));
    }

    public final void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager) Class.forName("androidx.work.multiprocess.RemoteWorkManagerClient").getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
        }
    }
}
