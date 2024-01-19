package com.airbnb.lottie;

import androidx.collection.ArraySet;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    public boolean enabled = false;
    public final Set<FrameListener> frameListeners = new ArraySet(0);
    public final Map<String, MeanCalculator> layerRenderTimes = new HashMap();

    public interface FrameListener {
        void onFrameRendered(float f2);
    }
}
