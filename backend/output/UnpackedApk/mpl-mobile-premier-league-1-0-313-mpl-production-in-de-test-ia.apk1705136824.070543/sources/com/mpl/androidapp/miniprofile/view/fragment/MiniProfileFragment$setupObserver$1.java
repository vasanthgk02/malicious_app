package com.mpl.androidapp.miniprofile.view.fragment;

import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult;
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
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment$setupObserver$1", f = "MiniProfileFragment.kt", l = {149}, m = "invokeSuspend")
/* compiled from: MiniProfileFragment.kt */
public final class MiniProfileFragment$setupObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniProfileFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileFragment$setupObserver$1(MiniProfileFragment miniProfileFragment, Continuation<? super MiniProfileFragment$setupObserver$1> continuation) {
        // this.this$0 = miniProfileFragment;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileFragment$setupObserver$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileFragment$setupObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            StateFlow<MiniProfileResult> miniProfileUiState = this.this$0.getViewModel().getMiniProfileUiState();
            final MiniProfileFragment miniProfileFragment = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                public final Object emit(MiniProfileResult miniProfileResult, Continuation<? super Unit> continuation) {
                    miniProfileFragment.setViewState(miniProfileResult);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (miniProfileUiState.collect(r1, this) == coroutineSingletons) {
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
