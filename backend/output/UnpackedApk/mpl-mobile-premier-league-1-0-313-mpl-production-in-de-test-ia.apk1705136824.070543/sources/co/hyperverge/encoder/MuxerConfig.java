package co.hyperverge.encoder;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003Jc\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006<"}, d2 = {"Lco/hyperverge/encoder/MuxerConfig;", "", "file", "Ljava/io/File;", "videoWidth", "", "videoHeight", "mimeType", "", "framesPerImage", "framesPerSecond", "", "bitrate", "frameMuxer", "Lco/hyperverge/encoder/FrameMuxer;", "iFrameInterval", "(Ljava/io/File;IILjava/lang/String;IFILco/hyperverge/encoder/FrameMuxer;I)V", "getBitrate", "()I", "setBitrate", "(I)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getFrameMuxer", "()Lco/hyperverge/encoder/FrameMuxer;", "setFrameMuxer", "(Lco/hyperverge/encoder/FrameMuxer;)V", "getFramesPerImage", "setFramesPerImage", "getFramesPerSecond", "()F", "setFramesPerSecond", "(F)V", "getIFrameInterval", "setIFrameInterval", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "hv-bitmaps-to-video_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: MuxerConfiguration.kt */
public final class MuxerConfig {
    public int bitrate;
    public File file;
    public FrameMuxer frameMuxer;
    public int framesPerImage;
    public float framesPerSecond;
    public int iFrameInterval;
    public String mimeType;
    public int videoHeight;
    public int videoWidth;

    public MuxerConfig(File file2, int i, int i2, String str, int i3, float f2, int i4, FrameMuxer frameMuxer2, int i5) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(str, "mimeType");
        Intrinsics.checkNotNullParameter(frameMuxer2, "frameMuxer");
        this.file = file2;
        this.videoWidth = i;
        this.videoHeight = i2;
        this.mimeType = str;
        this.framesPerImage = i3;
        this.framesPerSecond = f2;
        this.bitrate = i4;
        this.frameMuxer = frameMuxer2;
        this.iFrameInterval = i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r2.iFrameInterval == r3.iFrameInterval) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0051
            boolean r0 = r3 instanceof co.hyperverge.encoder.MuxerConfig
            if (r0 == 0) goto L_0x004f
            co.hyperverge.encoder.MuxerConfig r3 = (co.hyperverge.encoder.MuxerConfig) r3
            java.io.File r0 = r2.file
            java.io.File r1 = r3.file
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            int r0 = r2.videoWidth
            int r1 = r3.videoWidth
            if (r0 != r1) goto L_0x004f
            int r0 = r2.videoHeight
            int r1 = r3.videoHeight
            if (r0 != r1) goto L_0x004f
            java.lang.String r0 = r2.mimeType
            java.lang.String r1 = r3.mimeType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            int r0 = r2.framesPerImage
            int r1 = r3.framesPerImage
            if (r0 != r1) goto L_0x004f
            float r0 = r2.framesPerSecond
            float r1 = r3.framesPerSecond
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x004f
            int r0 = r2.bitrate
            int r1 = r3.bitrate
            if (r0 != r1) goto L_0x004f
            co.hyperverge.encoder.FrameMuxer r0 = r2.frameMuxer
            co.hyperverge.encoder.FrameMuxer r1 = r3.frameMuxer
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            int r0 = r2.iFrameInterval
            int r3 = r3.iFrameInterval
            if (r0 != r3) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r3 = 0
            return r3
        L_0x0051:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.encoder.MuxerConfig.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        File file2 = this.file;
        int i = 0;
        int hashCode = (((((file2 != null ? file2.hashCode() : 0) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31;
        String str = this.mimeType;
        int floatToIntBits = (((Float.floatToIntBits(this.framesPerSecond) + ((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.framesPerImage) * 31)) * 31) + this.bitrate) * 31;
        FrameMuxer frameMuxer2 = this.frameMuxer;
        if (frameMuxer2 != null) {
            i = frameMuxer2.hashCode();
        }
        return ((floatToIntBits + i) * 31) + this.iFrameInterval;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MuxerConfig(file=");
        outline73.append(this.file);
        outline73.append(", videoWidth=");
        outline73.append(this.videoWidth);
        outline73.append(", videoHeight=");
        outline73.append(this.videoHeight);
        outline73.append(", mimeType=");
        outline73.append(this.mimeType);
        outline73.append(", framesPerImage=");
        outline73.append(this.framesPerImage);
        outline73.append(", framesPerSecond=");
        outline73.append(this.framesPerSecond);
        outline73.append(", bitrate=");
        outline73.append(this.bitrate);
        outline73.append(", frameMuxer=");
        outline73.append(this.frameMuxer);
        outline73.append(", iFrameInterval=");
        return GeneratedOutlineSupport.outline57(outline73, this.iFrameInterval, ")");
    }
}
