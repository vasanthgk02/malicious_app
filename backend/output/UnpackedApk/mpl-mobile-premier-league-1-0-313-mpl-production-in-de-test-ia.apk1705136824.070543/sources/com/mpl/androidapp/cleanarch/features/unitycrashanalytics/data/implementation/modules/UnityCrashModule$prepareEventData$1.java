package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule$prepareEventData$1", f = "UnityCrashModule.kt", l = {121}, m = "invokeSuspend")
/* compiled from: UnityCrashModule.kt */
public final class UnityCrashModule$prepareEventData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $battleId;
    public final /* synthetic */ String $crashMessage;
    public final /* synthetic */ String $gameConfigInput;
    public final /* synthetic */ boolean $isCrashTriggered;
    public int label;
    public final /* synthetic */ UnityCrashModule this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnityCrashModule$prepareEventData$1(String str, String str2, UnityCrashModule unityCrashModule, boolean z, String str3, Continuation<? super UnityCrashModule$prepareEventData$1> continuation) {
        // this.$battleId = str;
        // this.$crashMessage = str2;
        // this.this$0 = unityCrashModule;
        // this.$isCrashTriggered = z;
        // this.$gameConfigInput = str3;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UnityCrashModule$prepareEventData$1 unityCrashModule$prepareEventData$1 = new UnityCrashModule$prepareEventData$1(this.$battleId, this.$crashMessage, this.this$0, this.$isCrashTriggered, this.$gameConfigInput, continuation);
        return unityCrashModule$prepareEventData$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityCrashModule$prepareEventData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            JSONObject jSONObject = new JSONObject();
            boolean z = this.$isCrashTriggered;
            String str = this.$gameConfigInput;
            jSONObject.put(UnityCrashModule.KEY_CRASH_TRIGGERED, z);
            jSONObject.put("data", new JSONObject(str));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …             }.toString()");
            UnityCrashData unityCrashData = new UnityCrashData(0, this.$battleId, jSONObject2, this.$crashMessage, 1, null);
            UnityCrashDbServiceImpl unityCrashDbServiceImpl = this.this$0.getUnityCrashDbServiceImpl();
            this.label = 1;
            if (unityCrashDbServiceImpl.insertUnityCrashData(unityCrashData, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
