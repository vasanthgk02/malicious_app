package com.squareup.picasso;

import android.graphics.Bitmap;
import com.squareup.picasso.Picasso.LoadedFrom;

public class FetchAction extends Action<Object> {
    public Callback callback;
    public final Object target = new Object();

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FetchAction(Picasso picasso, Request request, int i, int i2, Object obj, String str, Callback callback2) {
        super(picasso, null, request, i, i2, 0, null, str, obj, false);
        this.callback = callback2;
    }

    public void cancel() {
        super.cancel();
        this.callback = null;
    }

    public void complete(Bitmap bitmap, LoadedFrom loadedFrom) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSuccess();
        }
    }

    public void error(Exception exc) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onError(exc);
        }
    }

    public Object getTarget() {
        return this.target;
    }
}
