package com.mpl.androidapp.webview;

import android.app.Application;
import com.mpl.androidapp.updater.downloadmanager.usecases.DownloadAssetTaskUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PrepareGameAssetUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PokerWebViewVm_Factory implements Factory<PokerWebViewVm> {
    public final Provider<Application> contextProvider;
    public final Provider<DownloadAssetTaskUseCase> downloadPokerAssetTaskProvider;
    public final Provider<PrepareGameAssetUseCase> prepareGameAssetProvider;

    public PokerWebViewVm_Factory(Provider<Application> provider, Provider<PrepareGameAssetUseCase> provider2, Provider<DownloadAssetTaskUseCase> provider3) {
        this.contextProvider = provider;
        this.prepareGameAssetProvider = provider2;
        this.downloadPokerAssetTaskProvider = provider3;
    }

    public static PokerWebViewVm_Factory create(Provider<Application> provider, Provider<PrepareGameAssetUseCase> provider2, Provider<DownloadAssetTaskUseCase> provider3) {
        return new PokerWebViewVm_Factory(provider, provider2, provider3);
    }

    public static PokerWebViewVm newInstance(Application application, PrepareGameAssetUseCase prepareGameAssetUseCase, DownloadAssetTaskUseCase downloadAssetTaskUseCase) {
        return new PokerWebViewVm(application, prepareGameAssetUseCase, downloadAssetTaskUseCase);
    }

    public PokerWebViewVm get() {
        return newInstance((Application) this.contextProvider.get(), (PrepareGameAssetUseCase) this.prepareGameAssetProvider.get(), (DownloadAssetTaskUseCase) this.downloadPokerAssetTaskProvider.get());
    }
}
