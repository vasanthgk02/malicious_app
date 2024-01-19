package org.reactnative.maskedview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;

public class RNCMaskedView extends ReactViewGroup {
    public Bitmap mBitmapMask = null;
    public boolean mBitmapMaskInvalidated = false;
    public Paint mPaint;
    public PorterDuffXfermode mPorterDuffXferMode;

    public RNCMaskedView(Context context) {
        super(context);
        setLayerType(1, null);
        this.mPaint = new Paint(1);
        this.mPorterDuffXferMode = new PorterDuffXfermode(Mode.DST_IN);
    }

    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        super.dispatchDraw(canvas);
        if (this.mBitmapMaskInvalidated) {
            Bitmap bitmap2 = this.mBitmapMask;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            View childAt = getChildAt(0);
            childAt.setVisibility(0);
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            if (childAt.getMeasuredWidth() <= 0 || childAt.getMeasuredHeight() <= 0) {
                bitmap = null;
            } else {
                bitmap = Bitmap.createBitmap(childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), Config.ARGB_8888);
                childAt.draw(new Canvas(bitmap));
            }
            this.mBitmapMask = bitmap;
            childAt.setVisibility(4);
            this.mBitmapMaskInvalidated = false;
        }
        if (this.mBitmapMask != null) {
            this.mPaint.setXfermode(this.mPorterDuffXferMode);
            canvas.drawBitmap(this.mBitmapMask, 0.0f, 0.0f, this.mPaint);
            this.mPaint.setXfermode(null);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mBitmapMaskInvalidated = true;
    }

    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        if (!this.mBitmapMaskInvalidated && getChildAt(0).equals(view)) {
            this.mBitmapMaskInvalidated = true;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mBitmapMaskInvalidated = true;
        }
    }
}
