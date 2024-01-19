package androidx.window.layout;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.window.core.AndroidLogger;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer.VerificationMode;
import androidx.window.core.ValidSpecification;
import androidx.window.layout.FoldingFeature.State;
import androidx.window.layout.HardwareFoldingFeature.Type;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.userexperior.models.recording.enums.UeCustomType;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\f\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0010\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "(Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "isEqualSidecarDeviceState", "", "first", "Landroidx/window/sidecar/SidecarDeviceState;", "second", "isEqualSidecarDisplayFeature", "Landroidx/window/sidecar/SidecarDisplayFeature;", "isEqualSidecarDisplayFeatures", "", "isEqualSidecarWindowLayoutInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "translate", "Landroidx/window/layout/DisplayFeature;", "feature", "deviceState", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", "state", "sidecarDisplayFeatures", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidecarAdapter.kt */
public final class SidecarAdapter {
    public final VerificationMode verificationMode;

    public SidecarAdapter(VerificationMode verificationMode2, int i) {
        VerificationMode verificationMode3 = (i & 1) != 0 ? VerificationMode.QUIET : null;
        Intrinsics.checkNotNullParameter(verificationMode3, "verificationMode");
        this.verificationMode = verificationMode3;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static final int getRawSidecarDevicePosture(SidecarDeviceState sidecarDeviceState) {
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
        try {
            return sidecarDeviceState.posture;
        } catch (NoSuchFieldError unused) {
            Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            return 0;
        }
    }

    public static final int getSidecarDevicePosture$window_release(SidecarDeviceState sidecarDeviceState) {
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
        int rawSidecarDevicePosture = getRawSidecarDevicePosture(sidecarDeviceState);
        if (rawSidecarDevicePosture < 0 || rawSidecarDevicePosture > 4) {
            return 0;
        }
        return rawSidecarDevicePosture;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return kotlin.collections.EmptyList.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[ExcHandler: IllegalAccessException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:8:0x0011] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.window.sidecar.SidecarDisplayFeature> getSidecarDisplayFeatures(androidx.window.sidecar.SidecarWindowLayoutInfo r4) {
        /*
            java.lang.String r0 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r0 = r4.displayFeatures     // Catch:{ NoSuchFieldError -> 0x000c }
            if (r0 != 0) goto L_0x000b
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE     // Catch:{ NoSuchFieldError -> 0x000c }
        L_0x000b:
            return r0
        L_0x000c:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r0 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r1 = "getDisplayFeatures"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            java.lang.Object r4 = r0.invoke(r4, r1)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            if (r4 == 0) goto L_0x0022
            java.util.List r4 = (java.util.List) r4     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            return r4
        L_0x0022:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r4.<init>(r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
            throw r4     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x002a }
        L_0x002a:
            kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarAdapter.getSidecarDisplayFeatures(androidx.window.sidecar.SidecarWindowLayoutInfo):java.util.List");
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static final void setSidecarDevicePosture(SidecarDeviceState sidecarDeviceState, int i) {
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
        try {
            sidecarDeviceState.posture = i;
        } catch (NoSuchFieldError unused) {
            Class<SidecarDeviceState> cls = SidecarDeviceState.class;
            try {
                cls.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(sidecarDeviceState, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }
    }

    public final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (Intrinsics.areEqual(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return Intrinsics.areEqual(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean isEqualSidecarDisplayFeatures(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (!isEqualSidecarDisplayFeature(list.get(i), list2.get(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public final WindowLayoutInfo translate(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(EmptyList.INSTANCE);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        setSidecarDevicePosture(sidecarDeviceState2, getSidecarDevicePosture$window_release(sidecarDeviceState));
        return new WindowLayoutInfo(translate(getSidecarDisplayFeatures(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final DisplayFeature translate$window_release(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        Type type;
        State state;
        Intrinsics.checkNotNullParameter(sidecarDisplayFeature, "feature");
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "deviceState");
        Intrinsics.checkNotNullExpressionValue("SidecarAdapter", UeCustomType.TAG);
        VerificationMode verificationMode2 = this.verificationMode;
        AndroidLogger androidLogger = AndroidLogger.INSTANCE;
        Intrinsics.checkNotNullParameter(sidecarDisplayFeature, "<this>");
        Intrinsics.checkNotNullParameter("SidecarAdapter", InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(verificationMode2, "verificationMode");
        Intrinsics.checkNotNullParameter(androidLogger, "logger");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) new ValidSpecification(sidecarDisplayFeature, "SidecarAdapter", verificationMode2, androidLogger).require("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).require("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).require("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).require("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).compute();
        HardwareFoldingFeature hardwareFoldingFeature = null;
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type2 = sidecarDisplayFeature2.getType();
        if (type2 == 1) {
            type = Type.FOLD;
        } else if (type2 != 2) {
            return null;
        } else {
            type = Type.HINGE;
        }
        int sidecarDevicePosture$window_release = getSidecarDevicePosture$window_release(sidecarDeviceState);
        if (!(sidecarDevicePosture$window_release == 0 || sidecarDevicePosture$window_release == 1)) {
            if (sidecarDevicePosture$window_release == 2) {
                state = State.HALF_OPENED;
            } else if (sidecarDevicePosture$window_release == 3) {
                state = State.FLAT;
            } else if (sidecarDevicePosture$window_release != 4) {
                state = State.FLAT;
            }
            Rect rect = sidecarDisplayFeature.getRect();
            Intrinsics.checkNotNullExpressionValue(rect, "feature.rect");
            hardwareFoldingFeature = new HardwareFoldingFeature(new Bounds(rect), type, state);
        }
        return hardwareFoldingFeature;
    }

    public final List<DisplayFeature> translate(List<SidecarDisplayFeature> list, SidecarDeviceState sidecarDeviceState) {
        Intrinsics.checkNotNullParameter(list, "sidecarDisplayFeatures");
        Intrinsics.checkNotNullParameter(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        for (SidecarDisplayFeature translate$window_release : list) {
            DisplayFeature translate$window_release2 = translate$window_release(translate$window_release, sidecarDeviceState);
            if (translate$window_release2 != null) {
                arrayList.add(translate$window_release2);
            }
        }
        return arrayList;
    }
}
