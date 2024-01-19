package com.mpl.androidapp.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.database.dao.GameAssetsDao;

public abstract class AssetsDatabase extends RoomDatabase {
    public abstract GameAssetsDao gameAssetsDao();
}
