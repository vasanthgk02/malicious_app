package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;

public class CircularRevealHelper {
    public boolean buildingCircularRevealCache;
    public final Delegate delegate;
    public Drawable overlayDrawable;
    public RevealInfo revealInfo;
    public final Paint revealPaint = new Paint(7);
    public final Path revealPath = new Path();
    public final Paint scrimPaint;
    public final View view;

    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    public CircularRevealHelper(Delegate delegate2) {
        this.delegate = delegate2;
        View view2 = (View) delegate2;
        this.view = view2;
        view2.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    public void draw(Canvas canvas) {
        if (shouldDrawCircularReveal()) {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
            }
        } else {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
            }
        }
        if ((this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.revealInfo.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    public final float getDistanceToFurthestCorner(RevealInfo revealInfo2) {
        return ImageOriginUtils.distanceToFurthestCorner(revealInfo2.centerX, revealInfo2.centerY, 0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    public RevealInfo getRevealInfo() {
        RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null) {
            return null;
        }
        RevealInfo revealInfo3 = new RevealInfo(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius);
        if (revealInfo3.radius == Float.MAX_VALUE) {
            revealInfo3.radius = getDistanceToFurthestCorner(revealInfo3);
        }
        return revealInfo3;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setRevealInfo(RevealInfo revealInfo2) {
        if (revealInfo2 == null) {
            this.revealInfo = null;
        } else {
            RevealInfo revealInfo3 = this.revealInfo;
            if (revealInfo3 == null) {
                this.revealInfo = new RevealInfo(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius);
            } else {
                float f2 = revealInfo2.centerX;
                float f3 = revealInfo2.centerY;
                float f4 = revealInfo2.radius;
                revealInfo3.centerX = f2;
                revealInfo3.centerY = f3;
                revealInfo3.radius = f4;
            }
            if (revealInfo2.radius + 1.0E-4f >= getDistanceToFurthestCorner(revealInfo2)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        this.view.invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if ((r0.radius == Float.MAX_VALUE) != false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldDrawCircularReveal() {
        /*
            r4 = this;
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r4.revealInfo
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0014
            float r0 = r0.radius
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0015
        L_0x0014:
            r1 = 1
        L_0x0015:
            r0 = r1 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.CircularRevealHelper.shouldDrawCircularReveal():boolean");
    }

    public final boolean shouldDrawScrim() {
        return !this.buildingCircularRevealCache && Color.alpha(this.scrimPaint.getColor()) != 0;
    }
}
