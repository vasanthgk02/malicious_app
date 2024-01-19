package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", "T", "", "()V", "Companion", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DataMigrationInitializer.kt */
public final class DataMigrationInitializer<T> {
    public static final Companion Companion = new Companion(null);

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JY\u0010\u0003\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\b\u0001\u0010\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e0\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "()V", "getInitializer", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "T", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "migrations", "", "Landroidx/datastore/core/DataMigration;", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "runMigrations", "(Ljava/util/List;Landroidx/datastore/core/InitializerApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DataMigrationInitializer.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final java.lang.Object access$runMigrations(androidx.datastore.core.DataMigrationInitializer.Companion r5, java.util.List r6, androidx.datastore.core.InitializerApi r7, kotlin.coroutines.Continuation r8) {
            /*
                r0 = 0
                if (r5 == 0) goto L_0x009f
                boolean r1 = r8 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r1 == 0) goto L_0x0016
                r1 = r8
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r1 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0016
                int r2 = r2 - r3
                r1.label = r2
                goto L_0x001b
            L_0x0016:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r1.<init>(r5, r8)
            L_0x001b:
                java.lang.Object r5 = r1.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r1.label
                r3 = 1
                r4 = 2
                if (r2 == 0) goto L_0x0047
                if (r2 == r3) goto L_0x003f
                if (r2 != r4) goto L_0x0037
                java.lang.Object r6 = r1.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r1.L$0
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
                com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)     // Catch:{ all -> 0x0035 }
                goto L_0x006a
            L_0x0035:
                r5 = move-exception
                goto L_0x0083
            L_0x0037:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003f:
                java.lang.Object r6 = r1.L$0
                java.util.List r6 = (java.util.List) r6
                com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
                goto L_0x0060
            L_0x0047:
                com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r2.<init>(r6, r5, r0)
                r1.L$0 = r5
                r1.label = r3
                java.lang.Object r6 = r7.updateData(r2, r1)
                if (r6 != r8) goto L_0x005f
                goto L_0x009d
            L_0x005f:
                r6 = r5
            L_0x0060:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L_0x006a:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L_0x0095
                java.lang.Object r5 = r6.next()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r1.L$0 = r7     // Catch:{ all -> 0x0035 }
                r1.L$1 = r6     // Catch:{ all -> 0x0035 }
                r1.label = r4     // Catch:{ all -> 0x0035 }
                java.lang.Object r5 = r5.invoke(r1)     // Catch:{ all -> 0x0035 }
                if (r5 != r8) goto L_0x006a
                goto L_0x009d
            L_0x0083:
                T r0 = r7.element
                if (r0 != 0) goto L_0x008a
                r7.element = r5
                goto L_0x006a
            L_0x008a:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                T r0 = r7.element
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                com.twitter.sdk.android.tweetui.TweetUtils.addSuppressed(r0, r5)
                goto L_0x006a
            L_0x0095:
                T r5 = r7.element
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto L_0x009e
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
            L_0x009d:
                return r8
            L_0x009e:
                throw r5
            L_0x009f:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.access$runMigrations(androidx.datastore.core.DataMigrationInitializer$Companion, java.util.List, androidx.datastore.core.InitializerApi, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
