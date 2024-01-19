package com.freshchat.consumer.sdk.j.a;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR = (aw.eT() ? new c() : Executors.newSingleThreadExecutor(iJ));
    public static final Executor THREAD_POOL_EXECUTOR;
    public static final ThreadFactory iJ = new ThreadFactory() {
        public final AtomicInteger iT = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("AsyncTask #");
            outline73.append(this.iT.getAndIncrement());
            return new Thread(runnable, outline73.toString());
        }
    };
    public static final BlockingQueue<Runnable> iK = new LinkedBlockingQueue(10);
    public static final Executor iL = Executors.newFixedThreadPool(2, iJ);
    public static final b iM = new b();
    public static volatile Executor iN = SERIAL_EXECUTOR;
    public final e<Params, Result> iO = new e<Params, Result>() {
        public Result call() throws Exception {
            a.this.iS.set(true);
            Process.setThreadPriority(10);
            a aVar = a.this;
            return aVar.c(aVar.doInBackground(this.jg));
        }
    };
    public final FutureTask<Result> iP = new FutureTask<Result>(this.iO) {
        public void done() {
            try {
                a.this.b(get());
            } catch (InterruptedException e2) {
                ai.w("AsyncTask", "", e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            } catch (Exception | CancellationException unused) {
                a.this.b(null);
            }
        }
    };
    public volatile d iQ = d.PENDING;
    public final AtomicBoolean iR = new AtomicBoolean();
    public final AtomicBoolean iS = new AtomicBoolean();

    /* renamed from: com.freshchat.consumer.sdk.j.a.a$4  reason: invalid class name */
    public /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] iV;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.freshchat.consumer.sdk.j.a.a$d[] r0 = com.freshchat.consumer.sdk.j.a.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                iV = r0
                com.freshchat.consumer.sdk.j.a.a$d r1 = com.freshchat.consumer.sdk.j.a.a.d.RUNNING     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = iV     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.freshchat.consumer.sdk.j.a.a$d r1 = com.freshchat.consumer.sdk.j.a.a.d.FINISHED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.a.AnonymousClass4.<clinit>():void");
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.j.a.a$a  reason: collision with other inner class name */
    public static class C0026a<Data> {
        public final a iW;
        public final Data[] iX;

        public C0026a(a aVar, Data... dataArr) {
            this.iW = aVar;
            this.iX = dataArr;
        }
    }

    public static class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            C0026a aVar = (C0026a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.iW.finish(aVar.iX[0]);
            } else if (i == 2) {
                aVar.iW.onProgressUpdate(aVar.iX);
            }
        }
    }

    @TargetApi(11)
    public static class c implements Executor {
        public final ArrayDeque<Runnable> iY;
        public Runnable iZ;

        public c() {
            this.iY = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.iY.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.fe();
                    }
                }
            });
            if (this.iZ == null) {
                fe();
            }
        }

        public synchronized void fe() {
            Runnable poll = this.iY.poll();
            this.iZ = poll;
            if (poll != null) {
                a.THREAD_POOL_EXECUTOR.execute(poll);
            }
        }
    }

    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class e<Params, Result> implements Callable<Result> {
        public Params[] jg;

        public e() {
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, iK, iJ, new DiscardOldestPolicy());
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public void b(Result result) {
        if (!this.iS.get()) {
            c(result);
        }
    }

    /* access modifiers changed from: private */
    public Result c(Result result) {
        iM.obtainMessage(1, new C0026a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.iQ = d.FINISHED;
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.iQ != d.PENDING) {
            int i = AnonymousClass4.iV[this.iQ.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.iQ = d.RUNNING;
        onPreExecute();
        this.iO.jg = paramsArr;
        executor.execute(this.iP);
        return this;
    }

    public final a<Params, Progress, Result> a(Params... paramsArr) {
        return a(iN, paramsArr);
    }

    public final boolean cancel(boolean z) {
        this.iR.set(true);
        return this.iP.cancel(z);
    }

    public abstract Result doInBackground(Params... paramsArr);

    public final boolean isCancelled() {
        return this.iR.get();
    }

    public void onCancelled() {
    }

    public void onCancelled(Result result) {
        onCancelled();
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }
}
