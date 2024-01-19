package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;

public class ImageDecodeOptions {
    public static final ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final Config bitmapConfig;
    public final BitmapTransformation bitmapTransformation;
    public final ColorSpace colorSpace;
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    public final boolean forceStaticImage;
    public final int maxDimensionPx;
    public final int minDecodeIntervalMs;
    public final boolean useLastFrameForPreview;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.maxDimensionPx = imageDecodeOptionsBuilder.getMaxDimensionPx();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
        this.bitmapTransformation = imageDecodeOptionsBuilder.getBitmapTransformation();
        this.colorSpace = imageDecodeOptionsBuilder.getColorSpace();
    }

    public static ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImageDecodeOptions.class != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.minDecodeIntervalMs == imageDecodeOptions.minDecodeIntervalMs && this.maxDimensionPx == imageDecodeOptions.maxDimensionPx && this.decodePreviewFrame == imageDecodeOptions.decodePreviewFrame && this.useLastFrameForPreview == imageDecodeOptions.useLastFrameForPreview && this.decodeAllFrames == imageDecodeOptions.decodeAllFrames && this.forceStaticImage == imageDecodeOptions.forceStaticImage && this.bitmapConfig == imageDecodeOptions.bitmapConfig && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation && this.colorSpace == imageDecodeOptions.colorSpace;
    }

    public int hashCode() {
        int ordinal = (this.bitmapConfig.ordinal() + (((((((((((this.minDecodeIntervalMs * 31) + this.maxDimensionPx) * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0)) * 31)) * 31;
        ImageDecoder imageDecoder = this.customImageDecoder;
        int i = 0;
        int hashCode = (ordinal + (imageDecoder != null ? imageDecoder.hashCode() : 0)) * 31;
        BitmapTransformation bitmapTransformation2 = this.bitmapTransformation;
        int hashCode2 = (hashCode + (bitmapTransformation2 != null ? bitmapTransformation2.hashCode() : 0)) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        if (colorSpace2 != null) {
            i = colorSpace2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ImageDecodeOptions{");
        outline73.append(toStringHelper().toString());
        outline73.append("}");
        return outline73.toString();
    }

    public Objects$ToStringHelper toStringHelper() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        stringHelper.add((String) "minDecodeIntervalMs", this.minDecodeIntervalMs);
        stringHelper.add((String) "maxDimensionPx", this.maxDimensionPx);
        stringHelper.add((String) "decodePreviewFrame", this.decodePreviewFrame);
        stringHelper.add((String) "useLastFrameForPreview", this.useLastFrameForPreview);
        stringHelper.add((String) "decodeAllFrames", this.decodeAllFrames);
        stringHelper.add((String) "forceStaticImage", this.forceStaticImage);
        stringHelper.addHolder("bitmapConfigName", this.bitmapConfig.name());
        stringHelper.addHolder("customImageDecoder", this.customImageDecoder);
        stringHelper.addHolder("bitmapTransformation", this.bitmapTransformation);
        stringHelper.addHolder("colorSpace", this.colorSpace);
        return stringHelper;
    }
}
