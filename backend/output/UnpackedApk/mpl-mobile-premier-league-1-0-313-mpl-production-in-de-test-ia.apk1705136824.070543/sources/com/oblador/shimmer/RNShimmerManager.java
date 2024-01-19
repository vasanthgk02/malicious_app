package com.oblador.shimmer;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNShimmerManager extends ViewGroupManager<RNShimmeringView> {
    public static final String REACT_CLASS = "RNShimmeringView";

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultBoolean = true, name = "animating")
    public void setAnimating(RNShimmeringView rNShimmeringView, boolean z) {
        rNShimmeringView.getBuilder().setAutoStart(z);
        rNShimmeringView.updateShimmer();
    }

    @ReactProp(defaultFloat = 0.5f, name = "shimmeringOpacity")
    public void setBaseOpacity(RNShimmeringView rNShimmeringView, float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        rNShimmeringView.getBuilder().setBaseAlpha(f2);
        rNShimmeringView.updateShimmer();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "shimmeringDirection")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDirection(com.oblador.shimmer.RNShimmeringView r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 3739(0xe9b, float:5.24E-42)
            r2 = 3
            r3 = 0
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L_0x003a
            r1 = 3089570(0x2f24a2, float:4.32941E-39)
            if (r0 == r1) goto L_0x0030
            r1 = 3317767(0x32a007, float:4.649182E-39)
            if (r0 == r1) goto L_0x0026
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            java.lang.String r0 = "right"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0044
            r8 = 3
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "left"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0044
            r8 = 1
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "down"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0044
            r8 = 2
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "up"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0044
            r8 = 0
            goto L_0x0045
        L_0x0044:
            r8 = -1
        L_0x0045:
            if (r8 == 0) goto L_0x0050
            if (r8 == r5) goto L_0x004f
            if (r8 == r4) goto L_0x004d
            r2 = 0
            goto L_0x0050
        L_0x004d:
            r2 = 1
            goto L_0x0050
        L_0x004f:
            r2 = 2
        L_0x0050:
            com.facebook.shimmer.Shimmer$Builder r8 = r7.getBuilder()
            r8.setDirection(r2)
            r7.updateShimmer()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.shimmer.RNShimmerManager.setDirection(com.oblador.shimmer.RNShimmeringView, java.lang.String):void");
    }

    @ReactProp(defaultInt = 1000, name = "duration")
    public void setDuration(RNShimmeringView rNShimmeringView, int i) {
        if (i < 0) {
            i = 0;
        }
        rNShimmeringView.getBuilder().setDuration((long) i);
        rNShimmeringView.updateShimmer();
    }

    @ReactProp(defaultFloat = 1.0f, name = "animationOpacity")
    public void setHighlightOpacity(RNShimmeringView rNShimmeringView, float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        rNShimmeringView.getBuilder().setHighlightAlpha(f2);
        rNShimmeringView.updateShimmer();
    }

    @ReactProp(defaultFloat = 0.0f, name = "intensity")
    public void setIntensity(RNShimmeringView rNShimmeringView, float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        rNShimmeringView.getBuilder().setIntensity(f2);
        rNShimmeringView.updateShimmer();
    }

    @ReactProp(defaultInt = 400, name = "pauseDuration")
    public void setPauseDuration(RNShimmeringView rNShimmeringView, int i) {
        if (i < 0) {
            i = 0;
        }
        rNShimmeringView.getBuilder().setRepeatDelay((long) i);
        rNShimmeringView.updateShimmer();
    }

    @ReactProp(defaultFloat = 0.0f, name = "tilt")
    public void setTilt(RNShimmeringView rNShimmeringView, int i) {
        rNShimmeringView.getBuilder().setTilt((float) i);
        rNShimmeringView.updateShimmer();
    }

    public RNShimmeringView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNShimmeringView(themedReactContext);
    }
}
