package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class JobInfoSchedulerService extends JobService {
    public /* synthetic */ void lambda$onStartJob$0$JobInfoSchedulerService(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        Builder builder = TransportContext.builder();
        builder.setBackendName(string);
        builder.setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            ((AutoValue_TransportContext.Builder) builder).extras = Base64.decode(string2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Runnable(builder.build(), i2, new Runnable(jobParameters) {
            public final /* synthetic */ JobParameters f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                JobInfoSchedulerService.this.lambda$onStartJob$0$JobInfoSchedulerService(this.f$1);
            }
        }) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Uploader.this.lambda$upload$1$Uploader(this.f$1, this.f$2, this.f$3);
            }
        });
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
