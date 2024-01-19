package dagger.hilt.android.internal.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public final class HiltViewModelFactory implements Factory {
    public final Factory delegateFactory;
    public final AbstractSavedStateViewModelFactory hiltViewModelFactory;
    public final Set<String> hiltViewModelKeys;

    public interface ViewModelFactoriesEntryPoint {
        Map<String, Provider<ViewModel>> getHiltViewModelMap();
    }

    public HiltViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, Set<String> set, Factory factory, final ViewModelComponentBuilder viewModelComponentBuilder) {
        this.hiltViewModelKeys = set;
        this.delegateFactory = factory;
        this.hiltViewModelFactory = new AbstractSavedStateViewModelFactory(this, savedStateRegistryOwner, bundle) {
        };
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        if (this.hiltViewModelKeys.contains(cls.getName())) {
            return this.hiltViewModelFactory.create(cls);
        }
        return this.delegateFactory.create(cls);
    }
}
