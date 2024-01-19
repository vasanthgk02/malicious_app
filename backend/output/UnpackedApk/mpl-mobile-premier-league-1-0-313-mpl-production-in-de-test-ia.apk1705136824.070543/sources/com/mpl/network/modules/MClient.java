package com.mpl.network.modules;

import a.a.a.a.a.e;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mpl.MLog;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.PriorityBlockingQueue;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner.Builder;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.http.conn.ConnectTimeoutException;

@Keep
public final class MClient {
    public static PriorityBlockingQueue<MRequest> REQUEST_PRIORITY_QUEUE = new PriorityBlockingQueue<>(40, new a());
    public static final String TAG = "NetworkLib: MClient";

    public static class a implements Comparator<MRequest> {
        public int compare(Object obj, Object obj2) {
            return ((MRequest) obj2).getRequestPriority().ordinal() - ((MRequest) obj).getRequestPriority().ordinal();
        }
    }

    public static class b implements Comparator<MRequest> {
        public int compare(Object obj, Object obj2) {
            return ((MRequest) obj2).getRequestPriority().ordinal() - ((MRequest) obj).getRequestPriority().ordinal();
        }
    }

    public static class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IResponseListener f962a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MRequest f963b;

        public c(IResponseListener iResponseListener, MRequest mRequest) {
            this.f962a = iResponseListener;
            this.f963b = mRequest;
        }

