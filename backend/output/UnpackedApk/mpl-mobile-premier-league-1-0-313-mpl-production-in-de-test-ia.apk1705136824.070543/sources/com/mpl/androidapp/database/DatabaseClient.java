package com.mpl.androidapp.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import androidx.room.RoomDatabase.Callback;
import androidx.room.RoomDatabase.JournalMode;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.database.entity.Events;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseClient {
    public static final String DB_NAME = "mpl_database.db";
    public static final String EVENT_DB_NAME = "mpl_event_database.db";
    public static final String EVENT_DB_NAME_ALL = "mpl_event_database_all_games.db";
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MutedChannel` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `url` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_MutedChannel_url` ON `MutedChannel` (`url`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Asset` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `assetVersion` INTEGER NOT NULL, `gameId` INTEGER NOT NULL, `firstDownloadTime` INTEGER NOT NULL, `lastModifiedTime` INTEGER NOT NULL, `gameVersion` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `reactVersion` INTEGER NOT NULL, `modifiedAppVersion` INTEGER NOT NULL, `modifiedReactVersion` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Asset_gameId` ON `Asset` (`gameId`)");
        }
    };
    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PendingStory` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `storyId` TEXT, `userTags` TEXT, `storyType` TEXT, `title` TEXT, `tag` TEXT, `fileName` TEXT, `videoPath` TEXT, `thumbnailPath` TEXT, `videoId` TEXT, `videoUploadAddress` TEXT, `videoUploadAuth` TEXT, `imageId` TEXT, `imageUrl` TEXT, `imageUploadAddress` TEXT, `imageUploadAuth` TEXT, `retryCount` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_PendingStory_storyId` ON `PendingStory` (`storyId`)");
        }
    };
    public static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `uploadStartTs` INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `progress` INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `startCount` INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `creationTime` INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `sdk` INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `s3TransferId` INTEGER NOT NULL DEFAULT -1");
            supportSQLiteDatabase.execSQL("ALTER TABLE `PendingStory` ADD COLUMN `version` INTEGER NOT NULL DEFAULT 0");
        }
    };
    public static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS PendingStory");
        }
    };
    public static final Migration MIGRATION_6_7 = new Migration(6, 7) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BroadcastWithPosition` (`broadcastId` TEXT NOT NULL, `startPosition` INTEGER NOT NULL, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`broadcastId`))");
        }
    };
    public static final String TAG = "DatabaseClient";
    public static DatabaseClient mInstance;
    public final AppDatabase mAppDatabase;
    public final DatabaseEventsAll mDatabaseEventAll;
    public final DatabaseEvents mEventDatabase;

    public DatabaseClient(Context context) {
        MLogger.d(TAG, "DatabaseLogs>>", "DatabaseClient: ");
        Builder<AppDatabase> databaseBuilder = Room.databaseBuilder(context, AppDatabase.class, DB_NAME);
        databaseBuilder.fallbackToDestructiveMigration();
        databaseBuilder.addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7);
        databaseBuilder.setJournalMode(JournalMode.AUTOMATIC);
        databaseBuilder.enableMultiInstanceInvalidation();
        databaseBuilder.addCallback(new Callback() {
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onCreate(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onCreate:Normal data base ");
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onOpen(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onOpen:Normal data base ");
            }
        });
        this.mAppDatabase = (AppDatabase) databaseBuilder.build();
        Builder<DatabaseEventsAll> databaseBuilder2 = Room.databaseBuilder(context, DatabaseEventsAll.class, EVENT_DB_NAME_ALL);
        databaseBuilder2.fallbackToDestructiveMigration();
        databaseBuilder2.setJournalMode(JournalMode.AUTOMATIC);
        databaseBuilder2.enableMultiInstanceInvalidation();
        databaseBuilder2.addCallback(new Callback() {
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onCreate(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onCreate:Event database ");
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onOpen(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onOpen:Event data base ");
            }
        });
        this.mDatabaseEventAll = (DatabaseEventsAll) databaseBuilder2.build();
        Builder<DatabaseEvents> databaseBuilder3 = Room.databaseBuilder(context, DatabaseEvents.class, EVENT_DB_NAME);
        databaseBuilder3.fallbackToDestructiveMigration();
        databaseBuilder3.setJournalMode(JournalMode.AUTOMATIC);
        databaseBuilder3.enableMultiInstanceInvalidation();
        databaseBuilder3.addCallback(new Callback() {
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onCreate(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onCreate:Event database ");
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onOpen(supportSQLiteDatabase);
                MLogger.d(DatabaseClient.TAG, "onOpen:Event data base ");
            }
        });
        this.mEventDatabase = (DatabaseEvents) databaseBuilder3.build();
    }

    /* access modifiers changed from: private */
    public int deleteAllDataFromDb() {
        DatabaseEvents databaseEvents = this.mEventDatabase;
        if (databaseEvents != null) {
            return databaseEvents.eventDao().deleteAllDataFromDB();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int deleteAllDataFromDbAll() {
        DatabaseEventsAll databaseEventsAll = this.mDatabaseEventAll;
        if (databaseEventsAll != null) {
            return databaseEventsAll.eventDaoAll().deleteAllDataFromDB();
        }
        return -1;
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        DatabaseClient databaseClient;
        synchronized (DatabaseClient.class) {
            try {
                MLogger.d(TAG, "DatabaseLogs>>", "getInstance: ");
                if (mInstance == null) {
                    MLogger.d(TAG, "DatabaseLogs>>", "getInstance: Initializing new data base client");
                    mInstance = new DatabaseClient(context);
                }
                MLogger.d(TAG, "DatabaseLogs>>", "getInstance: ", Integer.valueOf(mInstance.hashCode()));
                databaseClient = mInstance;
            }
        }
        return databaseClient;
    }

    /* access modifiers changed from: private */
    public void readEventFromTable() {
        MLogger.d(TAG, "reading data from table");
        try {
            List<Events> allEvents = this.mEventDatabase.eventDao().getAllEvents();
            if (!allEvents.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Events next : allEvents) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(next.getKey(), new JSONObject(next.getValue()));
                    jSONArray.put(jSONObject);
                }
                MLogger.d(TAG, "sending data in jason array", jSONArray);
                sendEventToServer(jSONArray);
                return;
            }
            MLogger.d(TAG, "no data in databse");
        } catch (JSONException e2) {
            MLogger.d(TAG, MqttServiceConstants.TRACE_EXCEPTION, e2);
        }
    }

    /* access modifiers changed from: private */
    public void readEventFromTableAll() {
        MLogger.d(TAG, "reading data from table");
        try {
            List<Events> allEvents = this.mDatabaseEventAll.eventDaoAll().getAllEvents();
            if (!allEvents.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Events next : allEvents) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(next.getKey(), new JSONObject(next.getValue()));
                    jSONArray.put(jSONObject);
                }
                MLogger.d(TAG, "sending data in json array", jSONArray);
                sendEventToServerAll(jSONArray);
                return;
            }
            MLogger.d(TAG, "no data in database");
        } catch (JSONException e2) {
            MLogger.d(TAG, MqttServiceConstants.TRACE_EXCEPTION, e2);
        }
    }

    private void sendEventToServer(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            NetworkUtils.doPostRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.RUMMY_EVENT).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).setMRequestBody(jSONArray.toString()).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "final call failed with exception" + exc);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    if (DatabaseClient.this.deleteAllDataFromDb() == 1) {
                        MLogger.d(IResponseListener.TAG, "deleted all data from db");
                    }
                }
            }, "server_Event");
        } catch (Exception e2) {
            MLogger.e(TAG, "sendEventToServer: ", e2);
        }
    }

    private void sendEventToServerAll(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            NetworkUtils.doPostRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.ALL_GAMES_DISCONNECTION_EVENT).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).setMRequestBody(jSONArray.toString()).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "final call failed with exception" + exc);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    if (DatabaseClient.this.deleteAllDataFromDbAll() == 1) {
                        MLogger.d(IResponseListener.TAG, "deleted all data from db");
                    }
                }
            }, "server_Event");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void addEventAll(String str, String str2) {
        Events events = new Events();
        events.setKey(str);
        events.setValue(str2);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
        outline73.append(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        events.setTime(outline73.toString());
        this.mDatabaseEventAll.eventDaoAll().addevent(events);
    }

    public AppDatabase getAppDatabase() {
        MLogger.d(TAG, "DatabaseLogs>>", "getAppDatabase: ");
        return this.mAppDatabase;
    }

    public void sendData() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                DatabaseClient.this.readEventFromTable();
            }
        });
    }

    public void sendDataAll() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                DatabaseClient.this.readEventFromTableAll();
            }
        });
    }
}
