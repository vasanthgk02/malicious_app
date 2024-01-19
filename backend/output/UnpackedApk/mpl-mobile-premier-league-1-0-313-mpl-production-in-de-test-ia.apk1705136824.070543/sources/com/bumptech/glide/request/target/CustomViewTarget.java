package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    public static final String TAG = "CustomViewTarget";
    public static final int VIEW_TAG_ID = R.id.glide_custom_view_target_tag;
    public OnAttachStateChangeListener attachStateListener;
    public boolean isAttachStateListenerAdded;
    public boolean isClearedByUs;
    public final SizeDeterminer sizeDeterminer;
    public final T view;

    public static final class SizeDeterminer {
        public static Integer maxDisplayLength;
        public final List<SizeReadyCallback> cbs = new ArrayList();
        public SizeDeterminerLayoutListener layoutListener;
        public final View view;
        public boolean waitForLayout;

        public static final class SizeDeterminerLayoutListener implements OnPreDrawListener {
            public final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.TAG, 2)) {
                    "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.sizeDeterminerRef.get();
                if (sizeDeterminer != null && !sizeDeterminer.cbs.isEmpty()) {
                    int targetWidth = sizeDeterminer.getTargetWidth();
                    int targetHeight = sizeDeterminer.getTargetHeight();
                    if (sizeDeterminer.isViewStateAndSizeValid(targetWidth, targetHeight)) {
                        Iterator it = new ArrayList(sizeDeterminer.cbs).iterator();
                        while (it.hasNext()) {
                            ((SizeReadyCallback) it.next()).onSizeReady(targetWidth, targetHeight);
                        }
                        sizeDeterminer.clearCallbacksAndListener();
                    }
                }
                return true;
            }
        }

        public SizeDeterminer(View view2) {
            this.view = view2;
        }

        public void clearCallbacksAndListener() {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
            }
            this.layoutListener = null;
            this.cbs.clear();
        }

        public final int getTargetDimen(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.waitForLayout && this.view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            boolean isLoggable = Log.isLoggable(CustomViewTarget.TAG, 4);
            Context context = this.view.getContext();
            if (maxDisplayLength == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                k.checkNotNull(windowManager, (String) "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                maxDisplayLength = Integer.valueOf(Math.max(point.x, point.y));
            }
            return maxDisplayLength.intValue();
        }

        public final int getTargetHeight() {
            int paddingBottom = this.view.getPaddingBottom() + this.view.getPaddingTop();
            LayoutParams layoutParams = this.view.getLayoutParams();
            return getTargetDimen(this.view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int getTargetWidth() {
            int paddingRight = this.view.getPaddingRight() + this.view.getPaddingLeft();
            LayoutParams layoutParams = this.view.getLayoutParams();
            return getTargetDimen(this.view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final boolean isViewStateAndSizeValid(int i, int i2) {
            if (i > 0 || i == Integer.MIN_VALUE) {
                if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                    return true;
                }
            }
            return false;
        }
    }

    public CustomViewTarget(T t) {
        k.checkNotNull(t, (String) "Argument must not be null");
        this.view = t;
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    private Object getTag() {
        return this.view.getTag(VIEW_TAG_ID);
    }

    private void maybeAddAttachStateListener() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && !this.isAttachStateListenerAdded) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void maybeRemoveAttachStateListener() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && this.isAttachStateListenerAdded) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    private void setTag(Object obj) {
        this.view.setTag(VIEW_TAG_ID, obj);
    }

    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                CustomViewTarget.this.resumeMyRequest();
            }

            public void onViewDetachedFromWindow(View view) {
                CustomViewTarget.this.pauseMyRequest();
            }
        };
        maybeAddAttachStateListener();
        return this;
    }

    public final Request getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        SizeDeterminer sizeDeterminer2 = this.sizeDeterminer;
        int targetWidth = sizeDeterminer2.getTargetWidth();
        int targetHeight = sizeDeterminer2.getTargetHeight();
        if (sizeDeterminer2.isViewStateAndSizeValid(targetWidth, targetHeight)) {
            sizeReadyCallback.onSizeReady(targetWidth, targetHeight);
            return;
        }
        if (!sizeDeterminer2.cbs.contains(sizeReadyCallback)) {
            sizeDeterminer2.cbs.add(sizeReadyCallback);
        }
        if (sizeDeterminer2.layoutListener == null) {
            ViewTreeObserver viewTreeObserver = sizeDeterminer2.view.getViewTreeObserver();
            SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(sizeDeterminer2);
            sizeDeterminer2.layoutListener = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    public final T getView() {
        return this.view;
    }

    public void onDestroy() {
    }

    public final void onLoadCleared(Drawable drawable) {
        this.sizeDeterminer.clearCallbacksAndListener();
        onResourceCleared(drawable);
        if (!this.isClearedByUs) {
            maybeRemoveAttachStateListener();
        }
    }

    public final void onLoadStarted(Drawable drawable) {
        maybeAddAttachStateListener();
        onResourceLoading(drawable);
    }

    public abstract void onResourceCleared(Drawable drawable);

    public void onResourceLoading(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void pauseMyRequest() {
        Request request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.cbs.remove(sizeReadyCallback);
    }

    public final void resumeMyRequest() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    public final void setRequest(Request request) {
        setTag(request);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Target for: ");
        outline73.append(this.view);
        return outline73.toString();
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(int i) {
        return this;
    }

    public final CustomViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
