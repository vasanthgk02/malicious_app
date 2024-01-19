package com.mpl.androidapp.webview;

import androidx.lifecycle.ViewModel;

public final class PokerWebViewVm_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(PokerWebViewVm pokerWebViewVm);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.webview.PokerWebViewVm";
        }
    }
}
