package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import java.util.ArrayList;

public class DeferredReleaserConcurrentImpl extends DeferredReleaser {
    public final Object mLock = new Object();
    public ArrayList<Releasable> mPendingReleasables = new ArrayList<>();
    public ArrayList<Releasable> mTempList = new ArrayList<>();
    public final Handler mUiHandler = new Handler(Looper.getMainLooper());
    public final Runnable releaseRunnable = new Runnable() {
        public void run() {
            synchronized (DeferredReleaserConcurrentImpl.this.mLock) {
                ArrayList<Releasable> arrayList = DeferredReleaserConcurrentImpl.this.mTempList;
                DeferredReleaserConcurrentImpl.this.mTempList = DeferredReleaserConcurrentImpl.this.mPendingReleasables;
                DeferredReleaserConcurrentImpl.this.mPendingReleasables = arrayList;
            }
            int size = DeferredReleaserConcurrentImpl.this.mTempList.size();
            for (int i = 0; i < size; i++) {
                DeferredReleaserConcurrentImpl.this.mTempList.get(i).release();
            }
            DeferredReleaserConcurrentImpl.this.mTempList.clear();
        }
    };

    public void cancelDeferredRelease(Releasable releasable) {
        synchronized (this.mLock) {
            this.mPendingReleasables.remove(releasable);
        }
    }
}
