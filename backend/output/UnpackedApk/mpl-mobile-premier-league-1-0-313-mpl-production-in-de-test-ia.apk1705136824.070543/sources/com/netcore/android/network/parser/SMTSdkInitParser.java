package com.netcore.android.network.parser;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/network/parser/SMTSdkInitParser;", "", "Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "networkResponse", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse;", "parse$smartech_release", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTSdkInitializeResponse;", "parse", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTSdkInitParser.kt */
public final class SMTSdkInitParser {
    public final String TAG = SMTSdkInitParser.class.getSimpleName();

    /* JADX WARNING: Removed duplicated region for block: B:306:0x0556 A[Catch:{ Exception -> 0x058a }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0572 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.netcore.android.network.models.SMTSdkInitializeResponse parse$smartech_release(com.netcore.android.network.SMTHttpRequestClient.NetworkResponse r12) {
        /*
            r11 = this;
            java.lang.String r0 = "TAG"
            java.lang.String r1 = "networkResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            com.netcore.android.network.models.SMTSdkInitializeResponse r1 = new com.netcore.android.network.models.SMTSdkInitializeResponse
            r1.<init>()
            com.netcore.android.network.models.SMTRequest$SMTApiTypeID r2 = r12.getApiID()
            r1.setSmtApiTypeID(r2)
            java.lang.String r2 = r12.getResponse()     // Catch:{ Exception -> 0x059e }
            if (r2 != 0) goto L_0x0023
            com.netcore.android.logger.SMTLogger r12 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x059e }
            java.lang.String r2 = "SMTSdkInitParser"
            java.lang.String r3 = " Init api response is null."
            r12.w(r2, r3)     // Catch:{ Exception -> 0x059e }
            return r1
        L_0x0023:
            java.lang.String r2 = r12.getResponse()     // Catch:{ Exception -> 0x059e }
            if (r2 == 0) goto L_0x0033
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x059e }
            java.lang.String r12 = r12.getResponse()     // Catch:{ Exception -> 0x059e }
            r2.<init>(r12)     // Catch:{ Exception -> 0x059e }
            goto L_0x0038
        L_0x0033:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x059e }
            r2.<init>()     // Catch:{ Exception -> 0x059e }
        L_0x0038:
            r12 = 0
            r3 = 1
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r4 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings     // Catch:{ Exception -> 0x0501 }
            r4.<init>()     // Catch:{ Exception -> 0x0501 }
            r1.setSmartechSettings(r4)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r4 = "smartechSettings"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = "batchInterval"
            int r5 = r4.optInt(r5)     // Catch:{ Exception -> 0x005c }
            r6 = 5
            if (r5 >= r6) goto L_0x0052
            r5 = 5
        L_0x0052:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x005c }
            if (r6 == 0) goto L_0x006f
            r6.setBatchInterval(r5)     // Catch:{ Exception -> 0x005c }
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x006f:
            java.lang.String r5 = "batchSize"
            int r5 = r4.optInt(r5)     // Catch:{ Exception -> 0x0082 }
            if (r5 >= r3) goto L_0x0078
            r5 = 1
        L_0x0078:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x0082 }
            if (r6 == 0) goto L_0x0095
            r6.setBatchSize(r5)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0095
        L_0x0082:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0095:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x00a5 }
            if (r5 == 0) goto L_0x00b8
            java.lang.String r6 = "fetchLocation"
            boolean r6 = r4.optBoolean(r6)     // Catch:{ Exception -> 0x00a5 }
            r5.setFetchLocation(r6)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00b8
        L_0x00a5:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x00b8:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x00c8 }
            if (r5 == 0) goto L_0x00db
            java.lang.String r6 = "paEnabled"
            boolean r6 = r4.optBoolean(r6)     // Catch:{ Exception -> 0x00c8 }
            r5.setPaEnabled(r6)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00db
        L_0x00c8:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x00db:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x00eb }
            if (r5 == 0) goto L_0x00fe
            java.lang.String r6 = "paInterval"
            int r6 = r4.optInt(r6)     // Catch:{ Exception -> 0x00eb }
            r5.setPaInterval(r6)     // Catch:{ Exception -> 0x00eb }
            goto L_0x00fe
        L_0x00eb:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x00fe:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x0121
            java.lang.String r6 = "panelActive"
            boolean r6 = r4.optBoolean(r6)     // Catch:{ Exception -> 0x010e }
            r5.setPanelActive(r6)     // Catch:{ Exception -> 0x010e }
            goto L_0x0121
        L_0x010e:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0121:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x0131 }
            if (r5 == 0) goto L_0x0144
            java.lang.String r6 = "sdkActive"
            boolean r6 = r4.optBoolean(r6)     // Catch:{ Exception -> 0x0131 }
            r5.setSdkActive(r6)     // Catch:{ Exception -> 0x0131 }
            goto L_0x0144
        L_0x0131:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0144:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x0154 }
            if (r5 == 0) goto L_0x0167
            java.lang.String r6 = "sessionInterval"
            int r6 = r4.optInt(r6)     // Catch:{ Exception -> 0x0154 }
            r5.setSessionInterval(r6)     // Catch:{ Exception -> 0x0154 }
            goto L_0x0167
        L_0x0154:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0167:
            java.lang.String r5 = "eventLimit"
            int r5 = r4.optInt(r5)     // Catch:{ Exception -> 0x017b }
            if (r5 >= r3) goto L_0x0171
            r5 = 200(0xc8, float:2.8E-43)
        L_0x0171:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x017b }
            if (r6 == 0) goto L_0x018e
            r6.setEventLimit(r5)     // Catch:{ Exception -> 0x017b }
            goto L_0x018e
        L_0x017b:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x018e:
            r5 = 50
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            if (r6 == 0) goto L_0x019e
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings     // Catch:{ Exception -> 0x021c }
            r7.<init>()     // Catch:{ Exception -> 0x021c }
            r6.setSmartechGeoFenceSettings(r7)     // Catch:{ Exception -> 0x021c }
        L_0x019e:
            java.lang.String r6 = "geoFenceSettings"
            org.json.JSONObject r6 = r4.optJSONObject(r6)     // Catch:{ Exception -> 0x021c }
            if (r6 == 0) goto L_0x022f
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01bb
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = r7.getSmartechGeoFenceSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01bb
            java.lang.String r8 = "geoFenceEnabled"
            boolean r8 = r6.optBoolean(r8, r12)     // Catch:{ Exception -> 0x021c }
            r7.setGeoFenceEnabled(r8)     // Catch:{ Exception -> 0x021c }
        L_0x01bb:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01d0
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = r7.getSmartechGeoFenceSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01d0
            java.lang.String r8 = "geoFenceDistance"
            int r8 = r6.optInt(r8, r5)     // Catch:{ Exception -> 0x021c }
            r7.setGeoFenceDistance(r8)     // Catch:{ Exception -> 0x021c }
        L_0x01d0:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01e5
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = r7.getSmartechGeoFenceSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x01e5
            java.lang.String r8 = "geoFenceLastModified"
            long r8 = r6.optLong(r8)     // Catch:{ Exception -> 0x021c }
            r7.setGeoFenceLastModified(r8)     // Catch:{ Exception -> 0x021c }
        L_0x01e5:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0201
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = r7.getSmartechGeoFenceSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x0201
            java.lang.String r9 = "serverRefreshGeoFenceDistanceConfig"
            java.lang.String r9 = r6.optString(r9, r8)     // Catch:{ Exception -> 0x021c }
            java.lang.String r10 = "it.optString(\"serverRefr…FenceDistanceConfig\", \"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x021c }
            r7.setServerRefreshGeoFenceDistanceConfig(r9)     // Catch:{ Exception -> 0x021c }
        L_0x0201:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x022f
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r7 = r7.getSmartechGeoFenceSettings()     // Catch:{ Exception -> 0x021c }
            if (r7 == 0) goto L_0x022f
            java.lang.String r9 = "appRefreshGeoFenceDistanceConfig"
            java.lang.String r6 = r6.optString(r9, r8)     // Catch:{ Exception -> 0x021c }
            java.lang.String r8 = "it.optString(\"appRefresh…oFenceDistanceConfig\",\"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)     // Catch:{ Exception -> 0x021c }
            r7.setAppRefreshGeoFenceDistanceConfig(r6)     // Catch:{ Exception -> 0x021c }
            goto L_0x022f
        L_0x021c:
            r6 = move-exception
            com.netcore.android.logger.SMTLogger r7 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r8 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0501 }
            r7.e(r8, r6)     // Catch:{ Exception -> 0x0501 }
        L_0x022f:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x025e }
            if (r6 == 0) goto L_0x023e
            java.lang.String r7 = "appInboxEnabled"
            boolean r7 = r4.optBoolean(r7, r12)     // Catch:{ Exception -> 0x025e }
            r6.setAppInboxEnabled(r7)     // Catch:{ Exception -> 0x025e }
        L_0x023e:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x025e }
            if (r6 == 0) goto L_0x024e
            java.lang.String r7 = "messageCachePeriod"
            r8 = 7
            int r7 = r4.optInt(r7, r8)     // Catch:{ Exception -> 0x025e }
            r6.setMessageCachePeriod(r7)     // Catch:{ Exception -> 0x025e }
        L_0x024e:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x025e }
            if (r6 == 0) goto L_0x0271
            java.lang.String r7 = "mediaCachingSize"
            int r5 = r4.optInt(r7, r5)     // Catch:{ Exception -> 0x025e }
            r6.setMediaCachingSize(r5)     // Catch:{ Exception -> 0x025e }
            goto L_0x0271
        L_0x025e:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0271:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x0281 }
            if (r5 == 0) goto L_0x0294
            java.lang.String r6 = "baseUrl"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ Exception -> 0x0281 }
            r5.setBaseUrl(r6)     // Catch:{ Exception -> 0x0281 }
            goto L_0x0294
        L_0x0281:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x0294:
            java.lang.String r5 = "tokenInterval"
            int r5 = r4.optInt(r5)     // Catch:{ Exception -> 0x02a8 }
            if (r5 >= r3) goto L_0x029e
            r5 = 60
        L_0x029e:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x02a8 }
            if (r6 == 0) goto L_0x02bb
            r6.setTokenInterval(r5)     // Catch:{ Exception -> 0x02a8 }
            goto L_0x02bb
        L_0x02a8:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r7 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0501 }
            r6.e(r7, r5)     // Catch:{ Exception -> 0x0501 }
        L_0x02bb:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r5 == 0) goto L_0x02c9
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings     // Catch:{ Exception -> 0x033b }
            r6.<init>()     // Catch:{ Exception -> 0x033b }
            r5.setSmartechEventSettings(r6)     // Catch:{ Exception -> 0x033b }
        L_0x02c9:
            java.lang.String r5 = "eventSettings"
            org.json.JSONObject r5 = r4.optJSONObject(r5)     // Catch:{ Exception -> 0x033b }
            if (r5 == 0) goto L_0x034e
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x02e6
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = r6.getSmartechEventSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x02e6
            java.lang.String r7 = "allevents"
            boolean r7 = r5.optBoolean(r7, r3)     // Catch:{ Exception -> 0x033b }
            r6.setAllevents(r7)     // Catch:{ Exception -> 0x033b }
        L_0x02e6:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x02fb
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = r6.getSmartechEventSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x02fb
            java.lang.String r7 = "appinbox"
            boolean r7 = r5.optBoolean(r7, r3)     // Catch:{ Exception -> 0x033b }
            r6.setAppinbox(r7)     // Catch:{ Exception -> 0x033b }
        L_0x02fb:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x0310
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = r6.getSmartechEventSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x0310
            java.lang.String r7 = "push"
            boolean r7 = r5.optBoolean(r7, r3)     // Catch:{ Exception -> 0x033b }
            r6.setPush(r7)     // Catch:{ Exception -> 0x033b }
        L_0x0310:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x0325
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = r6.getSmartechEventSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x0325
            java.lang.String r7 = "inapp"
            boolean r7 = r5.optBoolean(r7, r3)     // Catch:{ Exception -> 0x033b }
            r6.setInapp(r7)     // Catch:{ Exception -> 0x033b }
        L_0x0325:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r6 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x034e
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r6 = r6.getSmartechEventSettings()     // Catch:{ Exception -> 0x033b }
            if (r6 == 0) goto L_0x034e
            java.lang.String r7 = "lifecycle"
            boolean r3 = r5.optBoolean(r7, r3)     // Catch:{ Exception -> 0x033b }
            r6.setLifecycle(r3)     // Catch:{ Exception -> 0x033b }
            goto L_0x034e
        L_0x033b:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r5 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r6 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0501 }
            r5.e(r6, r3)     // Catch:{ Exception -> 0x0501 }
        L_0x034e:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r3 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x03b9 }
            if (r3 == 0) goto L_0x035c
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r5 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings     // Catch:{ Exception -> 0x03b9 }
            r5.<init>()     // Catch:{ Exception -> 0x03b9 }
            r3.setSmartechInAppFrequencySettings(r5)     // Catch:{ Exception -> 0x03b9 }
        L_0x035c:
            java.lang.String r3 = "frequency"
            org.json.JSONObject r3 = r4.optJSONObject(r3)     // Catch:{ Exception -> 0x03b9 }
            if (r3 == 0) goto L_0x03cc
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x0379
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r5 = r5.getSmartechInAppFrequencySettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x0379
            java.lang.String r6 = "enable"
            int r6 = r3.optInt(r6, r12)     // Catch:{ Exception -> 0x03b9 }
            r5.setEnable(r6)     // Catch:{ Exception -> 0x03b9 }
        L_0x0379:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x038e
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r5 = r5.getSmartechInAppFrequencySettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x038e
            java.lang.String r6 = "day"
            int r6 = r3.optInt(r6, r12)     // Catch:{ Exception -> 0x03b9 }
            r5.setDay(r6)     // Catch:{ Exception -> 0x03b9 }
        L_0x038e:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x03a3
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r5 = r5.getSmartechInAppFrequencySettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x03a3
            java.lang.String r6 = "week"
            int r6 = r3.optInt(r6, r12)     // Catch:{ Exception -> 0x03b9 }
            r5.setWeek(r6)     // Catch:{ Exception -> 0x03b9 }
        L_0x03a3:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x03cc
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings r5 = r5.getSmartechInAppFrequencySettings()     // Catch:{ Exception -> 0x03b9 }
            if (r5 == 0) goto L_0x03cc
            java.lang.String r6 = "month"
            int r3 = r3.optInt(r6, r12)     // Catch:{ Exception -> 0x03b9 }
            r5.setMonth(r3)     // Catch:{ Exception -> 0x03b9 }
            goto L_0x03cc
        L_0x03b9:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r5 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r6 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0501 }
            r5.e(r6, r3)     // Catch:{ Exception -> 0x0501 }
        L_0x03cc:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r3 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x03da
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL     // Catch:{ Exception -> 0x047f }
            r5.<init>()     // Catch:{ Exception -> 0x047f }
            r3.setSmartechURL(r5)     // Catch:{ Exception -> 0x047f }
        L_0x03da:
            java.lang.String r3 = "baseUrls"
            org.json.JSONObject r3 = r4.optJSONObject(r3)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0492
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x03fc
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x03fc
            java.lang.String r6 = "trackAppActUrl"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "it.optString(\"trackAppActUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x047f }
            r5.setTrackAppActUrl(r6)     // Catch:{ Exception -> 0x047f }
        L_0x03fc:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0416
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0416
            java.lang.String r6 = "pushAmpUrl"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "it.optString(\"pushAmpUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x047f }
            r5.setPushAmpUrl(r6)     // Catch:{ Exception -> 0x047f }
        L_0x0416:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0430
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0430
            java.lang.String r6 = "inAppUrl"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "it.optString(\"inAppUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x047f }
            r5.setInAppUrl(r6)     // Catch:{ Exception -> 0x047f }
        L_0x0430:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x044a
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x044a
            java.lang.String r6 = "listSegUrl"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "it.optString(\"listSegUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x047f }
            r5.setInAppListSegUrl(r6)     // Catch:{ Exception -> 0x047f }
        L_0x044a:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0464
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0464
            java.lang.String r6 = "inboxUrl"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "it.optString(\"inboxUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x047f }
            r5.setInboxUrl(r6)     // Catch:{ Exception -> 0x047f }
        L_0x0464:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r5 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0492
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r5 = r5.getSmartechURL()     // Catch:{ Exception -> 0x047f }
            if (r5 == 0) goto L_0x0492
            java.lang.String r6 = "geoFenceUrl"
            java.lang.String r3 = r3.optString(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r6 = "it.optString(\"geoFenceUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch:{ Exception -> 0x047f }
            r5.setGeoFenceUrl(r3)     // Catch:{ Exception -> 0x047f }
            goto L_0x0492
        L_0x047f:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r5 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r6 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0501 }
            r5.e(r6, r3)     // Catch:{ Exception -> 0x0501 }
        L_0x0492:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r3 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x04ed }
            if (r3 == 0) goto L_0x04a0
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r5 = new com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel     // Catch:{ Exception -> 0x04ed }
            r5.<init>()     // Catch:{ Exception -> 0x04ed }
            r3.setDebuglevel(r5)     // Catch:{ Exception -> 0x04ed }
        L_0x04a0:
            java.lang.String r3 = "debug"
            org.json.JSONObject r3 = r4.optJSONObject(r3)     // Catch:{ Exception -> 0x04ed }
            if (r3 == 0) goto L_0x0514
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r4 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x04bd
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r4 = r4.getDebuglevel()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x04bd
            java.lang.String r5 = "logEnabled"
            boolean r5 = r3.optBoolean(r5, r12)     // Catch:{ Exception -> 0x04ed }
            r4.setLogEnabled(r5)     // Catch:{ Exception -> 0x04ed }
        L_0x04bd:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r4 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x04d2
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r4 = r4.getDebuglevel()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x04d2
            java.lang.String r5 = "logLevel"
            int r5 = r3.optInt(r5, r12)     // Catch:{ Exception -> 0x04ed }
            r4.setLogLevel(r5)     // Catch:{ Exception -> 0x04ed }
        L_0x04d2:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r4 = r1.getSmartechSettings()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x0514
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel r4 = r4.getDebuglevel()     // Catch:{ Exception -> 0x04ed }
            if (r4 == 0) goto L_0x0514
            java.lang.String r5 = "guids"
            org.json.JSONArray r3 = r3.optJSONArray(r5)     // Catch:{ Exception -> 0x04ed }
            java.lang.String r5 = "it.optJSONArray(\"guids\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ Exception -> 0x04ed }
            r4.setGuids(r3)     // Catch:{ Exception -> 0x04ed }
            goto L_0x0514
        L_0x04ed:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r4 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x0501 }
            java.lang.String r5 = r11.TAG     // Catch:{ Exception -> 0x0501 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0501 }
            r4.e(r5, r3)     // Catch:{ Exception -> 0x0501 }
            goto L_0x0514
        L_0x0501:
            r3 = move-exception
            com.netcore.android.logger.SMTLogger r4 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x059e }
            java.lang.String r5 = r11.TAG     // Catch:{ Exception -> 0x059e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ Exception -> 0x059e }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x059e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x059e }
            r4.e(r5, r3)     // Catch:{ Exception -> 0x059e }
        L_0x0514:
            java.lang.String r3 = "inAppRules"
            org.json.JSONArray r2 = r2.optJSONArray(r3)     // Catch:{ Exception -> 0x058a }
            if (r2 == 0) goto L_0x057d
            int r3 = r2.length()     // Catch:{ Exception -> 0x058a }
            if (r3 <= 0) goto L_0x057d
            java.util.ArrayList r3 = r1.getInAppRules()     // Catch:{ Exception -> 0x058a }
            if (r3 != 0) goto L_0x0530
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x058a }
            r3.<init>()     // Catch:{ Exception -> 0x058a }
            r1.setInAppRules(r3)     // Catch:{ Exception -> 0x058a }
        L_0x0530:
            int r3 = r2.length()     // Catch:{ Exception -> 0x058a }
            r4 = 0
        L_0x0535:
            if (r4 >= r3) goto L_0x05a6
            com.netcore.android.inapp.f r5 = new com.netcore.android.inapp.f     // Catch:{ Exception -> 0x058a }
            r5.<init>()     // Catch:{ Exception -> 0x058a }
            java.lang.Object r6 = r2.get(r4)     // Catch:{ Exception -> 0x058a }
            if (r6 == 0) goto L_0x0575
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Exception -> 0x058a }
            java.util.ArrayList r5 = r5.d(r6)     // Catch:{ Exception -> 0x058a }
            if (r5 == 0) goto L_0x0553
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x058a }
            if (r6 == 0) goto L_0x0551
            goto L_0x0553
        L_0x0551:
            r6 = 0
            goto L_0x0554
        L_0x0553:
            r6 = 1
        L_0x0554:
            if (r6 != 0) goto L_0x0572
            boolean r6 = r1.isListAndSegmentPresent()     // Catch:{ Exception -> 0x058a }
            if (r6 != 0) goto L_0x0569
            java.lang.Object r6 = r5.get(r12)     // Catch:{ Exception -> 0x058a }
            com.netcore.android.inapp.h.b r6 = (com.netcore.android.inapp.h.b) r6     // Catch:{ Exception -> 0x058a }
            boolean r6 = r6.r()     // Catch:{ Exception -> 0x058a }
            r1.setListAndSegmentPresent(r6)     // Catch:{ Exception -> 0x058a }
        L_0x0569:
            java.util.ArrayList r6 = r1.getInAppRules()     // Catch:{ Exception -> 0x058a }
            if (r6 == 0) goto L_0x0572
            r6.addAll(r5)     // Catch:{ Exception -> 0x058a }
        L_0x0572:
            int r4 = r4 + 1
            goto L_0x0535
        L_0x0575:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x058a }
            java.lang.String r2 = "null cannot be cast to non-null type org.json.JSONObject"
            r12.<init>(r2)     // Catch:{ Exception -> 0x058a }
            throw r12     // Catch:{ Exception -> 0x058a }
        L_0x057d:
            com.netcore.android.logger.SMTLogger r12 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x058a }
            java.lang.String r2 = r11.TAG     // Catch:{ Exception -> 0x058a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x058a }
            java.lang.String r3 = "InApp rules not found"
            r12.w(r2, r3)     // Catch:{ Exception -> 0x058a }
            goto L_0x05a6
        L_0x058a:
            r12 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x059e }
            java.lang.String r3 = r11.TAG     // Catch:{ Exception -> 0x059e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ Exception -> 0x059e }
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x059e }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x059e }
            r2.e(r3, r12)     // Catch:{ Exception -> 0x059e }
            goto L_0x05a6
        L_0x059e:
            r12 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r11.TAG
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r3, r0, r12, r2, r3)
        L_0x05a6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.network.parser.SMTSdkInitParser.parse$smartech_release(com.netcore.android.network.SMTHttpRequestClient$NetworkResponse):com.netcore.android.network.models.SMTSdkInitializeResponse");
    }
}
