package co.hyperverge.hypersnapsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import co.hyperverge.facedetection.FaceDetectorApi;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hypersnapsdk.d.a.a.d;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.model.FaceDetectorObj;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CamPreviewFaceDetectionHandler */
public class b extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3066a = b.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    public static int f3067b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static b f3068c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f3069d = new Handler(getLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Handler f3070e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public int f3071f;
    public int g;
    public final float[] h;
    public co.hyperverge.hypersnapsdk.d.a.a.a i;
    public boolean j;

    /* compiled from: CamPreviewFaceDetectionHandler */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f3072a;

        /* renamed from: b  reason: collision with root package name */
        public int f3073b;

        /* renamed from: c  reason: collision with root package name */
        public int f3074c;

        /* renamed from: d  reason: collision with root package name */
        public int f3075d;

        /* renamed from: e  reason: collision with root package name */
        public int f3076e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3077f;
        public co.hyperverge.hypersnapsdk.c.e.a g;
        public ArrayList<ArrayList<Float>> h = new ArrayList<>();
        public final boolean i;

        public a(byte[] bArr, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            this.f3072a = bArr;
            this.f3073b = i2;
            this.f3074c = i3;
            this.f3075d = i4;
            this.f3076e = i5;
            this.f3077f = z;
            this.g = new co.hyperverge.hypersnapsdk.c.e.a(System.currentTimeMillis());
            this.i = z2;
        }

        public ArrayList<Float> a(ArrayList<ArrayList<Float>> arrayList) {
            ArrayList<Float> arrayList2 = arrayList.get(0);
            float floatValue = (arrayList2.get(3).floatValue() - arrayList2.get(1).floatValue()) * (arrayList2.get(4).floatValue() - arrayList2.get(0).floatValue());
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if ((next.get(3).floatValue() - next.get(1).floatValue()) * (next.get(4).floatValue() - next.get(0).floatValue()) > floatValue) {
                    floatValue = (next.get(3).floatValue() - next.get(1).floatValue()) * (next.get(4).floatValue() - next.get(0).floatValue());
                    arrayList2 = next;
                }
            }
            return arrayList2;
        }

        public void run() {
            try {
                co.hyperverge.hypersnapsdk.c.e.a a2 = e.a();
                int i2 = -1;
                if (b.this.h[0] > 0.0f) {
                    a();
                    i2 = FaceDetectorApi.getAvgIntensity(this.f3072a, this.f3073b, this.f3074c, Math.max(0, Math.round(b.this.h[0] * ((float) this.f3073b)) - 20), Math.min(this.f3073b, Math.round(b.this.h[0] * ((float) this.f3073b)) + 20), Math.max(0, Math.round(b.this.h[1] * ((float) this.f3074c)) - 20), Math.min(this.f3074c, Math.round(b.this.h[1] * ((float) this.f3074c)) + 20), false);
                    double log = Math.log(89.0d) - Math.log((double) i2);
                    if (b.this.j) {
                        if (CameraEngine.f2908a) {
                            co.hyperverge.hvcamera.magicfilter.camera.b.a(log);
                        } else {
                            co.hyperverge.hvcamera.magicfilter.camera.a.a(log);
                        }
                    }
                    b.f3067b = 0;
                    b.this.h[0] = -1.0f;
                    b.this.h[1] = -1.0f;
                } else if (a2 != null && b.f3067b % 10 == 0) {
                    byte[] bArr = this.f3072a;
                    int i3 = this.f3073b;
                    i2 = FaceDetectorApi.getAvgIntensity(bArr, i3, this.f3074c, Math.round((((float) i3) / 100.0f) * a2.f3099a.get(0).floatValue()), Math.round((((float) this.f3073b) / 100.0f) * a2.f3099a.get(2).floatValue()), Math.round((((float) this.f3074c) / 100.0f) * a2.f3099a.get(1).floatValue()), Math.round((((float) this.f3074c) / 100.0f) * a2.f3099a.get(3).floatValue()), true);
                }
                int i4 = b.f3067b + 1;
                b.f3067b = i4;
                b.f3067b = i4 % 10;
                this.h = FaceDetectorApi.detectFacesFromByteArray(this.f3072a, this.f3073b, this.f3074c, this.f3076e % RotationOptions.ROTATE_180 == 0 ? 0 : 1);
                this.g.f3101c = System.currentTimeMillis();
                b.this.f3070e.removeCallbacksAndMessages(null);
                ArrayList<ArrayList<Float>> arrayList = this.h;
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        ArrayList<Float> a3 = a(this.h);
                        if (i2 > 0 && a2 != null) {
                            if ((StrictMath.abs(((a3.get(4).floatValue() * 100.0f) + (a3.get(0).floatValue() * 100.0f)) - (a2.f3099a.get(0).floatValue() + a2.f3099a.get(2).floatValue())) * ((float) this.f3073b)) / 200.0f < 15.0f) {
                                if ((StrictMath.abs(((a3.get(3).floatValue() * 100.0f) + (a3.get(1).floatValue() * 100.0f)) - (a2.f3099a.get(1).floatValue() + a2.f3099a.get(3).floatValue())) * ((float) this.f3074c)) / 200.0f < 15.0f) {
                                    double log2 = Math.log(89.0d) - Math.log((double) i2);
                                    if (b.this.j) {
                                        if (CameraEngine.f2908a) {
                                            co.hyperverge.hvcamera.magicfilter.camera.b.a(log2);
                                        } else {
                                            co.hyperverge.hvcamera.magicfilter.camera.a.a(log2);
                                        }
                                    }
                                    b.f3067b = 1;
                                }
                            }
                        }
                        ArrayList<ArrayList<Float>> arrayList2 = this.h;
                        if (arrayList2 == null || arrayList2.size() <= 1) {
                            Handler handler = b.this.f3070e;
                            C0054b bVar = new C0054b(a3, this.f3075d, this.g, this.f3077f, this.i, null);
                            handler.post(bVar);
                            return;
                        }
                        Handler handler2 = b.this.f3070e;
                        C0054b bVar2 = new C0054b(a3, this.f3075d, this.g, this.f3077f, this.i, this.h);
                        handler2.post(bVar2);
                        return;
                    }
                }
                Handler handler3 = b.this.f3070e;
                C0054b bVar3 = new C0054b(null, this.f3075d, this.g, this.f3077f, this.i, null);
                handler3.post(bVar3);
            } catch (IllegalArgumentException e2) {
                String str = b.f3066a;
                i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }

        public void a() {
            float f2;
            float f3;
            float f4;
            float f5;
            int i2 = this.f3076e;
            if (i2 != 0) {
                if (i2 == 90) {
                    float[] fArr = b.this.h;
                    f4 = fArr[0];
                    f5 = fArr[1];
                } else if (i2 == 180) {
                    float[] fArr2 = b.this.h;
                    f4 = 1.0f - fArr2[1];
                    f5 = fArr2[0];
                } else if (i2 != 270) {
                    float[] fArr3 = b.this.h;
                    f2 = 1.0f - fArr3[0];
                    f3 = fArr3[1];
                } else {
                    float[] fArr4 = b.this.h;
                    f2 = 1.0f - fArr4[0];
                    f3 = fArr4[1];
                }
                f3 = 1.0f - f5;
                f2 = f4;
            } else {
                float[] fArr5 = b.this.h;
                float f6 = fArr5[0];
                float f7 = 1.0f - fArr5[0];
                f2 = fArr5[1];
                f3 = f7;
            }
            float[] fArr6 = b.this.h;
            fArr6[0] = f2;
            fArr6[1] = f3;
        }
    }

    /* renamed from: co.hyperverge.hypersnapsdk.c.b$b  reason: collision with other inner class name */
    /* compiled from: CamPreviewFaceDetectionHandler */
    public class C0054b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<Float> f3078a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f3079b;

        /* renamed from: c  reason: collision with root package name */
        public co.hyperverge.hypersnapsdk.c.e.a f3080c;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<ArrayList<Float>> f3081f = new ArrayList<>();

        /* renamed from: co.hyperverge.hypersnapsdk.c.b$b$a */
        /* compiled from: CamPreviewFaceDetectionHandler */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f3082a;

            public a(List list) {
                this.f3082a = list;
            }

            public void run() {
                Iterator<ArrayList<Float>> it = C0054b.this.f3081f.iterator();
                while (it.hasNext()) {
                    C0054b bVar = C0054b.this;
                    this.f3082a.add(bVar.a(bVar.f3079b, it.next()));
                }
                C0054b bVar2 = C0054b.this;
                b bVar3 = b.this;
                co.hyperverge.hypersnapsdk.d.a.a.a aVar = bVar3.i;
                if (aVar != null) {
                    FaceDetectorObj faceDetectorObj = new FaceDetectorObj(null, bVar2.f3080c, bVar3.f3071f, bVar3.g, this.f3082a);
                    ((d) aVar).a(faceDetectorObj);
                }
            }
        }

        /* renamed from: co.hyperverge.hypersnapsdk.c.b$b$b  reason: collision with other inner class name */
        /* compiled from: CamPreviewFaceDetectionHandler */
        public class C0055b implements Runnable {
            public C0055b() {
            }

            public void run() {
                float f2;
                float f3;
                ArrayList arrayList = new ArrayList();
                float floatValue = C0054b.this.f3078a.get(4).floatValue() - C0054b.this.f3078a.get(0).floatValue();
                float floatValue2 = C0054b.this.f3078a.get(5).floatValue() - C0054b.this.f3078a.get(1).floatValue();
                float f4 = floatValue * 0.35f;
                float f5 = 100.0f;
                float f6 = 0.0f;
                if ((C0054b.this.f3078a.get(0).floatValue() - f4) * 100.0f < 0.0f) {
                    f2 = 0.0f;
                } else {
                    f2 = (C0054b.this.f3078a.get(0).floatValue() - f4) * 100.0f;
                }
                float f7 = floatValue2 * 0.45f;
                if ((C0054b.this.f3078a.get(1).floatValue() - f7) * 100.0f >= 0.0f) {
                    f6 = (C0054b.this.f3078a.get(1).floatValue() - f7) * 100.0f;
                }
                if ((C0054b.this.f3078a.get(4).floatValue() + f4) * 100.0f > 100.0f) {
                    f3 = 100.0f;
                } else {
                    f3 = (C0054b.this.f3078a.get(4).floatValue() + f4) * 100.0f;
                }
                if ((C0054b.this.f3078a.get(5).floatValue() + f7) * 100.0f <= 100.0f) {
                    f5 = 100.0f * (C0054b.this.f3078a.get(5).floatValue() + f7);
                }
                arrayList.add(Float.valueOf(f2));
                arrayList.add(Float.valueOf(f6));
                arrayList.add(Float.valueOf(f3));
                arrayList.add(Float.valueOf(f5));
                co.hyperverge.hypersnapsdk.c.e.a aVar = C0054b.this.f3080c;
                aVar.f3099a = arrayList;
                e.a(aVar);
                C0054b bVar = C0054b.this;
                ArrayList<Integer> a2 = bVar.a(bVar.f3079b, bVar.f3078a);
                C0054b bVar2 = C0054b.this;
                b bVar3 = b.this;
                co.hyperverge.hypersnapsdk.d.a.a.a aVar2 = bVar3.i;
                if (aVar2 != null) {
                    FaceDetectorObj faceDetectorObj = new FaceDetectorObj(a2, bVar2.f3080c, bVar3.f3071f, bVar3.g, null);
                    ((d) aVar2).a(faceDetectorObj);
                }
            }
        }

        public C0054b(ArrayList<Float> arrayList, int i, co.hyperverge.hypersnapsdk.c.e.a aVar, boolean z, boolean z2, ArrayList<ArrayList<Float>> arrayList2) {
            this.f3078a = arrayList;
            this.f3079b = i;
            this.f3080c = aVar;
            this.f3081f = arrayList2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0188  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0191  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x019b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ArrayList<java.lang.Integer> a(int r22, java.util.ArrayList<java.lang.Float> r23) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
                r2 = r23
                r5 = 4598175219545276416(0x3fd0000000000000, double:0.25)
                r7 = 5
                r8 = 2
                r9 = 4
                r10 = 1
                r11 = 0
                r12 = 3
                if (r1 != 0) goto L_0x0056
                java.lang.Object r1 = r2.get(r11)
                java.lang.Float r1 = (java.lang.Float) r1
                float r1 = r1.floatValue()
                co.hyperverge.hypersnapsdk.c.b r13 = co.hyperverge.hypersnapsdk.c.b.this
                int r13 = r13.f3071f
                float r13 = (float) r13
                float r1 = r1 * r13
                int r1 = (int) r1
                java.lang.Object r13 = r2.get(r10)
                java.lang.Float r13 = (java.lang.Float) r13
                float r13 = r13.floatValue()
                co.hyperverge.hypersnapsdk.c.b r14 = co.hyperverge.hypersnapsdk.c.b.this
                int r14 = r14.g
                float r14 = (float) r14
                float r13 = r13 * r14
                int r13 = (int) r13
                java.lang.Object r14 = r2.get(r9)
                java.lang.Float r14 = (java.lang.Float) r14
                float r14 = r14.floatValue()
                co.hyperverge.hypersnapsdk.c.b r15 = co.hyperverge.hypersnapsdk.c.b.this
                int r15 = r15.f3071f
                float r15 = (float) r15
                float r14 = r14 * r15
                int r14 = (int) r14
                java.lang.Object r2 = r2.get(r7)
                java.lang.Float r2 = (java.lang.Float) r2
                float r2 = r2.floatValue()
                co.hyperverge.hypersnapsdk.c.b r7 = co.hyperverge.hypersnapsdk.c.b.this
                int r7 = r7.g
                goto L_0x00f8
            L_0x0056:
                r13 = 90
                r14 = 6
                r15 = 7
                r16 = 1065353216(0x3f800000, float:1.0)
                if (r1 != r13) goto L_0x00a8
                java.lang.Object r1 = r2.get(r15)
                java.lang.Float r1 = (java.lang.Float) r1
                float r1 = r1.floatValue()
                co.hyperverge.hypersnapsdk.c.b r7 = co.hyperverge.hypersnapsdk.c.b.this
                int r7 = r7.f3071f
                float r7 = (float) r7
                float r1 = r1 * r7
                int r1 = (int) r1
                java.lang.Object r7 = r2.get(r14)
                java.lang.Float r7 = (java.lang.Float) r7
                float r7 = r7.floatValue()
                float r7 = r16 - r7
                co.hyperverge.hypersnapsdk.c.b r13 = co.hyperverge.hypersnapsdk.c.b.this
                int r13 = r13.g
                float r13 = (float) r13
                float r7 = r7 * r13
                int r7 = (int) r7
                java.lang.Object r13 = r2.get(r12)
                java.lang.Float r13 = (java.lang.Float) r13
                float r13 = r13.floatValue()
                co.hyperverge.hypersnapsdk.c.b r14 = co.hyperverge.hypersnapsdk.c.b.this
                int r14 = r14.f3071f
                float r14 = (float) r14
                float r13 = r13 * r14
                int r13 = (int) r13
                java.lang.Object r2 = r2.get(r8)
                java.lang.Float r2 = (java.lang.Float) r2
                float r2 = r2.floatValue()
                float r16 = r16 - r2
                co.hyperverge.hypersnapsdk.c.b r2 = co.hyperverge.hypersnapsdk.c.b.this
                int r2 = r2.g
                goto L_0x015a
            L_0x00a8:
                r13 = 180(0xb4, float:2.52E-43)
                if (r1 != r13) goto L_0x0112
                java.lang.Object r1 = r2.get(r9)
                java.lang.Float r1 = (java.lang.Float) r1
                float r1 = r1.floatValue()
                float r1 = r16 - r1
                co.hyperverge.hypersnapsdk.c.b r13 = co.hyperverge.hypersnapsdk.c.b.this
                int r13 = r13.f3071f
                float r13 = (float) r13
                float r1 = r1 * r13
                int r1 = (int) r1
                java.lang.Object r7 = r2.get(r7)
                java.lang.Float r7 = (java.lang.Float) r7
                float r7 = r7.floatValue()
                float r7 = r16 - r7
                co.hyperverge.hypersnapsdk.c.b r13 = co.hyperverge.hypersnapsdk.c.b.this
                int r13 = r13.g
                float r13 = (float) r13
                float r7 = r7 * r13
                int r13 = (int) r7
                java.lang.Object r7 = r2.get(r11)
                java.lang.Float r7 = (java.lang.Float) r7
                float r7 = r7.floatValue()
                float r7 = r16 - r7
                co.hyperverge.hypersnapsdk.c.b r14 = co.hyperverge.hypersnapsdk.c.b.this
                int r14 = r14.f3071f
                float r14 = (float) r14
                float r7 = r7 * r14
                int r14 = (int) r7
                java.lang.Object r2 = r2.get(r10)
                java.lang.Float r2 = (java.lang.Float) r2
                float r2 = r2.floatValue()
                float r2 = r16 - r2
                co.hyperverge.hypersnapsdk.c.b r7 = co.hyperverge.hypersnapsdk.c.b.this
                int r7 = r7.g
            L_0x00f8:
                float r7 = (float) r7
                float r2 = r2 * r7
                int r2 = (int) r2
                int r7 = r14 - r1
                float r7 = (float) r7
                int r15 = r2 - r13
                float r15 = (float) r15
                double r10 = (double) r1
                double r3 = (double) r7
                double r3 = r3 * r5
                double r10 = r10 - r3
                int r1 = (int) r10
                double r5 = (double) r13
                double r10 = (double) r15
                r13 = r14
                r14 = r3
                r3 = 4599976659396224614(0x3fd6666666666666, double:0.35)
                goto L_0x0177
            L_0x0112:
                java.lang.Object r1 = r2.get(r12)
                java.lang.Float r1 = (java.lang.Float) r1
                float r1 = r1.floatValue()
                float r1 = r16 - r1
                co.hyperverge.hypersnapsdk.c.b r3 = co.hyperverge.hypersnapsdk.c.b.this
                int r3 = r3.f3071f
                float r3 = (float) r3
                float r1 = r1 * r3
                int r1 = (int) r1
                java.lang.Object r3 = r2.get(r8)
                java.lang.Float r3 = (java.lang.Float) r3
                float r3 = r3.floatValue()
                co.hyperverge.hypersnapsdk.c.b r4 = co.hyperverge.hypersnapsdk.c.b.this
                int r4 = r4.g
                float r4 = (float) r4
                float r3 = r3 * r4
                int r7 = (int) r3
                java.lang.Object r3 = r2.get(r15)
                java.lang.Float r3 = (java.lang.Float) r3
                float r3 = r3.floatValue()
                float r16 = r16 - r3
                co.hyperverge.hypersnapsdk.c.b r3 = co.hyperverge.hypersnapsdk.c.b.this
                int r3 = r3.f3071f
                float r3 = (float) r3
                float r3 = r3 * r16
                int r13 = (int) r3
                java.lang.Object r2 = r2.get(r14)
                java.lang.Float r2 = (java.lang.Float) r2
                float r16 = r2.floatValue()
                co.hyperverge.hypersnapsdk.c.b r2 = co.hyperverge.hypersnapsdk.c.b.this
                int r2 = r2.g
            L_0x015a:
                float r2 = (float) r2
                float r2 = r2 * r16
                int r2 = (int) r2
                int r3 = r13 - r1
                float r3 = (float) r3
                int r4 = r2 - r7
                float r4 = (float) r4
                double r10 = (double) r1
                double r14 = (double) r3
                r17 = 4599976659396224614(0x3fd6666666666666, double:0.35)
                double r14 = r14 * r17
                double r10 = r10 - r14
                int r1 = (int) r10
                double r10 = (double) r7
                double r3 = (double) r4
                r19 = r5
                r5 = r10
                r10 = r3
                r3 = r19
            L_0x0177:
                double r10 = r10 * r3
                double r5 = r5 - r10
                int r3 = (int) r5
                double r4 = (double) r13
                double r4 = r4 + r14
                int r4 = (int) r4
                double r5 = (double) r2
                double r5 = r5 + r10
                int r2 = (int) r5
                if (r1 <= 0) goto L_0x0184
                goto L_0x0185
            L_0x0184:
                r1 = 0
            L_0x0185:
                if (r3 <= 0) goto L_0x0188
                goto L_0x0189
            L_0x0188:
                r3 = 0
            L_0x0189:
                co.hyperverge.hypersnapsdk.c.b r5 = co.hyperverge.hypersnapsdk.c.b.this
                int r5 = r5.g
                int r6 = r5 + -3
                if (r2 <= r6) goto L_0x0193
                int r2 = r5 + -3
            L_0x0193:
                co.hyperverge.hypersnapsdk.c.b r5 = co.hyperverge.hypersnapsdk.c.b.this
                int r5 = r5.f3071f
                int r6 = r5 + -3
                if (r4 <= r6) goto L_0x019d
                int r4 = r5 + -3
            L_0x019d:
                java.util.ArrayList r5 = new java.util.ArrayList
                java.lang.Integer[] r6 = new java.lang.Integer[r9]
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r7 = 0
                r6[r7] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
                r3 = 1
                r6[r3] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
                r6[r8] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r6[r12] = r1
                java.util.List r1 = java.util.Arrays.asList(r6)
                r5.<init>(r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.b.C0054b.a(int, java.util.ArrayList):java.util.ArrayList");
        }

        public void run() {
            if (this.f3078a == null) {
                co.hyperverge.hypersnapsdk.d.a.a.a aVar = b.this.i;
                if (aVar != null) {
                    FaceDetectorObj faceDetectorObj = new FaceDetectorObj(null, null, 0, 0, null);
                    ((d) aVar).a(faceDetectorObj);
                }
            } else if (this.f3081f != null) {
                new Handler(Looper.getMainLooper()).post(new a(new ArrayList()));
            } else {
                new Handler(Looper.getMainLooper()).post(new C0055b());
            }
        }
    }

    public b(co.hyperverge.hypersnapsdk.d.a.a.a aVar) {
        super("FaceHandler");
        float[] fArr = new float[2];
        this.h = fArr;
        start();
        this.i = aVar;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
    }
}
