package co.hyperverge.hypersnapsdk;

import android.annotation.SuppressLint;
import co.hyperverge.hypersnapsdk.b.g.c.b;
import co.hyperverge.hypersnapsdk.c.h;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.e.a;
import co.hyperverge.hypersnapsdk.listeners.InitializerCallback;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig;
import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.Cache;

public class HyperSnapSDK {

    /* renamed from: b  reason: collision with root package name */
    public static HyperSnapSDKConfig f2946b = new HyperSnapSDKConfig();

    /* renamed from: c  reason: collision with root package name */
    public static HyperSnapSDK f2947c;

    /* renamed from: e  reason: collision with root package name */
    public static Cache f2948e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2949f = false;
    public InitializerCallback g;

    public class b implements co.hyperverge.hypersnapsdk.b.g.c.b {
        public b(HyperSnapSDK hyperSnapSDK) {
        }

        public void onError(HVError hVError) {
            hVError.getErrorMessage();
            n.m().m = h.a();
            n.m().n = true;
        }

        public void onSuccess() {
            n.m().n = true;
        }
    }

    public class c implements co.hyperverge.hypersnapsdk.b.g.c.b {
        public c() {
        }

        public void onError(HVError hVError) {
            HyperSnapSDK.this.c();
        }

        public void onSuccess() {
            HyperSnapSDK.this.c();
        }
    }

    public static HyperSnapSDK getInstance() {
        if (f2947c == null) {
            f2947c = new HyperSnapSDK();
        }
        return f2947c;
    }

    public final void a(String str, int i) {
        if (this.g != null) {
            HVError hVError = new HVError();
            hVError.setErrorCode(i);
            hVError.setErrorMessage(str);
            this.g.onError(hVError);
            if (getInstance() == null) {
                throw null;
            } else if (f2946b == null) {
            } else {
                if (getInstance() == null) {
                    throw null;
                } else if (f2946b.isShouldUseRemoteConfig() && a.a() == null) {
                    throw null;
                }
            }
        }
    }

    @SuppressLint({"LogNotTimber"})
    public final void c() {
        Cache cache = f2948e;
        if (co.hyperverge.hypersnapsdk.b.g.c.f3040b == null) {
            co.hyperverge.hypersnapsdk.b.g.c.f3040b = new co.hyperverge.hypersnapsdk.b.g.c(cache);
        }
        co.hyperverge.hypersnapsdk.b.g.c cVar = co.hyperverge.hypersnapsdk.b.g.c.f3040b;
        b bVar = new b(this);
        if (cVar == null) {
            throw null;
        } else if (n.m() != null) {
            String outline50 = GeneratedOutlineSupport.outline50("https://s3.ap-south-1.amazonaws.com/hv-sdk-device-configs/hypersnap/android/", "sdk.json");
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("https://s3.ap-south-1.amazonaws.com/hv-sdk-device-configs/hypersnap/android/");
            outline73.append(String.format("%s.json", new Object[]{"3.6.38"}));
            cVar.f3042d.submit(new Runnable(outline50, outline73.toString(), bVar) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ b f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    c.this.a(this.f$1, this.f$2, this.f$3);
                }
            });
        } else {
            throw null;
        }
    }
}
