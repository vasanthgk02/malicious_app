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
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.share.services.GenerateDeepLinkService$appFlyersApiService$2", f = "GenerateDeepLinkService.kt", l = {28}, m = "invokeSuspend")
/* compiled from: GenerateDeepLinkService.kt */
public final class GenerateDeepLinkService$appFlyersApiService$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ GenerateDeepLinkServiceImpl $callback;
    public final /* synthetic */ String $payload;
    public int label;
    public final /* synthetic */ GenerateDeepLinkService this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GenerateDeepLinkService$appFlyersApiService$2(GenerateDeepLinkServiceImpl generateDeepLinkServiceImpl, GenerateDeepLinkService generateDeepLinkService, String str, Continuation<? super GenerateDeepLinkService$appFlyersApiService$2> continuation) {
        // this.$callback = generateDeepLinkServiceImpl;
        // this.this$0 = generateDeepLinkService;
        // this.$payload = str;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenerateDeepLinkService$appFlyersApiService$2(this.$callback, this.this$0, this.$payload, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GenerateDeepLinkService$appFlyersApiService$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.Default;
            GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1 generateDeepLinkService$appFlyersApiService$2$externalDeepLink$1 = new GenerateDeepLinkService$appFlyersApiService$2$externalDeepLink$1(this.this$0, this.$payload, null);
            this.label = 1;
            obj = TypeUtilsKt.withContext(coroutineDispatcher, generateDeepLinkService$appFlyersApiService$2$externalDeepLink$1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        if (((Boolean) pair.first).booleanValue()) {
            String str = (String) pair.second;
            GenerateDeepLinkServiceImpl generateDeepLinkServiceImpl = this.$callback;
            if (generateDeepLinkServiceImpl != null) {
                generateDeepLinkServiceImpl.deepLinkApiSuccess(str);
            }
        } else {
            GenerateDeepLinkServiceImpl generateDeepLinkServiceImpl2 = this.$callback;
            if (generateDeepLinkServiceImpl2 != null) {
                generateDeepLinkServiceImpl2.deepLinkApiFailure((String) pair.second);
            }
        }
        return Unit.INSTANCE;
    }
}
