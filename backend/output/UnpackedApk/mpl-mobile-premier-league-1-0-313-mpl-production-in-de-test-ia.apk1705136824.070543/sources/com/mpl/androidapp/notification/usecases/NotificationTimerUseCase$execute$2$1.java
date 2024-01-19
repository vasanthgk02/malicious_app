package com.mpl.androidapp.notification.usecases;

import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationTimerSuccessful;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.ContextScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.NotificationTimerUseCase$execute$2$1", f = "NotificationTimerUseCase.kt", l = {22}, m = "invokeSuspend")
/* compiled from: NotificationTimerUseCase.kt */
public final class NotificationTimerUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public final /* synthetic */ long $timerDuration;
    public int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.notification.usecases.NotificationTimerUseCase$execute$2$1$1", f = "NotificationTimerUseCase.kt", l = {23}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.notification.usecases.NotificationTimerUseCase$execute$2$1$1  reason: invalid class name */
    /* compiled from: NotificationTimerUseCase.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(j, cancellableContinuation, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                TweetUtils.throwOnFailure(obj);
                long j = j;
                this.label = 1;
                if (j <= 0) {
                    obj2 = Unit.INSTANCE;
                } else {
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(this), 1);
                    cancellableContinuationImpl.initCancellability();
                    if (j < Long.MAX_VALUE) {
                        Element element = cancellableContinuationImpl.getContext().get(ContinuationInterceptor.Key);
                        Delay delay = element instanceof Delay ? (Delay) element : null;
                        if (delay == null) {
                            delay = DefaultExecutorKt.DefaultDelay;
                        }
                        delay.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
                    }
                    obj2 = cancellableContinuationImpl.getResult();
                    if (obj2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        Intrinsics.checkNotNullParameter(this, "frame");
                    }
                    if (obj2 != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        obj2 = Unit.INSTANCE;
                    }
                }
                if (obj2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (i == 1) {
                TweetUtils.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cancellableContinuation.resumeWith(new Success(NotificationTimerSuccessful.INSTANCE));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotificationTimerUseCase$execute$2$1(CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, long j, Continuation<? super NotificationTimerUseCase$execute$2$1> continuation) {
        // this.$coroutine = cancellableContinuation;
        // this.$timerDuration = j;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationTimerUseCase$execute$2$1(this.$coroutine, this.$timerDuration, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationTimerUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineContext coroutineContext = ((ContextScope) TypeUtilsKt.CoroutineScope(Dispatchers.IO)).coroutineContext;
            final long j = this.$timerDuration;
            final CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation = this.$coroutine;
            AnonymousClass1 r1 = new AnonymousClass1(null);
            this.label = 1;
            if (TypeUtilsKt.withContext(coroutineContext, r1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
