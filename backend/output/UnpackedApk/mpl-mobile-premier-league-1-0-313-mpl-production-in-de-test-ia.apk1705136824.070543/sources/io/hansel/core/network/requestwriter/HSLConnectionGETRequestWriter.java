package io.hansel.core.network.requestwriter;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import in.juspay.hypersdk.core.InflateView;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HSLConnectionGETRequestWriter implements HSLConnectionRequestWriter {
    public boolean isAddingToUrl = true;
    public CoreJSONObject jsonParams;
    public Map<String, Object> params;
    public String urlStr;

    public HSLConnectionGETRequestWriter(String str, CoreJSONObject coreJSONObject) {
        this.urlStr = str;
        this.jsonParams = coreJSONObject;
    }

    public HSLConnectionGETRequestWriter(String str, CoreJSONObject coreJSONObject, boolean z) {
        this.urlStr = str;
        this.jsonParams = coreJSONObject;
        this.isAddingToUrl = z;
    }

    public HSLConnectionGETRequestWriter(String str, Map<String, Object> map) {
        this.urlStr = str;
        this.params = map;
    }

    public String getUrl() {
        return this.urlStr;
    }

    public HttpURLConnection write() {
        if (this.isAddingToUrl) {
            ArrayList arrayList = new ArrayList();
            if (this.params != null) {
                ArrayList arrayList2 = new ArrayList(this.params.entrySet());
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    Entry entry = (Entry) arrayList2.get(i);
                    String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                    String encode2 = URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8");
                    arrayList.add(encode + InflateView.SETTER_EQUALS + encode2);
                }
            } else {
                CoreJSONObject coreJSONObject = this.jsonParams;
                if (coreJSONObject != null) {
                    Iterator<String> keys = coreJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String encode3 = URLEncoder.encode(next, "UTF-8");
                        String encode4 = URLEncoder.encode(String.valueOf(this.jsonParams.optString(next)), "UTF-8");
                        arrayList.add(encode3 + InflateView.SETTER_EQUALS + encode4);
                    }
                }
            }
            this.urlStr = GeneratedOutlineSupport.outline63(new StringBuilder(), this.urlStr, ColorPropConverter.PREFIX_ATTR, HSLInternalUtils.implodeArray(arrayList, "&"));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.urlStr).openConnection()));
        if (!this.isAddingToUrl) {
            if (this.params != null) {
                ArrayList arrayList3 = new ArrayList(this.params.entrySet());
                int size2 = arrayList3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Entry entry2 = (Entry) arrayList3.get(i2);
                    httpURLConnection.setRequestProperty(URLEncoder.encode((String) entry2.getKey(), "UTF-8"), URLEncoder.encode(String.valueOf(entry2.getValue()), "UTF-8"));
                }
            } else {
                CoreJSONObject coreJSONObject2 = this.jsonParams;
                if (coreJSONObject2 != null) {
                    Iterator<String> keys2 = coreJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        httpURLConnection.setRequestProperty(URLEncoder.encode(next2, "UTF-8"), URLEncoder.encode(String.valueOf(this.jsonParams.optString(next2)), "UTF-8"));
                    }
                }
            }
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(false);
        return httpURLConnection;
    }
}
