package io.hansel.userjourney;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.core.security.ICrypto;
import io.hansel.core.utils.HSLUtils;
import io.hansel.hanselsdk.HanselRequestType;
import io.hansel.segments.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HSLJourneyModule extends HSLModule implements r {
    public static r serverSegmentRequestHandler;
    public Context context;
    public HSLServerResponseHandler getDataResponseHandler;
    public d journeyConfigSource;
    public f journeyEventsSource;
    public h nudgePriorityManager;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5402a;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5402a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.RE_EVALUATE_JOURNEYS     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 46
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x0018 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0018 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x0021 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_JOURNEY_LIST     // Catch:{ NoSuchFieldError -> 0x0021 }
                r1 = 47
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.USER_ID_CHANGED     // Catch:{ NoSuchFieldError -> 0x002a }
                r1 = 40
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.AEP_GET_DATA     // Catch:{ NoSuchFieldError -> 0x0033 }
                r1 = 34
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x003c }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.AEP_DIL     // Catch:{ NoSuchFieldError -> 0x003c }
                r1 = 38
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f5402a     // Catch:{ NoSuchFieldError -> 0x0045 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.CLEAR_TTL     // Catch:{ NoSuchFieldError -> 0x0045 }
                r1 = 17
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.HSLJourneyModule.a.<clinit>():void");
        }
    }

    private void reEvaluateJourneys(Set<String> set, boolean z) {
        if (set != null) {
            this.journeyEventsSource.b();
            this.journeyConfigSource.clear();
            ArrayList arrayList = new ArrayList(set);
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            boolean z2 = false;
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                HSLLogger.d("Re-evaluating the journey with id " + str);
                String m = p.m(this.context, str);
                e a2 = e.a(this.context);
                a2.a(str);
                this.nudgePriorityManager.b(this.context, str);
                hashSet.addAll(a2.b(str, p.n(this.context, str), this.nudgePriorityManager));
                String m2 = p.m(this.context, str);
                this.journeyEventsSource.b(str, m2);
                if (isBranchUpdated(m, m2, str)) {
                    z2 = true;
                }
            }
            this.nudgePriorityManager.a(this.context);
            if (z || z2) {
                fireBranchUpdateEvent();
            }
            e.a(this.context).a(0);
            downloadImages(hashSet);
            publishJourneyEvalFinish();
        }
    }

    private void schedule() {
        HSLSDKIdentifiers hSLSDKIdentifiers = this.moduleInitializationData.sdkIdentifiers;
        boolean isTGStatusKnown = HSLInternalUtils.isTGStatusKnown(this.context);
        if (isTGStatusKnown && HSLInternalUtils.getBooleanFromSharedPreferences(this.context, "is_dil_enabled", true)) {
            long currentTimeMillis = System.currentTimeMillis();
            long u = p.u(this.context, "DIL_DATA");
            if (u == 0 || currentTimeMillis >= u) {
                fireServerSegmentDataRequest(hSLSDKIdentifiers);
            }
        }
        if (isTGStatusKnown && HSLInternalUtils.getBooleanFromSharedPreferences(this.context, "is_ujm_enabled", true)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            long t = p.t(this.context, "GET_DATA");
            long u2 = p.u(this.context, "GET_DATA");
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Sync status: Last sync time is ");
            outline73.append(HSLUtils.getReadableTimeFromMillis(t));
            HSLLogger.i(outline73.toString());
            if (u2 == 0 || currentTimeMillis2 >= u2) {
                HSLLogger.i("Sync status: TTL has expired hence trying to sync nudges with Hansel servers.");
                this.moduleInitializationData.networkTaskHandler.schedule(new m(this.context, hSLSDKIdentifiers, this.getDataResponseHandler));
                return;
            }
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Sync status: TTL did not expire and the next sync time is ");
            outline732.append(HSLUtils.getReadableTimeFromMillis(u2));
            HSLLogger.i(outline732.toString());
            this.moduleInitializationData.hanselSyncStateListenerInternal.onHanselSynced(HanselRequestType.configs, true);
            getLinkedMessageBroker().publishEvent(EventsConstants.CONFIGS_SYNCED.name(), Boolean.TRUE);
        }
    }

    public static void setServerSegmentRequestHandler(r rVar) {
        serverSegmentRequestHandler = rVar;
    }

    public void clearSource() {
        d dVar = this.journeyConfigSource;
        if (dVar != null) {
            dVar.clear();
        }
        f fVar = this.journeyEventsSource;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void downloadImage(String str) {
        c cVar = c.JPEG;
        if (str != null && str.endsWith(".png")) {
            cVar = c.PNG;
        } else if (str != null && str.endsWith(".gif")) {
            cVar = c.GIF;
        }
        b bVar = new b(this.context, str, getLinkedMessageBroker(), cVar);
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("IMAGES", 0);
        if (!HSLUtils.isSet(sharedPreferences.getString(str, ""))) {
            Editor edit = sharedPreferences.edit();
            edit.putString(str, sharedPreferences.getAll().size() + "__HSL_DOWNLOADING").apply();
        }
        this.moduleInitializationData.networkTaskHandler.schedule(new l(this.context, str, bVar));
    }

    public void downloadImages(Set<String> set) {
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            if (!HSLUtils.isSet(this.context.getSharedPreferences("IMAGES", 0).getString(str, ""))) {
                downloadImage(str);
            }
        }
    }

    public void fireBranchUpdateEvent() {
        getLinkedMessageBroker().publishBlockingEvent(EventsConstants.FIRE_BRANCH_TRACKER_EVENT.name(), null);
    }

    public void fireServerSegmentDataRequest(HSLSDKIdentifiers hSLSDKIdentifiers) {
        r rVar = serverSegmentRequestHandler;
        if (rVar != null) {
            rVar.fireServerSegmentDataRequest(hSLSDKIdentifiers);
        }
    }

    public String getCode() {
        return "jm";
    }

    public String[] getPublishingEvents() {
        return new String[]{EventsConstants.REGISTER_CONFIG_SOURCE.name(), EventsConstants.REGISTER_TRACKER_SOURCE.name(), EventsConstants.HANDLE_DEEP_CONFIGS.name(), EventsConstants.SET_JOURNEY_LIST.name(), EventsConstants.FIRE_BRANCH_TRACKER_EVENT.name()};
    }

    public String[] getSubscribingEvents() {
        return new String[]{EventsConstants.RE_EVALUATE_JOURNEYS.name(), EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND.name(), EventsConstants.GET_JOURNEY_LIST.name(), EventsConstants.USER_ID_CHANGED.name(), EventsConstants.AEP_GET_DATA.name(), EventsConstants.AEP_DIL.name(), EventsConstants.CLEAR_TTL.name(), EventsConstants.GET_DEFAULT_BRANCH_TRACKER_TTL.name()};
    }

    public void handleDebugConfig(String str) {
        getLinkedMessageBroker().publishEvent(EventsConstants.DEBUG_CONFIG.name(), str);
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            switch (a.f5402a[EventsConstants.valueOf(str).ordinal()]) {
                case 1:
                    if (obj instanceof HashSet) {
                        reEvaluateJourneys((HashSet) obj, false);
                    }
                    return true;
                case 2:
                    schedule();
                    return true;
                case 3:
                    getLinkedMessageBroker().publishBlockingEvent(EventsConstants.SET_JOURNEY_LIST.name(), e.a(this.context).b());
                    return true;
                case 4:
                    fireServerSegmentDataRequest(this.moduleInitializationData.sdkIdentifiers);
                    reEvaluateJourneys(p.d(this.context), true);
                    return true;
                case 5:
                    if (obj instanceof String) {
                        p.O(this.moduleInitializationData.app, (String) obj);
                    }
                    return true;
                case 6:
                    if (obj instanceof String) {
                        p.N(this.moduleInitializationData.app, (String) obj);
                    }
                    return true;
                case 7:
                    p.b(this.context, "GET_DATA");
                    p.b(this.context, "DIL_DATA");
                    return true;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        Context applicationContext = hSLModuleInitializationData.app.getApplicationContext();
        this.context = applicationContext;
        if (hSLModuleInitializationData.hasAppVersionChanged) {
            p.b(applicationContext, "GET_DATA");
            p.b(this.context, "DIL_DATA");
        }
        if (this.journeyConfigSource == null) {
            this.journeyConfigSource = new d(this.context, hSLModuleInitializationData.sdkIdentifiers.appVersion);
        }
        iMessageBroker.publishEvent(EventsConstants.REGISTER_CONFIG_SOURCE.name(), this.journeyConfigSource);
        EventsConstants eventsConstants = EventsConstants.REGISTER_GET_DATA_STATUS_LISTENER;
        iMessageBroker.publishBlockingEvent(eventsConstants.name(), this.journeyConfigSource);
        if (this.journeyEventsSource == null) {
            this.journeyEventsSource = new f(this.context);
        }
        iMessageBroker.publishEvent(EventsConstants.REGISTER_TRACKER_SOURCE.name(), this.journeyEventsSource);
        iMessageBroker.publishBlockingEvent(eventsConstants.name(), this.journeyEventsSource);
        if (this.nudgePriorityManager == null) {
            this.nudgePriorityManager = new h();
        }
        if (this.getDataResponseHandler == null) {
            this.getDataResponseHandler = new a(this, this.context, getLinkedMessageBroker(), this.nudgePriorityManager);
        }
    }

    public boolean isBranchUpdated(String str, String str2, String str3) {
        if (str != null && str.equals(str2)) {
            return false;
        }
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("Branch is updated for journey ", str3, "   with ", str, " , ");
        outline82.append(str2);
        HSLLogger.d(outline82.toString(), LogGroup.CJ);
        return true;
    }

    public void publishConfigsResponse(CoreJSONObject coreJSONObject) {
        getLinkedMessageBroker().publishEvent(EventsConstants.HANDLE_DEEP_CONFIGS.name(), coreJSONObject);
    }

    public void publishJourneyEvalFinish() {
        getLinkedMessageBroker().publishEvent(EventsConstants.JOURNS_FINISH.name(), null);
    }

    public Object returnEventData(String str, Object obj) {
        return str.equals(EventsConstants.GET_DEFAULT_BRANCH_TRACKER_TTL.name()) ? Long.valueOf(86400000) : super.returnEventData(str, obj);
    }

    public void syncState(boolean z) {
        this.moduleInitializationData.hanselSyncStateListenerInternal.onHanselSynced(HanselRequestType.ujm, z);
        this.moduleInitializationData.hanselSyncStateListenerInternal.onHanselSynced(HanselRequestType.configs, z);
        if (z) {
            HSLInternalUtils.setBooleanInSharedPreferences(this.context, "is_first_get_data_sync_done", true);
        }
        getLinkedMessageBroker().publishEvent(EventsConstants.CONFIGS_SYNCED.name(), Boolean.valueOf(z));
    }
}
