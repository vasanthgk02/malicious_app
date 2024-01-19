package com.nozbe.watermelondb;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/nozbe/watermelondb/DatabaseDriver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$query$1 extends Lambda implements Function1<DatabaseDriver, Object> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ String $table;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$query$1(String str, String str2) {
        // this.$table = str;
        // this.$query = str2;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r9) {
        /*
            r8 = this;
            com.nozbe.watermelondb.DatabaseDriver r9 = (com.nozbe.watermelondb.DatabaseDriver) r9
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = r8.$table
            java.lang.String r1 = r8.$query
            java.lang.String r2 = "id"
            java.lang.String r3 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            com.facebook.react.bridge.WritableArray r3 = com.facebook.react.bridge.Arguments.createArray()
            com.nozbe.watermelondb.Database r4 = r9.database
            r5 = 0
            r6 = 2
            android.database.Cursor r1 = com.nozbe.watermelondb.Database.rawQuery$default(r4, r1, r5, r6)
            int r4 = r1.getCount()     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "resultArray"
            if (r4 <= 0) goto L_0x0077
            java.lang.String[] r4 = r1.getColumnNames()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "it.columnNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)     // Catch:{ all -> 0x007e }
            boolean r4 = com.twitter.sdk.android.tweetui.TweetUtils.contains(r4, r2)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0077
        L_0x003a:
            boolean r4 = r1.moveToNext()     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0077
            int r4 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ all -> 0x007e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch:{ all -> 0x007e }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r9.cachedRecords     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x007e }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x0057
            r7 = 0
            goto L_0x005b
        L_0x0057:
            boolean r7 = r7.contains(r4)     // Catch:{ all -> 0x007e }
        L_0x005b:
            if (r7 == 0) goto L_0x0061
            r3.pushString(r4)     // Catch:{ all -> 0x007e }
            goto L_0x003a
        L_0x0061:
            r9.markAsCached(r0, r4)     // Catch:{ all -> 0x007e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch:{ all -> 0x007e }
            com.facebook.react.bridge.WritableMap r4 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "cursorMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)     // Catch:{ all -> 0x007e }
            com.google.android.material.resources.TextAppearanceConfig.mapCursor(r4, r1)     // Catch:{ all -> 0x007e }
            r3.pushMap(r4)     // Catch:{ all -> 0x007e }
            goto L_0x003a
        L_0x0077:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            return r3
        L_0x007e:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r0 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseBridge$query$1.invoke(java.lang.Object):java.lang.Object");
    }
}
