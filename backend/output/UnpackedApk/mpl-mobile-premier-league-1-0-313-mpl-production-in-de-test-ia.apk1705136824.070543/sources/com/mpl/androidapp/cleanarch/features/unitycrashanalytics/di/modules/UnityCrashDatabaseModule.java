package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/di/modules/UnityCrashDatabaseModule;", "", "()V", "provideUnityCrashDao", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/dao/UnityCrashDao;", "database", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/database/UnityCrashDatabase;", "provideUnityCrashDatabase", "appContext", "Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashDatabaseModule.kt */
public final class UnityCrashDatabaseModule {
    public final UnityCrashDao provideUnityCrashDao(UnityCrashDatabase unityCrashDatabase) {
        Intrinsics.checkNotNullParameter(unityCrashDatabase, "database");
        UnityCrashDao unityCrashDao = unityCrashDatabase.unityCrashDao();
        Intrinsics.checkNotNullExpressionValue(unityCrashDao, "database.unityCrashDao()");
        return unityCrashDao;
    }

    public final UnityCrashDatabase provideUnityCrashDatabase(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Builder<UnityCrashDatabase> databaseBuilder = Room.databaseBuilder(context, UnityCrashDatabase.class, "unity_crash_database.db");
        databaseBuilder.fallbackToDestructiveMigration();
        return (UnityCrashDatabase) databaseBuilder.build();
    }
}
