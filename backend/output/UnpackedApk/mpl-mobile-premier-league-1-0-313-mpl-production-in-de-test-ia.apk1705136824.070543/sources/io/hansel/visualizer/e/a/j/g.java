package io.hansel.visualizer.e.a.j;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.visualizer.e.a.l.b;
import java.nio.ByteBuffer;

public abstract class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5893a = true;

    /* renamed from: b  reason: collision with root package name */
    public io.hansel.visualizer.e.a.j.f.a f5894b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f5895c = b.a();

    /* renamed from: d  reason: collision with root package name */
    public boolean f5896d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5897e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5898f = false;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5899a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                io.hansel.visualizer.e.a.j.f$a[] r0 = io.hansel.visualizer.e.a.j.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5899a = r0
                r1 = 1
                r2 = 3
                io.hansel.visualizer.e.a.j.f$a r3 = io.hansel.visualizer.e.a.j.f.a.PING     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 4
                int[] r4 = f5899a     // Catch:{ NoSuchFieldError -> 0x0017 }
                io.hansel.visualizer.e.a.j.f$a r5 = io.hansel.visualizer.e.a.j.f.a.PONG     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = f5899a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.visualizer.e.a.j.f$a r5 = io.hansel.visualizer.e.a.j.f.a.TEXT     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = f5899a     // Catch:{ NoSuchFieldError -> 0x0023 }
                io.hansel.visualizer.e.a.j.f$a r2 = io.hansel.visualizer.e.a.j.f.a.BINARY     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1[r0] = r3     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f5899a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.hansel.visualizer.e.a.j.f$a r1 = io.hansel.visualizer.e.a.j.f.a.CLOSING     // Catch:{ NoSuchFieldError -> 0x002a }
                r1 = 5
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5899a     // Catch:{ NoSuchFieldError -> 0x0032 }
                io.hansel.visualizer.e.a.j.f$a r1 = io.hansel.visualizer.e.a.j.f.a.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0032 }
                r1 = 0
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.e.a.j.g.a.<clinit>():void");
        }
    }

    public g(io.hansel.visualizer.e.a.j.f.a aVar) {
        this.f5894b = aVar;
    }

    public static g a(io.hansel.visualizer.e.a.j.f.a aVar) {
        if (aVar != null) {
            switch (a.f5899a[aVar.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new i();
                case 3:
                    return new j();
                case 4:
                    return new a();
                case 5:
                    return new b();
                case 6:
                    return new c();
                default:
                    throw new IllegalArgumentException("Supplied opcode is invalid");
            }
        } else {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
    }

    public io.hansel.visualizer.e.a.j.f.a a() {
        return this.f5894b;
    }

    public void a(f fVar) {
        ByteBuffer c2 = fVar.c();
        if (this.f5895c == null) {
            this.f5895c = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f5895c.put(c2);
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f5895c;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f5895c;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f5895c.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.f5895c.capacity() + c2.remaining());
                this.f5895c.flip();
                allocate.put(this.f5895c);
                allocate.put(c2);
                this.f5895c = allocate;
            } else {
                this.f5895c.put(c2);
            }
            this.f5895c.rewind();
        }
        c2.reset();
        this.f5893a = fVar.f();
    }

    public void a(ByteBuffer byteBuffer) {
        this.f5895c = byteBuffer;
    }

    public void a(boolean z) {
        this.f5893a = z;
    }

    public void b(boolean z) {
        this.f5896d = z;
    }

    public boolean b() {
        return this.f5897e;
    }

    public ByteBuffer c() {
        return this.f5895c;
    }

    public void c(boolean z) {
        this.f5897e = z;
    }

    public void d(boolean z) {
        this.f5898f = z;
    }

    public boolean d() {
        return this.f5896d;
    }

    public void e(boolean z) {
    }

    public boolean e() {
        return this.f5898f;
    }

    public boolean f() {
        return this.f5893a;
    }

    public abstract void g();

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Framedata{ optcode:");
        outline73.append(a());
        outline73.append(", fin:");
        outline73.append(f());
        outline73.append(", rsv1:");
        outline73.append(d());
        outline73.append(", rsv2:");
        outline73.append(b());
        outline73.append(", rsv3:");
        outline73.append(e());
        outline73.append(", payloadlength:[pos:");
        outline73.append(this.f5895c.position());
        outline73.append(", len:");
        outline73.append(this.f5895c.remaining());
        outline73.append("], payload:");
        return GeneratedOutlineSupport.outline62(outline73, this.f5895c.remaining() > 1000 ? "(too big to display)" : new String(this.f5895c.array()), "}");
    }
}
