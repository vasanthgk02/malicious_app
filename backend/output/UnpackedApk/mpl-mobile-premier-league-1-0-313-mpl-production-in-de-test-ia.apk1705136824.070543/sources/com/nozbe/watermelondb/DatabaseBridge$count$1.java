package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$count$1 extends Lambda implements Function1<DatabaseDriver, Object> {
    public final /* synthetic */ String $query;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$count$1(String str) {
        // this.$query = str;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r5) {
        /*
            r4 = this;
            com.nozbe.watermelondb.DatabaseDriver r5 = (com.nozbe.watermelondb.DatabaseDriver) r5
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r4.$query
            java.lang.String r1 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.nozbe.watermelondb.Database r5 = r5.database
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            r3 = 0
            if (r5 == 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            android.database.Cursor r5 = r5.rawQuery(r0, r2)
            r5.moveToFirst()     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = "count"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x0037 }
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0037 }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            return r5
        L_0x0037:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r0)
            throw r1
        L_0x003e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseBridge$count$1.invoke(java.lang.Object):java.lang.Object");
    }
}