        public void onFailure(Call call, IOException iOException) {
            MLog.d(MClient.TAG, "onFailure() called with: call = [" + call + "], e = [" + iOException + CMapParser.MARK_END_OF_ARRAY);
            call.cancel();
            boolean z = iOException instanceof ProtocolException;
            boolean z2 = iOException instanceof ConnectTimeoutException;
            boolean z3 = iOException instanceof SocketTimeoutException;
            boolean z4 = iOException instanceof InterruptedIOException;
            boolean z5 = iOException instanceof SocketException;
            IResponseListener iResponseListener = this.f962a;
            com.mpl.network.modules.utils.MException.b bVar = new com.mpl.network.modules.utils.MException.b();
            bVar.f966c = 1000;
            bVar.f965b = iOException;
            bVar.f964a = iOException.getMessage();
            iResponseListener.onResponseFail(bVar.a());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:51:0x015f, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0160, code lost:
            r0 = r11.f962a;
            r1.f966c = r13.code();
            r1.f964a = r12.getMessage();
            r1.f965b = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0171, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0172, code lost:
            r12 = "{}";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x015f A[ExcHandler: IOException (r12v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:33:0x00de] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(okhttp3.Call r12, okhttp3.Response r13) {
            /*
                r11 = this;
                r12 = 1001(0x3e9, float:1.403E-42)
                java.lang.String r0 = "Response body is null"
                if (r13 != 0) goto L_0x0018
                com.mpl.network.modules.listeners.IResponseListener r13 = r11.f962a
                com.mpl.network.modules.utils.MException$b r1 = new com.mpl.network.modules.utils.MException$b
                r1.<init>()
                r1.f966c = r12
                java.lang.NullPointerException r12 = new java.lang.NullPointerException
                r12.<init>(r0)
                r1.f965b = r12
                goto L_0x018d
            L_0x0018:
                boolean r1 = r13.isSuccessful()
                r2 = 2
                java.lang.String r3 = "NetworkLib: MClient"
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x00a2
                java.lang.Object[] r12 = new java.lang.Object[r2]
                java.lang.String r0 = "Response is success: "
                r12[r4] = r0
                r12[r5] = r13
                com.mpl.MLog.i(r3, r12)
                okhttp3.Headers r12 = r13.headers()
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                if (r12 == 0) goto L_0x0068
                int r2 = r12.size()
                if (r2 <= 0) goto L_0x0068
                java.util.Set r2 = r12.names()
                java.util.Iterator r2 = r2.iterator()
            L_0x004c:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0068
                java.lang.Object r3 = r2.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.String r4 = r12.get(r3)
                com.mpl.network.modules.engine.MHeader r5 = new com.mpl.network.modules.engine.MHeader
                r5.<init>(r3, r4)
                r0.put(r3, r5)
                r1.add(r5)
                goto L_0x004c
            L_0x0068:
                int r12 = r0.size()
                if (r12 <= 0) goto L_0x0098
                java.lang.String r12 = "x-mpl-downtime"
                boolean r12 = r0.containsKey(r12)
                if (r12 == 0) goto L_0x0098
                com.mpl.network.modules.utils.MException$b r12 = new com.mpl.network.modules.utils.MException$b
                r12.<init>()
                java.util.ArrayList<com.mpl.network.modules.engine.MHeader> r13 = r12.f967d
                if (r13 != 0) goto L_0x0082
                r12.f967d = r1
                goto L_0x0085
            L_0x0082:
                r13.addAll(r1)
            L_0x0085:
                r13 = 5553(0x15b1, float:7.781E-42)
                r12.f966c = r13
                java.lang.String r13 = "Server Down"
                r12.f964a = r13
                com.mpl.network.modules.listeners.IResponseListener r13 = r11.f962a
                com.mpl.network.modules.utils.MException r12 = r12.a()
                r13.onResponseFail(r12)
                goto L_0x0197
            L_0x0098:
                com.mpl.network.modules.request.MRequest r12 = r11.f963b
                com.mpl.network.modules.listeners.IResponseListener r0 = r11.f962a
                r1 = 0
                r12.processResponse(r1, r13, r0)
                goto L_0x0197
            L_0x00a2:
                java.lang.Object[] r1 = new java.lang.Object[r5]
                java.lang.String r6 = "Response is not success: "
                r1[r4] = r6
                com.mpl.MLog.i(r3, r1)
                com.mpl.network.modules.utils.MException$b r1 = new com.mpl.network.modules.utils.MException$b
                r1.<init>()
                okhttp3.Headers r6 = r13.headers()
                if (r6 == 0) goto L_0x00d8
                int r7 = r6.size()
                if (r7 <= 0) goto L_0x00d8
                java.util.Set r7 = r6.names()
                java.util.Iterator r7 = r7.iterator()
            L_0x00c4:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x00d8
                java.lang.Object r8 = r7.next()
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String r9 = r6.get(r8)
                r1.a(r8, r9)
                goto L_0x00c4
            L_0x00d8:
                okhttp3.ResponseBody r6 = r13.body()
                if (r6 == 0) goto L_0x0182
                java.lang.String r12 = r6.string()     // Catch:{ JSONException -> 0x0171, IOException -> 0x015f }
                java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r6.<init>()     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r7 = "Response is fail, response = ["
                r6.append(r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r6.append(r12)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r7 = "]"
                r6.append(r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r0[r4] = r6     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                com.mpl.MLog.d(r3, r0)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r0.<init>(r12)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r6 = "status"
                org.json.JSONObject r6 = r0.optJSONObject(r6)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r7 = "code"
                if (r6 == 0) goto L_0x0116
                int r0 = r6.optInt(r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r10 = r6
                r6 = r0
                r0 = r10
                goto L_0x011a
            L_0x0116:
                int r6 = r0.optInt(r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
            L_0x011a:
                java.lang.String r7 = "message"
                java.lang.String r0 = r0.optString(r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r7 = 4
                java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r8 = "code: "
                r7[r4] = r8     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r7[r5] = r4     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                java.lang.String r4 = " message is: "
                r7[r2] = r4     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r2 = 3
                r7[r2] = r0     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                com.mpl.MLog.i(r3, r7)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                if (r6 == 0) goto L_0x014b
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                if (r0 == 0) goto L_0x0140
                goto L_0x014b
            L_0x0140:
                com.mpl.network.modules.listeners.IResponseListener r0 = r11.f962a     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r1.f966c = r6     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r1.f964a = r12     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                com.mpl.network.modules.utils.MException r2 = r1.a()     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                goto L_0x0159
            L_0x014b:
                com.mpl.network.modules.listeners.IResponseListener r0 = r11.f962a     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                int r2 = r13.code()     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r1.f966c = r2     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                r1.f964a = r12     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                com.mpl.network.modules.utils.MException r2 = r1.a()     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
            L_0x0159:
                r0.onResponseFail(r2)     // Catch:{ JSONException -> 0x015d, IOException -> 0x015f }
                goto L_0x0197
            L_0x015d:
                r0 = move-exception
                goto L_0x0174
            L_0x015f:
                r12 = move-exception
                com.mpl.network.modules.listeners.IResponseListener r0 = r11.f962a
                int r13 = r13.code()
                r1.f966c = r13
                java.lang.String r13 = r12.getMessage()
                r1.f964a = r13
                r1.f965b = r12
                goto L_0x0190
            L_0x0171:
                r0 = move-exception
                java.lang.String r12 = "{}"
            L_0x0174:
                r0.printStackTrace()
                com.mpl.network.modules.listeners.IResponseListener r0 = r11.f962a
                int r13 = r13.code()
                r1.f966c = r13
                r1.f964a = r12
                goto L_0x0190
            L_0x0182:
                com.mpl.network.modules.listeners.IResponseListener r13 = r11.f962a
                r1.f966c = r12
                java.lang.NullPointerException r12 = new java.lang.NullPointerException
                r12.<init>(r0)
                r1.f965b = r12
            L_0x018d:
                r1.f964a = r0
                r0 = r13
            L_0x0190:
                com.mpl.network.modules.utils.MException r12 = r1.a()
                r0.onResponseFail(r12)
            L_0x0197:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.MClient.c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    public static void addRequest(MRequest mRequest) {
        if (mRequest != null) {
            PriorityBlockingQueue<MRequest> priorityBlockingQueue = REQUEST_PRIORITY_QUEUE;
            if (priorityBlockingQueue == null) {
                REQUEST_PRIORITY_QUEUE = new PriorityBlockingQueue<>(40, new b());
            } else if (priorityBlockingQueue.contains(mRequest)) {
                MLog.e(TAG, "Already in progress");
                return;
            } else {
                REQUEST_PRIORITY_QUEUE.add(mRequest);
                if (REQUEST_PRIORITY_QUEUE.size() == 1) {
                    mRequest = REQUEST_PRIORITY_QUEUE.poll();
                }
                return;
            }
            executeAsync(mRequest);
            return;
        }
        throw new NullPointerException("request == null,Request Can not be null");
    }

    public static void cancelCallWithTag(String str) {
        e c2 = e.c();
        for (Call next : c2.f2398a.dispatcher().queuedCalls()) {
            if (str.equals(next.request().tag())) {
                next.cancel();
            }
        }
        for (Call next2 : c2.f2398a.dispatcher().runningCalls()) {
            if (str.equals(next2.request().tag())) {
                next2.cancel();
            }
        }
    }

    public static void createAddCertificatePinner(String str, String... strArr) {
        if (str == null) {
            throw new NullPointerException("pattern == null");
        } else if (strArr == null) {
            throw new NullPointerException("pins == null");
        } else if (strArr.length >= 0) {
            e.c().a(new Builder().add(str, strArr).build());
        } else {
            throw new RuntimeException("pins length should be greater than 0");
        }
    }

    public static void createAddMultipleCertificatePinners(LinkedHashMap<String, String[]> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            throw new NullPointerException("pattern == null or length is zero");
        }
        Builder builder = new Builder();
        for (Entry next : linkedHashMap.entrySet()) {
            builder.add((String) next.getKey(), (String[]) next.getValue());
        }
        e.c().a(builder.build());
    }

    public static void executeAsync(MRequest mRequest) {
        if (mRequest == null) {
            throw new NullPointerException("request can not be null");
        } else if (mRequest.getResponseListener() != null) {
            IResponseListener responseListener = mRequest.getResponseListener();
            if (!mRequest.isValid()) {
                com.mpl.network.modules.utils.MException.b bVar = new com.mpl.network.modules.utils.MException.b();
                bVar.f966c = 1001;
                bVar.f965b = new NullPointerException("URL is null or not proper");
                bVar.f964a = "Please provide URL";
                responseListener.onResponseFail(bVar.a());
            } else if (!(mRequest instanceof MOKHttpPostRequest) || mRequest.getRequestBody() != null) {
                processRequest(mRequest, responseListener);
            } else {
                com.mpl.network.modules.utils.MException.b bVar2 = new com.mpl.network.modules.utils.MException.b();
                bVar2.f966c = 1001;
                bVar2.f965b = new NullPointerException("RequestBody is null.");
                bVar2.f964a = "Please provide request body for POST/PUT call.";
                responseListener.onResponseFail(bVar2.a());
            }
        } else {
            com.mpl.network.modules.utils.MException.b bVar3 = new com.mpl.network.modules.utils.MException.b();
            bVar3.f966c = 1001;
            bVar3.f965b = new NullPointerException("IResponseListener is null.");
            bVar3.f964a = "Please provide IResponseListener";
            throw bVar3.a();
        }
    }

    public static void executeNextTask() {
        MRequest poll = REQUEST_PRIORITY_QUEUE.poll();
        if (poll != null) {
            executeAsync(poll);
            return;
        }
        MLog.e(TAG, "All request completed");
    }

    public static void executeSync(MRequest mRequest) {
    }

    public static boolean isCertificatePinnerAvailable() {
        OkHttpClient okHttpClient = e.c().f2398a;
        return (okHttpClient == null || okHttpClient.certificatePinner() == null) ? false : true;
    }

    public static boolean isRequestQueue(String str) {
        String str2 = str;
        e c2 = e.c();
        Dispatcher dispatcher = c2.f2399b;
        if (dispatcher != null) {
            int queuedCallsCount = dispatcher.queuedCallsCount();
            List<Call> queuedCalls = c2.f2399b.queuedCalls();
            MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", " queuedCallsCount: ", Integer.valueOf(queuedCallsCount), " queuedCalls: ", queuedCalls);
            for (int i = 0; i < queuedCallsCount; i++) {
                Call call = queuedCalls.get(i);
                MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", Boolean.valueOf(call.request().tag() instanceof String));
                MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", Boolean.valueOf(str2.equalsIgnoreCase(String.valueOf(call.request().tag()))));
                if ((call.request().tag() instanceof String) && str2.equalsIgnoreCase(String.valueOf(call.request().tag()))) {
                    return true;
                }
            }
        }
        Dispatcher dispatcher2 = c2.f2400c;
        if (dispatcher2 != null) {
            int queuedCallsCount2 = dispatcher2.queuedCallsCount();
            List<Call> queuedCalls2 = c2.f2400c.queuedCalls();
            MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", " queuedCallsCount: ", Integer.valueOf(queuedCallsCount2), " queuedCalls: ", queuedCalls2);
            for (int i2 = 0; i2 < queuedCallsCount2; i2++) {
                Call call2 = queuedCalls2.get(i2);
                MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", Boolean.valueOf(call2.request().tag() instanceof String));
                MLog.d("NetworkLib: MClientBuilder", "isRequestQueue: ", Boolean.valueOf(str2.equalsIgnoreCase(String.valueOf(call2.request().tag()))));
                if ((call2.request().tag() instanceof String) && str2.equalsIgnoreCase(String.valueOf(call2.request().tag()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isRequestRunning(String str) {
        String str2 = str;
        e c2 = e.c();
        Dispatcher dispatcher = c2.f2399b;
        if (dispatcher != null) {
            int runningCallsCount = dispatcher.runningCallsCount();
            List<Call> runningCalls = c2.f2399b.runningCalls();
            MLog.d("NetworkLib: MClientBuilder", "isRequestRunning: ", " runningCallsCount: ", Integer.valueOf(runningCallsCount), " runningCalls: ", runningCalls);
            for (int i = 0; i < runningCallsCount; i++) {
                Call call = runningCalls.get(i);
                if ((call.request().tag() instanceof String) && str2.equalsIgnoreCase(String.valueOf(call.request().tag()))) {
                    return true;
                }
            }
        }
        Dispatcher dispatcher2 = c2.f2400c;
        if (dispatcher2 != null) {
            int runningCallsCount2 = dispatcher2.runningCallsCount();
            List<Call> runningCalls2 = c2.f2400c.runningCalls();
            MLog.d("NetworkLib: MClientBuilder", "isRequestRunning: ", " runningCallsCount: ", Integer.valueOf(runningCallsCount2), " runningCalls: ", runningCalls2);
            for (int i2 = 0; i2 < runningCallsCount2; i2++) {
                Call call2 = runningCalls2.get(i2);
                if ((call2.request().tag() instanceof String) && str2.equalsIgnoreCase(String.valueOf(call2.request().tag()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void print() {
        while (!REQUEST_PRIORITY_QUEUE.isEmpty()) {
            MLog.d(TAG, REQUEST_PRIORITY_QUEUE.poll().getTag());
        }
    }

    public static void processRequest(MRequest mRequest, IResponseListener iResponseListener) {
        OkHttpClient okHttpClient = mRequest.getOkHttpClient();
        Request prepareRequest = mRequest.prepareRequest();
        MLog.i(TAG, mRequest.printRequest());
        FirebasePerfOkHttpClient.enqueue(okHttpClient.newCall(prepareRequest), new c(iResponseListener, mRequest));
    }

    public static void removeCertificatePinner() {
        e.c().f2401d = null;
    }

    public static void setLogEnable(boolean z) {
        MLog.setIsLogEnabled(z);
        e.f2397f = z;
    }

    public static void setLogEnable(boolean z, Context context) {
        setLogEnable(z);
    }

    public static void setProtocols(List<Protocol> list) {
        e.g = list;
    }
}
