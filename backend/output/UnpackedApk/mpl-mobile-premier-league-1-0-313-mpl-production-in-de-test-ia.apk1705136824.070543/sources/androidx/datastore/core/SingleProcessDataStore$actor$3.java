package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "msg", "Landroidx/datastore/core/SingleProcessDataStore$Message;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$actor$3 extends SuspendLambda implements Function2<Message<T>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$actor$3> continuation) {
        // this.this$0 = singleProcessDataStore;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.this$0, continuation);
        singleProcessDataStore$actor$3.L$0 = obj;
        return singleProcessDataStore$actor$3;
    }

    public Object invoke(Object obj, Object obj2) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.this$0, (Continuation) obj2);
        singleProcessDataStore$actor$3.L$0 = (Message) obj;
        return singleProcessDataStore$actor$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001a
            if (r1 == r3) goto L_0x0015
            if (r1 != r2) goto L_0x000d
            goto L_0x0015
        L_0x000d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0015:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            goto L_0x0086
        L_0x001a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            androidx.datastore.core.SingleProcessDataStore$Message r5 = (androidx.datastore.core.SingleProcessDataStore.Message) r5
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.Message.Read
            if (r1 == 0) goto L_0x0075
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.this$0
            androidx.datastore.core.SingleProcessDataStore$Message$Read r5 = (androidx.datastore.core.SingleProcessDataStore.Message.Read) r5
            r4.label = r3
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r2 = r1.downstreamFlow
            java.lang.Object r2 = r2.getValue()
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            boolean r3 = r2 instanceof androidx.datastore.core.Data
            if (r3 == 0) goto L_0x0038
            goto L_0x0064
        L_0x0038:
            boolean r3 = r2 instanceof androidx.datastore.core.ReadException
            if (r3 == 0) goto L_0x004c
            androidx.datastore.core.State<T> r5 = r5.lastState
            if (r2 != r5) goto L_0x0064
            java.lang.Object r5 = r1.readAndInitOrPropagateFailure(r4)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 != r1) goto L_0x0049
            goto L_0x0066
        L_0x0049:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L_0x0066
        L_0x004c:
            androidx.datastore.core.UnInitialized r5 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r5 == 0) goto L_0x0060
            java.lang.Object r5 = r1.readAndInitOrPropagateFailure(r4)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 != r1) goto L_0x005d
            goto L_0x0066
        L_0x005d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L_0x0066
        L_0x0060:
            boolean r5 = r2 instanceof androidx.datastore.core.Final
            if (r5 != 0) goto L_0x0069
        L_0x0064:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x0066:
            if (r5 != r0) goto L_0x0086
            return r0
        L_0x0069:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Can't read in final state."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0075:
            boolean r1 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.Message.Update
            if (r1 == 0) goto L_0x0086
            androidx.datastore.core.SingleProcessDataStore<T> r1 = r4.this$0
            androidx.datastore.core.SingleProcessDataStore$Message$Update r5 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r5
            r4.label = r2
            java.lang.Object r5 = androidx.datastore.core.SingleProcessDataStore.access$handleUpdate(r1, r5, r4)
            if (r5 != r0) goto L_0x0086
            return r0
        L_0x0086:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$actor$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
