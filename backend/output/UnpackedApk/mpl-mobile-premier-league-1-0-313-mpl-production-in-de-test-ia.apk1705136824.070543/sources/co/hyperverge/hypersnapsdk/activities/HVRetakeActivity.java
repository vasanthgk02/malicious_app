package co.hyperverge.hypersnapsdk.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import com.inca.security.Proxy.iIiIiIiIii;

public class HVRetakeActivity extends a {

    /* renamed from: d  reason: collision with root package name */
    public final String f3005d = HVRetakeActivity.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    public ImageView f3006e;

    /* renamed from: f  reason: collision with root package name */
    public String f3007f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k = "";
    public boolean l = false;
    public boolean m = false;
    public int n;
    public float o;
    public double p;
    public HVBaseConfig q;
    public String r;
    public final q s = new q();
    public final q t = new q();
    public String u;

    /* access modifiers changed from: 0000 */
    public void a(View view) {
        long longValue = this.t.c().longValue();
        if (this.u.contains("Face")) {
            if (n.m().o) {
                n.m().a(getApplicationContext()).a((HVFaceConfig) this.q, longValue);
            }
            if (HyperSnapSDK.getInstance() == null) {
                throw null;
            } else if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                n.m().l.a(System.currentTimeMillis(), (String) "selfieRetakeClicked");
            }
        }
        if (this.u.contains("Doc") && n.m().o) {
            n.m().a(getApplicationContext()).c((HVDocConfig) this.q, longValue);
        }
        if (n.m().o && n.m().j != null) {
            n.m().j.B();
        }
        setResult(21);
        finish();
    }

    public void d() {
        setResult(20);
        finish();
    }

    public boolean e() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -2061810651, bundle);
    }

    public void onRemoteConfigFetchDone() {
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 231277244, new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public HVBaseConfig a() {
        return this.q;
    }

    public final String a(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
