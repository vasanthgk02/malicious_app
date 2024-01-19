package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProvider.KeyedFactory;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory extends KeyedFactory {
    public static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE;
    public static final Class<?>[] VIEWMODEL_SIGNATURE;
    public final Application mApplication;
    public final Bundle mDefaultArgs;
    public final Factory mFactory;
    public final Lifecycle mLifecycle;
    public final SavedStateRegistry mSavedStateRegistry;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = new Class[]{Application.class, cls};
        VIEWMODEL_SIGNATURE = new Class[]{cls};
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        Factory factory;
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = application;
        if (application != null) {
            if (AndroidViewModelFactory.sInstance == null) {
                AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
            }
            factory = AndroidViewModelFactory.sInstance;
        } else {
            if (NewInstanceFactory.sInstance == null) {
                NewInstanceFactory.sInstance = new NewInstanceFactory();
            }
            factory = NewInstanceFactory.sInstance;
        }
        this.mFactory = factory;
    }

    public static <T> Constructor<T> findMatchingConstructor(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<T> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    public <T extends ViewModel> T create(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t;
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.mApplication == null) {
            constructor = findMatchingConstructor(cls, VIEWMODEL_SIGNATURE);
        } else {
            constructor = findMatchingConstructor(cls, ANDROID_VIEWMODEL_SIGNATURE);
        }
        if (constructor == null) {
            return this.mFactory.create(cls);
        }
        SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
        Lifecycle lifecycle = this.mLifecycle;
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), this.mDefaultArgs));
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
        if (isAssignableFrom) {
            try {
                if (this.mApplication != null) {
                    t = (ViewModel) constructor.newInstance(new Object[]{this.mApplication, savedStateHandleController.mHandle});
                    t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                    return t;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        t = (ViewModel) constructor.newInstance(new Object[]{savedStateHandleController.mHandle});
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return t;
    }

    public void onRequery(ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
