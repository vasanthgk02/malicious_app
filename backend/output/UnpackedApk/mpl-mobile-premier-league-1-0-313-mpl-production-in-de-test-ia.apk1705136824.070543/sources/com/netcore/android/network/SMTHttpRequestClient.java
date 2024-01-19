package com.netcore.android.network;

import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00050\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/netcore/android/network/SMTHttpRequestClient;", "", "Ljava/io/InputStream;", "Ljava/nio/charset/Charset;", "charset", "", "readTextAndClose", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;", "inputStream", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "readGzipStream", "(Ljava/io/InputStream;)Ljava/lang/StringBuilder;", "Lcom/netcore/android/network/models/SMTRequest;", "request", "Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "makeNetworkCall$smartech_release", "(Lcom/netcore/android/network/models/SMTRequest;)Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "makeNetworkCall", "GZIP", "Ljava/lang/String;", "getGZIP", "()Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "getTAG", "<init>", "()V", "NetworkResponse", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTHttpRequestClient.kt */
public final class SMTHttpRequestClient {
    public final String GZIP = "gzip";
    public final String TAG = SMTHttpRequestClient.class.getSimpleName();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001d¨\u0006%"}, d2 = {"Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "", "", "response", "Ljava/lang/String;", "getResponse", "()Ljava/lang/String;", "setResponse", "(Ljava/lang/String;)V", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "apiID", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "getApiID", "()Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "setApiID", "(Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;)V", "", "httpCode", "Ljava/lang/Integer;", "getHttpCode", "()Ljava/lang/Integer;", "setHttpCode", "(Ljava/lang/Integer;)V", "", "shouldRetry", "Z", "getShouldRetry", "()Z", "setShouldRetry", "(Z)V", "errorMessage", "getErrorMessage", "setErrorMessage", "isSuccess", "setSuccess", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTHttpRequestClient.kt */
    public static final class NetworkResponse {
        public SMTApiTypeID apiID;
        public String errorMessage;
        public Integer httpCode;
        public boolean isSuccess = true;
        public String response;
        public boolean shouldRetry;

        public final SMTApiTypeID getApiID() {
            SMTApiTypeID sMTApiTypeID = this.apiID;
            if (sMTApiTypeID != null) {
                return sMTApiTypeID;
            }
            Intrinsics.throwUninitializedPropertyAccessException("apiID");
            throw null;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Integer getHttpCode() {
            return this.httpCode;
        }

        public final String getResponse() {
            return this.response;
        }

        public final boolean getShouldRetry() {
            return this.shouldRetry;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }

        public final void setApiID(SMTApiTypeID sMTApiTypeID) {
            Intrinsics.checkNotNullParameter(sMTApiTypeID, "<set-?>");
            this.apiID = sMTApiTypeID;
        }

        public final void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public final void setHttpCode(Integer num) {
            this.httpCode = num;
        }

        public final void setResponse(String str) {
            this.response = str;
        }

        public final void setShouldRetry(boolean z) {
            this.shouldRetry = z;
        }

        public final void setSuccess(boolean z) {
            this.isSuccess = z;
        }
    }

