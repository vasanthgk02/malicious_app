package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.dao.UnityCrashDao;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UnityCrashDatabaseModule_ProvideUnityCrashDaoFactory implements Factory<UnityCrashDao> {
    public final Provider<UnityCrashDatabase> databaseProvider;
    public final UnityCrashDatabaseModule module;

    public UnityCrashDatabaseModule_ProvideUnityCrashDaoFactory(UnityCrashDatabaseModule unityCrashDatabaseModule, Provider<UnityCrashDatabase> provider) {
        this.module = unityCrashDatabaseModule;
        this.databaseProvider = provider;
    }

    public static UnityCrashDatabaseModule_ProvideUnityCrashDaoFactory create(UnityCrashDatabaseModule unityCrashDatabaseModule, Provider<UnityCrashDatabase> provider) {
        return new UnityCrashDatabaseModule_ProvideUnityCrashDaoFactory(unityCrashDatabaseModule, provider);
    }

    public static UnityCrashDao provideUnityCrashDao(UnityCrashDatabaseModule unityCrashDatabaseModule, UnityCrashDatabase unityCrashDatabase) {
        UnityCrashDao provideUnityCrashDao = unityCrashDatabaseModule.provideUnityCrashDao(unityCrashDatabase);
        TweetUtils.checkNotNullFromProvides(provideUnityCrashDao);
        return provideUnityCrashDao;
    }

    public UnityCrashDao get() {
        return provideUnityCrashDao(this.module, (UnityCrashDatabase) this.databaseProvider.get());
    }
}
