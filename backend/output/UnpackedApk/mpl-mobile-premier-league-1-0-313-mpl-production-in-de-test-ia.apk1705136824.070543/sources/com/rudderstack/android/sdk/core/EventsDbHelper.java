package com.rudderstack.android.sdk.core;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase.OpenParams;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Locale;

public final class EventsDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "rl_persistence.db";
    public static final int DB_VERSION = 1;
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_ID = "id";
    public static final String UPDATED = "updated";

    public EventsDbHelper(Context context) {
        this(context, (String) DB_NAME, (CursorFactory) null, 1);
    }

    private void createSchema(SQLiteDatabase sQLiteDatabase) {
        String format = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS '%s' ('%s' INTEGER PRIMARY KEY AUTOINCREMENT, '%s' TEXT NOT NULL, '%s' INTEGER NOT NULL)", new Object[]{"events", "id", "message", UPDATED});
        RudderLogger.logVerbose(String.format(Locale.US, "DBPersistentManager: createSchema: createSchemaSQL: %s", new Object[]{format}));
        sQLiteDatabase.execSQL(format);
        RudderLogger.logInfo("DBPersistentManager: createSchema: DB Schema created");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createSchema(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public EventsDbHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public EventsDbHelper(Context context, String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i, databaseErrorHandler);
    }

    public EventsDbHelper(Context context, String str, int i, OpenParams openParams) {
        super(context, str, i, openParams);
    }
}
