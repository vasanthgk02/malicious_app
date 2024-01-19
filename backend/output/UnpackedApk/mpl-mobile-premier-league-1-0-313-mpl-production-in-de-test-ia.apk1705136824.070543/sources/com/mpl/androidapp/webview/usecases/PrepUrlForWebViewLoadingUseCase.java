package com.mpl.androidapp.webview.usecases;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.mpl.androidapp.login.LoginReactModule;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.StartLoadingWebView;
import com.mpl.androidapp.webview.utils.custexceptions.CloseWebGameException;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u000020\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002JL\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001fH\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/mpl/androidapp/webview/usecases/PrepUrlForWebViewLoadingUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "data", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateBase64Data", "toString", "prepareEncodedUrl", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "dataStr", "isInternalRouteObjectSet", "", "internalRouteObject", "Lorg/json/JSONObject;", "lobbyId", "", "isSingleLaunch", "battleId", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepUrlForWebViewLoadingUseCase.kt */
public final class PrepUrlForWebViewLoadingUseCase extends SuspendUseCase<HashMap<String, Object>, UseCaseResult<? extends WebViewGameActivityStates>> {
    public final Context context;
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepUrlForWebViewLoadingUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    private final String generateBase64Data(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        if (VERSION.SDK_INT >= 26) {
            String encodeToString = Base64.getEncoder().encodeToString(bytes);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "{\n            Base64.get…ring(dataArray)\n        }");
            return encodeToString;
        }
        byte[] encode = android.util.Base64.encode(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(dataArray, android.util.Base64.DEFAULT)");
        Charset charset = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
        return new String(encode, charset);
    }

    /* access modifiers changed from: private */
    public final String prepareEncodedUrl(CancellableContinuation<? super UseCaseResult<? extends WebViewGameActivityStates>> cancellableContinuation, String str, boolean z, JSONObject jSONObject, int i, boolean z2, int i2) {
        String str2 = "";
        try {
            Object obj = new JSONObject(str).get("payload");
            if (obj != null) {
                JSONObject jSONObject2 = (JSONObject) obj;
                Object obj2 = jSONObject2.get(WebViewGameVm.KEY_REDIRECTION_URL);
                if (obj2 != null) {
                    String str3 = (String) obj2;
                    if (z) {
                        try {
                            jSONObject2.put(WebViewGameVm.KEY_INTERNAL_ROUTE_OBJECT, jSONObject);
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str3;
                            cancellableContinuation.resumeWith(TweetUtils.createFailure(new Exception(e.getMessage())));
                            return str2;
                        }
                    }
                    jSONObject2.put("platform", "android");
                    if (!z2) {
                        jSONObject2.put("lobbyId", i);
                        jSONObject2.put(WebViewGameVm.KEY_BATTLE_ID, i2);
                    }
                    String jSONObject3 = jSONObject2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "payloadResponse.toString()");
                    String generateBase64Data = generateBase64Data(jSONObject3);
                    if (str3.length() > 0) {
                        Builder appendQueryParameter = Uri.parse(str3).buildUpon().appendQueryParameter("info", generateBase64Data);
                        Intrinsics.checkNotNullExpressionValue(appendQueryParameter, LoginReactModule.RESULT);
                        MLogger.d("WebViewGames", Intrinsics.stringPlus("Final url: ", appendQueryParameter));
                        String builder = appendQueryParameter.toString();
                        Intrinsics.checkNotNullExpressionValue(builder, "result.toString()");
                        cancellableContinuation.resumeWith(new Success(new StartLoadingWebView(builder)));
                        return str3;
                    }
                    MLogger.d("WebViewGames", Intrinsics.stringPlus("Empty url: ", str3));
                    cancellableContinuation.resumeWith(TweetUtils.createFailure(new CloseWebGameException((String) "Redirection url is empty")));
                    return str3;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        } catch (Exception e3) {
            e = e3;
            cancellableContinuation.resumeWith(TweetUtils.createFailure(new Exception(e.getMessage())));
            return str2;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public Object execute(HashMap<String, Object> hashMap, Continuation<? super UseCaseResult<? extends WebViewGameActivityStates>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new PrepUrlForWebViewLoadingUseCase$execute$2$1(hashMap, this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
