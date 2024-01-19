package org.fmod;

import android.media.AudioTrack;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {
    public static int h = 0;
    public static int i = 1;
    public static int j = 2;
    public static int k = 3;

    /* renamed from: a  reason: collision with root package name */
    public volatile Thread f6154a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6155b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioTrack f6156c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6157d = false;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f6158e = null;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6159f = null;
    public volatile a g;

    private native int fmodGetInfo(int i2);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f6156c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f6156c.stop();
            }
            this.f6156c.release();
            this.f6156c = null;
        }
        this.f6158e = null;
        this.f6159f = null;
        this.f6157d = false;
    }

    public synchronized void close() {
        stop();
    }

    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i2);

    public boolean isRunning() {
        return this.f6154a != null && this.f6154a.isAlive();
    }

    public void run() {
        int i2 = 3;
        while (this.f6155b) {
            if (!this.f6157d && i2 > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(i);
                int fmodGetInfo3 = fmodGetInfo(j) * fmodGetInfo2 * 4;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, 3, 2, fmodGetInfo3 > round ? fmodGetInfo3 : round, 1);
                this.f6156c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.f6157d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f6158e = allocateDirect;
                    this.f6159f = new byte[allocateDirect.capacity()];
                    this.f6156c.play();
                    i2 = 3;
                } else {
                    this.f6156c.getState();
                    releaseAudioTrack();
                    i2--;
                }
            }
            if (this.f6157d) {
                if (fmodGetInfo(k) == 1) {
                    fmodProcess(this.f6158e);
                    ByteBuffer byteBuffer = this.f6158e;
                    byteBuffer.get(this.f6159f, 0, byteBuffer.capacity());
                    this.f6156c.write(this.f6159f, 0, this.f6158e.capacity());
                    this.f6158e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f6154a != null) {
            stop();
        }
        this.f6154a = new Thread(this, "FMODAudioDevice");
        this.f6154a.setPriority(10);
        this.f6155b = true;
        this.f6154a.start();
        if (this.g != null) {
            this.g.b();
        }
    }

    public synchronized int startAudioRecord(int i2, int i3, int i4) {
        if (this.g == null) {
            this.g = new a(this, i2, i3);
            this.g.b();
        }
        return this.g.a();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:16:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            java.lang.Thread r0 = r1.f6154a     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
            r0 = 0
            r1.f6155b = r0     // Catch:{ all -> 0x001c }
            java.lang.Thread r0 = r1.f6154a     // Catch:{ InterruptedException -> 0x0001 }
            r0.join()     // Catch:{ InterruptedException -> 0x0001 }
            r0 = 0
            r1.f6154a = r0     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0011:
            org.fmod.a r0 = r1.g     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            org.fmod.a r0 = r1.g     // Catch:{ all -> 0x001c }
            r0.c()     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fmod.FMODAudioDevice.stop():void");
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
    }
}
