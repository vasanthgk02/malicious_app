package io.hansel.segments;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventData;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import io.hansel.userjourney.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HSLSegmentModule extends HSLModule {
    public String appId;
    public Context context;
    public g ipaSource;
    public i promptDataProvider;
    public l screenNameManager;
    public HSLTaskHandler taskHandler;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                e.a(HSLSegmentModule.this.context).a();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EventsConstants f5240b;

        public b(String str, EventsConstants eventsConstants) {
            this.f5239a = str;
            this.f5240b = eventsConstants;
        }

        public void run() {
            try {
                io.hansel.userjourney.e.a(HSLSegmentModule.this.context).a(System.currentTimeMillis());
                HSLLogger.d("Hansel Segments: Filter value changed for attribute " + this.f5239a, LogGroup.CS);
                n a2 = n.a(HSLSegmentModule.this.context);
                Set<String> a3 = a2.a(this.f5240b, this.f5239a);
                a2.a(a3, new EventData(this.f5240b, this.f5239a, io.hansel.userjourney.e.a(HSLSegmentModule.this.context).a()));
                HSLSegmentModule.this.reEvaluateJourneys(a3);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventsConstants f5242a;

        public c(EventsConstants eventsConstants) {
            this.f5242a = eventsConstants;
        }

        public void run() {
            try {
                io.hansel.userjourney.e.a(HSLSegmentModule.this.context).a(System.currentTimeMillis());
                HSLLogger.d("Hansel Segments: All filter values cleared event received", LogGroup.CS);
                Set<String> b2 = n.a(HSLSegmentModule.this.context).b();
                n.a(HSLSegmentModule.this.context).a(b2, new EventData(this.f5242a, null, io.hansel.userjourney.e.a(HSLSegmentModule.this.context).a()));
                HSLSegmentModule.this.reEvaluateJourneys(b2);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Set f5244a;

        public d(Set set) {
            this.f5244a = set;
        }

        public void run() {
            try {
                Set set = this.f5244a;
                if (set != null && set.size() > 0) {
                    HSLSegmentModule.this.reEvaluateJourneys(this.f5244a);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5246a;

        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0080 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00ae */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5246a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.USER_ID_CHANGED     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 40
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r0 = 2
                int[] r1 = f5246a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.FILTER_CHANGED     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 43
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r1 = 3
                int[] r2 = f5246a     // Catch:{ NoSuchFieldError -> 0x0022 }
                io.hansel.core.module.EventsConstants r3 = io.hansel.core.module.EventsConstants.FILTERS_CLEARED     // Catch:{ NoSuchFieldError -> 0x0022 }
                r3 = 44
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r2 = 4
                int[] r3 = f5246a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.core.module.EventsConstants r4 = io.hansel.core.module.EventsConstants.JOURNS_FINISH     // Catch:{ NoSuchFieldError -> 0x002b }
                r4 = 54
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r3 = 5
                int[] r4 = f5246a     // Catch:{ NoSuchFieldError -> 0x0034 }
                io.hansel.core.module.EventsConstants r5 = io.hansel.core.module.EventsConstants.EVALUATE_EVENT     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 57
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r4 = 6
                int[] r5 = f5246a     // Catch:{ NoSuchFieldError -> 0x003d }
                io.hansel.core.module.EventsConstants r6 = io.hansel.core.module.EventsConstants.DISPLAY_PROMPTS     // Catch:{ NoSuchFieldError -> 0x003d }
                r6 = 58
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r5 = 7
                int[] r6 = f5246a     // Catch:{ NoSuchFieldError -> 0x0046 }
                io.hansel.core.module.EventsConstants r7 = io.hansel.core.module.EventsConstants.DISMISS_PROMPT     // Catch:{ NoSuchFieldError -> 0x0046 }
                r7 = 56
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                r6 = 8
                int[] r7 = f5246a     // Catch:{ NoSuchFieldError -> 0x004e }
                io.hansel.core.module.EventsConstants r8 = io.hansel.core.module.EventsConstants.ACTIVITY_OLD_ADDED     // Catch:{ NoSuchFieldError -> 0x004e }
                r7[r1] = r6     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                r1 = 9
                int[] r7 = f5246a     // Catch:{ NoSuchFieldError -> 0x0056 }
                io.hansel.core.module.EventsConstants r8 = io.hansel.core.module.EventsConstants.ACTIVITY_PAUSED     // Catch:{ NoSuchFieldError -> 0x0056 }
                r7[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r2 = f5246a     // Catch:{ NoSuchFieldError -> 0x005e }
                io.hansel.core.module.EventsConstants r7 = io.hansel.core.module.EventsConstants.ACTIVITY_RESUMED     // Catch:{ NoSuchFieldError -> 0x005e }
                r7 = 10
                r2[r3] = r7     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r2 = f5246a     // Catch:{ NoSuchFieldError -> 0x0066 }
                io.hansel.core.module.EventsConstants r3 = io.hansel.core.module.EventsConstants.ACTIVITY_NEW_ADDED     // Catch:{ NoSuchFieldError -> 0x0066 }
                r3 = 11
                r2[r0] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x006e }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.ACTIVITY_ROTATED     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 12
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.DIL_SEG_CHANGED     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 42
                r3 = 13
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x0080 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.ON_SET_SCREEN     // Catch:{ NoSuchFieldError -> 0x0080 }
                r2 = 14
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0080 }
            L_0x0080:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x0088 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.ON_UNSET_SCREEN     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x0092 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.IMAGE_DOWNLOADED     // Catch:{ NoSuchFieldError -> 0x0092 }
                r1 = 64
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x009a }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.HANDLE_ON_BACK_PRESSED     // Catch:{ NoSuchFieldError -> 0x009a }
                r1 = 17
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x00a4 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_CURRENT_SCREEN_NAME     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r1 = 60
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x00ae }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_PROMPT_SHOW_EVENT_MAP     // Catch:{ NoSuchFieldError -> 0x00ae }
                r1 = 76
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                int[] r0 = f5246a     // Catch:{ NoSuchFieldError -> 0x00b8 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_PROMPT_DISMISS_EVENT_MAP     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r1 = 77
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.segments.HSLSegmentModule.e.<clinit>():void");
        }
    }

    private Set<String> getAssociatedJourneys(String str) {
        return p.h(this.context, str);
    }

    /* access modifiers changed from: private */
    public void reEvaluateJourneys(Set<String> set) {
        HSLLogger.d("Hansel Segments: Re-evaluating journeys for segments " + set, LogGroup.CS);
        if (set == null || set.isEmpty()) {
            io.hansel.userjourney.e.a(this.context).a(0);
            return;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            hashSet.addAll(getAssociatedJourneys((String) arrayList.get(i)));
        }
        HSLLogger.d("Hansel Segments:Publishing event for re-Evaluating journeys " + hashSet);
        getLinkedMessageBroker().publishEvent(EventsConstants.RE_EVALUATE_JOURNEYS.name(), hashSet);
    }

    private void reevaluteSegJourn() {
        io.hansel.userjourney.e.a(this.context).a(System.currentTimeMillis());
        Set<String> b2 = e.a(this.context).b();
        n a2 = n.a(this.context);
        long a3 = io.hansel.userjourney.e.a(this.context).a();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(b2);
        int size = arrayList.size();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            hashSet.addAll(a2.d(str));
            hashSet2.addAll(a2.a((Set<String>) hashSet, new EventData(EventsConstants.INSERT_IPA, str, a3)));
        }
        reEvaluateJourneys(hashSet2);
    }

    public String getCode() {
        return "sm";
    }

    public String[] getPublishingEvents() {
        return new String[]{EventsConstants.RE_EVALUATE_JOURNEYS.name(), EventsConstants.REGISTER_IPA_SOURCE.name(), EventsConstants.FIRE_PROMPT_EVENT.name(), EventsConstants.FIRE_PROMPT_ACTION.name(), EventsConstants.LOG_EVENT_INTERNAL.name()};
    }

    public String[] getSubscribingEvents() {
        return new String[]{EventsConstants.FILTER_CHANGED.name(), EventsConstants.USER_ID_CHANGED.name(), EventsConstants.FILTERS_CLEARED.name(), EventsConstants.JOURNS_FINISH.name(), EventsConstants.EVALUATE_EVENT.name(), EventsConstants.DISMISS_PROMPT.name(), EventsConstants.ACTIVITY_NEW_ADDED.name(), EventsConstants.ACTIVITY_OLD_ADDED.name(), EventsConstants.ACTIVITY_ROTATED.name(), EventsConstants.HANDLE_ON_BACK_PRESSED.name(), EventsConstants.ON_SET_SCREEN.name(), EventsConstants.ON_UNSET_SCREEN.name(), EventsConstants.DIL_SEG_CHANGED.name(), EventsConstants.IMAGE_DOWNLOADED.name(), EventsConstants.ACTIVITY_PAUSED.name(), EventsConstants.ACTIVITY_RESUMED.name(), EventsConstants.GET_CURRENT_SCREEN_NAME.name(), EventsConstants.DISPLAY_PROMPTS.name(), EventsConstants.GET_PROMPT_SHOW_EVENT_MAP.name(), EventsConstants.GET_PROMPT_DISMISS_EVENT_MAP.name()};
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            EventsConstants valueOf = EventsConstants.valueOf(str);
            switch (e.f5246a[valueOf.ordinal()]) {
                case 1:
                case 2:
                    this.taskHandler.schedule(new b((String) obj, valueOf));
                    return true;
                case 3:
                    this.taskHandler.schedule(new c(valueOf));
                    return true;
                case 4:
                case 5:
                    reevaluteSegJourn();
                    return true;
                case 6:
                    this.promptDataProvider.a(getLinkedMessageBroker(), (io.hansel.userjourney.models.b) obj);
                    return true;
                case 7:
                    HSLLogger.d("Dismiss prompt event.", LogGroup.PT);
                    this.promptDataProvider.c();
                    return true;
                case 8:
                    HSLLogger.d("Old activity added.", LogGroup.PT);
                    return true;
                case 9:
                    HSLLogger.d("Activity paused " + obj, LogGroup.PT);
                    this.promptDataProvider.d();
                    return true;
                case 10:
                    HSLLogger.d("Activity resumed " + obj, LogGroup.PT);
                    this.promptDataProvider.f();
                    return true;
                case 11:
                    HSLLogger.d("New activity added.", LogGroup.PT);
                    return true;
                case 12:
                    HSLLogger.d("Activity rotated.", LogGroup.PT);
                    this.promptDataProvider.g();
                    return true;
                case 13:
                    this.taskHandler.schedule(new d((Set) obj));
                    return true;
                case 14:
                    this.screenNameManager.a((String) obj, getLinkedMessageBroker(), this.moduleInitializationData.sdkIdentifiers);
                    return true;
                case 15:
                    this.screenNameManager.b();
                    return true;
                case 16:
                    this.promptDataProvider.a((String[]) obj);
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
        this.appId = hSLModuleInitializationData.sdkIdentifiers.appId;
        n.a(applicationContext).a(iMessageBroker, iCrypto, Boolean.valueOf(hSLModuleInitializationData.shouldEnableEncryption));
        if (this.ipaSource == null) {
            this.ipaSource = new g(this.context);
        }
        iMessageBroker.publishEvent(EventsConstants.REGISTER_IPA_SOURCE.name(), this.ipaSource);
        HSLTaskHandler hSLTaskHandler = new HSLTaskHandler();
        this.taskHandler = hSLTaskHandler;
        hSLTaskHandler.schedule(new a());
        i iVar = new i(this.context, iMessageBroker);
        this.promptDataProvider = iVar;
        this.screenNameManager = new l(iVar);
    }

    public Object returnEventData(String str, Object obj) {
        if (str == null) {
            return null;
        }
        try {
            switch (e.f5246a[EventsConstants.valueOf(str).ordinal()]) {
                case 17:
                    return obj instanceof Activity ? Boolean.valueOf(this.promptDataProvider.e()) : Boolean.FALSE;
                case 18:
                    l lVar = this.screenNameManager;
                    if (lVar != null) {
                        return lVar.a();
                    }
                    return null;
                case 19:
                    if (!(obj instanceof Pair)) {
                        return null;
                    }
                    Pair pair = (Pair) obj;
                    return h.b(this.context, (CoreJSONObject) pair.second, (String) pair.first, this.appId);
                case 20:
                    if (!(obj instanceof Pair)) {
                        return null;
                    }
                    Pair pair2 = (Pair) obj;
                    return h.a(this.context, (CoreJSONObject) pair2.second, (String) pair2.first, this.appId);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return null;
    }
}
