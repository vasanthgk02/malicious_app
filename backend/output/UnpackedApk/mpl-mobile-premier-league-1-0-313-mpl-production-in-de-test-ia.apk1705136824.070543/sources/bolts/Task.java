package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult> {
    public static final Executor IMMEDIATE_EXECUTOR;
    public static Task<Boolean> TASK_FALSE = new Task<>((TResult) Boolean.FALSE);
    public static Task<?> TASK_NULL = new Task<>((TResult) null);
    public static Task<Boolean> TASK_TRUE = new Task<>((TResult) Boolean.TRUE);
    public boolean cancelled;
    public boolean complete;
    public List<Continuation<TResult, Void>> continuations = new ArrayList();
    public Exception error;
    public boolean errorHasBeenObserved;
    public final Object lock = new Object();
    public TResult result;
    public UnobservedErrorNotifier unobservedErrorNotifier;

    static {
        BoltsExecutors boltsExecutors = BoltsExecutors.INSTANCE;
        ExecutorService executorService = boltsExecutors.background;
        IMMEDIATE_EXECUTOR = boltsExecutors.immediate;
        Executor executor = AndroidExecutors.INSTANCE.uiThread;
        new Task(true);
    }

    public Task() {
    }

    public static <TResult> Task<TResult> call(final Callable<TResult> callable, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                public final /* synthetic */ CancellationToken val$ct = null;

                public void run() {
                    try {
                        TaskCompletionSource.this.setResult(callable.call());
                    } catch (CancellationException unused) {
                        TaskCompletionSource.this.setCancelled();
                    } catch (Exception e2) {
                        TaskCompletionSource.this.setError(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.setError(new ExecutorException(e2));
        }
        return taskCompletionSource.task;
    }

    public static <TResult> Task<TResult> forError(Exception exc) {
        boolean z;
        Task<TResult> task = new Task<>();
        synchronized (task.lock) {
            try {
                z = false;
                if (!task.complete) {
                    task.complete = true;
                    task.error = exc;
                    task.errorHasBeenObserved = false;
                    task.lock.notifyAll();
                    task.runContinuations();
                    z = true;
                }
            }
        }
        if (z) {
            return task;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        if (tresult == null) {
            return TASK_NULL;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? TASK_TRUE : TASK_FALSE;
        }
        Task<TResult> task = new Task<>();
        if (task.trySetResult(tresult)) {
            return task;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        boolean z;
        final Executor executor = IMMEDIATE_EXECUTOR;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            synchronized (this.lock) {
                z = this.complete;
            }
            if (!z) {
                this.continuations.add(new Continuation<TResult, Void>(this) {
                    public final /* synthetic */ CancellationToken val$ct = null;

                    public Object then(Task task) throws Exception {
                        TaskCompletionSource taskCompletionSource = taskCompletionSource;
                        Continuation continuation = continuation;
                        try {
                            executor.execute(new Runnable(continuation, task) {
                                public final /* synthetic */ CancellationToken val$ct = null;

                                public void run() {
                                    try {
                                        TaskCompletionSource.this.setResult(continuation.then(this));
                                    } catch (CancellationException unused) {
                                        TaskCompletionSource.this.setCancelled();
                                    } catch (Exception e2) {
                                        TaskCompletionSource.this.setError(e2);
                                    }
                                }
                            });
                        } catch (Exception e2) {
                            taskCompletionSource.setError(new ExecutorException(e2));
                        }
                        return null;
                    }
                });
            }
        }
        if (z) {
            try {
                executor.execute(new Runnable() {
                    public final /* synthetic */ CancellationToken val$ct = null;

                    public void run() {
                        try {
                            TaskCompletionSource.this.setResult(continuation.then(this));
                        } catch (CancellationException unused) {
                            TaskCompletionSource.this.setCancelled();
                        } catch (Exception e2) {
                            TaskCompletionSource.this.setError(e2);
                        }
                    }
                });
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.task;
    }

    public Exception getError() {
        Exception exc;
        synchronized (this.lock) {
            try {
                if (this.error != null) {
                    this.errorHasBeenObserved = true;
                    if (this.unobservedErrorNotifier != null) {
                        this.unobservedErrorNotifier.task = null;
                        this.unobservedErrorNotifier = null;
                    }
                }
                exc = this.error;
            }
        }
        return exc;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.lock) {
            try {
                tresult = this.result;
            }
        }
        return tresult;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            try {
                z = this.cancelled;
            }
        }
        return z;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.lock) {
            try {
                z = getError() != null;
            }
        }
        return z;
    }

    public final void runContinuations() {
        synchronized (this.lock) {
            for (Continuation then : this.continuations) {
                try {
                    then.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.continuations = null;
        }
    }

    public boolean trySetCancelled() {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.cancelled = true;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public boolean trySetResult(TResult tresult) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.result = tresult;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public Task(TResult tresult) {
        trySetResult(tresult);
    }

    public Task(boolean z) {
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }
}
