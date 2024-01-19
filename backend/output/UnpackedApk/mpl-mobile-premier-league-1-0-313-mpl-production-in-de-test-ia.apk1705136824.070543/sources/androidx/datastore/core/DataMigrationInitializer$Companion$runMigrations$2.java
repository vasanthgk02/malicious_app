package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H@"}, d2 = {"<anonymous>", "T", "startingData"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
/* compiled from: DataMigrationInitializer.kt */
public final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<T, Continuation<? super T>, Object> {
    public final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> $cleanUps;
    public final /* synthetic */ List<DataMigration<T>> $migrations;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2(List<? extends DataMigration<T>> list, List<Function1<Continuation<? super Unit>, Object>> list2, Continuation<? super DataMigrationInitializer$Companion$runMigrations$2> continuation) {
        // this.$migrations = list;
        // this.$cleanUps = list2;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    public Object invoke(Object obj, Object obj2) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, (Continuation) obj2);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r11.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0033
            if (r1 == r2) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            java.lang.Object r1 = r11.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r11.L$0
            java.util.List r4 = (java.util.List) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            goto L_0x0040
        L_0x0018:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0020:
            java.lang.Object r1 = r11.L$3
            java.lang.Object r4 = r11.L$2
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r11.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r11.L$0
            java.util.List r6 = (java.util.List) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            r7 = r11
            goto L_0x0066
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            java.util.List<androidx.datastore.core.DataMigration<T>> r1 = r11.$migrations
            java.util.List<kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r11.$cleanUps
            java.util.Iterator r1 = r1.iterator()
        L_0x0040:
            r5 = r11
        L_0x0041:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x008d
            java.lang.Object r6 = r1.next()
            androidx.datastore.core.DataMigration r6 = (androidx.datastore.core.DataMigration) r6
            r5.L$0 = r4
            r5.L$1 = r1
            r5.L$2 = r6
            r5.L$3 = r12
            r5.label = r2
            java.lang.Object r7 = r6.shouldMigrate(r12, r5)
            if (r7 != r0) goto L_0x005e
            return r0
        L_0x005e:
            r9 = r1
            r1 = r12
            r12 = r7
            r7 = r5
            r5 = r9
            r10 = r6
            r6 = r4
            r4 = r10
        L_0x0066:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0088
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r12 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r8 = 0
            r12.<init>(r4, r8)
            r6.add(r12)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.L$2 = r8
            r7.L$3 = r8
            r7.label = r3
            java.lang.Object r12 = r4.migrate(r1, r7)
            if (r12 != r0) goto L_0x0089
            return r0
        L_0x0088:
            r12 = r1
        L_0x0089:
            r1 = r5
            r4 = r6
            r5 = r7
            goto L_0x0041
        L_0x008d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
