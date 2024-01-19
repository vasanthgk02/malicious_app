package io.hansel.hanselsdk;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public HanselSyncStateListener f5235a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5236b;

    public a(HanselSyncStateListener hanselSyncStateListener, boolean z) {
        this.f5235a = hanselSyncStateListener;
        this.f5236b = z;
    }

    public void run() {
        HanselSyncStateListener hanselSyncStateListener = this.f5235a;
        if (hanselSyncStateListener != null) {
            hanselSyncStateListener.onHanselSynced(this.f5236b);
        }
    }
}
