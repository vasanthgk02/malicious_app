package com.mpl.androidapp.unity.vm;

import android.app.Application;
import com.mpl.androidapp.miniprofile.base.BaseViewModel;
import com.mpl.androidapp.unity.states.UnityViewProfileState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.ErrorState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.InitialUnityProfileState;
import com.mpl.androidapp.unity.usecases.UnityViewProfileUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/unity/vm/MiniProfileContainerVm;", "Lcom/mpl/androidapp/miniprofile/base/BaseViewModel;", "application", "Landroid/app/Application;", "unityViewProfileUseCase", "Lcom/mpl/androidapp/unity/usecases/UnityViewProfileUseCase;", "(Landroid/app/Application;Lcom/mpl/androidapp/unity/usecases/UnityViewProfileUseCase;)V", "_unityProfileState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "unityProfileState", "Lkotlinx/coroutines/flow/StateFlow;", "getUnityProfileState", "()Lkotlinx/coroutines/flow/StateFlow;", "getUnityDeepLink", "", "userId", "", "gameId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileContainerVm.kt */
public final class MiniProfileContainerVm extends BaseViewModel {
    public final MutableStateFlow<UnityViewProfileState> _unityProfileState;
    public final StateFlow<UnityViewProfileState> unityProfileState;
    public final UnityViewProfileUseCase unityViewProfileUseCase;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileContainerVm(Application application, UnityViewProfileUseCase unityViewProfileUseCase2) {
        // Intrinsics.checkNotNullParameter(application, "application");
        // Intrinsics.checkNotNullParameter(unityViewProfileUseCase2, "unityViewProfileUseCase");
        super(application);
        this.unityViewProfileUseCase = unityViewProfileUseCase2;
        MutableStateFlow<UnityViewProfileState> MutableStateFlow = StateFlowKt.MutableStateFlow(InitialUnityProfileState.INSTANCE);
        this._unityProfileState = MutableStateFlow;
        this.unityProfileState = TypeUtilsKt.asStateFlow(MutableStateFlow);
    }

    private final void useCaseError(Error error) {
        this._unityProfileState.setValue(new ErrorState(String.valueOf(error.getException().getMessage())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUnityDeepLink(java.lang.String r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.unity.vm.MiniProfileContainerVm$getUnityDeepLink$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.unity.vm.MiniProfileContainerVm$getUnityDeepLink$1 r0 = (com.mpl.androidapp.unity.vm.MiniProfileContainerVm$getUnityDeepLink$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.unity.vm.MiniProfileContainerVm$getUnityDeepLink$1 r0 = new com.mpl.androidapp.unity.vm.MiniProfileContainerVm$getUnityDeepLink$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            com.mpl.androidapp.unity.vm.MiniProfileContainerVm r5 = (com.mpl.androidapp.unity.vm.MiniProfileContainerVm) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0049
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.unity.models.UnityProfileParams r7 = new com.mpl.androidapp.unity.models.UnityProfileParams
            r7.<init>(r5, r6)
            com.mpl.androidapp.unity.usecases.UnityViewProfileUseCase r5 = r4.unityViewProfileUseCase
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r5.invoke(r7, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r5 = r4
        L_0x0049:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r6 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r6 == 0) goto L_0x006d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r6 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            if (r6 == 0) goto L_0x0065
            com.mpl.androidapp.unity.states.UnityViewProfileState$ViewProfileDeepLink r6 = (com.mpl.androidapp.unity.states.UnityViewProfileState.ViewProfileDeepLink) r6
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.unity.states.UnityViewProfileState> r5 = r5._unityProfileState
            r5.setValue(r6)
            goto L_0x0076
        L_0x0065:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type com.mpl.androidapp.unity.states.UnityViewProfileState.ViewProfileDeepLink"
            r5.<init>(r6)
            throw r5
        L_0x006d:
            boolean r6 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r6 == 0) goto L_0x0076
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r5.useCaseError(r7)
        L_0x0076:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.unity.vm.MiniProfileContainerVm.getUnityDeepLink(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow<UnityViewProfileState> getUnityProfileState() {
        return this.unityProfileState;
    }
}
