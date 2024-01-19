package com.badlogic.gdx.net;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.utils.ObjectMap;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NetJavaImpl {
    public final ObjectMap<HttpRequest, HttpURLConnection> connections = new ObjectMap<>();
    public final ExecutorService executorService;
    public final ObjectMap<HttpRequest, HttpResponseListener> listeners = new ObjectMap<>();

    public static class HttpClientResponse implements HttpResponse {
        public final HttpURLConnection connection;

        public HttpClientResponse(HttpURLConnection httpURLConnection) throws IOException {
            this.connection = httpURLConnection;
            try {
                httpURLConnection.getResponseCode();
            } catch (IOException unused) {
            }
        }
    }

    public NetJavaImpl(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory(this) {
            public AtomicInteger threadID = new AtomicInteger();

            public Thread newThread(Runnable runnable) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("NetThread");
                outline73.append(this.threadID.getAndIncrement());
                Thread thread = new Thread(runnable, outline73.toString());
                thread.setDaemon(true);
                return thread;
            }
        });
        this.executorService = threadPoolExecutor;
    }

    public synchronized void removeFromConnectionsAndListeners(HttpRequest httpRequest) {
        this.connections.remove(httpRequest);
        this.listeners.remove(httpRequest);
    }
}
