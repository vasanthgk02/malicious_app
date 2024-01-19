package com.mpl.androidapp.unity.vm;

import com.mpl.androidapp.unity.vm.MiniProfileContainerVm_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory INSTANCE = new MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory();
    }

    public static MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory create() {
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
