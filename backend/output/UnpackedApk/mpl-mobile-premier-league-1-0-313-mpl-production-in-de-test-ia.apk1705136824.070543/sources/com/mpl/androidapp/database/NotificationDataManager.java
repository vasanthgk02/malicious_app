package com.mpl.androidapp.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import com.facebook.react.bridge.ReactContext;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.database.entity.Notification;
import com.mpl.androidapp.utils.MLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationDataManager {
    public static final String DB_NAME = "mpl_notification_database.db";
    public static final String TAG = "NotificationDataManager";
    public static int index;
    public static NotificationDatabase mNotifDB;
    public ReactContext mReactContext;

    public NotificationDataManager(Context context) {
        Builder<NotificationDatabase> databaseBuilder = Room.databaseBuilder(context, NotificationDatabase.class, DB_NAME);
        databaseBuilder.fallbackToDestructiveMigration();
        mNotifDB = (NotificationDatabase) databaseBuilder.build();
    }

    public void addNotificationData(String str, String str2, boolean z) {
        final Notification notification = new Notification();
        notification.setNotificationData(str);
        notification.setRecievedTime(str2);
        notification.setRead(z);
        notification.setIsSoftDeleted(false);
        try {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    try {
                        if (ConfigManager.getPlatformConfig() != null) {
                            int optInt = ConfigManager.getPlatformConfig().optInt("notification.drawer.limit", 100) - 1;
                            int totalElementINDB = NotificationDataManager.mNotifDB.dataAccessObject().getTotalElementINDB();
                            if (totalElementINDB >= optInt) {
                                NotificationDataManager.this.deleteEventOnStorageFull(totalElementINDB - optInt);
                            }
                            NotificationDataManager.mNotifDB.dataAccessObject().addevent(notification);
                        }
                    } catch (Exception e2) {
                        MLogger.d(NotificationDataManager.TAG, e2.getMessage());
                    }
                }
            });
        } catch (Exception e2) {
            MLogger.d(TAG, e2.getMessage());
        }
    }

    public void deleteAllNOtificationDataTable() {
        NotificationDatabase notificationDatabase = mNotifDB;
        if (notificationDatabase != null && notificationDatabase.dataAccessObject() != null) {
            mNotifDB.dataAccessObject().deleteAllDataFromDB();
        }
    }

    public void deleteEventOnStorageFull(int i) {
        List<Notification> notificationEntityInAscendingOrder = mNotifDB.dataAccessObject().getNotificationEntityInAscendingOrder(i);
        if (!notificationEntityInAscendingOrder.isEmpty()) {
            for (Notification index2 : notificationEntityInAscendingOrder) {
                index = (int) index2.getIndex();
                mNotifDB.dataAccessObject().deleteSingleFromDB(index);
                MLogger.d(TAG, Integer.valueOf(index));
            }
        }
    }

    public void deleteNotificationTableElement(int i) {
        mNotifDB.dataAccessObject().deleteSingleFromDB(i);
    }

    public void markAllAsRead() {
        try {
            if (mNotifDB != null) {
                List<Notification> allEvents = mNotifDB.dataAccessObject().getAllEvents();
                if (!allEvents.isEmpty()) {
                    for (Notification index2 : allEvents) {
                        mNotifDB.dataAccessObject().update(true, (int) index2.getIndex());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void markOneAsRead(int i) {
        try {
            if (mNotifDB != null) {
                List<Notification> singleNOtificationDataEvent = mNotifDB.dataAccessObject().getSingleNOtificationDataEvent(i);
                if (!singleNOtificationDataEvent.isEmpty()) {
                    for (Notification index2 : singleNOtificationDataEvent) {
                        mNotifDB.dataAccessObject().update(true, (int) index2.getIndex());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public String readNotificationDataFromTable(int i, int i2) {
        MLogger.d(TAG, Integer.valueOf(i2 - i));
        if (mNotifDB == null) {
            return "object null";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            List<Notification> notificationDataInDescendginOrderPagination = mNotifDB.dataAccessObject().getNotificationDataInDescendginOrderPagination((long) i, (long) i2);
            MLogger.d(TAG, notificationDataInDescendginOrderPagination.toString());
            if (!notificationDataInDescendginOrderPagination.isEmpty()) {
                for (Notification next : notificationDataInDescendginOrderPagination) {
                    String valueOf = String.valueOf(next.getIndex());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", valueOf);
                    jSONObject2.put("notificationData", next.getNotificationData());
                    jSONObject2.put("receivedTime", next.getRecievedTime());
                    jSONObject2.put("read", next.isRead());
                    jSONArray.put(jSONObject2);
                    MLogger.d(TAG, jSONArray.toString());
                }
                jSONObject.put("startingIndex", i);
                jSONObject.put("endingIndex", i2);
                jSONObject.put("notification", jSONArray);
                MLogger.d(TAG, jSONObject.toString());
            }
        } catch (JSONException e2) {
            MLogger.d(TAG, e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String readNotificationDataOnCount(int i, int i2) {
        MLogger.d(TAG, Integer.valueOf(i2));
        if (mNotifDB == null) {
            return "object null";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            List<Notification> notificationEntityInDescendingOrderByCount = mNotifDB.dataAccessObject().getNotificationEntityInDescendingOrderByCount(i, i2);
            MLogger.d(TAG, notificationEntityInDescendingOrderByCount.toString());
            if (notificationEntityInDescendingOrderByCount.isEmpty()) {
                return jSONObject.toString();
            }
            int i3 = 0;
            for (Notification next : notificationEntityInDescendingOrderByCount) {
                String valueOf = String.valueOf(next.getIndex());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", valueOf);
                jSONObject2.put("notificationData", next.getNotificationData());
                jSONObject2.put("receivedTime", next.getRecievedTime());
                jSONObject2.put("read", next.isRead());
                jSONArray.put(jSONObject2);
                i3 = (int) next.getIndex();
                MLogger.d(TAG, jSONArray.toString());
            }
            jSONObject.put("startingIndex", i3 - 1);
            jSONObject.put("notification", jSONArray);
            MLogger.d(TAG, jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e2) {
            MLogger.d(TAG, e2.getMessage());
        }
    }

    public String unreadNotifCount() {
        MLogger.d(TAG, "countunread");
        JSONObject jSONObject = new JSONObject();
        NotificationDatabase notificationDatabase = mNotifDB;
        if (notificationDatabase == null) {
            return "object null";
        }
        try {
            List<Notification> allEvents = notificationDatabase.dataAccessObject().getAllEvents();
            MLogger.d(TAG, allEvents.toString());
            if (allEvents.isEmpty()) {
                return jSONObject.toString();
            }
            int i = 0;
            int i2 = 0;
            for (Notification next : allEvents) {
                int index2 = (int) next.getIndex();
                if (!next.isRead()) {
                    i++;
                }
                i2 = index2;
            }
            MLogger.d(TAG, Integer.valueOf(i));
            jSONObject.put("count", i);
            jSONObject.put("startIndex", i2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            MLogger.d(TAG, e2.getMessage());
        }
    }
}
