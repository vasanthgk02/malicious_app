package com.th3rdwave.safeareacontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.resources.TextAppearanceConfig;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class SafeAreaView extends ReactViewGroup implements OnPreDrawListener {
    public EnumSet<SafeAreaViewEdges> mEdges;
    public EdgeInsets mInsets;
    public SafeAreaViewMode mMode = SafeAreaViewMode.PADDING;
    public View mProviderView;

    public SafeAreaView(Context context) {
        super(context);
    }

    public static ReactContext getReactContext(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public final boolean maybeUpdateInsets() {
        View view = this.mProviderView;
        if (view == null) {
            return false;
        }
        EdgeInsets safeAreaInsets = TextAppearanceConfig.getSafeAreaInsets(view);
        if (safeAreaInsets != null) {
            EdgeInsets edgeInsets = this.mInsets;
            if (edgeInsets == null || !edgeInsets.equalsToEdgeInsets(safeAreaInsets)) {
                this.mInsets = safeAreaInsets;
                updateInsets();
                return true;
            }
        }
        return false;
    }

    public void onAttachedToWindow() {
        View view;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent == null) {
                view = this;
                break;
            } else if (parent instanceof SafeAreaProvider) {
                view = (View) parent;
                break;
            } else {
                parent = parent.getParent();
            }
        }
        this.mProviderView = view;
        view.getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.mProviderView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mProviderView = null;
    }

    public boolean onPreDraw() {
        boolean maybeUpdateInsets = maybeUpdateInsets();
        if (maybeUpdateInsets) {
            requestLayout();
        }
        return !maybeUpdateInsets;
    }

    public void setEdges(EnumSet<SafeAreaViewEdges> enumSet) {
        this.mEdges = enumSet;
        updateInsets();
    }

    public void setMode(SafeAreaViewMode safeAreaViewMode) {
        this.mMode = safeAreaViewMode;
        updateInsets();
    }

    public final void updateInsets() {
        if (this.mInsets != null) {
            EnumSet<SafeAreaViewEdges> enumSet = this.mEdges;
            if (enumSet == null) {
                enumSet = EnumSet.allOf(SafeAreaViewEdges.class);
            }
            SafeAreaViewLocalData safeAreaViewLocalData = new SafeAreaViewLocalData(this.mInsets, this.mMode, enumSet);
            UIManagerModule uIManagerModule = (UIManagerModule) getReactContext(this).getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), safeAreaViewLocalData);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                long nanoTime = System.nanoTime();
                getReactContext(this).runOnNativeModulesQueueThread(new Runnable() {
                    public void run() {
                        synchronized (atomicBoolean) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                atomicBoolean.notify();
                            }
                        }
                    }
                });
                synchronized (atomicBoolean) {
                    long j = 0;
                    while (!atomicBoolean.get() && j < 500000000) {
                        try {
                            atomicBoolean.wait(500);
                        } catch (InterruptedException unused) {
                            atomicBoolean.set(true);
                        }
                        j += System.nanoTime() - nanoTime;
                    }
                }
            }
        }
    }
}
