package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<Source, T> {
    public final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();

    public boolean handles(Object obj, Options options) throws IOException {
        Source source = (Source) obj;
        return true;
    }

    public final Resource<T> decode(Source source, int i, int i2, Options options) throws IOException {
        final DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        final boolean z = options.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE);
        final int i3 = i;
        final int i4 = i2;
        AnonymousClass1 r1 = new OnHeaderDecodedListener() {
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageInfo imageInfo, Source source) {
                boolean z = false;
                if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i3, i4, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new OnPartialImageListener(this) {
                    public boolean onPartialImage(DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i = i3;
                if (i == Integer.MIN_VALUE) {
                    i = size.getWidth();
                }
                int i2 = i4;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = size.getHeight();
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i, i2);
                int round = Math.round(((float) size.getWidth()) * scaleFactor);
                int round2 = Math.round(scaleFactor * ((float) size.getHeight()));
                if (Log.isLoggable("ImageDecoder", 2)) {
                    size.getWidth();
                    size.getHeight();
                }
                imageDecoder.setTargetSize(round, round2);
                int i3 = VERSION.SDK_INT;
                if (i3 >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z = true;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(z ? Named.DISPLAY_P3 : Named.SRGB));
                } else if (i3 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(Named.SRGB));
                }
            }
        };
        BitmapImageDecoderResourceDecoder bitmapImageDecoderResourceDecoder = (BitmapImageDecoderResourceDecoder) this;
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, r1);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            decodeBitmap.getWidth();
            decodeBitmap.getHeight();
        }
        return new BitmapResource(decodeBitmap, bitmapImageDecoderResourceDecoder.bitmapPool);
    }
}
