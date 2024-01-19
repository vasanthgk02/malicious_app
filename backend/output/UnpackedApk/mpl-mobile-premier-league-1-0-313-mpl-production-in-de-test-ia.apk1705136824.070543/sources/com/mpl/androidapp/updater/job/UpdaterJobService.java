package com.mpl.androidapp.updater.job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.utils.MLogger;
import org.apache.fontbox.cmap.CMapParser;

public class UpdaterJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 2071864318) {
            GEInteractor.getInstance().deleteAssetsBasedOnGamePlayed(jobParameters, this);
            jobFinished(jobParameters, false);
            new Handler(new Callback() {
                public boolean handleMessage(Message message) {
                    JobSchedulerHelper.scheduleJob(UpdaterJobService.this);
                    return false;
                }
            }).sendEmptyMessageDelayed(0, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
            return false;
        } else if (jobParameters.getJobId() == 2072344318) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        MLogger.d(JobSchedulerHelper.TAG, "onStopJob() called with: jobParameters = [" + jobParameters + CMapParser.MARK_END_OF_ARRAY);
        return false;
    }
}
