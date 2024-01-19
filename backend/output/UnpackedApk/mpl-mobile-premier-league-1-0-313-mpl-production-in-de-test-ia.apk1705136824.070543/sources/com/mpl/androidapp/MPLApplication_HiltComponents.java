package com.mpl.androidapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.entrypoints.UnityCrashModuleEntryPoint;
import com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment_GeneratedInjector;
import com.mpl.androidapp.react.MPLReactContainerActivity_GeneratedInjector;
import com.mpl.androidapp.unity.di.entrypoints.HiltWrapper_UnityShareImageEntryPoint;
import com.mpl.androidapp.unity.di.entrypoints.MplUnityFeaturesEntryPoint;
import com.mpl.androidapp.unity.views.MiniProfileContainerFragment_GeneratedInjector;
import com.mpl.androidapp.unity.views.UnityMiniProfileActivity_GeneratedInjector;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.HiltWrapper_AssetDownloadEntryPoint;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.NotificationDisplayEntryPoint;
import com.mpl.androidapp.webview.PokerWebViewActivity_GeneratedInjector;
import com.mpl.androidapp.webview.view.activities.WebViewGameActivity_GeneratedInjector;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$ActivityEntryPoint;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$FragmentEntryPoint;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$InternalFactoryFactory;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint;
import dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.FragmentComponentManager.FragmentComponentBuilderEntryPoint;
import dagger.hilt.internal.GeneratedComponent;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public final class MPLApplication_HiltComponents {

    public static abstract class ActivityC implements MPLReactContainerActivity_GeneratedInjector, UnityMiniProfileActivity_GeneratedInjector, PokerWebViewActivity_GeneratedInjector, WebViewGameActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories$ActivityEntryPoint, FragmentComponentBuilderEntryPoint, GeneratedComponent {

        public interface Builder extends ActivityComponentBuilder {
            /* synthetic */ ActivityComponentBuilder activity(Activity activity);

            /* synthetic */ ActivityComponent build();
        }

        public abstract /* synthetic */ FragmentComponentBuilder fragmentComponentBuilder();

        public abstract /* synthetic */ DefaultViewModelFactories$InternalFactoryFactory getHiltInternalFactoryFactory();

        public abstract /* synthetic */ ViewModelComponentBuilder getViewModelComponentBuilder();

        public abstract /* synthetic */ Set<String> getViewModelKeys();

        public abstract /* synthetic */ ViewComponentBuilder viewComponentBuilder();
    }

    public interface ActivityCBuilderModule {
        ActivityComponentBuilder bind(Builder builder);
    }

    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentBuilderEntryPoint, ActivityRetainedLifecycleEntryPoint, GeneratedComponent {

        public interface Builder extends ActivityRetainedComponentBuilder {
            /* synthetic */ ActivityRetainedComponent build();
        }

        public abstract /* synthetic */ ActivityComponentBuilder activityComponentBuilder();

        public abstract /* synthetic */ ActivityRetainedLifecycle getActivityRetainedLifecycle();
    }

    public interface ActivityRetainedCBuilderModule {
        ActivityRetainedComponentBuilder bind(Builder builder);
    }

    public static abstract class FragmentC implements MiniProfileFragment_GeneratedInjector, MiniProfileContainerFragment_GeneratedInjector, FragmentComponent, DefaultViewModelFactories$FragmentEntryPoint, GeneratedComponent {

        public interface Builder extends FragmentComponentBuilder {
            /* synthetic */ FragmentComponent build();

            /* synthetic */ FragmentComponentBuilder fragment(Fragment fragment);
        }

        public abstract /* synthetic */ DefaultViewModelFactories$InternalFactoryFactory getHiltInternalFactoryFactory();

        public abstract /* synthetic */ ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder();
    }

    public interface FragmentCBuilderModule {
        FragmentComponentBuilder bind(Builder builder);
    }

    public static abstract class ServiceC implements ServiceComponent, GeneratedComponent {

        public interface Builder extends ServiceComponentBuilder {
            /* synthetic */ ServiceComponent build();

            /* synthetic */ ServiceComponentBuilder service(Service service);
        }
    }

    public interface ServiceCBuilderModule {
        ServiceComponentBuilder bind(Builder builder);
    }

    public static abstract class SingletonC implements MPLApplication_GeneratedInjector, UnityCrashModuleEntryPoint, HiltWrapper_UnityShareImageEntryPoint, MplUnityFeaturesEntryPoint, HiltWrapper_AssetDownloadEntryPoint, NotificationDisplayEntryPoint, ActivityRetainedComponentBuilderEntryPoint, GeneratedComponent {
        public abstract /* synthetic */ ActivityRetainedComponentBuilder retainedComponentBuilder();

        public abstract /* synthetic */ ServiceComponentBuilder serviceComponentBuilder();
    }

    public static abstract class ViewC implements ViewComponent, GeneratedComponent {

        public interface Builder extends ViewComponentBuilder {
            /* synthetic */ ViewComponent build();

            /* synthetic */ ViewComponentBuilder view(View view);
        }
    }

    public interface ViewCBuilderModule {
        ViewComponentBuilder bind(Builder builder);
    }

    public static abstract class ViewModelC implements ViewModelComponent, ViewModelFactoriesEntryPoint, GeneratedComponent {

        public interface Builder extends ViewModelComponentBuilder {
            /* synthetic */ ViewModelComponent build();

            /* synthetic */ ViewModelComponentBuilder savedStateHandle(SavedStateHandle savedStateHandle);
        }

        public abstract /* synthetic */ Map<String, Provider<ViewModel>> getHiltViewModelMap();
    }

    public interface ViewModelCBuilderModule {
        ViewModelComponentBuilder bind(Builder builder);
    }

    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        public interface Builder extends ViewWithFragmentComponentBuilder {
            /* synthetic */ ViewWithFragmentComponent build();

            /* synthetic */ ViewWithFragmentComponentBuilder view(View view);
        }
    }

    public interface ViewWithFragmentCBuilderModule {
        ViewWithFragmentComponentBuilder bind(Builder builder);
    }
}
