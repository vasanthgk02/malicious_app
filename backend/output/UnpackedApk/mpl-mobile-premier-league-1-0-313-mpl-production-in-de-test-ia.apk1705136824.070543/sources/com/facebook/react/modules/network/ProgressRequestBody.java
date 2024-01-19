package com.facebook.react.modules.network;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

public class ProgressRequestBody extends RequestBody {
    public long mContentLength = 0;
    public final ProgressListener mProgressListener;
    public final RequestBody mRequestBody;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.mRequestBody = requestBody;
        this.mProgressListener = progressListener;
    }

    public long contentLength() throws IOException {
        if (this.mContentLength == 0) {
            this.mContentLength = this.mRequestBody.contentLength();
        }
        return this.mContentLength;
    }

    public MediaType contentType() {
        return this.mRequestBody.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(Okio.sink((OutputStream) new CountingOutputStream(bufferedSink.outputStream()) {
            public final void sendProgressUpdate() throws IOException {
                long j = this.mCount;
                long contentLength = ProgressRequestBody.this.contentLength();
                ProgressRequestBody.this.mProgressListener.onProgress(j, contentLength, j == contentLength);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                this.out.write(bArr, i, i2);
                this.mCount += (long) i2;
                sendProgressUpdate();
            }

            public void write(int i) throws IOException {
                this.out.write(i);
                this.mCount++;
                sendProgressUpdate();
            }
        }));
        contentLength();
        this.mRequestBody.writeTo(buffer);
        buffer.flush();
    }
}
