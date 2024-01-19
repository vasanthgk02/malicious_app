package com.shield.android.e;

import com.shield.android.internal.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public abstract class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final HttpURLConnection f1563a;

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f1564b;

    /* renamed from: c  reason: collision with root package name */
    public final OutputStream f1565c;

    public b(HttpURLConnection httpURLConnection, InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            f.a().b(httpURLConnection.getContent().toString(), new Object[0]);
            f.a().b(httpURLConnection.getURL().toString(), new Object[0]);
        } catch (Exception unused) {
        }
        if (httpURLConnection != null) {
            this.f1563a = httpURLConnection;
            this.f1564b = inputStream;
            this.f1565c = outputStream;
            return;
        }
        throw new IllegalArgumentException("connection == null");
    }

    public abstract void close() throws IOException;
}
