package io.hansel.core.base.utils;

import android.view.View;
import com.userexperior.e.h;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;

public class a {
    public static io.hansel.core.base.b.a a(View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return new io.hansel.core.base.b.a(iArr);
        }
        HSLLogger.e("Trying to get coordinates of null View.");
        return new io.hansel.core.base.b.a(null);
    }

    public static void a(View view, CoreJSONObject coreJSONObject) {
        try {
            io.hansel.core.base.b.a a2 = a(view);
            coreJSONObject.put((String) "x", HSLUtils.pxToDp((float) a2.a()));
            coreJSONObject.put((String) "y", HSLUtils.pxToDp((float) a2.b()));
            coreJSONObject.put((String) h.f3998a, HSLUtils.pxToDp((float) view.getHeight()));
            coreJSONObject.put((String) "w", HSLUtils.pxToDp((float) view.getWidth()));
            HSLLogger.d("Location on screen for element " + view.getClass().getName() + " is " + coreJSONObject, LogGroup.PT);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }
}
