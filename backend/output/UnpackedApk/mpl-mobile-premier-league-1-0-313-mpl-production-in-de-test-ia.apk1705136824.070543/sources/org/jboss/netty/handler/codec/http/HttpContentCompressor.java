package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.compression.ZlibEncoder;
import org.jboss.netty.handler.codec.compression.ZlibWrapper;
import org.jboss.netty.handler.codec.embedder.EncoderEmbedder;

public class HttpContentCompressor extends HttpContentEncoder {
    public final int compressionLevel;

    /* renamed from: org.jboss.netty.handler.codec.http.HttpContentCompressor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                org.jboss.netty.handler.codec.compression.ZlibWrapper[] r0 = org.jboss.netty.handler.codec.compression.ZlibWrapper.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper = r0
                org.jboss.netty.handler.codec.compression.ZlibWrapper r1 = org.jboss.netty.handler.codec.compression.ZlibWrapper.GZIP     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.handler.codec.compression.ZlibWrapper r1 = org.jboss.netty.handler.codec.compression.ZlibWrapper.ZLIB     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.http.HttpContentCompressor.AnonymousClass1.<clinit>():void");
        }
    }

    public HttpContentCompressor() {
        this(6);
    }

    private ZlibWrapper determineWrapper(String str) {
        if (str.indexOf("gzip") >= 0) {
            return ZlibWrapper.GZIP;
        }
        if (str.indexOf("deflate") >= 0) {
            return ZlibWrapper.ZLIB;
        }
        return null;
    }

    public String getTargetContentEncoding(String str) throws Exception {
        ZlibWrapper determineWrapper = determineWrapper(str);
        if (determineWrapper == null) {
            return null;
        }
        int ordinal = determineWrapper.ordinal();
        if (ordinal == 0) {
            return "deflate";
        }
        if (ordinal == 1) {
            return "gzip";
        }
        throw new Error();
    }

    public EncoderEmbedder<ChannelBuffer> newContentEncoder(String str) throws Exception {
        ZlibWrapper determineWrapper = determineWrapper(str);
        if (determineWrapper == null) {
            return null;
        }
        return new EncoderEmbedder<>(new ZlibEncoder(determineWrapper, this.compressionLevel));
    }

    public HttpContentCompressor(int i) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("compressionLevel: ", i, " (expected: 0-9)"));
        }
        this.compressionLevel = i;
    }
}
