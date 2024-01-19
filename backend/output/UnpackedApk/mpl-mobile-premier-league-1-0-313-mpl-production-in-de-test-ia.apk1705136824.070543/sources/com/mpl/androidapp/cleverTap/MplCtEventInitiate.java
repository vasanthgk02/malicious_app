package com.mpl.androidapp.cleverTap;

import com.mpl.androidapp.cleverTap.MplCtEventConstants.DownloadManagerTimeLog;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fJ&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/cleverTap/MplCtEventInitiate;", "", "()V", "CT_EVENT_TAG", "", "sendEventDownloadServiceTimeLog", "", "gameId", "", "time", "", "propertyTimeOne", "", "propertyTimeTwo", "propertyTimeThree", "propertyTimeFour", "sendEventNativeLaunchStatus", "eventName", "gameConfigJson", "isSuccess", "failureReason", "CtEventConstants", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplCtEventInitiate.kt */
public final class MplCtEventInitiate {
    public static final String CT_EVENT_TAG = "mpl_ct_event";
    public static final MplCtEventInitiate INSTANCE = new MplCtEventInitiate();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/cleverTap/MplCtEventInitiate$CtEventConstants;", "", "()V", "CURRENCY_FACTOR", "", "ENTRY_CURRENCY", "ENTRY_FEE", "GAME_ID", "GAME_NAME", "LOBBY_ID", "MANUAL_SPLIT", "MAX_PLAYERS", "TOTAL_PLAYERS", "TOURNAMENT_DESCRIPTION", "TOURNAMENT_NAME", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MplCtEventInitiate.kt */
    public static final class CtEventConstants {
        public static final String CURRENCY_FACTOR = "CurrencyFactor";
        public static final String ENTRY_CURRENCY = "EntryCurrency";
        public static final String ENTRY_FEE = "EntryFee";
        public static final String GAME_ID = "GameId";
        public static final String GAME_NAME = "GameName";
        public static final CtEventConstants INSTANCE = new CtEventConstants();
        public static final String LOBBY_ID = "LobbyId";
        public static final String MANUAL_SPLIT = "ManualSplit";
        public static final String MAX_PLAYERS = "MaxPlayers";
        public static final String TOTAL_PLAYERS = "TotalPlayers";
        public static final String TOURNAMENT_DESCRIPTION = "TournamentDescription";
        public static final String TOURNAMENT_NAME = "TournamentName";
    }

    public static /* synthetic */ void sendEventDownloadServiceTimeLog$default(MplCtEventInitiate mplCtEventInitiate, int i, long j, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        mplCtEventInitiate.sendEventDownloadServiceTimeLog(i, j, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4);
    }

