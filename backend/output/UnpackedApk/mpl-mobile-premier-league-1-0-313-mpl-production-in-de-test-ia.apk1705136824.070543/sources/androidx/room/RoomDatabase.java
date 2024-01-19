package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 n2\u00020\u0001:\u0007lmnopqrB\u0005¢\u0006\u0002\u0010\u0002J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u000209H\u0017J\b\u0010;\u001a\u000209H\u0017J\b\u0010<\u001a\u000209H'J\b\u0010=\u001a\u000209H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0010H\u0016J\b\u0010A\u001a\u00020\u0018H$J\u0010\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020DH$J\b\u0010E\u001a\u000209H\u0017J*\u0010F\u001a\b\u0012\u0004\u0012\u00020G0!2\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0HH\u0017J\r\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bKJ\u0016\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0MH\u0017J\"\u0010N\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0!0HH\u0015J#\u0010O\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\tH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020\u0004H\u0016J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020DH\u0017J\b\u0010V\u001a\u000209H\u0002J\b\u0010W\u001a\u000209H\u0002J\u0010\u0010X\u001a\u0002092\u0006\u0010Y\u001a\u00020%H\u0014J\u001c\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^H\u0017J)\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\u00102\u0012\u0010_\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010`H\u0016¢\u0006\u0002\u0010aJ\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020dH\u0016J!\u0010b\u001a\u0002He\"\u0004\b\u0000\u0010e2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002He0fH\u0016¢\u0006\u0002\u0010gJ\b\u0010h\u001a\u000209H\u0017J+\u0010i\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002HP0\t2\u0006\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010kR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0004@\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u001dR \u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0004@\u0004X\u000e¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u001a\u0010$\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u000e¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u0014\u0010'\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010/\u001a\b\u0012\u0004\u0012\u000201008G¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010,R\u001e\u00106\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Landroidx/room/RoomDatabase;", "", "()V", "allowMainThreadQueries", "", "autoCloser", "Landroidx/room/AutoCloser;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "backingFieldMap", "", "getBackingFieldMap", "internalOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "isMainThread", "isMainThread$room_runtime_release", "()Z", "isOpen", "isOpen$annotations", "mCallbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getMCallbacks$annotations", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "openHelper", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "suspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "transactionExecutor", "getTransactionExecutor", "typeConverters", "writeAheadLoggingEnabled", "assertNotMainThread", "", "assertNotSuspendingTransaction", "beginTransaction", "clearAllTables", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "createInvalidationTracker", "createOpenHelper", "config", "Landroidx/room/DatabaseConfiguration;", "endTransaction", "getAutoMigrations", "Landroidx/room/migration/Migration;", "", "getCloseLock", "Ljava/util/concurrent/locks/Lock;", "getCloseLock$room_runtime_release", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "getTypeConverter", "T", "klass", "(Ljava/lang/Class;)Ljava/lang/Object;", "inTransaction", "init", "configuration", "internalBeginTransaction", "internalEndTransaction", "internalInitInvalidationTracker", "db", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "runInTransaction", "body", "Ljava/lang/Runnable;", "V", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "setTransactionSuccessful", "unwrapOpenHelper", "clazz", "(Ljava/lang/Class;Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Ljava/lang/Object;", "Builder", "Callback", "Companion", "JournalMode", "MigrationContainer", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomDatabase.kt */
public abstract class RoomDatabase {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    public boolean allowMainThreadQueries;
    public AutoCloser autoCloser;
    public Map<Class<? extends Object>, Object> autoMigrationSpecs = new LinkedHashMap();
    public final Map<String, Object> backingFieldMap;
    public SupportSQLiteOpenHelper internalOpenHelper;
    public Executor internalQueryExecutor;
    public Executor internalTransactionExecutor;
    public final InvalidationTracker invalidationTracker = createInvalidationTracker();
    public List<? extends Callback> mCallbacks;
    public volatile SupportSQLiteDatabase mDatabase;
    public final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();
    public final Map<Class<?>, Object> typeConverters;
    public boolean writeAheadLoggingEnabled;

    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0014H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u0016H\u0016J'\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:H\u0016¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\r\u0010>\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\tH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u00106\u001a\u00020*H\u0017J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u00192\u0006\u00106\u001a\u00020*H\u0017J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J$\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u00106\u001a\u00020*H\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010I\u001a\u00020J\"\u00020%H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020(H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Landroidx/room/RoomDatabase$Builder;", "T", "Landroidx/room/RoomDatabase;", "", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "allowDestructiveMigrationOnDowngrade", "", "allowMainThreadQueries", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeout", "", "autoMigrationSpecs", "", "Landroidx/room/migration/AutoMigrationSpec;", "callbacks", "Landroidx/room/RoomDatabase$Callback;", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryExecutor", "requireMigration", "transactionExecutor", "typeConverters", "addAutoMigrationSpec", "autoMigrationSpec", "addCallback", "callback", "addMigrations", "migrations", "", "Landroidx/room/migration/Migration;", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "addTypeConverter", "typeConverter", "build", "()Landroidx/room/RoomDatabase;", "createFromAsset", "databaseFilePath", "createFromFile", "databaseFile", "createFromInputStream", "inputStreamCallable", "enableMultiInstanceInvalidation", "fallbackToDestructiveMigration", "fallbackToDestructiveMigrationFrom", "startVersions", "", "fallbackToDestructiveMigrationOnDowngrade", "openHelperFactory", "setAutoCloseTimeout", "setJournalMode", "setMultiInstanceInvalidationServiceIntent", "invalidationServiceIntent", "setQueryCallback", "executor", "setQueryExecutor", "setTransactionExecutor", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public static class Builder<T extends RoomDatabase> {
        public boolean allowDestructiveMigrationOnDowngrade;
        public boolean allowMainThreadQueries;
        public long autoCloseTimeout = -1;
        public List<Object> autoMigrationSpecs = new ArrayList();
        public final List<Callback> callbacks = new ArrayList();
        public final Context context;
        public Factory factory;
        public JournalMode journalMode = JournalMode.AUTOMATIC;
        public final Class<T> klass;
        public final MigrationContainer migrationContainer = new MigrationContainer();
        public Set<Integer> migrationStartAndEndVersions;
        public Set<Integer> migrationsNotRequiredFrom = new LinkedHashSet();
        public Intent multiInstanceInvalidationIntent;
        public final String name;
        public Executor queryExecutor;
        public boolean requireMigration = true;
        public Executor transactionExecutor;
        public final List<Object> typeConverters = new ArrayList();

