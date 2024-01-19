package com.swmansion.rnscreens;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.Screen.WindowTraits;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J)\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b\"J\u001f\u0010#\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b$J\u001f\u0010%\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b&J\u001f\u0010'\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b(J)\u0010)\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b*J)\u0010+\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b,J)\u0010-\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b.R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/swmansion/rnscreens/ScreenWindowTraits;", "", "()V", "mDefaultStatusBarColor", "", "Ljava/lang/Integer;", "mDidSetNavigationBarAppearance", "", "mDidSetOrientation", "mDidSetStatusBarAppearance", "applyDidSetNavigationBarAppearance", "", "applyDidSetNavigationBarAppearance$react_native_screens_release", "applyDidSetOrientation", "applyDidSetOrientation$react_native_screens_release", "applyDidSetStatusBarAppearance", "applyDidSetStatusBarAppearance$react_native_screens_release", "checkTraitForScreen", "screen", "Lcom/swmansion/rnscreens/Screen;", "trait", "Lcom/swmansion/rnscreens/Screen$WindowTraits;", "childScreenWithTraitSet", "findParentWithTraitSet", "findScreenForTrait", "isColorLight", "color", "setColor", "activity", "Landroid/app/Activity;", "context", "Lcom/facebook/react/bridge/ReactContext;", "setColor$react_native_screens_release", "setHidden", "setHidden$react_native_screens_release", "setNavigationBarColor", "setNavigationBarColor$react_native_screens_release", "setNavigationBarHidden", "setNavigationBarHidden$react_native_screens_release", "setOrientation", "setOrientation$react_native_screens_release", "setStyle", "setStyle$react_native_screens_release", "setTranslucent", "setTranslucent$react_native_screens_release", "trySetWindowTraits", "trySetWindowTraits$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits {
    public static Integer mDefaultStatusBarColor;
    public static boolean mDidSetNavigationBarAppearance;
    public static boolean mDidSetOrientation;
    public static boolean mDidSetStatusBarAppearance;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0.mStatusBarHidden != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0.mStatusBarTranslucent != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r0.getStatusBarStyle() != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0.getStatusBarColor() != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r0.getScreenOrientation() != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r0.mNavigationBarHidden != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r0.getNavigationBarColor() != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r0.isStatusBarAnimated != null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean checkTraitForScreen(com.swmansion.rnscreens.Screen r0, com.swmansion.rnscreens.Screen.WindowTraits r1) {
        /*
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002f;
                case 2: goto L_0x0028;
                case 3: goto L_0x0023;
                case 4: goto L_0x001e;
                case 5: goto L_0x0019;
                case 6: goto L_0x0012;
                case 7: goto L_0x000d;
                default: goto L_0x0007;
            }
        L_0x0007:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x000d:
            java.lang.Boolean r0 = r0.mNavigationBarHidden
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x0012:
            java.lang.Integer r0 = r0.getNavigationBarColor()
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x0019:
            java.lang.Boolean r0 = r0.isStatusBarAnimated
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x001e:
            java.lang.Boolean r0 = r0.mStatusBarHidden
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x0023:
            java.lang.Boolean r0 = r0.mStatusBarTranslucent
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x0028:
            java.lang.String r0 = r0.getStatusBarStyle()
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x002f:
            java.lang.Integer r0 = r0.getStatusBarColor()
            if (r0 == 0) goto L_0x003e
            goto L_0x003c
        L_0x0036:
            java.lang.Integer r0 = r0.getScreenOrientation()
            if (r0 == 0) goto L_0x003e
        L_0x003c:
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.checkTraitForScreen(com.swmansion.rnscreens.Screen, com.swmansion.rnscreens.Screen$WindowTraits):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r0.mNavigationBarHidden != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r0.getNavigationBarColor() != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r0.isStatusBarAnimated != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r0.mStatusBarHidden != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r0.mStatusBarTranslucent != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r0.getStatusBarStyle() != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r0.getStatusBarColor() != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r0.getScreenOrientation() != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.swmansion.rnscreens.Screen childScreenWithTraitSet(com.swmansion.rnscreens.Screen r3, com.swmansion.rnscreens.Screen.WindowTraits r4) {
        /*
            if (r3 != 0) goto L_0x0004
            goto L_0x006d
        L_0x0004:
            com.swmansion.rnscreens.ScreenFragment r3 = r3.getFragment()
            if (r3 != 0) goto L_0x000c
            goto L_0x006d
        L_0x000c:
            java.util.List<com.swmansion.rnscreens.ScreenContainer<?>> r3 = r3.mChildScreenContainers
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x006d
            java.lang.Object r0 = r3.next()
            com.swmansion.rnscreens.ScreenContainer r0 = (com.swmansion.rnscreens.ScreenContainer) r0
            com.swmansion.rnscreens.Screen r0 = r0.getTopScreen()
            com.swmansion.rnscreens.Screen r1 = childScreenWithTraitSet(r0, r4)
            if (r1 == 0) goto L_0x0029
            return r1
        L_0x0029:
            if (r0 == 0) goto L_0x0012
            int r1 = r4.ordinal()
            r2 = 1
            switch(r1) {
                case 0: goto L_0x0062;
                case 1: goto L_0x005b;
                case 2: goto L_0x0054;
                case 3: goto L_0x004f;
                case 4: goto L_0x004a;
                case 5: goto L_0x0045;
                case 6: goto L_0x003e;
                case 7: goto L_0x0039;
                default: goto L_0x0033;
            }
        L_0x0033:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x0039:
            java.lang.Boolean r1 = r0.mNavigationBarHidden
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x003e:
            java.lang.Integer r1 = r0.getNavigationBarColor()
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0045:
            java.lang.Boolean r1 = r0.isStatusBarAnimated
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x004a:
            java.lang.Boolean r1 = r0.mStatusBarHidden
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x004f:
            java.lang.Boolean r1 = r0.mStatusBarTranslucent
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0054:
            java.lang.String r1 = r0.getStatusBarStyle()
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x005b:
            java.lang.Integer r1 = r0.getStatusBarColor()
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0062:
            java.lang.Integer r1 = r0.getScreenOrientation()
            if (r1 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r2 = 0
        L_0x006a:
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x006d:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.childScreenWithTraitSet(com.swmansion.rnscreens.Screen, com.swmansion.rnscreens.Screen$WindowTraits):com.swmansion.rnscreens.Screen");
    }

    public static final Screen findScreenForTrait(Screen screen, WindowTraits windowTraits) {
        Screen childScreenWithTraitSet = childScreenWithTraitSet(screen, windowTraits);
        if (childScreenWithTraitSet != null) {
            return childScreenWithTraitSet;
        }
        if (!checkTraitForScreen(screen, windowTraits)) {
            ViewParent container = screen.getContainer();
            while (true) {
                if (container == null) {
                    screen = null;
                    break;
                }
                if (container instanceof Screen) {
                    Screen screen2 = (Screen) container;
                    if (checkTraitForScreen(screen2, windowTraits)) {
                        screen = screen2;
                        break;
                    }
                }
                container = container.getParent();
            }
        }
        return screen;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static final void setColor$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        Integer num;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null && reactContext != null) {
            if (mDefaultStatusBarColor == null) {
                mDefaultStatusBarColor = Integer.valueOf(activity.getWindow().getStatusBarColor());
            }
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.COLOR);
            Screen findScreenForTrait2 = findScreenForTrait(screen, WindowTraits.ANIMATED);
            if (findScreenForTrait == null) {
                num = null;
            } else {
                num = findScreenForTrait.getStatusBarColor();
            }
            if (num == null) {
                num = mDefaultStatusBarColor;
            }
            boolean z = false;
            if (findScreenForTrait2 != null) {
                Boolean bool = findScreenForTrait2.isStatusBarAnimated;
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            UiThreadUtil.runOnUiThread(new ScreenWindowTraits$setColor$1(reactContext, activity, num, z));
        }
    }

    /* renamed from: setHidden$lambda-1  reason: not valid java name */
    public static final void m104setHidden$lambda1(boolean z, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsControllerCompat, "$controller");
        if (z) {
            windowInsetsControllerCompat.mImpl.hide(1);
        } else {
            windowInsetsControllerCompat.mImpl.show(1);
        }
    }

    public static final void setHidden$react_native_screens_release(Screen screen, Activity activity) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null) {
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.HIDDEN);
            boolean z = false;
            if (findScreenForTrait != null) {
                Boolean bool = findScreenForTrait.mStatusBarHidden;
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            Window window = activity.getWindow();
            UiThreadUtil.runOnUiThread(new Runnable(z, new WindowInsetsControllerCompat(window, window.getDecorView())) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ WindowInsetsControllerCompat f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ScreenWindowTraits.m104setHidden$lambda1(this.f$0, this.f$1);
                }
            });
        }
    }

    /* renamed from: setNavigationBarColor$lambda-2  reason: not valid java name */
    public static final void m105setNavigationBarColor$lambda2(Window window, int i) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        boolean z = true;
        if (((double) 1) - (((((double) Color.blue(i)) * 0.114d) + ((((double) Color.green(i)) * 0.587d) + (((double) Color.red(i)) * 0.299d))) / ((double) InvitationReply.EXPIRED)) >= 0.5d) {
            z = false;
        }
        windowInsetsControllerCompat.mImpl.setAppearanceLightNavigationBars(z);
    }

    public static final void setNavigationBarColor$react_native_screens_release(Screen screen, Activity activity) {
        Integer num;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.NAVIGATION_BAR_COLOR);
            if (findScreenForTrait == null) {
                num = null;
            } else {
                num = findScreenForTrait.getNavigationBarColor();
            }
            int navigationBarColor = num == null ? window.getNavigationBarColor() : num.intValue();
            UiThreadUtil.runOnUiThread(new Runnable(window, navigationBarColor) {
                public final /* synthetic */ Window f$0;
                public final /* synthetic */ int f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ScreenWindowTraits.m105setNavigationBarColor$lambda2(this.f$0, this.f$1);
                }
            });
            window.setNavigationBarColor(navigationBarColor);
        }
    }

    public static final void setNavigationBarHidden$react_native_screens_release(Screen screen, Activity activity) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.NAVIGATION_BAR_HIDDEN);
            boolean z = false;
            if (findScreenForTrait != null) {
                Boolean bool = findScreenForTrait.mNavigationBarHidden;
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            if (VERSION.SDK_INT >= 30) {
                b.setDecorFitsSystemWindows1(window, z);
            } else {
                View decorView = window.getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                decorView.setSystemUiVisibility(z ? systemUiVisibility & -1793 : systemUiVisibility | 1792);
            }
            if (z) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                windowInsetsControllerCompat.mImpl.hide(2);
                windowInsetsControllerCompat.mImpl.setSystemBarsBehavior(2);
            } else {
                new WindowInsetsControllerCompat(window, window.getDecorView()).mImpl.show(2);
            }
        }
    }

    public static final void setOrientation$react_native_screens_release(Screen screen, Activity activity) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null) {
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.ORIENTATION);
            int i = -1;
            if (findScreenForTrait != null) {
                Integer screenOrientation = findScreenForTrait.getScreenOrientation();
                if (screenOrientation != null) {
                    i = screenOrientation.intValue();
                }
            }
            activity.setRequestedOrientation(i);
        }
    }

    /* renamed from: setStyle$lambda-0  reason: not valid java name */
    public static final void m106setStyle$lambda0(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(str, "$style");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(activity.getWindow(), decorView);
        windowInsetsControllerCompat.mImpl.setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setStyle$react_native_screens_release(com.swmansion.rnscreens.Screen r1, android.app.Activity r2, com.facebook.react.bridge.ReactContext r3) {
        /*
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            if (r2 == 0) goto L_0x0029
            if (r3 == 0) goto L_0x0029
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r3 >= r0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            com.swmansion.rnscreens.Screen$WindowTraits r3 = com.swmansion.rnscreens.Screen.WindowTraits.STYLE
            com.swmansion.rnscreens.Screen r1 = findScreenForTrait(r1, r3)
            if (r1 != 0) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            java.lang.String r1 = r1.getStatusBarStyle()
            if (r1 != 0) goto L_0x0021
        L_0x001f:
            java.lang.String r1 = "light"
        L_0x0021:
            com.swmansion.rnscreens.-$$Lambda$f58sTl-wiJupb7mbVAcQQ35FeEk r3 = new com.swmansion.rnscreens.-$$Lambda$f58sTl-wiJupb7mbVAcQQ35FeEk
            r3.<init>(r2, r1)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r3)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setStyle$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity, com.facebook.react.bridge.ReactContext):void");
    }

    public static final void setTranslucent$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null && reactContext != null) {
            Screen findScreenForTrait = findScreenForTrait(screen, WindowTraits.TRANSLUCENT);
            boolean z = false;
            if (findScreenForTrait != null) {
                Boolean bool = findScreenForTrait.mStatusBarTranslucent;
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            UiThreadUtil.runOnUiThread(new ScreenWindowTraits$setTranslucent$1(reactContext, activity, z));
        }
    }

    public static final void trySetWindowTraits$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (mDidSetOrientation) {
            setOrientation$react_native_screens_release(screen, activity);
        }
        if (mDidSetStatusBarAppearance) {
            setColor$react_native_screens_release(screen, activity, reactContext);
            setStyle$react_native_screens_release(screen, activity, reactContext);
            setTranslucent$react_native_screens_release(screen, activity, reactContext);
            setHidden$react_native_screens_release(screen, activity);
        }
        if (mDidSetNavigationBarAppearance) {
            setNavigationBarColor$react_native_screens_release(screen, activity);
            setNavigationBarHidden$react_native_screens_release(screen, activity);
        }
    }
}
