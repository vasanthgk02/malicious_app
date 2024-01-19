package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    public static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    public final ThreadFactory threadFactory = THREAD_FACTORY;

    public Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
