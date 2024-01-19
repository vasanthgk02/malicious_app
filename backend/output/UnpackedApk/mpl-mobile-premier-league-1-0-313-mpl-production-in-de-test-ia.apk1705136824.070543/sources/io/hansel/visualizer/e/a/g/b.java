package io.hansel.visualizer.e.a.g;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import io.hansel.core.logger.HSLLogger;
import io.hansel.visualizer.e.a.b.C0091b;
import io.hansel.visualizer.e.a.g.a.C0093a;
import io.hansel.visualizer.e.a.h.d;
import io.hansel.visualizer.e.a.h.e;
import io.hansel.visualizer.e.a.h.g;
import io.hansel.visualizer.e.a.i.a;
import io.hansel.visualizer.e.a.j.f;
import io.hansel.visualizer.e.a.j.j;
import io.hansel.visualizer.e.a.k.c;
import io.hansel.visualizer.e.a.k.h;
import io.hansel.visualizer.e.a.k.i;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import okhttp3.internal.ws.WebSocketExtensions;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;

public class b extends a {
    public static final /* synthetic */ boolean h = (!b.class.desiredAssertionStatus());

    /* renamed from: c  reason: collision with root package name */
    public final Random f5880c;

    /* renamed from: d  reason: collision with root package name */
    public List<io.hansel.visualizer.e.a.i.b> f5881d;

    /* renamed from: e  reason: collision with root package name */
    public io.hansel.visualizer.e.a.i.b f5882e;

    /* renamed from: f  reason: collision with root package name */
    public f f5883f;
    public ByteBuffer g;

    public b() {
        this(Collections.emptyList());
    }

    public b(List<io.hansel.visualizer.e.a.i.b> list) {
        this.f5880c = new Random();
        this.f5882e = new a();
        this.f5881d = new ArrayList();
        boolean z = false;
        for (io.hansel.visualizer.e.a.i.b bVar : list) {
            if (bVar.getClass().equals(a.class)) {
                z = true;
            }
        }
        this.f5881d.addAll(list);
        if (!z) {
            List<io.hansel.visualizer.e.a.i.b> list2 = this.f5881d;
            list2.add(list2.size(), this.f5882e);
        }
    }

