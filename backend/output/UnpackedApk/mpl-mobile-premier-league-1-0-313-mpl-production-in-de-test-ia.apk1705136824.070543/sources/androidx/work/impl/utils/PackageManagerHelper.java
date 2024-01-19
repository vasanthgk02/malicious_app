package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class PackageManagerHelper {
    public static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z) {
        String str;
        String str2 = RNGestureHandlerModule.KEY_ENABLED;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str3 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            logger.debug(str3, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            Logger logger2 = Logger.get();
            String str4 = TAG;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            logger2.debug(str4, String.format("%s could not be %s", objArr2), e2);
        }
    }
}
