package com.clevertap.android.sdk.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.clevertap.android.sdk.Logger;

public final class CloseImageView extends AppCompatImageView {
    public final int canvasSize = getScaledPixels(40);

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setId(199272);
    }

    public final int getScaledPixels(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Context context = getContext();
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("ct_close", "drawable", context.getPackageName()), null);
            if (decodeResource != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(decodeResource, this.canvasSize, this.canvasSize, true), 0.0f, 0.0f, new Paint());
            } else {
                Logger.v("Unable to find inapp notif close button image");
            }
        } catch (Throwable th) {
            Logger.v((String) "Error displaying the inapp notif close button image:", th);
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.canvasSize;
        setMeasuredDimension(i3, i3);
    }

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setId(199272);
    }

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context) {
        super(context, null);
        setId(199272);
    }
}
