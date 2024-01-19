package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$find$1 extends Lambda implements Function1<DatabaseDriver, Object> {
    public final /* synthetic */ String $id;
    public final /* synthetic */ String $table;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$find$1(String str, String str2) {
        // this.$table = str;
        // this.$id = str2;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r7) {
        /*
            r6 = this;
            com.nozbe.watermelondb.DatabaseDriver r7 = (com.nozbe.watermelondb.DatabaseDriver) r7
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r6.$table
            java.lang.String r1 = r6.$id
            java.lang.String r2 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r7.cachedRecords
            java.lang.Object r2 = r2.get(r0)
            java.util.List r2 = (java.util.List) r2
            r3 = 0
            if (r2 != 0) goto L_0x0022
            r2 = 0
            goto L_0x0026
        L_0x0022:
            boolean r2 = r2.contains(r1)
        L_0x0026:
            if (r2 == 0) goto L_0x0029
            goto L_0x005e
        L_0x0029:
            com.nozbe.watermelondb.Database r2 = r7.database
            java.lang.String r4 = "select * from `"
            java.lang.String r5 = "` where id == ? limit 1"
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r4, r0, r5)
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]
            r5[r3] = r1
            android.database.Cursor r2 = r2.rawQuery(r4, r5)
            int r3 = r2.getCount()     // Catch:{ all -> 0x005f }
            r4 = 0
            if (r3 > 0) goto L_0x0048
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r4)
            r1 = r4
            goto L_0x005e
        L_0x0048:
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x005f }
            r7.markAsCached(r0, r1)     // Catch:{ all -> 0x005f }
            r2.moveToFirst()     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "resultMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)     // Catch:{ all -> 0x005f }
            com.google.android.material.resources.TextAppearanceConfig.mapCursor(r3, r2)     // Catch:{ all -> 0x005f }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r4)
            r1 = r3
        L_0x005e:
            return r1
        L_0x005f:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r0 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseBridge$find$1.invoke(java.lang.Object):java.lang.Object");
    }
}
