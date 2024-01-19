package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry.AutoRecreated;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements LifecycleEventObserver {
    public final SavedStateRegistryOwner mOwner;

    public static final class SavedStateProvider implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {
        public final Set<String> mClasses = new HashSet();

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
        }

        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.mClasses));
            return bundle;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        if (event == Event.ON_CREATE) {
            LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycleOwner.getLifecycle();
            lifecycleRegistry.enforceMainThreadIfNeeded("removeObserver");
            lifecycleRegistry.mObserverMap.remove(this);
            Bundle consumeRestoredStateForKey = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
            if (consumeRestoredStateForKey != null) {
                ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            Class<? extends U> asSubclass = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(AutoRecreated.class);
                            try {
                                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((AutoRecreated) declaredConstructor.newInstance(new Object[0])).onRecreated(this.mOwner);
                                } catch (Exception e2) {
                                    throw new RuntimeException(GeneratedOutlineSupport.outline50("Failed to instantiate ", next), e2);
                                }
                            } catch (NoSuchMethodException e3) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class");
                                outline73.append(asSubclass.getSimpleName());
                                outline73.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(outline73.toString(), e3);
                            }
                        } catch (ClassNotFoundException e4) {
                            throw new RuntimeException(GeneratedOutlineSupport.outline52("Class ", next, " wasn't found"), e4);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
