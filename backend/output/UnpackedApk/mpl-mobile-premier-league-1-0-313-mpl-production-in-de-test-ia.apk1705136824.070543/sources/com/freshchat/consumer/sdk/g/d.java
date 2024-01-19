package com.freshchat.consumer.sdk.g;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;

public abstract class d<T> extends AsyncTaskLoader<T> {
    public T eR;

    public d(Context context) {
        super(context);
    }

    public void deliverResult(T t) {
        if (isReset()) {
            this.eR = null;
            return;
        }
        this.eR = t;
        if (isStarted()) {
            super.deliverResult(t);
        }
    }

    public abstract T getData();

    public T loadInBackground() {
        return getData();
    }

    public void onCanceled(T t) {
        this.eR = null;
    }

    public void onReset() {
        super.onReset();
        onStopLoading();
        this.eR = null;
    }

    public void onStartLoading() {
        T t = this.eR;
        if (t != null) {
            deliverResult(t);
        }
        if (takeContentChanged() || this.eR == null) {
            forceLoad();
        }
    }

    public void onStopLoading() {
        cancelLoad();
    }
}
