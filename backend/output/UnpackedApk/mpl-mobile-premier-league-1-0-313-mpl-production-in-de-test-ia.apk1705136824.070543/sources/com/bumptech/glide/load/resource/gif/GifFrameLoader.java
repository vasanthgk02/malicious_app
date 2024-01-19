package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.List;

public class GifFrameLoader {
    public final BitmapPool bitmapPool;
    public final List<FrameCallback> callbacks = new ArrayList();
    public DelayTarget current;
    public Bitmap firstFrame;
    public int firstFrameSize;
    public final GifDecoder gifDecoder;
    public final Handler handler;
    public int height;
    public boolean isCleared;
    public boolean isLoadPending;
    public boolean isRunning;
    public DelayTarget next;
    public DelayTarget pendingTarget;
    public RequestBuilder<Bitmap> requestBuilder;
    public final RequestManager requestManager;
    public boolean startFromFirstFrame;
    public int width;

    public static class DelayTarget extends CustomTarget<Bitmap> {
        public final Handler handler;
        public final int index;
        public Bitmap resource;
        public final long targetTime;

        public DelayTarget(Handler handler2, int i, long j) {
            super(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
            this.handler = handler2;
            this.index = i;
            this.targetTime = j;
        }

        public void onLoadCleared(Drawable drawable) {
            this.resource = null;
        }

        public void onResourceReady(Object obj, Transition transition) {
            this.resource = (Bitmap) obj;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    public interface FrameCallback {
        void onFrameReady();
    }

    public class FrameLoaderCallback implements Callback {
        public FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            }
            if (i == 2) {
                GifFrameLoader.this.requestManager.clear((Target<?>) (DelayTarget) message.obj);
            }
            return false;
        }
    }

    public GifFrameLoader(Glide glide, GifDecoder gifDecoder2, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        BitmapPool bitmapPool2 = glide.getBitmapPool();
        RequestManager with = Glide.with(glide.getContext());
        RequestBuilder<Bitmap> apply = Glide.with(glide.getContext()).asBitmap().apply(((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(i, i2));
        this.requestManager = with;
        Handler handler2 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        this.bitmapPool = bitmapPool2;
        this.handler = handler2;
        this.requestBuilder = apply;
        this.gifDecoder = gifDecoder2;
        setFrameTransformation(transformation, bitmap);
    }

    public final void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                k.checkArgument(this.pendingTarget == null, (String) "Pending target must be null when starting from the first frame");
                this.gifDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay());
            this.gifDecoder.advance();
            this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis);
            this.requestBuilder.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(new ObjectKey(Double.valueOf(Math.random())))).load((Object) this.gifDecoder).into(this.next);
        }
    }

    public void onFrameReady(DelayTarget delayTarget) {
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.isRunning) {
            this.pendingTarget = delayTarget;
        } else {
            if (delayTarget.resource != null) {
                Bitmap bitmap = this.firstFrame;
                if (bitmap != null) {
                    this.bitmapPool.put(bitmap);
                    this.firstFrame = null;
                }
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                int size = this.callbacks.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    this.callbacks.get(size).onFrameReady();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            loadNextFrame();
        }
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        k.checkNotNull(transformation, (String) "Argument must not be null");
        k.checkNotNull(bitmap, (String) "Argument must not be null");
        this.firstFrame = bitmap;
        this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(transformation));
        this.firstFrameSize = Util.getBitmapByteSize(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }
}
