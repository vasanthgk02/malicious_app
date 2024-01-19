package com.nozbe.watermelondb;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004CDEFB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\n\u0010!\u001a\u00060\u0005j\u0002`\"J\u0006\u0010#\u001a\u00020\u001bJ\u0012\u0010$\u001a\u00020\u00072\n\u0010!\u001a\u00060\u0005j\u0002`\"J7\u0010%\u001a\u00020\u001b2\n\u0010&\u001a\u00060\u0005j\u0002`\u00152\n\u0010!\u001a\u00060\u0005j\u0002`\"2\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020\u00010(j\u0002`)H\u0002¢\u0006\u0002\u0010*J)\u0010+\u001a\u00020\u001b2\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\u0010\u0010,\u001a\f\u0012\u0004\u0012\u00020\u00010(j\u0002`)¢\u0006\u0002\u0010-J+\u0010.\u001a\u00020\u001b2\n\u0010!\u001a\u00060\u0005j\u0002`\"2\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020\u00010(j\u0002`)H\u0002¢\u0006\u0002\u0010-J \u0010/\u001a\u0004\u0018\u00010\u00012\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\n\u0010&\u001a\u00060\u0005j\u0002`\u0015J\u0012\u00100\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0005j\u0002`\u0013J\u0010\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u0005J \u00103\u001a\u0002042\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\n\u0010&\u001a\u00060\u0005j\u0002`\u0015H\u0002J\u0014\u00105\u001a\u0002062\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0002J \u00107\u001a\u00020\u001b2\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\n\u0010&\u001a\u00060\u0005j\u0002`\u0015H\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J'\u00109\u001a\u0004\u0018\u0001042\n\u0010 \u001a\u00060\u0005j\u0002`\u00132\n\u0010&\u001a\u00060\u0005j\u0002`\u0015H\u0002¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0005J\u0016\u0010<\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010?\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010@\u001a\u00020\u001b*\u00020\u001f2\u0006\u0010A\u001a\u00020BH\u0002R(\u0010\u0011\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0013\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\u00150\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver;", "", "context", "Landroid/content/Context;", "dbName", "", "schemaVersion", "", "Lcom/nozbe/watermelondb/SchemaVersion;", "(Landroid/content/Context;Ljava/lang/String;I)V", "schema", "Lcom/nozbe/watermelondb/Schema;", "(Landroid/content/Context;Ljava/lang/String;Lcom/nozbe/watermelondb/Schema;)V", "migrations", "Lcom/nozbe/watermelondb/MigrationSet;", "(Landroid/content/Context;Ljava/lang/String;Lcom/nozbe/watermelondb/MigrationSet;)V", "(Landroid/content/Context;Ljava/lang/String;)V", "cachedRecords", "", "Lcom/nozbe/watermelondb/TableName;", "", "Lcom/nozbe/watermelondb/RecordID;", "database", "Lcom/nozbe/watermelondb/Database;", "log", "Ljava/util/logging/Logger;", "batch", "", "operations", "Lcom/facebook/react/bridge/ReadableArray;", "cachedQuery", "Lcom/facebook/react/bridge/WritableArray;", "table", "query", "Lcom/nozbe/watermelondb/SQL;", "close", "count", "create", "id", "args", "", "Lcom/nozbe/watermelondb/QueryArgs;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "destroyDeletedRecords", "records", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execute", "find", "getDeletedRecords", "getLocal", "key", "isCached", "", "isCompatible", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility;", "markAsCached", "migrate", "removeFromCache", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "removeLocal", "setLocal", "value", "setUpSchema", "unsafeResetDatabase", "pushMapFromCursor", "cursor", "Landroid/database/Cursor;", "MigrationNeededError", "Operation", "SchemaCompatibility", "SchemaNeededError", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseDriver.kt */
public final class DatabaseDriver {
    public final Map<String, List<String>> cachedRecords;
    public final Database database;
    public final Logger log;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$MigrationNeededError;", "Ljava/lang/Exception;", "databaseVersion", "", "Lcom/nozbe/watermelondb/SchemaVersion;", "(I)V", "getDatabaseVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DatabaseDriver.kt */
    public static final class MigrationNeededError extends Exception {
        public final int databaseVersion;

        public MigrationNeededError(int i) {
            this.databaseVersion = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MigrationNeededError) && this.databaseVersion == ((MigrationNeededError) obj).databaseVersion;
        }

