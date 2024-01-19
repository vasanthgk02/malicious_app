package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOrientation(java.io.InputStream r1, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2) throws java.io.IOException {
        /*
            r0 = this;
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface
            r2.<init>(r1)
            java.lang.String r1 = "Orientation"
            androidx.exifinterface.media.ExifInterface$ExifAttribute r1 = r2.getExifAttribute(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.nio.ByteOrder r2 = r2.mExifByteOrder     // Catch:{ NumberFormatException -> 0x0015 }
            int r1 = r1.getIntValue(r2)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r1 = 1
        L_0x0016:
            if (r1 != 0) goto L_0x0019
            r1 = -1
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser.getOrientation(java.io.InputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool):int");
    }

    public ImageType getType(InputStream inputStream) {
        return ImageType.UNKNOWN;
    }

    public ImageType getType(ByteBuffer byteBuffer) {
        return ImageType.UNKNOWN;
    }
}
