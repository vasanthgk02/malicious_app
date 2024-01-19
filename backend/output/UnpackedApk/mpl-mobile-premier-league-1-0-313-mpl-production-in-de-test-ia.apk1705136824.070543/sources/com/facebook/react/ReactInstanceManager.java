package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.Trace;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.CatalystInstanceImpl.Builder;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DisabledDevSupportManager;
import com.facebook.react.devsupport.ReactInstanceManagerDevHelper;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.pdfbox.pdfparser.BaseParser;

public class ReactInstanceManager {
    public final Context mApplicationContext;
    public final Set<ReactRoot> mAttachedReactRoots = Collections.synchronizedSet(new HashSet());
    public final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    public final JSBundleLoader mBundleLoader;
    public volatile Thread mCreateReactContextThread;
    public Activity mCurrentActivity;
    public volatile ReactContext mCurrentReactContext;
    public DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    public final DevSupportManager mDevSupportManager;
    public volatile boolean mHasStartedCreatingInitialContext = false;
    public volatile Boolean mHasStartedDestroying = Boolean.FALSE;
    public final JSIModulePackage mJSIModulePackage;
    public final String mJSMainModulePath;
    public final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    public volatile LifecycleState mLifecycleState;
    public final MemoryPressureRouter mMemoryPressureRouter;
    public final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    public final List<ReactPackage> mPackages;
    public ReactContextInitParams mPendingReactContextInitParams;
    public final Object mReactContextLock = new Object();
    public final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
    public final boolean mUseDeveloperSupport;
    public List<ViewManager> mViewManagers;

    public class ReactContextInitParams {
        public final JSBundleLoader mJsBundleLoader;
        public final JavaScriptExecutorFactory mJsExecutorFactory;

        public ReactContextInitParams(ReactInstanceManager reactInstanceManager, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            ImageOriginUtils.assertNotNull(javaScriptExecutorFactory);
            this.mJsExecutorFactory = javaScriptExecutorFactory;
            ImageOriginUtils.assertNotNull(jSBundleLoader);
            this.mJsBundleLoader = jSBundleLoader;
        }
    }

    public interface ReactInstanceEventListener {
        void onReactContextInitialized(ReactContext reactContext);
    }

