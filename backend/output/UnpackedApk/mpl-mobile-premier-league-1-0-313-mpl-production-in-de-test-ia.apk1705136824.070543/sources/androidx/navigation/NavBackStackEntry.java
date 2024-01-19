package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public Bundle mArgs;
    public final Context mContext;
    public Factory mDefaultFactory;
    public final NavDestination mDestination;
    public State mHostLifecycle;
    public final UUID mId;
    public final LifecycleRegistry mLifecycle;
    public State mMaxLifecycle;
    public NavControllerViewModel mNavControllerViewModel;
    public final SavedStateRegistryController mSavedStateRegistryController;

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel) {
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), null);
    }

    public Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory((Application) this.mContext.getApplicationContext(), this, this.mArgs);
        }
        return this.mDefaultFactory;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mRegistry;
    }

    public ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.mNavControllerViewModel;
        if (navControllerViewModel != null) {
            UUID uuid = this.mId;
            ViewModelStore viewModelStore = navControllerViewModel.mViewModelStores.get(uuid);
            if (viewModelStore != null) {
                return viewModelStore;
            }
            ViewModelStore viewModelStore2 = new ViewModelStore();
            navControllerViewModel.mViewModelStores.put(uuid, viewModelStore2);
            return viewModelStore2;
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public void updateState() {
        if (this.mHostLifecycle.ordinal() < this.mMaxLifecycle.ordinal()) {
            this.mLifecycle.setCurrentState(this.mHostLifecycle);
        } else {
            this.mLifecycle.setCurrentState(this.mMaxLifecycle);
        }
    }

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel, UUID uuid, Bundle bundle2) {
        this.mLifecycle = new LifecycleRegistry(this);
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(this);
        this.mSavedStateRegistryController = savedStateRegistryController;
        this.mHostLifecycle = State.CREATED;
        this.mMaxLifecycle = State.RESUMED;
        this.mContext = context;
        this.mId = uuid;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        savedStateRegistryController.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.mHostLifecycle = ((LifecycleRegistry) lifecycleOwner.getLifecycle()).mState;
        }
    }
}
