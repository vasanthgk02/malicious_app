package com.RNFetchBlob;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

public class RNFetchBlobConfig {
    public ReadableMap addAndroidDownloads;
    public String appendExt;
    public Boolean auto;
    public ReadableArray binaryContentTypes;
    public Boolean fileCache;
    public Boolean followRedirect = Boolean.TRUE;
    public Boolean increment = Boolean.FALSE;
    public String key;
    public Boolean overwrite = Boolean.TRUE;
    public String path;
    public long timeout = 60000;
    public Boolean trusty;
    public Boolean wifiOnly = Boolean.FALSE;

    public RNFetchBlobConfig(ReadableMap readableMap) {
        String str = null;
        this.binaryContentTypes = null;
        if (readableMap != null) {
            boolean z = false;
            this.fileCache = Boolean.valueOf(readableMap.hasKey("fileCache") ? readableMap.getBoolean("fileCache") : false);
            this.path = readableMap.hasKey("path") ? readableMap.getString("path") : null;
            this.appendExt = readableMap.hasKey("appendExt") ? readableMap.getString("appendExt") : "";
            this.trusty = Boolean.valueOf(readableMap.hasKey("trusty") ? readableMap.getBoolean("trusty") : false);
            this.wifiOnly = Boolean.valueOf(readableMap.hasKey("wifiOnly") ? readableMap.getBoolean("wifiOnly") : false);
            if (readableMap.hasKey("addAndroidDownloads")) {
                this.addAndroidDownloads = readableMap.getMap("addAndroidDownloads");
            }
            if (readableMap.hasKey("binaryContentTypes")) {
                this.binaryContentTypes = readableMap.getArray("binaryContentTypes");
            }
            String str2 = this.path;
            if (str2 != null && str2.toLowerCase().contains("?append=true")) {
                this.overwrite = Boolean.FALSE;
            }
            if (readableMap.hasKey("overwrite")) {
                this.overwrite = Boolean.valueOf(readableMap.getBoolean("overwrite"));
            }
            if (readableMap.hasKey("followRedirect")) {
                this.followRedirect = Boolean.valueOf(readableMap.getBoolean("followRedirect"));
            }
            this.key = readableMap.hasKey("key") ? readableMap.getString("key") : str;
            if (readableMap.hasKey("contentType")) {
                readableMap.getString("contentType");
            }
            this.increment = Boolean.valueOf(readableMap.hasKey("increment") ? readableMap.getBoolean("increment") : false);
            this.auto = Boolean.valueOf(readableMap.hasKey("auto") ? readableMap.getBoolean("auto") : z);
            if (readableMap.hasKey(Values.TIMEOUT)) {
                this.timeout = (long) readableMap.getInt(Values.TIMEOUT);
            }
        }
    }
}
