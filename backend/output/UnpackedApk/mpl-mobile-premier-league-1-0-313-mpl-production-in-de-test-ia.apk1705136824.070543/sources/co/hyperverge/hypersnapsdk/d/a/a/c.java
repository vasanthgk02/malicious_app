package co.hyperverge.hypersnapsdk.d.a.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import co.hyperverge.encoder.Mp4FrameMuxer;
import co.hyperverge.encoder.Muxer;
import co.hyperverge.encoder.MuxerConfig;
import co.hyperverge.encoder.MuxingCompletionListener;
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
import co.hyperverge.hypersnapsdk.activities.HVFaceActivity;
import co.hyperverge.hypersnapsdk.c.k;
import co.hyperverge.hypersnapsdk.c.l;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.d.a.a.c.b;
import co.hyperverge.hypersnapsdk.f.h;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.model.CameraProperties;
import co.hyperverge.hypersnapsdk.model.ImageComparisonObj;
import co.hyperverge.hypersnapsdk.model.LivenessResponse;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.antmedia.android.broadcaster.encoder.VideoEncoderCore;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TextureFragment */
public class c extends Fragment implements b {
    public HVMagicView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public View F;
    public SeekBar G;
    public ProgressDialog H;
    public a I;
    public co.hyperverge.hypersnapsdk.views.a J;
    public boolean K;
    public co.hyperverge.hypersnapsdk.views.c L;
    public co.hyperverge.hypersnapsdk.views.b M;
    public boolean N;
    public int O;
    public int P;
    public JSONObject Q;
    public HVFaceConfig R;
    public int S;
    public ProgressDialog T;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Bitmap> f3144a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public co.hyperverge.hypersnapsdk.f.d<byte[]> f3145b;

    /* renamed from: c  reason: collision with root package name */
    public File f3146c;

    /* renamed from: d  reason: collision with root package name */
    public String f3147d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f3148e = false;
    public OnTouchListener e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3149f = false;
    public final HVCamHost f0;
    public Muxer g;
    public float g0;
    public final ExecutorService h = Executors.newSingleThreadExecutor();
    public float h0;
    public boolean j;
    public boolean k;
    public byte[] l;
    public co.hyperverge.hypersnapsdk.views.e m;
    public long n;
    public final q o;
    public final q p;
    public final q q;
    public HVError r;
    public HVError s;
    public CountDownTimer t;
    public FrameLayout w;
    public ImageView x;
    public ImageView y;
    public ImageView z;

    /* compiled from: TextureFragment */
    public class a implements OnTouchListener {

        /* renamed from: co.hyperverge.hypersnapsdk.d.a.a.c$a$a  reason: collision with other inner class name */
        /* compiled from: TextureFragment */
        public class C0056a implements AnimationListener {
            public C0056a() {
            }

            public void onAnimationEnd(Animation animation) {
                c.this.r();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        public a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ImageView imageView = c.this.x;
                imageView.clearAnimation();
                imageView.clearAnimation();
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(150);
                scaleAnimation.setInterpolator(new AccelerateInterpolator());
                scaleAnimation.setFillAfter(true);
                imageView.startAnimation(scaleAnimation);
                c.this.x.startAnimation(scaleAnimation);
            } else if (action == 1) {
                ImageView imageView2 = c.this.x;
                imageView2.clearAnimation();
                c.this.x.clearAnimation();
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(150);
                scaleAnimation2.setInterpolator(new AccelerateInterpolator());
                scaleAnimation2.setFillAfter(true);
                scaleAnimation2.setAnimationListener(new C0056a());
                c.this.x.startAnimation(scaleAnimation2);
                imageView2.startAnimation(scaleAnimation2);
            }
            return false;
        }
    }

    /* compiled from: TextureFragment */
    public class b extends HVCamHost {

        /* compiled from: TextureFragment */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Handler f3153a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ byte[] f3154b;

            public a(Handler handler, byte[] bArr) {
                this.f3153a = handler;
                this.f3154b = bArr;
            }

            public void run() {
                c cVar = c.this;
                if (!cVar.f3149f) {
                    this.f3153a.postDelayed(this, 100);
                    return;
                }
                ((d) cVar.I).a(false);
                c cVar2 = c.this;
                if (cVar2.f3148e) {
                    cVar2.n = cVar2.p.b();
                }
                b bVar = b.this;
                c cVar3 = c.this;
                ((d) cVar3.I).a(this.f3154b, cVar3.l, bVar.getPhotoDirectory().getAbsolutePath(), b.this.getPhotoFilename(), c.this.f3147d);
                this.f3153a.removeCallbacks(this);
            }
        }

        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(float f2, float f3, boolean z) {
            if (f2 > 0.0f || f3 > 0.0f) {
                c cVar = c.this;
                cVar.M.a(f2 * ((float) cVar.O), f3 * ((float) cVar.P), z);
                return;
            }
            c cVar2 = c.this;
            cVar2.M.a((float) (cVar2.O / 2), (float) (cVar2.P / 2), z);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            c cVar = c.this;
            if (cVar.M != null) {
                int i = cVar.R.getShouldUseBackCamera() ? 0 : 8;
                c.this.M.setVisibility(i);
                if (c.this.R.isShouldUseZoom()) {
                    c.this.G.setVisibility(i);
                }
            }
        }

        public void flashScreen() {
        }

        public int getAspectRatio() {
            return 1;
        }

