package co.hyperverge.crashguard.data.network;

import co.hyperverge.crashguard.data.models.CrashEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lco/hyperverge/crashguard/data/network/SentryApi;", "", "postCrashEvent", "Lretrofit2/Response;", "Lco/hyperverge/crashguard/data/network/SentryResponse;", "crashEvent", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "url", "", "sentryKey", "(Lco/hyperverge/crashguard/data/models/CrashEvent;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SentryApi.kt */
public interface SentryApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/network/SentryApi$Companion;", "", "()V", "INSTANCE", "Lco/hyperverge/crashguard/data/network/SentryApi;", "getInstance", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SentryApi.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static SentryApi INSTANCE;
    }

    @POST
    Object postCrashEvent(@Body CrashEvent crashEvent, @Url String str, @Query("sentry_key") String str2, Continuation<? super Response<SentryResponse>> continuation);
}
