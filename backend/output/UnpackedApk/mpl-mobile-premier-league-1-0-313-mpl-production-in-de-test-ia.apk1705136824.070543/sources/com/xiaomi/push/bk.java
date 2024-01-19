package com.xiaomi.push;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.au.b;
import com.xiaomi.push.au.f;
import com.xiaomi.push.service.az;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

public class bk {

    /* renamed from: a  reason: collision with root package name */
    public bn f4495a;

    /* renamed from: a  reason: collision with other field name */
    public bp f357a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f358a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f359a = ByteBuffer.allocate(2048);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f360a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f361a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f362a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f4496b = ByteBuffer.allocate(4);

    public bk(InputStream inputStream, bp bpVar) {
        this.f358a = new BufferedInputStream(inputStream);
        this.f357a = bpVar;
        this.f4495a = new bn();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.ByteBuffer a() {
        /*
            r8 = this;
            java.nio.ByteBuffer r0 = r8.f359a
            r0.clear()
            java.nio.ByteBuffer r0 = r8.f359a
            r1 = 8
            r8.a(r0, r1)
            java.nio.ByteBuffer r0 = r8.f359a
            r1 = 0
            short r0 = r0.getShort(r1)
            java.nio.ByteBuffer r2 = r8.f359a
            r3 = 2
            short r2 = r2.getShort(r3)
            r3 = -15618(0xffffffffffffc2fe, float:NaN)
            if (r0 != r3) goto L_0x00fd
            r0 = 5
            if (r2 != r0) goto L_0x00fd
            java.nio.ByteBuffer r0 = r8.f359a
            r2 = 4
            int r0 = r0.getInt(r2)
            java.nio.ByteBuffer r3 = r8.f359a
            int r3 = r3.position()
            r4 = 32768(0x8000, float:4.5918E-41)
            if (r0 > r4) goto L_0x00f5
            int r4 = r0 + 4
            java.nio.ByteBuffer r5 = r8.f359a
            int r5 = r5.remaining()
            if (r4 <= r5) goto L_0x005a
            int r4 = r0 + 2048
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            java.nio.ByteBuffer r5 = r8.f359a
            byte[] r5 = r5.array()
            java.nio.ByteBuffer r6 = r8.f359a
            int r6 = r6.arrayOffset()
            java.nio.ByteBuffer r7 = r8.f359a
            int r7 = r7.position()
            int r7 = r7 + r6
            r4.put(r5, r1, r7)
            goto L_0x0082
        L_0x005a:
            java.nio.ByteBuffer r4 = r8.f359a
            int r4 = r4.capacity()
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 <= r5) goto L_0x0084
            r4 = 2048(0x800, float:2.87E-42)
            if (r0 >= r4) goto L_0x0084
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            java.nio.ByteBuffer r5 = r8.f359a
            byte[] r5 = r5.array()
            java.nio.ByteBuffer r6 = r8.f359a
            int r6 = r6.arrayOffset()
            java.nio.ByteBuffer r7 = r8.f359a
            int r7 = r7.position()
            int r7 = r7 + r6
            r4.put(r5, r1, r7)
        L_0x0082:
            r8.f359a = r4
        L_0x0084:
            java.nio.ByteBuffer r4 = r8.f359a
            r8.a(r4, r0)
            java.nio.ByteBuffer r4 = r8.f4496b
            r4.clear()
            java.nio.ByteBuffer r4 = r8.f4496b
            r8.a(r4, r2)
            java.nio.ByteBuffer r2 = r8.f4496b
            r2.position(r1)
            java.nio.ByteBuffer r2 = r8.f4496b
            int r2 = r2.getInt()
            java.util.zip.Adler32 r4 = r8.f360a
            r4.reset()
            java.util.zip.Adler32 r4 = r8.f360a
            java.nio.ByteBuffer r5 = r8.f359a
            byte[] r5 = r5.array()
            java.nio.ByteBuffer r6 = r8.f359a
            int r6 = r6.position()
            r4.update(r5, r1, r6)
            java.util.zip.Adler32 r1 = r8.f360a
            long r4 = r1.getValue()
            int r1 = (int) r4
            if (r2 != r1) goto L_0x00ce
            byte[] r1 = r8.f362a
            if (r1 == 0) goto L_0x00cb
            java.nio.ByteBuffer r2 = r8.f359a
            byte[] r2 = r2.array()
            r4 = 1
            com.xiaomi.push.service.bh.a(r1, r2, r4, r3, r0)
        L_0x00cb:
            java.nio.ByteBuffer r0 = r8.f359a
            return r0
        L_0x00ce:
            java.lang.String r0 = "CRC = "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.util.zip.Adler32 r1 = r8.f360a
            long r3 = r1.getValue()
            int r1 = (int) r3
            r0.append(r1)
            java.lang.String r1 = " and "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Corrupted Blob bad CRC"
            r0.<init>(r1)
            throw r0
        L_0x00f5:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Blob size too large"
            r0.<init>(r1)
            throw r0
        L_0x00fd:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Malformed Input"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bk.a():java.nio.ByteBuffer");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f358a.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        bi a2;
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f361a = false;
        bi a3 = a();
        if ("CONN".equals(a3.a())) {
            f a4 = f.a(a3.a());
            if (a4.a()) {
                this.f357a.a(a4.a());
                z = true;
            }
            if (a4.c()) {
                b a5 = a4.a();
                bi biVar = new bi();
                biVar.a((String) "SYNC", (String) "CONF");
                biVar.a(a5.a(), (String) null);
                this.f357a.a(biVar);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Slim] CONN: host = ");
            outline73.append(a4.b());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
        if (z) {
            this.f362a = this.f357a.a();
            while (!this.f361a) {
                a2 = a();
                this.f357a.c();
                short a6 = a2.a();
                if (a6 != 1) {
                    if (a6 != 2) {
                        if (a6 != 3) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("[Slim] unknow blob type ");
                            outline732.append(a2.a());
                            str = outline732.toString();
                        } else {
                            try {
                                this.f357a.b(this.f4495a.a(a2.a(), this.f357a));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                            }
                        }
                    } else if ("SECMSG".equals(a2.a()) && ((a2.a() == 2 || a2.a() == 3) && TextUtils.isEmpty(a2.b()))) {
                        try {
                            this.f357a.b(this.f4495a.a(a2.a(az.a().a(Integer.valueOf(a2.a()).toString(), a2.g()).h), this.f357a));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(str);
                }
                this.f357a.a(a2);
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
        sb.append("[Slim] Parse packet from Blob chid=");
        sb.append(a2.a());
        sb.append("; Id=");
        sb.append(a2.e());
        sb.append(" failure:");
        str = GeneratedOutlineSupport.outline39(e, sb);
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.bi m525a() {
        /*
            r6 = this;
            r0 = 0
            java.nio.ByteBuffer r1 = r6.a()     // Catch:{ IOException -> 0x0056 }
            int r2 = r1.position()     // Catch:{ IOException -> 0x0056 }
            r1.flip()     // Catch:{ IOException -> 0x0054 }
            r3 = 8
            r1.position(r3)     // Catch:{ IOException -> 0x0054 }
            if (r2 != r3) goto L_0x0019
            com.xiaomi.push.bo r1 = new com.xiaomi.push.bo     // Catch:{ IOException -> 0x0054 }
            r1.<init>()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0021
        L_0x0019:
            java.nio.ByteBuffer r1 = r1.slice()     // Catch:{ IOException -> 0x0054 }
            com.xiaomi.push.bi r1 = com.xiaomi.push.bi.a(r1)     // Catch:{ IOException -> 0x0054 }
        L_0x0021:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054 }
            r3.<init>()     // Catch:{ IOException -> 0x0054 }
            java.lang.String r4 = "[Slim] Read {cmd="
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r4 = r1.a()     // Catch:{ IOException -> 0x0054 }
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r4 = ";chid="
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            int r4 = r1.a()     // Catch:{ IOException -> 0x0054 }
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r4 = ";len="
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            r3.append(r2)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r4 = "}"
            r3.append(r4)     // Catch:{ IOException -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0054 }
            com.xiaomi.channel.commonutils.logger.b.c(r3)     // Catch:{ IOException -> 0x0054 }
            return r1
        L_0x0054:
            r1 = move-exception
            goto L_0x0058
        L_0x0056:
            r1 = move-exception
            r2 = 0
        L_0x0058:
            if (r2 != 0) goto L_0x0060
            java.nio.ByteBuffer r2 = r6.f359a
            int r2 = r2.position()
        L_0x0060:
            java.lang.String r3 = "[Slim] read Blob ["
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.nio.ByteBuffer r4 = r6.f359a
            byte[] r4 = r4.array()
            r5 = 128(0x80, float:1.8E-43)
            if (r2 <= r5) goto L_0x0072
            r2 = 128(0x80, float:1.8E-43)
        L_0x0072:
            java.lang.String r0 = com.xiaomi.push.m.a(r4, r0, r2)
            r3.append(r0)
            java.lang.String r0 = "] Err:"
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bk.m525a():com.xiaomi.push.bi");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m526a() {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f361a) {
                throw e2;
            }
        }
    }

    public void b() {
        this.f361a = true;
    }
}
