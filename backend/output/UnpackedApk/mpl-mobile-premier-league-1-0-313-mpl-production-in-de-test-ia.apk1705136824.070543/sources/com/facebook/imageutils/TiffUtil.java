package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.io.IOException;
import java.io.InputStream;

public class TiffUtil {
    public static final Class<?> TAG = TiffUtil.class;

    public static int readOrientationFromTIFF(InputStream inputStream, int i) throws IOException {
        int i2;
        int i3;
        boolean z;
        int i4;
        if (i > 8) {
            int readPackedInt = ImageOriginUtils.readPackedInt(inputStream, 4, false);
            int i5 = i - 4;
            if (readPackedInt == 1229531648 || readPackedInt == 1296891946) {
                z = readPackedInt == 1229531648;
                i3 = ImageOriginUtils.readPackedInt(inputStream, 4, z);
                i2 = i5 - 4;
                if (i3 < 8 || i3 - 8 > i2) {
                    FLog.e(TAG, (String) "Invalid offset");
                    i2 = 0;
                }
                int i6 = i3 - 8;
                if (i2 == 0 && i6 <= i2) {
                    inputStream.skip((long) i6);
                    int i7 = i2 - i6;
                    if (i7 >= 14) {
                        int readPackedInt2 = ImageOriginUtils.readPackedInt(inputStream, 2, z);
                        int i8 = i7 - 2;
                        while (true) {
                            int i9 = readPackedInt2 - 1;
                            if (readPackedInt2 <= 0 || i8 < 12) {
                                break;
                            }
                            i4 = i8 - 2;
                            if (ImageOriginUtils.readPackedInt(inputStream, 2, z) == 274) {
                                break;
                            }
                            inputStream.skip(10);
                            i8 = i4 - 10;
                            readPackedInt2 = i9;
                        }
                    }
                    i4 = 0;
                    if (i4 < 10 || ImageOriginUtils.readPackedInt(inputStream, 2, z) != 3 || ImageOriginUtils.readPackedInt(inputStream, 4, z) != 1) {
                        return 0;
                    }
                    int readPackedInt3 = ImageOriginUtils.readPackedInt(inputStream, 2, z);
                    ImageOriginUtils.readPackedInt(inputStream, 2, z);
                    return readPackedInt3;
                }
            }
            FLog.e(TAG, (String) "Invalid TIFF header");
        }
        i2 = 0;
        z = false;
        i3 = 0;
        int i62 = i3 - 8;
        return i2 == 0 ? 0 : 0;
    }
}
