package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class Action<T> {
    public boolean cancelled;
    public final Drawable errorDrawable;
    public final int errorResId;
    public final String key;
    public final int memoryPolicy;
    public final int networkPolicy;
    public final boolean noFade;
    public final Picasso picasso;
    public final Request request;
    public final Object tag;
    public final WeakReference<T> target;
    public boolean willReplay;

    public static class RequestWeakReference<M> extends WeakReference<M> {
        public final Action action;

        public RequestWeakReference(Action action2, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.action = action2;
        }
    }

    public Action(Picasso picasso2, T t, Request request2, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        WeakReference<T> weakReference;
        this.picasso = picasso2;
        this.request = request2;
        if (t == null) {
            weakReference = null;
        } else {
            weakReference = new RequestWeakReference<>(this, t, picasso2.referenceQueue);
        }
        this.target = weakReference;
        this.memoryPolicy = i;
        this.networkPolicy = i2;
        this.noFade = z;
        this.errorResId = i3;
        this.errorDrawable = drawable;
        this.key = str;
        this.tag = obj == 0 ? this : obj;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public abstract void complete(Bitmap bitmap, LoadedFrom loadedFrom);

    public abstract void error(Exception exc);

    public String getKey() {
        return this.key;
    }

    public int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    public int getNetworkPolicy() {
        return this.networkPolicy;
    }

    public Picasso getPicasso() {
        return this.picasso;
    }

    public Priority getPriority() {
        return this.request.priority;
    }

    public Request getRequest() {
        return this.request;
    }

    public Object getTag() {
        return this.tag;
    }

    public T getTarget() {
        WeakReference<T> weakReference = this.target;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean willReplay() {
        return this.willReplay;
    }
}
