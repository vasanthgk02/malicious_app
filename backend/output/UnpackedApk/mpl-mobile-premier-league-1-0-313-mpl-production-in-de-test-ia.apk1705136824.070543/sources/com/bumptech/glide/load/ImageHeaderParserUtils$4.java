package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;

public class ImageHeaderParserUtils$4 implements ImageHeaderParserUtils$OrientationReader {
    public final /* synthetic */ ArrayPool val$byteArrayPool;
    public final /* synthetic */ InputStream val$finalIs;

    public ImageHeaderParserUtils$4(InputStream inputStream, ArrayPool arrayPool) {
        this.val$finalIs = inputStream;
        this.val$byteArrayPool = arrayPool;
    }

    public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.getOrientation(this.val$finalIs, this.val$byteArrayPool);
        } finally {
            this.val$finalIs.reset();
        }
    }
}
