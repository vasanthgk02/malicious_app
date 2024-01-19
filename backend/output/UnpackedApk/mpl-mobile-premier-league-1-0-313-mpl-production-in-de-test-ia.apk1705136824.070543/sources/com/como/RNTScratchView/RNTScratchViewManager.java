package com.como.RNTScratchView;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.razorpay.AnalyticsConstants;
import java.util.Map;

public class RNTScratchViewManager extends SimpleViewManager<ScratchView> {
    public static final String EVENT_IMAGE_LOAD = "onImageLoadFinished";
    public static final String EVENT_SCRATCH_DONE = "onScratchDone";
    public static final String EVENT_SCRATCH_PROGRESS_CHANGED = "onScratchProgressChanged";
    public static final String EVENT_TOUCH_STATE_CHANGED = "onTouchStateChanged";
    public static final String REACT_CLASS = "RNTScratchView";

    public Map<String, Integer> getCommandsMap() {
        return ImageOriginUtils.of(AnalyticsConstants.RESET, Integer.valueOf(0));
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put(EVENT_IMAGE_LOAD, ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", EVENT_IMAGE_LOAD)));
        builder.put(EVENT_TOUCH_STATE_CHANGED, ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", EVENT_TOUCH_STATE_CHANGED)));
        builder.put(EVENT_SCRATCH_PROGRESS_CHANGED, ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", EVENT_SCRATCH_PROGRESS_CHANGED)));
        builder.put(EVENT_SCRATCH_DONE, ImageOriginUtils.of("phasedRegistrationNames", ImageOriginUtils.of("bubbled", EVENT_SCRATCH_DONE)));
        return builder.build();
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "brushSize")
    public void setBrushSize(ScratchView scratchView, float f2) {
        if (scratchView != null) {
            scratchView.setBrushSize(f2);
        }
    }

    @ReactProp(name = "imageUrl")
    public void setImageUrl(ScratchView scratchView, String str) {
        if (scratchView != null) {
            scratchView.setImageUrl(str);
        }
    }

    @ReactProp(name = "localImageName")
    public void setLocalImageName(ScratchView scratchView, String str) {
        if (scratchView != null) {
            scratchView.setResourceName(str);
        }
    }

    @ReactProp(name = "placeholderColor")
    public void setPlaceholderColor(ScratchView scratchView, String str) {
        if (scratchView != null) {
            scratchView.setPlaceholderColor(str);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ScratchView scratchView, String str) {
        if (scratchView != null) {
            scratchView.setResizeMode(str);
        }
    }

    @ReactProp(name = "resourceName")
    public void setResourceName(ScratchView scratchView, String str) {
        if (scratchView != null) {
            scratchView.setResourceName(str);
        }
    }

    @ReactProp(name = "threshold")
    public void setThreshold(ScratchView scratchView, float f2) {
        if (scratchView != null) {
            scratchView.setThreshold(f2);
        }
    }

    public ScratchView createViewInstance(ThemedReactContext themedReactContext) {
        return new ScratchView(themedReactContext);
    }

    public void receiveCommand(ScratchView scratchView, int i, ReadableArray readableArray) {
        super.receiveCommand(scratchView, i, readableArray);
        if (i == 0) {
            scratchView.reset();
        }
    }
}
