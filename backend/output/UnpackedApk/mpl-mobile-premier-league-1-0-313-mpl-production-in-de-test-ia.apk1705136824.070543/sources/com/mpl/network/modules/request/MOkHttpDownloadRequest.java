package com.mpl.network.modules.request;

import a.a.a.a.a.e;
import a.a.a.a.d.b;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Keep
public final class MOkHttpDownloadRequest extends MOkHttpGetRequest {
    public static final String TAG = "NetworkLib: MOkHttpDownloadRequest";

    public static class Builder {
        public int connectTimeout;
        public File destFile;
        public String destFileName;
        public long downloadedSize;
        public String host;
        public boolean isCachingRequired;
        public String mAndroidAppVersion;
        public int mChunckDelay;
        public List<MHeader> mHeaders;
        public String mMainUrl;
        public OkHttpClient mOkHttpClient;
        public Map<String, String> mQueryParams;
        public String mReactVersion;
        public RequestPriority mRequestPriority = RequestPriority.HIGH;
        public RequestType mRequestType;
        public IResponseListener mResponseListener;
        public int pingInterval;
        public int port;
        public int readTimeout;
        public Request request;
        public RequestBody requestBody;
        public boolean retryOnConnectionFailure;
        public String scheme;
        public Object tag;
        public int type;
        public List<String> urlPathSegments;
        public int writeTimeout;

        private Builder setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        private Builder setRequest(Request request2) {
            this.request = request2;
            return this;
        }

        private Builder setRequestBody(RequestBody requestBody2) {
            this.requestBody = requestBody2;
            return this;
        }

        private Builder setRequestType(RequestType requestType) {
            this.mRequestType = requestType;
            return this;
        }

        public Builder addHeader(MHeader mHeader) {
            if (mHeader != null) {
                if (this.mHeaders == null) {
                    this.mHeaders = new ArrayList();
                }
                this.mHeaders.add(mHeader);
                return this;
            }
            throw new NullPointerException("header == null");
        }

        public Builder addQueryParam(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new NullPointerException("key == null or value == null");
            }
            if (this.mQueryParams == null) {
                this.mQueryParams = new IdentityHashMap();
            }
            this.mQueryParams.put(str, str2);
            return this;
        }

        public MOkHttpDownloadRequest build() {
            if (this.destFile == null) {
                throw new NullPointerException("destFile == null");
            } else if (this.destFileName == null) {
                throw new NullPointerException("destFileName == null");
            } else if (this.mResponseListener != null) {
                return new MOkHttpDownloadRequest(this);
            } else {
                throw new NullPointerException("mResponseListener == null");
            }
        }

        public Builder isCacheRequired(boolean z) {
            this.isCachingRequired = z;
            return this;
        }

        public Builder setAndroidAppVersion(String str) {
            this.mAndroidAppVersion = str;
            return this;
        }

        public Builder setChunckDelay(int i) {
            this.mChunckDelay = i;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setConnectTimeout(int i, TimeUnit timeUnit) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setDestFile(File file) {
            if (file != null) {
                this.destFile = file;
                return this;
            }
            throw new NullPointerException("destFile == null");
        }

        public Builder setDestFileName(String str) {
            if (str != null) {
                this.destFileName = str;
                return this;
            }
            throw new NullPointerException("destFileName == null");
        }

        public Builder setDownloadedSize(long j) {
            this.downloadedSize = j;
            return this;
        }

        public Builder setHeaders(List<MHeader> list) {
            List<MHeader> list2 = this.mHeaders;
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.mHeaders = list;
            }
            return this;
        }

