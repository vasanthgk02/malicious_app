package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    public final Set<LottieListener<Throwable>> failureListeners = new LinkedHashSet(1);
    public final Handler handler = new Handler(Looper.getMainLooper());
    public volatile LottieResult<T> result = null;
    public final Set<LottieListener<T>> successListeners = new LinkedHashSet(1);

    public class LottieFutureTask extends FutureTask<LottieResult<T>> {
        public LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        public void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.setResult((LottieResult) get());
                } catch (InterruptedException | ExecutionException e2) {
                    LottieTask.this.setResult(new LottieResult(e2));
                }
            }
        }
    }

    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        if (z) {
            try {
                setResult(callable.call());
            } catch (Throwable th) {
                setResult(new LottieResult(th));
            }
        } else {
            EXECUTOR.execute(new LottieFutureTask(callable));
        }
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (!(this.result == null || this.result.exception == null)) {
            lottieListener.onResult(this.result.exception);
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (!(this.result == null || this.result.value == null)) {
            lottieListener.onResult(this.result.value);
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public final void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            this.handler.post(new Runnable() {
                public void run() {
                    if (LottieTask.this.result != null) {
                        LottieResult<T> lottieResult = LottieTask.this.result;
                        V v = lottieResult.value;
                        if (v != null) {
                            LottieTask lottieTask = LottieTask.this;
                            synchronized (lottieTask) {
                                Iterator it = new ArrayList(lottieTask.successListeners).iterator();
                                while (it.hasNext()) {
                                    ((LottieListener) it.next()).onResult(v);
                                }
                            }
                        } else {
                            LottieTask lottieTask2 = LottieTask.this;
                            Throwable th = lottieResult.exception;
                            synchronized (lottieTask2) {
                                ArrayList arrayList = new ArrayList(lottieTask2.failureListeners);
                                if (arrayList.isEmpty()) {
                                    Logger.warning("Lottie encountered an error but no failure listener was added:", th);
                                } else {
                                    Iterator it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        ((LottieListener) it2.next()).onResult(th);
                                    }
                                }
                            }
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
