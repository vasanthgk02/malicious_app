package kotlinx.coroutines.sync;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Removed;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Mutex.kt */
public final class MutexImpl implements Mutex {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    public volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Mutex.kt */
    public final class LockCont extends LockWaiter {
        public final CancellableContinuation<Unit> cont;

        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(MutexImpl.this, obj);
            this.cont = cancellableContinuation;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("LockCont[");
            outline73.append(this.owner);
            outline73.append(", ");
            outline73.append(this.cont);
            outline73.append("] for ");
            outline73.append(MutexImpl.this);
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Mutex.kt */
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        public static final /* synthetic */ AtomicIntegerFieldUpdater isTaken$FU = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");
        public volatile /* synthetic */ int isTaken = 0;
        public final Object owner;

        public LockWaiter(MutexImpl mutexImpl, Object obj) {
            this.owner = obj;
        }

        public final void dispose() {
            remove();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Mutex.kt */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        public volatile Object owner;

        public LockedQueue(Object obj) {
            this.owner = obj;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("LockedQueue[");
            outline73.append(this.owner);
            outline73.append(']');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Mutex.kt */
    public static final class UnlockOp extends AtomicOp<MutexImpl> {
        public final LockedQueue queue;

        public UnlockOp(LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        public void complete(Object obj, Object obj2) {
            Object obj3;
            MutexImpl mutexImpl = (MutexImpl) obj;
            if (obj2 == null) {
                obj3 = MutexKt.EMPTY_UNLOCKED;
            } else {
                obj3 = this.queue;
            }
            MutexImpl._state$FU.compareAndSet(mutexImpl, this, obj3);
        }

        public Object prepare(Object obj) {
            MutexImpl mutexImpl = (MutexImpl) obj;
            LockedQueue lockedQueue = this.queue;
            if (lockedQueue.getNext() == lockedQueue) {
                return null;
            }
            return MutexKt.UNLOCK_FAIL;
        }
    }

    public MutexImpl(boolean z) {
        Empty empty;
        if (z) {
            empty = MutexKt.EMPTY_LOCKED;
        } else {
            empty = MutexKt.EMPTY_UNLOCKED;
        }
        this._state = empty;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r11 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object lock(java.lang.Object r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
        L_0x0000:
            java.lang.Object r11 = r10._state
            boolean r0 = r11 instanceof kotlinx.coroutines.sync.Empty
            java.lang.String r1 = "Illegal state "
            java.lang.String r2 = "Already locked by null"
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0022
            r0 = r11
            kotlinx.coroutines.sync.Empty r0 = (kotlinx.coroutines.sync.Empty) r0
            java.lang.Object r0 = r0.locked
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.MutexKt.UNLOCKED
            if (r0 == r5) goto L_0x0016
            goto L_0x0031
        L_0x0016:
            kotlinx.coroutines.sync.Empty r0 = kotlinx.coroutines.sync.MutexKt.EMPTY_LOCKED
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = _state$FU
            boolean r11 = r5.compareAndSet(r10, r11, r0)
            if (r11 == 0) goto L_0x0000
            r11 = 1
            goto L_0x0032
        L_0x0022:
            boolean r0 = r11 instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue
            if (r0 == 0) goto L_0x00ff
            kotlinx.coroutines.sync.MutexImpl$LockedQueue r11 = (kotlinx.coroutines.sync.MutexImpl.LockedQueue) r11
            java.lang.Object r11 = r11.owner
            if (r11 == 0) goto L_0x002e
            r11 = 1
            goto L_0x002f
        L_0x002e:
            r11 = 0
        L_0x002f:
            if (r11 == 0) goto L_0x00f5
        L_0x0031:
            r11 = 0
        L_0x0032:
            if (r11 == 0) goto L_0x0037
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0037:
            kotlin.coroutines.Continuation r11 = com.twitter.sdk.android.tweetui.TweetUtils.intercepted(r12)
            kotlinx.coroutines.CancellableContinuationImpl r11 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getOrCreateCancellableContinuation(r11)
            kotlinx.coroutines.sync.MutexImpl$LockCont r0 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r5 = 0
            r0.<init>(r5, r11)
        L_0x0045:
            java.lang.Object r6 = r10._state
            boolean r7 = r6 instanceof kotlinx.coroutines.sync.Empty
            if (r7 == 0) goto L_0x0076
            r7 = r6
            kotlinx.coroutines.sync.Empty r7 = (kotlinx.coroutines.sync.Empty) r7
            java.lang.Object r8 = r7.locked
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.sync.MutexKt.UNLOCKED
            if (r8 == r9) goto L_0x0061
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = _state$FU
            kotlinx.coroutines.sync.MutexImpl$LockedQueue r9 = new kotlinx.coroutines.sync.MutexImpl$LockedQueue
            java.lang.Object r7 = r7.locked
            r9.<init>(r7)
            r8.compareAndSet(r10, r6, r9)
            goto L_0x0045
        L_0x0061:
            kotlinx.coroutines.sync.Empty r7 = kotlinx.coroutines.sync.MutexKt.EMPTY_LOCKED
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = _state$FU
            boolean r6 = r8.compareAndSet(r10, r6, r7)
            if (r6 == 0) goto L_0x0045
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r1 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r1.<init>(r10, r5)
            r11.resume(r0, r1)
            goto L_0x00ab
        L_0x0076:
            boolean r7 = r6 instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue
            if (r7 == 0) goto L_0x00d1
            r7 = r6
            kotlinx.coroutines.sync.MutexImpl$LockedQueue r7 = (kotlinx.coroutines.sync.MutexImpl.LockedQueue) r7
            java.lang.Object r8 = r7.owner
            if (r8 == 0) goto L_0x0083
            r8 = 1
            goto L_0x0084
        L_0x0083:
            r8 = 0
        L_0x0084:
            if (r8 == 0) goto L_0x00c7
        L_0x0086:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r8 = r7.getPrevNode()
            boolean r8 = r8.addNext(r0, r7)
            if (r8 == 0) goto L_0x0086
            java.lang.Object r7 = r10._state
            if (r7 == r6) goto L_0x00a3
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.sync.MutexImpl.LockWaiter.isTaken$FU
            boolean r6 = r6.compareAndSet(r0, r3, r4)
            if (r6 != 0) goto L_0x009d
            goto L_0x00a3
        L_0x009d:
            kotlinx.coroutines.sync.MutexImpl$LockCont r0 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r0.<init>(r5, r11)
            goto L_0x0045
        L_0x00a3:
            kotlinx.coroutines.RemoveOnCancel r1 = new kotlinx.coroutines.RemoveOnCancel
            r1.<init>(r0)
            r11.invokeOnCancellation(r1)
        L_0x00ab:
            java.lang.Object r11 = r11.getResult()
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r11 != r0) goto L_0x00b8
            java.lang.String r0 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
        L_0x00b8:
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r11 != r12) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L_0x00bf:
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r11 != r12) goto L_0x00c4
            return r11
        L_0x00c4:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00c7:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = r2.toString()
            r11.<init>(r12)
            throw r11
        L_0x00d1:
            boolean r7 = r6 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r7 == 0) goto L_0x00dc
            kotlinx.coroutines.internal.OpDescriptor r6 = (kotlinx.coroutines.internal.OpDescriptor) r6
            r6.perform(r10)
            goto L_0x0045
        L_0x00dc:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r1)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00f5:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = r2.toString()
            r11.<init>(r12)
            throw r11
        L_0x00ff:
            boolean r0 = r11 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r0 == 0) goto L_0x010a
            kotlinx.coroutines.internal.OpDescriptor r11 = (kotlinx.coroutines.internal.OpDescriptor) r11
            r11.perform(r10)
            goto L_0x0000
        L_0x010a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.lock(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mutex[");
                outline73.append(((Empty) obj).locked);
                outline73.append(']');
                return outline73.toString();
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Mutex[");
                outline732.append(((LockedQueue) obj).owner);
                outline732.append(']');
                return outline732.toString();
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }

    public void unlock(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        while (true) {
            Object obj2 = this._state;
            boolean z = false;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    if (((Empty) obj2).locked != MutexKt.UNLOCKED) {
                        z = true;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty = (Empty) obj2;
                    if (empty.locked == obj) {
                        z = true;
                    }
                    if (!z) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mutex is locked by ");
                        outline73.append(empty.locked);
                        outline73.append(" but expected ");
                        outline73.append(obj);
                        throw new IllegalStateException(outline73.toString().toString());
                    }
                }
                if (_state$FU.compareAndSet(this, obj2, MutexKt.EMPTY_UNLOCKED)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (!(lockedQueue.owner == obj)) {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Mutex is locked by ");
                        outline732.append(lockedQueue.owner);
                        outline732.append(" but expected ");
                        outline732.append(obj);
                        throw new IllegalStateException(outline732.toString().toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) lockedQueue2.getNext();
                    if (lockFreeLinkedListNode == lockedQueue2) {
                        lockFreeLinkedListNode = null;
                        break;
                    } else if (lockFreeLinkedListNode.remove()) {
                        break;
                    } else {
                        ((Removed) lockFreeLinkedListNode.getNext()).ref.helpRemovePrev();
                    }
                }
                if (lockFreeLinkedListNode == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (_state$FU.compareAndSet(this, obj2, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) lockFreeLinkedListNode;
                    LockCont lockCont = (LockCont) lockWaiter;
                    if (LockWaiter.isTaken$FU.compareAndSet(lockCont, 0, 1) && lockCont.cont.tryResume(Unit.INSTANCE, null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, lockCont)) != null) {
                        z = true;
                    }
                    if (z) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        lockCont.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }
}
