package com.mpl.androidapp.webview.services;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class WebFlowGamesService_Factory implements Factory<WebFlowGamesService> {
    public final Provider<Gson> gsonProvider;

    public WebFlowGamesService_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static WebFlowGamesService_Factory create(Provider<Gson> provider) {
        return new WebFlowGamesService_Factory(provider);
    }

    public static WebFlowGamesService newInstance(Gson gson) {
        return new WebFlowGamesService(gson);
    }

    public WebFlowGamesService get() {
        return newInstance((Gson) this.gsonProvider.get());
    }
}
