package com.mpl.androidapp.miniprofile.vm;

import androidx.lifecycle.ViewModel;

public final class SharedGameStreamViewModel_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(SharedGameStreamViewModel sharedGameStreamViewModel);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel";
        }
    }
}
