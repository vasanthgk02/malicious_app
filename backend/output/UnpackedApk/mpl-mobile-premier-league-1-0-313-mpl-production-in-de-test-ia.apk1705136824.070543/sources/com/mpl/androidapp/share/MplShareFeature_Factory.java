package com.mpl.androidapp.share;

import android.content.Context;
import com.mpl.androidapp.share.repositories.MplShareRepository;
import com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent;
import com.mpl.androidapp.share.usecases.PrepareShareIntent;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class MplShareFeature_Factory implements Factory<MplShareFeature> {
    public final Provider<CheckSharePlatformIsPresent> checkSharePlatformIsPresentProvider;
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<MplShareRepository> mplShareRepositoryProvider;
    public final Provider<PrepareShareIntent> prepareShareIntentProvider;

    public MplShareFeature_Factory(Provider<Context> provider, Provider<MplShareRepository> provider2, Provider<CheckSharePlatformIsPresent> provider3, Provider<PrepareShareIntent> provider4, Provider<CoroutineDispatcher> provider5) {
        this.contextProvider = provider;
        this.mplShareRepositoryProvider = provider2;
        this.checkSharePlatformIsPresentProvider = provider3;
        this.prepareShareIntentProvider = provider4;
        this.ioDispatcherProvider = provider5;
    }

    public static MplShareFeature_Factory create(Provider<Context> provider, Provider<MplShareRepository> provider2, Provider<CheckSharePlatformIsPresent> provider3, Provider<PrepareShareIntent> provider4, Provider<CoroutineDispatcher> provider5) {
        MplShareFeature_Factory mplShareFeature_Factory = new MplShareFeature_Factory(provider, provider2, provider3, provider4, provider5);
        return mplShareFeature_Factory;
    }

    public static MplShareFeature newInstance(Context context, MplShareRepository mplShareRepository, CheckSharePlatformIsPresent checkSharePlatformIsPresent, PrepareShareIntent prepareShareIntent, CoroutineDispatcher coroutineDispatcher) {
        MplShareFeature mplShareFeature = new MplShareFeature(context, mplShareRepository, checkSharePlatformIsPresent, prepareShareIntent, coroutineDispatcher);
        return mplShareFeature;
    }

    public MplShareFeature get() {
        return newInstance((Context) this.contextProvider.get(), (MplShareRepository) this.mplShareRepositoryProvider.get(), (CheckSharePlatformIsPresent) this.checkSharePlatformIsPresentProvider.get(), (PrepareShareIntent) this.prepareShareIntentProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
