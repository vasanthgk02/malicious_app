package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalAssetFetchProducer";
    public final AssetManager mAssetManager;

    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        this.mAssetManager = assetManager;
    }

    public static String getAssetName(ImageRequest imageRequest) {
        return imageRequest.getSourceUri().getPath().substring(1);
    }

    private int getLength(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openFd = this.mAssetManager.openFd(getAssetName(imageRequest));
            int length = (int) openFd.getLength();
            try {
                openFd.close();
            } catch (IOException unused) {
            }
            return length;
        } catch (IOException unused2) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(this.mAssetManager.open(getAssetName(imageRequest), 2), getLength(imageRequest));
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
