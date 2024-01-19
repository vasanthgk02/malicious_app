package androidx.transition;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewUtils {
    public static final Property<View, Rect> CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") {
        public Object get(Object obj) {
            return ViewCompat.getClipBounds((View) obj);
        }

        public void set(Object obj, Object obj2) {
            ViewCompat.setClipBounds((View) obj, (Rect) obj2);
        }
    };
    public static final ViewUtilsBase IMPL;
    public static final Property<View, Float> TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") {
        public Object get(Object obj) {
            return Float.valueOf(ViewUtils.getTransitionAlpha((View) obj));
        }

        public void set(Object obj, Object obj2) {
            float floatValue = ((Float) obj2).floatValue();
            ViewUtils.IMPL.setTransitionAlpha((View) obj, floatValue);
        }
    };

    static {
        int i = VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (i >= 23) {
            IMPL = new ViewUtilsApi23();
        } else {
            IMPL = new ViewUtilsApi22();
        }
    }

    public static ViewOverlayImpl getOverlay(View view) {
        return new ViewOverlayApi18(view);
    }

    public static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static WindowIdImpl getWindowId(View view) {
        return new WindowIdApi18(view);
    }

    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }
}
