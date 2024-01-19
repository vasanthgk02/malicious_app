package com.swmansion.rnscreens;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.swmansion.rnscreens.Screen.ActivityState;
import com.swmansion.rnscreens.Screen.ReplaceAnimation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001;B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0017J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0018H\u0017J\u001f\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0018H\u0017J\u001a\u0010'\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010\rH\u0017J\u001f\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0002\u0010$J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0018H\u0017J\u001a\u00105\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0018H\u0017J\u001c\u00109\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010:\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "Lcom/facebook/react/viewmanagers/RNSScreenManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setActivityState", "", "view", "activityState", "", "", "setCustomAnimationOnSwipe", "value", "", "setFullScreenSwipeEnabled", "setGestureEnabled", "gestureEnabled", "setGestureResponseDistance", "Lcom/facebook/react/bridge/ReadableMap;", "setHideKeyboardOnSwipe", "setHomeIndicatorHidden", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setNavigationBarColor", "navigationBarColor", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setNavigationBarHidden", "navigationBarHidden", "setPreventNativeDismiss", "setReplaceAnimation", "animation", "setScreenOrientation", "screenOrientation", "setStackAnimation", "setStackPresentation", "presentation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarColor", "statusBarColor", "setStatusBarHidden", "statusBarHidden", "setStatusBarStyle", "statusBarStyle", "setStatusBarTranslucent", "statusBarTranslucent", "setSwipeDirection", "setTransitionDuration", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "RNSScreen")
/* compiled from: ScreenViewManager.kt */
public final class ScreenViewManager extends ViewGroupManager<Screen> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSScreen";
    public final ViewManagerDelegate<Screen> mDelegate = new RNSScreenManagerDelegate(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenViewManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ViewManagerDelegate<Screen> getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map of = ImageOriginUtils.of("registrationName", "onDismissed");
        Map of2 = ImageOriginUtils.of("registrationName", "onWillAppear");
        Map of3 = ImageOriginUtils.of("registrationName", "onAppear");
        Map of4 = ImageOriginUtils.of("registrationName", "onWillDisappear");
        Map of5 = ImageOriginUtils.of("registrationName", "onDisappear");
        Map of6 = ImageOriginUtils.of("registrationName", "onHeaderBackButtonClicked");
        Map of7 = ImageOriginUtils.of("registrationName", "onTransitionProgress");
        HashMap hashMap = new HashMap();
        hashMap.put("topDismissed", of);
        hashMap.put("topWillAppear", of2);
        hashMap.put("topAppear", of3);
        hashMap.put("topWillDisappear", of4);
        hashMap.put("topDisappear", of5);
        hashMap.put("topHeaderBackButtonClickedEvent", of6);
        hashMap.put("topTransitionProgress", of7);
        Intrinsics.checkNotNullExpressionValue(hashMap, "of(\n            ScreenDi…itionProgress\")\n        )");
        return hashMap;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public void setCustomAnimationOnSwipe(Screen screen, boolean z) {
    }

    public void setFullScreenSwipeEnabled(Screen screen, boolean z) {
    }

    public void setGestureResponseDistance(Screen screen, ReadableMap readableMap) {
    }

    public void setHideKeyboardOnSwipe(Screen screen, boolean z) {
    }

    public void setHomeIndicatorHidden(Screen screen, boolean z) {
    }

    public void setPreventNativeDismiss(Screen screen, boolean z) {
    }

    public void setSwipeDirection(Screen screen, String str) {
    }

    public void setTransitionDuration(Screen screen, int i) {
    }

    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new Screen(themedReactContext);
    }

    public void setActivityState(Screen screen, float f2) {
        Intrinsics.checkNotNullParameter(screen, "view");
        setActivityState(screen, (int) f2);
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setGestureEnabled(z);
    }

    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNativeBackButtonDismissalEnabled(z);
    }

    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNavigationBarColor(num);
    }

    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNavigationBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(Screen screen, String str) {
        ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(screen, "view");
        if (str == null ? true : Intrinsics.areEqual(str, "pop")) {
            replaceAnimation = ReplaceAnimation.POP;
        } else if (Intrinsics.areEqual(str, "push")) {
            replaceAnimation = ReplaceAnimation.PUSH;
        } else {
            throw new JSApplicationIllegalArgumentException(Intrinsics.stringPlus("Unknown replace animation type ", str));
        }
        screen.setReplaceAnimation(replaceAnimation);
    }

    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setScreenOrientation(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r3.equals("flip") != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        if (r3.equals("simple_push") != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Unknown animation type ", r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r3.equals("default") != false) goto L_0x0078;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackAnimation(com.swmansion.rnscreens.Screen r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0078
            int r0 = r3.hashCode()
            switch(r0) {
                case -1418955385: goto L_0x0063;
                case -427095442: goto L_0x0058;
                case -349395819: goto L_0x004d;
                case 3135100: goto L_0x0042;
                case 3145837: goto L_0x0039;
                case 3387192: goto L_0x002e;
                case 182437661: goto L_0x0023;
                case 1544803905: goto L_0x001a;
                case 1601504978: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x006c
        L_0x000f:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_BOTTOM
            goto L_0x007a
        L_0x001a:
            java.lang.String r0 = "default"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            goto L_0x0078
        L_0x0023:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.FADE_FROM_BOTTOM
            goto L_0x007a
        L_0x002e:
            java.lang.String r0 = "none"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            goto L_0x007a
        L_0x0039:
            java.lang.String r0 = "flip"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            goto L_0x0078
        L_0x0042:
            java.lang.String r0 = "fade"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.FADE
            goto L_0x007a
        L_0x004d:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_RIGHT
            goto L_0x007a
        L_0x0058:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_LEFT
            goto L_0x007a
        L_0x0063:
            java.lang.String r0 = "simple_push"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006c
            goto L_0x0078
        L_0x006c:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r0 = "Unknown animation type "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r3)
            r2.<init>(r3)
            throw r2
        L_0x0078:
            com.swmansion.rnscreens.Screen$StackAnimation r3 = com.swmansion.rnscreens.Screen.StackAnimation.DEFAULT
        L_0x007a:
            r2.setStackAnimation(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r3.equals("containedModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r3.equals("modal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r3.equals("transparentModal") != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r3 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r2.setStackPresentation(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r3.equals("formSheet") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r3.equals("fullScreenModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r3.equals("containedTransparentModal") != false) goto L_0x0051;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackPresentation(com.swmansion.rnscreens.Screen r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0057
            int r0 = r3.hashCode()
            switch(r0) {
                case -76271493: goto L_0x0049;
                case 3452698: goto L_0x003e;
                case 104069805: goto L_0x0033;
                case 438078970: goto L_0x002a;
                case 955284238: goto L_0x0021;
                case 1171936146: goto L_0x0018;
                case 1798290171: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0057
        L_0x000f:
            java.lang.String r0 = "formSheet"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0018:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0021:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x0051
        L_0x002a:
            java.lang.String r0 = "containedModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0033:
            java.lang.String r0 = "modal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x003b:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L_0x0053
        L_0x003e:
            java.lang.String r0 = "push"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L_0x0053
        L_0x0049:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x0051:
            com.swmansion.rnscreens.Screen$StackPresentation r3 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L_0x0053:
            r2.setStackPresentation(r3)
            return
        L_0x0057:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r0 = "Unknown presentation type "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r3)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarAnimated(Boolean.valueOf(str != null && !Intrinsics.areEqual("none", str)));
    }

    @ReactProp(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarColor(num);
    }

    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarStyle(str);
    }

    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarTranslucent(Boolean.valueOf(z));
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "view");
        if (i != -1) {
            if (i == 0) {
                screen.setActivityState(ActivityState.INACTIVE);
            } else if (i == 1) {
                screen.setActivityState(ActivityState.TRANSITIONING_OR_BELOW_TOP);
            } else if (i == 2) {
                screen.setActivityState(ActivityState.ON_TOP);
            }
        }
    }
}
