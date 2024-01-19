package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules;

import android.content.Context;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory implements Factory<UnityCrashDatabase> {
    public final Provider<Context> appContextProvider;
    public final UnityCrashDatabaseModule module;

    public UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory(UnityCrashDatabaseModule unityCrashDatabaseModule, Provider<Context> provider) {
        this.module = unityCrashDatabaseModule;
        this.appContextProvider = provider;
    }

    public static UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory create(UnityCrashDatabaseModule unityCrashDatabaseModule, Provider<Context> provider) {
        return new UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory(unityCrashDatabaseModule, provider);
    }

    public static UnityCrashDatabase provideUnityCrashDatabase(UnityCrashDatabaseModule unityCrashDatabaseModule, Context context) {
        UnityCrashDatabase provideUnityCrashDatabase = unityCrashDatabaseModule.provideUnityCrashDatabase(context);
        TweetUtils.checkNotNullFromProvides(provideUnityCrashDatabase);
        return provideUnityCrashDatabase;
    }

    public UnityCrashDatabase get() {
        return provideUnityCrashDatabase(this.module, (Context) this.appContextProvider.get());
    }
}
