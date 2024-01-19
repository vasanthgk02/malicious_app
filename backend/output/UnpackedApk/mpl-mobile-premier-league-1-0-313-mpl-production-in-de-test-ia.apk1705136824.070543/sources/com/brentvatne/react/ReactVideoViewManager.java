package com.brentvatne.react;

import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.brentvatne.react.ReactVideoView.Events;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.yqritc.scalablevideoview.ScalableType;
import java.util.Map;

public class ReactVideoViewManager extends SimpleViewManager<ReactVideoView> {
    public static final String PROP_CONTROLS = "controls";
    public static final String PROP_FULLSCREEN = "fullscreen";
    public static final String PROP_MUTED = "muted";
    public static final String PROP_PAUSED = "paused";
    public static final String PROP_PLAY_IN_BACKGROUND = "playInBackground";
    public static final String PROP_PROGRESS_UPDATE_INTERVAL = "progressUpdateInterval";
    public static final String PROP_RATE = "rate";
    public static final String PROP_REPEAT = "repeat";
    public static final String PROP_RESIZE_MODE = "resizeMode";
    public static final String PROP_SEEK = "seek";
    public static final String PROP_SRC = "src";
    public static final String PROP_SRC_HEADERS = "requestHeaders";
    public static final String PROP_SRC_IS_ASSET = "isAsset";
    public static final String PROP_SRC_IS_NETWORK = "isNetwork";
    public static final String PROP_SRC_MAINVER = "mainVer";
    public static final String PROP_SRC_PATCHVER = "patchVer";
    public static final String PROP_SRC_TYPE = "type";
    public static final String PROP_SRC_URI = "uri";
    public static final String PROP_STEREO_PAN = "stereoPan";
    public static final String PROP_VOLUME = "volume";
    public static final String REACT_CLASS = "RCTVideo";

    public Map getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        for (Events events : Events.values()) {
            builder.put(events.toString(), ImageOriginUtils.of("registrationName", events.toString()));
        }
        return builder.build();
    }

    public Map getExportedViewConstants() {
        ScalableType scalableType = ScalableType.LEFT_TOP;
        String num = Integer.toString(5);
        ScalableType scalableType2 = ScalableType.FIT_XY;
        String num2 = Integer.toString(1);
        ScalableType scalableType3 = ScalableType.FIT_CENTER;
        String num3 = Integer.toString(3);
        ScalableType scalableType4 = ScalableType.CENTER_CROP;
        return ImageOriginUtils.of("ScaleNone", num, "ScaleToFill", num2, "ScaleAspectFit", num3, "ScaleAspectFill", Integer.toString(18));
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultBoolean = false, name = "controls")
    public void setControls(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setControls(z);
    }

    @ReactProp(defaultBoolean = false, name = "fullscreen")
    public void setFullscreen(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setFullscreen(z);
    }

    @ReactProp(defaultBoolean = false, name = "muted")
    public void setMuted(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setMutedModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = "paused")
    public void setPaused(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setPausedModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = "playInBackground")
    public void setPlayInBackground(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setPlayInBackground(z);
    }

    @ReactProp(defaultFloat = 250.0f, name = "progressUpdateInterval")
    public void setProgressUpdateInterval(ReactVideoView reactVideoView, float f2) {
        reactVideoView.setProgressUpdateInterval(f2);
    }

    @ReactProp(name = "rate")
    public void setRate(ReactVideoView reactVideoView, float f2) {
        reactVideoView.setRateModifier(f2);
    }

    @ReactProp(defaultBoolean = false, name = "repeat")
    public void setRepeat(ReactVideoView reactVideoView, boolean z) {
        reactVideoView.setRepeatModifier(z);
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ReactVideoView reactVideoView, String str) {
        reactVideoView.setResizeModeModifier(ScalableType.values()[Integer.parseInt(str)]);
    }

    @ReactProp(name = "seek")
    public void setSeek(ReactVideoView reactVideoView, float f2) {
        reactVideoView.seekTo(Math.round(f2 * 1000.0f));
    }

    @ReactProp(name = "src")
    public void setSrc(ReactVideoView reactVideoView, ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        int i = readableMap2.getInt(PROP_SRC_MAINVER);
        int i2 = readableMap2.getInt(PROP_SRC_PATCHVER);
        int i3 = i < 0 ? 0 : i;
        int i4 = i2 < 0 ? 0 : i2;
        if (i3 > 0) {
            reactVideoView.setSrc(readableMap2.getString("uri"), readableMap2.getString("type"), readableMap2.getBoolean(PROP_SRC_IS_NETWORK), readableMap2.getBoolean(PROP_SRC_IS_ASSET), readableMap2.getMap(PROP_SRC_HEADERS), i3, i4);
        } else {
            reactVideoView.setSrc(readableMap2.getString("uri"), readableMap2.getString("type"), readableMap2.getBoolean(PROP_SRC_IS_NETWORK), readableMap2.getBoolean(PROP_SRC_IS_ASSET), readableMap2.getMap(PROP_SRC_HEADERS), 0, 0);
        }
    }

    @ReactProp(name = "stereoPan")
    public void setStereoPan(ReactVideoView reactVideoView, float f2) {
        reactVideoView.setStereoPan(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "volume")
    public void setVolume(ReactVideoView reactVideoView, float f2) {
        reactVideoView.setVolumeModifier(f2);
    }

    public ReactVideoView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactVideoView(themedReactContext);
    }

    public void onDropViewInstance(ReactVideoView reactVideoView) {
        super.onDropViewInstance(reactVideoView);
        MediaController mediaController = reactVideoView.mediaController;
        if (mediaController != null) {
            mediaController.hide();
        }
        MediaPlayer mediaPlayer = reactVideoView.mMediaPlayer;
        if (mediaPlayer != null) {
            if (VERSION.SDK_INT >= 23) {
                mediaPlayer.setOnTimedMetaDataAvailableListener(null);
            }
            reactVideoView.mMediaPlayerValid = false;
            reactVideoView.mMediaPlayer.reset();
            reactVideoView.mMediaPlayer.release();
            reactVideoView.mMediaPlayer = null;
        }
        if (reactVideoView.mIsFullscreen) {
            reactVideoView.setFullscreen(false);
        }
        ThemedReactContext themedReactContext = reactVideoView.mThemedReactContext;
        if (themedReactContext != null) {
            themedReactContext.removeLifecycleEventListener(reactVideoView);
            reactVideoView.mThemedReactContext = null;
        }
    }
}
