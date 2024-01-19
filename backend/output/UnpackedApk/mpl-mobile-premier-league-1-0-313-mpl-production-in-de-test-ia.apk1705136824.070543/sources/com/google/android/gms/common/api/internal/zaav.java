package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class zaav implements Runnable {
    public final /* synthetic */ zaaw zab;

    public /* synthetic */ zaav(zaaw zaaw) {
        this.zab = zaaw;
    }

    public final void run() {
        this.zab.zab.lock();
        try {
            if (!Thread.interrupted()) {
                zaa();
                this.zab.zab.unlock();
            }
        } catch (RuntimeException e2) {
            zabi zabi = this.zab.zaa;
            zabi.zam.sendMessage(zabi.zam.obtainMessage(2, e2));
        } finally {
            this.zab.zab.unlock();
        }
    }

    public abstract void zaa();
}
