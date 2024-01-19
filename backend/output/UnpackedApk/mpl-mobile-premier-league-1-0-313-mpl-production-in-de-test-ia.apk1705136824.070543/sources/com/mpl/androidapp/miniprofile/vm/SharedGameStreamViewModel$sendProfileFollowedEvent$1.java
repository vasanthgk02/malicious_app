package com.mpl.androidapp.miniprofile.vm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$sendProfileFollowedEvent$1", f = "SharedGameStreamViewModel.kt", l = {}, m = "invokeSuspend")
/* compiled from: SharedGameStreamViewModel.kt */
public final class SharedGameStreamViewModel$sendProfileFollowedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $entryPoint;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SharedGameStreamViewModel$sendProfileFollowedEvent$1(String str, Continuation<? super SharedGameStreamViewModel$sendProfileFollowedEvent$1> continuation) {
        // this.$entryPoint = str;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharedGameStreamViewModel$sendProfileFollowedEvent$1(this.$entryPoint, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SharedGameStreamViewModel$sendProfileFollowedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            new HashMap().put("Entry Point", this.$entryPoint);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
