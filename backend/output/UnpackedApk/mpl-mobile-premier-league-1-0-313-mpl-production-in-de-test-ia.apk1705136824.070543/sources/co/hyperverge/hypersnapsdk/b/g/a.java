package co.hyperverge.hypersnapsdk.b.g;

import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.analytics.mixpanel.network.b;
import co.hyperverge.hypersnapsdk.c.n;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: ApiClient */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static b f3036b;

    /* renamed from: c  reason: collision with root package name */
    public static d f3037c;

    /* renamed from: d  reason: collision with root package name */
    public static b f3038d;

    public static d a(Cache cache) {
        if (f3037c == null) {
            Builder builder = new Builder();
            a(builder);
            Retrofit.Builder builder2 = new Retrofit.Builder();
            if (n.m() != null) {
                builder2.baseUrl("https://s3-ap-south-1.amazonaws.com");
                builder2.client(builder.cache(cache).build());
                builder2.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(), "factory == null"));
                f3037c = (d) builder2.build().create(d.class);
            } else {
                throw null;
            }
        }
        return f3037c;
    }

    public static b b() {
        if (f3036b == null) {
            Builder builder = new Builder();
            a(builder);
            if (HyperSnapSDK.getInstance() != null) {
                if (HyperSnapSDK.f2946b.isShouldEnableSSLPinning()) {
                    builder.certificatePinner(new CertificatePinner.Builder().add("ind.faceid.hyperverge.co", "sha256/hHWXbXBGT2chaVwYyxEyGqtPJX9H/dh5HbOAz5CmclM=").add("ind.faceid.hyperverge.co", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=").add("ind.faceid.hyperverge.co", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=").add("ind.docs.hyperverge.co", "sha256/hHWXbXBGT2chaVwYyxEyGqtPJX9H/dh5HbOAz5CmclM=").add("ind.docs.hyperverge.co", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=").add("ind.docs.hyperverge.co", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=").add("staging.api.hyperverge.co", "sha256/hHWXbXBGT2chaVwYyxEyGqtPJX9H/dh5HbOAz5CmclM=").add("staging.api.hyperverge.co", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=").add("staging.api.hyperverge.co", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=").add("*.hyperverge.co", "sha256/C3U1B8/WXNaje+K8wU4TRgV0htiLVH9gikN4+kwR+P4=").add("*.hyperverge.co", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=").add("*.hyperverge.co", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=").build());
                }
                Retrofit.Builder builder2 = new Retrofit.Builder();
                builder2.baseUrl(n.m().h);
                builder2.client(builder.build());
                builder2.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(), "factory == null"));
                f3036b = (b) builder2.build().create(b.class);
            } else {
                throw null;
            }
        }
        return f3036b;
    }

    public static void a(Builder builder) {
        if (HyperSnapSDK.getInstance() != null) {
            long readTimeOut = (long) HyperSnapSDK.f2946b.getReadTimeOut();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.readTimeout(readTimeOut, timeUnit);
            if (HyperSnapSDK.getInstance() != null) {
                builder.writeTimeout((long) HyperSnapSDK.f2946b.getWriteTimeOut(), timeUnit);
                if (HyperSnapSDK.getInstance() != null) {
                    builder.connectTimeout((long) HyperSnapSDK.f2946b.getConnectTimeOut(), timeUnit);
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
