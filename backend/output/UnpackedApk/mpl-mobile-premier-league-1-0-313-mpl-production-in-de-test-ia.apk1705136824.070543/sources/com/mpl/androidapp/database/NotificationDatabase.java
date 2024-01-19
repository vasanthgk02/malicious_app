package com.mpl.androidapp.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.database.dao.NotifictionDrawerDao;

public abstract class NotificationDatabase extends RoomDatabase {
    public abstract NotifictionDrawerDao dataAccessObject();
}
