package com.firebase.jobdispatcher;

import android.os.AsyncTask;
import androidx.collection.SimpleArrayMap;

public abstract class SimpleJobService extends JobService {
    public final SimpleArrayMap<JobParameters, AsyncJobTask> runningJobs = new SimpleArrayMap<>();

    public static class AsyncJobTask extends AsyncTask<Void, Void, Integer> {
        public final JobParameters jobParameters;
        public final SimpleJobService jobService;

        public AsyncJobTask(SimpleJobService simpleJobService, JobParameters jobParameters2, AnonymousClass1 r3) {
            this.jobService = simpleJobService;
            this.jobParameters = jobParameters2;
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return Integer.valueOf(this.jobService.onRunJob(this.jobParameters));
        }

        public void onPostExecute(Object obj) {
            SimpleJobService simpleJobService = this.jobService;
            JobParameters jobParameters2 = this.jobParameters;
            boolean z = true;
            if (((Integer) obj).intValue() != 1) {
                z = false;
            }
            synchronized (simpleJobService.runningJobs) {
                simpleJobService.runningJobs.remove(jobParameters2);
            }
            simpleJobService.jobFinished(jobParameters2, z);
        }
    }

    public abstract int onRunJob(JobParameters jobParameters);

    public boolean onStartJob(JobParameters jobParameters) {
        AsyncJobTask asyncJobTask = new AsyncJobTask(this, jobParameters, null);
        synchronized (this.runningJobs) {
            this.runningJobs.put(jobParameters, asyncJobTask);
        }
        asyncJobTask.execute(new Void[0]);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        synchronized (this.runningJobs) {
            AsyncJobTask asyncJobTask = (AsyncJobTask) this.runningJobs.remove(jobParameters);
            if (asyncJobTask == null) {
                return false;
            }
            asyncJobTask.cancel(true);
            return true;
        }
    }
}
