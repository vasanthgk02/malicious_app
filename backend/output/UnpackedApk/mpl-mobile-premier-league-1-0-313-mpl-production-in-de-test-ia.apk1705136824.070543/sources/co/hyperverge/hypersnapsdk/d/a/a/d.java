package co.hyperverge.hypersnapsdk.d.a.a;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.activities.HVRetakeActivity;
import co.hyperverge.hypersnapsdk.c.f;
import co.hyperverge.hypersnapsdk.c.i;
import co.hyperverge.hypersnapsdk.c.k;
import co.hyperverge.hypersnapsdk.c.l;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.o;
import co.hyperverge.hypersnapsdk.c.p;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.listeners.FaceCaptureCompletionHandler;
import co.hyperverge.hypersnapsdk.model.LivenessResponse;
import co.hyperverge.hypersnapsdk.objects.HVBaseResponse;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig.LivenessMode;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import co.hyperverge.hypersnapsdk.objects.IPAddress;
import co.hyperverge.hypersnapsdk.service.b.a$a;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.login.LoginReactModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TexturePresenter */
public class d implements a {
    public long A;
    public int B;
    public String C;
    public String D;
    public i E;
    public MediaMetadataRetriever F;
    public String G;
    public Location H;
    public String I;
    public String J;
    public String K;
    public final ArrayList<HVBaseResponse> L;
    public final String g = d.class.getSimpleName();
    public String h;
    public co.hyperverge.hypersnapsdk.c.b i;
    public co.hyperverge.hypersnapsdk.f.j.b j;
    public b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public co.hyperverge.hypersnapsdk.b.a q;
    public co.hyperverge.hypersnapsdk.f.j.a r;
    public Handler s;
    public LivenessMode t = LivenessMode.TEXTURELIVENESS;
    public FaceCaptureCompletionHandler v;
    public co.hyperverge.hypersnapsdk.c.e.a w;
    public String x = "";
    public ArrayList<Integer> y;
    public HVFaceConfig z;

