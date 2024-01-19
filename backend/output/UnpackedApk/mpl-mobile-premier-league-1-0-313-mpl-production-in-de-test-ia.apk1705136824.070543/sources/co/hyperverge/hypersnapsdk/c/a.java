package co.hyperverge.hypersnapsdk.c;

import android.content.Context;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.f.j.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: AdvertisingIDHelper */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f3061b;

    /* renamed from: c  reason: collision with root package name */
    public b f3062c = b.a();

    /* renamed from: d  reason: collision with root package name */
    public String f3063d = null;

    /* renamed from: co.hyperverge.hypersnapsdk.c.a$a  reason: collision with other inner class name */
    /* compiled from: AdvertisingIDHelper */
    public class C0053a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3064a;

        public C0053a(Context context) {
            this.f3064a = context;
        }

        public void run() {
            try {
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f3064a.getApplicationContext());
                a.this.f3063d = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
            } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e2) {
                i.a(e2);
            }
        }
    }
}
