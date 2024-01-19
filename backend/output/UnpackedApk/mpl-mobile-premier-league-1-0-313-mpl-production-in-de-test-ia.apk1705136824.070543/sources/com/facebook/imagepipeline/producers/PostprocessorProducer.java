package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;

public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    public static final String POSTPROCESSOR = "Postprocessor";
    public final PlatformBitmapFactory mBitmapFactory;
    public final Executor mExecutor;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public boolean mIsClosed;
        public boolean mIsDirty = false;
        public boolean mIsPostProcessingRunning = false;
        public final ProducerListener2 mListener;
        public final Postprocessor mPostprocessor;
        public final ProducerContext mProducerContext;
        public CloseableReference<CloseableImage> mSourceImageRef = null;
        public int mStatus = 0;

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mListener = producerListener2;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
            producerContext.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this) {
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        /* access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            k.checkArgument(CloseableReference.isValid(closeableReference));
            if (!shouldPostprocess((CloseableImage) closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mProducerContext, PostprocessorProducer.NAME);
            CloseableReference<CloseableImage> closeableReference2 = null;
            try {
                closeableReference2 = postprocessInternal((CloseableImage) closeableReference.get());
                this.mListener.onProducerFinishWithSuccess(this.mProducerContext, PostprocessorProducer.NAME, getExtraMap(this.mListener, this.mProducerContext, this.mPostprocessor));
                maybeNotifyOnNewResult(closeableReference2, i);
                if (closeableReference2 != null) {
                    closeableReference2.close();
                }
            } catch (Exception e2) {
                this.mListener.onProducerFinishWithFailure(this.mProducerContext, PostprocessorProducer.NAME, e2, getExtraMap(this.mListener, this.mProducerContext, this.mPostprocessor));
                maybeNotifyOnFailure(e2);
            } catch (Throwable th) {
                if (closeableReference2 != null) {
                    closeableReference2.close();
                }
                throw th;
            }
        }

        private Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (!producerListener2.requiresExtraMap(producerContext, PostprocessorProducer.NAME)) {
                return null;
            }
            return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        /* access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean isLast = BaseConsumer.isLast(i);
            if ((!isLast && !isClosed()) || (isLast && close())) {
                getConsumer().onNewResult(closeableReference, i);
            }
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                closeableStaticBitmap2.setOriginalEncodedImageInfo(closeableStaticBitmap.getOriginalEncodedImageInfo());
                return CloseableReference.of(closeableStaticBitmap2);
            } finally {
                CloseableReference.closeSafely(process);
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() {
                public void run() {
                    CloseableReference access$300;
                    int access$400;
                    synchronized (PostprocessorConsumer.this) {
                        access$300 = PostprocessorConsumer.this.mSourceImageRef;
                        access$400 = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(access$300)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(access$300, access$400);
                        } finally {
                            if (access$300 != null) {
                                access$300.close();
                            }
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            if (r2 == false) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
            submitPostprocessing();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
            if (r0 == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            r0.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateSourceImageRef(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r2, int r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.mIsClosed     // Catch:{ all -> 0x0024 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                return
            L_0x0007:
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r0 = r1.mSourceImageRef     // Catch:{ all -> 0x0024 }
                com.facebook.common.references.CloseableReference r2 = com.facebook.common.references.CloseableReference.cloneOrNull(r2)     // Catch:{ all -> 0x0024 }
                r1.mSourceImageRef = r2     // Catch:{ all -> 0x0024 }
                r1.mStatus = r3     // Catch:{ all -> 0x0024 }
                r2 = 1
                r1.mIsDirty = r2     // Catch:{ all -> 0x0024 }
                boolean r2 = r1.setRunningIfDirtyAndNotRunning()     // Catch:{ all -> 0x0024 }
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                if (r0 == 0) goto L_0x001e
                r0.close()
            L_0x001e:
                if (r2 == 0) goto L_0x0023
                r1.submitPostprocessing()
            L_0x0023:
                return
            L_0x0024:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.updateSourceImageRef(com.facebook.common.references.CloseableReference, int):void");
        }

        public void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        public void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!CloseableReference.isValid(closeableReference)) {
                if (BaseConsumer.isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }
    }

    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public boolean mIsClosed;
        public CloseableReference<CloseableImage> mSourceImageRef;

        /* access modifiers changed from: private */
        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r0 == null) goto L_0x0015;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            r0.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setSourceImageRef(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.mIsClosed     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
                return
            L_0x0007:
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r0 = r1.mSourceImageRef     // Catch:{ all -> 0x0016 }
                com.facebook.common.references.CloseableReference r2 = com.facebook.common.references.CloseableReference.cloneOrNull(r2)     // Catch:{ all -> 0x0016 }
                r1.mSourceImageRef = r2     // Catch:{ all -> 0x0016 }
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0015
                r0.close()
            L_0x0015:
                return
            L_0x0016:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.setSourceImageRef(com.facebook.common.references.CloseableReference):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            if (r0 != null) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            getConsumer().onNewResult(r0, 0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateInternal() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.mIsClosed     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0023 }
                return
            L_0x0007:
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r0 = r3.mSourceImageRef     // Catch:{ all -> 0x0023 }
                com.facebook.common.references.CloseableReference r0 = com.facebook.common.references.CloseableReference.cloneOrNull(r0)     // Catch:{ all -> 0x0023 }
                monitor-exit(r3)     // Catch:{ all -> 0x0023 }
                com.facebook.imagepipeline.producers.Consumer r1 = r3.getConsumer()     // Catch:{ all -> 0x001c }
                r2 = 0
                r1.onNewResult(r0, r2)     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001b
                r0.close()
            L_0x001b:
                return
            L_0x001c:
                r1 = move-exception
                if (r0 == 0) goto L_0x0022
                r0.close()
            L_0x0022:
                throw r1
            L_0x0023:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0023 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.updateInternal():void");
        }

        public void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        public void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        public synchronized void update() {
            updateInternal();
        }

        public RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this) {
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!BaseConsumer.isNotLast(i)) {
                setSourceImageRef(closeableReference);
                updateInternal();
            }
        }
    }

    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!BaseConsumer.isNotLast(i)) {
                getConsumer().onNewResult(closeableReference, i);
            }
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        if (producer != null) {
            this.mInputProducer = producer;
            this.mBitmapFactory = platformBitmapFactory;
            if (executor != null) {
                this.mExecutor = executor;
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r14v3, types: [com.facebook.imagepipeline.producers.PostprocessorProducer$SingleUsePostprocessorConsumer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r14, com.facebook.imagepipeline.producers.ProducerContext r15) {
        /*
            r13 = this;
            com.facebook.imagepipeline.producers.ProducerListener2 r3 = r15.getProducerListener()
            com.facebook.imagepipeline.request.ImageRequest r0 = r15.getImageRequest()
            com.facebook.imagepipeline.request.Postprocessor r6 = r0.getPostprocessor()
            com.facebook.imagepipeline.producers.PostprocessorProducer$PostprocessorConsumer r9 = new com.facebook.imagepipeline.producers.PostprocessorProducer$PostprocessorConsumer
            r0 = r9
            r1 = r13
            r2 = r14
            r4 = r6
            r5 = r15
            r0.<init>(r2, r3, r4, r5)
            boolean r14 = r6 instanceof com.facebook.imagepipeline.request.RepeatedPostprocessor
            if (r14 == 0) goto L_0x0027
            com.facebook.imagepipeline.producers.PostprocessorProducer$RepeatedPostprocessorConsumer r14 = new com.facebook.imagepipeline.producers.PostprocessorProducer$RepeatedPostprocessorConsumer
            r10 = r6
            com.facebook.imagepipeline.request.RepeatedPostprocessor r10 = (com.facebook.imagepipeline.request.RepeatedPostprocessor) r10
            r12 = 0
            r7 = r14
            r8 = r13
            r11 = r15
            r7.<init>(r9, r10, r11)
            goto L_0x002d
        L_0x0027:
            com.facebook.imagepipeline.producers.PostprocessorProducer$SingleUsePostprocessorConsumer r14 = new com.facebook.imagepipeline.producers.PostprocessorProducer$SingleUsePostprocessorConsumer
            r0 = 0
            r14.<init>(r9)
        L_0x002d:
            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r0 = r13.mInputProducer
            r0.produceResults(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.produceResults(com.facebook.imagepipeline.producers.Consumer, com.facebook.imagepipeline.producers.ProducerContext):void");
    }
}
