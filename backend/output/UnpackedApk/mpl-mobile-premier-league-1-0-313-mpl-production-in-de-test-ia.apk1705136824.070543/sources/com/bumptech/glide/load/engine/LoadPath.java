package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath.DecodeCallback;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {
    public final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    public final String failureMessage;
    public final Pools$Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools$Pool<List<Throwable>> pools$Pool) {
        this.listPool = pools$Pool;
        if (!list.isEmpty()) {
            this.decodePaths = list;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed LoadPath{");
            outline73.append(cls.getSimpleName());
            outline73.append(InflateView.KEYWORD_SPLIT);
            outline73.append(cls2.getSimpleName());
            outline73.append(InflateView.KEYWORD_SPLIT);
            outline73.append(cls3.getSimpleName());
            outline73.append("}");
            this.failureMessage = outline73.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        Resource<Transcode> resource;
        Object acquire = this.listPool.acquire();
        k.checkNotNull(acquire, (String) "Argument must not be null");
        List list = (List) acquire;
        try {
            int size = this.decodePaths.size();
            resource = null;
            for (int i3 = 0; i3 < size; i3++) {
                resource = ((DecodePath) this.decodePaths.get(i3)).decode(dataRewinder, i, i2, options, decodeCallback);
                if (resource != null) {
                    break;
                }
            }
        } catch (GlideException e2) {
            list.add(e2);
        } catch (Throwable th) {
            this.listPool.release(list);
            throw th;
        }
        if (resource != null) {
            this.listPool.release(list);
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList<Throwable>(list));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LoadPath{decodePaths=");
        outline73.append(Arrays.toString(this.decodePaths.toArray()));
        outline73.append('}');
        return outline73.toString();
    }
}
