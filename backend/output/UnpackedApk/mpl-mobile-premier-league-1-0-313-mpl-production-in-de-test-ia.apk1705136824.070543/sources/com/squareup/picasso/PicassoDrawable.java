package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;
import sfs2x.client.entities.invitation.InvitationReply;

public final class PicassoDrawable extends BitmapDrawable {
    public static final Paint DEBUG_PAINT = new Paint();
    public static final float FADE_DURATION = 200.0f;
    public int alpha = InvitationReply.EXPIRED;
    public boolean animating;
    public final boolean debugging;
    public final float density;
    public final LoadedFrom loadedFrom;
    public Drawable placeholder;
    public long startTimeMillis;

    public PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, LoadedFrom loadedFrom2, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.debugging = z2;
        this.density = context.getResources().getDisplayMetrics().density;
        this.loadedFrom = loadedFrom2;
        if (loadedFrom2 != LoadedFrom.MEMORY && !z) {
            this.placeholder = drawable;
            this.animating = true;
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
    }

    private void drawDebugIndicator(Canvas canvas) {
        DEBUG_PAINT.setColor(-1);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 16.0f)), DEBUG_PAINT);
        DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 15.0f)), DEBUG_PAINT);
    }

    public static Path getTrianglePath(int i, int i2, int i3) {
        Path path = new Path();
        float f2 = (float) i;
        float f3 = (float) i2;
        path.moveTo(f2, f3);
        path.lineTo((float) (i + i3), f3);
        path.lineTo(f2, (float) (i2 + i3));
        return path;
    }

    public static void setBitmap(ImageView imageView, Context context, Bitmap bitmap, LoadedFrom loadedFrom2, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        PicassoDrawable picassoDrawable = new PicassoDrawable(context, bitmap, drawable, loadedFrom2, z, z2);
        imageView.setImageDrawable(picassoDrawable);
    }

    public static void setPlaceholder(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.animating) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.startTimeMillis)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.animating = false;
                this.placeholder = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.placeholder;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.alpha) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.alpha);
            }
        }
        if (this.debugging) {
            drawDebugIndicator(canvas);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.alpha = i;
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
