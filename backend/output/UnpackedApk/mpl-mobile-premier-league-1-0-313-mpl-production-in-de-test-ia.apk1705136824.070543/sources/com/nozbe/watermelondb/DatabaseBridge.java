package com.nozbe.watermelondb;

import android.content.Context;
import android.database.SQLException;
import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.nozbe.watermelondb.DatabaseDriver.MigrationNeededError;
import com.nozbe.watermelondb.DatabaseDriver.SchemaNeededError;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0015\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0019\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0014\u0010\u001d\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0007j\u0002`\bH\u0002J4\u0010\u001e\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u001b2\n\u0010\u001f\u001a\u00060\u0017j\u0002` 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010!\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010\"\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010$\u001a\u00020\u0017H\u0016J,\u0010%\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J4\u0010\u0016\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u001b2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010(\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J,\u0010)\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007JH\u0010+\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010&\u001a\u00020\u00172\n\u0010,\u001a\u00060\u0017j\u0002`\u00182\n\u0010-\u001a\u00060\u0007j\u0002`.2\n\u0010/\u001a\u00060\u0007j\u0002`.2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J<\u00100\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010&\u001a\u00020\u00172\n\u00101\u001a\u00060\u0017j\u0002`\u00182\n\u0010'\u001a\u00060\u0007j\u0002`.2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J4\u00102\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\n\u00101\u001a\u00060\u0017j\u0002`\u00182\n\u0010'\u001a\u00060\u0007j\u0002`.2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J2\u00103\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010605H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseBridge;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "connections", "", "", "Lcom/nozbe/watermelondb/ConnectionTag;", "Lcom/nozbe/watermelondb/DatabaseBridge$Connection;", "batch", "", "tag", "operations", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lcom/facebook/react/bridge/Promise;", "connectDriver", "connectionTag", "driver", "Lcom/nozbe/watermelondb/DatabaseDriver;", "count", "query", "", "Lcom/nozbe/watermelondb/SQL;", "destroyDeletedRecords", "table", "Lcom/nozbe/watermelondb/TableName;", "records", "disconnectDriver", "find", "id", "Lcom/nozbe/watermelondb/RecordID;", "getDeletedRecords", "getLocal", "key", "getName", "initialize", "databaseName", "schemaVersion", "removeLocal", "setLocal", "value", "setUpWithMigrations", "migrations", "fromVersion", "Lcom/nozbe/watermelondb/SchemaVersion;", "toVersion", "setUpWithSchema", "schema", "unsafeResetDatabase", "withDriver", "function", "Lkotlin/Function1;", "", "Connection", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge extends ReactContextBaseJavaModule {
    public final Map<Integer, Connection> connections = new LinkedHashMap();
    public final ReactApplicationContext reactContext;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseBridge$Connection;", "", "()V", "queue", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getQueue", "()Ljava/util/ArrayList;", "Connected", "Waiting", "Lcom/nozbe/watermelondb/DatabaseBridge$Connection$Connected;", "Lcom/nozbe/watermelondb/DatabaseBridge$Connection$Waiting;", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DatabaseBridge.kt */
    public static abstract class Connection {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseBridge$Connection$Connected;", "Lcom/nozbe/watermelondb/DatabaseBridge$Connection;", "driver", "Lcom/nozbe/watermelondb/DatabaseDriver;", "(Lcom/nozbe/watermelondb/DatabaseDriver;)V", "getDriver", "()Lcom/nozbe/watermelondb/DatabaseDriver;", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DatabaseBridge.kt */
        public static final class Connected extends Connection {
            public final DatabaseDriver driver;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public Connected(DatabaseDriver databaseDriver) {
                // Intrinsics.checkNotNullParameter(databaseDriver, "driver");
                super(null);
                this.driver = databaseDriver;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\"\u0010\u0002\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u0006¢\u0006\u0002\u0010\u0007R-\u0010\u0002\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseBridge$Connection$Waiting;", "Lcom/nozbe/watermelondb/DatabaseBridge$Connection;", "queueInWaiting", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getQueueInWaiting", "()Ljava/util/ArrayList;", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DatabaseBridge.kt */
        public static final class Waiting extends Connection {
            public final ArrayList<Function0<Unit>> queueInWaiting;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public Waiting(ArrayList<Function0<Unit>> arrayList) {
                // Intrinsics.checkNotNullParameter(arrayList, "queueInWaiting");
                super(null);
                this.queueInWaiting = arrayList;
            }
        }

        public Connection() {
        }

        public final ArrayList<Function0<Unit>> getQueue() {
            if (this instanceof Connected) {
                return new ArrayList<>();
            }
            if (this instanceof Waiting) {
                return ((Waiting) this).queueInWaiting;
            }
            throw new NoWhenBranchMatchedException();
        }

        public Connection(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private final void connectDriver(int i, DatabaseDriver databaseDriver, Promise promise) {
        Connection connection = this.connections.get(Integer.valueOf(i));
        ArrayList<Function0<Unit>> queue = connection == null ? null : connection.getQueue();
        if (queue == null) {
            queue = new ArrayList<>();
        }
        this.connections.put(Integer.valueOf(i), new Connected(databaseDriver));
        Iterator<Function0<Unit>> it = queue.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        promise.resolve(Boolean.TRUE);
    }

    private final void disconnectDriver(int i) {
        Connection connection = this.connections.get(Integer.valueOf(i));
        ArrayList<Function0<Unit>> queue = connection == null ? null : connection.getQueue();
        if (queue == null) {
            queue = new ArrayList<>();
        }
        this.connections.remove(Integer.valueOf(i));
        Iterator<Function0<Unit>> it = queue.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    /* access modifiers changed from: private */
    public final void withDriver(int i, Promise promise, Function1<? super DatabaseDriver, ? extends Object> function1) throws Exception {
        Method enclosingMethod = function1.getClass().getEnclosingMethod();
        String name = enclosingMethod == null ? null : enclosingMethod.getName();
        try {
            Trace.beginSection(Intrinsics.stringPlus("DatabaseBridge.", name));
            Object obj = this.connections.get(Integer.valueOf(i));
            if (obj == null) {
                promise.reject((Throwable) new Exception("No driver with tag " + i + " available"));
                obj = Unit.INSTANCE;
            }
            if (obj instanceof Connected) {
                Object invoke = function1.invoke(((Connected) obj).driver);
                if (invoke == Unit.INSTANCE) {
                    invoke = Boolean.TRUE;
                }
                promise.resolve(invoke);
            } else if (obj instanceof Waiting) {
                ((Waiting) obj).getQueue().add(new DatabaseBridge$withDriver$1(this, i, promise, function1));
                this.connections.put(Integer.valueOf(i), new Waiting(((Waiting) obj).getQueue()));
            }
        } catch (SQLException e2) {
            promise.reject(name, (Throwable) e2);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
        Trace.endSection();
    }

    @ReactMethod
    public final void batch(int i, ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(readableArray, "operations");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$batch$1(readableArray));
    }

    @ReactMethod
    public final void count(int i, String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$count$1(str));
    }

    @ReactMethod
    public final void destroyDeletedRecords(int i, String str, ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(readableArray, "records");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$destroyDeletedRecords$1(str, readableArray));
    }

    @ReactMethod
    public final void find(int i, String str, String str2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$find$1(str, str2));
    }

    @ReactMethod
    public final void getDeletedRecords(int i, String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$getDeletedRecords$1(str));
    }

    @ReactMethod
    public final void getLocal(int i, String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$getLocal$1(str));
    }

    public String getName() {
        return "DatabaseBridge";
    }

    @ReactMethod
    public final void initialize(int i, String str, int i2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        boolean z = this.connections.get(Integer.valueOf(i)) == null;
        if (!_Assertions.ENABLED || z) {
            WritableMap createMap = Arguments.createMap();
            try {
                this.connections.put(Integer.valueOf(i), new Connected(new DatabaseDriver((Context) this.reactContext, str, i2)));
                createMap.putString("code", "ok");
                promise.resolve(createMap);
            } catch (SchemaNeededError unused) {
                this.connections.put(Integer.valueOf(i), new Waiting(new ArrayList()));
                createMap.putString("code", "schema_needed");
                promise.resolve(createMap);
            } catch (MigrationNeededError e2) {
                this.connections.put(Integer.valueOf(i), new Waiting(new ArrayList()));
                createMap.putString("code", "migrations_needed");
                createMap.putInt("databaseVersion", e2.databaseVersion);
                promise.resolve(createMap);
            } catch (Exception e3) {
                promise.reject((Throwable) e3);
            }
        } else {
            throw new AssertionError(GeneratedOutlineSupport.outline42("A driver with tag ", i, " already set up"));
        }
    }

    @ReactMethod
    public final void query(int i, String str, String str2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(str2, "query");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$query$1(str, str2));
    }

    @ReactMethod
    public final void removeLocal(int i, String str, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$removeLocal$1(str));
    }

    @ReactMethod
    public final void setLocal(int i, String str, String str2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$setLocal$1(str, str2));
    }

    @ReactMethod
    public final void setUpWithMigrations(int i, String str, String str2, int i2, int i3, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(str2, "migrations");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            connectDriver(i, new DatabaseDriver((Context) this.reactContext, str, new MigrationSet(i2, i3, str2)), promise);
        } catch (Exception e2) {
            disconnectDriver(i);
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public final void setUpWithSchema(int i, String str, String str2, int i2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "databaseName");
        Intrinsics.checkNotNullParameter(str2, "schema");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ReactApplicationContext reactApplicationContext = this.reactContext;
        Schema schema = new Schema(i2, str2);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        Intrinsics.checkNotNullParameter(str, "dbName");
        Intrinsics.checkNotNullParameter(schema, "schema");
        DatabaseDriver databaseDriver = new DatabaseDriver(reactApplicationContext, str);
        databaseDriver.unsafeResetDatabase(schema);
        connectDriver(i, databaseDriver, promise);
    }

    @ReactMethod
    public final void unsafeResetDatabase(int i, String str, int i2, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "schema");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        withDriver(i, promise, new DatabaseBridge$unsafeResetDatabase$1(i2, str));
    }
}
