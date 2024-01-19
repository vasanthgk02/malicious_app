package com.mpl.androidapp.miniprofile.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.miniprofile.base.BaseBottomSheetDialogFragment;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import kotlin.jvm.functions.Function3;

public abstract class Hilt_MiniProfileFragment<VIEW_BINDING extends ViewBinding> extends BaseBottomSheetDialogFragment<VIEW_BINDING> implements Object {
    public ContextWrapper componentContext;
    public volatile FragmentComponentManager componentManager;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    public Hilt_MiniProfileFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VIEW_BINDING> function3) {
        super(function3);
    }

    private void initializeComponentContext() {
        if (this.componentContext == null) {
            this.componentContext = new ViewComponentManager$FragmentContextWrapper(super.getContext(), (Fragment) this);
        }
    }

    public FragmentComponentManager createComponentManager() {
        return new FragmentComponentManager(this);
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public Context getContext() {
        if (super.getContext() == null && this.componentContext == null) {
            return null;
        }
        initializeComponentContext();
        return this.componentContext;
    }

    public Factory getDefaultViewModelProviderFactory() {
        return TweetUtils.getFragmentFactory(this, super.getDefaultViewModelProviderFactory());
    }

    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((MiniProfileFragment_GeneratedInjector) generatedComponent()).injectMiniProfileFragment((MiniProfileFragment) this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        initializeComponentContext();
        inject();
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(super.onGetLayoutInflater(bundle), (Fragment) this));
    }

    public final FragmentComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    public void onAttach(Activity activity) {
        boolean z;
        super.onAttach(activity);
        Object obj = this.componentContext;
        if (obj != null) {
            while ((obj instanceof ContextWrapper) && !(obj instanceof Activity)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            if (obj != activity) {
                z = false;
                TweetUtils.checkState(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
                initializeComponentContext();
                inject();
            }
        }
        z = true;
        TweetUtils.checkState(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        initializeComponentContext();
        inject();
    }
}
