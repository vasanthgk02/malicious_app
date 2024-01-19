package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;

public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    public static final String TAG = "ReactRootView";
    public final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper;
    public Bundle mAppProperties;
    public CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    public int mHeightMeasureSpec;
    public String mInitialUITemplate;
    public boolean mIsAttachedToInstance;
    public String mJSModuleName;
    public JSTouchDispatcher mJSTouchDispatcher;
    public int mLastHeight;
    public int mLastWidth;
    public ReactInstanceManager mReactInstanceManager;
    public ReactRootViewEventListener mRootViewEventListener;
    public int mRootViewTag;
    public boolean mShouldLogContentAppeared;
    public int mUIManagerType;
    public final boolean mUseSurface;
    public boolean mWasMeasured;
    public int mWidthMeasureSpec;

    public class CustomGlobalLayoutListener implements OnGlobalLayoutListener {
        public int mDeviceRotation = 0;
        public int mKeyboardHeight = 0;
        public final int mMinKeyboardHeightDetected;
        public final Rect mVisibleViewArea;

        public CustomGlobalLayoutListener() {
            ImageOriginUtils.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) ImageOriginUtils.toPixelFromDIP(60.0f);
        }

        public final WritableMap createKeyboardEventPayload(double d2, double d3, double d4, double d5) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble("height", d5);
            createMap2.putDouble("screenX", d3);
            createMap2.putDouble("width", d4);
            createMap2.putDouble("screenY", d2);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", System.KEYBOARD);
            createMap.putDouble(InlineAnimation.DURATION, 0.0d);
            return createMap;
        }

        public void onGlobalLayout() {
            String str;
            double d2;
            String str2;
            if (ReactRootView.this.mReactInstanceManager != null && ReactRootView.this.mIsAttachedToInstance && ReactRootView.this.mReactInstanceManager.getCurrentReactContext() != null) {
                ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
                int i = ImageOriginUtils.sWindowDisplayMetrics.heightPixels - this.mVisibleViewArea.bottom;
                boolean z = true;
                if (this.mKeyboardHeight != i && i > this.mMinKeyboardHeightDetected) {
                    this.mKeyboardHeight = i;
                    ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload((double) ImageOriginUtils.toDIPFromPixel((float) this.mVisibleViewArea.bottom), (double) ImageOriginUtils.toDIPFromPixel((float) this.mVisibleViewArea.left), (double) ImageOriginUtils.toDIPFromPixel((float) this.mVisibleViewArea.width()), (double) ImageOriginUtils.toDIPFromPixel((float) this.mKeyboardHeight)));
                } else {
                    if (this.mKeyboardHeight != 0 && i <= this.mMinKeyboardHeightDetected) {
                        this.mKeyboardHeight = 0;
                        ReactRootView reactRootView = ReactRootView.this;
                        reactRootView.sendEvent("keyboardDidHide", createKeyboardEventPayload((double) ImageOriginUtils.toDIPFromPixel((float) reactRootView.mLastHeight), 0.0d, (double) ImageOriginUtils.toDIPFromPixel((float) this.mVisibleViewArea.width()), 0.0d));
                    }
                }
                int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
                if (this.mDeviceRotation != rotation) {
                    this.mDeviceRotation = rotation;
                    ImageOriginUtils.initDisplayMetrics(ReactRootView.this.getContext().getApplicationContext());
                    if (rotation != 0) {
                        if (rotation == 1) {
                            d2 = -90.0d;
                            str = "landscape-primary";
                        } else if (rotation == 2) {
                            d2 = 180.0d;
                            str2 = "portrait-secondary";
                        } else if (rotation == 3) {
                            d2 = 90.0d;
                            str = "landscape-secondary";
                        }
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("name", str);
                        createMap.putDouble("rotationDegrees", d2);
                        createMap.putBoolean("isLandscape", z);
                        ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
                    } else {
                        d2 = 0.0d;
                        str2 = "portrait-primary";
                    }
                    str = str2;
                    z = false;
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("name", str);
                    createMap2.putDouble("rotationDegrees", d2);
                    createMap2.putBoolean("isLandscape", z);
                    ReactRootView.this.sendEvent("namedOrientationDidChange", createMap2);
                }
                ((DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
            }
        }
    }

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    public ReactRootView(Context context) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    private void attachToReactInstanceManager() {
        Trace.beginSection("attachToReactInstanceManager");
        if (!this.mIsAttachedToInstance) {
            try {
                this.mIsAttachedToInstance = true;
                ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
                ImageOriginUtils.assertNotNull(reactInstanceManager);
                ReactInstanceManager reactInstanceManager2 = reactInstanceManager;
                UiThreadUtil.assertOnUiThread();
                reactInstanceManager2.mAttachedReactRoots.add(this);
                getRootViewGroup().removeAllViews();
                getRootViewGroup().setId(-1);
                ReactContext currentReactContext = reactInstanceManager2.getCurrentReactContext();
                if (reactInstanceManager2.mCreateReactContextThread == null && currentReactContext != null) {
                    reactInstanceManager2.attachRootViewToInstance(this);
                }
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    private void dispatchJSTouchEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w((String) TAG, (String) "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w((String) TAG, (String) "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
        }
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void init() {
        setClipChildren(false);
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    private void updateRootLayoutSpecs(int i, int i2) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null) {
            FLog.w((String) TAG, (String) "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
        if (currentReactContext != null) {
            UIManager uIManager = ImageOriginUtils.getUIManager(currentReactContext, getUIManagerType());
            if (uIManager != null) {
                uIManager.updateRootLayoutSpecs(getRootViewTag(), i, i2);
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e2) {
            handleException(e2);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w((String) TAG, (String) "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        if (reactAndroidHWInputDeviceHelper != null) {
            int keyCode = keyEvent.getKeyCode();
            int action = keyEvent.getAction();
            if ((action == 1 || action == 0) && ReactAndroidHWInputDeviceHelper.KEY_EVENTS_ACTIONS.containsKey(Integer.valueOf(keyCode))) {
                reactAndroidHWInputDeviceHelper.dispatchEvent(ReactAndroidHWInputDeviceHelper.KEY_EVENTS_ACTIONS.get(Integer.valueOf(keyCode)), reactAndroidHWInputDeviceHelper.mLastFocusedViewId, action);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        throw null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        ImageOriginUtils.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    public String getJSModuleName() {
        String str = this.mJSModuleName;
        ImageOriginUtils.assertNotNull(str);
        return str;
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    public ViewGroup getRootViewGroup() {
        return this;
    }

    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public void handleException(Throwable th) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        ReactRootViewEventListener reactRootViewEventListener = this.mRootViewEventListener;
        if (reactRootViewEventListener != null) {
            reactRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w((String) TAG, (String) "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w((String) TAG, (String) "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            EventDispatcher eventDispatcher = ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
            JSTouchDispatcher jSTouchDispatcher = this.mJSTouchDispatcher;
            if (!jSTouchDispatcher.mChildIsHandlingNativeGesture) {
                jSTouchDispatcher.dispatchCancelEvent(motionEvent, eventDispatcher);
                jSTouchDispatcher.mChildIsHandlingNativeGesture = true;
                jSTouchDispatcher.mTargetTag = -1;
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w((String) TAG, (String) "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i, rect);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        int i2 = reactAndroidHWInputDeviceHelper.mLastFocusedViewId;
        if (i2 != -1) {
            reactAndroidHWInputDeviceHelper.dispatchEvent("blur", i2, -1);
        }
        reactAndroidHWInputDeviceHelper.mLastFocusedViewId = -1;
        super.onFocusChanged(z, i, rect);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUseSurface) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[Catch:{ all -> 0x00b2 }, LOOP:0: B:19:0x0031->B:21:0x0037, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a A[Catch:{ all -> 0x00b2 }, LOOP:1: B:28:0x0064->B:30:0x006a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091 A[Catch:{ all -> 0x00b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.mUseSurface
            if (r0 == 0) goto L_0x0008
            super.onMeasure(r9, r10)
            return
        L_0x0008:
            java.lang.String r0 = "ReactRootView.onMeasure"
            android.os.Trace.beginSection(r0)
            int r0 = r8.mWidthMeasureSpec     // Catch:{ all -> 0x00b2 }
            r1 = 1
            r2 = 0
            if (r9 != r0) goto L_0x001a
            int r0 = r8.mHeightMeasureSpec     // Catch:{ all -> 0x00b2 }
            if (r10 == r0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            r8.mWidthMeasureSpec = r9     // Catch:{ all -> 0x00b2 }
            r8.mHeightMeasureSpec = r10     // Catch:{ all -> 0x00b2 }
            int r3 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x00b2 }
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x002f
            if (r3 != 0) goto L_0x002a
            goto L_0x002f
        L_0x002a:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x00b2 }
            goto L_0x0055
        L_0x002f:
            r9 = 0
            r3 = 0
        L_0x0031:
            int r5 = r8.getChildCount()     // Catch:{ all -> 0x00b2 }
            if (r3 >= r5) goto L_0x0055
            android.view.View r5 = r8.getChildAt(r3)     // Catch:{ all -> 0x00b2 }
            int r6 = r5.getLeft()     // Catch:{ all -> 0x00b2 }
            int r7 = r5.getMeasuredWidth()     // Catch:{ all -> 0x00b2 }
            int r6 = r6 + r7
            int r7 = r5.getPaddingLeft()     // Catch:{ all -> 0x00b2 }
            int r6 = r6 + r7
            int r5 = r5.getPaddingRight()     // Catch:{ all -> 0x00b2 }
            int r6 = r6 + r5
            int r9 = java.lang.Math.max(r9, r6)     // Catch:{ all -> 0x00b2 }
            int r3 = r3 + 1
            goto L_0x0031
        L_0x0055:
            int r3 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x00b2 }
            if (r3 == r4) goto L_0x0063
            if (r3 != 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x00b2 }
            goto L_0x0088
        L_0x0063:
            r10 = 0
        L_0x0064:
            int r3 = r8.getChildCount()     // Catch:{ all -> 0x00b2 }
            if (r2 >= r3) goto L_0x0088
            android.view.View r3 = r8.getChildAt(r2)     // Catch:{ all -> 0x00b2 }
            int r4 = r3.getTop()     // Catch:{ all -> 0x00b2 }
            int r5 = r3.getMeasuredHeight()     // Catch:{ all -> 0x00b2 }
            int r4 = r4 + r5
            int r5 = r3.getPaddingTop()     // Catch:{ all -> 0x00b2 }
            int r4 = r4 + r5
            int r3 = r3.getPaddingBottom()     // Catch:{ all -> 0x00b2 }
            int r4 = r4 + r3
            int r10 = java.lang.Math.max(r10, r4)     // Catch:{ all -> 0x00b2 }
            int r2 = r2 + 1
            goto L_0x0064
        L_0x0088:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x00b2 }
            r8.mWasMeasured = r1     // Catch:{ all -> 0x00b2 }
            com.facebook.react.ReactInstanceManager r1 = r8.mReactInstanceManager     // Catch:{ all -> 0x00b2 }
            if (r1 == 0) goto L_0x0099
            boolean r1 = r8.mIsAttachedToInstance     // Catch:{ all -> 0x00b2 }
            if (r1 != 0) goto L_0x0099
            r8.attachToReactInstanceManager()     // Catch:{ all -> 0x00b2 }
            goto L_0x00aa
        L_0x0099:
            if (r0 != 0) goto L_0x00a3
            int r0 = r8.mLastWidth     // Catch:{ all -> 0x00b2 }
            if (r0 != r9) goto L_0x00a3
            int r0 = r8.mLastHeight     // Catch:{ all -> 0x00b2 }
            if (r0 == r10) goto L_0x00aa
        L_0x00a3:
            int r0 = r8.mWidthMeasureSpec     // Catch:{ all -> 0x00b2 }
            int r1 = r8.mHeightMeasureSpec     // Catch:{ all -> 0x00b2 }
            r8.updateRootLayoutSpecs(r0, r1)     // Catch:{ all -> 0x00b2 }
        L_0x00aa:
            r8.mLastWidth = r9     // Catch:{ all -> 0x00b2 }
            r8.mLastHeight = r10     // Catch:{ all -> 0x00b2 }
            android.os.Trace.endSection()
            return
        L_0x00b2:
            r9 = move-exception
            android.os.Trace.endSection()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.onMeasure(int, int):void");
    }

    public void onStage(int i) {
        if (i == 101) {
            onAttachedToReactInstance();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            String str = this.mJSModuleName;
            if (str != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, str, this.mRootViewTag);
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w((String) TAG, (String) "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        if (reactAndroidHWInputDeviceHelper.mLastFocusedViewId != view2.getId()) {
            int i = reactAndroidHWInputDeviceHelper.mLastFocusedViewId;
            if (i != -1) {
                reactAndroidHWInputDeviceHelper.dispatchEvent("blur", i, -1);
            }
            reactAndroidHWInputDeviceHelper.mLastFocusedViewId = view2.getId();
            reactAndroidHWInputDeviceHelper.dispatchEvent("focus", view2.getId(), -1);
        }
        super.requestChildFocus(view, view2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void runApplication() {
        Trace.beginSection("ReactRootView.runApplication");
        try {
            if (this.mReactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Trace.endSection();
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (!this.mUseSurface) {
                        if (this.mWasMeasured) {
                            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                        }
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                        Bundle appProperties = getAppProperties();
                        if (appProperties != null) {
                            writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                        }
                        this.mShouldLogContentAppeared = true;
                        FLog.e((String) TAG, (String) "runApplication: call AppRegistry.runApplication");
                        ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    }
                    Trace.endSection();
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            ((RCTDeviceEventEmitter) reactInstanceManager.getCurrentReactContext().getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (getRootViewTag() != 0) {
            runApplication();
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    public void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle, String str2) {
        Trace.beginSection("startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            ImageOriginUtils.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = str2;
            if (reactInstanceManager != null) {
                FLog.d("ReactInstanceManager", "ReactInstanceManager.createReactContextInBackground()");
                UiThreadUtil.assertOnUiThread();
                if (!reactInstanceManager.mHasStartedCreatingInitialContext) {
                    reactInstanceManager.mHasStartedCreatingInitialContext = true;
                    reactInstanceManager.recreateReactContextInBackgroundInner();
                }
                attachToReactInstanceManager();
                return;
            }
            throw null;
        } finally {
            Trace.endSection();
        }
    }

    public void unmountReactApplication() {
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null && this.mIsAttachedToInstance) {
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                synchronized (reactInstanceManager.mAttachedReactRoots) {
                    if (reactInstanceManager.mAttachedReactRoots.contains(this)) {
                        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                        reactInstanceManager.mAttachedReactRoots.remove(this);
                        if (currentReactContext != null && currentReactContext.hasActiveCatalystInstance()) {
                            reactInstanceManager.detachViewFromInstance(this, currentReactContext.getCatalystInstance());
                        }
                    }
                }
                this.mIsAttachedToInstance = false;
            } else {
                throw null;
            }
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public ReactRootView(Context context, boolean z) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = z;
        init();
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        startReactApplication(reactInstanceManager, str, bundle, null);
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }
}
