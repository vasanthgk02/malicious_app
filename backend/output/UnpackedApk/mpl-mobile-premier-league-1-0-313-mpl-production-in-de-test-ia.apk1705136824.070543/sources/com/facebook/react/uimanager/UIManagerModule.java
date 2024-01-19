package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Trace;
import android.view.View;
import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.UIViewOperationQueue.ChangeJSResponderOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.ConfigureLayoutAnimationOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.DismissPopupMenuOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.DispatchStringCommandOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.FindTargetForTouchOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.MeasureInWindowOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.MeasureOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.RemoveRootViewOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.SendAccessibilityEvent;
import com.facebook.react.uimanager.UIViewOperationQueue.SetLayoutAnimationEnabledOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.ShowPopupMenuOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UIBlockOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UIOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UpdatePropertiesOperation;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNodeJNIBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = "UIManager")
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    public static final boolean DEBUG = false;
    public static final String NAME = "UIManager";
    public int mBatchId;
    public final Map<String, Object> mCustomDirectEvents;
    public final EventDispatcher mEventDispatcher;
    public final List<UIManagerModuleListener> mListeners;
    public final MemoryTrimCallback mMemoryTrimCallback;
    public final Map<String, Object> mModuleConstants;
    public final UIImplementation mUIImplementation;
    public Map<String, WritableMap> mViewManagerConstantsCache;
    public volatile int mViewManagerConstantsCacheSize;
    public final ViewManagerRegistry mViewManagerRegistry;

    public interface CustomEventNamesResolver {
        String resolveCustomEventName(String str);
    }

    public class MemoryTrimCallback implements ComponentCallbacks2 {
        public MemoryTrimCallback(UIManagerModule uIManagerModule, AnonymousClass1 r2) {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                YogaNodePool.get().clear();
            }
        }
    }

    public interface ViewManagerResolver {
        ViewManager getViewManager(String str);

        List<String> getViewManagerNames();
    }

    static {
        Printer printer = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, int i) {
        this(reactApplicationContext, viewManagerResolver, new UIImplementationProvider(), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.bridge.WritableMap computeConstantsForViewManager(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0022
            com.facebook.react.uimanager.UIImplementation r1 = r3.mUIImplementation
            com.facebook.react.uimanager.ViewManagerRegistry r1 = r1.mViewManagers
            java.util.Map<java.lang.String, com.facebook.react.uimanager.ViewManager> r2 = r1.mViewManagers
            java.lang.Object r2 = r2.get(r4)
            com.facebook.react.uimanager.ViewManager r2 = (com.facebook.react.uimanager.ViewManager) r2
            if (r2 == 0) goto L_0x0012
            goto L_0x0023
        L_0x0012:
            com.facebook.react.uimanager.UIManagerModule$ViewManagerResolver r2 = r1.mViewManagerResolver
            if (r2 == 0) goto L_0x0022
            com.facebook.react.uimanager.ViewManager r2 = r2.getViewManager(r4)
            if (r2 == 0) goto L_0x0023
            java.util.Map<java.lang.String, com.facebook.react.uimanager.ViewManager> r1 = r1.mViewManagers
            r1.put(r4, r2)
            goto L_0x0023
        L_0x0022:
            r2 = r0
        L_0x0023:
            if (r2 != 0) goto L_0x0026
            return r0
        L_0x0026:
            com.facebook.systrace.SystraceMessage$Builder r4 = com.facebook.systrace.SystraceMessage.NOOP_BUILDER
            r2.getName()
            com.facebook.systrace.SystraceMessage$NoopBuilder r4 = (com.facebook.systrace.SystraceMessage.NoopBuilder) r4
            java.util.Map<java.lang.String, java.lang.Object> r4 = r3.mCustomDirectEvents     // Catch:{ all -> 0x0038 }
            java.util.Map r4 = com.facebook.react.uimanager.UIManagerModuleConstantsHelper.createConstantsForViewManager(r2, r0, r0, r0, r4)     // Catch:{ all -> 0x0038 }
            com.facebook.react.bridge.WritableNativeMap r4 = com.facebook.react.bridge.Arguments.makeNativeMap(r4)     // Catch:{ all -> 0x0038 }
            return r4
        L_0x0038:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIManagerModule.computeConstantsForViewManager(java.lang.String):com.facebook.react.bridge.WritableMap");
    }

    public static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        try {
            Map<String, Object> constants = ImageOriginUtils.getConstants();
            HashMap hashMap = (HashMap) constants;
            hashMap.put("ViewManagerNames", viewManagerResolver.getViewManagerNames());
            hashMap.put("LazyViewManagersEnabled", Boolean.TRUE);
            return constants;
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        Trace.beginSection("UIManagerModule.addRootView");
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(getReactApplicationContext(), t.getContext(), ((ReactRoot) t).getSurfaceID());
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.uiImplementationThreadLock) {
            ReactShadowNodeImpl reactShadowNodeImpl = new ReactShadowNodeImpl();
            if (I18nUtil.getInstance().isRTL(uIImplementation.mReactContext)) {
                YogaNative.jni_YGNodeStyleSetDirectionJNI(((YogaNodeJNIBase) reactShadowNodeImpl.mYogaNode).mNativePointer, YogaDirection.RTL.intValue());
            }
            reactShadowNodeImpl.mViewClassName = "Root";
            reactShadowNodeImpl.mReactTag = nextRootViewTag;
            reactShadowNodeImpl.mThemedContext = themedReactContext;
            themedReactContext.runOnNativeModulesQueueThread(new Runnable(reactShadowNodeImpl) {
                public final /* synthetic */ ReactShadowNode val$rootCSSNode;

                {
                    this.val$rootCSSNode = r2;
                }

                public void run() {
                    ShadowNodeRegistry shadowNodeRegistry = UIImplementation.this.mShadowNodeRegistry;
                    ReactShadowNode reactShadowNode = this.val$rootCSSNode;
                    shadowNodeRegistry.mThreadAsserter.assertNow();
                    int reactTag = reactShadowNode.getReactTag();
                    shadowNodeRegistry.mTagsToCSSNodes.put(reactTag, reactShadowNode);
                    shadowNodeRegistry.mRootTags.put(reactTag, true);
                }
            });
            NativeViewHierarchyManager nativeViewHierarchyManager = uIImplementation.mOperationsQueue.mNativeViewHierarchyManager;
            synchronized (nativeViewHierarchyManager) {
                nativeViewHierarchyManager.addRootViewGroup(nextRootViewTag, t);
            }
        }
        Trace.endSection();
        return nextRootViewTag;
    }

    public void addUIBlock(UIBlock uIBlock) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new UIBlockOperation(uIBlock));
    }

    public void addUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.add(uIManagerModuleListener);
    }

    @ReactMethod
    public void clearJSResponder() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        ArrayList<UIOperation> arrayList = uIViewOperationQueue.mOperations;
        ChangeJSResponderOperation changeJSResponderOperation = new ChangeJSResponderOperation(0, 0, true, false);
        arrayList.add(changeJSResponderOperation);
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new ConfigureLayoutAnimationOperation(readableMap, callback, null));
    }

    @ReactMethod
    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        if (DEBUG) {
            FLog.d("ReactNative", "(UIManager.createView) tag: " + i + ", class: " + str + ", props: " + readableMap);
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.uiImplementationThreadLock) {
            ReactShadowNode createShadowNodeInstance = uIImplementation.mViewManagers.get(str).createShadowNodeInstance(uIImplementation.mReactContext);
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i2);
            ImageOriginUtils.assertNotNull(reactShadowNode, "Root node with tag " + i2 + " doesn't exist");
            createShadowNodeInstance.setReactTag(i);
            createShadowNodeInstance.setViewClassName(str);
            createShadowNodeInstance.setRootTag(reactShadowNode.getReactTag());
            createShadowNodeInstance.setThemedContext(reactShadowNode.getThemedContext());
            ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry2.mThreadAsserter.assertNow();
            shadowNodeRegistry2.mTagsToCSSNodes.put(createShadowNodeInstance.getReactTag(), createShadowNodeInstance);
            ReactStylesDiffMap reactStylesDiffMap = null;
            if (readableMap != null) {
                reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                createShadowNodeInstance.updateProperties(reactStylesDiffMap);
            }
            uIImplementation.handleCreateView(createShadowNodeInstance, reactStylesDiffMap);
        }
    }

    @ReactMethod
    public void dismissPopupMenu() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new DismissPopupMenuOperation(null));
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.assertViewExists(i, "dispatchViewManagerCommand");
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
        DispatchCommandOperation dispatchCommandOperation = new DispatchCommandOperation(i, i2, readableArray);
        if (uIViewOperationQueue.mAllowViewCommandsQueue) {
            uIViewOperationQueue.mViewCommandOperations.add(dispatchCommandOperation);
        } else {
            uIViewOperationQueue.mOperations.add(dispatchCommandOperation);
        }
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i, Dynamic dynamic, ReadableArray readableArray) {
        UIManager uIManager = ImageOriginUtils.getUIManager(getReactApplicationContext(), ImageOriginUtils.getUIManagerType(i));
        if (uIManager != null) {
            if (dynamic.getType() == ReadableType.Number) {
                uIManager.dispatchCommand(i, dynamic.asInt(), readableArray);
            } else if (dynamic.getType() == ReadableType.String) {
                uIManager.dispatchCommand(i, dynamic.asString(), readableArray);
            }
        }
    }

    @ReactMethod
    public void findSubviewIn(int i, ReadableArray readableArray, Callback callback) {
        UIImplementation uIImplementation = this.mUIImplementation;
        float round = (float) Math.round(ImageOriginUtils.toPixelFromDIP(readableArray.getDouble(0)));
        float round2 = (float) Math.round(ImageOriginUtils.toPixelFromDIP(readableArray.getDouble(1)));
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
        ArrayList<UIOperation> arrayList = uIViewOperationQueue.mOperations;
        FindTargetForTouchOperation findTargetForTouchOperation = new FindTargetForTouchOperation(i, round, round2, callback, null);
        arrayList.add(findTargetForTouchOperation);
    }

    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        Map<String, WritableMap> map = this.mViewManagerConstantsCache;
        if (map == null || !map.containsKey(str)) {
            return computeConstantsForViewManager(str);
        }
        WritableMap writableMap = this.mViewManagerConstantsCache.get(str);
        int i = this.mViewManagerConstantsCacheSize - 1;
        this.mViewManagerConstantsCacheSize = i;
        if (i <= 0) {
            this.mViewManagerConstantsCache = null;
        }
        return writableMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(ImageOriginUtils.of("bubblingEventTypes", ImageOriginUtils.getBubblingEventTypeConstants(), "directEventTypes", ImageOriginUtils.getDirectEventTypeConstants()));
    }

    public CustomEventNamesResolver getDirectEventNamesResolver() {
        return new CustomEventNamesResolver() {
            public String resolveCustomEventName(String str) {
                Map map = (Map) UIManagerModule.this.mCustomDirectEvents.get(str);
                return map != null ? (String) map.get("registrationName") : str;
            }
        };
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Long> getPerformanceCounters() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        if (uIViewOperationQueue != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("CommitStartTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchCommitStartTime));
            hashMap.put("CommitEndTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchCommitEndTime));
            hashMap.put("LayoutTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchLayoutTime));
            hashMap.put("DispatchViewUpdatesTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchDispatchViewUpdatesTime));
            hashMap.put("RunStartTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchRunStartTime));
            hashMap.put("RunEndTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchRunEndTime));
            hashMap.put("BatchedExecutionTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchBatchedExecutionTime));
            hashMap.put("NonBatchedExecutionTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchNonBatchedExecutionTime));
            hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(uIViewOperationQueue.mThreadCpuTime));
            hashMap.put("CreateViewCount", Long.valueOf(uIViewOperationQueue.mCreateViewCount));
            hashMap.put("UpdatePropsCount", Long.valueOf(uIViewOperationQueue.mUpdatePropertiesOperationCount));
            return hashMap;
        }
        throw null;
    }

    public UIImplementation getUIImplementation() {
        return this.mUIImplementation;
    }

    @Deprecated
    public ViewManagerRegistry getViewManagerRegistry_DO_NOT_USE() {
        return this.mViewManagerRegistry;
    }

    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        this.mEventDispatcher.mReactEventEmitter.register(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    public void invalidateNodeLayout(int i) {
        ReactShadowNode resolveShadowNode = this.mUIImplementation.resolveShadowNode(i);
        if (resolveShadowNode == null) {
            FLog.w((String) "ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i);
            return;
        }
        resolveShadowNode.dirty();
        this.mUIImplementation.dispatchViewUpdates(-1);
    }

    @ReactMethod
    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        if (DEBUG) {
            FLog.d("ReactNative", "(UIManager.manageChildren) tag: " + i + ", moveFrom: " + readableArray + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5);
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
        }
        this.mUIImplementation.manageChildren(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void measure(int i, Callback callback) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new MeasureOperation(i, callback, null));
    }

    @ReactMethod
    public void measureInWindow(int i, Callback callback) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new MeasureInWindowOperation(i, callback, null));
    }

    @ReactMethod
    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation != null) {
            try {
                uIImplementation.measureLayout(i, i2, uIImplementation.mMeasureBuffer);
                callback2.invoke(Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[0])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[1])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[2])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e2) {
                callback.invoke(e2.getMessage());
            }
        } else {
            throw null;
        }
    }

    @Deprecated
    @ReactMethod
    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        if (uIImplementation != null) {
            try {
                uIImplementation.measureLayoutRelativeToParent(i, uIImplementation.mMeasureBuffer);
                callback2.invoke(Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[0])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[1])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[2])), Float.valueOf(ImageOriginUtils.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e2) {
                callback.invoke(e2.getMessage());
            }
        } else {
            throw null;
        }
    }

    public void onBatchComplete() {
        int i = this.mBatchId;
        this.mBatchId = i + 1;
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        for (UIManagerModuleListener willDispatchViewUpdates : this.mListeners) {
            willDispatchViewUpdates.willDispatchViewUpdates(this);
        }
        try {
            this.mUIImplementation.dispatchViewUpdates(i);
        } finally {
            Trace.endSection();
        }
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (eventDispatcher != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    EventDispatcher.this.stopFrameCallback();
                }
            });
            getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
            YogaNodePool.get().clear();
            ViewManagerPropertyUpdater.clear();
            return;
        }
        throw null;
    }

    public void onHostDestroy() {
        if (this.mUIImplementation == null) {
            throw null;
        }
    }

    public void onHostPause() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mIsDispatchUIFrameCallbackEnqueued = false;
        ReactChoreographer.getInstance().removeFrameCallback(CallbackType.DISPATCH_UI, uIViewOperationQueue.mDispatchUIFrameCallback);
        uIViewOperationQueue.flushPendingBatches();
    }

    public void onHostResume() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mIsDispatchUIFrameCallbackEnqueued = true;
        ReactChoreographer.getInstance().postFrameCallback(CallbackType.DISPATCH_UI, uIViewOperationQueue.mDispatchUIFrameCallback);
    }

    @Deprecated
    @ReactMethod
    public void playTouchSound() {
        AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.playSoundEffect(0);
        }
    }

    @Deprecated
    public void preComputeConstantsForViewManager(List<String> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : list) {
            WritableMap computeConstantsForViewManager = computeConstantsForViewManager(next);
            if (computeConstantsForViewManager != null) {
                arrayMap.put(next, computeConstantsForViewManager);
            }
        }
        this.mViewManagerConstantsCacheSize = list.size();
        this.mViewManagerConstantsCache = Collections.unmodifiableMap(arrayMap);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(0, new UIBlockOperation(uIBlock));
    }

    public void profileNextBatch() {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mIsProfilingNextBatch = true;
        uIViewOperationQueue.mProfiledBatchCommitStartTime = 0;
        uIViewOperationQueue.mCreateViewCount = 0;
        uIViewOperationQueue.mUpdatePropertiesOperationCount = 0;
    }

    @ReactMethod
    public void removeRootView(int i) {
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.uiImplementationThreadLock) {
            uIImplementation.mShadowNodeRegistry.removeRootNode(i);
        }
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new RemoveRootViewOperation(i));
    }

    @Deprecated
    @ReactMethod
    public void removeSubviewsFromContainerWithID(int i) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
                createArray.pushInt(i2);
            }
            uIImplementation.manageChildren(i, null, null, null, null, createArray);
            return;
        }
        throw new IllegalViewOperationException(GeneratedOutlineSupport.outline41("Trying to remove subviews of an unknown view tag: ", i));
    }

    public void removeUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.remove(uIManagerModuleListener);
    }

    @Deprecated
    @ReactMethod
    public void replaceExistingNonRootView(int i, int i2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (!shadowNodeRegistry.mRootTags.get(i)) {
            ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry2.mThreadAsserter.assertNow();
            if (!shadowNodeRegistry2.mRootTags.get(i2)) {
                ShadowNodeRegistry shadowNodeRegistry3 = uIImplementation.mShadowNodeRegistry;
                shadowNodeRegistry3.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry3.mTagsToCSSNodes.get(i);
                if (reactShadowNode != null) {
                    ReactShadowNode parent = reactShadowNode.getParent();
                    if (parent != null) {
                        int indexOf = parent.indexOf(reactShadowNode);
                        if (indexOf >= 0) {
                            WritableArray createArray = Arguments.createArray();
                            createArray.pushInt(i2);
                            WritableArray createArray2 = Arguments.createArray();
                            createArray2.pushInt(indexOf);
                            WritableArray createArray3 = Arguments.createArray();
                            createArray3.pushInt(indexOf);
                            uIImplementation.manageChildren(parent.getReactTag(), null, null, createArray, createArray2, createArray3);
                            return;
                        }
                        throw new IllegalStateException("Didn't find child tag in parent");
                    }
                    throw new IllegalViewOperationException(GeneratedOutlineSupport.outline41("Node is not attached to a parent: ", i));
                }
                throw new IllegalViewOperationException(GeneratedOutlineSupport.outline41("Trying to replace unknown view tag: ", i));
            }
        }
        throw new IllegalViewOperationException("Trying to add or replace a root tag!");
    }

    @Deprecated
    public int resolveRootTagFromReactTag(int i) {
        boolean z = true;
        int i2 = 0;
        if (i % 10 != 1) {
            z = false;
        }
        if (z) {
            return i;
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (shadowNodeRegistry.mRootTags.get(i)) {
            return i;
        }
        ReactShadowNode resolveShadowNode = uIImplementation.resolveShadowNode(i);
        if (resolveShadowNode != null) {
            i2 = resolveShadowNode.getRootTag();
        } else {
            FLog.w((String) "ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i);
        }
        return i2;
    }

    public View resolveView(int i) {
        UiThreadUtil.assertOnUiThread();
        return this.mUIImplementation.mOperationsQueue.mNativeViewHierarchyManager.resolveView(i);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i, int i2) {
        int uIManagerType = ImageOriginUtils.getUIManagerType(i);
        if (uIManagerType == 2) {
            UIManager uIManager = ImageOriginUtils.getUIManager(getReactApplicationContext(), uIManagerType);
            if (uIManager != null) {
                uIManager.sendAccessibilityEvent(i, i2);
                return;
            }
            return;
        }
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new SendAccessibilityEvent(i, i2, null));
    }

    @ReactMethod
    public void setChildren(int i, ReadableArray readableArray) {
        if (DEBUG) {
            FLog.d("ReactNative", "(UIManager.setChildren) tag: " + i + ", children: " + readableArray);
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.uiImplementationThreadLock) {
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            int i2 = 0;
            while (i2 < readableArray.size()) {
                ReactShadowNode node = uIImplementation.mShadowNodeRegistry.getNode(readableArray.getInt(i2));
                if (node != null) {
                    reactShadowNode.addChildAt(node, i2);
                    i2++;
                } else {
                    throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2));
                }
            }
            NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.mNativeViewHierarchyOptimizer;
            if (nativeViewHierarchyOptimizer != null) {
                for (int i3 = 0; i3 < readableArray.size(); i3++) {
                    nativeViewHierarchyOptimizer.addNodeToNode(reactShadowNode, nativeViewHierarchyOptimizer.mShadowNodeRegistry.getNode(readableArray.getInt(i3)), i3);
                }
            } else {
                throw null;
            }
        }
    }

    @ReactMethod
    public void setJSResponder(int i, boolean z) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode != null) {
            while (reactShadowNode.getNativeKind() == NativeKind.NONE) {
                reactShadowNode = reactShadowNode.getParent();
            }
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            int reactTag = reactShadowNode.getReactTag();
            ArrayList<UIOperation> arrayList = uIViewOperationQueue.mOperations;
            ChangeJSResponderOperation changeJSResponderOperation = new ChangeJSResponderOperation(reactTag, i, false, z);
            arrayList.add(changeJSResponderOperation);
        }
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
        uIViewOperationQueue.mOperations.add(new SetLayoutAnimationEnabledOperation(z, null));
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mUIImplementation.mOperationsQueue.mViewHierarchyUpdateDebugListener = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public void setViewLocalData(final int i, final Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
            public void runGuarded() {
                UIImplementation access$200 = UIManagerModule.this.mUIImplementation;
                int i = i;
                Object obj = obj;
                ShadowNodeRegistry shadowNodeRegistry = access$200.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                if (reactShadowNode == null) {
                    FLog.w((String) "ReactNative", "Attempt to set local data for view with unknown tag: " + i);
                    return;
                }
                reactShadowNode.setLocalData(obj);
                if (access$200.mOperationsQueue.isEmpty()) {
                    access$200.dispatchViewUpdates(-1);
                }
            }
        });
    }

    @ReactMethod
    public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.assertViewExists(i, "showPopupMenu");
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
        ArrayList<UIOperation> arrayList = uIViewOperationQueue.mOperations;
        ShowPopupMenuOperation showPopupMenuOperation = new ShowPopupMenuOperation(i, readableArray, callback, callback2);
        arrayList.add(showPopupMenuOperation);
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
        int uIManagerType = ImageOriginUtils.getUIManagerType(i);
        if (uIManagerType == 2) {
            UIManager uIManager = ImageOriginUtils.getUIManager(getReactApplicationContext(), uIManagerType);
            if (uIManager != null) {
                uIManager.synchronouslyUpdateViewOnUIThread(i, readableMap);
                return;
            }
            return;
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
        if (uIImplementation != null) {
            UiThreadUtil.assertOnUiThread();
            uIImplementation.mOperationsQueue.mNativeViewHierarchyManager.updateProperties(i, reactStylesDiffMap);
            return;
        }
        throw null;
    }

    public void updateNodeSize(int i, int i2, int i3) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode == null) {
            FLog.w((String) "ReactNative", "Tried to update size of non-existent tag: " + i);
            return;
        }
        reactShadowNode.setStyleWidth((float) i2);
        reactShadowNode.setStyleHeight((float) i3);
        if (uIImplementation.mOperationsQueue.isEmpty()) {
            uIImplementation.dispatchViewUpdates(-1);
        }
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        AnonymousClass4 r0 = new GuardedRunnable(reactApplicationContext) {
            public void runGuarded() {
                UIImplementation access$200 = UIManagerModule.this.mUIImplementation;
                int i = i4;
                int i2 = i5;
                int i3 = i6;
                ShadowNodeRegistry shadowNodeRegistry = access$200.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                if (reactShadowNode == null) {
                    FLog.w((String) "ReactNative", "Tried to update non-existent root tag: " + i);
                } else {
                    reactShadowNode.setMeasureSpecs(i2, i3);
                }
                UIManagerModule.this.mUIImplementation.dispatchViewUpdates(-1);
            }
        };
        reactApplicationContext.runOnNativeModulesQueueThread(r0);
    }

    @ReactMethod
    public void updateView(final int i, String str, final ReadableMap readableMap) {
        if (DEBUG) {
            FLog.d("ReactNative", "(UIManager.updateView) tag: " + i + ", class: " + str + ", props: " + readableMap);
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
        }
        int uIManagerType = ImageOriginUtils.getUIManagerType(i);
        if (uIManagerType == 2) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            if (reactApplicationContext.hasActiveCatalystInstance()) {
                final UIManager uIManager = ImageOriginUtils.getUIManager(reactApplicationContext, uIManagerType);
                if (uIManager != null) {
                    reactApplicationContext.runOnUiQueueThread(new Runnable(this) {
                        public void run() {
                            uIManager.synchronouslyUpdateViewOnUIThread(i, readableMap);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.mViewManagers.get(str);
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode == null) {
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline41("Trying to update non-existent view with tag ", i));
        } else if (readableMap != null) {
            ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
            reactShadowNode.updateProperties(reactStylesDiffMap);
            if (!reactShadowNode.isVirtual()) {
                NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.mNativeViewHierarchyOptimizer;
                if (nativeViewHierarchyOptimizer != null) {
                    if (reactShadowNode.isLayoutOnly() && !NativeViewHierarchyOptimizer.isLayoutOnlyAndCollapsable(reactStylesDiffMap)) {
                        nativeViewHierarchyOptimizer.transitionLayoutOnlyViewToNativeView(reactShadowNode, reactStylesDiffMap);
                    } else if (!reactShadowNode.isLayoutOnly()) {
                        UIViewOperationQueue uIViewOperationQueue = nativeViewHierarchyOptimizer.mUIViewOperationQueue;
                        int reactTag = reactShadowNode.getReactTag();
                        uIViewOperationQueue.mUpdatePropertiesOperationCount++;
                        uIViewOperationQueue.mOperations.add(new UpdatePropertiesOperation(reactTag, reactStylesDiffMap, null));
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    @Deprecated
    @ReactMethod
    public void viewIsDescendantOf(int i, int i2, Callback callback) {
        UIImplementation uIImplementation = this.mUIImplementation;
        ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
        shadowNodeRegistry2.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode2 = shadowNodeRegistry2.mTagsToCSSNodes.get(i2);
        if (reactShadowNode == null || reactShadowNode2 == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        callback.invoke(Boolean.valueOf(reactShadowNode.isDescendantOf(reactShadowNode2)));
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i) {
        this(reactApplicationContext, list, new UIImplementationProvider(), i);
    }

    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, UIImplementationProvider uIImplementationProvider, int i) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback(this, null);
        this.mListeners = new ArrayList();
        this.mBatchId = 0;
        ImageOriginUtils.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
        this.mModuleConstants = createConstants(viewManagerResolver);
        this.mCustomDirectEvents = ImageOriginUtils.getDirectEventTypeConstants();
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(viewManagerResolver);
        this.mViewManagerRegistry = viewManagerRegistry;
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (uIImplementationProvider != null) {
            this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i);
            reactApplicationContext.addLifecycleEventListener(this);
            return;
        }
        throw null;
    }

    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        UIImplementation uIImplementation = this.mUIImplementation;
        uIImplementation.assertViewExists(i, "dispatchViewManagerCommand");
        UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
        DispatchStringCommandOperation dispatchStringCommandOperation = new DispatchStringCommandOperation(i, str, readableArray);
        if (uIViewOperationQueue.mAllowViewCommandsQueue) {
            uIViewOperationQueue.mViewCommandOperations.add(dispatchStringCommandOperation);
        } else {
            uIViewOperationQueue.mOperations.add(dispatchStringCommandOperation);
        }
    }

    public static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
        try {
            Map<String, Object> createConstants = UIManagerModuleConstantsHelper.createConstants(list, map, map2);
            return createConstants;
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, UIImplementationProvider uIImplementationProvider, int i) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback(this, null);
        this.mListeners = new ArrayList();
        this.mBatchId = 0;
        ImageOriginUtils.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
        HashMap hashMap = new HashMap();
        this.mCustomDirectEvents = hashMap;
        this.mModuleConstants = createConstants(list, null, hashMap);
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(list);
        this.mViewManagerRegistry = viewManagerRegistry;
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (uIImplementationProvider != null) {
            this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i);
            reactApplicationContext.addLifecycleEventListener(this);
            return;
        }
        throw null;
    }

    public <T extends View> int addRootView(T t) {
        return addRootView(t, null, null);
    }
}
