package com.mpl.androidapp.filehandling.downloadservice.features;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature$runFeature$1", f = "GenericFileDownloadFeature.kt", l = {71}, m = "invokeSuspend")
/* compiled from: GenericFileDownloadFeature.kt */
public final class GenericFileDownloadFeature$runFeature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ GenericFileDownloadFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GenericFileDownloadFeature$runFeature$1(GenericFileDownloadFeature genericFileDownloadFeature, Continuation<? super GenericFileDownloadFeature$runFeature$1> continuation) {
        // this.this$0 = genericFileDownloadFeature;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenericFileDownloadFeature$runFeature$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GenericFileDownloadFeature$runFeature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            GenericFileDownloadFeature genericFileDownloadFeature = this.this$0;
            this.label = 1;
            if (genericFileDownloadFeature.checkForConnectivity(this) == coroutineSingletons) {
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
