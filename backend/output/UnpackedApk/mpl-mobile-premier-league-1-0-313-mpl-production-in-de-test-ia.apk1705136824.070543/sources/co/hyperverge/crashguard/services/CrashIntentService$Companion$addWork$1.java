package co.hyperverge.crashguard.services;

import android.content.Context;
import co.hyperverge.crashguard.data.models.CrashEvent;
import co.hyperverge.crashguard.data.repo.CrashEventsRepo;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "co.hyperverge.crashguard.services.CrashIntentService$Companion$addWork$1", f = "CrashIntentService.kt", l = {}, m = "invokeSuspend")
/* compiled from: CrashIntentService.kt */
public final class CrashIntentService$Companion$addWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CrashEvent $crashEvent;
    public final /* synthetic */ CrashEventsRepo $crashEventsRepo;
    public final /* synthetic */ boolean $enqueue;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CrashIntentService$Companion$addWork$1(CrashEventsRepo crashEventsRepo, CrashEvent crashEvent, boolean z, Context context, Continuation<? super CrashIntentService$Companion$addWork$1> continuation) {
        // this.$crashEventsRepo = crashEventsRepo;
        // this.$crashEvent = crashEvent;
        // this.$enqueue = z;
        // this.$context = context;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CrashIntentService$Companion$addWork$1 crashIntentService$Companion$addWork$1 = new CrashIntentService$Companion$addWork$1(this.$crashEventsRepo, this.$crashEvent, this.$enqueue, this.$context, continuation);
        return crashIntentService$Companion$addWork$1;
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        CrashIntentService$Companion$addWork$1 crashIntentService$Companion$addWork$1 = new CrashIntentService$Companion$addWork$1(this.$crashEventsRepo, this.$crashEvent, this.$enqueue, this.$context, (Continuation) obj2);
        return crashIntentService$Companion$addWork$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        TweetUtils.throwOnFailure(obj);
        this.$crashEventsRepo.addEvent(this.$crashEvent);
        if (this.$enqueue) {
            CrashIntentService.Companion.enqueuePending(this.$context);
        }
        return Unit.INSTANCE;
    }
}
