package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.swmansion.rnscreens.Screen.ActivityState;
import com.swmansion.rnscreens.ScreenFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0016J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020%H\u0004J\u0018\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u00100\u001a\u00020!J\b\u00101\u001a\u00020!H\u0014J\b\u00102\u001a\u00020!H\u0014J\b\u00103\u001a\u00020!H\u0014J0\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0014J\u0018\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u0016H\u0014J\b\u0010=\u001a\u00020!H\u0002J\b\u0010>\u001a\u00020!H\u0016J\u0006\u0010?\u001a\u00020!J\b\u0010@\u001a\u00020!H\u0004J\b\u0010A\u001a\u00020!H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u000bH\u0002J\u0010\u0010D\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020\u000bH\u0002J\b\u0010K\u001a\u00020!H\u0002R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00148\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006L"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainer;", "T", "Lcom/swmansion/rnscreens/ScreenFragment;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isNested", "", "()Z", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mIsAttached", "mLayoutCallback", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", "mLayoutEnqueued", "mNeedUpdate", "mParentScreenFragment", "mScreenFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "screenCount", "", "getScreenCount", "()I", "topScreen", "Lcom/swmansion/rnscreens/Screen;", "getTopScreen", "()Lcom/swmansion/rnscreens/Screen;", "adapt", "screen", "(Lcom/swmansion/rnscreens/Screen;)Lcom/swmansion/rnscreens/ScreenFragment;", "addScreen", "", "index", "attachScreen", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "screenFragment", "createTransaction", "detachScreen", "findFragmentManagerForReactRootView", "rootView", "Lcom/facebook/react/ReactRootView;", "getActivityState", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "getScreenAt", "hasScreen", "notifyChildUpdate", "notifyContainerUpdate", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScreenChanged", "onUpdate", "performUpdates", "performUpdatesNow", "removeAllScreens", "removeMyFragments", "fragmentManager", "removeScreenAt", "removeView", "view", "Landroid/view/View;", "requestLayout", "setFragmentManager", "fm", "setupFragmentManager", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenContainer.kt */
public class ScreenContainer<T extends ScreenFragment> extends ViewGroup {
    public FragmentManager mFragmentManager;
    public boolean mIsAttached;
    public final FrameCallback mLayoutCallback = new ScreenContainer$mLayoutCallback$1(this);
    public boolean mLayoutEnqueued;
    public boolean mNeedUpdate;
    public ScreenFragment mParentScreenFragment;
    public final ArrayList<T> mScreenFragments = new ArrayList<>();

    public ScreenContainer(Context context) {
        super(context);
    }

    /* renamed from: onScreenChanged$lambda-7  reason: not valid java name */
    public static final void m100onScreenChanged$lambda7(ScreenContainer screenContainer) {
        Intrinsics.checkNotNullParameter(screenContainer, "this$0");
        screenContainer.performUpdates();
    }

    private final void setFragmentManager(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        performUpdatesNow();
    }

