package com.mpl.androidapp.updater.downloadmanager.di.modules;

import android.content.Context;
import com.mpl.androidapp.database.AssetsDatabase;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DatabaseModule_ProvideAppDatabaseFactory implements Factory<AssetsDatabase> {
    public final Provider<Context> appContextProvider;
    public final DatabaseModule module;

    public DatabaseModule_ProvideAppDatabaseFactory(DatabaseModule databaseModule, Provider<Context> provider) {
        this.module = databaseModule;
        this.appContextProvider = provider;
    }

    public static DatabaseModule_ProvideAppDatabaseFactory create(DatabaseModule databaseModule, Provider<Context> provider) {
        return new DatabaseModule_ProvideAppDatabaseFactory(databaseModule, provider);
    }

    public static AssetsDatabase provideAppDatabase(DatabaseModule databaseModule, Context context) {
        AssetsDatabase provideAppDatabase = databaseModule.provideAppDatabase(context);
        TweetUtils.checkNotNullFromProvides(provideAppDatabase);
        return provideAppDatabase;
    }

    public AssetsDatabase get() {
        return provideAppDatabase(this.module, (Context) this.appContextProvider.get());
    }
}
