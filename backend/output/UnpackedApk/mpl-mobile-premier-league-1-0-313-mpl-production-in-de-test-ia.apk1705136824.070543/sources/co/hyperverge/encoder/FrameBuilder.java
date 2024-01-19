package co.hyperverge.encoder;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010$\u001a\u00020\u001bJ\u0012\u0010%\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010&\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lco/hyperverge/encoder/FrameBuilder;", "", "context", "Landroid/content/Context;", "muxerConfig", "Lco/hyperverge/encoder/MuxerConfig;", "audioTrackResource", "", "(Landroid/content/Context;Lco/hyperverge/encoder/MuxerConfig;Ljava/lang/Integer;)V", "audioExtractor", "Landroid/media/MediaExtractor;", "Ljava/lang/Integer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "frameMuxer", "Lco/hyperverge/encoder/FrameMuxer;", "mediaCodec", "Landroid/media/MediaCodec;", "mediaFormat", "Landroid/media/MediaFormat;", "rect", "Landroid/graphics/Rect;", "surface", "Landroid/view/Surface;", "createCanvas", "Landroid/graphics/Canvas;", "createFrame", "", "image", "drainCodec", "endOfStream", "", "drawBitmapAndPostCanvas", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "muxAudioFrames", "postCanvasFrame", "releaseAudioExtractor", "releaseMuxer", "releaseVideoCodec", "start", "hv-bitmaps-to-video_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FrameBuilder.kt */
public final class FrameBuilder {
    public MediaExtractor audioExtractor;
    public final Integer audioTrackResource;
    public final BufferInfo bufferInfo = new BufferInfo();
    public final Context context;
    public FrameMuxer frameMuxer = this.muxerConfig.frameMuxer;
    public final MediaCodec mediaCodec;
    public final MediaFormat mediaFormat;
    public final MuxerConfig muxerConfig;
    public Surface surface;

    public FrameBuilder(Context context2, MuxerConfig muxerConfig2, Integer num) {
        MediaExtractor mediaExtractor;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(muxerConfig2, "muxerConfig");
        this.context = context2;
        this.muxerConfig = muxerConfig2;
        this.audioTrackResource = num;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(muxerConfig2.mimeType, muxerConfig2.videoWidth, muxerConfig2.videoHeight);
        Intrinsics.checkNotNullExpressionValue(createVideoFormat, "MediaFormat.createVideoF… muxerConfig.videoHeight)");
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.muxerConfig.bitrate);
        createVideoFormat.setFloat("frame-rate", this.muxerConfig.framesPerSecond);
        createVideoFormat.setInteger("i-frame-interval", this.muxerConfig.iFrameInterval);
        this.mediaFormat = createVideoFormat;
        MediaCodec createByCodecName = MediaCodec.createByCodecName(new MediaCodecList(0).findEncoderForFormat(this.mediaFormat));
        Intrinsics.checkNotNullExpressionValue(createByCodecName, "run {\n        val codecN…odecName(codecName)\n    }");
        this.mediaCodec = createByCodecName;
        if (this.audioTrackResource != null) {
            AssetFileDescriptor openRawResourceFd = this.context.getResources().openRawResourceFd(this.audioTrackResource.intValue());
            Intrinsics.checkNotNullExpressionValue(openRawResourceFd, "context.resources.openRa…rceFd(audioTrackResource)");
            mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
        } else {
            mediaExtractor = null;
        }
        this.audioExtractor = mediaExtractor;
    }

    public final void drainCodec(boolean z) {
        int dequeueOutputBuffer;
        if (z) {
            this.mediaCodec.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
        while (true) {
            dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, (long) 10000);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer >= 0) {
                            if (outputBuffers == null) {
                                break;
                            }
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                break;
                            }
                            BufferInfo bufferInfo2 = this.bufferInfo;
                            if ((bufferInfo2.flags & 2) != 0) {
                                bufferInfo2.size = 0;
                            }
                            if (this.bufferInfo.size != 0) {
                                if (this.frameMuxer.isStarted()) {
                                    this.frameMuxer.muxVideoFrame(byteBuffer, this.bufferInfo);
                                } else {
                                    throw new RuntimeException("muxer hasn't started");
                                }
                            }
                            this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if ((this.bufferInfo.flags & 4) != 0) {
                                return;
                            }
                        } else {
                            Log.wtf("FrameBuilder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        }
                    } else if (!this.frameMuxer.isStarted()) {
                        MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                        Intrinsics.checkNotNullExpressionValue(outputFormat, "mediaCodec.outputFormat");
                        "encoder output format changed: " + outputFormat;
                        this.frameMuxer.start(outputFormat, this.audioExtractor);
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else {
                    outputBuffers = this.mediaCodec.getOutputBuffers();
                }
            } else if (!z) {
                return;
            }
        }
        throw new RuntimeException(GeneratedOutlineSupport.outline42("encoderOutputBuffer  ", dequeueOutputBuffer, " was null"));
    }
}
