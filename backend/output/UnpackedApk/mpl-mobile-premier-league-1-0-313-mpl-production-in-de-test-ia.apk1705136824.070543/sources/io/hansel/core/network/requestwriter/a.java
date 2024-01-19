package io.hansel.core.network.requestwriter;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.security.d;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class a implements HSLConnectionRequestWriter {
    public byte[] paramBytes;
    public String secret;
    public String urlStr;

    public a(String str, String str2, byte[] bArr) {
        this.urlStr = str2;
        this.paramBytes = bArr;
        this.secret = str;
    }

    private boolean urlContainsQueryParams(String str) {
        return str.contains(ColorPropConverter.PREFIX_ATTR);
    }

    public String getContentType() {
        throw null;
    }

    public HashMap<String, String> getHeaders() {
        throw null;
    }

    public String getUrl() {
        return this.urlStr;
    }

    public HttpURLConnection write() {
        String str;
        try {
            str = d.b(this.secret, this.paramBytes);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            str = null;
        }
        String str2 = this.urlStr;
        if (str != null) {
            str2 = GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(str2), urlContainsQueryParams(str2) ? "&q=" : "?q=", str);
        }
        int length = this.paramBytes.length;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2).openConnection()));
        httpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
        httpURLConnection.setRequestProperty("Content-Type", getContentType());
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
        HashMap<String, String> headers = getHeaders();
        ArrayList arrayList = new ArrayList(headers.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str3 = (String) arrayList.get(i);
            httpURLConnection.setRequestProperty(str3, headers.get(str3));
        }
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(this.paramBytes);
        outputStream.close();
        return httpURLConnection;
    }
}
