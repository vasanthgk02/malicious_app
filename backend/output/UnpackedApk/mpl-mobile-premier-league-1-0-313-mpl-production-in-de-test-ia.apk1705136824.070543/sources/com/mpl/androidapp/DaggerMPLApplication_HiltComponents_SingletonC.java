package com.mpl.androidapp;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.HiltWrapper_WorkerFactoryModule;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import com.mpl.androidapp.MPLApplication_HiltComponents.ActivityC;
import com.mpl.androidapp.MPLApplication_HiltComponents.ActivityRetainedC;
import com.mpl.androidapp.MPLApplication_HiltComponents.FragmentC;
import com.mpl.androidapp.MPLApplication_HiltComponents.ServiceC;
import com.mpl.androidapp.MPLApplication_HiltComponents.SingletonC;
import com.mpl.androidapp.MPLApplication_HiltComponents.ViewC;
import com.mpl.androidapp.MPLApplication_HiltComponents.ViewModelC;
import com.mpl.androidapp.MPLApplication_HiltComponents.ViewWithFragmentC;
import com.mpl.androidapp.cleanarch.core.analytics.data.AnalyticsFeatureImpl;
import com.mpl.androidapp.cleanarch.core.analytics.domain.AnalyticsFeature;
import com.mpl.androidapp.cleanarch.core.config.data.ConfigManagerFeatureImpl;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetBooleanZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetJsonObjectZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetStringZkUseCase;
import com.mpl.androidapp.cleanarch.core.logger.data.LoggerFeatureImpl;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService_AssistedFactory;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules.UnityCrashDatabaseModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules.UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm;
import com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature;
import com.mpl.androidapp.filehandling.downloadservice.usecases.CheckConnectivityUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.InitDownloadManagerUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase;
import com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceCursorStatus;
import com.mpl.androidapp.miniprofile.base.BaseViewModel;
import com.mpl.androidapp.miniprofile.base.BaseViewModel_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.miniprofile.repository.SendHeartRepository;
import com.mpl.androidapp.miniprofile.service.FollowPlayerService;
import com.mpl.androidapp.miniprofile.service.GameStatsService;
import com.mpl.androidapp.miniprofile.service.ProfileDetailsService;
import com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment;
import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel;
import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel;
import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature;
import com.mpl.androidapp.notification.usecases.BuildLaunchIntentUseCase;
import com.mpl.androidapp.notification.usecases.BuildMplNotificationUseCase;
import com.mpl.androidapp.notification.usecases.IsAppIsInBackgroundUseCase;
import com.mpl.androidapp.notification.usecases.NotificationChannelUseCase;
import com.mpl.androidapp.notification.usecases.NotificationPriorityUseCase;
import com.mpl.androidapp.notification.usecases.NotificationSendEventUseCase;
import com.mpl.androidapp.notification.usecases.NotificationTimerUseCase;
import com.mpl.androidapp.notification.usecases.NotifyNotificationUseCase;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.share.MplShareFeature;
import com.mpl.androidapp.share.repositories.MplShareRepository;
import com.mpl.androidapp.share.services.GenerateDeepLinkService;
import com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent;
import com.mpl.androidapp.share.usecases.PrepareShareIntent;
import com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase;
import com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase;
import com.mpl.androidapp.unity.usecases.SendEventForGamesUseCase;
import com.mpl.androidapp.unity.usecases.UnityViewProfileUseCase;
import com.mpl.androidapp.unity.views.MiniProfileContainerFragment;
import com.mpl.androidapp.unity.views.UnityMiniProfileActivity;
import com.mpl.androidapp.unity.vm.MiniProfileContainerVm;
import com.mpl.androidapp.unity.vm.MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.CoroutinesModule;
import com.mpl.androidapp.updater.downloadmanager.di.modules.CoroutinesModule_ProvidesIoDispatcherFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.CoroutinesModule_ProvidesMainDispatcherFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DatabaseModule;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DatabaseModule_ProvideAppDatabaseFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DownloadManagerModule;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DownloadManagerModule_ProvideDownloadManagerFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DownloadManagerModule_ProvideGameAssetsRepoFactory;
import com.mpl.androidapp.updater.downloadmanager.di.modules.DownloadManagerModule_ProvideGsonFactory;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressAssets;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker_AssistedFactory;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload;
import com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.DeleteAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.DownloadAssetTaskUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.InsertAssetEntryUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadNotificationFlowCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitDeleteUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitInsertUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitUpdateUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PrepareGameAssetUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus;
import com.mpl.androidapp.webview.PokerWebViewActivity;
import com.mpl.androidapp.webview.PokerWebViewVm;
import com.mpl.androidapp.webview.PokerWebViewVm_HiltModules_KeyModule_ProvideFactory;
import com.mpl.androidapp.webview.repositories.WebFlowRepository;
import com.mpl.androidapp.webview.services.WebFlowGamesService;
import com.mpl.androidapp.webview.usecases.PrepHelpDeskDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepPaymentPageDeepLinkUseCase;
import com.mpl.androidapp.webview.usecases.PrepUrlForWebViewLoadingUseCase;
import com.mpl.androidapp.webview.view.activities.WebViewGameActivity;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.mpl.androidapp.webview.vm.WebViewGameVm_HiltModules_KeyModule_ProvideFactory;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$InternalFactoryFactory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.Lifecycle;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DaggerMPLApplication_HiltComponents_SingletonC extends SingletonC {
    public Provider<AnalyticsFeatureImpl> analyticsFeatureImplProvider;
    public final ApplicationContextModule applicationContextModule;
    public Provider<ConfigManagerFeature> bindConfigManagerFeatureProvider;
    public Provider<LoggerFeature> bindFeatureProvider;
    public Provider<AnalyticsFeature> bindFeatureProvider2;
    public Provider<SendUnityCrashFeature> bindRepositoryProvider;
    public Provider<ConfigManagerFeatureImpl> configManagerFeatureImplProvider;
    public final DatabaseModule databaseModule;
    public final DownloadManagerModule downloadManagerModule;
    public Provider<DownloadProgressWorker_AssistedFactory> downloadProgressWorker_AssistedFactoryProvider;
    public Provider<LoggerFeatureImpl> loggerFeatureImplProvider;
    public Provider<AssetsDatabase> provideAppDatabaseProvider;
    public Provider<DownloadManager> provideDownloadManagerProvider;
    public Provider<GameAssetResourceRepo> provideGameAssetsRepoProvider;
    public Provider<Gson> provideGsonProvider;
    public Provider<UnityCrashDatabase> provideUnityCrashDatabaseProvider;
    public Provider<SendUnityCrashFeatureImpl> sendUnityCrashFeatureImplProvider;
    public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
    public final UnityCrashDatabaseModule unityCrashDatabaseModule;
    public Provider<UnityCrashSyncService_AssistedFactory> unityCrashSyncService_AssistedFactoryProvider;

    public static final class ActivityCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ActivityC.Builder {
        public Activity activity;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public ActivityCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }

        public ActivityCBuilder activity(Activity activity2) {
            if (activity2 != null) {
                this.activity = activity2;
                return this;
            }
            throw null;
        }

        public ActivityC build() {
            TweetUtils.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.activityRetainedCImpl, this.activity);
        }
    }

    public static final class ActivityCImpl extends ActivityC {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.activityRetainedCImpl, this.activityCImpl);
        }

        public DefaultViewModelFactories$InternalFactoryFactory getHiltInternalFactoryFactory() {
            return new DefaultViewModelFactories$InternalFactoryFactory(TweetUtils.provideApplication(this.singletonC.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(this.activityRetainedCImpl));
        }

        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.activityRetainedCImpl);
        }

        public Set<String> getViewModelKeys() {
            ArrayList arrayList = new ArrayList(7);
            String provide = BaseViewModel_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide, "Set contributions cannot be null");
            arrayList.add(provide);
            String provide2 = MPLReactContainerVm_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide2, "Set contributions cannot be null");
            arrayList.add(provide2);
            String provide3 = MiniProfileContainerVm_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide3, "Set contributions cannot be null");
            arrayList.add(provide3);
            String provide4 = MiniProfileViewModel_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide4, "Set contributions cannot be null");
            arrayList.add(provide4);
            String provide5 = PokerWebViewVm_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide5, "Set contributions cannot be null");
            arrayList.add(provide5);
            String provide6 = SharedGameStreamViewModel_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide6, "Set contributions cannot be null");
            arrayList.add(provide6);
            String provide7 = WebViewGameVm_HiltModules_KeyModule_ProvideFactory.provide();
            TweetUtils.checkNotNull1(provide7, "Set contributions cannot be null");
            arrayList.add(provide7);
            if (arrayList.isEmpty()) {
                return Collections.emptySet();
            }
            if (arrayList.size() == 1) {
                return Collections.singleton(arrayList.get(0));
            }
            return Collections.unmodifiableSet(new HashSet(arrayList));
        }

        public void injectMPLReactContainerActivity(MPLReactContainerActivity mPLReactContainerActivity) {
        }

        public void injectPokerWebViewActivity(PokerWebViewActivity pokerWebViewActivity) {
        }

        public void injectUnityMiniProfileActivity(UnityMiniProfileActivity unityMiniProfileActivity) {
        }

        public void injectWebViewGameActivity(WebViewGameActivity webViewGameActivity) {
        }

        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.activityRetainedCImpl, this.activityCImpl);
        }

        public ActivityCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, Activity activity) {
            this.activityCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }
    }

    public static final class ActivityRetainedCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ActivityRetainedC.Builder {
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public ActivityRetainedCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
        }

        public ActivityRetainedC build() {
            return new ActivityRetainedCImpl();
        }
    }

    public static final class ActivityRetainedCImpl extends ActivityRetainedC {
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public Provider lifecycleProvider;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public static final class SwitchingProvider<T> implements Provider<T> {
            public final ActivityRetainedCImpl activityRetainedCImpl;
            public final int id;
            public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

            public SwitchingProvider(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, int i) {
                this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
                this.activityRetainedCImpl = activityRetainedCImpl2;
                this.id = i;
            }

            public T get() {
                if (this.id == 0) {
                    return new Lifecycle();
                }
                throw new AssertionError(this.id);
            }
        }

        private void initialize() {
            this.lifecycleProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, 0));
        }

        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.activityRetainedCImpl);
        }

        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return (ActivityRetainedLifecycle) this.lifecycleProvider.get();
        }

        public ActivityRetainedCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC) {
            this.activityRetainedCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            initialize();
        }
    }

    public static final class Builder {
        public ApplicationContextModule applicationContextModule;
        public DatabaseModule databaseModule;
        public DownloadManagerModule downloadManagerModule;
        public UnityCrashDatabaseModule unityCrashDatabaseModule;

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule2) {
            if (applicationContextModule2 != null) {
                this.applicationContextModule = applicationContextModule2;
                return this;
            }
            throw null;
        }

        public SingletonC build() {
            TweetUtils.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            if (this.databaseModule == null) {
                this.databaseModule = new DatabaseModule();
            }
            if (this.downloadManagerModule == null) {
                this.downloadManagerModule = new DownloadManagerModule();
            }
            if (this.unityCrashDatabaseModule == null) {
                this.unityCrashDatabaseModule = new UnityCrashDatabaseModule();
            }
            DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC = new DaggerMPLApplication_HiltComponents_SingletonC(this.applicationContextModule, this.databaseModule, this.downloadManagerModule, this.unityCrashDatabaseModule);
            return daggerMPLApplication_HiltComponents_SingletonC;
        }

        @Deprecated
        public Builder coroutinesModule(CoroutinesModule coroutinesModule) {
            if (coroutinesModule != null) {
                return this;
            }
            throw null;
        }

        public Builder databaseModule(DatabaseModule databaseModule2) {
            if (databaseModule2 != null) {
                this.databaseModule = databaseModule2;
                return this;
            }
            throw null;
        }

        public Builder downloadManagerModule(DownloadManagerModule downloadManagerModule2) {
            if (downloadManagerModule2 != null) {
                this.downloadManagerModule = downloadManagerModule2;
                return this;
            }
            throw null;
        }

        @Deprecated
        public Builder hiltWrapper_WorkerFactoryModule(HiltWrapper_WorkerFactoryModule hiltWrapper_WorkerFactoryModule) {
            if (hiltWrapper_WorkerFactoryModule != null) {
                return this;
            }
            throw null;
        }

        public Builder unityCrashDatabaseModule(UnityCrashDatabaseModule unityCrashDatabaseModule2) {
            if (unityCrashDatabaseModule2 != null) {
                this.unityCrashDatabaseModule = unityCrashDatabaseModule2;
                return this;
            }
            throw null;
        }

        public Builder() {
        }
    }

    public static final class FragmentCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.FragmentC.Builder {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public Fragment fragment;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public FragmentCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }

        public FragmentC build() {
            TweetUtils.checkBuilderRequirement(this.fragment, Fragment.class);
            FragmentCImpl fragmentCImpl = new FragmentCImpl(this.activityRetainedCImpl, this.activityCImpl, this.fragment);
            return fragmentCImpl;
        }

        public FragmentCBuilder fragment(Fragment fragment2) {
            if (fragment2 != null) {
                this.fragment = fragment2;
                return this;
            }
            throw null;
        }
    }

    public static final class FragmentCImpl extends FragmentC {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final FragmentCImpl fragmentCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public DefaultViewModelFactories$InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        public void injectMiniProfileContainerFragment(MiniProfileContainerFragment miniProfileContainerFragment) {
        }

        public void injectMiniProfileFragment(MiniProfileFragment miniProfileFragment) {
        }

        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            ViewWithFragmentCBuilder viewWithFragmentCBuilder = new ViewWithFragmentCBuilder(this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
            return viewWithFragmentCBuilder;
        }

        public FragmentCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, Fragment fragment) {
            this.fragmentCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }
    }

    public static final class ServiceCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ServiceC.Builder {
        public Service service;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public ServiceCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
        }

        public ServiceC build() {
            TweetUtils.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.service);
        }

        public ServiceCBuilder service(Service service2) {
            if (service2 != null) {
                this.service = service2;
                return this;
            }
            throw null;
        }
    }

    public static final class ServiceCImpl extends ServiceC {
        public final ServiceCImpl serviceCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public ServiceCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, Service service) {
            this.serviceCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
        }
    }

    public static final class SwitchingProvider<T> implements Provider<T> {
        public final int id;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public SwitchingProvider(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, int i) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.id = i;
        }

        public T get() {
            switch (this.id) {
                case 0:
                    return this.singletonC.downloadProgressWorker_AssistedFactory();
                case 1:
                    return DownloadManagerModule_ProvideGsonFactory.provideGson(this.singletonC.downloadManagerModule);
                case 2:
                    return this.singletonC.downloadManager();
                case 3:
                    return this.singletonC.gameAssetResourceRepo2();
                case 4:
                    return this.singletonC.assetsDatabase();
                case 5:
                    return this.singletonC.unityCrashSyncService_AssistedFactory();
                case 6:
                    return this.singletonC.sendUnityCrashFeatureImpl();
                case 7:
                    return new LoggerFeatureImpl();
                case 8:
                    return this.singletonC.analyticsFeatureImpl();
                case 9:
                    return this.singletonC.unityCrashDatabase();
                case 10:
                    return this.singletonC.configManagerFeatureImpl();
                default:
                    throw new AssertionError(this.id);
            }
        }
    }

    public static final class ViewCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ViewC.Builder {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
        public View view;

        public ViewCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }

        public ViewC build() {
            TweetUtils.checkBuilderRequirement(this.view, View.class);
            ViewCImpl viewCImpl = new ViewCImpl(this.activityRetainedCImpl, this.activityCImpl, this.view);
            return viewCImpl;
        }

        public ViewCBuilder view(View view2) {
            if (view2 != null) {
                this.view = view2;
                return this;
            }
            throw null;
        }
    }

    public static final class ViewCImpl extends ViewC {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
        public final ViewCImpl viewCImpl;

        public ViewCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, View view) {
            this.viewCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }
    }

    public static final class ViewModelCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ViewModelC.Builder {
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public SavedStateHandle savedStateHandle;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;

        public ViewModelCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }

        public ViewModelC build() {
            TweetUtils.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new ViewModelCImpl(this.activityRetainedCImpl, this.savedStateHandle);
        }

        public ViewModelCBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            if (savedStateHandle2 != null) {
                this.savedStateHandle = savedStateHandle2;
                return this;
            }
            throw null;
        }
    }

    public static final class ViewModelCImpl extends ViewModelC {
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public Provider<BaseViewModel> baseViewModelProvider;
        public Provider<MPLReactContainerVm> mPLReactContainerVmProvider;
        public Provider<MiniProfileContainerVm> miniProfileContainerVmProvider;
        public Provider<MiniProfileViewModel> miniProfileViewModelProvider;
        public Provider<PokerWebViewVm> pokerWebViewVmProvider;
        public Provider<SharedGameStreamViewModel> sharedGameStreamViewModelProvider;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
        public final ViewModelCImpl viewModelCImpl;
        public Provider<WebViewGameVm> webViewGameVmProvider;

        public static final class SwitchingProvider<T> implements Provider<T> {
            public final ActivityRetainedCImpl activityRetainedCImpl;
            public final int id;
            public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
            public final ViewModelCImpl viewModelCImpl;

            public SwitchingProvider(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ViewModelCImpl viewModelCImpl2, int i) {
                this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
                this.activityRetainedCImpl = activityRetainedCImpl2;
                this.viewModelCImpl = viewModelCImpl2;
                this.id = i;
            }

            public T get() {
                switch (this.id) {
                    case 0:
                        return this.viewModelCImpl.baseViewModel();
                    case 1:
                        return this.viewModelCImpl.mPLReactContainerVm();
                    case 2:
                        return this.viewModelCImpl.miniProfileContainerVm();
                    case 3:
                        return this.viewModelCImpl.miniProfileViewModel();
                    case 4:
                        return this.viewModelCImpl.pokerWebViewVm();
                    case 5:
                        return this.viewModelCImpl.sharedGameStreamViewModel();
                    case 6:
                        return this.viewModelCImpl.webViewGameVm();
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }

        /* access modifiers changed from: private */
        public BaseViewModel baseViewModel() {
            return new BaseViewModel(TweetUtils.provideApplication(this.singletonC.applicationContextModule));
        }

        private void initialize(SavedStateHandle savedStateHandle) {
            this.baseViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.mPLReactContainerVmProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.miniProfileContainerVmProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.miniProfileViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.pokerWebViewVmProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.sharedGameStreamViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.webViewGameVmProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 6);
        }

        /* access modifiers changed from: private */
        public MPLReactContainerVm mPLReactContainerVm() {
            return new MPLReactContainerVm(TweetUtils.provideContext(this.singletonC.applicationContextModule), (SendUnityCrashFeature) this.singletonC.bindRepositoryProvider.get(), this.singletonC.unityCrashModule(), this.singletonC.configService());
        }

        /* access modifiers changed from: private */
        public MiniProfileContainerVm miniProfileContainerVm() {
            return new MiniProfileContainerVm(TweetUtils.provideApplication(this.singletonC.applicationContextModule), unityViewProfileUseCase());
        }

        /* access modifiers changed from: private */
        public MiniProfileViewModel miniProfileViewModel() {
            return new MiniProfileViewModel(sendHeartRepository(), (Gson) this.singletonC.provideGsonProvider.get());
        }

        private MplShareFeature mplShareFeature() {
            MplShareFeature mplShareFeature = new MplShareFeature(TweetUtils.provideContext(this.singletonC.applicationContextModule), this.singletonC.MplShareRepository(), this.singletonC.CheckSharePlatformIsPresent(), this.singletonC.PrepareShareIntent(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
            return mplShareFeature;
        }

        /* access modifiers changed from: private */
        public PokerWebViewVm pokerWebViewVm() {
            return new PokerWebViewVm(TweetUtils.provideApplication(this.singletonC.applicationContextModule), new PrepareGameAssetUseCase(), new DownloadAssetTaskUseCase());
        }

        private PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase() {
            return new PrepHelpDeskDeepLinkUseCase(TweetUtils.provideContext(this.singletonC.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        private PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase() {
            return new PrepPaymentPageDeepLinkUseCase(TweetUtils.provideContext(this.singletonC.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        private PrepUrlForWebViewLoadingUseCase prepUrlForWebViewLoadingUseCase() {
            return new PrepUrlForWebViewLoadingUseCase(TweetUtils.provideContext(this.singletonC.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        private SendHeartRepository sendHeartRepository() {
            return new SendHeartRepository(new ProfileDetailsService(), new FollowPlayerService(), new GameStatsService());
        }

        /* access modifiers changed from: private */
        public SharedGameStreamViewModel sharedGameStreamViewModel() {
            return new SharedGameStreamViewModel(TweetUtils.provideContext(this.singletonC.applicationContextModule));
        }

        private UnityViewProfileUseCase unityViewProfileUseCase() {
            return new UnityViewProfileUseCase((Gson) this.singletonC.provideGsonProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        private WebFlowGamesService webFlowGamesService() {
            return new WebFlowGamesService((Gson) this.singletonC.provideGsonProvider.get());
        }

        private WebFlowRepository webFlowRepository() {
            return new WebFlowRepository(webFlowGamesService());
        }

        /* access modifiers changed from: private */
        public WebViewGameVm webViewGameVm() {
            WebViewGameVm webViewGameVm = new WebViewGameVm(TweetUtils.provideApplication(this.singletonC.applicationContextModule), (Gson) this.singletonC.provideGsonProvider.get(), webFlowRepository(), prepHelpDeskDeepLinkUseCase(), prepPaymentPageDeepLinkUseCase(), prepUrlForWebViewLoadingUseCase(), mplShareFeature());
            return webViewGameVm;
        }

        public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
            MapBuilder mapBuilder = new MapBuilder(7);
            mapBuilder.contributions.put("com.mpl.androidapp.miniprofile.base.BaseViewModel", this.baseViewModelProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm", this.mPLReactContainerVmProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.unity.vm.MiniProfileContainerVm", this.miniProfileContainerVmProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel", this.miniProfileViewModelProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.webview.PokerWebViewVm", this.pokerWebViewVmProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel", this.sharedGameStreamViewModelProvider);
            mapBuilder.contributions.put("com.mpl.androidapp.webview.vm.WebViewGameVm", this.webViewGameVmProvider);
            return mapBuilder.build();
        }

        public ViewModelCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, SavedStateHandle savedStateHandle) {
            this.viewModelCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            initialize(savedStateHandle);
        }
    }

    public static final class ViewWithFragmentCBuilder implements com.mpl.androidapp.MPLApplication_HiltComponents.ViewWithFragmentC.Builder {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final FragmentCImpl fragmentCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
        public View view;

        public ViewWithFragmentCBuilder(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, FragmentCImpl fragmentCImpl2) {
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
            this.fragmentCImpl = fragmentCImpl2;
        }

        public ViewWithFragmentC build() {
            TweetUtils.checkBuilderRequirement(this.view, View.class);
            ViewWithFragmentCImpl viewWithFragmentCImpl = new ViewWithFragmentCImpl(this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
            return viewWithFragmentCImpl;
        }

        public ViewWithFragmentCBuilder view(View view2) {
            if (view2 != null) {
                this.view = view2;
                return this;
            }
            throw null;
        }
    }

    public static final class ViewWithFragmentCImpl extends ViewWithFragmentC {
        public final ActivityCImpl activityCImpl;
        public final ActivityRetainedCImpl activityRetainedCImpl;
        public final FragmentCImpl fragmentCImpl;
        public final DaggerMPLApplication_HiltComponents_SingletonC singletonC;
        public final ViewWithFragmentCImpl viewWithFragmentCImpl;

        public ViewWithFragmentCImpl(DaggerMPLApplication_HiltComponents_SingletonC daggerMPLApplication_HiltComponents_SingletonC, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, FragmentCImpl fragmentCImpl2, View view) {
            this.viewWithFragmentCImpl = this;
            this.singletonC = daggerMPLApplication_HiltComponents_SingletonC;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
            this.fragmentCImpl = fragmentCImpl2;
        }
    }

    /* access modifiers changed from: private */
    public AnalyticsFeatureImpl analyticsFeatureImpl() {
        return new AnalyticsFeatureImpl((LoggerFeature) this.bindFeatureProvider.get());
    }

    /* access modifiers changed from: private */
    public AssetsDatabase assetsDatabase() {
        return DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase(this.databaseModule, TweetUtils.provideContext(this.applicationContextModule));
    }

    private BuildLaunchIntentUseCase buildLaunchIntentUseCase() {
        return new BuildLaunchIntentUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private BuildMplNotificationUseCase buildMplNotificationUseCase() {
        return new BuildMplNotificationUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public static Builder builder() {
        return new Builder();
    }

    private CheckConnectivityUseCase checkConnectivityUseCase() {
        return new CheckConnectivityUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    /* access modifiers changed from: private */
    public ConfigManagerFeatureImpl configManagerFeatureImpl() {
        return new ConfigManagerFeatureImpl((LoggerFeature) this.bindFeatureProvider.get());
    }

    private CopyPokerAssetFileUseCase copyPokerAssetFileUseCase() {
        return new CopyPokerAssetFileUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private DeleteAssetFileUseCase deleteAssetFileUseCase() {
        return new DeleteAssetFileUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private DeleteExistingFileUseCase deleteExistingFileUseCase() {
        return new DeleteExistingFileUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    /* access modifiers changed from: private */
    public DownloadManager downloadManager() {
        return DownloadManagerModule_ProvideDownloadManagerFactory.provideDownloadManager(this.downloadManagerModule, TweetUtils.provideContext(this.applicationContextModule));
    }

    private DownloadManagerCursorStatus downloadManagerCursorStatus() {
        return new DownloadManagerCursorStatus((Gson) this.provideGsonProvider.get());
    }

    /* access modifiers changed from: private */
    public DownloadProgressWorker downloadProgressWorker(Context context, WorkerParameters workerParameters) {
        DownloadProgressWorker downloadProgressWorker = new DownloadProgressWorker(context, workerParameters, (Gson) this.provideGsonProvider.get(), queryDownload(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), CoroutinesModule_ProvidesMainDispatcherFactory.providesMainDispatcher());
        return downloadProgressWorker;
    }

    /* access modifiers changed from: private */
    public DownloadProgressWorker_AssistedFactory downloadProgressWorker_AssistedFactory() {
        return new DownloadProgressWorker_AssistedFactory() {
            public DownloadProgressWorker create(Context context, WorkerParameters workerParameters) {
                return DaggerMPLApplication_HiltComponents_SingletonC.this.singletonC.downloadProgressWorker(context, workerParameters);
            }
        };
    }

    private DownloadServiceCursorStatus downloadServiceCursorStatus() {
        return new DownloadServiceCursorStatus((Gson) this.provideGsonProvider.get());
    }

    private ExtractAssetsUseCase extractAssetsUseCase() {
        return new ExtractAssetsUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    /* access modifiers changed from: private */
    public GameAssetResourceRepo gameAssetResourceRepo2() {
        return DownloadManagerModule_ProvideGameAssetsRepoFactory.provideGameAssetsRepo(this.downloadManagerModule, (AssetsDatabase) this.provideAppDatabaseProvider.get());
    }

    private GenerateDeepLinkService generateDeepLinkService() {
        return new GenerateDeepLinkService(TweetUtils.provideContext(this.applicationContextModule));
    }

    private GetBooleanZkUseCase getBooleanZkUseCase() {
        return new GetBooleanZkUseCase((ConfigManagerFeature) this.bindConfigManagerFeatureProvider.get(), (LoggerFeature) this.bindFeatureProvider.get());
    }

    private GetJsonObjectZkUseCase getJsonObjectZkUseCase() {
        return new GetJsonObjectZkUseCase((ConfigManagerFeature) this.bindConfigManagerFeatureProvider.get(), (LoggerFeature) this.bindFeatureProvider.get());
    }

    private GetStringZkUseCase getStringZkUseCase() {
        return new GetStringZkUseCase((ConfigManagerFeature) this.bindConfigManagerFeatureProvider.get(), (LoggerFeature) this.bindFeatureProvider.get());
    }

    private HiltWorkerFactory hiltWorkerFactory() {
        HiltWorkerFactory hiltWorkerFactory = new HiltWorkerFactory(mapOfStringAndProviderOfWorkerAssistedFactoryOf());
        TweetUtils.checkNotNullFromProvides(hiltWorkerFactory);
        return hiltWorkerFactory;
    }

    private InitDownloadManagerUseCase initDownloadManagerUseCase() {
        return new InitDownloadManagerUseCase(TweetUtils.provideContext(this.applicationContextModule), (DownloadManager) this.provideDownloadManagerProvider.get(), downloadServiceCursorStatus(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private void initialize(ApplicationContextModule applicationContextModule2, DatabaseModule databaseModule2, DownloadManagerModule downloadManagerModule2, UnityCrashDatabaseModule unityCrashDatabaseModule2) {
        this.provideGsonProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 1));
        this.provideDownloadManagerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 2));
        this.provideAppDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 4));
        this.provideGameAssetsRepoProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 3));
        this.downloadProgressWorker_AssistedFactoryProvider = new SwitchingProvider(this.singletonC, 0);
        SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonC, 7);
        this.loggerFeatureImplProvider = switchingProvider;
        this.bindFeatureProvider = DoubleCheck.provider(switchingProvider);
        SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonC, 8);
        this.analyticsFeatureImplProvider = switchingProvider2;
        this.bindFeatureProvider2 = DoubleCheck.provider(switchingProvider2);
        SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonC, 6);
        this.sendUnityCrashFeatureImplProvider = switchingProvider3;
        this.bindRepositoryProvider = DoubleCheck.provider(switchingProvider3);
        this.unityCrashSyncService_AssistedFactoryProvider = new SwitchingProvider(this.singletonC, 5);
        this.provideUnityCrashDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 9));
        SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonC, 10);
        this.configManagerFeatureImplProvider = switchingProvider4;
        this.bindConfigManagerFeatureProvider = DoubleCheck.provider(switchingProvider4);
    }

    private MPLApplication injectMPLApplication2(MPLApplication mPLApplication) {
        MPLApplication_MembersInjector.injectWorkerFactory(mPLApplication, hiltWorkerFactory());
        return mPLApplication;
    }

    private IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase() {
        return new IsAppIsInBackgroundUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private Map<String, Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mapOfStringAndProviderOfWorkerAssistedFactoryOf() {
        MapBuilder mapBuilder = new MapBuilder(2);
        mapBuilder.contributions.put("com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker", this.downloadProgressWorker_AssistedFactoryProvider);
        mapBuilder.contributions.put("com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService", this.unityCrashSyncService_AssistedFactoryProvider);
        return mapBuilder.build();
    }

    private MplFileCreationUseCase mplFileCreationUseCase() {
        return new MplFileCreationUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private NotificationChannelUseCase notificationChannelUseCase() {
        return new NotificationChannelUseCase(CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private NotificationPriorityUseCase notificationPriorityUseCase() {
        return new NotificationPriorityUseCase(CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private NotificationSendEventUseCase notificationSendEventUseCase() {
        return new NotificationSendEventUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private NotificationTimerUseCase notificationTimerUseCase() {
        return new NotificationTimerUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private NotifyNotificationUseCase notifyNotificationUseCase() {
        return new NotifyNotificationUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private OptionalDownloadNotificationFlowCheckUseCase optionalDownloadNotificationFlowCheckUseCase() {
        return new OptionalDownloadNotificationFlowCheckUseCase(CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private PublishProgressUseCase publishProgressUseCase() {
        return new PublishProgressUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    private QueryDownload queryDownload() {
        QueryDownload queryDownload = new QueryDownload(TweetUtils.provideContext(this.applicationContextModule), (DownloadManager) this.provideDownloadManagerProvider.get(), downloadManagerCursorStatus(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), getGameResourceUseCase(), removeGameResourceUseCase(), deleteAssetFileUseCase(), updateAssetsAnalyticsUseCase(), publishProgressUseCase(), copyPokerAssetFileUseCase(), extractAssetsUseCase(), optionalDownloadVisitCheckUseCase(), optionalDownloadNotificationFlowCheckUseCase());
        return queryDownload;
    }

    private RemoveGameResourceUseCase removeGameResourceUseCase() {
        return new RemoveGameResourceUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    /* access modifiers changed from: private */
    public SendUnityCrashFeatureImpl sendUnityCrashFeatureImpl() {
        return new SendUnityCrashFeatureImpl(unityCrashImplService(), unityCrashModule(), (LoggerFeature) this.bindFeatureProvider.get(), (AnalyticsFeature) this.bindFeatureProvider2.get());
    }

    /* access modifiers changed from: private */
    public UnityCrashDatabase unityCrashDatabase() {
        return UnityCrashDatabaseModule_ProvideUnityCrashDatabaseFactory.provideUnityCrashDatabase(this.unityCrashDatabaseModule, TweetUtils.provideContext(this.applicationContextModule));
    }

    /* access modifiers changed from: private */
    public UnityCrashModule unityCrashModule() {
        return new UnityCrashModule(unityCrashImplService(), (LoggerFeature) this.bindFeatureProvider.get(), configService(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    /* access modifiers changed from: private */
    public UnityCrashSyncService unityCrashSyncService(Context context, WorkerParameters workerParameters) {
        return new UnityCrashSyncService(context, workerParameters, CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), (SendUnityCrashFeature) this.bindRepositoryProvider.get());
    }

    /* access modifiers changed from: private */
    public UnityCrashSyncService_AssistedFactory unityCrashSyncService_AssistedFactory() {
        return new UnityCrashSyncService_AssistedFactory() {
            public UnityCrashSyncService create(Context context, WorkerParameters workerParameters) {
                return DaggerMPLApplication_HiltComponents_SingletonC.this.singletonC.unityCrashSyncService(context, workerParameters);
            }
        };
    }

    private ValidateInputParamsUseCase validateInputParamsUseCase() {
        return new ValidateInputParamsUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public CheckSharePlatformIsPresent CheckSharePlatformIsPresent() {
        return new CheckSharePlatformIsPresent(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public CreateUnityScreenShotUseCase CreateUnityScreenShotUseCase() {
        return new CreateUnityScreenShotUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public GenericFileDownloadFeature GenericFileDownloadFeature() {
        GenericFileDownloadFeature genericFileDownloadFeature = new GenericFileDownloadFeature(checkConnectivityUseCase(), validateInputParamsUseCase(), deleteExistingFileUseCase(), mplFileCreationUseCase(), initDownloadManagerUseCase(), (Gson) this.provideGsonProvider.get(), TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        return genericFileDownloadFeature;
    }

    public InsertAssetEntryUseCase InsertAssetEntryUseCase() {
        return new InsertAssetEntryUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public LogCrashAnalyticsUseCase LogCrashAnalyticsUseCase() {
        return new LogCrashAnalyticsUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public MplShareRepository MplShareRepository() {
        return new MplShareRepository(generateDeepLinkService());
    }

    public NotificationUgcFeature NotificationUgcFeature() {
        NotificationUgcFeature notificationUgcFeature = new NotificationUgcFeature(notificationChannelUseCase(), notificationPriorityUseCase(), buildLaunchIntentUseCase(), buildMplNotificationUseCase(), notificationTimerUseCase(), isAppIsInBackgroundUseCase(), notifyNotificationUseCase(), notificationSendEventUseCase(), TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        return notificationUgcFeature;
    }

    public OptionalDownloadVisitUpdateUseCase OptionalDownloadVisitUpdateUseCase() {
        return new OptionalDownloadVisitUpdateUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public PrepareShareIntent PrepareShareIntent() {
        return new PrepareShareIntent(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public SendEventForGamesUseCase SendEventForGamesUseCase() {
        return new SendEventForGamesUseCase(TweetUtils.provideContext(this.applicationContextModule), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public ConfigZkFeatures configService() {
        return new ConfigZkFeatures(getBooleanZkUseCase(), getStringZkUseCase(), getJsonObjectZkUseCase());
    }

    public DownloadAssets downloadAssetsService() {
        DownloadAssets downloadAssets = new DownloadAssets(TweetUtils.provideContext(this.applicationContextModule), (DownloadManager) this.provideDownloadManagerProvider.get(), (GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), updateAssetsAnalyticsUseCase(), publishProgressUseCase(), getGameResourceUseCase(), removeGameResourceUseCase());
        return downloadAssets;
    }

    public DownloadProgressAssets downloadProgressAssetsService() {
        return new DownloadProgressAssets(TweetUtils.provideContext(this.applicationContextModule), (Gson) this.provideGsonProvider.get());
    }

    public GameAssetResourceRepo gameAssetResourceRepo() {
        return (GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get();
    }

    public GetGameResourceUseCase getGameResourceUseCase() {
        return new GetGameResourceUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public void injectMPLApplication(MPLApplication mPLApplication) {
        injectMPLApplication2(mPLApplication);
    }

    public CoroutineDispatcher ioDispatcher() {
        return CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher();
    }

    public LoggerFeatureImpl loggerFeatureService() {
        return new LoggerFeatureImpl();
    }

    public OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase() {
        return new OptionalDownloadVisitCheckUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public OptionalDownloadVisitDeleteUseCase optionalDownloadVisitDeleteUseCase() {
        return new OptionalDownloadVisitDeleteUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public OptionalDownloadVisitInsertUseCase optionalDownloadVisitInsertUseCase() {
        return new OptionalDownloadVisitInsertUseCase((GameAssetResourceRepo) this.provideGameAssetsRepoProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
        return new ActivityRetainedCBuilder();
    }

    public ServiceComponentBuilder serviceComponentBuilder() {
        return new ServiceCBuilder();
    }

    public UnityCrashDbServiceImpl unityCrashImplService() {
        return new UnityCrashDbServiceImpl((UnityCrashDatabase) this.provideUnityCrashDatabaseProvider.get());
    }

    public UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase() {
        return new UpdateAssetsAnalyticsUseCase(CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
    }

    public DaggerMPLApplication_HiltComponents_SingletonC(ApplicationContextModule applicationContextModule2, DatabaseModule databaseModule2, DownloadManagerModule downloadManagerModule2, UnityCrashDatabaseModule unityCrashDatabaseModule2) {
        this.singletonC = this;
        this.downloadManagerModule = downloadManagerModule2;
        this.applicationContextModule = applicationContextModule2;
        this.databaseModule = databaseModule2;
        this.unityCrashDatabaseModule = unityCrashDatabaseModule2;
        initialize(applicationContextModule2, databaseModule2, downloadManagerModule2, unityCrashDatabaseModule2);
    }
}
