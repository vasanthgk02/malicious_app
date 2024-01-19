package com.mpl.androidapp.backgroundmanager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences.Editor;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessaging.AutoInit;
import com.mpl.androidapp.utils.MLogger;

public class BackgroundOperationsJobService extends JobService {
    public static final String TAG = "backgroundService";

    public boolean onStartJob(final JobParameters jobParameters) {
        MLogger.d("backgroundService", "onStartJob: ");
        new Thread(new Runnable() {
            public void run() {
                AutoInit autoInit = FirebaseMessaging.getInstance().autoInit;
                synchronized (autoInit) {
                    autoInit.initialize();
                    if (autoInit.dataCollectionDefaultChangeEventHandler != null) {
                        autoInit.subscriber.unsubscribe(DataCollectionDefaultChange.class, autoInit.dataCollectionDefaultChangeEventHandler);
                        autoInit.dataCollectionDefaultChangeEventHandler = null;
                    }
                    FirebaseApp firebaseApp = FirebaseMessaging.this.firebaseApp;
                    firebaseApp.checkNotDeleted();
                    Editor edit = firebaseApp.applicationContext.getSharedPreferences("com.google.firebase.messaging", 0).edit();
                    edit.putBoolean("auto_init", true);
                    edit.apply();
                    FirebaseMessaging.this.startSyncIfNecessary();
                    autoInit.autoInitEnabled = Boolean.TRUE;
                }
                BackgroundOperationsJobService.this.jobFinished(jobParameters, true);
            }
        }).start();
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
