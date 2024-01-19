package com.mpl.androidapp.webview.vm;

import com.mpl.androidapp.webview.vm.WebViewGameVm_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class WebViewGameVm_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final WebViewGameVm_HiltModules_KeyModule_ProvideFactory INSTANCE = new WebViewGameVm_HiltModules_KeyModule_ProvideFactory();
    }

    public static WebViewGameVm_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        String provide = KeyModule.provide();
        TweetUtils.checkNotNullFromProvides(provide);
        return provide;
    }

    public String get() {
        return provide();
    }
}
