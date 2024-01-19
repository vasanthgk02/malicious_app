package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "BitmapPrepareProducer";
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final int mMaxBitmapSizeBytes;
    public final int mMinBitmapSizeBytes;
    public final boolean mPreparePrefetch;

    public static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final int mMaxBitmapSizeBytes;
        public final int mMinBitmapSizeBytes;

        public BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> consumer, int i, int i2) {
            super(consumer);
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
        }

        private void internalPrepareBitmap(CloseableReference<CloseableImage> closeableReference) {
            if (closeableReference != null && closeableReference.isValid()) {
                CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                if (closeableImage != null && !closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap)) {
                    Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                    if (underlyingBitmap != null) {
                        int height = underlyingBitmap.getHeight() * underlyingBitmap.getRowBytes();
                        if (height >= this.mMinBitmapSizeBytes && height <= this.mMaxBitmapSizeBytes) {
                            underlyingBitmap.prepareToDraw();
                        }
                    }
                }
            }
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            internalPrepareBitmap(closeableReference);
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer, int i, int i2, boolean z) {
        k.checkArgument(i <= i2);
        if (producer != null) {
            this.mInputProducer = producer;
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
            this.mPreparePrefetch = z;
            return;
        }
        throw null;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        if (!producerContext.isPrefetch() || this.mPreparePrefetch) {
            this.mInputProducer.produceResults(new BitmapPrepareConsumer(consumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), producerContext);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }
}
