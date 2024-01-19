package co.hyperverge.encoder;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import io.antmedia.android.broadcaster.encoder.VideoEncoderCore;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\r\u001a\u00020\u0005J%\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J+\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lco/hyperverge/encoder/Muxer;", "", "context", "Landroid/content/Context;", "config", "Lco/hyperverge/encoder/MuxerConfig;", "(Landroid/content/Context;Lco/hyperverge/encoder/MuxerConfig;)V", "file", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "muxerConfig", "muxingCompletionListener", "Lco/hyperverge/encoder/MuxingCompletionListener;", "getMuxerConfig", "mux", "Lco/hyperverge/encoder/MuxingResult;", "imageList", "", "audioTrack", "", "(Ljava/util/List;Ljava/lang/Integer;)Lco/hyperverge/encoder/MuxingResult;", "muxAsync", "(Ljava/util/List;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMuxerConfig", "", "setOnMuxingCompletedListener", "Companion", "hv-bitmaps-to-video_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Muxer.kt */
public final class Muxer {
    public final Context context;
    public final File file;
    public MuxerConfig muxerConfig;
    public MuxingCompletionListener muxingCompletionListener;

    public Muxer(Context context2, File file2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(file2, "file");
        this.context = context2;
        this.file = file2;
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        MuxerConfig muxerConfig2 = new MuxerConfig(file2, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 240, VideoEncoderCore.MIME_TYPE, 1, 10.0f, 1500000, new Mp4FrameMuxer(absolutePath, 10.0f), 10);
        this.muxerConfig = muxerConfig2;
    }
}
