package net.butterflytv.rtmp_client;

public class RTMPMuxer {
    static {
        System.loadLibrary("rtmp-jni");
    }

    public native long alloc();

    public native int close(long j);

    public native void file_close();

    public native void file_open(String str);

    public native boolean isConnected(long j);

    public native int open(String str, int i, int i2, long j);

    public native int read(byte[] bArr, int i, int i2, long j);

    public native int writeAudio(byte[] bArr, int i, int i2, long j, long j2);

    public native int writeVideo(byte[] bArr, int i, int i2, long j, long j2);

    public native void write_flv_header(boolean z, boolean z2);
}