        public Builder setHost(String str) {
            if (this.mMainUrl == null) {
                this.host = str;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setPathSegments(List<String> list) {
            this.urlPathSegments = list;
            return this;
        }

        public Builder setPingInterval(int i) {
            this.pingInterval = b.a("interval", (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setPingInterval(int i, TimeUnit timeUnit) {
            this.pingInterval = b.a("interval", (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setPort(int i) {
            if (this.mMainUrl == null) {
                this.port = i;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setQueryParams(Map<String, String> map) {
            Map<String, String> map2 = this.mQueryParams;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                this.mQueryParams = map;
            }
            return this;
        }

        public Builder setReactVersion(String str) {
            this.mReactVersion = str;
            return this;
        }

        public Builder setReadTimeout(int i) {
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setReadTimeout(int i, TimeUnit timeUnit) {
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setRequestPriority(RequestPriority requestPriority) {
            this.mRequestPriority = requestPriority;
            return this;
        }

        public Builder setResponseListener(IResponseListener iResponseListener) {
            this.mResponseListener = iResponseListener;
            return this;
        }

        public Builder setRetryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder setScheme(String str) {
            if (this.mMainUrl == null) {
                this.scheme = str;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setType(int i) {
            this.type = i;
            return this;
        }

        public Builder setUrl(String str) {
            if (!TextUtils.isEmpty(this.scheme) || !TextUtils.isEmpty(this.host) || this.port != 0) {
                throw new RuntimeException("scheme or host is already set. ");
            }
            this.mMainUrl = str;
            return this;
        }

        public Builder setWriteTimeout(int i) {
            this.writeTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setWriteTimeout(int i, TimeUnit timeUnit) {
            this.writeTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }
    }

    public MOkHttpDownloadRequest(Builder builder) {
        this.type = builder.type;
        this.destFile = builder.destFile;
        this.destFileName = builder.destFileName;
        this.mHeaders = builder.mHeaders;
        this.mRequestType = builder.mRequestType;
        this.mQueryParams = builder.mQueryParams;
        this.mMainUrl = builder.mMainUrl;
        this.tag = builder.tag;
        this.mRequestPriority = builder.mRequestPriority;
        this.urlPathSegments = builder.urlPathSegments;
        this.mResponseListener = builder.mResponseListener;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        this.requestBody = builder.requestBody;
        this.request = builder.request;
        this.scheme = builder.scheme;
        this.port = builder.port;
        this.host = builder.host;
        this.isCachingRequired = builder.isCachingRequired;
        this.downloadedSize = builder.downloadedSize;
        this.mAndroidAppVersion = builder.mAndroidAppVersion;
        this.mReactVersion = builder.mReactVersion;
        this.mChunckDelay = builder.mChunckDelay;
        this.mOkHttpClient = e.c().a((MRequest) this);
    }

    public Object clone() {
        throw new CloneNotSupportedException();
    }

    public long getDownloadedSize() {
        return this.downloadedSize;
    }

    public OkHttpClient prepareClient() {
        return super.prepareClient();
    }

    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r15v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r14v0, types: [okhttp3.ResponseBody] */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r15v5 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r15v7 */
    /* JADX WARNING: type inference failed for: r18v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r18v7 */
    /* JADX WARNING: type inference failed for: r15v8, types: [okio.BufferedSource] */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r18v9 */
    /* JADX WARNING: type inference failed for: r14v1 */
    /* JADX WARNING: type inference failed for: r18v10 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r18v11 */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v37 */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r3v38 */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r15v10 */
    /* JADX WARNING: type inference failed for: r18v12 */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: type inference failed for: r18v13 */
    /* JADX WARNING: type inference failed for: r18v14 */
    /* JADX WARNING: type inference failed for: r18v15 */
    /* JADX WARNING: type inference failed for: r18v16 */
    /* JADX WARNING: type inference failed for: r15v12 */
    /* JADX WARNING: type inference failed for: r15v13 */
    /* JADX WARNING: type inference failed for: r15v14 */
    /* JADX WARNING: type inference failed for: r15v15 */
    /* JADX WARNING: type inference failed for: r15v16 */
    /* JADX WARNING: type inference failed for: r15v17 */
    /* JADX WARNING: type inference failed for: r18v17 */
    /* JADX WARNING: type inference failed for: r18v18 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r15v4
      assigns: []
      uses: []
      mth insns count: 246
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d5 A[Catch:{ all -> 0x020b }, LOOP:3: B:110:0x01cf->B:112:0x01d5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 18 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E> void processResponse(okhttp3.Call r24, okhttp3.Response r25, com.mpl.network.modules.listeners.IResponseListener<E> r26) {
        /*
            r23 = this;
            r1 = r23
            r2 = r25
            r9 = r26
            java.lang.String r10 = "NetworkLib: MOkHttpDownloadRequest"
            java.io.File r0 = r23.getDestFile()
            if (r0 == 0) goto L_0x0220
            java.io.File r0 = r23.getDestFile()
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0220
            r3 = 0
            r11 = 1
            r12 = 0
            java.io.File r0 = r23.getDestFile()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            r13 = 2
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            java.lang.String r5 = "downloadedFile: "
            r4[r12] = r5     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            r4[r11] = r0     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            com.mpl.MLog.i(r10, r4)     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            okhttp3.Headers r4 = r25.headers()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            r5.<init>()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            if (r4 == 0) goto L_0x005d
            int r6 = r4.size()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            if (r6 <= 0) goto L_0x005d
            java.util.Set r6 = r4.names()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
        L_0x0044:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            if (r7 == 0) goto L_0x005d
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            java.lang.String r8 = r4.get(r7)     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            com.mpl.network.modules.engine.MHeader r14 = new com.mpl.network.modules.engine.MHeader     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            r14.<init>(r7, r8)     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            r5.add(r14)     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            goto L_0x0044
        L_0x005d:
            int r6 = r5.size()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            if (r6 <= 0) goto L_0x0066
            r9.onProcessHeader(r5)     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
        L_0x0066:
            okhttp3.ResponseBody r14 = r25.body()     // Catch:{ IOException -> 0x019b, all -> 0x0197 }
            if (r14 == 0) goto L_0x013e
            okio.BufferedSource r15 = r14.source()     // Catch:{ IOException -> 0x013a, all -> 0x0136 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            java.io.InputStream r3 = r14.byteStream()     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            long r3 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0091
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x008d, all -> 0x0089 }
            r3.<init>(r0, r11)     // Catch:{ IOException -> 0x008d, all -> 0x0089 }
            goto L_0x0096
        L_0x0089:
            r0 = move-exception
            r3 = r14
            goto L_0x020c
        L_0x008d:
            r0 = move-exception
            r3 = r14
            goto L_0x019d
        L_0x0091:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            r3.<init>(r0, r12)     // Catch:{ IOException -> 0x0132, all -> 0x012e }
        L_0x0096:
            r7 = r3
            long r3 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 <= 0) goto L_0x00a3
            long r5 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x008d, all -> 0x0089 }
        L_0x00a3:
            long r16 = r14.contentLength()     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ IOException -> 0x0132, all -> 0x012e }
        L_0x00ab:
            int r3 = r8.read(r4)     // Catch:{ IOException -> 0x0132, all -> 0x012e }
            r11 = -1
            if (r3 == r11) goto L_0x010f
            r18 = r14
            long r13 = (long) r3
            long r13 = r13 + r5
            r7.write(r4, r12, r3)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            r5 = 100
            long r5 = r5 * r13
            long r5 = r5 / r16
            int r3 = (int) r5     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            r11 = 2
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            r5[r12] = r3     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            java.lang.String r3 = "% downloaded"
            r6 = 1
            r5[r6] = r3     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            com.mpl.MLog.i(r10, r5)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            int r3 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r3 != 0) goto L_0x00d8
            r19 = 1
            goto L_0x00da
        L_0x00d8:
            r19 = 0
        L_0x00da:
            r3 = r26
            r20 = r4
            r4 = r13
            r21 = r7
            r6 = r16
            r22 = r8
            r8 = r19
            r3.progressResponse(r4, r6, r8)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            int r3 = r23.getChunckDelay()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            if (r3 <= 0) goto L_0x0103
            int r3 = r23.getChunckDelay()     // Catch:{ InterruptedException -> 0x00f9 }
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x00f9 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00f9 }
            goto L_0x0103
        L_0x00f9:
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            java.lang.String r3 = "chunk sleep interrupted"
            r4[r12] = r3     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            com.mpl.MLog.d(r10, r4)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        L_0x0103:
            r5 = r13
            r14 = r18
            r4 = r20
            r7 = r21
            r8 = r22
            r11 = 1
            r13 = 2
            goto L_0x00ab
        L_0x010f:
            r18 = r14
            java.lang.reflect.Type r3 = r9.mType     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            java.lang.Class<java.io.File> r4 = java.io.File.class
            if (r3 != r4) goto L_0x011a
            r9.onResponseSuccess(r0)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        L_0x011a:
            java.lang.reflect.Type r3 = r9.mType     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r3 != r4) goto L_0x0127
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
            r9.onResponseSuccess(r0)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        L_0x0127:
            r3 = r15
            goto L_0x017a
        L_0x0129:
            r0 = move-exception
            goto L_0x018e
        L_0x012b:
            r0 = move-exception
            goto L_0x0194
        L_0x012e:
            r0 = move-exception
            r18 = r14
            goto L_0x018e
        L_0x0132:
            r0 = move-exception
            r18 = r14
            goto L_0x0194
        L_0x0136:
            r0 = move-exception
            r18 = r14
            goto L_0x018d
        L_0x013a:
            r0 = move-exception
            r18 = r14
            goto L_0x0193
        L_0x013e:
            r18 = r14
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            r0.<init>()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            if (r4 == 0) goto L_0x0169
            int r5 = r4.size()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            if (r5 <= 0) goto L_0x0169
            java.util.Set r5 = r4.names()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
        L_0x0155:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            if (r6 == 0) goto L_0x0169
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            java.lang.String r7 = r4.get(r6)     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            r0.a(r6, r7)     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            goto L_0x0155
        L_0x0169:
            int r4 = r25.code()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            r0.f966c = r4     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            java.lang.String r4 = "Response body is null"
            r0.f964a = r4     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            com.mpl.network.modules.utils.MException r0 = r0.a()     // Catch:{ IOException -> 0x0192, all -> 0x018c }
            r9.onResponseFail(r0)     // Catch:{ IOException -> 0x0192, all -> 0x018c }
        L_0x017a:
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r18 == 0) goto L_0x0188
            okhttp3.internal.Util.closeQuietly(r18)
        L_0x0188:
            if (r3 == 0) goto L_0x0265
            goto L_0x0207
        L_0x018c:
            r0 = move-exception
        L_0x018d:
            r15 = r3
        L_0x018e:
            r3 = r18
            goto L_0x020c
        L_0x0192:
            r0 = move-exception
        L_0x0193:
            r15 = r3
        L_0x0194:
            r3 = r18
            goto L_0x019d
        L_0x0197:
            r0 = move-exception
            r15 = r3
            goto L_0x020c
        L_0x019b:
            r0 = move-exception
            r15 = r3
        L_0x019d:
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x020b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x020b }
            r5.<init>()     // Catch:{ all -> 0x020b }
            java.lang.String r6 = "Exception in writting file: "
            r5.append(r6)     // Catch:{ all -> 0x020b }
            r5.append(r0)     // Catch:{ all -> 0x020b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x020b }
            r4[r12] = r5     // Catch:{ all -> 0x020b }
            com.mpl.MLog.e(r10, r4)     // Catch:{ all -> 0x020b }
            com.mpl.network.modules.utils.MException$b r4 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x020b }
            r4.<init>()     // Catch:{ all -> 0x020b }
            okhttp3.Headers r5 = r25.headers()     // Catch:{ all -> 0x020b }
            if (r5 == 0) goto L_0x01e3
            int r6 = r5.size()     // Catch:{ all -> 0x020b }
            if (r6 <= 0) goto L_0x01e3
            java.util.Set r6 = r5.names()     // Catch:{ all -> 0x020b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x020b }
        L_0x01cf:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x020b }
            if (r7 == 0) goto L_0x01e3
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x020b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x020b }
            java.lang.String r8 = r5.get(r7)     // Catch:{ all -> 0x020b }
            r4.a(r7, r8)     // Catch:{ all -> 0x020b }
            goto L_0x01cf
        L_0x01e3:
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.f966c = r5     // Catch:{ all -> 0x020b }
            r4.f965b = r0     // Catch:{ all -> 0x020b }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x020b }
            r4.f964a = r0     // Catch:{ all -> 0x020b }
            com.mpl.network.modules.utils.MException r0 = r4.a()     // Catch:{ all -> 0x020b }
            r9.onResponseFail(r0)     // Catch:{ all -> 0x020b }
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r3 == 0) goto L_0x0204
            okhttp3.internal.Util.closeQuietly(r3)
        L_0x0204:
            if (r15 == 0) goto L_0x0265
            r3 = r15
        L_0x0207:
            okhttp3.internal.Util.closeQuietly(r3)
            goto L_0x0265
        L_0x020b:
            r0 = move-exception
        L_0x020c:
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r3 == 0) goto L_0x021a
            okhttp3.internal.Util.closeQuietly(r3)
        L_0x021a:
            if (r15 == 0) goto L_0x021f
            okhttp3.internal.Util.closeQuietly(r15)
        L_0x021f:
            throw r0
        L_0x0220:
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b
            r0.<init>()
            okhttp3.Headers r2 = r25.headers()
            if (r2 == 0) goto L_0x024d
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x024d
            java.util.Set r3 = r2.names()
            java.util.Iterator r3 = r3.iterator()
        L_0x0239:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x024d
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r2.get(r4)
            r0.a(r4, r5)
            goto L_0x0239
        L_0x024d:
            r2 = 1001(0x3e9, float:1.403E-42)
            r0.f966c = r2
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "File path or file name is null."
            r2.<init>(r3)
            r0.f965b = r2
            java.lang.String r2 = "Please provide destination file path and destination file name for saving file"
            r0.f964a = r2
            com.mpl.network.modules.utils.MException r0 = r0.a()
            r9.onResponseFail(r0)
        L_0x0265:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MOkHttpDownloadRequest.processResponse(okhttp3.Call, okhttp3.Response, com.mpl.network.modules.listeners.IResponseListener):void");
    }
}
