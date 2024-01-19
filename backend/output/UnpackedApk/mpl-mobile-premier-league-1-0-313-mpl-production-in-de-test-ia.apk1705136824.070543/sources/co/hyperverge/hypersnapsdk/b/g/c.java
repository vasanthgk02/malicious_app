package co.hyperverge.hypersnapsdk.b.g;

import android.annotation.SuppressLint;
import co.hyperverge.hypersnapsdk.b.e;
import co.hyperverge.hypersnapsdk.c.h;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVError;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Cache;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint({"LogNotTimber"})
/* compiled from: HVRemoteConfigRepo */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3039a;

    /* renamed from: b  reason: collision with root package name */
    public static c f3040b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f3041c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f3042d = Executors.newSingleThreadExecutor();

    /* renamed from: e  reason: collision with root package name */
    public final Cache f3043e;

    /* compiled from: HVRemoteConfigRepo */
    public class a implements Callback<e> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f3044a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3045b;

        public a(boolean z, b bVar) {
            this.f3044a = z;
            this.f3045b = bVar;
        }

        public void onFailure(Call<e> call, Throwable th) {
            if (this.f3044a) {
                c.this.a(true, i.a(th), 12);
            }
            n.m().k = new e();
            this.f3045b.onError(new HVError(12, "Could not get remote configs"));
        }

        public void onResponse(Call<e> call, Response<e> response) {
            String str;
            if (response.isSuccessful()) {
                c.a(c.this, this.f3044a);
                n.m().k = (e) response.body;
                this.f3045b.onSuccess();
                return;
            }
            ResponseBody responseBody = response.errorBody;
            if (responseBody != null) {
                try {
                    str = responseBody.string();
                } catch (IOException e2) {
                    i.a((Throwable) e2);
                }
                c.this.a(this.f3044a, str, response.code());
                n.m().a();
                this.f3045b.onError(new HVError(response.code(), "Could not get remote configs"));
            }
            str = "Server Error";
            c.this.a(this.f3044a, str, response.code());
            n.m().a();
            this.f3045b.onError(new HVError(response.code(), "Could not get remote configs"));
        }
    }

    /* compiled from: HVRemoteConfigRepo */
    public interface b {
        void onError(HVError hVError);

        void onSuccess();
    }

    static {
        Class<c> cls = c.class;
        f3041c = !cls.desiredAssertionStatus();
        f3039a = cls.getCanonicalName();
    }

    public c(Cache cache) {
        this.f3043e = cache;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, b bVar) {
        try {
            d a2 = a.a(this.f3043e);
            Response execute = a2.a(str).execute();
            Response execute2 = a2.a(str2).execute();
            if (!execute.isSuccessful() || !execute2.isSuccessful()) {
                String a3 = a(execute);
                String a4 = a(execute2);
                bVar.onError(new HVError(12, a3 + "\n" + a4));
                return;
            }
            List<co.hyperverge.hypersnapsdk.b.f.a> list = ((co.hyperverge.hypersnapsdk.b.f.b) execute.body).f3035a;
            List<co.hyperverge.hypersnapsdk.b.f.a> list2 = ((co.hyperverge.hypersnapsdk.b.f.b) execute2.body).f3035a;
            boolean z = f3041c;
            if (!z) {
                if (list == null) {
                    throw new AssertionError();
                }
            }
            if (!z) {
                if (list2 == null) {
                    throw new AssertionError();
                }
            }
            n.m().m = h.a(list, list2);
            bVar.onSuccess();
        } catch (Exception e2) {
            bVar.onError(new HVError(12, i.a((Throwable) e2)));
        }
    }

    public final <T> String a(Response<T> response) {
        String str;
        if (response.isSuccessful()) {
            return "";
        }
        ResponseBody responseBody = response.errorBody;
        if (responseBody != null) {
            try {
                str = responseBody.string();
            } catch (IOException e2) {
                i.a((Throwable) e2);
            }
            a(false, str, response.code());
            return str;
        }
        str = "Server Error";
        a(false, str, response.code());
        return str;
    }

    public static void a(c cVar, boolean z) {
        if (cVar == null) {
            throw null;
        } else if (z) {
            if (n.m().o && n.m().j != null) {
                n.m().j.w();
            }
        } else if (n.m().o && n.m().j != null) {
            n.m().j.b();
        }
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            if (n.m().o && n.m().j != null) {
                n.m().j.b(str, i);
            }
        } else if (n.m().o && n.m().j != null) {
            n.m().j.a(str, i);
        }
    }
}
