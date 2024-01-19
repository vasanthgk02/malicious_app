package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends CustomTarget<Z> {
    public static final Handler HANDLER = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            PreloadTarget preloadTarget = (PreloadTarget) message.obj;
            preloadTarget.requestManager.clear((Target<?>) preloadTarget);
            return true;
        }
    });
    public final RequestManager requestManager;

    public PreloadTarget(RequestManager requestManager2, int i, int i2) {
        super(i, i2);
        this.requestManager = requestManager2;
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onResourceReady(Z z, Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}
