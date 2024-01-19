package co.hyperverge.hypersnapsdk.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.R$id;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.c.k;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.Locale;

/* compiled from: HVBaseActivity */
public abstract class a extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3008a = a.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    public co.hyperverge.hypersnapsdk.f.j.a f3009b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressDialog f3010c = null;

    /* access modifiers changed from: private */
    public void b() {
        if (n.m() == null || n.m().n) {
            ProgressDialog progressDialog = this.f3010c;
            if (progressDialog != null && progressDialog.isShowing() && i.a((Activity) this)) {
                this.f3010c.dismiss();
            }
            onRemoteConfigFetchDone();
            return;
        }
        if (!this.f3010c.isShowing()) {
            this.f3010c.show();
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                a.this.checkAndWaitForRemoteConfig();
            }
        }, 100);
    }

    public static /* synthetic */ void b(DialogInterface dialogInterface, int i) {
    }

    public abstract HVBaseConfig a();

    public void a(HVBaseConfig hVBaseConfig, View view) {
        if (view == null) {
            view = findViewById(16908290).getRootView();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.llBranding);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.llTrustLogos);
        int i = 0;
        boolean z = n.m() != null && n.m().p().f3026a;
        boolean shouldShowTrustLogos = hVBaseConfig.shouldShowTrustLogos();
        linearLayout.setVisibility(z ? 0 : 8);
        if (!shouldShowTrustLogos) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
    }

    public void checkAndWaitForRemoteConfig() {
        if (this.f3010c == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f3010c = progressDialog;
            progressDialog.setMessage(k.f3108c);
            this.f3010c.setCancelable(false);
        }
        co.hyperverge.hypersnapsdk.f.j.a aVar = this.f3009b;
        aVar.f3185b.post(new Runnable() {
            public final void run() {
                a.this.b();
            }
        });
    }

    public abstract void d();

    public abstract boolean e();

    public final void g() {
        try {
            co.hyperverge.hypersnapsdk.service.c.a a2 = co.hyperverge.hypersnapsdk.service.c.a.a(this);
            if (a2 != null) {
                try {
                    FusedLocationProviderClient fusedLocationProviderClient = a2.f3196b;
                    if (fusedLocationProviderClient != null) {
                        fusedLocationProviderClient.removeLocationUpdates(a2.f3198d);
                    }
                } catch (NoClassDefFoundError e2) {
                    i.a((Throwable) e2);
                }
            } else {
                throw null;
            }
        } catch (NoClassDefFoundError unused) {
        }
    }

    public void handleCloseAction() {
        String str;
        if (e()) {
            HVBaseConfig a2 = a();
            String str2 = null;
            if (a2 != null) {
                str2 = a2.getCloseAlertDialogTitle();
                str = a2.getCloseAlertDialogDesc();
            } else {
                str = null;
            }
            if (str2 == null) {
                str2 = getString(R$string.hv_close_alert_title);
            }
            if (str == null) {
                str = getString(R$string.hv_close_alert_desc);
            }
            Builder builder = new Builder(this);
            AlertParams alertParams = builder.P;
            alertParams.mTitle = str2;
            alertParams.mMessage = str;
            alertParams.mCancelable = false;
            builder.setPositiveButton(R$string.hv_close_alert_positive_action, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface, i);
                }
            });
            builder.setNegativeButton(R$string.hv_close_alert_negative_action, (OnClickListener) $$Lambda$0Tx7EmfTRu28vRZSN4mys39wPFk.INSTANCE);
            builder.show();
            return;
        }
        d();
    }

    public void onBackPressed() {
        try {
            String name = getClass().getName();
            if (name.contains("HVFaceActivity") && n.m().o) {
                n.m().a(getApplicationContext()).r();
            }
            if (name.contains("HVDocsActivity") && n.m().o) {
                n.m().a(getApplicationContext()).i();
            }
            if (name.contains("HVDocReviewActivity") && n.m().o) {
                n.m().a(getApplicationContext()).p();
            }
            if (name.contains("HVRetakeActivity")) {
                String className = getCallingActivity().getClassName();
                if (className.contains("Face") && n.m().o) {
                    n.m().a(getApplicationContext()).y();
                }
                if (className.contains("Doc") && n.m().o) {
                    n.m().a(getApplicationContext()).d();
                }
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
        }
        handleCloseAction();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.a((Context) this);
        this.f3009b = co.hyperverge.hypersnapsdk.f.j.a.a();
    }

    public void onDestroy() {
        super.onDestroy();
        g();
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
            n.m().l.M();
        }
    }

    public void onPause() {
        super.onPause();
        g();
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
            co.hyperverge.hypersnapsdk.service.d.a aVar = n.m().l;
            SensorManager sensorManager = aVar.s;
            if (sensorManager != null) {
                sensorManager.unregisterListener(aVar.A);
                aVar.z = false;
            }
        }
    }

    public abstract void onRemoteConfigFetchDone();

    public void onResume() {
        Locale locale;
        super.onResume();
        if (VERSION.SDK_INT >= 24) {
            locale = getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = getResources().getConfiguration().locale;
        }
        if (VERSION.SDK_INT >= 24) {
            Configuration configuration = getResources().getConfiguration();
            configuration.setLocale(locale);
            createConfigurationContext(configuration);
        } else {
            Resources resources = getResources();
            Configuration configuration2 = resources.getConfiguration();
            configuration2.locale = locale;
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
        }
        k.a((Context) this);
        if (!n.m().n) {
            return;
        }
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
            n.m().l.K();
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        d();
    }
}
