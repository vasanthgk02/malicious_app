package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget;
import com.bumptech.glide.request.target.Target;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    public int getSize() {
        GifFrameLoader gifFrameLoader = ((GifDrawable) this.drawable).state.frameLoader;
        return gifFrameLoader.gifDecoder.getByteSize() + gifFrameLoader.firstFrameSize;
    }

    public void initialize() {
        ((GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        GifDrawable gifDrawable = (GifDrawable) this.drawable;
        gifDrawable.isRecycled = true;
        GifFrameLoader gifFrameLoader = gifDrawable.state.frameLoader;
        gifFrameLoader.callbacks.clear();
        Bitmap bitmap = gifFrameLoader.firstFrame;
        if (bitmap != null) {
            gifFrameLoader.bitmapPool.put(bitmap);
            gifFrameLoader.firstFrame = null;
        }
        gifFrameLoader.isRunning = false;
        DelayTarget delayTarget = gifFrameLoader.current;
        if (delayTarget != null) {
            gifFrameLoader.requestManager.clear((Target<?>) delayTarget);
            gifFrameLoader.current = null;
        }
        DelayTarget delayTarget2 = gifFrameLoader.next;
        if (delayTarget2 != null) {
            gifFrameLoader.requestManager.clear((Target<?>) delayTarget2);
            gifFrameLoader.next = null;
        }
        DelayTarget delayTarget3 = gifFrameLoader.pendingTarget;
        if (delayTarget3 != null) {
            gifFrameLoader.requestManager.clear((Target<?>) delayTarget3);
            gifFrameLoader.pendingTarget = null;
        }
        gifFrameLoader.gifDecoder.clear();
        gifFrameLoader.isCleared = true;
    }
}
