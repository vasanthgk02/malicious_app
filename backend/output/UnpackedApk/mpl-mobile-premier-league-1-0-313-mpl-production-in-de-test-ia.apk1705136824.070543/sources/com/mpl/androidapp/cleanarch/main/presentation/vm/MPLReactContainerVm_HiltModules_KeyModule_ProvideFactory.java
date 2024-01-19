package com.mpl.androidapp.cleanarch.main.presentation.vm;

import com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm_HiltModules.KeyModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class InstanceHolder {
        public static final MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory INSTANCE = new MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory();
    }

    public static MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory create() {
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
