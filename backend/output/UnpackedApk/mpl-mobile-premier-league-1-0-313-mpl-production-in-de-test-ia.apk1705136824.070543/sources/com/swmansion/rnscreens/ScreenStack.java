package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ABB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J \u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020$H\u0014J\f\u00105\u001a\u00060\bR\u00020\u0000H\u0002J\b\u00106\u001a\u00020$H\u0016J\u0006\u00107\u001a\u00020$J\u0014\u00108\u001a\u00020$2\n\u00109\u001a\u00060\bR\u00020\u0000H\u0002J\b\u0010:\u001a\u00020$H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0002R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0015j\b\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006C"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "goingForward", "", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "isDetachingCurrentScreen", "mDismissed", "", "mRemovalTransitionStarted", "mStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTopScreen", "previousChildrenCount", "", "reverseLastTwoChildren", "rootScreen", "Lcom/swmansion/rnscreens/Screen;", "getRootScreen", "()Lcom/swmansion/rnscreens/Screen;", "topScreen", "getTopScreen", "adapt", "screen", "dismiss", "", "screenFragment", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchOnFinishTransitioning", "drawAndRelease", "drawChild", "child", "Landroid/view/View;", "drawingTime", "", "endViewTransition", "view", "hasScreen", "Lcom/swmansion/rnscreens/ScreenFragment;", "notifyContainerUpdate", "obtainDrawingOp", "onUpdate", "onViewAppearTransitionEnd", "performDraw", "op", "removeAllScreens", "removeScreenAt", "index", "removeView", "startViewTransition", "turnOffA11yUnderTransparentScreen", "visibleBottom", "Companion", "DrawingOp", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenStack.kt */
public final class ScreenStack extends ScreenContainer<ScreenStackFragment> {
    public static final Companion Companion = new Companion(null);
    public final List<DrawingOp> drawingOpPool = new ArrayList();
    public List<DrawingOp> drawingOps = new ArrayList();
    public boolean goingForward;
    public boolean isDetachingCurrentScreen;
    public final Set<ScreenStackFragment> mDismissed = new HashSet();
    public boolean mRemovalTransitionStarted;
    public final ArrayList<ScreenStackFragment> mStack = new ArrayList<>();
    public ScreenStackFragment mTopScreen;
    public int previousChildrenCount;
    public boolean reverseLastTwoChildren;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "()V", "isTransparent", "", "fragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "needsDrawReordering", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenStack.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J)\u0010\u0017\u001a\u00060\u0000R\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "set", "Lcom/swmansion/rnscreens/ScreenStack;", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenStack.kt */
    public final class DrawingOp {
        public Canvas canvas;
        public View child;
        public long drawingTime;
        public final /* synthetic */ ScreenStack this$0;

        public DrawingOp(ScreenStack screenStack) {
            Intrinsics.checkNotNullParameter(screenStack, "this$0");
            this.this$0 = screenStack;
        }
    }

    public ScreenStack(Context context) {
        super(context);
    }

    public static final void access$performDraw(ScreenStack screenStack, DrawingOp drawingOp) {
        if (screenStack != null) {
            super.drawChild(drawingOp.canvas, drawingOp.child, drawingOp.drawingTime);
            return;
        }
        throw null;
    }

    /* renamed from: onUpdate$lambda-2$lambda-1  reason: not valid java name */
    public static final void m102onUpdate$lambda2$lambda1(ScreenStackFragment screenStackFragment) {
        if (screenStackFragment != null) {
            screenStackFragment.getScreen().bringToFront();
        }
    }

