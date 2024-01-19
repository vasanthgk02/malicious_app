package com.mpl.androidapp.updater.downloadmanager.di.modules;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.dao.GameAssetsDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/di/modules/DatabaseModule;", "", "()V", "provideAppDatabase", "Lcom/mpl/androidapp/database/AssetsDatabase;", "appContext", "Landroid/content/Context;", "provideChannelDao", "Lcom/mpl/androidapp/database/dao/GameAssetsDao;", "assetsDatabase", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseModule.kt */
public final class DatabaseModule {
    public final AssetsDatabase provideAppDatabase(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Builder<AssetsDatabase> databaseBuilder = Room.databaseBuilder(context, AssetsDatabase.class, "assets_database.db");
        databaseBuilder.fallbackToDestructiveMigration();
        return (AssetsDatabase) databaseBuilder.build();
    }

    public final GameAssetsDao provideChannelDao(AssetsDatabase assetsDatabase) {
        Intrinsics.checkNotNullParameter(assetsDatabase, "assetsDatabase");
        GameAssetsDao gameAssetsDao = assetsDatabase.gameAssetsDao();
        Intrinsics.checkNotNullExpressionValue(gameAssetsDao, "assetsDatabase.gameAssetsDao()");
        return gameAssetsDao;
    }
}
