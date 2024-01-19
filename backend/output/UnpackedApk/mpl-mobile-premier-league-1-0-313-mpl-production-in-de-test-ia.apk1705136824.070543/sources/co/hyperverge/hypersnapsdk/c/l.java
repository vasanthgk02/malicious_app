package co.hyperverge.hypersnapsdk.c;

import android.graphics.Rect;
import co.hyperverge.facedetection.FaceDetectorApi;
import co.hyperverge.hypersnapsdk.d.a.a.d;
import co.hyperverge.hypersnapsdk.model.CameraProperties;
import co.hyperverge.hypersnapsdk.model.FaceDetectorObj;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: MLKitFaceHelper */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static l f3112a;

    /* renamed from: b  reason: collision with root package name */
    public FaceDetector f3113b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3114c = false;

    /* renamed from: e  reason: collision with root package name */
    public List<ArrayList<Integer>> f3115e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ArrayList<Float>> f3116f;
    public ExecutorService g;
    public co.hyperverge.hypersnapsdk.c.e.a h;

    /* compiled from: MLKitFaceHelper */
    public class a implements Callable<ArrayList<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f3117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraProperties f3118b;

        public a(byte[] bArr, CameraProperties cameraProperties) {
            this.f3117a = bArr;
            this.f3118b = cameraProperties;
        }

        public Object call() throws Exception {
            ArrayList arrayList;
            l.this.f3115e = new ArrayList();
            l lVar = l.this;
            byte[] bArr = this.f3117a;
            CameraProperties cameraProperties = this.f3118b;
            lVar.f3116f = FaceDetectorApi.detectFacesFromByteArray(bArr, cameraProperties.width, cameraProperties.height, cameraProperties.rotation % RotationOptions.ROTATE_180 == 0 ? 0 : 1);
            try {
                ArrayList<ArrayList<Float>> arrayList2 = l.this.f3116f;
                if (arrayList2 != null && arrayList2.size() > 1) {
                    Iterator<ArrayList<Float>> it = l.this.f3116f.iterator();
                    while (it.hasNext()) {
                        l.this.f3115e.add(l.this.a(this.f3118b.orientation, it.next(), this.f3118b));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            l lVar2 = l.this;
            ArrayList<ArrayList<Float>> arrayList3 = lVar2.f3116f;
            CameraProperties cameraProperties2 = this.f3118b;
            if (arrayList3.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = arrayList3.get(0);
                float floatValue = (((Float) arrayList.get(3)).floatValue() - ((Float) arrayList.get(1)).floatValue()) * (((Float) arrayList.get(4)).floatValue() - ((Float) arrayList.get(0)).floatValue());
                Iterator<ArrayList<Float>> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    ArrayList next = it2.next();
                    if ((((Float) next.get(3)).floatValue() - ((Float) next.get(1)).floatValue()) * (((Float) next.get(4)).floatValue() - ((Float) next.get(0)).floatValue()) > floatValue) {
                        floatValue = (((Float) next.get(3)).floatValue() - ((Float) next.get(1)).floatValue()) * (((Float) next.get(4)).floatValue() - ((Float) next.get(0)).floatValue());
                        arrayList = next;
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            ArrayList arrayList4 = new ArrayList();
            float floatValue2 = ((Float) arrayList.get(5)).floatValue() - ((Float) arrayList.get(1)).floatValue();
            float floatValue3 = (((Float) arrayList.get(4)).floatValue() - ((Float) arrayList.get(0)).floatValue()) * 0.35f;
            float f2 = 100.0f;
            float f3 = 0.0f;
            float floatValue4 = (((Float) arrayList.get(0)).floatValue() - floatValue3) * 100.0f < 0.0f ? 0.0f : (((Float) arrayList.get(0)).floatValue() - floatValue3) * 100.0f;
            float f4 = floatValue2 * 0.45f;
            if ((((Float) arrayList.get(1)).floatValue() - f4) * 100.0f >= 0.0f) {
                f3 = (((Float) arrayList.get(1)).floatValue() - f4) * 100.0f;
            }
            float floatValue5 = (((Float) arrayList.get(4)).floatValue() + floatValue3) * 100.0f > 100.0f ? 100.0f : (((Float) arrayList.get(4)).floatValue() + floatValue3) * 100.0f;
            if ((((Float) arrayList.get(5)).floatValue() + f4) * 100.0f <= 100.0f) {
                f2 = 100.0f * (((Float) arrayList.get(5)).floatValue() + f4);
            }
            arrayList4.add(Float.valueOf(floatValue4));
            arrayList4.add(Float.valueOf(f3));
            arrayList4.add(Float.valueOf(floatValue5));
            arrayList4.add(Float.valueOf(f2));
            co.hyperverge.hypersnapsdk.c.e.a aVar = lVar2.h;
            aVar.f3099a = arrayList4;
            e.a(aVar);
            return lVar2.a(cameraProperties2.orientation, arrayList, cameraProperties2);
        }
    }

    /* compiled from: MLKitFaceHelper */
    public class b implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraProperties f3121b;

        public b(d dVar, CameraProperties cameraProperties) {
            this.f3120a = dVar;
            this.f3121b = cameraProperties;
        }

        public void onFailure(Exception exc) {
            l.this.f3114c = false;
            d dVar = this.f3120a;
            CameraProperties cameraProperties = this.f3121b;
            FaceDetectorObj faceDetectorObj = new FaceDetectorObj(null, null, cameraProperties.viewWidth, cameraProperties.viewHeight, null, false);
            dVar.a(faceDetectorObj);
        }
    }

    /* compiled from: MLKitFaceHelper */
    public class c implements OnSuccessListener<List<Face>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3123a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraProperties f3124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Future f3125c;

        public c(d dVar, CameraProperties cameraProperties, Future future) {
            this.f3123a = dVar;
            this.f3124b = cameraProperties;
            this.f3125c = future;
        }

        /* renamed from: a */
        public void onSuccess(List<Face> list) {
            boolean z;
            ArrayList arrayList;
            if (list.isEmpty()) {
                l.this.f3114c = false;
                d dVar = this.f3123a;
                CameraProperties cameraProperties = this.f3124b;
                FaceDetectorObj faceDetectorObj = new FaceDetectorObj(null, null, cameraProperties.viewWidth, cameraProperties.viewHeight, null, false);
                dVar.a(faceDetectorObj);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            loop0:
            while (true) {
                z = false;
                for (Face next : list) {
                    ArrayList arrayList3 = new ArrayList();
                    Rect boundingBox = next.getBoundingBox();
                    arrayList3.add(Integer.valueOf(boundingBox.left));
                    arrayList3.add(Integer.valueOf(boundingBox.top));
                    arrayList3.add(Integer.valueOf(boundingBox.right));
                    arrayList3.add(Integer.valueOf(boundingBox.bottom));
                    arrayList2.add(arrayList3);
                    float headEulerAngleY = next.getHeadEulerAngleY();
                    float headEulerAngleX = next.getHeadEulerAngleX();
                    float headEulerAngleZ = next.getHeadEulerAngleZ();
                    if (Math.abs(headEulerAngleY) <= 15.0f && Math.abs(headEulerAngleX) <= 15.0f && Math.abs(headEulerAngleZ) <= 15.0f) {
                        z = true;
                    }
                }
                break loop0;
            }
            do {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                    arrayList = null;
                }
            } while (!this.f3125c.isDone());
            arrayList = (ArrayList) this.f3125c.get();
            l.this.f3114c = false;
            if (arrayList2.size() > 1) {
                d dVar2 = this.f3123a;
                l lVar = l.this;
                co.hyperverge.hypersnapsdk.c.e.a aVar = lVar.h;
                CameraProperties cameraProperties2 = this.f3124b;
                FaceDetectorObj faceDetectorObj2 = new FaceDetectorObj(null, aVar, cameraProperties2.viewWidth, cameraProperties2.viewHeight, lVar.f3115e, z);
                dVar2.a(faceDetectorObj2);
            } else {
                d dVar3 = this.f3123a;
                co.hyperverge.hypersnapsdk.c.e.a aVar2 = l.this.h;
                CameraProperties cameraProperties3 = this.f3124b;
                FaceDetectorObj faceDetectorObj3 = new FaceDetectorObj(arrayList, aVar2, cameraProperties3.viewWidth, cameraProperties3.viewHeight, null, z);
                dVar3.a(faceDetectorObj3);
            }
        }
    }

    public l() {
        try {
            this.f3113b = FaceDetection.getClient(new Builder().setPerformanceMode(2).setLandmarkMode(2).setClassificationMode(1).build());
            new ArrayList();
            this.f3115e = new ArrayList();
            this.f3114c = false;
            this.g = Executors.newFixedThreadPool(1);
            this.h = new co.hyperverge.hypersnapsdk.c.e.a(System.currentTimeMillis());
        } catch (Exception | NoClassDefFoundError e2) {
            e2.getLocalizedMessage();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.Integer> a(int r22, java.util.ArrayList<java.lang.Float> r23, co.hyperverge.hypersnapsdk.model.CameraProperties r24) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            int r3 = r2.viewWidth
            int r4 = r2.viewHeight
            r5 = 5
            r8 = 4599976659396224614(0x3fd6666666666666, double:0.35)
            r10 = 2
            r11 = 4
            r12 = 1
            r13 = 3
            r14 = 0
            if (r0 != 0) goto L_0x0055
            java.lang.Object r0 = r1.get(r14)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r15 = r2.viewWidth
            float r15 = (float) r15
            float r0 = r0 * r15
            int r0 = (int) r0
            java.lang.Object r15 = r1.get(r12)
            java.lang.Float r15 = (java.lang.Float) r15
            float r15 = r15.floatValue()
            int r6 = r2.viewHeight
            float r6 = (float) r6
            float r15 = r15 * r6
            int r6 = (int) r15
            java.lang.Object r7 = r1.get(r11)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            int r15 = r2.viewWidth
            float r15 = (float) r15
            float r7 = r7 * r15
            int r7 = (int) r7
            java.lang.Object r1 = r1.get(r5)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            int r2 = r2.viewHeight
            goto L_0x00fe
        L_0x0055:
            r6 = 90
            r7 = 6
            r15 = 7
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r0 != r6) goto L_0x00b4
            java.lang.Object r0 = r1.get(r15)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r5 = r2.viewWidth
            float r5 = (float) r5
            float r0 = r0 * r5
            int r0 = (int) r0
            java.lang.Object r5 = r1.get(r7)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            float r5 = r18 - r5
            int r6 = r2.viewHeight
            float r6 = (float) r6
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.Object r6 = r1.get(r13)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            int r7 = r2.viewWidth
            float r7 = (float) r7
            float r6 = r6 * r7
            int r6 = (int) r6
            java.lang.Object r1 = r1.get(r10)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r18 = r18 - r1
            int r1 = r2.viewHeight
            float r1 = (float) r1
            float r1 = r1 * r18
            int r1 = (int) r1
            int r2 = r6 - r0
            float r2 = (float) r2
            int r7 = r1 - r5
            float r7 = (float) r7
            double r12 = (double) r0
            double r14 = (double) r2
            double r14 = r14 * r8
            double r12 = r12 - r14
            int r0 = (int) r12
            double r8 = (double) r5
            double r12 = (double) r7
            r2 = r6
            r6 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            goto L_0x0167
        L_0x00b4:
            r6 = 180(0xb4, float:2.52E-43)
            if (r0 != r6) goto L_0x011a
            java.lang.Object r0 = r1.get(r11)
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r0 = r18 - r0
            int r6 = r2.viewWidth
            float r6 = (float) r6
            float r0 = r0 * r6
            int r0 = (int) r0
            java.lang.Object r5 = r1.get(r5)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            float r5 = r18 - r5
            int r6 = r2.viewHeight
            float r6 = (float) r6
            float r5 = r5 * r6
            int r6 = (int) r5
            r5 = 0
            java.lang.Object r7 = r1.get(r5)
            java.lang.Float r7 = (java.lang.Float) r7
            float r5 = r7.floatValue()
            float r5 = r18 - r5
            int r7 = r2.viewWidth
            float r7 = (float) r7
            float r5 = r5 * r7
            int r7 = (int) r5
            r5 = 1
            java.lang.Object r1 = r1.get(r5)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r1 = r18 - r1
            int r2 = r2.viewHeight
        L_0x00fe:
            float r2 = (float) r2
            float r1 = r1 * r2
            int r1 = (int) r1
            int r2 = r7 - r0
            float r2 = (float) r2
            int r5 = r1 - r6
            float r5 = (float) r5
            double r12 = (double) r0
            double r14 = (double) r2
            r16 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            double r14 = r14 * r16
            double r12 = r12 - r14
            int r0 = (int) r12
            double r12 = (double) r6
            double r5 = (double) r5
            r2 = r7
            r19 = r8
            r8 = r12
            r12 = r5
            r6 = r19
            goto L_0x0167
        L_0x011a:
            r0 = 3
            r16 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            java.lang.Object r2 = r1.get(r0)
            java.lang.Float r2 = (java.lang.Float) r2
            float r0 = r2.floatValue()
            float r0 = r18 - r0
            float r2 = (float) r3
            float r0 = r0 * r2
            int r0 = (int) r0
            java.lang.Object r5 = r1.get(r10)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            float r6 = (float) r4
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.Object r12 = r1.get(r15)
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            float r18 = r18 - r12
            float r2 = r2 * r18
            int r2 = (int) r2
            java.lang.Object r1 = r1.get(r7)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r1 = r1 * r6
            int r1 = (int) r1
            int r6 = r2 - r0
            float r6 = (float) r6
            int r7 = r1 - r5
            float r7 = (float) r7
            double r12 = (double) r0
            double r14 = (double) r6
            double r14 = r14 * r8
            double r12 = r12 - r14
            int r0 = (int) r12
            double r8 = (double) r5
            double r12 = (double) r7
            r6 = r16
        L_0x0167:
            double r12 = r12 * r6
            double r8 = r8 - r12
            int r5 = (int) r8
            double r6 = (double) r2
            double r6 = r6 + r14
            int r2 = (int) r6
            double r6 = (double) r1
            double r6 = r6 + r12
            int r1 = (int) r6
            if (r0 <= 0) goto L_0x0174
            goto L_0x0175
        L_0x0174:
            r0 = 0
        L_0x0175:
            if (r5 <= 0) goto L_0x0178
            goto L_0x0179
        L_0x0178:
            r5 = 0
        L_0x0179:
            r6 = 3
            int r4 = r4 - r6
            if (r1 <= r4) goto L_0x017e
            r1 = r4
        L_0x017e:
            int r3 = r3 - r6
            if (r2 <= r3) goto L_0x0182
            r2 = r3
        L_0x0182:
            java.util.ArrayList r3 = new java.util.ArrayList
            java.lang.Integer[] r4 = new java.lang.Integer[r11]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6 = 0
            r4[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r5 = 1
            r4[r5] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r4[r10] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r1 = 3
            r4[r1] = r0
            java.util.List r0 = java.util.Arrays.asList(r4)
            r3.<init>(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.l.a(int, java.util.ArrayList, co.hyperverge.hypersnapsdk.model.CameraProperties):java.util.ArrayList");
    }

    public void a() {
        try {
            FaceDetector faceDetector = this.f3113b;
            if (faceDetector != null) {
                faceDetector.close();
                this.f3113b = null;
                f3112a = null;
            }
        } catch (Exception | NoClassDefFoundError e2) {
            e2.getLocalizedMessage();
        }
    }

    public void a(CameraProperties cameraProperties, d dVar) {
        if (!this.f3114c) {
            this.f3114c = true;
            byte[] bArr = cameraProperties.data;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            try {
                Future submit = this.g.submit(new a(copyOf, cameraProperties));
                Task process = this.f3113b.process(InputImage.fromByteArray(copyOf, 480, JpegTranscoderUtils.FULL_ROUND, 0, 17));
                c cVar = new c(dVar, cameraProperties, submit);
                zzw zzw = (zzw) process;
                if (zzw != null) {
                    zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) cVar);
                    zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new b(dVar, cameraProperties));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.getLocalizedMessage();
            }
        }
    }
}
