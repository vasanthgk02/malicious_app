package com.mpl.androidapp.unity.usecases;

import android.content.Context;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import com.mpl.androidapp.unity.models.UnitySendEventGameParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.engine.MHeader;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001(B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J(\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002JD\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030%2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/mpl/androidapp/unity/usecases/SendEventForGamesUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/unity/models/UnitySendEventGameParams;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "parameters", "(Lcom/mpl/androidapp/unity/models/UnitySendEventGameParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessToken", "", "gameConfigJson", "getNetworkCallParamsBuilder", "Lcom/mpl/androidapp/utils/NetworkCallParams;", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "requestBody", "Lorg/json/JSONArray;", "url", "prepareHeader", "prepareRequestBody", "event", "eventProp", "sendEventToServerothergames", "", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "callback", "Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendEventForGamesUseCase.kt */
public final class SendEventForGamesUseCase extends SuspendUseCase<UnitySendEventGameParams, UseCaseResult<? extends MPLUnityFeaturesState>> {
    public static final Companion Companion = new Companion(null);
    public static final String tag = "SendEventForGamesUseCase";
    public Context context;
    public final CoroutineDispatcher dispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/unity/usecases/SendEventForGamesUseCase$Companion;", "", "()V", "tag", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendEventForGamesUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SendEventForGamesUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    private final NetworkCallParams getNetworkCallParamsBuilder(List<MHeader> list, JSONArray jSONArray, String str) {
        Builder builder = new Builder();
        builder.setUrl(Intrinsics.stringPlus(MBuildConfigUtils.getMainUrl(), str));
        builder.setConnectionTimeOut(10000);
        builder.setWriteTimeOut(10000);
        builder.setReadTimeOut(10000);
        builder.setMHeaders(list);
        builder.setRetryOption(true);
        builder.setMRequestBody(jSONArray.toString());
        return builder.build();
    }

    private final List<MHeader> prepareHeader(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        arrayList.add(new MHeader("Authorization", Intrinsics.stringPlus("Bearer ", new JSONObject(str).optString(GameConstant.AUTH_TOKEN, ""))));
        return arrayList;
    }

    private final JSONArray prepareRequestBody(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject(str2);
        jSONObject2.put(EventsConstants.APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
        jSONObject2.put(EventsConstants.APP_VERSION_NAME, MBuildConfigUtils.getCurrentAppVersionName().toString());
        jSONObject2.put(EventsConstants.ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
        jSONObject.put(str, str2);
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    /* access modifiers changed from: private */
    public final boolean sendEventToServerothergames(CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, String str, String str2, String str3, String str4, GameEventCallback gameEventCallback) {
        MLogger.d("SendEventForGames", "sendEventTO server called", str);
        try {
            NetworkCallParams networkCallParamsBuilder = getNetworkCallParamsBuilder(prepareHeader(str3), prepareRequestBody(str, str2), str4);
            if (networkCallParamsBuilder != null) {
                SendEventForGamesUseCase$sendEventToServerothergames$1$1 sendEventForGamesUseCase$sendEventToServerothergames$1$1 = new SendEventForGamesUseCase$sendEventToServerothergames$1$1(this, gameEventCallback, cancellableContinuation, str, str2);
                NetworkUtils.doPostRequest(networkCallParamsBuilder, sendEventForGamesUseCase$sendEventToServerothergames$1$1, "server_Event");
            }
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
            cancellableContinuation.resumeWith(new Error(new Exception(e2.getMessage())));
        }
        return false;
    }

    public final String getAccessToken(String str) {
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            if (accessUserToken != null) {
                return accessUserToken;
            }
            return new JSONObject(str).optString(GameConstant.AUTH_TOKEN, "");
        } catch (Exception unused) {
            return "";
        }
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

    public Object execute(UnitySendEventGameParams unitySendEventGameParams, Continuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new SendEventForGamesUseCase$execute$2$1(unitySendEventGameParams, this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
