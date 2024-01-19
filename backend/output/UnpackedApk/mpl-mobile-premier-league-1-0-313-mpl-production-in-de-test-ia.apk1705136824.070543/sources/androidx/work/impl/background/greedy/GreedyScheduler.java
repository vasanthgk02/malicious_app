package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.greedy.DelayedWorkTracker.AnonymousClass1;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    public final Set<WorkSpec> mConstrainedWorkSpecs = new HashSet();
    public final Context mContext;
    public DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mInDefaultProcess;
    public final Object mLock;
    public boolean mRegisteredExecutionListener;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final WorkManagerImpl mWorkManagerImpl;

    public GreedyScheduler(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.mRunnableScheduler);
        this.mLock = new Object();
    }

    public void cancel(String str) {
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.mConfiguration));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            Runnable remove = delayedWorkTracker.mRunnables.remove(str);
            if (remove != null) {
                delayedWorkTracker.mRunnableScheduler.mHandler.removeCallbacks(remove);
            }
        }
        this.mWorkManagerImpl.stopWork(str);
    }

    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    public void onAllConstraintsMet(List<String> list) {
        for (String next : list) {
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
            TaskExecutor taskExecutor = workManagerImpl.mWorkTaskExecutor;
            ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new StartWorkRunnable(workManagerImpl, next, null));
        }
    }

    public void onAllConstraintsNotMet(List<String> list) {
        for (String next : list) {
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(next);
        }
    }

    public void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            Iterator<WorkSpec> it = this.mConstrainedWorkSpecs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec next = it.next();
                if (next.id.equals(str)) {
                    Logger.get().debug(TAG, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.mConstrainedWorkSpecs.remove(next);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                }
            }
        }
    }

    public void schedule(WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.mConfiguration));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == WorkInfo$State.ENQUEUED) {
                if (currentTimeMillis < calculateNextRunTime) {
                    DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        Runnable remove = delayedWorkTracker.mRunnables.remove(workSpec.id);
                        if (remove != null) {
                            delayedWorkTracker.mRunnableScheduler.mHandler.removeCallbacks(remove);
                        }
                        AnonymousClass1 r8 = new Runnable(workSpec) {
                            public final /* synthetic */ WorkSpec val$workSpec;

                            {
                                this.val$workSpec = r2;
                            }

                            public void run() {
                                Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", new Object[]{this.val$workSpec.id}), new Throwable[0]);
                                DelayedWorkTracker.this.mGreedyScheduler.schedule(this.val$workSpec);
                            }
                        };
                        delayedWorkTracker.mRunnables.put(workSpec.id, r8);
                        delayedWorkTracker.mRunnableScheduler.mHandler.postDelayed(r8, workSpec.calculateNextRunTime() - System.currentTimeMillis());
                    }
                } else if (!workSpec.hasConstraints()) {
                    Logger.get().debug(TAG, String.format("Starting work for %s", new Object[]{workSpec.id}), new Throwable[0]);
                    WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
                    ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).mBackgroundExecutor.execute(new StartWorkRunnable(workManagerImpl, workSpec.id, null));
                } else if (VERSION.SDK_INT < 23 || !workSpec.constraints.mRequiresDeviceIdle) {
                    if (VERSION.SDK_INT >= 24) {
                        if (workSpec.constraints.mContentUriTriggers.size() > 0) {
                            Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{workSpec}), new Throwable[0]);
                        }
                    }
                    hashSet.add(workSpec);
                    hashSet2.add(workSpec.id);
                } else {
                    Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{workSpec}), new Throwable[0]);
                }
            }
        }
        synchronized (this.mLock) {
            if (!hashSet.isEmpty()) {
                Logger.get().debug(TAG, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                this.mConstrainedWorkSpecs.addAll(hashSet);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }
}
