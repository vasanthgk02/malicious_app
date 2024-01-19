package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.foreground.SystemForegroundDispatcher.Callback;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.UUID;

public class SystemForegroundService extends LifecycleService implements Callback {
    public static final String TAG = Logger.tagWithPrefix("SystemFgService");
    public static SystemForegroundService sForegroundService;
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    public final void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.mCallback != null) {
            Logger.get().error(SystemForegroundDispatcher.TAG, "A callback already exists.", new Throwable[0]);
        } else {
            systemForegroundDispatcher.mCallback = this;
        }
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent != null) {
            SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
            if (systemForegroundDispatcher != null) {
                String action = intent.getAction();
                if ("ACTION_START_FOREGROUND".equals(action)) {
                    Logger.get().info(SystemForegroundDispatcher.TAG, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
                    String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
                    WorkDatabase workDatabase = systemForegroundDispatcher.mWorkManagerImpl.mWorkDatabase;
                    TaskExecutor taskExecutor = systemForegroundDispatcher.mTaskExecutor;
                    ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new Runnable(workDatabase, stringExtra) {
                        public final /* synthetic */ WorkDatabase val$database;
                        public final /* synthetic */ String val$workSpecId;

                        {
                            this.val$database = r2;
                            this.val$workSpecId = r3;
                        }

                        public void run() {
                            WorkSpec workSpec = ((WorkSpecDao_Impl) this.val$database.workSpecDao()).getWorkSpec(this.val$workSpecId);
                            if (workSpec != null && workSpec.hasConstraints()) {
                                synchronized (SystemForegroundDispatcher.this.mLock) {
                                    SystemForegroundDispatcher.this.mWorkSpecById.put(this.val$workSpecId, workSpec);
                                    SystemForegroundDispatcher.this.mTrackedWorkSpecs.add(workSpec);
                                    SystemForegroundDispatcher.this.mConstraintsTracker.replace(SystemForegroundDispatcher.this.mTrackedWorkSpecs);
                                }
                            }
                        }
                    });
                    systemForegroundDispatcher.handleNotify(intent);
                } else if ("ACTION_NOTIFY".equals(action)) {
                    systemForegroundDispatcher.handleNotify(intent);
                } else if ("ACTION_CANCEL_WORK".equals(action)) {
                    Logger.get().info(SystemForegroundDispatcher.TAG, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
                    String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                    if (stringExtra2 != null && !TextUtils.isEmpty(stringExtra2)) {
                        WorkManagerImpl workManagerImpl = systemForegroundDispatcher.mWorkManagerImpl;
                        UUID fromString = UUID.fromString(stringExtra2);
                        if (workManagerImpl != null) {
                            ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).mBackgroundExecutor.execute(new CancelWorkRunnable(fromString) {
                                public final /* synthetic */ UUID val$id;

                                {
                                    this.val$id = r2;
                                }

                                /* JADX INFO: finally extract failed */
                                public void runInternal() {
                                    WorkDatabase workDatabase = WorkManagerImpl.this.mWorkDatabase;
                                    workDatabase.beginTransaction();
                                    try {
                                        cancel(WorkManagerImpl.this, this.val$id.toString());
                                        workDatabase.setTransactionSuccessful();
                                        workDatabase.endTransaction();
                                        reschedulePendingWorkers(WorkManagerImpl.this);
                                    } catch (Throwable th) {
                                        workDatabase.endTransaction();
                                        throw th;
                                    }
                                }
                            });
                        } else {
                            throw null;
                        }
                    }
                } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
                    Logger.get().info(SystemForegroundDispatcher.TAG, "Stopping foreground service", new Throwable[0]);
                    Callback callback = systemForegroundDispatcher.mCallback;
                    if (callback != null) {
                        SystemForegroundService systemForegroundService = (SystemForegroundService) callback;
                        systemForegroundService.mIsShutdown = true;
                        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
                        if (VERSION.SDK_INT >= 26) {
                            systemForegroundService.stopForeground(true);
                        }
                        systemForegroundService.stopSelf();
                    }
                }
            } else {
                throw null;
            }
        }
        return 3;
    }

    public void startForeground(final int i, final int i2, final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i, notification, i2);
                } else {
                    SystemForegroundService.this.startForeground(i, notification);
                }
            }
        });
    }
}
