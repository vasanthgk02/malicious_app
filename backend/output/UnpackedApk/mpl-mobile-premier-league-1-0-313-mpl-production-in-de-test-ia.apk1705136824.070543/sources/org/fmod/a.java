package org.fmod;

import android.media.AudioRecord;
import java.nio.ByteBuffer;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final FMODAudioDevice f6160a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteBuffer f6161b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6162c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6163d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6164e = 2;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f6165f;
    public volatile boolean g;
    public AudioRecord h;
    public boolean i;

    public a(FMODAudioDevice fMODAudioDevice, int i2, int i3) {
        this.f6160a = fMODAudioDevice;
        this.f6162c = i2;
        this.f6163d = i3;
        this.f6161b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i2, i3, 2));
    }

    private void d() {
        AudioRecord audioRecord = this.h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.h.stop();
            }
            this.h.release();
            this.h = null;
        }
        this.f6161b.position(0);
        this.i = false;
    }

    public final int a() {
        return this.f6161b.capacity();
    }

    public final void b() {
        if (this.f6165f != null) {
            c();
        }
        this.g = true;
        this.f6165f = new Thread(this);
        this.f6165f.start();
    }

    public final void c() {
        while (this.f6165f != null) {
            this.g = false;
            try {
                this.f6165f.join();
                this.f6165f = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void run() {
        int i2 = 3;
        while (this.g) {
            if (!this.i && i2 > 0) {
                d();
                AudioRecord audioRecord = new AudioRecord(1, this.f6162c, this.f6163d, this.f6164e, this.f6161b.capacity());
                this.h = audioRecord;
                int state = audioRecord.getState();
                boolean z = true;
                if (state != 1) {
                    z = false;
                }
                this.i = z;
                if (z) {
                    this.f6161b.position(0);
                    this.h.startRecording();
                    i2 = 3;
                } else {
                    this.h.getState();
                    i2--;
                    d();
                }
            }
            if (this.i && this.h.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.h;
                ByteBuffer byteBuffer = this.f6161b;
                this.f6160a.fmodProcessMicData(this.f6161b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f6161b.position(0);
            }
        }
        d();
    }
}
