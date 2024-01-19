package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import com.android.tools.r8.GeneratedOutlineSupport;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    public boolean mAllowingSavingState = true;
    public SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap<>();
    public androidx.savedstate.Recreator.SavedStateProvider mRecreatorProvider;
    public boolean mRestored;
    public Bundle mRestoredState;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    public Bundle consumeRestoredStateForKey(String str) {
        if (this.mRestored) {
            Bundle bundle = this.mRestoredState;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.mRestoredState.remove(str);
            if (this.mRestoredState.isEmpty()) {
                this.mRestoredState = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        if (((SavedStateProvider) this.mComponents.putIfAbsent(str, savedStateProvider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        if (this.mAllowingSavingState) {
            if (this.mRecreatorProvider == null) {
                this.mRecreatorProvider = new androidx.savedstate.Recreator.SavedStateProvider(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                androidx.savedstate.Recreator.SavedStateProvider savedStateProvider = this.mRecreatorProvider;
                savedStateProvider.mClasses.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class");
                outline73.append(cls.getSimpleName());
                outline73.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(outline73.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
