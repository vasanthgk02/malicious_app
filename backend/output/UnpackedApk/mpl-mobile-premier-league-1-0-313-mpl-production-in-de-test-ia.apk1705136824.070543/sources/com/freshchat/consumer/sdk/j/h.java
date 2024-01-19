package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.i.c;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class h {
    public static final String TAG = "com.freshchat.consumer.sdk.j.h";
    public final long channelId;
    public final Context context;
    public TelephonyManager gZ;
    public a hp;
    public final ax hq;
    public AudioManager hr;
    public MediaRecorder hs;

    public class a {
        public long hu;
        public File hv;
        public AtomicBoolean hw = new AtomicBoolean(false);
        public long startTime;

        public a() {
        }

        public boolean M() {
            return this.hw.get();
        }

        public void a(File file) {
            this.hv = file;
        }

        public void eq() {
            this.hu = System.currentTimeMillis();
        }

        public File er() {
            return this.hv;
        }

        public int es() {
            long j = this.hu;
            if (j > 0) {
                long j2 = this.startTime;
                if (j > j2) {
                    return (int) ((j - j2) / 1000);
                }
            }
            return 0;
        }

        public void r(boolean z) {
            this.hw.set(z);
        }

        public void setStartTime(long j) {
            this.startTime = j;
        }
    }

    public h(Context context2, ax axVar, long j) {
        this.context = context2.getApplicationContext();
        this.hq = axVar;
        this.channelId = j;
    }

    private void ej() {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.hs = mediaRecorder;
        mediaRecorder.setAudioSource(1);
        this.hs.setOutputFormat(2);
        this.hs.setAudioEncoder(3);
        this.hs.setOutputFile(ek().er().getAbsolutePath());
    }

    private AudioManager em() {
        if (this.hr == null) {
            this.hr = (AudioManager) this.context.getSystemService("audio");
        }
        return this.hr;
    }

    private void eo() {
        int i = aw.eY() ? 4 : 2;
        if (em() != null) {
            em().requestAudioFocus(null, 3, i);
        }
    }

    /* access modifiers changed from: private */
    public boolean ep() {
        return en() != null && en().getCallState() == 1;
    }

    private void q(boolean z) {
        ek().r(false);
        ek().eq();
        this.hq.an();
        this.hq.ao();
        try {
            this.hs.stop();
        } catch (RuntimeException unused) {
        }
        el();
        File er = ek() != null ? ek().er() : null;
        er.exists();
        er.getAbsolutePath();
        if (er.exists()) {
            if (z) {
                er.delete();
            } else {
                this.hq.a(ek());
            }
        }
        em().abandonAudioFocus(null);
    }

    public void b(a aVar) {
        this.hp = aVar;
    }

    public void eh() {
        q(true);
    }

    public void ei() {
        q(false);
    }

    public a ek() {
        return this.hp;
    }

    public void el() {
        MediaRecorder mediaRecorder = this.hs;
        if (mediaRecorder != null) {
            mediaRecorder.release();
            this.hs = null;
        }
    }

    public TelephonyManager en() {
        if (this.gZ == null) {
            this.gZ = (TelephonyManager) this.context.getSystemService("phone");
        }
        return this.gZ;
    }

    public void startRecording() {
        try {
            if (c.dU()) {
                c.dW();
            }
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = new a();
            aVar.setStartTime(System.currentTimeMillis());
            Message message = new Message();
            message.setChannelId(this.channelId);
            message.setAlias(UUID.randomUUID().toString());
            aVar.a(x.b(this.context, message));
            aVar.r(true);
            b(aVar);
            eo();
            ej();
            try {
                this.hs.prepare();
                this.hs.start();
                long currentTimeMillis2 = System.currentTimeMillis();
                this.hq.am();
                this.hq.ap();
                long currentTimeMillis3 = System.currentTimeMillis();
                String str = TAG;
                ai.d(str, "Time taken to show progress " + (currentTimeMillis3 - currentTimeMillis2) + " ms");
                String str2 = TAG;
                ai.d(str2, "Post-recorder " + (currentTimeMillis2 - currentTimeMillis) + " ms");
                new Thread(new Runnable() {
                    public void run() {
                        int i;
                        Exception e2;
                        int i2 = 300;
                        h.this.hq.b(300);
                        long currentTimeMillis = System.currentTimeMillis();
                        while (h.this.ek() != null && h.this.ek().M()) {
                            try {
                                int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) / 1000);
                                if (h.this.ep() || currentTimeMillis2 > 360) {
                                    h.this.eh();
                                }
                                h.this.hq.i(n.s(currentTimeMillis2));
                                i = h.this.hs.getMaxAmplitude();
                                if (i > 0) {
                                    h.this.hq.c(i);
                                    if (i > i2) {
                                        try {
                                            h.this.hq.b(i);
                                        } catch (Exception e3) {
                                            e2 = e3;
                                        }
                                        i2 = i;
                                    }
                                }
                            } catch (Exception e4) {
                                int i3 = i2;
                                e2 = e4;
                                i = i3;
                                q.a(e2);
                                i2 = i;
                            }
                        }
                        h.this.hq.an();
                        h.this.hq.ao();
                    }
                }).start();
            } catch (IOException unused) {
                Toast.makeText(this.context, com.freshchat.consumer.sdk.b.c.VOICE_MESSAGE_RECORDING_FAILED.toString(), 0).show();
                b((a) null);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
