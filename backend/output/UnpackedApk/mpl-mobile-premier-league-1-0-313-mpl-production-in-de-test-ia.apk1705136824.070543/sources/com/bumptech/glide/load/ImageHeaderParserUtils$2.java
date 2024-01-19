package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageHeaderParserUtils$2 implements ImageHeaderParserUtils$TypeReader {
    public final /* synthetic */ ByteBuffer val$buffer;

    public ImageHeaderParserUtils$2(ByteBuffer byteBuffer) {
        this.val$buffer = byteBuffer;
    }

    public ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
        return imageHeaderParser.getType(this.val$buffer);
    }
}
