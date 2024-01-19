package androidx.fragment.app;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProvider.KeyedFactory;
import androidx.lifecycle.ViewModelProvider.OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class FragmentManagerViewModel extends ViewModel {
    public static final Factory FACTORY = new Factory() {
        public <T extends ViewModel> T create(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };
    public static final String TAG = "FragmentManager";
    public final HashMap<String, FragmentManagerViewModel> mChildNonConfigs = new HashMap<>();
    public boolean mHasBeenCleared = false;
    public boolean mHasSavedSnapshot = false;
    public boolean mIsStateSaved = false;
    public final HashMap<String, Fragment> mRetainedFragments = new HashMap<>();
    public final boolean mStateAutomaticallySaved;
    public final HashMap<String, ViewModelStore> mViewModelStores = new HashMap<>();

    public FragmentManagerViewModel(boolean z) {
        this.mStateAutomaticallySaved = z;
    }

    public static FragmentManagerViewModel getInstance(ViewModelStore viewModelStore) {
        ViewModel viewModel;
        Factory factory = FACTORY;
        Class cls = FragmentManagerViewModel.class;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String outline50 = GeneratedOutlineSupport.outline50("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            ViewModel viewModel2 = viewModelStore.mMap.get(outline50);
            if (!cls.isInstance(viewModel2)) {
                if (factory instanceof KeyedFactory) {
                    viewModel = ((KeyedFactory) factory).create(outline50, cls);
                } else {
                    viewModel = factory.create(cls);
                }
                viewModel2 = viewModel;
                ViewModel put = viewModelStore.mMap.put(outline50, viewModel2);
                if (put != null) {
                    put.onCleared();
                }
            } else if (factory instanceof OnRequeryFactory) {
                ((OnRequeryFactory) factory).onRequery(viewModel2);
            }
            return (FragmentManagerViewModel) viewModel2;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public void addRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
        } else if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            this.mRetainedFragments.put(fragment.mWho, fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                "Updating retained Fragments: Added " + fragment;
            }
        }
    }

    public void clearNonConfigState(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(3)) {
            "Clearing non-config state for " + fragment;
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            this.mChildNonConfigs.remove(fragment.mWho);
        }
        ViewModelStore viewModelStore = this.mViewModelStores.get(fragment.mWho);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.mViewModelStores.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        if (!this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) || !this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) || !this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores)) {
            z = false;
        }
        return z;
    }

    public Fragment findRetainedFragmentByWho(String str) {
        return this.mRetainedFragments.get(str);
    }

    public FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mChildNonConfigs.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
        this.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    public Collection<Fragment> getRetainedFragments() {
        return new ArrayList(this.mRetainedFragments.values());
    }

    @Deprecated
    public FragmentManagerNonConfig getSnapshot() {
        if (this.mRetainedFragments.isEmpty() && this.mChildNonConfigs.isEmpty() && this.mViewModelStores.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Entry next : this.mChildNonConfigs.entrySet()) {
            FragmentManagerNonConfig snapshot = ((FragmentManagerViewModel) next.getValue()).getSnapshot();
            if (snapshot != null) {
                hashMap.put(next.getKey(), snapshot);
            }
        }
        this.mHasSavedSnapshot = true;
        if (!this.mRetainedFragments.isEmpty() || !hashMap.isEmpty() || !this.mViewModelStores.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments.values()), hashMap, new HashMap(this.mViewModelStores));
        }
        return null;
    }

    public ViewModelStore getViewModelStore(Fragment fragment) {
        ViewModelStore viewModelStore = this.mViewModelStores.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.mViewModelStores.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public int hashCode() {
        int hashCode = this.mChildNonConfigs.hashCode();
        return this.mViewModelStores.hashCode() + ((hashCode + (this.mRetainedFragments.hashCode() * 31)) * 31);
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    public void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            "onCleared called for " + this;
        }
        this.mHasBeenCleared = true;
    }

    public void removeRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
            return;
        }
        if ((this.mRetainedFragments.remove(fragment.mWho) != null) && FragmentManager.isLoggingEnabled(2)) {
            "Updating retained Fragments: Removed " + fragment;
        }
    }

    @Deprecated
    public void restoreFromSnapshot(FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        this.mViewModelStores.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment next : fragments) {
                    if (next != null) {
                        this.mRetainedFragments.put(next.mWho, next);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (Entry next2 : childNonConfigs.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
                    fragmentManagerViewModel.restoreFromSnapshot((FragmentManagerNonConfig) next2.getValue());
                    this.mChildNonConfigs.put(next2.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> viewModelStores = fragmentManagerNonConfig.getViewModelStores();
            if (viewModelStores != null) {
                this.mViewModelStores.putAll(viewModelStores);
            }
        }
        this.mHasSavedSnapshot = false;
    }

    public void setIsStateSaved(boolean z) {
        this.mIsStateSaved = z;
    }

    public boolean shouldDestroy(Fragment fragment) {
        if (!this.mRetainedFragments.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.mStateAutomaticallySaved) {
            return this.mHasBeenCleared;
        }
        return !this.mHasSavedSnapshot;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
