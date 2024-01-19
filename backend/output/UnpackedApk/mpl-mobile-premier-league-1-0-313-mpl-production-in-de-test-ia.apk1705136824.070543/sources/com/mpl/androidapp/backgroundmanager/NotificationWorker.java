package com.mpl.androidapp.backgroundmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;

public class NotificationWorker extends Worker {
    public NotificationWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private void getWork() {
        MLogger.d("workmanger", "completed succesfully1");
    }

    @SuppressLint({"RestrictedApi"})
    public Result doWork() {
        try {
            MLogger.d("workmanger", "started succesfully");
            getWork();
        } catch (Exception e2) {
            MLogger.e("workmanger", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in doWork : ")));
        }
        return new Success();
    }
}
