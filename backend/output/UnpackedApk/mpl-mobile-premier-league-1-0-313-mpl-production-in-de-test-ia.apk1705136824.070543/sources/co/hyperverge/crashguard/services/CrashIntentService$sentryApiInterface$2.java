package co.hyperverge.crashguard.services;

import co.hyperverge.crashguard.data.network.SentryApi;
import co.hyperverge.crashguard.data.network.SentryApi.Companion;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.jakewharton.retrofit2.converter.kotlinx.serialization.Serializer.FromString;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.Json.Default;
import okhttp3.MediaType;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit.Builder;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lco/hyperverge/crashguard/data/network/SentryApi;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashIntentService.kt */
public final class CrashIntentService$sentryApiInterface$2 extends Lambda implements Function0<SentryApi> {
    public static final CrashIntentService$sentryApiInterface$2 INSTANCE = new CrashIntentService$sentryApiInterface$2();

    public CrashIntentService$sentryApiInterface$2() {
        super(0);
    }

    public Object invoke() {
        if (SentryApi.Companion != null) {
            SentryApi sentryApi = Companion.INSTANCE;
            if (sentryApi != null) {
                return sentryApi;
            }
            Builder builder = new Builder();
            Default defaultR = Json.Default;
            MediaType parse = MediaType.parse(DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            Intrinsics.checkNotNull(parse);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(\"application/json\")!!");
            Intrinsics.checkNotNullParameter(defaultR, "$this$asConverterFactory");
            Intrinsics.checkNotNullParameter(parse, "contentType");
            builder.converterFactories.add((Factory) Objects.requireNonNull(new com.jakewharton.retrofit2.converter.kotlinx.serialization.Factory(parse, new FromString(defaultR)), "factory == null"));
            builder.baseUrl("https://hyperverge.co/");
            Object create = builder.build().create(SentryApi.class);
            Companion.INSTANCE = (SentryApi) create;
            Intrinsics.checkNotNullExpressionValue(create, "Builder()\n            .a…a).also { INSTANCE = it }");
            return (SentryApi) create;
        }
        throw null;
    }
}
