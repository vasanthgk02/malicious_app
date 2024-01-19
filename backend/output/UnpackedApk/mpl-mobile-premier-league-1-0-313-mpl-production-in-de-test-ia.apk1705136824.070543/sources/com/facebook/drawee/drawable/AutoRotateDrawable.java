package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {
    public boolean mClockwise;
    public int mInterval;
    public boolean mIsScheduled;
    public float mRotationAngle;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AutoRotateDrawable(android.graphics.drawable.Drawable r1, int r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0011
            r0.<init>(r1)
            r1 = 0
            r0.mRotationAngle = r1
            r1 = 0
            r0.mIsScheduled = r1
            r0.mInterval = r2
            r1 = 1
            r0.mClockwise = r1
            return
        L_0x0011:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.AutoRotateDrawable.<init>(android.graphics.drawable.Drawable, int):void");
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f2 = this.mRotationAngle;
        if (!this.mClockwise) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, (float) ((i / 2) + bounds.left), (float) ((i2 / 2) + bounds.top));
        Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(save);
        if (!this.mIsScheduled) {
            this.mIsScheduled = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void run() {
        this.mIsScheduled = false;
        this.mRotationAngle += (float) ((int) ((20.0f / ((float) this.mInterval)) * 360.0f));
        invalidateSelf();
    }
}
