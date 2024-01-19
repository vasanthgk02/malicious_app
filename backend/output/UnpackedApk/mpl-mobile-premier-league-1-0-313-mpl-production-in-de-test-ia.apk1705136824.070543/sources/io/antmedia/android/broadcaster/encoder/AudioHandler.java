package io.antmedia.android.broadcaster.encoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.lang.Thread.State;

public class AudioHandler extends Handler {
    public static final int END_OF_STREAM = 2;
    public static final int RECORD_AUDIO = 0;
    public AudioEncoder audioEncoder = null;
    public boolean isRunning = false;
    public long startTime;

    public AudioHandler(Looper looper) {
        super(looper);
    }

    public AudioEncoder getAudioEncoder() {
        return this.audioEncoder;
    }

    public void handleMessage(Message message) {
        AudioEncoder audioEncoder2 = this.audioEncoder;
        if (audioEncoder2 != null) {
            int i = message.what;
            if (i != 0) {
                if (i == 2) {
                    if (audioEncoder2.getState() == State.RUNNABLE) {
                        this.audioEncoder.stopEncoding();
                        removeMessages(0);
                    }
                    this.isRunning = false;
                }
            } else if (this.isRunning) {
                audioEncoder2.encodeAudio((float[]) message.obj, message.arg1, (long) (message.arg2 * 1000));
            }
        }
    }

    public void recordAudio(float[] fArr, int i) {
        Message obtainMessage = obtainMessage(0, fArr);
        obtainMessage.arg1 = fArr.length;
        obtainMessage.arg2 = (int) (System.currentTimeMillis() - this.startTime);
        sendMessage(obtainMessage);
    }

    public void setRecordStartTime(long j) {
        this.startTime = j;
    }

    public boolean startAudioEncoder(IMediaMuxer iMediaMuxer, int i, int i2, int i3) {
        boolean z;
        AudioEncoder audioEncoder2 = new AudioEncoder();
        this.audioEncoder = audioEncoder2;
        try {
            z = audioEncoder2.startAudioEncoder(i, i3, 96000, i2, 2, iMediaMuxer);
            try {
                this.isRunning = true;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            this.audioEncoder = null;
            return z;
        }
        return z;
    }
}
