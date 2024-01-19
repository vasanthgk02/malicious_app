package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Database.kt */
public final class Database$unsafeDestroyEverything$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Database this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Database$unsafeDestroyEverything$1(Database database) {
        // this.this$0 = database;
        super(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r7 = this;
            com.nozbe.watermelondb.Database r0 = r7.this$0
            r1 = 0
            if (r0 == 0) goto L_0x0087
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = "select * from sqlite_master where type='table'"
            android.database.Cursor r0 = r0.rawQuery(r4, r3)
            r0.moveToFirst()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "name"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x0080 }
            r4 = -1
            if (r3 <= r4) goto L_0x002c
        L_0x001f:
            java.lang.String r4 = r0.getString(r3)     // Catch:{ all -> 0x0080 }
            r2.add(r4)     // Catch:{ all -> 0x0080 }
            boolean r4 = r0.moveToNext()     // Catch:{ all -> 0x0080 }
            if (r4 != 0) goto L_0x001f
        L_0x002c:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)
            com.nozbe.watermelondb.Database r0 = r7.this$0
            java.util.Iterator r2 = r2.iterator()
        L_0x0035:
            boolean r3 = r2.hasNext()
            r4 = 2
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "drop table if exists `"
            r5.append(r6)
            r5.append(r3)
            r3 = 96
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            com.nozbe.watermelondb.Database.execute$default(r0, r3, r1, r4)
            goto L_0x0035
        L_0x0061:
            com.nozbe.watermelondb.Database r0 = r7.this$0
            java.lang.String r2 = "pragma writable_schema=1"
            com.nozbe.watermelondb.Database.execute$default(r0, r2, r1, r4)
            com.nozbe.watermelondb.Database r0 = r7.this$0
            java.lang.String r2 = "delete from sqlite_master where type in ('table', 'index', 'trigger')"
            com.nozbe.watermelondb.Database.execute$default(r0, r2, r1, r4)
            com.nozbe.watermelondb.Database r0 = r7.this$0
            java.lang.String r2 = "pragma user_version=0"
            com.nozbe.watermelondb.Database.execute$default(r0, r2, r1, r4)
            com.nozbe.watermelondb.Database r0 = r7.this$0
            java.lang.String r2 = "pragma writable_schema=0"
            com.nozbe.watermelondb.Database.execute$default(r0, r2, r1, r4)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0080:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)
            throw r2
        L_0x0087:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.Database$unsafeDestroyEverything$1.invoke():java.lang.Object");
    }
}
