package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import com.mpl.androidapp.cleanarch.core.utils.Resource;
import com.mpl.androidapp.cleanarch.core.utils.Resource.Error;
import com.mpl.androidapp.cleanarch.core.utils.Resource.Success;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$2", f = "UnityCrashSyncService.kt", l = {28}, m = "invokeSuspend")
/* compiled from: UnityCrashSyncService.kt */
public final class UnityCrashSyncService$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result>, Object> {
    public int label;
    public final /* synthetic */ UnityCrashSyncService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnityCrashSyncService$doWork$2(UnityCrashSyncService unityCrashSyncService, Continuation<? super UnityCrashSyncService$doWork$2> continuation) {
        // this.this$0 = unityCrashSyncService;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityCrashSyncService$doWork$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result> continuation) {
        return ((UnityCrashSyncService$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            SendUnityCrashFeature features = this.this$0.getFeatures();
            this.label = 1;
            obj = features.sendCrashEventToKafka(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Resource resource = (Resource) obj;
        if (resource instanceof Success) {
            return new Result.Success();
        }
        if (resource instanceof Error) {
            return new Failure();
        }
        return new Failure();
    }
}
