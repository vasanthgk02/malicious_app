package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.firebase.jobdispatcher.IRemoteJobService.Stub;
import com.firebase.jobdispatcher.JobInvocation.Builder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class JobService extends Service {
    public static final String ACTION_EXECUTE = "com.firebase.jobdispatcher.ACTION_EXECUTE";
    public static final int RESULT_FAIL_NORETRY = 2;
    public static final int RESULT_FAIL_RETRY = 1;
    public static final int RESULT_SUCCESS = 0;
    public static final String TAG = "FJD.JobService";
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    public final ExecutorService backgroundExecutor;
    public final Stub binder = new Stub() {
        public void start(Bundle bundle, IJobCallback iJobCallback) {
            Builder decode = GooglePlayReceiver.prefixedCoder.decode(bundle);
            if (decode == null) {
                Log.wtf(JobService.TAG, "start: unknown invocation provided");
            } else {
                JobService.this.handleStartJobRequest(decode.build(), iJobCallback);
            }
        }

        public void stop(Bundle bundle, boolean z) {
            Builder decode = GooglePlayReceiver.prefixedCoder.decode(bundle);
            if (decode == null) {
                Log.wtf(JobService.TAG, "stop: unknown invocation provided");
            } else {
                JobService.this.handleStopJobRequest(decode.build(), z);
            }
        }
    };
    public final SimpleArrayMap<String, JobCallback> runningJobs = new SimpleArrayMap<>(1);

    public static final class JobCallback {
        public final JobParameters job;
        public final IJobCallback remoteCallback;
        public final long startedAtElapsed;

        public JobCallback(JobParameters jobParameters, IJobCallback iJobCallback, long j, AnonymousClass1 r5) {
            this.job = jobParameters;
            this.remoteCallback = iJobCallback;
            this.startedAtElapsed = j;
        }
    }

    public static class UnitOfWork implements Runnable {
        public final boolean boolValue;
        public final JobCallback jobCallback;
        public final JobParameters jobParameters;
        public final JobService jobService;
        public final IJobCallback remoteJobCallback;
        public final int terminatingResult;
        public final Intent unbindIntent;
        public final int workType;

        public UnitOfWork(int i, JobService jobService2, JobParameters jobParameters2, IJobCallback iJobCallback, JobCallback jobCallback2, Intent intent, boolean z, int i2) {
            this.workType = i;
            this.jobService = jobService2;
            this.jobParameters = jobParameters2;
            this.remoteJobCallback = iJobCallback;
            this.jobCallback = jobCallback2;
            this.unbindIntent = intent;
            this.boolValue = z;
            this.terminatingResult = i2;
        }

        public static UnitOfWork callOnStopJob(JobService jobService2, JobCallback jobCallback2, boolean z, int i) {
            UnitOfWork unitOfWork = new UnitOfWork(2, jobService2, null, null, jobCallback2, null, z, i);
            return unitOfWork;
        }

        public static UnitOfWork removeAndFinishJobWithResult(JobService jobService2, JobParameters jobParameters2, int i) {
            UnitOfWork unitOfWork = new UnitOfWork(7, jobService2, jobParameters2, null, null, null, false, i);
            return unitOfWork;
        }

        public void run() {
            switch (this.workType) {
                case 1:
                    this.jobService.callOnStartJobImpl(this.jobParameters);
                    return;
                case 2:
                    this.jobService.callOnStopJobImpl(this.jobCallback, this.boolValue, this.terminatingResult);
                    return;
                case 3:
                    this.jobService.handleOnUnbindEventImpl(this.unbindIntent);
                    return;
                case 4:
                    this.jobService.handleStartJobRequestImpl(this.jobParameters, this.remoteJobCallback);
                    return;
                case 5:
                    this.jobService.handleStopJobRequestImpl(this.jobParameters, this.boolValue);
                    return;
                case 6:
                    JobCallback jobCallback2 = this.jobCallback;
                    int i = this.terminatingResult;
                    if (jobCallback2 != null) {
                        try {
                            IJobCallback iJobCallback = jobCallback2.remoteCallback;
                            JobCoder jobCoder = GooglePlayReceiver.prefixedCoder;
                            JobParameters jobParameters2 = jobCallback2.job;
                            Bundle bundle = new Bundle();
                            jobCoder.encode(jobParameters2, bundle);
                            iJobCallback.jobFinished(bundle, i);
                        } catch (RemoteException unused) {
                        }
                        return;
                    }
                    throw null;
                case 7:
                    this.jobService.removeAndFinishJobWithResultImpl(this.jobParameters, this.terminatingResult);
                    return;
                default:
                    throw new AssertionError("unreachable");
            }
        }
    }

    public JobService() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.backgroundExecutor = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public void callOnStartJobImpl(JobParameters jobParameters) {
        if (!onStartJob(jobParameters)) {
            this.backgroundExecutor.execute(UnitOfWork.removeAndFinishJobWithResult(this, jobParameters, 0));
        }
    }

    /* access modifiers changed from: private */
    public void callOnStopJobImpl(JobCallback jobCallback, boolean z, int i) {
        boolean onStopJob = onStopJob(jobCallback.job);
        if (z) {
            ExecutorService executorService = this.backgroundExecutor;
            UnitOfWork unitOfWork = new UnitOfWork(6, null, null, null, jobCallback, null, false, onStopJob ? 1 : i);
            executorService.execute(unitOfWork);
        }
    }

    /* access modifiers changed from: private */
    public void handleOnUnbindEventImpl(Intent intent) {
        synchronized (this.runningJobs) {
            for (int i = this.runningJobs.mSize - 1; i >= 0; i--) {
                JobCallback jobCallback = (JobCallback) this.runningJobs.remove(this.runningJobs.keyAt(i));
                if (jobCallback != null) {
                    mainHandler.post(UnitOfWork.callOnStopJob(this, jobCallback, true, 2));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleStartJobRequest(JobParameters jobParameters, IJobCallback iJobCallback) {
        ExecutorService executorService = this.backgroundExecutor;
        UnitOfWork unitOfWork = new UnitOfWork(4, this, jobParameters, iJobCallback, null, null, false, 0);
        executorService.execute(unitOfWork);
    }

    /* access modifiers changed from: private */
    public void handleStartJobRequestImpl(JobParameters jobParameters, IJobCallback iJobCallback) {
        synchronized (this.runningJobs) {
            if (this.runningJobs.containsKey(jobParameters.getTag())) {
                String.format(Locale.US, "Job with tag = %s was already running.", new Object[]{jobParameters.getTag()});
                return;
            }
            SimpleArrayMap<String, JobCallback> simpleArrayMap = this.runningJobs;
            String tag = jobParameters.getTag();
            JobCallback jobCallback = new JobCallback(jobParameters, iJobCallback, SystemClock.elapsedRealtime(), null);
            simpleArrayMap.put(tag, jobCallback);
            Handler handler = mainHandler;
            UnitOfWork unitOfWork = new UnitOfWork(1, this, jobParameters, null, null, null, false, 0);
            handler.post(unitOfWork);
        }
    }

    /* access modifiers changed from: private */
    public void handleStopJobRequest(JobParameters jobParameters, boolean z) {
        ExecutorService executorService = this.backgroundExecutor;
        UnitOfWork unitOfWork = new UnitOfWork(5, this, jobParameters, null, null, null, z, 0);
        executorService.execute(unitOfWork);
    }

    /* access modifiers changed from: private */
    public void handleStopJobRequestImpl(JobParameters jobParameters, boolean z) {
        synchronized (this.runningJobs) {
            JobCallback jobCallback = (JobCallback) this.runningJobs.remove(jobParameters.getTag());
            if (jobCallback == null) {
                boolean isLoggable = Log.isLoggable(TAG, 3);
            } else {
                mainHandler.post(UnitOfWork.callOnStopJob(this, jobCallback, z, 0));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeAndFinishJobWithResultImpl(com.firebase.jobdispatcher.JobParameters r5, int r6) {
        /*
            r4 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobService$JobCallback> r0 = r4.runningJobs
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobService$JobCallback> r1 = r4.runningJobs     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = r5.getTag()     // Catch:{ all -> 0x0024 }
            java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0024 }
            com.firebase.jobdispatcher.JobService$JobCallback r5 = (com.firebase.jobdispatcher.JobService.JobCallback) r5     // Catch:{ all -> 0x0024 }
            if (r5 == 0) goto L_0x0022
            com.firebase.jobdispatcher.IJobCallback r1 = r5.remoteCallback     // Catch:{ RemoteException -> 0x0022 }
            com.firebase.jobdispatcher.JobCoder r2 = com.firebase.jobdispatcher.GooglePlayReceiver.prefixedCoder     // Catch:{ RemoteException -> 0x0022 }
            com.firebase.jobdispatcher.JobParameters r5 = r5.job     // Catch:{ RemoteException -> 0x0022 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ RemoteException -> 0x0022 }
            r3.<init>()     // Catch:{ RemoteException -> 0x0022 }
            r2.encode(r5, r3)     // Catch:{ RemoteException -> 0x0022 }
            r1.jobFinished(r3, r6)     // Catch:{ RemoteException -> 0x0022 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobService.removeAndFinishJobWithResultImpl(com.firebase.jobdispatcher.JobParameters, int):void");
    }

    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dumpImpl(printWriter);
    }

    public final void dumpImpl(PrintWriter printWriter) {
        synchronized (this.runningJobs) {
            if (this.runningJobs.isEmpty()) {
                printWriter.println("No running jobs");
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            printWriter.println("Running jobs:");
            for (int i = 0; i < this.runningJobs.mSize; i++) {
                JobCallback jobCallback = (JobCallback) this.runningJobs.get(this.runningJobs.keyAt(i));
                String quote = JSONObject.quote(jobCallback.job.getTag());
                String formatElapsedTime = DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime - jobCallback.startedAtElapsed));
                printWriter.println("    * " + quote + " has been running for " + formatElapsedTime);
            }
        }
    }

    public final void jobFinished(JobParameters jobParameters, boolean z) {
        if (jobParameters != null) {
            this.backgroundExecutor.execute(UnitOfWork.removeAndFinishJobWithResult(this, jobParameters, z ? 1 : 0));
        }
    }

    public final IBinder onBind(Intent intent) {
        return this.binder;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public final void onStart(Intent intent, int i) {
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    public abstract boolean onStartJob(JobParameters jobParameters);

    public abstract boolean onStopJob(JobParameters jobParameters);

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    public final boolean onUnbind(Intent intent) {
        ExecutorService executorService = this.backgroundExecutor;
        UnitOfWork unitOfWork = new UnitOfWork(3, this, null, null, null, intent, false, 0);
        executorService.execute(unitOfWork);
        return super.onUnbind(intent);
    }
}
