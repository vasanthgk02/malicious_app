package org.jboss.netty.handler.codec.compression;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

public final class ZlibUtil {

    /* renamed from: org.jboss.netty.handler.codec.compression.ZlibUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                org.jboss.netty.handler.codec.compression.ZlibWrapper[] r0 = org.jboss.netty.handler.codec.compression.ZlibWrapper.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper = r0
                r1 = 1
                r2 = 2
                org.jboss.netty.handler.codec.compression.ZlibWrapper r3 = org.jboss.netty.handler.codec.compression.ZlibWrapper.NONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.handler.codec.compression.ZlibWrapper r3 = org.jboss.netty.handler.codec.compression.ZlibWrapper.ZLIB     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3 = 0
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = $SwitchMap$org$jboss$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.handler.codec.compression.ZlibWrapper r2 = org.jboss.netty.handler.codec.compression.ZlibWrapper.GZIP     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.compression.ZlibUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Enum<?> convertWrapperType(ZlibWrapper zlibWrapper) {
        int ordinal = zlibWrapper.ordinal();
        if (ordinal == 0) {
            return JZlib.W_ZLIB;
        }
        if (ordinal == 1) {
            return JZlib.W_GZIP;
        }
        if (ordinal == 2) {
            return JZlib.W_NONE;
        }
        throw new Error();
    }

    public static CompressionException exception(ZStream zStream, String str, int i) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(i);
        sb.append(")");
        if (zStream.msg != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(": ");
            outline73.append(zStream.msg);
            str2 = outline73.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        return new CompressionException(sb.toString());
    }

    public static void fail(ZStream zStream, String str, int i) {
        throw exception(zStream, str, i);
    }
}
