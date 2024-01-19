package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.utils.IdGenerator;

public class Alarms {
    public static final String TAG = Logger.tagWithPrefix("Alarms");

    public static void cancelAlarm(Context context, WorkManagerImpl workManagerImpl, String str) {
        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workManagerImpl.mWorkDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao_Impl.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            Logger.get().debug(TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            systemIdInfoDao_Impl.removeSystemIdInfo(str);
        }
    }

    public static void cancelExactAlarm(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.createDelayMetIntent(context, str), 536870912);
        if (service != null && alarmManager != null) {
            Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void setAlarm(Context context, WorkManagerImpl workManagerImpl, String str, long j) {
        int intValue;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao_Impl.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            setExactAlarm(context, str, systemIdInfo.systemId, j);
            return;
        }
        synchronized (IdGenerator.class) {
            workDatabase.beginTransaction();
            try {
                Long longValue = ((PreferenceDao_Impl) workDatabase.preferenceDao()).getLongValue("next_alarm_manager_id");
                int i = 0;
                intValue = longValue != null ? longValue.intValue() : 0;
                if (intValue != Integer.MAX_VALUE) {
                    i = intValue + 1;
                }
                ((PreferenceDao_Impl) workDatabase.preferenceDao()).insertPreference(new Preference((String) "next_alarm_manager_id", (long) i));
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        systemIdInfoDao_Impl.insertSystemIdInfo(new SystemIdInfo(str, intValue));
        setExactAlarm(context, str, intValue, j);
    }

    public static void setExactAlarm(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.createDelayMetIntent(context, str), 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j, service);
        }
    }
}
