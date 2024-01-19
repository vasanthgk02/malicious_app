package com.mpl.androidapp.unity.usecases;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.mpl.androidapp.unity.models.CrashParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001!B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/mpl/androidapp/unity/usecases/LogCrashAnalyticsUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/unity/models/CrashParams;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "parameters", "(Lcom/mpl/androidapp/unity/models/CrashParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isGameIdExists", "", "jsonArray", "Lorg/json/JSONArray;", "gameId", "", "loadJSONFromAsset", "logCrashlytics", "", "msg", "stacktrace", "logToCrashlytics", "message", "prepareMessage", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LogCrashAnalyticsUseCase.kt */
public final class LogCrashAnalyticsUseCase extends SuspendUseCase<CrashParams, UseCaseResult<? extends MPLUnityFeaturesState>> {
    public static final Companion Companion = new Companion(null);
    public static final String GAME_CONFIG_JSON_PATH = "game/game_config.json";
    public static final String GAME_ID_ARRAY = "game_code_id";
    public static final String PROFILE_ID_NULL = "Profile id is null";
    public static final String tag_crash = "LogCrashAnalyticsUseCase";
    public Context context;
    public final CoroutineDispatcher dispatcher;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/unity/usecases/LogCrashAnalyticsUseCase$Companion;", "", "()V", "GAME_CONFIG_JSON_PATH", "", "GAME_ID_ARRAY", "PROFILE_ID_NULL", "tag_crash", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LogCrashAnalyticsUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LogCrashAnalyticsUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    private final boolean isGameIdExists(JSONArray jSONArray, String str) {
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        return CharsKt__CharKt.contains$default((CharSequence) jSONArray2, (CharSequence) str, false, 2);
    }

    private final String loadJSONFromAsset() {
        try {
            InputStream open = this.context.getAssets().open(GAME_CONFIG_JSON_PATH);
            Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(GAME_CONFIG_JSON_PATH)");
            byte[] bArr = new byte[open.available()];
            Charset charset = Charsets.UTF_8;
            open.read(bArr);
            open.close();
            return new String(bArr, charset);
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final void logCrashlytics(String str, String str2, String str3) {
        try {
            MLogger.e(tag_crash, "logCrashlytics:called " + str + "stacktrace" + str2 + "gameid" + str3);
            if (!TextUtils.isEmpty(str3)) {
                String prepareMessage = prepareMessage(str3, str, str2);
                JSONArray jSONArray = new JSONObject(loadJSONFromAsset()).getJSONArray("game_code_id");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "gameList");
                boolean isGameIdExists = isGameIdExists(jSONArray, str3);
                logToCrashlytics(prepareMessage);
                return;
            }
            logToCrashlytics("");
        } catch (Exception e2) {
            MLogger.e(tag_crash, "logCrashlytics: ", e2);
        }
    }

    private final void logToCrashlytics(String str) {
        try {
            FirebaseCrashlytics.getInstance().recordException(new Exception(str));
        } catch (Exception e2) {
            MLogger.e(tag_crash, "logCrashlytics: ", e2);
        }
    }

    private final String prepareMessage(String str, String str2, String str3) {
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("\n                        Playing game Id: ", str, "\n                        Message: ", str2, "\n                        Stacktrace: ");
        outline82.append(str3);
        outline82.append("\n                        ");
        return CharsKt__CharKt.trimIndent(outline82.toString());
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public Object execute(CrashParams crashParams, Continuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new LogCrashAnalyticsUseCase$execute$2$1(this, crashParams, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
