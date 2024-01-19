package io.reactivex.internal.schedulers;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public static final class SleepingRunnable implements Runnable {
        public final long execTime;
        public final Runnable run;
        public final TrampolineWorker worker;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j;
        }

        public void run() {
            if (!this.worker.disposed) {
                long now = this.worker.now(TimeUnit.MILLISECONDS);
                long j = this.execTime;
                if (j > now) {
                    try {
                        Thread.sleep(j - now);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        TweetUtils.onError(e2);
                        return;
                    }
                }
                if (!this.worker.disposed) {
                    this.run.run();
                }
            }
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public final int count;
        public volatile boolean disposed;
        public final long execTime;
        public final Runnable run;

        public TimedRunnable(Runnable runnable, Long l, int i) {
            this.run = runnable;
            this.execTime = l.longValue();
            this.count = i;
        }

        public int compareTo(Object obj) {
            TimedRunnable timedRunnable = (TimedRunnable) obj;
            int i = 0;
            int i2 = (this.execTime > timedRunnable.execTime ? 1 : (this.execTime == timedRunnable.execTime ? 0 : -1));
            int i3 = i2 < 0 ? -1 : i2 > 0 ? 1 : 0;
            if (i3 != 0) {
                return i3;
            }
            int i4 = this.count;
            int i5 = timedRunnable.count;
            if (i4 < i5) {
                i = -1;
            } else if (i4 > i5) {
                i = 1;
            }
            return i;
        }
    }

    public static final class TrampolineWorker extends Worker implements Disposable {
        public final AtomicInteger counter = new AtomicInteger();
        public volatile boolean disposed;
        public final PriorityBlockingQueue<TimedRunnable> queue = new PriorityBlockingQueue<>();
        public final AtomicInteger wip = new AtomicInteger();

        public final class AppendToQueueTask implements Runnable {
            public final TimedRunnable timedRunnable;

            public AppendToQueueTask(TimedRunnable timedRunnable2) {
                this.timedRunnable = timedRunnable2;
            }

            public void run() {
                this.timedRunnable.disposed = true;
                TrampolineWorker.this.queue.remove(this.timedRunnable);
            }
        }

        public void dispose() {
            this.disposed = true;
        }

        public Disposable enqueue(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.counter.incrementAndGet());
            this.queue.add(timedRunnable);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    TimedRunnable poll = this.queue.poll();
                    if (poll == null) {
                        i = this.wip.addAndGet(-i);
                        if (i == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    } else if (!poll.disposed) {
                        poll.run.run();
                    }
                }
                this.queue.clear();
                return EmptyDisposable.INSTANCE;
            }
            AppendToQueueTask appendToQueueTask = new AppendToQueueTask(timedRunnable);
            ObjectHelper.requireNonNull(appendToQueueTask, "run is null");
            return new RunnableDisposable(appendToQueueTask);
        }

        public Disposable schedule(Runnable runnable) {
            return enqueue(runnable, now(TimeUnit.MILLISECONDS));
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + now(TimeUnit.MILLISECONDS);
            return enqueue(new SleepingRunnable(runnable, this, millis), millis);
        }
    }

    public Worker createWorker() {
        return new TrampolineWorker();
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            ObjectHelper.requireNonNull(runnable, "run is null");
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            TweetUtils.onError(e2);
        }
        return EmptyDisposable.INSTANCE;
    }

    public Disposable scheduleDirect(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }
}
