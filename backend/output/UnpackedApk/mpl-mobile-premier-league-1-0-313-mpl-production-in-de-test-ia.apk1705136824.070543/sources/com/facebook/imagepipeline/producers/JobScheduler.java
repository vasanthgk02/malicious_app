package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    public static final String QUEUE_TIME_KEY = "queueTime";
    public final Runnable mDoJobRunnable = new Runnable() {
        public void run() {
            JobScheduler.this.doJob();
        }
    };
    public EncodedImage mEncodedImage = null;
    public final Executor mExecutor;
    public final JobRunnable mJobRunnable;
    public long mJobStartTime = 0;
    public JobState mJobState = JobState.IDLE;
    public long mJobSubmitTime = 0;
    public final int mMinimumJobIntervalMs;
    public int mStatus = 0;
    public final Runnable mSubmitJobRunnable = new Runnable() {
        public void run() {
            JobScheduler.this.submitJob();
        }
    };

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.facebook.imagepipeline.producers.JobScheduler$JobState[] r0 = com.facebook.imagepipeline.producers.JobScheduler.JobState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = r0
                r1 = 1
                com.facebook.imagepipeline.producers.JobScheduler$JobState r2 = com.facebook.imagepipeline.producers.JobScheduler.JobState.IDLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.imagepipeline.producers.JobScheduler$JobState r3 = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.imagepipeline.producers.JobScheduler$JobState r3 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.facebook.imagepipeline.producers.JobScheduler$JobState r2 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass3.<clinit>():void");
        }
    }

    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    public static class JobStartExecutorSupplier {
        public static ScheduledExecutorService sJobStarterExecutor;

        public static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
    }

    /* access modifiers changed from: private */
    public void doJob() {
        EncodedImage encodedImage;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = uptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i)) {
                this.mJobRunnable.run(encodedImage, i);
            }
        } finally {
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void enqueueJob(long j) {
        Runnable decorateRunnable = FrescoInstrumenter.decorateRunnable(this.mSubmitJobRunnable, "JobScheduler_enqueueJob");
        if (j > 0) {
            JobStartExecutorSupplier.get().schedule(decorateRunnable, j, TimeUnit.MILLISECONDS);
        } else {
            decorateRunnable.run();
        }
    }

    private void onJobFinished() {
        boolean z;
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                z = true;
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
                j = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(j - uptimeMillis);
        }
    }

    public static boolean shouldProcess(EncodedImage encodedImage, int i) {
        return BaseConsumer.isLast(i) || BaseConsumer.statusHasFlag(i, 4) || EncodedImage.isValid(encodedImage);
    }

    /* access modifiers changed from: private */
    public void submitJob() {
        this.mExecutor.execute(FrescoInstrumenter.decorateRunnable(this.mDoJobRunnable, "JobScheduler_submitJob"));
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public synchronized long getQueuedTime() {
        try {
        }
        return this.mJobStartTime - this.mJobSubmitTime;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r3 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        enqueueJob(r5 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scheduleJob() {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            monitor-enter(r7)
            com.facebook.imagepipeline.image.EncodedImage r2 = r7.mEncodedImage     // Catch:{ all -> 0x003f }
            int r3 = r7.mStatus     // Catch:{ all -> 0x003f }
            boolean r2 = shouldProcess(r2, r3)     // Catch:{ all -> 0x003f }
            r3 = 0
            if (r2 != 0) goto L_0x0012
            monitor-exit(r7)     // Catch:{ all -> 0x003f }
            return r3
        L_0x0012:
            com.facebook.imagepipeline.producers.JobScheduler$JobState r2 = r7.mJobState     // Catch:{ all -> 0x003f }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x003f }
            r4 = 1
            if (r2 == 0) goto L_0x0026
            r5 = 2
            if (r2 == r5) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            com.facebook.imagepipeline.producers.JobScheduler$JobState r2 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING     // Catch:{ all -> 0x003f }
            r7.mJobState = r2     // Catch:{ all -> 0x003f }
        L_0x0023:
            r5 = 0
            goto L_0x0037
        L_0x0026:
            long r2 = r7.mJobStartTime     // Catch:{ all -> 0x003f }
            int r5 = r7.mMinimumJobIntervalMs     // Catch:{ all -> 0x003f }
            long r5 = (long) r5     // Catch:{ all -> 0x003f }
            long r2 = r2 + r5
            long r5 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x003f }
            r7.mJobSubmitTime = r0     // Catch:{ all -> 0x003f }
            com.facebook.imagepipeline.producers.JobScheduler$JobState r2 = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED     // Catch:{ all -> 0x003f }
            r7.mJobState = r2     // Catch:{ all -> 0x003f }
            r3 = 1
        L_0x0037:
            monitor-exit(r7)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x003e
            long r5 = r5 - r0
            r7.enqueueJob(r5)
        L_0x003e:
            return r4
        L_0x003f:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x003f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.JobScheduler.scheduleJob():boolean");
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        EncodedImage encodedImage2;
        if (!shouldProcess(encodedImage, i)) {
            return false;
        }
        synchronized (this) {
            try {
                encodedImage2 = this.mEncodedImage;
                this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
                this.mStatus = i;
            }
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }
}
