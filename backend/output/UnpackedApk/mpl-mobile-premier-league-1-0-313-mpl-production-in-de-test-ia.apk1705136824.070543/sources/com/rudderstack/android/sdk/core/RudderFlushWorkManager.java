package com.rudderstack.android.sdk.core;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Constraints.Builder;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.rudderstack.android.sdk.core.util.Utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class RudderFlushWorkManager {
    public static final String RUDDER_FLUSH_CONFIG_FILE_NAME = "RudderFlushConfig";
    public RudderConfig config;
    public Context context;
    public RudderPreferenceManager preferenceManager;

    public RudderFlushWorkManager(Context context2, RudderConfig rudderConfig, RudderPreferenceManager rudderPreferenceManager, RudderFlushConfig rudderFlushConfig) {
        this.context = context2;
        this.config = rudderConfig;
        this.preferenceManager = rudderPreferenceManager;
        saveRudderFlushConfig(context2, rudderFlushConfig);
    }

    public static RudderFlushConfig getRudderFlushConfig(Context context2) {
        RudderFlushConfig rudderFlushConfig = null;
        try {
            if (Utils.fileExists(context2, RUDDER_FLUSH_CONFIG_FILE_NAME)) {
                FileInputStream openFileInput = context2.openFileInput(RUDDER_FLUSH_CONFIG_FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput);
                RudderFlushConfig rudderFlushConfig2 = (RudderFlushConfig) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    openFileInput.close();
                    rudderFlushConfig = rudderFlushConfig2;
                } catch (Exception e2) {
                    e = e2;
                    rudderFlushConfig = rudderFlushConfig2;
                    try {
                        RudderLogger.logError((String) "RudderServerConfigManager: getRudderFlushConfig: Failed to read RudderServerConfig Object from File");
                        e.printStackTrace();
                    } catch (Throwable unused) {
                    }
                    return rudderFlushConfig;
                } catch (Throwable unused2) {
                    rudderFlushConfig = rudderFlushConfig2;
                    return rudderFlushConfig;
                }
            }
            return rudderFlushConfig;
        } catch (Exception e3) {
            e = e3;
            RudderLogger.logError((String) "RudderServerConfigManager: getRudderFlushConfig: Failed to read RudderServerConfig Object from File");
            e.printStackTrace();
            return rudderFlushConfig;
        }
    }

    public static void saveRudderFlushConfig(Context context2, RudderFlushConfig rudderFlushConfig) {
        try {
            FileOutputStream openFileOutput = context2.openFileOutput(RUDDER_FLUSH_CONFIG_FILE_NAME, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);
            objectOutputStream.writeObject(rudderFlushConfig);
            objectOutputStream.close();
            openFileOutput.close();
        } catch (Exception e2) {
            RudderLogger.logError((String) "RudderServerConfigManager: saveRudderFlushConfig: Exception while saving RudderServerConfig Object to File");
            e2.printStackTrace();
        }
    }

    public void cancelPeriodicFlushWorker() {
        if (!this.config.isPeriodicFlushEnabled()) {
            RudderLogger.logWarn("EventRepository: cancelPeriodicFlushWorker: Periodic Flush is Disabled, no PeriodicWorkRequest to be cancelled");
        } else if (!Utils.isOnClassPath("androidx.work.WorkManager")) {
            RudderLogger.logWarn("EventRepository: cancelPeriodicFlushWorker: WorkManager dependency not found, please add it to your build.gradle");
        } else {
            String periodicWorkRequestId = this.preferenceManager.getPeriodicWorkRequestId();
            if (periodicWorkRequestId == null) {
                RudderLogger.logWarn("EventRepository: cancelPeriodicFlushWorker: Couldn't find PeriodicWorkRequest Id, cannot cancel PeriodicWorkRequest");
                return;
            }
            WorkManagerImpl instance = WorkManagerImpl.getInstance(this.context);
            UUID fromString = UUID.fromString(periodicWorkRequestId);
            if (instance != null) {
                ((WorkManagerTaskExecutor) instance.mWorkTaskExecutor).mBackgroundExecutor.execute(new CancelWorkRunnable(fromString) {
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
                RudderLogger.logDebug("EventRepository: cancelPeriodicFlushWorker: Successfully cancelled PeriodicWorkRequest With ID " + periodicWorkRequestId);
                return;
            }
            throw null;
        }
    }

    public void registerPeriodicFlushWorker() {
        if (this.config.isPeriodicFlushEnabled()) {
            if (!Utils.isOnClassPath("androidx.work.WorkManager")) {
                RudderLogger.logWarn("EventRepository: registerPeriodicFlushWorker: WorkManager dependency not found, please add it to your build.gradle");
                return;
            }
            Builder builder = new Builder();
            builder.mRequiredNetworkType = NetworkType.CONNECTED;
            Constraints constraints = new Constraints(builder);
            PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(FlushEventsWorker.class, this.config.getRepeatInterval(), this.config.getRepeatIntervalTimeUnit());
            builder2.mTags.add("Flushing Pending Events Periodically");
            PeriodicWorkRequest.Builder builder3 = builder2;
            builder3.mWorkSpec.constraints = constraints;
            PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) builder3.build();
            WorkManagerImpl.getInstance(this.context).enqueueUniquePeriodicWork("flushEvents", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
            String uuid = periodicWorkRequest.mId.toString();
            this.preferenceManager.savePeriodicWorkRequestId(uuid);
            RudderLogger.logDebug("EventRepository: registerPeriodicFlushWorker: Registered PeriodicWorkRequest with ID " + uuid);
        }
    }
}
