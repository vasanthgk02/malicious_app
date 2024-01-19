package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.io.InputStream;

public class ImageHeaderParserUtils$1 implements ImageHeaderParserUtils$TypeReader {
    public final /* synthetic */ InputStream val$finalIs;

    public ImageHeaderParserUtils$1(InputStream inputStream) {
        this.val$finalIs = inputStream;
    }

    public ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.getType(this.val$finalIs);
        } finally {
            this.val$finalIs.reset();
        }
    }
}
