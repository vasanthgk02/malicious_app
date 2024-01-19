package com.mpl.androidapp.miniprofile.view.fragment;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
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
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment$profileDetailsApi$1", f = "MiniProfileFragment.kt", l = {}, m = "invokeSuspend")
/* compiled from: MiniProfileFragment.kt */
public final class MiniProfileFragment$profileDetailsApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniProfileFragment this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment$profileDetailsApi$1$1", f = "MiniProfileFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment$profileDetailsApi$1$1  reason: invalid class name */
    /* compiled from: MiniProfileFragment.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(miniProfileFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                TweetUtils.throwOnFailure(obj);
                MiniProfileViewModel access$getViewModel = miniProfileFragment.getViewModel();
                InternetConnectionInfo internetConnectionInfo = InternetConnectionInfo.INSTANCE;
                Context access$getMContext$p = miniProfileFragment.mContext;
                if (access$getMContext$p != null) {
                    access$getViewModel.callProfileApi(internetConnectionInfo.isNetworkAvailable(access$getMContext$p), MiniProfileApis.PROFILE_DETAILS);
                    return Unit.INSTANCE;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                throw null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileFragment$profileDetailsApi$1(MiniProfileFragment miniProfileFragment, Continuation<? super MiniProfileFragment$profileDetailsApi$1> continuation) {
        // this.this$0 = miniProfileFragment;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileFragment$profileDetailsApi$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileFragment$profileDetailsApi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            this.this$0.updateMiniProfileDisplayStates(false, true, false);
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
            final MiniProfileFragment miniProfileFragment = this.this$0;
            TypeUtilsKt.launch$default(lifecycleScope, null, null, new AnonymousClass1(null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
