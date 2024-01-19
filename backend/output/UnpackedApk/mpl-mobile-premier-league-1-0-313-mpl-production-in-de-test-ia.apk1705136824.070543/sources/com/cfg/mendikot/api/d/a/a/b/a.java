package com.cfg.mendikot.api.d.a.a.b;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.api.d.a.a.a.b.g;
import com.cfg.mendikot.api.d.a.a.a.b.p;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2319a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final URI f2320b;

    /* renamed from: c  reason: collision with root package name */
    public final SecureRandom f2321c;

    /* renamed from: d  reason: collision with root package name */
    public int f2322d;

    /* renamed from: e  reason: collision with root package name */
    public int f2323e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2324f;
    public long g;
    public volatile boolean h;
    public Map<String, String> i;
    public volatile f j;
    public volatile Thread k;
    public SSLSocketFactory l = ((SSLSocketFactory) SSLSocketFactory.getDefault());

    /* renamed from: com.cfg.mendikot.api.d.a.a.b.a$a  reason: collision with other inner class name */
    public class C0034a implements Runnable {
        public C0034a() {
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                com.cfg.mendikot.api.d.a.a.b.a r0 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ Exception -> 0x0012 }
                com.cfg.mendikot.api.d.a.a.b.a$f r0 = r0.j     // Catch:{ Exception -> 0x0012 }
                boolean r0 = com.cfg.mendikot.api.d.a.a.b.a.f.e(r0)     // Catch:{ Exception -> 0x0012 }
                if (r0 == 0) goto L_0x004d
                com.cfg.mendikot.api.d.a.a.b.a r0 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ Exception -> 0x0012 }
                com.cfg.mendikot.api.d.a.a.b.a$f r0 = r0.j     // Catch:{ Exception -> 0x0012 }
                com.cfg.mendikot.api.d.a.a.b.a.f.f(r0)     // Catch:{ Exception -> 0x0012 }
                goto L_0x004d
            L_0x0012:
                r0 = move-exception
                com.cfg.mendikot.api.d.a.a.b.a r1 = com.cfg.mendikot.api.d.a.a.b.a.this
                java.lang.Object r1 = r1.f2319a
                monitor-enter(r1)
                com.cfg.mendikot.api.d.a.a.b.a r2 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ all -> 0x004e }
                boolean r2 = r2.h     // Catch:{ all -> 0x004e }
                if (r2 == 0) goto L_0x004c
                com.cfg.mendikot.api.d.a.a.b.a r2 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ all -> 0x004e }
                com.cfg.mendikot.api.d.a.a.b.a$f r2 = r2.j     // Catch:{ all -> 0x004e }
                r2.a()     // Catch:{ all -> 0x004e }
                com.cfg.mendikot.api.d.a.a.b.a r2 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ all -> 0x004e }
                r2.a(r0)     // Catch:{ all -> 0x004e }
                boolean r0 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x004e }
                if (r0 == 0) goto L_0x004c
                com.cfg.mendikot.api.d.a.a.b.a r0 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ all -> 0x004e }
                boolean r0 = r0.f2324f     // Catch:{ all -> 0x004e }
                if (r0 == 0) goto L_0x004c
                com.cfg.mendikot.api.d.a.a.b.a r0 = com.cfg.mendikot.api.d.a.a.b.a.this     // Catch:{ all -> 0x004e }
                if (r0 == 0) goto L_0x004a
                java.lang.Thread r2 = new java.lang.Thread     // Catch:{ all -> 0x004e }
                com.cfg.mendikot.api.d.a.a.b.a$b r3 = new com.cfg.mendikot.api.d.a.a.b.a$b     // Catch:{ all -> 0x004e }
                r3.<init>()     // Catch:{ all -> 0x004e }
                r2.<init>(r3)     // Catch:{ all -> 0x004e }
                r0.k = r2     // Catch:{ all -> 0x004e }
                java.lang.Thread r0 = r0.k     // Catch:{ all -> 0x004e }
                r0.start()     // Catch:{ all -> 0x004e }
                goto L_0x004c
            L_0x004a:
                r0 = 0
                throw r0     // Catch:{ all -> 0x004e }
            L_0x004c:
                monitor-exit(r1)     // Catch:{ all -> 0x004e }
            L_0x004d:
                return
            L_0x004e:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.b.a.C0034a.run():void");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                Thread.sleep(a.this.g);
                synchronized (a.this.f2319a) {
                    if (a.this.h) {
                        a.this.j = new f(null);
                        a aVar = a.this;
                        if (aVar != null) {
                            new Thread(new C0034a()).start();
                        } else {
                            throw null;
                        }
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.cfg.mendikot.api.d.a.a.b.d.a f2327a;

        public c(com.cfg.mendikot.api.d.a.a.b.d.a aVar) {
            this.f2327a = aVar;
        }

        public void run() {
            f.a(a.this.j, this.f2327a);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.cfg.mendikot.api.d.a.a.b.d.a f2329a;

        public d(com.cfg.mendikot.api.d.a.a.b.d.a aVar) {
            this.f2329a = aVar;
        }

        public void run() {
            f.a(a.this.j, this.f2329a);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            synchronized (a.this.f2319a) {
                a.this.h = false;
                if (a.this.k != null) {
                    a.this.k.interrupt();
                }
                a.this.j.a();
            }
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f2332a = false;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f2333b = false;

        /* renamed from: c  reason: collision with root package name */
        public final LinkedList<com.cfg.mendikot.api.d.a.a.b.d.a> f2334c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        public final Object f2335d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public final Thread f2336e = new Thread(new C0035a());

        /* renamed from: f  reason: collision with root package name */
        public Socket f2337f;
        public BufferedInputStream g;
        public BufferedOutputStream h;

        /* renamed from: com.cfg.mendikot.api.d.a.a.b.a$f$a  reason: collision with other inner class name */
        public class C0035a implements Runnable {
            public C0035a() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
                return;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0041 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0023 A[LOOP:1: B:12:0x0023->B:16:?, LOOP_START] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0021 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:5:0x000b A[SYNTHETIC, Splitter:B:5:0x000b] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.cfg.mendikot.api.d.a.a.b.a$f r0 = com.cfg.mendikot.api.d.a.a.b.a.f.this
                    java.lang.Object r0 = r0.f2335d
                    monitor-enter(r0)
                L_0x0005:
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ all -> 0x0043 }
                    boolean r1 = r1.f2332a     // Catch:{ all -> 0x0043 }
                    if (r1 != 0) goto L_0x0012
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ InterruptedException -> 0x0012 }
                    java.lang.Object r1 = r1.f2335d     // Catch:{ InterruptedException -> 0x0012 }
                    r1.wait()     // Catch:{ InterruptedException -> 0x0012 }
                L_0x0012:
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ all -> 0x0043 }
                    r2 = 0
                    r1.f2332a = r2     // Catch:{ all -> 0x0043 }
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ all -> 0x0043 }
                    java.net.Socket r1 = r1.f2337f     // Catch:{ all -> 0x0043 }
                    boolean r1 = r1.isClosed()     // Catch:{ all -> 0x0043 }
                    if (r1 == 0) goto L_0x0023
                    monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                    return
                L_0x0023:
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ all -> 0x0043 }
                    java.util.LinkedList<com.cfg.mendikot.api.d.a.a.b.d.a> r1 = r1.f2334c     // Catch:{ all -> 0x0043 }
                    int r1 = r1.size()     // Catch:{ all -> 0x0043 }
                    if (r1 <= 0) goto L_0x0005
                    com.cfg.mendikot.api.d.a.a.b.a$f r1 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ all -> 0x0043 }
                    java.util.LinkedList<com.cfg.mendikot.api.d.a.a.b.d.a> r1 = r1.f2334c     // Catch:{ all -> 0x0043 }
                    java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0043 }
                    com.cfg.mendikot.api.d.a.a.b.d.a r1 = (com.cfg.mendikot.api.d.a.a.b.d.a) r1     // Catch:{ all -> 0x0043 }
                    int r2 = r1.f2339a     // Catch:{ all -> 0x0043 }
                    byte[] r1 = r1.f2340b     // Catch:{ all -> 0x0043 }
                    com.cfg.mendikot.api.d.a.a.b.a$f r3 = com.cfg.mendikot.api.d.a.a.b.a.f.this     // Catch:{ IOException -> 0x0041 }
                    com.cfg.mendikot.api.d.a.a.b.a.f.a(r3, r2, r1)     // Catch:{ IOException -> 0x0041 }
                    goto L_0x0023
                L_0x0041:
                    monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                    return
                L_0x0043:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.b.a.f.C0035a.run():void");
            }
        }

        public f(C0034a aVar) {
        }

        public static void a(f fVar, int i2, byte[] bArr) {
            int i3;
            byte[] bArr2;
            if (fVar != null) {
                int length = bArr == null ? 0 : bArr.length;
                if (length < 126) {
                    bArr2 = new byte[(length + 6)];
                    bArr2[0] = (byte) (i2 | -128);
                    bArr2[1] = (byte) (length | -128);
                    i3 = 2;
                } else if (length < 65536) {
                    bArr2 = new byte[(length + 8)];
                    bArr2[0] = (byte) (i2 | -128);
                    bArr2[1] = -2;
                    byte[] bArr3 = {(byte) (length >>> 8), (byte) length};
                    bArr2[2] = bArr3[0];
                    bArr2[3] = bArr3[1];
                    i3 = 4;
                } else {
                    bArr2 = new byte[(length + 14)];
                    bArr2[0] = (byte) (i2 | -128);
                    bArr2[1] = -1;
                    byte[] bArr4 = {0, 0, 0, 0, (byte) (length >>> 24), (byte) (length >>> 16), (byte) (length >>> 8), (byte) length};
                    bArr2[2] = bArr4[0];
                    bArr2[3] = bArr4[1];
                    bArr2[4] = bArr4[2];
                    bArr2[5] = bArr4[3];
                    bArr2[6] = bArr4[4];
                    bArr2[7] = bArr4[5];
                    bArr2[8] = bArr4[6];
                    bArr2[9] = bArr4[7];
                    i3 = 10;
                }
                byte[] bArr5 = new byte[4];
                a.this.f2321c.nextBytes(bArr5);
                bArr2[i3] = bArr5[0];
                bArr2[i3 + 1] = bArr5[1];
                bArr2[i3 + 2] = bArr5[2];
                bArr2[i3 + 3] = bArr5[3];
                int i4 = i3 + 4;
                for (int i5 = 0; i5 < length; i5++) {
                    bArr2[i4] = (byte) (bArr[i5] ^ bArr5[i5 % 4]);
                    i4++;
                }
                fVar.h.write(bArr2);
                fVar.h.flush();
                return;
            }
            throw null;
        }

        public static boolean e(f fVar) {
            boolean z;
            Socket socket;
            InetSocketAddress inetSocketAddress;
            synchronized (fVar.f2335d) {
                if (!fVar.f2333b) {
                    String scheme = a.this.f2320b.getScheme();
                    int port = a.this.f2320b.getPort();
                    if (scheme != null) {
                        if (scheme.equals("ws")) {
                            Socket createSocket = SocketFactory.getDefault().createSocket();
                            fVar.f2337f = createSocket;
                            createSocket.setSoTimeout(a.this.f2323e);
                            if (port != -1) {
                                socket = fVar.f2337f;
                                inetSocketAddress = new InetSocketAddress(a.this.f2320b.getHost(), port);
                            } else {
                                socket = fVar.f2337f;
                                inetSocketAddress = new InetSocketAddress(a.this.f2320b.getHost(), 80);
                            }
                        } else if (scheme.equals("wss")) {
                            Socket createSocket2 = a.this.l.createSocket();
                            fVar.f2337f = createSocket2;
                            createSocket2.setSoTimeout(a.this.f2323e);
                            if (port != -1) {
                                socket = fVar.f2337f;
                                inetSocketAddress = new InetSocketAddress(a.this.f2320b.getHost(), port);
                            } else {
                                socket = fVar.f2337f;
                                inetSocketAddress = new InetSocketAddress(a.this.f2320b.getHost(), 443);
                            }
                        } else {
                            throw new com.cfg.mendikot.api.d.a.a.b.c.a("The scheme component of the URI should be ws or wss");
                        }
                        socket.connect(inetSocketAddress, a.this.f2322d);
                        z = true;
                    } else {
                        throw new com.cfg.mendikot.api.d.a.a.b.c.a("The scheme component of the URI cannot be null");
                    }
                } else {
                    z = false;
                }
            }
            return z;
        }

        public static void f(f fVar) {
            String str;
            byte[] bArr = null;
            if (fVar != null) {
                fVar.h = new BufferedOutputStream(fVar.f2337f.getOutputStream(), 65536);
                byte[] bArr2 = new byte[16];
                new Random().nextBytes(bArr2);
                String d2 = com.cfg.mendikot.api.d.a.a.a.a.a.f.a.d(bArr2);
                StringBuilder sb = new StringBuilder();
                String rawPath = a.this.f2320b.getRawPath();
                String rawQuery = a.this.f2320b.getRawQuery();
                if (rawQuery != null) {
                    rawPath = GeneratedOutlineSupport.outline52(rawPath, ColorPropConverter.PREFIX_ATTR, rawQuery);
                }
                sb.append("GET " + rawPath + " HTTP/1.1");
                sb.append("\r\n");
                if (a.this.f2320b.getPort() == -1) {
                    str = a.this.f2320b.getHost();
                } else {
                    str = a.this.f2320b.getHost() + ":" + a.this.f2320b.getPort();
                }
                sb.append("Host: " + str);
                sb.append("\r\n");
                sb.append("Upgrade: websocket");
                sb.append("\r\n");
                sb.append("Connection: Upgrade");
                sb.append("\r\n");
                sb.append("Sec-WebSocket-Key: " + d2);
                sb.append("\r\n");
                sb.append("Sec-WebSocket-Version: 13");
                sb.append("\r\n");
                for (Entry next : a.this.i.entrySet()) {
                    sb.append(((String) next.getKey()) + ": " + ((String) next.getValue()));
                    sb.append("\r\n");
                }
                sb.append("\r\n");
                fVar.h.write(sb.toString().getBytes(Charset.forName("ASCII")));
                fVar.h.flush();
                InputStream inputStream = fVar.f2337f.getInputStream();
                try {
                    com.cfg.mendikot.api.d.a.a.a.b.r.c.d dVar = new com.cfg.mendikot.api.d.a.a.a.b.r.c.d(new com.cfg.mendikot.api.d.a.a.a.b.r.c.c(), 8192);
                    dVar.f2296f = inputStream;
                    g gVar = (g) new com.cfg.mendikot.api.d.a.a.a.b.r.c.b(dVar).a();
                    p a2 = gVar.a();
                    if (a2 != null) {
                        if (a2.b() == 101) {
                            com.cfg.mendikot.api.d.a.a.a.b.c[] a3 = gVar.a((String) "Upgrade");
                            if (a3.length != 0) {
                                String a4 = a3[0].a();
                                if (a4 != null) {
                                    if (a4.toLowerCase().equals(WebSocketHandshake.HTTP_HEADER_UPGRADE_WEBSOCKET)) {
                                        com.cfg.mendikot.api.d.a.a.a.b.c[] a5 = gVar.a((String) "Connection");
                                        if (a5.length != 0) {
                                            String a6 = a5[0].a();
                                            if (a6 != null) {
                                                if (a6.toLowerCase().equals("upgrade")) {
                                                    com.cfg.mendikot.api.d.a.a.a.b.c[] a7 = gVar.a((String) "Sec-WebSocket-Accept");
                                                    if (a7.length != 0) {
                                                        String a8 = a7[0].a();
                                                        if (a8 != null) {
                                                            String str2 = d2 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
                                                            Charset charset = com.cfg.mendikot.api.d.a.a.a.a.a.c.f2256a;
                                                            if (str2 != null) {
                                                                bArr = str2.getBytes(charset);
                                                            }
                                                            if (a8.equals(com.cfg.mendikot.api.d.a.a.a.a.a.f.a.d(MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE).digest(bArr)))) {
                                                                fVar.f2336e.start();
                                                                a aVar = a.this;
                                                                synchronized (aVar.f2319a) {
                                                                    if (aVar.h) {
                                                                        com.cfg.mendikot.api.b.a aVar2 = (com.cfg.mendikot.api.b.a) aVar;
                                                                        com.cfg.mendikot.api.b.this.f2254e = 0;
                                                                        a.a.l.e eVar = aVar2.m;
                                                                        if (eVar != null) {
                                                                            eVar.f(aVar2.n);
                                                                        }
                                                                    }
                                                                }
                                                                fVar.g = new BufferedInputStream(fVar.f2337f.getInputStream(), 65536);
                                                                fVar.c();
                                                                return;
                                                            }
                                                            throw new com.cfg.mendikot.api.d.a.a.b.c.b("Invalid value for header Sec-WebSocket-Accept. Expected: " + r0 + ", received: " + a8);
                                                        }
                                                        throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no value for header Sec-WebSocket-Accept");
                                                    }
                                                    throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no header named Sec-WebSocket-Accept");
                                                }
                                                throw new com.cfg.mendikot.api.d.a.a.b.c.b("Invalid value for header Connection. Expected: upgrade, received: " + r4);
                                            }
                                            throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no value for header Connection");
                                        }
                                        throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no header named Connection");
                                    }
                                    throw new com.cfg.mendikot.api.d.a.a.b.c.b("Invalid value for header Upgrade. Expected: websocket, received: " + r4);
                                }
                                throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no value for header Upgrade");
                            }
                            throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no header named Upgrade");
                        }
                        throw new com.cfg.mendikot.api.d.a.a.b.c.b("Invalid status code. Expected 101, received: " + r4);
                    }
                    throw new com.cfg.mendikot.api.d.a.a.b.c.b("There is no status line");
                } catch (NoSuchAlgorithmException e2) {
                    throw new IllegalArgumentException(e2);
                } catch (com.cfg.mendikot.api.d.a.a.a.b.e e3) {
                    throw new com.cfg.mendikot.api.d.a.a.b.c.b(e3.getMessage());
                }
            } else {
                throw null;
            }
        }

        public final void a() {
            try {
                synchronized (this.f2335d) {
                    if (!this.f2333b) {
                        this.f2333b = true;
                        if (this.f2337f != null) {
                            this.f2337f.close();
                            this.f2332a = true;
                            this.f2335d.notify();
                        }
                    }
                }
            } catch (IOException unused) {
            }
        }

        public final void c() {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            while (true) {
                int read = this.g.read();
                if (read != -1) {
                    int i3 = (read << 24) >>> 31;
                    if (linkedList.isEmpty()) {
                        i2 = (read << 28) >>> 28;
                    }
                    boolean z = i3 == 1;
                    int read2 = (this.g.read() << 25) >>> 25;
                    if (read2 == 126) {
                        byte[] bArr = new byte[2];
                        for (int i4 = 0; i4 < 2; i4++) {
                            bArr[i4] = (byte) this.g.read();
                        }
                        read2 = k.a1(new byte[]{0, 0, bArr[0], bArr[1]});
                    } else if (read2 == 127) {
                        byte[] bArr2 = new byte[8];
                        for (int i5 = 0; i5 < 8; i5++) {
                            bArr2[i5] = (byte) this.g.read();
                        }
                        read2 = k.a1(new byte[]{bArr2[4], bArr2[5], bArr2[6], bArr2[7]});
                    }
                    byte[] bArr3 = new byte[read2];
                    for (int i6 = 0; i6 < read2; i6++) {
                        bArr3[i6] = (byte) this.g.read();
                    }
                    if (z) {
                        if (!linkedList.isEmpty()) {
                            linkedList.add(bArr3);
                            Iterator it = linkedList.iterator();
                            int i7 = 0;
                            while (it.hasNext()) {
                                i7 += ((byte[]) it.next()).length;
                            }
                            bArr3 = new byte[i7];
                            Iterator it2 = linkedList.iterator();
                            int i8 = 0;
                            while (it2.hasNext()) {
                                byte[] bArr4 = (byte[]) it2.next();
                                System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                                i8 += bArr4.length;
                            }
                            linkedList.clear();
                        }
                        if (i2 == 0) {
                            continue;
                        } else if (i2 == 1) {
                            a aVar = a.this;
                            String str = new String(bArr3, Charset.forName("UTF-8"));
                            synchronized (aVar.f2319a) {
                                if (aVar.h) {
                                    com.cfg.mendikot.api.b.this.b(str);
                                }
                            }
                        } else if (i2 != 2) {
                            switch (i2) {
                                case 8:
                                    a();
                                    a aVar2 = a.this;
                                    synchronized (aVar2.f2319a) {
                                        if (aVar2.h) {
                                            com.cfg.mendikot.api.b.a aVar3 = (com.cfg.mendikot.api.b.a) aVar2;
                                            a.a.l.e eVar = aVar3.m;
                                            if (eVar != null) {
                                                eVar.c(aVar3.n);
                                            }
                                        }
                                    }
                                    return;
                                case 9:
                                    a aVar4 = a.this;
                                    synchronized (aVar4.f2319a) {
                                        if (aVar4.h) {
                                            "onPingReceived: " + bArr3;
                                        }
                                    }
                                    a aVar5 = a.this;
                                    if (aVar5 != null) {
                                        new Thread(new d(new com.cfg.mendikot.api.d.a.a.b.d.a(10, bArr3))).start();
                                        break;
                                    } else {
                                        throw null;
                                    }
                                case 10:
                                    a.c(a.this, bArr3);
                                    break;
                                default:
                                    a();
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown opcode: 0x");
                                    outline73.append(Integer.toHexString(i2));
                                    a.a(a.this, new com.cfg.mendikot.api.d.a.a.b.c.c(outline73.toString()));
                                    return;
                            }
                        } else {
                            a aVar6 = a.this;
                            synchronized (aVar6.f2319a) {
                                if (aVar6.h) {
                                    "onBinaryReceived: " + bArr3;
                                }
                            }
                        }
                    } else {
                        linkedList.add(bArr3);
                    }
                } else {
                    throw new IOException("Unexpected end of stream");
                }
            }
            while (true) {
            }
        }

        public static void a(f fVar, com.cfg.mendikot.api.d.a.a.b.d.a aVar) {
            synchronized (fVar.f2335d) {
                fVar.f2334c.addLast(aVar);
                fVar.f2332a = true;
                fVar.f2335d.notify();
            }
        }
    }

    public a(URI uri) {
        this.f2320b = uri;
        this.f2321c = new SecureRandom();
        this.f2322d = 0;
        this.f2323e = 0;
        this.f2324f = false;
        this.g = 0;
        this.h = false;
        this.i = new HashMap();
        this.j = new f(null);
    }

    public static void a(a aVar, Exception exc) {
        synchronized (aVar.f2319a) {
            if (aVar.h) {
                aVar.a(exc);
            }
        }
    }

    public static void c(a aVar, byte[] bArr) {
        synchronized (aVar.f2319a) {
            if (aVar.h) {
                "onPongReceived: " + bArr;
            }
        }
    }

    public void a(int i2) {
        synchronized (this.f2319a) {
            if (this.h) {
                throw new IllegalStateException("Cannot set connect timeout while WebSocketClient is running");
            } else if (i2 >= 0) {
                this.f2322d = i2;
            } else {
                throw new IllegalStateException("Connect timeout must be greater or equal than zero");
            }
        }
    }

    public void a(long j2) {
        synchronized (this.f2319a) {
            if (this.h) {
                throw new IllegalStateException("Cannot enable automatic reconnection while WebSocketClient is running");
            } else if (j2 >= 0) {
                this.f2324f = true;
                this.g = j2;
            } else {
                throw new IllegalStateException("Wait time between reconnections must be greater or equal than zero");
            }
        }
    }

    public abstract void a(Exception exc);

    public void b() {
        synchronized (this.f2319a) {
            if (!this.h) {
                this.h = true;
                new Thread(new C0034a()).start();
            } else {
                throw new IllegalStateException("WebSocketClient is not reusable");
            }
        }
    }

    public void b(int i2) {
        synchronized (this.f2319a) {
            if (this.h) {
                throw new IllegalStateException("Cannot set read timeout while WebSocketClient is running");
            } else if (i2 >= 0) {
                this.f2323e = i2;
            } else {
                throw new IllegalStateException("Read timeout must be greater or equal than zero");
            }
        }
    }

    public void b(String str) {
        new Thread(new c(new com.cfg.mendikot.api.d.a.a.b.d.a(1, str.getBytes(Charset.forName("UTF-8"))))).start();
    }
}
