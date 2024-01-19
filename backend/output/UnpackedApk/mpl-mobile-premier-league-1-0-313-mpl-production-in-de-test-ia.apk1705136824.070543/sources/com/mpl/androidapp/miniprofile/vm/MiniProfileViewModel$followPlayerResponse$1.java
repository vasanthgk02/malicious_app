package com.mpl.androidapp.miniprofile.vm;

import com.mpl.androidapp.miniprofile.utils.UtilPrepFollowUnfollowFrmCache;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.ScreenSuccessFollowState;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel$followPlayerResponse$1", f = "MiniProfileViewModel.kt", l = {84}, m = "invokeSuspend")
/* compiled from: MiniProfileViewModel.kt */
public final class MiniProfileViewModel$followPlayerResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $success;
    public int label;
    public final /* synthetic */ MiniProfileViewModel this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileViewModel$followPlayerResponse$1(MiniProfileViewModel miniProfileViewModel, boolean z, Continuation<? super MiniProfileViewModel$followPlayerResponse$1> continuation) {
        // this.this$0 = miniProfileViewModel;
        // this.$success = z;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileViewModel$followPlayerResponse$1(this.this$0, this.$success, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileViewModel$followPlayerResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            new UtilPrepFollowUnfollowFrmCache(this.this$0.getProfileId()).updateFollowCache();
            MutableStateFlow access$get_miniProfileUiState$p = this.this$0._miniProfileUiState;
            ScreenSuccessFollowState screenSuccessFollowState = new ScreenSuccessFollowState(this.$success);
            this.label = 1;
            if (access$get_miniProfileUiState$p.emit(screenSuccessFollowState, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
