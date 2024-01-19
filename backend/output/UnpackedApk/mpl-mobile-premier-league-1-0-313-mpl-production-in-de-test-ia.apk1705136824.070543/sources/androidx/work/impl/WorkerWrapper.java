package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Retry;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WorkerWrapper implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    public Context mAppContext;
    public Configuration mConfiguration;
    public DependencyDao mDependencyDao;
    public ForegroundProcessor mForegroundProcessor;
    public SettableFuture<Boolean> mFuture = new SettableFuture<>();
    public ListenableFuture<Result> mInnerFuture = null;
    public volatile boolean mInterrupted;
    public Result mResult = new Failure();
    public RuntimeExtras mRuntimeExtras;
    public List<Scheduler> mSchedulers;
    public List<String> mTags;
    public WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public WorkSpec mWorkSpec;
    public WorkSpecDao mWorkSpecDao;
    public String mWorkSpecId;
    public WorkTagDao mWorkTagDao;
    public TaskExecutor mWorkTaskExecutor;
    public ListenableWorker mWorker;

    public static class Builder {
        public Context mAppContext;
        public Configuration mConfiguration;
        public ForegroundProcessor mForegroundProcessor;
        public RuntimeExtras mRuntimeExtras = new RuntimeExtras();
        public List<Scheduler> mSchedulers;
        public WorkDatabase mWorkDatabase;
        public String mWorkSpecId;
        public TaskExecutor mWorkTaskExecutor;

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String str) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = taskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = workDatabase;
            this.mWorkSpecId = str;
        }
    }

    public WorkerWrapper(Builder builder) {
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = null;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    public final void handleResult(Result result) {
        if (result instanceof Success) {
            Logger.get().info(TAG, String.format("Worker result SUCCESS for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            }
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpecDao workSpecDao = this.mWorkSpecDao;
                ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.SUCCEEDED, this.mWorkSpecId);
                ((WorkSpecDao_Impl) this.mWorkSpecDao).setOutput(this.mWorkSpecId, ((Success) this.mResult).mOutputData);
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = ((ArrayList) ((DependencyDao_Impl) this.mDependencyDao).getDependentWorkIds(this.mWorkSpecId)).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(str) == WorkInfo$State.BLOCKED) {
                        if (((DependencyDao_Impl) this.mDependencyDao).hasCompletedAllPrerequisites(str)) {
                            Logger.get().info(TAG, String.format("Setting status to enqueued for %s", new Object[]{str}), new Throwable[0]);
                            WorkSpecDao workSpecDao2 = this.mWorkSpecDao;
                            ((WorkSpecDao_Impl) workSpecDao2).setState(WorkInfo$State.ENQUEUED, str);
                            ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(str, currentTimeMillis);
                        }
                    }
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
                resolve(false);
            }
        } else if (result instanceof Retry) {
            Logger.get().info(TAG, String.format("Worker result RETRY for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, String.format("Worker result FAILURE for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setFailedAndResolve();
            }
        }
    }

    public final void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (((WorkSpecDao_Impl) this.mWorkSpecDao).getState(str2) != WorkInfo$State.CANCELLED) {
                WorkSpecDao workSpecDao = this.mWorkSpecDao;
                ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.FAILED, str2);
            }
            linkedList.addAll(((DependencyDao_Impl) this.mDependencyDao).getDependentWorkIds(str2));
        }
    }

    public void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
                ((WorkProgressDao_Impl) this.mWorkDatabase.workProgressDao()).delete(this.mWorkSpecId);
                if (state == null) {
                    resolve(false);
                } else if (state == WorkInfo$State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!state.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            for (Scheduler cancel : list) {
                cancel.cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    public final void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpecDao workSpecDao = this.mWorkSpecDao;
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            WorkSpecDao workSpecDao = this.mWorkSpecDao;
            ((WorkSpecDao_Impl) workSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    public final void resolve(boolean z) {
        this.mWorkDatabase.beginTransaction();
        try {
            if (((ArrayList) ((WorkSpecDao_Impl) this.mWorkDatabase.workSpecDao()).getAllUnfinishedWork()).isEmpty()) {
                PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
            }
            if (z) {
                ((WorkSpecDao_Impl) this.mWorkSpecDao).setState(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
                ((WorkSpecDao_Impl) this.mWorkSpecDao).markWorkSpecScheduled(this.mWorkSpecId, -1);
            }
            if (!(this.mWorkSpec == null || this.mWorker == null || !this.mWorker.isRunInForeground())) {
                ForegroundProcessor foregroundProcessor = this.mForegroundProcessor;
                String str = this.mWorkSpecId;
                Processor processor = (Processor) foregroundProcessor;
                synchronized (processor.mLock) {
                    processor.mForegroundWorkMap.remove(str);
                    processor.stopForegroundService();
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            this.mFuture.set(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    public final void resolveIncorrectStatus() {
        WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
        if (state == WorkInfo$State.RUNNING) {
            Logger.get().debug(TAG, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger.get().debug(TAG, String.format("Status for %s is %s; not doing any work", new Object[]{this.mWorkSpecId, state}), new Throwable[0]);
        resolve(false);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c8, code lost:
        if ((r0.state == androidx.work.WorkInfo$State.ENQUEUED && r0.runAttemptCount > 0) != false) goto L_0x00ca;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r18 = this;
            r1 = r18
            androidx.work.impl.model.WorkTagDao r0 = r1.mWorkTagDao
            java.lang.String r2 = r1.mWorkSpecId
            androidx.work.impl.model.WorkTagDao_Impl r0 = (androidx.work.impl.model.WorkTagDao_Impl) r0
            java.util.List r0 = r0.getTagsForWorkSpecId(r2)
            r1.mTags = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Work [ id="
            r2.<init>(r3)
            java.lang.String r3 = r1.mWorkSpecId
            r2.append(r3)
            java.lang.String r3 = ", tags={ "
            r2.append(r3)
            java.util.Iterator r0 = r0.iterator()
            r3 = 1
            r4 = 1
        L_0x0025:
            boolean r5 = r0.hasNext()
            r6 = 0
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            if (r4 == 0) goto L_0x0036
            r4 = 0
            goto L_0x003b
        L_0x0036:
            java.lang.String r6 = ", "
            r2.append(r6)
        L_0x003b:
            r2.append(r5)
            goto L_0x0025
        L_0x003f:
            java.lang.String r0 = " } ]"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.mWorkDescription = r0
            boolean r0 = r18.tryCheckForInterruptionAndResolve()
            if (r0 == 0) goto L_0x0052
            goto L_0x02a7
        L_0x0052:
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase
            r0.beginTransaction()
            androidx.work.impl.model.WorkSpecDao r0 = r1.mWorkSpecDao     // Catch:{ all -> 0x02b9 }
            java.lang.String r2 = r1.mWorkSpecId     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0
            androidx.work.impl.model.WorkSpec r0 = r0.getWorkSpec(r2)     // Catch:{ all -> 0x02b9 }
            r1.mWorkSpec = r0     // Catch:{ all -> 0x02b9 }
            if (r0 != 0) goto L_0x008b
            androidx.work.Logger r0 = androidx.work.Logger.get()     // Catch:{ all -> 0x02b9 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x02b9 }
            java.lang.String r4 = "Didn't find WorkSpec for id %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b9 }
            java.lang.String r5 = r1.mWorkSpecId     // Catch:{ all -> 0x02b9 }
            r3[r6] = r5     // Catch:{ all -> 0x02b9 }
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x02b9 }
            java.lang.Throwable[] r4 = new java.lang.Throwable[r6]     // Catch:{ all -> 0x02b9 }
            r0.error(r2, r3, r4)     // Catch:{ all -> 0x02b9 }
            r1.resolve(r6)     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase     // Catch:{ all -> 0x02b9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02b9 }
        L_0x0084:
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase
            r0.endTransaction()
            goto L_0x02a7
        L_0x008b:
            androidx.work.WorkInfo$State r2 = r0.state     // Catch:{ all -> 0x02b9 }
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo$State.ENQUEUED     // Catch:{ all -> 0x02b9 }
            if (r2 == r4) goto L_0x00b3
            r18.resolveIncorrectStatus()     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase     // Catch:{ all -> 0x02b9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02b9 }
            androidx.work.Logger r0 = androidx.work.Logger.get()     // Catch:{ all -> 0x02b9 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x02b9 }
            java.lang.String r4 = "%s is not in ENQUEUED state. Nothing more to do."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.model.WorkSpec r5 = r1.mWorkSpec     // Catch:{ all -> 0x02b9 }
            java.lang.String r5 = r5.workerClassName     // Catch:{ all -> 0x02b9 }
            r3[r6] = r5     // Catch:{ all -> 0x02b9 }
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x02b9 }
            java.lang.Throwable[] r4 = new java.lang.Throwable[r6]     // Catch:{ all -> 0x02b9 }
            r0.debug(r2, r3, r4)     // Catch:{ all -> 0x02b9 }
            goto L_0x0084
        L_0x00b3:
            boolean r0 = r0.isPeriodic()     // Catch:{ all -> 0x02b9 }
            if (r0 != 0) goto L_0x00ca
            androidx.work.impl.model.WorkSpec r0 = r1.mWorkSpec     // Catch:{ all -> 0x02b9 }
            androidx.work.WorkInfo$State r2 = r0.state     // Catch:{ all -> 0x02b9 }
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo$State.ENQUEUED     // Catch:{ all -> 0x02b9 }
            if (r2 != r4) goto L_0x00c7
            int r0 = r0.runAttemptCount     // Catch:{ all -> 0x02b9 }
            if (r0 <= 0) goto L_0x00c7
            r0 = 1
            goto L_0x00c8
        L_0x00c7:
            r0 = 0
        L_0x00c8:
            if (r0 == 0) goto L_0x010a
        L_0x00ca:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.model.WorkSpec r0 = r1.mWorkSpec     // Catch:{ all -> 0x02b9 }
            long r7 = r0.periodStartTime     // Catch:{ all -> 0x02b9 }
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x00da
            r0 = 1
            goto L_0x00db
        L_0x00da:
            r0 = 0
        L_0x00db:
            if (r0 != 0) goto L_0x010a
            androidx.work.impl.model.WorkSpec r0 = r1.mWorkSpec     // Catch:{ all -> 0x02b9 }
            long r7 = r0.calculateNextRunTime()     // Catch:{ all -> 0x02b9 }
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x010a
            androidx.work.Logger r0 = androidx.work.Logger.get()     // Catch:{ all -> 0x02b9 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x02b9 }
            java.lang.String r4 = "Delaying execution for %s because it is being executed before schedule."
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.model.WorkSpec r7 = r1.mWorkSpec     // Catch:{ all -> 0x02b9 }
            java.lang.String r7 = r7.workerClassName     // Catch:{ all -> 0x02b9 }
            r5[r6] = r7     // Catch:{ all -> 0x02b9 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x02b9 }
            java.lang.Throwable[] r5 = new java.lang.Throwable[r6]     // Catch:{ all -> 0x02b9 }
            r0.debug(r2, r4, r5)     // Catch:{ all -> 0x02b9 }
            r1.resolve(r3)     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase     // Catch:{ all -> 0x02b9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02b9 }
            goto L_0x0084
        L_0x010a:
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase     // Catch:{ all -> 0x02b9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02b9 }
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase
            r0.endTransaction()
            androidx.work.impl.model.WorkSpec r0 = r1.mWorkSpec
            boolean r0 = r0.isPeriodic()
            if (r0 == 0) goto L_0x0123
            androidx.work.impl.model.WorkSpec r0 = r1.mWorkSpec
            androidx.work.Data r0 = r0.input
        L_0x0120:
            r9 = r0
            goto L_0x01aa
        L_0x0123:
            androidx.work.Configuration r0 = r1.mConfiguration
            androidx.work.InputMergerFactory r0 = r0.mInputMergerFactory
            androidx.work.impl.model.WorkSpec r2 = r1.mWorkSpec
            java.lang.String r2 = r2.inputMergerClassName
            r4 = 0
            if (r0 == 0) goto L_0x02b8
            androidx.work.InputMerger r0 = androidx.work.InputMerger.fromClassName(r2)
            if (r0 != 0) goto L_0x0152
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            androidx.work.impl.model.WorkSpec r4 = r1.mWorkSpec
            java.lang.String r4 = r4.inputMergerClassName
            r3[r6] = r4
            java.lang.String r4 = "Could not create Input Merger %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r6]
            r0.error(r2, r3, r4)
            r18.setFailedAndResolve()
            goto L_0x02a7
        L_0x0152:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            androidx.work.impl.model.WorkSpec r5 = r1.mWorkSpec
            androidx.work.Data r5 = r5.input
            r2.add(r5)
            androidx.work.impl.model.WorkSpecDao r5 = r1.mWorkSpecDao
            java.lang.String r7 = r1.mWorkSpecId
            androidx.work.impl.model.WorkSpecDao_Impl r5 = (androidx.work.impl.model.WorkSpecDao_Impl) r5
            if (r5 == 0) goto L_0x02b7
            java.lang.String r8 = "SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)"
            androidx.room.RoomSQLiteQuery r8 = androidx.room.RoomSQLiteQuery.acquire(r8, r3)
            if (r7 != 0) goto L_0x0172
            r8.bindNull(r3)
            goto L_0x0175
        L_0x0172:
            r8.bindString(r3, r7)
        L_0x0175:
            androidx.room.RoomDatabase r7 = r5.__db
            r7.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r5 = r5.__db
            android.database.Cursor r4 = androidx.core.widget.CompoundButtonCompat.query(r5, r8, r6, r4)
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x02af }
            int r7 = r4.getCount()     // Catch:{ all -> 0x02af }
            r5.<init>(r7)     // Catch:{ all -> 0x02af }
        L_0x0189:
            boolean r7 = r4.moveToNext()     // Catch:{ all -> 0x02af }
            if (r7 == 0) goto L_0x019b
            byte[] r7 = r4.getBlob(r6)     // Catch:{ all -> 0x02af }
            androidx.work.Data r7 = androidx.work.Data.fromByteArray(r7)     // Catch:{ all -> 0x02af }
            r5.add(r7)     // Catch:{ all -> 0x02af }
            goto L_0x0189
        L_0x019b:
            r4.close()
            r8.release()
            r2.addAll(r5)
            androidx.work.Data r0 = r0.merge(r2)
            goto L_0x0120
        L_0x01aa:
            androidx.work.WorkerParameters r0 = new androidx.work.WorkerParameters
            java.lang.String r2 = r1.mWorkSpecId
            java.util.UUID r8 = java.util.UUID.fromString(r2)
            java.util.List<java.lang.String> r10 = r1.mTags
            androidx.work.WorkerParameters$RuntimeExtras r11 = r1.mRuntimeExtras
            androidx.work.impl.model.WorkSpec r2 = r1.mWorkSpec
            int r12 = r2.runAttemptCount
            androidx.work.Configuration r2 = r1.mConfiguration
            java.util.concurrent.Executor r13 = r2.mExecutor
            androidx.work.impl.utils.taskexecutor.TaskExecutor r14 = r1.mWorkTaskExecutor
            androidx.work.WorkerFactory r15 = r2.mWorkerFactory
            androidx.work.impl.utils.WorkProgressUpdater r2 = new androidx.work.impl.utils.WorkProgressUpdater
            androidx.work.impl.WorkDatabase r4 = r1.mWorkDatabase
            androidx.work.impl.utils.taskexecutor.TaskExecutor r5 = r1.mWorkTaskExecutor
            r2.<init>(r4, r5)
            androidx.work.impl.utils.WorkForegroundUpdater r4 = new androidx.work.impl.utils.WorkForegroundUpdater
            androidx.work.impl.WorkDatabase r5 = r1.mWorkDatabase
            androidx.work.impl.foreground.ForegroundProcessor r7 = r1.mForegroundProcessor
            androidx.work.impl.utils.taskexecutor.TaskExecutor r6 = r1.mWorkTaskExecutor
            r4.<init>(r5, r7, r6)
            r7 = r0
            r16 = r2
            r17 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.work.ListenableWorker r2 = r1.mWorker
            if (r2 != 0) goto L_0x01f2
            androidx.work.Configuration r2 = r1.mConfiguration
            androidx.work.WorkerFactory r2 = r2.mWorkerFactory
            android.content.Context r4 = r1.mAppContext
            androidx.work.impl.model.WorkSpec r5 = r1.mWorkSpec
            java.lang.String r5 = r5.workerClassName
            androidx.work.ListenableWorker r0 = r2.createWorkerWithDefaultFallback(r4, r5, r0)
            r1.mWorker = r0
        L_0x01f2:
            androidx.work.ListenableWorker r0 = r1.mWorker
            if (r0 != 0) goto L_0x0215
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            androidx.work.impl.model.WorkSpec r4 = r1.mWorkSpec
            java.lang.String r4 = r4.workerClassName
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "Could not create Worker %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r5]
            r0.error(r2, r3, r4)
            r18.setFailedAndResolve()
            goto L_0x02a7
        L_0x0215:
            r5 = 0
            boolean r0 = r0.isUsed()
            if (r0 == 0) goto L_0x0239
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            androidx.work.impl.model.WorkSpec r4 = r1.mWorkSpec
            java.lang.String r4 = r4.workerClassName
            r3[r5] = r4
            java.lang.String r4 = "Received an already-used Worker %s; WorkerFactory should return new instances"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r5]
            r0.error(r2, r3, r4)
            r18.setFailedAndResolve()
            goto L_0x02a7
        L_0x0239:
            androidx.work.ListenableWorker r0 = r1.mWorker
            r0.setUsed()
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase
            r0.beginTransaction()
            androidx.work.impl.model.WorkSpecDao r0 = r1.mWorkSpecDao     // Catch:{ all -> 0x02a8 }
            java.lang.String r2 = r1.mWorkSpecId     // Catch:{ all -> 0x02a8 }
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0
            androidx.work.WorkInfo$State r0 = r0.getState(r2)     // Catch:{ all -> 0x02a8 }
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo$State.ENQUEUED     // Catch:{ all -> 0x02a8 }
            if (r0 != r2) goto L_0x026b
            androidx.work.impl.model.WorkSpecDao r0 = r1.mWorkSpecDao     // Catch:{ all -> 0x02a8 }
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo$State.RUNNING     // Catch:{ all -> 0x02a8 }
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x02a8 }
            java.lang.String r5 = r1.mWorkSpecId     // Catch:{ all -> 0x02a8 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x02a8 }
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0
            r0.setState(r2, r4)     // Catch:{ all -> 0x02a8 }
            androidx.work.impl.model.WorkSpecDao r0 = r1.mWorkSpecDao     // Catch:{ all -> 0x02a8 }
            java.lang.String r2 = r1.mWorkSpecId     // Catch:{ all -> 0x02a8 }
            androidx.work.impl.model.WorkSpecDao_Impl r0 = (androidx.work.impl.model.WorkSpecDao_Impl) r0
            r0.incrementWorkSpecRunAttemptCount(r2)     // Catch:{ all -> 0x02a8 }
            goto L_0x026d
        L_0x026b:
            r6 = 0
            r3 = 0
        L_0x026d:
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase     // Catch:{ all -> 0x02a8 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x02a8 }
            androidx.work.impl.WorkDatabase r0 = r1.mWorkDatabase
            r0.endTransaction()
            if (r3 == 0) goto L_0x02a4
            boolean r0 = r18.tryCheckForInterruptionAndResolve()
            if (r0 == 0) goto L_0x0280
            goto L_0x02a7
        L_0x0280:
            androidx.work.impl.utils.futures.SettableFuture r0 = new androidx.work.impl.utils.futures.SettableFuture
            r0.<init>()
            androidx.work.impl.utils.taskexecutor.TaskExecutor r2 = r1.mWorkTaskExecutor
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = (androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) r2
            java.util.concurrent.Executor r2 = r2.mMainThreadExecutor
            androidx.work.impl.WorkerWrapper$1 r3 = new androidx.work.impl.WorkerWrapper$1
            r3.<init>(r0)
            r2.execute(r3)
            java.lang.String r2 = r1.mWorkDescription
            androidx.work.impl.WorkerWrapper$2 r3 = new androidx.work.impl.WorkerWrapper$2
            r3.<init>(r0, r2)
            androidx.work.impl.utils.taskexecutor.TaskExecutor r2 = r1.mWorkTaskExecutor
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = (androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor) r2
            androidx.work.impl.utils.SerialExecutor r2 = r2.mBackgroundExecutor
            r0.addListener(r3, r2)
            goto L_0x02a7
        L_0x02a4:
            r18.resolveIncorrectStatus()
        L_0x02a7:
            return
        L_0x02a8:
            r0 = move-exception
            androidx.work.impl.WorkDatabase r2 = r1.mWorkDatabase
            r2.endTransaction()
            throw r0
        L_0x02af:
            r0 = move-exception
            r4.close()
            r8.release()
            throw r0
        L_0x02b7:
            throw r4
        L_0x02b8:
            throw r4
        L_0x02b9:
            r0 = move-exception
            androidx.work.impl.WorkDatabase r2 = r1.mWorkDatabase
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.run():void");
    }

    public void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            ((WorkSpecDao_Impl) this.mWorkSpecDao).setOutput(this.mWorkSpecId, ((Failure) this.mResult).mOutputData);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(TAG, String.format("Work interrupted for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
        WorkInfo$State state = ((WorkSpecDao_Impl) this.mWorkSpecDao).getState(this.mWorkSpecId);
        if (state == null) {
            resolve(false);
        } else {
            resolve(!state.isFinished());
        }
        return true;
    }
}
