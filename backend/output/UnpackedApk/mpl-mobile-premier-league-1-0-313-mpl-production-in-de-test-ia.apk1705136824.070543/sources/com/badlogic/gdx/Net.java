package com.badlogic.gdx;

import com.badlogic.gdx.utils.Pool.Poolable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public interface Net {

    public static class HttpRequest implements Poolable {
        public String content;
        public InputStream contentStream;
        public boolean followRedirects = true;
        public Map<String, String> headers = new HashMap();
        public String httpMethod;
        public int timeOut = 0;
        public String url;

        public HttpRequest(String str) {
            this.httpMethod = str;
        }

        public void reset() {
            this.httpMethod = null;
            this.url = null;
            this.headers.clear();
            this.timeOut = 0;
            this.content = null;
            this.contentStream = null;
            this.followRedirects = true;
        }
    }

    public interface HttpResponse {
    }

    public interface HttpResponseListener {
        void failed(Throwable th);

        void handleHttpResponse(HttpResponse httpResponse);
    }
}
