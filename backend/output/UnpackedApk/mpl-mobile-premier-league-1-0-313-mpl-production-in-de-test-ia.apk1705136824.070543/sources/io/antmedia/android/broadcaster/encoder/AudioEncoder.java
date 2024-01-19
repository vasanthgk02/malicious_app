package io.antmedia.android.broadcaster.encoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class AudioEncoder extends Thread {
    public static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static long previousPresentationTimeUs;
    public static long roundOffset;
    public static int roundTimes;
    public final int TIMEOUT_USEC = 10000;
    public MediaCodec mAudioEncoder;
    public ByteBuffer[] mAudioInputBuffers;
    public ByteBuffer[] mAudioOutputBuffers;
    public IMediaMuxer mMuxerHandler;
    public Map<Integer, Object> reservedBuffers = new HashMap();

    private byte[] convertToByte(float[] fArr) {
        short[] sArr = new short[fArr.length];
        byte[] bArr = new byte[(fArr.length * 2)];
        for (int i = 0; i < fArr.length; i++) {
            sArr[i] = (short) ((int) (fArr[i] * ((float) 1) * 32767.0f));
            int i2 = i * 2;
            bArr[i2] = (byte) (sArr[i] & 255);
            bArr[i2 + 1] = (byte) ((sArr[i] & 65280) >> 8);
        }
        return bArr;
    }

    public static long getUnsignedInt(long j) {
        return j & 4294967295L;
    }

    private void release() {
        try {
            if (this.mAudioEncoder != null) {
                this.mAudioEncoder.stop();
                this.mAudioEncoder.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void encodeAudio(float[] fArr, int i, long j) {
        if (this.mAudioEncoder != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    break;
                }
                int dequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(MqttAsyncClient.DISCONNECT_TIMEOUT);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = this.mAudioInputBuffers[dequeueInputBuffer];
                    byteBuffer.remaining();
                    byte[] convertToByte = convertToByte(fArr);
                    byteBuffer.put(convertToByte, 0, convertToByte.length);
                    byteBuffer.clear();
                    this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, convertToByte.length, j, 0);
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i2++;
            }
        }
    }

    public byte[] getBuffer(int i, int i2, int i3) {
        Iterator<Entry<Integer, Object>> it = this.reservedBuffers.entrySet().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (((Integer) next.getKey()).intValue() <= i2) {
                byte[] bArr = (byte[]) next.getValue();
                it.remove();
                if (bArr.length >= i) {
                    this.reservedBuffers.put(Integer.valueOf(i3), bArr);
                    return bArr;
                }
            }
        }
        byte[] bArr2 = new byte[i];
        this.reservedBuffers.put(Integer.valueOf(i3), bArr2);
        return bArr2;
    }

    public void run() {
        BufferInfo bufferInfo = new BufferInfo();
        roundTimes = 0;
        roundOffset = 0;
        previousPresentationTimeUs = 0;
        while (true) {
            int dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(bufferInfo, MqttAsyncClient.DISCONNECT_TIMEOUT);
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = this.mAudioOutputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    System.out.println(" encoded data null audio");
                } else {
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    if (previousPresentationTimeUs < 0 && bufferInfo.presentationTimeUs > 0) {
                        int i = roundTimes + 1;
                        roundTimes = i;
                        roundOffset = ((long) i) * 4294967296L;
                    }
                    int unsignedInt = (int) ((getUnsignedInt(bufferInfo.presentationTimeUs) + roundOffset) / 1000);
                    byte[] buffer = getBuffer(bufferInfo.size, this.mMuxerHandler.getLastAudioFrameTimeStamp(), unsignedInt);
                    byteBuffer.get(buffer, 0, bufferInfo.size);
                    byteBuffer.position(bufferInfo.offset);
                    this.mMuxerHandler.writeAudio(buffer, bufferInfo.size, unsignedInt);
                    previousPresentationTimeUs = bufferInfo.presentationTimeUs;
                    this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            } else if (dequeueOutputBuffer == -3) {
                this.mAudioOutputBuffers = this.mAudioEncoder.getOutputBuffers();
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.reservedBuffers.clear();
                release();
                return;
            }
        }
    }

    public boolean startAudioEncoder(int i, int i2, int i3, int i4, int i5, IMediaMuxer iMediaMuxer) {
        this.mMuxerHandler = iMediaMuxer;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, i, i2);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", i3);
        createAudioFormat.setInteger("max-input-size", i4 * 2);
        createAudioFormat.setInteger("pcm-encoding", i5);
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            this.mAudioEncoder = createEncoderByType;
            createEncoderByType.configure(createAudioFormat, null, null, 1);
            this.mAudioEncoder.start();
            this.mAudioInputBuffers = this.mAudioEncoder.getInputBuffers();
            this.mAudioOutputBuffers = this.mAudioEncoder.getOutputBuffers();
            start();
            return true;
        } catch (IOException | IllegalStateException e2) {
            e2.printStackTrace();
            this.mAudioEncoder = null;
            return false;
        }
    }

    public void stopEncoding() {
        int i = 0;
        while (i < 3) {
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(MqttAsyncClient.DISCONNECT_TIMEOUT);
                if (dequeueInputBuffer >= 0) {
                    this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i++;
            } else {
                return;
            }
        }
    }
}
