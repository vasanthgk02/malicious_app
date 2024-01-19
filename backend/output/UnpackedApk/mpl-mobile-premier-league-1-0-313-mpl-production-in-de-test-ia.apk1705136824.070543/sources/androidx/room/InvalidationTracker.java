package androidx.room;

import android.annotation.SuppressLint;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 f2\u00020\u0001:\u0005fghijB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007BV\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\t\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\rJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J7\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010AJ?\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010B\u001a\u00020\u00192\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017¢\u0006\u0002\u0010CJ\r\u0010D\u001a\u00020\u0019H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bHJ!\u0010I\u001a\u0002092\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010KJ\r\u0010L\u001a\u000209H\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u000209H\u0016J\b\u0010O\u001a\u000209H\u0017J\u0010\u0010P\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J%\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010SJ\u0015\u0010T\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\bUJ%\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J\u0018\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010`\u001a\u000209H\u0000¢\u0006\u0002\baJ\u0018\u0010b\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010c\u001a\u000209H\u0000¢\u0006\u0002\bdJ\u0015\u0010c\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000¢\u0006\u0002\bdJ%\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010SR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020'8GX\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020+8\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010-R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R%\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "shadowTablesMap", "", "viewTables", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "autoCloser", "Landroidx/room/AutoCloser;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "initialized", "", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "()V", "syncTriggersLock", "tableIdLookup", "", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "trackerLock", "addObserver", "", "observer", "addWeakObserver", "createLiveData", "Landroidx/lifecycle/LiveData;", "T", "computeFunction", "Ljava/util/concurrent/Callable;", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "ensureInitialization", "ensureInitialization$room_runtime_release", "internalInit", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "internalInit$room_runtime_release", "notifyObserversByTableNames", "tables", "([Ljava/lang/String;)V", "onAutoCloseCallback", "onAutoCloseCallback$room_runtime_release", "refreshVersionsAsync", "refreshVersionsSync", "removeObserver", "resolveViews", "names", "([Ljava/lang/String;)[Ljava/lang/String;", "setAutoCloser", "setAutoCloser$room_runtime_release", "startMultiInstanceInvalidation", "context", "Landroid/content/Context;", "name", "serviceIntent", "Landroid/content/Intent;", "startMultiInstanceInvalidation$room_runtime_release", "startTrackingTable", "db", "tableId", "stopMultiInstanceInvalidation", "stopMultiInstanceInvalidation$room_runtime_release", "stopTrackingTable", "syncTriggers", "syncTriggers$room_runtime_release", "validateAndResolveTableNames", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InvalidationTracker.kt */
public class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public AutoCloser autoCloser;
    public volatile SupportSQLiteStatement cleanupStatement;
    public final RoomDatabase database;
    public volatile boolean initialized;
    public MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    public final ObservedTableTracker observedTableTracker;
    public final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    public final AtomicBoolean pendingRefresh = new AtomicBoolean(false);
    public final Runnable refreshRunnable;
    public final Map<String, String> shadowTablesMap;
    public final Object syncTriggersLock;
    public final Map<String, Integer> tableIdLookup;
    public final String[] tablesNames;
    public final Object trackerLock;
    public final Map<String, Set<String>> viewTables;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0012\u0010\u0016\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "tableCount", "", "(I)V", "needsSync", "", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "tableObservers", "", "getTableObservers", "()[J", "triggerStateChanges", "", "triggerStates", "", "getTablesToSync", "onAdded", "tableIds", "onRemoved", "resetTriggerState", "", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InvalidationTracker.kt */
    public static final class ObservedTableTracker {
        public boolean needsSync;
        public final long[] tableObservers;
        public final int[] triggerStateChanges;
        public final boolean[] triggerStates;

        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                if (!this.needsSync) {
                    return null;
                }
                long[] jArr = this.tableObservers;
                int length = jArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    int i4 = 1;
                    boolean z = jArr[i] > 0;
                    if (z != this.triggerStates[i2]) {
                        int[] iArr = this.triggerStateChanges;
                        if (!z) {
                            i4 = 2;
                        }
                        iArr[i2] = i4;
                    } else {
                        this.triggerStateChanges[i2] = 0;
                    }
                    this.triggerStates[i2] = z;
                    i++;
                    i2 = i3;
                }
                this.needsSync = false;
                int[] iArr2 = (int[]) this.triggerStateChanges.clone();
                return iArr2;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\"\n\u0000\b&\u0018\u00002\u00020\u0001B#\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0015\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&R\u0014\u0010\t\u001a\u00020\n8PX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "firstTable", "", "rest", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "tables", "([Ljava/lang/String;)V", "isRemote", "", "isRemote$room_runtime_release", "()Z", "getTables$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "onInvalidated", "", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InvalidationTracker.kt */
    public static abstract class Observer {
        public final String[] tables;

        public Observer(String[] strArr) {
            Intrinsics.checkNotNullParameter(strArr, "tables");
            this.tables = strArr;
        }

        public abstract void onInvalidated(Set<String> set);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rH\u0000¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "observer", "Landroidx/room/InvalidationTracker$Observer;", "tableIds", "", "tableNames", "", "", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "singleTableSet", "", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "notifyByTableInvalidStatus", "", "invalidatedTablesIds", "", "notifyByTableInvalidStatus$room_runtime_release", "notifyByTableNames", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InvalidationTracker.kt */
    public static final class ObserverWrapper {
        public final Observer observer;
        public final Set<String> singleTableSet;
        public final int[] tableIds;
        public final String[] tableNames;

        public ObserverWrapper(Observer observer2, int[] iArr, String[] strArr) {
            Set<String> set;
            Intrinsics.checkNotNullParameter(observer2, "observer");
            Intrinsics.checkNotNullParameter(iArr, "tableIds");
            Intrinsics.checkNotNullParameter(strArr, "tableNames");
            this.observer = observer2;
            this.tableIds = iArr;
            this.tableNames = strArr;
            boolean z = true;
            if (!(strArr.length == 0)) {
                set = TweetUtils.setOf(this.tableNames[0]);
            } else {
                set = EmptySet.INSTANCE;
            }
            this.singleTableSet = set;
            if (!(this.tableIds.length != this.tableNames.length ? false : z)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> set) {
            Set set2;
            Intrinsics.checkNotNullParameter(set, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    SetBuilder setBuilder = new SetBuilder();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i]))) {
                            setBuilder.add(this.tableNames[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    set2 = TweetUtils.build((Set<E>) setBuilder);
                } else if (set.contains(Integer.valueOf(iArr[0]))) {
                    set2 = this.singleTableSet;
                } else {
                    set2 = EmptySet.INSTANCE;
                }
            } else {
                set2 = EmptySet.INSTANCE;
            }
            if (!set2.isEmpty()) {
                this.observer.onInvalidated(set2);
            }
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        String str;
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        Intrinsics.checkNotNullParameter(map, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(map2, "viewTables");
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.observedTableTracker = new ObservedTableTracker(strArr.length);
        Intrinsics.checkNotNullParameter(this.database, "database");
        Intrinsics.checkNotNullExpressionValue(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArr[i];
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str3 = this.shadowTablesMap.get(strArr[i]);
            if (str3 != null) {
                Locale locale2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale2, "US");
                str = str3.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Entry next : this.shadowTablesMap.entrySet()) {
            Locale locale3 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale3, "US");
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale3);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                Locale locale4 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale4, "US");
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale4);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.tableIdLookup;
                map3.put(lowerCase3, ArraysKt___ArraysJvmKt.getValue(map3, lowerCase2));
            }
        }
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapper;
        boolean z;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] strArr = observer.tables;
        SetBuilder setBuilder = new SetBuilder();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                Locale locale2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale2, "US");
                String lowerCase2 = str.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                Intrinsics.checkNotNull(set);
                setBuilder.addAll(set);
            } else {
                setBuilder.add(str);
            }
        }
        Object[] array = ((AbstractCollection) TweetUtils.build((Set<E>) setBuilder)).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr2 = (String[]) array;
        ArrayList arrayList = new ArrayList(strArr2.length);
        int length = strArr2.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr2[i];
            Map<String, Integer> map3 = this.tableIdLookup;
            Locale locale3 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale3, "US");
            String lowerCase3 = str2.toLowerCase(locale3);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map3.get(lowerCase3);
            if (num != null) {
                arrayList.add(Integer.valueOf(num.intValue()));
                i++;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("There is no table with name ", str2));
            }
        }
        int[] intArray = ArraysKt___ArraysJvmKt.toIntArray(arrayList);
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, intArray, strArr2);
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.putIfAbsent(observer, observerWrapper2);
        }
        if (observerWrapper == null) {
            ObservedTableTracker observedTableTracker2 = this.observedTableTracker;
            int[] copyOf = Arrays.copyOf(intArray, intArray.length);
            if (observedTableTracker2 != null) {
                Intrinsics.checkNotNullParameter(copyOf, "tableIds");
                synchronized (observedTableTracker2) {
                    z = false;
                    for (int i2 : copyOf) {
                        long j = observedTableTracker2.tableObservers[i2];
                        observedTableTracker2.tableObservers[i2] = 1 + j;
                        if (j == 0) {
                            observedTableTracker2.needsSync = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    syncTriggers$room_runtime_release();
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpen()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (!this.initialized) {
            return false;
        }
        return true;
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            ObservedTableTracker observedTableTracker2 = this.observedTableTracker;
            synchronized (observedTableTracker2) {
                Arrays.fill(observedTableTracker2.triggerStates, false);
                observedTableTracker2.needsSync = true;
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapper;
        boolean z;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.remove(observer);
        }
        if (observerWrapper != null) {
            ObservedTableTracker observedTableTracker2 = this.observedTableTracker;
            int[] iArr = observerWrapper.tableIds;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            if (observedTableTracker2 != null) {
                Intrinsics.checkNotNullParameter(copyOf, "tableIds");
                synchronized (observedTableTracker2) {
                    z = false;
                    for (int i : copyOf) {
                        long j = observedTableTracker2.tableObservers[i];
                        observedTableTracker2.tableObservers[i] = j - 1;
                        if (j == 1) {
                            observedTableTracker2.needsSync = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    syncTriggers$room_runtime_release();
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.tablesNames[i];
        for (String str2 : TRIGGERS) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            Intrinsics.checkNotNullParameter(str, "tableName");
            Intrinsics.checkNotNullParameter(str2, "triggerType");
            GeneratedOutlineSupport.outline103(sb, "`room_table_modification_trigger_" + str + '_' + str2 + '`', " AFTER ", str2, " ON `");
            GeneratedOutlineSupport.outline103(sb, str, "` BEGIN UPDATE ", "room_table_modification_log", " SET ");
            GeneratedOutlineSupport.outline103(sb, "invalidated", " = 1", " WHERE ", "table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(sb2);
        }
    }

    public final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.tablesNames[i];
        for (String checkNotNullParameter : TRIGGERS) {
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TRIGGER IF EXISTS ");
            Intrinsics.checkNotNullParameter(str, "tableName");
            Intrinsics.checkNotNullParameter(checkNotNullParameter, "triggerType");
            sb.append("`room_table_modification_trigger_" + str + '_' + checkNotNullParameter + '`');
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(sb2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.unlock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void syncTriggers$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase r10) {
        /*
            r9 = this;
            java.lang.String r0 = "database"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10.inTransaction()
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            androidx.room.RoomDatabase r0 = r9.database     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock$room_runtime_release()     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            r0.lock()     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            java.lang.Object r1 = r9.syncTriggersLock     // Catch:{ all -> 0x0066 }
            monitor-enter(r1)     // Catch:{ all -> 0x0066 }
            androidx.room.InvalidationTracker$ObservedTableTracker r2 = r9.observedTableTracker     // Catch:{ all -> 0x0034 }
            int[] r2 = r2.getTablesToSync()     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x0025
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            r0.unlock()     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            return
        L_0x0025:
            java.lang.String r3 = "database"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r3)     // Catch:{ all -> 0x0034 }
            boolean r3 = r10.isWriteAheadLoggingEnabled()     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0036
            r10.beginTransactionNonExclusive()     // Catch:{ all -> 0x0034 }
            goto L_0x0039
        L_0x0034:
            r10 = move-exception
            goto L_0x0064
        L_0x0036:
            r10.beginTransaction()     // Catch:{ all -> 0x0034 }
        L_0x0039:
            int r3 = r2.length     // Catch:{ all -> 0x005f }
            r4 = 0
            r5 = 0
        L_0x003c:
            if (r4 >= r3) goto L_0x0054
            r6 = r2[r4]     // Catch:{ all -> 0x005f }
            int r7 = r5 + 1
            r8 = 1
            if (r6 == r8) goto L_0x004d
            r8 = 2
            if (r6 == r8) goto L_0x0049
            goto L_0x0050
        L_0x0049:
            r9.stopTrackingTable(r10, r5)     // Catch:{ all -> 0x005f }
            goto L_0x0050
        L_0x004d:
            r9.startTrackingTable(r10, r5)     // Catch:{ all -> 0x005f }
        L_0x0050:
            int r4 = r4 + 1
            r5 = r7
            goto L_0x003c
        L_0x0054:
            r10.setTransactionSuccessful()     // Catch:{ all -> 0x005f }
            r10.endTransaction()     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            r0.unlock()     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            goto L_0x006b
        L_0x005f:
            r2 = move-exception
            r10.endTransaction()     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x0064:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            throw r10     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r10 = move-exception
            r0.unlock()     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
            throw r10     // Catch:{ SQLiteException | IllegalStateException -> 0x006b }
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.syncTriggers$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }
}
