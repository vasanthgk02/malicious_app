package com.cauly.android.ad;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public abstract class WeakAsyncTask<Params, Progress, Result, WeakTarget> extends AsyncTask<Params, Progress, Result> {
    protected WeakReference<WeakTarget> mTarget;

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(WeakTarget weaktarget, Params... paramsArr);

    public WeakAsyncTask(WeakTarget target) {
        this.mTarget = new WeakReference<>(target);
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        WeakTarget target = this.mTarget.get();
        if (target != null) {
            onPreExecute(target);
        }
    }

    /* access modifiers changed from: protected */
    public final Result doInBackground(Params... params) {
        WeakTarget target = this.mTarget.get();
        if (target != null) {
            return doInBackground(target, params);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(Result result) {
        WeakTarget target = this.mTarget.get();
        if (target != null) {
            onPostExecute(target, result);
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute(WeakTarget weaktarget) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(WeakTarget weaktarget, Result result) {
    }
}
