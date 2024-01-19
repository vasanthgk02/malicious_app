package com.mpl.androidapp.unity.views;

import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.model.UnityMiniProfileData;
import com.mpl.androidapp.unity.vm.MiniProfileContainerVm;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.views.MiniProfileContainerFragment$observeLiveData$1$1$1", f = "MiniProfileContainerFragment.kt", l = {77}, m = "invokeSuspend")
/* compiled from: MiniProfileContainerFragment.kt */
public final class MiniProfileContainerFragment$observeLiveData$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ProfileDetails $profileDetails;
    public int label;
    public final /* synthetic */ MiniProfileContainerFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileContainerFragment$observeLiveData$1$1$1(MiniProfileContainerFragment miniProfileContainerFragment, ProfileDetails profileDetails, Continuation<? super MiniProfileContainerFragment$observeLiveData$1$1$1> continuation) {
        // this.this$0 = miniProfileContainerFragment;
        // this.$profileDetails = profileDetails;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileContainerFragment$observeLiveData$1$1$1(this.this$0, this.$profileDetails, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileContainerFragment$observeLiveData$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MiniProfileContainerVm access$getViewModel = this.this$0.getViewModel();
            String valueOf = String.valueOf(this.$profileDetails.getBasicUser().getId());
            UnityMiniProfileData access$getProfileData$p = this.this$0.profileData;
            if (access$getProfileData$p != null) {
                int gameID = access$getProfileData$p.getGameID();
                this.label = 1;
                if (access$getViewModel.getUnityDeepLink(valueOf, gameID, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("profileData");
                throw null;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
