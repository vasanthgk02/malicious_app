package co.hyperverge.crashguard.services;

import android.util.Log;
import co.hyperverge.crashguard.data.models.CrashEvent;
import co.hyperverge.crashguard.data.network.SentryApi;
import co.hyperverge.crashguard.data.network.SentryErrorResponse;
import co.hyperverge.crashguard.data.network.SentryResponse;
import co.hyperverge.crashguard.data.repo.CrashEventsRepo;
import co.hyperverge.crashguard.data.repo.PrefsRepo;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.Json.Default;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "co.hyperverge.crashguard.services.CrashIntentService$onHandleWork$1", f = "CrashIntentService.kt", l = {47}, m = "invokeSuspend")
/* compiled from: CrashIntentService.kt */
public final class CrashIntentService$onHandleWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Integer>>, Object> {
    public final /* synthetic */ CrashEvent $crashEvent;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ CrashIntentService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CrashIntentService$onHandleWork$1(CrashIntentService crashIntentService, CrashEvent crashEvent, Continuation<? super CrashIntentService$onHandleWork$1> continuation) {
        // this.this$0 = crashIntentService;
        // this.$crashEvent = crashEvent;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CrashIntentService$onHandleWork$1 crashIntentService$onHandleWork$1 = new CrashIntentService$onHandleWork$1(this.this$0, this.$crashEvent, continuation);
        crashIntentService$onHandleWork$1.L$0 = obj;
        return crashIntentService$onHandleWork$1;
    }

    public Object invoke(Object obj, Object obj2) {
        CrashIntentService$onHandleWork$1 crashIntentService$onHandleWork$1 = new CrashIntentService$onHandleWork$1(this.this$0, this.$crashEvent, (Continuation) obj2);
        crashIntentService$onHandleWork$1.L$0 = (CoroutineScope) obj;
        return crashIntentService$onHandleWork$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CrashIntentService crashIntentService = this.this$0;
            CrashEvent crashEvent = this.$crashEvent;
            PrefsRepo prefsRepo = (PrefsRepo) crashIntentService.prefsRepo$delegate.getValue();
            PrefsRepo prefsRepo2 = (PrefsRepo) crashIntentService.prefsRepo$delegate.getValue();
            this.label = 1;
            obj = ((SentryApi) crashIntentService.sentryApiInterface$delegate.getValue()).postCrashEvent(crashEvent, (String) prefsRepo.sentryEndpointUrl$delegate.getValue(prefsRepo, PrefsRepo.$$delegatedProperties[0]), (String) prefsRepo2.sentryKey$delegate.getValue(prefsRepo2, PrefsRepo.$$delegatedProperties[1]), this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i2 == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Throwable th) {
                obj2 = TweetUtils.createFailure(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) obj;
        if (response.isSuccessful()) {
            i = Log.i(CrashIntentService.TAG, Intrinsics.stringPlus("onHandleWork: success posting event: ", (SentryResponse) response.body));
        } else {
            Default defaultR = Json.Default;
            i = Log.e(CrashIntentService.TAG, Intrinsics.stringPlus("onHandleWork: failed posting event: ", (SentryErrorResponse) defaultR.decodeFromString(TypeUtilsKt.serializer(defaultR.serializersModule, Reflection.typeOf(SentryErrorResponse.class)), String.valueOf(response.errorBody))));
        }
        obj2 = new Integer(i);
        CrashEvent crashEvent2 = this.$crashEvent;
        CrashIntentService crashIntentService2 = this.this$0;
        if (Result.m884exceptionOrNullimpl(obj2) != null) {
            String str = CrashIntentService.TAG;
            "onHandleWork: failed with e: " + r2 + " for event " + crashEvent2;
            ((CrashEventsRepo) crashIntentService2.crashEventsRepo$delegate.getValue()).addEvent(crashEvent2);
        }
        return new Result(obj2);
    }
}
