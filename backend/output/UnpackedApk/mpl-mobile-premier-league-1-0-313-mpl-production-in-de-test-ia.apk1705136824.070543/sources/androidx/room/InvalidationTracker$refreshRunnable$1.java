package androidx.room;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/InvalidationTracker$refreshRunnable$1", "Ljava/lang/Runnable;", "checkUpdatedTable", "", "", "run", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InvalidationTracker.kt */
public final class InvalidationTracker$refreshRunnable$1 implements Runnable {
    public final /* synthetic */ InvalidationTracker this$0;

    public InvalidationTracker$refreshRunnable$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<java.lang.Integer> checkUpdatedTable() {
        /*
            r5 = this;
            androidx.room.InvalidationTracker r0 = r5.this$0
            kotlin.collections.builders.SetBuilder r1 = new kotlin.collections.builders.SetBuilder
            r1.<init>()
            androidx.room.RoomDatabase r0 = r0.database
            androidx.sqlite.db.SimpleSQLiteQuery r2 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r3 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;"
            r2.<init>(r3)
            r3 = 0
            r4 = 2
            android.database.Cursor r0 = androidx.room.RoomDatabase.query$default(r0, r2, r3, r4, r3)
        L_0x0016:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x0029
            r2 = 0
            int r2 = r0.getInt(r2)     // Catch:{ all -> 0x0062 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0062 }
            r1.add(r2)     // Catch:{ all -> 0x0062 }
            goto L_0x0016
        L_0x0029:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r3)
            java.util.Set r0 = com.twitter.sdk.android.tweetui.TweetUtils.build(r1)
            r1 = r0
            kotlin.collections.builders.SetBuilder r1 = (kotlin.collections.builders.SetBuilder) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0061
            androidx.room.InvalidationTracker r1 = r5.this$0
            androidx.sqlite.db.SupportSQLiteStatement r1 = r1.cleanupStatement
            java.lang.String r2 = "Required value was null."
            if (r1 == 0) goto L_0x0057
            androidx.room.InvalidationTracker r1 = r5.this$0
            androidx.sqlite.db.SupportSQLiteStatement r1 = r1.cleanupStatement
            if (r1 == 0) goto L_0x004d
            r1.executeUpdateDelete()
            goto L_0x0061
        L_0x004d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0061:
            return r0
        L_0x0062:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.checkUpdatedTable():java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r0 != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r0 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
        if (r0 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0091, code lost:
        r0.decrementCountAndScheduleClose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0099, code lost:
        if ((!r3.isEmpty()) == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009b, code lost:
        r0 = r4.this$0;
        r1 = r0.observerMap;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0 = r0.observerMap.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00aa, code lost:
        if (r0.hasNext() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ac, code lost:
        ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r0.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c1, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0086 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0086=Splitter:B:39:0x0086, B:35:0x007a=Splitter:B:35:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.RoomDatabase r0 = r0.database
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock$room_runtime_release()
            r0.lock()
            r1 = 1
            androidx.room.InvalidationTracker r2 = r4.this$0     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            boolean r2 = r2.ensureInitialization$room_runtime_release()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            if (r2 != 0) goto L_0x0021
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0020
            r0.decrementCountAndScheduleClose()
        L_0x0020:
            return
        L_0x0021:
            androidx.room.InvalidationTracker r2 = r4.this$0     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.pendingRefresh     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            r3 = 0
            boolean r2 = r2.compareAndSet(r1, r3)     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            if (r2 != 0) goto L_0x0039
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0038
            r0.decrementCountAndScheduleClose()
        L_0x0038:
            return
        L_0x0039:
            androidx.room.InvalidationTracker r2 = r4.this$0     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            androidx.room.RoomDatabase r2 = r2.database     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            boolean r2 = r2.inTransaction()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            if (r2 == 0) goto L_0x0050
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x004f
            r0.decrementCountAndScheduleClose()
        L_0x004f:
            return
        L_0x0050:
            androidx.room.InvalidationTracker r2 = r4.this$0     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            androidx.room.RoomDatabase r2 = r2.database     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            r2.beginTransactionNonExclusive()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            java.util.Set r3 = r4.checkUpdatedTable()     // Catch:{ all -> 0x0073 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0073 }
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0094
            goto L_0x0091
        L_0x0073:
            r3 = move-exception
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
            throw r3     // Catch:{ IllegalStateException -> 0x0086, SQLiteException -> 0x007a }
        L_0x0078:
            r1 = move-exception
            goto L_0x00c2
        L_0x007a:
            kotlin.collections.EmptySet r3 = kotlin.collections.EmptySet.INSTANCE     // Catch:{ all -> 0x0078 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0094
            goto L_0x0091
        L_0x0086:
            kotlin.collections.EmptySet r3 = kotlin.collections.EmptySet.INSTANCE     // Catch:{ all -> 0x0078 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0094
        L_0x0091:
            r0.decrementCountAndScheduleClose()
        L_0x0094:
            boolean r0 = r3.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x00c1
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r1 = r0.observerMap
            monitor-enter(r1)
            androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r0 = r0.observerMap     // Catch:{ all -> 0x00be }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00be }
        L_0x00a6:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x00bc
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00be }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00be }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00be }
            androidx.room.InvalidationTracker$ObserverWrapper r2 = (androidx.room.InvalidationTracker.ObserverWrapper) r2     // Catch:{ all -> 0x00be }
            r2.notifyByTableInvalidStatus$room_runtime_release(r3)     // Catch:{ all -> 0x00be }
            goto L_0x00a6
        L_0x00bc:
            monitor-exit(r1)
            goto L_0x00c1
        L_0x00be:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x00c1:
            return
        L_0x00c2:
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r4.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00ce
            r0.decrementCountAndScheduleClose()
        L_0x00ce:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
    }
}
