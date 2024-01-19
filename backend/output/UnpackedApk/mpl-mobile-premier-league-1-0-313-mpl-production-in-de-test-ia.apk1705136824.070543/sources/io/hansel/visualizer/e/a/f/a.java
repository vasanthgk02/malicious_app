package io.hansel.visualizer.e.a.f;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import io.hansel.core.logger.HSLLogger;
import io.hansel.visualizer.e.a.d;
import io.hansel.visualizer.e.a.k.f;
import io.hansel.visualizer.e.a.k.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

public abstract class a extends io.hansel.visualizer.e.a.a implements Runnable, io.hansel.visualizer.e.a.b {
    public static final /* synthetic */ boolean q = (!a.class.desiredAssertionStatus());

    /* renamed from: f  reason: collision with root package name */
    public URI f5869f;
    public d g;
    public Socket h;
    public InputStream i;
    public OutputStream j;
    public Proxy k;
    public Thread l;
    public Map<String, String> m;
    public CountDownLatch n;
    public CountDownLatch o;
    public int p;

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                Thread.currentThread().setName("WebsocketWriteThread");
                while (!Thread.interrupted()) {
                    ByteBuffer take = a.this.g.f5863a.take();
                    a.this.j.write(take.array(), 0, take.limit());
                    a.this.j.flush();
                }
            } catch (IOException e2) {
                a.this.a(e2);
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public a(URI uri) {
        this(uri, new io.hansel.visualizer.e.a.g.b());
    }

    public a(URI uri, io.hansel.visualizer.e.a.g.a aVar) {
        this(uri, aVar, null, 0);
    }

    public a(URI uri, io.hansel.visualizer.e.a.g.a aVar, Map<String, String> map, int i2) {
        this.f5869f = null;
        this.g = null;
        this.h = null;
        this.k = Proxy.NO_PROXY;
        this.n = new CountDownLatch(1);
        this.o = new CountDownLatch(1);
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar != null) {
            this.f5869f = uri;
            this.m = map;
            this.p = i2;
            b(false);
            a(false);
            this.g = new d(this, aVar);
        } else {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
    }

    /* access modifiers changed from: private */
    public void a(IOException iOException) {
        if (iOException instanceof SSLException) {
            a((Exception) iOException);
        }
        this.g.b();
    }

    private int j() {
        int port = this.f5869f.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.f5869f.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException(GeneratedOutlineSupport.outline50("unknown scheme: ", scheme));
    }

    private void n() {
        String rawPath = this.f5869f.getRawPath();
        String rawQuery = this.f5869f.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = GeneratedOutlineSupport.outline52(rawPath, ColorPropConverter.PREFIX_ATTR, rawQuery);
        }
        int j2 = j();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5869f.getHost());
        sb.append(j2 != 80 ? GeneratedOutlineSupport.outline41(":", j2) : "");
        String sb2 = sb.toString();
        io.hansel.visualizer.e.a.k.d dVar = new io.hansel.visualizer.e.a.k.d();
        dVar.b(rawPath);
        dVar.a("Host", sb2);
        Map<String, String> map = this.m;
        if (map != null) {
            for (Entry next : map.entrySet()) {
                dVar.a((String) next.getKey(), (String) next.getValue());
            }
        }
        this.g.a((io.hansel.visualizer.e.a.k.b) dVar);
    }

    public InetSocketAddress a() {
        return this.g.a();
    }

    public void a(int i2, String str) {
    }

    public abstract void a(int i2, String str, boolean z);

    public void a(io.hansel.visualizer.e.a.b bVar, int i2, String str) {
        a(i2, str);
    }

    public final void a(io.hansel.visualizer.e.a.b bVar, int i2, String str, boolean z) {
        g();
        Thread thread = this.l;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.h;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e2) {
            a((io.hansel.visualizer.e.a.b) this, (Exception) e2);
        }
        a(i2, str, z);
        this.n.countDown();
        this.o.countDown();
    }

    public final void a(io.hansel.visualizer.e.a.b bVar, f fVar) {
        f();
        a((h) fVar);
        this.n.countDown();
    }

    public final void a(io.hansel.visualizer.e.a.b bVar, Exception exc) {
        a(exc);
    }

    public final void a(io.hansel.visualizer.e.a.b bVar, String str) {
        a(str);
    }

    public final void a(io.hansel.visualizer.e.a.b bVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    public void a(io.hansel.visualizer.e.a.j.f fVar) {
        this.g.a(fVar);
    }

    public abstract void a(h hVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
    }

    public InetSocketAddress b(io.hansel.visualizer.e.a.b bVar) {
        Socket socket = this.h;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public void b(int i2, String str, boolean z) {
    }

    public void b(io.hansel.visualizer.e.a.b bVar, int i2, String str, boolean z) {
        b(i2, str, z);
    }

    public void b(io.hansel.visualizer.e.a.b bVar, io.hansel.visualizer.e.a.j.f fVar) {
        b(fVar);
    }

    public void b(io.hansel.visualizer.e.a.j.f fVar) {
    }

    public void b(String str) {
        this.g.a(str);
    }

    public Collection<io.hansel.visualizer.e.a.b> c() {
        return Collections.singletonList(this.g);
    }

    public final void c(io.hansel.visualizer.e.a.b bVar) {
    }

    public void h() {
        if (this.l != null) {
            this.g.a(1000);
        }
    }

    public void i() {
        if (this.l == null) {
            Thread thread = new Thread(this);
            this.l = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean k() {
        return this.g.f();
    }

    public boolean l() {
        return this.g.g();
    }

    public boolean m() {
        return this.g.i();
    }

    public void run() {
        boolean z;
        try {
            Socket socket = this.h;
            if (socket == null) {
                this.h = new Socket(this.k);
                z = true;
            } else if (!socket.isClosed()) {
                z = false;
            } else {
                throw new IOException();
            }
            this.h.setTcpNoDelay(e());
            this.h.setReuseAddress(d());
            if (!this.h.isBound()) {
                this.h.connect(new InetSocketAddress(this.f5869f.getHost(), j()), this.p);
            }
            if (z && this.f5869f.getScheme().equals("wss")) {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                instance.init(null, null, null);
                this.h = instance.getSocketFactory().createSocket(this.h, this.f5869f.getHost(), j(), true);
            }
            this.i = this.h.getInputStream();
            this.j = this.h.getOutputStream();
            n();
            try {
                Thread thread = new Thread(new b());
                this.l = thread;
                thread.start();
                byte[] bArr = new byte[d.s];
                while (!l() && !k()) {
                    int read = this.i.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    this.g.a(ByteBuffer.wrap(bArr, 0, read));
                }
                this.g.b();
            } catch (IOException e2) {
                a(e2);
            } catch (RuntimeException e3) {
                a((Exception) e3);
                this.g.b(1006, e3.getMessage());
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
            if (!q) {
                if (!this.h.isClosed()) {
                    throw new AssertionError();
                }
            }
        } catch (Exception e4) {
            a((io.hansel.visualizer.e.a.b) this.g, e4);
            this.g.b(-1, e4.getMessage());
        }
    }
}
