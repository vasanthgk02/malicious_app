package com.clevertap.android.sdk.pushnotification.amp;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CoreState;
import com.clevertap.android.sdk.Logger;
import java.util.HashMap;

public class CTBackgroundJobService extends JobService {
    public boolean onStartJob(final JobParameters jobParameters) {
        Logger.v("Job Service is starting");
        new Thread(new Runnable() {
            public void run() {
                Context applicationContext = CTBackgroundJobService.this.getApplicationContext();
                JobParameters jobParameters = jobParameters;
                HashMap<String, CleverTapAPI> hashMap = CleverTapAPI.instances;
                if (hashMap == null) {
                    CleverTapAPI defaultInstance = CleverTapAPI.getDefaultInstance(applicationContext);
                    if (defaultInstance != null) {
                        CoreState coreState = defaultInstance.coreState;
                        if (coreState.config.backgroundSync) {
                            coreState.pushProviders.runInstanceJobWork(applicationContext, jobParameters);
                        } else {
                            Logger.d("Instance doesn't allow Background sync, not running the Job");
                        }
                    }
                } else {
                    for (String next : hashMap.keySet()) {
                        CleverTapAPI cleverTapAPI = CleverTapAPI.instances.get(next);
                        if (cleverTapAPI == null || !cleverTapAPI.coreState.config.analyticsOnly) {
                            if (cleverTapAPI != null) {
                                CoreState coreState2 = cleverTapAPI.coreState;
                                if (coreState2.config.backgroundSync) {
                                    coreState2.pushProviders.runInstanceJobWork(applicationContext, jobParameters);
                                }
                            }
                            Logger.d(next, "Instance doesn't allow Background sync, not running the Job");
                        } else {
                            Logger.d(next, "Instance is Analytics Only not running the Job");
                        }
                    }
                }
                CTBackgroundJobService.this.jobFinished(jobParameters, true);
            }
        }).start();
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
