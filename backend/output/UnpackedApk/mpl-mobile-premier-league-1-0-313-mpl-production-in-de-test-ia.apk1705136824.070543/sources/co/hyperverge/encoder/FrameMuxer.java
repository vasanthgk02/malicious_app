package co.hyperverge.encoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0007H&J\u001c\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0015"}, d2 = {"Lco/hyperverge/encoder/FrameMuxer;", "", "getVideoTime", "", "isStarted", "", "muxAudioFrame", "", "encodedData", "Ljava/nio/ByteBuffer;", "audioBufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "muxVideoFrame", "byteBuffer", "bufferInfo", "release", "start", "videoFormat", "Landroid/media/MediaFormat;", "audioExtractor", "Landroid/media/MediaExtractor;", "hv-bitmaps-to-video_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FrameMuxer.kt */
public interface FrameMuxer {
    boolean isStarted();

    void muxVideoFrame(ByteBuffer byteBuffer, BufferInfo bufferInfo);

    void release();

    void start(MediaFormat mediaFormat, MediaExtractor mediaExtractor);
}
