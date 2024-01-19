package io.antmedia.android.broadcaster;

import android.app.Activity;

public interface ILiveVideoBroadcaster {
    void init(Activity activity);

    boolean isConnected();

    boolean isRecording();

    void recordAudio(float[] fArr, int i);

    void registerStatusListener(String str, String str2);

    boolean startBroadcasting(String str, int i, int i2, int i3, Activity activity);

    boolean startBroadcasting(String str, int i, int i2, int i3, Activity activity, int i4, int i5);

    void stopBroadcasting();
}