    /* compiled from: TexturePresenter */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.this.o = true;
        }
    }

    /* compiled from: TexturePresenter */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            d.this.o = true;
        }
    }

    /* compiled from: TexturePresenter */
    public class c implements co.hyperverge.hypersnapsdk.c.p.a {

        /* renamed from: a  reason: collision with root package name */
        public String f3164a = "";

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3165b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f3166c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ co.hyperverge.hypersnapsdk.c.d f3167d;

        /* compiled from: TexturePresenter */
        public class a implements a$a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f3169a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f3170b;

            public a(String str, List list) {
                this.f3169a = str;
                this.f3170b = list;
            }

            public void a(IPAddress iPAddress) {
                c cVar = c.this;
                d.a(d.this, cVar.f3165b, cVar.f3166c, this.f3169a, this.f3170b, iPAddress, cVar.f3167d, cVar.f3164a);
            }

            public void a() {
                c cVar = c.this;
                d.a(d.this, cVar.f3165b, cVar.f3166c, this.f3169a, this.f3170b, null, cVar.f3167d, cVar.f3164a);
            }
        }

        public c(String str, String str2, co.hyperverge.hypersnapsdk.c.d dVar) {
            this.f3165b = str;
            this.f3166c = str2;
            this.f3167d = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0113, code lost:
            if (r0.isEmpty() != false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0122, code lost:
            if (new java.io.File(r10.f3168e.x).exists() == false) goto L_0x0124;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r11, java.util.List<java.lang.Integer> r12) {
            /*
                r10 = this;
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.d.a.a.b r0 = r0.k
                co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
                r1 = 0
                if (r0 == 0) goto L_0x01b0
                if (r11 == 0) goto L_0x0015
                co.hyperverge.hvcamera.HVCamHost r0 = r0.f0
                java.io.File r2 = new java.io.File
                r2.<init>(r11)
                r0.onPictureSaved(r2)
            L_0x0015:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                r0.x = r11
                if (r11 != 0) goto L_0x0026
                r2 = 2
                co.hyperverge.hypersnapsdk.objects.HVError r3 = new co.hyperverge.hypersnapsdk.objects.HVError
                java.lang.String r4 = "Error while processing the face image"
                r3.<init>(r2, r4)
                r0.a(r3, r1)
            L_0x0026:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r10.f3165b
                r2.append(r3)
                java.lang.String r3 = "/"
                r2.append(r3)
                java.lang.String r3 = r10.f3166c
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.h = r2
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r2 = r0.z
                boolean r2 = r2.isShouldAddWaterMark()
                if (r2 == 0) goto L_0x00a8
                co.hyperverge.hypersnapsdk.HyperSnapSDK r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
                if (r2 == 0) goto L_0x00a7
                co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
                boolean r2 = r2.isShouldUseLocation()
                if (r2 == 0) goto L_0x00a8
                java.lang.String r2 = r0.h
                if (r2 == 0) goto L_0x0080
                co.hyperverge.hypersnapsdk.c.r r2 = co.hyperverge.hypersnapsdk.c.r.f3141a
                if (r2 != 0) goto L_0x0069
                co.hyperverge.hypersnapsdk.c.r r2 = new co.hyperverge.hypersnapsdk.c.r
                r2.<init>()
                co.hyperverge.hypersnapsdk.c.r.f3141a = r2
            L_0x0069:
                co.hyperverge.hypersnapsdk.c.r r3 = co.hyperverge.hypersnapsdk.c.r.f3141a
                co.hyperverge.hypersnapsdk.d.a.a.b r2 = r0.k
                co.hyperverge.hypersnapsdk.d.a.a.c r2 = (co.hyperverge.hypersnapsdk.d.a.a.c) r2
                androidx.fragment.app.FragmentActivity r4 = r2.getActivity()
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r5 = r0.z
                java.lang.String r6 = r0.K
                java.lang.String r7 = r0.h
                r8 = 0
                java.lang.String r2 = r3.a(r4, r5, r6, r7, r8)
                r0.I = r2
            L_0x0080:
                java.lang.String r2 = r0.x
                if (r2 == 0) goto L_0x00a8
                co.hyperverge.hypersnapsdk.c.r r2 = co.hyperverge.hypersnapsdk.c.r.f3141a
                if (r2 != 0) goto L_0x008f
                co.hyperverge.hypersnapsdk.c.r r2 = new co.hyperverge.hypersnapsdk.c.r
                r2.<init>()
                co.hyperverge.hypersnapsdk.c.r.f3141a = r2
            L_0x008f:
                co.hyperverge.hypersnapsdk.c.r r3 = co.hyperverge.hypersnapsdk.c.r.f3141a
                co.hyperverge.hypersnapsdk.d.a.a.b r2 = r0.k
                co.hyperverge.hypersnapsdk.d.a.a.c r2 = (co.hyperverge.hypersnapsdk.d.a.a.c) r2
                androidx.fragment.app.FragmentActivity r4 = r2.getActivity()
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r5 = r0.z
                java.lang.String r6 = r0.K
                java.lang.String r7 = r0.x
                r8 = 1
                java.lang.String r2 = r3.a(r4, r5, r6, r7, r8)
                r0.J = r2
                goto L_0x00a8
            L_0x00a7:
                throw r1
            L_0x00a8:
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                boolean r0 = r0.t()
                if (r0 != 0) goto L_0x00b8
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r2 = r0.h
                r0.x = r2
            L_0x00b8:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r0.z
                boolean r0 = r0.isShouldHandleRetries()
                if (r0 != 0) goto L_0x00cc
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.d.a.a.b r0 = r0.k
                co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
                r0.d()
                goto L_0x00f1
            L_0x00cc:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.d.a.a.b r0 = r0.k
                co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
                if (r0 == 0) goto L_0x01af
                co.hyperverge.hvcamera.HVMagicView r0 = r0.A     // Catch:{ Exception -> 0x00dc }
                if (r0 == 0) goto L_0x00f1
                r0.onPause()     // Catch:{ Exception -> 0x00dc }
                goto L_0x00f1
            L_0x00dc:
                r0 = move-exception
                co.hyperverge.hypersnapsdk.f.i.a(r0)
                co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
                if (r2 == 0) goto L_0x00f1
                co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
                r2.a(r0)
            L_0x00f1:
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                boolean r0 = r0.t()
                if (r0 == 0) goto L_0x013b
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r2 = r0.x
                if (r2 == 0) goto L_0x0124
                java.lang.String r0 = r0.h
                boolean r0 = r2.equals(r0)
                if (r0 != 0) goto L_0x0124
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r0 = r0.x
                if (r0 == 0) goto L_0x0115
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x0124
            L_0x0115:
                java.io.File r0 = new java.io.File
                co.hyperverge.hypersnapsdk.d.a.a.d r2 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r2 = r2.x
                r0.<init>(r2)
                boolean r0 = r0.exists()
                if (r0 != 0) goto L_0x013b
            L_0x0124:
                co.hyperverge.hypersnapsdk.d.a.a.d r11 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.d.a.a.b r12 = r11.k
                int r0 = co.hyperverge.hypersnapsdk.R$string.blurry_face_detection_error
                co.hyperverge.hypersnapsdk.d.a.a.c r12 = (co.hyperverge.hypersnapsdk.d.a.a.c) r12
                java.lang.String r12 = r12.a(r0)
                r0 = 23
                co.hyperverge.hypersnapsdk.objects.HVError r2 = new co.hyperverge.hypersnapsdk.objects.HVError
                r2.<init>(r0, r12)
                r11.a(r2, r1)
                return
            L_0x013b:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r0.z
                org.json.JSONObject r0 = r0.getHeaders()
                if (r0 == 0) goto L_0x017e
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r0.z
                org.json.JSONObject r0 = r0.getHeaders()
                java.lang.String r1 = "transactionId"
                boolean r0 = r0.has(r1)
                if (r0 == 0) goto L_0x017e
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this     // Catch:{ JSONException -> 0x0164 }
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r0.z     // Catch:{ JSONException -> 0x0164 }
                org.json.JSONObject r0 = r0.getHeaders()     // Catch:{ JSONException -> 0x0164 }
                java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0164 }
                r10.f3164a = r0     // Catch:{ JSONException -> 0x0164 }
                goto L_0x0184
            L_0x0164:
                r0 = move-exception
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
                if (r1 == 0) goto L_0x0176
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
                r1.a(r0)
            L_0x0176:
                co.hyperverge.hypersnapsdk.d.a.a.d r1 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r1 = r1.g
                r0.toString()
                goto L_0x0184
            L_0x017e:
                java.lang.String r0 = co.hyperverge.hypersnapsdk.c.o.i()
                r10.f3164a = r0
            L_0x0184:
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.b.e r0 = r0.p()
                boolean r0 = r0.f3028c
                if (r0 == 0) goto L_0x019e
                co.hyperverge.hypersnapsdk.service.b.b r0 = new co.hyperverge.hypersnapsdk.service.b.b
                r0.<init>()
                co.hyperverge.hypersnapsdk.d.a.a.d$c$a r1 = new co.hyperverge.hypersnapsdk.d.a.a.d$c$a
                r1.<init>(r11, r12)
                r0.a(r1)
                goto L_0x01ae
            L_0x019e:
                co.hyperverge.hypersnapsdk.d.a.a.d r2 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r3 = r10.f3165b
                java.lang.String r4 = r10.f3166c
                co.hyperverge.hypersnapsdk.c.d r8 = r10.f3167d
                java.lang.String r9 = r10.f3164a
                r7 = 0
                r5 = r11
                r6 = r12
                co.hyperverge.hypersnapsdk.d.a.a.d.a(r2, r3, r4, r5, r6, r7, r8, r9)
            L_0x01ae:
                return
            L_0x01af:
                throw r1
            L_0x01b0:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.d.a.a.d.c.a(java.lang.String, java.util.List):void");
        }
    }

    /* renamed from: co.hyperverge.hypersnapsdk.d.a.a.d$d  reason: collision with other inner class name */
    /* compiled from: TexturePresenter */
    public class C0058d implements co.hyperverge.hypersnapsdk.b.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f3172a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3173b;

        public C0058d(q qVar, String str) {
            this.f3172a = qVar;
            this.f3173b = str;
        }
    }

    /* compiled from: TexturePresenter */
    public class e implements co.hyperverge.hypersnapsdk.listeners.a {
        public e() {
        }

        public void a(Location location) {
            if (location != null) {
                d dVar = d.this;
                dVar.H = location;
                dVar.K = location.getLatitude() + ", " + location.getLongitude();
                return;
            }
            d dVar2 = d.this;
            dVar2.H = co.hyperverge.hypersnapsdk.service.c.a.a(((c) dVar2.k).getActivity()).a();
            d dVar3 = d.this;
            dVar3.K = d.this.H.getLatitude() + ", " + d.this.H.getLongitude();
        }
    }

    public d() {
        new ArrayList();
        this.B = 0;
        this.C = null;
        this.D = null;
        this.F = new MediaMetadataRetriever();
        this.G = "";
        this.K = "";
        this.L = new ArrayList<>();
        this.j = co.hyperverge.hypersnapsdk.f.j.b.a();
        this.r = co.hyperverge.hypersnapsdk.f.j.a.a();
        this.o = true;
        new ArrayList();
        this.s = new Handler();
        this.l = false;
        this.z = new HVFaceConfig();
        this.q = co.hyperverge.hypersnapsdk.b.a.a();
        this.E = i.b();
        if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
            this.v = null;
            return;
        }
        throw null;
    }

    /* renamed from: lambda$G5kEO-WVL9FWbptnZeFOpyeawyU  reason: not valid java name */
    public static void m301lambda$G5kEOWVL9FWbptnZeFOpyeawyU(d dVar, HVError hVError, HVResponse hVResponse) {
        co.hyperverge.hypersnapsdk.f.j.a aVar = dVar.r;
        aVar.f3185b.post(new Runnable(hVError, hVResponse) {
            public final /* synthetic */ HVError f$1;
            public final /* synthetic */ HVResponse f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                d.this.c(this.f$1, this.f$2);
            }
        });
    }

    public void a(LivenessResponse livenessResponse, String str) {
        if (f.f3102b == null) {
            f.f3102b = new f();
        }
        f fVar = f.f3102b;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = livenessResponse.response;
        if (jSONObject2 != null) {
            jSONObject = jSONObject2;
        } else {
            try {
                JSONObject jSONObject3 = livenessResponse.headers;
                if (jSONObject3.has("X-HV-Raw-Response")) {
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.getString("X-HV-Raw-Response"));
                    if (jSONObject4.has(LoginReactModule.RESULT)) {
                        jSONObject = jSONObject4;
                    }
                }
            } catch (JSONException e2) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            }
        }
        HVFaceConfig hVFaceConfig = this.z;
        if (fVar != null) {
            try {
                JSONObject jSONObject5 = jSONObject.getJSONObject(LoginReactModule.RESULT);
                if (jSONObject5.has("summary")) {
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("summary");
                    String string = jSONObject6.getString("action");
                    String d2 = o.d(hVFaceConfig.getLivenessEndpoint(), "");
                    String string2 = jSONObject6.has("retakeMessage") ? jSONObject6.getString("retakeMessage") : "Some issue with the image capture. Please try again.";
                    if (!hVFaceConfig.isShouldHandleRetries()) {
                        a(livenessResponse, str, false, string2, string, null);
                    } else if (!string.equalsIgnoreCase("retake")) {
                        a(livenessResponse, str, false, "", string, null);
                    } else if (d2 != null) {
                        a(livenessResponse, str, true, string2, string, null);
                    } else {
                        a(livenessResponse, str, false, string2, string, new HVError(17, "Please call startSession before making OCR call within SDK. Transaction ID is empty"));
                    }
                } else {
                    a(livenessResponse, str, false, "", "", null);
                }
            } catch (JSONException e3) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                a(livenessResponse, str, false, "", "", null);
            }
        } else {
            throw null;
        }
    }

    public void c() {
        ((c) this.k).d();
        if (n.m().o && n.m().j != null) {
            n.m().j.b(this.z);
        }
        a((LivenessResponse) null, new HVError(3, ((c) this.k).a(R$string.operation_cancelled)));
    }

    /* access modifiers changed from: private */
    public void c(HVError hVError, HVResponse hVResponse) {
        boolean z2;
        if (CameraEngine.f2908a) {
            z2 = co.hyperverge.hvcamera.magicfilter.camera.b.o;
        } else {
            z2 = co.hyperverge.hvcamera.magicfilter.camera.a.j;
        }
        if (!z2) {
            new Handler().postDelayed(new Runnable(hVError, hVResponse) {
                public final /* synthetic */ HVError f$1;
                public final /* synthetic */ HVResponse f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    d.m301lambda$G5kEOWVL9FWbptnZeFOpyeawyU(d.this, this.f$1, this.f$2);
                }
            }, 20);
        } else if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                n.m().l.M();
            }
            FaceCaptureCompletionHandler faceCaptureCompletionHandler = this.v;
            if (faceCaptureCompletionHandler != null) {
                faceCaptureCompletionHandler.onResult(hVError, hVResponse);
            }
            try {
                if (this.E != null) {
                    i.f3104a = null;
                    this.i.i = null;
                    co.hyperverge.hypersnapsdk.c.b.f3068c = null;
                    f.f3102b = null;
                    if (l.f3112a == null) {
                        l.f3112a = new l();
                    }
                    l.f3112a.a();
                    c cVar = (c) this.k;
                    if (cVar.getActivity() != null) {
                        cVar.getActivity().finish();
                    }
                    MediaMetadataRetriever mediaMetadataRetriever = this.F;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                        return;
                    }
                    return;
                }
                throw null;
            } catch (Exception e2) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        } else {
            throw null;
        }
    }

    public void a() {
        if (co.hyperverge.hypersnapsdk.c.b.f3068c == null) {
            co.hyperverge.hypersnapsdk.c.b.f3068c = new co.hyperverge.hypersnapsdk.c.b(this);
        }
        this.i = co.hyperverge.hypersnapsdk.c.b.f3068c;
        try {
            co.hyperverge.hypersnapsdk.service.c.a.a(((c) this.k).getActivity()).c();
            co.hyperverge.hypersnapsdk.service.c.a.a(((c) this.k).getActivity()).f3197c = new e();
        } catch (NoClassDefFoundError unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(co.hyperverge.hypersnapsdk.model.FaceDetectorObj r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            boolean r0 = r1.m
            if (r0 != 0) goto L_0x038d
            boolean r0 = r1.o
            if (r0 != 0) goto L_0x000e
            goto L_0x038d
        L_0x000e:
            java.util.ArrayList<java.lang.Integer> r0 = r2.rectPoints
            r3 = 0
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            boolean r0 = r1.l
            if (r0 == 0) goto L_0x001f
            r1.l = r3
        L_0x001f:
            co.hyperverge.hypersnapsdk.c.e$a r0 = r2.faceCoordinateObject
            r1.w = r0
            java.util.List<java.util.ArrayList<java.lang.Integer>> r0 = r2.multipleFaces
            r4 = 1058642330(0x3f19999a, float:0.6)
            r5 = 2
            r8 = 1
            if (r0 == 0) goto L_0x008d
            int r9 = r0.size()
            if (r9 <= 0) goto L_0x008d
            r1.B = r3
            java.util.Iterator r0 = r0.iterator()
            r9 = 0
        L_0x0039:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0089
            java.lang.Object r10 = r0.next()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r11 = r10.get(r5)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.lang.Object r10 = r10.get(r3)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            int r11 = r11 - r10
            long r10 = (long) r11
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r12 = r1.z
            boolean r12 = r12.getShouldUseBackCamera()
            if (r12 == 0) goto L_0x0067
            r12 = 1051931443(0x3eb33333, float:0.35)
            goto L_0x006a
        L_0x0067:
            r12 = 1050253722(0x3e99999a, float:0.3)
        L_0x006a:
            float r10 = (float) r10
            int r11 = co.hyperverge.hypersnapsdk.f.h.b()
            float r11 = (float) r11
            float r12 = r12 * r11
            int r11 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x0083
            int r11 = co.hyperverge.hypersnapsdk.f.h.b()
            float r11 = (float) r11
            float r11 = r11 * r4
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 >= 0) goto L_0x0083
            r10 = 1
            goto L_0x0084
        L_0x0083:
            r10 = 0
        L_0x0084:
            if (r10 == 0) goto L_0x0039
            int r9 = r9 + 1
            goto L_0x0039
        L_0x0089:
            if (r9 <= 0) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            r9 = 0
            r10 = 50
            if (r0 == 0) goto L_0x0124
            r1.l = r3
            r1.n = r3
            r1.o = r3
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            java.lang.String r2 = "faceCaptureMultipleFaces"
            androidx.fragment.app.FragmentActivity r3 = r0.getActivity()
            if (r3 == 0) goto L_0x0119
            boolean r3 = r0.isAdded()
            if (r3 != 0) goto L_0x00ac
            goto L_0x0119
        L_0x00ac:
            co.hyperverge.hypersnapsdk.views.a r3 = r0.J     // Catch:{ Exception -> 0x0104 }
            android.content.res.Resources r4 = r0.getResources()     // Catch:{ Exception -> 0x0104 }
            int r5 = co.hyperverge.hypersnapsdk.R$color.face_capture_circle_failure     // Catch:{ Exception -> 0x0104 }
            int r4 = r4.getColor(r5)     // Catch:{ Exception -> 0x0104 }
            r3.setProgressColor(r4)     // Catch:{ Exception -> 0x0104 }
            org.json.JSONObject r3 = r0.Q     // Catch:{ Exception -> 0x0104 }
            if (r3 == 0) goto L_0x00e1
            boolean r3 = r3.has(r2)     // Catch:{ Exception -> 0x0104 }
            if (r3 == 0) goto L_0x00e1
            org.json.JSONObject r3 = r0.Q     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = r3.getString(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x0104 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0104 }
            if (r3 != 0) goto L_0x00e1
            android.widget.TextView r3 = r0.B     // Catch:{ Exception -> 0x0104 }
            org.json.JSONObject r4 = r0.Q     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0104 }
            r3.setText(r2)     // Catch:{ Exception -> 0x0104 }
            goto L_0x00ec
        L_0x00e1:
            android.widget.TextView r2 = r0.B     // Catch:{ Exception -> 0x0104 }
            int r3 = co.hyperverge.hypersnapsdk.R$string.faceCaptureMultipleFaces     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = r0.a(r3)     // Catch:{ Exception -> 0x0104 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0104 }
        L_0x00ec:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r2 = r0.R     // Catch:{ Exception -> 0x0104 }
            boolean r2 = r2.isShouldAutoCapture()     // Catch:{ Exception -> 0x0104 }
            if (r2 == 0) goto L_0x00f7
            r0.A()     // Catch:{ Exception -> 0x0104 }
        L_0x00f7:
            android.widget.ImageView r2 = r0.x     // Catch:{ Exception -> 0x0104 }
            int r3 = co.hyperverge.hypersnapsdk.R$drawable.camera_disabled     // Catch:{ Exception -> 0x0104 }
            r2.setImageResource(r3)     // Catch:{ Exception -> 0x0104 }
            android.widget.ImageView r0 = r0.x     // Catch:{ Exception -> 0x0104 }
            r0.setImageTintList(r9)     // Catch:{ Exception -> 0x0104 }
            goto L_0x0119
        L_0x0104:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            if (r2 == 0) goto L_0x0119
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            r2.a(r0)
        L_0x0119:
            android.os.Handler r0 = r1.s
            co.hyperverge.hypersnapsdk.d.a.a.d$a r2 = new co.hyperverge.hypersnapsdk.d.a.a.d$a
            r2.<init>()
            r0.postDelayed(r2, r10)
            return
        L_0x0124:
            java.util.ArrayList<java.lang.Integer> r0 = r2.rectPoints
            if (r0 == 0) goto L_0x012e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0138
        L_0x012e:
            boolean r0 = r1.l
            if (r0 != 0) goto L_0x0382
            boolean r0 = r1.n
            if (r0 == 0) goto L_0x0138
            goto L_0x0382
        L_0x0138:
            java.util.ArrayList<java.lang.Integer> r0 = r2.rectPoints
            if (r0 == 0) goto L_0x0376
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0376
            boolean r0 = r1.l
            if (r0 != 0) goto L_0x0376
            r1.n = r3
            boolean r0 = r2.isStraight
            if (r0 != 0) goto L_0x0154
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            r0.l()
            return
        L_0x0154:
            int r0 = r1.B
            int r0 = r0 + r8
            r1.B = r0
            float r0 = (float) r0
            r12 = 1084227584(0x40a00000, float:5.0)
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x0162
            r0 = 1
            goto L_0x0163
        L_0x0162:
            r0 = 0
        L_0x0163:
            if (r0 != 0) goto L_0x01ca
            r1.l = r3
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r1.z     // Catch:{ Exception -> 0x01b5 }
            boolean r0 = r0.shouldCheckForFaceTilt()     // Catch:{ Exception -> 0x01b5 }
            if (r0 == 0) goto L_0x01b4
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k     // Catch:{ Exception -> 0x01b5 }
            if (r0 == 0) goto L_0x01b4
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0     // Catch:{ Exception -> 0x01b5 }
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x01b5 }
            if (r0 == 0) goto L_0x01b4
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k     // Catch:{ Exception -> 0x01b5 }
            r12 = r0
            co.hyperverge.hypersnapsdk.d.a.a.c r12 = (co.hyperverge.hypersnapsdk.d.a.a.c) r12     // Catch:{ Exception -> 0x01b5 }
            androidx.fragment.app.FragmentActivity r12 = r12.getActivity()     // Catch:{ Exception -> 0x01b5 }
            int r13 = co.hyperverge.hypersnapsdk.R$string.faceCaptureStayStill     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x01b5 }
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0     // Catch:{ Exception -> 0x01b5 }
            androidx.fragment.app.FragmentActivity r13 = r0.getActivity()     // Catch:{ Exception -> 0x01b5 }
            if (r13 == 0) goto L_0x01b4
            boolean r13 = r0.isAdded()     // Catch:{ Exception -> 0x01b5 }
            if (r13 != 0) goto L_0x0199
            goto L_0x01b4
        L_0x0199:
            android.widget.TextView r0 = r0.B     // Catch:{ Exception -> 0x019f }
            r0.setText(r12)     // Catch:{ Exception -> 0x019f }
            goto L_0x01b4
        L_0x019f:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)     // Catch:{ Exception -> 0x01b5 }
            co.hyperverge.hypersnapsdk.c.n r12 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x01b5 }
            co.hyperverge.hypersnapsdk.service.a.b r12 = r12.i     // Catch:{ Exception -> 0x01b5 }
            if (r12 == 0) goto L_0x01b4
            co.hyperverge.hypersnapsdk.c.n r12 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x01b5 }
            co.hyperverge.hypersnapsdk.service.a.b r12 = r12.i     // Catch:{ Exception -> 0x01b5 }
            r12.a(r0)     // Catch:{ Exception -> 0x01b5 }
        L_0x01b4:
            return
        L_0x01b5:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r12 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r12 = r12.i
            if (r12 == 0) goto L_0x01ca
            co.hyperverge.hypersnapsdk.c.n r12 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r12 = r12.i
            r12.a(r0)
        L_0x01ca:
            java.util.ArrayList<java.lang.Integer> r0 = r2.rectPoints
            r1.y = r0
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.ArrayList<java.lang.Integer> r12 = r2.rectPoints
            java.lang.Object r12 = r12.get(r3)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            int r0 = r0 - r12
            long r12 = (long) r0
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            int[] r14 = new int[r5]
            co.hyperverge.hypersnapsdk.views.e r15 = r0.m
            r15.getLocationOnScreen(r14)
            r14 = r14[r8]
            float r14 = (float) r14
            co.hyperverge.hypersnapsdk.views.e r0 = r0.m
            int r0 = r0.getHeight()
            int r0 = r0 / r5
            float r0 = (float) r0
            float r14 = r14 + r0
            int r0 = (int) r14
            java.util.ArrayList<java.lang.Integer> r14 = r2.rectPoints
            java.lang.Object r15 = r14.get(r5)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.lang.Object r16 = r14.get(r3)
            java.lang.Integer r16 = (java.lang.Integer) r16
            int r16 = r16.intValue()
            int r15 = r15 - r16
            long r6 = (long) r15
            r15 = 3
            java.lang.Object r15 = r14.get(r15)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.lang.Object r17 = r14.get(r8)
            java.lang.Integer r17 = (java.lang.Integer) r17
            int r17 = r17.intValue()
            int r15 = r15 - r17
            long r10 = (long) r15
            java.lang.Object r14 = r14.get(r8)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r14 = (long) r14
            r18 = 2
            long r10 = r10 / r18
            long r10 = r10 + r14
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r14 = r1.z
            boolean r14 = r14.getShouldUseBackCamera()
            if (r14 == 0) goto L_0x024b
            r16 = 1051931443(0x3eb33333, float:0.35)
            goto L_0x024e
        L_0x024b:
            r16 = 1050253722(0x3e99999a, float:0.3)
        L_0x024e:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r14 = r1.z
            boolean r14 = r14.shouldCheckForFaceTilt()
            if (r14 != 0) goto L_0x027c
            float r14 = (float) r0
            float r10 = (float) r10
            co.hyperverge.hypersnapsdk.d.a.a.b r11 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r11 = (co.hyperverge.hypersnapsdk.d.a.a.c) r11
            int[] r5 = new int[r5]
            co.hyperverge.hypersnapsdk.views.e r11 = r11.m
            r11.getLocationOnScreen(r5)
            r5 = r5[r8]
            float r5 = (float) r5
            float r10 = r10 + r5
            float r14 = r14 - r10
            float r5 = java.lang.Math.abs(r14)
            double r10 = (double) r5
            double r14 = (double) r0
            r18 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            double r14 = r14 * r18
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 >= 0) goto L_0x027a
            goto L_0x027c
        L_0x027a:
            r0 = 0
            goto L_0x027d
        L_0x027c:
            r0 = 1
        L_0x027d:
            float r5 = (float) r6
            int r6 = co.hyperverge.hypersnapsdk.f.h.b()
            float r6 = (float) r6
            float r16 = r16 * r6
            int r6 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x0298
            int r6 = co.hyperverge.hypersnapsdk.f.h.b()
            float r6 = (float) r6
            float r6 = r6 * r4
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0298
            if (r0 == 0) goto L_0x0298
            r0 = 1
            goto L_0x0299
        L_0x0298:
            r0 = 0
        L_0x0299:
            if (r0 == 0) goto L_0x02c5
            boolean r0 = r2.isStraight
            if (r0 == 0) goto L_0x02c5
            co.hyperverge.hypersnapsdk.c.e$a r0 = r1.w
            co.hyperverge.hypersnapsdk.HyperSnapSDK r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r2 == 0) goto L_0x02c4
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r2 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            boolean r2 = r2.isShouldUseLocation()
            if (r2 == 0) goto L_0x02b7
            android.location.Location r2 = r1.H
            if (r2 != 0) goto L_0x02b7
            r1.l = r3
            goto L_0x038d
        L_0x02b7:
            co.hyperverge.hypersnapsdk.d.a.a.b r2 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r2 = (co.hyperverge.hypersnapsdk.d.a.a.c) r2
            r2.i()
            r1.l = r8
            r1.w = r0
            goto L_0x038d
        L_0x02c4:
            throw r9
        L_0x02c5:
            r1.B = r3
            float r0 = (float) r12
            int r5 = co.hyperverge.hypersnapsdk.f.h.b()
            float r5 = (float) r5
            float r5 = r5 * r4
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0360
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            java.lang.String r2 = "faceCaptureMoveAway"
            androidx.fragment.app.FragmentActivity r4 = r0.getActivity()
            if (r4 == 0) goto L_0x034f
            boolean r4 = r0.isAdded()
            if (r4 != 0) goto L_0x02e6
            goto L_0x034f
        L_0x02e6:
            co.hyperverge.hypersnapsdk.views.a r4 = r0.J     // Catch:{ Exception -> 0x033a }
            android.content.res.Resources r5 = r0.getResources()     // Catch:{ Exception -> 0x033a }
            int r6 = co.hyperverge.hypersnapsdk.R$color.face_capture_circle_failure     // Catch:{ Exception -> 0x033a }
            int r5 = r5.getColor(r6)     // Catch:{ Exception -> 0x033a }
            r4.setProgressColor(r5)     // Catch:{ Exception -> 0x033a }
            org.json.JSONObject r4 = r0.Q     // Catch:{ Exception -> 0x033a }
            if (r4 == 0) goto L_0x031b
            boolean r4 = r4.has(r2)     // Catch:{ Exception -> 0x033a }
            if (r4 == 0) goto L_0x031b
            org.json.JSONObject r4 = r0.Q     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = r4.getString(r2)     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x033a }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x033a }
            if (r4 != 0) goto L_0x031b
            android.widget.TextView r4 = r0.B     // Catch:{ Exception -> 0x033a }
            org.json.JSONObject r5 = r0.Q     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x033a }
            r4.setText(r2)     // Catch:{ Exception -> 0x033a }
            goto L_0x0322
        L_0x031b:
            android.widget.TextView r2 = r0.B     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = co.hyperverge.hypersnapsdk.c.k.f3109e     // Catch:{ Exception -> 0x033a }
            r2.setText(r4)     // Catch:{ Exception -> 0x033a }
        L_0x0322:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r2 = r0.R     // Catch:{ Exception -> 0x033a }
            boolean r2 = r2.isShouldAutoCapture()     // Catch:{ Exception -> 0x033a }
            if (r2 == 0) goto L_0x032d
            r0.A()     // Catch:{ Exception -> 0x033a }
        L_0x032d:
            android.widget.ImageView r2 = r0.x     // Catch:{ Exception -> 0x033a }
            int r4 = co.hyperverge.hypersnapsdk.R$drawable.camera_disabled     // Catch:{ Exception -> 0x033a }
            r2.setImageResource(r4)     // Catch:{ Exception -> 0x033a }
            android.widget.ImageView r0 = r0.x     // Catch:{ Exception -> 0x033a }
            r0.setImageTintList(r9)     // Catch:{ Exception -> 0x033a }
            goto L_0x034f
        L_0x033a:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            if (r2 == 0) goto L_0x034f
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            r2.a(r0)
        L_0x034f:
            r1.n = r8
            r1.o = r3
            android.os.Handler r0 = r1.s
            co.hyperverge.hypersnapsdk.d.a.a.d$b r2 = new co.hyperverge.hypersnapsdk.d.a.a.d$b
            r2.<init>()
            r4 = 50
            r0.postDelayed(r2, r4)
            goto L_0x0373
        L_0x0360:
            boolean r0 = r2.isStraight
            if (r0 != 0) goto L_0x036c
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            r0.l()
            goto L_0x0373
        L_0x036c:
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            r0.f()
        L_0x0373:
            r1.l = r3
            goto L_0x038d
        L_0x0376:
            r1.B = r3
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            r0.f()
            r1.l = r3
            goto L_0x038d
        L_0x0382:
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            r0.f()
            r1.l = r3
            r1.n = r3
        L_0x038d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.d.a.a.d.a(co.hyperverge.hypersnapsdk.model.FaceDetectorObj):void");
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (this.z.getCustomLoaderClass() != null) {
            if (z2) {
                try {
                    ((c) this.k).getActivity().startActivityForResult(new Intent(((c) this.k).getActivity(), Class.forName(this.z.getCustomLoaderClass())), 87);
                } catch (ClassNotFoundException e2) {
                    if (n.m().i != null) {
                        n.m().i.a(e2);
                    }
                }
            } else {
                ((c) this.k).getActivity().finishActivity(87);
            }
            return;
        }
        c cVar = (c) this.k;
        if (cVar != null) {
            if (z2) {
                try {
                    cVar.F.setVisibility(0);
                    cVar.H = new ProgressDialog(cVar.getActivity());
                    try {
                        JSONObject jSONObject = cVar.Q;
                        if (jSONObject == null || !jSONObject.has("faceCaptureActivity") || cVar.Q.getString("faceCaptureActivity").trim().isEmpty()) {
                            cVar.H.setMessage(k.f3108c);
                        } else {
                            cVar.H.setMessage(cVar.Q.getString("faceCaptureActivity"));
                        }
                    } catch (Exception e3) {
                        co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                        if (n.m().i != null) {
                            n.m().i.a(e3);
                        }
                    }
                    cVar.H.setCancelable(false);
                    cVar.H.show();
                } catch (Exception e4) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e4);
                    if (n.m().i != null) {
                        n.m().i.a(e4);
                    }
                }
            } else {
                cVar.F.setVisibility(8);
                ProgressDialog progressDialog = cVar.H;
                if (progressDialog != null) {
                    cVar.N = true;
                    progressDialog.cancel();
                    cVar.H = null;
                }
            }
            return;
        }
        throw null;
    }

    public void a(byte[] bArr, byte[] bArr2, String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        this.m = true;
        co.hyperverge.hypersnapsdk.c.d dVar = new co.hyperverge.hypersnapsdk.c.d();
        byte[] bArr3 = bArr;
        dVar.a(bArr, GeneratedOutlineSupport.outline52(str, "/", str2), this.H);
        if (this.t != LivenessMode.NONE) {
            a(true);
        }
        this.G = str3;
        p pVar = new p(bArr, bArr2, str, this.w, str2, this.z, new c(str, str2, dVar));
        this.j.f3189d.submit(pVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02eb, code lost:
        if ((java.lang.System.currentTimeMillis() - r17) > org.eclipse.paho.client.mqttv3.MqttAsyncClient.DISCONNECT_TIMEOUT) goto L_0x02ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03d3 A[Catch:{ all -> 0x03c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04a6 A[Catch:{ Exception -> 0x04bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x04ba A[Catch:{ Exception -> 0x04bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x053d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(co.hyperverge.hypersnapsdk.d.a.a.d r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.List r27, co.hyperverge.hypersnapsdk.objects.IPAddress r28, co.hyperverge.hypersnapsdk.c.d r29, java.lang.String r30) {
        /*
            r1 = r23
            r2 = r26
            r3 = r27
            r0 = r28
            r4 = r29
            r5 = r30
            java.lang.String r6 = r1.x
            r4.a(r6, r5, r0)
            java.lang.String r6 = r1.h
            r4.a(r6, r5, r0)
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r6 = r1.z
            boolean r6 = r6.isShouldAddWaterMark()
            if (r6 == 0) goto L_0x0028
            java.lang.String r6 = r1.I
            r4.a(r6, r5, r0)
            java.lang.String r6 = r1.J
            r4.a(r6, r5, r0)
        L_0x0028:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r0 = r1.z
            boolean r0 = r0.isShouldRecordVideo()
            r4 = 2
            r5 = 0
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r1.G
            co.hyperverge.hypersnapsdk.d.a.a.b r6 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r6 = (co.hyperverge.hypersnapsdk.d.a.a.c) r6
            androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
            android.media.MediaMetadataRetriever r7 = r1.F
            long r10 = co.hyperverge.hypersnapsdk.f.i.a(r0, r6, r7)
            r6 = 0
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0071
            r1.G = r5
            co.hyperverge.hypersnapsdk.objects.HVError r0 = new co.hyperverge.hypersnapsdk.objects.HVError
            java.lang.String r6 = "videoDuration is 0 ms"
            r0.<init>(r4, r6)
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r4 = r4.o
            if (r4 == 0) goto L_0x0092
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r4 = r4.j
            if (r4 == 0) goto L_0x0092
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r4 = r4.j
            co.hyperverge.hypersnapsdk.d.a.a.b r6 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r6 = (co.hyperverge.hypersnapsdk.d.a.a.c) r6
            long r6 = r6.n
            r4.a(r0, r6)
            goto L_0x0092
        L_0x0071:
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r0 = r0.o
            if (r0 == 0) goto L_0x0092
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            if (r0 == 0) goto L_0x0092
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r8 = r0.j
            java.lang.String r9 = r1.G
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            long r12 = r0.n
            r8.a(r9, r10, r12)
        L_0x0092:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig$LivenessMode r0 = r1.t
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig$LivenessMode r4 = co.hyperverge.hypersnapsdk.objects.HVFaceConfig.LivenessMode.NONE
            if (r0 != r4) goto L_0x009d
            r1.a(r5, r5)
            goto L_0x0536
        L_0x009d:
            java.lang.String r0 = "/"
            r4 = r24
            r6 = r25
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r4, r0, r6)
            java.lang.String r6 = r1.G
            co.hyperverge.hypersnapsdk.c.q r7 = new co.hyperverge.hypersnapsdk.c.q
            r7.<init>()
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.o.i()
            boolean r0 = co.hyperverge.hypersnapsdk.c.k.a(r0)
            if (r0 != 0) goto L_0x0141
            co.hyperverge.hypersnapsdk.c.f r0 = co.hyperverge.hypersnapsdk.c.f.f3102b
            if (r0 != 0) goto L_0x00c3
            co.hyperverge.hypersnapsdk.c.f r0 = new co.hyperverge.hypersnapsdk.c.f
            r0.<init>()
            co.hyperverge.hypersnapsdk.c.f.f3102b = r0
        L_0x00c3:
            co.hyperverge.hypersnapsdk.c.f r0 = co.hyperverge.hypersnapsdk.c.f.f3102b
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r8 = r1.z
            if (r0 == 0) goto L_0x0140
            java.lang.String r0 = "transactionId"
            org.json.JSONObject r9 = r8.getHeaders()
            java.lang.String r10 = co.hyperverge.hypersnapsdk.c.o.i()     // Catch:{ JSONException -> 0x0104 }
            boolean r10 = r10.isEmpty()     // Catch:{ JSONException -> 0x0104 }
            if (r10 != 0) goto L_0x00e6
            boolean r10 = r9.has(r0)     // Catch:{ JSONException -> 0x0104 }
            if (r10 != 0) goto L_0x00e6
            java.lang.String r10 = co.hyperverge.hypersnapsdk.c.o.i()     // Catch:{ JSONException -> 0x0104 }
            r9.put(r0, r10)     // Catch:{ JSONException -> 0x0104 }
        L_0x00e6:
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x0104 }
            if (r0 == 0) goto L_0x0103
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x0104 }
            boolean r0 = r0.isShouldActivateDeviceBlocklist()     // Catch:{ JSONException -> 0x0104 }
            if (r0 == 0) goto L_0x00ff
            boolean r0 = co.hyperverge.hypersnapsdk.c.k.a(r5)     // Catch:{ JSONException -> 0x0104 }
            if (r0 != 0) goto L_0x00ff
            java.lang.String r0 = "deviceId"
            r9.put(r0, r5)     // Catch:{ JSONException -> 0x0104 }
        L_0x00ff:
            r8.setLivenessAPIHeaders(r9)     // Catch:{ JSONException -> 0x0104 }
            goto L_0x0108
        L_0x0103:
            throw r5     // Catch:{ JSONException -> 0x0104 }
        L_0x0104:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
        L_0x0108:
            org.json.JSONObject r9 = r8.getLivenessParams()
            java.lang.String r0 = r8.getLivenessEndpoint()     // Catch:{ Exception -> 0x013b }
            java.lang.String r10 = ""
            org.json.JSONObject r10 = co.hyperverge.hypersnapsdk.c.o.c(r0, r10)     // Catch:{ Exception -> 0x013b }
            java.util.Iterator r11 = r10.keys()     // Catch:{ Exception -> 0x013b }
        L_0x011a:
            boolean r0 = r11.hasNext()     // Catch:{ Exception -> 0x013b }
            if (r0 == 0) goto L_0x0137
            java.lang.Object r0 = r11.next()     // Catch:{ Exception -> 0x013b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x013b }
            int r12 = r10.getInt(r0)     // Catch:{ JSONException -> 0x0132 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x0132 }
            r9.put(r0, r12)     // Catch:{ JSONException -> 0x0132 }
            goto L_0x011a
        L_0x0132:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)     // Catch:{ Exception -> 0x013b }
            goto L_0x011a
        L_0x0137:
            r8.setLivenessAPIParameters(r9)     // Catch:{ Exception -> 0x013b }
            goto L_0x0141
        L_0x013b:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            goto L_0x0141
        L_0x0140:
            throw r5
        L_0x0141:
            co.hyperverge.hypersnapsdk.b.a r0 = r1.q
            co.hyperverge.hypersnapsdk.d.a.a.b r8 = r1.k
            co.hyperverge.hypersnapsdk.d.a.a.c r8 = (co.hyperverge.hypersnapsdk.d.a.a.c) r8
            androidx.fragment.app.FragmentActivity r8 = r8.getActivity()
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r1.z
            co.hyperverge.hypersnapsdk.d.a.a.d$d r10 = new co.hyperverge.hypersnapsdk.d.a.a.d$d
            r10.<init>(r7, r4)
            if (r0 == 0) goto L_0x0540
            java.lang.String r7 = "connectivity"
            java.lang.Object r7 = r8.getSystemService(r7)
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7
            android.net.NetworkInfo r7 = r7.getActiveNetworkInfo()
            r11 = 0
            if (r7 == 0) goto L_0x016b
            boolean r7 = r7.isConnected()
            if (r7 == 0) goto L_0x016b
            r7 = 1
            goto L_0x016c
        L_0x016b:
            r7 = 0
        L_0x016c:
            if (r7 != 0) goto L_0x01a2
            co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
            co.hyperverge.hypersnapsdk.d.a.a.b r0 = r0.k
            int r2 = co.hyperverge.hypersnapsdk.R$string.network_error
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c) r0
            java.lang.String r0 = r0.a(r2)
            co.hyperverge.hypersnapsdk.objects.HVError r2 = new co.hyperverge.hypersnapsdk.objects.HVError
            r3 = 12
            r2.<init>(r3, r0)
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r0 = r0.o
            if (r0 == 0) goto L_0x019a
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            if (r0 == 0) goto L_0x019a
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            r0.a(r5, r2)
        L_0x019a:
            co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
            r0.a(r2, r5)
            r0 = 0
            goto L_0x0534
        L_0x01a2:
            co.hyperverge.hypersnapsdk.b.b r0 = r0.f3017b
            r7 = r0
            co.hyperverge.hypersnapsdk.b.g.e r7 = (co.hyperverge.hypersnapsdk.b.g.e) r7
            if (r7 == 0) goto L_0x053f
            java.lang.String r12 = "uuid"
            java.lang.String r13 = "no"
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            java.lang.String r14 = "image/jpeg"
            okhttp3.MediaType r14 = okhttp3.MediaType.parse(r14)
            okhttp3.RequestBody r14 = okhttp3.RequestBody.create(r14, r0)
            java.lang.String r0 = r0.getName()
            java.lang.String r15 = "image"
            okhttp3.MultipartBody$Part r14 = okhttp3.MultipartBody.Part.createFormData(r15, r0, r14)
            org.json.JSONObject r15 = r9.getLivenessParams()
            boolean r0 = r9.isShouldUseDefaultZoom()     // Catch:{ JSONException -> 0x0204 }
            if (r0 == 0) goto L_0x01db
            java.lang.String r0 = "zoom-factor"
            float r16 = co.hyperverge.hypersnapsdk.f.a.f3177b     // Catch:{ JSONException -> 0x0204 }
            java.lang.String r8 = java.lang.String.valueOf(r16)     // Catch:{ JSONException -> 0x0204 }
            r15.put(r0, r8)     // Catch:{ JSONException -> 0x0204 }
        L_0x01db:
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x0204 }
            if (r0 == 0) goto L_0x0203
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x0204 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r0 = r0.getHyperSnapRegion()     // Catch:{ JSONException -> 0x0204 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r8 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.ASIA_PACIFIC     // Catch:{ JSONException -> 0x0204 }
            if (r0 == r8) goto L_0x01fd
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x0204 }
            if (r0 == 0) goto L_0x01fc
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x0204 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r0 = r0.getHyperSnapRegion()     // Catch:{ JSONException -> 0x0204 }
            co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region r5 = co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region.AsiaPacific     // Catch:{ JSONException -> 0x0204 }
            if (r0 != r5) goto L_0x0216
            goto L_0x01fd
        L_0x01fc:
            throw r5     // Catch:{ JSONException -> 0x0204 }
        L_0x01fd:
            java.lang.String r0 = "validateFaceSize"
            r15.put(r0, r13)     // Catch:{ JSONException -> 0x0204 }
            goto L_0x0216
        L_0x0203:
            throw r5     // Catch:{ JSONException -> 0x0204 }
        L_0x0204:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.c.n r5 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r5 = r5.i
            if (r5 == 0) goto L_0x0216
            co.hyperverge.hypersnapsdk.c.n r5 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r5 = r5.i
            r5.a(r0)
        L_0x0216:
            if (r6 == 0) goto L_0x0251
            java.lang.String r0 = r9.getLivenessEndpoint()
            boolean r5 = co.hyperverge.hypersnapsdk.c.k.a(r0)
            if (r5 != 0) goto L_0x0234
            java.lang.String r5 = "apac"
            boolean r5 = r0.contains(r5)
            if (r5 != 0) goto L_0x0232
            java.lang.String r5 = "ind"
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0234
        L_0x0232:
            r0 = 1
            goto L_0x0235
        L_0x0234:
            r0 = 0
        L_0x0235:
            if (r0 == 0) goto L_0x0251
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            java.lang.String r5 = "video/mp4"
            okhttp3.MediaType r5 = okhttp3.MediaType.parse(r5)
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create(r5, r0)
            java.lang.String r0 = r0.getName()
            java.lang.String r8 = "video"
            okhttp3.MultipartBody$Part r0 = okhttp3.MultipartBody.Part.createFormData(r8, r0, r5)
            goto L_0x0252
        L_0x0251:
            r0 = 0
        L_0x0252:
            r5 = r0
            if (r3 == 0) goto L_0x02a6
            boolean r0 = r27.isEmpty()
            if (r0 != 0) goto L_0x02a6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0291 }
            r0.<init>()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r8 = "x1"
            java.lang.Object r11 = r3.get(r11)     // Catch:{ Exception -> 0x0291 }
            r0.put(r8, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r8 = "y1"
            r11 = 1
            java.lang.Object r11 = r3.get(r11)     // Catch:{ Exception -> 0x0291 }
            r0.put(r8, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r8 = "x2"
            r11 = 2
            java.lang.Object r11 = r3.get(r11)     // Catch:{ Exception -> 0x0291 }
            r0.put(r8, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r8 = "y2"
            r11 = 3
            java.lang.Object r3 = r3.get(r11)     // Catch:{ Exception -> 0x0291 }
            r0.put(r8, r3)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "face-coordinates"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0291 }
            r15.put(r3, r0)     // Catch:{ Exception -> 0x0291 }
            goto L_0x02a6
        L_0x0291:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i
            if (r3 == 0) goto L_0x02a6
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i
            r3.a(r0)
        L_0x02a6:
            java.util.Map r3 = r7.e(r15)
            co.hyperverge.hypersnapsdk.c.i r8 = co.hyperverge.hypersnapsdk.c.i.b()
            if (r8 == 0) goto L_0x053d
            java.lang.String r0 = "X"
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            co.hyperverge.hypersnapsdk.c.n r15 = co.hyperverge.hypersnapsdk.c.n.m()
            java.lang.String r16 = "text/plain"
            if (r15 == 0) goto L_0x03e7
            co.hyperverge.hypersnapsdk.c.n r15 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r15 = r15.w()
            if (r15 == 0) goto L_0x03e7
            boolean r15 = r9.getShouldUseBackCamera()
            if (r15 == 0) goto L_0x02d5
            boolean r15 = r9.isShouldUseDefaultZoom()
            if (r15 != 0) goto L_0x03e7
        L_0x02d5:
            long r17 = java.lang.System.currentTimeMillis()
        L_0x02d9:
            java.util.concurrent.atomic.AtomicBoolean r15 = r8.f3105f
            boolean r15 = r15.get()
            if (r15 != 0) goto L_0x02ed
            long r19 = java.lang.System.currentTimeMillis()
            long r19 = r19 - r17
            r21 = 10000(0x2710, double:4.9407E-320)
            int r15 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r15 <= 0) goto L_0x02d9
        L_0x02ed:
            org.json.JSONArray r15 = new org.json.JSONArray     // Catch:{ Exception -> 0x03c4 }
            r15.<init>()     // Catch:{ Exception -> 0x03c4 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x03c4 }
            r1.<init>()     // Catch:{ Exception -> 0x03c4 }
            r17 = r10
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03bc }
            float r10 = r10.redChannelDistance     // Catch:{ Exception -> 0x03bc }
            r28 = r5
            r18 = r6
            double r5 = r8.a(r10)     // Catch:{ Exception -> 0x03ba }
            r15.put(r5)     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r5 = r8.g     // Catch:{ Exception -> 0x03ba }
            float r5 = r5.greenChannelDistance     // Catch:{ Exception -> 0x03ba }
            double r5 = r8.a(r5)     // Catch:{ Exception -> 0x03ba }
            r15.put(r5)     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r5 = r8.g     // Catch:{ Exception -> 0x03ba }
            float r5 = r5.blueChannelDistance     // Catch:{ Exception -> 0x03ba }
            double r5 = r8.a(r5)     // Catch:{ Exception -> 0x03ba }
            r15.put(r5)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r5 = "isEmulator"
            boolean r6 = co.hyperverge.hypersnapsdk.f.i.b()     // Catch:{ Exception -> 0x03ba }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r5 = "frameDiffs"
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03ba }
            java.util.List<java.lang.Integer> r10 = r10.frameDistanceValue     // Catch:{ Exception -> 0x03ba }
            r6.<init>(r10)     // Catch:{ Exception -> 0x03ba }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r5 = "frameDataLength"
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03ba }
            java.util.List<java.lang.Long> r10 = r10.frameDataLength     // Catch:{ Exception -> 0x03ba }
            r6.<init>(r10)     // Catch:{ Exception -> 0x03ba }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r5 = "imageSize"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ba }
            r6.<init>()     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03ba }
            int r10 = r10.imageWidth     // Catch:{ Exception -> 0x03ba }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x03ba }
            r6.append(r10)     // Catch:{ Exception -> 0x03ba }
            r6.append(r0)     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03ba }
            int r10 = r10.imageHeight     // Catch:{ Exception -> 0x03ba }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x03ba }
            r6.append(r10)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x03ba }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r5 = "cameraCaptureSize"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03ba }
            r6.<init>()     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r10 = r8.g     // Catch:{ Exception -> 0x03ba }
            int r10 = r10.captureWidth     // Catch:{ Exception -> 0x03ba }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x03ba }
            r6.append(r10)     // Catch:{ Exception -> 0x03ba }
            r6.append(r0)     // Catch:{ Exception -> 0x03ba }
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r0 = r8.g     // Catch:{ Exception -> 0x03ba }
            int r0 = r0.captureHeight     // Catch:{ Exception -> 0x03ba }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x03ba }
            r6.append(r0)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x03ba }
            r1.put(r5, r0)     // Catch:{ Exception -> 0x03ba }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f3105f     // Catch:{ Exception -> 0x03ba }
            boolean r0 = r0.get()     // Catch:{ Exception -> 0x03ba }
            if (r0 == 0) goto L_0x03a8
            java.lang.String r0 = "channelDiffs"
            r1.put(r0, r15)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r0 = "blocksDiff"
            co.hyperverge.hypersnapsdk.model.ImageComparisonObj r5 = r8.g     // Catch:{ Exception -> 0x03ba }
            float r5 = r5.similarityScore     // Catch:{ Exception -> 0x03ba }
            double r5 = (double) r5     // Catch:{ Exception -> 0x03ba }
            r1.put(r0, r5)     // Catch:{ Exception -> 0x03ba }
        L_0x03a8:
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r16)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03ba }
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r1)     // Catch:{ Exception -> 0x03ba }
            java.lang.String r1 = "captureData"
            r11.put(r1, r0)     // Catch:{ Exception -> 0x03ba }
            goto L_0x03df
        L_0x03ba:
            r0 = move-exception
            goto L_0x03cb
        L_0x03bc:
            r0 = move-exception
            r28 = r5
            r18 = r6
            goto L_0x03cb
        L_0x03c2:
            r0 = move-exception
            goto L_0x03e3
        L_0x03c4:
            r0 = move-exception
            r28 = r5
            r18 = r6
            r17 = r10
        L_0x03cb:
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ all -> 0x03c2 }
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i     // Catch:{ all -> 0x03c2 }
            if (r1 == 0) goto L_0x03dc
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ all -> 0x03c2 }
            co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i     // Catch:{ all -> 0x03c2 }
            r1.a(r0)     // Catch:{ all -> 0x03c2 }
        L_0x03dc:
            r0.toString()     // Catch:{ all -> 0x03c2 }
        L_0x03df:
            r8.c()
            goto L_0x03ed
        L_0x03e3:
            r8.c()
            throw r0
        L_0x03e7:
            r28 = r5
            r18 = r6
            r17 = r10
        L_0x03ed:
            r0 = r3
            java.util.HashMap r0 = (java.util.HashMap) r0
            r0.putAll(r11)
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r16)
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r13)
            boolean r1 = r9.getShouldUseBackCamera()
            if (r1 == 0) goto L_0x040b
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r16)
            java.lang.String r1 = "yes"
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r1)
        L_0x040b:
            r1 = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r5 = r9.getHeaders()
            if (r5 == 0) goto L_0x0420
            org.json.JSONObject r0 = r9.getHeaders()
        L_0x0420:
            r7.a(r0)
            com.google.gson.Gson r5 = new com.google.gson.Gson
            r5.<init>()
            java.lang.String r6 = r0.toString()
            java.lang.Class<java.util.HashMap> r8 = java.util.HashMap.class
            java.lang.Object r5 = r5.fromJson(r6, r8)
            java.util.Map r5 = (java.util.Map) r5
            co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r6 == 0) goto L_0x053b
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r6 = r6.getAccessToken()
            if (r6 == 0) goto L_0x046a
            co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r6 == 0) goto L_0x0468
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r6 = r6.getAccessToken()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x046a
            co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r6 == 0) goto L_0x0466
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r6 = r6.getAccessToken()
            java.lang.String r8 = "Authorization"
            r5.put(r8, r6)
            goto L_0x048c
        L_0x0466:
            r0 = 0
            throw r0
        L_0x0468:
            r0 = 0
            throw r0
        L_0x046a:
            co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r6 == 0) goto L_0x0539
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r6 = r6.getAppId()
            java.lang.String r8 = "appId"
            r5.put(r8, r6)
            co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r6 == 0) goto L_0x0537
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r6 = r6.getAppKey()
            java.lang.String r8 = "appKey"
            r5.put(r8, r6)
        L_0x048c:
            boolean r6 = r9.isUseBothImagesSignature()
            if (r6 == 0) goto L_0x049b
            if (r2 == 0) goto L_0x0499
            java.lang.String r0 = co.hyperverge.hypersnapsdk.b.g.f.a(r4, r2, r0)
            goto L_0x049f
        L_0x0499:
            r0 = 0
            goto L_0x049f
        L_0x049b:
            java.lang.String r0 = co.hyperverge.hypersnapsdk.b.g.f.a(r4, r0)
        L_0x049f:
            r2 = r0
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ Exception -> 0x04bc }
            if (r0 == 0) goto L_0x04ba
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ Exception -> 0x04bc }
            boolean r0 = r0.isShouldUseSignature()     // Catch:{ Exception -> 0x04bc }
            if (r0 == 0) goto L_0x04d1
            if (r2 == 0) goto L_0x04d1
            boolean r0 = r5.containsKey(r12)     // Catch:{ Exception -> 0x04bc }
            if (r0 != 0) goto L_0x04d1
            r5.put(r12, r2)     // Catch:{ Exception -> 0x04bc }
            goto L_0x04d1
        L_0x04ba:
            r0 = 0
            throw r0     // Catch:{ Exception -> 0x04bc }
        L_0x04bc:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
            if (r6 == 0) goto L_0x04d1
            co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
            r6.a(r0)
        L_0x04d1:
            boolean r0 = r9.isShouldRecordVideo()
            if (r0 == 0) goto L_0x04f2
            if (r18 == 0) goto L_0x04f2
            co.hyperverge.hypersnapsdk.b.g.b r0 = co.hyperverge.hypersnapsdk.b.g.a.b()
            java.lang.String r6 = r9.getLivenessEndpoint()
            r24 = r0
            r25 = r6
            r26 = r5
            r27 = r14
            r29 = r3
            r30 = r1
            retrofit2.Call r0 = r24.a(r25, r26, r27, r28, r29, r30)
            goto L_0x050a
        L_0x04f2:
            co.hyperverge.hypersnapsdk.b.g.b r0 = co.hyperverge.hypersnapsdk.b.g.a.b()
            java.lang.String r6 = r9.getLivenessEndpoint()
            r24 = r0
            r25 = r6
            r26 = r5
            r27 = r14
            r28 = r3
            r29 = r1
            retrofit2.Call r0 = r24.a(r25, r26, r27, r28, r29)
        L_0x050a:
            co.hyperverge.hypersnapsdk.b.g.e$c r1 = new co.hyperverge.hypersnapsdk.b.g.e$c
            r3 = r17
            r1.<init>(r2, r9, r3)
            r0.enqueue(r1)
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r0 = r0.o
            if (r0 == 0) goto L_0x0531
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            if (r0 == 0) goto L_0x0531
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            java.lang.String r1 = r9.getLivenessEndpoint()
            r0.a(r1, r4)
        L_0x0531:
            r0 = 0
            r1 = r23
        L_0x0534:
            r1.m = r0
        L_0x0536:
            return
        L_0x0537:
            r0 = 0
            throw r0
        L_0x0539:
            r0 = 0
            throw r0
        L_0x053b:
            r0 = 0
            throw r0
        L_0x053d:
            r0 = 0
            throw r0
        L_0x053f:
            throw r5
        L_0x0540:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.d.a.a.d.a(co.hyperverge.hypersnapsdk.d.a.a.d, java.lang.String, java.lang.String, java.lang.String, java.util.List, co.hyperverge.hypersnapsdk.objects.IPAddress, co.hyperverge.hypersnapsdk.c.d, java.lang.String):void");
    }

    public void a(HVError hVError, LivenessResponse livenessResponse) {
        if (n.m().o && n.m().j != null) {
            n.m().j.a(hVError, livenessResponse, this.z);
        }
        a(false);
        a(livenessResponse, hVError);
    }

    public void a(boolean z2) {
        co.hyperverge.hypersnapsdk.f.j.a aVar = this.r;
        aVar.f3185b.post(new Runnable(z2) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                d.this.c(this.f$1);
            }
        });
    }

    public final HVBaseResponse a(LivenessResponse livenessResponse, boolean z2) {
        JSONObject jSONObject;
        HVBaseResponse hVBaseResponse;
        JSONObject jSONObject2 = new JSONObject();
        if (livenessResponse != null) {
            JSONObject jSONObject3 = livenessResponse.response;
            if (jSONObject3 != null) {
                if (this.t == LivenessMode.TEXTURELIVENESS && n.m().o) {
                    n.m().j.a(livenessResponse, this.z, this.A);
                }
                jSONObject2 = jSONObject3;
            }
            jSONObject = livenessResponse.headers;
        } else {
            jSONObject = null;
        }
        if (z2) {
            hVBaseResponse = new HVBaseResponse(jSONObject2, jSONObject, this.x, this.C);
        } else {
            hVBaseResponse = new HVResponse(jSONObject2, jSONObject, this.x, this.C);
        }
        hVBaseResponse.setRetakeMessage(this.D);
        hVBaseResponse.setAttemptsCount(o.a(this.z.getLivenessEndpoint(), ""));
        if (this.z.isShouldReturnFullImageUrl()) {
            hVBaseResponse.setFullImageURI(this.h);
        } else if (!k.a(this.h)) {
            new File(this.h).delete();
        }
        if (this.z.isShouldAddWaterMark()) {
            if (HyperSnapSDK.getInstance() == null) {
                throw null;
            } else if (HyperSnapSDK.f2946b.isShouldUseLocation()) {
                hVBaseResponse.setWaterMarkFullImageUri(this.I);
                hVBaseResponse.setWaterMarkCroppedImageUri(this.J);
            }
        }
        hVBaseResponse.setVideoUri(this.G);
        hVBaseResponse.toString();
        return hVBaseResponse;
    }

    public void a(LivenessResponse livenessResponse, HVError hVError) {
        if (this.v != null) {
            try {
                HVResponse hVResponse = (HVResponse) a(livenessResponse, false);
                hVResponse.setRetakeAttemptResponses(this.L);
                co.hyperverge.hypersnapsdk.f.j.a aVar = this.r;
                aVar.f3185b.post(new Runnable(hVError, hVResponse) {
                    public final /* synthetic */ HVError f$1;
                    public final /* synthetic */ HVResponse f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        d.this.c(this.f$1, this.f$2);
                    }
                });
            } catch (Exception e2) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    private void a(LivenessResponse livenessResponse, String str, boolean z2, String str2, String str3, HVError hVError) {
        this.C = str3;
        this.D = str2;
        if (z2) {
            this.L.add(a(livenessResponse, true));
            Intent intent = new Intent(((c) this.k).getActivity(), HVRetakeActivity.class);
            intent.putExtra("imageUri", str);
            intent.putExtra("retryMessage", str2);
            intent.putExtra("config", this.z);
            intent.putExtra("face", true);
            intent.putExtra("radius", ((c) this.k).m.getDiameter() / 2);
            ((c) this.k).getActivity().startActivityForResult(intent, 1);
            return;
        }
        a(livenessResponse, hVError);
    }

    /* access modifiers changed from: private */
    public void a(byte[] bArr, long j2) {
        i iVar = this.E;
        if (iVar == null) {
            throw null;
        } else if (n.m() != null && n.m().w()) {
            try {
                if (iVar.h == 0) {
                    iVar.j = Arrays.copyOfRange(bArr, 0, 50);
                }
                iVar.g.frameDataLength.set(iVar.h % 10, Long.valueOf(j2));
                int i2 = iVar.h + 1;
                iVar.h = i2;
                if (i2 % 10 == 0) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 50);
                    iVar.k = copyOfRange;
                    byte[] bArr2 = iVar.j;
                    double d2 = 0.0d;
                    for (int i3 = 0; i3 < copyOfRange.length; i3++) {
                        d2 += Math.pow((double) (copyOfRange[i3] - bArr2[i3]), 2.0d);
                    }
                    iVar.g.frameDistanceValue.add(Integer.valueOf((int) Math.sqrt(d2)));
                    byte[] bArr3 = iVar.k;
                    iVar.j = Arrays.copyOf(bArr3, bArr3.length);
                }
            } catch (Exception e2) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }
}
