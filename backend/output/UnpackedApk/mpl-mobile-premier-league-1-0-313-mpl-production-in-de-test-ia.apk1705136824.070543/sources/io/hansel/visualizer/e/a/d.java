package io.hansel.visualizer.e.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.visualizer.e.a.b.C0091b;
import io.hansel.visualizer.e.a.b.a;
import io.hansel.visualizer.e.a.g.a.C0093a;
import io.hansel.visualizer.e.a.g.a.b;
import io.hansel.visualizer.e.a.h.e;
import io.hansel.visualizer.e.a.j.h;
import io.hansel.visualizer.e.a.k.f;
import io.hansel.visualizer.e.a.l.c;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class d implements b {
    public static final Object r = new Object();
    public static int s = 16384;
    public static boolean t = false;
    public static final /* synthetic */ boolean u = (!d.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f5863a;

    /* renamed from: b  reason: collision with root package name */
    public final e f5864b;

    /* renamed from: c  reason: collision with root package name */
    public SelectionKey f5865c;

    /* renamed from: d  reason: collision with root package name */
    public ByteChannel f5866d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5867e = false;

    /* renamed from: f  reason: collision with root package name */
    public a f5868f = a.NOT_YET_CONNECTED;
    public List<io.hansel.visualizer.e.a.g.a> g;
    public io.hansel.visualizer.e.a.g.a h = null;
    public C0091b i;
    public ByteBuffer j = ByteBuffer.allocate(0);
    public io.hansel.visualizer.e.a.k.a k = null;
    public String l = null;
    public Integer m = null;
    public Boolean n = null;
    public String o = null;
    public long p = System.currentTimeMillis();
    public h q;

    public d(e eVar, io.hansel.visualizer.e.a.g.a aVar) {
        if (eVar == null || (aVar == null && this.i == C0091b.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f5863a = new LinkedBlockingQueue();
        new LinkedBlockingQueue();
        this.f5864b = eVar;
        this.i = C0091b.CLIENT;
        if (aVar != null) {
            this.h = aVar.a();
        }
    }

    private void a(f fVar) {
        if (t) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("open using draft: ");
            outline73.append(this.h);
            HSLLogger.d(outline73.toString());
        }
        this.f5868f = a.OPEN;
        try {
            this.f5864b.a((b) this, fVar);
        } catch (RuntimeException e2) {
            this.f5864b.a((b) this, (Exception) e2);
        }
    }

    private void a(RuntimeException runtimeException) {
        e(b(500));
        c(-1, runtimeException.getMessage(), false);
    }

    private void a(Collection<io.hansel.visualizer.e.a.j.f> collection) {
        if (!i()) {
            throw new io.hansel.visualizer.e.a.h.h();
        } else if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            ArrayList arrayList = new ArrayList();
            for (io.hansel.visualizer.e.a.j.f next : collection) {
                if (t) {
                    HSLLogger.d("send frame: " + next);
                }
                arrayList.add(this.h.a(next));
            }
            a((List<ByteBuffer>) arrayList);
        }
    }

    private void a(List<ByteBuffer> list) {
        synchronized (r) {
            for (ByteBuffer e2 : list) {
                e(e2);
            }
        }
    }

    private ByteBuffer b(int i2) {
        String str = i2 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("HTTP/1.1 ", str, "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: ");
        outline80.append(str.length() + 48);
        outline80.append("\r\n\r\n<html><head></head><body><h1>");
        outline80.append(str);
        outline80.append("</h1></body></html>");
        return ByteBuffer.wrap(c.a(outline80.toString()));
    }

    private void b(io.hansel.visualizer.e.a.h.c cVar) {
        e(b(404));
        c(cVar.a(), cVar.getMessage(), false);
    }

    private void b(ByteBuffer byteBuffer) {
        try {
            for (io.hansel.visualizer.e.a.j.f next : this.h.c(byteBuffer)) {
                if (t) {
                    HSLLogger.d("matched frame: " + next);
                }
                this.h.a(this, next);
            }
        } catch (io.hansel.visualizer.e.a.h.c e2) {
            this.f5864b.a((b) this, (Exception) e2);
            a(e2);
        }
    }

    private boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.j.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.j.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + this.j.capacity());
                this.j.flip();
                allocate.put(this.j);
                this.j = allocate;
            }
            this.j.put(byteBuffer);
            this.j.flip();
            byteBuffer2 = this.j;
        }
        byteBuffer2.mark();
        try {
            if (this.h == null && d(byteBuffer2) == b.MATCHED) {
                try {
                    a(Collections.singletonList(ByteBuffer.wrap(c.b(this.f5864b.a(this)))));
                    a(-3, (String) "");
                } catch (io.hansel.visualizer.e.a.h.c unused) {
                    a(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                C0091b bVar = this.i;
                if (bVar == C0091b.SERVER) {
                    io.hansel.visualizer.e.a.g.a aVar = this.h;
                    if (aVar == null) {
                        for (io.hansel.visualizer.e.a.g.a a2 : this.g) {
                            io.hansel.visualizer.e.a.g.a a3 = a2.a();
                            try {
                                a3.a(this.i);
                                byteBuffer2.reset();
                                f d2 = a3.d(byteBuffer2);
                                if (!(d2 instanceof io.hansel.visualizer.e.a.k.a)) {
                                    b(new io.hansel.visualizer.e.a.h.c(1002, (String) "wrong http function"));
                                    return false;
                                }
                                io.hansel.visualizer.e.a.k.a aVar2 = (io.hansel.visualizer.e.a.k.a) d2;
                                if (a3.a(aVar2) == b.MATCHED) {
                                    this.o = aVar2.a();
                                    try {
                                        a(a3.a((f) a3.a(aVar2, this.f5864b.a((b) this, a3, aVar2)), this.i));
                                        this.h = a3;
                                        a((f) aVar2);
                                        return true;
                                    } catch (io.hansel.visualizer.e.a.h.c e2) {
                                        b(e2);
                                        return false;
                                    } catch (RuntimeException e3) {
                                        this.f5864b.a((b) this, (Exception) e3);
                                        a(e3);
                                        return false;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (e unused2) {
                            }
                        }
                        if (this.h == null) {
                            b(new io.hansel.visualizer.e.a.h.c(1002, (String) "no draft matches"));
                        }
                        return false;
                    }
                    f d3 = aVar.d(byteBuffer2);
                    if (!(d3 instanceof io.hansel.visualizer.e.a.k.a)) {
                        c(1002, "wrong http function", false);
                        return false;
                    }
                    io.hansel.visualizer.e.a.k.a aVar3 = (io.hansel.visualizer.e.a.k.a) d3;
                    if (this.h.a(aVar3) == b.MATCHED) {
                        a((f) aVar3);
                        return true;
                    }
                    a(1002, (String) "the handshake did finaly not match");
                    return false;
                }
                if (bVar == C0091b.CLIENT) {
                    this.h.a(bVar);
                    f d4 = this.h.d(byteBuffer2);
                    if (!(d4 instanceof io.hansel.visualizer.e.a.k.h)) {
                        c(1002, "wrong http function", false);
                        return false;
                    }
                    io.hansel.visualizer.e.a.k.h hVar = (io.hansel.visualizer.e.a.k.h) d4;
                    if (this.h.a(this.k, hVar) == b.MATCHED) {
                        try {
                            this.f5864b.a((b) this, this.k, hVar);
                            a((f) hVar);
                            return true;
                        } catch (io.hansel.visualizer.e.a.h.c e4) {
                            c(e4.a(), e4.getMessage(), false);
                            return false;
                        } catch (RuntimeException e5) {
                            this.f5864b.a((b) this, (Exception) e5);
                            c(-1, e5.getMessage(), false);
                            return false;
                        }
                    } else {
                        a(1002, "draft " + this.h + " refuses handshake");
                    }
                }
                return false;
            } catch (e e6) {
                a((io.hansel.visualizer.e.a.h.c) e6);
            }
        } catch (io.hansel.visualizer.e.a.h.b e7) {
            if (this.j.capacity() == 0) {
                byteBuffer2.reset();
                int a4 = e7.a();
                if (a4 == 0) {
                    a4 = byteBuffer2.capacity() + 16;
                } else if (!u && e7.a() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(a4);
                this.j = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.j;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.j;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
    }

    private b d(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        int limit = byteBuffer.limit();
        byte[] bArr = io.hansel.visualizer.e.a.g.a.f5871b;
        if (limit > bArr.length) {
            return b.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= bArr.length) {
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (io.hansel.visualizer.e.a.g.a.f5871b[i2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return b.NOT_MATCHED;
                }
                i2++;
            }
            return b.MATCHED;
        }
        throw new io.hansel.visualizer.e.a.h.b(bArr.length);
    }

    private void e(ByteBuffer byteBuffer) {
        if (t) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("write(");
            outline73.append(byteBuffer.remaining());
            outline73.append("): {");
            outline73.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            outline73.append("}");
            HSLLogger.d(outline73.toString());
        }
        this.f5863a.add(byteBuffer);
        this.f5864b.c(this);
    }

    public InetSocketAddress a() {
        return this.f5864b.b(this);
    }

    public void a(int i2) {
        a(i2, "", false);
    }

    public void a(int i2, String str) {
        a(i2, str, false);
    }

    public void a(int i2, String str, boolean z) {
        a aVar = this.f5868f;
        a aVar2 = a.CLOSING;
        if (!(aVar == aVar2 || aVar == a.CLOSED)) {
            if (aVar == a.OPEN) {
                if (i2 != 1006) {
                    if (this.h.b() != C0093a.NONE) {
                        if (!z) {
                            try {
                                this.f5864b.a((b) this, i2, str);
                            } catch (RuntimeException e2) {
                                try {
                                    this.f5864b.a((b) this, (Exception) e2);
                                } catch (io.hansel.visualizer.e.a.h.c e3) {
                                    this.f5864b.a((b) this, (Exception) e3);
                                    c(1006, "generated frame is invalid", false);
                                }
                            }
                        }
                        io.hansel.visualizer.e.a.j.b bVar = new io.hansel.visualizer.e.a.j.b();
                        bVar.a(str);
                        bVar.a(i2);
                        bVar.g();
                        a((io.hansel.visualizer.e.a.j.f) bVar);
                    }
                    c(i2, str, z);
                } else if (u || !z) {
                    this.f5868f = aVar2;
                    c(i2, str, false);
                    return;
                } else {
                    throw new AssertionError();
                }
            } else if (i2 != -3) {
                c(-1, str, false);
            } else if (u || z) {
                c(-3, str, true);
            } else {
                throw new AssertionError();
            }
            if (i2 == 1002) {
                c(i2, str, z);
            }
            this.f5868f = a.CLOSING;
            this.j = null;
        }
    }

    public void a(int i2, boolean z) {
        b(i2, "", z);
    }

    public void a(io.hansel.visualizer.e.a.h.c cVar) {
        a(cVar.a(), cVar.getMessage(), false);
    }

    public void a(io.hansel.visualizer.e.a.j.f fVar) {
        a((Collection<io.hansel.visualizer.e.a.j.f>) Collections.singletonList(fVar));
    }

    public void a(io.hansel.visualizer.e.a.k.b bVar) {
        boolean z = u;
        if (z || this.f5868f != a.CONNECTING) {
            this.k = this.h.a(bVar);
            String a2 = bVar.a();
            this.o = a2;
            if (z || a2 != null) {
                try {
                    this.f5864b.a((b) this, this.k);
                    a(this.h.a((f) this.k, this.i));
                } catch (io.hansel.visualizer.e.a.h.c unused) {
                    throw new e("Handshake data rejected by client.");
                } catch (RuntimeException e2) {
                    this.f5864b.a((b) this, (Exception) e2);
                    throw new e("rejected because of" + e2);
                }
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError("shall only be called once");
        }
    }

    public void a(String str) {
        if (str != null) {
            a((Collection<io.hansel.visualizer.e.a.j.f>) this.h.a(str, this.i == C0091b.CLIENT));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (r1 == io.hansel.visualizer.e.a.b.a.OPEN) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.nio.ByteBuffer r7) {
        /*
            r6 = this;
            boolean r0 = u
            if (r0 != 0) goto L_0x0011
            boolean r1 = r7.hasRemaining()
            if (r1 == 0) goto L_0x000b
            goto L_0x0011
        L_0x000b:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0011:
            boolean r1 = t
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = "process("
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            int r2 = r7.remaining()
            r1.append(r2)
            java.lang.String r2 = "): {"
            r1.append(r2)
            int r2 = r7.remaining()
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L_0x0033
            java.lang.String r2 = "too big to display"
            goto L_0x0044
        L_0x0033:
            java.lang.String r2 = new java.lang.String
            byte[] r3 = r7.array()
            int r4 = r7.position()
            int r5 = r7.remaining()
            r2.<init>(r3, r4, r5)
        L_0x0044:
            r1.append(r2)
            java.lang.String r2 = "}"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.HSLLogger.d(r1)
        L_0x0054:
            io.hansel.visualizer.e.a.b$a r1 = r6.f5868f
            io.hansel.visualizer.e.a.b$a r2 = io.hansel.visualizer.e.a.b.a.NOT_YET_CONNECTED
            if (r1 == r2) goto L_0x005f
            io.hansel.visualizer.e.a.b$a r2 = io.hansel.visualizer.e.a.b.a.OPEN
            if (r1 != r2) goto L_0x0097
            goto L_0x0086
        L_0x005f:
            boolean r1 = r6.c(r7)
            if (r1 == 0) goto L_0x0097
            if (r0 != 0) goto L_0x0080
            java.nio.ByteBuffer r1 = r6.j
            boolean r1 = r1.hasRemaining()
            boolean r2 = r7.hasRemaining()
            if (r1 != r2) goto L_0x0080
            boolean r1 = r7.hasRemaining()
            if (r1 != 0) goto L_0x007a
            goto L_0x0080
        L_0x007a:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0080:
            boolean r1 = r7.hasRemaining()
            if (r1 == 0) goto L_0x008a
        L_0x0086:
            r6.b(r7)
            goto L_0x0097
        L_0x008a:
            java.nio.ByteBuffer r1 = r6.j
            boolean r1 = r1.hasRemaining()
            if (r1 == 0) goto L_0x0097
            java.nio.ByteBuffer r1 = r6.j
            r6.b(r1)
        L_0x0097:
            if (r0 != 0) goto L_0x00b2
            boolean r0 = r6.g()
            if (r0 != 0) goto L_0x00b2
            boolean r0 = r6.h()
            if (r0 != 0) goto L_0x00b2
            boolean r7 = r7.hasRemaining()
            if (r7 != 0) goto L_0x00ac
            goto L_0x00b2
        L_0x00ac:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.e.a.d.a(java.nio.ByteBuffer):void");
    }

    public void b() {
        int i2;
        if (d() == a.NOT_YET_CONNECTED) {
            i2 = -1;
        } else if (this.f5867e) {
            b(this.m.intValue(), this.l, this.n.booleanValue());
            return;
        } else {
            i2 = (this.h.b() != C0093a.NONE && (this.h.b() != C0093a.ONEWAY || this.i == C0091b.SERVER)) ? 1006 : 1000;
        }
        a(i2, true);
    }

    public void b(int i2, String str) {
        b(i2, str, false);
    }

    public synchronized void b(int i2, String str, boolean z) {
        if (this.f5868f != a.CLOSED) {
            SelectionKey selectionKey = this.f5865c;
            if (selectionKey != null) {
                selectionKey.cancel();
            }
            ByteChannel byteChannel = this.f5866d;
            if (byteChannel != null) {
                try {
                    byteChannel.close();
                } catch (IOException e2) {
                    if (!e2.getMessage().equals("Broken pipe")) {
                        this.f5864b.a((b) this, (Exception) e2);
                    } else if (t) {
                        HSLLogger.d("Caught IOException: Broken pipe during closeConnection()");
                    }
                }
            }
            try {
                this.f5864b.a(this, i2, str, z);
            } catch (RuntimeException e3) {
                this.f5864b.a((b) this, (Exception) e3);
            }
            io.hansel.visualizer.e.a.g.a aVar = this.h;
            if (aVar != null) {
                aVar.c();
            }
            this.k = null;
            this.f5868f = a.CLOSED;
            this.f5863a.clear();
        }
    }

    public long c() {
        return this.p;
    }

    public synchronized void c(int i2, String str, boolean z) {
        if (!this.f5867e) {
            this.m = Integer.valueOf(i2);
            this.l = str;
            this.n = Boolean.valueOf(z);
            this.f5867e = true;
            this.f5864b.c(this);
            try {
                this.f5864b.b(this, i2, str, z);
            } catch (RuntimeException e2) {
                this.f5864b.a((b) this, (Exception) e2);
            }
            io.hansel.visualizer.e.a.g.a aVar = this.h;
            if (aVar != null) {
                aVar.c();
            }
            this.k = null;
        }
    }

    public a d() {
        return this.f5868f;
    }

    public e e() {
        return this.f5864b;
    }

    public boolean f() {
        return this.f5868f == a.CLOSED;
    }

    public boolean g() {
        return this.f5868f == a.CLOSING;
    }

    public boolean h() {
        return this.f5867e;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean i() {
        if (u || this.f5868f != a.OPEN || !this.f5867e) {
            return this.f5868f == a.OPEN;
        }
        throw new AssertionError();
    }

    public void j() {
        if (this.q == null) {
            this.q = new h();
        }
        a((io.hansel.visualizer.e.a.j.f) this.q);
    }

    public void k() {
        this.p = System.currentTimeMillis();
    }

    public String toString() {
        return super.toString();
    }
}
