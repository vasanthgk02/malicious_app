package com.facebook.imagepipeline.producers;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public static final String INPUT_IMAGE_FORMAT = "Image format";
    public static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    public static final String ORIGINAL_SIZE_KEY = "Original size";
    public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    public static final String REQUESTED_SIZE_KEY = "Requested size";
    public static final String TRANSCODER_ID = "Transcoder id";
    public static final String TRANSCODING_RESULT = "Transcoding result";
    public final Executor mExecutor;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final boolean mIsResizingEnabled;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ImageTranscoderFactory mImageTranscoderFactory;
        public boolean mIsCancelled = false;
        public final boolean mIsResizingEnabled;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobRunnable(ResizeAndRotateProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    ImageTranscoder createImageTranscoder = transformingConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), TransformingConsumer.this.mIsResizingEnabled);
                    k.checkNotNull1(createImageTranscoder);
                    transformingConsumer.doTransform(encodedImage, i, createImageTranscoder);
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this) {
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }

                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void doTransform(EncodedImage encodedImage, int i, ImageTranscoder imageTranscoder) {
            EncodedImage encodedImage2;
            this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            Map<String, String> map = null;
            try {
                ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, Integer.valueOf(85));
                if (transcode.getTranscodeStatus() != 2) {
                    map = getExtraMap(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    try {
                        encodedImage2 = new EncodedImage(of);
                        encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                        encodedImage2.parseMetaData();
                        this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, map);
                        if (transcode.getTranscodeStatus() != 1) {
                            i |= 16;
                        }
                        getConsumer().onNewResult(encodedImage2, i);
                        EncodedImage.closeSafely(encodedImage2);
                        if (of != null) {
                            of.close();
                        }
                        newOutputStream.close();
                    } catch (Throwable th) {
                        if (of != null) {
                            of.close();
                        }
                        throw th;
                    }
                } else {
                    throw new RuntimeException("Error while transcoding the image");
                }
            } catch (Exception e2) {
                try {
                    this.mProducerContext.getProducerListener().onProducerFinishWithFailure(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, e2, map);
                    if (BaseConsumer.isLast(i)) {
                        getConsumer().onFailure(e2);
                    }
                } finally {
                    newOutputStream.close();
                }
            }
        }

        private void forwardNewResult(EncodedImage encodedImage, int i, ImageFormat imageFormat) {
            EncodedImage encodedImage2;
            if (imageFormat == DefaultImageFormats.JPEG || imageFormat == DefaultImageFormats.HEIF) {
                encodedImage2 = getNewResultsForJpegOrHeif(encodedImage);
            } else {
                encodedImage2 = getNewResultForImagesWithoutExifData(encodedImage);
            }
            getConsumer().onNewResult(encodedImage2, i);
        }

        private EncodedImage getCloneWithRotationApplied(EncodedImage encodedImage, int i) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            if (cloneOrNull != null) {
                cloneOrNull.setRotationAngle(i);
            }
            return cloneOrNull;
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME)) {
                return null;
            }
            String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ResizeAndRotateProducer.INPUT_IMAGE_FORMAT, String.valueOf(encodedImage.getImageFormat()));
            hashMap.put(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, str3);
            hashMap.put(ResizeAndRotateProducer.REQUESTED_SIZE_KEY, str2);
            hashMap.put(JobScheduler.QUEUE_TIME_KEY, String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put(ResizeAndRotateProducer.TRANSCODER_ID, str);
            hashMap.put(ResizeAndRotateProducer.TRANSCODING_RESULT, String.valueOf(imageTranscodeResult));
            return new ImmutableMap(hashMap);
        }

        private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage encodedImage) {
            RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
            return (rotationOptions.useImageMetadata() || !rotationOptions.rotationEnabled()) ? encodedImage : getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
        }

        private EncodedImage getNewResultsForJpegOrHeif(EncodedImage encodedImage) {
            return (this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1) ? encodedImage : getCloneWithRotationApplied(encodedImage, 0);
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!this.mIsCancelled) {
                boolean isLast = BaseConsumer.isLast(i);
                if (encodedImage == null) {
                    if (isLast) {
                        getConsumer().onNewResult(null, 1);
                    }
                    return;
                }
                ImageFormat imageFormat = encodedImage.getImageFormat();
                ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                ImageTranscoder createImageTranscoder = this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled);
                k.checkNotNull1(createImageTranscoder);
                TriState access$700 = ResizeAndRotateProducer.shouldTransform(imageRequest, encodedImage, createImageTranscoder);
                if (!isLast && access$700 == TriState.UNSET) {
                    return;
                }
                if (access$700 != TriState.YES) {
                    forwardNewResult(encodedImage, i, imageFormat);
                } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                    if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        if (executor != null) {
            this.mExecutor = executor;
            if (pooledByteBufferFactory != null) {
                this.mPooledByteBufferFactory = pooledByteBufferFactory;
                if (producer != null) {
                    this.mInputProducer = producer;
                    if (imageTranscoderFactory != null) {
                        this.mImageTranscoderFactory = imageTranscoderFactory;
                        this.mIsResizingEnabled = z;
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        return !rotationOptions.canDeferUntilRendered() && (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage));
    }

    public static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
            return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
        }
        encodedImage.setExifOrientation(0);
        return false;
    }

    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
            return TriState.NO;
        }
        return TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions()));
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Producer<EncodedImage> producer = this.mInputProducer;
        TransformingConsumer transformingConsumer = new TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory);
        producer.produceResults(transformingConsumer, producerContext);
    }
}
