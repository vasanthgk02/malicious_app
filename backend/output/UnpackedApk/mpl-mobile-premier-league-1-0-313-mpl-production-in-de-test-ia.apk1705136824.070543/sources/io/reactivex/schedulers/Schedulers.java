package io.reactivex.schedulers;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Callable;

public final class Schedulers {
    public static final Scheduler COMPUTATION;
    public static final Scheduler IO;
    public static final Scheduler NEW_THREAD;

    public static final class ComputationHolder {
        public static final Scheduler DEFAULT = new ComputationScheduler();
    }

    public static final class ComputationTask implements Callable<Scheduler> {
        public Object call() throws Exception {
            return ComputationHolder.DEFAULT;
        }
    }

    public static final class IOTask implements Callable<Scheduler> {
        public Object call() throws Exception {
            return IoHolder.DEFAULT;
        }
    }

    public static final class IoHolder {
        public static final Scheduler DEFAULT = new IoScheduler();
    }

    public static final class NewThreadHolder {
        public static final Scheduler DEFAULT = new NewThreadScheduler();
    }

    public static final class NewThreadTask implements Callable<Scheduler> {
        public Object call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }

    public static final class SingleHolder {
        public static final Scheduler DEFAULT = new SingleScheduler();
    }

    public static final class SingleTask implements Callable<Scheduler> {
        public Object call() throws Exception {
            return SingleHolder.DEFAULT;
        }
    }

    static {
        SingleTask singleTask = new SingleTask();
        ObjectHelper.requireNonNull(singleTask, "Scheduler Callable can't be null");
        TweetUtils.callRequireNonNull1(singleTask);
        ComputationTask computationTask = new ComputationTask();
        ObjectHelper.requireNonNull(computationTask, "Scheduler Callable can't be null");
        COMPUTATION = TweetUtils.callRequireNonNull1(computationTask);
        IOTask iOTask = new IOTask();
        ObjectHelper.requireNonNull(iOTask, "Scheduler Callable can't be null");
        IO = TweetUtils.callRequireNonNull1(iOTask);
        TrampolineScheduler trampolineScheduler = TrampolineScheduler.INSTANCE;
        NewThreadTask newThreadTask = new NewThreadTask();
        ObjectHelper.requireNonNull(newThreadTask, "Scheduler Callable can't be null");
        NEW_THREAD = TweetUtils.callRequireNonNull1(newThreadTask);
    }
}
