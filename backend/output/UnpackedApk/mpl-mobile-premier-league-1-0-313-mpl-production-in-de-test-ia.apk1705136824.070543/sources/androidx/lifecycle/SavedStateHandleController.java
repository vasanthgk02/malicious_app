package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.AutoRecreated;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.HashSet;
import java.util.Iterator;

public final class SavedStateHandleController implements LifecycleEventObserver {
    public final SavedStateHandle mHandle;
    public boolean mIsAttached = false;
    public final String mKey;

    public static final class OnRecreation implements AutoRecreated {
        public void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner) {
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                if (viewModelStore != null) {
                    Iterator it = new HashSet(viewModelStore.mMap.keySet()).iterator();
                    while (it.hasNext()) {
                        SavedStateHandleController.attachHandleIfNeeded(viewModelStore.mMap.get((String) it.next()), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                    }
                    if (!new HashSet(viewModelStore.mMap.keySet()).isEmpty()) {
                        savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                        return;
                    }
                    return;
                }
                throw null;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.mKey = str;
        this.mHandle = savedStateHandle;
    }

    public static void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.mIsAttached) {
            savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
            tryToAddRecreator(savedStateRegistry, lifecycle);
        }
    }

    public static void tryToAddRecreator(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        State state = ((LifecycleRegistry) lifecycle).mState;
        if (state == State.INITIALIZED || state.isAtLeast(State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
                    if (event == Event.ON_START) {
                        LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) Lifecycle.this;
                        lifecycleRegistry.enforceMainThreadIfNeeded("removeObserver");
                        lifecycleRegistry.mObserverMap.remove(this);
                        savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
        }
    }

    public void attachToLifecycle(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.mIsAttached) {
            this.mIsAttached = true;
            lifecycle.addObserver(this);
            savedStateRegistry.registerSavedStateProvider(this.mKey, this.mHandle.mSavedStateProvider);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        if (event == Event.ON_DESTROY) {
            this.mIsAttached = false;
            LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycleOwner.getLifecycle();
            lifecycleRegistry.enforceMainThreadIfNeeded("removeObserver");
            lifecycleRegistry.mObserverMap.remove(this);
        }
    }
}