        public Builder(Context context2, Class<T> cls, String str) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(cls, "klass");
            this.context = context2;
            this.klass = cls;
            this.name = str;
        }

        public Builder<T> addCallback(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public Builder<T> addMigrations(Migration... migrationArr) {
            Intrinsics.checkNotNullParameter(migrationArr, "migrations");
            if (this.migrationStartAndEndVersions == null) {
                this.migrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                Set<Integer> set = this.migrationStartAndEndVersions;
                Intrinsics.checkNotNull(set);
                set.add(Integer.valueOf(migration.startVersion));
                Set<Integer> set2 = this.migrationStartAndEndVersions;
                Intrinsics.checkNotNull(set2);
                set2.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
            return this;
        }

        public T build() {
            String str;
            if (this.queryExecutor == null && this.transactionExecutor == null) {
                Executor executor = ArchTaskExecutor.sIOThreadExecutor;
                this.transactionExecutor = executor;
                this.queryExecutor = executor;
            } else {
                Executor executor2 = this.queryExecutor;
                if (executor2 != null && this.transactionExecutor == null) {
                    this.transactionExecutor = executor2;
                } else if (this.queryExecutor == null) {
                    this.queryExecutor = this.transactionExecutor;
                }
            }
            Set<Integer> set = this.migrationStartAndEndVersions;
            if (set != null) {
                Intrinsics.checkNotNull(set);
                for (Integer intValue : set) {
                    if (!(!this.migrationsNotRequiredFrom.contains(Integer.valueOf(intValue.intValue())))) {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ", intValue.intValue()).toString());
                    }
                }
            }
            Factory factory2 = this.factory;
            if (factory2 == null) {
                factory2 = new FrameworkSQLiteOpenHelperFactory();
            }
            if (factory2 == null) {
                factory2 = null;
            } else if (this.autoCloseTimeout > 0) {
                if (this.name != null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
            }
            Factory factory3 = factory2;
            if (factory3 != null) {
                Context context2 = this.context;
                String str2 = this.name;
                MigrationContainer migrationContainer2 = this.migrationContainer;
                List<Callback> list = this.callbacks;
                boolean z = this.allowMainThreadQueries;
                JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context2);
                Executor executor3 = this.queryExecutor;
                if (executor3 != null) {
                    Executor executor4 = this.transactionExecutor;
                    if (executor4 != null) {
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str2, factory3, migrationContainer2, list, z, resolve$room_runtime_release, executor3, executor4, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, null, null, null, this.typeConverters, this.autoMigrationSpecs);
                        Class<T> cls = this.klass;
                        Intrinsics.checkNotNullParameter(cls, "klass");
                        Intrinsics.checkNotNullParameter("_Impl", "suffix");
                        Package packageR = cls.getPackage();
                        Intrinsics.checkNotNull(packageR);
                        String name2 = packageR.getName();
                        String canonicalName = cls.getCanonicalName();
                        Intrinsics.checkNotNull(canonicalName);
                        Intrinsics.checkNotNullExpressionValue(name2, "fullPackage");
                        boolean z2 = false;
                        if (!(name2.length() == 0)) {
                            canonicalName = canonicalName.substring(name2.length() + 1);
                            Intrinsics.checkNotNullExpressionValue(canonicalName, "this as java.lang.String).substring(startIndex)");
                        }
                        String str3 = CharsKt__CharKt.replace$default(canonicalName, '.', '_', false, 4) + "_Impl";
                        try {
                            if (name2.length() == 0) {
                                z2 = true;
                            }
                            if (z2) {
                                str = str3;
                            } else {
                                str = name2 + '.' + str3;
                            }
                            Class<?> cls2 = Class.forName(str, true, cls.getClassLoader());
                            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
                            T t = (RoomDatabase) cls2.newInstance();
                            t.init(databaseConfiguration);
                            return t;
                        } catch (ClassNotFoundException unused) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot find implementation for ");
                            outline73.append(cls.getCanonicalName());
                            outline73.append(". ");
                            outline73.append(str3);
                            outline73.append(" does not exist");
                            throw new RuntimeException(outline73.toString());
                        } catch (IllegalAccessException unused2) {
                            throw new RuntimeException("Cannot access the constructor " + cls + ".canonicalName");
                        } catch (InstantiationException unused3) {
                            throw new RuntimeException("Failed to create an instance of " + cls + ".canonicalName");
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            this.multiInstanceInvalidationIntent = this.name != null ? new Intent(this.context, MultiInstanceInvalidationService.class) : null;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode2) {
            Intrinsics.checkNotNullParameter(journalMode2, "journalMode");
            this.journalMode = journalMode2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/RoomDatabase$Callback;", "", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDestructiveMigration", "onOpen", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/RoomDatabase$Companion;", "", "()V", "MAX_BIND_PARAMETER_CNT", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "(Ljava/lang/String;I)V", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean isLowRamDevice(ActivityManager activityManager) {
            Intrinsics.checkNotNullParameter(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            if (!isLowRamDevice((ActivityManager) systemService)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001b0\u001bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomDatabase$MigrationContainer;", "", "()V", "migrations", "", "", "Ljava/util/TreeMap;", "Landroidx/room/migration/Migration;", "addMigration", "", "migration", "addMigrations", "", "([Landroidx/room/migration/Migration;)V", "", "contains", "", "startVersion", "endVersion", "findMigrationPath", "start", "end", "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public static class MigrationContainer {
        public final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        public void addMigrations(Migration... migrationArr) {
            Intrinsics.checkNotNullParameter(migrationArr, "migrations");
            for (Migration migration : migrationArr) {
                int i = migration.startVersion;
                int i2 = migration.endVersion;
                Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
                Integer valueOf = Integer.valueOf(i);
                TreeMap<Integer, Migration> treeMap = map.get(valueOf);
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    map.put(valueOf, treeMap);
                }
                TreeMap treeMap2 = treeMap;
                if (treeMap2.containsKey(Integer.valueOf(i2))) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Overriding migration ");
                    outline73.append(treeMap2.get(Integer.valueOf(i2)));
                    outline73.append(" with ");
                    outline73.append(migration);
                    outline73.toString();
                }
                treeMap2.put(Integer.valueOf(i2), migration);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", "()V", "onOpenPrepackagedDatabase", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomDatabase.kt */
    public static abstract class PrepackagedDatabaseCallback {
    }

    public RoomDatabase() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = synchronizedMap;
        this.typeConverters = new LinkedHashMap();
    }

    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    public static /* synthetic */ void getMDatabase$annotations() {
    }

    /* access modifiers changed from: private */
    public final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    /* access modifiers changed from: private */
    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            InvalidationTracker invalidationTracker2 = getInvalidationTracker();
            if (invalidationTracker2.pendingRefresh.compareAndSet(false, true)) {
                AutoCloser autoCloser2 = invalidationTracker2.autoCloser;
                if (autoCloser2 != null) {
                    autoCloser2.incrementCountAndEnsureDbIsOpen();
                }
                invalidationTracker2.database.getQueryExecutor().execute(invalidationTracker2.refreshRunnable);
            }
        }
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        return supportSQLiteOpenHelper instanceof DelegatingOpenHelper ? unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate()) : null;
    }

    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && !(!isMainThread$room_runtime_release())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!(inTransaction() || this.suspendingTransactionId.get() == null)) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalBeginTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$beginTransaction$1(this));
        }
    }

    public abstract void clearAllTables();

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|(1:12)|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r6 = this;
            boolean r0 = r6.isOpen()
            if (r0 == 0) goto L_0x0054
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r6.readWriteLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            java.lang.String r1 = "readWriteLock.writeLock()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.lock()
            androidx.room.InvalidationTracker r1 = r6.getInvalidationTracker()     // Catch:{ all -> 0x004f }
            androidx.room.MultiInstanceInvalidationClient r2 = r1.multiInstanceInvalidationClient     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.stopped     // Catch:{ all -> 0x004f }
            r4 = 0
            r5 = 1
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x0041
            androidx.room.InvalidationTracker r3 = r2.invalidationTracker     // Catch:{ all -> 0x004f }
            androidx.room.InvalidationTracker$Observer r4 = r2.getObserver()     // Catch:{ all -> 0x004f }
            r3.removeObserver(r4)     // Catch:{ all -> 0x004f }
            androidx.room.IMultiInstanceInvalidationService r3 = r2.service     // Catch:{ RemoteException -> 0x003a }
            if (r3 == 0) goto L_0x003a
            androidx.room.IMultiInstanceInvalidationCallback r4 = r2.callback     // Catch:{ RemoteException -> 0x003a }
            int r5 = r2.clientId     // Catch:{ RemoteException -> 0x003a }
            r3.unregisterCallback(r4, r5)     // Catch:{ RemoteException -> 0x003a }
        L_0x003a:
            android.content.Context r3 = r2.appContext     // Catch:{ all -> 0x004f }
            android.content.ServiceConnection r2 = r2.serviceConnection     // Catch:{ all -> 0x004f }
            r3.unbindService(r2)     // Catch:{ all -> 0x004f }
        L_0x0041:
            r2 = 0
            r1.multiInstanceInvalidationClient = r2     // Catch:{ all -> 0x004f }
            androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r6.getOpenHelper()     // Catch:{ all -> 0x004f }
            r1.close()     // Catch:{ all -> 0x004f }
            r0.unlock()
            goto L_0x0054
        L_0x004f:
            r1 = move-exception
            r0.unlock()
            throw r1
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.close():void");
    }

    public SupportSQLiteStatement compileStatement(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public void endTransaction() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalEndTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$endTransaction$1(this));
        }
    }

    public final Map<Class<? extends Object>, Object> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends Object>, Object> map) {
        Intrinsics.checkNotNullParameter(map, "autoMigrationSpecs");
        return EmptyList.INSTANCE;
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReadLock readLock = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        throw null;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        throw null;
    }

    public Set<Class<? extends Object>> getRequiredAutoMigrationSpecs() {
        return EmptySet.INSTANCE;
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return ArraysKt___ArraysJvmKt.emptyMap();
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        throw null;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        return this.typeConverters.get(cls);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ff A[LOOP:5: B:63:0x01c7->B:77:0x01ff, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x020b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(androidx.room.DatabaseConfiguration r13) {
        /*
            r12 = this;
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = r12.createOpenHelper(r13)
            r12.internalOpenHelper = r0
            java.util.Set r0 = r12.getRequiredAutoMigrationSpecs()
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            r3 = 1
            r4 = 0
            r5 = -1
            if (r2 == 0) goto L_0x007e
            java.lang.Object r2 = r0.next()
            java.lang.Class r2 = (java.lang.Class) r2
            java.util.List<java.lang.Object> r4 = r13.autoMigrationSpecs
            int r4 = r4.size()
            int r4 = r4 + r5
            if (r4 < 0) goto L_0x004c
        L_0x0030:
            int r6 = r4 + -1
            java.util.List<java.lang.Object> r7 = r13.autoMigrationSpecs
            java.lang.Object r7 = r7.get(r4)
            java.lang.Class r7 = r7.getClass()
            boolean r7 = r2.isAssignableFrom(r7)
            if (r7 == 0) goto L_0x0047
            r1.set(r4)
            r5 = r4
            goto L_0x004c
        L_0x0047:
            if (r6 >= 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r4 = r6
            goto L_0x0030
        L_0x004c:
            if (r5 < 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r3 = 0
        L_0x0050:
            if (r3 == 0) goto L_0x005e
            java.util.Map<java.lang.Class<? extends java.lang.Object>, java.lang.Object> r3 = r12.autoMigrationSpecs
            java.util.List<java.lang.Object> r4 = r13.autoMigrationSpecs
            java.lang.Object r4 = r4.get(r5)
            r3.put(r2, r4)
            goto L_0x0018
        L_0x005e:
            java.lang.String r13 = "A required auto migration spec ("
            java.lang.StringBuilder r13 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            java.lang.String r0 = r2.getCanonicalName()
            r13.append(r0)
            java.lang.String r0 = ") is missing in the database configuration."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L_0x007e:
            java.util.List<java.lang.Object> r0 = r13.autoMigrationSpecs
            int r0 = r0.size()
            int r0 = r0 + r5
            if (r0 < 0) goto L_0x00a0
        L_0x0087:
            int r2 = r0 + -1
            boolean r0 = r1.get(r0)
            if (r0 == 0) goto L_0x0094
            if (r2 >= 0) goto L_0x0092
            goto L_0x00a0
        L_0x0092:
            r0 = r2
            goto L_0x0087
        L_0x0094:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x00a0:
            java.util.Map<java.lang.Class<? extends java.lang.Object>, java.lang.Object> r0 = r12.autoMigrationSpecs
            java.util.List r0 = r12.getAutoMigrations(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x00aa:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00ee
            java.lang.Object r1 = r0.next()
            androidx.room.migration.Migration r1 = (androidx.room.migration.Migration) r1
            androidx.room.RoomDatabase$MigrationContainer r2 = r13.migrationContainer
            int r6 = r1.startVersion
            int r7 = r1.endVersion
            java.util.Map<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> r2 = r2.migrations
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r8 = r2.containsKey(r8)
            if (r8 == 0) goto L_0x00e1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r2.get(r6)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 != 0) goto L_0x00d8
            java.util.Map r2 = kotlin.collections.ArraysKt___ArraysJvmKt.emptyMap()
        L_0x00d8:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            boolean r2 = r2.containsKey(r6)
            goto L_0x00e2
        L_0x00e1:
            r2 = 0
        L_0x00e2:
            if (r2 != 0) goto L_0x00aa
            androidx.room.RoomDatabase$MigrationContainer r2 = r13.migrationContainer
            androidx.room.migration.Migration[] r6 = new androidx.room.migration.Migration[r3]
            r6[r4] = r1
            r2.addMigrations(r6)
            goto L_0x00aa
        L_0x00ee:
            java.lang.Class<androidx.room.SQLiteCopyOpenHelper> r0 = androidx.room.SQLiteCopyOpenHelper.class
            androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r12.getOpenHelper()
            java.lang.Object r0 = r12.unwrapOpenHelper(r0, r1)
            androidx.room.SQLiteCopyOpenHelper r0 = (androidx.room.SQLiteCopyOpenHelper) r0
            if (r0 == 0) goto L_0x0103
            java.lang.String r1 = "databaseConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            r0.databaseConfiguration = r13
        L_0x0103:
            java.lang.Class<androidx.room.AutoClosingRoomOpenHelper> r0 = androidx.room.AutoClosingRoomOpenHelper.class
            androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r12.getOpenHelper()
            java.lang.Object r0 = r12.unwrapOpenHelper(r0, r1)
            androidx.room.AutoClosingRoomOpenHelper r0 = (androidx.room.AutoClosingRoomOpenHelper) r0
            r1 = 0
            if (r0 == 0) goto L_0x0133
            androidx.room.AutoCloser r2 = r0.autoCloser
            r12.autoCloser = r2
            androidx.room.InvalidationTracker r2 = r12.getInvalidationTracker()
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r2 == 0) goto L_0x0132
            java.lang.String r3 = "autoCloser"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r2.autoCloser = r0
            androidx.room.-$$Lambda$G-RBd-AZgoETzaQuJ93DiJxTEu8 r3 = new androidx.room.-$$Lambda$G-RBd-AZgoETzaQuJ93DiJxTEu8
            r3.<init>()
            java.lang.String r2 = "onAutoClose"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r0.onAutoCloseCallback = r3
            goto L_0x0133
        L_0x0132:
            throw r1
        L_0x0133:
            androidx.room.RoomDatabase$JournalMode r0 = r13.journalMode
            androidx.room.RoomDatabase$JournalMode r2 = androidx.room.RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING
            if (r0 != r2) goto L_0x013b
            r0 = 1
            goto L_0x013c
        L_0x013b:
            r0 = 0
        L_0x013c:
            androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r12.getOpenHelper()
            r2.setWriteAheadLoggingEnabled(r0)
            java.util.List<androidx.room.RoomDatabase$Callback> r2 = r13.callbacks
            r12.mCallbacks = r2
            java.util.concurrent.Executor r2 = r13.queryExecutor
            r12.internalQueryExecutor = r2
            androidx.room.TransactionExecutor r2 = new androidx.room.TransactionExecutor
            java.util.concurrent.Executor r3 = r13.transactionExecutor
            r2.<init>(r3)
            r12.internalTransactionExecutor = r2
            boolean r2 = r13.allowMainThreadQueries
            r12.allowMainThreadQueries = r2
            r12.writeAheadLoggingEnabled = r0
            android.content.Intent r0 = r13.multiInstanceInvalidationServiceIntent
            if (r0 == 0) goto L_0x019a
            java.lang.String r0 = r13.name
            if (r0 == 0) goto L_0x018e
            androidx.room.InvalidationTracker r0 = r12.getInvalidationTracker()
            android.content.Context r7 = r13.context
            java.lang.String r8 = r13.name
            android.content.Intent r9 = r13.multiInstanceInvalidationServiceIntent
            if (r0 == 0) goto L_0x018d
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "serviceIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            androidx.room.MultiInstanceInvalidationClient r1 = new androidx.room.MultiInstanceInvalidationClient
            androidx.room.RoomDatabase r2 = r0.database
            java.util.concurrent.Executor r11 = r2.getQueryExecutor()
            r6 = r1
            r10 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            r0.multiInstanceInvalidationClient = r1
            goto L_0x019a
        L_0x018d:
            throw r1
        L_0x018e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x019a:
            java.util.Map r0 = r12.getRequiredTypeConverters()
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01ab:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0237
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01c7:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x01ab
            java.lang.Object r4 = r2.next()
            java.lang.Class r4 = (java.lang.Class) r4
            java.util.List<java.lang.Object> r6 = r13.typeConverters
            int r6 = r6.size()
            int r6 = r6 + r5
            if (r6 < 0) goto L_0x01f7
        L_0x01dc:
            int r7 = r6 + -1
            java.util.List<java.lang.Object> r8 = r13.typeConverters
            java.lang.Object r8 = r8.get(r6)
            java.lang.Class r8 = r8.getClass()
            boolean r8 = r4.isAssignableFrom(r8)
            if (r8 == 0) goto L_0x01f2
            r1.set(r6)
            goto L_0x01f8
        L_0x01f2:
            if (r7 >= 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r6 = r7
            goto L_0x01dc
        L_0x01f7:
            r6 = -1
        L_0x01f8:
            if (r6 < 0) goto L_0x01fc
            r7 = 1
            goto L_0x01fd
        L_0x01fc:
            r7 = 0
        L_0x01fd:
            if (r7 == 0) goto L_0x020b
            java.util.Map<java.lang.Class<?>, java.lang.Object> r7 = r12.typeConverters
            java.util.List<java.lang.Object> r8 = r13.typeConverters
            java.lang.Object r6 = r8.get(r6)
            r7.put(r4, r6)
            goto L_0x01c7
        L_0x020b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "A required type converter ("
            r13.append(r0)
            r13.append(r4)
            java.lang.String r0 = ") for "
            r13.append(r0)
            java.lang.String r0 = r3.getCanonicalName()
            r13.append(r0)
            java.lang.String r0 = " is missing in the database configuration."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L_0x0237:
            java.util.List<java.lang.Object> r0 = r13.typeConverters
            int r0 = r0.size()
            int r0 = r0 + r5
            if (r0 < 0) goto L_0x026f
        L_0x0240:
            int r2 = r0 + -1
            boolean r3 = r1.get(r0)
            if (r3 == 0) goto L_0x024d
            if (r2 >= 0) goto L_0x024b
            goto L_0x026f
        L_0x024b:
            r0 = r2
            goto L_0x0240
        L_0x024d:
            java.util.List<java.lang.Object> r13 = r13.typeConverters
            java.lang.Object r13 = r13.get(r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected type converter "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13)
            throw r0
        L_0x026f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.init(androidx.room.DatabaseConfiguration):void");
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        InvalidationTracker invalidationTracker2 = getInvalidationTracker();
        if (invalidationTracker2 != null) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
            synchronized (invalidationTracker2.trackerLock) {
                if (!invalidationTracker2.initialized) {
                    supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
                    supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
                    supportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                    invalidationTracker2.syncTriggers$room_runtime_release(supportSQLiteDatabase);
                    invalidationTracker2.cleanupStatement = supportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
                    invalidationTracker2.initialized = true;
                    return;
                }
                return;
            }
        }
        throw null;
    }

    public final boolean isMainThread$room_runtime_release() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        Boolean bool;
        boolean isOpen;
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            isOpen = !autoCloser2.manuallyClosed;
        } else {
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
            if (supportSQLiteDatabase != null) {
                isOpen = supportSQLiteDatabase.isOpen();
            } else {
                bool = null;
                return Intrinsics.areEqual(bool, Boolean.TRUE);
            }
        }
        bool = Boolean.valueOf(isOpen);
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "query");
        return query$default(this, supportSQLiteQuery, null, 2, null);
    }

    public Cursor query(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "query");
        return getOpenHelper().getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public void runInTransaction(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, SMTNotificationConstants.NOTIF_BODY_KEY);
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public final void setAutoMigrationSpecs(Map<Class<? extends Object>, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        Intrinsics.checkNotNullParameter(callable, SMTNotificationConstants.NOTIF_BODY_KEY);
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }
}
