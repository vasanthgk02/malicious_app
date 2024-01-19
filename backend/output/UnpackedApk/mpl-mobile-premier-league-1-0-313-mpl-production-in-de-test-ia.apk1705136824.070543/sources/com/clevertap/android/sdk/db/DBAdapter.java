package com.clevertap.android.sdk.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class DBAdapter {
    public static final String CREATE_EVENTS_TABLE;
    public static final String CREATE_INBOX_MESSAGES_TABLE;
    public static final String CREATE_NOTIFICATION_VIEWED_TABLE;
    public static final String CREATE_PROFILE_EVENTS_TABLE;
    public static final String CREATE_PUSH_NOTIFICATIONS_TABLE;
    public static final String CREATE_UNINSTALL_TS_TABLE;
    public static final String CREATE_USER_PROFILES_TABLE;
    public static final String DROP_TABLE_INBOX_MESSAGES;
    public static final String DROP_TABLE_PUSH_NOTIFICATION_VIEWED;
    public static final String DROP_TABLE_UNINSTALL_TS;
    public static final String EVENTS_TIME_INDEX;
    public static final String INBOX_MESSAGES_COMP_ID_USERID_INDEX;
    public static final String NOTIFICATION_VIEWED_INDEX;
    public static final String PROFILE_EVENTS_TIME_INDEX;
    public static final String PUSH_NOTIFICATIONS_TIME_INDEX;
    public static final String UNINSTALL_TS_INDEX;
    public CleverTapInstanceConfig config;
    public final DatabaseHelper dbHelper;
    public boolean rtlDirtyFlag;

    public static class DatabaseHelper extends SQLiteOpenHelper {
        public final File databaseFile;

        public DatabaseHelper(Context context, String str) {
            super(context, str, null, 3);
            this.databaseFile = context.getDatabasePath(str);
        }

        public void deleteDatabase() {
            close();
            this.databaseFile.delete();
        }

        @SuppressLint({"SQLiteString"})
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Logger.v("Creating CleverTap DB");
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_EVENTS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_EVENTS_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_PROFILE_EVENTS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_PROFILE_EVENTS_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_USER_PROFILES_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_USER_PROFILES_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_INBOX_MESSAGES_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_INBOX_MESSAGES_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_PUSH_NOTIFICATIONS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_PUSH_NOTIFICATIONS_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_UNINSTALL_TS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_UNINSTALL_TS_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.EVENTS_TIME_INDEX, sQLiteDatabase.compileStatement(DBAdapter.EVENTS_TIME_INDEX));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.PROFILE_EVENTS_TIME_INDEX, sQLiteDatabase.compileStatement(DBAdapter.PROFILE_EVENTS_TIME_INDEX));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.UNINSTALL_TS_INDEX, sQLiteDatabase.compileStatement(DBAdapter.UNINSTALL_TS_INDEX));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.PUSH_NOTIFICATIONS_TIME_INDEX, sQLiteDatabase.compileStatement(DBAdapter.PUSH_NOTIFICATIONS_TIME_INDEX));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.INBOX_MESSAGES_COMP_ID_USERID_INDEX, sQLiteDatabase.compileStatement(DBAdapter.INBOX_MESSAGES_COMP_ID_USERID_INDEX));
            GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.NOTIFICATION_VIEWED_INDEX, sQLiteDatabase.compileStatement(DBAdapter.NOTIFICATION_VIEWED_INDEX));
        }

        @SuppressLint({"SQLiteString"})
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Logger.v("Upgrading CleverTap DB to version " + i2);
            if (i == 1) {
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.DROP_TABLE_UNINSTALL_TS, sQLiteDatabase.compileStatement(DBAdapter.DROP_TABLE_UNINSTALL_TS));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.DROP_TABLE_INBOX_MESSAGES, sQLiteDatabase.compileStatement(DBAdapter.DROP_TABLE_INBOX_MESSAGES));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.DROP_TABLE_PUSH_NOTIFICATION_VIEWED, sQLiteDatabase.compileStatement(DBAdapter.DROP_TABLE_PUSH_NOTIFICATION_VIEWED));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_INBOX_MESSAGES_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_INBOX_MESSAGES_TABLE));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_PUSH_NOTIFICATIONS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_PUSH_NOTIFICATIONS_TABLE));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_UNINSTALL_TS_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_UNINSTALL_TS_TABLE));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.UNINSTALL_TS_INDEX, sQLiteDatabase.compileStatement(DBAdapter.UNINSTALL_TS_INDEX));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.PUSH_NOTIFICATIONS_TIME_INDEX, sQLiteDatabase.compileStatement(DBAdapter.PUSH_NOTIFICATIONS_TIME_INDEX));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.INBOX_MESSAGES_COMP_ID_USERID_INDEX, sQLiteDatabase.compileStatement(DBAdapter.INBOX_MESSAGES_COMP_ID_USERID_INDEX));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.NOTIFICATION_VIEWED_INDEX, sQLiteDatabase.compileStatement(DBAdapter.NOTIFICATION_VIEWED_INDEX));
            } else if (i == 2) {
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.DROP_TABLE_PUSH_NOTIFICATION_VIEWED, sQLiteDatabase.compileStatement(DBAdapter.DROP_TABLE_PUSH_NOTIFICATION_VIEWED));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE, sQLiteDatabase.compileStatement(DBAdapter.CREATE_NOTIFICATION_VIEWED_TABLE));
                GeneratedOutlineSupport.outline100(GeneratedOutlineSupport.outline73("Executing - "), DBAdapter.NOTIFICATION_VIEWED_INDEX, sQLiteDatabase.compileStatement(DBAdapter.NOTIFICATION_VIEWED_INDEX));
            }
        }
    }

    public enum Table {
        EVENTS("events"),
        PROFILE_EVENTS("profileEvents"),
        USER_PROFILES("userProfiles"),
        INBOX_MESSAGES("inboxMessages"),
        PUSH_NOTIFICATIONS("pushNotifications"),
        UNINSTALL_TS("uninstallTimestamp"),
        PUSH_NOTIFICATION_VIEWED("notificationViewed");
        
        public final String tableName;

        /* access modifiers changed from: public */
        Table(String str) {
            this.tableName = str;
        }

        public String getName() {
            return this.tableName;
        }
    }

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline73.append(Table.EVENTS.getName());
        outline73.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline73.append("data");
        outline73.append(" STRING NOT NULL, ");
        CREATE_EVENTS_TABLE = GeneratedOutlineSupport.outline62(outline73, "created_at", " INTEGER NOT NULL);");
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline732.append(Table.PROFILE_EVENTS.getName());
        outline732.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline732.append("data");
        outline732.append(" STRING NOT NULL, ");
        CREATE_PROFILE_EVENTS_TABLE = GeneratedOutlineSupport.outline62(outline732, "created_at", " INTEGER NOT NULL);");
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline733.append(Table.USER_PROFILES.getName());
        outline733.append(" (_id STRING UNIQUE PRIMARY KEY, ");
        outline733.append("data");
        outline733.append(" STRING NOT NULL);");
        CREATE_USER_PROFILES_TABLE = outline733.toString();
        StringBuilder outline734 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline734.append(Table.INBOX_MESSAGES.getName());
        outline734.append(" (_id STRING NOT NULL, ");
        outline734.append("data");
        outline734.append(" TEXT NOT NULL, ");
        GeneratedOutlineSupport.outline103(outline734, "wzrkParams", " TEXT NOT NULL, ", "campaignId", " STRING NOT NULL, ");
        GeneratedOutlineSupport.outline103(outline734, "tags", " TEXT NOT NULL, ", "isRead", " INTEGER NOT NULL DEFAULT 0, ");
        GeneratedOutlineSupport.outline103(outline734, "expires", " INTEGER NOT NULL, ", "created_at", " INTEGER NOT NULL, ");
        CREATE_INBOX_MESSAGES_TABLE = GeneratedOutlineSupport.outline62(outline734, "messageUser", " STRING NOT NULL);");
        StringBuilder outline735 = GeneratedOutlineSupport.outline73("CREATE UNIQUE INDEX IF NOT EXISTS userid_id_idx ON ");
        outline735.append(Table.INBOX_MESSAGES.getName());
        outline735.append(" (");
        outline735.append("messageUser");
        outline735.append(",");
        INBOX_MESSAGES_COMP_ID_USERID_INDEX = GeneratedOutlineSupport.outline62(outline735, "_id", ");");
        StringBuilder outline736 = GeneratedOutlineSupport.outline73("CREATE INDEX IF NOT EXISTS time_idx ON ");
        outline736.append(Table.EVENTS.getName());
        outline736.append(" (");
        outline736.append("created_at");
        outline736.append(");");
        EVENTS_TIME_INDEX = outline736.toString();
        StringBuilder outline737 = GeneratedOutlineSupport.outline73("CREATE INDEX IF NOT EXISTS time_idx ON ");
        outline737.append(Table.PROFILE_EVENTS.getName());
        outline737.append(" (");
        outline737.append("created_at");
        outline737.append(");");
        PROFILE_EVENTS_TIME_INDEX = outline737.toString();
        StringBuilder outline738 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline738.append(Table.PUSH_NOTIFICATIONS.getName());
        outline738.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline738.append("data");
        outline738.append(" STRING NOT NULL, ");
        outline738.append("created_at");
        outline738.append(" INTEGER NOT NULL,");
        outline738.append("isRead");
        outline738.append(" INTEGER NOT NULL);");
        CREATE_PUSH_NOTIFICATIONS_TABLE = outline738.toString();
        StringBuilder outline739 = GeneratedOutlineSupport.outline73("CREATE INDEX IF NOT EXISTS time_idx ON ");
        outline739.append(Table.PUSH_NOTIFICATIONS.getName());
        outline739.append(" (");
        outline739.append("created_at");
        outline739.append(");");
        PUSH_NOTIFICATIONS_TIME_INDEX = outline739.toString();
        StringBuilder outline7310 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline7310.append(Table.UNINSTALL_TS.getName());
        outline7310.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline7310.append("created_at");
        outline7310.append(" INTEGER NOT NULL);");
        CREATE_UNINSTALL_TS_TABLE = outline7310.toString();
        StringBuilder outline7311 = GeneratedOutlineSupport.outline73("CREATE INDEX IF NOT EXISTS time_idx ON ");
        outline7311.append(Table.UNINSTALL_TS.getName());
        outline7311.append(" (");
        outline7311.append("created_at");
        outline7311.append(");");
        UNINSTALL_TS_INDEX = outline7311.toString();
        StringBuilder outline7312 = GeneratedOutlineSupport.outline73("CREATE TABLE ");
        outline7312.append(Table.PUSH_NOTIFICATION_VIEWED.getName());
        outline7312.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        outline7312.append("data");
        outline7312.append(" STRING NOT NULL, ");
        CREATE_NOTIFICATION_VIEWED_TABLE = GeneratedOutlineSupport.outline62(outline7312, "created_at", " INTEGER NOT NULL);");
        StringBuilder outline7313 = GeneratedOutlineSupport.outline73("CREATE INDEX IF NOT EXISTS time_idx ON ");
        outline7313.append(Table.PUSH_NOTIFICATION_VIEWED.getName());
        outline7313.append(" (");
        outline7313.append("created_at");
        outline7313.append(");");
        NOTIFICATION_VIEWED_INDEX = outline7313.toString();
        StringBuilder outline7314 = GeneratedOutlineSupport.outline73("DROP TABLE IF EXISTS ");
        outline7314.append(Table.UNINSTALL_TS.getName());
        DROP_TABLE_UNINSTALL_TS = outline7314.toString();
        StringBuilder outline7315 = GeneratedOutlineSupport.outline73("DROP TABLE IF EXISTS ");
        outline7315.append(Table.INBOX_MESSAGES.getName());
        DROP_TABLE_INBOX_MESSAGES = outline7315.toString();
        StringBuilder outline7316 = GeneratedOutlineSupport.outline73("DROP TABLE IF EXISTS ");
        outline7316.append(Table.PUSH_NOTIFICATION_VIEWED.getName());
        DROP_TABLE_PUSH_NOTIFICATION_VIEWED = outline7316.toString();
    }

    public DBAdapter(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        String str;
        if (cleverTapInstanceConfig.isDefaultInstance) {
            str = "clevertap";
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("clevertap_");
            outline73.append(cleverTapInstanceConfig.accountId);
            str = outline73.toString();
        }
        this.rtlDirtyFlag = true;
        this.dbHelper = new DatabaseHelper(context, str);
        this.config = cleverTapInstanceConfig;
    }

    public final boolean belowMemThreshold() {
        DatabaseHelper databaseHelper = this.dbHelper;
        if (!databaseHelper.databaseFile.exists() || Math.max(databaseHelper.databaseFile.getUsableSpace(), 20971520) >= databaseHelper.databaseFile.length()) {
            return true;
        }
        return false;
    }

    public final void cleanInternal(Table table, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        String name = table.getName();
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            writableDatabase.delete(name, "created_at <= " + currentTimeMillis, null);
        } catch (SQLiteException e2) {
            Logger configLogger = getConfigLogger();
            configLogger.verbose("Error removing stale event records from " + name + ". Recreating DB.", (Throwable) e2);
            this.dbHelper.deleteDatabase();
        } catch (Throwable th) {
            this.dbHelper.close();
            throw th;
        }
        this.dbHelper.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r4 = r3.dbHelper;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4 = getConfigLogger();
        r4.verbose("Error removing sent data from table " + r5 + " Recreating DB");
        r3.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void cleanupEventsFromLastId(java.lang.String r4, com.clevertap.android.sdk.db.DBAdapter.Table r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0054 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r3.dbHelper     // Catch:{ SQLiteException -> 0x0026 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0026 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0026 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0026 }
            java.lang.String r2 = "_id <= "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0026 }
            r1.append(r4)     // Catch:{ SQLiteException -> 0x0026 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteException -> 0x0026 }
            r1 = 0
            r0.delete(r5, r4, r1)     // Catch:{ SQLiteException -> 0x0026 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x0054 }
        L_0x0022:
            r4.close()     // Catch:{ all -> 0x0054 }
            goto L_0x004b
        L_0x0026:
            com.clevertap.android.sdk.Logger r4 = r3.getConfigLogger()     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "Error removing sent data from table "
            r0.append(r1)     // Catch:{ all -> 0x004d }
            r0.append(r5)     // Catch:{ all -> 0x004d }
            java.lang.String r5 = " Recreating DB"
            r0.append(r5)     // Catch:{ all -> 0x004d }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x004d }
            r4.verbose(r5)     // Catch:{ all -> 0x004d }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x004d }
            r4.deleteDatabase()     // Catch:{ all -> 0x004d }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x0054 }
            goto L_0x0022
        L_0x004b:
            monitor-exit(r3)
            return
        L_0x004d:
            r4 = move-exception
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r5 = r3.dbHelper     // Catch:{ all -> 0x0054 }
            r5.close()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.cleanupEventsFromLastId(java.lang.String, com.clevertap.android.sdk.db.DBAdapter$Table):void");
    }

    public synchronized void cleanupStaleEvents(Table table) {
        cleanInternal(table, 432000000);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:10|(1:12)|13|14|47|46|8|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A[Catch:{ SQLiteException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[SYNTHETIC, Splitter:B:29:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject fetchEvents(com.clevertap.android.sdk.db.DBAdapter.Table r12, int r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x009d }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ all -> 0x009d }
            r9.<init>()     // Catch:{ all -> 0x009d }
            r10 = 0
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r11.dbHelper     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "created_at ASC"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r1 = r12
            android.database.Cursor r13 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r0 = r10
        L_0x0022:
            boolean r1 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0054 }
            if (r1 == 0) goto L_0x004b
            boolean r1 = r13.isLast()     // Catch:{ SQLiteException -> 0x0054 }
            if (r1 == 0) goto L_0x0038
            java.lang.String r0 = "_id"
            int r0 = r13.getColumnIndex(r0)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ SQLiteException -> 0x0054 }
        L_0x0038:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0022 }
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ JSONException -> 0x0022 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ JSONException -> 0x0022 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0022 }
            r9.put(r1)     // Catch:{ JSONException -> 0x0022 }
            goto L_0x0022
        L_0x004b:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.dbHelper     // Catch:{ all -> 0x009d }
            r12.close()     // Catch:{ all -> 0x009d }
            r13.close()     // Catch:{ all -> 0x009d }
            goto L_0x0082
        L_0x0054:
            r0 = move-exception
            goto L_0x005a
        L_0x0056:
            r12 = move-exception
            goto L_0x0092
        L_0x0058:
            r0 = move-exception
            r13 = r10
        L_0x005a:
            com.clevertap.android.sdk.Logger r1 = r11.getConfigLogger()     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch:{ all -> 0x0090 }
            r2.append(r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = "."
            r2.append(r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0090 }
            r1.verbose(r12, r0)     // Catch:{ all -> 0x0090 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.dbHelper     // Catch:{ all -> 0x009d }
            r12.close()     // Catch:{ all -> 0x009d }
            if (r13 == 0) goto L_0x0081
            r13.close()     // Catch:{ all -> 0x009d }
        L_0x0081:
            r0 = r10
        L_0x0082:
            if (r0 == 0) goto L_0x008e
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008e }
            r12.<init>()     // Catch:{ JSONException -> 0x008e }
            r12.put(r0, r9)     // Catch:{ JSONException -> 0x008e }
            monitor-exit(r11)
            return r12
        L_0x008e:
            monitor-exit(r11)
            return r10
        L_0x0090:
            r12 = move-exception
            r10 = r13
        L_0x0092:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r13 = r11.dbHelper     // Catch:{ all -> 0x009d }
            r13.close()     // Catch:{ all -> 0x009d }
            if (r10 == 0) goto L_0x009c
            r10.close()     // Catch:{ all -> 0x009d }
        L_0x009c:
            throw r12     // Catch:{ all -> 0x009d }
        L_0x009d:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.fetchEvents(com.clevertap.android.sdk.db.DBAdapter$Table, int):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        if (r9 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r9 == null) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String fetchPushNotificationId(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x0087 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0087 }
            r9 = 0
            java.lang.String r10 = ""
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.dbHelper     // Catch:{ SQLiteException -> 0x0054 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0054 }
            r3 = 0
            java.lang.String r4 = "data =?"
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0054 }
            r2 = 0
            r5[r2] = r12     // Catch:{ SQLiteException -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0054 }
            if (r9 == 0) goto L_0x0033
            boolean r12 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0054 }
            if (r12 == 0) goto L_0x0033
            java.lang.String r12 = "data"
            int r12 = r9.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r10 = r9.getString(r12)     // Catch:{ SQLiteException -> 0x0054 }
        L_0x0033:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0054 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r1 = "Fetching PID for check - "
            r12.append(r1)     // Catch:{ SQLiteException -> 0x0054 }
            r12.append(r10)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r12 = r12.toString()     // Catch:{ SQLiteException -> 0x0054 }
            com.clevertap.android.sdk.Logger.v(r12)     // Catch:{ SQLiteException -> 0x0054 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.dbHelper     // Catch:{ all -> 0x0087 }
            r12.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x007a
        L_0x004e:
            r9.close()     // Catch:{ all -> 0x0087 }
            goto L_0x007a
        L_0x0052:
            r12 = move-exception
            goto L_0x007c
        L_0x0054:
            r12 = move-exception
            com.clevertap.android.sdk.Logger r1 = r11.getConfigLogger()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch:{ all -> 0x0052 }
            r2.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "."
            r2.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0052 }
            r1.verbose(r0, r12)     // Catch:{ all -> 0x0052 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r12 = r11.dbHelper     // Catch:{ all -> 0x0087 }
            r12.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x007a
            goto L_0x004e
        L_0x007a:
            monitor-exit(r11)
            return r10
        L_0x007c:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r11.dbHelper     // Catch:{ all -> 0x0087 }
            r0.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x0086
            r9.close()     // Catch:{ all -> 0x0087 }
        L_0x0086:
            throw r12     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.fetchPushNotificationId(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(3:10|11|(3:13|14|15))|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r12 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        if (r12 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0078=Splitter:B:33:0x0078, B:17:0x003e=Splitter:B:17:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject fetchUserProfileById(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            if (r12 != 0) goto L_0x0006
            monitor-exit(r11)
            return r0
        L_0x0006:
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0083 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r11.dbHelper     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r4 = 0
            java.lang.String r5 = "_id =?"
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            if (r12 == 0) goto L_0x003e
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x003c }
            if (r2 == 0) goto L_0x003e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "data"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ JSONException -> 0x003e }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x003e }
            r0 = r2
            goto L_0x003e
        L_0x003c:
            r2 = move-exception
            goto L_0x0050
        L_0x003e:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.dbHelper     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0075
        L_0x0045:
            r12.close()     // Catch:{ all -> 0x0083 }
            goto L_0x0075
        L_0x0049:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x0078
        L_0x004e:
            r2 = move-exception
            r12 = r0
        L_0x0050:
            com.clevertap.android.sdk.Logger r3 = r11.getConfigLogger()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r4.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch:{ all -> 0x0077 }
            r4.append(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0077 }
            r3.verbose(r1, r2)     // Catch:{ all -> 0x0077 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.dbHelper     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0075
            goto L_0x0045
        L_0x0075:
            monitor-exit(r11)
            return r0
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r11.dbHelper     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0082
            r12.close()     // Catch:{ all -> 0x0083 }
        L_0x0082:
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.fetchUserProfileById(java.lang.String):org.json.JSONObject");
    }

    public final Logger getConfigLogger() {
        return this.config.getLogger();
    }

    public synchronized ArrayList<CTMessageDAO> getMessages(String str) {
        ArrayList<CTMessageDAO> arrayList;
        String name = Table.INBOX_MESSAGES.getName();
        arrayList = new ArrayList<>();
        try {
            Cursor query = this.dbHelper.getWritableDatabase().query(name, null, "messageUser =?", new String[]{str}, null, null, "created_at DESC");
            if (query != null) {
                while (query.moveToNext()) {
                    CTMessageDAO cTMessageDAO = new CTMessageDAO();
                    cTMessageDAO.id = query.getString(query.getColumnIndex("_id"));
                    cTMessageDAO.jsonData = new JSONObject(query.getString(query.getColumnIndex("data")));
                    cTMessageDAO.wzrkParams = new JSONObject(query.getString(query.getColumnIndex("wzrkParams")));
                    cTMessageDAO.date = query.getLong(query.getColumnIndex("created_at"));
                    cTMessageDAO.expires = query.getLong(query.getColumnIndex("expires"));
                    cTMessageDAO.read = query.getInt(query.getColumnIndex("isRead")) == 1;
                    cTMessageDAO.userId = query.getString(query.getColumnIndex("messageUser"));
                    cTMessageDAO.setTags(query.getString(query.getColumnIndex("tags")));
                    cTMessageDAO.campaignId = query.getString(query.getColumnIndex("campaignId"));
                    arrayList.add(cTMessageDAO);
                }
                query.close();
            }
            this.dbHelper.close();
        } catch (SQLiteException e2) {
            Logger configLogger = getConfigLogger();
            configLogger.verbose("Error retrieving records from " + name, (Throwable) e2);
            this.dbHelper.close();
            return null;
        } catch (JSONException e3) {
            try {
                Logger configLogger2 = getConfigLogger();
                configLogger2.verbose("Error retrieving records from " + name, e3.getMessage());
                return null;
            } finally {
                this.dbHelper.close();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r4 = r3.dbHelper;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = getConfigLogger();
        r0.verbose("Error removing all events from table " + r4 + " Recreating DB");
        r3.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeEvents(com.clevertap.android.sdk.db.DBAdapter.Table r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0043 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r3.dbHelper     // Catch:{ SQLiteException -> 0x0015 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0015 }
            r1 = 0
            r0.delete(r4, r1, r1)     // Catch:{ SQLiteException -> 0x0015 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x0043 }
        L_0x0011:
            r4.close()     // Catch:{ all -> 0x0043 }
            goto L_0x003a
        L_0x0015:
            com.clevertap.android.sdk.Logger r0 = r3.getConfigLogger()     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r1.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r2 = "Error removing all events from table "
            r1.append(r2)     // Catch:{ all -> 0x003c }
            r1.append(r4)     // Catch:{ all -> 0x003c }
            java.lang.String r4 = " Recreating DB"
            r1.append(r4)     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003c }
            r0.verbose(r4)     // Catch:{ all -> 0x003c }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x003c }
            r4.deleteDatabase()     // Catch:{ all -> 0x003c }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r4 = r3.dbHelper     // Catch:{ all -> 0x0043 }
            goto L_0x0011
        L_0x003a:
            monitor-exit(r3)
            return
        L_0x003c:
            r4 = move-exception
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r3.dbHelper     // Catch:{ all -> 0x0043 }
            r0.close()     // Catch:{ all -> 0x0043 }
            throw r4     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.removeEvents(com.clevertap.android.sdk.db.DBAdapter$Table):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r7 = getConfigLogger();
        r7.verbose("Error adding data to table " + r8 + " Recreating DB");
        r6.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r7 = r6.dbHelper;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int storeObject(org.json.JSONObject r7, com.clevertap.android.sdk.db.DBAdapter.Table r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.belowMemThreshold()     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x000f
            java.lang.String r7 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.Logger.v(r7)     // Catch:{ all -> 0x0089 }
            r7 = -2
            monitor-exit(r6)
            return r7
        L_0x000f:
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0089 }
            r0 = -1
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r6.dbHelper     // Catch:{ SQLiteException -> 0x005b }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x005b }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x005b }
            r3.<init>()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r4 = "data"
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x005b }
            r3.put(r4, r7)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r7 = "created_at"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x005b }
            r3.put(r7, r4)     // Catch:{ SQLiteException -> 0x005b }
            r7 = 0
            r2.insert(r8, r7, r3)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x005b }
            r7.<init>()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r3 = "SELECT COUNT(*) FROM "
            r7.append(r3)     // Catch:{ SQLiteException -> 0x005b }
            r7.append(r8)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x005b }
            android.database.sqlite.SQLiteStatement r7 = r2.compileStatement(r7)     // Catch:{ SQLiteException -> 0x005b }
            long r0 = r7.simpleQueryForLong()     // Catch:{ SQLiteException -> 0x005b }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r7 = r6.dbHelper     // Catch:{ all -> 0x0089 }
        L_0x0055:
            r7.close()     // Catch:{ all -> 0x0089 }
            goto L_0x0080
        L_0x0059:
            r7 = move-exception
            goto L_0x0083
        L_0x005b:
            com.clevertap.android.sdk.Logger r7 = r6.getConfigLogger()     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = "Error adding data to table "
            r2.append(r3)     // Catch:{ all -> 0x0059 }
            r2.append(r8)     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = " Recreating DB"
            r2.append(r8)     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0059 }
            r7.verbose(r8)     // Catch:{ all -> 0x0059 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r7 = r6.dbHelper     // Catch:{ all -> 0x0059 }
            r7.deleteDatabase()     // Catch:{ all -> 0x0059 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r7 = r6.dbHelper     // Catch:{ all -> 0x0089 }
            goto L_0x0055
        L_0x0080:
            int r7 = (int) r0
            monitor-exit(r6)
            return r7
        L_0x0083:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r8 = r6.dbHelper     // Catch:{ all -> 0x0089 }
            r8.close()     // Catch:{ all -> 0x0089 }
            throw r7     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.storeObject(org.json.JSONObject, com.clevertap.android.sdk.db.DBAdapter$Table):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = getConfigLogger();
        r1.verbose("Error adding data to table " + r0 + " Recreating DB");
        r6.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = r6.dbHelper;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void storeUninstallTimestamp() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.belowMemThreshold()     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0012
            com.clevertap.android.sdk.Logger r0 = r6.getConfigLogger()     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "There is not enough space left on the device to store data, data discarded"
            r0.verbose(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r6)
            return
        L_0x0012:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.UNINSTALL_TS     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0069 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r6.dbHelper     // Catch:{ SQLiteException -> 0x003c }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003c }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x003c }
            r2.<init>()     // Catch:{ SQLiteException -> 0x003c }
            java.lang.String r3 = "created_at"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteException -> 0x003c }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x003c }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x003c }
            r3 = 0
            r1.insert(r0, r3, r2)     // Catch:{ SQLiteException -> 0x003c }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r6.dbHelper     // Catch:{ all -> 0x0069 }
        L_0x0036:
            r0.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0061
        L_0x003a:
            r0 = move-exception
            goto L_0x0063
        L_0x003c:
            com.clevertap.android.sdk.Logger r1 = r6.getConfigLogger()     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "Error adding data to table "
            r2.append(r3)     // Catch:{ all -> 0x003a }
            r2.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = " Recreating DB"
            r2.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x003a }
            r1.verbose(r0)     // Catch:{ all -> 0x003a }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r6.dbHelper     // Catch:{ all -> 0x003a }
            r0.deleteDatabase()     // Catch:{ all -> 0x003a }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r6.dbHelper     // Catch:{ all -> 0x0069 }
            goto L_0x0036
        L_0x0061:
            monitor-exit(r6)
            return
        L_0x0063:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r6.dbHelper     // Catch:{ all -> 0x0069 }
            r1.close()     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.storeUninstallTimestamp():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r7 = getConfigLogger();
        r7.verbose("Error adding data to table " + r2 + " Recreating DB");
        r6.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long storeUserProfile(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            if (r7 != 0) goto L_0x0007
            monitor-exit(r6)
            return r0
        L_0x0007:
            boolean r2 = r6.belowMemThreshold()     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x001a
            com.clevertap.android.sdk.Logger r7 = r6.getConfigLogger()     // Catch:{ all -> 0x0072 }
            java.lang.String r8 = "There is not enough space left on the device to store data, data discarded"
            r7.verbose(r8)     // Catch:{ all -> 0x0072 }
            r7 = -2
            monitor-exit(r6)
            return r7
        L_0x001a:
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0072 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r3 = r6.dbHelper     // Catch:{ SQLiteException -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0044 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0044 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r5 = "data"
            java.lang.String r8 = r8.toString()     // Catch:{ SQLiteException -> 0x0044 }
            r4.put(r5, r8)     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r8 = "_id"
            r4.put(r8, r7)     // Catch:{ SQLiteException -> 0x0044 }
            r7 = 0
            r8 = 5
            long r0 = r3.insertWithOnConflict(r2, r7, r4, r8)     // Catch:{ SQLiteException -> 0x0044 }
        L_0x003f:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r7 = r6.dbHelper     // Catch:{ all -> 0x0072 }
            goto L_0x0067
        L_0x0042:
            r7 = move-exception
            goto L_0x006c
        L_0x0044:
            com.clevertap.android.sdk.Logger r7 = r6.getConfigLogger()     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r8.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "Error adding data to table "
            r8.append(r3)     // Catch:{ all -> 0x0042 }
            r8.append(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = " Recreating DB"
            r8.append(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0042 }
            r7.verbose(r8)     // Catch:{ all -> 0x0042 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r7 = r6.dbHelper     // Catch:{ all -> 0x0042 }
            r7.deleteDatabase()     // Catch:{ all -> 0x0042 }
            goto L_0x003f
        L_0x0067:
            r7.close()     // Catch:{ all -> 0x0072 }
            monitor-exit(r6)
            return r0
        L_0x006c:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r8 = r6.dbHelper     // Catch:{ all -> 0x0072 }
            r8.close()     // Catch:{ all -> 0x0072 }
            throw r7     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.storeUserProfile(java.lang.String, org.json.JSONObject):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r8 = getConfigLogger();
        r8.verbose("Error adding data to table " + com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS.getName() + " Recreating DB");
        r7.dbHelper.deleteDatabase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r7.dbHelper.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updatePushNotificationIds(java.lang.String[] r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r8.length     // Catch:{ all -> 0x009e }
            if (r0 != 0) goto L_0x0006
            monitor-exit(r7)
            return
        L_0x0006:
            boolean r0 = r7.belowMemThreshold()     // Catch:{ all -> 0x009e }
            if (r0 != 0) goto L_0x0013
            java.lang.String r8 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.Logger.v(r8)     // Catch:{ all -> 0x009e }
            monitor-exit(r7)
            return
        L_0x0013:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r7.dbHelper     // Catch:{ SQLiteException -> 0x006a }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x006a }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x006a }
            r1.<init>()     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r2 = "isRead"
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x006a }
            r1.put(r2, r4)     // Catch:{ SQLiteException -> 0x006a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006a }
            r2.<init>()     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r4 = "?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x006a }
            r4 = 0
            r5 = 0
        L_0x0034:
            int r6 = r8.length     // Catch:{ SQLiteException -> 0x006a }
            int r6 = r6 - r3
            if (r5 >= r6) goto L_0x0040
            java.lang.String r6 = ", ?"
            r2.append(r6)     // Catch:{ SQLiteException -> 0x006a }
            int r5 = r5 + 1
            goto L_0x0034
        L_0x0040:
            com.clevertap.android.sdk.db.DBAdapter$Table r3 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r3 = r3.getName()     // Catch:{ SQLiteException -> 0x006a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006a }
            r5.<init>()     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r6 = "data IN ( "
            r5.append(r6)     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x006a }
            r5.append(r2)     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r2 = " )"
            r5.append(r2)     // Catch:{ SQLiteException -> 0x006a }
            java.lang.String r2 = r5.toString()     // Catch:{ SQLiteException -> 0x006a }
            r0.update(r3, r1, r2, r8)     // Catch:{ SQLiteException -> 0x006a }
            r7.rtlDirtyFlag = r4     // Catch:{ SQLiteException -> 0x006a }
        L_0x0065:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r8 = r7.dbHelper     // Catch:{ all -> 0x009e }
            goto L_0x0093
        L_0x0068:
            r8 = move-exception
            goto L_0x0098
        L_0x006a:
            com.clevertap.android.sdk.Logger r8 = r7.getConfigLogger()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r0.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = "Error adding data to table "
            r0.append(r1)     // Catch:{ all -> 0x0068 }
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0068 }
            r0.append(r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = " Recreating DB"
            r0.append(r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0068 }
            r8.verbose(r0)     // Catch:{ all -> 0x0068 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r8 = r7.dbHelper     // Catch:{ all -> 0x0068 }
            r8.deleteDatabase()     // Catch:{ all -> 0x0068 }
            goto L_0x0065
        L_0x0093:
            r8.close()     // Catch:{ all -> 0x009e }
            monitor-exit(r7)
            return
        L_0x0098:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r7.dbHelper     // Catch:{ all -> 0x009e }
            r0.close()     // Catch:{ all -> 0x009e }
            throw r8     // Catch:{ all -> 0x009e }
        L_0x009e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.updatePushNotificationIds(java.lang.String[]):void");
    }
}
