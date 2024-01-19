package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imageutils.BitmapUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_BYTES = "byteCount";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final int MAX_BITMAP_SIZE = 104857600;
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    public final ByteArrayPool mByteArrayPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final boolean mDecodeCancellationEnabled;
    public final boolean mDownsampleEnabled;
    public final boolean mDownsampleEnabledForNetwork;
    public final Executor mExecutor;
    public final ImageDecoder mImageDecoder;
    public final Producer<EncodedImage> mInputProducer;
    public final int mMaxBitmapSize;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;

    public class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer, producerContext, z, i);
        }

        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        public QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.of(0, false, false);
        }

        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return false;
            }
            return super.updateDecodeJob(encodedImage, i);
        }
    }

    public class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        public int mLastScheduledScanNumber;
        public final ProgressiveJpegConfig mProgressiveJpegConfig;
        public final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i) {
            super(consumer, producerContext, z, i);
            if (progressiveJpegParser != null) {
                this.mProgressiveJpegParser = progressiveJpegParser;
                if (progressiveJpegConfig != null) {
                    this.mProgressiveJpegConfig = progressiveJpegConfig;
                    this.mLastScheduledScanNumber = 0;
                    return;
                }
                throw null;
            }
            throw null;
        }

        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.getBestScanEndOffset();
        }

        public QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage r4, int r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = super.updateDecodeJob(r4, r5)     // Catch:{ all -> 0x0057 }
                boolean r1 = com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(r5)     // Catch:{ all -> 0x0057 }
                if (r1 != 0) goto L_0x0013
                r1 = 8
                boolean r1 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r5, r1)     // Catch:{ all -> 0x0057 }
                if (r1 == 0) goto L_0x0055
            L_0x0013:
                r1 = 4
                boolean r5 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r5, r1)     // Catch:{ all -> 0x0057 }
                if (r5 != 0) goto L_0x0055
                boolean r5 = com.facebook.imagepipeline.image.EncodedImage.isValid(r4)     // Catch:{ all -> 0x0057 }
                if (r5 == 0) goto L_0x0055
                com.facebook.imageformat.ImageFormat r5 = r4.getImageFormat()     // Catch:{ all -> 0x0057 }
                com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.JPEG     // Catch:{ all -> 0x0057 }
                if (r5 != r1) goto L_0x0055
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r5 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0057 }
                boolean r4 = r5.parseMoreData(r4)     // Catch:{ all -> 0x0057 }
                r5 = 0
                if (r4 != 0) goto L_0x0033
                monitor-exit(r3)
                return r5
            L_0x0033:
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r4 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0057 }
                int r4 = r4.getBestScanNumber()     // Catch:{ all -> 0x0057 }
                int r1 = r3.mLastScheduledScanNumber     // Catch:{ all -> 0x0057 }
                if (r4 > r1) goto L_0x003f
                monitor-exit(r3)
                return r5
            L_0x003f:
                com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r1 = r3.mProgressiveJpegConfig     // Catch:{ all -> 0x0057 }
                int r2 = r3.mLastScheduledScanNumber     // Catch:{ all -> 0x0057 }
                int r1 = r1.getNextScanNumberToDecode(r2)     // Catch:{ all -> 0x0057 }
                if (r4 >= r1) goto L_0x0053
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r1 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0057 }
                boolean r1 = r1.isEndMarkerRead()     // Catch:{ all -> 0x0057 }
                if (r1 != 0) goto L_0x0053
                monitor-exit(r3)
                return r5
            L_0x0053:
                r3.mLastScheduledScanNumber = r4     // Catch:{ all -> 0x0057 }
            L_0x0055:
                monitor-exit(r3)
                return r0
            L_0x0057:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.NetworkImagesProgressiveDecoder.updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage, int):boolean");
        }
    }

    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        public final String TAG = "ProgressiveDecoder";
        public final ImageDecodeOptions mImageDecodeOptions;
        public boolean mIsFinished;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        public final ProducerListener2 mProducerListener;

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z, final int i) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getProducerListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobRunnable(DecodeProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    if (encodedImage != null) {
                        if (DecodeProducer.this.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i, 16)) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), encodedImage, i));
                            }
                        }
                        if (producerContext.getImagePipelineConfig().getExperiments().shouldDownsampleIfLargeBitmap()) {
                            ProgressiveDecoder.this.maybeIncreaseSampleSize(encodedImage);
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i);
                    }
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this) {
                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }

                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A[Catch:{ all -> 0x0168 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb A[Catch:{ all -> 0x0168 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doDecode(com.facebook.imagepipeline.image.EncodedImage r19, int r20) {
            /*
                r18 = this;
                r11 = r18
                r0 = r20
                java.lang.String r12 = "DecodeProducer"
                com.facebook.imageformat.ImageFormat r1 = r19.getImageFormat()
                com.facebook.imageformat.ImageFormat r2 = com.facebook.imageformat.DefaultImageFormats.JPEG
                if (r1 == r2) goto L_0x0015
                boolean r1 = com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(r20)
                if (r1 == 0) goto L_0x0015
                return
            L_0x0015:
                boolean r1 = r18.isFinished()
                if (r1 != 0) goto L_0x016d
                boolean r1 = com.facebook.imagepipeline.image.EncodedImage.isValid(r19)
                if (r1 != 0) goto L_0x0023
                goto L_0x016d
            L_0x0023:
                com.facebook.imageformat.ImageFormat r1 = r19.getImageFormat()
                java.lang.String r2 = "unknown"
                if (r1 == 0) goto L_0x002f
                java.lang.String r1 = r1.mName
                r7 = r1
                goto L_0x0030
            L_0x002f:
                r7 = r2
            L_0x0030:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r3 = r19.getWidth()
                r1.append(r3)
                java.lang.String r3 = "x"
                r1.append(r3)
                int r4 = r19.getHeight()
                r1.append(r4)
                java.lang.String r8 = r1.toString()
                int r1 = r19.getSampleSize()
                java.lang.String r10 = java.lang.String.valueOf(r1)
                boolean r6 = com.facebook.imagepipeline.producers.BaseConsumer.isLast(r20)
                if (r6 == 0) goto L_0x0064
                r5 = 8
                boolean r5 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r0, r5)
                if (r5 != 0) goto L_0x0064
                r5 = 1
                goto L_0x0065
            L_0x0064:
                r5 = 0
            L_0x0065:
                r9 = 4
                boolean r13 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r0, r9)
                com.facebook.imagepipeline.producers.ProducerContext r14 = r11.mProducerContext
                com.facebook.imagepipeline.request.ImageRequest r14 = r14.getImageRequest()
                com.facebook.imagepipeline.common.ResizeOptions r14 = r14.getResizeOptions()
                if (r14 == 0) goto L_0x008c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                int r15 = r14.width
                r2.append(r15)
                r2.append(r3)
                int r3 = r14.height
                r2.append(r3)
                java.lang.String r2 = r2.toString()
            L_0x008c:
                r14 = r2
                com.facebook.imagepipeline.producers.JobScheduler r2 = r11.mJobScheduler     // Catch:{ all -> 0x0168 }
                long r15 = r2.getQueuedTime()     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r2 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.request.ImageRequest r2 = r2.getImageRequest()     // Catch:{ all -> 0x0168 }
                android.net.Uri r2 = r2.getSourceUri()     // Catch:{ all -> 0x0168 }
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0168 }
                if (r5 != 0) goto L_0x00ab
                if (r13 == 0) goto L_0x00a6
                goto L_0x00ab
            L_0x00a6:
                int r3 = r18.getIntermediateImageEndOffset(r19)     // Catch:{ all -> 0x0168 }
                goto L_0x00af
            L_0x00ab:
                int r3 = r19.getSize()     // Catch:{ all -> 0x0168 }
            L_0x00af:
                if (r5 != 0) goto L_0x00b9
                if (r13 == 0) goto L_0x00b4
                goto L_0x00b9
            L_0x00b4:
                com.facebook.imagepipeline.image.QualityInfo r5 = r18.getQualityInfo()     // Catch:{ all -> 0x0168 }
                goto L_0x00bb
            L_0x00b9:
                com.facebook.imagepipeline.image.QualityInfo r5 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY     // Catch:{ all -> 0x0168 }
            L_0x00bb:
                com.facebook.imagepipeline.producers.ProducerListener2 r13 = r11.mProducerListener     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r1 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                r13.onProducerStart(r1, r12)     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.DecodeProducer r1 = com.facebook.imagepipeline.producers.DecodeProducer.this     // Catch:{ DecodeException -> 0x0122 }
                com.facebook.imagepipeline.decoder.ImageDecoder r1 = r1.mImageDecoder     // Catch:{ DecodeException -> 0x0122 }
                com.facebook.imagepipeline.common.ImageDecodeOptions r13 = r11.mImageDecodeOptions     // Catch:{ DecodeException -> 0x0122 }
                r4 = r19
                com.facebook.imagepipeline.image.CloseableImage r13 = r1.decode(r4, r3, r5, r13)     // Catch:{ DecodeException -> 0x0122 }
                int r1 = r19.getSampleSize()     // Catch:{ Exception -> 0x011d }
                r2 = 1
                if (r1 == r2) goto L_0x00d9
                r0 = r0 | 16
            L_0x00d9:
                r1 = r18
                r2 = r13
                r3 = r15
                r9 = r14
                java.util.Map r1 = r1.getExtraMap(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerListener2 r2 = r11.mProducerListener     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r3 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                r2.onProducerFinishWithSuccess(r3, r12, r1)     // Catch:{ all -> 0x0168 }
                if (r13 == 0) goto L_0x0116
                com.facebook.imagepipeline.image.OriginalEncodedImageInfo r1 = new com.facebook.imagepipeline.image.OriginalEncodedImageInfo     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r2 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.request.ImageRequest r2 = r2.getImageRequest()     // Catch:{ all -> 0x0168 }
                android.net.Uri r5 = r2.getSourceUri()     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r2 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.image.EncodedImageOrigin r6 = r2.getEncodedImageOrigin()     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r2 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                java.lang.Object r7 = r2.getCallerContext()     // Catch:{ all -> 0x0168 }
                int r8 = r19.getWidth()     // Catch:{ all -> 0x0168 }
                int r9 = r19.getHeight()     // Catch:{ all -> 0x0168 }
                int r10 = r19.getSize()     // Catch:{ all -> 0x0168 }
                r4 = r1
                r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0168 }
                r13.setOriginalEncodedImageInfo(r1)     // Catch:{ all -> 0x0168 }
            L_0x0116:
                r11.handleResult(r13, r0)     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r19)
                return
            L_0x011d:
                r0 = move-exception
                r2 = r13
                goto L_0x0152
            L_0x0120:
                r0 = move-exception
                goto L_0x0150
            L_0x0122:
                r0 = move-exception
                com.facebook.imagepipeline.image.EncodedImage r1 = r0.getEncodedImage()     // Catch:{ Exception -> 0x0120 }
                java.lang.String r3 = "ProgressiveDecoder"
                java.lang.String r4 = "%s, {uri: %s, firstEncodedBytes: %s, length: %d}"
                java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0120 }
                java.lang.String r13 = r0.getMessage()     // Catch:{ Exception -> 0x0120 }
                r17 = 0
                r9[r17] = r13     // Catch:{ Exception -> 0x0120 }
                r13 = 1
                r9[r13] = r2     // Catch:{ Exception -> 0x0120 }
                r2 = 2
                r13 = 10
                java.lang.String r13 = r1.getFirstBytesAsHexString(r13)     // Catch:{ Exception -> 0x0120 }
                r9[r2] = r13     // Catch:{ Exception -> 0x0120 }
                r2 = 3
                int r1 = r1.getSize()     // Catch:{ Exception -> 0x0120 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0120 }
                r9[r2] = r1     // Catch:{ Exception -> 0x0120 }
                com.facebook.common.logging.FLog.w(r3, r4, r9)     // Catch:{ Exception -> 0x0120 }
                throw r0     // Catch:{ Exception -> 0x0120 }
            L_0x0150:
                r1 = 0
                r2 = r1
            L_0x0152:
                r1 = r18
                r3 = r15
                r9 = r14
                java.util.Map r1 = r1.getExtraMap(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerListener2 r2 = r11.mProducerListener     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.producers.ProducerContext r3 = r11.mProducerContext     // Catch:{ all -> 0x0168 }
                r2.onProducerFinishWithFailure(r3, r12, r0, r1)     // Catch:{ all -> 0x0168 }
                r11.handleError(r0)     // Catch:{ all -> 0x0168 }
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r19)
                return
            L_0x0168:
                r0 = move-exception
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r19)
                throw r0
            L_0x016d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.doDecode(com.facebook.imagepipeline.image.EncodedImage, int):void");
        }

        private Map<String, String> getExtraMap(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            CloseableImage closeableImage2 = closeableImage;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext, DecodeProducer.PRODUCER_NAME)) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            String valueOf3 = String.valueOf(z);
            if (closeableImage2 instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", underlyingBitmap.getWidth() + "x" + underlyingBitmap.getHeight());
                hashMap.put(JobScheduler.QUEUE_TIME_KEY, valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str6);
                hashMap.put("imageFormat", str5);
                hashMap.put("requestedImageSize", str7);
                hashMap.put("sampleSize", str4);
                hashMap.put("byteCount", underlyingBitmap.getByteCount() + "");
                return new ImmutableMap(hashMap);
            }
            String str9 = str8;
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put(JobScheduler.QUEUE_TIME_KEY, valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str6);
            hashMap2.put("imageFormat", str5);
            hashMap2.put("requestedImageSize", str7);
            hashMap2.put("sampleSize", str9);
            return new ImmutableMap(hashMap2);
        }

        /* access modifiers changed from: private */
        public void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        private void handleResult(CloseableImage closeableImage, int i) {
            CloseableReference create = DecodeProducer.this.mCloseableReferenceFactory.create(closeableImage);
            try {
                maybeFinish(BaseConsumer.isLast(i));
                getConsumer().onNewResult(create, i);
            } finally {
                CloseableReference.closeSafely(create);
            }
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void maybeIncreaseSampleSize(EncodedImage encodedImage) {
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                encodedImage.setSampleSize(DownsampleUtil.determineSampleSizeJPEG(encodedImage, BitmapUtil.getPixelSizeForBitmapConfig(this.mImageDecodeOptions.bitmapConfig), DecodeProducer.MAX_BITMAP_SIZE));
            }
        }

        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        public abstract QualityInfo getQualityInfo();

        public void onCancellationImpl() {
            handleCancellation();
        }

        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        public void onProgressUpdateImpl(float f2) {
            super.onProgressUpdateImpl(f2 * 0.99f);
        }

        public boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            return this.mJobScheduler.updateJob(encodedImage, i);
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
                }
                boolean isLast = BaseConsumer.isLast(i);
                if (isLast) {
                    if (encodedImage == null) {
                        handleError(new ExceptionWithNoStacktrace("Encoded image is null."));
                        return;
                    } else if (!encodedImage.isValid()) {
                        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return;
                    }
                }
                if (!updateDecodeJob(encodedImage, i)) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return;
                }
                boolean statusHasFlag = BaseConsumer.statusHasFlag(i, 4);
                if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                    this.mJobScheduler.scheduleJob();
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i, CloseableReferenceFactory closeableReferenceFactory) {
        if (byteArrayPool != null) {
            this.mByteArrayPool = byteArrayPool;
            if (executor != null) {
                this.mExecutor = executor;
                if (imageDecoder != null) {
                    this.mImageDecoder = imageDecoder;
                    if (progressiveJpegConfig != null) {
                        this.mProgressiveJpegConfig = progressiveJpegConfig;
                        this.mDownsampleEnabled = z;
                        this.mDownsampleEnabledForNetwork = z2;
                        if (producer != null) {
                            this.mInputProducer = producer;
                            this.mDecodeCancellationEnabled = z3;
                            this.mMaxBitmapSize = i;
                            this.mCloseableReferenceFactory = closeableReferenceFactory;
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
        throw null;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        LocalImagesProgressiveDecoder localImagesProgressiveDecoder;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DecodeProducer#produceResults");
            }
            if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
                LocalImagesProgressiveDecoder localImagesProgressiveDecoder2 = new LocalImagesProgressiveDecoder(consumer, producerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
                localImagesProgressiveDecoder = localImagesProgressiveDecoder2;
            } else {
                NetworkImagesProgressiveDecoder networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
                localImagesProgressiveDecoder = networkImagesProgressiveDecoder;
            }
            this.mInputProducer.produceResults(localImagesProgressiveDecoder, producerContext);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
