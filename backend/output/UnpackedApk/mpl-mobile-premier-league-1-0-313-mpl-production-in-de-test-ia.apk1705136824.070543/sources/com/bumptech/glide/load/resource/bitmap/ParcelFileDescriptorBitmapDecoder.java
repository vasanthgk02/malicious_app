package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.ImageReader.ParcelFileDescriptorImageReader;
import java.io.IOException;

public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    public final Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler2) {
        this.downsampler = downsampler2;
    }

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        Downsampler downsampler2 = this.downsampler;
        return downsampler2.decode((ImageReader) new ParcelFileDescriptorImageReader((ParcelFileDescriptor) obj, downsampler2.parsers, downsampler2.byteArrayPool), i, i2, options, Downsampler.EMPTY_CALLBACKS);
    }

    public boolean handles(Object obj, Options options) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        if (this.downsampler != null) {
            return true;
        }
        throw null;
    }
}
