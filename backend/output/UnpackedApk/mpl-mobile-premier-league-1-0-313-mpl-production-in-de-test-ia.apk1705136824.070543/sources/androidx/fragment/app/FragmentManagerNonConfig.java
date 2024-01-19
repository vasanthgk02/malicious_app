package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
    public final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    public final Collection<Fragment> mFragments;
    public final Map<String, ViewModelStore> mViewModelStores;

    public FragmentManagerNonConfig(Collection<Fragment> collection, Map<String, FragmentManagerNonConfig> map, Map<String, ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    public Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(Fragment fragment) {
        Collection<Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
