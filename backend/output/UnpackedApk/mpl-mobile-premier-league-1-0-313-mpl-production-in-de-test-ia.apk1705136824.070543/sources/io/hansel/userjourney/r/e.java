package io.hansel.userjourney.r;

import android.content.Context;
import android.util.Pair;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.security.murmur.HSLMurmurAllocation;
import io.hansel.userjourney.models.g;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class e extends c {

    /* renamed from: c  reason: collision with root package name */
    public Context f5735c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f5736d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5737e;

    /* renamed from: f  reason: collision with root package name */
    public g f5738f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CoreJSONArray f5739a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c> f5740b;

        /* renamed from: c  reason: collision with root package name */
        public String f5741c;

        public a(CoreJSONArray coreJSONArray, ArrayList<c> arrayList, String str) {
            this.f5739a = coreJSONArray;
            this.f5740b = arrayList;
            this.f5741c = str;
        }
    }

    public e(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        super(str, str2, coreJSONObject, context);
        this.f5735c = context;
        try {
            CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("split");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(str, str2, optJSONArray.optJSONObject(i)));
            }
            a(coreJSONObject.getString("idx"));
            this.f5736d = arrayList;
            this.f5737e = coreJSONObject.optBoolean("g_a", true);
            this.f5738f = new g(context, coreJSONObject, str);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    private a a(String str, String str2, CoreJSONObject coreJSONObject) {
        return new a(coreJSONObject.optJSONArray("rngs"), io.hansel.userjourney.g.a(str, str2, coreJSONObject.optJSONArray("s"), this.f5735c), coreJSONObject.optString("type"));
    }

    public Pair<String, ArrayList<c>> b(String str, String str2) {
        Object obj;
        try {
            HSLLogger.d("Invoked getStatements method  in Rollout Node for journey " + str + "with leaf node id " + str2 + " and current node id " + b());
            StringBuilder sb = new StringBuilder();
            sb.append(HSLFiltersInternal.getInstance().getUniqueId());
            sb.append(str);
            sb.append(b());
            String sb2 = sb.toString();
            List<a> list = this.f5736d;
            int size = list == null ? 0 : list.size();
            if (str2 != null) {
                for (int i = 0; i < size; i++) {
                    a aVar = this.f5736d.get(i);
                    if (aVar != null) {
                        ArrayList<c> arrayList = aVar.f5740b;
                        if (arrayList != null) {
                            int size2 = arrayList.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                if (str2.startsWith(aVar.f5740b.get(i2).b())) {
                                    return new Pair<>(str2, aVar.f5740b);
                                }
                            }
                            continue;
                        }
                    }
                }
                obj = null;
            } else {
                obj = null;
                for (int i3 = 0; i3 < size; i3++) {
                    a aVar2 = this.f5736d.get(i3);
                    if ("default".equals(aVar2.f5741c)) {
                        obj = aVar2.f5740b;
                    } else if (new HSLMurmurAllocation(aVar2.f5739a, MqttAsyncClient.DISCONNECT_TIMEOUT).validateAllocation(sb2)) {
                        return new Pair<>(str2, aVar2.f5740b);
                    }
                }
            }
            return new Pair<>(str2, obj);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            HSLLogger.e("Error: Unable to get statements for Rollout Node with id " + b() + " and journey id " + str + "with leaf node id " + str2);
            return null;
        }
    }

    public g c() {
        return this.f5738f;
    }

    public boolean d() {
        return this.f5737e;
    }
}