        public File getPhotoDirectory() {
            File file;
            Exception e2;
            try {
                file = new File(c.this.requireActivity().getFilesDir(), "hv");
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    i.a((Throwable) e2);
                    return file;
                }
            } catch (Exception e4) {
                e2 = e4;
                file = null;
                i.a((Throwable) e2);
                return file;
            }
            return file;
        }

        public String getPhotoFilename() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("FD_");
            outline73.append(System.currentTimeMillis());
            outline73.append(".jpg");
            return outline73.toString();
        }

        public float getPictureMegapixels() {
            return 1.3f;
        }

        public float getPreviewMegapixels() {
            return 0.3f;
        }

        public String getVideoFilename() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("FD_");
            outline73.append(System.currentTimeMillis());
            outline73.append(".mp4");
            return outline73.toString();
        }

        public boolean isShouldCaptureHighResolutionImage() {
            return false;
        }

        public void onCameraFlipCallback() {
            ProgressDialog progressDialog = c.this.T;
            if (progressDialog != null && progressDialog.isShowing() && i.a((Activity) c.this.getActivity())) {
                c.this.T.dismiss();
                c.this.T = null;
            }
            c cVar = c.this;
            cVar.k = !cVar.k;
            co.hyperverge.hypersnapsdk.f.j.a a2 = co.hyperverge.hypersnapsdk.f.j.a.a();
            a2.f3185b.post(new Runnable() {
                public final void run() {
                    b.this.b();
                }
            });
        }

        public void onCamerasFound(int i) {
        }

        public void onFilterMode(int i, String str) {
        }

        public void onFlashAuto() {
        }

        public void onFlashNull() {
        }

        public void onFlashOff() {
            if (c.this.R.isUseFlash()) {
                c.this.A.nextFlashMode();
            }
        }

        public void onFlashOn() {
        }

        public void onFlashTorchOn() {
        }

        public void onLayoutChange() {
        }

        public void onNewPreviewFrame(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2) {
            byte[] bArr3 = bArr2;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            byte[] bArr4 = bArr;
            CameraProperties cameraProperties = new CameraProperties(i5, i6, h.b(), h.a((Context) c.this.requireActivity(), 80.0f) + c.this.m.getDiameter(), (long) bArr3.length, i7, i8, bArr4, !c.this.R.getShouldUseBackCamera(), false);
            d dVar = (d) c.this.I;
            if (dVar != null) {
                if (n.m().t()) {
                    if (dVar.z.shouldCheckForFaceTilt()) {
                        if (l.f3112a == null) {
                            l.f3112a = new l();
                        }
                        l.f3112a.a(cameraProperties, dVar);
                    } else {
                        co.hyperverge.hypersnapsdk.c.b bVar = dVar.i;
                        if (bVar != null) {
                            bVar.f3071f = cameraProperties.viewWidth;
                            bVar.g = cameraProperties.viewHeight;
                            bVar.j = cameraProperties.isFrontFacingCam;
                            bVar.f3069d.removeCallbacksAndMessages(null);
                            Handler handler = bVar.f3069d;
                            co.hyperverge.hypersnapsdk.c.b.a aVar = new co.hyperverge.hypersnapsdk.c.b.a(cameraProperties.data, cameraProperties.width, cameraProperties.height, cameraProperties.orientation, cameraProperties.rotation, cameraProperties.isFrontFacingCam, cameraProperties.isCapturedFramePreviewed);
                            handler.post(aVar);
                        } else {
                            throw null;
                        }
                    }
                }
                byte[] bArr5 = cameraProperties.data;
                long j = cameraProperties.rgbDataLength;
                co.hyperverge.hypersnapsdk.f.j.b bVar2 = dVar.j;
                bVar2.f3189d.submit(new Runnable(bArr5, j) {
                    public final /* synthetic */ byte[] f$1;
                    public final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        d.this.a(this.f$1, this.f$2);
                    }
                });
                c cVar = c.this;
                cVar.l = bArr3;
                if (cVar.R.isShouldRecordVideo()) {
                    c cVar2 = c.this;
                    if (!cVar2.j) {
                        cVar2.f3145b.add(bArr3);
                        c.this.f3145b.size();
                        return;
                    }
                    return;
                }
                return;
            }
            throw null;
        }

        public void onPictureFailed() {
            c cVar = c.this;
            cVar.N = true;
            cVar.r = new HVError(2, "failure logged in selfie onPictureFailed()");
            long longValue = c.this.o.c().longValue();
            if (n.m().o && n.m().j != null) {
                co.hyperverge.hypersnapsdk.a.b bVar = n.m().j;
                c cVar2 = c.this;
                bVar.a(cVar2.r, cVar2.R, longValue);
            }
            c.this.j = false;
        }

        public void onPictureReady(byte[] bArr) {
            long longValue = c.this.o.c().longValue();
            if (n.m().o && n.m().j != null) {
                n.m().j.b(c.this.R, longValue);
            }
            if (c.this.R.isShouldRecordVideo()) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new a(handler, bArr), 100);
                return;
            }
            c cVar = c.this;
            a aVar = cVar.I;
            byte[] bArr2 = cVar.l;
            String absolutePath = getPhotoDirectory().getAbsolutePath();
            String photoFilename = getPhotoFilename();
            StringBuilder sb = new StringBuilder();
            sb.append(c.this.f0.getPhotoDirectory());
            File file = new File(GeneratedOutlineSupport.outline62(sb, File.separator, "hv_dummy_video.mp4"));
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            ((d) aVar).a(bArr, bArr2, absolutePath, photoFilename, file.getAbsolutePath());
        }

        public void onPictureSaved(File file) {
            long longValue = c.this.o.c().longValue();
            if (n.m().o && n.m().j != null) {
                n.m().j.a(c.this.R, file.getAbsolutePath(), longValue);
            }
            c.this.j = false;
        }

        public void onPictureSizeSet(int i, int i2) {
            ImageComparisonObj imageComparisonObj = co.hyperverge.hypersnapsdk.c.i.b().g;
            imageComparisonObj.captureWidth = i;
            imageComparisonObj.captureHeight = i2;
        }

        public void onReady() {
            try {
                HVMagicView hVMagicView = c.this.A;
                if (hVMagicView != null) {
                    hVMagicView.f2838c.a();
                }
            } catch (Exception e2) {
                i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }

        public void onViewDimensionChange(int i, int i2) {
            c cVar = c.this;
            cVar.P = i2;
            cVar.O = i;
            cVar.q();
        }

        public void setScreenFlashOff() {
        }

        public void showCrossHair(float f2, float f3, boolean z) {
            if (c.this.M != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(f2, f3, z) {
                    public final /* synthetic */ float f$1;
                    public final /* synthetic */ float f$2;
                    public final /* synthetic */ boolean f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        b.this.a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void zoomMaxLevel(int i) {
            if (!c.this.R.getShouldUseBackCamera() || !c.this.R.isShouldUseDefaultZoom()) {
                CameraEngine.f2911e = false;
            } else {
                float f2 = co.hyperverge.hypersnapsdk.f.a.f3177b;
                CameraEngine.f2910d = f2;
                CameraEngine.f2911e = true;
                if (CameraEngine.f2908a) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.c(f2);
                } else {
                    int i2 = (int) f2;
                    List<Integer> list = co.hyperverge.hvcamera.magicfilter.camera.a.g;
                    if (list != null && !list.isEmpty()) {
                        int intValue = co.hyperverge.hvcamera.magicfilter.camera.a.g.get(0).intValue();
                        int i3 = 0;
                        while (true) {
                            if (i3 < co.hyperverge.hvcamera.magicfilter.camera.a.g.size()) {
                                if (intValue > 0 && intValue * i2 < co.hyperverge.hvcamera.magicfilter.camera.a.g.get(i3).intValue()) {
                                    float f3 = (float) i3;
                                    co.hyperverge.hvcamera.magicfilter.camera.a.i = f3;
                                    co.hyperverge.hvcamera.magicfilter.camera.a.e((int) f3);
                                    break;
                                }
                                i3++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            c.this.getActivity();
            if (CameraEngine.f2908a) {
                c.this.G.setMax(i * 2);
            } else {
                c.this.G.setMax(i);
            }
            c.this.G.setProgress(0);
        }
    }

    /* renamed from: co.hyperverge.hypersnapsdk.d.a.a.c$c  reason: collision with other inner class name */
    /* compiled from: TextureFragment */
    public class C0057c implements MuxingCompletionListener {
        public C0057c() {
        }
    }

    /* compiled from: TextureFragment */
    public class d extends CountDownTimer {
        public d(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            try {
                JSONObject jSONObject = c.this.Q;
                if (jSONObject == null || !jSONObject.has("faceCaptureAutoCaptureAction") || c.this.Q.getString("faceCaptureAutoCaptureAction").trim().isEmpty()) {
                    c.this.B.setText(k.h);
                } else {
                    c cVar = c.this;
                    cVar.B.setText(cVar.Q.getString("faceCaptureAutoCaptureAction"));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.this.r();
        }

        public void onTick(long j) {
        }
    }

    /* compiled from: TextureFragment */
    public class e implements OnSeekBarChangeListener {
        public e() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            c.this.getActivity();
            boolean z2 = CameraEngine.f2908a;
            if (z2) {
                float f2 = ((float) i) / 2.0f;
                if (z2) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.c(f2);
                } else if (co.hyperverge.hvcamera.magicfilter.camera.a.f2915e) {
                    co.hyperverge.hvcamera.magicfilter.camera.a.e((int) f2);
                }
            } else {
                float f3 = (float) i;
                if (z2) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.c(f3);
                } else if (co.hyperverge.hvcamera.magicfilter.camera.a.f2915e) {
                    co.hyperverge.hvcamera.magicfilter.camera.a.e((int) f3);
                }
                c.this.S = i;
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: TextureFragment */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f3159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3160b;

        public f(ProgressDialog progressDialog, View view) {
            this.f3159a = progressDialog;
            this.f3160b = view;
        }

        public void run() {
            if (n.m().n && i.a((Activity) c.this.getActivity())) {
                this.f3159a.dismiss();
                c.this.e(this.f3160b);
            }
        }
    }

    public c() {
        if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
            this.j = false;
            this.k = true;
            this.o = new q();
            this.p = new q();
            this.q = new q();
            this.K = false;
            this.e0 = new a();
            this.f0 = new b();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        if (n.m().o && n.m().j != null) {
            n.m().j.e(this.q.c().longValue());
        }
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                n.m().l.a(System.currentTimeMillis(), (String) "selfieCaptureClicked");
            }
            r();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        if (n.m().o && n.m().j != null) {
            n.m().j.q();
        }
        try {
            ProgressDialog progressDialog = this.T;
            if (progressDialog == null || !progressDialog.isShowing()) {
                if (this.T == null) {
                    this.T = new ProgressDialog(getActivity());
                }
                HVFaceConfig hVFaceConfig = this.R;
                hVFaceConfig.setShouldUseBackCamera(!hVFaceConfig.getShouldUseBackCamera());
                this.T.setCancelable(false);
                this.T.setMessage("Please wait...");
                this.T.show();
                this.A.f2836a.a();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(View view) {
        if (n.m().o && n.m().j != null) {
            n.m().j.n();
        }
        ((HVFaceActivity) requireActivity()).handleCloseAction();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x() {
        /*
            r13 = this;
            co.hyperverge.hypersnapsdk.f.d<byte[]> r0 = r13.f3145b
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r0.next()
            byte[] r1 = (byte[]) r1
            int r3 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r2, r3)
            java.util.ArrayList<android.graphics.Bitmap> r2 = r13.f3144a
            r2.add(r1)
            goto L_0x0006
        L_0x001e:
            co.hyperverge.encoder.Muxer r0 = r13.g
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.ArrayList<android.graphics.Bitmap> r3 = r13.f3144a
            r1.<init>(r3)
            r3 = 0
            if (r0 == 0) goto L_0x0198
            java.lang.String r4 = "imageList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            co.hyperverge.encoder.FrameBuilder r4 = new co.hyperverge.encoder.FrameBuilder
            android.content.Context r5 = r0.context
            co.hyperverge.encoder.MuxerConfig r6 = r0.muxerConfig
            r4.<init>(r5, r6, r3)
            r5 = 2
            r6 = 1
            android.media.MediaCodec r7 = r4.mediaCodec     // Catch:{ IOException -> 0x0137 }
            android.media.MediaFormat r8 = r4.mediaFormat     // Catch:{ IOException -> 0x0137 }
            r7.configure(r8, r3, r3, r6)     // Catch:{ IOException -> 0x0137 }
            android.media.MediaCodec r7 = r4.mediaCodec     // Catch:{ IOException -> 0x0137 }
            android.view.Surface r7 = r7.createInputSurface()     // Catch:{ IOException -> 0x0137 }
            r4.surface = r7     // Catch:{ IOException -> 0x0137 }
            android.media.MediaCodec r7 = r4.mediaCodec     // Catch:{ IOException -> 0x0137 }
            r7.start()     // Catch:{ IOException -> 0x0137 }
            r4.drainCodec(r2)     // Catch:{ IOException -> 0x0137 }
            java.util.Iterator r1 = r1.iterator()
        L_0x0055:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00f1
            java.lang.Object r5 = r1.next()
            java.lang.String r7 = "image"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            co.hyperverge.encoder.MuxerConfig r7 = r4.muxerConfig
            int r7 = r7.framesPerImage
            r8 = 0
        L_0x0069:
            if (r8 >= r7) goto L_0x0055
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 23
            if (r9 < r10) goto L_0x007a
            android.view.Surface r9 = r4.surface
            if (r9 == 0) goto L_0x0083
            android.graphics.Canvas r9 = r9.lockHardwareCanvas()
            goto L_0x0084
        L_0x007a:
            android.view.Surface r9 = r4.surface
            if (r9 == 0) goto L_0x0083
            android.graphics.Canvas r9 = r9.lockCanvas(r3)
            goto L_0x0084
        L_0x0083:
            r9 = r3
        L_0x0084:
            boolean r10 = r5 instanceof java.lang.Integer
            r11 = 0
            if (r10 == 0) goto L_0x00af
            android.content.Context r10 = r4.context
            android.content.res.Resources r10 = r10.getResources()
            r12 = r5
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeResource(r10, r12)
            java.lang.String r12 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            if (r9 == 0) goto L_0x00a4
            r9.drawBitmap(r10, r11, r11, r3)
        L_0x00a4:
            android.view.Surface r10 = r4.surface
            if (r10 == 0) goto L_0x00ab
            r10.unlockCanvasAndPost(r9)
        L_0x00ab:
            r4.drainCodec(r2)
            goto L_0x00ed
        L_0x00af:
            boolean r10 = r5 instanceof android.graphics.Bitmap
            if (r10 == 0) goto L_0x00c6
            r10 = r5
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            if (r9 == 0) goto L_0x00bb
            r9.drawBitmap(r10, r11, r11, r3)
        L_0x00bb:
            android.view.Surface r10 = r4.surface
            if (r10 == 0) goto L_0x00c2
            r10.unlockCanvasAndPost(r9)
        L_0x00c2:
            r4.drainCodec(r2)
            goto L_0x00ed
        L_0x00c6:
            boolean r9 = r5 instanceof android.graphics.Canvas
            if (r9 == 0) goto L_0x00d8
            r9 = r5
            android.graphics.Canvas r9 = (android.graphics.Canvas) r9
            android.view.Surface r10 = r4.surface
            if (r10 == 0) goto L_0x00d4
            r10.unlockCanvasAndPost(r9)
        L_0x00d4:
            r4.drainCodec(r2)
            goto L_0x00ed
        L_0x00d8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Image type "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r10 = " is not supported. Try using a Canvas or a Bitmap"
            r9.append(r10)
            r9.toString()
        L_0x00ed:
            int r8 = r8 + 1
            goto L_0x0069
        L_0x00f1:
            r4.drainCodec(r6)
            android.media.MediaCodec r1 = r4.mediaCodec
            r1.stop()
            android.media.MediaCodec r1 = r4.mediaCodec
            r1.release()
            android.view.Surface r1 = r4.surface
            if (r1 == 0) goto L_0x0105
            r1.release()
        L_0x0105:
            android.media.MediaExtractor r1 = r4.audioExtractor
            if (r1 == 0) goto L_0x010c
            r1.release()
        L_0x010c:
            co.hyperverge.encoder.FrameMuxer r1 = r4.frameMuxer
            r1.release()
            co.hyperverge.encoder.MuxingCompletionListener r1 = r0.muxingCompletionListener
            if (r1 == 0) goto L_0x012f
            co.hyperverge.hypersnapsdk.d.a.a.c$c r1 = (co.hyperverge.hypersnapsdk.d.a.a.c.C0057c) r1
            co.hyperverge.hypersnapsdk.d.a.a.c r2 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            java.io.File r3 = r2.f3146c
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r3 = r3.toString()
            r2.f3147d = r3
            co.hyperverge.hypersnapsdk.d.a.a.c r1 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            r1.f3149f = r6
            r1.f3148e = r6
        L_0x012f:
            java.io.File r0 = r0.file
            java.lang.String r1 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            goto L_0x0197
        L_0x0137:
            r1 = move-exception
            r1.printStackTrace()
            co.hyperverge.encoder.MuxingCompletionListener r0 = r0.muxingCompletionListener
            if (r0 == 0) goto L_0x018b
            co.hyperverge.hypersnapsdk.d.a.a.c$c r0 = (co.hyperverge.hypersnapsdk.d.a.a.c.C0057c) r0
            co.hyperverge.hypersnapsdk.d.a.a.c r3 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            r3.f3149f = r6
            r3.f3148e = r2
            co.hyperverge.hypersnapsdk.objects.HVError r2 = new co.hyperverge.hypersnapsdk.objects.HVError
            java.lang.String r4 = "Video encoding unsuccessful : "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r6 = co.hyperverge.hypersnapsdk.f.i.a(r1)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r2.<init>(r5, r4)
            r3.s = r2
            co.hyperverge.hypersnapsdk.d.a.a.c r2 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            co.hyperverge.hypersnapsdk.objects.HVError r2 = r2.s
            r2.getErrorMessage()
            co.hyperverge.hypersnapsdk.d.a.a.c r2 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            co.hyperverge.hypersnapsdk.c.q r2 = r2.p
            long r2 = r2.b()
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r4 = r4.o
            if (r4 == 0) goto L_0x018b
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r4 = r4.j
            if (r4 == 0) goto L_0x018b
            co.hyperverge.hypersnapsdk.c.n r4 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r4 = r4.j
            co.hyperverge.hypersnapsdk.d.a.a.c r0 = co.hyperverge.hypersnapsdk.d.a.a.c.this
            co.hyperverge.hypersnapsdk.objects.HVError r0 = r0.s
            r4.a(r0, r2)
        L_0x018b:
            java.lang.String r0 = "Start encoder failed"
            java.lang.String r2 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
        L_0x0197:
            return
        L_0x0198:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.d.a.a.c.x():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y() {
        this.m.getWidth();
        this.m.getHeight();
        co.hyperverge.hypersnapsdk.views.b bVar = this.M;
        if (bVar != null) {
            bVar.a((float) (this.O / 2), (float) (this.P / 2), false);
        }
    }

    public final void A() {
        this.K = false;
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void C() {
        this.f3144a = new ArrayList<>();
        this.f3145b = new co.hyperverge.hypersnapsdk.f.d<>(this.R.getNumberOfFrames());
        this.f3147d = "";
        this.f3148e = false;
        this.f3149f = false;
    }

    public final void e(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.llBranding);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.llTrustLogos);
        int i = 0;
        boolean z2 = n.m() != null && n.m().p().f3026a;
        boolean shouldShowTrustLogos = this.R.shouldShowTrustLogos();
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (!shouldShowTrustLogos) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
    }

    public void f() {
        if (getActivity() != null && isAdded()) {
            try {
                this.J.setProgressColor(getResources().getColor(R$color.face_capture_circle_failure));
                JSONObject jSONObject = this.Q;
                if (jSONObject == null || !jSONObject.has("faceCaptureFaceNotFound") || this.Q.getString("faceCaptureFaceNotFound").trim().isEmpty()) {
                    this.B.setText(k.f3106a);
                } else {
                    this.B.setText(this.Q.getString("faceCaptureFaceNotFound"));
                }
                if (this.R.isShouldAutoCapture()) {
                    A();
                }
                v();
            } catch (Exception e2) {
                if (!TextUtils.isEmpty(i.a((Throwable) e2))) {
                    i.a((Throwable) e2);
                }
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    public void i() {
        if (getActivity() != null && isAdded()) {
            try {
                if (n.m().t()) {
                    this.J.setProgressColor(getResources().getColor(R$color.face_capture_circle_success));
                } else {
                    this.J.setProgressColor(getResources().getColor(R$color.camera_button_color));
                }
                JSONObject jSONObject = this.Q;
                if (jSONObject == null || !jSONObject.has("faceCaptureFaceFound") || this.Q.getString("faceCaptureFaceFound").trim().isEmpty()) {
                    this.B.setText(k.f94b);
                } else {
                    this.B.setText(this.Q.getString("faceCaptureFaceFound"));
                }
                if (this.R.isShouldAutoCapture()) {
                    if (!this.K) {
                        this.K = true;
                        this.t.start();
                    }
                    if (this.N) {
                        JSONObject jSONObject2 = this.Q;
                        if (jSONObject2 == null || !jSONObject2.has("faceCaptureAutoCaptureWait") || this.Q.getString("faceCaptureAutoCaptureWait").trim().isEmpty()) {
                            this.B.setText(k.g);
                        } else {
                            this.B.setText(this.Q.getString("faceCaptureAutoCaptureWait"));
                        }
                    } else {
                        JSONObject jSONObject3 = this.Q;
                        if (jSONObject3 == null || !jSONObject3.has("faceCaptureAutoCaptureAction") || this.Q.getString("faceCaptureAutoCaptureAction").trim().isEmpty()) {
                            this.B.setText(k.h);
                        } else {
                            this.B.setText(this.Q.getString("faceCaptureAutoCaptureAction"));
                        }
                    }
                }
                this.x.setOnTouchListener(this.e0);
                this.x.setClickable(true);
                this.x.setImageResource(R$drawable.ic_camera_button_svg);
                this.x.setImageTintList(ColorStateList.valueOf(getResources().getColor(R$color.camera_button_color)));
            } catch (Exception e2) {
                if (!TextUtils.isEmpty(i.a((Throwable) e2))) {
                    i.a((Throwable) e2);
                }
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    public void l() {
        if (getActivity() != null && isAdded()) {
            try {
                this.J.setProgressColor(getResources().getColor(R$color.face_capture_circle_failure));
                JSONObject jSONObject = this.Q;
                if (jSONObject == null || !jSONObject.has("faceCaptureLookStraight") || this.Q.getString("faceCaptureLookStraight").trim().isEmpty()) {
                    this.B.setText(k.f3110f);
                } else {
                    this.B.setText(this.Q.getString("faceCaptureLookStraight"));
                }
                if (this.R.isShouldAutoCapture()) {
                    A();
                }
                v();
            } catch (Exception e2) {
                if (!TextUtils.isEmpty(i.a((Throwable) e2))) {
                    i.a((Throwable) e2);
                }
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    public final void n() {
        try {
            this.F = LayoutInflater.from(getActivity()).inflate(R$layout.view_overlay, null);
            if (this.R.isShouldUseDefaultZoom()) {
                this.F.findViewById(R$id.black_overlay).setBackgroundColor(getResources().getColor(R$color.black_opaque));
            }
            this.w.addView(this.F);
            this.F.setVisibility(8);
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public final void o() {
        try {
            u();
            p();
            n();
            this.Q = this.R.getCustomUIStrings();
            String faceCaptureTitle = this.R.getFaceCaptureTitle();
            if (!TextUtils.isEmpty(faceCaptureTitle)) {
                this.C.setText(faceCaptureTitle);
            }
            String faceCaptureSubtitle = this.R.getFaceCaptureSubtitle();
            this.D.setText(faceCaptureSubtitle);
            this.D.setVisibility(!TextUtils.isEmpty(faceCaptureSubtitle) ? 0 : 8);
            if (!this.R.isShouldUseFlip()) {
                this.y.setVisibility(4);
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            a aVar = this.I;
            if (aVar != null) {
                ((d) aVar).a();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.q.d();
        this.o.d();
        HVFaceConfig hVFaceConfig = this.R;
        if (hVFaceConfig != null && hVFaceConfig.isShouldRecordVideo()) {
            C();
        }
        if (i2 == 18) {
            d dVar = (d) this.I;
            ((c) dVar.k).d();
            dVar.a((LivenessResponse) null, (HVError) intent.getSerializableExtra("hvError"));
        } else if (i2 == 20) {
            ((d) this.I).c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x01e3 A[Catch:{ Exception -> 0x01ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01eb A[Catch:{ Exception -> 0x01ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
            r7 = this;
            co.hyperverge.hypersnapsdk.c.q r10 = r7.q
            r10.d()
            int r10 = co.hyperverge.hypersnapsdk.R$layout.hv_fragment_texture_view
            r0 = 0
            android.view.View r8 = r8.inflate(r10, r9, r0)
            int r9 = co.hyperverge.hypersnapsdk.R$id.parent_container
            android.view.View r9 = r8.findViewById(r9)
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            r7.w = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.statusString
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r7.B = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.camera_icon
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r7.x = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.title_text
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r7.C = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.tvSubtitle
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r7.D = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.camera_flip
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r7.y = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.close_gesture
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r7.z = r9
            int r9 = co.hyperverge.hypersnapsdk.R$id.debug_text
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r7.E = r9
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r9 = r9.getTitleTypeface()     // Catch:{ Exception -> 0x00ba }
            if (r9 <= 0) goto L_0x007b
            android.widget.TextView r9 = r7.C     // Catch:{ Exception -> 0x00ba }
            androidx.fragment.app.FragmentActivity r10 = r7.requireActivity()     // Catch:{ Exception -> 0x00ba }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00ba }
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r1 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r1 = r1.getTitleTypeface()     // Catch:{ Exception -> 0x00ba }
            android.graphics.Typeface r10 = androidx.core.content.res.ResourcesCompat.getFont(r10, r1)     // Catch:{ Exception -> 0x00ba }
            r9.setTypeface(r10)     // Catch:{ Exception -> 0x00ba }
        L_0x007b:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r9 = r9.getSubtitleTypeface()     // Catch:{ Exception -> 0x00ba }
            if (r9 <= 0) goto L_0x009a
            android.widget.TextView r9 = r7.D     // Catch:{ Exception -> 0x00ba }
            androidx.fragment.app.FragmentActivity r10 = r7.requireActivity()     // Catch:{ Exception -> 0x00ba }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00ba }
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r1 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r1 = r1.getSubtitleTypeface()     // Catch:{ Exception -> 0x00ba }
            android.graphics.Typeface r10 = androidx.core.content.res.ResourcesCompat.getFont(r10, r1)     // Catch:{ Exception -> 0x00ba }
            r9.setTypeface(r10)     // Catch:{ Exception -> 0x00ba }
        L_0x009a:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r9 = r9.getTitleTypeface()     // Catch:{ Exception -> 0x00ba }
            if (r9 <= 0) goto L_0x00cf
            android.widget.TextView r9 = r7.B     // Catch:{ Exception -> 0x00ba }
            androidx.fragment.app.FragmentActivity r10 = r7.requireActivity()     // Catch:{ Exception -> 0x00ba }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00ba }
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r1 = r7.R     // Catch:{ Exception -> 0x00ba }
            int r1 = r1.getTitleTypeface()     // Catch:{ Exception -> 0x00ba }
            android.graphics.Typeface r10 = androidx.core.content.res.ResourcesCompat.getFont(r10, r1)     // Catch:{ Exception -> 0x00ba }
            r9.setTypeface(r10)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00cf
        L_0x00ba:
            r9 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r9)
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            if (r10 == 0) goto L_0x00cf
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            r10.a(r9)
        L_0x00cf:
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r7.R
            boolean r9 = r9.isShouldAutoCapture()
            if (r9 == 0) goto L_0x00f0
            android.widget.ImageView r9 = r7.x
            r10 = 4
            r9.setVisibility(r10)
            co.hyperverge.hypersnapsdk.d.a.a.c$d r9 = new co.hyperverge.hypersnapsdk.d.a.a.c$d
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r10 = r7.R
            int r10 = r10.getAutoCaptureDuration()
            long r3 = (long) r10
            r5 = 1000(0x3e8, double:4.94E-321)
            r1 = r9
            r2 = r7
            r1.<init>(r3, r5)
            r7.t = r9
            goto L_0x00fa
        L_0x00f0:
            android.widget.ImageView r9 = r7.x
            co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$YzbE-dskt3l53XJbrinshMeKX4E r10 = new co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$YzbE-dskt3l53XJbrinshMeKX4E
            r10.<init>()
            r9.setOnClickListener(r10)
        L_0x00fa:
            android.widget.ImageView r9 = r7.y
            co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$StyWZ__MtQgk6b7xGGX-ZeFqavg r10 = new co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$StyWZ__MtQgk6b7xGGX-ZeFqavg
            r10.<init>()
            r9.setOnClickListener(r10)
            android.widget.ImageView r9 = r7.z
            co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$9913Dv6hRb5AFtwmG0RWvJsl0uI r10 = new co.hyperverge.hypersnapsdk.d.a.a.-$$Lambda$c$9913Dv6hRb5AFtwmG0RWvJsl0uI
            r10.<init>()
            r9.setOnClickListener(r10)
            int r9 = co.hyperverge.hypersnapsdk.R$id.hv_zoom_seek_bar     // Catch:{ Exception -> 0x019a }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ Exception -> 0x019a }
            android.widget.SeekBar r9 = (android.widget.SeekBar) r9     // Catch:{ Exception -> 0x019a }
            r7.G = r9     // Catch:{ Exception -> 0x019a }
            co.hyperverge.hypersnapsdk.objects.HVFaceConfig r9 = r7.R     // Catch:{ Exception -> 0x019a }
            if (r9 == 0) goto L_0x0192
            boolean r9 = r9.isShouldUseZoom()     // Catch:{ Exception -> 0x019a }
            if (r9 == 0) goto L_0x0192
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()     // Catch:{ Exception -> 0x019a }
            boolean r9 = co.hyperverge.hypersnapsdk.f.h.e(r9)     // Catch:{ Exception -> 0x019a }
            if (r9 == 0) goto L_0x015d
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()     // Catch:{ Exception -> 0x019a }
            android.widget.LinearLayout$LayoutParams r9 = (android.widget.LinearLayout.LayoutParams) r9     // Catch:{ Exception -> 0x019a }
            androidx.fragment.app.FragmentActivity r10 = r7.getActivity()     // Catch:{ Exception -> 0x019a }
            r1 = 1110704128(0x42340000, float:45.0)
            int r10 = co.hyperverge.hypersnapsdk.f.h.a(r10, r1)     // Catch:{ Exception -> 0x019a }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ Exception -> 0x019a }
            int r1 = co.hyperverge.hypersnapsdk.f.h.a(r2, r1)     // Catch:{ Exception -> 0x019a }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ Exception -> 0x019a }
            r3 = 1084227584(0x40a00000, float:5.0)
            int r2 = co.hyperverge.hypersnapsdk.f.h.a(r2, r3)     // Catch:{ Exception -> 0x019a }
            r9.setMargins(r10, r0, r1, r2)     // Catch:{ Exception -> 0x019a }
            android.widget.SeekBar r10 = r7.G     // Catch:{ Exception -> 0x019a }
            r10.setLayoutParams(r9)     // Catch:{ Exception -> 0x019a }
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            r9.requestLayout()     // Catch:{ Exception -> 0x019a }
        L_0x015d:
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            android.graphics.drawable.Drawable r9 = r9.getProgressDrawable()     // Catch:{ Exception -> 0x019a }
            android.content.res.Resources r10 = r7.getResources()     // Catch:{ Exception -> 0x019a }
            int r1 = co.hyperverge.hypersnapsdk.R$color.seekbar_color     // Catch:{ Exception -> 0x019a }
            int r10 = r10.getColor(r1)     // Catch:{ Exception -> 0x019a }
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch:{ Exception -> 0x019a }
            r9.setColorFilter(r10, r1)     // Catch:{ Exception -> 0x019a }
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            android.graphics.drawable.Drawable r9 = r9.getThumb()     // Catch:{ Exception -> 0x019a }
            android.content.res.Resources r10 = r7.getResources()     // Catch:{ Exception -> 0x019a }
            int r1 = co.hyperverge.hypersnapsdk.R$color.seekbar_color     // Catch:{ Exception -> 0x019a }
            int r10 = r10.getColor(r1)     // Catch:{ Exception -> 0x019a }
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch:{ Exception -> 0x019a }
            r9.setColorFilter(r10, r1)     // Catch:{ Exception -> 0x019a }
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            co.hyperverge.hypersnapsdk.d.a.a.c$e r10 = new co.hyperverge.hypersnapsdk.d.a.a.c$e     // Catch:{ Exception -> 0x019a }
            r10.<init>()     // Catch:{ Exception -> 0x019a }
            r9.setOnSeekBarChangeListener(r10)     // Catch:{ Exception -> 0x019a }
            goto L_0x01b2
        L_0x0192:
            android.widget.SeekBar r9 = r7.G     // Catch:{ Exception -> 0x019a }
            r10 = 8
            r9.setVisibility(r10)     // Catch:{ Exception -> 0x019a }
            goto L_0x01b2
        L_0x019a:
            r9 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r9)
            co.hyperverge.hypersnapsdk.f.i.a(r9)
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            if (r10 == 0) goto L_0x01b2
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            r10.a(r9)
        L_0x01b2:
            android.app.ProgressDialog r9 = new android.app.ProgressDialog
            android.content.Context r10 = r7.getContext()
            r9.<init>(r10)
            java.lang.String r10 = co.hyperverge.hypersnapsdk.c.k.f3108c
            r9.setMessage(r10)
            r9.setCancelable(r0)
            r9.show()
            android.os.Handler r10 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r10.<init>(r0)
            co.hyperverge.hypersnapsdk.d.a.a.c$f r0 = new co.hyperverge.hypersnapsdk.d.a.a.c$f
            r0.<init>(r9, r8)
            r1 = 100
            r10.postDelayed(r0, r1)
            co.hyperverge.hypersnapsdk.c.n r9 = co.hyperverge.hypersnapsdk.c.n.m()     // Catch:{ Exception -> 0x01ff }
            boolean r9 = r9.t()     // Catch:{ Exception -> 0x01ff }
            if (r9 == 0) goto L_0x01eb
            android.widget.ImageView r9 = r7.x     // Catch:{ Exception -> 0x01ff }
            int r10 = co.hyperverge.hypersnapsdk.R$drawable.camera_disabled     // Catch:{ Exception -> 0x01ff }
            r9.setImageResource(r10)     // Catch:{ Exception -> 0x01ff }
            goto L_0x01f2
        L_0x01eb:
            android.widget.ImageView r9 = r7.x     // Catch:{ Exception -> 0x01ff }
            int r10 = co.hyperverge.hypersnapsdk.R$drawable.ic_camera_button_svg     // Catch:{ Exception -> 0x01ff }
            r9.setImageResource(r10)     // Catch:{ Exception -> 0x01ff }
        L_0x01f2:
            r7.o()     // Catch:{ Exception -> 0x01ff }
            r7.w()     // Catch:{ Exception -> 0x01ff }
            r7.e(r8)     // Catch:{ Exception -> 0x01ff }
            r9 = 1
            r7.N = r9     // Catch:{ Exception -> 0x01ff }
            goto L_0x0214
        L_0x01ff:
            r9 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r9)
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            if (r10 == 0) goto L_0x0214
            co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
            r10.a(r9)
        L_0x0214:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.d.a.a.c.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        try {
            HVMagicView hVMagicView = this.A;
            if (hVMagicView != null) {
                hVMagicView.onPause();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        ProgressDialog progressDialog = this.H;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.H.cancel();
        }
        if (n.m().t()) {
            f();
            ((d) this.I).l = false;
        }
    }

    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = 0.8f;
        activity.getWindow().setAttributes(attributes);
        if (!n.m().t()) {
            i();
        }
        if (isAdded()) {
            try {
                HVMagicView hVMagicView = this.A;
                if (hVMagicView != null) {
                    hVMagicView.onResume();
                }
            } catch (Exception e2) {
                i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
    }

    public final void p() {
        try {
            co.hyperverge.hypersnapsdk.views.a aVar = new co.hyperverge.hypersnapsdk.views.a(getActivity(), null);
            this.J = aVar;
            aVar.setId(R$id.hv_circular_bar);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.J.getDiameter(), this.J.getDiameter());
            layoutParams.gravity = 1;
            layoutParams.topMargin = (int) getActivity().getResources().getDimension(R$dimen.margin_face_circle_top);
            this.J.setLayoutParams(layoutParams);
            this.w.addView(this.J);
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public final void q() {
        if (this.R.getShouldUseBackCamera()) {
            if (this.M.getParent() != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.M.getLayoutParams();
                layoutParams.height = this.P;
                layoutParams.width = this.O;
                this.M.setX(this.A.getX());
                this.M.setY(this.A.getY());
                this.M.requestLayout();
            }
            this.m.requestLayout();
        }
    }

    public void r() {
        boolean z2;
        try {
            if (!((d) this.I).l) {
                if (n.m().t()) {
                    z2 = false;
                    if (z2 && this.N) {
                        this.o.d();
                        this.N = false;
                        if (this.A != null) {
                            this.j = true;
                            if (this.R.isShouldRecordVideo()) {
                                this.p.d();
                                s();
                            }
                            this.A.takePicture(null);
                            if (this.R.isShouldUseDefaultZoom()) {
                                ((d) this.I).a(true);
                                return;
                            }
                            return;
                        }
                        this.r = new HVError(2, "camerView is null");
                        long longValue = this.o.c().longValue();
                        if (n.m().o && n.m().j != null) {
                            n.m().j.a(this.r, this.R, longValue);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            this.r = new HVError(2, i.a((Throwable) e2));
            long longValue2 = this.o.c().longValue();
            if (n.m().o && n.m().j != null) {
                n.m().j.a(this.r, this.R, longValue2);
            }
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public final void s() {
        File file;
        if (this.f0.getPhotoDirectory() == null) {
            file = null;
        } else {
            file = new File(r0.getPath() + File.separator + this.f0.getVideoFilename());
        }
        this.f3146c = file;
        if (file == null) {
            HVError hVError = new HVError(2, "could not create media video file");
            this.s = hVError;
            hVError.getErrorMessage();
            long b2 = this.p.b();
            if (n.m().o && n.m().j != null) {
                n.m().j.a(this.s, b2);
            }
            return;
        }
        this.g = new Muxer(getActivity().getApplicationContext(), this.f3146c);
        MuxerConfig muxerConfig = new MuxerConfig(this.f3146c, 480, 640, VideoEncoderCore.MIME_TYPE, 1, (float) this.R.getFps(), ((int) this.R.getBitrateM()) * 1000000, new Mp4FrameMuxer(this.f3146c.getAbsolutePath(), (float) this.R.getFps()), 10);
        Muxer muxer = this.g;
        if (muxer != null) {
            Intrinsics.checkNotNullParameter(muxerConfig, "config");
            muxer.muxerConfig = muxerConfig;
            Muxer muxer2 = this.g;
            C0057c cVar = new C0057c();
            if (muxer2 != null) {
                Intrinsics.checkNotNullParameter(cVar, "muxingCompletionListener");
                muxer2.muxingCompletionListener = cVar;
                this.h.execute(new Runnable() {
                    public final void run() {
                        c.this.x();
                    }
                });
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void u() {
        try {
            CameraEngine.f2909b = true;
            if (CameraEngine.f2908a) {
                co.hyperverge.hvcamera.magicfilter.camera.b.f2918b = true;
            } else {
                co.hyperverge.hvcamera.magicfilter.camera.a.t = true;
            }
            CameraEngine.setFeatureConfig(n.m().j());
            if (this.R.isShouldUseEnhancedCameraFeatures()) {
                if (CameraEngine.f2908a) {
                    co.hyperverge.hvcamera.magicfilter.camera.b.H = true;
                } else {
                    co.hyperverge.hvcamera.magicfilter.camera.a.u = true;
                }
            }
            this.m = new co.hyperverge.hypersnapsdk.views.e(requireActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.m.getDiameter(), this.m.getDiameter());
            layoutParams.gravity = 1;
            layoutParams.topMargin = (int) requireActivity().getResources().getDimension(R$dimen.margin_face_circle_top);
            this.m.setLayoutParams(layoutParams);
            this.w.addView(this.m);
            this.L = new co.hyperverge.hypersnapsdk.views.c(getActivity());
            this.O = this.m.getDiameter();
            this.P = this.m.getDiameter();
            this.k = !this.R.getShouldUseBackCamera();
            HVMagicView hVMagicView = new HVMagicView(requireActivity(), this.f0, true ^ this.R.getShouldUseBackCamera());
            HVMagicView.g = hVMagicView;
            this.A = hVMagicView;
            hVMagicView.disableRotation();
            Display defaultDisplay = requireActivity().getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (CameraEngine.f2908a) {
                co.hyperverge.hvcamera.magicfilter.camera.b.a(point);
            } else {
                co.hyperverge.hvcamera.magicfilter.camera.a.a(point);
            }
            this.A.setLayoutParams(new FrameLayout.LayoutParams(this.m.getDiameter(), this.m.getDiameter()));
            this.A.setSensorCallback(new SensorCallback() {
                public final void onSensorCallback() {
                    c.this.y();
                }
            });
            this.m.addView(this.A);
            co.hyperverge.hypersnapsdk.views.e eVar = this.m;
            co.hyperverge.hypersnapsdk.views.b bVar = new co.hyperverge.hypersnapsdk.views.b(getActivity());
            this.M = bVar;
            eVar.addView(bVar);
            eVar.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return c.this.a(view, motionEvent);
                }
            });
            q();
            if (this.M != null) {
                this.M.setVisibility(this.R.getShouldUseBackCamera() ? 0 : 8);
            }
            this.m.addView(this.L);
            HVMagicView hVMagicView2 = this.A;
            if (hVMagicView2 != null) {
                hVMagicView2.onResume();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void v() {
        this.x.setOnTouchListener(null);
        this.x.setClickable(false);
        this.x.setImageResource(R$drawable.camera_disabled);
        this.x.setImageTintList(null);
    }

    public final void w() {
        try {
            this.J.setBackgroundColor(getResources().getColor(R$color.progress_grey));
            this.J.setProgressColor(getResources().getColor(R$color.face_capture_circle_failure));
            this.J.setMaxProgress(100);
            if (!n.m().t()) {
                this.J.setmStrokeWidth(10);
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g0 = motionEvent.getX();
            this.h0 = motionEvent.getY();
        } else if (actionMasked == 1 && Math.abs(motionEvent.getX() - this.g0) < 20.0f && Math.abs(motionEvent.getY() - this.h0) < 20.0f) {
            this.M.a(motionEvent.getX(), motionEvent.getY(), false);
            this.A.onTouchToFocus(motionEvent.getX() / ((float) this.O), motionEvent.getY() / ((float) this.P), null);
        }
        return true;
    }

    public String a(int i) {
        return getResources().getString(i);
    }

    public void d() {
        try {
            HVMagicView hVMagicView = this.A;
            if (hVMagicView != null) {
                hVMagicView.setSensorCallback(null);
                HVMagicView hVMagicView2 = this.A;
                if (hVMagicView2 != null) {
                    HVMagicView.g = null;
                    HVMagicView.f2835f = null;
                    hVMagicView2.queueEvent(new co.hyperverge.hvcamera.HVMagicView.a());
                    this.A.onPause();
                    return;
                }
                throw null;
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }
}
