package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import sfs2x.client.entities.invitation.InvitationReply;

public class FastBitmapDrawable extends Drawable {
    public int mAlpha = InvitationReply.EXPIRED;
    public Bitmap mBitmap;
    public int mHeight;
    public final Paint mPaint = new Paint(2);
    public int mWidth;

    public FastBitmapDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap != null) {
            this.mWidth = bitmap.getWidth();
            this.mHeight = this.mBitmap.getHeight();
            return;
        }
        this.mHeight = 0;
        this.mWidth = 0;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.mBitmap, null, getBounds(), this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    public int getMinimumHeight() {
        return this.mHeight;
    }

    public int getMinimumWidth() {
        return this.mWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
    }
}
