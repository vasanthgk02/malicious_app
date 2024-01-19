package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public void close(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public Object loadResource(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
