package com.facebook.appevents.cloudbridge;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.net.ftp.FTPReply;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010 \u001a\u00020!2\u001a\u0010\"\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0007J\n\u0010)\u001a\u0004\u0018\u00010\fH\u0007J=\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0#2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\f2\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b2\b\b\u0002\u00105\u001a\u00020\u00052<\u00106\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!\u0018\u000107H\u0000¢\u0006\u0002\b;J$\u0010<\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020!2\u0006\u0010=\u001a\u00020>H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006A"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "()V", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "MAX_CACHED_TRANSFORMED_EVENTS", "MAX_PROCESSED_TRANSFORMED_EVENTS", "MAX_RETRY_COUNT", "RETRY_EVENTS_HTTP_RESPONSE", "TAG", "", "TIMEOUT_INTERVAL", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "transformedEvents", "", "", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "", "events", "", "appendEvents$facebook_core_release", "configure", "datasetID", "url", "accessKey", "getCredentials", "handleError", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "makeHttpRequest", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "requestCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "requestResult", "makeHttpRequest$facebook_core_release", "transformAppEventRequestForCAPIG", "request", "Lcom/facebook/GraphRequest;", "transformGraphRequestAndSendToCAPIGEndPoint", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
public final class AppEventsConversionsAPITransformerWebRequests {
    public static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = TweetUtils.hashSetOf(Integer.valueOf(200), Integer.valueOf(202));
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    public static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = TweetUtils.hashSetOf(Integer.valueOf(FTPReply.BAD_COMMAND_SEQUENCE), Integer.valueOf(FTPReply.COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER), Integer.valueOf(429));
    public static CloudBridgeCredentials credentials;
    public static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    public static final class CloudBridgeCredentials {
        public final String accessKey;
        public final String cloudBridgeURL;
        public final String datasetID;

        public CloudBridgeCredentials(String str, String str2, String str3) {
            GeneratedOutlineSupport.outline97(str, "datasetID", str2, "cloudBridgeURL", str3, "accessKey");
            this.datasetID = str;
            this.cloudBridgeURL = str2;
            this.accessKey = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return Intrinsics.areEqual(this.datasetID, cloudBridgeCredentials.datasetID) && Intrinsics.areEqual(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        public int hashCode() {
            return this.accessKey.hashCode() + GeneratedOutlineSupport.outline11(this.cloudBridgeURL, this.datasetID.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("CloudBridgeCredentials(datasetID=");
            outline73.append(this.datasetID);
            outline73.append(", cloudBridgeURL=");
            outline73.append(this.cloudBridgeURL);
            outline73.append(", accessKey=");
            return GeneratedOutlineSupport.outline59(outline73, this.accessKey, ')');
        }
    }

    public static final void configure(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "datasetID", str2, "url", str3, "accessKey");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "CAPITransformerWebRequests", (String) " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        CloudBridgeCredentials cloudBridgeCredentials = new CloudBridgeCredentials(str, str2, str3);
        Intrinsics.checkNotNullParameter(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        transformedEvents = arrayList;
    }

    /* JADX WARNING: type inference failed for: r0v14, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r0v43 */
    /* JADX WARNING: type inference failed for: r0v124, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v130 */
    /* JADX WARNING: type inference failed for: r0v131 */
    /* JADX WARNING: type inference failed for: r0v132 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x060c A[Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x03d3 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m158transformGraphRequestAndSendToCAPIGEndPoint$lambda0(com.facebook.GraphRequest r30) {
        /*
            r1 = r30
            java.lang.String r0 = "$request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = r1.graphPath
            r2 = 0
            if (r0 != 0) goto L_0x000e
            r0 = 0
            goto L_0x0019
        L_0x000e:
            java.lang.String r4 = "/"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r5 = 6
            java.util.List r0 = kotlin.text.CharsKt__CharKt.split$default(r0, r4, r2, r2, r5)
        L_0x0019:
            java.lang.String r4 = "CAPITransformerWebRequests"
            r5 = 1
            if (r0 == 0) goto L_0x06df
            int r0 = r0.size()
            r6 = 2
            if (r0 == r6) goto L_0x0027
            goto L_0x06df
        L_0x0027:
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials r0 = credentials     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            java.lang.String r7 = "credentials"
            if (r0 == 0) goto L_0x06c3
            java.lang.String r0 = r0.cloudBridgeURL     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials r8 = credentials     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            if (r8 == 0) goto L_0x06bb
            java.lang.String r8 = r8.datasetID     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            r9.<init>()     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            r9.append(r0)     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            java.lang.String r0 = "/capi/"
            r9.append(r0)     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            r9.append(r8)     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            java.lang.String r0 = "/events"
            r9.append(r0)     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            java.lang.String r8 = r9.toString()     // Catch:{ UninitializedPropertyAccessException -> 0x06cd }
            org.json.JSONObject r0 = r1.graphObject
            if (r0 == 0) goto L_0x04b3
            java.util.Map r0 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r0)
            java.util.Map r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableMap(r0)
            java.lang.Object r9 = r1.tag
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Any"
            if (r9 == 0) goto L_0x04ad
            r11 = r0
            java.util.HashMap r11 = (java.util.HashMap) r11
            java.lang.String r12 = "custom_events"
            r11.put(r12, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r11 = r0
            java.util.LinkedHashMap r11 = (java.util.LinkedHashMap) r11
            java.util.Set r12 = r11.keySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0078:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x009d
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r9.append(r13)
            java.lang.String r14 = " : "
            r9.append(r14)
            java.lang.Object r13 = r11.get(r13)
            r9.append(r13)
            java.lang.String r13 = "line.separator"
            java.lang.String r13 = java.lang.System.getProperty(r13)
            r9.append(r13)
            goto L_0x0078
        L_0x009d:
            com.facebook.internal.Logger$Companion r12 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r13 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r14 = new java.lang.Object[r5]
            r14[r2] = r9
            java.lang.String r9 = "\nGraph Request data: \n\n%s \n\n"
            r12.log(r13, r4, r9, r14)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer r9 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.INSTANCE
            java.lang.String r9 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            com.facebook.appevents.cloudbridge.OtherEventConstants r0 = com.facebook.appevents.cloudbridge.OtherEventConstants.EVENT
            java.lang.String r0 = r0.getRawValue()
            java.lang.Object r0 = r11.get(r0)
            com.facebook.appevents.cloudbridge.AppEventType$Companion r15 = com.facebook.appevents.cloudbridge.AppEventType.Companion
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.String"
            if (r0 == 0) goto L_0x04a7
            java.lang.String r0 = (java.lang.String) r0
            if (r15 == 0) goto L_0x04a5
            java.lang.String r15 = "rawValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            java.lang.String r2 = "MOBILE_APP_INSTALL"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x00ea
            com.facebook.appevents.cloudbridge.AppEventType r0 = com.facebook.appevents.cloudbridge.AppEventType.MOBILE_APP_INSTALL
        L_0x00e8:
            r2 = r0
            goto L_0x00f8
        L_0x00ea:
            java.lang.String r2 = "CUSTOM_APP_EVENTS"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L_0x00f5
            com.facebook.appevents.cloudbridge.AppEventType r0 = com.facebook.appevents.cloudbridge.AppEventType.CUSTOM
            goto L_0x00e8
        L_0x00f5:
            com.facebook.appevents.cloudbridge.AppEventType r0 = com.facebook.appevents.cloudbridge.AppEventType.OTHER
            goto L_0x00e8
        L_0x00f8:
            com.facebook.appevents.cloudbridge.AppEventType r0 = com.facebook.appevents.cloudbridge.AppEventType.OTHER
            java.lang.String r6 = "appData"
            java.lang.String r5 = "userData"
            if (r2 != r0) goto L_0x0110
        L_0x0100:
            r19 = r4
            r24 = r5
            r22 = r6
            r20 = r7
            r21 = r8
            r27 = r9
            r23 = r12
            goto L_0x03e9
        L_0x0110:
            java.util.Set r0 = r11.entrySet()
            java.util.Iterator r18 = r0.iterator()
        L_0x0118:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x0100
            java.lang.Object r0 = r18.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r19 = r0.getKey()
            r20 = r7
            r7 = r19
            java.lang.String r7 = (java.lang.String) r7
            r19 = r4
            java.lang.Object r4 = r0.getValue()
            com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField$Companion r0 = com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField.Companion
            if (r0 == 0) goto L_0x03e7
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r15)
            com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField[] r0 = com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField.values()
            int r1 = r0.length
            r21 = r8
            r8 = 0
        L_0x0143:
            if (r8 >= r1) goto L_0x015b
            r22 = r0[r8]
            r23 = r0
            java.lang.String r0 = r22.getRawValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            if (r0 == 0) goto L_0x0156
            r0 = r22
            goto L_0x015c
        L_0x0156:
            int r8 = r8 + 1
            r0 = r23
            goto L_0x0143
        L_0x015b:
            r0 = 0
        L_0x015c:
            java.lang.String r1 = "\n transformEvents JSONException: \n%s\n%s"
            java.lang.String r8 = "AppEventsConversionsAPITransformer"
            if (r0 == 0) goto L_0x01f6
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r6)
            java.lang.String r7 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            java.lang.String r7 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.util.Map<com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField, com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping> r7 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.topLevelTransformations
            java.lang.Object r7 = r7.get(r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping r7 = (com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.SectionFieldMapping) r7
            if (r7 != 0) goto L_0x017f
            r22 = r6
            goto L_0x01bb
        L_0x017f:
            com.facebook.appevents.cloudbridge.ConversionsAPISection r7 = r7.section
            int r7 = r7.ordinal()
            if (r7 == 0) goto L_0x01a6
            r22 = r6
            r6 = 1
            if (r7 == r6) goto L_0x018d
            goto L_0x01bb
        L_0x018d:
            java.util.Map<com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField, com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping> r1 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.topLevelTransformations
            java.lang.Object r0 = r1.get(r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping r0 = (com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.SectionFieldMapping) r0
            if (r0 != 0) goto L_0x0199
            r0 = 0
            goto L_0x019b
        L_0x0199:
            com.facebook.appevents.cloudbridge.ConversionsAPIUserAndAppDataField r0 = r0.field
        L_0x019b:
            if (r0 != 0) goto L_0x019e
            goto L_0x01bb
        L_0x019e:
            java.lang.String r0 = r0.getRawValue()
            r12.put(r0, r4)
            goto L_0x01bb
        L_0x01a6:
            r22 = r6
            com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField r6 = com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField.USER_DATA
            if (r0 != r6) goto L_0x01d6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c0 }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x01c0 }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x01c0 }
            java.util.Map r0 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r0)     // Catch:{ JSONException -> 0x01c0 }
            r9.putAll(r0)     // Catch:{ JSONException -> 0x01c0 }
        L_0x01bb:
            r24 = r5
            r23 = r12
            goto L_0x01f2
        L_0x01c0:
            r0 = move-exception
            com.facebook.internal.Logger$Companion r6 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r7 = com.facebook.LoggingBehavior.APP_EVENTS
            r24 = r5
            r23 = r12
            r12 = 2
            java.lang.Object[] r5 = new java.lang.Object[r12]
            r12 = 0
            r5[r12] = r4
            r4 = 1
            r5[r4] = r0
            r6.log(r7, r8, r1, r5)
            goto L_0x01f2
        L_0x01d6:
            r24 = r5
            r23 = r12
            java.util.Map<com.facebook.appevents.cloudbridge.AppEventUserAndAppDataField, com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping> r1 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.topLevelTransformations
            java.lang.Object r0 = r1.get(r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionFieldMapping r0 = (com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.SectionFieldMapping) r0
            if (r0 != 0) goto L_0x01e6
            r0 = 0
            goto L_0x01e8
        L_0x01e6:
            com.facebook.appevents.cloudbridge.ConversionsAPIUserAndAppDataField r0 = r0.field
        L_0x01e8:
            if (r0 != 0) goto L_0x01eb
            goto L_0x01f2
        L_0x01eb:
            java.lang.String r0 = r0.getRawValue()
            r9.put(r0, r4)
        L_0x01f2:
            r27 = r9
            goto L_0x03d3
        L_0x01f6:
            r24 = r5
            r22 = r6
            r23 = r12
            com.facebook.appevents.cloudbridge.ConversionsAPISection r0 = com.facebook.appevents.cloudbridge.ConversionsAPISection.CUSTOM_EVENTS
            java.lang.String r0 = r0.getRawValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            boolean r5 = r4 instanceof java.lang.String
            com.facebook.appevents.cloudbridge.AppEventType r6 = com.facebook.appevents.cloudbridge.AppEventType.CUSTOM
            if (r2 != r6) goto L_0x03ac
            if (r0 == 0) goto L_0x03ac
            if (r5 == 0) goto L_0x03ac
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = "appEvents"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0392 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0392 }
            java.util.List r5 = com.facebook.internal.Utility.convertJSONArrayToList(r5)     // Catch:{ JSONException -> 0x0392 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0392 }
        L_0x0229:
            boolean r6 = r5.hasNext()     // Catch:{ JSONException -> 0x0392 }
            if (r6 == 0) goto L_0x0242
            java.lang.Object r6 = r5.next()     // Catch:{ JSONException -> 0x0392 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0392 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0392 }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x0392 }
            java.util.Map r6 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r7)     // Catch:{ JSONException -> 0x0392 }
            r0.add(r6)     // Catch:{ JSONException -> 0x0392 }
            goto L_0x0229
        L_0x0242:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x024c
            r27 = r9
            goto L_0x03a5
        L_0x024c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r4 = r0.iterator()
        L_0x0255:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x038f
            java.lang.Object r0 = r4.next()
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Set r0 = r5.keySet()
            java.util.Iterator r12 = r0.iterator()
        L_0x0274:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0371
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            com.facebook.appevents.cloudbridge.CustomEventField$Companion r25 = com.facebook.appevents.cloudbridge.CustomEventField.Companion
            if (r25 == 0) goto L_0x036f
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            r25 = r4
            com.facebook.appevents.cloudbridge.CustomEventField[] r4 = com.facebook.appevents.cloudbridge.CustomEventField.values()
            r26 = r12
            int r12 = r4.length
            r27 = r9
            r9 = 0
        L_0x0293:
            if (r9 >= r12) goto L_0x02ab
            r28 = r4[r9]
            r29 = r4
            java.lang.String r4 = r28.getRawValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            if (r4 == 0) goto L_0x02a6
            r4 = r28
            goto L_0x02ac
        L_0x02a6:
            int r9 = r9 + 1
            r4 = r29
            goto L_0x0293
        L_0x02ab:
            r4 = 0
        L_0x02ac:
            java.util.Map<com.facebook.appevents.cloudbridge.CustomEventField, com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping> r9 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.customEventTransformations
            java.lang.Object r9 = r9.get(r4)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping r9 = (com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.SectionCustomEventFieldMapping) r9
            if (r4 == 0) goto L_0x0362
            if (r9 != 0) goto L_0x02ba
            goto L_0x0362
        L_0x02ba:
            com.facebook.appevents.cloudbridge.ConversionsAPISection r12 = r9.section
            if (r12 == 0) goto L_0x02e5
            com.facebook.appevents.cloudbridge.ConversionsAPISection r4 = com.facebook.appevents.cloudbridge.ConversionsAPISection.CUSTOM_DATA
            if (r12 != r4) goto L_0x0362
            com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField r4 = r9.field
            java.lang.String r4 = r4.getRawValue()
            java.lang.Object r9 = r5.get(r0)
            if (r9 == 0) goto L_0x02df
            java.lang.Object r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.transformValue$facebook_core_release(r0, r9)
            if (r0 == 0) goto L_0x02d9
            r6.put(r4, r0)
            goto L_0x0362
        L_0x02d9:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x02df:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x02e5:
            com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField r9 = r9.field     // Catch:{ ClassCastException -> 0x034a }
            java.lang.String r9 = r9.getRawValue()     // Catch:{ ClassCastException -> 0x034a }
            com.facebook.appevents.cloudbridge.CustomEventField r12 = com.facebook.appevents.cloudbridge.CustomEventField.EVENT_NAME     // Catch:{ ClassCastException -> 0x034a }
            if (r4 != r12) goto L_0x0322
            java.lang.Object r12 = r5.get(r0)     // Catch:{ ClassCastException -> 0x034a }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ ClassCastException -> 0x034a }
            if (r12 == 0) goto L_0x0322
            java.lang.Object r0 = r5.get(r0)     // Catch:{ ClassCastException -> 0x034a }
            if (r0 == 0) goto L_0x031c
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ClassCastException -> 0x034a }
            java.util.Map<java.lang.String, com.facebook.appevents.cloudbridge.ConversionsAPIEventName> r4 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.standardEventTransformations     // Catch:{ ClassCastException -> 0x034a }
            boolean r4 = r4.containsKey(r0)     // Catch:{ ClassCastException -> 0x034a }
            if (r4 == 0) goto L_0x0318
            java.util.Map<java.lang.String, com.facebook.appevents.cloudbridge.ConversionsAPIEventName> r4 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.standardEventTransformations     // Catch:{ ClassCastException -> 0x034a }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ ClassCastException -> 0x034a }
            com.facebook.appevents.cloudbridge.ConversionsAPIEventName r0 = (com.facebook.appevents.cloudbridge.ConversionsAPIEventName) r0     // Catch:{ ClassCastException -> 0x034a }
            if (r0 != 0) goto L_0x0314
            java.lang.String r0 = ""
            goto L_0x0318
        L_0x0314:
            java.lang.String r0 = r0.getRawValue()     // Catch:{ ClassCastException -> 0x034a }
        L_0x0318:
            r7.put(r9, r0)     // Catch:{ ClassCastException -> 0x034a }
            goto L_0x0362
        L_0x031c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ ClassCastException -> 0x034a }
            r0.<init>(r3)     // Catch:{ ClassCastException -> 0x034a }
            throw r0     // Catch:{ ClassCastException -> 0x034a }
        L_0x0322:
            com.facebook.appevents.cloudbridge.CustomEventField r12 = com.facebook.appevents.cloudbridge.CustomEventField.EVENT_TIME     // Catch:{ ClassCastException -> 0x034a }
            if (r4 != r12) goto L_0x0362
            java.lang.Object r4 = r5.get(r0)     // Catch:{ ClassCastException -> 0x034a }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ ClassCastException -> 0x034a }
            if (r4 == 0) goto L_0x0362
            java.lang.Object r4 = r5.get(r0)     // Catch:{ ClassCastException -> 0x034a }
            if (r4 == 0) goto L_0x0344
            java.lang.Object r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.transformValue$facebook_core_release(r0, r4)     // Catch:{ ClassCastException -> 0x034a }
            if (r0 == 0) goto L_0x033e
            r7.put(r9, r0)     // Catch:{ ClassCastException -> 0x034a }
            goto L_0x0362
        L_0x033e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ ClassCastException -> 0x034a }
            r0.<init>(r10)     // Catch:{ ClassCastException -> 0x034a }
            throw r0     // Catch:{ ClassCastException -> 0x034a }
        L_0x0344:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ ClassCastException -> 0x034a }
            r0.<init>(r10)     // Catch:{ ClassCastException -> 0x034a }
            throw r0     // Catch:{ ClassCastException -> 0x034a }
        L_0x034a:
            r0 = move-exception
            com.facebook.internal.Logger$Companion r4 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r9 = com.facebook.LoggingBehavior.APP_EVENTS
            r17 = r5
            r12 = 1
            java.lang.Object[] r5 = new java.lang.Object[r12]
            java.lang.String r0 = com.twitter.sdk.android.tweetui.TweetUtils.stackTraceToString(r0)
            r16 = 0
            r5[r16] = r0
            java.lang.String r0 = "\n transformEvents ClassCastException: \n %s "
            r4.log(r9, r8, r0, r5)
            goto L_0x0365
        L_0x0362:
            r17 = r5
            r12 = 1
        L_0x0365:
            r5 = r17
            r4 = r25
            r12 = r26
            r9 = r27
            goto L_0x0274
        L_0x036f:
            r4 = 0
            throw r4
        L_0x0371:
            r25 = r4
            r27 = r9
            r12 = 1
            boolean r0 = r6.isEmpty()
            r0 = r0 ^ r12
            if (r0 == 0) goto L_0x0386
            com.facebook.appevents.cloudbridge.ConversionsAPISection r0 = com.facebook.appevents.cloudbridge.ConversionsAPISection.CUSTOM_DATA
            java.lang.String r0 = r0.getRawValue()
            r7.put(r0, r6)
        L_0x0386:
            r1.add(r7)
            r4 = r25
            r9 = r27
            goto L_0x0255
        L_0x038f:
            r27 = r9
            goto L_0x03a6
        L_0x0392:
            r0 = move-exception
            r27 = r9
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r6 = com.facebook.LoggingBehavior.APP_EVENTS
            r7 = 2
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r7 = 0
            r9[r7] = r4
            r4 = 1
            r9[r4] = r0
            r5.log(r6, r8, r1, r9)
        L_0x03a5:
            r1 = 0
        L_0x03a6:
            if (r1 == 0) goto L_0x03d3
            r13.addAll(r1)
            goto L_0x03d3
        L_0x03ac:
            r27 = r9
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$DataProcessingParameterName$Companion r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.DataProcessingParameterName.Companion
            if (r0 == 0) goto L_0x03e5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r15)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer$DataProcessingParameterName[] r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.DataProcessingParameterName.values()
            int r1 = r0.length
            r5 = 0
        L_0x03bb:
            if (r5 >= r1) goto L_0x03cd
            r6 = r0[r5]
            java.lang.String r8 = r6.getRawValue()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r7)
            if (r8 == 0) goto L_0x03ca
            goto L_0x03ce
        L_0x03ca:
            int r5 = r5 + 1
            goto L_0x03bb
        L_0x03cd:
            r6 = 0
        L_0x03ce:
            if (r6 == 0) goto L_0x03d3
            r14.put(r7, r4)
        L_0x03d3:
            r1 = r30
            r4 = r19
            r7 = r20
            r8 = r21
            r6 = r22
            r12 = r23
            r5 = r24
            r9 = r27
            goto L_0x0118
        L_0x03e5:
            r1 = 0
            throw r1
        L_0x03e7:
            r1 = 0
            throw r1
        L_0x03e9:
            com.facebook.appevents.cloudbridge.AppEventType r0 = com.facebook.appevents.cloudbridge.AppEventType.OTHER
            if (r2 != r0) goto L_0x03ef
            goto L_0x04b9
        L_0x03ef:
            com.facebook.appevents.cloudbridge.OtherEventConstants r0 = com.facebook.appevents.cloudbridge.OtherEventConstants.INSTALL_EVENT_TIME
            java.lang.String r0 = r0.getRawValue()
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r1 = "eventType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r3 = r24
            r1 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r5 = r22
            r4 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r6 = "restOfData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r6)
            java.lang.String r7 = "customEvents"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r6)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            com.facebook.appevents.cloudbridge.OtherEventConstants r5 = com.facebook.appevents.cloudbridge.OtherEventConstants.ACTION_SOURCE
            java.lang.String r5 = r5.getRawValue()
            com.facebook.appevents.cloudbridge.OtherEventConstants r6 = com.facebook.appevents.cloudbridge.OtherEventConstants.APP
            java.lang.String r6 = r6.getRawValue()
            r3.put(r5, r6)
            com.facebook.appevents.cloudbridge.ConversionsAPISection r5 = com.facebook.appevents.cloudbridge.ConversionsAPISection.USER_DATA
            java.lang.String r5 = r5.getRawValue()
            r3.put(r5, r1)
            com.facebook.appevents.cloudbridge.ConversionsAPISection r1 = com.facebook.appevents.cloudbridge.ConversionsAPISection.APP_DATA
            java.lang.String r1 = r1.getRawValue()
            r3.put(r1, r4)
            r3.putAll(r14)
            int r1 = r2.ordinal()
            if (r1 == 0) goto L_0x047d
            r2 = 1
            if (r1 == r2) goto L_0x0452
            goto L_0x04b9
        L_0x0452:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0459
            goto L_0x04b9
        L_0x0459:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r13.iterator()
        L_0x0462:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04ba
            java.lang.Object r2 = r1.next()
            java.util.Map r2 = (java.util.Map) r2
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r4.putAll(r3)
            r4.putAll(r2)
            r0.add(r4)
            goto L_0x0462
        L_0x047d:
            if (r0 != 0) goto L_0x0480
            goto L_0x04b9
        L_0x0480:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r1.putAll(r3)
            com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField r2 = com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField.EVENT_NAME
            java.lang.String r2 = r2.getRawValue()
            com.facebook.appevents.cloudbridge.OtherEventConstants r3 = com.facebook.appevents.cloudbridge.OtherEventConstants.MOBILE_APP_INSTALL
            java.lang.String r3 = r3.getRawValue()
            r1.put(r2, r3)
            com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField r2 = com.facebook.appevents.cloudbridge.ConversionsAPICustomEventField.EVENT_TIME
            java.lang.String r2 = r2.getRawValue()
            r1.put(r2, r0)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r1)
            goto L_0x04ba
        L_0x04a5:
            r1 = 0
            throw r1
        L_0x04a7:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r3)
            throw r0
        L_0x04ad:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r10)
            throw r0
        L_0x04b3:
            r19 = r4
            r20 = r7
            r21 = r8
        L_0x04b9:
            r0 = 0
        L_0x04ba:
            if (r0 != 0) goto L_0x04bd
            return
        L_0x04bd:
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r1 = transformedEvents
            java.lang.String r2 = "transformedEvents"
            if (r1 == 0) goto L_0x06b6
            r1.addAll(r0)
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = transformedEvents
            if (r0 == 0) goto L_0x06b1
            int r0 = r0.size()
            int r0 = r0 + -1000
            r1 = 0
            int r0 = java.lang.Math.max(r1, r0)
            if (r0 <= 0) goto L_0x04f0
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r1 = transformedEvents
            if (r1 == 0) goto L_0x04eb
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.drop(r1, r0)
            java.util.List r0 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            java.lang.String r1 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            transformedEvents = r0
            goto L_0x04f0
        L_0x04eb:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
            throw r1
        L_0x04f0:
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = transformedEvents
            if (r0 == 0) goto L_0x06ac
            int r0 = r0.size()
            r1 = 10
            int r0 = java.lang.Math.min(r0, r1)
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r1 = transformedEvents
            if (r1 == 0) goto L_0x06a7
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            int r4 = r0 + -1
            r5 = 0
            r3.<init>(r5, r4)
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.slice(r1, r3)
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r3 = transformedEvents
            if (r3 == 0) goto L_0x06a2
            java.util.List r0 = r3.subList(r5, r0)
            r0.clear()
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>(r1)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.lang.String r3 = "data"
            r2.put(r3, r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials r0 = credentials
            if (r0 == 0) goto L_0x069d
            java.lang.String r0 = r0.accessKey
            java.lang.String r3 = "accessKey"
            r2.put(r3, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            com.facebook.internal.Logger$Companion r2 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.APP_EVENTS
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r21
            r5 = 1
            r4[r5] = r30
            r5 = 2
            java.lang.String r6 = r0.toString(r5)
            java.lang.String r7 = "jsonBodyStr.toString(2)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r4[r5] = r6
            java.lang.String r5 = "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n"
            r6 = r19
            r2.log(r3, r6, r5, r4)
            java.lang.String r0 = r0.toString()
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.<init>(r3, r4)
            java.util.Map r2 = com.twitter.sdk.android.tweetui.TweetUtils.mapOf(r2)
            r3 = 60000(0xea60, float:8.4078E-41)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1 r4 = new com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1
            r4.<init>(r1)
            java.lang.String r1 = "UTF-8"
            java.lang.String r5 = "urlStr"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            java.lang.String r5 = "POST"
            java.lang.String r8 = "requestMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            java.net.URL r8 = new java.net.URL     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r8.<init>(r7)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.net.URLConnection r7 = r8.openConnection()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r7 == 0) goto L_0x0661
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r7.setRequestMethod(r5)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.util.Set r8 = r2.keySet()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r8 != 0) goto L_0x059e
            goto L_0x05b8
        L_0x059e:
            java.util.Iterator r8 = r8.iterator()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
        L_0x05a2:
            boolean r9 = r8.hasNext()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r9 == 0) goto L_0x05b8
            java.lang.Object r9 = r8.next()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.Object r10 = r2.get(r9)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r7.setRequestProperty(r9, r10)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            goto L_0x05a2
        L_0x05b8:
            java.lang.String r2 = r7.getRequestMethod()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            boolean r2 = r2.equals(r5)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r2 != 0) goto L_0x05d1
            java.lang.String r2 = r7.getRequestMethod()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r5 = "PUT"
            boolean r2 = r2.equals(r5)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r2 == 0) goto L_0x05cf
            goto L_0x05d1
        L_0x05cf:
            r2 = 0
            goto L_0x05d2
        L_0x05d1:
            r2 = 1
        L_0x05d2:
            r7.setDoOutput(r2)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r7.setConnectTimeout(r3)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.OutputStream r3 = r7.getOutputStream()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r2.<init>(r3)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r5.<init>(r2, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r3.<init>(r5)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r3.write(r0)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r3.flush()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r3.close()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r2.close()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r0.<init>()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.util.HashSet<java.lang.Integer> r2 = ACCEPTABLE_HTTP_RESPONSE     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            int r3 = r7.getResponseCode()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            boolean r2 = r2.contains(r3)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            if (r2 == 0) goto L_0x0632
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.io.InputStream r5 = r7.getInputStream()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r3.<init>(r5, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r2.<init>(r3)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
        L_0x061a:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0629 }
            if (r1 == 0) goto L_0x0624
            r0.append(r1)     // Catch:{ all -> 0x0629 }
            goto L_0x061a
        L_0x0624:
            r1 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            goto L_0x0632
        L_0x0629:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x062c }
        L_0x062c:
            r0 = move-exception
            r3 = r0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            throw r3     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
        L_0x0632:
            java.lang.String r0 = r0.toString()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r1 = "connResponseSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r3 = "\nResponse Received: \n%s\n%s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r8 = 0
            r5[r8] = r0     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            int r8 = r7.getResponseCode()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r9 = 1
            r5[r9] = r8     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r1.log(r2, r6, r3, r5)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            int r1 = r7.getResponseCode()     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            r4.invoke(r0, r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            goto L_0x069c
        L_0x0661:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r1)     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
            throw r0     // Catch:{ UnknownHostException -> 0x067e, IOException -> 0x0669 }
        L_0x0669:
            r0 = move-exception
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = r0.toString()
            r5 = 0
            r3[r5] = r0
            java.lang.String r0 = "Send to server failed: \n%s"
            r1.log(r2, r6, r0, r3)
            goto L_0x069c
        L_0x067e:
            r0 = move-exception
            r3 = 1
            r5 = 0
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = r0.toString()
            r3[r5] = r0
            java.lang.String r0 = "Connection failed, retrying: \n%s"
            r1.log(r2, r6, r0, r3)
            r0 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 0
            r4.invoke(r1, r0)
        L_0x069c:
            return
        L_0x069d:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r20)
            throw r1
        L_0x06a2:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x06a7:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x06ac:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x06b1:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x06b6:
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x06bb:
            r6 = r4
            r20 = r7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r20)     // Catch:{ UninitializedPropertyAccessException -> 0x06cb }
            r1 = 0
            throw r1
        L_0x06c3:
            r6 = r4
            r20 = r7
            r1 = 0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r20)     // Catch:{ UninitializedPropertyAccessException -> 0x06cb }
            throw r1
        L_0x06cb:
            r0 = move-exception
            goto L_0x06cf
        L_0x06cd:
            r0 = move-exception
            r6 = r4
        L_0x06cf:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r0
            java.lang.String r0 = "\n Credentials not initialized Error when logging: \n%s"
            r1.log(r2, r6, r0, r3)
            return
        L_0x06df:
            r6 = r4
            r3 = 1
            r4 = 0
            com.facebook.internal.Logger$Companion r0 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r30
            java.lang.String r3 = "\n GraphPathComponents Error when logging: \n%s"
            r0.log(r1, r6, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.m158transformGraphRequestAndSendToCAPIGEndPoint$lambda0(com.facebook.GraphRequest):void");
    }

    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }
}
