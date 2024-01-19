package com.freshchat.consumer.sdk.g;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import java.util.List;

public abstract class c<T> extends AsyncTaskLoader<List<T>> {
    public List<T> eQ;

    public c(Context context) {
        super(context);
    }

    public abstract List<T> dd();

    /* renamed from: de */
    public List<T> loadInBackground() {
        return dd();
    }

    public void onReset() {
        super.onReset();
        onStopLoading();
        List<T> list = this.eQ;
        if (list != null && list.size() > 0) {
            this.eQ.clear();
        }
        this.eQ = null;
    }

    public void onStartLoading() {
        List<T> list = this.eQ;
        if (list != null) {
            deliverResult(list);
        }
        if (takeContentChanged() || this.eQ == null) {
            forceLoad();
        }
    }

    public void onStopLoading() {
        cancelLoad();
    }

    /* renamed from: q */
    public void deliverResult(List<T> list) {
        if (isReset()) {
            if (list != null) {
                list.clear();
            }
            return;
        }
        List<T> list2 = this.eQ;
        this.eQ = list;
        if (isStarted()) {
            super.deliverResult(list);
        }
        if (!(list2 == null || list2 == list || list2.size() <= 0)) {
            list2.clear();
        }
    }

    /* renamed from: r */
    public void onCanceled(List<T> list) {
        if (list != null && list.size() > 0) {
            list.clear();
        }
    }
}
