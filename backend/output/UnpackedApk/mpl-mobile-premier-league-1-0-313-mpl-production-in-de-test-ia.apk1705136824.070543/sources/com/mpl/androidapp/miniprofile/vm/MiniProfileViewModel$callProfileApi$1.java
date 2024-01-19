package com.mpl.androidapp.miniprofile.vm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel$callProfileApi$1", f = "MiniProfileViewModel.kt", l = {}, m = "invokeSuspend")
/* compiled from: MiniProfileViewModel.kt */
public final class MiniProfileViewModel$callProfileApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $connectivityAvailable;
    public final /* synthetic */ MiniProfileApis $miniProfileApis;
    public int label;
    public final /* synthetic */ MiniProfileViewModel this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MiniProfileApis.values().length];
            MiniProfileApis miniProfileApis = MiniProfileApis.PROFILE_DETAILS;
            iArr[0] = 1;
            MiniProfileApis miniProfileApis2 = MiniProfileApis.FOLLOW_USER;
            iArr[1] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileViewModel$callProfileApi$1(boolean z, MiniProfileViewModel miniProfileViewModel, MiniProfileApis miniProfileApis, Continuation<? super MiniProfileViewModel$callProfileApi$1> continuation) {
        // this.$connectivityAvailable = z;
        // this.this$0 = miniProfileViewModel;
        // this.$miniProfileApis = miniProfileApis;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniProfileViewModel$callProfileApi$1(this.$connectivityAvailable, this.this$0, this.$miniProfileApis, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniProfileViewModel$callProfileApi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                if (this.$connectivityAvailable) {
                    this.this$0.loadingState();
                    if (this.this$0.getProfileId().length() > 0) {
                        int ordinal = this.$miniProfileApis.ordinal();
                        if (ordinal == 0) {
                            this.this$0.sendHeartRepository.profileDetails(this.this$0, this.this$0.gson, this.this$0.getProfileId());
                        } else if (ordinal == 1) {
                            this.this$0.sendHeartRepository.followPlayer(this.this$0, this.this$0.gson, this.this$0.getProfileId());
                        }
                    }
                } else {
                    this.this$0.errorState();
                }
                return Unit.INSTANCE;
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
