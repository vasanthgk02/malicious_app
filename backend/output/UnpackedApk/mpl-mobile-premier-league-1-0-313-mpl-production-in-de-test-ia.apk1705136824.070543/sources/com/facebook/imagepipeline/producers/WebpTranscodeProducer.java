package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class WebpTranscodeProducer implements Producer<EncodedImage> {
    public static final int DEFAULT_JPEG_QUALITY = 80;
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    public final Executor mExecutor;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext mContext;
        public TriState mShouldTranscodeWhenFinished = TriState.UNSET;

        public WebpTranscodeConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mContext = producerContext;
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (this.mShouldTranscodeWhenFinished == TriState.UNSET && encodedImage != null) {
                this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(encodedImage);
            }
            if (this.mShouldTranscodeWhenFinished == TriState.NO) {
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            if (BaseConsumer.isLast(i)) {
                if (this.mShouldTranscodeWhenFinished != TriState.YES || encodedImage == null) {
                    getConsumer().onNewResult(encodedImage, i);
                } else {
                    WebpTranscodeProducer.this.transcodeLastResult(encodedImage, getConsumer(), this.mContext);
                }
            }
        }
    }

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        if (executor != null) {
            this.mExecutor = executor;
            if (pooledByteBufferFactory != null) {
                this.mPooledByteBufferFactory = pooledByteBufferFactory;
                if (producer != null) {
                    this.mInputProducer = producer;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static void doTranscode(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Exception {
        InputStream inputStream = encodedImage.getInputStream();
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
        if (imageFormat_WrapIOException == DefaultImageFormats.WEBP_SIMPLE || imageFormat_WrapIOException == DefaultImageFormats.WEBP_EXTENDED) {
            WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(inputStream, pooledByteBufferOutputStream, 80);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
        } else if (imageFormat_WrapIOException == DefaultImageFormats.WEBP_LOSSLESS || imageFormat_WrapIOException == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
            WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(inputStream, pooledByteBufferOutputStream);
            encodedImage.setImageFormat(DefaultImageFormats.PNG);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }

    public static TriState shouldTranscode(EncodedImage encodedImage) {
        if (encodedImage != null) {
            ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            if (DefaultImageFormats.isStaticWebpFormat(imageFormat_WrapIOException)) {
                WebpTranscoder webpTranscoder = WebpTranscoderFactory.getWebpTranscoder();
                if (webpTranscoder == null) {
                    return TriState.NO;
                }
                return TriState.valueOf(!webpTranscoder.isWebpNativelySupported(imageFormat_WrapIOException));
            } else if (imageFormat_WrapIOException == ImageFormat.UNKNOWN) {
                return TriState.UNSET;
            } else {
                return TriState.NO;
            }
        } else {
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public void transcodeLastResult(EncodedImage encodedImage, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (encodedImage != null) {
            final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            AnonymousClass1 r0 = new StatefulProducerRunnable<EncodedImage>(consumer, producerContext.getProducerListener(), producerContext, PRODUCER_NAME) {
                public void onCancellation() {
                    EncodedImage.closeSafely(cloneOrNull);
                    super.onCancellation();
                }

                public void onFailure(Exception exc) {
                    EncodedImage.closeSafely(cloneOrNull);
                    super.onFailure(exc);
                }

                public void disposeResult(EncodedImage encodedImage) {
                    EncodedImage.closeSafely(encodedImage);
                }

                public EncodedImage getResult() throws Exception {
                    CloseableReference of;
                    PooledByteBufferOutputStream newOutputStream = WebpTranscodeProducer.this.mPooledByteBufferFactory.newOutputStream();
                    try {
                        WebpTranscodeProducer.doTranscode(cloneOrNull, newOutputStream);
                        of = CloseableReference.of(newOutputStream.toByteBuffer());
                        EncodedImage encodedImage = new EncodedImage(of);
                        encodedImage.copyMetaDataFrom(cloneOrNull);
                        if (of != null) {
                            of.close();
                        }
                        newOutputStream.close();
                        return encodedImage;
                    } catch (Throwable th) {
                        newOutputStream.close();
                        throw th;
                    }
                }

                public void onSuccess(EncodedImage encodedImage) {
                    EncodedImage.closeSafely(cloneOrNull);
                    super.onSuccess(encodedImage);
                }
            };
            this.mExecutor.execute(r0);
            return;
        }
        throw null;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new WebpTranscodeConsumer(consumer, producerContext), producerContext);
    }
}
