package co.hyperverge.hypersnapsdk.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.R$id;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.d.a.a.c;
import co.hyperverge.hypersnapsdk.d.a.a.d;
import co.hyperverge.hypersnapsdk.f.f;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.listeners.FaceCaptureCompletionHandler;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig.LivenessMode;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class HVFaceActivity extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2996d = HVFaceActivity.class.getCanonicalName();

    /* renamed from: e  reason: collision with root package name */
    public f f2997e;

    /* renamed from: f  reason: collision with root package name */
    public c f2998f;
    public HVFaceConfig g;
    public final q h = new q();
    public final q i = new q();

    public class a implements OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HVFaceActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1001);
        }
    }

    public class b implements OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HVError hVError = new HVError(33, "GPS access denied by user");
            if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
                HVFaceActivity.b(null, hVError, null);
                HVFaceActivity.this.finish();
                return;
            }
            throw null;
        }
    }

    public static void b(FaceCaptureCompletionHandler faceCaptureCompletionHandler, HVError hVError, HVResponse hVResponse) {
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                n.m().l.M();
            }
            faceCaptureCompletionHandler.onResult(hVError, hVResponse);
            return;
        }
        throw null;
    }

    public HVBaseConfig a() {
        return this.g;
    }

    public void checkForPermissions() {
        this.h.d();
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"android.permission.CAMERA"}));
        this.f2997e.a(this, arrayList);
        if (this.f2997e.b(this, arrayList).f3182b.isEmpty()) {
            n.m().a(getApplicationContext()).h(this.h.c().longValue());
            checkAndWaitForRemoteConfig();
        }
    }

    public void d() {
        try {
            c cVar = this.f2998f;
            if (cVar != null) {
                ((d) cVar.I).c();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public boolean e() {
        return this.g.shouldShowCloseAlert();
    }

    public final void i() {
        if (((LocationManager) co.hyperverge.hypersnapsdk.service.c.a.a(this).f3200f.getSystemService("location")).isProviderEnabled("gps")) {
            co.hyperverge.hypersnapsdk.service.c.a.a(this).a();
            co.hyperverge.hypersnapsdk.service.c.a.a(this).c();
            return;
        }
        Builder builder = new Builder(this);
        AlertParams alertParams = builder.P;
        alertParams.mTitle = "GPS Switched Off";
        alertParams.mMessage = "Please enable GPS to continue";
        alertParams.mCancelable = false;
        a aVar = new a();
        AlertParams alertParams2 = builder.P;
        alertParams2.mPositiveButtonText = "Open settings";
        alertParams2.mPositiveButtonListener = aVar;
        b bVar = new b();
        AlertParams alertParams3 = builder.P;
        alertParams3.mNegativeButtonText = "Cancel";
        alertParams3.mNegativeButtonListener = bVar;
        builder.show();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        try {
            this.h.d();
            this.i.d();
            c cVar = this.f2998f;
            if (cVar != null) {
                cVar.q.d();
                cVar.o.d();
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
        }
        HVFaceConfig hVFaceConfig = this.g;
        if (hVFaceConfig != null && hVFaceConfig.isShouldRecordVideo()) {
            c cVar2 = this.f2998f;
            if (cVar2 != null) {
                cVar2.C();
            }
        }
        if (i2 == 1001) {
            try {
                i();
            } catch (NoClassDefFoundError unused) {
            }
        }
        if (i3 == 2) {
            checkForPermissions();
        } else if (i3 == 3) {
            try {
                HVError hVError = new HVError(3, getResources().getString(R$string.operation_cancelled));
                if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
                    b(null, hVError, null);
                    finish();
                    return;
                }
                throw null;
            } catch (Exception e3) {
                i.a((Throwable) e3);
                if (n.m().i != null) {
                    n.m().i.a(e3);
                }
            }
        } else if (i3 == 18) {
            HVError hVError2 = (HVError) intent.getSerializableExtra("hvError");
            try {
                if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
                    b(null, hVError2, null);
                    finish();
                    return;
                }
                throw null;
            } catch (Exception e4) {
                i.a((Throwable) e4);
                if (n.m().i != null) {
                    n.m().i.a(e4);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -2074602576, bundle);
    }

    public void onRemoteConfigFetchDone() {
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics()) {
                String d2 = i.d((String) "face");
                if (n.m().l != null) {
                    n.m().l.b(d2);
                    n.m().l.a(System.currentTimeMillis(), (String) "selfieFlowStarted");
                }
                JSONObject headers = this.g.getHeaders();
                try {
                    headers.put("sensorDataZipFileName", d2);
                    this.g.setLivenessAPIHeaders(headers);
                } catch (Exception e2) {
                    i.a((Throwable) e2);
                }
            }
            try {
                this.f2998f = new c();
                d dVar = new d();
                dVar.k = this.f2998f;
                this.f2998f.I = dVar;
                LivenessMode mode = this.g.getMode();
                if (mode != null) {
                    dVar.t = mode;
                }
                this.g.getClientID();
                dVar.z = this.g;
                c cVar = this.f2998f;
                HVFaceConfig hVFaceConfig = this.g;
                cVar.R = hVFaceConfig;
                if (hVFaceConfig.isShouldRecordVideo()) {
                    cVar.f3145b = new co.hyperverge.hypersnapsdk.f.d<>(cVar.R.getNumberOfFrames());
                    cVar.R.getNumberOfFrames();
                    cVar.R.getBitrateM();
                    cVar.R.getFps();
                }
                getSupportFragmentManager().beginTransaction().replace(R$id.texture_container, this.f2998f).commit();
                if (n.m().o && n.m().j != null) {
                    long longValue = this.i.c().longValue();
                    n.m().j.c(this.g);
                    n.m().j.d(longValue);
                    n.m().j.u();
                }
            } catch (Exception e3) {
                i.a((Throwable) e3);
                if (n.m().o && n.m().j != null) {
                    n.m().j.h(new HVError(2, i.a((Throwable) e3)));
                }
                if (n.m().i != null) {
                    n.m().i.a(e3);
                }
            }
        } else {
            throw null;
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        co.hyperverge.hypersnapsdk.f.f.a b2 = this.f2997e.b(this, new ArrayList(Arrays.asList(new String[]{"android.permission.CAMERA"})));
        if (b2.f3182b.isEmpty()) {
            if (n.m().o && n.m().j != null) {
                n.m().j.h(this.h.c().longValue());
            }
            checkAndWaitForRemoteConfig();
        } else {
            String join = TextUtils.join(",", b2.f3182b);
            try {
                HVError hVError = new HVError(4, GeneratedOutlineSupport.outline50("Following Permissions not granted by user: ", join));
                if (co.hyperverge.hypersnapsdk.e.a.a() != null) {
                    b(null, hVError, null);
                    finish();
                    HVError hVError2 = new HVError(4, GeneratedOutlineSupport.outline50("Following Permissions not granted by user: ", join));
                    if (n.m().o && n.m().j != null) {
                        n.m().j.b(hVError2, this.h.c().longValue());
                    }
                    finish();
                } else {
                    throw null;
                }
            } catch (Exception e2) {
                i.a((Throwable) e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 181791443, new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
