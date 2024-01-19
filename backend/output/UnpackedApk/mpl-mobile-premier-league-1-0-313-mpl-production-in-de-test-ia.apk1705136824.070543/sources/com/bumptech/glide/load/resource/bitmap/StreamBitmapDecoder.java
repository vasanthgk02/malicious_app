package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    public final ArrayPool byteArrayPool;
    public final Downsampler downsampler;

    public static class UntrustedCallbacks implements DecodeCallbacks {
        public final RecyclableBufferedInputStream bufferedStream;
        public final ExceptionCatchingInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionCatchingInputStream;
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException iOException = this.exceptionStream.exception;
            if (iOException != null) {
                if (bitmap != null) {
                    bitmapPool.put(bitmap);
                }
                throw iOException;
            }
        }

        public void onObtainBounds() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.bufferedStream;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.marklimit = recyclableBufferedInputStream.buf.length;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler2, ArrayPool arrayPool) {
        this.downsampler = downsampler2;
        this.byteArrayPool = arrayPool;
    }

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        ExceptionCatchingInputStream poll;
        InputStream inputStream = (InputStream) obj;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            z = true;
        }
        synchronized (ExceptionCatchingInputStream.QUEUE) {
            poll = ExceptionCatchingInputStream.QUEUE.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.wrapped = recyclableBufferedInputStream;
        try {
            return this.downsampler.decode((InputStream) new MarkEnforcingInputStream(poll), i, i2, options, (DecodeCallbacks) new UntrustedCallbacks(recyclableBufferedInputStream, poll));
        } finally {
            poll.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    public boolean handles(Object obj, Options options) throws IOException {
        InputStream inputStream = (InputStream) obj;
        if (this.downsampler != null) {
            return true;
        }
        throw null;
    }
}
