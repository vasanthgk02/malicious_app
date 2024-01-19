package a.a.a.a.a;

import a.a.a.a.b.a;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.request.MRequest;
import com.mpl.network.modules.request.RequestPriority;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.apache.fontbox.cmap.CMapParser;

public final class e {

    /* renamed from: e  reason: collision with root package name */
    public static e f2396e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2397f;
    public static List<Protocol> g;

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient f2398a;

    /* renamed from: b  reason: collision with root package name */
    public Dispatcher f2399b;

    /* renamed from: c  reason: collision with root package name */
    public Dispatcher f2400c;

    /* renamed from: d  reason: collision with root package name */
    public CertificatePinner f2401d;

    public e() {
        MLog.d("NetworkLib: MClientBuilder", "Prepare Client First Time");
        OkHttpClient okHttpClient = this.f2398a;
        Builder newBuilder = okHttpClient != null ? okHttpClient.newBuilder() : new Builder();
        if (f2397f) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(Level.BODY);
            newBuilder.addInterceptor(new a());
            newBuilder.addInterceptor(httpLoggingInterceptor);
        }
        if (a() != null) {
            newBuilder.certificatePinner(a());
        }
        List<Protocol> list = g;
        if (list != null && list.size() > 0) {
            newBuilder.protocols(g);
        }
        this.f2398a = newBuilder.build();
        if (this.f2399b == null) {
            MLog.d("NetworkLib: MThreadPoolProvider", "getHighThreadPoolExecutor() called");
            if (f.f2403c == null) {
                if (b.f2393b == null) {
                    b.f2393b = new b();
                }
                f.f2403c = b.f2393b;
            }
            Dispatcher dispatcher = new Dispatcher(f.f2403c);
            this.f2399b = dispatcher;
            dispatcher.setMaxRequests(64);
            this.f2399b.setMaxRequestsPerHost(20);
        }
        if (this.f2400c == null) {
            MLog.d("NetworkLib: MThreadPoolProvider", "getNormalThreadPoolExecutor() called");
            if (f.f2402b == null) {
                if (d.f2395b == null) {
                    d.f2395b = new d();
                }
                f.f2402b = d.f2395b;
            }
            Dispatcher dispatcher2 = new Dispatcher(f.f2402b);
            this.f2400c = dispatcher2;
            dispatcher2.setMaxRequests(64);
            this.f2400c.setMaxRequestsPerHost(20);
        }
        MLog.d("NetworkLib: MClientBuilder", "Prepare Client First Time done: ", this.f2399b, " ---> ", this.f2400c);
    }

    public static e c() {
        MLog.d("NetworkLib: MClientBuilder", "getInstance() called: ");
        if (f2396e == null) {
            synchronized (e.class) {
                try {
                    if (f2396e == null) {
                        f2396e = new e();
                    }
                }
            }
        }
        return f2396e;
    }

    public final CertificatePinner a() {
        CertificatePinner build = new CertificatePinner.Builder().add("api.mpl.live", "sha256/qG8bcr0nB3jax8y5ITeXg63KROslai65SNB8K8O4oj8=", "sha256/5kJvNEMw0KjrCAu7eXY5HZdvyCS13BbA0VJG1RSP91w=", "sha256/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=").build();
        this.f2401d = build;
        MLog.d("NetworkLib: MClientBuilder", "createCertificatePinner() called ", build);
        return this.f2401d;
    }

    public void a(CertificatePinner certificatePinner) {
        MLog.d("NetworkLib: MClientBuilder", "addNewCertificatePinner() called with: certificatePinner = [" + certificatePinner + CMapParser.MARK_END_OF_ARRAY);
        this.f2401d = certificatePinner;
        if (certificatePinner != null) {
            this.f2398a = this.f2398a.newBuilder().certificatePinner(this.f2401d).build();
            MLog.d("NetworkLib: MClientBuilder", "Prepare Client with certificate First Time end");
        }
    }

    public OkHttpClient a(MRequest mRequest) {
        Builder newBuilder = this.f2398a.newBuilder();
        newBuilder.dispatcher(mRequest.getRequestPriority() == RequestPriority.HIGH ? this.f2399b : this.f2400c);
        newBuilder.retryOnConnectionFailure(mRequest.isRetryOnConnectionFailure());
        if (mRequest.getConnectTimeout() > 0) {
            newBuilder.connectTimeout((long) mRequest.getConnectTimeout(), TimeUnit.MILLISECONDS);
        }
        if (mRequest.getReadTimeout() > 0) {
            newBuilder.readTimeout((long) mRequest.getReadTimeout(), TimeUnit.MILLISECONDS);
        }
        if (mRequest.getWriteTimeout() > 0) {
            newBuilder.writeTimeout((long) mRequest.getWriteTimeout(), TimeUnit.MILLISECONDS);
        }
        if (mRequest.getPingInterval() > 0) {
            newBuilder.pingInterval((long) mRequest.getPingInterval(), TimeUnit.MILLISECONDS);
        }
        OkHttpClient build = newBuilder.build();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("prepareClient() called with: request = [");
        outline73.append(build.certificatePinner());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        MLog.d("NetworkLib: MClientBuilder", outline73.toString());
        return build;
    }
}
