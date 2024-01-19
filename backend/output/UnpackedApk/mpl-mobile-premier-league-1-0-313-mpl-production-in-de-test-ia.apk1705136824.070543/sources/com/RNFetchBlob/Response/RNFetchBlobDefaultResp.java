package com.RNFetchBlob.Response;

import com.RNFetchBlob.RNFetchBlobProgressConfig;
import com.RNFetchBlob.RNFetchBlobReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public class RNFetchBlobDefaultResp extends ResponseBody {
    public boolean isIncrement = false;
    public String mTaskId;
    public ResponseBody originalBody;
    public ReactApplicationContext rctContext;

    public class ProgressReportingSource implements Source {
        public long bytesRead = 0;
        public BufferedSource mOriginalSource;

        public ProgressReportingSource(BufferedSource bufferedSource) {
            this.mOriginalSource = bufferedSource;
        }

        public void close() throws IOException {
        }

        public long read(Buffer buffer, long j) throws IOException {
            long read = this.mOriginalSource.read(buffer, j);
            this.bytesRead += read > 0 ? read : 0;
            RNFetchBlobProgressConfig reportProgress = RNFetchBlobReq.getReportProgress(RNFetchBlobDefaultResp.this.mTaskId);
            long contentLength = RNFetchBlobDefaultResp.this.contentLength();
            if (!(reportProgress == null || contentLength == 0 || !reportProgress.shouldReport((float) (this.bytesRead / RNFetchBlobDefaultResp.this.contentLength())))) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("taskId", RNFetchBlobDefaultResp.this.mTaskId);
                createMap.putString("written", String.valueOf(this.bytesRead));
                createMap.putString(ECommerceParamNames.TOTAL, String.valueOf(RNFetchBlobDefaultResp.this.contentLength()));
                if (RNFetchBlobDefaultResp.this.isIncrement) {
                    createMap.putString("chunk", buffer.readString(Charset.defaultCharset()));
                } else {
                    createMap.putString("chunk", "");
                }
                ((RCTDeviceEventEmitter) RNFetchBlobDefaultResp.this.rctContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobProgress", createMap);
            }
            return read;
        }

        public Timeout timeout() {
            return null;
        }
    }

    public RNFetchBlobDefaultResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, boolean z) {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.isIncrement = z;
    }

    public long contentLength() {
        return this.originalBody.contentLength();
    }

    public MediaType contentType() {
        return this.originalBody.contentType();
    }

    public BufferedSource source() {
        return Okio.buffer((Source) new ProgressReportingSource(this.originalBody.source()));
    }
}
