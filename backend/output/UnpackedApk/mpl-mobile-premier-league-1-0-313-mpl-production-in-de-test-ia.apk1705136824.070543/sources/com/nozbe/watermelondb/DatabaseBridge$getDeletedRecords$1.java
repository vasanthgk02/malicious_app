package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$getDeletedRecords$1 extends Lambda implements Function1<DatabaseDriver, Object> {
    public final /* synthetic */ String $table;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$getDeletedRecords$1(String str) {
        // this.$table = str;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r7) {
        /*
            r6 = this;
            com.nozbe.watermelondb.DatabaseDriver r7 = (com.nozbe.watermelondb.DatabaseDriver) r7
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r6.$table
            java.lang.String r1 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.facebook.react.bridge.WritableArray r2 = com.facebook.react.bridge.Arguments.createArray()
            com.nozbe.watermelondb.Database r7 = r7.database
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "select id from `"
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = "` where _status='deleted'"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 2
            r3 = 0
            android.database.Cursor r7 = com.nozbe.watermelondb.Database.rawQuery$default(r7, r0, r3, r1)
            r7.moveToFirst()     // Catch:{ all -> 0x0054 }
            int r0 = r7.getCount()     // Catch:{ all -> 0x0054 }
            r1 = 0
            r4 = 0
        L_0x003c:
            if (r4 >= r0) goto L_0x004b
            int r4 = r4 + 1
            java.lang.String r5 = r7.getString(r1)     // Catch:{ all -> 0x0054 }
            r2.pushString(r5)     // Catch:{ all -> 0x0054 }
            r7.moveToNext()     // Catch:{ all -> 0x0054 }
            goto L_0x003c
        L_0x004b:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r3)
            java.lang.String r7 = "resultArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            return r2
        L_0x0054:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseBridge$getDeletedRecords$1.invoke(java.lang.Object):java.lang.Object");
    }
}
