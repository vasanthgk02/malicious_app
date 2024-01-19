package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo.ClientType;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo.NetworkType;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal.Builder;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse.Status;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder.AnonymousClass1;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final DataEncoder dataEncoder;
    public final URL endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
    public final int readTimeout;
    public final Clock uptimeClock;
    public final Clock wallTimeClock;

    public static final class HttpRequest {
        public final String apiKey;
        public final BatchedLogRequest requestBody;
        public final URL url;

        public HttpRequest(URL url2, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url2;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }
    }

    public static final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        ((AutoBatchedLogRequestEncoder) AutoBatchedLogRequestEncoder.CONFIG).configure(jsonDataEncoderBuilder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        this.dataEncoder = new DataEncoder() {
            public void encode(Object obj, Writer writer) throws IOException {
                JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                jsonValueObjectEncoderContext.add(obj, false);
                jsonValueObjectEncoderContext.maybeUnNest();
                jsonValueObjectEncoderContext.jsonWriter.flush();
            }

            public String encode(Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = 40000;
    }

    public static HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.redirectUrl;
        if (url == null) {
            return null;
        }
        ImageOriginUtils.d("CctTransportBackend", "Following redirect to: %s", url);
        return new HttpRequest(httpResponse.redirectUrl, httpRequest.requestBody, httpRequest.apiKey);
    }

    public static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid url: ", str), e2);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        Builder builder = eventInternal.toBuilder();
        builder.getAutoMetadata().put("sdk-version", String.valueOf(VERSION.SDK_INT));
        builder.getAutoMetadata().put("model", Build.MODEL);
        builder.getAutoMetadata().put("hardware", Build.HARDWARE);
        builder.getAutoMetadata().put("device", Build.DEVICE);
        builder.getAutoMetadata().put("product", Build.PRODUCT);
        builder.getAutoMetadata().put("os-uild", Build.ID);
        builder.getAutoMetadata().put("manufacturer", Build.MANUFACTURER);
        builder.getAutoMetadata().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        builder.getAutoMetadata().put("tz-offset", String.valueOf((long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000)));
        if (activeNetworkInfo == null) {
            i = NetworkType.NONE.getValue();
        } else {
            i = activeNetworkInfo.getType();
        }
        builder.getAutoMetadata().put("net-type", String.valueOf(i));
        int i3 = -1;
        if (activeNetworkInfo == null) {
            i2 = MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == i3) {
                i2 = MobileSubtype.COMBINED.getValue();
            } else if (MobileSubtype.forNumber(i2) == null) {
                i2 = 0;
            }
        }
        builder.getAutoMetadata().put("mobile-subtype", String.valueOf(i2));
        builder.getAutoMetadata().put("country", Locale.getDefault().getCountry());
        builder.getAutoMetadata().put("locale", Locale.getDefault().getLanguage());
        builder.getAutoMetadata().put("mcc_mnc", ((TelephonyManager) this.applicationContext.getSystemService("phone")).getSimOperator());
        Context context = this.applicationContext;
        try {
            i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException unused) {
            ImageOriginUtils.getTag("CctTransportBackend");
        }
        builder.getAutoMetadata().put("application_build", Integer.toString(i3));
        return builder.build();
    }

    public final HttpResponse doSend(HttpRequest httpRequest) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        InputStream gZIPInputStream;
        ImageOriginUtils.d("CctTransportBackend", "Making request to: %s", httpRequest.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.2"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = httpRequest.apiKey;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                ((AnonymousClass1) this.dataEncoder).encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                ImageOriginUtils.getTag("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Type");
                ImageOriginUtils.getTag("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Encoding");
                ImageOriginUtils.getTag("CctTransportBackend");
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField(Names.LOCATION)), 0);
                }
                if (responseCode != 200) {
                    return new HttpResponse(responseCode, null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                    HttpResponse httpResponse = new HttpResponse(responseCode, null, ((AutoValue_LogResponse) LogResponse.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream)))).nextRequestWaitMillis);
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return httpResponse;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
                throw th;
                throw th;
            } catch (Throwable th3) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th3;
            }
        } catch (ConnectException | UnknownHostException unused) {
            ImageOriginUtils.getTag("CctTransportBackend");
            return new HttpResponse(500, null, 0);
        } catch (EncodingException | IOException unused2) {
            ImageOriginUtils.getTag("CctTransportBackend");
            return new HttpResponse(400, null, 0);
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
    }

    public BackendResponse send(BackendRequest backendRequest) {
        HttpResponse doSend;
        String str;
        Integer num;
        AutoValue_LogEvent.Builder builder;
        long j;
        CctTransportBackend cctTransportBackend = this;
        HashMap hashMap = new HashMap();
        AutoValue_BackendRequest autoValue_BackendRequest = (AutoValue_BackendRequest) backendRequest;
        for (EventInternal next : autoValue_BackendRequest.events) {
            String str2 = ((AutoValue_EventInternal) next).transportName;
            if (!hashMap.containsKey(str2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(str2, arrayList);
            } else {
                ((List) hashMap.get(str2)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            String str3 = null;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
                QosTier qosTier = QosTier.DEFAULT;
                Long valueOf = Long.valueOf(cctTransportBackend.wallTimeClock.getTime());
                Long valueOf2 = Long.valueOf(cctTransportBackend.uptimeClock.getTime());
                ClientType clientType = ClientType.ANDROID_FIREBASE;
                AutoValue_AndroidClientInfo autoValue_AndroidClientInfo = new AutoValue_AndroidClientInfo(Integer.valueOf(eventInternal.getInteger("sdk-version")), eventInternal.get("model"), eventInternal.get("hardware"), eventInternal.get("device"), eventInternal.get("product"), eventInternal.get("os-uild"), eventInternal.get("manufacturer"), eventInternal.get("fingerprint"), eventInternal.get("locale"), eventInternal.get("country"), eventInternal.get("mcc_mnc"), eventInternal.get("application_build"), null);
                AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(clientType, autoValue_AndroidClientInfo, null);
                try {
                    str = null;
                    num = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    num = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    EventInternal eventInternal2 = (EventInternal) it2.next();
                    AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) eventInternal2;
                    Iterator it3 = it;
                    EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                    Iterator it4 = it2;
                    Encoding encoding = encodedPayload.encoding;
                    String str4 = "";
                    AutoValue_BackendRequest autoValue_BackendRequest2 = autoValue_BackendRequest;
                    if (encoding.equals(new Encoding("proto"))) {
                        byte[] bArr = encodedPayload.bytes;
                        builder = new AutoValue_LogEvent.Builder();
                        builder.sourceExtension = bArr;
                    } else if (encoding.equals(new Encoding("json"))) {
                        String str5 = new String(encodedPayload.bytes, Charset.forName("UTF-8"));
                        AutoValue_LogEvent.Builder builder2 = new AutoValue_LogEvent.Builder();
                        builder2.sourceExtensionJsonProto3 = str5;
                        builder = builder2;
                    } else {
                        ImageOriginUtils.getTag("CctTransportBackend");
                        String.format("Received event of unsupported encoding %s. Skipping...", new Object[]{encoding});
                        it2 = it4;
                        it = it3;
                        autoValue_BackendRequest = autoValue_BackendRequest2;
                    }
                    builder.eventTimeMs = Long.valueOf(autoValue_EventInternal.eventMillis);
                    builder.eventUptimeMs = Long.valueOf(autoValue_EventInternal.uptimeMillis);
                    String str6 = autoValue_EventInternal.autoMetadata.get("tz-offset");
                    if (str6 == null) {
                        j = 0;
                    } else {
                        j = Long.valueOf(str6).longValue();
                    }
                    builder.timezoneOffsetSeconds = Long.valueOf(j);
                    builder.networkConnectionInfo = new AutoValue_NetworkConnectionInfo(NetworkType.forNumber(eventInternal2.getInteger("net-type")), MobileSubtype.forNumber(eventInternal2.getInteger("mobile-subtype")), null);
                    Integer num2 = autoValue_EventInternal.code;
                    if (num2 != null) {
                        builder.eventCode = num2;
                    }
                    String str7 = builder.eventTimeMs == null ? " eventTimeMs" : str4;
                    if (builder.eventUptimeMs == null) {
                        str7 = GeneratedOutlineSupport.outline50(str7, " eventUptimeMs");
                    }
                    if (builder.timezoneOffsetSeconds == null) {
                        str7 = GeneratedOutlineSupport.outline50(str7, " timezoneOffsetSeconds");
                    }
                    if (str7.isEmpty()) {
                        AutoValue_LogEvent autoValue_LogEvent = new AutoValue_LogEvent(builder.eventTimeMs.longValue(), builder.eventCode, builder.eventUptimeMs.longValue(), builder.sourceExtension, builder.sourceExtensionJsonProto3, builder.timezoneOffsetSeconds.longValue(), builder.networkConnectionInfo, null);
                        arrayList3.add(autoValue_LogEvent);
                        it2 = it4;
                        it = it3;
                        autoValue_BackendRequest = autoValue_BackendRequest2;
                    } else {
                        throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str7));
                    }
                }
                Iterator it5 = it;
                AutoValue_BackendRequest autoValue_BackendRequest3 = autoValue_BackendRequest;
                String str8 = valueOf == null ? " requestTimeMs" : "";
                if (valueOf2 == null) {
                    str8 = GeneratedOutlineSupport.outline50(str8, " requestUptimeMs");
                }
                if (str8.isEmpty()) {
                    AutoValue_LogRequest autoValue_LogRequest = new AutoValue_LogRequest(valueOf.longValue(), valueOf2.longValue(), autoValue_ClientInfo, num, str, arrayList3, qosTier, null);
                    arrayList2.add(autoValue_LogRequest);
                    cctTransportBackend = this;
                    it = it5;
                    autoValue_BackendRequest = autoValue_BackendRequest3;
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str8));
                }
            } else {
                AutoValue_BackendRequest autoValue_BackendRequest4 = autoValue_BackendRequest;
                AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList2);
                URL url = this.endPoint;
                if (autoValue_BackendRequest4.extras != null) {
                    try {
                        CCTDestination fromByteArray = CCTDestination.fromByteArray(((AutoValue_BackendRequest) backendRequest).extras);
                        if (fromByteArray.apiKey != null) {
                            str3 = fromByteArray.apiKey;
                        }
                        if (fromByteArray.endPoint != null) {
                            url = parseUrlOrThrow(fromByteArray.endPoint);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return BackendResponse.fatalError();
                    }
                }
                int i = 5;
                try {
                    HttpRequest httpRequest = new HttpRequest(url, autoValue_BatchedLogRequest, str3);
                    do {
                        doSend = doSend(httpRequest);
                        httpRequest = lambda$send$0(httpRequest, doSend);
                        if (httpRequest == null) {
                            break;
                        }
                        i--;
                    } while (i >= 1);
                    if (doSend.code == 200) {
                        return new AutoValue_BackendResponse(Status.OK, doSend.nextRequestMillis);
                    }
                    if (doSend.code < 500) {
                        if (doSend.code != 404) {
                            if (doSend.code == 400) {
                                return new AutoValue_BackendResponse(Status.INVALID_PAYLOAD, -1);
                            }
                            return BackendResponse.fatalError();
                        }
                    }
                    return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1);
                } catch (IOException unused3) {
                    ImageOriginUtils.getTag("CctTransportBackend");
                    return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1);
                }
            }
        }
    }
}
