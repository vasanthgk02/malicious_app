package androidx.window.layout;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "()V", "TAG", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeMaximumWindowMetrics", "computeWindowBoundsIceCreamSandwich", "Landroid/graphics/Rect;", "computeWindowBoundsIceCreamSandwich$window_release", "computeWindowBoundsN", "computeWindowBoundsN$window_release", "computeWindowBoundsP", "computeWindowBoundsP$window_release", "computeWindowBoundsQ", "computeWindowBoundsQ$window_release", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRealSizeForDisplay$window_release", "getRectSizeFromDisplay", "", "bounds", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowMetricsCalculatorCompat.kt */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();
    public static final String TAG;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0148  */
    @android.annotation.SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Rect computeWindowBoundsP$window_release(android.app.Activity r11) {
        /*
            r10 = this;
            java.lang.String r0 = "displayCutout"
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.content.res.Resources r3 = r11.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            r4 = 1
            r5 = 0
            java.lang.Class<android.content.res.Configuration> r6 = android.content.res.Configuration.class
            java.lang.String r7 = "windowConfiguration"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            r6.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            boolean r6 = r11.isInMultiWindowMode()     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.String r7 = "null cannot be cast to non-null type android.graphics.Rect"
            if (r6 == 0) goto L_0x0050
            java.lang.Class r6 = r3.getClass()     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.String r8 = "getBounds"
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r8, r9)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.Object r3 = r6.invoke(r3, r8)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            if (r3 == 0) goto L_0x004a
            android.graphics.Rect r3 = (android.graphics.Rect) r3     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            r2.set(r3)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            goto L_0x009f
        L_0x004a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            r3.<init>(r7)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            throw r3     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
        L_0x0050:
            java.lang.Class r6 = r3.getClass()     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.String r8 = "getAppBounds"
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r8, r9)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            java.lang.Object r3 = r6.invoke(r3, r8)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            if (r3 == 0) goto L_0x006a
            android.graphics.Rect r3 = (android.graphics.Rect) r3     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            r2.set(r3)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            goto L_0x009f
        L_0x006a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            r3.<init>(r7)     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
            throw r3     // Catch:{ NoSuchFieldException -> 0x0094, NoSuchMethodException -> 0x0088, IllegalAccessException -> 0x007c, InvocationTargetException -> 0x0070 }
        L_0x0070:
            android.view.WindowManager r3 = r11.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            r3.getRectSize(r2)
            goto L_0x009f
        L_0x007c:
            android.view.WindowManager r3 = r11.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            r3.getRectSize(r2)
            goto L_0x009f
        L_0x0088:
            android.view.WindowManager r3 = r11.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            r3.getRectSize(r2)
            goto L_0x009f
        L_0x0094:
            android.view.WindowManager r3 = r11.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            r3.getRectSize(r2)
        L_0x009f:
            android.view.WindowManager r3 = r11.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>()
            java.lang.String r7 = "currentDisplay"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r7 = "display"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            java.lang.String r7 = "point"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            r3.getRealSize(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            boolean r7 = r11.isInMultiWindowMode()
            if (r7 != 0) goto L_0x00e5
            int r7 = r10.getNavigationBarHeight(r11)
            int r8 = r2.bottom
            int r8 = r8 + r7
            int r9 = r6.y
            if (r8 != r9) goto L_0x00d5
            r2.bottom = r8
            goto L_0x00e5
        L_0x00d5:
            int r8 = r2.right
            int r8 = r8 + r7
            int r9 = r6.x
            if (r8 != r9) goto L_0x00df
            r2.right = r8
            goto L_0x00e5
        L_0x00df:
            int r8 = r2.left
            if (r8 != r7) goto L_0x00e5
            r2.left = r5
        L_0x00e5:
            int r7 = r2.width()
            int r8 = r6.x
            if (r7 < r8) goto L_0x00f5
            int r7 = r2.height()
            int r8 = r6.y
            if (r7 >= r8) goto L_0x0196
        L_0x00f5:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            boolean r11 = r11.isInMultiWindowMode()
            if (r11 != 0) goto L_0x0196
            java.lang.String r11 = "android.view.DisplayInfo"
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.reflect.Constructor r11 = r11.getConstructor(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r11.setAccessible(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Object r11 = r11.newInstance(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Class r1 = r3.getClass()     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.String r7 = "getDisplayInfo"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Class r9 = r11.getClass()     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r8[r5] = r9     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r7, r8)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r1.setAccessible(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r7[r5] = r11     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r1.invoke(r3, r7)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Class r1 = r11.getClass()     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.reflect.Field r1 = r1.getDeclaredField(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            r1.setAccessible(r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            java.lang.Object r11 = r1.get(r11)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            boolean r1 = r11 instanceof android.view.DisplayCutout     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            if (r1 == 0) goto L_0x0145
            android.view.DisplayCutout r11 = (android.view.DisplayCutout) r11     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0145 }
            goto L_0x0146
        L_0x0145:
            r11 = 0
        L_0x0146:
            if (r11 == 0) goto L_0x0196
            int r1 = r2.left
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r3 = r11.getSafeInsetLeft()
            if (r1 != r3) goto L_0x0155
            r2.left = r5
        L_0x0155:
            int r1 = r6.x
            int r3 = r2.right
            int r1 = r1 - r3
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r3 = r11.getSafeInsetRight()
            if (r1 != r3) goto L_0x016f
            int r1 = r2.right
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r3 = r11.getSafeInsetRight()
            int r1 = r1 + r3
            r2.right = r1
        L_0x016f:
            int r1 = r2.top
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r3 = r11.getSafeInsetTop()
            if (r1 != r3) goto L_0x017c
            r2.top = r5
        L_0x017c:
            int r1 = r6.y
            int r3 = r2.bottom
            int r1 = r1 - r3
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r3 = r11.getSafeInsetBottom()
            if (r1 != r3) goto L_0x0196
            int r1 = r2.bottom
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r11 = r11.getSafeInsetBottom()
            int r1 = r1 + r11
            r2.bottom = r1
        L_0x0196:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowMetricsCalculatorCompat.computeWindowBoundsP$window_release(android.app.Activity):android.graphics.Rect");
    }

    public final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
