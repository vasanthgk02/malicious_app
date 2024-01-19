package defpackage;

import android.content.Context;
import defpackage.bd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

/* renamed from: au  reason: default package */
public abstract class au<T extends bd> extends av<T> {
    public au(Context context, ag agVar) {
        super(context, agVar);
    }

    public HttpRequestBase a(String str) {
        return new HttpGet(str);
    }

    public void a() throws UnsupportedEncodingException {
    }

    public void b() throws IOException {
    }
}
