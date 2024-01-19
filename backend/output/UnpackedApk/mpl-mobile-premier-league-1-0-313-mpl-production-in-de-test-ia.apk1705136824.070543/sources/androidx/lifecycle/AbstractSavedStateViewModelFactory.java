package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider.KeyedFactory;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint;
import javax.inject.Provider;

public abstract class AbstractSavedStateViewModelFactory extends KeyedFactory {
    public final Bundle mDefaultArgs;
    public final Lifecycle mLifecycle;
    public final SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
        Lifecycle lifecycle = this.mLifecycle;
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), this.mDefaultArgs));
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
        Provider provider = ((ViewModelFactoriesEntryPoint) TweetUtils.get(r5.savedStateHandle(savedStateHandleController.mHandle).build(), ViewModelFactoriesEntryPoint.class)).getHiltViewModelMap().get(cls.getName());
        if (provider != null) {
            T t = (ViewModel) provider.get();
            t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
            return t;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline36(cls, GeneratedOutlineSupport.outline73("Expected the @HiltViewModel-annotated class '"), "' to be available in the multi-binding of @HiltViewModelMap but none was found."));
    }

    public void onRequery(ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }

    public final <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
