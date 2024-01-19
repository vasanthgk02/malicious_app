package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mpl.androidapp.utils.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.apache.fontbox.ttf.HeaderTable;

@ReactModule(name = "Networking")
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    public static final int CHUNK_TIMEOUT_NS = 100000000;
    public static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    public static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    public static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    public static final String REQUEST_BODY_KEY_BASE64 = "base64";
    public static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    public static final String REQUEST_BODY_KEY_STRING = "string";
    public static final String REQUEST_BODY_KEY_URI = "uri";
    public static final String TAG = "NetworkingModule";
    public static final String USER_AGENT_HEADER_NAME = "user-agent";
    public static CustomClientBuilder customClientBuilder;
    public final OkHttpClient mClient;
    public final ForwardingCookieHandler mCookieHandler;
    public final CookieJarContainer mCookieJarContainer;
    public final String mDefaultUserAgent;
    public final List<RequestBodyHandler> mRequestBodyHandlers;
    public final Set<Integer> mRequestIds;
    public final List<ResponseHandler> mResponseHandlers;
    public boolean mShuttingDown;
    public final List<UriHandler> mUriHandlers;

    public interface CustomClientBuilder {
        void apply(Builder builder);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient, List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator create : list) {
                newBuilder.addNetworkInterceptor(create.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    public static void applyCustomBuilder(Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            public void doInBackgroundGuarded(Object[] objArr) {
                Void[] voidArr = (Void[]) objArr;
                OkHttpClient access$600 = NetworkingModule.this.mClient;
                Integer valueOf = Integer.valueOf(i);
                for (Call next : access$600.dispatcher().queuedCalls()) {
                    if (valueOf.equals(next.request().tag())) {
                        next.cancel();
                        return;
                    }
                }
                for (Call next2 : access$600.dispatcher().runningCalls()) {
                    if (valueOf.equals(next2.request().tag())) {
                        next2.cancel();
                        return;
                    }
                }
            }
        }.execute(new Void[0]);
    }

    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        RCTDeviceEventEmitter eventEmitter = getEventEmitter("constructMultipartBody");
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray(Constant.HEADER), null);
            if (extractHeaders == null) {
                ImageOriginUtils.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey("uri")) {
                ImageOriginUtils.onRequestError(eventEmitter, i, "Unrecognized FormData part.", null);
            } else if (mediaType == null) {
                ImageOriginUtils.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", null);
                return null;
            } else {
                InputStream fileInputStream = ImageOriginUtils.getFileInputStream(getReactApplicationContext(), map.getString("uri"));
                if (fileInputStream == null) {
                    ImageOriginUtils.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + r3, null);
                    return null;
                }
                builder.addPart(extractHeaders, new RequestBodyUtil$1(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    private Headers extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        ReadableArray readableArray2 = readableArray;
        ReadableMap readableMap2 = readableMap;
        if (readableArray2 == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            ReadableArray array = readableArray2.getArray(i2);
            if (array != null && array.size() == 2) {
                String string = array.getString(i);
                StringBuilder sb = new StringBuilder(string.length());
                int length = string.length();
                boolean z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = string.charAt(i3);
                    if (charAt <= ' ' || charAt >= 127) {
                        z = true;
                    } else {
                        sb.append(charAt);
                    }
                }
                if (z) {
                    string = sb.toString();
                }
                String string2 = array.getString(1);
                StringBuilder sb2 = new StringBuilder(string2.length());
                int length2 = string2.length();
                boolean z2 = false;
                for (int i4 = 0; i4 < length2; i4++) {
                    char charAt2 = string2.charAt(i4);
                    if ((charAt2 <= 31 || charAt2 >= 127) && charAt2 != 9) {
                        z2 = true;
                    } else {
                        sb2.append(charAt2);
                    }
                }
                if (z2) {
                    string2 = sb2.toString();
                }
                if (!(string == null || string2 == null)) {
                    builder.add(string, string2);
                    i2++;
                    i = 0;
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null) {
            String str = this.mDefaultUserAgent;
            if (str != null) {
                builder.add((String) USER_AGENT_HEADER_NAME, str);
            }
        }
        if (!(readableMap2 != null && readableMap2.hasKey(REQUEST_BODY_KEY_STRING))) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    private RCTDeviceEventEmitter getEventEmitter(String str) {
        if (getReactApplicationContextIfActiveOrWarn() != null) {
            return (RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void readWithProgress(RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.mTotalBytesRead;
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    String decodeNext = progressiveStringDecoder.decodeNext(bArr, read);
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i);
                    createArray.pushString(decodeNext);
                    createArray.pushInt((int) j);
                    createArray.pushInt((int) j2);
                    if (rCTDeviceEventEmitter != null) {
                        rCTDeviceEventEmitter.emit("didReceiveNetworkIncrementalData", createArray);
                    }
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return new ProgressRequestBody(requestBody, new ProgressListener(this) {
            public long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    RCTDeviceEventEmitter rCTDeviceEventEmitter = rCTDeviceEventEmitter;
                    int i = i;
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i);
                    createArray.pushInt((int) j);
                    createArray.pushInt((int) j2);
                    if (rCTDeviceEventEmitter != null) {
                        rCTDeviceEventEmitter.emit("didSendNetworkData", createArray);
                    }
                    this.last = nanoTime;
                }
            }
        });
    }

    public void abortRequest(double d2) {
        int i = (int) d2;
        cancelRequest(i);
        removeRequest(i);
    }

    public void addListener(String str) {
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    @ReactMethod
    public void clearCookies(Callback callback) {
        ForwardingCookieHandler forwardingCookieHandler = this.mCookieHandler;
        CookieManager cookieManager = forwardingCookieHandler.getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>(callback) {
                public final /* synthetic */ Callback val$callback;

                {
                    this.val$callback = r2;
                }

                public void onReceiveValue(Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (ForwardingCookieHandler.this.mCookieSaver != null) {
                        ForwardingCookieHandler.access$200();
                        this.val$callback.invoke(bool);
                        return;
                    }
                    throw null;
                }
            });
        }
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        if (this.mCookieHandler != null) {
            this.mCookieJarContainer.removeCookieJar();
            this.mRequestBodyHandlers.clear();
            this.mResponseHandlers.clear();
            this.mUriHandlers.clear();
            return;
        }
        throw null;
    }

    public void removeListeners(double d2) {
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public void sendRequest(String str, String str2, double d2, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d3, boolean z2) {
        int i = (int) d2;
        try {
            sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, (int) d3, z2);
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to send url request: ");
            String str4 = str2;
            sb.append(str2);
            FLog.e((String) TAG, sb.toString(), th2);
            RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequest error");
            if (eventEmitter != null) {
                ImageOriginUtils.onRequestError(eventEmitter, i, th2.getMessage(), th2);
            }
        }
    }

    public void sendRequestInternal(String str, String str2, int i, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, int i2, boolean z2) {
        RequestBodyHandler requestBodyHandler;
        RequestBody requestBody;
        final int i3 = i;
        ReadableMap readableMap2 = readableMap;
        final String str4 = str3;
        int i4 = i2;
        final RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequestInternal");
        try {
            Uri parse = Uri.parse(str2);
            for (UriHandler next : this.mUriHandlers) {
                if (next.supports(parse, str4)) {
                    WritableMap fetch = next.fetch(parse);
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i3);
                    createArray.pushMap(fetch);
                    if (eventEmitter != null) {
                        eventEmitter.emit("didReceiveNetworkData", createArray);
                    }
                    ImageOriginUtils.onRequestSuccess(eventEmitter, i3);
                    return;
                }
            }
            try {
                String str5 = str2;
                Request.Builder url = new Request.Builder().url(str2);
                if (i3 != 0) {
                    url.tag(Integer.valueOf(i));
                }
                Builder newBuilder = this.mClient.newBuilder();
                applyCustomBuilder(newBuilder);
                if (!z2) {
                    newBuilder.cookieJar(CookieJar.NO_COOKIES);
                }
                if (z) {
                    newBuilder.addNetworkInterceptor(new Interceptor(this) {
                        public Response intercept(Chain chain) throws IOException {
                            Response proceed = chain.proceed(chain.request());
                            return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), new ProgressListener() {
                                public long last = System.nanoTime();

                                public void onProgress(long j, long j2, boolean z) {
                                    long nanoTime = System.nanoTime();
                                    if ((z || NetworkingModule.shouldDispatch(nanoTime, this.last)) && !str4.equals("text")) {
                                        AnonymousClass1 r9 = AnonymousClass1.this;
                                        RCTDeviceEventEmitter rCTDeviceEventEmitter = eventEmitter;
                                        int i = i3;
                                        WritableArray createArray = Arguments.createArray();
                                        createArray.pushInt(i);
                                        createArray.pushInt((int) j);
                                        createArray.pushInt((int) j2);
                                        if (rCTDeviceEventEmitter != null) {
                                            rCTDeviceEventEmitter.emit("didReceiveNetworkDataProgress", createArray);
                                        }
                                        this.last = nanoTime;
                                    }
                                }
                            })).build();
                        }
                    });
                }
                if (i4 != this.mClient.connectTimeoutMillis()) {
                    newBuilder.connectTimeout((long) i4, TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = newBuilder.build();
                Headers extractHeaders = extractHeaders(readableArray, readableMap2);
                if (extractHeaders == null) {
                    ImageOriginUtils.onRequestError(eventEmitter, i3, "Unrecognized headers format", null);
                    return;
                }
                String str6 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                String str7 = extractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                url.headers(extractHeaders);
                if (readableMap2 != null) {
                    Iterator<RequestBodyHandler> it = this.mRequestBodyHandlers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        requestBodyHandler = it.next();
                        if (requestBodyHandler.supports(readableMap2)) {
                            break;
                        }
                    }
                }
                requestBodyHandler = null;
                if (readableMap2 == null || str.toLowerCase().equals(Constant.GET) || str.toLowerCase().equals(HeaderTable.TAG)) {
                    requestBody = ImageOriginUtils.getEmptyBody(str);
                } else if (requestBodyHandler != null) {
                    requestBody = requestBodyHandler.toRequestBody(readableMap2, str6);
                } else if (readableMap2.hasKey(REQUEST_BODY_KEY_STRING)) {
                    if (str6 == null) {
                        ImageOriginUtils.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    String string = readableMap2.getString(REQUEST_BODY_KEY_STRING);
                    MediaType parse2 = MediaType.parse(str6);
                    if ("gzip".equalsIgnoreCase(str7)) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(string.getBytes());
                            gZIPOutputStream.close();
                            requestBody = RequestBody.create(parse2, byteArrayOutputStream.toByteArray());
                        } catch (IOException unused) {
                            requestBody = null;
                        }
                        if (requestBody == null) {
                            ImageOriginUtils.onRequestError(eventEmitter, i3, "Failed to gzip request body", null);
                            return;
                        }
                    } else {
                        Charset charset = StandardCharsets.UTF_8;
                        if (parse2 != null) {
                            charset = parse2.charset(charset);
                        }
                        requestBody = RequestBody.create(parse2, string.getBytes(charset));
                    }
                } else if (readableMap2.hasKey("base64")) {
                    if (str6 == null) {
                        ImageOriginUtils.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    } else {
                        requestBody = RequestBody.create(MediaType.parse(str6), ByteString.decodeBase64(readableMap2.getString("base64")));
                    }
                } else if (readableMap2.hasKey("uri")) {
                    if (str6 == null) {
                        ImageOriginUtils.onRequestError(eventEmitter, i3, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    InputStream fileInputStream = ImageOriginUtils.getFileInputStream(getReactApplicationContext(), readableMap2.getString("uri"));
                    if (fileInputStream == null) {
                        ImageOriginUtils.onRequestError(eventEmitter, i3, "Could not retrieve file for uri " + r0, null);
                        return;
                    }
                    requestBody = new RequestBodyUtil$1(MediaType.parse(str6), fileInputStream);
                } else if (readableMap2.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                    if (str6 == null) {
                        str6 = "multipart/form-data";
                    }
                    MultipartBody.Builder constructMultipartBody = constructMultipartBody(readableMap2.getArray(REQUEST_BODY_KEY_FORMDATA), str6, i3);
                    if (constructMultipartBody != null) {
                        requestBody = constructMultipartBody.build();
                    } else {
                        return;
                    }
                } else {
                    requestBody = ImageOriginUtils.getEmptyBody(str);
                }
                String str8 = str;
                url.method(str, wrapRequestBodyWithProgressEmitter(requestBody, eventEmitter, i3));
                addRequest(i3);
                Call newCall = build.newCall(url.build());
                final int i5 = i;
                final String str9 = str3;
                final boolean z3 = z;
                AnonymousClass2 r1 = new okhttp3.Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        String str;
                        if (!NetworkingModule.this.mShuttingDown) {
                            NetworkingModule.this.removeRequest(i5);
                            if (iOException.getMessage() != null) {
                                str = iOException.getMessage();
                            } else {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while executing request: ");
                                outline73.append(iOException.getClass().getSimpleName());
                                str = outline73.toString();
                            }
                            ImageOriginUtils.onRequestError(eventEmitter, i5, str, iOException);
                        }
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseHandler responseHandler;
                        if (!NetworkingModule.this.mShuttingDown) {
                            NetworkingModule.this.removeRequest(i5);
                            RCTDeviceEventEmitter rCTDeviceEventEmitter = eventEmitter;
                            int i = i5;
                            int code = response.code();
                            WritableMap access$300 = NetworkingModule.translateHeaders(response.headers());
                            String httpUrl = response.request().url().toString();
                            WritableArray createArray = Arguments.createArray();
                            createArray.pushInt(i);
                            createArray.pushInt(code);
                            createArray.pushMap(access$300);
                            createArray.pushString(httpUrl);
                            if (rCTDeviceEventEmitter != null) {
                                rCTDeviceEventEmitter.emit("didReceiveNetworkResponse", createArray);
                            }
                            try {
                                ResponseBody body = response.body();
                                if ("gzip".equalsIgnoreCase(response.header("Content-Encoding")) && body != null) {
                                    GzipSource gzipSource = new GzipSource(body.source());
                                    String header = response.header("Content-Type");
                                    body = ResponseBody.create(header != null ? MediaType.parse(header) : null, -1, Okio.buffer((Source) gzipSource));
                                }
                                Iterator it = NetworkingModule.this.mResponseHandlers.iterator();
                                do {
                                    if (it.hasNext()) {
                                        responseHandler = (ResponseHandler) it.next();
                                    } else {
                                        if (z3) {
                                            if (str9.equals("text")) {
                                                NetworkingModule.this.readWithProgress(eventEmitter, i5, body);
                                                ImageOriginUtils.onRequestSuccess(eventEmitter, i5);
                                                return;
                                            }
                                        }
                                        String str = "";
                                        if (str9.equals("text")) {
                                            try {
                                                str = body.string();
                                            } catch (IOException e2) {
                                                if (!response.request().method().equalsIgnoreCase(BuildConfig.SCM_BRANCH)) {
                                                    ImageOriginUtils.onRequestError(eventEmitter, i5, e2.getMessage(), e2);
                                                }
                                            }
                                        } else if (str9.equals("base64")) {
                                            str = Base64.encodeToString(body.bytes(), 2);
                                        }
                                        RCTDeviceEventEmitter rCTDeviceEventEmitter2 = eventEmitter;
                                        int i2 = i5;
                                        WritableArray createArray2 = Arguments.createArray();
                                        createArray2.pushInt(i2);
                                        createArray2.pushString(str);
                                        if (rCTDeviceEventEmitter2 != null) {
                                            rCTDeviceEventEmitter2.emit("didReceiveNetworkData", createArray2);
                                        }
                                        ImageOriginUtils.onRequestSuccess(eventEmitter, i5);
                                        return;
                                    }
                                } while (!responseHandler.supports(str9));
                                WritableMap responseData = responseHandler.toResponseData(body);
                                RCTDeviceEventEmitter rCTDeviceEventEmitter3 = eventEmitter;
                                int i3 = i5;
                                WritableArray createArray3 = Arguments.createArray();
                                createArray3.pushInt(i3);
                                createArray3.pushMap(responseData);
                                if (rCTDeviceEventEmitter3 != null) {
                                    rCTDeviceEventEmitter3.emit("didReceiveNetworkData", createArray3);
                                }
                                ImageOriginUtils.onRequestSuccess(eventEmitter, i5);
                            } catch (IOException e3) {
                                ImageOriginUtils.onRequestError(eventEmitter, i5, e3.getMessage(), e3);
                            }
                        }
                    }
                };
                FirebasePerfOkHttpClient.enqueue(newCall, r1);
            } catch (Exception e2) {
                ImageOriginUtils.onRequestError(eventEmitter, i3, e2.getMessage(), null);
            }
        } catch (IOException e3) {
            ImageOriginUtils.onRequestError(eventEmitter, i3, e3.getMessage(), e3);
        }
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null, ImageOriginUtils.createClient(reactApplicationContext), null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, null, ImageOriginUtils.createClient(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, ImageOriginUtils.createClient(reactApplicationContext), null);
    }
}
