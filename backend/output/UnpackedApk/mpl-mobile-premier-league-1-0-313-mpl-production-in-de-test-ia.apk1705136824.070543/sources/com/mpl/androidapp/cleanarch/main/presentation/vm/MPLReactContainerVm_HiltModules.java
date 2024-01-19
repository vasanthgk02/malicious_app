package com.mpl.androidapp.cleanarch.main.presentation.vm;

import androidx.lifecycle.ViewModel;

public final class MPLReactContainerVm_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(MPLReactContainerVm mPLReactContainerVm);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm";
        }
    }
}
