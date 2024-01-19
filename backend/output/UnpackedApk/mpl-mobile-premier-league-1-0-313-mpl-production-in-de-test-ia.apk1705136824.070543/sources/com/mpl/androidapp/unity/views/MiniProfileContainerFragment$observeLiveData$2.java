package com.mpl.androidapp.unity.views;

import com.mpl.androidapp.unity.states.UnityViewProfileState;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.views.MiniProfileContainerFragment$observeLiveData$2", f = "MiniProfileContainerFragment.kt", l = {85}, m = "invokeSuspend")
/* compiled from: MiniProfileContainerFragment.kt */
public final class MiniProfileContainerFragment$observeLiveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniProfileContainerFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileContainerFragment$observeLiveData$2(MiniProfileContainerFragment miniProfileContainerFragment, Continuation<? super MiniProfileContainerFragment$observeLiveData$2> continuation) {
        // this.this$0 = miniProfileContainerFragment;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileContainerFragment$observeLiveData$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileContainerFragment$observeLiveData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            StateFlow<UnityViewProfileState> unityProfileState = this.this$0.getViewModel().getUnityProfileState();
            final MiniProfileContainerFragment miniProfileContainerFragment = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                public final Object emit(UnityViewProfileState unityViewProfileState, Continuation<? super Unit> continuation) {
                    miniProfileContainerFragment.setViewState(unityViewProfileState);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (unityProfileState.collect(r1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            TweetUtils.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
