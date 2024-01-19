package com.mpl.androidapp.webview.vm;

import android.app.Application;
import com.google.gson.Gson;
import com.mpl.androidapp.share.MplShareFeature;
import com.mpl.androidapp.webview.repositories.WebFlowRepository;
import com.mpl.androidapp.webview.usecases.PrepHelpDeskDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepPaymentPageDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepUrlForWebViewLoadingUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class WebViewGameVm_Factory implements Factory<WebViewGameVm> {
    public final Provider<Application> contextProvider;
    public final Provider<Gson> gsonProvider;
    public final Provider<MplShareFeature> mplShareFeatureProvider;
    public final Provider<PrepHelpDeskDeepLinkUseCase> prepHelpDeskDeepLinkUseCaseProvider;
    public final Provider<PrepPaymentPageDeepLinkUseCase> prepPaymentPageDeepLinkUseCaseProvider;
    public final Provider<PrepUrlForWebViewLoadingUseCase> prepUrlForWebViewLoadingUseCaseProvider;
    public final Provider<WebFlowRepository> repositoryProvider;

    public WebViewGameVm_Factory(Provider<Application> provider, Provider<Gson> provider2, Provider<WebFlowRepository> provider3, Provider<PrepHelpDeskDeepLinkUseCase> provider4, Provider<PrepPaymentPageDeepLinkUseCase> provider5, Provider<PrepUrlForWebViewLoadingUseCase> provider6, Provider<MplShareFeature> provider7) {
        this.contextProvider = provider;
        this.gsonProvider = provider2;
        this.repositoryProvider = provider3;
        this.prepHelpDeskDeepLinkUseCaseProvider = provider4;
        this.prepPaymentPageDeepLinkUseCaseProvider = provider5;
        this.prepUrlForWebViewLoadingUseCaseProvider = provider6;
        this.mplShareFeatureProvider = provider7;
    }

    public static WebViewGameVm_Factory create(Provider<Application> provider, Provider<Gson> provider2, Provider<WebFlowRepository> provider3, Provider<PrepHelpDeskDeepLinkUseCase> provider4, Provider<PrepPaymentPageDeepLinkUseCase> provider5, Provider<PrepUrlForWebViewLoadingUseCase> provider6, Provider<MplShareFeature> provider7) {
        WebViewGameVm_Factory webViewGameVm_Factory = new WebViewGameVm_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return webViewGameVm_Factory;
    }

    public static WebViewGameVm newInstance(Application application, Gson gson, WebFlowRepository webFlowRepository, PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase, PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase, PrepUrlForWebViewLoadingUseCase prepUrlForWebViewLoadingUseCase, MplShareFeature mplShareFeature) {
        WebViewGameVm webViewGameVm = new WebViewGameVm(application, gson, webFlowRepository, prepHelpDeskDeepLinkUseCase, prepPaymentPageDeepLinkUseCase, prepUrlForWebViewLoadingUseCase, mplShareFeature);
        return webViewGameVm;
    }

    public WebViewGameVm get() {
        return newInstance((Application) this.contextProvider.get(), (Gson) this.gsonProvider.get(), (WebFlowRepository) this.repositoryProvider.get(), (PrepHelpDeskDeepLinkUseCase) this.prepHelpDeskDeepLinkUseCaseProvider.get(), (PrepPaymentPageDeepLinkUseCase) this.prepPaymentPageDeepLinkUseCaseProvider.get(), (PrepUrlForWebViewLoadingUseCase) this.prepUrlForWebViewLoadingUseCaseProvider.get(), (MplShareFeature) this.mplShareFeatureProvider.get());
    }
}
