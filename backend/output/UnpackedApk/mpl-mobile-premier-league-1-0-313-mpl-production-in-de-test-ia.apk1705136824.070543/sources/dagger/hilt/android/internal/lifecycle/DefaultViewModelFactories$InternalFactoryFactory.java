package dagger.hilt.android.internal.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import java.util.Set;

public final class DefaultViewModelFactories$InternalFactoryFactory {
    public final Application application;
    public final Set<String> keySet;
    public final ViewModelComponentBuilder viewModelComponentBuilder;

    public DefaultViewModelFactories$InternalFactoryFactory(Application application2, Set<String> set, ViewModelComponentBuilder viewModelComponentBuilder2) {
        this.application = application2;
        this.keySet = set;
        this.viewModelComponentBuilder = viewModelComponentBuilder2;
    }

    public final Factory getHiltViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, Factory factory) {
        if (factory == null) {
            factory = new SavedStateViewModelFactory(this.application, savedStateRegistryOwner, bundle);
        }
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
        Bundle bundle2 = bundle;
        HiltViewModelFactory hiltViewModelFactory = new HiltViewModelFactory(savedStateRegistryOwner2, bundle2, this.keySet, factory, this.viewModelComponentBuilder);
        return hiltViewModelFactory;
    }
}
