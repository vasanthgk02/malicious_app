package com.mpl.androidapp.unity.views;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.mpl.androidapp.MPLBaseActivity;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;

public abstract class Hilt_UnityMiniProfileActivity extends MPLBaseActivity implements GeneratedComponentManager {
    public volatile ActivityComponentManager componentManager;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    public Hilt_UnityMiniProfileActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_UnityMiniProfileActivity.this.inject();
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
            ((UnityMiniProfileActivity_GeneratedInjector) generatedComponent()).injectUnityMiniProfileActivity((UnityMiniProfileActivity) this);
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