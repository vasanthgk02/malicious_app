package org.eclipse.paho.android.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.UUID;
import org.eclipse.paho.android.service.MessageStore.StoredMessage;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class DatabaseMessageStore implements MessageStore {
    public static final String ARRIVED_MESSAGE_TABLE_NAME = "MqttArrivedMessageTable";
    public static final String MTIMESTAMP = "mtimestamp";
    public static final String TAG = "DatabaseMessageStore";
    public SQLiteDatabase db = null;
    public MQTTDatabaseHelper mqttDb = null;
    public MqttTraceHandler traceHandler = null;

    public class DbStoredData implements StoredMessage {
        public String clientHandle;
        public MqttMessage message;
        public String messageId;
        public String topic;

        public DbStoredData(String str, String str2, String str3, MqttMessage mqttMessage) {
            this.messageId = str;
            this.topic = str3;
            this.message = mqttMessage;
        }

        public String getClientHandle() {
            return this.clientHandle;
        }

        public MqttMessage getMessage() {
            return this.message;
        }

        public String getMessageId() {
            return this.messageId;
        }

        public String getTopic() {
            return this.topic;
        }
    }

    public static class MQTTDatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "mqttAndroidService.db";
        public static final int DATABASE_VERSION = 1;
        public static final String TAG = "MQTTDatabaseHelper";
        public MqttTraceHandler traceHandler = null;

        public MQTTDatabaseHelper(MqttTraceHandler mqttTraceHandler, Context context) {
            super(context, DATABASE_NAME, null, 1);
            this.traceHandler = mqttTraceHandler;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MqttTraceHandler mqttTraceHandler = this.traceHandler;
            mqttTraceHandler.traceDebug(TAG, "onCreate {" + "CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);" + "}");
            try {
                sQLiteDatabase.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.traceHandler.traceDebug(TAG, "created the table");
            } catch (SQLException e2) {
                this.traceHandler.traceException(TAG, "onCreate", e2);
                throw e2;
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.traceHandler.traceDebug(TAG, "onUpgrade");
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(sQLiteDatabase);
                this.traceHandler.traceDebug(TAG, "onUpgrade complete");
            } catch (SQLException e2) {
                this.traceHandler.traceException(TAG, "onUpgrade", e2);
                throw e2;
            }
        }
    }

    public class MqttMessageHack extends MqttMessage {
        public MqttMessageHack(byte[] bArr) {
            super(bArr);
        }

        public void setDuplicate(boolean z) {
            super.setDuplicate(z);
        }
    }

    public DatabaseMessageStore(MqttService mqttService, Context context) {
        this.traceHandler = mqttService;
        this.mqttDb = new MQTTDatabaseHelper(this.traceHandler, context);
        this.traceHandler.traceDebug(TAG, "DatabaseMessageStore<init> complete");
    }

    private int getArrivedRowCount(String str) {
        int i = 0;
        SQLiteDatabase sQLiteDatabase = this.db;
        Cursor query = sQLiteDatabase.query(ARRIVED_MESSAGE_TABLE_NAME, new String[]{"messageId"}, "clientHandle=?", new String[]{str}, null, null, null);
        if (query.moveToFirst()) {
            i = query.getInt(0);
        }
        query.close();
        return i;
    }

    public void clearArrivedMessages(String str) {
        int i;
        this.db = this.mqttDb.getWritableDatabase();
        String[] strArr = {str};
        if (str == null) {
            this.traceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table");
            i = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, null, null);
        } else {
            MqttTraceHandler mqttTraceHandler = this.traceHandler;
            mqttTraceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table of " + str + " messages");
            i = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "clientHandle=?", strArr);
        }
        MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
        mqttTraceHandler2.traceDebug(TAG, "clearArrivedMessages: rows affected = " + i);
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public boolean discardArrived(String str, String str2) {
        this.db = this.mqttDb.getWritableDatabase();
        this.traceHandler.traceDebug(TAG, GeneratedOutlineSupport.outline54("discardArrived{", str, "}, {", str2, "}"));
        try {
            int delete = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "messageId=? AND clientHandle=?", new String[]{str2, str});
            if (delete != 1) {
                MqttTraceHandler mqttTraceHandler = this.traceHandler;
                mqttTraceHandler.traceError(TAG, "discardArrived - Error deleting message {" + str2 + "} from database: Rows affected = " + delete);
                return false;
            }
            int arrivedRowCount = getArrivedRowCount(str);
            MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
            mqttTraceHandler2.traceDebug(TAG, "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + arrivedRowCount);
            return true;
        } catch (SQLException e2) {
            this.traceHandler.traceException(TAG, "discardArrived", e2);
            throw e2;
        }
    }

    public Iterator<StoredMessage> getAllArrivedMessages(final String str) {
        return new Iterator<StoredMessage>() {

            /* renamed from: c  reason: collision with root package name */
            public Cursor f6150c;
            public boolean hasNext;
            public final String[] selectionArgs = {str};

            {
                DatabaseMessageStore databaseMessageStore = DatabaseMessageStore.this;
                databaseMessageStore.db = databaseMessageStore.mqttDb.getWritableDatabase();
                if (str == null) {
                    this.f6150c = DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, null, null, null, null, null, "mtimestamp ASC");
                } else {
                    this.f6150c = DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, null, "clientHandle=?", this.selectionArgs, null, null, "mtimestamp ASC");
                }
                this.hasNext = this.f6150c.moveToFirst();
            }

            public void finalize() throws Throwable {
                this.f6150c.close();
                super.finalize();
            }

            public boolean hasNext() {
                if (!this.hasNext) {
                    this.f6150c.close();
                }
                return this.hasNext;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public StoredMessage next() {
                Cursor cursor = this.f6150c;
                String string = cursor.getString(cursor.getColumnIndex("messageId"));
                Cursor cursor2 = this.f6150c;
                String string2 = cursor2.getString(cursor2.getColumnIndex(MqttServiceConstants.CLIENT_HANDLE));
                Cursor cursor3 = this.f6150c;
                String string3 = cursor3.getString(cursor3.getColumnIndex(MqttServiceConstants.DESTINATION_NAME));
                Cursor cursor4 = this.f6150c;
                byte[] blob = cursor4.getBlob(cursor4.getColumnIndex("payload"));
                Cursor cursor5 = this.f6150c;
                int i = cursor5.getInt(cursor5.getColumnIndex(MqttServiceConstants.QOS));
                Cursor cursor6 = this.f6150c;
                boolean parseBoolean = Boolean.parseBoolean(cursor6.getString(cursor6.getColumnIndex(MqttServiceConstants.RETAINED)));
                Cursor cursor7 = this.f6150c;
                boolean parseBoolean2 = Boolean.parseBoolean(cursor7.getString(cursor7.getColumnIndex(MqttServiceConstants.DUPLICATE)));
                MqttMessageHack mqttMessageHack = new MqttMessageHack(blob);
                mqttMessageHack.setQos(i);
                mqttMessageHack.setRetained(parseBoolean);
                mqttMessageHack.setDuplicate(parseBoolean2);
                this.hasNext = this.f6150c.moveToNext();
                DbStoredData dbStoredData = new DbStoredData(string, string2, string3, mqttMessageHack);
                return dbStoredData;
            }
        };
    }

    public String storeArrived(String str, String str2, MqttMessage mqttMessage) {
        this.db = this.mqttDb.getWritableDatabase();
        MqttTraceHandler mqttTraceHandler = this.traceHandler;
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("storeArrived{", str, "}, {");
        outline80.append(mqttMessage.toString());
        outline80.append("}");
        mqttTraceHandler.traceDebug(TAG, outline80.toString());
        byte[] payload = mqttMessage.getPayload();
        int qos = mqttMessage.getQos();
        boolean isRetained = mqttMessage.isRetained();
        boolean isDuplicate = mqttMessage.isDuplicate();
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put("messageId", uuid);
        contentValues.put(MqttServiceConstants.CLIENT_HANDLE, str);
        contentValues.put(MqttServiceConstants.DESTINATION_NAME, str2);
        contentValues.put("payload", payload);
        contentValues.put(MqttServiceConstants.QOS, Integer.valueOf(qos));
        contentValues.put(MqttServiceConstants.RETAINED, Boolean.valueOf(isRetained));
        contentValues.put(MqttServiceConstants.DUPLICATE, Boolean.valueOf(isDuplicate));
        contentValues.put(MTIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        try {
            this.db.insertOrThrow(ARRIVED_MESSAGE_TABLE_NAME, null, contentValues);
            int arrivedRowCount = getArrivedRowCount(str);
            MqttTraceHandler mqttTraceHandler2 = this.traceHandler;
            mqttTraceHandler2.traceDebug(TAG, "storeArrived: inserted message with id of {" + uuid + "} - Number of messages in database for this clientHandle = " + arrivedRowCount);
            return uuid;
        } catch (SQLException e2) {
            this.traceHandler.traceException(TAG, "onUpgrade", e2);
            throw e2;
        }
    }
}
