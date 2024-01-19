package java8.util.concurrent;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java8.util.concurrent.FJPool.WorkQueue;
import org.apache.fontbox.cmap.CMapParser;
import sun.misc.Unsafe;

public abstract class FJTask<V> implements Future<V>, Serializable {
    public static final long STATUS;
    public static final Unsafe U;
    public static final ExceptionNode[] exceptionTable = new ExceptionNode[32];
    public static final ReentrantLock exceptionTableLock = new ReentrantLock();
    public static final ReferenceQueue<FJTask<?>> exceptionTableRefQueue = new ReferenceQueue<>();
    public static final long serialVersionUID = -7721805057305804111L;
    public volatile int status;

    public static final class AdaptedCallable<T> extends FJTask<T> implements RunnableFuture<T> {
        public static final long serialVersionUID = 2838392045355241008L;
        public final Callable<? extends T> callable;
        public T result;

        public AdaptedCallable(Callable<? extends T> callable2) {
            if (callable2 != null) {
                this.callable = callable2;
                return;
            }
            throw null;
        }

        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }

        public final T getRawResult() {
            return this.result;
        }

        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.callable + CMapParser.MARK_END_OF_ARRAY;
        }
    }

    public static final class AdaptedRunnable<T> extends FJTask<T> implements RunnableFuture<T> {
        public static final long serialVersionUID = 5232453952276885070L;
        public T result;
        public final Runnable runnable;

        public AdaptedRunnable(Runnable runnable2, T t) {
            if (runnable2 != null) {
                this.runnable = runnable2;
                this.result = t;
                return;
            }
            throw null;
        }

        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        public final T getRawResult() {
            return this.result;
        }

        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + CMapParser.MARK_END_OF_ARRAY;
        }
    }

    public static final class AdaptedRunnableAction extends FJTask<Void> implements RunnableFuture<Void> {
        public static final long serialVersionUID = 5232453952276885070L;
        public final Runnable runnable;

        public AdaptedRunnableAction(Runnable runnable2) {
            this.runnable = runnable2;
        }

        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        public Object getRawResult() {
            return null;
        }

        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + CMapParser.MARK_END_OF_ARRAY;
        }
    }

    public static final class ExceptionNode extends WeakReference<FJTask<?>> {
        public final Throwable ex;
        public final int hashCode;
        public ExceptionNode next;
        public final long thrower = Thread.currentThread().getId();

        public ExceptionNode(FJTask<?> fJTask, Throwable th, ExceptionNode exceptionNode, ReferenceQueue<FJTask<?>> referenceQueue) {
            super(fJTask, referenceQueue);
            this.ex = th;
            this.next = exceptionNode;
            this.hashCode = System.identityHashCode(fJTask);
        }
    }

    public static final class RunnableExecuteAction extends FJTask<Void> {
        public static final long serialVersionUID = 5232453952276885070L;
        public final Runnable runnable;

        public RunnableExecuteAction(Runnable runnable2) {
            this.runnable = runnable2;
        }

        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        public Object getRawResult() {
            return null;
        }

        public void internalPropagateException(Throwable th) {
            FJPool.rethrow(th);
            throw null;
        }
    }

    static {
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            STATUS = unsafe.objectFieldOffset(FJTask.class.getDeclaredField("status"));
        } catch (Exception e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static final void cancelIgnoringExceptions(FJTask<?> fJTask) {
        if (fJTask.status >= 0) {
            try {
                fJTask.cancel(false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void expungeStaleExceptions() {
        while (true) {
            Reference<? extends T> poll = exceptionTableRefQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof ExceptionNode) {
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int length = ((ExceptionNode) poll).hashCode & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[length];
                ExceptionNode exceptionNode2 = null;
                while (true) {
                    if (exceptionNode == null) {
                        break;
                    }
                    ExceptionNode exceptionNode3 = exceptionNode.next;
                    if (exceptionNode != poll) {
                        exceptionNode2 = exceptionNode;
                        exceptionNode = exceptionNode3;
                    } else if (exceptionNode2 == null) {
                        exceptionNodeArr[length] = exceptionNode3;
                    } else {
                        exceptionNode2.next = exceptionNode3;
                    }
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        if (readObject != null) {
            setExceptionalCompletion((Throwable) readObject);
        }
    }

    public static void rethrow(Throwable th) {
        FJPool.rethrow(th);
        throw null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object obj;
        objectOutputStream.defaultWriteObject();
        int i = this.status & -268435456;
        if (i >= -268435456) {
            obj = null;
        } else if (i == -1073741824) {
            obj = new CancellationException();
        } else {
            obj = getThrowableException();
        }
        objectOutputStream.writeObject(obj);
    }

    public boolean cancel(boolean z) {
        return (setCompletion(-1073741824) & -268435456) == -1073741824;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i, (65535 & s2) | (-65536 & i)));
        return true;
    }

    public final int doExec() {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        try {
            if (exec()) {
                return setCompletion(-268435456);
            }
            return i;
        } catch (Throwable th) {
            return setExceptionalCompletion(th);
        }
    }

    public final int doJoin() {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof FJWorkerThread)) {
            return externalAwaitDone();
        }
        FJWorkerThread fJWorkerThread = (FJWorkerThread) currentThread;
        WorkQueue workQueue = fJWorkerThread.workQueue;
        if (workQueue.tryUnpush(this)) {
            int doExec = doExec();
            if (doExec < 0) {
                return doExec;
            }
        }
        return fJWorkerThread.pool.awaitJoin(workQueue, this, 0);
    }

    public abstract boolean exec();

    public final int externalAwaitDone() {
        boolean z = false;
        int doExec = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
        if (doExec < 0) {
            return doExec;
        }
        int i = this.status;
        if (i < 0) {
            return i;
        }
        int i2 = i;
        do {
            if (U.compareAndSwapInt(this, STATUS, i2, i2 | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        try {
                            wait(0);
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    } else {
                        notifyAll();
                    }
                }
            }
            i2 = this.status;
        } while (i2 >= 0);
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i2;
    }

    public final int externalInterruptibleAwaitDone() throws InterruptedException {
        if (!Thread.interrupted()) {
            int i = this.status;
            if (i < 0) {
                return i;
            }
            int doExec = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
            if (doExec < 0) {
                return doExec;
            }
            while (true) {
                int i2 = this.status;
                if (i2 < 0) {
                    return i2;
                }
                if (U.compareAndSwapInt(this, STATUS, i2, i2 | 65536)) {
                    synchronized (this) {
                        if (this.status >= 0) {
                            wait(0);
                        } else {
                            notifyAll();
                        }
                    }
                }
            }
        } else {
            throw new InterruptedException();
        }
    }

    public final V get() throws InterruptedException, ExecutionException {
        int doJoin = (Thread.currentThread() instanceof FJWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & -268435456;
        if (doJoin == -1073741824) {
            throw new CancellationException();
        } else if (doJoin != Integer.MIN_VALUE) {
            return getRawResult();
        } else {
            throw new ExecutionException(getThrowableException());
        }
    }

    public abstract V getRawResult();

    /* JADX INFO: finally extract failed */
    public final Throwable getThrowableException() {
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            ExceptionNode exceptionNode = exceptionNodeArr[identityHashCode & (exceptionNodeArr.length - 1)];
            while (exceptionNode != null && exceptionNode.get() != this) {
                exceptionNode = exceptionNode.next;
            }
            reentrantLock.unlock();
            Constructor constructor = null;
            if (exceptionNode != null) {
                Throwable th = exceptionNode.ex;
                if (th != null) {
                    if (exceptionNode.thrower != Thread.currentThread().getId()) {
                        try {
                            for (Constructor constructor2 : th.getClass().getConstructors()) {
                                Class<Throwable>[] parameterTypes = constructor2.getParameterTypes();
                                if (parameterTypes.length == 0) {
                                    constructor = constructor2;
                                } else if (parameterTypes.length == 1 && parameterTypes[0] == Throwable.class) {
                                    return (Throwable) constructor2.newInstance(new Object[]{th});
                                }
                            }
                            if (constructor != null) {
                                Throwable th2 = (Throwable) constructor.newInstance(new Object[0]);
                                th2.initCause(th);
                                return th2;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return th;
                }
            }
            return null;
        } catch (Throwable th3) {
            reentrantLock.unlock();
            throw th3;
        }
    }

    public void internalPropagateException(Throwable th) {
    }

    public final void internalWait(long j) {
        int i = this.status;
        if (i >= 0) {
            if (U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        try {
                            wait(j);
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        notifyAll();
                    }
                }
            }
        }
    }

    public final V invoke() {
        int doExec = doExec();
        if (doExec >= 0) {
            Thread currentThread = Thread.currentThread();
            if (currentThread instanceof FJWorkerThread) {
                FJWorkerThread fJWorkerThread = (FJWorkerThread) currentThread;
                doExec = fJWorkerThread.pool.awaitJoin(fJWorkerThread.workQueue, this, 0);
            } else {
                doExec = externalAwaitDone();
            }
        }
        int i = doExec & -268435456;
        if (i != -268435456) {
            if (i == -1073741824) {
                throw new CancellationException();
            } else if (i == Integer.MIN_VALUE) {
                FJPool.rethrow(getThrowableException());
                throw null;
            }
        }
        return getRawResult();
    }

    public final boolean isCancelled() {
        return (this.status & -268435456) == -1073741824;
    }

    public final boolean isDone() {
        return this.status < 0;
    }

    public final int setCompletion(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    /* JADX INFO: finally extract failed */
    public final int setExceptionalCompletion(Throwable th) {
        int i = this.status;
        if (i >= 0) {
            int identityHashCode = System.identityHashCode(this);
            ReentrantLock reentrantLock = exceptionTableLock;
            reentrantLock.lock();
            try {
                expungeStaleExceptions();
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int length = identityHashCode & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[length];
                while (true) {
                    if (exceptionNode == null) {
                        exceptionNodeArr[length] = new ExceptionNode(this, th, exceptionNodeArr[length], exceptionTableRefQueue);
                        break;
                    } else if (exceptionNode.get() == this) {
                        break;
                    } else {
                        exceptionNode = exceptionNode.next;
                    }
                }
                reentrantLock.unlock();
                i = setCompletion(LinearLayoutManager.INVALID_OFFSET);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        if ((-268435456 & i) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return i;
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        int i;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            int i2 = this.status;
            if (i2 >= 0 && nanos > 0) {
                long nanoTime = System.nanoTime() + nanos;
                if (nanoTime == 0) {
                    nanoTime = 1;
                }
                Thread currentThread = Thread.currentThread();
                if (currentThread instanceof FJWorkerThread) {
                    FJWorkerThread fJWorkerThread = (FJWorkerThread) currentThread;
                    i2 = fJWorkerThread.pool.awaitJoin(fJWorkerThread.workQueue, this, nanoTime);
                } else {
                    i2 = FJPool.common.tryExternalUnpush(this) ? doExec() : 0;
                    if (i2 >= 0) {
                        while (true) {
                            i = this.status;
                            if (i < 0) {
                                break;
                            }
                            long nanoTime2 = nanoTime - System.nanoTime();
                            if (nanoTime2 <= 0) {
                                break;
                            }
                            long millis = TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                            if (millis > 0) {
                                if (U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
                                    synchronized (this) {
                                        if (this.status >= 0) {
                                            wait(millis);
                                        } else {
                                            notifyAll();
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        i2 = i;
                    }
                }
            }
            if (i2 >= 0) {
                i2 = this.status;
            }
            int i3 = i2 & -268435456;
            if (i3 == -268435456) {
                return getRawResult();
            }
            if (i3 == -1073741824) {
                throw new CancellationException();
            } else if (i3 != Integer.MIN_VALUE) {
                throw new TimeoutException();
            } else {
                throw new ExecutionException(getThrowableException());
            }
        } else {
            throw new InterruptedException();
        }
    }
}
