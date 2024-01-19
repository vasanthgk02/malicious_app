package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.debug.FpsDebugFrameCallback.FpsInfo;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TreeMap;

@ReactModule(name = "AnimationsDebugModule")
public class AnimationsDebugModule extends NativeAnimationsDebugModuleSpec {
    public static final String NAME = "AnimationsDebugModule";
    public final DeveloperSettings mCatalystSettings;
    public FpsDebugFrameCallback mFrameCallback;

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, DeveloperSettings developerSettings) {
        super(reactApplicationContext);
        this.mCatalystSettings = developerSettings;
    }

    public String getName() {
        return NAME;
    }

    public void onCatalystInstanceDestroy() {
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            this.mFrameCallback = null;
        }
    }

    public void startRecordingFps() {
        DeveloperSettings developerSettings = this.mCatalystSettings;
        if (developerSettings != null && developerSettings.isAnimationFpsDebugEnabled()) {
            if (this.mFrameCallback == null) {
                FpsDebugFrameCallback fpsDebugFrameCallback = new FpsDebugFrameCallback(getReactApplicationContext());
                this.mFrameCallback = fpsDebugFrameCallback;
                if (fpsDebugFrameCallback != null) {
                    fpsDebugFrameCallback.mTimeToFps = new TreeMap<>();
                    fpsDebugFrameCallback.mIsRecordingFpsInfoAtEachFrame = true;
                    fpsDebugFrameCallback.mShouldStop = false;
                    fpsDebugFrameCallback.mReactContext.getCatalystInstance().addBridgeIdleDebugListener(fpsDebugFrameCallback.mDidJSUpdateUiDuringFrameDetector);
                    fpsDebugFrameCallback.mUIManagerModule.setViewHierarchyUpdateDebugListener(fpsDebugFrameCallback.mDidJSUpdateUiDuringFrameDetector);
                    UiThreadUtil.runOnUiThread(new Runnable(fpsDebugFrameCallback) {
                        public final /* synthetic */ FpsDebugFrameCallback val$fpsDebugFrameCallback;

                        {
                            this.val$fpsDebugFrameCallback = r2;
                        }

                        public void run() {
                            FpsDebugFrameCallback fpsDebugFrameCallback = FpsDebugFrameCallback.this;
                            UiThreadUtil.assertOnUiThread();
                            if (ChoreographerCompat.sInstance == null) {
                                ChoreographerCompat.sInstance = new ChoreographerCompat();
                            }
                            fpsDebugFrameCallback.mChoreographer = ChoreographerCompat.sInstance;
                            FpsDebugFrameCallback.this.mChoreographer.postFrameCallback(this.val$fpsDebugFrameCallback);
                        }
                    });
                    return;
                }
                throw null;
            }
            throw new JSApplicationCausedNativeException("Already recording FPS!");
        }
    }

    public void stopRecordingFps(double d2) {
        FpsInfo fpsInfo;
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            FpsDebugFrameCallback fpsDebugFrameCallback2 = this.mFrameCallback;
            ImageOriginUtils.assertNotNull(fpsDebugFrameCallback2.mTimeToFps, "FPS was not recorded at each frame!");
            Entry<Long, FpsInfo> floorEntry = fpsDebugFrameCallback2.mTimeToFps.floorEntry(Long.valueOf((long) d2));
            if (floorEntry == null) {
                fpsInfo = null;
            } else {
                fpsInfo = floorEntry.getValue();
            }
            if (fpsInfo == null) {
                Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
            } else {
                StringBuilder outline81 = GeneratedOutlineSupport.outline81(String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(fpsInfo.fps), Integer.valueOf(fpsInfo.totalFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)}), "\n", String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(fpsInfo.jsFps), Integer.valueOf(fpsInfo.totalJsFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)}), "\nTotal Time MS: ");
                outline81.append(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(fpsInfo.totalTimeMs)}));
                String sb = outline81.toString();
                FLog.d("ReactNative", sb);
                Toast.makeText(getReactApplicationContext(), sb, 1).show();
            }
            this.mFrameCallback = null;
        }
    }
}