    private final StringBuilder readGzipStream(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append("\n");
                } else {
                    inputStreamReader.close();
                    bufferedReader.close();
                    gZIPInputStream.close();
                    return sb;
                }
            }
        } catch (IOException e2) {
            e2.getMessage();
            sb.append("");
            Intrinsics.checkNotNullExpressionValue(sb, "output.append(\"\")");
            return sb;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readTextAndClose(java.io.InputStream r2, java.nio.charset.Charset r3) {
        /*
            r1 = this;
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x000c
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0014
        L_0x000c:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x0014:
            r2 = 0
            java.lang.String r3 = com.twitter.sdk.android.tweetui.TweetUtils.readText(r0)     // Catch:{ all -> 0x001d }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r2)
            return r3
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.network.SMTHttpRequestClient.readTextAndClose(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String readTextAndClose$default(SMTHttpRequestClient sMTHttpRequestClient, InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return sMTHttpRequestClient.readTextAndClose(inputStream, charset);
    }

    public final String getGZIP() {
        return this.GZIP;
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c3, code lost:
        if (r6 != 0) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01c5, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c8, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016b, code lost:
        if (r6 != 0) goto L_0x01c5;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v6
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.Integer]
      uses: [java.lang.Integer, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection]
      mth insns count: 167
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0185 A[Catch:{ Exception -> 0x01a4, all -> 0x01c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x018a A[Catch:{ Exception -> 0x01a4, all -> 0x01c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x018d A[Catch:{ Exception -> 0x01a4, all -> 0x01c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0192 A[Catch:{ Exception -> 0x01a4, all -> 0x01c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0198 A[SYNTHETIC, Splitter:B:97:0x0198] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.netcore.android.network.SMTHttpRequestClient.NetworkResponse makeNetworkCall$smartech_release(com.netcore.android.network.models.SMTRequest r12) {
        /*
            r11 = this;
            java.lang.String r0 = "e.localizedMessage"
            java.lang.String r1 = "TAG"
            java.lang.String r2 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            com.netcore.android.network.SMTHttpRequestClient$NetworkResponse r2 = new com.netcore.android.network.SMTHttpRequestClient$NetworkResponse
            r2.<init>()
            com.netcore.android.network.models.SMTRequest$SMTApiTypeID r3 = r12.getAPITypeID$smartech_release()
            r2.setApiID(r3)
            java.lang.String r3 = r12.getBaseUrl$smartech_release()
            int r3 = r3.length()
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0023
            r3 = 1
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = "https://cpn.netcoresmartech.com/"
            goto L_0x002d
        L_0x0029:
            java.lang.String r3 = r12.getBaseUrl$smartech_release()
        L_0x002d:
            java.lang.String r6 = r12.getApiEndPoint$smartech_release()
            if (r6 == 0) goto L_0x0042
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r6 = r12.getApiEndPoint$smartech_release()
            r3.append(r6)
            java.lang.String r3 = r3.toString()
        L_0x0042:
            java.net.URL r6 = new java.net.URL
            r6.<init>(r3)
            com.netcore.android.logger.SMTLogger r7 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r8 = "URL:"
            r7.internal(r8, r3)
            r3 = 0
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0170, all -> 0x016e }
            java.lang.Object r6 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r6)     // Catch:{ Exception -> 0x0170, all -> 0x016e }
            java.net.URLConnection r6 = (java.net.URLConnection) r6     // Catch:{ Exception -> 0x0170, all -> 0x016e }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0170, all -> 0x016e }
            if (r6 == 0) goto L_0x0070
            com.netcore.android.network.SMTEnumHttpMethodType r8 = r12.getHttpMethod$smartech_release()     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x0068
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x006d }
            goto L_0x0069
        L_0x0068:
            r8 = r3
        L_0x0069:
            r6.setRequestMethod(r8)     // Catch:{ Exception -> 0x006d }
            goto L_0x0070
        L_0x006d:
            r12 = move-exception
            goto L_0x0172
        L_0x0070:
            r8 = 60000(0xea60, float:8.4078E-41)
            if (r6 == 0) goto L_0x0078
            r6.setConnectTimeout(r8)     // Catch:{ Exception -> 0x006d }
        L_0x0078:
            if (r6 == 0) goto L_0x007d
            r6.setReadTimeout(r8)     // Catch:{ Exception -> 0x006d }
        L_0x007d:
            java.lang.String r8 = "application/json"
            if (r6 == 0) goto L_0x0086
            java.lang.String r9 = "Content-Type"
            r6.setRequestProperty(r9, r8)     // Catch:{ Exception -> 0x006d }
        L_0x0086:
            if (r6 == 0) goto L_0x008d
            java.lang.String r9 = "Accept"
            r6.setRequestProperty(r9, r8)     // Catch:{ Exception -> 0x006d }
        L_0x008d:
            if (r6 == 0) goto L_0x0096
            java.lang.String r8 = "Accept-Encoding"
            java.lang.String r9 = "gzip"
            r6.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x006d }
        L_0x0096:
            com.netcore.android.network.SMTEnumHttpMethodType r8 = r12.getHttpMethod$smartech_release()     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x00a8
            int r8 = r8.getValue()     // Catch:{ Exception -> 0x006d }
            com.netcore.android.network.SMTEnumHttpMethodType r9 = com.netcore.android.network.SMTEnumHttpMethodType.GET     // Catch:{ Exception -> 0x006d }
            int r9 = r9.getValue()     // Catch:{ Exception -> 0x006d }
            if (r8 == r9) goto L_0x00db
        L_0x00a8:
            if (r6 == 0) goto L_0x00ad
            r6.setChunkedStreamingMode(r4)     // Catch:{ Exception -> 0x006d }
        L_0x00ad:
            if (r6 == 0) goto L_0x00b2
            r6.setDoOutput(r5)     // Catch:{ Exception -> 0x006d }
        L_0x00b2:
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x006d }
            if (r6 == 0) goto L_0x00bb
            java.io.OutputStream r9 = r6.getOutputStream()     // Catch:{ Exception -> 0x006d }
            goto L_0x00bc
        L_0x00bb:
            r9 = r3
        L_0x00bc:
            r8.<init>(r9)     // Catch:{ Exception -> 0x006d }
            org.json.JSONObject r12 = r12.getHParams$smartech_release()     // Catch:{ Exception -> 0x006d }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x006d }
            java.nio.charset.Charset r9 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x006d }
            byte[] r12 = r12.getBytes(r9)     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r9)     // Catch:{ Exception -> 0x006d }
            r8.write(r12)     // Catch:{ Exception -> 0x006d }
            r8.flush()     // Catch:{ Exception -> 0x006d }
            r8.close()     // Catch:{ Exception -> 0x006d }
        L_0x00db:
            if (r6 == 0) goto L_0x00e6
            int r12 = r6.getResponseCode()     // Catch:{ Exception -> 0x006d }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x006d }
            goto L_0x00e7
        L_0x00e6:
            r12 = r3
        L_0x00e7:
            r2.setHttpCode(r12)     // Catch:{ Exception -> 0x006d }
            java.lang.Integer r12 = r2.getHttpCode()     // Catch:{ Exception -> 0x006d }
            r8 = 200(0xc8, float:2.8E-43)
            if (r12 != 0) goto L_0x00f4
            goto L_0x016b
        L_0x00f4:
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x006d }
            if (r12 != r8) goto L_0x016b
            java.lang.String r12 = r11.GZIP     // Catch:{ Exception -> 0x006d }
            if (r6 == 0) goto L_0x0103
            java.lang.String r8 = r6.getContentEncoding()     // Catch:{ Exception -> 0x006d }
            goto L_0x0104
        L_0x0103:
            r8 = r3
        L_0x0104:
            boolean r12 = r12.equals(r8)     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "empty"
            java.lang.String r9 = "Response : "
            java.lang.String r10 = "Network"
            if (r12 == 0) goto L_0x013f
            if (r6 == 0) goto L_0x0117
            java.io.InputStream r12 = r6.getInputStream()     // Catch:{ Exception -> 0x006d }
            goto L_0x0118
        L_0x0117:
            r12 = r3
        L_0x0118:
            if (r12 == 0) goto L_0x016b
            java.lang.StringBuilder r12 = r11.readGzipStream(r12)     // Catch:{ Exception -> 0x006d }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x006d }
            r2.setResponse(r12)     // Catch:{ Exception -> 0x006d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006d }
            r12.<init>()     // Catch:{ Exception -> 0x006d }
            r12.append(r9)     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = r2.getResponse()     // Catch:{ Exception -> 0x006d }
            if (r9 == 0) goto L_0x0134
            r8 = r9
        L_0x0134:
            r12.append(r8)     // Catch:{ Exception -> 0x006d }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x006d }
            r7.internal(r10, r12)     // Catch:{ Exception -> 0x006d }
            goto L_0x016b
        L_0x013f:
            if (r6 == 0) goto L_0x0146
            java.io.InputStream r12 = r6.getInputStream()     // Catch:{ Exception -> 0x006d }
            goto L_0x0147
        L_0x0146:
            r12 = r3
        L_0x0147:
            if (r12 == 0) goto L_0x014e
            java.lang.String r12 = readTextAndClose$default(r11, r12, r3, r5, r3)     // Catch:{ Exception -> 0x006d }
            goto L_0x014f
        L_0x014e:
            r12 = r3
        L_0x014f:
            r2.setResponse(r12)     // Catch:{ Exception -> 0x006d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006d }
            r12.<init>()     // Catch:{ Exception -> 0x006d }
            r12.append(r9)     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = r2.getResponse()     // Catch:{ Exception -> 0x006d }
            if (r9 == 0) goto L_0x0161
            r8 = r9
        L_0x0161:
            r12.append(r8)     // Catch:{ Exception -> 0x006d }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x006d }
            r7.internal(r10, r12)     // Catch:{ Exception -> 0x006d }
        L_0x016b:
            if (r6 == 0) goto L_0x01c8
            goto L_0x01c5
        L_0x016e:
            r12 = move-exception
            goto L_0x01cb
        L_0x0170:
            r12 = move-exception
            r6 = r3
        L_0x0172:
            com.netcore.android.logger.SMTLogger r7 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x01c9 }
            java.lang.String r8 = r11.TAG     // Catch:{ all -> 0x01c9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ all -> 0x01c9 }
            java.lang.String r9 = r12.getLocalizedMessage()     // Catch:{ all -> 0x01c9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)     // Catch:{ all -> 0x01c9 }
            r7.e(r8, r9)     // Catch:{ all -> 0x01c9 }
            if (r6 == 0) goto L_0x018a
            java.io.InputStream r7 = r6.getErrorStream()     // Catch:{ all -> 0x01c9 }
            goto L_0x018b
        L_0x018a:
            r7 = r3
        L_0x018b:
            if (r7 == 0) goto L_0x0192
            java.lang.String r7 = readTextAndClose$default(r11, r7, r3, r5, r3)     // Catch:{ all -> 0x01c9 }
            goto L_0x0193
        L_0x0192:
            r7 = r3
        L_0x0193:
            r2.setResponse(r7)     // Catch:{ all -> 0x01c9 }
            if (r6 == 0) goto L_0x01a0
            int r3 = r6.getResponseCode()     // Catch:{ Exception -> 0x01a4 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01a4 }
        L_0x01a0:
            r2.setHttpCode(r3)     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01b6
        L_0x01a4:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r7 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x01c9 }
            java.lang.String r8 = r11.TAG     // Catch:{ all -> 0x01c9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ all -> 0x01c9 }
            java.lang.String r1 = r3.getLocalizedMessage()     // Catch:{ all -> 0x01c9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ all -> 0x01c9 }
            r7.e(r8, r1)     // Catch:{ all -> 0x01c9 }
        L_0x01b6:
            r2.setSuccess(r4)     // Catch:{ all -> 0x01c9 }
            r2.setShouldRetry(r5)     // Catch:{ all -> 0x01c9 }
            java.lang.String r12 = r12.getLocalizedMessage()     // Catch:{ all -> 0x01c9 }
            r2.setErrorMessage(r12)     // Catch:{ all -> 0x01c9 }
            if (r6 == 0) goto L_0x01c8
        L_0x01c5:
            r6.disconnect()
        L_0x01c8:
            return r2
        L_0x01c9:
            r12 = move-exception
            r3 = r6
        L_0x01cb:
            if (r3 == 0) goto L_0x01d0
            r3.disconnect()
        L_0x01d0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.network.SMTHttpRequestClient.makeNetworkCall$smartech_release(com.netcore.android.network.models.SMTRequest):com.netcore.android.network.SMTHttpRequestClient$NetworkResponse");
    }
}
