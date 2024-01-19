package com.mpl.androidapp.webview.usecases;

import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.utils.WebFlowGameConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.usecases.PrepUrlForWebViewLoadingUseCase$execute$2$1", f = "PrepUrlForWebViewLoadingUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: PrepUrlForWebViewLoadingUseCase.kt */
public final class PrepUrlForWebViewLoadingUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends WebViewGameActivityStates>> $coroutine;
    public final /* synthetic */ HashMap<String, Object> $data;
    public int label;
    public final /* synthetic */ PrepUrlForWebViewLoadingUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepUrlForWebViewLoadingUseCase$execute$2$1(HashMap<String, Object> hashMap, PrepUrlForWebViewLoadingUseCase prepUrlForWebViewLoadingUseCase, CancellableContinuation<? super UseCaseResult<? extends WebViewGameActivityStates>> cancellableContinuation, Continuation<? super PrepUrlForWebViewLoadingUseCase$execute$2$1> continuation) {
        // this.$data = hashMap;
        // this.this$0 = prepUrlForWebViewLoadingUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepUrlForWebViewLoadingUseCase$execute$2$1(this.$data, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrepUrlForWebViewLoadingUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                Object obj2 = this.$data.get(WebFlowGameConstants.IS_INTERNAL_ROUTE_OBJECT_SET);
                if (obj2 != null) {
                    boolean booleanValue = ((Boolean) obj2).booleanValue();
                    Object obj3 = this.$data.get(WebFlowGameConstants.INTERNAL_ROUTE_OBJECT);
                    if (obj3 != null) {
                        JSONObject jSONObject = (JSONObject) obj3;
                        Object obj4 = this.$data.get(WebFlowGameConstants.API_RESPONSE_OBJECT);
                        if (obj4 != null) {
                            String str = (String) obj4;
                            Object obj5 = this.$data.get(WebFlowGameConstants.API_LOBBY_ID);
                            if (obj5 != null) {
                                int intValue = ((Integer) obj5).intValue();
                                Object obj6 = this.$data.get(WebFlowGameConstants.API_BATTLE_ID);
                                if (obj6 != null) {
                                    int intValue2 = ((Integer) obj6).intValue();
                                    Object obj7 = this.$data.get(WebFlowGameConstants.API_IS_SINGLE_LAUNCH);
                                    if (obj7 != null) {
                                        this.this$0.prepareEncodedUrl(this.$coroutine, str, booleanValue, jSONObject, intValue, ((Boolean) obj7).booleanValue(), intValue2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
