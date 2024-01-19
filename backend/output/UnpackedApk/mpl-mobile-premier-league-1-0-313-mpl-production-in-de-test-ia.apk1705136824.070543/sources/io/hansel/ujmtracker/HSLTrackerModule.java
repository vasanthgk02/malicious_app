package io.hansel.ujmtracker;

import android.content.Context;
import android.util.Pair;
import com.netcore.android.event.SMTEventId;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import java.util.HashMap;

public class HSLTrackerModule extends HSLModule {
    public Context context;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k.c(HSLTrackerModule.this.context, l.a());
            h.a().a((String) SMTEventId.EVENT_NH_BRANCH_TRACKER);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5311a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5311a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.REGISTER_TRACKER_SOURCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 49
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.AEP_ADD_EVENTS     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 35
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0022 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.AEP_TRACK_EVENTS     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 36
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.SAVE_VENDOR_LIMITS     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 29
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                r1 = 0
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x003c }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_BRANCH_TRACKER_EVENT     // Catch:{ NoSuchFieldError -> 0x003c }
                r1 = 30
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0045 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_PROMPT_EVENT     // Catch:{ NoSuchFieldError -> 0x0045 }
                r1 = 31
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x004f }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_PROMPT_SHOW_EVENT     // Catch:{ NoSuchFieldError -> 0x004f }
                r1 = 32
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.CONFIGS_SYNCED     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1 = 63
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0063 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_APP_LOAD_EVENT     // Catch:{ NoSuchFieldError -> 0x0063 }
                r1 = 73
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x006d }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_PENDING_NUDGE_EVENTS     // Catch:{ NoSuchFieldError -> 0x006d }
                r1 = 71
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0077 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.LOG_EVENT_INTERNAL     // Catch:{ NoSuchFieldError -> 0x0077 }
                r1 = 72
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                int[] r0 = f5311a     // Catch:{ NoSuchFieldError -> 0x0081 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.SAVE_BRANCH_TRACKER_TTL     // Catch:{ NoSuchFieldError -> 0x0081 }
                r1 = 74
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.ujmtracker.HSLTrackerModule.b.<clinit>():void");
        }
    }

    private void fireBranchTrackerEvent() {
        getLinkedMessageBroker().enqueue(new a());
    }

    private void processLimitsForVendor(CoreJSONArray coreJSONArray) {
        if (coreJSONArray != null) {
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("n");
                    Integer valueOf = Integer.valueOf(optJSONObject.optInt("ol", 100));
                    k.a(this.context, optString, Integer.valueOf(optJSONObject.optInt("al", 100)));
                    k.b(this.context, optString, valueOf);
                }
            }
        }
    }

    public void displayPrompts(io.hansel.userjourney.models.b bVar) {
        getLinkedMessageBroker().publishBlockingEvent(EventsConstants.DISPLAY_PROMPTS.name(), bVar);
    }

    public String getCode() {
        return "tm";
    }

    public String[] getPublishingEvents() {
        return new String[]{EventsConstants.INSERT_IPA.name(), EventsConstants.DISPLAY_PROMPTS.name()};
    }

    public String[] getSubscribingEvents() {
        return new String[]{EventsConstants.REGISTER_TRACKER_SOURCE.name(), EventsConstants.AEP_ADD_EVENTS.name(), EventsConstants.AEP_TRACK_EVENTS.name(), EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND.name(), EventsConstants.SAVE_VENDOR_LIMITS.name(), EventsConstants.FIRE_BRANCH_TRACKER_EVENT.name(), EventsConstants.FIRE_PROMPT_EVENT.name(), EventsConstants.FIRE_PROMPT_SHOW_EVENT.name(), EventsConstants.CONFIGS_SYNCED.name(), EventsConstants.FIRE_PENDING_NUDGE_EVENTS.name(), EventsConstants.LOG_EVENT_INTERNAL.name(), EventsConstants.FIRE_APP_LOAD_EVENT.name(), EventsConstants.SAVE_BRANCH_TRACKER_TTL.name()};
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            switch (b.f5311a[EventsConstants.valueOf(str).ordinal()]) {
                case 1:
                    if (obj instanceof e) {
                        h.a().a((e) obj);
                    }
                    return true;
                case 2:
                    if (obj instanceof String) {
                        k.e(this.moduleInitializationData.app, (String) obj);
                    }
                    return true;
                case 3:
                    if (obj instanceof String) {
                        k.f(this.moduleInitializationData.app, (String) obj);
                        h.a().g();
                    }
                    return true;
                case 4:
                    if (obj instanceof CoreJSONArray) {
                        processLimitsForVendor((CoreJSONArray) obj);
                        return true;
                    }
                    break;
                case 5:
                    HSLLogger.i("Application moved to foreground and firing two internal events");
                    h.a().c();
                    if (l.b(k.f(this.context), k.a(this.context, ((Long) getLinkedMessageBroker().returnEventData(EventsConstants.GET_DEFAULT_BRANCH_TRACKER_TTL.name(), null)).longValue()))) {
                        HSLLogger.d("Branch Tracker: invoked on app launch");
                        fireBranchTrackerEvent();
                    } else {
                        HSLLogger.d("Branch Tracker: not invoked on app launch");
                    }
                    return true;
                case 6:
                    HSLLogger.d("Branch Tracker: invoked on branch change");
                    fireBranchTrackerEvent();
                    return true;
                case 7:
                    if (obj != null) {
                        Pair pair = (Pair) obj;
                        h.a().a((HashMap) pair.first, (HashMap) pair.second);
                    }
                    return true;
                case 8:
                    if (obj != null) {
                        Pair pair2 = (Pair) obj;
                        h.a().b((HashMap) pair2.first, (HashMap) pair2.second);
                    }
                    return true;
                case 9:
                    h.a().d();
                    return true;
                case 10:
                    if (obj != null) {
                        c.b().a((Boolean) obj, this.moduleInitializationData.sdkIdentifiers);
                    }
                    return true;
                case 11:
                    g.a().b(this.context);
                    return true;
                case 12:
                    if (obj instanceof HashMap) {
                        HashMap hashMap = (HashMap) obj;
                        h.a().c((String) hashMap.get("event_name"), (String) hashMap.get("vendor"), (HashMap) hashMap.get(AnalyticsConstants.PROPERTIES), null, true);
                    }
                    return true;
                case 13:
                    if (!(obj instanceof Long)) {
                        return false;
                    }
                    long min = Math.min(((Long) obj).longValue(), ((Long) getLinkedMessageBroker().returnEventData(EventsConstants.GET_DEFAULT_BRANCH_TRACKER_TTL.name(), null)).longValue());
                    k.b(this.context, min);
                    HSLLogger.d("Branch Tracker TTL updated: " + min);
                    return true;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        this.context = hSLModuleInitializationData.app.getApplicationContext();
        h a2 = h.a();
        HSLInternalUtils.populateAppVersion(hSLModuleInitializationData.app, new HSLVersion());
        a2.a((Context) hSLModuleInitializationData.app, this, hSLModuleInitializationData.sdkIdentifiers, hSLModuleInitializationData.networkTaskHandler);
    }

    public void reevaluateJourneys(io.hansel.userjourney.models.b bVar) {
        getLinkedMessageBroker().publishEvent(EventsConstants.EVALUATE_EVENT.name(), bVar);
    }
}
