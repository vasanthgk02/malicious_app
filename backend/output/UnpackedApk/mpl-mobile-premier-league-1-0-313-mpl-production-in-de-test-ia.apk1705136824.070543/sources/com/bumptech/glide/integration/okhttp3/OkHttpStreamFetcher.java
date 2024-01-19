package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    public volatile Call call;
    public DataCallback<? super InputStream> callback;
    public final Factory client;
    public ResponseBody responseBody;
    public InputStream stream;
    public final GlideUrl url;

    public OkHttpStreamFetcher(Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    public void cancel() {
        Call call2 = this.call;
        if (call2 != null) {
            call2.cancel();
        }
    }

    public void cleanup() {
        try {
            if (this.stream != null) {
                this.stream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody2 = this.responseBody;
        if (responseBody2 != null) {
            responseBody2.close();
        }
        this.callback = null;
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public void loadData(Priority priority, DataCallback<? super InputStream> dataCallback) {
        Builder url2 = new Builder().url(this.url.getSafeStringUrl());
        for (Entry next : this.url.headers.getHeaders().entrySet()) {
            url2.addHeader((String) next.getKey(), (String) next.getValue());
        }
        Request build = url2.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        FirebasePerfOkHttpClient.enqueue(this.call, this);
    }

    public void onFailure(Call call2, IOException iOException) {
        boolean isLoggable = Log.isLoggable("OkHttpFetcher", 3);
        this.callback.onLoadFailed(iOException);
    }

    public void onResponse(Call call2, Response response) {
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            ResponseBody responseBody2 = this.responseBody;
            k.checkNotNull(responseBody2, (String) "Argument must not be null");
            ContentLengthInputStream contentLengthInputStream = new ContentLengthInputStream(this.responseBody.byteStream(), responseBody2.contentLength());
            this.stream = contentLengthInputStream;
            this.callback.onDataReady(contentLengthInputStream);
            return;
        }
        this.callback.onLoadFailed(new HttpException(response.message(), response.code()));
    }
}
