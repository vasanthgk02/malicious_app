package java8.util.concurrent;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.login.LoginReactModule;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java8.util.concurrent.FJPool.ManagedBlocker;
import java8.util.function.Function;
import java8.util.function.Supplier;
import org.apache.fontbox.cmap.CMapParser;
import sun.misc.Unsafe;

public class CompletableFuture<T> implements Future<T> {
    public static final Executor ASYNC_POOL;
    public static final long NEXT;
    public static final AltResult NIL = new AltResult(null);
    public static final long RESULT;
    public static final long STACK;
    public static final Unsafe U;
    public static final boolean USE_COMMON_POOL;
    public volatile Object result;
    public volatile Completion stack;

    public static final class AltResult {
        public final Throwable ex;

        public AltResult(Throwable th) {
            this.ex = th;
        }
    }

    public static final class AsyncRun extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        public CompletableFuture<Void> dep;
        public Runnable fn;

        public AsyncRun(CompletableFuture<Void> completableFuture, Runnable runnable) {
            this.dep = completableFuture;
            this.fn = runnable;
        }

        public final boolean exec() {
            run();
            return false;
        }

        public Object getRawResult() {
            return null;
        }

        public void run() {
            CompletableFuture<Void> completableFuture = this.dep;
            if (completableFuture != null) {
                Runnable runnable = this.fn;
                if (runnable != null) {
                    this.dep = null;
                    this.fn = null;
                    if (completableFuture.result == null) {
                        try {
                            runnable.run();
                            completableFuture.completeNull();
                        } catch (Throwable th) {
                            completableFuture.completeThrowable(th);
                        }
                    }
                    completableFuture.postComplete();
                }
            }
        }
    }

    public static final class AsyncSupply<T> extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        public CompletableFuture<T> dep;
        public Supplier<? extends T> fn;

        public AsyncSupply(CompletableFuture<T> completableFuture, Supplier<? extends T> supplier) {
            this.dep = completableFuture;
            this.fn = supplier;
        }

        public final boolean exec() {
            run();
            return false;
        }

        public Object getRawResult() {
            return null;
        }

        public void run() {
            CompletableFuture<T> completableFuture = this.dep;
            if (completableFuture != null) {
                Supplier<? extends T> supplier = this.fn;
                if (supplier != null) {
                    this.dep = null;
                    this.fn = null;
                    if (completableFuture.result == null) {
                        try {
                            completableFuture.completeValue(supplier.get());
                        } catch (Throwable th) {
                            completableFuture.completeThrowable(th);
                        }
                    }
                    completableFuture.postComplete();
                }
            }
        }
    }

    public interface AsynchronousCompletionTask {
    }

    public static abstract class BiCompletion<T, U, V> extends UniCompletion<T, V> {
        public CompletableFuture<U> snd;

        public BiCompletion(Executor executor, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3) {
            super(null, completableFuture, completableFuture2);
            this.snd = completableFuture3;
        }
    }

    public static final class BiRelay<T, U> extends BiCompletion<T, U, Void> {
        public BiRelay(CompletableFuture<Void> completableFuture, CompletableFuture<T> completableFuture2, CompletableFuture<U> completableFuture3) {
            super(null, completableFuture, completableFuture2, completableFuture3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r6 == null) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java8.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r8) {
            /*
                r7 = this;
                java8.util.concurrent.CompletableFuture<T> r0 = r7.src
                r1 = 0
                if (r0 == 0) goto L_0x0059
                java.lang.Object r2 = r0.result
                if (r2 == 0) goto L_0x0059
                java8.util.concurrent.CompletableFuture<U> r3 = r7.snd
                if (r3 == 0) goto L_0x0059
                java.lang.Object r4 = r3.result
                if (r4 == 0) goto L_0x0059
                java8.util.concurrent.CompletableFuture<V> r5 = r7.dep
                if (r5 != 0) goto L_0x0016
                goto L_0x0059
            L_0x0016:
                java.lang.Object r6 = r5.result
                if (r6 != 0) goto L_0x0038
                boolean r6 = r2 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r6 == 0) goto L_0x0025
                r6 = r2
                java8.util.concurrent.CompletableFuture$AltResult r6 = (java8.util.concurrent.CompletableFuture.AltResult) r6
                java.lang.Throwable r6 = r6.ex
                if (r6 != 0) goto L_0x0031
            L_0x0025:
                boolean r2 = r4 instanceof java8.util.concurrent.CompletableFuture.AltResult
                if (r2 == 0) goto L_0x0035
                r2 = r4
                java8.util.concurrent.CompletableFuture$AltResult r2 = (java8.util.concurrent.CompletableFuture.AltResult) r2
                java.lang.Throwable r6 = r2.ex
                if (r6 == 0) goto L_0x0035
                r2 = r4
            L_0x0031:
                r5.completeThrowable(r6, r2)
                goto L_0x0038
            L_0x0035:
                r5.completeNull()
            L_0x0038:
                r7.src = r1
                r7.snd = r1
                r7.dep = r1
                java8.util.concurrent.CompletableFuture$Completion r1 = r3.stack
                if (r1 == 0) goto L_0x0054
                java.lang.Object r1 = r3.result
                if (r1 != 0) goto L_0x0049
                r3.cleanStack()
            L_0x0049:
                if (r8 < 0) goto L_0x0054
                if (r1 != 0) goto L_0x0051
                java.lang.Object r1 = r3.result
                if (r1 == 0) goto L_0x0054
            L_0x0051:
                r3.postComplete()
            L_0x0054:
                java8.util.concurrent.CompletableFuture r8 = r5.postFire(r0, r8)
                return r8
            L_0x0059:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.BiRelay.tryFire(int):java8.util.concurrent.CompletableFuture");
        }
    }

    public static final class CoCompletion extends Completion {
        public BiCompletion<?, ?, ?> base;

        public CoCompletion(BiCompletion<?, ?, ?> biCompletion) {
            this.base = biCompletion;
        }

        public final boolean isLive() {
            BiCompletion<?, ?, ?> biCompletion = this.base;
            return (biCompletion == null || biCompletion.dep == null) ? false : true;
        }

        public final CompletableFuture<?> tryFire(int i) {
            BiCompletion<?, ?, ?> biCompletion = this.base;
            if (biCompletion != null) {
                CompletableFuture<?> tryFire = biCompletion.tryFire(i);
                if (tryFire != null) {
                    this.base = null;
                    return tryFire;
                }
            }
            return null;
        }
    }

    public static abstract class Completion extends FJTask<Void> implements Runnable, AsynchronousCompletionTask {
        public volatile Completion next;

        public final boolean exec() {
            tryFire(1);
            return false;
        }

        public Object getRawResult() {
            return null;
        }

        public abstract boolean isLive();

        public final void run() {
            tryFire(1);
        }

        public abstract CompletableFuture<?> tryFire(int i);
    }

    public static final class Signaller extends Completion implements ManagedBlocker {
        public final long deadline;
        public boolean interrupted;
        public final boolean interruptible;
        public long nanos;
        public volatile Thread thread = Thread.currentThread();

        public Signaller(boolean z, long j, long j2) {
            this.interruptible = z;
            this.nanos = j;
            this.deadline = j2;
        }

        public boolean block() {
            while (!isReleasable()) {
                if (this.deadline == 0) {
                    LockSupport.park(this);
                } else {
                    LockSupport.parkNanos(this, this.nanos);
                }
            }
            return true;
        }

        public final boolean isLive() {
            return this.thread != null;
        }

        public boolean isReleasable() {
            if (Thread.interrupted()) {
                this.interrupted = true;
            }
            if (this.interrupted && this.interruptible) {
                return true;
            }
            long j = this.deadline;
            if (j != 0) {
                if (this.nanos <= 0) {
                    return true;
                }
                long nanoTime = j - System.nanoTime();
                this.nanos = nanoTime;
                if (nanoTime <= 0) {
                    return true;
                }
            }
            if (this.thread == null) {
                return true;
            }
            return false;
        }

        public final CompletableFuture<?> tryFire(int i) {
            Thread thread2 = this.thread;
            if (thread2 != null) {
                this.thread = null;
                LockSupport.unpark(thread2);
            }
            return null;
        }
    }

    public static final class ThreadPerTaskExecutor implements Executor {
        public void execute(Runnable runnable) {
            if (runnable != null) {
                new Thread(runnable).start();
                return;
            }
            throw null;
        }
    }

    public static abstract class UniCompletion<T, V> extends Completion {
        public CompletableFuture<V> dep;
        public Executor executor;
        public CompletableFuture<T> src;

        public UniCompletion(Executor executor2, CompletableFuture<V> completableFuture, CompletableFuture<T> completableFuture2) {
            this.executor = executor2;
            this.dep = completableFuture;
            this.src = completableFuture2;
        }

        public final boolean isLive() {
            return this.dep != null;
        }
    }

    public static final class UniExceptionally<T> extends UniCompletion<T, T> {
        public Function<? super Throwable, ? extends T> fn;

        public UniExceptionally(Executor executor, CompletableFuture<T> completableFuture, CompletableFuture<T> completableFuture2, Function<? super Throwable, ? extends T> function) {
            super(executor, completableFuture, completableFuture2);
            this.fn = function;
        }

        public final CompletableFuture<T> tryFire(int i) {
            CompletableFuture<T> completableFuture = this.src;
            if (completableFuture != null) {
                Object obj = completableFuture.result;
                if (obj != null) {
                    CompletableFuture<V> completableFuture2 = this.dep;
                    if (completableFuture2 != null) {
                        Function<? super Throwable, ? extends T> function = this.fn;
                        if (function != null) {
                            if (completableFuture2.uniExceptionally(obj, function, i > 0 ? null : this)) {
                                this.src = null;
                                this.dep = null;
                                this.fn = null;
                                return completableFuture2.postFire(completableFuture, i);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    static {
        Executor executor;
        boolean z = true;
        if (FJPool.COMMON_PARALLELISM <= 1) {
            z = false;
        }
        USE_COMMON_POOL = z;
        if (z) {
            executor = FJPool.common;
        } else {
            executor = new ThreadPerTaskExecutor();
        }
        ASYNC_POOL = executor;
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            RESULT = unsafe.objectFieldOffset(CompletableFuture.class.getDeclaredField(LoginReactModule.RESULT));
            STACK = U.objectFieldOffset(CompletableFuture.class.getDeclaredField("stack"));
            NEXT = U.objectFieldOffset(Completion.class.getDeclaredField("next"));
            Class<LockSupport> cls = LockSupport.class;
        } catch (Exception e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r3 == null) goto L_0x0041;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java8.util.concurrent.CompletableFuture<?>[], code=java8.util.concurrent.CompletableFuture[], for r3v0, types: [java8.util.concurrent.CompletableFuture[], java8.util.concurrent.CompletableFuture<?>[]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java8.util.concurrent.CompletableFuture<java.lang.Void> andTree(java8.util.concurrent.CompletableFuture[] r3, int r4, int r5) {
        /*
            java8.util.concurrent.CompletableFuture r0 = new java8.util.concurrent.CompletableFuture
            r0.<init>()
            if (r4 <= r5) goto L_0x000d
            java8.util.concurrent.CompletableFuture$AltResult r3 = NIL
            r0.result = r3
            goto L_0x0081
        L_0x000d:
            int r1 = r4 + r5
            int r1 = r1 >>> 1
            if (r4 != r1) goto L_0x0016
            r2 = r3[r4]
            goto L_0x001a
        L_0x0016:
            java8.util.concurrent.CompletableFuture r2 = andTree(r3, r4, r1)
        L_0x001a:
            if (r2 == 0) goto L_0x0082
            if (r4 != r5) goto L_0x0020
            r3 = r2
            goto L_0x002b
        L_0x0020:
            int r1 = r1 + 1
            if (r5 != r1) goto L_0x0027
            r3 = r3[r5]
            goto L_0x002b
        L_0x0027:
            java8.util.concurrent.CompletableFuture r3 = andTree(r3, r1, r5)
        L_0x002b:
            if (r3 == 0) goto L_0x0082
            java.lang.Object r4 = r2.result
            if (r4 == 0) goto L_0x0059
            java.lang.Object r5 = r3.result
            if (r5 != 0) goto L_0x0036
            goto L_0x0059
        L_0x0036:
            boolean r3 = r4 instanceof java8.util.concurrent.CompletableFuture.AltResult
            if (r3 == 0) goto L_0x0041
            r3 = r4
            java8.util.concurrent.CompletableFuture$AltResult r3 = (java8.util.concurrent.CompletableFuture.AltResult) r3
            java.lang.Throwable r3 = r3.ex
            if (r3 != 0) goto L_0x004d
        L_0x0041:
            boolean r3 = r5 instanceof java8.util.concurrent.CompletableFuture.AltResult
            if (r3 == 0) goto L_0x0054
            r3 = r5
            java8.util.concurrent.CompletableFuture$AltResult r3 = (java8.util.concurrent.CompletableFuture.AltResult) r3
            java.lang.Throwable r3 = r3.ex
            if (r3 == 0) goto L_0x0054
            r4 = r5
        L_0x004d:
            java.lang.Object r3 = encodeThrowable(r3, r4)
            r0.result = r3
            goto L_0x0081
        L_0x0054:
            java8.util.concurrent.CompletableFuture$AltResult r3 = NIL
            r0.result = r3
            goto L_0x0081
        L_0x0059:
            java8.util.concurrent.CompletableFuture$BiRelay r4 = new java8.util.concurrent.CompletableFuture$BiRelay
            r4.<init>(r0, r2, r3)
        L_0x005e:
            java.lang.Object r5 = r2.result
            if (r5 != 0) goto L_0x007e
            boolean r5 = r2.tryPushStack(r4)
            if (r5 == 0) goto L_0x005e
            java.lang.Object r5 = r3.result
            if (r5 != 0) goto L_0x0075
            java8.util.concurrent.CompletableFuture$CoCompletion r5 = new java8.util.concurrent.CompletableFuture$CoCompletion
            r5.<init>(r4)
            r3.unipush(r5)
            goto L_0x0081
        L_0x0075:
            java.lang.Object r3 = r2.result
            if (r3 == 0) goto L_0x0081
            r3 = 0
            r4.tryFire(r3)
            goto L_0x0081
        L_0x007e:
            r3.unipush(r4)
        L_0x0081:
            return r0
        L_0x0082:
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.andTree(java8.util.concurrent.CompletableFuture[], int, int):java8.util.concurrent.CompletableFuture");
    }

    public static boolean casNext(Completion completion, Completion completion2, Completion completion3) {
        return U.compareAndSwapObject(completion, NEXT, completion2, completion3);
    }

    public static Object encodeThrowable(Throwable th, Object obj) {
        if (!(th instanceof CompletionException)) {
            th = new CompletionException(th);
        } else if ((obj instanceof AltResult) && th == ((AltResult) obj).ex) {
            return obj;
        }
        return new AltResult(th);
    }

    public static void lazySetNext(Completion completion, Completion completion2) {
        U.putOrderedObject(completion, NEXT, completion2);
    }

    public static Object reportGet(Object obj) throws InterruptedException, ExecutionException {
        if (obj == null) {
            throw new InterruptedException();
        } else if (!(obj instanceof AltResult)) {
            return obj;
        } else {
            Throwable th = ((AltResult) obj).ex;
            if (th == null) {
                return null;
            }
            if (!(th instanceof CancellationException)) {
                if (th instanceof CompletionException) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                }
                throw new ExecutionException(th);
            }
            throw ((CancellationException) th);
        }
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor) {
        if (!USE_COMMON_POOL && executor == FJPool.common) {
            executor = ASYNC_POOL;
        } else if (executor == null) {
            throw null;
        }
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncRun(completableFuture, runnable));
        return completableFuture;
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor) {
        if (!USE_COMMON_POOL && executor == FJPool.common) {
            executor = ASYNC_POOL;
        } else if (executor == null) {
            throw null;
        }
        CompletableFuture<U> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncSupply(completableFuture, supplier));
        return completableFuture;
    }

    public boolean cancel(boolean z) {
        boolean z2 = this.result == null && internalComplete(new AltResult(new CancellationException()));
        postComplete();
        if (z2 || isCancelled()) {
            return true;
        }
        return false;
    }

    public final boolean casStack(Completion completion, Completion completion2) {
        return U.compareAndSwapObject(this, STACK, completion, completion2);
    }

    public final void cleanStack() {
        Completion completion;
        boolean z = false;
        while (true) {
            completion = this.stack;
            if (completion != null && !completion.isLive()) {
                z = casStack(completion, completion.next);
            } else if (completion != null && !z) {
                Completion completion2 = completion;
                Completion completion3 = completion.next;
                Completion completion4 = completion2;
                while (completion3 != null) {
                    Completion completion5 = completion3.next;
                    if (completion3.isLive()) {
                        completion4 = completion3;
                        completion3 = completion5;
                    } else {
                        casNext(completion4, completion3, completion5);
                        return;
                    }
                }
                return;
            }
        }
        if (completion != null) {
        }
    }

    public final boolean completeNull() {
        return U.compareAndSwapObject(this, RESULT, null, NIL);
    }

    public final boolean completeThrowable(Throwable th) {
        Unsafe unsafe = U;
        long j = RESULT;
        if (!(th instanceof CompletionException)) {
            th = new CompletionException(th);
        }
        return unsafe.compareAndSwapObject(this, j, null, new AltResult(th));
    }

    public final boolean completeValue(T t) {
        Unsafe unsafe = U;
        long j = RESULT;
        if (t == null) {
            t = NIL;
        }
        return unsafe.compareAndSwapObject(this, j, null, t);
    }

    public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> function) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniExceptionally(null, completableFuture, this, function));
        } else {
            completableFuture.uniExceptionally(obj, function, null);
        }
        return completableFuture;
    }

    public T get() throws InterruptedException, ExecutionException {
        Object obj = this.result;
        if (obj == null) {
            obj = waitingGet(true);
        }
        return reportGet(obj);
    }

    public final boolean internalComplete(Object obj) {
        return U.compareAndSwapObject(this, RESULT, null, obj);
    }

    public boolean isCancelled() {
        Object obj = this.result;
        return (obj instanceof AltResult) && (((AltResult) obj).ex instanceof CancellationException);
    }

    public boolean isDone() {
        return this.result != null;
    }

    public T join() {
        T t = this.result;
        if (t == null) {
            t = waitingGet(false);
        }
        if (!(t instanceof AltResult)) {
            return t;
        }
        Throwable th = ((AltResult) t).ex;
        if (th == null) {
            return null;
        }
        if (th instanceof CancellationException) {
            throw ((CancellationException) th);
        } else if (th instanceof CompletionException) {
            throw ((CompletionException) th);
        } else {
            throw new CompletionException(th);
        }
    }

    public final void postComplete() {
        while (true) {
            CompletableFuture completableFuture = this;
            while (true) {
                Completion completion = completableFuture.stack;
                if (completion == null) {
                    if (completableFuture != this) {
                        completion = this.stack;
                        if (completion != null) {
                            completableFuture = this;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                Completion completion2 = completion.next;
                if (completableFuture.casStack(completion, completion2)) {
                    if (completion2 != null) {
                        if (completableFuture != this) {
                            do {
                            } while (!tryPushStack(completion));
                        } else {
                            casNext(completion, completion2, null);
                        }
                    }
                    completableFuture = completion.tryFire(-1);
                    if (completableFuture == null) {
                    }
                }
            }
        }
    }

    public final CompletableFuture<T> postFire(CompletableFuture<?> completableFuture, int i) {
        if (!(completableFuture == null || completableFuture.stack == null)) {
            Object obj = completableFuture.result;
            if (obj == null) {
                completableFuture.cleanStack();
            }
            if (i >= 0 && !(obj == null && completableFuture.result == null)) {
                completableFuture.postComplete();
            }
        }
        if (!(this.result == null || this.stack == null)) {
            if (i < 0) {
                return this;
            }
            postComplete();
        }
        return null;
    }

    public String toString() {
        String str;
        Object obj = this.result;
        int i = 0;
        for (Completion completion = this.stack; completion != null; completion = completion.next) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (obj == null) {
            str = i == 0 ? "[Not completed]" : GeneratedOutlineSupport.outline42("[Not completed, ", i, " dependents]");
        } else {
            if (obj instanceof AltResult) {
                AltResult altResult = (AltResult) obj;
                if (altResult.ex != null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Completed exceptionally: ");
                    outline73.append(altResult.ex);
                    outline73.append(CMapParser.MARK_END_OF_ARRAY);
                    str = outline73.toString();
                }
            }
            str = "[Completed normally]";
        }
        sb.append(str);
        return sb.toString();
    }

    public final boolean tryPushStack(Completion completion) {
        Completion completion2 = this.stack;
        lazySetNext(completion, completion2);
        return U.compareAndSwapObject(this, STACK, completion2, completion);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[Catch:{ all -> 0x0035 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean uniExceptionally(java.lang.Object r5, java8.util.function.Function<? super java.lang.Throwable, ? extends T> r6, java8.util.concurrent.CompletableFuture.UniExceptionally<T> r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.result
            r1 = 1
            if (r0 != 0) goto L_0x0039
            if (r7 == 0) goto L_0x001e
            java.util.concurrent.Executor r0 = r7.executor     // Catch:{ all -> 0x0035 }
            r2 = 0
            boolean r3 = r7.compareAndSetForkJoinTaskTag(r2, r1)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x001a
            if (r0 != 0) goto L_0x0014
            r7 = 1
            goto L_0x001b
        L_0x0014:
            r3 = 0
            r7.executor = r3     // Catch:{ all -> 0x0035 }
            r0.execute(r7)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            r7 = 0
        L_0x001b:
            if (r7 != 0) goto L_0x001e
            return r2
        L_0x001e:
            boolean r7 = r5 instanceof java8.util.concurrent.CompletableFuture.AltResult     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x0031
            r7 = r5
            java8.util.concurrent.CompletableFuture$AltResult r7 = (java8.util.concurrent.CompletableFuture.AltResult) r7     // Catch:{ all -> 0x0035 }
            java.lang.Throwable r7 = r7.ex     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x0031
            java.lang.Object r5 = r6.apply(r7)     // Catch:{ all -> 0x0035 }
            r4.completeValue(r5)     // Catch:{ all -> 0x0035 }
            goto L_0x0039
        L_0x0031:
            r4.internalComplete(r5)     // Catch:{ all -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r5 = move-exception
            r4.completeThrowable(r5)
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.uniExceptionally(java.lang.Object, java8.util.function.Function, java8.util.concurrent.CompletableFuture$UniExceptionally):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void unipush(java8.util.concurrent.CompletableFuture.Completion r2) {
        /*
            r1 = this;
        L_0x0000:
            boolean r0 = r1.tryPushStack(r2)
            if (r0 != 0) goto L_0x000e
            java.lang.Object r0 = r1.result
            if (r0 == 0) goto L_0x0000
            r0 = 0
            lazySetNext(r2, r0)
        L_0x000e:
            java.lang.Object r0 = r1.result
            if (r0 == 0) goto L_0x0016
            r0 = 0
            r2.tryFire(r0)
        L_0x0016:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.CompletableFuture.unipush(java8.util.concurrent.CompletableFuture$Completion):void");
    }

    public final Object waitingGet(boolean z) {
        if (z && Thread.interrupted()) {
            return null;
        }
        boolean z2 = false;
        Signaller signaller = null;
        while (true) {
            Object obj = this.result;
            if (obj != null) {
                if (signaller != null) {
                    signaller.thread = null;
                    if (signaller.interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
                postComplete();
                return obj;
            } else if (signaller == null) {
                signaller = new Signaller(z, 0, 0);
                if (Thread.currentThread() instanceof FJWorkerThread) {
                    FJPool.helpAsyncBlocker(ASYNC_POOL, signaller);
                }
            } else if (!z2) {
                z2 = tryPushStack(signaller);
            } else if (!z || !signaller.interrupted) {
                try {
                    FJPool.managedBlock(signaller);
                } catch (InterruptedException unused) {
                    signaller.interrupted = true;
                }
            } else {
                signaller.thread = null;
                cleanStack();
                return null;
            }
        }
    }

    public final boolean completeThrowable(Throwable th, Object obj) {
        return U.compareAndSwapObject(this, RESULT, null, encodeThrowable(th, obj));
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        boolean interrupted;
        Object obj;
        Object obj2;
        long nanos = timeUnit.toNanos(j);
        Object obj3 = this.result;
        if (obj3 == null) {
            long nanoTime = System.nanoTime() + nanos;
            long j2 = 0;
            if (nanoTime == 0) {
                nanoTime = 1;
            }
            boolean z = false;
            Signaller signaller = null;
            Object obj4 = null;
            boolean z2 = false;
            while (true) {
                if (z) {
                    break;
                }
                interrupted = Thread.interrupted();
                if (interrupted) {
                    break;
                }
                obj = this.result;
                if (obj == null && nanos > j2) {
                    if (signaller == null) {
                        obj2 = obj;
                        Signaller signaller2 = r7;
                        Signaller signaller3 = new Signaller(true, nanos, nanoTime);
                        if (Thread.currentThread() instanceof FJWorkerThread) {
                            FJPool.helpAsyncBlocker(ASYNC_POOL, signaller2);
                        }
                        signaller = signaller2;
                    } else {
                        obj2 = obj;
                        if (!z2) {
                            z2 = tryPushStack(signaller);
                        } else {
                            try {
                                FJPool.managedBlock(signaller);
                                boolean z3 = signaller.interrupted;
                                nanos = signaller.nanos;
                                z = z3;
                            } catch (InterruptedException unused) {
                                z = true;
                            }
                            obj4 = obj2;
                            j2 = 0;
                        }
                    }
                    z = interrupted;
                    obj4 = obj2;
                    j2 = 0;
                }
            }
            obj4 = obj;
            z = interrupted;
            if (signaller != null) {
                signaller.thread = null;
                if (obj4 == null) {
                    cleanStack();
                }
            }
            if (obj4 != null) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                postComplete();
                obj3 = obj4;
            } else if (z) {
                obj3 = null;
            } else {
                throw new TimeoutException();
            }
        }
        return reportGet(obj3);
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        Executor executor = ASYNC_POOL;
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncRun(completableFuture, runnable));
        return completableFuture;
    }
}
