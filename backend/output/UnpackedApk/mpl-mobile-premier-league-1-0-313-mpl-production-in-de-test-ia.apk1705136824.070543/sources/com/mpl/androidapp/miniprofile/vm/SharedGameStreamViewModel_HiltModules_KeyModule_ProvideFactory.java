package com.mpl.androidapp.miniprofile.vm;

import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory();
    }

    public static SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory create() {
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