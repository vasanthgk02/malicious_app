package com.mpl.androidapp.worker;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.soutils.StoriesCleanUpHelper;
import com.mpl.androidapp.utils.MLogger;

public class StoriesCleanUpWorker extends Worker {
    public final String TAG = "StoriesCleanUpWorker";

    public StoriesCleanUpWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private void cleanUpExternalStorage() {
        MLogger.d("StoriesCleanUpWorker", "cleanUpExternalStorage");
        StoriesCleanUpHelper.deleteStoriesExternalStorage(getApplicationContext());
    }

    private void cleanUpInternalStorage() {
        MLogger.d("StoriesCleanUpWorker", "cleanUpInternalStorage");
        StoriesCleanUpHelper.deleteStoriesInternalStorage(getApplicationContext());
    }

    @SuppressLint({"RestrictedApi"})
    public Result doWork() {
        try {
            MLogger.d("StoriesCleanUpWorker", "doWork");
            cleanUpInternalStorage();
            cleanUpExternalStorage();
        } catch (Exception e2) {
            MLogger.e("StoriesCleanUpWorker", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in doWork : ")));
        }
        return new Success();
    }
}
