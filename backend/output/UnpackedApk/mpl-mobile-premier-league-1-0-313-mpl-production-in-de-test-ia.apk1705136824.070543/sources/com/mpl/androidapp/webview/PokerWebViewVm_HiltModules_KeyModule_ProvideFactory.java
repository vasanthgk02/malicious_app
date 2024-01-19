package com.mpl.androidapp.webview;

import com.mpl.androidapp.webview.PokerWebViewVm_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class PokerWebViewVm_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final PokerWebViewVm_HiltModules_KeyModule_ProvideFactory INSTANCE = new PokerWebViewVm_HiltModules_KeyModule_ProvideFactory();
    }

    public static PokerWebViewVm_HiltModules_KeyModule_ProvideFactory create() {
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
