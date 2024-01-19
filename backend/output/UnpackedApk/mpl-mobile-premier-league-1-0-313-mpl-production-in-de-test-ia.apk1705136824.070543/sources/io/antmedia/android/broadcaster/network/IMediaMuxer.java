package io.antmedia.android.broadcaster.network;

public interface IMediaMuxer {
    public static final int SEND_AUDIO = 0;
    public static final int SEND_VIDEO = 1;
    public static final int START_STREAMING = 3;
    public static final int STOP_STREAMING = 2;

    int getAudioFrameCountInQueue();

    int getFrameCountInQueue();

    int getLastAudioFrameTimeStamp();

    int getLastVideoFrameTimeStamp();

    int getSendFrameCount();

    int getVideoFrameCountInQueue();

    boolean isConnected();

    void open(String str);

    void setAudioEnable(boolean z);

    void stopMuxer();

    void writeAudio(byte[] bArr, int i, int i2);

    void writeVideo(byte[] bArr, int i, int i2);
}
