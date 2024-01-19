package io.hansel.core;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.e.b.a.C0074a;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.logger.HSLLogLevel;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.core.utils.HSLUtils;
import io.hansel.hanselsdk.HanselActionListener;
import io.hansel.hanselsdk.HanselRequestType;
import io.hansel.hanselsdk.HanselSyncStateListener;
import io.hansel.hanselsdk.HanselSyncStateListenerInternal;
import io.hansel.hanselsdk.HanselUser;
import io.hansel.pebbletracesdk.EndGame;
import io.hansel.pebbletracesdk.HanselInitializationListener;
import io.hansel.pebbletracesdk.uimanager.ToastRunnable;
import io.hansel.pebbletracesdk.uimanager.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class b implements io.hansel.core.module.a, HanselSyncStateListenerInternal {
    public static b k = new b();
    public static boolean l = false;

    /* renamed from: a  reason: collision with root package name */
    public HanselInitializationListener f5081a = null;

    /* renamed from: b  reason: collision with root package name */
    public HSLSDKIdentifiers f5082b;

    /* renamed from: c  reason: collision with root package name */
    public io.hansel.core.e.a.a f5083c;

    /* renamed from: d  reason: collision with root package name */
    public Context f5084d;

    /* renamed from: e  reason: collision with root package name */
    public HSLModuleInitializationData f5085e;

    /* renamed from: f  reason: collision with root package name */
    public IMessageBroker f5086f;
    public boolean g = true;
    public HashMap<String, String> h = new HashMap<>();
    public HashMap<HanselRequestType, HanselSyncStateListener> i = new HashMap<>();
    public WeakHashMap<String, HanselActionListener> j = new WeakHashMap<>();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5087a;

        public a(String str) {
            this.f5087a = str;
        }

        public void run() {
            b.this.f5086f.publishBlockingEvent(EventsConstants.ON_SET_SCREEN.name(), this.f5087a);
        }
    }

    /* renamed from: io.hansel.core.b$b  reason: collision with other inner class name */
    public class C0070b implements Runnable {
        public C0070b() {
        }

        public void run() {
            b.this.f5086f.publishBlockingEvent(EventsConstants.ON_UNSET_SCREEN.name(), null);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5090a;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5090a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.SET_EXPERIENCE_LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 25
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.SET_REQUEST_EXTRAS_FOR_SERVER_SDK     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 27
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x0022 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.SET_JOURNEY_LIST     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 48
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FIRE_PROMPT_ACTION     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 33
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x0034 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.REGISTER_GET_DATA_STATUS_LISTENER     // Catch:{ NoSuchFieldError -> 0x0034 }
                r1 = 66
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x003d }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_DATA_EVAL_STARTED     // Catch:{ NoSuchFieldError -> 0x003d }
                r1 = 67
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f5090a     // Catch:{ NoSuchFieldError -> 0x0046 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_DATA_EVAL_FINISHED     // Catch:{ NoSuchFieldError -> 0x0046 }
                r1 = 68
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.b.c.<clinit>():void");
        }
    }

    private void a(Context context) {
        String stringFromSharedPreferences = HSLInternalUtils.getStringFromSharedPreferences(context, HSLInternalUtils.KEY_OLD_SDK_V);
        if (!HSLBuildConfig.SDK_VERSION.equals(stringFromSharedPreferences)) {
            HSLInternalUtils.setStringInSharedPreferences(context, HSLInternalUtils.KEY_OLD_SDK_V, HSLBuildConfig.SDK_VERSION);
            this.f5086f.publishEvent(EventsConstants.SDK_VERSION_UPDATED.name(), new String[]{stringFromSharedPreferences, HSLBuildConfig.SDK_VERSION});
        }
    }

    private boolean a(Context context, HSLVersion hSLVersion) {
        String str = hSLVersion.versionName;
        String stringFromSharedPreferences = HSLInternalUtils.getStringFromSharedPreferences(context, HSLInternalUtils.KEY_APPVERSION_OF_PATCHES);
        if (stringFromSharedPreferences == null || stringFromSharedPreferences.isEmpty()) {
            return false;
        }
        return !str.equals(stringFromSharedPreferences);
    }

    public static b e() {
        return k;
    }

    private ArrayList<String> g() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("io.hansel.core.base.HSLBaseModule");
        arrayList.add("io.hansel.stability.module.HSLCodeModule");
        arrayList.add("io.hansel.visualizer.HSLVisualizer");
        arrayList.add("io.hansel.actions.HSLConfigsModule");
        arrayList.add("io.hansel.segments.HSLSegmentModule");
        arrayList.add("io.hansel.ujmtracker.HSLTrackerModule");
        arrayList.add("io.hansel.userjourney.HSLJourneyModule");
        return arrayList;
    }

    private void k() {
        IMessageBroker iMessageBroker = this.f5086f;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(EventsConstants.INIT_LIBRARIES.name(), null);
        }
    }

    public void a() {
        try {
            String string = HSLFiltersInternal.getInstance().getString("#$user_id");
            HSLFiltersInternal.getInstance().clear();
            if (this.f5086f != null && HSLUtils.isSet(string)) {
                this.f5086f.publishBlockingEvent(EventsConstants.USER_ID_CHANGED.name(), null);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to clear the attributes.");
        }
    }

    public void a(Application application, String str, String str2) {
        a(application, str, str2, null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:45|44|46|47|68) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0172 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058 A[SYNTHETIC, Splitter:B:12:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Application r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            java.lang.String r0 = "Something went wrong. Hansel sdk not initialized properly"
            java.lang.String r1 = "Hansel SDK initialization start "
            io.hansel.core.logger.HSLLogger.i(r1)     // Catch:{ all -> 0x01c2 }
            android.content.pm.PackageManager r1 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r2 = r11.getPackageName()     // Catch:{ NameNotFoundException -> 0x01bb }
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x01bb }
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x01bb }
            if (r12 == 0) goto L_0x001f
            if (r13 != 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            r5 = r12
            r6 = r13
            goto L_0x004f
        L_0x001f:
            java.lang.String r12 = "HANSEL_APP_ID"
            java.lang.String r12 = r1.getString(r12)     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r13 = "HANSEL_APP_KEY"
            java.lang.String r13 = r1.getString(r13)     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x01bb }
            r2.<init>()     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r3 = "appId: '"
            r2.append(r3)     // Catch:{ NameNotFoundException -> 0x01bb }
            r2.append(r12)     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r3 = "', appKey:'"
            r2.append(r3)     // Catch:{ NameNotFoundException -> 0x01bb }
            r2.append(r13)     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch:{ NameNotFoundException -> 0x01bb }
            java.lang.String r2 = r2.toString()     // Catch:{ NameNotFoundException -> 0x01bb }
            io.hansel.core.logger.LogGroup r3 = io.hansel.core.logger.LogGroup.DV     // Catch:{ NameNotFoundException -> 0x01bb }
            io.hansel.core.logger.HSLLogger.d(r2, r3)     // Catch:{ NameNotFoundException -> 0x01bb }
            goto L_0x001c
        L_0x004f:
            java.lang.String r12 = "SMT_USE_ENCRYPTION"
            r13 = 0
            boolean r12 = r1.getBoolean(r12, r13)     // Catch:{ NameNotFoundException -> 0x01bb }
            if (r5 == 0) goto L_0x01b5
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x01c2 }
            if (r1 != 0) goto L_0x01b5
            if (r6 == 0) goto L_0x01b5
            boolean r1 = r6.isEmpty()     // Catch:{ all -> 0x01c2 }
            if (r1 != 0) goto L_0x01b5
            android.content.Context r1 = r11.getApplicationContext()     // Catch:{ all -> 0x01c2 }
            r10.f5084d = r1     // Catch:{ all -> 0x01c2 }
            boolean r1 = io.hansel.core.base.utils.HSLInternalUtils.doNotUseHansel(r1)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLInternalUtils.sHSLDoNotUseHansel = r1     // Catch:{ all -> 0x01c2 }
            if (r1 == 0) goto L_0x0075
            return
        L_0x0075:
            if (r12 == 0) goto L_0x0092
            r1 = 23
            boolean r1 = io.hansel.core.utils.HSLUtils.isAndroidOSLessThanVersion(r1)     // Catch:{ all -> 0x01c2 }
            if (r1 == 0) goto L_0x0085
            java.lang.String r11 = "Hansel SDK is not initialized. It does not support local encryption for android API < 23."
            io.hansel.core.logger.HSLLogger.wMin(r11)     // Catch:{ all -> 0x01c2 }
            return
        L_0x0085:
            java.lang.String r1 = "AES/GCM/NoPadding"
            io.hansel.core.security.b r1 = io.hansel.core.security.b.a(r1)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.security.c r1 = r1.a()     // Catch:{ all -> 0x01c2 }
            r1.a()     // Catch:{ all -> 0x01c2 }
        L_0x0092:
            android.content.Context r1 = r10.f5084d     // Catch:{ all -> 0x01c2 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x01c2 }
            java.lang.String r8 = io.hansel.core.base.utils.HSLInternalUtils.getDeviceId(r1)     // Catch:{ all -> 0x01c2 }
            boolean r1 = r10.g     // Catch:{ all -> 0x01c2 }
            if (r1 == 0) goto L_0x00b4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c2 }
            r1.<init>()     // Catch:{ all -> 0x01c2 }
            java.lang.String r2 = "Your device id : "
            r1.append(r2)     // Catch:{ all -> 0x01c2 }
            r1.append(r8)     // Catch:{ all -> 0x01c2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c2 }
            io.hansel.core.logger.HSLLogger.i(r1)     // Catch:{ all -> 0x01c2 }
        L_0x00b4:
            java.lang.String r1 = "Hansel SDK HSLVersion : 8.7.9"
            io.hansel.core.logger.HSLLogger.i(r1)     // Catch:{ all -> 0x01c2 }
            java.lang.String r1 = "Hansel JS HSLVersion : 1.1.1"
            io.hansel.core.logger.HSLLogger.i(r1)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLVersion r1 = new io.hansel.core.base.utils.HSLVersion     // Catch:{ all -> 0x01c2 }
            r1.<init>()     // Catch:{ all -> 0x01c2 }
            android.content.Context r2 = r10.f5084d     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLInternalUtils.populateAppVersion(r2, r1)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLSDKIdentifiers r2 = new io.hansel.core.sdkmodels.HSLSDKIdentifiers     // Catch:{ all -> 0x01c2 }
            r4 = r2
            r7 = r1
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x01c2 }
            r10.f5082b = r2     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r14 = new io.hansel.core.sdkmodels.HSLModuleInitializationData     // Catch:{ all -> 0x01c2 }
            r14.<init>()     // Catch:{ all -> 0x01c2 }
            r10.f5085e = r14     // Catch:{ all -> 0x01c2 }
            r14.app = r11     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLSDKIdentifiers r2 = r10.f5082b     // Catch:{ all -> 0x01c2 }
            r14.sdkIdentifiers = r2     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.task.HSLTaskHandler r2 = r10.h()     // Catch:{ all -> 0x01c2 }
            r14.networkTaskHandler = r2     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r14 = r10.f5085e     // Catch:{ all -> 0x01c2 }
            android.content.Context r2 = r10.f5084d     // Catch:{ all -> 0x01c2 }
            boolean r1 = r10.a(r2, r1)     // Catch:{ all -> 0x01c2 }
            r14.hasAppVersionChanged = r1     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r14 = r10.f5085e     // Catch:{ all -> 0x01c2 }
            boolean r1 = r10.g     // Catch:{ all -> 0x01c2 }
            r14.isDeviceIdLogEnabled = r1     // Catch:{ all -> 0x01c2 }
            r14.hanselSyncStateListenerInternal = r10     // Catch:{ all -> 0x01c2 }
            r14.shouldEnableEncryption = r12     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLSDKIdentifiers r12 = r10.f5082b     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLInternalUtils.setSDKIdentifiers(r12)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.d.a r12 = new io.hansel.core.d.a     // Catch:{ all -> 0x01c2 }
            r12.<init>()     // Catch:{ all -> 0x01c2 }
            r10.f5086f = r12     // Catch:{ all -> 0x01c2 }
            r10.a(r12)     // Catch:{ all -> 0x01c2 }
            io.hansel.core.filters.HSLFiltersInternal r14 = io.hansel.core.filters.HSLFiltersInternal.getInstance()     // Catch:{ all -> 0x01c2 }
            io.hansel.core.module.IMessageBroker r1 = r10.f5086f     // Catch:{ all -> 0x01c2 }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r2 = r10.f5085e     // Catch:{ all -> 0x01c2 }
            r14.init(r11, r1, r2)     // Catch:{ all -> 0x01c2 }
            boolean r11 = l     // Catch:{ all -> 0x01c2 }
            if (r11 != 0) goto L_0x01b1
            java.util.ArrayList r11 = r10.g()     // Catch:{ all -> 0x01c2 }
            int r14 = r11.size()     // Catch:{ all -> 0x01c2 }
            r1 = 0
            r2 = 0
        L_0x0121:
            r3 = 1
            if (r1 >= r14) goto L_0x0189
            java.lang.Object r4 = r11.get(r1)     // Catch:{ all -> 0x01c2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x01c2 }
            java.lang.Class r5 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0172 }
            java.lang.Class[] r6 = new java.lang.Class[r13]     // Catch:{ all -> 0x0172 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ all -> 0x0172 }
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ all -> 0x0172 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ all -> 0x0172 }
            io.hansel.core.module.HSLModule r5 = (io.hansel.core.module.HSLModule) r5     // Catch:{ Exception -> 0x015a }
            io.hansel.core.sdkmodels.HSLModuleInitializationData r6 = r10.f5085e     // Catch:{ Exception -> 0x015a }
            r5.init(r6, r12, r12)     // Catch:{ Exception -> 0x015a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r6.<init>()     // Catch:{ Exception -> 0x015a }
            java.lang.String r5 = r5.getCode()     // Catch:{ Exception -> 0x015a }
            r6.append(r5)     // Catch:{ Exception -> 0x015a }
            java.lang.String r5 = " initialised"
            r6.append(r5)     // Catch:{ Exception -> 0x015a }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x015a }
            io.hansel.core.logger.HSLLogger.i(r5)     // Catch:{ Exception -> 0x015a }
            goto L_0x0186
        L_0x015a:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
            r5.<init>()     // Catch:{ all -> 0x0171 }
            java.lang.String r6 = "Something went wrong while initializing module: "
            r5.append(r6)     // Catch:{ all -> 0x0171 }
            r5.append(r4)     // Catch:{ all -> 0x0171 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0171 }
            io.hansel.core.logger.HSLLogger.printStackTraceMin(r2, r5)     // Catch:{ all -> 0x0171 }
            r2 = 1
            goto L_0x0186
        L_0x0171:
            r2 = 1
        L_0x0172:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c2 }
            r3.<init>()     // Catch:{ all -> 0x01c2 }
            java.lang.String r5 = "Exception : SDK not included - "
            r3.append(r5)     // Catch:{ all -> 0x01c2 }
            r3.append(r4)     // Catch:{ all -> 0x01c2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01c2 }
            io.hansel.core.logger.HSLLogger.d(r3)     // Catch:{ all -> 0x01c2 }
        L_0x0186:
            int r1 = r1 + 1
            goto L_0x0121
        L_0x0189:
            if (r2 == 0) goto L_0x018f
            io.hansel.core.logger.HSLLogger.wMin(r0)     // Catch:{ all -> 0x01c2 }
            goto L_0x01b1
        L_0x018f:
            l = r3     // Catch:{ all -> 0x01c2 }
            io.hansel.pebbletracesdk.HanselInitializationListener r11 = r10.f5081a     // Catch:{ all -> 0x01c2 }
            if (r11 == 0) goto L_0x0198
            r11.hanselInitialized()     // Catch:{ all -> 0x01c2 }
        L_0x0198:
            android.content.Context r11 = r10.f5084d     // Catch:{ all -> 0x01c2 }
            r10.a(r11)     // Catch:{ all -> 0x01c2 }
            android.content.Context r11 = r10.f5084d     // Catch:{ all -> 0x01c2 }
            java.lang.String r12 = "hansel_appversion_of_patchlist"
            io.hansel.core.sdkmodels.HSLSDKIdentifiers r13 = r10.f5082b     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLVersion r13 = r13.getAppVersion()     // Catch:{ all -> 0x01c2 }
            java.lang.String r13 = r13.versionName     // Catch:{ all -> 0x01c2 }
            io.hansel.core.base.utils.HSLInternalUtils.setStringInSharedPreferences(r11, r12, r13)     // Catch:{ all -> 0x01c2 }
            java.lang.String r11 = "Hansel SDK initialization complete"
            io.hansel.core.logger.HSLLogger.i(r11)     // Catch:{ all -> 0x01c2 }
        L_0x01b1:
            r10.k()     // Catch:{ all -> 0x01c2 }
            goto L_0x01c6
        L_0x01b5:
            java.lang.String r11 = "Hansel sdk not initialized properly"
            io.hansel.core.logger.HSLLogger.wMin(r11)     // Catch:{ all -> 0x01c2 }
            return
        L_0x01bb:
            r11 = move-exception
            java.lang.String r12 = "Hansel sdk not configured properly. Please read the integration document."
            io.hansel.core.logger.HSLLogger.printStackTraceMin(r11, r12)     // Catch:{ all -> 0x01c2 }
            return
        L_0x01c2:
            r11 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTraceMin(r11, r0)
        L_0x01c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.b.a(android.app.Application, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void a(Context context, String str) {
        try {
            io.hansel.core.base.push.b.a(context, this.f5082b, h(), str);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while setting new token.");
        }
    }

    public void a(IMessageBroker iMessageBroker) {
        if (iMessageBroker != null) {
            for (String subscriber : i()) {
                iMessageBroker.setSubscriber(subscriber, this);
            }
        }
    }

    public void a(HanselRequestType hanselRequestType, HanselSyncStateListener hanselSyncStateListener) {
        try {
            this.i.put(hanselRequestType, hanselSyncStateListener);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while registering Hansel Sync State Listener.");
        }
    }

    public void a(EndGame endGame) {
        try {
            c.a(endGame);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while end.");
        }
    }

    public void a(HanselInitializationListener hanselInitializationListener) {
        try {
            this.f5081a = hanselInitializationListener;
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to set the initialization listener.");
        }
    }

    public void a(Object obj) {
        IMessageBroker iMessageBroker = this.f5086f;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(EventsConstants.HANSEL_PUSH_DATA.name(), obj);
            this.f5086f.publishEvent(EventsConstants.HANDLE_PUSH_DATA.name(), obj);
        }
    }

    public void a(String str) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(this.f5084d.getMainLooper()).post(new a(str));
            } else {
                this.f5086f.publishBlockingEvent(EventsConstants.ON_SET_SCREEN.name(), str);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while set screen.");
        }
    }

    public void a(String str, HanselActionListener hanselActionListener) {
        try {
            this.j.put(str, hanselActionListener);
            io.hansel.core.filters.a.a(this.f5084d, str);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while registering Hansel Action Listener.");
        }
    }

    public void a(String str, boolean z) {
        try {
            new UIHandler().post(new ToastRunnable(this.f5084d, str, z));
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while showing toast.");
        }
    }

    public boolean a(Context context, Bundle bundle) {
        try {
            return io.hansel.core.base.push.b.a(context, bundle);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while handle Push Payload.");
            return false;
        }
    }

    public boolean a(Context context, Map<String, String> map) {
        try {
            return io.hansel.core.base.push.b.a(context, map);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while handle Push Payload.");
            return false;
        }
    }

    public boolean a(Bundle bundle) {
        try {
            return io.hansel.core.base.push.b.a(bundle);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while getting hansel push.");
            return false;
        }
    }

    public boolean a(Map<String, String> map) {
        try {
            return io.hansel.core.base.push.b.a(map);
        } catch (Exception e2) {
            HSLLogger.printStackTraceMin(e2, "Something went wrong while getting hansel push.");
            return false;
        }
    }

    public void b() {
        try {
            this.g = false;
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while disabling device log.");
        }
    }

    public void b(String str) {
        try {
            HSLInternalUtils.setStringInSharedPreferences(this.f5084d, "app_def_font", str);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while setting app font.");
        }
    }

    public void c() {
        try {
            HSLLogLevel.mid.setEnabled(true);
            LogGroup.TG.setEnabled(true);
            LogGroup.DV.setEnabled(true);
            LogGroup.PT.setEnabled(true);
            LogGroup.GT.setEnabled(true);
            LogGroup.CS.setEnabled(true);
            LogGroup.CJ.setEnabled(true);
            LogGroup.WS.setEnabled(true);
            LogGroup.HC.setEnabled(true);
            LogGroup.AI.setEnabled(true);
            LogGroup.RC.setEnabled(true);
            LogGroup.OT.setEnabled(true);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while enabling debug logs.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (r1 != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "#$user_id"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r1.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "hsl-userId-"
            r1.append(r2)     // Catch:{ all -> 0x004c }
            r1.append(r6)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004c }
            io.hansel.core.logger.HSLLogger.i(r1)     // Catch:{ all -> 0x004c }
            boolean r1 = io.hansel.core.utils.HSLUtils.isSet(r6)     // Catch:{ all -> 0x004c }
            io.hansel.core.filters.HSLFiltersInternal r2 = io.hansel.core.filters.HSLFiltersInternal.getInstance()     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r2.getUserId()     // Catch:{ all -> 0x004c }
            r3 = 0
            boolean r4 = io.hansel.core.utils.HSLUtils.isSet(r2)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x0032
            if (r1 == 0) goto L_0x0034
            boolean r1 = r6.equals(r2)     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0035
            goto L_0x0034
        L_0x0032:
            if (r1 == 0) goto L_0x0035
        L_0x0034:
            r3 = 1
        L_0x0035:
            io.hansel.core.filters.HSLFiltersInternal r1 = io.hansel.core.filters.HSLFiltersInternal.getInstance()     // Catch:{ all -> 0x004c }
            r1.put(r0, r6)     // Catch:{ all -> 0x004c }
            io.hansel.core.module.IMessageBroker r6 = r5.f5086f     // Catch:{ all -> 0x004c }
            if (r6 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x0052
            io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.USER_ID_CHANGED     // Catch:{ all -> 0x004c }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x004c }
            r6.publishBlockingEvent(r1, r0)     // Catch:{ all -> 0x004c }
            goto L_0x0052
        L_0x004c:
            r6 = move-exception
            java.lang.String r0 = "Something went wrong. Hansel sdk is not able to set the userId."
            io.hansel.core.logger.HSLLogger.printStackTraceMin(r6, r0)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.b.c(java.lang.String):void");
    }

    public Context d() {
        return this.f5084d;
    }

    public HashMap<String, String> f() {
        try {
            IMessageBroker iMessageBroker = this.f5086f;
            if (iMessageBroker != null) {
                iMessageBroker.publishBlockingEvent(EventsConstants.GET_JOURNEY_LIST.name(), null);
                return this.h;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to get the list of interaction maps.");
        }
        return new HashMap<>();
    }

    public HSLTaskHandler h() {
        if (this.f5083c == null) {
            io.hansel.core.e.a.a aVar = new io.hansel.core.e.a.a(this.f5084d);
            this.f5083c = aVar;
            io.hansel.core.e.b.a.a((C0074a) aVar);
        }
        return this.f5083c;
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            switch (c.f5090a[EventsConstants.valueOf(str).ordinal()]) {
                case 1:
                    HashMap hashMap = (HashMap) obj;
                    return true;
                case 2:
                    String str2 = (String) obj;
                    return true;
                case 3:
                    this.h = (HashMap) obj;
                    return true;
                case 4:
                    String str3 = (String) obj;
                    HanselActionListener hanselActionListener = this.j.get(str3);
                    if (hanselActionListener != null) {
                        hanselActionListener.onActionPerformed(str3);
                    }
                    return true;
                case 5:
                    GetDataStatusListener getDataStatusListener = (GetDataStatusListener) obj;
                    if (getDataStatusListener != null) {
                        a.a().a(getDataStatusListener);
                    }
                    return true;
                case 6:
                    a.a().c();
                    break;
                case 7:
                    break;
            }
            a.a().b();
        } catch (Throwable th) {
            HSLLogger.d(th.getMessage());
        }
        return false;
    }

    public String[] i() {
        return new String[]{EventsConstants.SET_EXPERIENCE_LIST.name(), EventsConstants.SET_REQUEST_EXTRAS_FOR_SERVER_SDK.name(), EventsConstants.SET_JOURNEY_LIST.name(), EventsConstants.FIRE_PROMPT_ACTION.name(), EventsConstants.REGISTER_GET_DATA_STATUS_LISTENER.name()};
    }

    public HanselUser j() {
        return io.hansel.hanselsdk.b.a();
    }

    public boolean l() {
        try {
            Object returnEventData = this.f5086f.returnEventData(EventsConstants.HANDLE_ON_BACK_PRESSED.name(), null);
            if (returnEventData instanceof Boolean) {
                return Boolean.parseBoolean(returnEventData.toString());
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while back press.");
        }
        return true;
    }

    public void m() {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(this.f5084d.getMainLooper()).post(new C0070b());
            } else {
                this.f5086f.publishBlockingEvent(EventsConstants.ON_UNSET_SCREEN.name(), null);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while unset screen.");
        }
    }

    public void onHanselSynced(HanselRequestType hanselRequestType, boolean z) {
        HanselSyncStateListener hanselSyncStateListener = this.i.get(hanselRequestType);
        if (hanselSyncStateListener != null) {
            try {
                new UIHandler().post(new io.hansel.hanselsdk.a(hanselSyncStateListener, z));
            } catch (Throwable th) {
                HSLLogger.printStackTraceMin(th, "Something went wrong while Hansel Sync.");
            }
        }
    }

    public Object returnEventData(String str, Object obj) {
        return null;
    }
}
