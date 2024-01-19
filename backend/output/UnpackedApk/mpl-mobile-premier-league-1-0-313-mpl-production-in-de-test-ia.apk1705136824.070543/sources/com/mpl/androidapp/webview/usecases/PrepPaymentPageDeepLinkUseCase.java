package com.mpl.androidapp.webview.usecases;

import android.content.Context;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0019B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/webview/usecases/PrepPaymentPageDeepLinkUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "reactContainer", "Ljava/lang/Class;", "Lcom/mpl/androidapp/react/MPLReactContainerActivity;", "deepLinkPayment", "params", "Lorg/json/JSONObject;", "execute", "data", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareJsonParam", "amount", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepPaymentPageDeepLinkUseCase.kt */
public final class PrepPaymentPageDeepLinkUseCase extends SuspendUseCase<String, UseCaseResult<? extends WebViewGameActivityStates>> {
    public static final String ACTION_KEY = "action";
    public static final String ACTION_PARAMS_KEY = "actionParams";
    public static final String ACTION_TAKEN_KEY = "actionTaken";
    public static final String ACTION_TAKEN_PAYMENT_VALUE = "payment";
    public static final String ACTION_VALUE = "OPEN_DEEP_LINK";
    public static final Companion Companion = new Companion(null);
    public final Context context;
    public final CoroutineDispatcher dispatcher;
    public final Class<MPLReactContainerActivity> reactContainer = MPLReactContainerActivity.class;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/usecases/PrepPaymentPageDeepLinkUseCase$Companion;", "", "()V", "ACTION_KEY", "", "ACTION_PARAMS_KEY", "ACTION_TAKEN_KEY", "ACTION_TAKEN_PAYMENT_VALUE", "ACTION_VALUE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrepPaymentPageDeepLinkUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepPaymentPageDeepLinkUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final String deepLinkPayment(JSONObject jSONObject) {
        return "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"AddMoney\",\"param\":" + jSONObject + "}}";
    }

    /* access modifiers changed from: private */
    public final JSONObject prepareJsonParam(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("entryFee", str);
        jSONObject.put("amount", str);
        jSONObject.put("from", "fantasyPredication");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("startFor", "payment");
        jSONObject.put("game", jSONObject2);
        return jSONObject;
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public Object execute(String str, Continuation<? super UseCaseResult<? extends WebViewGameActivityStates>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new PrepPaymentPageDeepLinkUseCase$execute$2$1(str, this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
