package com.mpl.androidapp.miniprofile.view.fragment;

import android.content.Context;
import com.mpl.androidapp.miniprofile.utils.InternetConnectionInfo;
import com.mpl.androidapp.miniprofile.vm.MiniProfileApis;
import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel;
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
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment$setClickListeners$2$1", f = "MiniProfileFragment.kt", l = {}, m = "invokeSuspend")
/* compiled from: MiniProfileFragment.kt */
public final class MiniProfileFragment$setClickListeners$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniProfileFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileFragment$setClickListeners$2$1(MiniProfileFragment miniProfileFragment, Continuation<? super MiniProfileFragment$setClickListeners$2$1> continuation) {
        // this.this$0 = miniProfileFragment;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileFragment$setClickListeners$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileFragment$setClickListeners$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            MiniProfileViewModel access$getViewModel = this.this$0.getViewModel();
            InternetConnectionInfo internetConnectionInfo = InternetConnectionInfo.INSTANCE;
            Context access$getMContext$p = this.this$0.mContext;
            if (access$getMContext$p != null) {
                access$getViewModel.callProfileApi(internetConnectionInfo.isNetworkAvailable(access$getMContext$p), MiniProfileApis.FOLLOW_USER);
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
