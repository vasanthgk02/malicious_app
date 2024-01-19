package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomOpenHelper.kt */
public class RoomOpenHelper extends Callback {
    public DatabaseConfiguration configuration;
    public final Delegate delegate;
    public final String identityHash;
    public final String legacyHash;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "db", "validateMigration", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomOpenHelper.kt */
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase);

        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomOpenHelper.kt */
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate2, String str, String str2) {
        // Intrinsics.checkNotNullParameter(databaseConfiguration, "configuration");
        // Intrinsics.checkNotNullParameter(delegate2, "delegate");
        // Intrinsics.checkNotNullParameter(str, "identityHash");
        // Intrinsics.checkNotNullParameter(str2, "legacyHash");
        super(delegate2.version);
        this.configuration = databaseConfiguration;
        this.delegate = delegate2;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(androidx.sqlite.db.SupportSQLiteDatabase r4) {
        /*
            r3 = this;
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            android.database.Cursor r0 = r4.query(r0)
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0050 }
            r2 = 0
            if (r1 == 0) goto L_0x001c
            int r1 = r0.getInt(r2)     // Catch:{ all -> 0x0050 }
            if (r1 != 0) goto L_0x001c
            r2 = 1
        L_0x001c:
            r1 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            r0.createAllTables(r4)
            if (r2 != 0) goto L_0x0047
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r4)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x0032
            goto L_0x0047
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r1 = "Pre-packaged database has an invalid schema: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r0 = r0.expectedFoundMsg
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        L_0x0047:
            r3.updateIdentity(r4)
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            r0.onCreate(r4)
            return
        L_0x0050:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onCreate(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        onUpgrade(supportSQLiteDatabase, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOpen(androidx.sqlite.db.SupportSQLiteDatabase r5) {
        /*
            r4 = this;
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r5.query(r0)
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x009c }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            int r1 = r0.getInt(r2)     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            r3 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r3)
            if (r1 == 0) goto L_0x006d
            androidx.sqlite.db.SimpleSQLiteQuery r0 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            android.database.Cursor r0 = r5.query(r0)
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = r0.getString(r2)     // Catch:{ all -> 0x0066 }
            goto L_0x003e
        L_0x003d:
            r1 = r3
        L_0x003e:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r3)
            java.lang.String r0 = r4.identityHash
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x007f
            java.lang.String r0 = r4.legacyHash
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0052
            goto L_0x007f
        L_0x0052:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r2 = r4.identityHash
            java.lang.String r3 = ", found: "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline63(r0, r2, r3, r1)
            r5.<init>(r0)
            throw r5
        L_0x0066:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5)
            throw r1
        L_0x006d:
            androidx.room.RoomOpenHelper$Delegate r0 = r4.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r5)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x0087
            androidx.room.RoomOpenHelper$Delegate r0 = r4.delegate
            r0.onPostMigrate(r5)
            r4.updateIdentity(r5)
        L_0x007f:
            androidx.room.RoomOpenHelper$Delegate r0 = r4.delegate
            r0.onOpen(r5)
            r4.configuration = r3
            return
        L_0x0087:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r1 = "Pre-packaged database has an invalid schema: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r0 = r0.expectedFoundMsg
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.<init>(r0)
            throw r5
        L_0x009c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x009e }
        L_0x009e:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onOpen(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.Iterable] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r9 <= r14) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        if (r9 < r5) goto L_0x0073;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0078 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(androidx.sqlite.db.SupportSQLiteDatabase r12, int r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.room.DatabaseConfiguration r0 = r11.configuration
            r1 = 0
            if (r0 == 0) goto L_0x00d3
            androidx.room.RoomDatabase$MigrationContainer r0 = r0.migrationContainer
            r2 = 0
            if (r0 == 0) goto L_0x00d2
            if (r13 != r14) goto L_0x0015
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
            goto L_0x008e
        L_0x0015:
            if (r14 <= r13) goto L_0x0019
            r3 = 1
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = r13
        L_0x0020:
            if (r3 == 0) goto L_0x0025
            if (r5 >= r14) goto L_0x0029
            goto L_0x0027
        L_0x0025:
            if (r5 <= r14) goto L_0x0029
        L_0x0027:
            r6 = 1
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            if (r6 == 0) goto L_0x008c
            java.util.Map<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> r6 = r0.migrations
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r6.get(r7)
            java.util.TreeMap r6 = (java.util.TreeMap) r6
            if (r6 != 0) goto L_0x003b
            goto L_0x008d
        L_0x003b:
            if (r3 == 0) goto L_0x0042
            java.util.NavigableSet r7 = r6.descendingKeySet()
            goto L_0x0046
        L_0x0042:
            java.util.Set r7 = r6.keySet()
        L_0x0046:
            java.util.Iterator r7 = r7.iterator()
        L_0x004a:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0088
            java.lang.Object r8 = r7.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.String r9 = "targetVersion"
            if (r3 == 0) goto L_0x0068
            int r10 = r5 + 1
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r9 = r8.intValue()
            if (r10 > r9) goto L_0x0075
            if (r9 > r14) goto L_0x0075
            goto L_0x0073
        L_0x0068:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r9 = r8.intValue()
            if (r14 > r9) goto L_0x0075
            if (r9 >= r5) goto L_0x0075
        L_0x0073:
            r9 = 1
            goto L_0x0076
        L_0x0075:
            r9 = 0
        L_0x0076:
            if (r9 == 0) goto L_0x004a
            java.lang.Object r5 = r6.get(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r4.add(r5)
            int r5 = r8.intValue()
            r6 = 1
            goto L_0x0089
        L_0x0088:
            r6 = 0
        L_0x0089:
            if (r6 != 0) goto L_0x0020
            goto L_0x008d
        L_0x008c:
            r2 = r4
        L_0x008d:
            r0 = r2
        L_0x008e:
            if (r0 == 0) goto L_0x00d3
            androidx.room.RoomOpenHelper$Delegate r1 = r11.delegate
            r1.onPreMigrate(r12)
            java.util.Iterator r0 = r0.iterator()
        L_0x0099:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a9
            java.lang.Object r1 = r0.next()
            androidx.room.migration.Migration r1 = (androidx.room.migration.Migration) r1
            r1.migrate(r12)
            goto L_0x0099
        L_0x00a9:
            androidx.room.RoomOpenHelper$Delegate r0 = r11.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r12)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x00bd
            androidx.room.RoomOpenHelper$Delegate r0 = r11.delegate
            r0.onPostMigrate(r12)
            r11.updateIdentity(r12)
            r1 = 1
            goto L_0x00d3
        L_0x00bd:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Migration didn't properly handle: "
            java.lang.StringBuilder r13 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            java.lang.String r14 = r0.expectedFoundMsg
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x00d2:
            throw r2
        L_0x00d3:
            if (r1 != 0) goto L_0x00fa
            androidx.room.DatabaseConfiguration r0 = r11.configuration
            if (r0 == 0) goto L_0x00ea
            boolean r0 = r0.isMigrationRequired(r13, r14)
            if (r0 != 0) goto L_0x00ea
            androidx.room.RoomOpenHelper$Delegate r13 = r11.delegate
            r13.dropAllTables(r12)
            androidx.room.RoomOpenHelper$Delegate r13 = r11.delegate
            r13.createAllTables(r12)
            goto L_0x00fa
        L_0x00ea:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "A migration from "
            java.lang.String r1 = " to "
            java.lang.String r2 = " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods."
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline44(r0, r13, r1, r14, r2)
            r12.<init>(r13)
            throw r12
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onUpgrade(androidx.sqlite.db.SupportSQLiteDatabase, int, int):void");
    }

    public final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String str = this.identityHash;
        Intrinsics.checkNotNullParameter(str, Response.HASH);
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
    }
}
