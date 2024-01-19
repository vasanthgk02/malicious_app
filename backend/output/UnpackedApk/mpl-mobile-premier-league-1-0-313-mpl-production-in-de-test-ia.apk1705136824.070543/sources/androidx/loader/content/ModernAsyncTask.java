package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.AsyncTaskLoader.LoadTask;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final Executor THREAD_POOL_EXECUTOR;
    public static InternalHandler sHandler;
    public static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(10);
    public static final ThreadFactory sThreadFactory = new ThreadFactory() {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ModernAsyncTask #");
            outline73.append(this.mCount.getAndIncrement());
            return new Thread(runnable, outline73.toString());
        }
    };
    public final AtomicBoolean mCancelled = new AtomicBoolean();
    public final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        public void done() {
            try {
                Object obj = get();
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                if (!modernAsyncTask.mTaskInvoked.get()) {
                    modernAsyncTask.postResult(obj);
                }
            } catch (InterruptedException unused) {
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused2) {
                ModernAsyncTask modernAsyncTask2 = ModernAsyncTask.this;
                if (!modernAsyncTask2.mTaskInvoked.get()) {
                    modernAsyncTask2.postResult(null);
                }
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    public volatile Status mStatus = Status.PENDING;
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    public final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        public Result call() throws Exception {
            LoadTask loadTask;
            ModernAsyncTask.this.mTaskInvoked.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                Params[] paramsArr = this.mParams;
                loadTask = (LoadTask) modernAsyncTask;
                if (loadTask != null) {
                    Void[] voidArr = (Void[]) paramsArr;
                    result = AsyncTaskLoader.this.onLoadInBackground();
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.postResult(result);
                    return result;
                }
                throw null;
            } catch (OperationCanceledException e2) {
                if (!loadTask.mCancelled.get()) {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    ModernAsyncTask.this.mCancelled.set(true);
                    throw th;
                } catch (Throwable th2) {
                    ModernAsyncTask.this.postResult(null);
                    throw th2;
                }
            }
        }
    };

    public static class AsyncTaskResult<Data> {
        public final Data[] mData;
        public final ModernAsyncTask mTask;

        public AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                ModernAsyncTask modernAsyncTask = asyncTaskResult.mTask;
                Data data = asyncTaskResult.mData[0];
                if (modernAsyncTask.mCancelled.get()) {
                    LoadTask loadTask = (LoadTask) modernAsyncTask;
                    try {
                        AsyncTaskLoader.this.dispatchOnCancelled(loadTask, data);
                    } finally {
                        loadTask.mDone.countDown();
                    }
                } else {
                    LoadTask loadTask2 = (LoadTask) modernAsyncTask;
                    try {
                        AsyncTaskLoader.this.dispatchOnLoadComplete(loadTask2, data);
                    } finally {
                        loadTask2.mDone.countDown();
                    }
                }
                modernAsyncTask.mStatus = Status.FINISHED;
            } else if (i == 2 && asyncTaskResult.mTask == null) {
                throw null;
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        public Params[] mParams;
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public Result postResult(Result result) {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            internalHandler = sHandler;
        }
        internalHandler.obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }
}
