package co.hyperverge.hypersnapsdk.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import com.inca.security.Proxy.iIiIiIiIii;

public class HVFaceInstructionActivity extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f3001d = HVFaceInstructionActivity.class.getCanonicalName();

    /* renamed from: e  reason: collision with root package name */
    public final q f3002e = new q();

    /* renamed from: f  reason: collision with root package name */
    public final q f3003f = new q();
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;

    public class a implements OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (n.m().o && n.m().j != null) {
                n.m().j.l(HVFaceInstructionActivity.this.f3003f.c().longValue());
            }
            HVFaceInstructionActivity hVFaceInstructionActivity = HVFaceInstructionActivity.this;
            hVFaceInstructionActivity.setResult(2);
            hVFaceInstructionActivity.finish();
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
        setResult(3);
        finish();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1322066868, bundle);
    }

    public void onRemoteConfigFetchDone() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
