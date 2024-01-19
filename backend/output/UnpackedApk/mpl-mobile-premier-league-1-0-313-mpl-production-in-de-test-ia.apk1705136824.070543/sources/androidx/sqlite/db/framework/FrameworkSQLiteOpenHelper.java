package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.DBRefHolder;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", "close", "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteOpenHelper.kt */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final boolean allowDataLossOnRecovery;
    public final Callback callback;
    public final Context context;
    public final Lazy<OpenHelper> lazyDelegate = TweetUtils.lazy((Function0<? extends T>) new FrameworkSQLiteOpenHelper$lazyDelegate$1<Object>(this));
    public final String name;
    public final boolean useNoBackupDirectory;
    public boolean writeAheadLoggingEnabled;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", "db", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class DBRefHolder {
        public FrameworkSQLiteDatabase db = null;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", "close", "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", "db", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class OpenHelper extends SQLiteOpenHelper {
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final DBRefHolder dbRef;
        public final ProcessLock lock;
        public boolean migrated;
        public boolean opened;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public static final class CallbackException extends RuntimeException {
            public final CallbackName callbackName;
            public final Throwable cause;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public CallbackException(CallbackName callbackName2, Throwable th) {
                // Intrinsics.checkNotNullParameter(callbackName2, "callbackName");
                // Intrinsics.checkNotNullParameter(th, "cause");
                super(th);
                this.callbackName = callbackName2;
                this.cause = th;
            }

            public Throwable getCause() {
                return this.cause;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public OpenHelper(Context context2, String str, DBRefHolder dBRefHolder, Callback callback2, boolean z) {
            // Intrinsics.checkNotNullParameter(context2, "context");
            // Intrinsics.checkNotNullParameter(dBRefHolder, "dbRef");
            // Intrinsics.checkNotNullParameter(callback2, "callback");
            super(context2, str, null, callback2.version, new DatabaseErrorHandler(dBRefHolder) {
                public final /* synthetic */ DBRefHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    OpenHelper._init_$lambda$0(Callback.this, this.f$1, sQLiteDatabase);
                }
            });
            this.context = context2;
            this.dbRef = dBRefHolder;
            this.callback = callback2;
            this.allowDataLossOnRecovery = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            File cacheDir = this.context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
            this.lock = new ProcessLock(str, cacheDir, false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
            if (r4 != null) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
            r4 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
            if (r4.hasNext() != false) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "p.second");
            r2.deleteDatabaseFile((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
            r3 = r1.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
            if (r3 != null) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
            r2.deleteDatabaseFile(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r1.delegate, r4) == false) goto L_0x0028;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0063 */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0061 A[ExcHandler: all (r0v12 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r4 
          PHI: (r4v7 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r4v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r4v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r4v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:11:0x005c, B:14:0x0063, B:15:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x005c] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final void _init_$lambda$0(androidx.sqlite.db.SupportSQLiteOpenHelper.Callback r2, androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.DBRefHolder r3, android.database.sqlite.SQLiteDatabase r4) {
            /*
                java.lang.String r0 = "$callback"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "$dbRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "dbObj"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                java.lang.String r0 = "refHolder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "sqLiteDatabase"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                androidx.sqlite.db.framework.FrameworkSQLiteDatabase r1 = r3.db
                if (r1 == 0) goto L_0x0028
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                android.database.sqlite.SQLiteDatabase r0 = r1.delegate
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
                if (r0 != 0) goto L_0x002f
            L_0x0028:
                androidx.sqlite.db.framework.FrameworkSQLiteDatabase r1 = new androidx.sqlite.db.framework.FrameworkSQLiteDatabase
                r1.<init>(r4)
                r3.db = r1
            L_0x002f:
                java.lang.String r3 = "p.second"
                java.lang.String r4 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r0 = "Corruption reported by sqlite on database: "
                r4.append(r0)
                r4.append(r1)
                java.lang.String r0 = ".path"
                r4.append(r0)
                r4.toString()
                boolean r4 = r1.isOpen()
                if (r4 != 0) goto L_0x005b
                java.lang.String r3 = r1.getPath()
                if (r3 == 0) goto L_0x00b5
                r2.deleteDatabaseFile(r3)
                goto L_0x00b5
            L_0x005b:
                r4 = 0
                java.util.List r4 = r1.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0063, all -> 0x0061 }
                goto L_0x0063
            L_0x0061:
                r0 = move-exception
                goto L_0x0067
            L_0x0063:
                r1.close()     // Catch:{ IOException -> 0x008e, all -> 0x0061 }
                goto L_0x008f
            L_0x0067:
                if (r4 == 0) goto L_0x0084
                java.util.Iterator r4 = r4.iterator()
            L_0x006d:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x008d
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                java.lang.String r1 = (java.lang.String) r1
                r2.deleteDatabaseFile(r1)
                goto L_0x006d
            L_0x0084:
                java.lang.String r3 = r1.getPath()
                if (r3 == 0) goto L_0x008d
                r2.deleteDatabaseFile(r3)
            L_0x008d:
                throw r0
            L_0x008e:
            L_0x008f:
                if (r4 == 0) goto L_0x00ac
                java.util.Iterator r4 = r4.iterator()
            L_0x0095:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x00b5
                java.lang.Object r0 = r4.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                java.lang.String r0 = (java.lang.String) r0
                r2.deleteDatabaseFile(r0)
                goto L_0x0095
            L_0x00ac:
                java.lang.String r3 = r1.getPath()
                if (r3 == 0) goto L_0x00b5
                r2.deleteDatabaseFile(r3)
            L_0x00b5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(androidx.sqlite.db.SupportSQLiteOpenHelper$Callback, androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$DBRefHolder, android.database.sqlite.SQLiteDatabase):void");
        }

        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1);
                super.close();
                this.dbRef.db = null;
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean z) {
            try {
                this.lock.lock(!this.opened && getDatabaseName() != null);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z);
                if (this.migrated) {
                    close();
                    return getSupportDatabase(z);
                }
                FrameworkSQLiteDatabase wrappedDb = getWrappedDb(innerGetDatabase);
                this.lock.unlock();
                return wrappedDb;
            } finally {
                this.lock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            DBRefHolder dBRefHolder = this.dbRef;
            Intrinsics.checkNotNullParameter(dBRefHolder, "refHolder");
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = dBRefHolder.db;
            if (frameworkSQLiteDatabase != null) {
                Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
                if (Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sQLiteDatabase)) {
                    return frameworkSQLiteDatabase;
                }
            }
            FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sQLiteDatabase);
            dBRefHolder.db = frameworkSQLiteDatabase2;
            return frameworkSQLiteDatabase2;
        }

        public final SQLiteDatabase getWritableOrReadableDatabase(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|10|12|13|14|15|16) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0038 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.database.sqlite.SQLiteDatabase innerGetDatabase(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getDatabaseName()
                if (r0 == 0) goto L_0x002b
                android.content.Context r1 = r4.context
                java.io.File r1 = r1.getDatabasePath(r0)
                java.io.File r1 = r1.getParentFile()
                if (r1 == 0) goto L_0x002b
                r1.mkdirs()
                boolean r2 = r1.isDirectory()
                if (r2 != 0) goto L_0x002b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Invalid database parent file, not a directory: "
                r2.append(r3)
                r2.append(r1)
                r2.toString()
            L_0x002b:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x0030 }
                return r5
            L_0x0030:
                super.close()
                r1 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0038 }
            L_0x0038:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x003d }
                return r5
            L_0x003d:
                r1 = move-exception
                super.close()
                boolean r2 = r1 instanceof androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException
                if (r2 == 0) goto L_0x0061
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackException r1 = (androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException) r1
                java.lang.Throwable r2 = r1.cause
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = r1.callbackName
                int r1 = r1.ordinal()
                if (r1 == 0) goto L_0x0060
                r3 = 1
                if (r1 == r3) goto L_0x0060
                r3 = 2
                if (r1 == r3) goto L_0x0060
                r3 = 3
                if (r1 == r3) goto L_0x0060
                boolean r1 = r2 instanceof android.database.sqlite.SQLiteException
                if (r1 == 0) goto L_0x005f
                goto L_0x006b
            L_0x005f:
                throw r2
            L_0x0060:
                throw r2
            L_0x0061:
                boolean r2 = r1 instanceof android.database.sqlite.SQLiteException
                if (r2 == 0) goto L_0x007a
                if (r0 == 0) goto L_0x0079
                boolean r2 = r4.allowDataLossOnRecovery
                if (r2 == 0) goto L_0x0079
            L_0x006b:
                android.content.Context r1 = r4.context
                r1.deleteDatabase(r0)
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ CallbackException -> 0x0075 }
                return r5
            L_0x0075:
                r5 = move-exception
                java.lang.Throwable r5 = r5.cause
                throw r5
            L_0x0079:
                throw r1
            L_0x007a:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.innerGetDatabase(boolean):android.database.sqlite.SQLiteDatabase");
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
            try {
                this.callback.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context2, String str, Callback callback2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.name = str;
        this.callback = callback2;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
    }

    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    public String getDatabaseName() {
        return this.name;
    }

    public final OpenHelper getDelegate() {
        return (OpenHelper) this.lazyDelegate.getValue();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate.isInitialized()) {
            OpenHelper delegate = getDelegate();
            Intrinsics.checkNotNullParameter(delegate, "sQLiteOpenHelper");
            delegate.setWriteAheadLoggingEnabled(z);
        }
        this.writeAheadLoggingEnabled = z;
    }
}
