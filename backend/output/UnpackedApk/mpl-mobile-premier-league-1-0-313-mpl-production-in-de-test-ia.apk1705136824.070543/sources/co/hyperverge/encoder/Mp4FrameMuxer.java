package co.hyperverge.encoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u001a\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lco/hyperverge/encoder/Mp4FrameMuxer;", "Lco/hyperverge/encoder/FrameMuxer;", "path", "", "fps", "", "(Ljava/lang/String;F)V", "audioTrackIndex", "", "finalVideoTime", "", "frameUsec", "muxer", "Landroid/media/MediaMuxer;", "started", "", "videoFrames", "videoTrackIndex", "getVideoTime", "isStarted", "muxAudioFrame", "", "encodedData", "Ljava/nio/ByteBuffer;", "audioBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "muxVideoFrame", "bufferInfo", "release", "start", "videoFormat", "Landroid/media/MediaFormat;", "audioExtractor", "Landroid/media/MediaExtractor;", "Companion", "hv-bitmaps-to-video_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Mp4FrameMuxer.kt */
public final class Mp4FrameMuxer implements FrameMuxer {
    public int audioTrackIndex;
    public long finalVideoTime;
    public final float fps;
    public final long frameUsec = ((long) (((float) TimeUnit.SECONDS.toMicros(1)) / this.fps));
    public final MediaMuxer muxer;
    public boolean started;
    public int videoFrames;
    public int videoTrackIndex;

    static {
        Intrinsics.checkNotNullExpressionValue(Mp4FrameMuxer.class.getSimpleName(), "Mp4FrameMuxer::class.java.simpleName");
    }

    public Mp4FrameMuxer(String str, float f2) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.fps = f2;
        this.muxer = new MediaMuxer(str, 0);
    }

    public boolean isStarted() {
        return this.started;
    }

    public void muxVideoFrame(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        Intrinsics.checkNotNullParameter(byteBuffer, "encodedData");
        Intrinsics.checkNotNullParameter(bufferInfo, "bufferInfo");
        long j = this.frameUsec;
        int i = this.videoFrames;
        this.videoFrames = i + 1;
        long j2 = j * ((long) i);
        this.finalVideoTime = j2;
        bufferInfo.presentationTimeUs = j2;
        this.muxer.writeSampleData(this.videoTrackIndex, byteBuffer, bufferInfo);
    }

    public void release() {
        this.muxer.stop();
        this.muxer.release();
    }

    public void start(MediaFormat mediaFormat, MediaExtractor mediaExtractor) {
        Intrinsics.checkNotNullParameter(mediaFormat, "videoFormat");
        if (mediaExtractor != null) {
            mediaExtractor.selectTrack(0);
        }
        MediaFormat trackFormat = mediaExtractor != null ? mediaExtractor.getTrackFormat(0) : null;
        this.videoTrackIndex = this.muxer.addTrack(mediaFormat);
        if (trackFormat != null) {
            this.audioTrackIndex = this.muxer.addTrack(trackFormat);
            trackFormat.toString();
        }
        mediaFormat.toString();
        this.muxer.start();
        this.started = true;
    }
}
