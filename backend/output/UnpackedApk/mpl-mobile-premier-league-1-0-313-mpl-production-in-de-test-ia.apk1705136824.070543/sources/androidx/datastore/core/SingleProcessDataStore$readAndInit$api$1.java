package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JD\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$readAndInit$api$1 implements InitializerApi<T> {
    public final /* synthetic */ Ref$ObjectRef<T> $initData;
    public final /* synthetic */ Ref$BooleanRef $initializationComplete;
    public final /* synthetic */ Mutex $updateLock;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    public SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<T> ref$ObjectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.$updateLock = mutex;
        this.$initializationComplete = ref$BooleanRef;
        this.$initData = ref$ObjectRef;
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7 A[Catch:{ all -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d8 A[SYNTHETIC, Splitter:B:48:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateData(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r11, kotlin.coroutines.Continuation<? super T> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0070
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r11 = r0.L$2
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)     // Catch:{ all -> 0x0039 }
            goto L_0x00c9
        L_0x0039:
            r11 = move-exception
            goto L_0x00d4
        L_0x003c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0044:
            java.lang.Object r11 = r0.L$2
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)     // Catch:{ all -> 0x0054 }
            goto L_0x00af
        L_0x0054:
            r11 = move-exception
            goto L_0x00d6
        L_0x0057:
            java.lang.Object r11 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore r11 = (androidx.datastore.core.SingleProcessDataStore) r11
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref$BooleanRef) r5
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            r12 = r7
            goto L_0x0093
        L_0x0070:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r10.$updateLock
            kotlin.jvm.internal.Ref$BooleanRef r2 = r10.$initializationComplete
            kotlin.jvm.internal.Ref$ObjectRef<T> r7 = r10.$initData
            androidx.datastore.core.SingleProcessDataStore<T> r8 = r10.this$0
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r8
            r0.label = r5
            java.lang.Object r5 = r12.lock(r6, r0)
            if (r5 != r1) goto L_0x008e
            return r1
        L_0x008e:
            r5 = r2
            r2 = r7
            r9 = r8
            r8 = r11
            r11 = r9
        L_0x0093:
            boolean r5 = r5.element     // Catch:{ all -> 0x00e0 }
            if (r5 != 0) goto L_0x00d8
            T r5 = r2.element     // Catch:{ all -> 0x00e0 }
            r0.L$0 = r12     // Catch:{ all -> 0x00e0 }
            r0.L$1 = r2     // Catch:{ all -> 0x00e0 }
            r0.L$2 = r11     // Catch:{ all -> 0x00e0 }
            r0.L$3 = r6     // Catch:{ all -> 0x00e0 }
            r0.L$4 = r6     // Catch:{ all -> 0x00e0 }
            r0.label = r4     // Catch:{ all -> 0x00e0 }
            java.lang.Object r4 = r8.invoke(r5, r0)     // Catch:{ all -> 0x00e0 }
            if (r4 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r9 = r4
            r4 = r12
            r12 = r9
        L_0x00af:
            T r5 = r2.element     // Catch:{ all -> 0x0054 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r5)     // Catch:{ all -> 0x0054 }
            if (r5 != 0) goto L_0x00cd
            r0.L$0 = r4     // Catch:{ all -> 0x0054 }
            r0.L$1 = r2     // Catch:{ all -> 0x0054 }
            r0.L$2 = r12     // Catch:{ all -> 0x0054 }
            r0.label = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r11 = r11.writeData$datastore_core(r12, r0)     // Catch:{ all -> 0x0054 }
            if (r11 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            r11 = r12
            r1 = r2
            r0 = r4
        L_0x00c9:
            r1.element = r11     // Catch:{ all -> 0x0039 }
            r2 = r1
            goto L_0x00ce
        L_0x00cd:
            r0 = r4
        L_0x00ce:
            T r11 = r2.element     // Catch:{ all -> 0x0039 }
            r0.unlock(r6)
            return r11
        L_0x00d4:
            r12 = r0
            goto L_0x00e1
        L_0x00d6:
            r12 = r4
            goto L_0x00e1
        L_0x00d8:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = "InitializerApi.updateData should not be called after initialization is complete."
            r11.<init>(r0)     // Catch:{ all -> 0x00e0 }
            throw r11     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r11 = move-exception
        L_0x00e1:
            r12.unlock(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1.updateData(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
