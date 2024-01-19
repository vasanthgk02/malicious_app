package com.dooboolab.audiorecorderplayer;

import android.media.MediaPlayer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/dooboolab/audiorecorderplayer/RNAudioRecorderPlayerModule$startPlayer$1$1", "Ljava/util/TimerTask;", "run", "", "react-native-audio-recorder-player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNAudioRecorderPlayerModule.kt */
public final class RNAudioRecorderPlayerModule$startPlayer$1$1 extends TimerTask {
    public final /* synthetic */ MediaPlayer $mp;
    public final /* synthetic */ RNAudioRecorderPlayerModule this$0;

    public RNAudioRecorderPlayerModule$startPlayer$1$1(MediaPlayer mediaPlayer, RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule) {
        this.$mp = mediaPlayer;
        this.this$0 = rNAudioRecorderPlayerModule;
    }

    public void run() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(InlineAnimation.DURATION, this.$mp.getDuration());
        createMap.putInt("currentPosition", this.$mp.getCurrentPosition());
        RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule = this.this$0;
        rNAudioRecorderPlayerModule.sendEvent(rNAudioRecorderPlayerModule.reactContext, "rn-playback", createMap);
    }
}
