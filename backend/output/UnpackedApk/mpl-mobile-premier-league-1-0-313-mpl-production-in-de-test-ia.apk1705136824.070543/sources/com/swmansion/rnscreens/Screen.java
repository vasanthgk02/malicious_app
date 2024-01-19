package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint({"ViewConstructor"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0005xyz{|B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020/J\u0016\u0010`\u001a\u00020^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020b0aH\u0014J\u0016\u0010c\u001a\u00020^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020b0aH\u0014J\u0010\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020fH\u0002J0\u0010g\u001a\u00020^2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0014J\u000e\u0010m\u001a\u00020^2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010n\u001a\u00020^2\u0006\u0010o\u001a\u00020/2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020^2\b\u0010G\u001a\u0004\u0018\u000105J\u000e\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u00020\u001bJ\u0018\u0010u\u001a\u00020^2\u0006\u0010v\u001a\u00020/2\u0006\u0010w\u001a\u00020/H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R(\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u000e\u0010-\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0004\n\u0002\u00100R\u0012\u00101\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u0012\u00102\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0004\n\u0002\u00100R\u0012\u00103\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u00107\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR(\u0010<\u001a\u0004\u0018\u00010/2\b\u0010<\u001a\u0004\u0018\u00010/8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010G\u001a\u0004\u0018\u00010/2\b\u0010\u0005\u001a\u0004\u0018\u00010/@BX\u000e¢\u0006\n\n\u0002\u00100\u001a\u0004\bH\u0010>R\u001a\u0010I\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010U\u001a\u0004\u0018\u00010/2\b\u0010U\u001a\u0004\u0018\u00010/8F@FX\u000e¢\u0006\f\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@R(\u0010X\u001a\u0004\u0018\u0001052\b\u0010X\u001a\u0004\u0018\u0001058F@FX\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006}"}, d2 = {"Lcom/swmansion/rnscreens/Screen;", "Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "<set-?>", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "activityState", "getActivityState", "()Lcom/swmansion/rnscreens/Screen$ActivityState;", "container", "Lcom/swmansion/rnscreens/ScreenContainer;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenContainer;", "setContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "fragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "getFragment", "()Lcom/swmansion/rnscreens/ScreenFragment;", "setFragment", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "headerConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "getHeaderConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "isGestureEnabled", "", "()Z", "setGestureEnabled", "(Z)V", "navigationBarHidden", "isNavigationBarHidden", "()Ljava/lang/Boolean;", "setNavigationBarHidden", "(Ljava/lang/Boolean;)V", "isStatusBarAnimated", "setStatusBarAnimated", "Ljava/lang/Boolean;", "statusBarHidden", "isStatusBarHidden", "setStatusBarHidden", "statusBarTranslucent", "isStatusBarTranslucent", "setStatusBarTranslucent", "mNativeBackButtonDismissalEnabled", "mNavigationBarColor", "", "Ljava/lang/Integer;", "mNavigationBarHidden", "mStatusBarColor", "mStatusBarHidden", "mStatusBarStyle", "", "mStatusBarTranslucent", "mTransitioning", "enableNativeBackButtonDismissal", "nativeBackButtonDismissalEnabled", "getNativeBackButtonDismissalEnabled", "setNativeBackButtonDismissalEnabled", "navigationBarColor", "getNavigationBarColor", "()Ljava/lang/Integer;", "setNavigationBarColor", "(Ljava/lang/Integer;)V", "replaceAnimation", "Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "getReplaceAnimation", "()Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "setReplaceAnimation", "(Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;)V", "screenOrientation", "getScreenOrientation", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "getStackAnimation", "()Lcom/swmansion/rnscreens/Screen$StackAnimation;", "setStackAnimation", "(Lcom/swmansion/rnscreens/Screen$StackAnimation;)V", "stackPresentation", "Lcom/swmansion/rnscreens/Screen$StackPresentation;", "getStackPresentation", "()Lcom/swmansion/rnscreens/Screen$StackPresentation;", "setStackPresentation", "(Lcom/swmansion/rnscreens/Screen$StackPresentation;)V", "statusBarColor", "getStatusBarColor", "setStatusBarColor", "statusBarStyle", "getStatusBarStyle", "()Ljava/lang/String;", "setStatusBarStyle", "(Ljava/lang/String;)V", "changeAccessibilityMode", "", "mode", "dispatchRestoreInstanceState", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "hasWebView", "viewGroup", "Landroid/view/ViewGroup;", "onLayout", "changed", "l", "t", "r", "b", "setActivityState", "setLayerType", "layerType", "paint", "Landroid/graphics/Paint;", "setScreenOrientation", "setTransitioning", "transitioning", "updateScreenSizePaper", "width", "height", "ActivityState", "ReplaceAnimation", "StackAnimation", "StackPresentation", "WindowTraits", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Screen.kt */
public final class Screen extends FabricEnabledViewGroup {
    public ActivityState activityState;
    public ScreenContainer<?> container;
    public ScreenFragment fragment;
    public Boolean isStatusBarAnimated;
    public boolean mNativeBackButtonDismissalEnabled = true;
    public Integer mNavigationBarColor;
    public Boolean mNavigationBarHidden;
    public Integer mStatusBarColor;
    public Boolean mStatusBarHidden;
    public String mStatusBarStyle;
    public Boolean mStatusBarTranslucent;
    public boolean mTransitioning;
    public ReplaceAnimation replaceAnimation = ReplaceAnimation.POP;
    public Integer screenOrientation;
    public StackAnimation stackAnimation = StackAnimation.DEFAULT;
    public StackPresentation stackPresentation = StackPresentation.PUSH;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ActivityState;", "", "(Ljava/lang/String;I)V", "INACTIVE", "TRANSITIONING_OR_BELOW_TOP", "ON_TOP", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "", "(Ljava/lang/String;I)V", "PUSH", "POP", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ReplaceAnimation {
        PUSH,
        POP
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackAnimation;", "", "(Ljava/lang/String;I)V", "DEFAULT", "NONE", "FADE", "SLIDE_FROM_BOTTOM", "SLIDE_FROM_RIGHT", "SLIDE_FROM_LEFT", "FADE_FROM_BOTTOM", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackPresentation;", "", "(Ljava/lang/String;I)V", "PUSH", "MODAL", "TRANSPARENT_MODAL", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$WindowTraits;", "", "(Ljava/lang/String;I)V", "ORIENTATION", "COLOR", "STYLE", "TRANSLUCENT", "HIDDEN", "ANIMATED", "NAVIGATION_BAR_COLOR", "NAVIGATION_BAR_HIDDEN", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum WindowTraits {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_HIDDEN
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new LayoutParams(2));
    }

    public final void changeAccessibilityMode(int i) {
        setImportantForAccessibility(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        CustomToolbar toolbar = headerConfig == null ? null : headerConfig.getToolbar();
        if (toolbar != null) {
            toolbar.setImportantForAccessibility(i);
        }
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "container");
    }

    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "container");
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final ScreenContainer<?> getContainer() {
        return this.container;
    }

    public final ScreenFragment getFragment() {
        return this.fragment;
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        View childAt = getChildAt(0);
        if (childAt instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) childAt;
        }
        return null;
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.mNativeBackButtonDismissalEnabled;
    }

    public final Integer getNavigationBarColor() {
        return this.mNavigationBarColor;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final Integer getStatusBarColor() {
        return this.mStatusBarColor;
    }

    public final String getStatusBarStyle() {
        return this.mStatusBarStyle;
    }

    public final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            Context context = getContext();
            if (context != null) {
                ReactContext reactContext = (ReactContext) context;
                reactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(reactContext, this, i5, i6));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        }
    }

    public final void setActivityState(ActivityState activityState2) {
        Intrinsics.checkNotNullParameter(activityState2, "activityState");
        if (activityState2 != this.activityState) {
            this.activityState = activityState2;
            ScreenContainer<?> screenContainer = this.container;
            if (screenContainer != null) {
                screenContainer.performUpdatesNow();
            }
        }
    }

    public final void setContainer(ScreenContainer<?> screenContainer) {
        this.container = screenContainer;
    }

    public final void setFragment(ScreenFragment screenFragment) {
        this.fragment = screenFragment;
    }

    public final void setGestureEnabled(boolean z) {
    }

    public void setLayerType(int i, Paint paint) {
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.mNativeBackButtonDismissalEnabled = z;
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.mDidSetNavigationBarAppearance = true;
        }
        this.mNavigationBarColor = num;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setNavigationBarColor$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.mDidSetNavigationBarAppearance = true;
        }
        this.mNavigationBarHidden = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setNavigationBarHidden$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation2) {
        Intrinsics.checkNotNullParameter(replaceAnimation2, "<set-?>");
        this.replaceAnimation = replaceAnimation2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setScreenOrientation(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0006
            r3 = 0
            r2.screenOrientation = r3
            return
        L_0x0006:
            r0 = 1
            com.swmansion.rnscreens.ScreenWindowTraits.mDidSetOrientation = r0
            int r1 = r3.hashCode()
            switch(r1) {
                case -1894896954: goto L_0x006f;
                case 96673: goto L_0x005f;
                case 729267099: goto L_0x0050;
                case 1430647483: goto L_0x0041;
                case 1651658175: goto L_0x0033;
                case 1730732811: goto L_0x0023;
                case 2118770584: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x007f
        L_0x0012:
            java.lang.String r0 = "landscape_right"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x001c
            goto L_0x007f
        L_0x001c:
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x0023:
            java.lang.String r0 = "landscape_left"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x002c
            goto L_0x007f
        L_0x002c:
            r3 = 8
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x0033:
            java.lang.String r1 = "portrait_up"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003c
            goto L_0x007f
        L_0x003c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            goto L_0x0084
        L_0x0041:
            java.lang.String r0 = "landscape"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x004a
            goto L_0x007f
        L_0x004a:
            r3 = 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x0050:
            java.lang.String r0 = "portrait"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0059
            goto L_0x007f
        L_0x0059:
            r3 = 7
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x005f:
            java.lang.String r0 = "all"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0068
            goto L_0x007f
        L_0x0068:
            r3 = 10
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x006f:
            java.lang.String r0 = "portrait_down"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0078
            goto L_0x007f
        L_0x0078:
            r3 = 9
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0084
        L_0x007f:
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0084:
            r2.screenOrientation = r3
            com.swmansion.rnscreens.ScreenFragment r3 = r2.fragment
            if (r3 != 0) goto L_0x008b
            goto L_0x0092
        L_0x008b:
            android.app.Activity r3 = r3.tryGetActivity()
            com.swmansion.rnscreens.ScreenWindowTraits.setOrientation$react_native_screens_release(r2, r3)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void setStackAnimation(StackAnimation stackAnimation2) {
        Intrinsics.checkNotNullParameter(stackAnimation2, "<set-?>");
        this.stackAnimation = stackAnimation2;
    }

    public final void setStackPresentation(StackPresentation stackPresentation2) {
        Intrinsics.checkNotNullParameter(stackPresentation2, "<set-?>");
        this.stackPresentation = stackPresentation2;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.mDidSetStatusBarAppearance = true;
        }
        this.mStatusBarColor = num;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setColor$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.mDidSetStatusBarAppearance = true;
        }
        this.mStatusBarHidden = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setHidden$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.mDidSetStatusBarAppearance = true;
        }
        this.mStatusBarStyle = str;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setStyle$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.mDidSetStatusBarAppearance = true;
        }
        this.mStatusBarTranslucent = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.setTranslucent$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            boolean hasWebView = hasWebView(this);
            int i = 2;
            if (!hasWebView || getLayerType() == 2) {
                if (!z || hasWebView) {
                    i = 0;
                }
                super.setLayerType(i, null);
            }
        }
    }
}
