package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils$3;
import com.bumptech.glide.load.ImageHeaderParserUtils$5;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ImageReader {

    public static final class InputStreamImageReader implements ImageReader {
        public final ArrayPool byteArrayPool;
        public final InputStreamRewinder dataRewinder;
        public final List<ImageHeaderParser> parsers;

        public InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            k.checkNotNull(arrayPool, (String) "Argument must not be null");
            this.byteArrayPool = arrayPool;
            k.checkNotNull(list, (String) "Argument must not be null");
            this.parsers = list;
            this.dataRewinder = new InputStreamRewinder(inputStream, arrayPool);
        }

        public Bitmap decodeBitmap(Options options) throws IOException {
            return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
        }

        public int getImageOrientation() throws IOException {
            return k.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        public ImageType getImageType() throws IOException {
            return k.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        public void stopGrowingBuffers() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.dataRewinder.bufferedStream;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.marklimit = recyclableBufferedInputStream.buf.length;
            }
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        public final ArrayPool byteArrayPool;
        public final ParcelFileDescriptorRewinder dataRewinder;
        public final List<ImageHeaderParser> parsers;

        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            k.checkNotNull(arrayPool, (String) "Argument must not be null");
            this.byteArrayPool = arrayPool;
            k.checkNotNull(list, (String) "Argument must not be null");
            this.parsers = list;
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public Bitmap decodeBitmap(Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
        }

        public int getImageOrientation() throws IOException {
            return k.getOrientationInternal(this.parsers, new ImageHeaderParserUtils$5(this.dataRewinder, this.byteArrayPool));
        }

        public ImageType getImageType() throws IOException {
            return k.getTypeInternal(this.parsers, new ImageHeaderParserUtils$3(this.dataRewinder, this.byteArrayPool));
        }

        public void stopGrowingBuffers() {
        }
    }

    Bitmap decodeBitmap(Options options) throws IOException;

    int getImageOrientation() throws IOException;

    ImageType getImageType() throws IOException;

    void stopGrowingBuffers();
}
