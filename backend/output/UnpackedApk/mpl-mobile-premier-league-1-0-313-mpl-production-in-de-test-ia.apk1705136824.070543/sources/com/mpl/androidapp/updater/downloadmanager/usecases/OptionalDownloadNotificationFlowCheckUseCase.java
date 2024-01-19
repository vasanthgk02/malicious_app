package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadNotificationFlowCheckUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "execute", "gameId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOptionalDownloadEnabled", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OptionalDownloadNotificationFlowCheckUseCase.kt */
public class OptionalDownloadNotificationFlowCheckUseCase extends SuspendUseCase<Integer, UseCaseResult<? extends QueryDownloadStates>> {
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OptionalDownloadNotificationFlowCheckUseCase(@IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.dispatcher = coroutineDispatcher;
    }

    public static Object execute$suspendImpl(OptionalDownloadNotificationFlowCheckUseCase optionalDownloadNotificationFlowCheckUseCase, int i, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(optionalDownloadNotificationFlowCheckUseCase.getDispatcher(), new OptionalDownloadNotificationFlowCheckUseCase$execute$2$1(optionalDownloadNotificationFlowCheckUseCase, i, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final boolean isOptionalDownloadEnabled(int i) {
        JSONArray jSONArray;
        boolean z;
        JSONObject normalConfig = ConfigManager.getNormalConfig();
        if (normalConfig == null) {
            jSONArray = null;
        } else {
            jSONArray = normalConfig.optJSONArray("assets.notification.enabled");
        }
        if (jSONArray != null) {
            JSONArray optJSONArray = normalConfig.optJSONArray("assets.notification.enabled");
            int i2 = 0;
            while (true) {
                if (optJSONArray == null || i2 >= optJSONArray.length()) {
                    break;
                } else if (i == optJSONArray.optInt(i2)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        return !z;
    }

    public Object execute(int i, Continuation<? super UseCaseResult<? extends QueryDownloadStates>> continuation) {
        return execute$suspendImpl(this, i, continuation);
    }

    public /* bridge */ /* synthetic */ Object execute(Object obj, Continuation continuation) {
        return execute(((Number) obj).intValue(), continuation);
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }
}
