package com.mpl.androidapp.updater.job;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class StayLiveJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
