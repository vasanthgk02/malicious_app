package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody {
    public BufferedSource mBufferedSource;
    public final ProgressListener mProgressListener;
    public final ResponseBody mResponseBody;
    public long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer((Source) new ForwardingSource(this.mResponseBody.source()) {
                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                    ProgressResponseBody.this.mTotalBytesRead += i != 0 ? read : 0;
                    ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                    progressResponseBody.mProgressListener.onProgress(progressResponseBody.mTotalBytesRead, progressResponseBody.mResponseBody.contentLength(), i == 0);
                    return read;
                }
            });
        }
        return this.mBufferedSource;
    }
}
