package com.mpl.androidapp.webview.view.activities;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.webview.base.WebViewBaseActivity;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import kotlin.jvm.functions.Function1;

public abstract class Hilt_WebViewGameActivity<VIEW_BINDING extends ViewBinding> extends WebViewBaseActivity<VIEW_BINDING> implements Object {
    public volatile ActivityComponentManager componentManager;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    public Hilt_WebViewGameActivity(Function1<? super LayoutInflater, ? extends VIEW_BINDING> function1) {
        super(function1);
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_WebViewGameActivity.this.inject();
            }
        });
    }

    public ActivityComponentManager createComponentManager() {
        return new ActivityComponentManager(this);
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public Factory getDefaultViewModelProviderFactory() {
        return TweetUtils.getActivityFactory(this, super.getDefaultViewModelProviderFactory());
    }

    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((WebViewGameActivity_GeneratedInjector) generatedComponent()).injectWebViewGameActivity((WebViewGameActivity) this);
        }
    }

    public final ActivityComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }
}
