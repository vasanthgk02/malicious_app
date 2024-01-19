package androidx.window.layout;

import android.app.Activity;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/ExtensionsWindowLayoutInfoAdapter;", "", "()V", "translate", "Landroidx/window/layout/FoldingFeature;", "activity", "Landroid/app/Activity;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "info", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtensionsWindowLayoutInfoAdapter.kt */
public final class ExtensionsWindowLayoutInfoAdapter {
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.window.layout.FoldingFeature translate$window_release(android.app.Activity r16, androidx.window.extensions.layout.FoldingFeature r17) {
        /*
            r0 = r16
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r2 = "oemFeature"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            int r2 = r17.getType()
            r4 = 0
            r5 = 1
            r6 = 2
            if (r2 == r5) goto L_0x001d
            if (r2 == r6) goto L_0x001a
            return r4
        L_0x001a:
            androidx.window.layout.HardwareFoldingFeature$Type r2 = androidx.window.layout.HardwareFoldingFeature.Type.HINGE
            goto L_0x001f
        L_0x001d:
            androidx.window.layout.HardwareFoldingFeature$Type r2 = androidx.window.layout.HardwareFoldingFeature.Type.FOLD
        L_0x001f:
            int r7 = r17.getState()
            if (r7 == r5) goto L_0x002b
            if (r7 == r6) goto L_0x0028
            return r4
        L_0x0028:
            androidx.window.layout.FoldingFeature$State r4 = androidx.window.layout.FoldingFeature.State.HALF_OPENED
            goto L_0x002d
        L_0x002b:
            androidx.window.layout.FoldingFeature$State r4 = androidx.window.layout.FoldingFeature.State.FLAT
        L_0x002d:
            android.graphics.Rect r6 = r17.getBounds()
            java.lang.String r7 = "oemFeature.bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.String r8 = "rect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            int r9 = r6.left
            int r10 = r6.top
            int r11 = r6.right
            int r6 = r6.bottom
            androidx.window.layout.WindowMetricsCalculatorCompat r12 = androidx.window.layout.WindowMetricsCalculatorCompat.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            int r13 = android.os.Build.VERSION.SDK_INT
            r14 = 30
            r15 = 0
            if (r13 < r14) goto L_0x0055
            android.graphics.Rect r0 = androidx.window.layout.ActivityCompatHelperApi30.currentWindowBounds(r16)
            goto L_0x0144
        L_0x0055:
            r14 = 29
            if (r13 < r14) goto L_0x00b1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            android.content.res.Resources r1 = r16.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            java.lang.Class<android.content.res.Configuration> r13 = android.content.res.Configuration.class
            java.lang.String r14 = "windowConfiguration"
            java.lang.reflect.Field r13 = r13.getDeclaredField(r14)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            r13.setAccessible(r5)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.Object r1 = r13.get(r1)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.Class r5 = r1.getClass()     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.String r13 = "getBounds"
            java.lang.Class[] r14 = new java.lang.Class[r15]     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r13, r14)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            android.graphics.Rect r13 = new android.graphics.Rect     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.Object[] r14 = new java.lang.Object[r15]     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.Object r1 = r5.invoke(r1, r14)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            if (r1 == 0) goto L_0x0091
            android.graphics.Rect r1 = (android.graphics.Rect) r1     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            r13.<init>(r1)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            r0 = r13
            goto L_0x0144
        L_0x0091:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            java.lang.String r5 = "null cannot be cast to non-null type android.graphics.Rect"
            r1.<init>(r5)     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
            throw r1     // Catch:{ NoSuchFieldException -> 0x00ab, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x009f, InvocationTargetException -> 0x0099 }
        L_0x0099:
            android.graphics.Rect r0 = r12.computeWindowBoundsP$window_release(r0)
            goto L_0x0144
        L_0x009f:
            android.graphics.Rect r0 = r12.computeWindowBoundsP$window_release(r0)
            goto L_0x0144
        L_0x00a5:
            android.graphics.Rect r0 = r12.computeWindowBoundsP$window_release(r0)
            goto L_0x0144
        L_0x00ab:
            android.graphics.Rect r0 = r12.computeWindowBoundsP$window_release(r0)
            goto L_0x0144
        L_0x00b1:
            r5 = 28
            if (r13 < r5) goto L_0x00bb
            android.graphics.Rect r0 = r12.computeWindowBoundsP$window_release(r0)
            goto L_0x0144
        L_0x00bb:
            r5 = 24
            java.lang.String r14 = "point"
            java.lang.String r15 = "display"
            java.lang.String r3 = "defaultDisplay"
            if (r13 < r5) goto L_0x010e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.view.WindowManager r13 = r16.getWindowManager()
            android.view.Display r13 = r13.getDefaultDisplay()
            r13.getRectSize(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            boolean r1 = r16.isInMultiWindowMode()
            if (r1 != 0) goto L_0x010c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r15)
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            r13.getRealSize(r1)
            int r0 = r12.getNavigationBarHeight(r0)
            int r3 = r5.bottom
            int r3 = r3 + r0
            int r12 = r1.y
            if (r3 != r12) goto L_0x0103
            r5.bottom = r3
            goto L_0x010c
        L_0x0103:
            int r3 = r5.right
            int r3 = r3 + r0
            int r0 = r1.x
            if (r3 != r0) goto L_0x010c
            r5.right = r3
        L_0x010c:
            r0 = r5
            goto L_0x0144
        L_0x010e:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            android.view.WindowManager r0 = r16.getWindowManager()
            android.view.Display r0 = r0.getDefaultDisplay()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            r0.getRealSize(r1)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            int r5 = r1.x
            if (r5 == 0) goto L_0x0140
            int r1 = r1.y
            if (r1 != 0) goto L_0x013b
            goto L_0x0140
        L_0x013b:
            r3.right = r5
            r3.bottom = r1
            goto L_0x0143
        L_0x0140:
            r0.getRectSize(r3)
        L_0x0143:
            r0 = r3
        L_0x0144:
            java.lang.String r1 = "bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)
            int r1 = r0.left
            int r3 = r0.top
            int r5 = r0.right
            int r0 = r0.bottom
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>(r1, r3, r5, r0)
            int r6 = r6 - r10
            if (r6 != 0) goto L_0x0162
            int r0 = r11 - r9
            if (r0 != 0) goto L_0x0162
            r0 = 1
            goto L_0x0163
        L_0x0162:
            r0 = 0
        L_0x0163:
            if (r0 == 0) goto L_0x0166
            goto L_0x018d
        L_0x0166:
            int r11 = r11 - r9
            int r0 = r8.width()
            if (r11 == r0) goto L_0x0174
            int r0 = r8.height()
            if (r6 == r0) goto L_0x0174
            goto L_0x018d
        L_0x0174:
            int r0 = r8.width()
            if (r11 >= r0) goto L_0x0181
            int r0 = r8.height()
            if (r6 >= r0) goto L_0x0181
            goto L_0x018d
        L_0x0181:
            int r0 = r8.width()
            if (r11 != r0) goto L_0x018f
            int r0 = r8.height()
            if (r6 != r0) goto L_0x018f
        L_0x018d:
            r0 = 0
            goto L_0x0190
        L_0x018f:
            r0 = 1
        L_0x0190:
            if (r0 == 0) goto L_0x01a4
            androidx.window.layout.HardwareFoldingFeature r0 = new androidx.window.layout.HardwareFoldingFeature
            androidx.window.core.Bounds r1 = new androidx.window.core.Bounds
            android.graphics.Rect r3 = r17.getBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            r1.<init>(r3)
            r0.<init>(r1, r2, r4)
            goto L_0x01a5
        L_0x01a4:
            r0 = 0
        L_0x01a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.ExtensionsWindowLayoutInfoAdapter.translate$window_release(android.app.Activity, androidx.window.extensions.layout.FoldingFeature):androidx.window.layout.FoldingFeature");
    }

    public static final WindowLayoutInfo translate$window_release(Activity activity, WindowLayoutInfo windowLayoutInfo) {
        FoldingFeature foldingFeature;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(windowLayoutInfo, "info");
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        Intrinsics.checkNotNullExpressionValue(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature2 : displayFeatures) {
            if (foldingFeature2 instanceof FoldingFeature) {
                Intrinsics.checkNotNullExpressionValue(foldingFeature2, "feature");
                foldingFeature = translate$window_release(activity, foldingFeature2);
            } else {
                foldingFeature = null;
            }
            if (foldingFeature != null) {
                arrayList.add(foldingFeature);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }
}
