package io.hansel.core.network.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.mpl.androidapp.config.ConfigConstant;
import com.netcore.android.preference.SMTPreferenceConstants;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.task.a.C0072a;
import io.hansel.core.e.b.a;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.requestwriter.HSLConnectionRequestWriter;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.TimeZone;

public abstract class HSLServerRequest implements C0072a, HSLServerResponseHandler {
    public final Context context;
    public boolean isImage;
    public CoreJSONObject requestParams;
    public int responseCode;
    public HSLSDKIdentifiers sdkIdentifiers;
    public HSLServerResponseHandler serverResponseHandler;

    public HSLServerRequest(Context context2) {
        this.responseCode = 0;
        this.context = context2;
    }

    public HSLServerRequest(Context context2, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler) {
        this.responseCode = 0;
        this.context = context2;
        this.sdkIdentifiers = hSLSDKIdentifiers;
        this.serverResponseHandler = hSLServerResponseHandler;
        this.isImage = false;
    }

    public HSLServerRequest(Context context2, HSLSDKIdentifiers hSLSDKIdentifiers, HSLServerResponseHandler hSLServerResponseHandler, boolean z) {
        this(context2, hSLSDKIdentifiers, hSLServerResponseHandler);
        this.isImage = z;
    }

    private String parseResponse(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r0 == null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendServerImageRequest() {
        /*
            r4 = this;
            r0 = 0
            io.hansel.core.network.requestwriter.HSLConnectionRequestWriter r1 = r4.getConnectionRequestWriter()     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            java.net.HttpURLConnection r0 = r1.write()     // Catch:{ all -> 0x0027 }
            int r1 = r0.getResponseCode()     // Catch:{ all -> 0x0027 }
            r4.responseCode = r1     // Catch:{ all -> 0x0027 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x001b
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ all -> 0x0027 }
            goto L_0x001f
        L_0x001b:
            java.io.InputStream r1 = r0.getErrorStream()     // Catch:{ all -> 0x0027 }
        L_0x001f:
            int r3 = r4.responseCode     // Catch:{ all -> 0x0027 }
            if (r3 != r2) goto L_0x0031
            r4.parseResponse(r4, r1, r3)     // Catch:{ all -> 0x0027 }
            goto L_0x0031
        L_0x0027:
            r1 = move-exception
            java.lang.String r2 = "Server response error"
            io.hansel.core.logger.LogGroup r3 = io.hansel.core.logger.LogGroup.AI     // Catch:{ all -> 0x0035 }
            io.hansel.core.logger.HSLLogger.printStackTrace(r1, r2, r3)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0034
        L_0x0031:
            r0.disconnect()
        L_0x0034:
            return
        L_0x0035:
            r1 = move-exception
            if (r0 == 0) goto L_0x003b
            r0.disconnect()
        L_0x003b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.request.HSLServerRequest.sendServerImageRequest():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String sendServerRequest() {
        /*
            r6 = this;
            r0 = 0
            io.hansel.core.network.requestwriter.HSLConnectionRequestWriter r1 = r6.getConnectionRequestWriter()     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.net.HttpURLConnection r1 = r1.write()     // Catch:{ all -> 0x0034 }
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0032 }
            r6.responseCode = r2     // Catch:{ all -> 0x0032 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x001b
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ all -> 0x0032 }
            goto L_0x001f
        L_0x001b:
            java.io.InputStream r2 = r1.getErrorStream()     // Catch:{ all -> 0x0032 }
        L_0x001f:
            int r4 = r6.responseCode     // Catch:{ all -> 0x0032 }
            if (r4 != r3) goto L_0x002b
            java.lang.String r0 = r6.parseResponse(r2)     // Catch:{ all -> 0x0032 }
            r1.disconnect()
            return r0
        L_0x002b:
            r2.close()     // Catch:{ all -> 0x0032 }
            r1.disconnect()
            return r0
        L_0x0032:
            r0 = move-exception
            goto L_0x0038
        L_0x0034:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0038:
            java.lang.String r2 = "Server response error"
            io.hansel.core.logger.LogGroup r3 = io.hansel.core.logger.LogGroup.AI     // Catch:{ all -> 0x0049 }
            io.hansel.core.logger.HSLLogger.printStackTrace(r0, r2, r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            r1.disconnect()
        L_0x0048:
            return r0
        L_0x0049:
            r0 = move-exception
            if (r1 == 0) goto L_0x004f
            r1.disconnect()
        L_0x004f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.network.request.HSLServerRequest.sendServerRequest():java.lang.String");
    }

    public CoreJSONObject addDefaultRequestParams() {
        if (this.requestParams == null) {
            this.requestParams = new CoreJSONObject();
        }
        addRequestParam("app_id", this.sdkIdentifiers.getAppId());
        addRequestParam("app_version", this.sdkIdentifiers.getAppVersion().versionName);
        addRequestParam("app_build_number", String.valueOf(this.sdkIdentifiers.getAppVersion().versionCode));
        addRequestParam(ConfigConstant.DEVICE_ID, this.sdkIdentifiers.getDeviceId());
        addRequestParam(SMTPreferenceConstants.SMT_SDK_VERSION, HSLBuildConfig.SDK_VERSION);
        addRequestParam("os", "android");
        addRequestParam("os_version", VERSION.RELEASE);
        addRequestParam("device", Build.MODEL);
        addRequestParam("manufacturer", Build.MANUFACTURER);
        addRequestParam("tz_offset", Integer.valueOf(TimeZone.getDefault().getRawOffset()));
        addRequestParam("time", String.valueOf(System.currentTimeMillis()));
        return this.requestParams;
    }

    public void addRequestParam(String str, Object obj) {
        try {
            getRequestParams().put(str, obj);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public void addRequestParams(CoreJSONObject coreJSONObject) {
        try {
            CoreJSONObject requestParams2 = getRequestParams();
            Iterator<String> keys = coreJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                requestParams2.put(next, coreJSONObject.get(next));
            }
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public boolean executerShouldPause() {
        if (this.responseCode != 200) {
            return !a.c(this.context);
        }
        return false;
    }

    public abstract HSLConnectionRequestWriter getConnectionRequestWriter();

    public CoreJSONObject getFinalRequestParams(boolean z) {
        if (z) {
            addDefaultRequestParams();
        }
        return getRequestParams();
    }

    public CoreJSONObject getRequestParams() {
        if (this.requestParams == null) {
            this.requestParams = new CoreJSONObject();
        }
        return this.requestParams;
    }

    public HSLSDKIdentifiers getSdkIdentifiers() {
        return this.sdkIdentifiers;
    }

    public String getTestResponse(Context context2, int i) {
        InputStream openRawResource = context2.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = openRawResource.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    openRawResource.close();
                    return byteArrayOutputStream.toString();
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
                return null;
            }
        }
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
        HSLServerResponseHandler hSLServerResponseHandler = this.serverResponseHandler;
        if (hSLServerResponseHandler != null) {
            try {
                hSLServerResponseHandler.parseResponse(hSLServerRequest, inputStream, i);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
        HSLServerResponseHandler hSLServerResponseHandler = this.serverResponseHandler;
        if (hSLServerResponseHandler != null) {
            try {
                hSLServerResponseHandler.parseResponse(hSLServerRequest, str, i);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public void run() {
        try {
            if (this.isImage) {
                sendServerImageRequest();
                return;
            }
            String sendServerRequest = sendServerRequest();
            if (sendServerRequest != null) {
                int i = this.responseCode;
                if (i == 200) {
                    parseResponse(this, sendServerRequest, i);
                }
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }
}
