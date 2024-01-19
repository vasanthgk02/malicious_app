package io.hansel.core.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import io.hansel.core.base.network.d;
import io.hansel.core.base.network.e;
import io.hansel.core.base.network.f;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.lifecycle.HanselActivityLifecycleManager;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import io.hansel.core.utils.HSLUtils;

public class HSLBaseModule extends HSLModule {
    public io.hansel.core.base.network.c initSDKUploadRequestScheduler;
    public io.hansel.core.lifecycle.a lifecycleHandler;
    public HSLModuleInitializationData moduleModel;
    public String[] publishingEvents;
    public CoreJSONObject stabilityData;
    public String[] subscribingEvents;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                HSLBaseModule.this.handleTgAdding(HSLUtils.clipboardData(HSLBaseModule.this.moduleModel.app));
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class b extends io.hansel.core.lifecycle.a {
        public b() {
        }

        public void a() {
            super.a();
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.APPLICATION_DID_MOVE_TO_BACKGROUND.name(), null);
            HSLLogger.i("App did move to background");
            HSLInternalUtils.setLastBackgroundTs(HSLBaseModule.this.moduleModel.app.getApplicationContext());
        }

        public void a(Boolean bool) {
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.FIRE_APP_LOAD_EVENT.name(), bool);
        }

        public void a(String str) {
            HSLLogger.d("HSLBaseModule: onActivityPaused " + str);
            HanselActivityLifecycleManager.getInstance().onPause();
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.ACTIVITY_PAUSED.name(), str);
        }

        public void b() {
            super.b();
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND.name(), null);
            HSLLogger.i("App did move to foreground");
            HSLInternalUtils.setLastForegroundTs(HSLBaseModule.this.moduleModel.app.getApplicationContext());
        }

        public void b(String str) {
            HSLLogger.d("HSLBaseModule: onActivityResumed " + str);
            HanselActivityLifecycleManager.getInstance().onResume();
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.ACTIVITY_RESUMED.name(), str);
        }

        public void c(String str) {
            HSLBaseModule.this.getLinkedMessageBroker().publishEvent(EventsConstants.ACTIVITY_NEW_ADDED.name(), str);
        }

        public void d() {
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.ACTIVITY_ROTATED.name(), null);
        }

        public void d(String str) {
            HSLBaseModule.this.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.ACTIVITY_OLD_ADDED.name(), str);
        }

        public Activity e() {
            return super.e();
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5093a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5093a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 10
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0018 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.PUSH_DATA     // Catch:{ NoSuchFieldError -> 0x0018 }
                r2 = 2
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0021 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.HANDLE_PUSH_DATA     // Catch:{ NoSuchFieldError -> 0x0021 }
                r2 = 11
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.PRE_INIT_SDK_API_CODE_MODULE     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 19
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.REGISTER_IPA_SOURCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 52
                r3 = 5
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x003c }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.AEP_TG_AUTHENTICATE     // Catch:{ NoSuchFieldError -> 0x003c }
                r2 = 39
                r3 = 6
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0045 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.CLEAR_TTL     // Catch:{ NoSuchFieldError -> 0x0045 }
                r2 = 17
                r3 = 7
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x004f }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.DEBUG_CONFIG     // Catch:{ NoSuchFieldError -> 0x004f }
                r2 = 65
                r3 = 8
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.GET_DATA_FLAGS_DATA     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 70
                r3 = 9
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r1 = f5093a     // Catch:{ NoSuchFieldError -> 0x0061 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.GET_TOP_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2 = 59
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.HSLBaseModule.c.<clinit>():void");
        }
    }

    public HSLBaseModule() {
        EventsConstants eventsConstants = EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND;
        this.publishingEvents = new String[]{eventsConstants.name(), EventsConstants.ACTIVITY_PAUSED.name(), EventsConstants.ACTIVITY_RESUMED.name(), EventsConstants.CRITERIA_FILTER_RESET.name(), EventsConstants.DEVICE_IN_TESTGROUP.name(), EventsConstants.CODE_PATCH_NEW_PRIMARY.name(), EventsConstants.VISUALISER_PATCH_NEW_PRIMARY.name()};
        this.subscribingEvents = new String[]{eventsConstants.name(), EventsConstants.PUSH_DATA.name(), EventsConstants.HANDLE_PUSH_DATA.name(), EventsConstants.PRE_INIT_SDK_API_CODE_MODULE.name(), EventsConstants.REGISTER_IPA_SOURCE.name(), EventsConstants.GET_TOP_ACTIVITY.name(), EventsConstants.AEP_TG_AUTHENTICATE.name(), EventsConstants.CLEAR_TTL.name(), EventsConstants.DEBUG_CONFIG.name(), EventsConstants.GET_DATA_FLAGS_DATA.name()};
    }

    private void getTgStatusFromServer(String str, boolean z) {
        e eVar = new e(this.moduleModel.app, getLinkedMessageBroker());
        HSLModuleInitializationData hSLModuleInitializationData = this.moduleModel;
        d dVar = new d(hSLModuleInitializationData.app, hSLModuleInitializationData.sdkIdentifiers, eVar, str, z);
        this.moduleInitializationData.networkTaskHandler.schedule(dVar);
    }

    private String getTgToken(String str) {
        return new io.hansel.core.d.c(this.moduleModel.app).a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078 A[SYNTHETIC, Splitter:B:23:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleCriteriaUpdate(android.content.Context r12, io.hansel.core.sdkmodels.HSLSDKIdentifiers r13) {
        /*
            r11 = this;
            java.lang.String r0 = "key_static_criteria_version"
            r1 = 0
            java.lang.String r2 = io.hansel.core.base.utils.HSLInternalUtils.getStringFromSharedPreferences(r12, r0, r1)
            java.lang.String r3 = "tz_offset"
            java.lang.String r4 = "device"
            java.lang.String r5 = "os_version"
            java.lang.String r6 = "device_id"
            java.lang.String r7 = "app_id"
            if (r2 == 0) goto L_0x0069
            io.hansel.core.json.CoreJSONObject r8 = new io.hansel.core.json.CoreJSONObject     // Catch:{ CoreJSONException -> 0x0065 }
            r8.<init>(r2)     // Catch:{ CoreJSONException -> 0x0065 }
            java.lang.String r9 = r8.getString(r7)     // Catch:{ CoreJSONException -> 0x0065 }
            java.lang.String r10 = r13.getAppId()     // Catch:{ CoreJSONException -> 0x0065 }
            boolean r9 = r9.equals(r10)     // Catch:{ CoreJSONException -> 0x0065 }
            if (r9 == 0) goto L_0x005b
            java.lang.String r9 = r8.getString(r6)     // Catch:{ CoreJSONException -> 0x0065 }
            java.lang.String r10 = r13.getDeviceId()     // Catch:{ CoreJSONException -> 0x0065 }
            boolean r9 = r9.equals(r10)     // Catch:{ CoreJSONException -> 0x0065 }
            if (r9 == 0) goto L_0x005b
            java.lang.String r9 = r8.getString(r5)     // Catch:{ CoreJSONException -> 0x0065 }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ CoreJSONException -> 0x0065 }
            boolean r9 = r9.equals(r10)     // Catch:{ CoreJSONException -> 0x0065 }
            if (r9 == 0) goto L_0x005b
            java.lang.String r9 = r8.getString(r4)     // Catch:{ CoreJSONException -> 0x0065 }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ CoreJSONException -> 0x0065 }
            boolean r9 = r9.equals(r10)     // Catch:{ CoreJSONException -> 0x0065 }
            if (r9 == 0) goto L_0x005b
            int r8 = r8.getInt(r3)     // Catch:{ CoreJSONException -> 0x0065 }
            java.util.TimeZone r9 = java.util.TimeZone.getDefault()     // Catch:{ CoreJSONException -> 0x0065 }
            int r9 = r9.getRawOffset()     // Catch:{ CoreJSONException -> 0x0065 }
            if (r8 == r9) goto L_0x0069
        L_0x005b:
            java.lang.String r2 = "hansel_patch_list_version"
            io.hansel.core.base.utils.HSLInternalUtils.setStringInSharedPreferences(r12, r2, r1)     // Catch:{ CoreJSONException -> 0x0062 }
            r2 = r1
            goto L_0x0069
        L_0x0062:
            r8 = move-exception
            r2 = r1
            goto L_0x0066
        L_0x0065:
            r8 = move-exception
        L_0x0066:
            io.hansel.core.logger.HSLLogger.printStackTrace(r8)
        L_0x0069:
            io.hansel.core.module.IMessageBroker r8 = r11.getLinkedMessageBroker()
            io.hansel.core.module.EventsConstants r9 = io.hansel.core.module.EventsConstants.CRITERIA_FILTER_RESET
            java.lang.String r9 = r9.name()
            r8.publishEvent(r9, r1)
            if (r2 != 0) goto L_0x00ac
            io.hansel.core.json.CoreJSONObject r1 = new io.hansel.core.json.CoreJSONObject     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.<init>()     // Catch:{ CoreJSONException -> 0x00a5 }
            java.lang.String r8 = r13.getAppId()     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.put(r7, r8)     // Catch:{ CoreJSONException -> 0x00a5 }
            java.lang.String r13 = r13.getDeviceId()     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.put(r6, r13)     // Catch:{ CoreJSONException -> 0x00a5 }
            java.lang.String r13 = android.os.Build.VERSION.RELEASE     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.put(r5, r13)     // Catch:{ CoreJSONException -> 0x00a5 }
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.put(r4, r13)     // Catch:{ CoreJSONException -> 0x00a5 }
            java.util.TimeZone r13 = java.util.TimeZone.getDefault()     // Catch:{ CoreJSONException -> 0x00a5 }
            int r13 = r13.getRawOffset()     // Catch:{ CoreJSONException -> 0x00a5 }
            r1.put(r3, r13)     // Catch:{ CoreJSONException -> 0x00a5 }
            java.lang.String r2 = r1.toString()     // Catch:{ CoreJSONException -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r13 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r13)
        L_0x00a9:
            io.hansel.core.base.utils.HSLInternalUtils.setStringInSharedPreferences(r12, r0, r2)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.HSLBaseModule.handleCriteriaUpdate(android.content.Context, io.hansel.core.sdkmodels.HSLSDKIdentifiers):void");
    }

    private void handleDebugEnabling(String str) {
        io.hansel.core.d.b.a(str);
    }

    /* access modifiers changed from: private */
    public void handleTgAdding(String str) {
        boolean isTGStatusKnown;
        String tgToken;
        if (HSLInternalUtils.isInTestGroup(this.moduleModel.app)) {
            HSLLogger.d("TGRequest:    Is in TestGroup");
            tgToken = getTgToken(str);
            isTGStatusKnown = true;
        } else {
            isTGStatusKnown = HSLInternalUtils.isTGStatusKnown(this.moduleModel.app);
            tgToken = getTgToken(str);
            if (tgToken != null) {
                HSLLogger.d("TGRequest:    Found TgToken,  isTgStatusKnown: " + isTGStatusKnown);
            } else if (!isTGStatusKnown) {
                HSLLogger.d("TGRequest:    Not Found TgToken,  isTgStatusKnown: " + isTGStatusKnown);
                tgToken = null;
                isTGStatusKnown = false;
            } else {
                return;
            }
        }
        getTgStatusFromServer(tgToken, isTGStatusKnown);
    }

    private void initLifecycleHandler(Application application) {
        if (this.lifecycleHandler == null) {
            b bVar = new b();
            this.lifecycleHandler = bVar;
            application.registerActivityLifecycleCallbacks(bVar);
            application.registerComponentCallbacks(this.lifecycleHandler);
        }
    }

    private void processFlagsFromGetData(Context context, CoreJSONObject coreJSONObject) {
        if (coreJSONObject != null) {
            HSLInternalUtils.setBooleanInSharedPreferences(context, "brach_tracker_on_app_load_enabled", coreJSONObject.optBoolean("al_t", false));
        }
    }

    private void scheduleInitialCalls(boolean z) {
        Context applicationContext = this.moduleModel.app.getApplicationContext();
        handleCriteriaUpdate(applicationContext, this.moduleModel.sdkIdentifiers);
        if (this.initSDKUploadRequestScheduler == null) {
            f fVar = new f(applicationContext, getLinkedMessageBroker(), this.moduleModel.hanselSyncStateListenerInternal);
            HSLModuleInitializationData hSLModuleInitializationData = this.moduleModel;
            this.initSDKUploadRequestScheduler = new io.hansel.core.base.network.c(applicationContext, hSLModuleInitializationData.sdkIdentifiers, hSLModuleInitializationData.networkTaskHandler, fVar);
        }
        CoreJSONObject coreJSONObject = null;
        CoreJSONObject coreJSONObject2 = this.stabilityData;
        if (coreJSONObject2 != null) {
            coreJSONObject = coreJSONObject2.optJSONObject("patchCounter");
        }
        io.hansel.core.base.network.b bVar = new io.hansel.core.base.network.b(System.currentTimeMillis(), coreJSONObject, z, this.lifecycleHandler.c());
        this.initSDKUploadRequestScheduler.a(bVar, this.stabilityData);
        HSLModuleInitializationData hSLModuleInitializationData2 = this.moduleModel;
        io.hansel.core.base.push.b.a(applicationContext, hSLModuleInitializationData2.sdkIdentifiers, hSLModuleInitializationData2.networkTaskHandler);
    }

    public String getCode() {
        return "bm";
    }

    public String[] getPublishingEvents() {
        return this.publishingEvents;
    }

    public String[] getSubscribingEvents() {
        return this.subscribingEvents;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        io.hansel.core.base.utils.HSLInternalUtils.saveTgAuthEndPoint(r6.moduleModel.app, (java.lang.String) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0116 A[Catch:{ all -> 0x010f, all -> 0x0135 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleEventData(java.lang.String r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r1.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "HSLBaseModule      handleEventData : "
            r1.append(r2)     // Catch:{ all -> 0x0135 }
            r1.append(r7)     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0135 }
            io.hansel.core.logger.HSLLogger.d(r1)     // Catch:{ all -> 0x0135 }
            io.hansel.core.module.EventsConstants r7 = io.hansel.core.module.EventsConstants.valueOf(r7)     // Catch:{ all -> 0x0135 }
            int[] r1 = io.hansel.core.base.HSLBaseModule.c.f5093a     // Catch:{ all -> 0x0135 }
            int r7 = r7.ordinal()     // Catch:{ all -> 0x0135 }
            r7 = r1[r7]     // Catch:{ all -> 0x0135 }
            r1 = 0
            java.lang.String r3 = "hansel_initsdk_request_silence_interval"
            r4 = 1
            switch(r7) {
                case 1: goto L_0x00e6;
                case 2: goto L_0x0094;
                case 3: goto L_0x0084;
                case 4: goto L_0x0063;
                case 5: goto L_0x004b;
                case 6: goto L_0x0059;
                case 7: goto L_0x0043;
                case 8: goto L_0x003d;
                case 9: goto L_0x002e;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0139
        L_0x002e:
            boolean r7 = r8 instanceof io.hansel.core.json.CoreJSONObject     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x0139
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleInitializationData     // Catch:{ all -> 0x0135 }
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            io.hansel.core.json.CoreJSONObject r8 = (io.hansel.core.json.CoreJSONObject) r8     // Catch:{ all -> 0x0135 }
            r6.processFlagsFromGetData(r7, r8)     // Catch:{ all -> 0x0135 }
            goto L_0x0139
        L_0x003d:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0135 }
            r6.handleDebugEnabling(r8)     // Catch:{ all -> 0x0135 }
            return r4
        L_0x0043:
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleModel     // Catch:{ all -> 0x0135 }
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            io.hansel.core.base.utils.HSLInternalUtils.setLongInSharedPreferences(r7, r3, r1)     // Catch:{ all -> 0x0135 }
            return r4
        L_0x004b:
            boolean r7 = r8 instanceof io.hansel.core.base.HSLEventsSource     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x0059
            io.hansel.core.base.HSLEventsSource r8 = (io.hansel.core.base.HSLEventsSource) r8     // Catch:{ all -> 0x0135 }
            io.hansel.core.base.a r7 = io.hansel.core.base.a.a()     // Catch:{ all -> 0x0135 }
            r7.a(r8)     // Catch:{ all -> 0x0135 }
            return r4
        L_0x0059:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0135 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleModel     // Catch:{ all -> 0x0135 }
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            io.hansel.core.base.utils.HSLInternalUtils.saveTgAuthEndPoint(r7, r8)     // Catch:{ all -> 0x0135 }
            return r4
        L_0x0063:
            io.hansel.core.json.CoreJSONObject r8 = (io.hansel.core.json.CoreJSONObject) r8     // Catch:{ all -> 0x0135 }
            r6.stabilityData = r8     // Catch:{ all -> 0x0135 }
            if (r8 == 0) goto L_0x0083
            java.lang.String r7 = "moduleName"
            java.lang.String r7 = r8.optString(r7)     // Catch:{ all -> 0x0135 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r8.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = "Pre SDK Init : HSLModule "
            r8.append(r1)     // Catch:{ all -> 0x0135 }
            r8.append(r7)     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0135 }
            io.hansel.core.logger.HSLLogger.i(r7)     // Catch:{ all -> 0x0135 }
        L_0x0083:
            return r4
        L_0x0084:
            io.hansel.core.lifecycle.a r7 = r6.lifecycleHandler     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x0093
            boolean r7 = r7.c()     // Catch:{ all -> 0x0135 }
            if (r7 != 0) goto L_0x0093
            io.hansel.core.lifecycle.a r7 = r6.lifecycleHandler     // Catch:{ all -> 0x0135 }
            r7.b()     // Catch:{ all -> 0x0135 }
        L_0x0093:
            return r4
        L_0x0094:
            boolean r7 = r8 instanceof java.util.Map     // Catch:{ all -> 0x0135 }
            java.lang.String r5 = "m_ty"
            if (r7 == 0) goto L_0x00a3
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ all -> 0x0135 }
            java.lang.Object r7 = r8.get(r5)     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0135 }
            goto L_0x00b0
        L_0x00a3:
            boolean r7 = r8 instanceof android.os.Bundle     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x00ae
            android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = r8.getString(r5)     // Catch:{ all -> 0x0135 }
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r7 = ""
        L_0x00b0:
            if (r7 == 0) goto L_0x00e5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r8.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r5 = "HSLBaseModule   msgType : "
            r8.append(r5)     // Catch:{ all -> 0x0135 }
            r8.append(r7)     // Catch:{ all -> 0x0135 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0135 }
            io.hansel.core.logger.HSLLogger.d(r8)     // Catch:{ all -> 0x0135 }
            java.lang.String r8 = "hansel_inv_ttl"
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x00e5
            java.lang.String r7 = "HSLBaseModule   hansel_inv_ttl"
            io.hansel.core.logger.HSLLogger.d(r7)     // Catch:{ all -> 0x0135 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleModel     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x00e5
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            io.hansel.core.base.utils.HSLInternalUtils.setLongInSharedPreferences(r7, r3, r1)     // Catch:{ all -> 0x0135 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleModel     // Catch:{ all -> 0x0135 }
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            java.lang.String r8 = "hansel_initsdk_is_push_initiated"
            io.hansel.core.base.utils.HSLInternalUtils.setBooleanInSharedPreferences(r7, r8, r4)     // Catch:{ all -> 0x0135 }
        L_0x00e5:
            return r4
        L_0x00e6:
            io.hansel.core.module.IMessageBroker r7 = r6.getLinkedMessageBroker()     // Catch:{ all -> 0x0135 }
            io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.PRE_INIT_SDK_API     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x0135 }
            r2 = 0
            r7.publishBlockingEvent(r1, r2)     // Catch:{ all -> 0x0135 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r7 = r6.moduleModel     // Catch:{ all -> 0x0135 }
            android.app.Application r7 = r7.app     // Catch:{ all -> 0x0135 }
            boolean r7 = io.hansel.core.base.utils.HSLInternalUtils.isTGStatusKnown(r7)     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x0101
            r6.scheduleInitialCalls(r0)     // Catch:{ all -> 0x0135 }
        L_0x0101:
            if (r8 == 0) goto L_0x0113
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x010f }
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ all -> 0x010f }
            if (r7 == 0) goto L_0x0113
            r7 = 1
            goto L_0x0114
        L_0x010f:
            r7 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r7)     // Catch:{ all -> 0x0135 }
        L_0x0113:
            r7 = 0
        L_0x0114:
            if (r7 != 0) goto L_0x0127
            android.os.Handler r7 = new android.os.Handler     // Catch:{ all -> 0x0135 }
            android.os.Looper r8 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0135 }
            r7.<init>(r8)     // Catch:{ all -> 0x0135 }
            io.hansel.core.base.HSLBaseModule$a r8 = new io.hansel.core.base.HSLBaseModule$a     // Catch:{ all -> 0x0135 }
            r8.<init>()     // Catch:{ all -> 0x0135 }
            r7.post(r8)     // Catch:{ all -> 0x0135 }
        L_0x0127:
            io.hansel.core.module.IMessageBroker r7 = r6.getLinkedMessageBroker()     // Catch:{ all -> 0x0135 }
            io.hansel.core.module.EventsConstants r8 = io.hansel.core.module.EventsConstants.FIRE_PENDING_NUDGE_EVENTS     // Catch:{ all -> 0x0135 }
            java.lang.String r8 = r8.name()     // Catch:{ all -> 0x0135 }
            r7.publishEvent(r8, r2)     // Catch:{ all -> 0x0135 }
            return r4
        L_0x0135:
            r7 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r7)
        L_0x0139:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.HSLBaseModule.handleEventData(java.lang.String, java.lang.Object):boolean");
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        initLifecycleHandler(hSLModuleInitializationData.app);
        this.moduleModel = hSLModuleInitializationData;
        Context applicationContext = hSLModuleInitializationData.app.getApplicationContext();
        if (hSLModuleInitializationData.hasAppVersionChanged) {
            HSLInternalUtils.setLongInSharedPreferences(hSLModuleInitializationData.app, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL, 0);
            HSLInternalUtils.setStringInSharedPreferences(applicationContext, HSLInternalUtils.KEY_PATCH_LIST_VERSION, null);
            HSLInternalUtils.setStringInSharedPreferences(applicationContext, HSLInternalUtils.KEY_STATIC_CRITERIA_VERSION, null);
        }
        HSLInternalUtils.clearKeys(applicationContext, new String[]{HSLInternalUtils.KEY_CRASH_DATA});
        a.a().b();
    }

    public Object returnEventData(String str, Object obj) {
        if (str == null) {
            return null;
        }
        try {
            if (c.f5093a[EventsConstants.valueOf(str).ordinal()] != 10) {
                return null;
            }
            return this.lifecycleHandler.e();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }
}
