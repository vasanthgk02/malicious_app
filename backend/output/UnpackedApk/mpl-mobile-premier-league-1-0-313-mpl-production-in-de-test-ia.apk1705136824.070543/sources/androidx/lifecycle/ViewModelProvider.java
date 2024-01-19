package androidx.lifecycle;

import android.app.Application;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {
    public final Factory mFactory;
    public final ViewModelStore mViewModelStore;

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static AndroidViewModelFactory sInstance;
        public Application mApplication;

        public AndroidViewModelFactory(Application application) {
            this.mApplication = application;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.mApplication});
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public <T extends ViewModel> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends ViewModel> T create(String str, Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {
        public static NewInstanceFactory sInstance;

        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                return (ViewModel) cls.newInstance();
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r3) {
        /*
            r2 = this;
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r1 == 0) goto L_0x000f
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.ViewModelProvider$Factory r3 = r3.getDefaultViewModelProviderFactory()
            goto L_0x001c
        L_0x000f:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance
            if (r3 != 0) goto L_0x001a
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = new androidx.lifecycle.ViewModelProvider$NewInstanceFactory
            r3.<init>()
            androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance = r3
        L_0x001a:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance
        L_0x001c:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        T t;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String outline50 = GeneratedOutlineSupport.outline50("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            T t2 = (ViewModel) this.mViewModelStore.mMap.get(outline50);
            if (cls.isInstance(t2)) {
                Factory factory = this.mFactory;
                if (factory instanceof OnRequeryFactory) {
                    ((OnRequeryFactory) factory).onRequery(t2);
                }
            } else {
                Factory factory2 = this.mFactory;
                if (factory2 instanceof KeyedFactory) {
                    t = ((KeyedFactory) factory2).create(outline50, cls);
                } else {
                    t = factory2.create(cls);
                }
                t2 = t;
                ViewModel put = this.mViewModelStore.mMap.put(outline50, t2);
                if (put != null) {
                    put.onCleared();
                }
            }
            return t2;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }
}
