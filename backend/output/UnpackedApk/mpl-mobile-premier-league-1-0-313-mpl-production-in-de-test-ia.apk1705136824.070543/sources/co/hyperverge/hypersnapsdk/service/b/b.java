package co.hyperverge.hypersnapsdk.service.b;

import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.b.a;
import co.hyperverge.hypersnapsdk.b.g.e;
import co.hyperverge.hypersnapsdk.b.g.e.j;
import co.hyperverge.hypersnapsdk.c.o;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.listeners.APICompletionCallback;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import co.hyperverge.hypersnapsdk.objects.IPAddress;
import com.google.gson.Gson;
import com.netcore.android.SMTEventParamKeys;
import java.util.Date;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

/* compiled from: IPToGeoServiceImpl */
public class b {
    public void a(a$a a_a) {
        IPAddress iPAddress = (IPAddress) new Gson().fromJson(o.f3131b.getString("ipAddressData", new JSONObject().toString()), IPAddress.class);
        if (!((iPAddress == null || iPAddress.getCreatedAt() == null) ? false : true) || i.a(iPAddress.getCreatedAt()) > 30) {
            a a2 = a.a();
            $$Lambda$b$vB_sHumH2JTmWH35kRfofG78Oo8 r2 = new APICompletionCallback(a_a, iPAddress) {
                public final /* synthetic */ a$a f$1;
                public final /* synthetic */ IPAddress f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResult(HVError hVError, HVResponse hVResponse) {
                    b.this.a(this.f$1, this.f$2, hVError, hVResponse);
                }
            };
            e eVar = (e) a2.f3017b;
            if (eVar != null) {
                HashMap hashMap = new HashMap();
                if (HyperSnapSDK.getInstance() != null) {
                    if (HyperSnapSDK.f2946b.getAccessToken() != null) {
                        if (HyperSnapSDK.getInstance() == null) {
                            throw null;
                        } else if (!HyperSnapSDK.f2946b.getAccessToken().isEmpty()) {
                            if (HyperSnapSDK.getInstance() != null) {
                                hashMap.put("Authorization", HyperSnapSDK.f2946b.getAccessToken());
                                try {
                                    if (!o.i().trim().isEmpty() && !hashMap.containsKey("transactionId")) {
                                        hashMap.put("transactionId", o.i());
                                    }
                                } catch (Exception e2) {
                                    i.a((Throwable) e2);
                                }
                                co.hyperverge.hypersnapsdk.b.g.a.b().a("https://hypersnapweb.hyperverge.co/api/proxy/geoIP/", hashMap).enqueue(new j(r2));
                                return;
                            }
                            throw null;
                        }
                    }
                    if (HyperSnapSDK.getInstance() != null) {
                        hashMap.put(SMTEventParamKeys.SMT_APP_ID, HyperSnapSDK.f2946b.getAppId());
                        if (HyperSnapSDK.getInstance() != null) {
                            hashMap.put("appKey", HyperSnapSDK.f2946b.getAppKey());
                            hashMap.put("transactionId", o.i());
                            co.hyperverge.hypersnapsdk.b.g.a.b().a("https://hypersnapweb.hyperverge.co/api/proxy/geoIP/", hashMap).enqueue(new j(r2));
                            return;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        a_a.a(iPAddress);
    }

    /* access modifiers changed from: private */
    public void a(a$a a_a, IPAddress iPAddress, HVError hVError, HVResponse hVResponse) {
        "onResult() called with: error = [" + hVError + "], hvResponse = [" + hVResponse + CMapParser.MARK_END_OF_ARRAY;
        if (hVResponse != null && hVResponse.getApiResult() != null) {
            IPAddress iPAddress2 = (IPAddress) new Gson().fromJson(String.valueOf(hVResponse.getApiResult()), IPAddress.class);
            iPAddress2.setCreatedAt(new Date());
            o.f3131b.edit().putString("ipAddressData", new Gson().toJson((Object) iPAddress2)).apply();
            a_a.a(iPAddress2);
        } else if (hVError != null) {
            if ((iPAddress == null || iPAddress.getCreatedAt() == null) ? false : true) {
                a_a.a(iPAddress);
            } else {
                a_a.a();
            }
        }
    }
}
