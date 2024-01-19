package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\b¢\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\b¢\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\b¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\b¢\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\b¢\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JR\u0015\u0010\u0010\u001a\u00020\u00018Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010LR\u0015\u0010\u001f\u001a\u00020\u00018Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0014\u0010O\u001a\u00020N8\u0006X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020N8\u0006X\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0011\u0010S\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0014\u0010\u0003\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010TR\u001e\u0010V\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000U8\u0006X\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineScheduler.kt */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    public static final /* synthetic */ AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public volatile /* synthetic */ int _isTerminated;
    public volatile /* synthetic */ long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    public volatile /* synthetic */ long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0004\u0018\u00002\u00020GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0014\u00100\u001a\u00020/8\u0006X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010+R\u0012\u0010B\u001a\u00020?8Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u00106¨\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public final class Worker extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        public volatile int indexInArray;
        public final WorkQueue localQueue = new WorkQueue();
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        public volatile Object nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
        public int rngState = Random.Default.nextInt();
        public WorkerState state = WorkerState.DORMANT;
        public long terminationDeadline;
        public volatile /* synthetic */ int workerCtl = 0;

        public Worker(int i) {
            setDaemon(true);
            setIndexInArray(i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
            if (r11 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
            if (r11 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
            if (r11 != null) goto L_0x006d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlinx.coroutines.scheduling.Task findTask(boolean r11) {
            /*
                r10 = this;
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = r10.state
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x0009
                goto L_0x0032
            L_0x0009:
                kotlinx.coroutines.scheduling.CoroutineScheduler r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
            L_0x000b:
                long r6 = r0.controlState
                r4 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
                long r4 = r4 & r6
                r1 = 42
                long r4 = r4 >> r1
                int r1 = (int) r4
                if (r1 != 0) goto L_0x001b
                r0 = 0
                goto L_0x002c
            L_0x001b:
                r4 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
                long r8 = r6 - r4
                java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.scheduling.CoroutineScheduler.controlState$FU
                r5 = r0
                boolean r1 = r4.compareAndSet(r5, r6, r8)
                if (r1 == 0) goto L_0x000b
                r0 = 1
            L_0x002c:
                if (r0 == 0) goto L_0x0034
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED
                r10.state = r0
            L_0x0032:
                r0 = 1
                goto L_0x0035
            L_0x0034:
                r0 = 0
            L_0x0035:
                if (r0 == 0) goto L_0x006e
                if (r11 == 0) goto L_0x0062
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                int r11 = r11.corePoolSize
                int r11 = r11 * 2
                int r11 = r10.nextInt(r11)
                if (r11 != 0) goto L_0x0046
                goto L_0x0047
            L_0x0046:
                r2 = 0
            L_0x0047:
                if (r2 == 0) goto L_0x0050
                kotlinx.coroutines.scheduling.Task r11 = r10.pollGlobalQueues()
                if (r11 == 0) goto L_0x0050
                goto L_0x006d
            L_0x0050:
                kotlinx.coroutines.scheduling.WorkQueue r11 = r10.localQueue
                kotlinx.coroutines.scheduling.Task r11 = r11.poll()
                if (r11 == 0) goto L_0x0059
                goto L_0x006d
            L_0x0059:
                if (r2 != 0) goto L_0x0069
                kotlinx.coroutines.scheduling.Task r11 = r10.pollGlobalQueues()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0062:
                kotlinx.coroutines.scheduling.Task r11 = r10.pollGlobalQueues()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0069:
                kotlinx.coroutines.scheduling.Task r11 = r10.trySteal(r3)
            L_0x006d:
                return r11
            L_0x006e:
                if (r11 == 0) goto L_0x0083
                kotlinx.coroutines.scheduling.WorkQueue r11 = r10.localQueue
                kotlinx.coroutines.scheduling.Task r11 = r11.poll()
                if (r11 != 0) goto L_0x008d
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                kotlinx.coroutines.scheduling.GlobalQueue r11 = r11.globalBlockingQueue
                java.lang.Object r11 = r11.removeFirstOrNull()
                kotlinx.coroutines.scheduling.Task r11 = (kotlinx.coroutines.scheduling.Task) r11
                goto L_0x008d
            L_0x0083:
                kotlinx.coroutines.scheduling.CoroutineScheduler r11 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                kotlinx.coroutines.scheduling.GlobalQueue r11 = r11.globalBlockingQueue
                java.lang.Object r11 = r11.removeFirstOrNull()
                kotlinx.coroutines.scheduling.Task r11 = (kotlinx.coroutines.scheduling.Task) r11
            L_0x008d:
                if (r11 != 0) goto L_0x0093
                kotlinx.coroutines.scheduling.Task r11 = r10.trySteal(r2)
            L_0x0093:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.findTask(boolean):kotlinx.coroutines.scheduling.Task");
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        public void run() {
            loop0:
            while (true) {
                boolean z = false;
                while (CoroutineScheduler.this._isTerminated == 0 && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    long j = -2097152;
                    if (findTask == null) {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) || this.workerCtl != -1 || CoroutineScheduler.this._isTerminated != 0 || this.state == WorkerState.TERMINATED) {
                                        break;
                                    }
                                    tryReleaseCpu(WorkerState.PARKING);
                                    Thread.interrupted();
                                    if (this.terminationDeadline == 0) {
                                        this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.terminationDeadline >= 0) {
                                        this.terminationDeadline = 0;
                                        CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                                        synchronized (coroutineScheduler.workers) {
                                            if (coroutineScheduler._isTerminated == 0) {
                                                if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.corePoolSize) {
                                                    if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        setIndexInArray(0);
                                                        coroutineScheduler.parkedWorkersStackTopUpdate(this, i, 0);
                                                        int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(coroutineScheduler) & 2097151);
                                                        if (andDecrement != i) {
                                                            Object obj = coroutineScheduler.workers.get(andDecrement);
                                                            Intrinsics.checkNotNull(obj);
                                                            Worker worker = (Worker) obj;
                                                            coroutineScheduler.workers.setSynchronized(i, worker);
                                                            worker.setIndexInArray(i);
                                                            coroutineScheduler.parkedWorkersStackTopUpdate(worker, andDecrement, i);
                                                        }
                                                        coroutineScheduler.workers.setSynchronized(andDecrement, null);
                                                        this.state = WorkerState.TERMINATED;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                if (coroutineScheduler2 == null) {
                                    throw null;
                                } else if (this.nextParkedWorker == CoroutineScheduler.NOT_IN_STACK) {
                                    while (true) {
                                        long j2 = coroutineScheduler2.parkedWorkersStack;
                                        long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & j;
                                        int i2 = this.indexInArray;
                                        this.nextParkedWorker = coroutineScheduler2.workers.get((int) (j2 & 2097151));
                                        if (CoroutineScheduler.parkedWorkersStack$FU.compareAndSet(coroutineScheduler2, j2, ((long) i2) | j3)) {
                                            break;
                                        }
                                        j = -2097152;
                                    }
                                }
                            }
                        } else if (!z) {
                            z = true;
                        } else {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0;
                        }
                    } else {
                        this.minDelayUntilStealableTaskNs = 0;
                        int taskMode = findTask.taskContext.getTaskMode();
                        this.terminationDeadline = 0;
                        if (this.state == WorkerState.PARKING) {
                            this.state = WorkerState.BLOCKING;
                        }
                        if (taskMode != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                            CoroutineScheduler.this.signalCpuWork();
                        }
                        CoroutineScheduler.this.runSafely(findTask);
                        if (taskMode != 0) {
                            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152);
                            if (this.state != WorkerState.TERMINATED) {
                                this.state = WorkerState.DORMANT;
                            }
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
            r5 = r5.tryStealLastScheduled(r6, true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlinx.coroutines.scheduling.Task trySteal(boolean r17) {
            /*
                r16 = this;
                r0 = r16
                kotlinx.coroutines.scheduling.CoroutineScheduler r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                long r1 = r1.controlState
                r3 = 2097151(0x1fffff, double:1.0361303E-317)
                long r1 = r1 & r3
                int r2 = (int) r1
                r1 = 2
                r3 = 0
                if (r2 >= r1) goto L_0x0010
                return r3
            L_0x0010:
                int r1 = r0.nextInt(r2)
                kotlinx.coroutines.scheduling.CoroutineScheduler r4 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                r8 = 0
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x001c:
                if (r8 >= r2) goto L_0x00b0
                r13 = 1
                int r1 = r1 + r13
                if (r1 <= r2) goto L_0x0023
                r1 = 1
            L_0x0023:
                kotlinx.coroutines.internal.ResizableAtomicArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r14 = r4.workers
                java.lang.Object r14 = r14.get(r1)
                kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r14 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r14
                if (r14 == 0) goto L_0x00aa
                if (r14 == r0) goto L_0x00aa
                if (r17 == 0) goto L_0x0078
                kotlinx.coroutines.scheduling.WorkQueue r5 = r0.localQueue
                kotlinx.coroutines.scheduling.WorkQueue r6 = r14.localQueue
                if (r5 == 0) goto L_0x0077
                int r14 = r6.consumerIndex
                int r11 = r6.producerIndex
                java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.Task> r12 = r6.buffer
            L_0x003d:
                if (r14 == r11) goto L_0x0071
                r15 = r14 & 127(0x7f, float:1.78E-43)
                int r7 = r6.blockingTasksInBuffer
                if (r7 == 0) goto L_0x0071
                java.lang.Object r7 = r12.get(r15)
                kotlinx.coroutines.scheduling.Task r7 = (kotlinx.coroutines.scheduling.Task) r7
                if (r7 == 0) goto L_0x006d
                kotlinx.coroutines.scheduling.TaskContext r3 = r7.taskContext
                int r3 = r3.getTaskMode()
                if (r3 != r13) goto L_0x0057
                r3 = 1
                goto L_0x0058
            L_0x0057:
                r3 = 0
            L_0x0058:
                if (r3 == 0) goto L_0x006d
                r3 = 0
                boolean r15 = r12.compareAndSet(r15, r7, r3)
                if (r15 == 0) goto L_0x006d
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = kotlinx.coroutines.scheduling.WorkQueue.blockingTasksInBuffer$FU
                r3.decrementAndGet(r6)
                r3 = 0
                r5.add(r7, r3)
                r5 = -1
                goto L_0x0075
            L_0x006d:
                int r14 = r14 + 1
                r3 = 0
                goto L_0x003d
            L_0x0071:
                long r5 = r5.tryStealLastScheduled(r6, r13)
            L_0x0075:
                r7 = 0
                goto L_0x0090
            L_0x0077:
                throw r3
            L_0x0078:
                kotlinx.coroutines.scheduling.WorkQueue r3 = r0.localQueue
                kotlinx.coroutines.scheduling.WorkQueue r5 = r14.localQueue
                if (r3 == 0) goto L_0x00a8
                kotlinx.coroutines.scheduling.Task r6 = r5.pollBuffer()
                if (r6 == 0) goto L_0x008b
                r7 = 0
                r3.add(r6, r7)
                r5 = -1
                goto L_0x0090
            L_0x008b:
                r7 = 0
                long r5 = r3.tryStealLastScheduled(r5, r7)
            L_0x0090:
                r11 = -1
                int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r3 != 0) goto L_0x009d
                kotlinx.coroutines.scheduling.WorkQueue r1 = r0.localQueue
                kotlinx.coroutines.scheduling.Task r1 = r1.poll()
                return r1
            L_0x009d:
                r11 = 0
                int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r3 <= 0) goto L_0x00ab
                long r9 = java.lang.Math.min(r9, r5)
                goto L_0x00ab
            L_0x00a8:
                r3 = 0
                throw r3
            L_0x00aa:
                r7 = 0
            L_0x00ab:
                int r8 = r8 + 1
                r3 = 0
                goto L_0x001c
            L_0x00b0:
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = 0
                int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x00bc
                goto L_0x00bd
            L_0x00bc:
                r9 = r11
            L_0x00bd:
                r0.minDelayUntilStealableTaskNs = r9
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.trySteal(boolean):kotlinx.coroutines.scheduling.Task");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            if (this.maxPoolSize >= this.corePoolSize) {
                if (this.maxPoolSize <= 2097150) {
                    if (this.idleWorkerKeepAliveNs > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.parkedWorkersStack = 0;
                        this.workers = new ResizableAtomicArray<>(this.corePoolSize + 1);
                        this.controlState = ((long) this.corePoolSize) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline73("Idle worker keep alive time "), this.idleWorkerKeepAliveNs, " must be positive").toString());
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Max pool size "), this.maxPoolSize, " should not exceed maximal supported number of threads 2097150").toString());
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Max pool size ");
            outline73.append(this.maxPoolSize);
            outline73.append(" should be greater than or equals to core pool size ");
            outline73.append(this.corePoolSize);
            throw new IllegalArgumentException(outline73.toString().toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Core pool size "), this.corePoolSize, " should be at least 1").toString());
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i) {
        TaskContext taskContext2 = (i & 2) != 0 ? TasksKt.NonBlockingContext : null;
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext2, z);
    }

    public void close() {
        int i;
        Task task;
        boolean z;
        if (_isTerminated$FU.compareAndSet(this, 0, 1)) {
            Worker currentWorker = currentWorker();
            synchronized (this.workers) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object obj = this.workers.get(i2);
                    Intrinsics.checkNotNull(obj);
                    Worker worker = (Worker) obj;
                    if (worker != currentWorker) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(MqttAsyncClient.DISCONNECT_TIMEOUT);
                        }
                        WorkQueue workQueue = worker.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        if (workQueue != null) {
                            Task task2 = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, null);
                            if (task2 != null) {
                                globalQueue.addLast(task2);
                            }
                            do {
                                Task pollBuffer = workQueue.pollBuffer();
                                if (pollBuffer == null) {
                                    z = false;
                                    continue;
                                } else {
                                    globalQueue.addLast(pollBuffer);
                                    z = true;
                                    continue;
                                }
                            } while (z);
                        } else {
                            throw null;
                        }
                    }
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (currentWorker != null) {
                    task = currentWorker.findTask(true);
                    if (task != null) {
                        continue;
                        runSafely(task);
                    }
                }
                task = (Task) this.globalCpuQueue.removeFirstOrNull();
                if (task == null) {
                    task = (Task) this.globalBlockingQueue.removeFirstOrNull();
                    if (task == null) {
                        break;
                    }
                } else {
                    continue;
                }
                runSafely(task);
            }
            if (currentWorker != null) {
                currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int i2 = i - ((int) ((j & 4398044413952L) >> 21));
            boolean z = false;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.workers.get(i3) == null) {
                Worker worker = new Worker(i3);
                this.workers.setSynchronized(i3, worker);
                if (i3 == ((int) (2097151 & controlState$FU.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    worker.start();
                    int i4 = i2 + 1;
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        Task task;
        Task task2;
        boolean z2;
        if (((NanoTimeSource) TasksKt.schedulerTimeSource) != null) {
            long nanoTime = System.nanoTime();
            if (runnable instanceof Task) {
                task = (Task) runnable;
                task.submissionTime = nanoTime;
                task.taskContext = taskContext;
            } else {
                task = new TaskImpl(runnable, nanoTime, taskContext);
            }
            Worker currentWorker = currentWorker();
            boolean z3 = true;
            if (currentWorker == null || currentWorker.state == WorkerState.TERMINATED || (task.taskContext.getTaskMode() == 0 && currentWorker.state == WorkerState.BLOCKING)) {
                task2 = task;
            } else {
                currentWorker.mayHaveLocalTasks = true;
                task2 = currentWorker.localQueue.add(task, z);
            }
            if (task2 != null) {
                if (task2.taskContext.getTaskMode() == 1) {
                    z2 = this.globalBlockingQueue.addLast(task2);
                } else {
                    z2 = this.globalCpuQueue.addLast(task2);
                }
                if (!z2) {
                    throw new RejectedExecutionException(GeneratedOutlineSupport.outline62(new StringBuilder(), this.schedulerName, " was terminated"));
                }
            }
            if (!z || currentWorker == null) {
                z3 = false;
            }
            if (task.taskContext.getTaskMode() != 0) {
                long addAndGet = controlState$FU.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
                if (!z3 && !tryUnpark() && !tryCreateWorker(addAndGet)) {
                    tryUnpark();
                }
            } else if (!z3) {
                signalCpuWork();
            } else {
                return;
            }
            return;
        }
        throw null;
    }

    public void execute(Runnable runnable) {
        dispatch(runnable, TasksKt.NonBlockingContext, false);
    }

    public final int parkedWorkersStackNextIndex(Worker worker) {
        Object obj = worker.nextParkedWorker;
        while (obj != NOT_IN_STACK) {
            if (obj == null) {
                return 0;
            }
            Worker worker2 = (Worker) obj;
            int i = worker2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = worker2.nextParkedWorker;
        }
        return -1;
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            if (i3 == i) {
                i3 = i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2;
            }
            if (i3 >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, j2 | ((long) i3))) {
                    return;
                }
            }
        }
    }

    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public final void signalCpuWork() {
        if (!tryUnpark() && !tryCreateWorker(this.controlState)) {
            tryUnpark();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.array.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            Worker worker = (Worker) this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int ordinal = worker.state.ordinal();
                if (ordinal == 0) {
                    i++;
                    arrayList.add(size$kotlinx_coroutines_core + 'c');
                } else if (ordinal == 1) {
                    i2++;
                    arrayList.add(size$kotlinx_coroutines_core + 'b');
                } else if (ordinal == 2) {
                    i3++;
                } else if (ordinal == 3) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(size$kotlinx_coroutines_core + 'd');
                    }
                } else if (ordinal == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        if (i < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = (Worker) this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
                int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
                if (parkedWorkersStackNextIndex >= 0) {
                    if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) parkedWorkersStackNextIndex) | j2)) {
                        worker.nextParkedWorker = NOT_IN_STACK;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }
}
