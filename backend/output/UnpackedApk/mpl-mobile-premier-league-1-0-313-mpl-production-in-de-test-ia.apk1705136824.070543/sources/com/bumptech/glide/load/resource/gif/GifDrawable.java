package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget;
import com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback;

public class GifDrawable extends Drawable implements FrameCallback, Animatable {
    public boolean applyGravity;
    public Rect destRect;
    public boolean isRecycled;
    public boolean isRunning;
    public boolean isStarted;
    public boolean isVisible = true;
    public int loopCount;
    public int maxLoopCount = -1;
    public Paint paint;
    public final GifState state;

    public static final class GifState extends ConstantState {
        public final GifFrameLoader frameLoader;

        public GifState(GifFrameLoader gifFrameLoader) {
            this.frameLoader = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        GifFrameLoader gifFrameLoader = new GifFrameLoader(Glide.get(context), gifDecoder, i, i2, transformation, bitmap);
        GifState gifState = new GifState(gifFrameLoader);
        k.checkNotNull(gifState, (String) "Argument must not be null");
        this.state = gifState;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (!this.isRecycled) {
            if (this.applyGravity) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.destRect == null) {
                    this.destRect = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.destRect);
                this.applyGravity = false;
            }
            GifFrameLoader gifFrameLoader = this.state.frameLoader;
            DelayTarget delayTarget = gifFrameLoader.current;
            if (delayTarget != null) {
                bitmap = delayTarget.resource;
            } else {
                bitmap = gifFrameLoader.firstFrame;
            }
            if (this.destRect == null) {
                this.destRect = new Rect();
            }
            canvas.drawBitmap(bitmap, null, this.destRect, getPaint());
        }
    }

    public ConstantState getConstantState() {
        return this.state;
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.firstFrame;
    }

    public int getIntrinsicHeight() {
        return this.state.frameLoader.height;
    }

    public int getIntrinsicWidth() {
        return this.state.frameLoader.width;
    }

    public int getOpacity() {
        return -2;
    }

    public final Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    public void onFrameReady() {
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        DelayTarget delayTarget = this.state.frameLoader.current;
        if ((delayTarget != null ? delayTarget.index : -1) == this.state.frameLoader.gifDecoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i = this.maxLoopCount;
        if (i != -1 && this.loopCount >= i) {
            stop();
        }
    }

    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        k.checkArgument(!this.isRecycled, (String) "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.isStarted = true;
        this.loopCount = 0;
        if (this.isVisible) {
            startRunning();
        }
    }

    public final void startRunning() {
        k.checkArgument(!this.isRecycled, (String) "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.gifDecoder.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            GifFrameLoader gifFrameLoader = this.state.frameLoader;
            if (gifFrameLoader.isCleared) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            } else if (!gifFrameLoader.callbacks.contains(this)) {
                boolean isEmpty = gifFrameLoader.callbacks.isEmpty();
                gifFrameLoader.callbacks.add(this);
                if (isEmpty && !gifFrameLoader.isRunning) {
                    gifFrameLoader.isRunning = true;
                    gifFrameLoader.isCleared = false;
                    gifFrameLoader.loadNextFrame();
                }
                invalidateSelf();
            } else {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
        }
    }

    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    public final void stopRunning() {
        this.isRunning = false;
        GifFrameLoader gifFrameLoader = this.state.frameLoader;
        gifFrameLoader.callbacks.remove(this);
        if (gifFrameLoader.callbacks.isEmpty()) {
            gifFrameLoader.isRunning = false;
        }
    }

    public GifDrawable(GifState gifState) {
        k.checkNotNull(gifState, (String) "Argument must not be null");
        this.state = gifState;
    }
}
