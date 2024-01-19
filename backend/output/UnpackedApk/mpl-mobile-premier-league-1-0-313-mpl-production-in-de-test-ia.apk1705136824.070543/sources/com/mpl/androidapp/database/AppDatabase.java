package com.mpl.androidapp.database;

import androidx.room.RoomDatabase;
import com.mpl.androidapp.database.dao.AssetDao;
import com.mpl.androidapp.database.dao.ContactDao;
import com.mpl.androidapp.database.dao.MutedChannelDao;

public abstract class AppDatabase extends RoomDatabase {
    public abstract AssetDao assetDao();

    public abstract ContactDao contactDao();

    public abstract MutedChannelDao mutedChannelDao();
}
