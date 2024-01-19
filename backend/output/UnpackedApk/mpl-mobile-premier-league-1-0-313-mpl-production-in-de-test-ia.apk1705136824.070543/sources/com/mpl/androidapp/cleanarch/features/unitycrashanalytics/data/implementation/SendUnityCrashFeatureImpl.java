package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation;

import com.mpl.androidapp.cleanarch.core.analytics.domain.AnalyticsFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import com.mpl.androidapp.cleverTap.MplCtEventInitiate.CtEventConstants;
import com.mpl.androidapp.utils.GameConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ,\u0010\u001d\u001a\u00020\u00142\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 `!H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/SendUnityCrashFeatureImpl;", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "unityCrashDbServiceImpl", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "unityCrashModule", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;", "logger", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "analytics", "Lcom/mpl/androidapp/cleanarch/core/analytics/domain/AnalyticsFeature;", "(Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;Lcom/mpl/androidapp/cleanarch/core/analytics/domain/AnalyticsFeature;)V", "getAnalytics", "()Lcom/mpl/androidapp/cleanarch/core/analytics/domain/AnalyticsFeature;", "getLogger", "()Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "getUnityCrashDbServiceImpl", "()Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "getUnityCrashModule", "()Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;", "sendCrash", "", "gameConfigInput", "", "message", "battleId", "sendCrashEventToKafka", "Lcom/mpl/androidapp/cleanarch/core/utils/Resource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEventToDestination", "eventProp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendUnityCrashFeatureImpl.kt */
public final class SendUnityCrashFeatureImpl implements SendUnityCrashFeature {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_NAME = "Unity Crash Logged";
    public static final String PROPERTY_BATTLE_ID = "Battle Id";
    public static final String PROPERTY_COUNTRY_CODE = "Country Code";
    public static final String PROPERTY_CRASH_DETAILS = "Crash Details";
    public static final String PROPERTY_ENTRY_FREE = "Entry Free";
    public static final String PROPERTY_GAME_ID = "Game ID";
    public static final String PROPERTY_GAME_NAME = "Game Name";
    public static final String PROPERTY_TOURNAMENT_ID = "Tournament ID";
    public static final String PROPERTY_TOURNAMENT_NAME = "Tournament Name";
    public static final String PROPERTY_USER_ID = "User ID";
    public static final String TAG = "MplReactContainerFeatureImpl";
    public final AnalyticsFeature analytics;
    public final LoggerFeature logger;
    public final UnityCrashDbServiceImpl unityCrashDbServiceImpl;
    public final UnityCrashModule unityCrashModule;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/SendUnityCrashFeatureImpl$Companion;", "", "()V", "EVENT_NAME", "", "PROPERTY_BATTLE_ID", "PROPERTY_COUNTRY_CODE", "PROPERTY_CRASH_DETAILS", "PROPERTY_ENTRY_FREE", "PROPERTY_GAME_ID", "PROPERTY_GAME_NAME", "PROPERTY_TOURNAMENT_ID", "PROPERTY_TOURNAMENT_NAME", "PROPERTY_USER_ID", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendUnityCrashFeatureImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SendUnityCrashFeatureImpl(UnityCrashDbServiceImpl unityCrashDbServiceImpl2, UnityCrashModule unityCrashModule2, LoggerFeature loggerFeature, AnalyticsFeature analyticsFeature) {
        Intrinsics.checkNotNullParameter(unityCrashDbServiceImpl2, "unityCrashDbServiceImpl");
        Intrinsics.checkNotNullParameter(unityCrashModule2, "unityCrashModule");
        Intrinsics.checkNotNullParameter(loggerFeature, "logger");
        Intrinsics.checkNotNullParameter(analyticsFeature, "analytics");
        this.unityCrashDbServiceImpl = unityCrashDbServiceImpl2;
        this.unityCrashModule = unityCrashModule2;
        this.logger = loggerFeature;
        this.analytics = analyticsFeature;
    }

    private final void sendCrash(String str, String str2, String str3) {
        try {
            this.logger.d(TAG, str2);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("GameId");
            String string = jSONObject.getString("GameName");
            String str4 = "";
            if (string == null) {
                string = str4;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("Profile");
            int i2 = jSONObject2 == null ? 0 : jSONObject2.getInt("id");
            String string2 = jSONObject.getString(GameConstant.GAME_COUNTRY_CODE);
            if (string2 != null) {
                str4 = string2;
            }
            int i3 = jSONObject.getInt(CtEventConstants.ENTRY_FEE);
            HashMap hashMap = new HashMap();
            hashMap.put("Game Name", string);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("User ID", Integer.valueOf(i2));
            hashMap.put("Entry Free", Integer.valueOf(i3));
            hashMap.put("Country Code", str4);
            hashMap.put(PROPERTY_BATTLE_ID, str3);
            hashMap.put("Crash Details", str2);
            sendEventToDestination(hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (str2.length() > 0) {
                this.logger.d(TAG, str2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Crash Details", str2);
                sendEventToDestination(hashMap2);
            }
        }
    }

    private final void sendEventToDestination(HashMap<String, Object> hashMap) {
        if (this.unityCrashModule.isEnabledInCt()) {
            this.logger.d(TAG, "Send only to CT - if its enabled");
            this.analytics.send(EVENT_NAME, hashMap);
        } else if (this.unityCrashModule.isEnabledInKafka()) {
            this.logger.d(TAG, "Send only to KAFKA - if its enabled");
            this.analytics.sendOnlyToKafka(EVENT_NAME, hashMap);
        } else {
            this.logger.d(TAG, "Not sent to either CT or KAFKA");
        }
    }

    public final AnalyticsFeature getAnalytics() {
        return this.analytics;
    }

    public final LoggerFeature getLogger() {
        return this.logger;
    }

    public final UnityCrashDbServiceImpl getUnityCrashDbServiceImpl() {
        return this.unityCrashDbServiceImpl;
    }

    public final UnityCrashModule getUnityCrashModule() {
        return this.unityCrashModule;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a A[SYNTHETIC, Splitter:B:33:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079 A[Catch:{ Exception -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendCrashEventToKafka(kotlin.coroutines.Continuation<? super com.mpl.androidapp.cleanarch.core.utils.Resource<java.lang.Boolean>> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "data"
            boolean r1 = r14 instanceof com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl$sendCrashEventToKafka$1
            if (r1 == 0) goto L_0x0015
            r1 = r14
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl$sendCrashEventToKafka$1 r1 = (com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl$sendCrashEventToKafka$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl$sendCrashEventToKafka$1 r1 = new com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl$sendCrashEventToKafka$1
            r1.<init>(r13, r14)
        L_0x001a:
            java.lang.Object r14 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 3
            r5 = 0
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0050
            if (r3 == r7) goto L_0x0045
            if (r3 == r6) goto L_0x0039
            if (r3 != r4) goto L_0x0031
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x00dd
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0039:
            java.lang.Object r0 = r1.L$0
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl r0 = (com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)     // Catch:{ Exception -> 0x0042 }
            goto L_0x00c5
        L_0x0042:
            goto L_0x00ce
        L_0x0045:
            java.lang.Object r3 = r1.L$0
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl r3 = (com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl) r3
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)     // Catch:{ Exception -> 0x004d }
            goto L_0x0063
        L_0x004d:
            r0 = r3
            goto L_0x00ce
        L_0x0050:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl r14 = r13.getUnityCrashDbServiceImpl()     // Catch:{ Exception -> 0x00cd }
            r1.L$0 = r13     // Catch:{ Exception -> 0x00cd }
            r1.label = r7     // Catch:{ Exception -> 0x00cd }
            java.lang.Object r14 = r14.getUnityCrashData(r7, r1)     // Catch:{ Exception -> 0x00cd }
            if (r14 != r2) goto L_0x0062
            return r2
        L_0x0062:
            r3 = r13
        L_0x0063:
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData r14 = (com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity.UnityCrashData) r14     // Catch:{ Exception -> 0x004d }
            r8 = 0
            java.lang.String r9 = "MplReactContainerFeatureImpl"
            if (r14 != 0) goto L_0x0079
            com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature r14 = r3.getLogger()     // Catch:{ Exception -> 0x004d }
            java.lang.Object[] r0 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x004d }
            java.lang.String r7 = "No crash log to send"
            r0[r8] = r7     // Catch:{ Exception -> 0x004d }
            r14.d(r9, r0)     // Catch:{ Exception -> 0x004d }
        L_0x0077:
            r0 = r3
            goto L_0x00c5
        L_0x0079:
            com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature r10 = r3.getLogger()     // Catch:{ Exception -> 0x004d }
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x004d }
            java.lang.String r12 = "Crash log is present to send"
            r11[r8] = r12     // Catch:{ Exception -> 0x004d }
            r10.d(r9, r11)     // Catch:{ Exception -> 0x004d }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x004d }
            java.lang.String r11 = r14.getData()     // Catch:{ Exception -> 0x004d }
            r10.<init>(r11)     // Catch:{ Exception -> 0x004d }
            java.lang.String r11 = "IsCrashTriggered"
            boolean r11 = r10.getBoolean(r11)     // Catch:{ Exception -> 0x004d }
            java.lang.String r10 = r10.getString(r0)     // Catch:{ Exception -> 0x004d }
            if (r11 == 0) goto L_0x00b6
            com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature r11 = r3.getLogger()     // Catch:{ Exception -> 0x004d }
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x004d }
            java.lang.String r12 = "Trigger Crash"
            r7[r8] = r12     // Catch:{ Exception -> 0x004d }
            r11.d(r9, r7)     // Catch:{ Exception -> 0x004d }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ Exception -> 0x004d }
            java.lang.String r0 = r14.getMessage()     // Catch:{ Exception -> 0x004d }
            java.lang.String r14 = r14.getBattleId()     // Catch:{ Exception -> 0x004d }
            r3.sendCrash(r10, r0, r14)     // Catch:{ Exception -> 0x004d }
        L_0x00b6:
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl r14 = r3.getUnityCrashDbServiceImpl()     // Catch:{ Exception -> 0x004d }
            r1.L$0 = r3     // Catch:{ Exception -> 0x004d }
            r1.label = r6     // Catch:{ Exception -> 0x004d }
            java.lang.Object r14 = r14.deleteTableEntries(r1)     // Catch:{ Exception -> 0x004d }
            if (r14 != r2) goto L_0x0077
            return r2
        L_0x00c5:
            com.mpl.androidapp.cleanarch.core.utils.Resource$Success r14 = new com.mpl.androidapp.cleanarch.core.utils.Resource$Success     // Catch:{ Exception -> 0x0042 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0042 }
            r14.<init>(r3)     // Catch:{ Exception -> 0x0042 }
            return r14
        L_0x00cd:
            r0 = r13
        L_0x00ce:
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl r14 = r0.getUnityCrashDbServiceImpl()
            r1.L$0 = r5
            r1.label = r4
            java.lang.Object r14 = r14.deleteTableEntries(r1)
            if (r14 != r2) goto L_0x00dd
            return r2
        L_0x00dd:
            com.mpl.androidapp.cleanarch.core.utils.Resource$Error r14 = new com.mpl.androidapp.cleanarch.core.utils.Resource$Error
            java.lang.String r0 = "An unknown error occured."
            r14.<init>(r0, r5, r6, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl.sendCrashEventToKafka(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
