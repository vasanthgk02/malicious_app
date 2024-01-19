package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class ResourceRecycler {
    public final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    public boolean isRecycling;

    public static final class ResourceRecyclerCallback implements Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    public synchronized void recycle(Resource<?> resource, boolean z) {
        if (!this.isRecycling) {
            if (!z) {
                this.isRecycling = true;
                resource.recycle();
                this.isRecycling = false;
            }
        }
        this.handler.obtainMessage(1, resource).sendToTarget();
    }
}
