package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore.Message.Read;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ThrowingCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$data$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "it", "Landroidx/datastore/core/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1  reason: invalid class name */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<State<T>, Continuation<? super Boolean>, Object> {
        public /* synthetic */ Object L$0;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(state, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public Object invoke(Object obj, Object obj2) {
            AnonymousClass1 r0 = new AnonymousClass1(state, (Continuation) obj2);
            r0.L$0 = (State) obj;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            TweetUtils.throwOnFailure(obj);
            State<T> state = (State) this.L$0;
            State<T> state2 = state;
            boolean z = false;
            if (!(state2 instanceof Data) && !(state2 instanceof Final) && state == state2) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$data$1> continuation) {
        // this.this$0 = singleProcessDataStore;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, continuation);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    public Object invoke(Object obj, Object obj2) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, (Continuation) obj2);
        singleProcessDataStore$data$1.L$0 = (FlowCollector) obj;
        return singleProcessDataStore$data$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final State state = (State) this.this$0.downstreamFlow.getValue();
            if (!(state instanceof Data)) {
                this.this$0.actor.offer(new Read(state));
            }
            MutableStateFlow<State<T>> mutableStateFlow = this.this$0.downstreamFlow;
            AnonymousClass1 r4 = new AnonymousClass1(null);
            this.label = 1;
            if (!(flowCollector instanceof ThrowingCollector)) {
                Object collect = mutableStateFlow.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), new SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2(flowCollector), r4), this);
                if (collect != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    collect = Unit.INSTANCE;
                }
                if (collect != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    collect = Unit.INSTANCE;
                }
                if (collect != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    collect = Unit.INSTANCE;
                }
                if (collect == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                throw ((ThrowingCollector) flowCollector).f5953e;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
