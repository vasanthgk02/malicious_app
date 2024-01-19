package io.hansel.visualizer.e.a.g;

import io.hansel.visualizer.e.a.b.C0091b;
import io.hansel.visualizer.e.a.d;
import io.hansel.visualizer.e.a.j.f;
import io.hansel.visualizer.e.a.k.h;
import io.hansel.visualizer.e.a.k.i;
import io.hansel.visualizer.e.a.l.c;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;

public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f5871b = c.b((String) "<policy-file-request/>\u0000");

    /* renamed from: a  reason: collision with root package name */
    public C0091b f5872a = null;

    /* renamed from: io.hansel.visualizer.e.a.g.a$a  reason: collision with other inner class name */
    public enum C0093a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.visualizer.e.a.k.c a(java.nio.ByteBuffer r8, io.hansel.visualizer.e.a.b.C0091b r9) {
        /*
            java.lang.String r0 = b(r8)
            if (r0 == 0) goto L_0x009f
            java.lang.String r1 = " "
            r2 = 3
            java.lang.String[] r0 = r0.split(r1, r2)
            int r1 = r0.length
            if (r1 != r2) goto L_0x0099
            io.hansel.visualizer.e.a.b$b r1 = io.hansel.visualizer.e.a.b.C0091b.CLIENT
            r2 = 2
            r3 = 1
            if (r9 != r1) goto L_0x002a
            io.hansel.visualizer.e.a.k.e r9 = new io.hansel.visualizer.e.a.k.e
            r9.<init>()
            r1 = r0[r3]
            short r1 = java.lang.Short.parseShort(r1)
            r9.a(r1)
            r0 = r0[r2]
            r9.d(r0)
            goto L_0x0034
        L_0x002a:
            io.hansel.visualizer.e.a.k.d r9 = new io.hansel.visualizer.e.a.k.d
            r9.<init>()
            r0 = r0[r3]
            r9.b(r0)
        L_0x0034:
            java.lang.String r0 = b(r8)
            if (r0 == 0) goto L_0x0090
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0090
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1, r2)
            int r1 = r0.length
            if (r1 != r2) goto L_0x0088
            r1 = 0
            r4 = r0[r1]
            boolean r4 = r9.a(r4)
            java.lang.String r5 = ""
            java.lang.String r6 = "^ +"
            if (r4 == 0) goto L_0x007c
            r4 = r0[r1]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r1 = r0[r1]
            java.lang.String r1 = r9.c(r1)
            r7.append(r1)
            java.lang.String r1 = "; "
            r7.append(r1)
            r0 = r0[r3]
            java.lang.String r0 = r0.replaceFirst(r6, r5)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r9.a(r4, r0)
            goto L_0x0034
        L_0x007c:
            r1 = r0[r1]
            r0 = r0[r3]
            java.lang.String r0 = r0.replaceFirst(r6, r5)
            r9.a(r1, r0)
            goto L_0x0034
        L_0x0088:
            io.hansel.visualizer.e.a.h.e r8 = new io.hansel.visualizer.e.a.h.e
            java.lang.String r9 = "not an http header"
            r8.<init>(r9)
            throw r8
        L_0x0090:
            if (r0 == 0) goto L_0x0093
            return r9
        L_0x0093:
            io.hansel.visualizer.e.a.h.b r8 = new io.hansel.visualizer.e.a.h.b
            r8.<init>()
            throw r8
        L_0x0099:
            io.hansel.visualizer.e.a.h.e r8 = new io.hansel.visualizer.e.a.h.e
            r8.<init>()
            throw r8
        L_0x009f:
            io.hansel.visualizer.e.a.h.b r9 = new io.hansel.visualizer.e.a.h.b
            int r8 = r8.capacity()
            int r8 = r8 + 128
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.e.a.g.a.a(java.nio.ByteBuffer, io.hansel.visualizer.e.a.b$b):io.hansel.visualizer.e.a.k.c");
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = BaseParser.ASCII_ZERO;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer a2 = a(byteBuffer);
        if (a2 == null) {
            return null;
        }
        return c.a(a2.array(), 0, a2.limit());
    }

    public int a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Negative count");
    }

    public abstract b a(io.hansel.visualizer.e.a.k.a aVar);

    public abstract b a(io.hansel.visualizer.e.a.k.a aVar, h hVar);

    public abstract a a();

    public abstract io.hansel.visualizer.e.a.k.b a(io.hansel.visualizer.e.a.k.b bVar);

    public abstract io.hansel.visualizer.e.a.k.c a(io.hansel.visualizer.e.a.k.a aVar, i iVar);

    public abstract ByteBuffer a(f fVar);

    public List<ByteBuffer> a(io.hansel.visualizer.e.a.k.f fVar, C0091b bVar) {
        return a(fVar, bVar, true);
    }

    public List<ByteBuffer> a(io.hansel.visualizer.e.a.k.f fVar, C0091b bVar, boolean z) {
        String b2;
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof io.hansel.visualizer.e.a.k.a) {
            sb.append("GET ");
            sb.append(((io.hansel.visualizer.e.a.k.a) fVar).a());
            b2 = " HTTP/1.1";
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 ");
            b2 = ((h) fVar).b();
        } else {
            throw new RuntimeException("unknown role");
        }
        sb.append(b2);
        sb.append("\r\n");
        Iterator<String> c2 = fVar.c();
        while (c2.hasNext()) {
            String next = c2.next();
            String c3 = fVar.c(next);
            sb.append(next);
            sb.append(": ");
            sb.append(c3);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a2 = c.a(sb.toString());
        byte[] d2 = z ? fVar.d() : null;
        ByteBuffer allocate = ByteBuffer.allocate((d2 == null ? 0 : d2.length) + a2.length);
        allocate.put(a2);
        if (d2 != null) {
            allocate.put(d2);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public abstract List<f> a(String str, boolean z);

    public void a(C0091b bVar) {
        this.f5872a = bVar;
    }

    public abstract void a(d dVar, f fVar);

    public boolean a(io.hansel.visualizer.e.a.k.f fVar) {
        return fVar.c("Upgrade").equalsIgnoreCase(WebSocketHandshake.HTTP_HEADER_UPGRADE_WEBSOCKET) && fVar.c("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int b(io.hansel.visualizer.e.a.k.f fVar) {
        String c2 = fVar.c("Sec-WebSocket-Version");
        if (c2.length() > 0) {
            try {
                return new Integer(c2.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract C0093a b();

    public abstract List<f> c(ByteBuffer byteBuffer);

    public abstract void c();

    public io.hansel.visualizer.e.a.k.f d(ByteBuffer byteBuffer) {
        return a(byteBuffer, this.f5872a);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
