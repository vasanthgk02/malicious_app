package com.mpl.androidapp.share.services;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.share.services.GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1", f = "GenerateDeepLinkService.kt", l = {28}, m = "invokeSuspend")
/* compiled from: GenerateDeepLinkService.kt */
public final class GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>>, Object> {
    public final /* synthetic */ String $payload;
    public int label;
    public final /* synthetic */ GenerateDeepLinkService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1(GenerateDeepLinkService generateDeepLinkService, String str, Continuation<? super GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1> continuation) {
        // this.this$0 = generateDeepLinkService;
        // this.$payload = str;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1(this.this$0, this.$payload, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, String>> continuation) {
        return ((GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            GenerateDeepLinkService generateDeepLinkService = this.this$0;
            String str = this.$payload;
            this.label = 1;
            obj = generateDeepLinkService.generateDeepLink(str, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
