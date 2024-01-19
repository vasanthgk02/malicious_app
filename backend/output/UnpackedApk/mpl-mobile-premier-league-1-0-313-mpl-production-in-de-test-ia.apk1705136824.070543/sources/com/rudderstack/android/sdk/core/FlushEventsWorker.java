package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.util.ArrayList;

public class FlushEventsWorker extends Worker {
    public FlushEventsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public Result doWork() {
        Result result;
        RudderFlushConfig rudderFlushConfig = RudderFlushWorkManager.getRudderFlushConfig(getApplicationContext());
        if (rudderFlushConfig == null) {
            RudderLogger.logWarn("FlushEventsWorker: doWork: RudderFlushConfig is empty, couldn't flush the events, aborting the work");
            return new Failure();
        }
        RudderLogger.init(rudderFlushConfig.getLogLevel());
        DBPersistentManager instance = DBPersistentManager.getInstance((Application) getApplicationContext());
        if (instance == null) {
            RudderLogger.logWarn("FlushEventsWorker: doWork: Failed to initialize DBPersistentManager, couldn't flush the events, aborting the work");
            return new Failure();
        }
        RudderLogger.logInfo("FlushEventsWorker: doWork: Started Periodic Flushing of Events ");
        if (FlushUtils.flush(false, null, new ArrayList(), new ArrayList(), rudderFlushConfig.flushQueueSize, rudderFlushConfig.dataPlaneUrl, instance, rudderFlushConfig.getAuthHeaderString(), rudderFlushConfig.getAnonymousHeaderString())) {
            result = new Success();
        } else {
            result = new Failure();
        }
        return result;
    }
}
