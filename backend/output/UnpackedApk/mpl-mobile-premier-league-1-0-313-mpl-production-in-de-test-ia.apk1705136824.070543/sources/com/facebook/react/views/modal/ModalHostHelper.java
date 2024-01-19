package com.facebook.react.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class ModalHostHelper {
    public static final Point MAX_POINT = new Point();
    public static final Point MIN_POINT = new Point();
    public static final Point SIZE_POINT = new Point();

    public static Point getModalHostSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        ImageOriginUtils.assertNotNull(windowManager);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(MIN_POINT, MAX_POINT);
        defaultDisplay.getSize(SIZE_POINT);
        int i = 0;
        boolean z = context.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (z && identifier > 0) {
            i = (int) resources.getDimension(identifier);
        }
        Point point = SIZE_POINT;
        if (point.x < point.y) {
            return new Point(MIN_POINT.x, MAX_POINT.y + i);
        }
        return new Point(MAX_POINT.x, MIN_POINT.y + i);
    }
}
