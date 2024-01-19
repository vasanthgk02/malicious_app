package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateFlow.kt */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Object<T> {
    public volatile /* synthetic */ Object _state;
    public int sequence;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[Catch:{ all -> 0x0071 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d6 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d9 A[Catch:{ all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r12, kotlin.coroutines.Continuation<?> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0074
            if (r2 == r6) goto L_0x005f
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r12 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)     // Catch:{ all -> 0x0071 }
            goto L_0x00a4
        L_0x0040:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0048:
            java.lang.Object r12 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)     // Catch:{ all -> 0x0071 }
            goto L_0x00d7
        L_0x005f:
            java.lang.Object r12 = r0.L$2
            r7 = r12
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r12 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)     // Catch:{ all -> 0x0071 }
            goto L_0x0095
        L_0x0071:
            r12 = move-exception
            goto L_0x0103
        L_0x0074:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r13 = r11.allocateSlot()
            r7 = r13
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            boolean r13 = r12 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0101 }
            if (r13 == 0) goto L_0x0094
            r13 = r12
            kotlinx.coroutines.flow.SubscribedFlowCollector r13 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r13     // Catch:{ all -> 0x0101 }
            r0.L$0 = r11     // Catch:{ all -> 0x0101 }
            r0.L$1 = r12     // Catch:{ all -> 0x0101 }
            r0.L$2 = r7     // Catch:{ all -> 0x0101 }
            r0.label = r6     // Catch:{ all -> 0x0101 }
            java.lang.Object r13 = r13.onSubscription(r0)     // Catch:{ all -> 0x0101 }
            if (r13 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r9 = r11
        L_0x0095:
            kotlin.coroutines.CoroutineContext r13 = r0.getContext()     // Catch:{ all -> 0x0071 }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0071 }
            kotlin.coroutines.CoroutineContext$Element r13 = r13.get(r2)     // Catch:{ all -> 0x0071 }
            kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13     // Catch:{ all -> 0x0071 }
            r8 = r12
            r2 = r13
            r12 = r5
        L_0x00a4:
            java.lang.Object r13 = r9._state     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x00b4
            boolean r10 = r2.isActive()     // Catch:{ all -> 0x0071 }
            if (r10 == 0) goto L_0x00af
            goto L_0x00b4
        L_0x00af:
            java.util.concurrent.CancellationException r12 = r2.getCancellationException()     // Catch:{ all -> 0x0071 }
            throw r12     // Catch:{ all -> 0x0071 }
        L_0x00b4:
            if (r12 == 0) goto L_0x00bc
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r13)     // Catch:{ all -> 0x0071 }
            if (r10 != 0) goto L_0x00d7
        L_0x00bc:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0071 }
            if (r13 != r12) goto L_0x00c2
            r12 = r5
            goto L_0x00c3
        L_0x00c2:
            r12 = r13
        L_0x00c3:
            r0.L$0 = r9     // Catch:{ all -> 0x0071 }
            r0.L$1 = r8     // Catch:{ all -> 0x0071 }
            r0.L$2 = r7     // Catch:{ all -> 0x0071 }
            r0.L$3 = r2     // Catch:{ all -> 0x0071 }
            r0.L$4 = r13     // Catch:{ all -> 0x0071 }
            r0.label = r4     // Catch:{ all -> 0x0071 }
            java.lang.Object r12 = r8.emit(r12, r0)     // Catch:{ all -> 0x0071 }
            if (r12 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            r12 = r13
        L_0x00d7:
            if (r7 == 0) goto L_0x0100
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = kotlinx.coroutines.flow.StateFlowSlot._state$FU     // Catch:{ all -> 0x0071 }
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.StateFlowKt.NONE     // Catch:{ all -> 0x0071 }
            java.lang.Object r13 = r13.getAndSet(r7, r10)     // Catch:{ all -> 0x0071 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x0071 }
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.StateFlowKt.PENDING     // Catch:{ all -> 0x0071 }
            if (r13 != r10) goto L_0x00ea
            r13 = 1
            goto L_0x00eb
        L_0x00ea:
            r13 = 0
        L_0x00eb:
            if (r13 != 0) goto L_0x00a4
            r0.L$0 = r9     // Catch:{ all -> 0x0071 }
            r0.L$1 = r8     // Catch:{ all -> 0x0071 }
            r0.L$2 = r7     // Catch:{ all -> 0x0071 }
            r0.L$3 = r2     // Catch:{ all -> 0x0071 }
            r0.L$4 = r12     // Catch:{ all -> 0x0071 }
            r0.label = r3     // Catch:{ all -> 0x0071 }
            java.lang.Object r13 = r7.awaitPending(r0)     // Catch:{ all -> 0x0071 }
            if (r13 != r1) goto L_0x00a4
            return r1
        L_0x0100:
            throw r5     // Catch:{ all -> 0x0071 }
        L_0x0101:
            r12 = move-exception
            r9 = r11
        L_0x0103:
            r9.freeSlot(r7)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public AbstractSharedFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    public AbstractSharedFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    public T getValue() {
        T t = NullSurrogateKt.NULL;
        T t2 = this._state;
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = (kotlinx.coroutines.flow.StateFlowSlot[]) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r1 = r0.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r2 >= r1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r3 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        r4 = r3._state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r4 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r4 != kotlinx.coroutines.flow.StateFlowKt.PENDING) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r5 = kotlinx.coroutines.flow.StateFlowKt.NONE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r4 != r5) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (kotlinx.coroutines.flow.StateFlowSlot._state$FU.compareAndSet(r3, r4, kotlinx.coroutines.flow.StateFlowKt.PENDING) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (kotlinx.coroutines.flow.StateFlowSlot._state$FU.compareAndSet(r3, r4, r5) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        ((kotlinx.coroutines.CancellableContinuationImpl) r4).resumeWith(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
        if (r7.sequence != r8) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
        r7.sequence = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r8 = r7.sequence;
        r0 = r7.slots;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0064, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(T r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0004
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
        L_0x0004:
            monitor-enter(r7)
            java.lang.Object r0 = r7._state     // Catch:{ all -> 0x006f }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r7)
            goto L_0x006e
        L_0x000f:
            r7._state = r8     // Catch:{ all -> 0x006f }
            int r8 = r7.sequence     // Catch:{ all -> 0x006f }
            r0 = r8 & 1
            if (r0 != 0) goto L_0x0069
            int r8 = r8 + 1
            r7.sequence = r8     // Catch:{ all -> 0x006f }
            S[] r0 = r7.slots     // Catch:{ all -> 0x006f }
            monitor-exit(r7)
        L_0x001e:
            kotlinx.coroutines.flow.StateFlowSlot[] r0 = (kotlinx.coroutines.flow.StateFlowSlot[]) r0
            if (r0 == 0) goto L_0x0055
            int r1 = r0.length
            r2 = 0
        L_0x0024:
            if (r2 >= r1) goto L_0x0055
            r3 = r0[r2]
            if (r3 == 0) goto L_0x0052
        L_0x002a:
            java.lang.Object r4 = r3._state
            if (r4 != 0) goto L_0x002f
            goto L_0x0052
        L_0x002f:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.StateFlowKt.PENDING
            if (r4 != r5) goto L_0x0034
            goto L_0x0052
        L_0x0034:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.StateFlowKt.NONE
            if (r4 != r5) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.flow.StateFlowSlot._state$FU
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.StateFlowKt.PENDING
            boolean r4 = r5.compareAndSet(r3, r4, r6)
            if (r4 == 0) goto L_0x002a
            goto L_0x0052
        L_0x0043:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.flow.StateFlowSlot._state$FU
            boolean r5 = r6.compareAndSet(r3, r4, r5)
            if (r5 == 0) goto L_0x002a
            kotlinx.coroutines.CancellableContinuationImpl r4 = (kotlinx.coroutines.CancellableContinuationImpl) r4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r4.resumeWith(r3)
        L_0x0052:
            int r2 = r2 + 1
            goto L_0x0024
        L_0x0055:
            monitor-enter(r7)
            int r0 = r7.sequence     // Catch:{ all -> 0x0066 }
            if (r0 != r8) goto L_0x0060
            int r8 = r8 + 1
            r7.sequence = r8     // Catch:{ all -> 0x0066 }
            monitor-exit(r7)
            goto L_0x006e
        L_0x0060:
            int r8 = r7.sequence     // Catch:{ all -> 0x0066 }
            S[] r0 = r7.slots     // Catch:{ all -> 0x0066 }
            monitor-exit(r7)
            goto L_0x001e
        L_0x0066:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0069:
            int r8 = r8 + 2
            r7.sequence = r8     // Catch:{ all -> 0x006f }
            monitor-exit(r7)
        L_0x006e:
            return
        L_0x006f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.setValue(java.lang.Object):void");
    }
}
