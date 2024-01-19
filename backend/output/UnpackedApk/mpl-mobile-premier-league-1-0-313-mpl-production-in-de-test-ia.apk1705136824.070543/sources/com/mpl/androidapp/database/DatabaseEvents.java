package com.mpl.androidapp.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.database.dao.EventDao;

public abstract class DatabaseEvents extends RoomDatabase {
    public abstract EventDao eventDao();
}
