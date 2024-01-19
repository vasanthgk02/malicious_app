package co.hyperverge.hypersnapsdk.c;

import android.graphics.Bitmap;
import android.graphics.Color;
import co.hyperverge.hypersnapsdk.model.ImageComparisonObj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ImageComparisonHelper */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static i f3104a;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f3105f = new AtomicBoolean(false);
    public ImageComparisonObj g = new ImageComparisonObj();
    public int h = 0;
    public byte[] j = new byte[2500];
    public byte[] k = new byte[2500];

    public static i b() {
        if (f3104a == null) {
            f3104a = new i();
        }
        return f3104a;
    }

    public double a(float f2) {
        return ((double) Math.round(((double) f2) * 100.0d)) / 100.0d;
    }

    public final void c() {
        this.g.frameDistanceValue.clear();
        this.g.frameDataLength.clear();
        this.f3105f.set(false);
        this.h = 0;
    }

    public List<Integer[]> a(Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        try {
            Integer[] numArr = new Integer[256];
            Arrays.fill(numArr, Integer.valueOf(0));
            Integer[] numArr2 = new Integer[256];
            Arrays.fill(numArr2, Integer.valueOf(0));
            Integer[] numArr3 = new Integer[256];
            Arrays.fill(numArr3, Integer.valueOf(0));
            bitmap.getWidth();
            bitmap.getHeight();
            int width = bitmap.getWidth() * bitmap.getHeight();
            int[] iArr = new int[width];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < width; i++) {
                int i2 = iArr[i];
                int red = Color.red(i2);
                int green = Color.green(i2);
                int blue = Color.blue(i2);
                Integer num = numArr[red];
                numArr[red] = Integer.valueOf(numArr[red].intValue() + 1);
                Integer num2 = numArr2[green];
                numArr2[green] = Integer.valueOf(numArr2[green].intValue() + 1);
                Integer num3 = numArr3[blue];
                numArr3[blue] = Integer.valueOf(numArr3[blue].intValue() + 1);
            }
            arrayList.add(a(numArr));
            arrayList.add(a(numArr2));
            arrayList.add(a(numArr3));
        } catch (Exception e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            e2.toString();
        }
        return arrayList;
    }

    public void b(Bitmap bitmap, Bitmap bitmap2) {
        try {
            ArrayList arrayList = (ArrayList) a(a(bitmap), a(bitmap2));
            if (!arrayList.isEmpty()) {
                this.g.redChannelDistance = ((Float) arrayList.get(0)).floatValue();
                this.g.greenChannelDistance = ((Float) arrayList.get(1)).floatValue();
                this.g.blueChannelDistance = ((Float) arrayList.get(2)).floatValue();
            }
        } catch (Exception e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            e2.toString();
        }
    }

    public float b(float f2) {
        if (f2 > 0.0f) {
            return (float) Math.sqrt((double) f2);
        }
        return 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r16 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00be, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        co.hyperverge.hypersnapsdk.f.i.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ca, code lost:
        if (co.hyperverge.hypersnapsdk.c.n.m().i != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cc, code lost:
        co.hyperverge.hypersnapsdk.c.n.m().i.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }, LOOP:2: B:24:0x0067->B:25:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap b(android.graphics.Bitmap r18) {
        /*
            r17 = this;
            r1 = 0
            int r0 = r18.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            b()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r0 = r0 / 4
            int r2 = r18.getHeight()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            b()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r2 = r2 / 4
            r3 = 0
            r4 = r18
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r4, r0, r2, r3)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r0 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r4 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            android.graphics.Bitmap$Config r5 = r2.getConfig()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            android.graphics.Bitmap r14 = android.graphics.Bitmap.createBitmap(r0, r4, r5)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            if (r14 != 0) goto L_0x002d
            return r1
        L_0x002d:
            r15 = 0
        L_0x002e:
            int r0 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            if (r15 >= r0) goto L_0x00bd
            r13 = 0
        L_0x0035:
            int r0 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            if (r13 >= r0) goto L_0x00b9
            int r0 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r4 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r12 = r0 * r4
            int[] r11 = new int[r12]     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            r6 = 0
            int r7 = r2.getWidth()     // Catch:{ Exception -> 0x005d, OutOfMemoryError -> 0x00c0 }
            r10 = 8
            r0 = 8
            r4 = r2
            r5 = r11
            r8 = r15
            r9 = r13
            r16 = r11
            r11 = r0
            r4.getPixels(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x005b, OutOfMemoryError -> 0x00c0 }
            goto L_0x0063
        L_0x005b:
            r0 = move-exception
            goto L_0x0060
        L_0x005d:
            r0 = move-exception
            r16 = r11
        L_0x0060:
            co.hyperverge.hypersnapsdk.f.i.a(r0)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
        L_0x0063:
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0067:
            if (r0 >= r12) goto L_0x007d
            r7 = r16[r0]     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r8 = android.graphics.Color.red(r7)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r4 = r4 + r8
            int r8 = android.graphics.Color.green(r7)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r5 = r5 + r8
            int r7 = android.graphics.Color.blue(r7)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r6 = r6 + r7
            int r0 = r0 + 1
            goto L_0x0067
        L_0x007d:
            int r0 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r7 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r0 = r0 * r7
            int[] r7 = new int[r0]     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            r0 = 255(0xff, float:3.57E-43)
            if (r4 < r5) goto L_0x0094
            if (r4 < r6) goto L_0x0094
            int r0 = android.graphics.Color.rgb(r0, r3, r3)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            goto L_0x00a1
        L_0x0094:
            if (r5 < r4) goto L_0x009d
            if (r5 < r6) goto L_0x009d
            int r0 = android.graphics.Color.rgb(r3, r0, r3)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            goto L_0x00a1
        L_0x009d:
            int r0 = android.graphics.Color.rgb(r3, r3, r0)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
        L_0x00a1:
            java.util.Arrays.fill(r7, r0)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            r8 = 0
            int r9 = r14.getWidth()     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            r12 = 8
            r0 = 8
            r6 = r14
            r10 = r15
            r11 = r13
            r4 = r13
            r13 = r0
            r6.setPixels(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ OutOfMemoryError -> 0x00c0, Exception -> 0x00be }
            int r13 = r4 + 8
            goto L_0x0035
        L_0x00b9:
            int r15 = r15 + 8
            goto L_0x002e
        L_0x00bd:
            return r1
        L_0x00be:
            r0 = move-exception
            goto L_0x00c1
        L_0x00c0:
            r0 = move-exception
        L_0x00c1:
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            if (r2 == 0) goto L_0x00d5
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            r2.a(r0)
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.i.b(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    public final Integer[] a(Integer[] numArr) {
        try {
            Integer[] numArr2 = new Integer[256];
            Arrays.fill(numArr2, Integer.valueOf(0));
            float floatValue = Float.valueOf((float) ((Integer) Collections.min(Arrays.asList(numArr))).intValue()).floatValue();
            float floatValue2 = Float.valueOf((float) ((Integer) Collections.max(Arrays.asList(numArr))).intValue()).floatValue();
            for (int i = 0; i < numArr.length; i++) {
                numArr2[i] = Integer.valueOf(Math.round((((((float) numArr[i].intValue()) - floatValue) * 255.0f) / (floatValue2 - floatValue)) + 0.0f));
            }
            return numArr2;
        } catch (Exception e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            e2.toString();
            return numArr;
        }
    }

    public List<Float> a(List<Integer[]> list, List<Integer[]> list2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            try {
                arrayList.add(Float.valueOf(a(list.get(i), list2.get(i))));
                i++;
            } catch (Exception e2) {
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
                e2.toString();
            }
        }
        return arrayList;
    }

    public final float a(Integer[] numArr, Integer[] numArr2) {
        int i = 0;
        float f2 = 0.0f;
        while (i < numArr.length) {
            try {
                f2 = (float) (((double) f2) + Math.pow((double) (b((float) numArr[i].intValue()) - b((float) numArr2[i].intValue())), 2.0d));
                i++;
            } catch (Exception e2) {
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
                e2.toString();
                return 0.0f;
            }
        }
        return (1.0f / b(2.0f)) * b(f2);
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        try {
            b().b(bitmap, bitmap2);
            b().b(bitmap);
            b().b(bitmap2);
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        } finally {
            this.f3105f.set(true);
        }
    }
}
