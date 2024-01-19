package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u001dH\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\b\u00105\u001a\u00020\u001dH\u0016J\u0006\u00106\u001a\u00020\u001dJ\u0012\u00107\u001a\u00020\u001d2\n\u00108\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u0004\u0018\u00010=J\u0012\u0010>\u001a\u00020\u001d2\n\u00108\u001a\u0006\u0012\u0002\b\u00030\u000bJ\b\u0010?\u001a\u00020\u001dH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u00020\u0004X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0005R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment;", "Landroidx/fragment/app/Fragment;", "()V", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "canDispatchAppear", "", "canDispatchWillAppear", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", "isTransitioning", "mChildScreenContainers", "", "mProgress", "", "screen", "getScreen$annotations", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "shouldUpdateOnResume", "canDispatchEvent", "event", "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "dispatchEvent", "", "fragment", "dispatchEventInChildContainers", "dispatchHeaderBackButtonClickedEvent", "dispatchOnAppear", "dispatchOnDisappear", "dispatchOnWillAppear", "dispatchOnWillDisappear", "dispatchTransitionProgress", "alpha", "closing", "dispatchViewAnimationEvent", "animationEnd", "onContainerUpdate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewAnimationEnd", "onViewAnimationStart", "registerChildScreenContainer", "screenContainer", "setLastEventDispatched", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "unregisterChildScreenContainer", "updateWindowTraits", "Companion", "ScreenLifecycleEvent", "ScreensFrameLayout", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenFragment.kt */
public class ScreenFragment extends Fragment {
    public boolean canDispatchAppear = true;
    public boolean canDispatchWillAppear = true;
    public boolean isTransitioning;
    public final List<ScreenContainer<?>> mChildScreenContainers = new ArrayList();
    public float mProgress = -1.0f;
    public Screen screen;
    public boolean shouldUpdateOnResume;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "", "(Ljava/lang/String;I)V", "Appear", "WillAppear", "Disappear", "WillDisappear", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    public enum ScreenLifecycleEvent {
        Appear,
        WillAppear,
        Disappear,
        WillDisappear
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreensFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearFocus", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScreenFragment.kt */
    public static final class ScreensFrameLayout extends FrameLayout {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ScreensFrameLayout(Context context) {
            // Intrinsics.checkNotNullParameter(context, "context");
            super(context);
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    /* renamed from: dispatchViewAnimationEvent$lambda-8  reason: not valid java name */
    public static final void m101dispatchViewAnimationEvent$lambda8(boolean z, ScreenFragment screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "this$0");
        if (z) {
            screenFragment.dispatchEvent(ScreenLifecycleEvent.Appear, screenFragment);
            screenFragment.dispatchTransitionProgress(1.0f, false);
            return;
        }
        screenFragment.dispatchEvent(ScreenLifecycleEvent.WillAppear, screenFragment);
        screenFragment.dispatchTransitionProgress(0.0f, false);
    }

    public static final View recycleView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.endViewTransition(view);
            viewGroup.removeView(view);
        }
        view.setVisibility(0);
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r8.canDispatchAppear == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r8.canDispatchWillAppear == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchEvent(com.swmansion.rnscreens.ScreenFragment.ScreenLifecycleEvent r7, com.swmansion.rnscreens.ScreenFragment r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.swmansion.rnscreens.ScreenStackFragment
            if (r0 == 0) goto L_0x00f2
            int r0 = r7.ordinal()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x002a
            if (r0 == r3) goto L_0x0027
            if (r0 == r2) goto L_0x001f
            if (r0 != r1) goto L_0x0019
            boolean r0 = r8.canDispatchWillAppear
            if (r0 != 0) goto L_0x0025
            goto L_0x0023
        L_0x0019:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x001f:
            boolean r0 = r8.canDispatchAppear
            if (r0 != 0) goto L_0x0025
        L_0x0023:
            r0 = 1
            goto L_0x002c
        L_0x0025:
            r0 = 0
            goto L_0x002c
        L_0x0027:
            boolean r0 = r8.canDispatchWillAppear
            goto L_0x002c
        L_0x002a:
            boolean r0 = r8.canDispatchAppear
        L_0x002c:
            if (r0 == 0) goto L_0x00f2
            com.swmansion.rnscreens.Screen r0 = r8.getScreen()
            int r5 = r7.ordinal()
            if (r5 == 0) goto L_0x0048
            if (r5 == r3) goto L_0x0045
            if (r5 == r2) goto L_0x0042
            if (r5 == r1) goto L_0x003f
            goto L_0x004a
        L_0x003f:
            r8.canDispatchWillAppear = r3
            goto L_0x004a
        L_0x0042:
            r8.canDispatchAppear = r3
            goto L_0x004a
        L_0x0045:
            r8.canDispatchWillAppear = r4
            goto L_0x004a
        L_0x0048:
            r8.canDispatchAppear = r4
        L_0x004a:
            int r5 = r7.ordinal()
            if (r5 == 0) goto L_0x007a
            if (r5 == r3) goto L_0x0070
            if (r5 == r2) goto L_0x0066
            if (r5 != r1) goto L_0x0060
            com.swmansion.rnscreens.events.ScreenWillDisappearEvent r1 = new com.swmansion.rnscreens.events.ScreenWillDisappearEvent
            int r0 = r0.getId()
            r1.<init>(r0)
            goto L_0x0083
        L_0x0060:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0066:
            com.swmansion.rnscreens.events.ScreenDisappearEvent r1 = new com.swmansion.rnscreens.events.ScreenDisappearEvent
            int r0 = r0.getId()
            r1.<init>(r0)
            goto L_0x0083
        L_0x0070:
            com.swmansion.rnscreens.events.ScreenWillAppearEvent r1 = new com.swmansion.rnscreens.events.ScreenWillAppearEvent
            int r0 = r0.getId()
            r1.<init>(r0)
            goto L_0x0083
        L_0x007a:
            com.swmansion.rnscreens.events.ScreenAppearEvent r1 = new com.swmansion.rnscreens.events.ScreenAppearEvent
            int r0 = r0.getId()
            r1.<init>(r0)
        L_0x0083:
            com.swmansion.rnscreens.Screen r0 = r6.getScreen()
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x00ea
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0
            com.swmansion.rnscreens.Screen r2 = r6.getScreen()
            int r2 = r2.getId()
            com.facebook.react.uimanager.events.EventDispatcher r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getEventDispatcherForReactTag(r0, r2)
            if (r0 != 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r0.dispatchEvent(r1)
        L_0x00a1:
            java.util.List<com.swmansion.rnscreens.ScreenContainer<?>> r0 = r8.mChildScreenContainers
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ac:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c8
            java.lang.Object r2 = r0.next()
            r5 = r2
            com.swmansion.rnscreens.ScreenContainer r5 = (com.swmansion.rnscreens.ScreenContainer) r5
            int r5 = r5.getScreenCount()
            if (r5 <= 0) goto L_0x00c1
            r5 = 1
            goto L_0x00c2
        L_0x00c1:
            r5 = 0
        L_0x00c2:
            if (r5 == 0) goto L_0x00ac
            r1.add(r2)
            goto L_0x00ac
        L_0x00c8:
            java.util.Iterator r0 = r1.iterator()
        L_0x00cc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f2
            java.lang.Object r1 = r0.next()
            com.swmansion.rnscreens.ScreenContainer r1 = (com.swmansion.rnscreens.ScreenContainer) r1
            com.swmansion.rnscreens.Screen r1 = r1.getTopScreen()
            if (r1 != 0) goto L_0x00df
            goto L_0x00cc
        L_0x00df:
            com.swmansion.rnscreens.ScreenFragment r1 = r1.getFragment()
            if (r1 != 0) goto L_0x00e6
            goto L_0x00cc
        L_0x00e6:
            r8.dispatchEvent(r7, r1)
            goto L_0x00cc
        L_0x00ea:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext"
            r7.<init>(r8)
            throw r7
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenFragment.dispatchEvent(com.swmansion.rnscreens.ScreenFragment$ScreenLifecycleEvent, com.swmansion.rnscreens.ScreenFragment):void");
    }

    public final void dispatchHeaderBackButtonClickedEvent() {
        Context context = getScreen().getContext();
        if (context != null) {
            EventDispatcher eventDispatcherForReactTag = ImageOriginUtils.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new HeaderBackButtonClickedEvent(getScreen().getId()));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
    }

    public final void dispatchTransitionProgress(float f2, boolean z) {
        if (this instanceof ScreenStackFragment) {
            int i = 1;
            if (!(this.mProgress == f2)) {
                float max = Math.max(0.0f, Math.min(1.0f, f2));
                this.mProgress = max;
                if (!(max == 0.0f)) {
                    if (this.mProgress != 1.0f) {
                        i = 0;
                    }
                    i = i != 0 ? 2 : 3;
                }
                short s = (short) i;
                ScreenContainer<?> container = getScreen().getContainer();
                boolean goingForward = container instanceof ScreenStack ? ((ScreenStack) container).getGoingForward() : false;
                Context context = getScreen().getContext();
                if (context != null) {
                    EventDispatcher eventDispatcherForReactTag = ImageOriginUtils.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                    if (eventDispatcherForReactTag != null) {
                        ScreenTransitionProgressEvent screenTransitionProgressEvent = new ScreenTransitionProgressEvent(getScreen().getId(), this.mProgress, z, goingForward, s);
                        eventDispatcherForReactTag.dispatchEvent(screenTransitionProgressEvent);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            }
        }
    }

    public final void dispatchViewAnimationEvent(boolean z) {
        this.isTransitioning = !z;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (!(parentFragment instanceof ScreenFragment) || ((ScreenFragment) parentFragment).isTransitioning)) {
            return;
        }
        if (isResumed()) {
            UiThreadUtil.runOnUiThread(new Runnable(z, this) {
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ ScreenFragment f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ScreenFragment.m101dispatchViewAnimationEvent$lambda8(this.f$0, this.f$1);
                }
            });
        } else if (z) {
            dispatchEvent(ScreenLifecycleEvent.Disappear, this);
            dispatchTransitionProgress(1.0f, true);
        } else {
            dispatchEvent(ScreenLifecycleEvent.WillDisappear, this);
            dispatchTransitionProgress(0.0f, true);
        }
    }

    public final Screen getScreen() {
        Screen screen2 = this.screen;
        if (screen2 != null) {
            return screen2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screen");
        throw null;
    }

    public void onContainerUpdate() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            this.shouldUpdateOnResume = true;
        } else {
            ScreenWindowTraits.trySetWindowTraits$react_native_screens_release(getScreen(), activity, tryGetContext());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        getScreen().setLayoutParams(new LayoutParams(-1, -1));
        Context context = getContext();
        if (context == null) {
            return null;
        }
        ScreensFrameLayout screensFrameLayout = new ScreensFrameLayout(context);
        Screen screen2 = getScreen();
        recycleView(screen2);
        screensFrameLayout.addView(screen2);
        return screensFrameLayout;
    }

    public void onDestroy() {
        super.onDestroy();
        ScreenContainer<?> container = getScreen().getContainer();
        if (container == null || !container.hasScreen(this)) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                EventDispatcher eventDispatcherForReactTag = ImageOriginUtils.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(getScreen().getId()));
                }
            }
        }
        this.mChildScreenContainers.clear();
    }

    public void onResume() {
        super.onResume();
        if (this.shouldUpdateOnResume) {
            this.shouldUpdateOnResume = false;
            ScreenWindowTraits.trySetWindowTraits$react_native_screens_release(getScreen(), tryGetActivity(), tryGetContext());
        }
    }

    public void onViewAnimationEnd() {
        dispatchViewAnimationEvent(true);
    }

    public final Activity tryGetActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                ReactContext reactContext = (ReactContext) context;
                if (reactContext.getCurrentActivity() != null) {
                    return reactContext.getCurrentActivity();
                }
            }
            for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
                if (container instanceof Screen) {
                    ScreenFragment fragment = ((Screen) container).getFragment();
                    if (fragment == null) {
                        continue;
                    } else {
                        FragmentActivity activity2 = fragment.getActivity();
                        if (activity2 != null) {
                            return activity2;
                        }
                    }
                }
            }
            activity = null;
        }
        return activity;
    }

    public final ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            if (context != null) {
                return (ReactContext) context;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        } else if (getScreen().getContext() instanceof ReactContext) {
            Context context2 = getScreen().getContext();
            if (context2 != null) {
                return (ReactContext) context2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        } else {
            for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
                if (container instanceof Screen) {
                    Screen screen2 = (Screen) container;
                    if (screen2.getContext() instanceof ReactContext) {
                        Context context3 = screen2.getContext();
                        if (context3 != null) {
                            return (ReactContext) context3;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    }
                }
            }
            return null;
        }
    }

    @SuppressLint({"ValidFragment"})
    public ScreenFragment(Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "screenView");
        Intrinsics.checkNotNullParameter(screen2, "<set-?>");
        this.screen = screen2;
    }
}
