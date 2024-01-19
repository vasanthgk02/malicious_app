package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EventLoop.common.kt */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$FU;
    public static final /* synthetic */ AtomicReferenceFieldUpdater _queue$FU;
    public volatile /* synthetic */ Object _delayed = null;
    public volatile /* synthetic */ int _isCompleted = 0;
    public volatile /* synthetic */ Object _queue = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventLoop.common.kt */
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.cont = cancellableContinuation;
        }

        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventLoop.common.kt */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        public volatile Object _heap;
        public int index = -1;
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        public int compareTo(Object obj) {
            int i = ((this.nanoTime - ((DelayedTask) obj).nanoTime) > 0 ? 1 : ((this.nanoTime - ((DelayedTask) obj).nanoTime) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != EventLoop_commonKt.DISPOSED_TASK) {
                DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                if (delayedTaskQueue != null) {
                    synchronized (delayedTaskQueue) {
                        if (getHeap() != null) {
                            delayedTaskQueue.removeAtImpl(getIndex());
                        }
                    }
                }
                this._heap = EventLoop_commonKt.DISPOSED_TASK;
            }
        }

        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public int getIndex() {
            return this.index;
        }

        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.DISPOSED_TASK) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Delayed[nanos=");
            outline73.append(this.nanoTime);
            outline73.append(']');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventLoop.common.kt */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<EventLoopImplBase> cls2 = EventLoopImplBase.class;
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            Thread thread = getThread();
            if (Thread.currentThread() != thread) {
                LockSupport.unpark(thread);
                return;
            }
            return;
        }
        DefaultExecutor.INSTANCE.enqueue(runnable);
    }

    public final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) obj);
                lockFreeTaskQueueCore2.addLast(runnable);
                if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    public boolean isEmpty() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        boolean z = true;
        if (!(arrayQueue == null || arrayQueue.head == arrayQueue.tail)) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null) {
            if (!(delayedTaskQueue._size == 0)) {
                return false;
            }
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                z = ((LockFreeTaskQueueCore) obj).isEmpty();
            } else if (obj != EventLoop_commonKt.CLOSED_EMPTY) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b1, code lost:
        if (((kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0).isEmpty() == false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b6, code lost:
        if (r0 == kotlinx.coroutines.EventLoop_commonKt.CLOSED_EMPTY) goto L_0x00db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r12 = this;
            boolean r0 = r12.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r12._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x004f
            int r6 = r0._size
            if (r6 != 0) goto L_0x0018
            r6 = 1
            goto L_0x0019
        L_0x0018:
            r6 = 0
        L_0x0019:
            if (r6 != 0) goto L_0x004f
            long r6 = java.lang.System.nanoTime()
        L_0x001f:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r8 = r0.firstImpl()     // Catch:{ all -> 0x004c }
            if (r8 != 0) goto L_0x0029
            monitor-exit(r0)
            r8 = r3
            goto L_0x0047
        L_0x0029:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r8 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r8     // Catch:{ all -> 0x004c }
            long r9 = r8.nanoTime     // Catch:{ all -> 0x004c }
            long r9 = r6 - r9
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 < 0) goto L_0x0035
            r9 = 1
            goto L_0x0036
        L_0x0035:
            r9 = 0
        L_0x0036:
            if (r9 == 0) goto L_0x003d
            boolean r8 = r12.enqueueImpl(r8)     // Catch:{ all -> 0x004c }
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            if (r8 == 0) goto L_0x0045
            kotlinx.coroutines.internal.ThreadSafeHeapNode r8 = r0.removeAtImpl(r5)     // Catch:{ all -> 0x004c }
            goto L_0x0046
        L_0x0045:
            r8 = r3
        L_0x0046:
            monitor-exit(r0)
        L_0x0047:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r8 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r8
            if (r8 != 0) goto L_0x001f
            goto L_0x004f
        L_0x004c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x004f:
            java.lang.Object r0 = r12._queue
            if (r0 != 0) goto L_0x0054
            goto L_0x0081
        L_0x0054:
            boolean r6 = r0 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r6 == 0) goto L_0x0071
            r6 = r0
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r6
            java.lang.Object r7 = r6.removeFirstOrNull()
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            if (r7 == r8) goto L_0x0067
            r3 = r7
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            goto L_0x0081
        L_0x0067:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = _queue$FU
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = r6.next()
            r7.compareAndSet(r12, r0, r6)
            goto L_0x004f
        L_0x0071:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.EventLoop_commonKt.CLOSED_EMPTY
            if (r0 != r6) goto L_0x0076
            goto L_0x0081
        L_0x0076:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = _queue$FU
            boolean r6 = r6.compareAndSet(r12, r0, r3)
            if (r6 == 0) goto L_0x004f
            r3 = r0
            java.lang.Runnable r3 = (java.lang.Runnable) r3
        L_0x0081:
            if (r3 == 0) goto L_0x0087
            r3.run()
            return r1
        L_0x0087:
            kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> r0 = r12.unconfinedQueue
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L_0x0091
            goto L_0x009b
        L_0x0091:
            int r3 = r0.head
            int r0 = r0.tail
            if (r3 != r0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r4 = 0
        L_0x0099:
            if (r4 == 0) goto L_0x009d
        L_0x009b:
            r3 = r6
            goto L_0x009e
        L_0x009d:
            r3 = r1
        L_0x009e:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x00a3
            goto L_0x00dc
        L_0x00a3:
            java.lang.Object r0 = r12._queue
            if (r0 == 0) goto L_0x00b9
            boolean r3 = r0 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r3 == 0) goto L_0x00b4
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b9
            goto L_0x00dc
        L_0x00b4:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.EventLoop_commonKt.CLOSED_EMPTY
            if (r0 != r3) goto L_0x00dc
            goto L_0x00db
        L_0x00b9:
            java.lang.Object r0 = r12._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x00db
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r3 = r0.firstImpl()     // Catch:{ all -> 0x00d8 }
            monitor-exit(r0)
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r3 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r3
            if (r3 != 0) goto L_0x00ca
            goto L_0x00db
        L_0x00ca:
            long r3 = r3.nanoTime
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            r1 = r3
            goto L_0x00dc
        L_0x00d8:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x00db:
            r1 = r6
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(long r13, kotlinx.coroutines.EventLoopImplBase.DelayedTask r15) {
        /*
            r12 = this;
            int r0 = r12._isCompleted
            r1 = 2
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0009
            goto L_0x0037
        L_0x0009:
            java.lang.Object r0 = r12._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 != 0) goto L_0x0020
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = _delayed$FU
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r5 = new kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue
            r5.<init>(r13)
            r0.compareAndSet(r12, r4, r5)
            java.lang.Object r0 = r12._delayed
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
        L_0x0020:
            monitor-enter(r15)
            java.lang.Object r5 = r15._heap     // Catch:{ all -> 0x00a7 }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.EventLoop_commonKt.DISPOSED_TASK     // Catch:{ all -> 0x00a7 }
            if (r5 != r6) goto L_0x002a
            monitor-exit(r15)
            r0 = 2
            goto L_0x0066
        L_0x002a:
            monitor-enter(r0)     // Catch:{ all -> 0x00a7 }
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.firstImpl()     // Catch:{ all -> 0x00a4 }
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch:{ all -> 0x00a4 }
            int r6 = r12._isCompleted     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0039
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r15)
        L_0x0037:
            r0 = 1
            goto L_0x0066
        L_0x0039:
            r6 = 0
            if (r5 != 0) goto L_0x0040
            r0.timeNow = r13     // Catch:{ all -> 0x00a4 }
            goto L_0x0053
        L_0x0040:
            long r8 = r5.nanoTime     // Catch:{ all -> 0x00a4 }
            long r10 = r8 - r13
            int r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0049
            r8 = r13
        L_0x0049:
            long r10 = r0.timeNow     // Catch:{ all -> 0x00a4 }
            long r10 = r8 - r10
            int r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0053
            r0.timeNow = r8     // Catch:{ all -> 0x00a4 }
        L_0x0053:
            long r8 = r15.nanoTime     // Catch:{ all -> 0x00a4 }
            long r10 = r0.timeNow     // Catch:{ all -> 0x00a4 }
            long r8 = r8 - r10
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0060
            long r5 = r0.timeNow     // Catch:{ all -> 0x00a4 }
            r15.nanoTime = r5     // Catch:{ all -> 0x00a4 }
        L_0x0060:
            r0.addImpl(r15)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r15)
            r0 = 0
        L_0x0066:
            if (r0 == 0) goto L_0x007e
            if (r0 == r3) goto L_0x007a
            if (r0 != r1) goto L_0x006d
            goto L_0x00a3
        L_0x006d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected result"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x007a:
            r12.reschedule(r13, r15)
            goto L_0x00a3
        L_0x007e:
            java.lang.Object r13 = r12._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r13 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r13
            if (r13 == 0) goto L_0x0091
            monitor-enter(r13)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r14 = r13.firstImpl()     // Catch:{ all -> 0x008e }
            monitor-exit(r13)
            r4 = r14
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r4 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r4
            goto L_0x0091
        L_0x008e:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        L_0x0091:
            if (r4 != r15) goto L_0x0094
            r2 = 1
        L_0x0094:
            if (r2 == 0) goto L_0x00a3
            java.lang.Thread r13 = r12.getThread()
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            if (r14 == r13) goto L_0x00a3
            java.util.concurrent.locks.LockSupport.unpark(r13)
        L_0x00a3:
            return
        L_0x00a4:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            throw r13     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r13 = move-exception
            monitor-exit(r15)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.schedule(long, kotlinx.coroutines.EventLoopImplBase$DelayedTask):void");
    }

    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long j2 = 0;
        if (j > 0) {
            j2 = j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j;
        }
        if (j2 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(j2 + nanoTime, cancellableContinuation);
            schedule(nanoTime, delayedResumeTask);
            cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(delayedResumeTask));
        }
    }

    public void shutdown() {
        ThreadSafeHeapNode removeAtImpl;
        ThreadLocalEventLoop threadLocalEventLoop = ThreadLocalEventLoop.INSTANCE;
        ThreadLocalEventLoop.ref.set(null);
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, EventLoop_commonKt.CLOSED_EMPTY)) {
                    break;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).close();
                break;
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                break;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    break;
                }
            }
        }
        do {
        } while (processNextEvent() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null) {
                synchronized (delayedTaskQueue) {
                    removeAtImpl = delayedTaskQueue._size > 0 ? delayedTaskQueue.removeAtImpl(0) : null;
                }
                DelayedTask delayedTask = (DelayedTask) removeAtImpl;
                if (delayedTask != null) {
                    reschedule(nanoTime, delayedTask);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
