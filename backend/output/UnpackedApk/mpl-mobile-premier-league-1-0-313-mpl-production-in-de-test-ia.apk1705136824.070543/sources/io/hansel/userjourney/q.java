package io.hansel.userjourney;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.userexperior.e.h;
import io.hansel.core.base.b.a;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;

public class q {
    public static void a(View view, float f2) {
        view.setAlpha((float) Math.min(1.0d, (double) ((float) Math.max(0.0d, (double) f2))));
    }

    public static void a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void a(View view, CoreJSONObject coreJSONObject) {
        try {
            a a2 = io.hansel.core.base.utils.a.a(view);
            coreJSONObject.put((String) "x", a2.a());
            coreJSONObject.put((String) "y", a2.b());
            coreJSONObject.put((String) h.f3998a, view.getHeight());
            coreJSONObject.put((String) "w", view.getWidth());
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static void a(View view, CoreJSONObject coreJSONObject, double d2, double d3) {
        int i;
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int height = view.getHeight();
            int width = view.getWidth();
            if (d2 == -1.0d) {
                coreJSONObject.put((String) "anchorPointX", i2 + (width / 2));
                i = i3 + (height / 2);
            } else {
                coreJSONObject.put((String) "anchorPointX", i2 + ((int) ((((double) width) * d2) / 100.0d)));
                i = i3 + ((int) ((((double) height) * d3) / 100.0d));
            }
            coreJSONObject.put((String) "anchorPointY", i);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static void b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }
}
