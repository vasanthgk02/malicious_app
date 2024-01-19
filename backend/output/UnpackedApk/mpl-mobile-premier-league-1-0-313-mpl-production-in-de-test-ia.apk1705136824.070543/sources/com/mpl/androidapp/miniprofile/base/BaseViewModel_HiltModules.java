package com.mpl.androidapp.miniprofile.base;

import androidx.lifecycle.ViewModel;

public final class BaseViewModel_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(BaseViewModel baseViewModel);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.miniprofile.base.BaseViewModel";
        }
    }
}
