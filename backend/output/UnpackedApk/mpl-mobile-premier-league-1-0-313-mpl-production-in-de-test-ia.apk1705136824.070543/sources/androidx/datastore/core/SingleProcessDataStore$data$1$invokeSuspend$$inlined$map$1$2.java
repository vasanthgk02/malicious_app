package androidx.datastore.core;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Collect.kt */
public final class SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2 implements FlowCollector<State<T>> {
    public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

    public SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2(FlowCollector flowCollector) {
        this.$this_unsafeFlow$inlined = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x004f
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow$inlined
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            boolean r2 = r5 instanceof androidx.datastore.core.ReadException
            if (r2 != 0) goto L_0x006d
            boolean r2 = r5 instanceof androidx.datastore.core.Final
            if (r2 != 0) goto L_0x0068
            boolean r2 = r5 instanceof androidx.datastore.core.Data
            if (r2 == 0) goto L_0x0052
            androidx.datastore.core.Data r5 = (androidx.datastore.core.Data) r5
            T r5 = r5.value
            r0.label = r3
            java.lang.Object r5 = r6.emit(r5, r0)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0052:
            boolean r5 = r5 instanceof androidx.datastore.core.UnInitialized
            if (r5 == 0) goto L_0x0062
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0062:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L_0x0068:
            androidx.datastore.core.Final r5 = (androidx.datastore.core.Final) r5
            java.lang.Throwable r5 = r5.finalException
            throw r5
        L_0x006d:
            androidx.datastore.core.ReadException r5 = (androidx.datastore.core.ReadException) r5
            java.lang.Throwable r5 = r5.readException
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
