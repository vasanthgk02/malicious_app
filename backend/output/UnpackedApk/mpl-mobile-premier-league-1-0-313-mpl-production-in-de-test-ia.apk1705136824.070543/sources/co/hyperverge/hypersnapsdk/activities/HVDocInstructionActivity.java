package co.hyperverge.hypersnapsdk.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import com.inca.security.Proxy.iIiIiIiIii;

public class HVDocInstructionActivity extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2958d = HVDocInstructionActivity.class.getCanonicalName();

    /* renamed from: e  reason: collision with root package name */
    public final q f2959e = new q();

    /* renamed from: f  reason: collision with root package name */
    public final q f2960f = new q();
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;

    public class a implements OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (n.m().o && n.m().j != null) {
                n.m().j.a(HVDocInstructionActivity.this.f2960f.c().longValue());
            }
            HVDocInstructionActivity hVDocInstructionActivity = HVDocInstructionActivity.this;
            hVDocInstructionActivity.setResult(10);
            hVDocInstructionActivity.finish();
        }
    }

    public HVBaseConfig a() {
        return null;
    }

    public void d() {
    }

    public boolean e() {
        return false;
    }

    public void onBackPressed() {
        setResult(11);
        finish();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -526326744, bundle);
    }

    public void onRemoteConfigFetchDone() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
