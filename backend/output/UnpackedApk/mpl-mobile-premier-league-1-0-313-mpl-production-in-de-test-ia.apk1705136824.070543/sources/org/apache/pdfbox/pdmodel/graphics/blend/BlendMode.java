package org.apache.pdfbox.pdmodel.graphics.blend;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public abstract class BlendMode {
    public static final Map<COSName, BlendMode> BLEND_MODES = createBlendModeMap();
    public static final SeparableBlendMode COLOR_BURN = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            if (f2 > 0.0f) {
                return 1.0f - Math.min(1.0f, (1.0f - f3) / f2);
            }
            return 0.0f;
        }
    };
    public static final SeparableBlendMode COLOR_DODGE = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            if (f2 < 1.0f) {
                return Math.min(1.0f, f3 / (1.0f - f2));
            }
            return 1.0f;
        }
    };
    public static final SeparableBlendMode COMPATIBLE;
    public static final SeparableBlendMode DARKEN = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return Math.min(f2, f3);
        }
    };
    public static final SeparableBlendMode DIFFERENCE = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return Math.abs(f3 - f2);
        }
    };
    public static final SeparableBlendMode EXCLUSION = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return (f3 + f2) - ((f3 * 2.0f) * f2);
        }
    };
    public static final SeparableBlendMode HARD_LIGHT = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return ((double) f2) <= 0.5d ? f3 * 2.0f * f2 : (((f2 + f3) - (f2 * f3)) * 2.0f) - 1.0f;
        }
    };
    public static final SeparableBlendMode LIGHTEN = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return Math.max(f2, f3);
        }
    };
    public static final SeparableBlendMode MULTIPLY = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return f2 * f3;
        }
    };
    public static final SeparableBlendMode NORMAL;
    public static final SeparableBlendMode OVERLAY = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return ((double) f3) <= 0.5d ? f3 * 2.0f * f2 : (((f2 + f3) - (f2 * f3)) * 2.0f) - 1.0f;
        }
    };
    public static final SeparableBlendMode SCREEN = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            return (f2 + f3) - (f2 * f3);
        }
    };
    public static final SeparableBlendMode SOFT_LIGHT = new SeparableBlendMode() {
        public float blendChannel(float f2, float f3) {
            if (((double) f2) <= 0.5d) {
                return f3 - ((1.0f - f3) * ((1.0f - (f2 * 2.0f)) * f3));
            }
            double d2 = (double) f3;
            return GeneratedOutlineSupport.outline3(d2 <= 0.25d ? ((((16.0f * f3) - 12.0f) * f3) + 4.0f) * f3 : (float) Math.sqrt(d2), f3, (f2 * 2.0f) - 1.0f, f3);
        }
    };

    static {
        AnonymousClass1 r0 = new SeparableBlendMode() {
            public float blendChannel(float f2, float f3) {
                return f2;
            }
        };
        NORMAL = r0;
        COMPATIBLE = r0;
    }

    public static Map<COSName, BlendMode> createBlendModeMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(COSName.NORMAL, NORMAL);
        hashMap.put(COSName.COMPATIBLE, COMPATIBLE);
        hashMap.put(COSName.MULTIPLY, MULTIPLY);
        hashMap.put(COSName.SCREEN, SCREEN);
        hashMap.put(COSName.OVERLAY, OVERLAY);
        hashMap.put(COSName.DARKEN, DARKEN);
        hashMap.put(COSName.LIGHTEN, LIGHTEN);
        hashMap.put(COSName.COLOR_DODGE, COLOR_DODGE);
        hashMap.put(COSName.COLOR_BURN, COLOR_BURN);
        hashMap.put(COSName.HARD_LIGHT, HARD_LIGHT);
        hashMap.put(COSName.SOFT_LIGHT, SOFT_LIGHT);
        hashMap.put(COSName.DIFFERENCE, DIFFERENCE);
        hashMap.put(COSName.EXCLUSION, EXCLUSION);
        return hashMap;
    }

    public static BlendMode getInstance(COSBase cOSBase) {
        BlendMode blendMode = null;
        if (cOSBase instanceof COSName) {
            blendMode = BLEND_MODES.get((COSName) cOSBase);
        } else if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            for (int i = 0; i < cOSArray.size(); i++) {
                blendMode = BLEND_MODES.get(cOSArray.get(i));
                if (blendMode != null) {
                    break;
                }
            }
        }
        if (blendMode != null) {
            return blendMode;
        }
        return COMPATIBLE;
    }
}
