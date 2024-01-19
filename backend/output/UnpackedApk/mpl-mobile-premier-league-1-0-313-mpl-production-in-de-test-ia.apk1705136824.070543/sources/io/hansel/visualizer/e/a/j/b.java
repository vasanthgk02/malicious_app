package io.hansel.visualizer.e.a.j;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import io.hansel.visualizer.e.a.h.d;
import io.hansel.visualizer.e.a.j.f.a;
import io.hansel.visualizer.e.a.l.c;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

public class b extends d {
    public int g;
    public String h;

    public b() {
        super(a.CLOSING);
        a((String) "");
        a(1000);
    }

    private void j() {
        byte[] b2 = c.b(this.h);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.g);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(b2.length + 2);
        allocate2.put(allocate);
        allocate2.put(b2);
        allocate2.rewind();
        super.a(allocate2);
    }

    public void a(int i) {
        this.g = i;
        if (i == 1015) {
            this.g = WebSocketProtocol.CLOSE_NO_STATUS_CODE;
            this.h = "";
        }
        j();
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        this.h = str;
        j();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        throw new io.hansel.visualizer.e.a.h.c(com.mpl.androidapp.utils.Constant.REQUEST_CODE_FOR_SHORT_CUT);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            r0 = 1005(0x3ed, float:1.408E-42)
            r4.g = r0
            java.lang.String r0 = ""
            r4.h = r0
            r5.mark()
            int r0 = r5.remaining()
            if (r0 != 0) goto L_0x0016
            r5 = 1000(0x3e8, float:1.401E-42)
        L_0x0013:
            r4.g = r5
            goto L_0x006c
        L_0x0016:
            int r0 = r5.remaining()
            r1 = 1
            if (r0 != r1) goto L_0x0020
            r5 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0013
        L_0x0020:
            int r0 = r5.remaining()
            r1 = 2
            if (r0 < r1) goto L_0x0040
            r0 = 4
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
            r0.position(r1)
            short r2 = r5.getShort()
            r0.putShort(r2)
            r2 = 0
            r0.position(r2)
            int r0 = r0.getInt()
            r4.g = r0
        L_0x0040:
            r5.reset()
            r0 = 1007(0x3ef, float:1.411E-42)
            int r2 = r5.position()     // Catch:{ c -> 0x0067 }
            int r3 = r5.position()     // Catch:{ IllegalArgumentException -> 0x005d }
            int r3 = r3 + r1
            r5.position(r3)     // Catch:{ IllegalArgumentException -> 0x005d }
            java.lang.String r1 = io.hansel.visualizer.e.a.l.c.b(r5)     // Catch:{ IllegalArgumentException -> 0x005d }
            r4.h = r1     // Catch:{ IllegalArgumentException -> 0x005d }
            r5.position(r2)     // Catch:{ c -> 0x0067 }
            goto L_0x006c
        L_0x005b:
            r1 = move-exception
            goto L_0x0063
        L_0x005d:
            io.hansel.visualizer.e.a.h.c r1 = new io.hansel.visualizer.e.a.h.c     // Catch:{ all -> 0x005b }
            r1.<init>(r0)     // Catch:{ all -> 0x005b }
            throw r1     // Catch:{ all -> 0x005b }
        L_0x0063:
            r5.position(r2)     // Catch:{ c -> 0x0067 }
            throw r1     // Catch:{ c -> 0x0067 }
        L_0x0067:
            r4.g = r0
            r5 = 0
            r4.h = r5
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.e.a.j.b.a(java.nio.ByteBuffer):void");
    }

    public ByteBuffer c() {
        return this.g == 1005 ? io.hansel.visualizer.e.a.l.b.a() : super.c();
    }

    public void g() {
        super.g();
        int i = this.g;
        if (i == 1007 && this.h == null) {
            throw new io.hansel.visualizer.e.a.h.c(Constant.REQUEST_CODE_FOR_SHORT_CUT);
        } else if (i != 1005 || this.h.length() <= 0) {
            int i2 = this.g;
            if (i2 > 1011 && i2 < 3000 && i2 != 1015) {
                throw new io.hansel.visualizer.e.a.h.c(1002, (String) "Trying to send an illegal close code!");
            } else if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("closecode must not be sent over the wire: ");
                outline73.append(this.g);
                throw new d(outline73.toString());
            }
        } else {
            throw new io.hansel.visualizer.e.a.h.c(1002, (String) "A close frame must have a closecode if it has a reason");
        }
    }

    public int h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String toString() {
        return super.toString() + "code: " + this.g;
    }
}