    public final void sendEventDownloadServiceTimeLog(int i, long j, boolean z, boolean z2, boolean z3, boolean z4) {
        HashMap hashMap = new HashMap();
        hashMap.put("Game ID", Integer.valueOf(i));
        hashMap.put("time", Long.valueOf(j));
        hashMap.put(DownloadManagerTimeLog.PROPERTY_TIME_ONE, Boolean.valueOf(z));
        hashMap.put(DownloadManagerTimeLog.PROPERTY_TIME_TWO, Boolean.valueOf(z2));
        hashMap.put(DownloadManagerTimeLog.PROPERTY_TIME_THREE, Boolean.valueOf(z3));
        hashMap.put(DownloadManagerTimeLog.PROPERTY_TIME_FOUR, Boolean.valueOf(z4));
        CleverTapAnalyticsUtils.sendEvent((String) DownloadManagerTimeLog.EVENT_NAME, hashMap);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v6
      assigns: []
      uses: []
      mth insns count: 135
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendEventNativeLaunchStatus(java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22) {
        /*
            r18 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            java.lang.String r3 = "ManualSplit"
            java.lang.String r4 = "CurrencyFactor"
            java.lang.String r5 = "LobbyId"
            java.lang.String r6 = "TotalPlayers"
            java.lang.String r7 = "TournamentName"
            java.lang.String r8 = "EntryCurrency"
            java.lang.String r9 = "GameId"
            java.lang.String r10 = "Failure Reason"
            java.lang.String r11 = "EntryFee"
            java.lang.String r12 = "is Success"
            java.lang.String r13 = "TournamentDescription"
            java.lang.String r14 = "GameName"
            java.lang.String r15 = "eventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r15)
            java.lang.String r15 = "gameConfigJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            java.lang.String r15 = "failureReason"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r15)
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x017a }
            r1.<init>(r0)     // Catch:{ Exception -> 0x017a }
            boolean r0 = r1.has(r14)     // Catch:{ Exception -> 0x017a }
            java.lang.String r2 = "gameName"
            r16 = r10
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = r1.optString(r14, r10)     // Catch:{ Exception -> 0x0052 }
            r17 = r12
            java.lang.String r12 = "Game Name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0174 }
            r15.put(r12, r0)     // Catch:{ Exception -> 0x0174 }
            goto L_0x005a
        L_0x0052:
            r0 = move-exception
            r1 = r12
        L_0x0054:
            r2 = r16
            goto L_0x017d
        L_0x0058:
            r17 = r12
        L_0x005a:
            boolean r0 = r1.has(r14)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r1.optString(r14, r10)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r12 = "Game Format"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0174 }
            r15.put(r12, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x006c:
            boolean r0 = r1.has(r9)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x0080
            r2 = 0
            int r0 = r1.optInt(r9, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Game ID"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x0080:
            boolean r0 = r1.has(r8)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = r1.optString(r8, r10)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Entry Currency"
            java.lang.String r8 = "entryCurrency"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x0094:
            boolean r0 = r1.has(r11)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x00a8
            r2 = 0
            int r0 = r1.optInt(r11, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Cash Entry Fee"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x00a8:
            java.lang.String r0 = "MaxPlayers"
            boolean r0 = r1.has(r0)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x00be
            java.lang.String r0 = r1.optString(r11, r10)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Max Players"
            java.lang.String r8 = "maxPlayers"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x00be:
            boolean r0 = r1.has(r7)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x00d2
            java.lang.String r0 = r1.optString(r7, r10)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Tournament Name"
            java.lang.String r7 = "tournamentName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x00d2:
            boolean r0 = r1.has(r13)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "tournamentDesc"
            java.lang.String r7 = "Tournament Description"
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = r1.optString(r13, r10)     // Catch:{ Exception -> 0x0174 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0174 }
            r15.put(r7, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x00e6:
            boolean r0 = r1.has(r13)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x00f6
            java.lang.String r0 = r1.optString(r13, r10)     // Catch:{ Exception -> 0x0174 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0174 }
            r15.put(r7, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x00f6:
            boolean r0 = r1.has(r6)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x010a
            r2 = 0
            int r0 = r1.optInt(r6, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Total Players"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x010a:
            boolean r0 = r1.has(r5)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x011e
            r2 = 0
            int r0 = r1.optInt(r5, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "Tournament ID"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0174 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x011e:
            boolean r0 = r1.has(r4)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x0133
            r5 = 0
            double r4 = r1.optDouble(r4, r5)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r0 = "Point Value"
            java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r15.put(r0, r2)     // Catch:{ Exception -> 0x0174 }
        L_0x0133:
            boolean r0 = r1.has(r3)     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x014d
            r2 = 0
            boolean r0 = r1.optBoolean(r3, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r1 = "Variant"
            if (r0 == 0) goto L_0x0148
            java.lang.String r0 = "Manual"
            r15.put(r1, r0)     // Catch:{ Exception -> 0x0174 }
            goto L_0x014d
        L_0x0148:
            java.lang.String r0 = "No Split"
            r15.put(r1, r0)     // Catch:{ Exception -> 0x0174 }
        L_0x014d:
            if (r21 == 0) goto L_0x015e
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r21)     // Catch:{ Exception -> 0x0159 }
            r1 = r17
            r15.put(r1, r0)     // Catch:{ Exception -> 0x0171 }
            goto L_0x019a
        L_0x0159:
            r0 = move-exception
            r1 = r17
            goto L_0x0054
        L_0x015e:
            r1 = r17
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r21)     // Catch:{ Exception -> 0x0171 }
            r15.put(r1, r0)     // Catch:{ Exception -> 0x0171 }
            r0 = r22
            r2 = r16
            r15.put(r2, r0)     // Catch:{ Exception -> 0x016f }
            goto L_0x019a
        L_0x016f:
            r0 = move-exception
            goto L_0x017d
        L_0x0171:
            r0 = move-exception
            goto L_0x0054
        L_0x0174:
            r0 = move-exception
            r2 = r16
            r1 = r17
            goto L_0x017d
        L_0x017a:
            r0 = move-exception
            r2 = r10
            r1 = r12
        L_0x017d:
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.printStackTrace()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "mpl_ct_event"
            com.mpl.androidapp.utils.MLogger.e(r4, r3)
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r15.put(r1, r3)
            r0.printStackTrace()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r15.put(r2, r0)
        L_0x019a:
            r1 = r19
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent(r1, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.cleverTap.MplCtEventInitiate.sendEventNativeLaunchStatus(java.lang.String, java.lang.String, boolean, java.lang.String):void");
    }
}
