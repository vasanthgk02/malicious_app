package com.mpl.androidapp.notification.usecases;

import com.mpl.androidapp.notification.models.NotificationPriorityInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/notification/usecases/NotificationPriorityUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/notification/models/NotificationPriorityInput;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "parameters", "(Lcom/mpl/androidapp/notification/models/NotificationPriorityInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationPriorityUseCase.kt */
public class NotificationPriorityUseCase extends SuspendUseCase<NotificationPriorityInput, UseCaseResult<? extends MPLNotificationStates>> {
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotificationPriorityUseCase(@IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.dispatcher = coroutineDispatcher;
    }

    public static Object execute$suspendImpl(NotificationPriorityUseCase notificationPriorityUseCase, NotificationPriorityInput notificationPriorityInput, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(notificationPriorityUseCase.getDispatcher(), new NotificationPriorityUseCase$execute$2$1(notificationPriorityInput, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }

    public Object execute(NotificationPriorityInput notificationPriorityInput, Continuation<? super UseCaseResult<? extends MPLNotificationStates>> continuation) {
        return execute$suspendImpl(this, notificationPriorityInput, continuation);
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }
}
