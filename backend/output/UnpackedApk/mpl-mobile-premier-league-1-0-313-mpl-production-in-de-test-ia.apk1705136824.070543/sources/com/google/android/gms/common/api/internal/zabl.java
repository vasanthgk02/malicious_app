package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabl implements BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager zaa;

    public zabl(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z) {
        Handler handler = this.zaa.zat;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
