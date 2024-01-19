package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.List;

public final class SchemaManager extends SQLiteOpenHelper {
    public static final String CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL;
    public static final List<Migration> INCREMENTAL_MIGRATIONS;
    public static final Migration MIGRATE_TO_V1 = $$Lambda$SchemaManager$OryUNQUvlV1zPxAbQpc_K9Bcpc.INSTANCE;
    public static final Migration MIGRATE_TO_V2 = $$Lambda$SchemaManager$V2XpHOEqNsxjZeHRKfPgpBoXd8.INSTANCE;
    public static final Migration MIGRATE_TO_V3 = $$Lambda$SchemaManager$KMc4V7kHVkAjH45Fz8HtRNyME4U.INSTANCE;
    public static final Migration MIGRATE_TO_V4 = $$Lambda$SchemaManager$GnoKRnczwOa6Fk7ZCPhACcfPzQ.INSTANCE;
    public static final Migration MIGRATION_TO_V5;
    public static int SCHEMA_VERSION = 5;
    public boolean configured = false;
    public final int schemaVersion;

    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("INSERT INTO global_log_event_state VALUES (");
        outline73.append(System.currentTimeMillis());
        outline73.append(")");
        CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL = outline73.toString();
        $$Lambda$SchemaManager$T1DaSoWWCWfbynOycgGeN7VwVk r1 = $$Lambda$SchemaManager$T1DaSoWWCWfbynOycgGeN7VwVk.INSTANCE;
        MIGRATION_TO_V5 = r1;
        INCREMENTAL_MIGRATIONS = Arrays.asList(new Migration[]{MIGRATE_TO_V1, MIGRATE_TO_V2, MIGRATE_TO_V3, MIGRATE_TO_V4, r1});
    }

    public SchemaManager(Context context, String str, int i) {
        super(context, str, null, i);
        this.schemaVersion = i;
    }

    public static /* synthetic */ void lambda$static$0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void lambda$static$1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void lambda$static$3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void lambda$static$4(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL);
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.configured = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.schemaVersion;
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, i);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, i, i2);
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= INCREMENTAL_MIGRATIONS.size()) {
            while (i < i2) {
                INCREMENTAL_MIGRATIONS.get(i).upgrade(sQLiteDatabase);
                i++;
            }
            return;
        }
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
        outline75.append(INCREMENTAL_MIGRATIONS.size());
        outline75.append(" migrations are provided");
        throw new IllegalArgumentException(outline75.toString());
    }
}
