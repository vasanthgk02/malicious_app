package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.util.Map.Entry;

public final class SavedStateRegistryController {
    public final SavedStateRegistryOwner mOwner;
    public final SavedStateRegistry mRegistry = new SavedStateRegistry();

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    public void performRestore(Bundle bundle) {
        Lifecycle lifecycle = this.mOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).mState == State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(this.mOwner));
            SavedStateRegistry savedStateRegistry = this.mRegistry;
            if (!savedStateRegistry.mRestored) {
                if (bundle != null) {
                    savedStateRegistry.mRestoredState = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.addObserver(new LifecycleEventObserver() {
                    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
                        if (event == Event.ON_START) {
                            SavedStateRegistry.this.mAllowingSavingState = true;
                        } else if (event == Event.ON_STOP) {
                            SavedStateRegistry.this.mAllowingSavingState = false;
                        }
                    }
                });
                savedStateRegistry.mRestored = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void performSave(Bundle bundle) {
        SavedStateRegistry savedStateRegistry = this.mRegistry;
        if (savedStateRegistry != null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = savedStateRegistry.mRestoredState;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            IteratorWithAdditions iteratorWithAdditions = savedStateRegistry.mComponents.iteratorWithAdditions();
            while (iteratorWithAdditions.hasNext()) {
                Entry entry = (Entry) iteratorWithAdditions.next();
                bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
            }
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        throw null;
    }
}
