package com.dylanvann.fastimage;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class FastImageOkHttpProgressGlideModule extends LibraryGlideModule {
    public static DispatchingProgressListener progressListener = new DispatchingProgressListener(null);

    public static class DispatchingProgressListener implements ResponseProgressListener {
        public final Map<String, FastImageProgressListener> LISTENERS = new WeakHashMap();
        public final Map<String, Long> PROGRESSES = new HashMap();

        public DispatchingProgressListener() {
        }

        public DispatchingProgressListener(AnonymousClass1 r1) {
        }
    }

    public static class OkHttpProgressResponseBody extends ResponseBody {
        public BufferedSource bufferedSource;
        public final String key;
        public final ResponseProgressListener progressListener;
        public final ResponseBody responseBody;

        public OkHttpProgressResponseBody(String str, ResponseBody responseBody2, ResponseProgressListener responseProgressListener) {
            this.key = str;
            this.responseBody = responseBody2;
            this.progressListener = responseProgressListener;
        }

        public long contentLength() {
            return this.responseBody.contentLength();
        }

        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        public BufferedSource source() {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer((Source) new ForwardingSource(this.responseBody.source()) {
                    public long totalBytesRead = 0;

                    public long read(Buffer buffer, long j) throws IOException {
                        long read = super.read(buffer, j);
                        long contentLength = OkHttpProgressResponseBody.this.responseBody.contentLength();
                        if (read == -1) {
                            this.totalBytesRead = contentLength;
                        } else {
                            this.totalBytesRead += read;
                        }
                        OkHttpProgressResponseBody okHttpProgressResponseBody = OkHttpProgressResponseBody.this;
                        ResponseProgressListener responseProgressListener = okHttpProgressResponseBody.progressListener;
                        String str = okHttpProgressResponseBody.key;
                        long j2 = this.totalBytesRead;
                        DispatchingProgressListener dispatchingProgressListener = (DispatchingProgressListener) responseProgressListener;
                        FastImageProgressListener fastImageProgressListener = dispatchingProgressListener.LISTENERS.get(str);
                        if (fastImageProgressListener != null) {
                            int i = (contentLength > j2 ? 1 : (contentLength == j2 ? 0 : -1));
                            if (i <= 0) {
                                dispatchingProgressListener.LISTENERS.remove(str);
                                dispatchingProgressListener.PROGRESSES.remove(str);
                            }
                            float granularityPercentage = fastImageProgressListener.getGranularityPercentage();
                            boolean z = true;
                            if (!(granularityPercentage == 0.0f || j2 == 0 || i == 0)) {
                                long j3 = (long) (((((float) j2) * 100.0f) / ((float) contentLength)) / granularityPercentage);
                                Long l = dispatchingProgressListener.PROGRESSES.get(str);
                                if (l == null || j3 != l.longValue()) {
                                    dispatchingProgressListener.PROGRESSES.put(str, Long.valueOf(j3));
                                } else {
                                    z = false;
                                }
                            }
                            if (z) {
                                fastImageProgressListener.onProgress(str, j2, contentLength);
                            }
                        }
                        return read;
                    }
                });
            }
            return this.bufferedSource;
        }
    }

    public interface ResponseProgressListener {
    }

    public static Interceptor createInterceptor(final ResponseProgressListener responseProgressListener) {
        return new Interceptor() {
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                return proceed.newBuilder().body(new OkHttpProgressResponseBody(request.url().toString(), proceed.body(), ResponseProgressListener.this)).build();
            }
        };
    }

    public static void expect(String str, FastImageProgressListener fastImageProgressListener) {
        progressListener.LISTENERS.put(str, fastImageProgressListener);
    }

    public static void forget(String str) {
        DispatchingProgressListener dispatchingProgressListener = progressListener;
        dispatchingProgressListener.LISTENERS.remove(str);
        dispatchingProgressListener.PROGRESSES.remove(str);
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        if (ImageOriginUtils.sClient == null) {
            ImageOriginUtils.sClient = ImageOriginUtils.createClientBuilder().build();
        }
        registry.replace(GlideUrl.class, InputStream.class, new Factory(ImageOriginUtils.sClient.newBuilder().addInterceptor(createInterceptor(progressListener)).build()));
    }
}
