package com.dooboolab.audiorecorderplayer;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule$startRecorder$1", "Ljava/lang/Runnable;", "run", "", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNAudioRecorderPlayerModule.kt */
public final class RNAudioRecorderPlayerModule$startRecorder$1 implements Runnable {
    public final /* synthetic */ long $systemTime;
    public final /* synthetic */ RNAudioRecorderPlayerModule this$0;

    public RNAudioRecorderPlayerModule$startRecorder$1(long j, RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule) {
        this.$systemTime = j;
        this.this$0 = rNAudioRecorderPlayerModule;
    }

    public void run() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.$systemTime) - this.this$0.totalPausedRecordTime;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("currentPosition", (double) elapsedRealtime);
        if (this.this$0._meteringEnabled) {
            int i = 0;
            if (this.this$0.mediaRecorder != null) {
                MediaRecorder access$getMediaRecorder$p = this.this$0.mediaRecorder;
                Intrinsics.checkNotNull(access$getMediaRecorder$p);
                i = access$getMediaRecorder$p.getMaxAmplitude();
            }
            double d2 = -160.0d;
            if (i > 0) {
                d2 = ((double) 20) * Math.log10(((double) i) / 32767.0d);
            }
            createMap.putInt("currentMetering", (int) d2);
        }
        RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule = this.this$0;
        rNAudioRecorderPlayerModule.sendEvent(rNAudioRecorderPlayerModule.reactContext, "rn-recordback", createMap);
        Handler recordHandler = this.this$0.getRecordHandler();
        Intrinsics.checkNotNull(recordHandler);
        recordHandler.postDelayed(this, (long) this.this$0.subsDurationMillis);
    }
}
