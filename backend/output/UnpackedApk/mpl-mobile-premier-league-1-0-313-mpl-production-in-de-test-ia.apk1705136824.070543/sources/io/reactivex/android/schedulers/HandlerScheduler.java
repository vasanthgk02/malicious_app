package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class HandlerScheduler extends Scheduler {
    public final boolean async;
    public final Handler handler;

    public static final class HandlerWorker extends Worker {
        public final boolean async;
        public volatile boolean disposed;
        public final Handler handler;

        public HandlerWorker(Handler handler2, boolean z) {
            this.handler = handler2;
            this.async = z;
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @SuppressLint({"NewApi"})
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            } else {
                ObjectHelper.requireNonNull(runnable, "run is null");
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, runnable);
                Message obtain = Message.obtain(this.handler, scheduledRunnable);
                obtain.obj = this;
                if (this.async) {
                    obtain.setAsynchronous(true);
                }
                this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.disposed) {
                    return scheduledRunnable;
                }
                this.handler.removeCallbacks(scheduledRunnable);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    public static final class ScheduledRunnable implements Runnable, Disposable {
        public final Runnable delegate;
        public volatile boolean disposed;
        public final Handler handler;

        public ScheduledRunnable(Handler handler2, Runnable runnable) {
            this.handler = handler2;
            this.delegate = runnable;
        }

        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                TweetUtils.onError(th);
            }
        }
    }

    public HandlerScheduler(Handler handler2, boolean z) {
        this.handler = handler2;
        this.async = z;
    }

    public Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    @SuppressLint({"NewApi"})
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, runnable);
            Message obtain = Message.obtain(this.handler, scheduledRunnable);
            if (this.async) {
                obtain.setAsynchronous(true);
            }
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
