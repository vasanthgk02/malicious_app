package com.mpl.androidapp.unity.usecases;

import com.google.gson.Gson;
import com.mpl.androidapp.unity.deepLink.ActionParams;
import com.mpl.androidapp.unity.deepLink.ActionPayload;
import com.mpl.androidapp.unity.deepLink.GameIdParam;
import com.mpl.androidapp.unity.deepLink.UnityUserProfileParam;
import com.mpl.androidapp.unity.models.UnityProfileParams;
import com.mpl.androidapp.unity.states.UnityViewProfileState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.ViewProfileDeepLink;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.usecases.UnityViewProfileUseCase$execute$2$1", f = "UnityViewProfileUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: UnityViewProfileUseCase.kt */
public final class UnityViewProfileUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends UnityViewProfileState>> $coroutine;
    public final /* synthetic */ UnityProfileParams $parameters;
    public int label;
    public final /* synthetic */ UnityViewProfileUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnityViewProfileUseCase$execute$2$1(UnityProfileParams unityProfileParams, UnityViewProfileUseCase unityViewProfileUseCase, CancellableContinuation<? super UseCaseResult<? extends UnityViewProfileState>> cancellableContinuation, Continuation<? super UnityViewProfileUseCase$execute$2$1> continuation) {
        // this.$parameters = unityProfileParams;
        // this.this$0 = unityViewProfileUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityViewProfileUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityViewProfileUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                int parseInt = Integer.parseInt(this.$parameters.getProfileId());
                int gameId = this.$parameters.getGameId();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "OPEN_DEEP_LINK");
                Gson access$getGson$p = this.this$0.gson;
                ActionPayload actionPayload = new ActionPayload("UserProfile", new UnityUserProfileParam(parseInt, ActionParams.ENTRY_UNITY_USER_PROFILE, ActionParams.ENTRY_FROM_MINI_PROFILE, new GameIdParam(gameId)), null, 4, null);
                jSONObject.put("actionParams", access$getGson$p.toJson((Object) new ActionParams("nav", actionPayload)));
                MLogger.d("UnitiyMiniProfile", Intrinsics.stringPlus("openProfile : ", jSONObject));
                this.$coroutine.resumeWith(new Success(new ViewProfileDeepLink("{\"notification_data\":" + jSONObject + '}')));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