    private byte a(f.a aVar) {
        if (aVar == f.a.CONTINUOUS) {
            return 0;
        }
        if (aVar == f.a.TEXT) {
            return 1;
        }
        if (aVar == f.a.BINARY) {
            return 2;
        }
        if (aVar == f.a.CLOSING) {
            return 8;
        }
        if (aVar == f.a.PING) {
            return 9;
        }
        if (aVar == f.a.PONG) {
            return 10;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Don't know how to handle ");
        outline73.append(aVar.toString());
        throw new RuntimeException(outline73.toString());
    }

    private f.a a(byte b2) {
        if (b2 == 0) {
            return f.a.CONTINUOUS;
        }
        if (b2 == 1) {
            return f.a.TEXT;
        }
        if (b2 == 2) {
            return f.a.BINARY;
        }
        switch (b2) {
            case 8:
                return f.a.CLOSING;
            case 9:
                return f.a.PING;
            case 10:
                return f.a.PONG;
            default:
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown opcode ");
                outline73.append((short) b2);
                throw new d(outline73.toString());
        }
    }

    private String a(String str) {
        String outline50 = GeneratedOutlineSupport.outline50(str.trim(), "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        try {
            return io.hansel.visualizer.e.a.l.a.a(MessageDigest.getInstance(WebSocketHandshake.SHA1_PROTOCOL).digest(outline50.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    private ByteBuffer b(f fVar) {
        byte b2;
        ByteBuffer c2 = fVar.c();
        int i = 0;
        boolean z = this.f5872a == C0091b.CLIENT;
        int i2 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + (i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0));
        byte b3 = Byte.MIN_VALUE;
        allocate.put((byte) (((byte) (fVar.f() ? -128 : 0)) | a(fVar.a())));
        byte[] a2 = a((long) c2.remaining(), i2);
        if (h || a2.length == i2) {
            if (i2 == 1) {
                byte b4 = a2[0];
                if (!z) {
                    b3 = 0;
                }
                allocate.put((byte) (b4 | b3));
            } else {
                if (i2 == 2) {
                    if (!z) {
                        b3 = 0;
                    }
                    b2 = b3 | 126;
                } else if (i2 == 8) {
                    if (!z) {
                        b3 = 0;
                    }
                    b2 = b3 | Byte.MAX_VALUE;
                } else {
                    throw new RuntimeException("Size representation not supported/specified");
                }
                allocate.put((byte) b2);
                allocate.put(a2);
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.f5880c.nextInt());
                allocate.put(allocate2.array());
                while (c2.hasRemaining()) {
                    allocate.put((byte) (c2.get() ^ allocate2.get(i % 4)));
                    i++;
                }
            } else {
                allocate.put(c2);
                c2.flip();
            }
            if (h || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    private String e() {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(instance.getTime());
    }

    public io.hansel.visualizer.e.a.g.a.b a(io.hansel.visualizer.e.a.k.a aVar) {
        if (b((io.hansel.visualizer.e.a.k.f) aVar) != 13) {
            return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
        }
        String c2 = aVar.c(WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION);
        for (io.hansel.visualizer.e.a.i.b next : this.f5881d) {
            if (next.a(c2)) {
                this.f5882e = next;
                return io.hansel.visualizer.e.a.g.a.b.MATCHED;
            }
        }
        return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
    }

    public io.hansel.visualizer.e.a.g.a.b a(io.hansel.visualizer.e.a.k.a aVar, h hVar) {
        if (!a((io.hansel.visualizer.e.a.k.f) hVar)) {
            return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
        }
        if (!aVar.a("Sec-WebSocket-Key") || !hVar.a("Sec-WebSocket-Accept")) {
            return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
        }
        if (!a(aVar.c("Sec-WebSocket-Key")).equals(hVar.c("Sec-WebSocket-Accept"))) {
            return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
        }
        String c2 = hVar.c(WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION);
        for (io.hansel.visualizer.e.a.i.b next : this.f5881d) {
            if (next.b(c2)) {
                this.f5882e = next;
                return io.hansel.visualizer.e.a.g.a.b.MATCHED;
            }
        }
        return io.hansel.visualizer.e.a.g.a.b.NOT_MATCHED;
    }

    public a a() {
        ArrayList arrayList = new ArrayList();
        for (io.hansel.visualizer.e.a.i.b c2 : this.f5881d) {
            arrayList.add(c2.c());
        }
        return new b(arrayList);
    }

    public io.hansel.visualizer.e.a.k.b a(io.hansel.visualizer.e.a.k.b bVar) {
        bVar.a("Upgrade", WebSocketHandshake.HTTP_HEADER_UPGRADE_WEBSOCKET);
        bVar.a("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.f5880c.nextBytes(bArr);
        bVar.a("Sec-WebSocket-Key", io.hansel.visualizer.e.a.l.a.a(bArr));
        bVar.a("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (io.hansel.visualizer.e.a.i.b next : this.f5881d) {
            if (next.a() != null && !next.a().equals("")) {
                sb.append(next.a());
                sb.append("; ");
            }
        }
        if (sb.length() != 0) {
            bVar.a(WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, sb.toString());
        }
        return bVar;
    }

    public c a(io.hansel.visualizer.e.a.k.a aVar, i iVar) {
        iVar.a("Upgrade", WebSocketHandshake.HTTP_HEADER_UPGRADE_WEBSOCKET);
        iVar.a("Connection", aVar.c("Connection"));
        String c2 = aVar.c("Sec-WebSocket-Key");
        if (c2 != null) {
            iVar.a("Sec-WebSocket-Accept", a(c2));
            if (d().b().length() != 0) {
                iVar.a(WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, d().b());
            }
            iVar.d("Web Socket Protocol Handshake");
            iVar.a("Server", "TooTallNate Java-WebSocket");
            iVar.a("Date", e());
            return iVar;
        }
        throw new e("missing Sec-WebSocket-Key");
    }

    public ByteBuffer a(f fVar) {
        d().a(fVar);
        if (io.hansel.visualizer.e.a.d.t) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("afterEnconding(");
            outline73.append(fVar.c().remaining());
            outline73.append("): {");
            outline73.append(fVar.c().remaining() > 1000 ? "too big to display" : new String(fVar.c().array()));
            outline73.append("}");
            HSLLogger.d(outline73.toString());
        }
        return b(fVar);
    }

    public List<f> a(String str, boolean z) {
        j jVar = new j();
        jVar.a(ByteBuffer.wrap(io.hansel.visualizer.e.a.l.c.b(str)));
        jVar.e(z);
        try {
            jVar.g();
            return Collections.singletonList(jVar);
        } catch (io.hansel.visualizer.e.a.h.c e2) {
            throw new g(e2);
        }
    }

    public void a(io.hansel.visualizer.e.a.d dVar, f fVar) {
        String str;
        f.a a2 = fVar.a();
        if (a2 == f.a.CLOSING) {
            int i = WebSocketProtocol.CLOSE_NO_STATUS_CODE;
            if (fVar instanceof io.hansel.visualizer.e.a.j.b) {
                io.hansel.visualizer.e.a.j.b bVar = (io.hansel.visualizer.e.a.j.b) fVar;
                i = bVar.h();
                str = bVar.i();
            } else {
                str = "";
            }
            if (dVar.d() == io.hansel.visualizer.e.a.b.a.CLOSING) {
                dVar.b(i, str, true);
            } else if (b() == C0093a.TWOWAY) {
                dVar.a(i, str, true);
            } else {
                dVar.c(i, str, false);
            }
        } else if (a2 == f.a.PING) {
            dVar.e().a((io.hansel.visualizer.e.a.b) dVar, fVar);
        } else if (a2 == f.a.PONG) {
            dVar.k();
            dVar.e().c(dVar, fVar);
        } else if (!fVar.f() || a2 == f.a.CONTINUOUS) {
            f.a aVar = f.a.CONTINUOUS;
            if (a2 != aVar) {
                if (this.f5883f == null) {
                    this.f5883f = fVar;
                } else {
                    throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Previous continuous frame sequence not completed.");
                }
            } else if (fVar.f()) {
                f fVar2 = this.f5883f;
                if (fVar2 != null) {
                    if (fVar2.a() == f.a.TEXT) {
                        int max = Math.max(this.f5883f.c().limit() - 64, 0);
                        this.f5883f.a(fVar);
                        if (!io.hansel.visualizer.e.a.l.c.a(this.f5883f.c(), max)) {
                            throw new io.hansel.visualizer.e.a.h.c(Constant.REQUEST_CODE_FOR_SHORT_CUT);
                        }
                    }
                    this.f5883f = null;
                } else {
                    throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Continuous frame sequence was not started.");
                }
            } else if (this.f5883f == null) {
                throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Continuous frame sequence was not started.");
            }
            f.a aVar2 = f.a.TEXT;
            if (a2 != aVar2 || io.hansel.visualizer.e.a.l.c.a(fVar.c())) {
                if (a2 == aVar) {
                    f fVar3 = this.f5883f;
                    if (fVar3 != null && fVar3.a() == aVar2) {
                        int max2 = Math.max(this.f5883f.c().limit() - 64, 0);
                        this.f5883f.a(fVar);
                        if (!io.hansel.visualizer.e.a.l.c.a(this.f5883f.c(), max2)) {
                            throw new io.hansel.visualizer.e.a.h.c(Constant.REQUEST_CODE_FOR_SHORT_CUT);
                        }
                    }
                }
                try {
                    dVar.e().b(dVar, fVar);
                } catch (RuntimeException e2) {
                    dVar.e().a((io.hansel.visualizer.e.a.b) dVar, (Exception) e2);
                }
                return;
            }
            throw new io.hansel.visualizer.e.a.h.c(Constant.REQUEST_CODE_FOR_SHORT_CUT);
        } else if (this.f5883f != null) {
            throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Continuous frame sequence not completed.");
        } else if (a2 == f.a.TEXT) {
            try {
                dVar.e().a((io.hansel.visualizer.e.a.b) dVar, io.hansel.visualizer.e.a.l.c.b(fVar.c()));
            } catch (RuntimeException e3) {
                dVar.e().a((io.hansel.visualizer.e.a.b) dVar, (Exception) e3);
            }
        } else if (a2 == f.a.BINARY) {
            try {
                dVar.e().a((io.hansel.visualizer.e.a.b) dVar, fVar.c());
            } catch (RuntimeException e4) {
                dVar.e().a((io.hansel.visualizer.e.a.b) dVar, (Exception) e4);
            }
        } else {
            throw new io.hansel.visualizer.e.a.h.c(1002, (String) "non control or continious frame expected");
        }
    }

    public C0093a b() {
        return C0093a.TWOWAY;
    }

    public List<f> c(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.g.remaining();
                if (remaining2 > remaining) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.g.duplicate().position(0)));
                this.g = null;
            } catch (io.hansel.visualizer.e.a.h.a e2) {
                this.g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                if (h || allocate.limit() > this.g.limit()) {
                    this.g.rewind();
                    allocate.put(this.g);
                    this.g = allocate;
                } else {
                    throw new AssertionError();
                }
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (io.hansel.visualizer.e.a.h.a e3) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(a(e3.a()));
                this.g = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public void c() {
        this.g = null;
        io.hansel.visualizer.e.a.i.b bVar = this.f5882e;
        if (bVar != null) {
            bVar.reset();
        }
        this.f5882e = new a();
    }

    public io.hansel.visualizer.e.a.i.b d() {
        return this.f5882e;
    }

    public f e(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining >= 2) {
            byte b2 = byteBuffer.get();
            boolean z = (b2 >> 8) != 0;
            boolean z2 = (b2 & 64) != 0;
            boolean z3 = (b2 & 32) != 0;
            boolean z4 = (b2 & GlyfDescript.X_DUAL) != 0;
            byte b3 = byteBuffer.get();
            boolean z5 = (b3 & Byte.MIN_VALUE) != 0;
            int i2 = (byte) (b3 & Byte.MAX_VALUE);
            f.a a2 = a((byte) (b2 & 15));
            if (i2 < 0 || i2 > 125) {
                if (a2 == f.a.PING || a2 == f.a.PONG || a2 == f.a.CLOSING) {
                    throw new d("more than 125 octets");
                } else if (i2 != 126) {
                    i = 10;
                    if (remaining >= 10) {
                        byte[] bArr = new byte[8];
                        for (int i3 = 0; i3 < 8; i3++) {
                            bArr[i3] = byteBuffer.get();
                        }
                        long longValue = new BigInteger(bArr).longValue();
                        if (longValue <= 2147483647L) {
                            i2 = (int) longValue;
                        } else {
                            throw new io.hansel.visualizer.e.a.h.f("Payloadsize is to big...");
                        }
                    } else {
                        throw new io.hansel.visualizer.e.a.h.a(10);
                    }
                } else if (remaining >= 4) {
                    byte[] bArr2 = new byte[3];
                    bArr2[1] = byteBuffer.get();
                    bArr2[2] = byteBuffer.get();
                    i2 = new BigInteger(bArr2).intValue();
                    i = 4;
                } else {
                    throw new io.hansel.visualizer.e.a.h.a(4);
                }
            }
            int i4 = i + (z5 ? 4 : 0) + i2;
            if (remaining >= i4) {
                ByteBuffer allocate = ByteBuffer.allocate(a(i2));
                if (z5) {
                    byte[] bArr3 = new byte[4];
                    byteBuffer2.get(bArr3);
                    for (int i5 = 0; i5 < i2; i5++) {
                        allocate.put((byte) (byteBuffer.get() ^ bArr3[i5 % 4]));
                    }
                } else {
                    allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                    byteBuffer2.position(allocate.limit() + byteBuffer.position());
                }
                io.hansel.visualizer.e.a.j.g a3 = io.hansel.visualizer.e.a.j.g.a(a2);
                a3.a(z);
                a3.b(z2);
                a3.c(z3);
                a3.d(z4);
                allocate.flip();
                a3.a(allocate);
                d().c(a3);
                d().b((f) a3);
                if (io.hansel.visualizer.e.a.d.t) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("afterDecoding(");
                    outline73.append(a3.c().remaining());
                    outline73.append("): {");
                    outline73.append(a3.c().remaining() > 1000 ? "too big to display" : new String(a3.c().array()));
                    outline73.append("}");
                    HSLLogger.d(outline73.toString());
                }
                a3.g();
                return a3;
            }
            throw new io.hansel.visualizer.e.a.h.a(i4);
        }
        throw new io.hansel.visualizer.e.a.h.a(2);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        io.hansel.visualizer.e.a.i.b bVar = this.f5882e;
        io.hansel.visualizer.e.a.i.b bVar2 = ((b) obj).f5882e;
        if (bVar != null) {
            z = bVar.equals(bVar2);
        } else if (bVar2 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        io.hansel.visualizer.e.a.i.b bVar = this.f5882e;
        if (bVar != null) {
            return bVar.hashCode();
        }
        return 0;
    }

    public String toString() {
        String aVar = super.toString();
        if (d() == null) {
            return aVar;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(aVar, " extension: ");
        outline78.append(d().toString());
        return outline78.toString();
    }
}
