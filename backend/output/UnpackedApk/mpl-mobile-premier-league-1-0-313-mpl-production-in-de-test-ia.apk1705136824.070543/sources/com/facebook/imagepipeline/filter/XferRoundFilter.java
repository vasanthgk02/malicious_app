package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public final class XferRoundFilter {
    public static boolean canUseXferRoundFilter() {
        return true;
    }

    public static void xferRoundBitmap(Bitmap bitmap, Bitmap bitmap2, boolean z) {
        Paint paint;
        Paint paint2;
        if (bitmap2 == null) {
            throw null;
        } else if (bitmap != null) {
            bitmap.setHasAlpha(true);
            if (z) {
                paint = new Paint(1);
                paint2 = new Paint(1);
            } else {
                paint = new Paint();
                paint2 = new Paint();
            }
            paint.setColor(-16777216);
            paint2.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            Canvas canvas = new Canvas(bitmap);
            float width = ((float) bitmap2.getWidth()) / 2.0f;
            float height = ((float) bitmap2.getHeight()) / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height), paint);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint2);
        } else {
            throw null;
        }
    }
}
