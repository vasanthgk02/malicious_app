package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory {
    public Producer<EncodedImage> mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    public Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
    public Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences = new HashMap();
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences = new HashMap();
    public Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
    public final ContentResolver mContentResolver;
    public Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
    public Producer<CloseableReference<PooledByteBuffer>> mLocalContentUriEncodedImageProducerSequence;
    public Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
    public Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
    public Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
    public Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
    public Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
    public Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
    public Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
    public Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
    public Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
    public final NetworkFetcher mNetworkFetcher;
    public final boolean mPartialImageCachingEnabled;
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences = new HashMap();
    public final ProducerFactory mProducerFactory;
    public Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mWebpSupportEnabled;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, boolean z2, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z3, boolean z4, boolean z5, boolean z6, ImageTranscoderFactory imageTranscoderFactory) {
        this.mContentResolver = contentResolver;
        this.mProducerFactory = producerFactory;
        this.mNetworkFetcher = networkFetcher;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mWebpSupportEnabled = z2;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mDownsampleEnabled = z3;
        this.mUseBitmapPrepareToDraw = z4;
        this.mPartialImageCachingEnabled = z5;
        this.mDiskCacheEnabled = z6;
        this.mImageTranscoderFactory = imageTranscoderFactory;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalContentUriFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalContentUriFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalContentUriFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalFileFetchToEncodedMemorySequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundNetworkFetchToEncodedMemorySequence;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cf A[FINALLY_INSNS] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getBasicDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest r4) {
        /*
            r3 = this;
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "ProducerSequenceFactory#getBasicDecodedImageSequence"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)     // Catch:{ all -> 0x00c8 }
        L_0x000b:
            if (r4 == 0) goto L_0x00c6
            android.net.Uri r0 = r4.getSourceUri()     // Catch:{ all -> 0x00c8 }
            java.lang.String r1 = "Uri is null."
            co.hyperverge.hypersnapsdk.c.k.checkNotNull(r0, r1)     // Catch:{ all -> 0x00c8 }
            int r4 = r4.getSourceUriType()     // Catch:{ all -> 0x00c8 }
            if (r4 == 0) goto L_0x00b8
            switch(r4) {
                case 2: goto L_0x0091;
                case 3: goto L_0x0083;
                case 4: goto L_0x005b;
                case 5: goto L_0x004d;
                case 6: goto L_0x003f;
                case 7: goto L_0x0031;
                case 8: goto L_0x0023;
                default: goto L_0x001f;
            }     // Catch:{ all -> 0x00c8 }
        L_0x001f:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c8 }
            goto L_0x009f
        L_0x0023:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getQualifiedResourceFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0030
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0030:
            return r4
        L_0x0031:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getDataFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x003e
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x003e:
            return r4
        L_0x003f:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalResourceFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x004c
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x004c:
            return r4
        L_0x004d:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalAssetFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x005a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x005a:
            return r4
        L_0x005b:
            android.content.ContentResolver r4 = r3.mContentResolver     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = r4.getType(r0)     // Catch:{ all -> 0x00c8 }
            boolean r4 = com.facebook.common.media.MediaUtils.isVideo(r4)     // Catch:{ all -> 0x00c8 }
            if (r4 == 0) goto L_0x0075
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalVideoFileFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0074
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0074:
            return r4
        L_0x0075:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalContentUriFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0082
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0082:
            return r4
        L_0x0083:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalImageFileFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0090
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0090:
            return r4
        L_0x0091:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalVideoFileFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x009e
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x009e:
            return r4
        L_0x009f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r1.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = "Unsupported uri scheme! Uri is: "
            r1.append(r2)     // Catch:{ all -> 0x00c8 }
            java.lang.String r0 = getShortenedUriString(r0)     // Catch:{ all -> 0x00c8 }
            r1.append(r0)     // Catch:{ all -> 0x00c8 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00c8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00c8 }
            throw r4     // Catch:{ all -> 0x00c8 }
        L_0x00b8:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getNetworkFetchSequence()     // Catch:{ all -> 0x00c8 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00c5
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00c5:
            return r4
        L_0x00c6:
            r4 = 0
            throw r4     // Catch:{ all -> 0x00c8 }
        L_0x00c8:
            r4 = move-exception
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00d2
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00d2:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory.getBasicDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest):com.facebook.imagepipeline.producers.Producer");
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producer2;
        producer2 = this.mBitmapPrepareSequences.get(producer);
        if (producer2 == null) {
            producer2 = this.mProducerFactory.newBitmapPrepareProducer(producer);
            this.mBitmapPrepareSequences.put(producer, producer2);
        }
        return producer2;
    }

    private synchronized Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.mCommonNetworkFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
            this.mCommonNetworkFetchToEncodedMemorySequence = newAddImageTransformMetaDataProducer;
            this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled, this.mImageTranscoderFactory);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mCommonNetworkFetchToEncodedMemorySequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        if (this.mDataFetchSequence == null) {
            DataFetchProducer newDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
            boolean z = WebpSupportStatus.sIsWebpSupportRequired;
            this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(newDataFetchProducer), true, this.mImageTranscoderFactory));
        }
        return this.mDataFetchSequence;
    }

    private synchronized Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.mCloseableImagePrefetchSequences.containsKey(producer)) {
            this.mCloseableImagePrefetchSequences.put(producer, ProducerFactory.newSwallowResultProducer(producer));
        }
        return this.mCloseableImagePrefetchSequences.get(producer);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        if (this.mLocalAssetFetchSequence == null) {
            this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
        }
        return this.mLocalAssetFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        if (this.mLocalContentUriFetchSequence == null) {
            this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer()});
        }
        return this.mLocalContentUriFetchSequence;
    }

    private synchronized Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        if (this.mLocalImageFileFetchSequence == null) {
            this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
        }
        return this.mLocalImageFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        if (this.mLocalResourceFetchSequence == null) {
            this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
        }
        return this.mLocalResourceFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        if (this.mLocalVideoFileFetchSequence == null) {
            this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
        }
        return this.mLocalVideoFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.mNetworkFetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchSequence;
    }

    private synchronized Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.mPostprocessorSequences.containsKey(producer)) {
            this.mPostprocessorSequences.put(producer, this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(this.mProducerFactory.newPostprocessorProducer(producer)));
        }
        return this.mPostprocessorSequences.get(producer);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        if (this.mQualifiedResourceFetchSequence == null) {
            this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
        }
        return this.mQualifiedResourceFetchSequence;
    }

    public static String getShortenedUriString(Uri uri) {
        String valueOf = String.valueOf(uri);
        if (valueOf.length() <= 30) {
            return valueOf;
        }
        return valueOf.substring(0, 30) + "...";
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> producer) {
        return this.mProducerFactory.newBitmapMemoryCacheGetProducer(this.mProducerFactory.newBackgroundThreadHandoffProducer(this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.mProducerFactory.newBitmapMemoryCacheProducer(producer)), this.mThreadHandoffProducerQueue));
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> producer) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(producer));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newBitmapCacheGetToBitmapCacheSequence;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer) {
        return newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalExifThumbnailProducer()});
    }

    private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> producer) {
        DiskCacheWriteProducer diskCacheWriteProducer;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        }
        if (this.mPartialImageCachingEnabled) {
            diskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(this.mProducerFactory.newPartialDiskCacheProducer(producer));
        } else {
            diskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(producer);
        }
        DiskCacheReadProducer newDiskCacheReadProducer = this.mProducerFactory.newDiskCacheReadProducer(diskCacheWriteProducer);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newDiskCacheReadProducer;
    }

    private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> producer) {
        boolean z = WebpSupportStatus.sIsWebpSupportRequired;
        if (this.mDiskCacheEnabled) {
            producer = newDiskCacheSequence(producer);
        }
        return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(this.mProducerFactory.newEncodedMemoryCacheProducer(producer));
    }

    private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return this.mProducerFactory.newResizeAndRotateProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory);
    }

    private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory)));
    }

    public static void validateEncodedImageRequest(ImageRequest imageRequest) {
        if (imageRequest != null) {
            k.checkArgument(imageRequest.getLowestPermittedRequestLevel().getValue() <= RequestLevel.ENCODED_MEMORY_CACHE.getValue());
            return;
        }
        throw null;
    }

    public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (imageRequest.getPostprocessor() != null) {
            basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
        }
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return basicDecodedImageSequence;
    }

    public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        Uri sourceUri = imageRequest.getSourceUri();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported uri scheme for encoded image fetch! Uri is: ");
        outline73.append(getShortenedUriString(sourceUri));
        throw new IllegalArgumentException(outline73.toString());
    }

    public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
            }
            validateEncodedImageRequest(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 2 || sourceUriType == 3) {
                Producer<CloseableReference<PooledByteBuffer>> localFileFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return localFileFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            } else {
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
            }
            if (this.mLocalContentUriEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
                }
                this.mLocalContentUriEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalContentUriFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalContentUriEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
            }
            if (this.mLocalFileEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
                }
                this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalFileEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
            }
            if (this.mNetworkEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
                }
                this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mNetworkEncodedImageProducerSequence;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
    }
}
