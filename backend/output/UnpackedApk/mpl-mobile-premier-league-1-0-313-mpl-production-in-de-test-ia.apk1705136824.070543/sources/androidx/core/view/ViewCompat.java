package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter;
import androidx.core.view.WindowInsetsCompat.Api21ReflectionHolder;
import androidx.core.view.WindowInsetsCompat.BuilderImpl;
import androidx.core.view.WindowInsetsCompat.BuilderImpl20;
import androidx.core.view.WindowInsetsCompat.BuilderImpl29;
import androidx.core.view.WindowInsetsCompat.BuilderImpl30;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.fontbox.cmap.CMapParser;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    public static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
    public static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new OnReceiveContentViewBehavior() {
        public ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
            return contentInfoCompat;
        }
    };
    public static boolean sAccessibilityDelegateCheckFailed = false;
    public static Field sAccessibilityDelegateField;
    public static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static ThreadLocal<Rect> sThreadLocalRect;
    public static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;

    public static abstract class AccessibilityViewProperty<T> {
        public final int mContentChangeType;
        public final int mFrameworkMinimumSdk;
        public final int mTagKey;
        public final Class<T> mType;

        public AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = 0;
            this.mFrameworkMinimumSdk = i2;
        }

        public boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }

        public abstract T frameworkGet(View view);

        public abstract void frameworkSet(View view, T t);

        public T get(View view) {
            if (VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                return frameworkGet(view);
            }
            T tag = view.getTag(this.mTagKey);
            if (this.mType.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void set(View view, T t) {
            if (VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                frameworkSet(view, t);
            } else if (shouldUpdate(get(view), t)) {
                AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
                if (accessibilityDelegate == null) {
                    accessibilityDelegate = new AccessibilityDelegateCompat();
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegate);
                view.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }

        public abstract boolean shouldUpdate(T t, T t2);

        public AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = i2;
            this.mFrameworkMinimumSdk = i3;
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    public static class UnhandledKeyEventManager {
        public static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        public SparseArray<WeakReference<View>> mCapturedKeys = null;
        public WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
        public WeakHashMap<View, Boolean> mViewsContainingListeners = null;

        public static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R$id.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(R$id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        public final View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (dispatchInOrder != null) {
                            return dispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    public static void addAccessibilityAction(View view, AccessibilityActionCompat accessibilityActionCompat) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static void compatOffsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    public static void compatOffsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(dispatchApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        UnhandledKeyEventManager at = UnhandledKeyEventManager.at(view);
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = at.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!UnhandledKeyEventManager.sViewsWithListeners.isEmpty()) {
                synchronized (UnhandledKeyEventManager.sViewsWithListeners) {
                    if (at.mViewsContainingListeners == null) {
                        at.mViewsContainingListeners = new WeakHashMap<>();
                    }
                    int size = UnhandledKeyEventManager.sViewsWithListeners.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        View view2 = (View) UnhandledKeyEventManager.sViewsWithListeners.get(size).get();
                        if (view2 == null) {
                            UnhandledKeyEventManager.sViewsWithListeners.remove(size);
                        } else {
                            at.mViewsContainingListeners.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                at.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View dispatchInOrder = at.dispatchInOrder(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                if (at.mCapturedKeys == null) {
                    at.mCapturedKeys = new SparseArray<>();
                }
                at.mCapturedKeys.put(keyCode, new WeakReference(dispatchInOrder));
            }
        }
        if (dispatchInOrder != null) {
            z = true;
        }
        return z;
    }

    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        UnhandledKeyEventManager at = UnhandledKeyEventManager.at(view);
        WeakReference<KeyEvent> weakReference = at.mLastDispatchedPreViewKeyEvent;
        if (weakReference == null || weakReference.get() != keyEvent) {
            at.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            if (at.mCapturedKeys == null) {
                at.mCapturedKeys = new SparseArray<>();
            }
            SparseArray<WeakReference<View>> sparseArray = at.mCapturedKeys;
            if (keyEvent.getAction() == 1) {
                int indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference2 = sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
            }
            if (weakReference2 == null) {
                weakReference2 = sparseArray.get(keyEvent.getKeyCode());
            }
            if (weakReference2 != null) {
                View view2 = (View) weakReference2.get();
                if (view2 != null && view2.isAttachedToWindow()) {
                    at.onUnhandledKeyEvent(view2, keyEvent);
                }
                z = true;
            }
        }
        return z;
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    public static AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        AccessibilityDelegate accessibilityDelegate = null;
        if (!sAccessibilityDelegateCheckFailed) {
            if (sAccessibilityDelegateField == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    sAccessibilityDelegateField = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable unused) {
                    sAccessibilityDelegateCheckFailed = true;
                }
            }
            try {
                Object obj = sAccessibilityDelegateField.get(view);
                if (obj instanceof AccessibilityDelegate) {
                    accessibilityDelegate = (AccessibilityDelegate) obj;
                }
            } catch (Throwable unused2) {
                sAccessibilityDelegateCheckFailed = true;
            }
        }
        return accessibilityDelegate;
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        return (CharSequence) new AccessibilityViewProperty<CharSequence>(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            public Object frameworkGet(View view) {
                return view.getAccessibilityPaneTitle();
            }

            public void frameworkSet(View view, Object obj) {
                view.setAccessibilityPaneTitle((CharSequence) obj);
            }

            public boolean shouldUpdate(Object obj, Object obj2) {
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            }
        }.get(view);
    }

    public static List<AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R$id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static Display getDisplay(View view) {
        return view.getDisplay();
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(View view) {
        if (VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        return (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        BuilderImpl builderImpl;
        WindowInsetsCompat windowInsetsCompat = null;
        if (VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets != null) {
                windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
                windowInsetsCompat.mImpl.setRootWindowInsets(windowInsetsCompat);
                windowInsetsCompat.mImpl.copyRootViewBounds(view.getRootView());
            }
            return windowInsetsCompat;
        }
        if (Api21ReflectionHolder.sReflectionSucceeded && view.isAttachedToWindow()) {
            try {
                Object obj = Api21ReflectionHolder.sViewAttachInfoField.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) Api21ReflectionHolder.sStableInsets.get(obj);
                    Rect rect2 = (Rect) Api21ReflectionHolder.sContentInsets.get(obj);
                    if (!(rect == null || rect2 == null)) {
                        int i = VERSION.SDK_INT;
                        if (i >= 30) {
                            builderImpl = new BuilderImpl30();
                        } else if (i >= 29) {
                            builderImpl = new BuilderImpl29();
                        } else {
                            builderImpl = new BuilderImpl20();
                        }
                        builderImpl.setStableInsets(Insets.of(rect.left, rect.top, rect.right, rect.bottom));
                        builderImpl.setSystemWindowInsets(Insets.of(rect2.left, rect2.top, rect2.right, rect2.bottom));
                        WindowInsetsCompat build = builderImpl.build();
                        build.mImpl.setRootWindowInsets(build);
                        build.mImpl.copyRootViewBounds(view.getRootView());
                        windowInsetsCompat = build;
                    }
                }
            } catch (IllegalAccessException e2) {
                e2.getMessage();
            }
        }
        return windowInsetsCompat;
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static int getWindowSystemUiVisibility(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View view) {
        Boolean bool = (Boolean) new AccessibilityViewProperty<Boolean>(R$id.tag_screen_reader_focusable, Boolean.class, 28) {
            public Object frameworkGet(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            public void frameworkSet(View view, Object obj) {
                view.setScreenReaderFocusable(((Boolean) obj).booleanValue());
            }

            public boolean shouldUpdate(Object obj, Object obj2) {
                return !booleanNullToFalseEquals((Boolean) obj, (Boolean) obj2);
            }
        }.get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = getAccessibilityPaneTitle(view) != null && view.getVisibility() == 0;
            int i2 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i2 = 2048;
                }
                obtain.setEventType(i2);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(getAccessibilityPaneTitle(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (((View) parent).getImportantForAccessibility() == 4) {
                            view.setImportantForAccessibility(2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError unused) {
                    view.getParent().getClass().getSimpleName();
                }
            }
        }
    }

    public static void offsetLeftAndRight(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect emptyTempRect = getEmptyTempRect();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        compatOffsetLeftAndRight(view, i);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    public static void offsetTopAndBottom(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect emptyTempRect = getEmptyTempRect();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        compatOffsetTopAndBottom(view, i);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.mInfo);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        OnReceiveContentViewBehavior onReceiveContentViewBehavior;
        ContentInfoCompat contentInfoCompat2;
        OnReceiveContentViewBehavior onReceiveContentViewBehavior2;
        if (Log.isLoggable("ViewCompat", 3)) {
            "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + CMapParser.MARK_END_OF_ARRAY;
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R$id.tag_on_receive_content_listener);
        if (onReceiveContentListener != null) {
            ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                contentInfoCompat2 = null;
            } else {
                if (view instanceof OnReceiveContentViewBehavior) {
                    onReceiveContentViewBehavior2 = (OnReceiveContentViewBehavior) view;
                } else {
                    onReceiveContentViewBehavior2 = NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
                }
                contentInfoCompat2 = onReceiveContentViewBehavior2.onReceiveContent(onReceiveContent);
            }
            return contentInfoCompat2;
        }
        if (view instanceof OnReceiveContentViewBehavior) {
            onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
        } else {
            onReceiveContentViewBehavior = NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
        }
        return onReceiveContentViewBehavior.onReceiveContent(contentInfoCompat);
    }

    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void removeAccessibilityAction(View view, int i) {
        removeActionWithId(i, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void removeActionWithId(int i, View view) {
        List<AccessibilityActionCompat> actionList = getActionList(view);
        for (int i2 = 0; i2 < actionList.size(); i2++) {
            if (actionList.get(i2).getId() == i) {
                actionList.remove(i2);
                return;
            }
        }
    }

    public static void replaceAccessibilityAction(View view, AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
            return;
        }
        AccessibilityActionCompat accessibilityActionCompat2 = new AccessibilityActionCompat(null, accessibilityActionCompat.mId, null, accessibilityViewCommand, accessibilityActionCompat.mViewCommandArgumentClass);
        addAccessibilityAction(view, accessibilityActionCompat2);
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    public static void saveAttributeDataForStyleable(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.mBridge;
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static void setAccessibilityHeading(View view, boolean z) {
        new AccessibilityViewProperty<Boolean>(R$id.tag_accessibility_heading, Boolean.class, 28) {
            public Object frameworkGet(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            public void frameworkSet(View view, Object obj) {
                view.setAccessibilityHeading(((Boolean) obj).booleanValue());
            }

            public boolean shouldUpdate(Object obj, Object obj2) {
                return !booleanNullToFalseEquals((Boolean) obj, (Boolean) obj2);
            }
        }.set(view, Boolean.valueOf(z));
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void setClipBounds(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setElevation(View view, float f2) {
        view.setElevation(f2);
    }

    public static void setHasTransientState(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static void setImportantForAccessibility(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (VERSION.SDK_INT < 30) {
            view.setTag(R$id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewCompat$Api21Impl$1(view, onApplyWindowInsetsListener));
        }
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        if (VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.mPointerIcon : null));
        }
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        new AccessibilityViewProperty<CharSequence>(R$id.tag_state_description, CharSequence.class, 64, 30) {
            public boolean shouldUpdate(Object obj, Object obj2) {
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            }

            public CharSequence frameworkGet(View view) {
                return view.getStateDescription();
            }

            public void frameworkSet(View view, CharSequence charSequence) {
                view.setStateDescription(charSequence);
            }
        }.set(view, charSequence);
    }

    public static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    public static void setTranslationZ(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }

    public static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
