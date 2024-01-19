package com.th3rdwave.safeareacontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.resources.TextAppearanceConfig;

@SuppressLint({"ViewConstructor"})
public class SafeAreaProvider extends ReactViewGroup implements OnPreDrawListener {
    public OnInsetsChangeListener mInsetsChangeListener;
    public Rect mLastFrame;
    public EdgeInsets mLastInsets;

    public interface OnInsetsChangeListener {
        void onInsetsChange(SafeAreaProvider safeAreaProvider, EdgeInsets edgeInsets, Rect rect);
    }

    public SafeAreaProvider(Context context) {
        super(context);
    }

    public final void maybeUpdateInsets() {
        EdgeInsets safeAreaInsets = TextAppearanceConfig.getSafeAreaInsets(this);
        Rect frame = TextAppearanceConfig.getFrame((ViewGroup) getRootView(), this);
        if (safeAreaInsets != null && frame != null) {
            EdgeInsets edgeInsets = this.mLastInsets;
            if (!(edgeInsets == null || this.mLastFrame == null || !edgeInsets.equalsToEdgeInsets(safeAreaInsets))) {
                Rect rect = this.mLastFrame;
                if (rect != null) {
                    boolean z = true;
                    if (!(rect == frame || (rect.x == frame.x && rect.y == frame.y && rect.width == frame.width && rect.height == frame.height))) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                } else {
                    throw null;
                }
            }
            OnInsetsChangeListener onInsetsChangeListener = this.mInsetsChangeListener;
            ImageOriginUtils.assertNotNull(onInsetsChangeListener);
            onInsetsChangeListener.onInsetsChange(this, safeAreaInsets, frame);
            this.mLastInsets = safeAreaInsets;
            this.mLastFrame = frame;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        maybeUpdateInsets();
        return true;
    }

    public void setOnInsetsChangeListener(OnInsetsChangeListener onInsetsChangeListener) {
        this.mInsetsChangeListener = onInsetsChangeListener;
    }
}
