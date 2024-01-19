package com.mpl.androidapp.miniprofile.base;

import com.mpl.androidapp.miniprofile.base.BaseViewModel_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class BaseViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final BaseViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new BaseViewModel_HiltModules_KeyModule_ProvideFactory();
    }

    public static BaseViewModel_HiltModules_KeyModule_ProvideFactory create() {
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
