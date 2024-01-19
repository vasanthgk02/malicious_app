package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;

public final class PreFillType {
    public final Config config;
    public final int height;
    public final int weight;
    public final int width;

    public static class Builder {
    }

    static {
        Config config2 = Config.RGB_565;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (preFillType.height == 0 && preFillType.width == 0 && preFillType.weight == 0 && preFillType.config == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        throw null;
    }

    public String toString() {
        return "PreFillSize{width=0, height=0, config=null, weight=0}";
    }
}
