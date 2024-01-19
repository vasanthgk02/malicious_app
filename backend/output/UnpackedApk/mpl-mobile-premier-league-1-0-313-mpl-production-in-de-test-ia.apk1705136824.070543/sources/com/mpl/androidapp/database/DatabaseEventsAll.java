package com.mpl.androidapp.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.database.dao.EventDaoAll;

public abstract class DatabaseEventsAll extends RoomDatabase {
    public abstract EventDaoAll eventDaoAll();
}
