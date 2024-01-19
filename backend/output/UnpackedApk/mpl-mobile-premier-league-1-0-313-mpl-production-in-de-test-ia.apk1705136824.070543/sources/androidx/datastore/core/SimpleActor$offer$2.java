package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
/* compiled from: SimpleActor.kt */
public final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object L$0;
    public int label;
    public final /* synthetic */ SimpleActor<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SimpleActor$offer$2(SimpleActor<T> simpleActor, Continuation<? super SimpleActor$offer$2> continuation) {
        // this.this$0 = simpleActor;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleActor$offer$2(this.this$0, continuation);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        return new SimpleActor$offer$2(this.this$0, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r3) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            r7 = r6
            goto L_0x005f
        L_0x0011:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0019:
            java.lang.Object r1 = r6.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            r4 = r1
            r1 = r7
            r7 = r6
            goto L_0x0053
        L_0x0024:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            androidx.datastore.core.SimpleActor<T> r7 = r6.this$0
            java.util.concurrent.atomic.AtomicInteger r7 = r7.remainingMessages
            int r7 = r7.get()
            if (r7 <= 0) goto L_0x0033
            r7 = 1
            goto L_0x0034
        L_0x0033:
            r7 = 0
        L_0x0034:
            if (r7 == 0) goto L_0x006c
            r7 = r6
        L_0x0037:
            androidx.datastore.core.SimpleActor<T> r1 = r7.this$0
            kotlinx.coroutines.CoroutineScope r1 = r1.scope
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.ensureActive(r1)
            androidx.datastore.core.SimpleActor<T> r1 = r7.this$0
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r1.consumeMessage
            kotlinx.coroutines.channels.Channel<T> r1 = r1.messageQueue
            r7.L$0 = r4
            r7.label = r3
            java.lang.Object r1 = r1.receive(r7)
            if (r1 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r5 = 0
            r7.L$0 = r5
            r7.label = r2
            java.lang.Object r1 = r4.invoke(r1, r7)
            if (r1 != r0) goto L_0x005f
            return r0
        L_0x005f:
            androidx.datastore.core.SimpleActor<T> r1 = r7.this$0
            java.util.concurrent.atomic.AtomicInteger r1 = r1.remainingMessages
            int r1 = r1.decrementAndGet()
            if (r1 != 0) goto L_0x0037
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x006c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
