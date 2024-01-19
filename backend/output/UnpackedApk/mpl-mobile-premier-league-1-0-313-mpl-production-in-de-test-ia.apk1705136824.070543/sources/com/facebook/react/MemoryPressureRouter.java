package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class MemoryPressureRouter implements ComponentCallbacks2 {
    public final Set<MemoryPressureListener> mListeners = Collections.synchronizedSet(new LinkedHashSet());

    public MemoryPressureRouter(Context context) {
        context.getApplicationContext().registerComponentCallbacks(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        Set<MemoryPressureListener> set = this.mListeners;
        for (MemoryPressureListener handleMemoryPressure : (MemoryPressureListener[]) set.toArray(new MemoryPressureListener[set.size()])) {
            handleMemoryPressure.handleMemoryPressure(i);
        }
    }
}