package com.mpl.androidapp.notification.usecases;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.IsAppIsInBackground;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.IsAppIsInBackgroundUseCase$execute$2$1", f = "IsAppIsInBackgroundUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: IsAppIsInBackgroundUseCase.kt */
public final class IsAppIsInBackgroundUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public int label;
    public final /* synthetic */ IsAppIsInBackgroundUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IsAppIsInBackgroundUseCase$execute$2$1(IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase, CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, Continuation<? super IsAppIsInBackgroundUseCase$execute$2$1> continuation) {
        // this.this$0 = isAppIsInBackgroundUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IsAppIsInBackgroundUseCase$execute$2$1(this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IsAppIsInBackgroundUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                Object systemService = this.this$0.getContext().getSystemService("activity");
                if (systemService != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                    boolean z = true;
                    if (runningAppProcesses != null) {
                        IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase = this.this$0;
                        for (int i = 0; i < runningAppProcesses.size(); i++) {
                            RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                            if (runningAppProcessInfo.importance == 100) {
                                String[] strArr = runningAppProcessInfo.pkgList;
                                int i2 = 0;
                                while (strArr != null && i2 < strArr.length) {
                                    String str = strArr[i2];
                                    Intrinsics.checkNotNullExpressionValue(str, "pkgList[i1]");
                                    if (Intrinsics.areEqual(isAppIsInBackgroundUseCase.getContext().getPackageName(), str)) {
                                        z = false;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                    this.$coroutine.resumeWith(new Success(new IsAppIsInBackground(z)));
                    return Unit.INSTANCE;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
