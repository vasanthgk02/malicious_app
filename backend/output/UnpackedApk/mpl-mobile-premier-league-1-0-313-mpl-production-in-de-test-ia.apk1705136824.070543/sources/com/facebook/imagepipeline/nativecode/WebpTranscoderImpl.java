package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class WebpTranscoderImpl implements WebpTranscoder {
    @DoNotStrip
    public static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @DoNotStrip
    public static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    public boolean isWebpNativelySupported(ImageFormat imageFormat) {
        if (imageFormat == DefaultImageFormats.WEBP_SIMPLE) {
            return true;
        }
        if (imageFormat == DefaultImageFormats.WEBP_LOSSLESS || imageFormat == DefaultImageFormats.WEBP_EXTENDED || imageFormat == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
            boolean z = WebpSupportStatus.sIsExtendedWebpSupported;
            return true;
        } else if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
            return false;
        } else {
            throw new IllegalArgumentException("Image format is not a WebP.");
        }
    }

    public void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        StaticWebpNativeLoader.ensure();
        if (inputStream == null) {
            throw null;
        } else if (outputStream != null) {
            nativeTranscodeWebpToJpeg(inputStream, outputStream, i);
        } else {
            throw null;
        }
    }

    public void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException {
        StaticWebpNativeLoader.ensure();
        if (inputStream == null) {
            throw null;
        } else if (outputStream != null) {
            nativeTranscodeWebpToPng(inputStream, outputStream);
        } else {
            throw null;
        }
    }
}
