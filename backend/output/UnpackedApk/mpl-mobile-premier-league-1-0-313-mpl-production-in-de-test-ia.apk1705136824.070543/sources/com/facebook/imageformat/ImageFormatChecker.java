package com.facebook.imageformat;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.imageformat.ImageFormat.FormatChecker;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImageFormatChecker {
    public static ImageFormatChecker sInstance;
    public List<FormatChecker> mCustomImageFormatCheckers;
    public final FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    public int mMaxHeaderLength;

    public ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        int i;
        ImageFormatChecker instance = getInstance();
        if (inputStream != null) {
            int i2 = instance.mMaxHeaderLength;
            byte[] bArr = new byte[i2];
            k.checkArgument(i2 >= i2);
            if (inputStream.markSupported()) {
                try {
                    inputStream.mark(i2);
                    i = k.read(inputStream, bArr, 0, i2);
                } finally {
                    inputStream.reset();
                }
            } else {
                i = k.read(inputStream, bArr, 0, i2);
            }
            ImageFormat determineFormat = instance.mDefaultFormatChecker.determineFormat(bArr, i);
            if (determineFormat != null && determineFormat != ImageFormat.UNKNOWN) {
                return determineFormat;
            }
            List<FormatChecker> list = instance.mCustomImageFormatCheckers;
            if (list != null) {
                for (FormatChecker determineFormat2 : list) {
                    ImageFormat determineFormat3 = determineFormat2.determineFormat(bArr, i);
                    if (determineFormat3 != null && determineFormat3 != ImageFormat.UNKNOWN) {
                        return determineFormat3;
                    }
                }
            }
            return ImageFormat.UNKNOWN;
        }
        throw null;
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e2) {
            k.propagateIfPossible(e2);
            throw new RuntimeException(e2);
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ImageFormatChecker();
                }
                imageFormatChecker = sInstance;
            }
        }
        return imageFormatChecker;
    }

    public final void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (FormatChecker headerSize : list) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, headerSize.getHeaderSize());
            }
        }
    }
}
