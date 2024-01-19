package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveDeleteMultiMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePaddingMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements UIManager, LifecycleEventListener {
    public static final boolean ENABLE_FABRIC_LOGS = false;
    public long mBatchedExecutionTime;
    public long mCommitStartTime;
    public int mCurrentSynchronousCommitNumber;
    public volatile boolean mDestroyed;
    public long mDispatchViewUpdatesTime;
    public long mFinishTransactionCPPTime;
    public long mFinishTransactionTime;
    public long mLayoutTime;
    public long mRunStartTime;

    static {
        Printer printer = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.FABRIC_UI_MANAGER;
        FabricSoLoader.staticInit();
    }

    @DoNotStrip
    private MountItem createBatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        return new BatchMountItem(mountItemArr, i, i2);
    }

    @DoNotStrip
    private MountItem createMountItem(String str, ReadableMap readableMap, Object obj, int i, int i2, boolean z) {
        String str2 = FabricComponents.sComponentNames.get(str);
        throw null;
    }

    @DoNotStrip
    private MountItem deleteMountItem(int i) {
        return new DeleteMountItem(i);
    }

    @DoNotStrip
    private MountItem insertMountItem(int i, int i2, int i3) {
        return new InsertMountItem(i, i2, i3);
    }

    @DoNotStrip
    private long measure(int i, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5) {
        return measure(i, str, readableMap, readableMap2, readableMap3, f2, f3, f4, f5, null);
    }

    @DoNotStrip
    private void preallocateView(int i, int i2, String str, ReadableMap readableMap, Object obj, boolean z) {
        throw null;
    }

    @DoNotStrip
    private MountItem removeDeleteMultiMountItem(int[] iArr) {
        return new RemoveDeleteMultiMountItem(iArr);
    }

    @DoNotStrip
    private MountItem removeMountItem(int i, int i2, int i3) {
        return new RemoveMountItem(i, i2, i3);
    }

    @DoNotStrip
    private void scheduleMountItem(MountItem mountItem, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        if (mountItem instanceof BatchMountItem) {
            this.mCommitStartTime = j;
            this.mLayoutTime = j5 - j4;
            this.mFinishTransactionCPPTime = j7 - j6;
            this.mFinishTransactionTime = SystemClock.uptimeMillis() - j6;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        throw null;
    }

    @DoNotStrip
    private MountItem updateEventEmitterMountItem(int i, Object obj) {
        return new UpdateEventEmitterMountItem(i, (EventEmitterWrapper) obj);
    }

    @DoNotStrip
    private MountItem updateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        UpdateLayoutMountItem updateLayoutMountItem = new UpdateLayoutMountItem(i, i2, i3, i4, i5, i6);
        return updateLayoutMountItem;
    }

    @DoNotStrip
    private MountItem updateLocalDataMountItem(int i, ReadableMap readableMap) {
        return new UpdateLocalDataMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updatePaddingMountItem(int i, int i2, int i3, int i4, int i5) {
        UpdatePaddingMountItem updatePaddingMountItem = new UpdatePaddingMountItem(i, i2, i3, i4, i5);
        return updatePaddingMountItem;
    }

    @DoNotStrip
    private MountItem updatePropsMountItem(int i, ReadableMap readableMap) {
        return new UpdatePropsMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateStateMountItem(int i, Object obj) {
        return new UpdateStateMountItem(i, (StateWrapper) obj);
    }

    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        ReactRootViewTagGenerator.getNextRootViewTag();
        new ThemedReactContext(null, t.getContext(), ((ReactRoot) t).getSurfaceID());
        throw null;
    }

    @DoNotStrip
    public void clearJSResponder() {
        throw null;
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        throw null;
    }

    public Object getEventDispatcher() {
        return null;
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    public void initialize() {
        new FabricEventEmitter(this);
        throw null;
    }

    public void onCatalystInstanceDestroy() {
        if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(4)) {
            ((FLogDefaultLoggingDelegate) FLog.sHandler).println(4, "FabricUIManager", "FabricUIManager.onCatalystInstanceDestroy");
        }
        if (this.mDestroyed) {
            ReactSoftException.logSoftException("FabricUIManager", new IllegalStateException("Cannot double-destroy FabricUIManager"));
        } else {
            this.mDestroyed = true;
            throw null;
        }
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(CallbackType.DISPATCH_UI, null);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(CallbackType.DISPATCH_UI, null);
    }

    @DoNotStrip
    public void onRequestEventBeat() {
        throw null;
    }

    public void profileNextBatch() {
    }

    public void sendAccessibilityEvent(int i, int i2) {
        throw null;
    }

    @DoNotStrip
    public void setJSResponder(int i, int i2, boolean z) {
        throw null;
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
        int i2;
        String str;
        ReactMarkerConstants reactMarkerConstants;
        UiThreadUtil.assertOnUiThread();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i3 + 1;
        String str2 = null;
        try {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, null, i3);
            if (ENABLE_FABRIC_LOGS) {
                FLog.d("FabricUIManager", "SynchronouslyUpdateViewOnUIThread for tag %d", Integer.valueOf(i));
            }
            MountItem updatePropsMountItem = updatePropsMountItem(i, readableMap);
            int i4 = i3;
            str = "FabricUIManager";
            try {
                scheduleMountItem(updatePropsMountItem, i3, uptimeMillis, 0, 0, 0, 0, 0, 0);
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                i2 = i4;
                str2 = null;
            } catch (Exception e2) {
                e = e2;
                i2 = i4;
                str2 = null;
                try {
                    ReactSoftException.logSoftException(str, new ReactNoCrashSoftException("Caught exception in synchronouslyUpdateViewOnUIThread", e));
                    reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                    ReactMarker.logFabricMarker(reactMarkerConstants, str2, i2);
                } catch (Throwable th) {
                    th = th;
                    ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = i4;
                str2 = null;
                ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            i2 = i3;
            str = "FabricUIManager";
            ReactSoftException.logSoftException(str, new ReactNoCrashSoftException("Caught exception in synchronouslyUpdateViewOnUIThread", e));
            reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
            ReactMarker.logFabricMarker(reactMarkerConstants, str2, i2);
        } catch (Throwable th3) {
            th = th3;
            i2 = i3;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i2);
            throw th;
        }
        ReactMarker.logFabricMarker(reactMarkerConstants, str2, i2);
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        if (ENABLE_FABRIC_LOGS) {
            FLog.d("FabricUIManager", "Updating Root Layout Specs");
        }
        throw null;
    }

    @DoNotStrip
    private long measure(int i, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5, int[] iArr) {
        if (i < 0) {
            ImageOriginUtils.getYogaSize(f2, f3);
            ImageOriginUtils.getYogaMeasureMode(f2, f3);
            ImageOriginUtils.getYogaSize(f4, f5);
            ImageOriginUtils.getYogaMeasureMode(f4, f5);
            throw null;
        }
        throw null;
    }

    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        throw null;
    }
}
