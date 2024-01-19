package co.hyperverge.hypersnapsdk.service.a;

import android.content.Context;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;

/* compiled from: ErrorMonitor */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final co.hyperverge.hypersnapsdk.service.a.d.a f3191a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3192b;

    public a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f3192b = applicationContext;
        c cVar = new c();
        i.a();
        if (HyperSnapSDK.getInstance() != null) {
            cVar.f3193c = HyperSnapSDK.f2946b.getAppId();
            applicationContext.getPackageName();
            if (co.hyperverge.hypersnapsdk.service.a.d.a.f3194a == null) {
                co.hyperverge.hypersnapsdk.service.a.d.a.f3194a = new co.hyperverge.hypersnapsdk.service.a.d.a(cVar);
            }
            this.f3191a = co.hyperverge.hypersnapsdk.service.a.d.a.f3194a;
            return;
        }
        throw null;
    }

    public void a(Throwable th) {
        try {
            if (HyperSnapSDK.getInstance() != null) {
                if (HyperSnapSDK.f2946b.isShouldUseSensorBiometrics() && n.m().l != null) {
                    n.m().l.M();
                }
                if ((this.f3192b.getApplicationInfo().flags & 2) != 0) {
                    co.hyperverge.hypersnapsdk.service.a.d.a aVar = this.f3191a;
                    return;
                }
                return;
            }
            throw null;
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }
}
