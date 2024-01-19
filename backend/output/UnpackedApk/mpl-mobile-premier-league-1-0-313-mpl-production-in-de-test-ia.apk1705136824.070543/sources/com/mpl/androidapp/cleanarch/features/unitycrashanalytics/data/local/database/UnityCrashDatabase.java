package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao;

public abstract class UnityCrashDatabase extends RoomDatabase {
    public abstract UnityCrashDao unityCrashDao();
}
