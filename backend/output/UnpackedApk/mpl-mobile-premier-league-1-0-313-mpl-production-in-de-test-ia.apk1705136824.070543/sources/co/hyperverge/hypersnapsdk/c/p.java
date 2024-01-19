package co.hyperverge.hypersnapsdk.c;

import android.graphics.Bitmap;
import co.hyperverge.facedetection.HVFace;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SaveBitmapAsync */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3133a = p.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f3134b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f3135c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3136d;

    /* renamed from: e  reason: collision with root package name */
    public String f3137e;

    /* renamed from: f  reason: collision with root package name */
    public String f3138f;
    public a g;
    public co.hyperverge.hypersnapsdk.c.e.a h;
    public HVFaceConfig i;
    public List<Integer> j = new ArrayList();

    /* compiled from: SaveBitmapAsync */
    public interface a {
    }

    public p(byte[] bArr, byte[] bArr2, String str, co.hyperverge.hypersnapsdk.c.e.a aVar, String str2, HVFaceConfig hVFaceConfig, a aVar2) {
        this.f3135c = bArr;
        this.f3137e = str;
        this.f3138f = str2;
        this.g = aVar2;
        this.h = aVar;
        this.i = hVFaceConfig;
        this.f3136d = bArr2;
    }

    public Bitmap a(Bitmap bitmap) {
        if (this.h == null) {
            return null;
        }
        try {
            HVFace hVFace = new HVFace("", this.f3137e);
            List<Float> list = this.h.f3099a;
            hVFace.setFaceLocation(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue());
            Bitmap a2 = g.a(bitmap, hVFace, this.i);
            this.j = g.a(hVFace, bitmap);
            return a2;
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i == null) {
                return null;
            }
            n.m().i.a(e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0172 A[Catch:{ Exception -> 0x0177 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            byte[] r0 = r13.f3135c
            int r0 = androidx.core.widget.CompoundButtonCompat.getOrientation(r0)
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r1 = r13.i
            boolean r1 = r1.getShouldUseBackCamera()
            if (r1 == 0) goto L_0x0012
            int r0 = co.hyperverge.hypersnapsdk.f.i.a(r0)
        L_0x0012:
            byte[] r1 = r13.f3135c
            int r2 = r1.length
            r3 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r3, r2)
            r13.f3134b = r1
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            r2 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r4 = 1119092736(0x42b40000, float:90.0)
            r5 = 1127481344(0x43340000, float:180.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 0
            switch(r0) {
                case 3: goto L_0x004d;
                case 4: goto L_0x0046;
                case 5: goto L_0x003f;
                case 6: goto L_0x003b;
                case 7: goto L_0x0034;
                case 8: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x007b
        L_0x0030:
            r9.setRotate(r2)
            goto L_0x0050
        L_0x0034:
            r9.setRotate(r2)
            r9.postScale(r7, r6)
            goto L_0x0050
        L_0x003b:
            r9.setRotate(r4)
            goto L_0x0050
        L_0x003f:
            r9.setRotate(r4)
            r9.postScale(r7, r6)
            goto L_0x0050
        L_0x0046:
            r9.setRotate(r5)
            r9.postScale(r7, r6)
            goto L_0x0050
        L_0x004d:
            r9.setRotate(r5)
        L_0x0050:
            r5 = 0
            r6 = 0
            int r7 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0065 }
            int r8 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0065 }
            r10 = 1
            r4 = r1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ OutOfMemoryError -> 0x0065 }
            r1.recycle()     // Catch:{ OutOfMemoryError -> 0x0065 }
            r1 = r0
            goto L_0x007b
        L_0x0065:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            if (r1 == 0) goto L_0x007a
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            r1.a(r0)
        L_0x007a:
            r1 = r11
        L_0x007b:
            r13.f3134b = r1
            r13.f3134b = r1
            if (r1 != 0) goto L_0x008b
            co.hyperverge.hypersnapsdk.c.p$a r0 = r13.g
            java.util.List<java.lang.Integer> r1 = r13.j
            co.hyperverge.hypersnapsdk.d.a.a.d$c r0 = (co.hyperverge.hypersnapsdk.d.a.a.d.c) r0
            r0.a(r11, r1)
            return
        L_0x008b:
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            if (r0 == 0) goto L_0x00f3
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r0 = r0.w()
            if (r0 == 0) goto L_0x00f3
            co.hyperverge.hypersnapsdk.c.i r0 = co.hyperverge.hypersnapsdk.c.i.b()
            android.graphics.Bitmap r1 = r13.f3134b
            int r1 = r1.getHeight()
            android.graphics.Bitmap r2 = r13.f3134b
            int r2 = r2.getWidth()
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r0 = r0.g
            r0.imageWidth = r1
            r0.imageHeight = r2
            byte[] r0 = r13.f3136d
            if (r0 == 0) goto L_0x00f3
            android.graphics.Bitmap r1 = r13.f3134b
            int r2 = r0.length     // Catch:{ Exception -> 0x00de }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r3, r2)     // Catch:{ Exception -> 0x00de }
            int r2 = r0.getWidth()     // Catch:{ Exception -> 0x00de }
            int r4 = r0.getHeight()     // Catch:{ Exception -> 0x00de }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r2, r4, r3)     // Catch:{ Exception -> 0x00de }
            co.hyperverge.hypersnapsdk.c.i r2 = co.hyperverge.hypersnapsdk.c.i.b()     // Catch:{ Exception -> 0x00de }
            if (r2 == 0) goto L_0x00dd
            co.hyperverge.hypersnapsdk.f.j.b r3 = co.hyperverge.hypersnapsdk.f.j.b.a()     // Catch:{ Exception -> 0x00de }
            co.hyperverge.hypersnapsdk.c.-$$Lambda$i$BveHYOo1exCWgXFR_dKyLpGIEvc r4 = new co.hyperverge.hypersnapsdk.c.-$$Lambda$i$BveHYOo1exCWgXFR_dKyLpGIEvc     // Catch:{ Exception -> 0x00de }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x00de }
            java.util.concurrent.ThreadPoolExecutor r0 = r3.f3189d     // Catch:{ Exception -> 0x00de }
            r0.submit(r4)     // Catch:{ Exception -> 0x00de }
            goto L_0x00f3
        L_0x00dd:
            throw r11     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            if (r1 == 0) goto L_0x00f3
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            r1.a(r0)
        L_0x00f3:
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r1 = r13.f3137e     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r2 = r13.f3138f     // Catch:{ IOException -> 0x01b5 }
            r0.<init>(r1, r2)     // Catch:{ IOException -> 0x01b5 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x01b5 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01b5 }
            android.graphics.Bitmap r0 = r13.f3134b     // Catch:{ IOException -> 0x01b5 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x01b5 }
            r3 = 90
            r0.compress(r2, r3, r1)     // Catch:{ IOException -> 0x01b5 }
            r1.close()     // Catch:{ IOException -> 0x01b5 }
            android.graphics.Bitmap r0 = r13.f3134b     // Catch:{ IOException -> 0x01b5 }
            android.graphics.Bitmap r0 = r13.a(r0)     // Catch:{ IOException -> 0x01b5 }
            if (r0 == 0) goto L_0x01ab
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r2 = r13.f3137e     // Catch:{ IOException -> 0x01b5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01b5 }
            r4.<init>()     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r5 = "FD_crop_"
            r4.append(r5)     // Catch:{ IOException -> 0x01b5 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x01b5 }
            r4.append(r5)     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r5 = ".jpg"
            r4.append(r5)     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x01b5 }
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x01b5 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x01b5 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01b5 }
            int r4 = r0.getWidth()     // Catch:{ IOException -> 0x01b5 }
            int r5 = r0.getHeight()     // Catch:{ IOException -> 0x01b5 }
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 <= r6) goto L_0x014b
            int r7 = r5 * 300
            int r7 = r7 / r4
            goto L_0x014d
        L_0x014b:
            r6 = r4
            r7 = r5
        L_0x014d:
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x01b5 }
            r8.<init>()     // Catch:{ IOException -> 0x01b5 }
            r9 = 1
            if (r5 > r7) goto L_0x015a
            if (r4 <= r6) goto L_0x0158
            goto L_0x015a
        L_0x0158:
            r10 = 1
            goto L_0x016a
        L_0x015a:
            int r5 = r5 / 2
            int r4 = r4 / 2
            r10 = 1
        L_0x015f:
            int r12 = r5 / r10
            if (r12 <= r7) goto L_0x016a
            int r12 = r4 / r10
            if (r12 <= r6) goto L_0x016a
            int r10 = r10 * 2
            goto L_0x015f
        L_0x016a:
            r8.inSampleSize = r10     // Catch:{ IOException -> 0x01b5 }
            int r4 = r0.getWidth()     // Catch:{ Exception -> 0x0177 }
            if (r6 >= r4) goto L_0x0195
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r7, r9)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0195
        L_0x0177:
            r4 = move-exception
            co.hyperverge.hypersnapsdk.c.p$a r5 = r13.g     // Catch:{ IOException -> 0x01b5 }
            java.util.List<java.lang.Integer> r6 = r13.j     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.d.a.a.d$c r5 = (co.hyperverge.hypersnapsdk.d.a.a.d.c) r5
            r5.a(r11, r6)     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.f.i.a(r4)     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.c.n r5 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.service.a.b r5 = r5.i     // Catch:{ IOException -> 0x01b5 }
            if (r5 == 0) goto L_0x0195
            co.hyperverge.hypersnapsdk.c.n r5 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.service.a.b r5 = r5.i     // Catch:{ IOException -> 0x01b5 }
            r5.a(r4)     // Catch:{ IOException -> 0x01b5 }
        L_0x0195:
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x01b5 }
            r0.compress(r4, r3, r2)     // Catch:{ IOException -> 0x01b5 }
            r2.close()     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.c.p$a r0 = r13.g     // Catch:{ IOException -> 0x01b5 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x01b5 }
            java.util.List<java.lang.Integer> r2 = r13.j     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.d.a.a.d$c r0 = (co.hyperverge.hypersnapsdk.d.a.a.d.c) r0
            r0.a(r1, r2)     // Catch:{ IOException -> 0x01b5 }
            goto L_0x01d3
        L_0x01ab:
            co.hyperverge.hypersnapsdk.c.p$a r0 = r13.g     // Catch:{ IOException -> 0x01b5 }
            java.util.List<java.lang.Integer> r1 = r13.j     // Catch:{ IOException -> 0x01b5 }
            co.hyperverge.hypersnapsdk.d.a.a.d$c r0 = (co.hyperverge.hypersnapsdk.d.a.a.d.c) r0
            r0.a(r11, r1)     // Catch:{ IOException -> 0x01b5 }
            goto L_0x01d3
        L_0x01b5:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.c.p$a r1 = r13.g
            java.util.List<java.lang.Integer> r2 = r13.j
            co.hyperverge.hypersnapsdk.d.a.a.d$c r1 = (co.hyperverge.hypersnapsdk.d.a.a.d.c) r1
            r1.a(r11, r2)
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            if (r1 == 0) goto L_0x01d3
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
            r1.a(r0)
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.p.run():void");
    }
}
