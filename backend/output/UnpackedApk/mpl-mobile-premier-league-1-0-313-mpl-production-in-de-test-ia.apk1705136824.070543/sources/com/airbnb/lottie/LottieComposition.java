package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.smartfoxserver.bitswarm.util.Logging;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LottieComposition {
    public Rect bounds;
    public SparseArrayCompat<FontCharacter> characters;
    public float endFrame;
    public Map<String, Font> fonts;
    public float frameRate;
    public boolean hasDashPattern;
    public Map<String, LottieImageAsset> images;
    public LongSparseArray<Layer> layerMap;
    public List<Layer> layers;
    public List<Marker> markers;
    public int maskAndMatteCount = 0;
    public final PerformanceTracker performanceTracker = new PerformanceTracker();
    public Map<String, List<Layer>> precomps;
    public float startFrame;
    public final HashSet<String> warnings = new HashSet<>();

    public void addWarning(String str) {
        Logger.warning(str);
        this.warnings.add(str);
    }

    public float getDuration() {
        return (float) ((long) ((getDurationFrames() / this.frameRate) * 1000.0f));
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r4.substring(0, r4.length() - 1).equalsIgnoreCase(r8) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.airbnb.lottie.model.Marker getMarker(java.lang.String r8) {
        /*
            r7 = this;
            java.util.List<com.airbnb.lottie.model.Marker> r0 = r7.markers
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x003f
            java.util.List<com.airbnb.lottie.model.Marker> r3 = r7.markers
            java.lang.Object r3 = r3.get(r2)
            com.airbnb.lottie.model.Marker r3 = (com.airbnb.lottie.model.Marker) r3
            java.lang.String r4 = r3.name
            boolean r4 = r4.equalsIgnoreCase(r8)
            r5 = 1
            if (r4 == 0) goto L_0x001c
            goto L_0x0039
        L_0x001c:
            java.lang.String r4 = r3.name
            java.lang.String r6 = "\r"
            boolean r4 = r4.endsWith(r6)
            if (r4 == 0) goto L_0x0038
            java.lang.String r4 = r3.name
            int r6 = r4.length()
            int r6 = r6 - r5
            java.lang.String r4 = r4.substring(r1, r6)
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            if (r5 == 0) goto L_0x003c
            return r3
        L_0x003c:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x003f:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.getMarker(java.lang.String):com.airbnb.lottie.model.Marker");
    }

    public Layer layerModelForId(long j) {
        return (Layer) this.layerMap.get(j, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.layers) {
            sb.append(layer.toString(Logging.TAB));
        }
        return sb.toString();
    }
}