    public ReactInstanceManager(Context context, Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<ReactPackage> list, boolean z, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, UIImplementationProvider uIImplementationProvider, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, RedBoxHandler redBoxHandler, boolean z2, DevBundleDownloadListener devBundleDownloadListener, int i, int i2, JSIModulePackage jSIModulePackage, Map<String, Object> map) {
        DevSupportManager devSupportManager;
        Context context2 = context;
        boolean z3 = z;
        FLog.d("ReactInstanceManager", "ReactInstanceManager.ctor()");
        SoLoader.init(context2, false);
        ImageOriginUtils.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context2;
        this.mCurrentActivity = null;
        this.mDefaultBackButtonImpl = null;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        this.mJSMainModulePath = str;
        this.mPackages = new ArrayList();
        this.mUseDeveloperSupport = z3;
        Trace.beginSection("ReactInstanceManager.initDevSupportManager");
        AnonymousClass2 r5 = new ReactInstanceManagerDevHelper(this) {
        };
        String str2 = this.mJSMainModulePath;
        if (!z3) {
            devSupportManager = new DisabledDevSupportManager();
        } else {
            try {
                devSupportManager = (DevSupportManager) Class.forName("com.facebook.react.devsupport.DevSupportManagerImpl").getConstructor(new Class[]{Context.class, ReactInstanceManagerDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class}).newInstance(new Object[]{context2, r5, str2, Boolean.TRUE, null, null, Integer.valueOf(i), null});
            } catch (Exception e2) {
                throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", e2);
            }
        }
        this.mDevSupportManager = devSupportManager;
        Trace.endSection();
        this.mBridgeIdleDebugListener = null;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context2);
        this.mNativeModuleCallExceptionHandler = null;
        synchronized (this.mPackages) {
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
            this.mPackages.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() {
                public void invokeDefaultOnBackPressed() {
                    ReactInstanceManager.this.invokeDefaultOnBackPressed();
                }
            }, z2, i2));
            if (this.mUseDeveloperSupport) {
                this.mPackages.add(new DebugCorePackage());
            }
            this.mPackages.addAll(list);
        }
        this.mJSIModulePackage = null;
        if (ReactChoreographer.sInstance == null) {
            ReactChoreographer.sInstance = new ReactChoreographer();
        }
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.startInspector();
        }
    }

    /* JADX INFO: finally extract failed */
    public static ReactApplicationContext access$1100(ReactInstanceManager reactInstanceManager, JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        if (reactInstanceManager != null) {
            FLog.d("ReactNative", "ReactInstanceManager.createReactContext()");
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
            ReactApplicationContext reactApplicationContext = new ReactApplicationContext(reactInstanceManager.mApplicationContext);
            NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = reactInstanceManager.mNativeModuleCallExceptionHandler;
            if (nativeModuleCallExceptionHandler == null) {
                nativeModuleCallExceptionHandler = reactInstanceManager.mDevSupportManager;
            }
            reactApplicationContext.setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
            List<ReactPackage> list = reactInstanceManager.mPackages;
            NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext, reactInstanceManager);
            ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
            synchronized (reactInstanceManager.mPackages) {
                for (ReactPackage next : list) {
                    Trace.beginSection("createAndProcessCustomReactPackage");
                    try {
                        reactInstanceManager.processPackage(next, nativeModuleRegistryBuilder);
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
            Trace.beginSection("buildNativeModuleRegistry");
            try {
                NativeModuleRegistry nativeModuleRegistry = new NativeModuleRegistry(nativeModuleRegistryBuilder.mReactApplicationContext, nativeModuleRegistryBuilder.mModules);
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
                Builder nativeModuleCallExceptionHandler2 = new Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(nativeModuleRegistry).setJSBundleLoader(jSBundleLoader).setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
                Trace.beginSection("createCatalystInstance");
                try {
                    CatalystInstanceImpl build = nativeModuleCallExceptionHandler2.build();
                    Trace.endSection();
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                    reactApplicationContext.initializeWithInstance(build);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ReactInstanceManager.createReactContext: mJSIModulePackage ");
                    sb.append(reactInstanceManager.mJSIModulePackage != null ? "not null" : "null");
                    FLog.e((String) "ReactNative", sb.toString());
                    JSIModulePackage jSIModulePackage = reactInstanceManager.mJSIModulePackage;
                    if (jSIModulePackage != null) {
                        build.addJSIModules(jSIModulePackage.getJSIModules(reactApplicationContext, build.getJavaScriptContextHolder()));
                        FLog.e((String) "ReactNative", "ReactInstanceManager.createReactContext: ReactFeatureFlags.useTurboModules == " + BaseParser.FALSE);
                    }
                    NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = reactInstanceManager.mBridgeIdleDebugListener;
                    if (notThreadSafeBridgeIdleDebugListener != null) {
                        build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
                    }
                    ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
                    Trace.beginSection("runJSBundle");
                    build.runJSBundle();
                    Trace.endSection();
                    return reactApplicationContext;
                } catch (Throwable th2) {
                    Trace.endSection();
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                    throw th2;
                }
            } catch (Throwable th3) {
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
                throw th3;
            }
        } else {
            throw null;
        }
    }

    public static void access$1500(ReactInstanceManager reactInstanceManager, final ReactApplicationContext reactApplicationContext) {
        if (reactInstanceManager != null) {
            FLog.d("ReactNative", "ReactInstanceManager.setupReactContext()");
            ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
            ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
            Trace.beginSection("setupReactContext");
            synchronized (reactInstanceManager.mAttachedReactRoots) {
                synchronized (reactInstanceManager.mReactContextLock) {
                    ImageOriginUtils.assertNotNull(reactApplicationContext);
                    reactInstanceManager.mCurrentReactContext = reactApplicationContext;
                }
                CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
                ImageOriginUtils.assertNotNull(catalystInstance);
                catalystInstance.initialize();
                reactInstanceManager.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
                reactInstanceManager.mMemoryPressureRouter.mListeners.add(catalystInstance);
                synchronized (reactInstanceManager) {
                    if (reactInstanceManager.mLifecycleState == LifecycleState.RESUMED) {
                        reactInstanceManager.moveToResumedLifecycleState(true);
                    }
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
                for (ReactRoot attachRootViewToInstance : reactInstanceManager.mAttachedReactRoots) {
                    reactInstanceManager.attachRootViewToInstance(attachRootViewToInstance);
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
            }
            final ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) reactInstanceManager.mReactInstanceEventListeners.toArray(new ReactInstanceEventListener[reactInstanceManager.mReactInstanceEventListeners.size()]);
            UiThreadUtil.runOnUiThread(new Runnable(reactInstanceManager) {
                public void run() {
                    for (ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
                        if (reactInstanceEventListener != null) {
                            reactInstanceEventListener.onReactContextInitialized(reactApplicationContext);
                        }
                    }
                }
            });
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
            reactApplicationContext.runOnJSQueueThread(new Runnable(reactInstanceManager) {
                public void run() {
                    Process.setThreadPriority(0);
                    ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, (String) "js_default");
                }
            });
            reactApplicationContext.runOnNativeModulesQueueThread(new Runnable(reactInstanceManager) {
                public void run() {
                    Process.setThreadPriority(0);
                }
            });
            return;
        }
        throw null;
    }

    public final void attachRootViewToInstance(final ReactRoot reactRoot) {
        WritableMap writableMap;
        FLog.e((String) "ReactNative", (String) "ReactInstanceManager.attachRootViewToInstance()");
        Trace.beginSection("attachRootViewToInstance");
        UIManager uIManager = ImageOriginUtils.getUIManager(this.mCurrentReactContext, reactRoot.getUIManagerType());
        if (uIManager != null) {
            Bundle appProperties = reactRoot.getAppProperties();
            ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
            if (appProperties == null) {
                writableMap = new WritableNativeMap();
            } else {
                writableMap = Arguments.fromBundle(appProperties);
            }
            final int addRootView = uIManager.addRootView(rootViewGroup, writableMap, reactRoot.getInitialUITemplate());
            reactRoot.setRootViewTag(addRootView);
            if (reactRoot.getUIManagerType() == 2) {
                uIManager.updateRootLayoutSpecs(addRootView, reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                reactRoot.runApplication();
            }
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                public void run() {
                    reactRoot.onStage(101);
                }
            });
            Trace.endSection();
            return;
        }
        throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
    }

    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        Printer printer = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
        FLog.e((String) "ReactInstanceManager", (String) "ReactInstanceManager.destroy called", (Throwable) new RuntimeException("ReactInstanceManager.destroy called"));
        if (this.mHasStartedDestroying.booleanValue()) {
            FLog.e((String) "ReactNative", (String) "ReactInstanceManager.destroy called: bail out, already destroying");
            return;
        }
        this.mHasStartedDestroying = Boolean.TRUE;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
            this.mDevSupportManager.stopInspector();
        }
        moveToBeforeCreateLifecycleState();
        if (this.mCreateReactContextThread != null) {
            this.mCreateReactContextThread = null;
        }
        MemoryPressureRouter memoryPressureRouter = this.mMemoryPressureRouter;
        Context context = this.mApplicationContext;
        if (memoryPressureRouter != null) {
            context.getApplicationContext().unregisterComponentCallbacks(memoryPressureRouter);
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    this.mCurrentReactContext.destroy();
                    this.mCurrentReactContext = null;
                }
            }
            this.mHasStartedCreatingInitialContext = false;
            this.mCurrentActivity = null;
            ResourceDrawableIdHelper instance = ResourceDrawableIdHelper.getInstance();
            synchronized (instance) {
                instance.mResourceDrawableIdMap.clear();
            }
            this.mHasStartedDestroying = Boolean.FALSE;
            synchronized (this.mHasStartedDestroying) {
                this.mHasStartedDestroying.notifyAll();
            }
            return;
        }
        throw null;
    }

    public final void detachViewFromInstance(ReactRoot reactRoot, CatalystInstance catalystInstance) {
        FLog.d("ReactNative", "ReactInstanceManager.detachViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getUIManagerType() == 2) {
            ((ReactFabric) catalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(reactRoot.getRootViewTag());
        } else {
            ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
        }
    }

    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            try {
                reactContext = this.mCurrentReactContext;
            }
        }
        return reactContext;
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> list;
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Trace.beginSection("createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        this.mViewManagers = new ArrayList();
                        for (ReactPackage createViewManagers : this.mPackages) {
                            this.mViewManagers.addAll(createViewManagers.createViewManagers(reactApplicationContext));
                        }
                        list = this.mViewManagers;
                    }
                }
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                return list;
            }
            list = this.mViewManagers;
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return list;
        } catch (Throwable th) {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            throw th;
        }
    }

    public final void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    public final synchronized void moveToBeforeCreateLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
                this.mLifecycleState = LifecycleState.BEFORE_RESUME;
            }
            if (this.mLifecycleState == LifecycleState.BEFORE_RESUME) {
                currentReactContext.onHostDestroy();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
    }

    public final synchronized void moveToResumedLifecycleState(boolean z) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (z || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
            currentReactContext.onHostResume(this.mCurrentActivity);
        }
        this.mLifecycleState = LifecycleState.RESUMED;
    }

    public void onBackPressed() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.mCurrentReactContext;
        if (reactContext == null) {
            FLog.w((String) "ReactInstanceManager", (String) "Instance detached from instance manager");
            UiThreadUtil.assertOnUiThread();
            DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
            if (defaultHardwareBackBtnHandler != null) {
                defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
                return;
            }
            return;
        }
        ((DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
    }

    public void onHostDestroy(Activity activity) {
        if (activity == this.mCurrentActivity) {
            UiThreadUtil.assertOnUiThread();
            if (this.mUseDeveloperSupport) {
                this.mDevSupportManager.setDevSupportEnabled(false);
            }
            moveToBeforeCreateLifecycleState();
            this.mCurrentActivity = null;
        }
    }

    public void onHostPause(Activity activity) {
        ImageOriginUtils.assertNotNull(this.mCurrentActivity);
        boolean z = activity == this.mCurrentActivity;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Pausing an activity that is not the current activity, this is incorrect! Current activity: ");
        outline73.append(this.mCurrentActivity.getClass().getSimpleName());
        outline73.append(" Paused activity: ");
        outline73.append(activity.getClass().getSimpleName());
        ImageOriginUtils.assertCondition(z, outline73.toString());
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = null;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        synchronized (this) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (currentReactContext != null) {
                if (this.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                    currentReactContext.onHostResume(this.mCurrentActivity);
                    currentReactContext.onHostPause();
                } else if (this.mLifecycleState == LifecycleState.RESUMED) {
                    currentReactContext.onHostPause();
                }
            }
            this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        }
    }

    public void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = activity;
        if (this.mUseDeveloperSupport) {
            final View decorView = activity.getWindow().getDecorView();
            if (!ViewCompat.isAttachedToWindow(decorView)) {
                decorView.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                    public void onViewAttachedToWindow(View view) {
                        decorView.removeOnAttachStateChangeListener(this);
                        ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                    }

                    public void onViewDetachedFromWindow(View view) {
                    }
                });
            } else {
                this.mDevSupportManager.setDevSupportEnabled(true);
            }
        }
        moveToResumedLifecycleState(false);
    }

    public void onNewIntent(Intent intent) {
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null) {
            FLog.w((String) "ReactInstanceManager", (String) "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
            ((DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)).emitNewIntentReceived(data);
        }
        currentReactContext.onNewIntent(this.mCurrentActivity, intent);
    }

    public final void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        Iterable<ModuleHolder> iterable;
        List<NativeModule> list;
        SystraceMessage.Builder builder = SystraceMessage.NOOP_BUILDER;
        reactPackage.getClass().getSimpleName();
        NoopBuilder noopBuilder = (NoopBuilder) builder;
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        if (reactPackage instanceof LazyReactPackage) {
            iterable = ((LazyReactPackage) reactPackage).getNativeModuleIterator(nativeModuleRegistryBuilder.mReactApplicationContext);
        } else if (reactPackage instanceof TurboReactPackage) {
            TurboReactPackage turboReactPackage = (TurboReactPackage) reactPackage;
            iterable = new Iterable<ModuleHolder>(turboReactPackage.getReactModuleInfoProvider().getReactModuleInfos().entrySet().iterator(), nativeModuleRegistryBuilder.mReactApplicationContext) {
                public final /* synthetic */ Iterator val$entrySetIterator;
                public final /* synthetic */ ReactApplicationContext val$reactContext;

                {
                    this.val$entrySetIterator = r2;
                    this.val$reactContext = r3;
                }

                public Iterator<ModuleHolder> iterator() {
                    return new Iterator<ModuleHolder>() {
                        public Entry<String, ReactModuleInfo> nextEntry = null;

                        public final void findNext() {
                            if (AnonymousClass1.this.val$entrySetIterator.hasNext()) {
                                Entry<String, ReactModuleInfo> entry = (Entry) AnonymousClass1.this.val$entrySetIterator.next();
                                ReactModuleInfo value = entry.getValue();
                                this.nextEntry = entry;
                                return;
                            }
                            this.nextEntry = null;
                        }

                        public boolean hasNext() {
                            if (this.nextEntry == null) {
                                findNext();
                            }
                            return this.nextEntry != null;
                        }

                        public Object next() {
                            if (this.nextEntry == null) {
                                findNext();
                            }
                            Entry<String, ReactModuleInfo> entry = this.nextEntry;
                            if (entry != null) {
                                findNext();
                                AnonymousClass1 r4 = AnonymousClass1.this;
                                return new ModuleHolder(entry.getValue(), new ModuleHolderProvider(entry.getKey(), r4.val$reactContext));
                            }
                            throw new NoSuchElementException("ModuleHolder not found");
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("Cannot remove native modules from the list");
                        }
                    };
                }
            };
        } else {
            ReactApplicationContext reactApplicationContext = nativeModuleRegistryBuilder.mReactApplicationContext;
            ReactInstanceManager reactInstanceManager = nativeModuleRegistryBuilder.mReactInstanceManager;
            FLog.d("ReactNative", reactPackage.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
            if (reactPackage instanceof ReactInstancePackage) {
                list = ((ReactInstancePackage) reactPackage).createNativeModules(reactApplicationContext, reactInstanceManager);
            } else {
                list = reactPackage.createNativeModules(reactApplicationContext);
            }
            iterable = new ReactPackageHelper$1<>(list);
        }
        for (ModuleHolder moduleHolder : iterable) {
            String name = moduleHolder.getName();
            if (nativeModuleRegistryBuilder.mModules.containsKey(name)) {
                ModuleHolder moduleHolder2 = nativeModuleRegistryBuilder.mModules.get(name);
                if (moduleHolder.getCanOverrideExistingModule()) {
                    nativeModuleRegistryBuilder.mModules.remove(moduleHolder2);
                } else {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("Native module ", name, " tried to override ");
                    outline80.append(moduleHolder2.getClassName());
                    outline80.append(". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true. This error may also be present if the package is present only once in getPackages() but is also automatically added later during build time by autolinking. Try removing the existing entry and rebuild.");
                    throw new IllegalStateException(outline80.toString());
                }
            }
            nativeModuleRegistryBuilder.mModules.put(name, moduleHolder);
        }
        if (z) {
            ((ReactPackageLogger) reactPackage).endProcessPackage();
        }
    }

    public final void recreateReactContextInBackgroundInner() {
        FLog.d("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        Printer printer = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
        UiThreadUtil.assertOnUiThread();
        if (!this.mUseDeveloperSupport || this.mJSMainModulePath == null) {
            FLog.d("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
            Printer printer2 = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag2 = ReactDebugOverlayTags.RN_CORE;
            JavaScriptExecutorFactory javaScriptExecutorFactory = this.mJavaScriptExecutorFactory;
            JSBundleLoader jSBundleLoader = this.mBundleLoader;
            FLog.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
            UiThreadUtil.assertOnUiThread();
            ReactContextInitParams reactContextInitParams = new ReactContextInitParams(this, javaScriptExecutorFactory, jSBundleLoader);
            if (this.mCreateReactContextThread == null) {
                runCreateReactContextOnNewThread(reactContextInitParams);
            } else {
                this.mPendingReactContextInitParams = reactContextInitParams;
            }
            return;
        }
        DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
        if (this.mBundleLoader == null) {
            this.mDevSupportManager.handleReloadJS();
        } else {
            this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback(this, devSettings) {
            });
        }
    }

    public final void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
        FLog.d("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    tearDownReactContext(this.mCurrentReactContext);
                    this.mCurrentReactContext = null;
                }
            }
        }
        this.mCreateReactContextThread = new Thread(null, new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000a */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x000a A[LOOP:0: B:2:0x000a->B:18:0x000a, LOOP_START, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.REACT_CONTEXT_THREAD_END
                    com.facebook.react.bridge.ReactMarker.logMarker(r0)
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this
                    java.lang.Boolean r0 = r0.mHasStartedDestroying
                    monitor-enter(r0)
                L_0x000a:
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this     // Catch:{ all -> 0x0061 }
                    java.lang.Boolean r1 = r1.mHasStartedDestroying     // Catch:{ all -> 0x0061 }
                    boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0061 }
                    if (r1 == 0) goto L_0x001c
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this     // Catch:{ InterruptedException -> 0x000a }
                    java.lang.Boolean r1 = r1.mHasStartedDestroying     // Catch:{ InterruptedException -> 0x000a }
                    r1.wait()     // Catch:{ InterruptedException -> 0x000a }
                    goto L_0x000a
                L_0x001c:
                    monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this
                    r1 = 1
                    r0.mHasStartedCreatingInitialContext = r1
                    r0 = -4
                    android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.VM_INIT     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.ReactMarker.logMarker(r0)     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager$ReactContextInitParams r1 = r5     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.JavaScriptExecutorFactory r1 = r1.mJsExecutorFactory     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.JavaScriptExecutor r1 = r1.create()     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager$ReactContextInitParams r2 = r5     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.JSBundleLoader r2 = r2.mJsBundleLoader     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.ReactApplicationContext r0 = com.facebook.react.ReactInstanceManager.access$1100(r0, r1, r2)     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this     // Catch:{ Exception -> 0x0058 }
                    r2 = 0
                    r1.mCreateReactContextThread = r2     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.ReactMarkerConstants r1 = com.facebook.react.bridge.ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.ReactMarker.logMarker(r1)     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager$5$1 r1 = new com.facebook.react.ReactInstanceManager$5$1     // Catch:{ Exception -> 0x0058 }
                    r1.<init>()     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.ReactInstanceManager$5$2 r2 = new com.facebook.react.ReactInstanceManager$5$2     // Catch:{ Exception -> 0x0058 }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x0058 }
                    r0.runOnNativeModulesQueueThread(r2)     // Catch:{ Exception -> 0x0058 }
                    com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r1)     // Catch:{ Exception -> 0x0058 }
                    goto L_0x0060
                L_0x0058:
                    r0 = move-exception
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this
                    com.facebook.react.devsupport.interfaces.DevSupportManager r1 = r1.mDevSupportManager
                    r1.handleException(r0)
                L_0x0060:
                    return
                L_0x0061:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.AnonymousClass5.run():void");
            }
        }, "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
    }

    public void showDevOptionsDialog() {
        UiThreadUtil.assertOnUiThread();
        this.mDevSupportManager.showDevOptionsDialog();
    }

    public final void tearDownReactContext(ReactContext reactContext) {
        FLog.d("ReactNative", "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.mAttachedReactRoots) {
            for (ReactRoot next : this.mAttachedReactRoots) {
                next.getRootViewGroup().removeAllViews();
                next.getRootViewGroup().setId(-1);
            }
        }
        MemoryPressureRouter memoryPressureRouter = this.mMemoryPressureRouter;
        memoryPressureRouter.mListeners.remove(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
    }
}
