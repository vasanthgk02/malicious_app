package com.mpl.androidapp.webview.repositories;

import com.mpl.androidapp.webview.services.WebFlowGamesService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class WebFlowRepository_Factory implements Factory<WebFlowRepository> {
    public final Provider<WebFlowGamesService> webFlowGamesServiceProvider;

    public WebFlowRepository_Factory(Provider<WebFlowGamesService> provider) {
        this.webFlowGamesServiceProvider = provider;
    }

    public static WebFlowRepository_Factory create(Provider<WebFlowGamesService> provider) {
        return new WebFlowRepository_Factory(provider);
    }

    public static WebFlowRepository newInstance(WebFlowGamesService webFlowGamesService) {
        return new WebFlowRepository(webFlowGamesService);
    }

    public WebFlowRepository get() {
        return newInstance((WebFlowGamesService) this.webFlowGamesServiceProvider.get());
    }
}
