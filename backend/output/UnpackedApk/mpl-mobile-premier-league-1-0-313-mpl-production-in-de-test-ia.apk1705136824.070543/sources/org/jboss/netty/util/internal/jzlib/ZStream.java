package org.jboss.netty.util.internal.jzlib;

import org.jboss.netty.util.internal.jzlib.JZlib.WrapperType;

public final class ZStream {
    public long adler;
    public int avail_in;
    public int avail_out;
    public int crc32;
    public Deflate dstate;
    public Inflate istate;
    public String msg;
    public byte[] next_in;
    public int next_in_index;
    public byte[] next_out;
    public int next_out_index;
    public long total_in;
    public long total_out;

    /* renamed from: org.jboss.netty.util.internal.jzlib.ZStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType[] r0 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType = r0
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r1 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.ZLIB     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType     // Catch:{ NoSuchFieldError -> 0x0015 }
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r1 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.GZIP     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.ZStream.AnonymousClass1.<clinit>():void");
        }
    }

    public int deflate(int i) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        return deflate.deflate(this, i);
    }

    public int deflateEnd() {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        int deflateEnd = deflate.deflateEnd();
        this.dstate = null;
        return deflateEnd;
    }

    public int deflateInit(int i) {
        return deflateInit(i, 15);
    }

    public int deflateParams(int i, int i2) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        return deflate.deflateParams(this, i, i2);
    }

    public int deflateSetDictionary(byte[] bArr, int i) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        return deflate.deflateSetDictionary(this, bArr, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r3.length >= (r5 + r0)) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flush_pending() {
        /*
            r6 = this;
            org.jboss.netty.util.internal.jzlib.Deflate r0 = r6.dstate
            int r0 = r0.pending
            int r1 = r6.avail_out
            if (r0 <= r1) goto L_0x0009
            r0 = r1
        L_0x0009:
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            org.jboss.netty.util.internal.jzlib.Deflate r1 = r6.dstate
            byte[] r2 = r1.pending_buf
            int r3 = r2.length
            int r1 = r1.pending_out
            if (r3 <= r1) goto L_0x0024
            byte[] r3 = r6.next_out
            int r4 = r3.length
            int r5 = r6.next_out_index
            if (r4 <= r5) goto L_0x0024
            int r2 = r2.length
            int r1 = r1 + r0
            if (r2 < r1) goto L_0x0024
            int r1 = r3.length
            int r5 = r5 + r0
            if (r1 >= r5) goto L_0x0071
        L_0x0024:
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            org.jboss.netty.util.internal.jzlib.Deflate r3 = r6.dstate
            byte[] r3 = r3.pending_buf
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            org.jboss.netty.util.internal.jzlib.Deflate r4 = r6.dstate
            int r4 = r4.pending_out
            r2.append(r4)
            r2.append(r3)
            byte[] r4 = r6.next_out
            int r4 = r4.length
            r2.append(r4)
            r2.append(r3)
            int r4 = r6.next_out_index
            r2.append(r4)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.String r2 = "avail_out="
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            int r3 = r6.avail_out
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
        L_0x0071:
            org.jboss.netty.util.internal.jzlib.Deflate r1 = r6.dstate
            byte[] r2 = r1.pending_buf
            int r1 = r1.pending_out
            byte[] r3 = r6.next_out
            int r4 = r6.next_out_index
            java.lang.System.arraycopy(r2, r1, r3, r4, r0)
            int r1 = r6.next_out_index
            int r1 = r1 + r0
            r6.next_out_index = r1
            org.jboss.netty.util.internal.jzlib.Deflate r1 = r6.dstate
            int r2 = r1.pending_out
            int r2 = r2 + r0
            r1.pending_out = r2
            long r2 = r6.total_out
            long r4 = (long) r0
            long r2 = r2 + r4
            r6.total_out = r2
            int r2 = r6.avail_out
            int r2 = r2 - r0
            r6.avail_out = r2
            int r2 = r1.pending
            int r2 = r2 - r0
            r1.pending = r2
            if (r2 != 0) goto L_0x009f
            r0 = 0
            r1.pending_out = r0
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.ZStream.flush_pending():void");
    }

    public void free() {
        this.next_in = null;
        this.next_out = null;
        this.msg = null;
    }

    public int inflate(int i) {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflate(this, i);
    }

    public int inflateEnd() {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        int inflateEnd = inflate.inflateEnd(this);
        this.istate = null;
        return inflateEnd;
    }

    public int inflateInit() {
        return inflateInit(15);
    }

    public int inflateSetDictionary(byte[] bArr, int i) {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateSetDictionary(this, bArr, i);
    }

    public int inflateSync() {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateSync(this);
    }

    public int read_buf(byte[] bArr, int i, int i2) {
        int i3 = this.avail_in;
        if (i3 <= i2) {
            i2 = i3;
        }
        if (i2 == 0) {
            return 0;
        }
        this.avail_in -= i2;
        int ordinal = this.dstate.wrapperType.ordinal();
        if (ordinal == 1) {
            this.adler = Adler32.adler32(this.adler, this.next_in, this.next_in_index, i2);
        } else if (ordinal == 2) {
            this.crc32 = CRC32.crc32(this.crc32, this.next_in, this.next_in_index, i2);
        }
        System.arraycopy(this.next_in, this.next_in_index, bArr, i, i2);
        this.next_in_index += i2;
        this.total_in += (long) i2;
        return i2;
    }

    public int deflateInit(int i, Enum enumR) {
        return deflateInit(i, 15, enumR);
    }

    public int inflateInit(Enum<?> enumR) {
        return inflateInit(15, enumR);
    }

    public int deflateInit(int i, int i2) {
        return deflateInit(i, i2, WrapperType.ZLIB);
    }

    public int inflateInit(int i) {
        return inflateInit(i, WrapperType.ZLIB);
    }

    public int deflateInit(int i, int i2, Enum enumR) {
        Deflate deflate = new Deflate();
        this.dstate = deflate;
        return deflate.deflateInit(this, i, i2, (WrapperType) enumR);
    }

    public int inflateInit(int i, Enum enumR) {
        Inflate inflate = new Inflate();
        this.istate = inflate;
        return inflate.inflateInit(this, i, (WrapperType) enumR);
    }
}
