package com.mpl.androidapp.unity.features;

import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.GenericFileDownloadFeatureCallback;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
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
@DebugMetadata(c = "com.mpl.androidapp.unity.features.MplUnityFeatures$genericFileDownloadFeature$1", f = "MplUnityFeatures.kt", l = {}, m = "invokeSuspend")
/* compiled from: MplUnityFeatures.kt */
public final class MplUnityFeatures$genericFileDownloadFeature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ FeatureFileDownloadInput $featureFileDownloadInput;
    public final /* synthetic */ GenericFileDownloadFeatureCallback $view;
    public int label;
    public final /* synthetic */ MplUnityFeatures this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplUnityFeatures$genericFileDownloadFeature$1(MplUnityFeatures mplUnityFeatures, FeatureFileDownloadInput featureFileDownloadInput, GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback, Continuation<? super MplUnityFeatures$genericFileDownloadFeature$1> continuation) {
        // this.this$0 = mplUnityFeatures;
        // this.$featureFileDownloadInput = featureFileDownloadInput;
        // this.$view = genericFileDownloadFeatureCallback;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MplUnityFeatures$genericFileDownloadFeature$1(this.this$0, this.$featureFileDownloadInput, this.$view, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MplUnityFeatures$genericFileDownloadFeature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            this.this$0.genericFileDownload(this.$featureFileDownloadInput, this.$view);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
