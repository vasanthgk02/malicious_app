package co.hyperverge.hypersnapsdk.analytics.mixpanel.network;

import android.content.Intent;
import androidx.core.app.JobIntentService;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient.Builder;
import org.apache.fontbox.cmap.CMapParser;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MixPanelIntentService extends JobIntentService {

    /* renamed from: b  reason: collision with root package name */
    public b f3011b;

    /* renamed from: c  reason: collision with root package name */
    public List<?> f3012c;

    public class a extends TypeToken<List<?>> {
        public a() {
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onHandleWork(Intent intent) {
        "onHandleWork() called with: intent = [" + intent + CMapParser.MARK_END_OF_ARRAY;
        if (this.f3011b == null) {
            if (co.hyperverge.hypersnapsdk.b.g.a.f3038d == null) {
                if (HyperSnapSDK.getInstance() != null) {
                    HyperSnapSDKConfig hyperSnapSDKConfig = HyperSnapSDK.f2946b;
                    Builder builder = new Builder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    builder.connectTimeout((long) hyperSnapSDKConfig.getConnectTimeOut(), timeUnit);
                    builder.writeTimeout((long) hyperSnapSDKConfig.getWriteTimeOut(), timeUnit);
                    builder.readTimeout((long) hyperSnapSDKConfig.getReadTimeOut(), timeUnit);
                    Retrofit.Builder builder2 = new Retrofit.Builder();
                    if (n.m() != null) {
                        builder2.baseUrl("https://api.mixpanel.com/track/");
                        builder2.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(), "factory == null"));
                        builder2.client(builder.build());
                        co.hyperverge.hypersnapsdk.b.g.a.f3038d = (b) builder2.build().create(b.class);
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            this.f3011b = co.hyperverge.hypersnapsdk.b.g.a.f3038d;
        }
        try {
            Gson gson = new Gson();
            this.f3012c = (List) gson.fromJson(intent.getStringExtra("events"), new a().getType());
            "onHandleWork() : posting mixPanelEvents = [" + this.f3012c + CMapParser.MARK_END_OF_ARRAY;
            Response execute = this.f3011b.a(gson.toJson((Object) this.f3012c)).execute();
            this.f3012c = null;
            "onHandleWork() response = [" + execute + CMapParser.MARK_END_OF_ARRAY;
            if (execute != null) {
                T t = execute.body;
                if (t instanceof Double) {
                    if (((Double) t).doubleValue() != 0.0d) {
                        ((Double) t).doubleValue();
                    }
                } else if (t != null) {
                    "onResponse: errorResponse: " + ((c) gson.fromJson(t.toString(), c.class));
                }
            }
        } catch (IOException unused) {
            throw null;
        } catch (Exception unused2) {
        }
    }
}
