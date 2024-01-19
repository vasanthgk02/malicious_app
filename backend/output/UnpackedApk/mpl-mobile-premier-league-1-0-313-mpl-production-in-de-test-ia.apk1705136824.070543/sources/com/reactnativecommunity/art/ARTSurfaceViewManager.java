package com.reactnativecommunity.art;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@ReactModule(name = "ARTSurfaceView")
public class ARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, ARTSurfaceViewShadowNode> {
    public static final YogaMeasureFunction MEASURE_FUNCTION = new YogaMeasureFunction() {
        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            throw new IllegalStateException("SurfaceView should have explicit width and height set");
        }
    };
    public static final String REACT_CLASS = "ARTSurfaceView";

    public String getName() {
        return "ARTSurfaceView";
    }

    public Class<ARTSurfaceViewShadowNode> getShadowNodeClass() {
        return ARTSurfaceViewShadowNode.class;
    }

    public void setBackgroundColor(ARTSurfaceView aRTSurfaceView, int i) {
    }

    public ARTSurfaceViewShadowNode createShadowNodeInstance() {
        ARTSurfaceViewShadowNode aRTSurfaceViewShadowNode = new ARTSurfaceViewShadowNode();
        aRTSurfaceViewShadowNode.setMeasureFunction(MEASURE_FUNCTION);
        return aRTSurfaceViewShadowNode;
    }

    public ARTSurfaceView createViewInstance(ThemedReactContext themedReactContext) {
        return new ARTSurfaceView(themedReactContext);
    }

    public void updateExtraData(ARTSurfaceView aRTSurfaceView, Object obj) {
        ARTSurfaceViewShadowNode aRTSurfaceViewShadowNode = (ARTSurfaceViewShadowNode) obj;
        if (aRTSurfaceViewShadowNode != null) {
            SurfaceTexture surfaceTexture = aRTSurfaceView.getSurfaceTexture();
            aRTSurfaceView.setSurfaceTextureListener(aRTSurfaceViewShadowNode);
            if (surfaceTexture != null && aRTSurfaceViewShadowNode.mSurface == null) {
                aRTSurfaceViewShadowNode.mSurface = new Surface(surfaceTexture);
                aRTSurfaceViewShadowNode.drawOutput(true);
                return;
            }
            return;
        }
        throw null;
    }
}
