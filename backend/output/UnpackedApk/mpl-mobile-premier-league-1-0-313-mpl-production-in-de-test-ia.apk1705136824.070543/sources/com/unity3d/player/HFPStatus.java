package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

public class HFPStatus {

    /* renamed from: a  reason: collision with root package name */
    public Context f3369a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f3370b = null;

    /* renamed from: c  reason: collision with root package name */
    public Intent f3371c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3372d = false;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f3373e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f3374f = a.f3376a;

    public enum a {
        ;

        /* access modifiers changed from: public */
        static {
            f3379d = new int[]{1, 2, 3};
        }
    }

    public HFPStatus(Context context) {
        this.f3369a = context;
        this.f3373e = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    public final void a() {
        deinitHFPStatusJni();
    }

    public boolean getHFPStat() {
        return this.f3374f == a.f3377b;
    }

    public void requestHFPStat() {
        AnonymousClass1 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                if (intExtra == 0) {
                    if (HFPStatus.this.f3372d) {
                        HFPStatus.this.f3373e.setMode(0);
                    }
                    HFPStatus.this.f3372d = false;
                } else if (intExtra != 1) {
                    if (intExtra == 2) {
                        if (HFPStatus.this.f3374f == a.f3377b) {
                            HFPStatus.this.f3372d = true;
                            return;
                        }
                        HFPStatus.this.f3374f = a.f3378c;
                    }
                } else {
                    HFPStatus.this.f3374f = a.f3377b;
                    if (!HFPStatus.this.f3372d) {
                        HFPStatus.this.f3373e.stopBluetoothSco();
                    } else {
                        HFPStatus.this.f3373e.setMode(3);
                    }
                }
            }
        };
        this.f3370b = r0;
        this.f3371c = this.f3369a.registerReceiver(r0, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f3373e.startBluetoothSco();
        } catch (NullPointerException unused) {
            f.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }
}
