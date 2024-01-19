package com.mpl.androidapp.webview.vm;

import androidx.lifecycle.ViewModel;

public final class WebViewGameVm_HiltModules {

    public static abstract class BindsModule {
        public abstract ViewModel binds(WebViewGameVm webViewGameVm);
    }

    public static final class KeyModule {
        public static String provide() {
            return "com.mpl.androidapp.webview.vm.WebViewGameVm";
        }
    }
}
