package io.hansel.userjourney;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.utilities.k;
import io.hansel.core.base.network.StatusCodeResponseHandler;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogLevel;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventData;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.utils.HSLUtils;
import io.hansel.hanselsdk.Hansel;
import io.hansel.segments.e;
import io.hansel.segments.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import sfs2x.client.requests.CreateRoomRequest;

public class a extends StatusCodeResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final h f5403a;

    /* renamed from: b  reason: collision with root package name */
    public final HSLJourneyModule f5404b;

    /* renamed from: c  reason: collision with root package name */
    public final IMessageBroker f5405c;

    /* renamed from: io.hansel.userjourney.a$a  reason: collision with other inner class name */
    public class C0082a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5406a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoreJSONObject f5407b;

        public C0082a(String str, CoreJSONObject coreJSONObject) {
            this.f5406a = str;
            this.f5407b = coreJSONObject;
        }

        public void run() {
            long j;
            a.this.f5404b.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.GET_DATA_EVAL_STARTED.name(), null);
            a.this.f5404b.clearSource();
            p.i(a.this.context, "GET_DATA", this.f5406a);
            try {
                j = this.f5407b.getLong("bt_ttl") * 60000;
            } catch (CoreJSONException unused) {
                HSLLogger.d("Branch Tracker TTL not received from server. Falling back to the default value");
                j = 86400000;
            }
            a.this.f5405c.publishEvent(EventsConstants.SAVE_BRANCH_TRACKER_TTL.name(), Long.valueOf(j));
            CoreJSONObject optJSONObject = this.f5407b.optJSONObject("dc");
            if (optJSONObject != null) {
                a.this.f5404b.publishConfigsResponse(optJSONObject);
            }
            e.a(a.this.context).a(this.f5407b.optJSONObject("ipa"));
            e.a(a.this.context).a(System.currentTimeMillis());
            CoreJSONObject optJSONObject2 = this.f5407b.optJSONObject("s");
            if (optJSONObject2 != null) {
                n.a(a.this.context).a(optJSONObject2, new EventData(EventsConstants.GET_DATA_JOURNS, null, e.a(a.this.context).a()));
            }
            CoreJSONObject optJSONObject3 = this.f5407b.optJSONObject("n");
            CoreJSONObject optJSONObject4 = optJSONObject3 != null ? optJSONObject3.optJSONObject("up") : null;
            CoreJSONObject optJSONObject5 = this.f5407b.optJSONObject("ti");
            if (optJSONObject5 != null) {
                a.this.d(optJSONObject5);
            }
            CoreJSONObject optJSONObject6 = this.f5407b.optJSONObject("j");
            if (optJSONObject6 != null) {
                a.this.a(optJSONObject6, optJSONObject4);
            }
            CoreJSONObject optJSONObject7 = this.f5407b.optJSONObject("flags");
            if (optJSONObject7 != null) {
                a.this.f5404b.getLinkedMessageBroker().publishEvent(EventsConstants.GET_DATA_EVAL_FINISHED.name(), null);
                a.this.c(optJSONObject7);
            }
            e.a(a.this.context).a(0);
            a.this.f5404b.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.GET_DATA_EVAL_FINISHED.name(), null);
            a.this.f5404b.publishJourneyEvalFinish();
            HSLLogger.i("Get Data Sync Successful");
            a.this.a();
            a.this.b();
            a.this.f5404b.syncState(true);
        }
    }

    public a(HSLJourneyModule hSLJourneyModule, Context context, IMessageBroker iMessageBroker, h hVar) {
        super(context);
        this.f5404b = hSLJourneyModule;
        this.f5405c = iMessageBroker;
        this.f5403a = hVar;
    }

    private Runnable a(String str, String str2) {
        return new C0082a(str2, new CoreJSONObject(str));
    }

    /* access modifiers changed from: private */
    public void a() {
        if (HSLLogLevel.mid.isEnabled()) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences("attribute_value_map", 0);
            Set<String> keySet = sharedPreferences.getAll().keySet();
            HSLLogger.d("Segments:  ", LogGroup.GT);
            ArrayList arrayList = new ArrayList(keySet);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                boolean z = sharedPreferences.getBoolean(str, false);
                HSLLogger.d(str + CMap.SPACE + z, LogGroup.GT);
            }
            SharedPreferences sharedPreferences2 = this.context.getSharedPreferences("sub_segment_values", 0);
            Set<String> keySet2 = sharedPreferences2.getAll().keySet();
            HSLLogger.d("Sub Segments:  ", LogGroup.GT);
            ArrayList arrayList2 = new ArrayList(keySet2);
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = (String) arrayList2.get(i2);
                boolean z2 = sharedPreferences2.getBoolean(str2, false);
                HSLLogger.d(str2 + CMap.SPACE + z2, LogGroup.GT);
            }
            HashMap<String, String> interactionMaps = Hansel.getInteractionMaps();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Total journeys : ");
            outline73.append(interactionMaps.size());
            outline73.append("\n\n");
            HSLLogger.d(outline73.toString(), LogGroup.GT);
            for (String next : interactionMaps.keySet()) {
                HSLLogger.d(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline78(next, " -> "), interactionMaps.get(next), "\n"), LogGroup.GT);
            }
            SharedPreferences sharedPreferences3 = this.context.getSharedPreferences("experiences_su", 0);
            Set<String> keySet3 = sharedPreferences3.getAll().keySet();
            HSLLogger.d("Configs:  ", LogGroup.GT);
            ArrayList arrayList3 = new ArrayList(keySet3);
            int size3 = arrayList3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                String str3 = (String) arrayList3.get(i3);
                HSLLogger.d(GeneratedOutlineSupport.outline52(str3, CMap.SPACE, sharedPreferences3.getString(str3, "")), LogGroup.GT);
            }
            SharedPreferences sharedPreferences4 = this.context.getSharedPreferences(HSLFiltersInternal.HANSEL_FILTERS_SP_NAME, 0);
            Set<String> keySet4 = sharedPreferences4.getAll().keySet();
            HSLLogger.d("Attributes:  ", LogGroup.GT);
            ArrayList arrayList4 = new ArrayList(keySet4);
            int size4 = arrayList4.size();
            for (int i4 = 0; i4 < size4; i4++) {
                String str4 = (String) arrayList4.get(i4);
                HSLLogger.d(GeneratedOutlineSupport.outline52(str4, CMap.SPACE, sharedPreferences4.getString(str4, "")), LogGroup.GT);
            }
        }
    }

    private void a(CoreJSONObject coreJSONObject) {
        try {
            if (coreJSONObject.getBoolean(ChannelPipelineCoverage.ALL)) {
                e.a(this.context).a(this.f5403a);
            } else {
                CoreJSONArray jSONArray = coreJSONObject.getJSONArray(k.f4287a);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    ArrayList arrayList = new ArrayList(jSONArray.getJSONObject(i).keySet());
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = (String) arrayList.get(i2);
                        e.a(this.context).a(str, (String) null, this.f5403a);
                        p.F(this.context, str);
                    }
                }
            }
            p.m(this.context);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    /* access modifiers changed from: private */
    public void a(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        p.c(this.context);
        try {
            a(coreJSONObject.getJSONObject("d"));
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
        this.f5403a.a(this.context, coreJSONObject2);
        try {
            b(coreJSONObject.getJSONObject("up"));
        } catch (CoreJSONException e3) {
            HSLLogger.printStackTrace(e3);
        }
        this.f5403a.a(this.context);
        p.a(this.context);
    }

    /* access modifiers changed from: private */
    public void b() {
        String str = (String) this.f5405c.returnEventData(EventsConstants.GET_CONFIG_VALUE_FOR_CONFIG_NAME.name(), "hsl_debug_mode");
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(":DeviceId=");
        outline73.append(HSLFiltersInternal.getInstance().getDeviceId());
        String sb = outline73.toString();
        if (HSLUtils.isSet(str) && str.contains(sb)) {
            this.f5404b.handleDebugConfig(str.replace(sb, ""));
        }
    }

    private void b(CoreJSONObject coreJSONObject) {
        Set<String> keySet = coreJSONObject.keySet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        try {
            ArrayList arrayList = new ArrayList(keySet);
            int size = arrayList.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                String o = p.o(this.context, str);
                Pair<HashSet<String>, HashSet<String>> a2 = e.a(this.context).a(str, p.n(this.context, str), coreJSONObject.getJSONObject(str), this.f5403a);
                if (a2 != null) {
                    hashSet.addAll((Collection) a2.first);
                    hashSet2.addAll((Collection) a2.second);
                }
                String m = p.m(this.context, str);
                HSLLogger.d("Journey evaluated " + str + " with " + o + " -> " + m, LogGroup.CJ);
                if (this.f5404b.isBranchUpdated(o, m, str)) {
                    z = true;
                }
            }
            if (z) {
                this.f5404b.fireBranchUpdateEvent();
            }
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2, "Journey not evaluated ", LogGroup.CJ);
        }
        if (hashSet2.size() > 0) {
            io.hansel.segments.k.a(this.context, (Set<String>) hashSet2);
        }
        this.f5404b.downloadImages(hashSet);
    }

    /* access modifiers changed from: private */
    public void c(CoreJSONObject coreJSONObject) {
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("n_f");
        String uniqueId = HSLFiltersInternal.getInstance().getUniqueId();
        if (optJSONObject != null) {
            p.b(this.context, uniqueId, optJSONObject);
        }
    }

    /* access modifiers changed from: private */
    public void d(CoreJSONObject coreJSONObject) {
        p.b(this.context);
        if (coreJSONObject != null) {
            p.a(this.context, coreJSONObject);
        }
    }

    public long getTTL() {
        return p.v(this.context, "GET_DATA");
    }

    public void onError(Throwable th) {
        HSLLogger.printStackTraceMin(th, "Get Data Sync Unsuccessful");
        this.f5404b.syncState(false);
    }

    public void onNoDataUpdate() {
        this.f5404b.syncState(true);
    }

    public void onParseResponse(HSLServerRequest hSLServerRequest, CoreJSONObject coreJSONObject) {
        long optLong = coreJSONObject.optLong("ttl");
        long currentTimeMillis = System.currentTimeMillis();
        p.d(this.context, (String) "GET_DATA", optLong);
        p.b(this.context, (String) "GET_DATA", currentTimeMillis);
        p.c(this.context, (String) "GET_DATA", (60000 * optLong) + currentTimeMillis);
        String optString = coreJSONObject.optString(CreateRoomRequest.KEY_ROOMVARS);
        if (!optString.equals(p.z(this.context, "GET_DATA"))) {
            this.f5405c.enqueue(a(coreJSONObject.toString(), optString));
        } else {
            this.f5404b.syncState(true);
        }
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, InputStream inputStream, int i) {
    }

    public void saveTTL(long j) {
        p.b(this.context, (String) "GET_DATA", System.currentTimeMillis());
        p.c(this.context, (String) "GET_DATA", j);
    }
}
