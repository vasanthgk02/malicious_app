package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import retrofit2.RequestBuilder.ContentTypeOverridingRequestBody;

public final class OkHttpCall<T> implements Call<T> {
    public final Object[] args;
    public final Factory callFactory;
    public volatile boolean canceled;
    public Throwable creationFailure;
    public boolean executed;
    public Call rawCall;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        public final ResponseBody delegate;
        public final BufferedSource delegateSource;
        public IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer((Source) new ForwardingSource(responseBody.source()) {
                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e2) {
                        ExceptionCatchingResponseBody.this.thrownException = e2;
                        throw e2;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public BufferedSource source() {
            return this.delegateSource;
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        public final long contentLength;
        public final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory2, Object[] objArr, Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    public final Call createRawCall() throws IOException {
        HttpUrl httpUrl;
        Factory factory = this.callFactory;
        RequestFactory requestFactory2 = this.requestFactory;
        Object[] objArr = this.args;
        ParameterHandler<?>[] parameterHandlerArr = requestFactory2.parameterHandlers;
        int length = objArr.length;
        if (length == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(requestFactory2.httpMethod, requestFactory2.baseUrl, requestFactory2.relativeUrl, requestFactory2.headers, requestFactory2.contentType, requestFactory2.hasBody, requestFactory2.isFormEncoded, requestFactory2.isMultipart);
            if (requestFactory2.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(objArr[i]);
                parameterHandlerArr[i].apply(requestBuilder, objArr[i]);
            }
            Builder builder = requestBuilder.urlBuilder;
            if (builder != null) {
                httpUrl = builder.build();
            } else {
                httpUrl = requestBuilder.baseUrl.resolve(requestBuilder.relativeUrl);
                if (httpUrl == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Malformed URL. Base: ");
                    outline73.append(requestBuilder.baseUrl);
                    outline73.append(", Relative: ");
                    outline73.append(requestBuilder.relativeUrl);
                    throw new IllegalArgumentException(outline73.toString());
                }
            }
            RequestBody requestBody = requestBuilder.body;
            if (requestBody == null) {
                FormBody.Builder builder2 = requestBuilder.formBuilder;
                if (builder2 != null) {
                    requestBody = builder2.build();
                } else {
                    MultipartBody.Builder builder3 = requestBuilder.multipartBuilder;
                    if (builder3 != null) {
                        requestBody = builder3.build();
                    } else if (requestBuilder.hasBody) {
                        requestBody = RequestBody.create((MediaType) null, new byte[0]);
                    }
                }
            }
            MediaType mediaType = requestBuilder.contentType;
            if (mediaType != null) {
                if (requestBody != null) {
                    requestBody = new ContentTypeOverridingRequestBody(requestBody, mediaType);
                } else {
                    requestBuilder.headersBuilder.add((String) "Content-Type", mediaType.toString());
                }
            }
            Call newCall = factory.newCall(requestBuilder.requestBuilder.url(httpUrl).headers(requestBuilder.headersBuilder.build()).method(requestBuilder.method, requestBody).tag(Invocation.class, new Invocation(requestFactory2.method, arrayList)).build());
            if (newCall != null) {
                return newCall;
            }
            throw new NullPointerException("Call.Factory returned null.");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline74("Argument count (", length, ") doesn't match expected count ("), parameterHandlerArr.length, ")"));
    }

    public void enqueue(final Callback<T> callback) {
        Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.rawCall;
                th = this.creationFailure;
                if (call == null && th == null) {
                    try {
                        Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new Callback() {
            public void onFailure(Call call, IOException iOException) {
                try {
                    callback.onFailure(OkHttpCall.this, iOException);
                } catch (Throwable th) {
                    Utils.throwIfFatal(th);
                    th.printStackTrace();
                }
            }

            public void onResponse(Call call, Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        Call rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.cancel();
        }
        return parseResponse(FirebasePerfOkHttpClient.execute(rawCall2));
    }

    public final Call getRawCall() throws IOException {
        Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e2) {
                Utils.throwIfFatal(e2);
                this.creationFailure = e2;
                throw e2;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            if (this.rawCall == null || !this.rawCall.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    public Response<T> parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                ResponseBody buffer = Utils.buffer(body);
                Objects.requireNonNull(buffer, "body == null");
                Objects.requireNonNull(build, "rawResponse == null");
                if (!build.isSuccessful()) {
                    return new Response<>(build, null, buffer);
                }
                throw new IllegalArgumentException("rawResponse should not be successful response");
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.success(null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e2) {
                IOException iOException = exceptionCatchingResponseBody.thrownException;
                if (iOException == null) {
                    throw e2;
                }
                throw iOException;
            }
        }
    }

    public synchronized Request request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return getRawCall().request();
    }

    /* renamed from: clone  reason: collision with other method in class */
    public Call m1146clone() {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
