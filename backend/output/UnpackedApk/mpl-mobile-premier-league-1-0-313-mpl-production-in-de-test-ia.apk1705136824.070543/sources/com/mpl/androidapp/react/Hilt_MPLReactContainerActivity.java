package com.mpl.androidapp.react;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.mpl.androidapp.MPLBaseActivity;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;

public abstract class Hilt_MPLReactContainerActivity extends MPLBaseActivity implements GeneratedComponentManager {
    public volatile ActivityComponentManager componentManager;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    public Hilt_MPLReactContainerActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_MPLReactContainerActivity.this.inject();
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
            ((MPLReactContainerActivity_GeneratedInjector) generatedComponent()).injectMPLReactContainerActivity((MPLReactContainerActivity) this);
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