    public ScreenFragment adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.drawingOps.size() < this.previousChildrenCount) {
            this.reverseLastTwoChildren = false;
        }
        this.previousChildrenCount = this.drawingOps.size();
        if (this.reverseLastTwoChildren && this.drawingOps.size() >= 2) {
            List<DrawingOp> list = this.drawingOps;
            Collections.swap(list, list.size() - 1, this.drawingOps.size() - 2);
        }
        List<DrawingOp> list2 = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp next : list2) {
            access$performDraw(next.this$0, next);
            next.canvas = null;
            next.child = null;
            next.drawingTime = 0;
            this.drawingOpPool.add(next);
        }
    }

    public final void dispatchOnFinishTransitioning() {
        Context context = getContext();
        if (context != null) {
            EventDispatcher eventDispatcherForReactTag = ImageOriginUtils.getEventDispatcherForReactTag((ReactContext) context, getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(getId()));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        DrawingOp drawingOp;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        List<DrawingOp> list = this.drawingOps;
        if (this.drawingOpPool.isEmpty()) {
            drawingOp = new DrawingOp(this);
        } else {
            List<DrawingOp> list2 = this.drawingOpPool;
            drawingOp = list2.remove(list2.size() - 1);
        }
        drawingOp.canvas = canvas;
        drawingOp.child = view;
        drawingOp.drawingTime = j;
        list.add(drawingOp);
        return true;
    }

    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        if (this.mRemovalTransitionStarted) {
            this.mRemovalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        int i = 0;
        while (i < screenCount) {
            int i2 = i + 1;
            Screen screenAt = getScreenAt(i);
            if (!ArraysKt___ArraysJvmKt.contains(this.mDismissed, screenAt.getFragment())) {
                return screenAt;
            }
            i = i2;
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    public Screen getTopScreen() {
        ScreenStackFragment screenStackFragment = this.mTopScreen;
        if (screenStackFragment == null) {
            return null;
        }
        return screenStackFragment.getScreen();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return ArraysKt___ArraysJvmKt.contains(this.mScreenFragments, screenFragment) && !ArraysKt___ArraysJvmKt.contains(this.mDismissed, screenFragment);
    }

    public void notifyContainerUpdate() {
        for (ScreenStackFragment screen : this.mStack) {
            ScreenStackHeaderConfig headerConfig = screen.getScreen().getHeaderConfig();
            if (headerConfig != null) {
                headerConfig.onUpdate();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0191  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpdate() {
        /*
            r9 = this;
            r0 = 0
            r9.isDetachingCurrentScreen = r0
            java.util.ArrayList<T> r1 = r9.mScreenFragments
            int r1 = r1.size()
            int r1 = r1 + -1
            r2 = 0
            r3 = 1
            r4 = r2
            r5 = r4
            if (r1 < 0) goto L_0x0044
        L_0x0011:
            int r6 = r1 + -1
            java.util.ArrayList<T> r7 = r9.mScreenFragments
            java.lang.Object r1 = r7.get(r1)
            java.lang.String r7 = "mScreenFragments[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            com.swmansion.rnscreens.ScreenStackFragment r1 = (com.swmansion.rnscreens.ScreenStackFragment) r1
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r9.mDismissed
            boolean r7 = r7.contains(r1)
            if (r7 != 0) goto L_0x003f
            if (r4 != 0) goto L_0x002c
            r4 = r1
            goto L_0x002d
        L_0x002c:
            r5 = r1
        L_0x002d:
            com.swmansion.rnscreens.Screen r1 = r1.getScreen()
            com.swmansion.rnscreens.Screen$StackPresentation r1 = r1.getStackPresentation()
            com.swmansion.rnscreens.Screen$StackPresentation r7 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
            if (r1 != r7) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r1 != 0) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            if (r6 >= 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r1 = r6
            goto L_0x0011
        L_0x0044:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r9.mStack
            boolean r1 = kotlin.collections.ArraysKt___ArraysJvmKt.contains(r1, r4)
            if (r1 != 0) goto L_0x0096
            com.swmansion.rnscreens.ScreenStackFragment r1 = r9.mTopScreen
            if (r1 == 0) goto L_0x008b
            if (r4 == 0) goto L_0x008b
            if (r1 != 0) goto L_0x0056
        L_0x0054:
            r1 = 0
            goto L_0x005f
        L_0x0056:
            java.util.ArrayList<T> r6 = r9.mScreenFragments
            boolean r1 = r6.contains(r1)
            if (r1 != r3) goto L_0x0054
            r1 = 1
        L_0x005f:
            com.swmansion.rnscreens.Screen r6 = r4.getScreen()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r6 = r6.getReplaceAnimation()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r7 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            if (r6 != r7) goto L_0x006d
            r6 = 1
            goto L_0x006e
        L_0x006d:
            r6 = 0
        L_0x006e:
            if (r1 != 0) goto L_0x0075
            if (r6 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r1 = 0
            goto L_0x0076
        L_0x0075:
            r1 = 1
        L_0x0076:
            if (r1 == 0) goto L_0x0081
            com.swmansion.rnscreens.Screen r2 = r4.getScreen()
        L_0x007c:
            com.swmansion.rnscreens.Screen$StackAnimation r2 = r2.getStackAnimation()
            goto L_0x00b1
        L_0x0081:
            com.swmansion.rnscreens.ScreenStackFragment r6 = r9.mTopScreen
            if (r6 != 0) goto L_0x0086
            goto L_0x00b1
        L_0x0086:
            com.swmansion.rnscreens.Screen r2 = r6.getScreen()
            goto L_0x007c
        L_0x008b:
            com.swmansion.rnscreens.ScreenStackFragment r1 = r9.mTopScreen
            if (r1 != 0) goto L_0x00b0
            if (r4 == 0) goto L_0x00b0
            com.swmansion.rnscreens.Screen$StackAnimation r2 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            r9.goingForward = r3
            goto L_0x00b0
        L_0x0096:
            com.swmansion.rnscreens.ScreenStackFragment r1 = r9.mTopScreen
            if (r1 == 0) goto L_0x00b0
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 != 0) goto L_0x00b0
            com.swmansion.rnscreens.ScreenStackFragment r1 = r9.mTopScreen
            if (r1 != 0) goto L_0x00a5
            goto L_0x00ae
        L_0x00a5:
            com.swmansion.rnscreens.Screen r1 = r1.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            r2 = r1
        L_0x00ae:
            r1 = 0
            goto L_0x00b1
        L_0x00b0:
            r1 = 1
        L_0x00b1:
            androidx.fragment.app.FragmentTransaction r6 = r9.createTransaction()
            if (r2 == 0) goto L_0x0136
            if (r1 == 0) goto L_0x00f9
            int r2 = r2.ordinal()
            switch(r2) {
                case 0: goto L_0x00f1;
                case 1: goto L_0x00eb;
                case 2: goto L_0x00e3;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00db;
                case 5: goto L_0x00d3;
                case 6: goto L_0x00c2;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            goto L_0x0136
        L_0x00c2:
            int r2 = com.swmansion.rnscreens.R$anim.rns_fade_from_bottom
            int r7 = com.swmansion.rnscreens.R$anim.rns_no_animation_350
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00cb:
            int r2 = com.swmansion.rnscreens.R$anim.rns_slide_in_from_bottom
            int r7 = com.swmansion.rnscreens.R$anim.rns_no_animation_medium
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00d3:
            int r2 = com.swmansion.rnscreens.R$anim.rns_slide_in_from_left
            int r7 = com.swmansion.rnscreens.R$anim.rns_slide_out_to_right
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00db:
            int r2 = com.swmansion.rnscreens.R$anim.rns_slide_in_from_right
            int r7 = com.swmansion.rnscreens.R$anim.rns_slide_out_to_left
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00e3:
            int r2 = com.swmansion.rnscreens.R$anim.rns_fade_in
            int r7 = com.swmansion.rnscreens.R$anim.rns_fade_out
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00eb:
            int r2 = com.swmansion.rnscreens.R$anim.rns_no_animation_20
            r6.setCustomAnimations(r2, r2)
            goto L_0x0136
        L_0x00f1:
            int r2 = com.swmansion.rnscreens.R$anim.rns_default_enter_in
            int r7 = com.swmansion.rnscreens.R$anim.rns_default_enter_out
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x00f9:
            int r2 = r2.ordinal()
            switch(r2) {
                case 0: goto L_0x012f;
                case 1: goto L_0x0129;
                case 2: goto L_0x0121;
                case 3: goto L_0x0109;
                case 4: goto L_0x0119;
                case 5: goto L_0x0111;
                case 6: goto L_0x0101;
                default: goto L_0x0100;
            }
        L_0x0100:
            goto L_0x0136
        L_0x0101:
            int r2 = com.swmansion.rnscreens.R$anim.rns_no_animation_250
            int r7 = com.swmansion.rnscreens.R$anim.rns_fade_to_bottom
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x0109:
            int r2 = com.swmansion.rnscreens.R$anim.rns_no_animation_medium
            int r7 = com.swmansion.rnscreens.R$anim.rns_slide_out_to_bottom
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x0111:
            int r2 = com.swmansion.rnscreens.R$anim.rns_slide_in_from_right
            int r7 = com.swmansion.rnscreens.R$anim.rns_slide_out_to_left
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x0119:
            int r2 = com.swmansion.rnscreens.R$anim.rns_slide_in_from_left
            int r7 = com.swmansion.rnscreens.R$anim.rns_slide_out_to_right
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x0121:
            int r2 = com.swmansion.rnscreens.R$anim.rns_fade_in
            int r7 = com.swmansion.rnscreens.R$anim.rns_fade_out
            r6.setCustomAnimations(r2, r7)
            goto L_0x0136
        L_0x0129:
            int r2 = com.swmansion.rnscreens.R$anim.rns_no_animation_20
            r6.setCustomAnimations(r2, r2)
            goto L_0x0136
        L_0x012f:
            int r2 = com.swmansion.rnscreens.R$anim.rns_default_exit_in
            int r7 = com.swmansion.rnscreens.R$anim.rns_default_exit_out
            r6.setCustomAnimations(r2, r7)
        L_0x0136:
            r9.setGoingForward(r1)
            if (r1 == 0) goto L_0x015f
            if (r4 == 0) goto L_0x015f
            com.swmansion.rnscreens.Screen r1 = r4.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            com.swmansion.rnscreens.Screen$StackAnimation r2 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_BOTTOM
            if (r1 == r2) goto L_0x0158
            com.swmansion.rnscreens.Screen r1 = r4.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r1 = r1.getStackAnimation()
            com.swmansion.rnscreens.Screen$StackAnimation r2 = com.swmansion.rnscreens.Screen.StackAnimation.FADE_FROM_BOTTOM
            if (r1 != r2) goto L_0x0156
            goto L_0x0158
        L_0x0156:
            r1 = 0
            goto L_0x0159
        L_0x0158:
            r1 = 1
        L_0x0159:
            if (r1 == 0) goto L_0x015f
            if (r5 != 0) goto L_0x015f
            r9.isDetachingCurrentScreen = r3
        L_0x015f:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r9.mStack
            java.util.Iterator r1 = r1.iterator()
        L_0x0165:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0185
            java.lang.Object r2 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r2 = (com.swmansion.rnscreens.ScreenStackFragment) r2
            java.util.ArrayList<T> r7 = r9.mScreenFragments
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto L_0x0181
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r9.mDismissed
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto L_0x0165
        L_0x0181:
            r6.remove(r2)
            goto L_0x0165
        L_0x0185:
            java.util.ArrayList<T> r1 = r9.mScreenFragments
            java.util.Iterator r1 = r1.iterator()
        L_0x018b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01a8
            java.lang.Object r2 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r2 = (com.swmansion.rnscreens.ScreenStackFragment) r2
            if (r2 != r5) goto L_0x019a
            goto L_0x01a8
        L_0x019a:
            if (r2 == r4) goto L_0x018b
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r9.mDismissed
            boolean r7 = r7.contains(r2)
            if (r7 != 0) goto L_0x018b
            r6.remove(r2)
            goto L_0x018b
        L_0x01a8:
            if (r5 == 0) goto L_0x01d9
            boolean r1 = r5.isAdded()
            if (r1 != 0) goto L_0x01d9
            java.util.ArrayList<T> r1 = r9.mScreenFragments
            java.util.Iterator r1 = r1.iterator()
            r2 = 1
        L_0x01b7:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01e8
            java.lang.Object r7 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r7 = (com.swmansion.rnscreens.ScreenStackFragment) r7
            if (r2 == 0) goto L_0x01c8
            if (r7 != r5) goto L_0x01b7
            r2 = 0
        L_0x01c8:
            int r8 = r9.getId()
            androidx.fragment.app.FragmentTransaction r7 = r6.add(r8, r7)
            com.swmansion.rnscreens.-$$Lambda$r0fEOUvZvFO_Z24qQi-HpUY8GlI r8 = new com.swmansion.rnscreens.-$$Lambda$r0fEOUvZvFO_Z24qQi-HpUY8GlI
            r8.<init>()
            r7.runOnCommit(r8)
            goto L_0x01b7
        L_0x01d9:
            if (r4 == 0) goto L_0x01e8
            boolean r1 = r4.isAdded()
            if (r1 != 0) goto L_0x01e8
            int r1 = r9.getId()
            r6.add(r1, r4)
        L_0x01e8:
            r9.mTopScreen = r4
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r9.mStack
            r1.clear()
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r1 = r9.mStack
            java.util.ArrayList<T> r2 = r9.mScreenFragments
            r1.addAll(r2)
            java.util.ArrayList<T> r1 = r9.mScreenFragments
            int r1 = r1.size()
            if (r1 <= r3) goto L_0x024d
            if (r5 == 0) goto L_0x024d
            com.swmansion.rnscreens.ScreenStackFragment r1 = r9.mTopScreen
            if (r1 != 0) goto L_0x0205
            goto L_0x024d
        L_0x0205:
            com.swmansion.rnscreens.Screen r1 = r1.getScreen()
            com.swmansion.rnscreens.Screen$StackPresentation r1 = r1.getStackPresentation()
            com.swmansion.rnscreens.Screen$StackPresentation r2 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
            if (r1 != r2) goto L_0x0213
            r1 = 1
            goto L_0x0214
        L_0x0213:
            r1 = 0
        L_0x0214:
            if (r1 == 0) goto L_0x024d
            java.util.ArrayList<T> r1 = r9.mScreenFragments
            int r2 = r1.size()
            int r2 = r2 - r3
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt___RangesKt.until(r0, r2)
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.slice(r1, r2)
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.collections.ReversedListReadOnly r2 = new kotlin.collections.ReversedListReadOnly
            r2.<init>(r1)
            java.util.Iterator r1 = r2.iterator()
        L_0x0233:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x024d
            java.lang.Object r2 = r1.next()
            com.swmansion.rnscreens.ScreenStackFragment r2 = (com.swmansion.rnscreens.ScreenStackFragment) r2
            com.swmansion.rnscreens.Screen r3 = r2.getScreen()
            r4 = 4
            r3.changeAccessibilityMode(r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r2 == 0) goto L_0x0233
        L_0x024d:
            com.swmansion.rnscreens.Screen r1 = r9.getTopScreen()
            if (r1 != 0) goto L_0x0254
            goto L_0x0257
        L_0x0254:
            r1.changeAccessibilityMode(r0)
        L_0x0257:
            r6.commitNowAllowingStateLoss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.onUpdate():void");
    }

    public void removeAllScreens() {
        this.mDismissed.clear();
        super.removeAllScreens();
    }

    public void removeScreenAt(int i) {
        this.mDismissed.remove(((ScreenFragment) this.mScreenFragments.get(i)).getScreen().getFragment());
        super.removeScreenAt(i);
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isDetachingCurrentScreen) {
            this.isDetachingCurrentScreen = false;
            this.reverseLastTwoChildren = true;
        }
        super.removeView(view);
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.startViewTransition(view);
        this.mRemovalTransitionStarted = true;
    }
}
