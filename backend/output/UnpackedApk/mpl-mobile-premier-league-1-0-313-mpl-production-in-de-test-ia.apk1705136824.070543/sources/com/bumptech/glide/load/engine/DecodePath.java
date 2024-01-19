package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import in.juspay.hypersdk.core.InflateView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
    public final Class<DataType> dataClass;
    public final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    public final String failureMessage;
    public final Pools$Pool<List<Throwable>> listPool;
    public final ResourceTranscoder<ResourceType, Transcode> transcoder;

    public interface DecodeCallback<ResourceType> {
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools$Pool<List<Throwable>> pools$Pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pools$Pool;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed DecodePath{");
        outline73.append(cls.getSimpleName());
        outline73.append(InflateView.KEYWORD_SPLIT);
        outline73.append(cls2.getSimpleName());
        outline73.append(InflateView.KEYWORD_SPLIT);
        outline73.append(cls3.getSimpleName());
        outline73.append("}");
        this.failureMessage = outline73.toString();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.bumptech.glide.load.engine.Resource, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r0v7, types: [com.bumptech.glide.load.engine.LockedResource<Z>, com.bumptech.glide.load.engine.LockedResource] */
    /* JADX WARNING: type inference failed for: r11v12, types: [com.bumptech.glide.load.engine.DataCacheKey] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bumptech.glide.load.engine.Resource<Transcode> decode(com.bumptech.glide.load.data.DataRewinder<DataType> r11, int r12, int r13, com.bumptech.glide.load.Options r14, com.bumptech.glide.load.engine.DecodePath.DecodeCallback<ResourceType> r15) throws com.bumptech.glide.load.engine.GlideException {
        /*
            r10 = this;
            androidx.core.util.Pools$Pool<java.util.List<java.lang.Throwable>> r0 = r10.listPool
            java.lang.Object r0 = r0.acquire()
            java.lang.String r1 = "Argument must not be null"
            co.hyperverge.hypersnapsdk.c.k.checkNotNull(r0, r1)
            java.util.List r0 = (java.util.List) r0
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r0
            com.bumptech.glide.load.engine.Resource r11 = r2.decodeResourceWithList(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0106 }
            androidx.core.util.Pools$Pool<java.util.List<java.lang.Throwable>> r12 = r10.listPool
            r12.release(r0)
            com.bumptech.glide.load.engine.DecodeJob$DecodeCallback r15 = (com.bumptech.glide.load.engine.DecodeJob.DecodeCallback) r15
            com.bumptech.glide.load.engine.DecodeJob r12 = com.bumptech.glide.load.engine.DecodeJob.this
            com.bumptech.glide.load.DataSource r13 = r15.dataSource
            r15 = 0
            if (r12 == 0) goto L_0x0105
            java.lang.Object r0 = r11.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            if (r13 == r0) goto L_0x0044
            com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r12.decodeHelper
            com.bumptech.glide.load.Transformation r0 = r0.getTransformation(r8)
            com.bumptech.glide.GlideContext r1 = r12.glideContext
            int r2 = r12.width
            int r3 = r12.height
            com.bumptech.glide.load.engine.Resource r1 = r0.transform(r1, r11, r2, r3)
            r7 = r0
            r0 = r1
            goto L_0x0046
        L_0x0044:
            r0 = r11
            r7 = r15
        L_0x0046:
            boolean r1 = r11.equals(r0)
            if (r1 != 0) goto L_0x004f
            r11.recycle()
        L_0x004f:
            com.bumptech.glide.load.engine.DecodeHelper<R> r11 = r12.decodeHelper
            com.bumptech.glide.GlideContext r11 = r11.glideContext
            com.bumptech.glide.Registry r11 = r11.getRegistry()
            boolean r11 = r11.isResourceEncoderAvailable(r0)
            if (r11 == 0) goto L_0x0070
            com.bumptech.glide.load.engine.DecodeHelper<R> r11 = r12.decodeHelper
            com.bumptech.glide.GlideContext r11 = r11.glideContext
            com.bumptech.glide.Registry r11 = r11.getRegistry()
            com.bumptech.glide.load.ResourceEncoder r15 = r11.getResultEncoder(r0)
            com.bumptech.glide.load.Options r11 = r12.options
            com.bumptech.glide.load.EncodeStrategy r11 = r15.getEncodeStrategy(r11)
            goto L_0x0072
        L_0x0070:
            com.bumptech.glide.load.EncodeStrategy r11 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0072:
            com.bumptech.glide.load.engine.DecodeHelper<R> r1 = r12.decodeHelper
            com.bumptech.glide.load.Key r2 = r12.currentSourceKey
            java.util.List r1 = r1.getLoadData()
            int r3 = r1.size()
            r4 = 0
            r5 = 0
        L_0x0080:
            r6 = 1
            if (r5 >= r3) goto L_0x0096
            java.lang.Object r9 = r1.get(r5)
            com.bumptech.glide.load.model.ModelLoader$LoadData r9 = (com.bumptech.glide.load.model.ModelLoader.LoadData) r9
            com.bumptech.glide.load.Key r9 = r9.sourceKey
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x0093
            r4 = 1
            goto L_0x0096
        L_0x0093:
            int r5 = r5 + 1
            goto L_0x0080
        L_0x0096:
            r1 = r4 ^ 1
            com.bumptech.glide.load.engine.DiskCacheStrategy r2 = r12.diskCacheStrategy
            boolean r13 = r2.isResourceCacheable(r1, r13, r11)
            if (r13 == 0) goto L_0x00fe
            if (r15 == 0) goto L_0x00f0
            int r13 = r11.ordinal()
            if (r13 == 0) goto L_0x00da
            if (r13 != r6) goto L_0x00c3
            com.bumptech.glide.load.engine.ResourceCacheKey r11 = new com.bumptech.glide.load.engine.ResourceCacheKey
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r12.decodeHelper
            com.bumptech.glide.GlideContext r13 = r13.glideContext
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.getArrayPool()
            com.bumptech.glide.load.Key r3 = r12.currentSourceKey
            com.bumptech.glide.load.Key r4 = r12.signature
            int r5 = r12.width
            int r6 = r12.height
            com.bumptech.glide.load.Options r9 = r12.options
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00e3
        L_0x00c3:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Unknown strategy: "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x00da:
            com.bumptech.glide.load.engine.DataCacheKey r11 = new com.bumptech.glide.load.engine.DataCacheKey
            com.bumptech.glide.load.Key r13 = r12.currentSourceKey
            com.bumptech.glide.load.Key r1 = r12.signature
            r11.<init>(r13, r1)
        L_0x00e3:
            com.bumptech.glide.load.engine.LockedResource r0 = com.bumptech.glide.load.engine.LockedResource.obtain(r0)
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r12 = r12.deferredEncodeManager
            r12.key = r11
            r12.encoder = r15
            r12.toEncode = r0
            goto L_0x00fe
        L_0x00f0:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r11 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r12 = r0.get()
            java.lang.Class r12 = r12.getClass()
            r11.<init>(r12)
            throw r11
        L_0x00fe:
            com.bumptech.glide.load.resource.transcode.ResourceTranscoder<ResourceType, Transcode> r11 = r10.transcoder
            com.bumptech.glide.load.engine.Resource r11 = r11.transcode(r0, r14)
            return r11
        L_0x0105:
            throw r15
        L_0x0106:
            r11 = move-exception
            androidx.core.util.Pools$Pool<java.util.List<java.lang.Throwable>> r12 = r10.listPool
            r12.release(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodePath.decode(com.bumptech.glide.load.data.DataRewinder, int, int, com.bumptech.glide.load.Options, com.bumptech.glide.load.engine.DecodePath$DecodeCallback):com.bumptech.glide.load.engine.Resource");
    }

    public final Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) throws GlideException {
        int size = this.decoders.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.decoders.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    "Failed to decode data for " + resourceDecoder;
                }
                list.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList<Throwable>(list));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DecodePath{ dataClass=");
        outline73.append(this.dataClass);
        outline73.append(", decoders=");
        outline73.append(this.decoders);
        outline73.append(", transcoder=");
        outline73.append(this.transcoder);
        outline73.append('}');
        return outline73.toString();
    }
}
