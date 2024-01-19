package com.mpl.androidapp.miniprofile.vm;

import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory();
    }

    public static MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory create() {
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
