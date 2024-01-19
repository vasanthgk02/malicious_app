package io.antmedia.android.broadcaster.encoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class VideoEncoderCore {
    public static final int IFRAME_INTERVAL = 1;
    public static final String MIME_TYPE = "video/avc";
    public static final String TAG = "VideoEncoderCore";
    public static final boolean VERBOSE = false;
    public int initialPresentationTime = -1;
    public BufferInfo mBufferInfo = new BufferInfo();
    public MediaCodec mEncoder;
    public Surface mInputSurface;
    public boolean mMuxerStarted;
    public IMediaMuxer mWriterHandler;
    public Map<Integer, Object> reservedBuffers = new HashMap();

    public VideoEncoderCore(int i, int i2, int i3, int i4, IMediaMuxer iMediaMuxer) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("capture-rate", i4);
        createVideoFormat.setInteger("repeat-previous-frame-after", 1000000 / i4);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(MIME_TYPE);
        this.mEncoder = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, null, null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        this.mWriterHandler = iMediaMuxer;
    }

    private byte[] getBuffer(int i, int i2, int i3) {
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

    public void drainEncoder(boolean z) {
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            if (z) {
                mediaCodec.signalEndOfInputStream();
            }
            ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, MqttAsyncClient.DISCONNECT_TIMEOUT);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        break;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (!this.mMuxerStarted) {
                        MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                        ByteBuffer byteBuffer = outputFormat.getByteBuffer("csd-0");
                        ByteBuffer byteBuffer2 = outputFormat.getByteBuffer("csd-1");
                        int limit = byteBuffer2.limit() + byteBuffer.limit();
                        byte[] bArr = new byte[limit];
                        byteBuffer.get(bArr, 0, byteBuffer.limit());
                        byteBuffer2.get(bArr, byteBuffer.limit(), byteBuffer2.limit());
                        this.mWriterHandler.writeVideo(bArr, limit, 0);
                        "encoder output format changed: " + outputFormat;
                        this.mMuxerStarted = true;
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else if (dequeueOutputBuffer < 0) {
                    continue;
                } else {
                    ByteBuffer byteBuffer3 = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer3 != null) {
                        BufferInfo bufferInfo = this.mBufferInfo;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        BufferInfo bufferInfo2 = this.mBufferInfo;
                        if (bufferInfo2.size != 0) {
                            if (this.mMuxerStarted) {
                                byteBuffer3.position(bufferInfo2.offset);
                                BufferInfo bufferInfo3 = this.mBufferInfo;
                                byteBuffer3.limit(bufferInfo3.offset + bufferInfo3.size);
                                int i = (int) (this.mBufferInfo.presentationTimeUs / 1000);
                                if (this.initialPresentationTime == -1) {
                                    this.initialPresentationTime = i;
                                }
                                int i2 = (i - this.initialPresentationTime) + 1;
                                byte[] buffer = getBuffer(this.mBufferInfo.size, this.mWriterHandler.getLastVideoFrameTimeStamp(), i2);
                                byteBuffer3.get(buffer, 0, this.mBufferInfo.size);
                                byteBuffer3.position(this.mBufferInfo.offset);
                                this.mWriterHandler.writeVideo(buffer, this.mBufferInfo.size, i2);
                            } else {
                                throw new RuntimeException("muxer hasn't started");
                            }
                        }
                        this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.mBufferInfo.flags & 4) != 0) {
                            this.reservedBuffers.clear();
                            break;
                        }
                    } else {
                        throw new RuntimeException(GeneratedOutlineSupport.outline42("encoderOutputBuffer ", dequeueOutputBuffer, " was null"));
                    }
                }
            }
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    public void release() {
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mEncoder.release();
                this.mEncoder = null;
            } catch (CodecException e2) {
                if (e2.isRecoverable()) {
                    if (VERSION.SDK_INT >= 23) {
                        e2.getErrorCode();
                        e2.getDiagnosticInfo();
                        return;
                    }
                    e2.getDiagnosticInfo();
                } else if (e2.isTransient()) {
                    if (VERSION.SDK_INT >= 23) {
                        e2.getErrorCode();
                        e2.getDiagnosticInfo();
                        return;
                    }
                    e2.getDiagnosticInfo();
                } else if (VERSION.SDK_INT >= 23) {
                    e2.getErrorCode();
                    e2.getDiagnosticInfo();
                } else {
                    e2.getDiagnosticInfo();
                }
            }
        }
    }

    public void stopMuxer() {
        IMediaMuxer iMediaMuxer = this.mWriterHandler;
        if (iMediaMuxer != null) {
            iMediaMuxer.stopMuxer();
            this.mWriterHandler = null;
        }
    }
}