    public T adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final FragmentTransaction createTransaction() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            FragmentTransaction reorderingAllowed = fragmentManager.beginTransaction().setReorderingAllowed(true);
            Intrinsics.checkNotNullExpressionValue(reorderingAllowed, "requireNotNull(mFragment…etReorderingAllowed(true)");
            return reorderingAllowed;
        }
        throw new IllegalArgumentException("mFragmentManager is null when creating transaction".toString());
    }

    public final ActivityState getActivityState(ScreenFragment screenFragment) {
        return screenFragment.getScreen().getActivityState();
    }

    public final Screen getScreenAt(int i) {
        return ((ScreenFragment) this.mScreenFragments.get(i)).getScreen();
    }

    public final int getScreenCount() {
        return this.mScreenFragments.size();
    }

    public Screen getTopScreen() {
        T t;
        boolean z;
        Iterator<T> it = this.mScreenFragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (getActivityState((ScreenFragment) t) == ActivityState.ON_TOP) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ScreenFragment screenFragment = (ScreenFragment) t;
        if (screenFragment == null) {
            return null;
        }
        return screenFragment.getScreen();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return ArraysKt___ArraysJvmKt.contains(this.mScreenFragments, screenFragment);
    }

    public void notifyContainerUpdate() {
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            ScreenFragment fragment = topScreen.getFragment();
            if (fragment != null) {
                fragment.onContainerUpdate();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 1
            r4.mIsAttached = r0
            r0 = r4
        L_0x0007:
            boolean r1 = r0 instanceof com.facebook.react.ReactRootView
            if (r1 != 0) goto L_0x001f
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 != 0) goto L_0x001f
            android.view.ViewParent r2 = r0.getParent()
            if (r2 == 0) goto L_0x001f
            android.view.ViewParent r0 = r0.getParent()
            java.lang.String r1 = "parent.parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0007
        L_0x001f:
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 == 0) goto L_0x0056
            com.swmansion.rnscreens.Screen r0 = (com.swmansion.rnscreens.Screen) r0
            com.swmansion.rnscreens.ScreenFragment r0 = r0.getFragment()
            if (r0 != 0) goto L_0x002d
            r0 = 0
            goto L_0x0047
        L_0x002d:
            r4.mParentScreenFragment = r0
            java.lang.String r1 = "screenContainer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.util.List<com.swmansion.rnscreens.ScreenContainer<?>> r1 = r0.mChildScreenContainers
            r1.add(r4)
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            java.lang.String r1 = "screenFragment.childFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r4.setFragmentManager(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            goto L_0x009e
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Parent Screen does not have its Fragment attached"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0056:
            if (r1 == 0) goto L_0x00ab
            com.facebook.react.ReactRootView r0 = (com.facebook.react.ReactRootView) r0
            android.content.Context r1 = r0.getContext()
        L_0x005e:
            boolean r2 = r1 instanceof androidx.fragment.app.FragmentActivity
            if (r2 != 0) goto L_0x006d
            boolean r3 = r1 instanceof android.content.ContextWrapper
            if (r3 == 0) goto L_0x006d
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1
            android.content.Context r1 = r1.getBaseContext()
            goto L_0x005e
        L_0x006d:
            if (r2 == 0) goto L_0x009f
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            androidx.fragment.app.FragmentManager r2 = r1.getSupportFragmentManager()
            java.util.List r2 = r2.getFragments()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0089
            androidx.fragment.app.FragmentManager r0 = r1.getSupportFragmentManager()
            java.lang.String r1 = "{\n            // We are …FragmentManager\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x009b
        L_0x0089:
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.FragmentManager.findFragment(r0)     // Catch:{ IllegalStateException -> 0x0092 }
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()     // Catch:{ IllegalStateException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            androidx.fragment.app.FragmentManager r0 = r1.getSupportFragmentManager()
        L_0x0096:
            java.lang.String r1 = "{\n            // We are …r\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x009b:
            r4.setFragmentManager(r0)
        L_0x009e:
            return
        L_0x009f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "In order to use RNScreens components your app's activity need to extend ReactActivity"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ab:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ScreenContainer is not attached under ReactRootView"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.onAttachedToWindow():void");
    }

    public void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            boolean z = false;
            for (Fragment next : fragmentManager.getFragments()) {
                if ((next instanceof ScreenFragment) && ((ScreenFragment) next).getScreen().getContainer() == this) {
                    beginTransaction.remove(next);
                    z = true;
                }
            }
            if (z) {
                beginTransaction.commitNowAllowingStateLoss();
            }
            fragmentManager.executePendingTransactions();
        }
        ScreenFragment screenFragment = this.mParentScreenFragment;
        if (screenFragment != null) {
            Intrinsics.checkNotNullParameter(this, "screenContainer");
            screenFragment.mChildScreenContainers.remove(this);
        }
        this.mParentScreenFragment = null;
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            while (true) {
                int i = childCount - 1;
                removeViewAt(childCount);
                if (i >= 0) {
                    childCount = i;
                } else {
                    return;
                }
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    public final void onScreenChanged() {
        this.mNeedUpdate = true;
        Context context = getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext != null) {
            reactContext.runOnUiQueueThread(new Runnable() {
                public final void run() {
                    ScreenContainer.m100onScreenChanged$lambda7(ScreenContainer.this);
                }
            });
        }
    }

    public void onUpdate() {
        FragmentTransaction createTransaction = createTransaction();
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            HashSet hashSet = new HashSet(fragmentManager.getFragments());
            Iterator<T> it = this.mScreenFragments.iterator();
            while (it.hasNext()) {
                ScreenFragment screenFragment = (ScreenFragment) it.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment, "screenFragment");
                if (getActivityState(screenFragment) == ActivityState.INACTIVE && screenFragment.isAdded()) {
                    createTransaction.remove(screenFragment);
                }
                hashSet.remove(screenFragment);
            }
            boolean z = false;
            if (!hashSet.isEmpty()) {
                Object[] array = hashSet.toArray(new Fragment[0]);
                if (array != null) {
                    Fragment[] fragmentArr = (Fragment[]) array;
                    int length = fragmentArr.length;
                    int i = 0;
                    while (i < length) {
                        Fragment fragment = fragmentArr[i];
                        i++;
                        if (fragment instanceof ScreenFragment) {
                            ScreenFragment screenFragment2 = (ScreenFragment) fragment;
                            if (screenFragment2.getScreen().getContainer() == null) {
                                createTransaction.remove(screenFragment2);
                            }
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
            boolean z2 = getTopScreen() == null;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = this.mScreenFragments.iterator();
            while (it2.hasNext()) {
                ScreenFragment screenFragment3 = (ScreenFragment) it2.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment3, "screenFragment");
                ActivityState activityState = getActivityState(screenFragment3);
                if (activityState != ActivityState.INACTIVE && !screenFragment3.isAdded()) {
                    createTransaction.add(getId(), (Fragment) screenFragment3);
                    z = true;
                } else if (activityState != ActivityState.INACTIVE && z) {
                    createTransaction.remove(screenFragment3);
                    arrayList.add(screenFragment3);
                }
                screenFragment3.getScreen().setTransitioning(z2);
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ScreenFragment screenFragment4 = (ScreenFragment) it3.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment4, "screenFragment");
                createTransaction.add(getId(), (Fragment) screenFragment4);
            }
            createTransaction.commitNowAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("mFragmentManager is null when performing update in ScreenContainer".toString());
    }

    public final void performUpdates() {
        if (this.mNeedUpdate && this.mIsAttached) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                boolean z = true;
                if (fragmentManager == null || !fragmentManager.isDestroyed()) {
                    z = false;
                }
                if (!z) {
                    this.mNeedUpdate = false;
                    onUpdate();
                    notifyContainerUpdate();
                }
            }
        }
    }

    public final void performUpdatesNow() {
        this.mNeedUpdate = true;
        performUpdates();
    }

    public void removeAllScreens() {
        Iterator<T> it = this.mScreenFragments.iterator();
        while (it.hasNext()) {
            ((ScreenFragment) it.next()).getScreen().setContainer(null);
        }
        this.mScreenFragments.clear();
        onScreenChanged();
    }

    public void removeScreenAt(int i) {
        ((ScreenFragment) this.mScreenFragments.get(i)).getScreen().setContainer(null);
        this.mScreenFragments.remove(i);
        onScreenChanged();
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.mLayoutEnqueued && this.mLayoutCallback != null) {
            this.mLayoutEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mLayoutCallback);
        }
    }
}
