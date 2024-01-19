package co.hyperverge.hypersnapsdk.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import co.hyperverge.hvcamera.HVCamHost;
import co.hyperverge.hvcamera.HVMagicView;
import co.hyperverge.hvcamera.HVMagicView.SensorCallback;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.R$color;
import co.hyperverge.hypersnapsdk.R$dimen;
import co.hyperverge.hypersnapsdk.R$drawable;
import co.hyperverge.hypersnapsdk.R$id;
import co.hyperverge.hypersnapsdk.R$layout;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.o;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.listeners.DocCaptureCompletionHandler;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import co.hyperverge.hypersnapsdk.objects.HVBaseResponse;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig.Document;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import co.hyperverge.hypersnapsdk.objects.HyperSnapParams$Region;
import co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig;
import co.hyperverge.hypersnapsdk.objects.IPAddress;
import co.hyperverge.hypersnapsdk.service.b.a$a;
import co.hyperverge.hypersnapsdk.service.qr.HVBarcodeDetector;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ClickableViewAccessibility", "LogNotTimber"})
public class HVDocsActivity extends a implements OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2965d = HVDocsActivity.class.getCanonicalName();

    /* renamed from: f  reason: collision with root package name */
    public static DocCaptureCompletionHandler f2966f;
    public final float[] A;
    public final float[] B;
    public final float[] C;
    public final float[] D;
    public FrameLayout G;
    public FrameLayout H;
    public HVMagicView I;
    public View J;
    public View K;
    public IPAddress L;
    public final AnimationListener M;
    public ConstraintLayout N;
    public ImageView O;
    public ImageView P;
    public TextView Q;
    public TextView R;
    public co.hyperverge.hypersnapsdk.views.b S;
    public co.hyperverge.hypersnapsdk.views.d T;
    public File U;
    public File V;
    public boolean W;
    public SensorManager X;
    public co.hyperverge.hypersnapsdk.f.f Y;
    public SensorEventListener Z;
    public String a0;
    public String b0;
    public String c0;
    public double d0;
    public String e0;
    public String f0;
    public Document g;
    public String g0;
    public HVDocConfig h;
    public File h0;
    public final q i = new q();
    public File i0;
    public final q j = new q();
    public int j0;
    public final q k = new q();
    public int k0;
    public final q l = new q();
    public float l0;
    public final q m = new q();
    public float m0;
    public final q n = new q();
    public float n0;
    public final q o = new q();
    public AtomicBoolean o0;
    public HVError p;
    public int p0;
    public final HVBarcodeDetector q = new HVBarcodeDetector();
    public int q0;
    public boolean r = false;
    public final HVCamHost r0;
    public final Handler s = new Handler();
    public float s0;
    public String t = "";
    public float t0;
    public int u = 0;
    public final HVResponse u0;
    public Location v;
    public final ArrayList<HVBaseResponse> v0;
    public final float[][] w;
    public final float[][] x;
    public final float[][] y;
    public final float[][] z;

    public class a implements AnimationListener {
        public a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class b implements AnimationListener {
        public b() {
        }

        public void onAnimationEnd(Animation animation) {
            HVDocsActivity.this.J.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            HVDocsActivity.this.J.setVisibility(0);
        }
    }

    public class c extends HVCamHost {

        public class a implements k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ co.hyperverge.hypersnapsdk.c.d f2970a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f2971b;

            /* renamed from: co.hyperverge.hypersnapsdk.activities.HVDocsActivity$c$a$a  reason: collision with other inner class name */
            public class C0051a implements a$a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f2973a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f2974b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ JSONObject f2975c;

                public C0051a(String str, String str2, JSONObject jSONObject) {
                    this.f2973a = str;
                    this.f2974b = str2;
                    this.f2975c = jSONObject;
                }

                public void a(IPAddress iPAddress) {
                    a aVar = a.this;
                    c cVar = c.this;
                    HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                    hVDocsActivity.L = iPAddress;
                    String str = this.f2973a;
                    String str2 = hVDocsActivity.f0;
                    c.a(cVar, str, str2, this.f2974b, iPAddress, aVar.f2970a, aVar.f2971b, this.f2975c);
                }

                public void a() {
                    a aVar = a.this;
                    c cVar = c.this;
                    c.a(cVar, this.f2973a, HVDocsActivity.this.f0, this.f2974b, null, aVar.f2970a, aVar.f2971b, this.f2975c);
                }
            }

            public a(co.hyperverge.hypersnapsdk.c.d dVar, ProgressDialog progressDialog) {
                this.f2970a = dVar;
                this.f2971b = progressDialog;
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ float f2977a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ float f2978b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f2979c;

            public b(float f2, float f3, boolean z) {
                this.f2977a = f2;
                this.f2978b = f3;
                this.f2979c = z;
            }

            public void run() {
                float f2 = this.f2977a;
                if (f2 > 0.0f || this.f2978b > 0.0f) {
                    HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                    hVDocsActivity.S.a(f2 * ((float) hVDocsActivity.j0), this.f2978b * ((float) hVDocsActivity.k0), this.f2979c);
                    return;
                }
                HVDocsActivity hVDocsActivity2 = HVDocsActivity.this;
                hVDocsActivity2.S.a((float) (hVDocsActivity2.j0 / 2), (float) (hVDocsActivity2.k0 / 2), this.f2979c);
            }
        }

        /* renamed from: co.hyperverge.hypersnapsdk.activities.HVDocsActivity$c$c  reason: collision with other inner class name */
        public class C0052c implements Runnable {
            public C0052c() {
            }

            public void run() {
                HVDocsActivity.i(HVDocsActivity.this);
            }
        }

        public c() {
        }

        public static void a(c cVar, String str, String str2, String str3, IPAddress iPAddress, co.hyperverge.hypersnapsdk.c.d dVar, ProgressDialog progressDialog, JSONObject jSONObject) {
            if (HVDocsActivity.this.h.isShouldReadQR()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                try {
                    HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                    hVDocsActivity.t = hVDocsActivity.q.detect(decodeFile);
                } catch (NoClassDefFoundError unused) {
                    String str4 = HVDocsActivity.f2965d;
                }
                JSONObject ocrParams = HVDocsActivity.this.h.getOcrParams();
                try {
                    ocrParams.put("qrString", HVDocsActivity.this.t);
                    HVDocsActivity.this.h.ocrParams = ocrParams.toString();
                } catch (Exception e2) {
                    String str5 = HVDocsActivity.f2965d;
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                }
                decodeFile.recycle();
            }
            dVar.a(str, str3, iPAddress);
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
            if (HVDocsActivity.this.h.shouldShowReviewScreen()) {
                HVDocsActivity.this.startReviewScreen(str, str2);
            } else if (HVDocsActivity.this.h.isShouldDoOCR()) {
                HVDocsActivity.this.makeOCRAPICall(str, str2);
            } else {
                HVDocsActivity.this.stopCamera();
                HVDocsActivity.this.c(null, new HVResponse(jSONObject, new JSONObject(), str, HVDocsActivity.this.b0));
            }
        }

        public void flashScreen() {
            new Handler(Looper.getMainLooper()).post(new C0052c());
        }

        public int getAspectRatio() {
            return 1;
        }

        public File getPhotoDirectory() {
            return new File(HVDocsActivity.this.e0).getParentFile();
        }

        public String getPhotoFilename() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("IS_");
            outline73.append(System.currentTimeMillis());
            outline73.append(".jpg");
            return outline73.toString();
        }

        public float getPictureMegapixels() {
            return 2.0f;
        }

        public float getPreviewMegapixels() {
            return 2.0f;
        }

        public String getVideoFilename() {
            return null;
        }

        public boolean isShouldCaptureHighResolutionImage() {
            return HVDocsActivity.this.h.isShouldReadQR();
        }

        public void onCameraFlipCallback() {
        }

        public void onCamerasFound(int i) {
        }

        public void onFilterMode(int i, String str) {
        }

        public void onFlashAuto() {
            HVDocsActivity.this.h.isShouldShowFlashIcon();
        }

        public void onFlashNull() {
        }

        public void onFlashOff() {
            try {
                if (HVDocsActivity.this.h.isShouldShowFlashIcon()) {
                    HVDocsActivity.this.O.setVisibility(0);
                    HVDocsActivity.this.O.setImageResource(R$drawable.ic_torch_off_svg);
                }
            } catch (Exception e2) {
                String str = HVDocsActivity.f2965d;
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }

        public void onFlashOn() {
            try {
                if (HVDocsActivity.this.h.isShouldShowFlashIcon()) {
                    HVDocsActivity.this.O.setVisibility(0);
                    HVDocsActivity.this.O.setImageResource(R$drawable.ic_torch_on_svg);
                    if (!CameraEngine.f2908a) {
                        HVDocsActivity.this.I.nextFlashMode();
                    }
                }
            } catch (Exception e2) {
                String str = HVDocsActivity.f2965d;
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }

        public void onFlashTorchOn() {
        }

        public void onLayoutChange() {
            HVDocsActivity.this.a(true);
        }

        public void onNewPreviewFrame(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2) {
        }

        public void onPictureFailed() {
            HVDocsActivity.this.o0.set(true);
            HVDocsActivity.this.p = new HVError(2, "failure logged in document onPictureFailed()");
            long longValue = HVDocsActivity.this.m.c().longValue();
            if (n.m().o && n.m().j != null) {
                co.hyperverge.hypersnapsdk.a.b bVar = n.m().j;
                HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                bVar.a(hVDocsActivity.p, hVDocsActivity.h, longValue);
            }
        }

        public void onPictureReady(byte[] bArr) {
            long longValue = HVDocsActivity.this.m.c().longValue();
            if (n.m().o && n.m().j != null) {
                n.m().j.b(HVDocsActivity.this.h, longValue);
            }
            co.hyperverge.hypersnapsdk.c.d dVar = new co.hyperverge.hypersnapsdk.c.d();
            HVDocsActivity hVDocsActivity = HVDocsActivity.this;
            dVar.a(bArr, hVDocsActivity.e0, hVDocsActivity.v);
            try {
                ProgressDialog progressDialog = new ProgressDialog(HVDocsActivity.this);
                progressDialog.setMessage(co.hyperverge.hypersnapsdk.c.k.f3108c);
                progressDialog.setCancelable(false);
                progressDialog.show();
                HVDocsActivity hVDocsActivity2 = HVDocsActivity.this;
                new l(bArr, hVDocsActivity2, new a(dVar, progressDialog)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e2) {
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }

        public void onPictureSaved(File file) {
            long longValue = HVDocsActivity.this.m.c().longValue();
            if (n.m().o && n.m().j != null) {
                n.m().j.a(HVDocsActivity.this.h, file.getAbsolutePath(), longValue);
            }
        }

        public void onPictureSizeSet(int i, int i2) {
        }

        public void onReady() {
        }

        public void onViewDimensionChange(int i, int i2) {
            HVDocsActivity hVDocsActivity = HVDocsActivity.this;
            hVDocsActivity.k0 = i2;
            hVDocsActivity.j0 = i;
            hVDocsActivity.i();
            HVDocsActivity.this.j();
            HVDocsActivity.this.adjustHintText();
        }

        public void setScreenFlashOff() {
        }

        public void showCrossHair(float f2, float f3, boolean z) {
            new Handler(Looper.getMainLooper()).post(new b(f2, f3, z));
        }

        public void zoomMaxLevel(int i) {
        }
    }

    public class d implements co.hyperverge.hypersnapsdk.listeners.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f2982a;

        public d(Context context) {
            this.f2982a = context;
        }

        public void a(Location location) {
            if (location != null) {
                HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                if (hVDocsActivity.P != null) {
                    hVDocsActivity.l();
                }
                HVDocsActivity.this.v = location;
                return;
            }
            HVDocsActivity.this.v = co.hyperverge.hypersnapsdk.service.c.a.a(this.f2982a).a();
            HVDocsActivity hVDocsActivity2 = HVDocsActivity.this;
            if (hVDocsActivity2.v != null && hVDocsActivity2.P != null) {
                hVDocsActivity2.l();
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HVDocsActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1001);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HVDocsActivity.b(new HVError(33, "GPS access denied by user"), null);
            HVDocsActivity.this.finish();
        }
    }

    public class g implements SensorEventListener {
        public g() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                int type = sensorEvent.sensor.getType();
                if (type == 1) {
                    HVDocsActivity.this.y[0] = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    HVDocsActivity.this.z[0] = (float[]) sensorEvent.values.clone();
                }
                HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                float[][] fArr = hVDocsActivity.z;
                if (fArr[0] != null) {
                    float[][] fArr2 = hVDocsActivity.y;
                    if (fArr2[0] != null) {
                        float[][] fArr3 = hVDocsActivity.w;
                        fArr3[0] = new float[9];
                        float[][] fArr4 = hVDocsActivity.x;
                        fArr4[0] = new float[9];
                        SensorManager.getRotationMatrix(fArr3[0], fArr4[0], fArr2[0], fArr[0]);
                        HVDocsActivity hVDocsActivity2 = HVDocsActivity.this;
                        SensorManager.getOrientation(hVDocsActivity2.w[0], hVDocsActivity2.A);
                        HVDocsActivity hVDocsActivity3 = HVDocsActivity.this;
                        float[] fArr5 = hVDocsActivity3.B;
                        float[] fArr6 = hVDocsActivity3.A;
                        fArr5[0] = fArr6[0] * 57.29578f;
                        float[] fArr7 = hVDocsActivity3.C;
                        fArr7[0] = fArr6[1] * 57.29578f;
                        hVDocsActivity3.D[0] = fArr6[2] * 57.29578f;
                        hVDocsActivity3.z[0] = null;
                        hVDocsActivity3.y[0] = null;
                        if (fArr7[0] < ((float) hVDocsActivity3.h.getAllowedTiltPitch())) {
                            HVDocsActivity hVDocsActivity4 = HVDocsActivity.this;
                            if (hVDocsActivity4.C[0] > ((float) (hVDocsActivity4.h.getAllowedTiltPitch() * -1))) {
                                HVDocsActivity hVDocsActivity5 = HVDocsActivity.this;
                                if (hVDocsActivity5.D[0] < ((float) hVDocsActivity5.h.getAllowedTiltRoll())) {
                                    HVDocsActivity hVDocsActivity6 = HVDocsActivity.this;
                                    if (hVDocsActivity6.D[0] > ((float) (hVDocsActivity6.h.getAllowedTiltRoll() * -1))) {
                                        HVDocsActivity.this.P.setImageResource(R$drawable.ic_camera_button_svg);
                                        HVDocsActivity hVDocsActivity7 = HVDocsActivity.this;
                                        hVDocsActivity7.W = false;
                                        hVDocsActivity7.setDescText();
                                        return;
                                    }
                                }
                            }
                        }
                        HVDocsActivity.this.P.setImageResource(R$drawable.camera_disabled);
                        HVDocsActivity.this.P.setImageTintList(null);
                        HVDocsActivity hVDocsActivity8 = HVDocsActivity.this;
                        hVDocsActivity8.W = true;
                        hVDocsActivity8.setDescText();
                    }
                }
            } catch (Exception e2) {
                String str = HVDocsActivity.f2965d;
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            if (n.m().n) {
                HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                hVDocsActivity.a((HVBaseConfig) hVDocsActivity.h, (View) null);
            }
        }
    }

    public class i implements SensorCallback {
        public i() {
        }

        public void onSensorCallback() {
            HVDocsActivity.this.H.getWidth();
            HVDocsActivity.this.H.getHeight();
            HVDocsActivity hVDocsActivity = HVDocsActivity.this;
            hVDocsActivity.S.a((float) (hVDocsActivity.j0 / 2), (float) (hVDocsActivity.k0 / 2), false);
        }
    }

    public class j implements OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2989a;

        public j() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!HVDocsActivity.this.h.isShouldAllowPhoneTilt() && HVDocsActivity.this.W) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2989a = HVDocsActivity.this.o0.get();
                if (HVDocsActivity.this.o0.get()) {
                    HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                    ImageView imageView = hVDocsActivity.P;
                    imageView.clearAnimation();
                    imageView.clearAnimation();
                    ScaleAnimation scaleAnimation = r7;
                    ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(150);
                    scaleAnimation.setInterpolator(new AccelerateInterpolator());
                    scaleAnimation.setFillAfter(true);
                    imageView.startAnimation(scaleAnimation);
                    hVDocsActivity.P.startAnimation(scaleAnimation);
                }
            } else if (action == 1 && this.f2989a) {
                HVDocsActivity hVDocsActivity2 = HVDocsActivity.this;
                ImageView imageView2 = hVDocsActivity2.P;
                imageView2.clearAnimation();
                hVDocsActivity2.P.clearAnimation();
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation3.setDuration(150);
                scaleAnimation3.setInterpolator(new AccelerateInterpolator());
                scaleAnimation3.setFillAfter(true);
                scaleAnimation3.setAnimationListener(new a());
                hVDocsActivity2.P.startAnimation(scaleAnimation3);
                imageView2.startAnimation(scaleAnimation3);
            }
            return false;
        }
    }

    public interface k {
    }

    public class l extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f2991a;

        /* renamed from: b  reason: collision with root package name */
        public Context f2992b;

        /* renamed from: c  reason: collision with root package name */
        public k f2993c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f2994d;

        public l(byte[] bArr, Context context, k kVar) {
            this.f2991a = bArr;
            this.f2992b = context;
            this.f2993c = kVar;
        }

        public Bitmap a(Bitmap bitmap) {
            try {
                double width = (double) (((float) bitmap.getWidth()) * HVDocsActivity.this.g.getAspectRatio() * HVDocsActivity.this.h.padding);
                HVDocsActivity.this.n();
                HVDocsActivity.this.o();
                if (!HVDocsActivity.this.h.isShouldSetPadding() || HVDocsActivity.this.g.getAspectRatio() > 1.0f) {
                    width = 0.0d;
                }
                HVDocsActivity.this.d0 = width;
                int o = (int) (((double) ((int) (((((float) HVDocsActivity.this.o()) + ((float) HVDocsActivity.this.p0)) / ((float) HVDocsActivity.this.k0)) * ((float) bitmap.getHeight())))) - width);
                if (o < 0) {
                    o = 0;
                }
                int n = (int) (((double) (((int) (((((float) HVDocsActivity.this.n()) + ((float) HVDocsActivity.this.p0)) / ((float) HVDocsActivity.this.k0)) * ((float) bitmap.getHeight()))) - o)) + width);
                if (n > bitmap.getHeight()) {
                    n = bitmap.getHeight();
                }
                if (o + n > bitmap.getHeight()) {
                    o = (int) (((((float) HVDocsActivity.this.o()) + ((float) HVDocsActivity.this.p0)) / ((float) HVDocsActivity.this.k0)) * ((float) bitmap.getHeight()));
                    n = ((int) (((((float) HVDocsActivity.this.n()) + ((float) HVDocsActivity.this.p0)) / ((float) HVDocsActivity.this.k0)) * ((float) bitmap.getHeight()))) - o;
                    HVDocsActivity.this.h.setShouldAddPadding(false);
                }
                return Bitmap.createBitmap(bitmap, 0, o, bitmap.getWidth(), n);
            } catch (Exception | OutOfMemoryError e2) {
                String str = HVDocsActivity.f2965d;
                co.hyperverge.hypersnapsdk.f.i.a(e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
                return null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
            throw r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doInBackground(java.lang.Object[] r6) {
            /*
                r5 = this;
                java.lang.Void[] r6 = (java.lang.Void[]) r6
                byte[] r6 = r5.f2991a
                int r6 = androidx.core.widget.CompoundButtonCompat.getOrientation(r6)
                byte[] r0 = r5.f2991a     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r1 = 0
                int r2 = r0.length     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r2)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                int r6 = co.hyperverge.hypersnapsdk.f.i.a(r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap r6 = co.hyperverge.hypersnapsdk.c.g.b(r0, r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                if (r6 != 0) goto L_0x001c
                goto L_0x00db
            L_0x001c:
                android.graphics.Bitmap r6 = r5.a(r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r0 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r2 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.lang.String r2 = r2.g0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r0.i0 = r1     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r1 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.File r1 = r1.i0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                int r2 = co.hyperverge.hypersnapsdk.f.i.f3183b     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r2 = 95
                r6.compress(r1, r2, r0)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r0.close()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r0 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.objects.HVDocConfig r0 = r0.h     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                boolean r0 = r0.isShouldReadQR()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                if (r0 == 0) goto L_0x0091
                android.graphics.Bitmap r0 = co.hyperverge.hypersnapsdk.f.i.a(r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r1 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r4 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.lang.String r4 = r4.f0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r1.h0 = r3     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                if (r0 != 0) goto L_0x0061
                goto L_0x00db
            L_0x0061:
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0083 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r3 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x0083 }
                java.io.File r3 = r3.h0     // Catch:{ Exception -> 0x0083 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0083 }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0075 }
                int r4 = co.hyperverge.hypersnapsdk.f.i.f3183b     // Catch:{ all -> 0x0075 }
                r0.compress(r3, r2, r1)     // Catch:{ all -> 0x0075 }
                r1.close()     // Catch:{ Exception -> 0x0083 }
                goto L_0x0089
            L_0x0075:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x0077 }
            L_0x0077:
                r4 = move-exception
                r1.close()     // Catch:{ all -> 0x007c }
                goto L_0x0080
            L_0x007c:
                r1 = move-exception
                r3.addSuppressed(r1)     // Catch:{ Exception -> 0x0083 }
            L_0x0080:
                throw r4     // Catch:{ Exception -> 0x0083 }
            L_0x0081:
                r6 = move-exception
                goto L_0x008d
            L_0x0083:
                r1 = move-exception
                java.lang.String r3 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.f2965d     // Catch:{ all -> 0x0081 }
                co.hyperverge.hypersnapsdk.f.i.a(r1)     // Catch:{ all -> 0x0081 }
            L_0x0089:
                r0.recycle()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                goto L_0x0091
            L_0x008d:
                r0.recycle()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                throw r6     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
            L_0x0091:
                android.graphics.Bitmap r0 = co.hyperverge.hypersnapsdk.f.i.b(r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r5.f2994d = r0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r6.recycle()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap r6 = r5.f2994d     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                if (r6 != 0) goto L_0x009f
                goto L_0x00db
            L_0x009f:
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r6 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r1 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.lang.String r1 = r1.e0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r6.U = r0     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                co.hyperverge.hypersnapsdk.activities.HVDocsActivity r0 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.this     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                java.io.File r0 = r0.U     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r6.<init>(r0)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap r0 = r5.f2994d     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                int r3 = co.hyperverge.hypersnapsdk.f.i.f3183b     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r0.compress(r1, r2, r6)     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                r6.close()     // Catch:{ Exception -> 0x00c4, OutOfMemoryError -> 0x00c2 }
                goto L_0x00db
            L_0x00c2:
                r6 = move-exception
                goto L_0x00c5
            L_0x00c4:
                r6 = move-exception
            L_0x00c5:
                java.lang.String r0 = co.hyperverge.hypersnapsdk.activities.HVDocsActivity.f2965d
                co.hyperverge.hypersnapsdk.f.i.a(r6)
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
                if (r0 == 0) goto L_0x00db
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
                r0.a(r6)
            L_0x00db:
                r6 = 0
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.activities.HVDocsActivity.l.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        public void onPostExecute(Object obj) {
            String str;
            Void voidR = (Void) obj;
            k kVar = this.f2993c;
            String str2 = HVDocsActivity.this.e0;
            Bitmap bitmap = this.f2994d;
            a aVar = (a) kVar;
            c.this.onPictureSaved(new File(str2));
            HVDocsActivity.this.o0.set(true);
            if (bitmap == null || !new File(str2).exists()) {
                HVDocsActivity.this.stopCamera();
                HVDocsActivity.this.c(new HVError(2, "Error while capturing the document"), new HVResponse(null, null, null, HVDocsActivity.this.b0));
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (HVDocsActivity.this.h.isShouldExportPDF()) {
                        HVDocsActivity hVDocsActivity = HVDocsActivity.this;
                        hVDocsActivity.a0 = co.hyperverge.hypersnapsdk.c.j.a(bitmap, HVDocsActivity.this.V.getPath() + "/hv_" + System.currentTimeMillis() + ".pdf");
                        jSONObject.put("pdfUri", HVDocsActivity.this.a0);
                    }
                    if (HVDocsActivity.this.h.getOcrHeaders() == null || !HVDocsActivity.this.h.getOcrHeaders().has("transactionId")) {
                        str = o.i();
                    } else {
                        str = HVDocsActivity.this.h.getOcrHeaders().getString("transactionId");
                    }
                    String str3 = str;
                    if (n.m().p().f3028c) {
                        new co.hyperverge.hypersnapsdk.service.b.b().a(new C0051a(str2, str3, jSONObject));
                    } else {
                        c cVar = c.this;
                        c.a(cVar, str2, HVDocsActivity.this.f0, str3, null, aVar.f2970a, aVar.f2971b, jSONObject);
                    }
                } catch (Exception e2) {
                    String str4 = HVDocsActivity.f2965d;
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                    if (n.m().i != null) {
                        n.m().i.a(e2);
                    }
                }
            }
            super.onPostExecute(voidR);
        }
    }

    public HVDocsActivity() {
        Class<float> cls = float.class;
        this.w = (float[][]) Array.newInstance(cls, new int[]{1, 1});
        this.x = (float[][]) Array.newInstance(cls, new int[]{1, 1});
        this.y = new float[][]{new float[3]};
        this.z = new float[][]{new float[3]};
        this.A = new float[3];
        this.B = new float[1];
        this.C = new float[1];
        this.D = new float[1];
        this.M = new b();
        this.W = false;
        this.p0 = 50;
        this.q0 = 35;
        this.r0 = new c();
        this.u0 = new HVResponse();
        this.v0 = new ArrayList<>();
    }

    public static void b(HVError hVError, HVResponse hVResponse) {
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                n.m().l.M();
            }
            f2966f.onResult(hVError, hVResponse);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        long longValue = this.k.c().longValue();
        if (n.m().o) {
            n.m().a(getApplicationContext()).m(longValue);
        }
        C();
    }

    public static void start(Context context, HVDocConfig hVDocConfig, DocCaptureCompletionHandler docCaptureCompletionHandler) {
        f2966f = docCaptureCompletionHandler;
        if (context == null) {
            b(new HVError(6, "Context object is null"), null);
            return;
        }
        HyperSnapSDK instance = HyperSnapSDK.getInstance();
        if (instance != null) {
            HyperSnapSDKConfig hyperSnapSDKConfig = HyperSnapSDK.f2946b;
            if (!instance.f2949f || ((hyperSnapSDKConfig.getAppId() != null && hyperSnapSDKConfig.getAppId().isEmpty()) || (hyperSnapSDKConfig.getAppKey() != null && hyperSnapSDKConfig.getAppKey().isEmpty()))) {
                b(new HVError(11, context.getResources().getString(R$string.initialised_error)), null);
                return;
            }
            if (hyperSnapSDKConfig.getHyperSnapRegion() == HyperSnapParams$Region.ASIA_PACIFIC) {
                if (!(HyperSnapSDK.getInstance().f2949f ? !TextUtils.isEmpty(o.i()) : false)) {
                    b(new HVError(11, context.getResources().getString(R$string.user_session_not_created_error)), null);
                    return;
                }
            }
            Intent intent = new Intent(context, HVDocsActivity.class);
            if (hVDocConfig.isShouldReadQR() && n.m().j().get("read-doc-qr") != null) {
                hVDocConfig.setShouldReadQR(n.m().j().get("read-doc-qr").booleanValue());
            }
            intent.putExtra(HVDocConfig.KEY, hVDocConfig);
            context.startActivity(intent);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void t() {
        this.r = true;
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(R$color.camera_button_color)));
            this.P.setImageResource(R$drawable.ic_camera_button_svg);
            this.P.setClickable(true);
            this.P.setEnabled(true);
        }
    }

    public final void A() {
        this.i.d();
        this.N.setVisibility(0);
        a((HVBaseConfig) this.h, (View) this.N);
        this.N.findViewById(R$id.ivClose).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                HVDocsActivity.this.a(view);
            }
        });
        this.N.findViewById(R$id.btnUploadDoc).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                HVDocsActivity.this.b(view);
            }
        });
        this.N.findViewById(R$id.btnCaptureDoc).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                HVDocsActivity.this.c(view);
            }
        });
        long longValue = this.i.c().longValue();
        if (n.m().o) {
            n.m().a(getApplicationContext()).g(longValue);
            n.m().a(getApplicationContext()).k();
        }
        this.j.d();
        this.k.d();
    }

    public final void C() {
        this.N.setVisibility(8);
        try {
            this.Y = new co.hyperverge.hypersnapsdk.f.f();
            if (n.m().j != null) {
                n.m().j.a(this.h);
            }
            if (this.h.isShouldShowInstructionPage()) {
                startInstructionActivity();
            } else {
                checkForPermissions();
            }
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            sendResponse(new HVError(2, getResources().getString(R$string.internal_error)));
        }
    }

    public JSONObject addResultImageUri(JSONObject jSONObject) {
        try {
            if (this.h.isShouldExportPDF()) {
                String str = this.a0;
                if (str != null) {
                    jSONObject.put("pdfUri", str);
                }
            }
        } catch (JSONException e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        return jSONObject;
    }

    public void adjustHintText() {
        LayoutParams layoutParams = (LayoutParams) this.R.getLayoutParams();
        if (this.g.getAspectRatio() < 1.0f) {
            layoutParams.setMargins(co.hyperverge.hypersnapsdk.f.h.a((Context) this, 30.0f), co.hyperverge.hypersnapsdk.f.h.a((Context) this, 60.0f), co.hyperverge.hypersnapsdk.f.h.a((Context) this, 30.0f), 0);
        }
        this.R.requestLayout();
        LayoutParams layoutParams2 = (LayoutParams) this.Q.getLayoutParams();
        layoutParams2.setMargins(0, n() - (this.g.getAspectRatio() < 1.0f ? -((int) getResources().getDimension(R$dimen.margin_doc_status_negative)) : (int) getResources().getDimension(R$dimen.margin_doc_status_top)), 0, 0);
        this.Q.setLayoutParams(layoutParams2);
        this.Q.requestLayout();
        this.H.requestLayout();
    }

    public void checkForPermissions() {
        this.n.d();
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"android.permission.CAMERA"}));
        this.Y.a(this, arrayList);
        if (this.Y.b(this, arrayList).f3182b.isEmpty()) {
            if (n.m().o && n.m().j != null) {
                n.m().j.h(this.n.c().longValue());
            }
            checkAndWaitForRemoteConfig();
        }
    }

    public void d() {
        if (!this.h.isDocumentUploadEnabled() || this.N.getVisibility() == 0) {
            if (n.m().o && n.m().j != null) {
                n.m().j.b(this.h);
            }
            stopCamera();
            c(new HVError(3, getString(R$string.operation_cancelled)), new HVResponse(new JSONObject(), null, null, this.b0));
            return;
        }
        stopCamera();
        A();
    }

    public boolean e() {
        if (this.h.isDocumentUploadEnabled()) {
            return this.h.shouldShowCloseAlert() && this.N.getVisibility() == 0;
        }
        return this.h.shouldShowCloseAlert();
    }

    /* renamed from: finishView */
    public void c(HVError hVError, HVResponse hVResponse) {
        boolean z2;
        try {
            if (CameraEngine.f2908a) {
                z2 = co.hyperverge.hvcamera.magicfilter.camera.b.o;
            } else {
                z2 = co.hyperverge.hvcamera.magicfilter.camera.a.j;
            }
            if (z2) {
                if (f2966f != null) {
                    b(hVError, hVResponse);
                }
                co.hyperverge.hypersnapsdk.c.c.f3085b = null;
                finish();
                return;
            }
            new Handler().postDelayed(new Runnable(hVError, hVResponse) {
                public final /* synthetic */ HVError f$1;
                public final /* synthetic */ HVResponse f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    HVDocsActivity.this.c(this.f$1, this.f$2);
                }
            }, 20);
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public final void i() {
        if (this.S.getParent() != null) {
            LayoutParams layoutParams = (LayoutParams) this.S.getLayoutParams();
            layoutParams.height = this.k0;
            layoutParams.width = this.j0;
            this.S.setX(this.I.getX());
            this.S.setY(this.I.getY());
            this.S.requestLayout();
        }
        this.H.requestLayout();
    }

    public void initializeViewsById() {
        ImageView imageView = (ImageView) findViewById(R$id.camera_bubble);
        this.P = imageView;
        imageView.setImageResource(R$drawable.camera_disabled);
        int i2 = 0;
        this.P.setClickable(false);
        this.P.setEnabled(false);
        if (HyperSnapSDK.getInstance() != null) {
            if (!HyperSnapSDK.f2946b.isShouldUseLocation()) {
                l();
            } else if (this.v != null) {
                l();
            }
            ImageView imageView2 = (ImageView) findViewById(R$id.camera_flash);
            this.O = imageView2;
            imageView2.setImageResource(R$drawable.ic_torch_off_svg);
            this.K = findViewById(R$id.black_overlay);
            new Handler(Looper.getMainLooper()).postDelayed(new h(), 100);
            if (!this.h.isShouldShowFlashIcon()) {
                this.O.setVisibility(4);
            }
            this.J.setVisibility(8);
            this.p0 = this.g.getAspectRatio() > 1.0f ? 0 : co.hyperverge.hypersnapsdk.f.h.a((Context) this, 50.0f);
            this.G = (FrameLayout) findViewById(R$id.camera_preview);
            this.H = (FrameLayout) findViewById(R$id.cameraContainer);
            CameraEngine.f2911e = false;
            CameraEngine.setFeatureConfig(n.m().j());
            CameraEngine.f2909b = false;
            try {
                HVMagicView hVMagicView = new HVMagicView(this, this.r0, false);
                HVMagicView.g = hVMagicView;
                this.I = hVMagicView;
                hVMagicView.disableRotation();
                this.H.addView(this.I, 0);
                FrameLayout frameLayout = (FrameLayout) this.I.getParent();
                this.I.setSensorCallback(new i());
                FrameLayout frameLayout2 = this.H;
                co.hyperverge.hypersnapsdk.views.b bVar = new co.hyperverge.hypersnapsdk.views.b(this);
                this.S = bVar;
                frameLayout2.addView(bVar, -1);
                frameLayout2.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return HVDocsActivity.this.a(view, motionEvent);
                    }
                });
                FrameLayout frameLayout3 = this.H;
                co.hyperverge.hypersnapsdk.views.d dVar = new co.hyperverge.hypersnapsdk.views.d(this);
                this.T = dVar;
                frameLayout3.addView(dVar, -1);
                ImageView imageView3 = (ImageView) findViewById(R$id.camera_cross);
                imageView3.setImageResource(R$drawable.ic_camera_cross);
                imageView3.setOnClickListener(this);
                this.Q = (TextView) findViewById(R$id.tv_hint);
                try {
                    if (this.h.getHintTypeface() > 0) {
                        this.Q.setTypeface(ResourcesCompat.getFont(getApplicationContext(), this.h.getHintTypeface()));
                    }
                    String docCaptureSubText = this.h.getDocCaptureSubText();
                    if (!TextUtils.isEmpty(docCaptureSubText)) {
                        this.Q.setText(docCaptureSubText);
                    }
                    this.R = (TextView) findViewById(R$id.tv_step);
                    if (this.h.getDescTypeface() > 0) {
                        this.R.setTypeface(ResourcesCompat.getFont(getApplicationContext(), this.h.getDescTypeface()));
                    }
                    if (this.h.getDocCaptureDescription() != null && !this.h.getDocCaptureDescription().isEmpty()) {
                        this.R.setText(this.h.getDocCaptureDescription());
                    }
                } catch (Exception e2) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                    if (n.m().o && n.m().j != null) {
                        n.m().j.b(new HVError(2, co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2)));
                    }
                    if (n.m().i != null) {
                        n.m().i.a(e2);
                    }
                }
                if (CameraEngine.f2908a) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.f2918b = true;
                } else {
                    co.hyperverge.hvcamera.magicfilter.camera.a.t = true;
                }
                Display defaultDisplay = getWindowManager().getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                if (CameraEngine.f2908a) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.a(point);
                } else {
                    co.hyperverge.hvcamera.magicfilter.camera.a.a(point);
                }
                float f2 = getResources().getDisplayMetrics().density;
                this.l0 = f2;
                this.m0 = ((float) displayMetrics.heightPixels) / f2;
                this.n0 = ((float) displayMetrics.widthPixels) / f2;
                if (co.hyperverge.hypersnapsdk.f.i.c(this) || s()) {
                    ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
                    layoutParams.width = (int) getResources().getDimension(R$dimen.resource_camera_size);
                    layoutParams.height = (int) getResources().getDimension(R$dimen.resource_camera_size);
                    this.P.requestLayout();
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.P.getLayoutParams();
                    layoutParams2.width = (int) getResources().getDimension(R$dimen.margin_doc_button_nav);
                    layoutParams2.height = (int) getResources().getDimension(R$dimen.margin_doc_button_nav);
                    this.P.requestLayout();
                }
                a(false);
                i();
                adjustHintText();
                j();
                String capturePageTitleText = this.h.getCapturePageTitleText();
                TextView textView = (TextView) findViewById(R$id.title_text);
                if (!TextUtils.isEmpty(capturePageTitleText)) {
                    textView.setText(capturePageTitleText);
                }
                if (this.h.getTitleTypeface() > 0) {
                    textView.setTypeface(ResourcesCompat.getFont(getApplicationContext(), this.h.getTitleTypeface()));
                }
                TextView textView2 = (TextView) findViewById(R$id.tvSubtitle);
                String capturePageSubtitleText = this.h.getCapturePageSubtitleText();
                textView2.setText(capturePageSubtitleText);
                if (TextUtils.isEmpty(capturePageSubtitleText)) {
                    i2 = 8;
                }
                textView2.setVisibility(i2);
                if (this.h.getSubtitleTypeface() > 0) {
                    textView2.setTypeface(ResourcesCompat.getFont(getApplicationContext(), this.h.getSubtitleTypeface()));
                }
                this.P.setOnClickListener(this);
                this.O.setOnClickListener(this);
                this.P.setOnTouchListener(new j());
                HVMagicView hVMagicView2 = this.I;
                if (hVMagicView2 != null) {
                    hVMagicView2.onResume();
                } else if (n.m().o && n.m().j != null) {
                    n.m().j.b(new HVError(2, "CameraView is null"));
                }
            } catch (Exception e3) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                if (n.m().i != null) {
                    n.m().i.a(e3);
                }
                HVError hVError = new HVError(5, getResources().getString(R$string.camera_error));
                if (n.m().o && n.m().j != null) {
                    n.m().j.b(hVError);
                }
                sendResponse(hVError);
            }
        } else {
            throw null;
        }
    }

    public final void j() {
        if (this.T.getParent() != null) {
            LayoutParams layoutParams = (LayoutParams) this.T.getLayoutParams();
            int i2 = this.j0;
            int n2 = n() - o();
            layoutParams.height = n2;
            layoutParams.width = i2;
            int o2 = o() + this.p0;
            n();
            this.T.setX((float) 0);
            this.T.setY((float) o2);
            co.hyperverge.hypersnapsdk.views.d dVar = this.T;
            RectF rectF = new RectF(0.0f, 0.0f, (float) i2, (float) n2);
            if (dVar != null) {
                Point point = new Point();
                Point point2 = new Point();
                point.x = ((int) rectF.left) + ((int) (rectF.width() * 0.02f));
                point.y = ((int) rectF.top) + ((int) (rectF.height() * 0.02f));
                point2.x = ((int) rectF.right) - ((int) (rectF.width() * 0.02f));
                point2.y = ((int) rectF.bottom) - ((int) (0.02f * ((float) ((int) rectF.height()))));
                dVar.f3232c = new RectF((float) point.x, (float) point.y, (float) point2.x, (float) point2.y);
                dVar.f3233e = true;
                this.T.requestLayout();
            } else {
                throw null;
            }
        }
        this.H.requestLayout();
    }

    public final void l() {
        if (!this.h.isShouldReadQR() || this.r) {
            ImageView imageView = this.P;
            if (imageView != null) {
                imageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(R$color.camera_button_color)));
                this.P.setImageResource(R$drawable.ic_camera_button_svg);
                this.P.setClickable(true);
                this.P.setEnabled(true);
                return;
            }
            return;
        }
        this.s.postDelayed(new Runnable() {
            public final void run() {
                HVDocsActivity.this.t();
            }
        }, 2000);
    }

    public void makeOCRAPICall(String str, String str2) {
        try {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(co.hyperverge.hypersnapsdk.c.k.f3108c);
            progressDialog.show();
            View view = this.K;
            if (view != null) {
                view.setVisibility(0);
            }
            if (co.hyperverge.hypersnapsdk.c.c.f3085b == null) {
                co.hyperverge.hypersnapsdk.c.c.f3085b = new co.hyperverge.hypersnapsdk.c.c();
            }
            co.hyperverge.hypersnapsdk.c.c.f3085b.a(this, str, str2, this.h, new co.hyperverge.hypersnapsdk.c.c.b(progressDialog, str) {
                public final /* synthetic */ ProgressDialog f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void a(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, HVError hVError) {
                    HVDocsActivity.this.a(this.f$1, this.f$2, z, str, str2, jSONObject, jSONObject2, hVError);
                }
            });
        } catch (Exception e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public final int n() {
        int aspectRatio = ((int) ((this.g.getAspectRatio() * ((float) this.j0)) + ((float) this.k0))) / 2;
        int i2 = (int) (this.l0 * 0.4f);
        int i3 = aspectRatio + i2;
        int i4 = this.k0;
        return i3 >= i4 ? i4 - i2 : aspectRatio;
    }

    public final int o() {
        int aspectRatio = ((int) (((float) this.k0) - (this.g.getAspectRatio() * ((float) this.j0)))) / 2;
        if (aspectRatio < 0) {
            return 20;
        }
        return aspectRatio;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        super.onActivityResult(i2, i3, intent);
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("onActivityResult() called with: requestCode = [", i2, "], resultCode = [", i3, "], data = [");
        outline75.append(intent);
        outline75.append(CMapParser.MARK_END_OF_ARRAY);
        outline75.toString();
        try {
            this.i.d();
            this.k.d();
            this.j.d();
            this.l.d();
            this.m.d();
            this.n.d();
            this.o.d();
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
        }
        if (i2 == 1001) {
            try {
                b((Context) this);
            } catch (NoClassDefFoundError unused) {
            }
        }
        if (i2 == 1000 && i3 == -1 && intent != null) {
            File a2 = co.hyperverge.hypersnapsdk.f.i.a(getContentResolver(), intent.getData(), new File(getFilesDir(), "hv"));
            if (a2 == null || !a2.exists()) {
                c(new HVError(6, "Selected file invalid or corrupt"), null);
            } else {
                String path = a2.getPath();
                JSONObject jSONObject = new JSONObject();
                try {
                    str = path.substring(path.lastIndexOf(".") + 1);
                } catch (Exception unused2) {
                    str = null;
                }
                if (str != null && !str.equals("pdf")) {
                    try {
                        co.hyperverge.hypersnapsdk.c.d dVar = new co.hyperverge.hypersnapsdk.c.d();
                        dVar.a(a2, this.v);
                        if (this.h.isShouldExportPDF()) {
                            String a3 = co.hyperverge.hypersnapsdk.c.j.a(BitmapFactory.decodeFile(path), this.V.getPath() + "/hv_" + System.currentTimeMillis() + ".pdf");
                            this.a0 = a3;
                            jSONObject.put("pdfUri", a3);
                        }
                        if (this.h.getOcrHeaders() == null || !this.h.getOcrHeaders().has("transactionId")) {
                            str2 = o.i();
                        } else {
                            str2 = this.h.getOcrHeaders().getString("transactionId");
                        }
                        dVar.a(path, str2, this.L);
                    } catch (Exception e3) {
                        co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                        if (n.m().i != null) {
                            n.m().i.a(e3);
                        }
                    }
                }
                if (this.h.shouldShowReviewScreen()) {
                    startReviewScreen(path, null);
                } else if (this.h.isShouldDoOCR()) {
                    makeOCRAPICall(path, null);
                } else {
                    c(null, new HVResponse(addResultImageUri(jSONObject), new JSONObject(), path, this.b0));
                }
            }
        }
        if (i3 == 10) {
            checkForPermissions();
        } else if (i3 != 11) {
            if (i3 != 18) {
                if (i3 == 6) {
                    this.u++;
                    long longExtra = intent.getLongExtra("timeTakenToClickRetakeButton", 0);
                    if (n.m().o && n.m().j != null) {
                        n.m().j.a(this.h, longExtra);
                    }
                    ImageView imageView = this.P;
                    if (imageView != null) {
                        imageView.setImageTintList(null);
                        this.P.setImageResource(R$drawable.camera_disabled);
                        this.P.setClickable(false);
                        this.P.setEnabled(false);
                    }
                    this.r = false;
                    l();
                    return;
                } else if (i3 == 7) {
                    long longExtra2 = intent.getLongExtra("timeTakenToClickConfirmButton", 0);
                    if (n.m().o && n.m().j != null) {
                        n.m().j.a(this.h, this.u, longExtra2);
                    }
                    this.u = 0;
                    String stringExtra = intent.getStringExtra("imageUri");
                    String stringExtra2 = this.h.isShouldReadQR() ? intent.getStringExtra("qrCodeCroppedImageUri") : null;
                    if (this.h.isShouldDoOCR()) {
                        makeOCRAPICall(stringExtra, stringExtra2);
                        return;
                    } else {
                        c(null, new HVResponse(addResultImageUri(new JSONObject()), new JSONObject(), stringExtra, this.b0));
                        return;
                    }
                } else if (i3 != 8) {
                    return;
                }
            }
            stopCamera();
            c((HVError) intent.getSerializableExtra("hvError"), null);
        } else {
            d();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.camera_cross) {
            if (n.m().o && n.m().j != null) {
                n.m().j.h();
            }
            handleCloseAction();
        } else if (id == R$id.camera_bubble) {
            if (n.m().o && n.m().j != null) {
                n.m().j.d(this.h, this.o.c().longValue());
            }
            if ((this.h.isShouldAllowPhoneTilt() || !this.W) && this.o0.get()) {
                this.o0.set(false);
                try {
                    this.m.d();
                    HVMagicView hVMagicView = this.I;
                    if (hVMagicView != null) {
                        hVMagicView.onTouchToFocus(0.5f, 0.5f, null);
                        this.I.takePicture(null);
                    } else {
                        this.p = new HVError(2, "camerView is null");
                        long longValue = this.m.c().longValue();
                        if (n.m().o && n.m().j != null) {
                            n.m().j.a(this.p, this.h, longValue);
                        }
                    }
                } catch (Exception e2) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                    this.p = new HVError(2, co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2));
                    long longValue2 = this.m.c().longValue();
                    if (n.m().o && n.m().j != null) {
                        n.m().j.a(this.p, this.h, longValue2);
                    }
                    if (n.m().i != null) {
                        n.m().i.a(e2);
                    }
                }
            }
        } else if (id == R$id.camera_flash) {
            if (n.m().o && n.m().j != null) {
                n.m().j.x();
            }
            this.I.nextFlashMode();
        } else if (id == R$id.camera_preview && this.I == null) {
            throw null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R$layout.hv_activity_doc_capture);
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            sendResponse(new HVError(2, getResources().getString(R$string.internal_error)));
        }
        this.h = (HVDocConfig) getIntent().getSerializableExtra(HVDocConfig.KEY);
        if (n.m().o && n.m().j != null) {
            n.m().j.a(this.h);
        }
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseLocation()) {
                try {
                    b((Context) this);
                } catch (NoClassDefFoundError unused) {
                }
            }
            if (bundle != null) {
                finish();
            }
            this.g = this.h.getDocument();
            View findViewById = findViewById(R$id.v_flash);
            this.J = findViewById;
            findViewById.setVisibility(0);
            File file = new File(getFilesDir(), "hv");
            this.V = file;
            if (!file.exists()) {
                this.V.mkdirs();
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.e0 = this.V.getPath() + "/" + currentTimeMillis + ".jpg";
            this.f0 = this.V.getPath() + "/HIGH_RES_CROPPED_" + currentTimeMillis + ".jpg";
            this.g0 = this.V.getPath() + "/HIGH_RES_FULL_" + currentTimeMillis + ".jpg";
            this.N = (ConstraintLayout) findViewById(R$id.layoutDocPicker);
            if (this.h.isDocumentUploadEnabled()) {
                A();
            } else {
                C();
            }
        } else {
            throw null;
        }
    }

    public void onDestroy() {
        try {
            if (!this.h.isShouldAllowPhoneTilt()) {
                this.X.unregisterListener(this.Z);
                co.hyperverge.hypersnapsdk.c.c.f3085b = null;
            }
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        HVMagicView hVMagicView = this.I;
        if (hVMagicView != null) {
            hVMagicView.onPause();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:2|(5:4|(1:6)|7|8|9)|12|13|14|16|17|18|19|(4:21|22|23|29)|40|(1:57)(2:44|58)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0119, code lost:
        co.hyperverge.hypersnapsdk.f.i.a((java.lang.Throwable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012c, code lost:
        co.hyperverge.hypersnapsdk.c.n.m().j.b(new co.hyperverge.hypersnapsdk.objects.HVError(2, co.hyperverge.hypersnapsdk.f.i.a((java.lang.Throwable) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0144, code lost:
        if (co.hyperverge.hypersnapsdk.c.n.m().i != null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0146, code lost:
        co.hyperverge.hypersnapsdk.c.n.m().i.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014f, code lost:
        sendResponse(new co.hyperverge.hypersnapsdk.objects.HVError(2, getResources().getString(co.hyperverge.hypersnapsdk.R$string.internal_error)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004e */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRemoteConfigFetchDone() {
        /*
            r5 = this;
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            r1 = 0
            if (r0 == 0) goto L_0x0162
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            boolean r0 = r0.isShouldUseSensorBiometrics()
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = "doc"
            java.lang.String r0 = co.hyperverge.hypersnapsdk.f.i.d(r0)
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.d.a r2 = r2.l
            if (r2 == 0) goto L_0x0026
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.d.a r2 = r2.l
            r2.b(r0)
        L_0x0026:
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r2 = r5.h
            org.json.JSONObject r2 = r2.getOcrHeaders()
            java.lang.String r3 = "sensorDataZipFileName"
            r2.put(r3, r0)     // Catch:{ Exception -> 0x003a }
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r0 = r5.h     // Catch:{ Exception -> 0x003a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x003a }
            r0.ocrHeaders = r2     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
        L_0x003e:
            r0 = 2
            co.hyperverge.hypersnapsdk.service.qr.HVBarcodeDetector r2 = r5.q     // Catch:{ NoClassDefFoundError -> 0x004e }
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ NoClassDefFoundError -> 0x004e }
            r4 = 6416(0x1910, float:8.991E-42)
            r2.initialiseHVBarcodeDetector(r3, r4)     // Catch:{ NoClassDefFoundError -> 0x004e }
            goto L_0x004e
        L_0x004b:
            r1 = move-exception
            goto L_0x0119
        L_0x004e:
            r5.initializeViewsById()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r2 = r5.h     // Catch:{ Exception -> 0x004b }
            r5.a(r2, r1)     // Catch:{ Exception -> 0x004b }
            java.util.concurrent.atomic.AtomicBoolean r1 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ Exception -> 0x004b }
            r2 = 1
            r1.<init>(r2)     // Catch:{ Exception -> 0x004b }
            r5.o0 = r1     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r1 = r5.h     // Catch:{ Exception -> 0x00a5 }
            boolean r1 = r1.isShouldAllowPhoneTilt()     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x00dc
            java.lang.String r1 = "sensor"
            java.lang.Object r1 = r5.getSystemService(r1)     // Catch:{ Exception -> 0x0078 }
            android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1     // Catch:{ Exception -> 0x0078 }
            r5.X = r1     // Catch:{ Exception -> 0x0078 }
            co.hyperverge.hypersnapsdk.activities.HVDocsActivity$g r1 = new co.hyperverge.hypersnapsdk.activities.HVDocsActivity$g     // Catch:{ Exception -> 0x0078 }
            r1.<init>()     // Catch:{ Exception -> 0x0078 }
            r5.Z = r1     // Catch:{ Exception -> 0x0078 }
            goto L_0x008d
        L_0x0078:
            r1 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r1)     // Catch:{ Exception -> 0x00a5 }
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x00a5 }
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x008d
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x00a5 }
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i     // Catch:{ Exception -> 0x00a5 }
            r3.a(r1)     // Catch:{ Exception -> 0x00a5 }
        L_0x008d:
            android.hardware.SensorManager r1 = r5.X     // Catch:{ Exception -> 0x00a5 }
            android.hardware.SensorEventListener r3 = r5.Z     // Catch:{ Exception -> 0x00a5 }
            android.hardware.Sensor r2 = r1.getDefaultSensor(r2)     // Catch:{ Exception -> 0x00a5 }
            r4 = 3
            r1.registerListener(r3, r2, r4)     // Catch:{ Exception -> 0x00a5 }
            android.hardware.SensorManager r1 = r5.X     // Catch:{ Exception -> 0x00a5 }
            android.hardware.SensorEventListener r2 = r5.Z     // Catch:{ Exception -> 0x00a5 }
            android.hardware.Sensor r3 = r1.getDefaultSensor(r0)     // Catch:{ Exception -> 0x00a5 }
            r1.registerListener(r2, r3, r4)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00dc
        L_0x00a5:
            r1 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r1)     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            boolean r2 = r2.o     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x00cb
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r2 = r2.j     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x00cb
            co.hyperverge.hypersnapsdk.objects.HVError r2 = new co.hyperverge.hypersnapsdk.objects.HVError     // Catch:{ Exception -> 0x004b }
            java.lang.String r3 = co.hyperverge.hypersnapsdk.f.i.a(r1)     // Catch:{ Exception -> 0x004b }
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r3 = r3.j     // Catch:{ Exception -> 0x004b }
            r3.b(r2)     // Catch:{ Exception -> 0x004b }
        L_0x00cb:
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i     // Catch:{ Exception -> 0x004b }
            if (r2 == 0) goto L_0x00dc
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i     // Catch:{ Exception -> 0x004b }
            r2.a(r1)     // Catch:{ Exception -> 0x004b }
        L_0x00dc:
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            boolean r1 = r1.o     // Catch:{ Exception -> 0x004b }
            if (r1 == 0) goto L_0x0161
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r1 = r1.j     // Catch:{ Exception -> 0x004b }
            if (r1 == 0) goto L_0x0161
            co.hyperverge.hypersnapsdk.c.q r1 = r5.l     // Catch:{ Exception -> 0x004b }
            java.lang.Long r1 = r1.c()     // Catch:{ Exception -> 0x004b }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r3 = r3.j     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.objects.HVDocConfig r4 = r5.h     // Catch:{ Exception -> 0x004b }
            r3.c(r4)     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r3 = r3.j     // Catch:{ Exception -> 0x004b }
            r3.j(r1)     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.a.b r1 = r1.j     // Catch:{ Exception -> 0x004b }
            r1.t()     // Catch:{ Exception -> 0x004b }
            co.hyperverge.hypersnapsdk.c.q r1 = r5.o     // Catch:{ Exception -> 0x004b }
            r1.d()     // Catch:{ Exception -> 0x004b }
            goto L_0x0161
        L_0x0119:
            co.hyperverge.hypersnapsdk.f.i.a(r1)
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r2 = r2.o
            if (r2 == 0) goto L_0x013e
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r2 = r2.j
            if (r2 == 0) goto L_0x013e
            co.hyperverge.hypersnapsdk.objects.HVError r2 = new co.hyperverge.hypersnapsdk.objects.HVError
            java.lang.String r3 = co.hyperverge.hypersnapsdk.f.i.a(r1)
            r2.<init>(r0, r3)
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r3 = r3.j
            r3.b(r2)
        L_0x013e:
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            if (r2 == 0) goto L_0x014f
            co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r2 = r2.i
            r2.a(r1)
        L_0x014f:
            co.hyperverge.hypersnapsdk.objects.HVError r1 = new co.hyperverge.hypersnapsdk.objects.HVError
            android.content.res.Resources r2 = r5.getResources()
            int r3 = co.hyperverge.hypersnapsdk.R$string.internal_error
            java.lang.String r2 = r2.getString(r3)
            r1.<init>(r0, r2)
            r5.sendResponse(r1)
        L_0x0161:
            return
        L_0x0162:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.activities.HVDocsActivity.onRemoteConfigFetchDone():void");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        co.hyperverge.hypersnapsdk.f.f.a b2 = this.Y.b(this, new ArrayList(Arrays.asList(new String[]{"android.permission.CAMERA"})));
        if (!b2.f3182b.isEmpty()) {
            HVError hVError = new HVError(4, GeneratedOutlineSupport.outline50("Following Permissions not granted by user: ", TextUtils.join(",", b2.f3182b)));
            if (n.m().o && n.m().j != null) {
                n.m().j.b(hVError, this.n.c().longValue());
            }
            b(hVError, null);
            finish();
            return;
        }
        if (n.m().o && n.m().j != null) {
            n.m().j.h(this.n.c().longValue());
        }
        checkAndWaitForRemoteConfig();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        HVMagicView hVMagicView = this.I;
        if (hVMagicView != null) {
            hVMagicView.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public final boolean s() {
        return ((double) this.m0) <= (((double) this.n0) * 4.0d) / 3.0d;
    }

    public void sendResponse(HVError hVError) {
        if (f2966f != null) {
            b(hVError, null);
        }
        co.hyperverge.hypersnapsdk.c.c.f3085b = null;
        finish();
    }

    public void setDescText() {
        if (this.W) {
            this.R.setText(getResources().getString(R$string.docCaptureTilt));
            this.R.setTextColor(getResources().getColor(R$color.text_red));
            return;
        }
        this.R.setTextColor(getResources().getColor(R$color.content_text_color));
        if (this.h.getDocCaptureDescription() == null || this.h.getDocCaptureDescription().isEmpty()) {
            this.R.setText(getResources().getString(R$string.docCaptureDescription));
        } else {
            this.R.setText(this.h.getDocCaptureDescription());
        }
    }

    public void startInstructionActivity() {
        try {
            Intent intent = new Intent(this, HVDocInstructionActivity.class);
            intent.putExtra("customUIStrings", this.h.getCustomUIStrings().toString());
            startActivityForResult(intent, 1);
        } catch (NoClassDefFoundError e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            b(new HVError(31, getResources().getString(R$string.instructions_error)), null);
            finish();
        } catch (Exception e3) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
        }
    }

    public void startReviewScreen(String str, String str2) {
        try {
            Intent intent = new Intent(this, HVDocReviewActivity.class);
            intent.putExtra("imageUri", str);
            if (this.h.isShouldReadQR() && !co.hyperverge.hypersnapsdk.c.k.a(str2) && new File(str2).exists()) {
                intent.putExtra("qrCodeCroppedImageUri", str2);
            }
            intent.putExtra("aspectRatio", this.g.getAspectRatio());
            intent.putExtra(HVDocConfig.KEY, this.h);
            intent.putExtra("extraPadding", this.d0);
            co.hyperverge.hypersnapsdk.views.d dVar = this.T;
            if (dVar != null) {
                intent.putExtra("viewWidth", dVar.getWidth());
                intent.putExtra("viewHeight", this.T.getHeight());
            }
            startActivityForResult(intent, 1);
        } catch (Exception e2) {
            co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
            if (n.m().o && n.m().j != null) {
                n.m().j.g(new HVError(2, co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2)));
            }
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void stopCamera() {
        HVMagicView hVMagicView = this.I;
        if (hVMagicView != null) {
            hVMagicView.setSensorCallback(null);
            HVMagicView hVMagicView2 = this.I;
            if (hVMagicView2 != null) {
                HVMagicView.g = null;
                HVMagicView.f2835f = null;
                hVMagicView2.queueEvent(new co.hyperverge.hvcamera.HVMagicView.a());
                this.I.onPause();
                this.v = null;
                return;
            }
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        if (n.m().o) {
            n.m().a(getApplicationContext()).f();
        }
        onBackPressed();
    }

    public HVBaseConfig a() {
        return this.h;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.s0 = motionEvent.getX();
            this.t0 = motionEvent.getY();
        } else if (actionMasked == 1 && Math.abs(motionEvent.getX() - this.s0) < 20.0f && Math.abs(motionEvent.getY() - this.t0) < 20.0f) {
            this.S.a(motionEvent.getX(), motionEvent.getY(), false);
            this.I.onTouchToFocus(motionEvent.getX() / ((float) this.j0), motionEvent.getY() / ((float) this.k0), null);
        }
        return true;
    }

    public static void i(HVDocsActivity hVDocsActivity) {
        if (hVDocsActivity != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(hVDocsActivity.M);
            hVDocsActivity.J.startAnimation(alphaAnimation);
            return;
        }
        throw null;
    }

    public final void b(Context context) {
        if (((LocationManager) co.hyperverge.hypersnapsdk.service.c.a.a(this).f3200f.getSystemService("location")).isProviderEnabled("gps")) {
            co.hyperverge.hypersnapsdk.service.c.a.a(context).c();
            co.hyperverge.hypersnapsdk.service.c.a.a(context).f3197c = new d(context);
            return;
        }
        Builder builder = new Builder(this);
        AlertParams alertParams = builder.P;
        alertParams.mTitle = "GPS Switched Off";
        alertParams.mMessage = "Please enable GPS to continue";
        alertParams.mCancelable = false;
        e eVar = new e();
        AlertParams alertParams2 = builder.P;
        alertParams2.mPositiveButtonText = "Open settings";
        alertParams2.mPositiveButtonListener = eVar;
        f fVar = new f();
        AlertParams alertParams3 = builder.P;
        alertParams3.mNegativeButtonText = "Cancel";
        alertParams3.mNegativeButtonListener = fVar;
        builder.show();
    }

    public final void a(boolean z2) {
        if (co.hyperverge.hypersnapsdk.f.i.c(this) || s()) {
            this.q0 = (int) getResources().getDimension(R$dimen.margin_doc_top_bar_height_nav);
        } else {
            this.q0 = (int) getResources().getDimension(R$dimen.margin_doc_top_bar_height_no_nav);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.llTopBar);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = this.q0;
        linearLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = ((ImageView) findViewById(R$id.camera_cross)).getLayoutParams();
        int i2 = this.q0;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        ViewGroup.LayoutParams layoutParams3 = ((ImageView) findViewById(R$id.camera_flash)).getLayoutParams();
        int i3 = this.q0;
        layoutParams3.height = i3;
        layoutParams3.width = i3;
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.cameraContainer);
        if (s()) {
            LayoutParams layoutParams4 = (LayoutParams) frameLayout.getLayoutParams();
            layoutParams4.setMargins(co.hyperverge.hypersnapsdk.f.h.a((Context) this, 10.0f), (int) ((((float) (((double) this.m0) - ((((double) this.n0) * 4.0d) / 3.0d))) / 2.0f) * this.l0), co.hyperverge.hypersnapsdk.f.h.a((Context) this, 10.0f), 0);
            layoutParams4.height = -2;
            frameLayout.setLayoutParams(layoutParams4);
        } else {
            LayoutParams layoutParams5 = (LayoutParams) frameLayout.getLayoutParams();
            if (this.h.getDocument() == Document.A4) {
                layoutParams5.setMargins(co.hyperverge.hypersnapsdk.f.h.a((Context) this, 45.0f), this.q0 + 75, co.hyperverge.hypersnapsdk.f.h.a((Context) this, 45.0f), 0);
            } else {
                layoutParams5.setMargins(co.hyperverge.hypersnapsdk.f.h.a((Context) this, 10.0f), this.q0, co.hyperverge.hypersnapsdk.f.h.a((Context) this, 10.0f), 0);
            }
            layoutParams5.height = -2;
            frameLayout.setLayoutParams(layoutParams5);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.overlay1);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R$id.overlay2);
        int o2 = o();
        n();
        LayoutParams layoutParams6 = (LayoutParams) frameLayout2.getLayoutParams();
        layoutParams6.height = o2 + this.p0;
        frameLayout2.setLayoutParams(layoutParams6);
        frameLayout3.setVisibility(0);
        LayoutParams layoutParams7 = (LayoutParams) frameLayout3.getLayoutParams();
        layoutParams7.setMargins(0, n() + this.p0, 0, 0);
        frameLayout3.setLayoutParams(layoutParams7);
        if (z2) {
            FrameLayout frameLayout4 = this.G;
            frameLayout4.measure(MeasureSpec.makeMeasureSpec(frameLayout4.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(frameLayout4.getMeasuredHeight(), 1073741824));
            frameLayout4.layout(frameLayout4.getLeft(), frameLayout4.getTop(), frameLayout4.getRight(), frameLayout4.getBottom());
        }
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        long longValue = this.j.c().longValue();
        if (n.m().o) {
            n.m().a(getApplicationContext()).i(longValue);
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", 1 != 0 ? new String[]{"image/*", "application/pdf"} : new String[]{"image/*"});
        startActivityForResult(intent, 1000);
    }

    /* access modifiers changed from: private */
    public void a(ProgressDialog progressDialog, String str, boolean z2, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, HVError hVError) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
            View view = this.K;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        this.b0 = str3;
        this.c0 = str2;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (z2) {
            if (this.u0.getRetakeAttemptResponses() == null) {
                this.u0.setRetakeAttemptResponses(this.v0);
            }
            HVBaseResponse hVBaseResponse = new HVBaseResponse();
            hVBaseResponse.setAction(this.b0);
            hVBaseResponse.setApiHeaders(jSONObject2);
            hVBaseResponse.setImageURI(str);
            hVBaseResponse.setApiResult(addResultImageUri(jSONObject));
            hVBaseResponse.setRetakeMessage(this.c0);
            HVDocConfig hVDocConfig = this.h;
            hVBaseResponse.setAttemptsCount(o.a(hVDocConfig.ocrEndpoint, hVDocConfig.getSuffixForDocument()));
            this.v0.add(hVBaseResponse);
            try {
                Intent intent = new Intent(this, HVRetakeActivity.class);
                intent.putExtra("imageUri", str);
                intent.putExtra("aspectRatio", this.g.getAspectRatio());
                intent.putExtra("config", this.h);
                intent.putExtra("setPadding", this.h.isShouldSetPadding());
                intent.putExtra("retryMessage", str2);
                intent.putExtra("extraPadding", this.d0);
                intent.putExtra("viewWidth", this.T.getWidth());
                intent.putExtra("viewHeight", this.T.getHeight());
                startActivityForResult(intent, 1);
            } catch (Exception e2) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        } else {
            stopCamera();
            this.u0.setAction(this.b0);
            this.u0.setApiHeaders(jSONObject2);
            this.u0.setImageURI(str);
            this.u0.setApiResult(addResultImageUri(jSONObject));
            this.u0.setRetakeMessage(this.c0);
            HVResponse hVResponse = this.u0;
            HVDocConfig hVDocConfig2 = this.h;
            hVResponse.setAttemptsCount(o.a(hVDocConfig2.ocrEndpoint, hVDocConfig2.getSuffixForDocument()));
            this.u0.setRetakeAttemptResponses(this.v0);
            c(hVError, this.u0);
        }
    }
}
