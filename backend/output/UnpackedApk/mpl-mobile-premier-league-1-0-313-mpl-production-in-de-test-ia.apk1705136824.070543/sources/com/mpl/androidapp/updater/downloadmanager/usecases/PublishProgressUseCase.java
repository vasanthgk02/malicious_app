package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.content.Context;
import android.os.Bundle;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.util.UpdaterConstant.Event;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/PublishProgressUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/data/PublishProgressParams;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "checkCode", "", "progress", "execute", "publishProgressParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/PublishProgressParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishTheProgress", "", "id", "isProgressComplete", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishProgressUseCase.kt */
public class PublishProgressUseCase extends SuspendUseCase<PublishProgressParams, UseCaseResult<? extends QueryDownloadStates>> {
    public Context context;
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PublishProgressUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    private final int checkCode(int i) {
        return i == -3333 ? 23 : 3;
    }

    public static Object execute$suspendImpl(PublishProgressUseCase publishProgressUseCase, PublishProgressParams publishProgressParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(publishProgressUseCase.getDispatcher(), new PublishProgressUseCase$execute$2$1(publishProgressParams, publishProgressUseCase, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final void publishTheProgress(int i, int i2, boolean z) {
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        try {
            MLogger.d("DownloadOfAssets", "publishProgress() called with: id = [" + i + "], progress = [" + i2 + ']');
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i);
            jSONObject.put("progress", i2);
            Bundle bundle = new Bundle();
            bundle.putString(Event.DOWNLOADED_ASSETS_DATA, jSONObject.toString());
            EventPublishHelper.publishAssetsBundleDownloadedStatusEvent(this.context, bundle);
            if (z) {
                return;
            }
            if (downloadProgressReceiver != null) {
                downloadProgressReceiver.send(checkCode(i2), bundle);
            }
        } catch (Exception e2) {
            MLogger.e("DownloadOfAssets", "", e2);
        }
    }

    public Object execute(PublishProgressParams publishProgressParams, Continuation<? super UseCaseResult<? extends QueryDownloadStates>> continuation) {
        return execute$suspendImpl(this, publishProgressParams, continuation);
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
}
