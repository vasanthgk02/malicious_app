package a.a.a.a;

import a.a.a.a.d.b;
import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import androidx.room.RoomDatabase.JournalMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.analytics.kafka.Config;
import com.mpl.analytics.kafka.MPLDatabase;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.RequestPriority;
import java.util.Timer;
import org.json.JSONObject;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public Config f2424a;

    /* renamed from: b  reason: collision with root package name */
    public final MPLDatabase f2425b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f2426c;

    /* renamed from: d  reason: collision with root package name */
    public long f2427d;

    /* renamed from: e  reason: collision with root package name */
    public long f2428e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2429f;

    public j(Context context, Config config) {
        Builder<MPLDatabase> databaseBuilder = Room.databaseBuilder(context, MPLDatabase.class, "events_mpl_database");
        databaseBuilder.allowMainThreadQueries = true;
        databaseBuilder.fallbackToDestructiveMigration();
        databaseBuilder.enableMultiInstanceInvalidation();
        databaseBuilder.setJournalMode(JournalMode.AUTOMATIC);
        this.f2425b = (MPLDatabase) databaseBuilder.build();
        this.f2424a = config;
        if (a.k == null) {
            a.k = new a();
        }
        this.f2429f = a.k;
        boolean isLogEnabled = this.f2424a.isLogEnabled();
        b.f6a = isLogEnabled;
        MLog.setIsLogEnabled(isLogEnabled);
    }

    public void a(JSONObject jSONObject) {
        if (this.f2424a != null) {
            b.a((String) "DatabaseManagement", "startIndex: ", Long.valueOf(this.f2428e), "lastIndex", Long.valueOf(this.f2427d));
            MOKHttpPostRequest.Builder postJsonObject = new MOKHttpPostRequest.Builder().setRequestPriority(RequestPriority.LOW).setHeaders(this.f2424a.getHeaders()).setUrl(this.f2424a.getPostUrl()).setConnectTimeout(this.f2424a.getConnectionTimeOut()).setRetryOnConnectionFailure(true).setPostJsonObject(jSONObject.toString());
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Kafka_");
            outline73.append(System.currentTimeMillis());
            MClient.executeAsync(postJsonObject.setTag(outline73.toString()).setResponseListener(new i(this)).build());
        }
    }
}
