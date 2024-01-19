package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
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

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static int tagId = R.id.glide_custom_view_target_tag;
    public final SizeDeterminer sizeDeterminer;
    public final T view;

    public static final class SizeDeterminer {
        public static Integer maxDisplayLength;
        public final List<SizeReadyCallback> cbs = new ArrayList();
        public SizeDeterminerLayoutListener layoutListener;
        public final View view;

        public static final class SizeDeterminerLayoutListener implements OnPreDrawListener {
            public final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
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
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            boolean isLoggable = Log.isLoggable("ViewTarget", 4);
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

    public ViewTarget(T t) {
        k.checkNotNull(t, (String) "Argument must not be null");
        this.view = t;
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    public Request getRequest() {
        Object tag = this.view.getTag(tagId);
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
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

    public void onLoadCleared(Drawable drawable) {
        this.sizeDeterminer.clearCallbacksAndListener();
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.cbs.remove(sizeReadyCallback);
    }

    public void setRequest(Request request) {
        this.view.setTag(tagId, request);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Target for: ");
        outline73.append(this.view);
        return outline73.toString();
    }
}
