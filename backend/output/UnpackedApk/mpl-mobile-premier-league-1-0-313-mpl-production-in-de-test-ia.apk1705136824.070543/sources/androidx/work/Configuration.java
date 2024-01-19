package androidx.work;

import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class Configuration {
    public final String mDefaultProcessName;
    public final InitializationExceptionHandler mExceptionHandler;
    public final Executor mExecutor = createDefaultExecutor();
    public final InputMergerFactory mInputMergerFactory;
    public final int mLoggingLevel;
    public final int mMaxJobSchedulerId;
    public final int mMaxSchedulerLimit;
    public final int mMinJobSchedulerId;
    public final DefaultRunnableScheduler mRunnableScheduler;
    public final Executor mTaskExecutor = createDefaultExecutor();
    public final WorkerFactory mWorkerFactory;

    public static final class Builder {
        public int mLoggingLevel = 4;
        public int mMaxJobSchedulerId = Integer.MAX_VALUE;
        public int mMaxSchedulerLimit = 20;
        public int mMinJobSchedulerId = 0;
        public WorkerFactory mWorkerFactory;
    }

    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        WorkerFactory workerFactory = builder.mWorkerFactory;
        if (workerFactory == null) {
            this.mWorkerFactory = WorkerFactory.getDefaultWorkerFactory();
        } else {
            this.mWorkerFactory = workerFactory;
        }
        this.mInputMergerFactory = new InputMergerFactory() {
        };
        this.mRunnableScheduler = new DefaultRunnableScheduler();
        this.mLoggingLevel = builder.mLoggingLevel;
        this.mMinJobSchedulerId = builder.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = builder.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = builder.mMaxSchedulerLimit;
        this.mExceptionHandler = null;
        this.mDefaultProcessName = null;
    }

    public final Executor createDefaultExecutor() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