        public int hashCode() {
            return this.databaseVersion;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline56(GeneratedOutlineSupport.outline73("MigrationNeededError(databaseVersion="), this.databaseVersion, ')');
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility;", "", "()V", "Compatible", "NeedsMigration", "NeedsSetup", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$Compatible;", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$NeedsSetup;", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$NeedsMigration;", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DatabaseDriver.kt */
    public static abstract class SchemaCompatibility {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$Compatible;", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility;", "()V", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DatabaseDriver.kt */
        public static final class Compatible extends SchemaCompatibility {
            public static final Compatible INSTANCE = new Compatible();

            public Compatible() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$NeedsMigration;", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility;", "fromVersion", "", "Lcom/nozbe/watermelondb/SchemaVersion;", "(I)V", "getFromVersion", "()I", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DatabaseDriver.kt */
        public static final class NeedsMigration extends SchemaCompatibility {
            public final int fromVersion;

            public NeedsMigration(int i) {
                super(null);
                this.fromVersion = i;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility$NeedsSetup;", "Lcom/nozbe/watermelondb/DatabaseDriver$SchemaCompatibility;", "()V", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DatabaseDriver.kt */
        public static final class NeedsSetup extends SchemaCompatibility {
            public static final NeedsSetup INSTANCE = new NeedsSetup();

            public NeedsSetup() {
                super(null);
            }
        }

        public SchemaCompatibility(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/nozbe/watermelondb/DatabaseDriver$SchemaNeededError;", "Ljava/lang/Exception;", "()V", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DatabaseDriver.kt */
    public static final class SchemaNeededError extends Exception {
    }

    public DatabaseDriver(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "dbName");
        this.database = new Database(str, context);
        this.log = null;
        this.cachedRecords = new LinkedHashMap();
    }

    public final void markAsCached(String str, String str2) {
        List list = this.cachedRecords.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(str2);
        this.cachedRecords.put(str, list);
    }

    public final void unsafeResetDatabase(Schema schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Logger logger = this.log;
        if (logger != null) {
            logger.info("Unsafe Reset Database");
        }
        Database database2 = this.database;
        if (database2 != null) {
            database2.transaction(new Database$unsafeDestroyEverything$1(database2));
            this.cachedRecords.clear();
            this.database.transaction(new DatabaseDriver$setUpSchema$1(this, schema));
            return;
        }
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseDriver(android.content.Context r4, java.lang.String r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "dbName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r3.<init>(r4, r5)
            com.nozbe.watermelondb.Database r4 = r3.database
            int r4 = r4.getUserVersion()
            if (r4 != r6) goto L_0x0018
            com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$Compatible r4 = com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.Compatible.INSTANCE
            goto L_0x0041
        L_0x0018:
            if (r4 != 0) goto L_0x001d
            com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$NeedsSetup r4 = com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.NeedsSetup.INSTANCE
            goto L_0x0041
        L_0x001d:
            r5 = 0
            r0 = 1
            if (r0 > r4) goto L_0x0024
            if (r4 >= r6) goto L_0x0024
            r5 = 1
        L_0x0024:
            if (r5 == 0) goto L_0x002d
            com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$NeedsMigration r5 = new com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$NeedsMigration
            r5.<init>(r4)
            r4 = r5
            goto L_0x0041
        L_0x002d:
            java.util.logging.Logger r5 = r3.log
            if (r5 != 0) goto L_0x0032
            goto L_0x003f
        L_0x0032:
            java.lang.String r0 = "Database has newer version ("
            java.lang.String r1 = ") than what the app supports ("
            java.lang.String r2 = "). Will reset database."
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline44(r0, r4, r1, r6, r2)
            r5.info(r4)
        L_0x003f:
            com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$NeedsSetup r4 = com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.NeedsSetup.INSTANCE
        L_0x0041:
            boolean r5 = r4 instanceof com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.NeedsSetup
            if (r5 != 0) goto L_0x0054
            boolean r5 = r4 instanceof com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.NeedsMigration
            if (r5 != 0) goto L_0x004a
            return
        L_0x004a:
            com.nozbe.watermelondb.DatabaseDriver$MigrationNeededError r5 = new com.nozbe.watermelondb.DatabaseDriver$MigrationNeededError
            com.nozbe.watermelondb.DatabaseDriver$SchemaCompatibility$NeedsMigration r4 = (com.nozbe.watermelondb.DatabaseDriver.SchemaCompatibility.NeedsMigration) r4
            int r4 = r4.fromVersion
            r5.<init>(r4)
            throw r5
        L_0x0054:
            com.nozbe.watermelondb.DatabaseDriver$SchemaNeededError r4 = new com.nozbe.watermelondb.DatabaseDriver$SchemaNeededError
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nozbe.watermelondb.DatabaseDriver.<init>(android.content.Context, java.lang.String, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseDriver(Context context, String str, MigrationSet migrationSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(str, "dbName");
        // Intrinsics.checkNotNullParameter(migrationSet, "migrations");
        this(context, str);
        if (this.database.getUserVersion() == migrationSet.from) {
            this.database.transaction(new DatabaseDriver$migrate$2(this, migrationSet));
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Incompatible migration set applied. DB: ");
        outline73.append(this.database.getUserVersion());
        outline73.append(", migration: ");
        outline73.append(migrationSet.from);
        throw new IllegalArgumentException(outline73.toString().toString());
    }
}
