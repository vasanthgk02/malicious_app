package com.mpl.androidapp.unity.vm;

import androidx.lifecycle.ViewModel;

public final class MiniProfileContainerVm_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(MiniProfileContainerVm miniProfileContainerVm);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.unity.vm.MiniProfileContainerVm";
        }
    }
}
