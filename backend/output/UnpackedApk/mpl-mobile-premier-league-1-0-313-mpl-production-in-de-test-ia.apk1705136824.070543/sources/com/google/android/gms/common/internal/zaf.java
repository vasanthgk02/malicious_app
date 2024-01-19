package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaf extends zag {
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ LifecycleFragment zab;

    public zaf(Intent intent, LifecycleFragment lifecycleFragment) {
        this.zaa = intent;
        this.zab = lifecycleFragment;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, 2);
        }
    }
}
