package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.view.DraweeHolder;

public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    public Drawable mControllerOverlay = null;
    public VisibilityCallback mVisibilityCallback;

    public RootDrawable(Drawable drawable) {
        super(drawable);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                DraweeHolder draweeHolder = (DraweeHolder) visibilityCallback;
                if (!draweeHolder.mIsControllerAttached) {
                    FLog.w(DraweeEventTracker.class, (String) "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.mController)), draweeHolder.toString());
                    draweeHolder.mIsHolderAttached = true;
                    draweeHolder.mIsVisible = true;
                    draweeHolder.attachOrDetachController();
                }
            }
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.mControllerOverlay;
            if (drawable2 != null) {
                drawable2.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    public boolean setVisible(boolean z, boolean z2) {
        VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null) {
            ((DraweeHolder) visibilityCallback).onVisibilityChange(z);
        }
        return super.setVisible(z, z2);
    }
}
