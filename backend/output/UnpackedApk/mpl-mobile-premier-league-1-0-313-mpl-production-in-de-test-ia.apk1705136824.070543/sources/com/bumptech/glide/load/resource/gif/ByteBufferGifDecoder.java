package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils$2;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    public static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    public static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    public final Context context;
    public final GifDecoderFactory gifDecoderFactory;
    public final GifHeaderParserPool parserPool;
    public final List<ImageHeaderParser> parsers;
    public final GifBitmapProvider provider;

    public static class GifDecoderFactory {
    }

    public static class GifHeaderParserPool {
        public final Queue<GifHeaderParser> pool = Util.createQueue(0);

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.rawData = null;
            gifHeaderParser.header = null;
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        GifHeaderParserPool gifHeaderParserPool = PARSER_POOL;
        GifDecoderFactory gifDecoderFactory2 = GIF_DECODER_FACTORY;
        this.context = context2.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory2;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        GifHeaderParser gifHeaderParser;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        GifHeaderParserPool gifHeaderParserPool = this.parserPool;
        synchronized (gifHeaderParserPool) {
            GifHeaderParser poll = gifHeaderParserPool.pool.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            gifHeaderParser = poll;
            gifHeaderParser.rawData = null;
            Arrays.fill(gifHeaderParser.block, 0);
            gifHeaderParser.header = new GifHeader();
            gifHeaderParser.blockSize = 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            gifHeaderParser.rawData = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            gifHeaderParser.rawData.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            GifDrawableResource decode = decode(byteBuffer, i, i2, gifHeaderParser, options);
            return decode;
        } finally {
            this.parserPool.release(gifHeaderParser);
        }
    }

    public boolean handles(Object obj, Options options) throws IOException {
        ImageType imageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue()) {
            List<ImageHeaderParser> list = this.parsers;
            if (byteBuffer == null) {
                imageType = ImageType.UNKNOWN;
            } else {
                imageType = k.getTypeInternal(list, new ImageHeaderParserUtils$2(byteBuffer));
            }
            if (imageType == ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    public final GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        Config config;
        int i3;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.frameCount > 0) {
                if (parseHeader.status == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Config.RGB_565;
                    } else {
                        config = Config.ARGB_8888;
                    }
                    int min = Math.min(parseHeader.height / i2, parseHeader.width / i);
                    if (min == 0) {
                        i3 = 0;
                    } else {
                        i3 = Integer.highestOneBit(min);
                    }
                    int max = Math.max(1, i3);
                    Log.isLoggable("BufferGifDecoder", 2);
                    GifDecoderFactory gifDecoderFactory2 = this.gifDecoderFactory;
                    GifBitmapProvider gifBitmapProvider = this.provider;
                    if (gifDecoderFactory2 != null) {
                        StandardGifDecoder standardGifDecoder = new StandardGifDecoder(gifBitmapProvider, parseHeader, byteBuffer, max);
                        standardGifDecoder.setDefaultBitmapConfig(config);
                        standardGifDecoder.framePointer = (standardGifDecoder.framePointer + 1) % standardGifDecoder.header.frameCount;
                        Bitmap nextFrame = standardGifDecoder.getNextFrame();
                        if (nextFrame == null) {
                            if (Log.isLoggable("BufferGifDecoder", 2)) {
                                LogTime.getElapsedMillis(logTime);
                            }
                            return null;
                        }
                        GifDrawable gifDrawable = new GifDrawable(this.context, standardGifDecoder, (UnitTransformation) UnitTransformation.TRANSFORMATION, i, i2, nextFrame);
                        GifDrawableResource gifDrawableResource = new GifDrawableResource(gifDrawable);
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            LogTime.getElapsedMillis(logTime);
                        }
                        return gifDrawableResource;
                    }
                    throw null;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                LogTime.getElapsedMillis(logTime);
            }
        }
    }
}
