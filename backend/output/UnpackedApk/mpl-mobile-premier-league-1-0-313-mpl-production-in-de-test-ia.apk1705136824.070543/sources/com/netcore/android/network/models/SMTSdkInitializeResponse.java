package com.netcore.android.network.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.inapp.h.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R6\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse;", "Lcom/netcore/android/network/models/SMTResponse;", "Ljava/util/ArrayList;", "Lcom/netcore/android/inapp/h/b;", "Lkotlin/collections/ArrayList;", "inAppRules", "Ljava/util/ArrayList;", "getInAppRules", "()Ljava/util/ArrayList;", "setInAppRules", "(Ljava/util/ArrayList;)V", "", "isListAndSegmentPresent", "Z", "()Z", "setListAndSegmentPresent", "(Z)V", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;", "smartechSettings", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;", "getSmartechSettings", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;", "setSmartechSettings", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;)V", "<init>", "()V", "SmartTechSettings", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTSdkInitializeResponse.kt */
public final class SMTSdkInitializeResponse extends SMTResponse {
    public ArrayList<b> inAppRules;
    public boolean isListAndSegmentPresent;
    public SmartTechSettings smartechSettings;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0005^_`abB\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\"\u0010#\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\"\u0010)\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\"\u0010,\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0019\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001dR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000f\u001a\u0004\bO\u0010\u0011\"\u0004\bP\u0010\u0013R$\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u0004\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bV\u0010\u000f\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\"\u0010Y\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bY\u0010\u000f\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013¨\u0006c"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings;", "", "", "toString", "()Ljava/lang/String;", "toLimitString", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings;", "smartechInAppFrequencySettings", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings;", "getSmartechInAppFrequencySettings", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings;", "setSmartechInAppFrequencySettings", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings;)V", "", "batchInterval", "I", "getBatchInterval", "()I", "setBatchInterval", "(I)V", "batchSize", "getBatchSize", "setBatchSize", "", "sdkActive", "Z", "getSdkActive", "()Z", "setSdkActive", "(Z)V", "sessionInterval", "getSessionInterval", "setSessionInterval", "isAppInboxEnabled", "setAppInboxEnabled", "fetchLocation", "getFetchLocation", "setFetchLocation", "messageCachePeriod", "getMessageCachePeriod", "setMessageCachePeriod", "eventLimit", "getEventLimit", "setEventLimit", "panelActive", "getPanelActive", "setPanelActive", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel;", "debuglevel", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel;", "getDebuglevel", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel;", "setDebuglevel", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel;)V", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL;", "smartechURL", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL;", "getSmartechURL", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL;", "setSmartechURL", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL;)V", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings;", "smartechGeoFenceSettings", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings;", "getSmartechGeoFenceSettings", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings;", "setSmartechGeoFenceSettings", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings;)V", "paEnabled", "getPaEnabled", "setPaEnabled", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings;", "smartechEventSettings", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings;", "getSmartechEventSettings", "()Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings;", "setSmartechEventSettings", "(Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings;)V", "mediaCachingSize", "getMediaCachingSize", "setMediaCachingSize", "baseUrl", "Ljava/lang/String;", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "tokenInterval", "getTokenInterval", "setTokenInterval", "paInterval", "getPaInterval", "setPaInterval", "<init>", "()V", "SmartTechBaseURL", "SmartTechDebugLevel", "SmartechEventSettings", "SmartechGeoFenceSettings", "SmartechInAppFrequencySettings", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTSdkInitializeResponse.kt */
    public static final class SmartTechSettings {
        public String baseUrl;
        public int batchInterval = 30;
        public int batchSize = 5;
        public SmartTechDebugLevel debuglevel;
        public int eventLimit = 200;
        public boolean fetchLocation = true;
        public boolean isAppInboxEnabled;
        public int mediaCachingSize = 50;
        public int messageCachePeriod = 7;
        public boolean paEnabled = true;
        public int paInterval = 15;
        public boolean panelActive;
        public boolean sdkActive;
        public int sessionInterval = 30;
        public SmartechEventSettings smartechEventSettings;
        public SmartechGeoFenceSettings smartechGeoFenceSettings;
        public SmartechInAppFrequencySettings smartechInAppFrequencySettings;
        public SmartTechBaseURL smartechURL;
        public int tokenInterval = 60;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\tR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL;", "", "", "toString", "()Ljava/lang/String;", "inboxUrl", "Ljava/lang/String;", "getInboxUrl", "setInboxUrl", "(Ljava/lang/String;)V", "trackAppActUrl", "getTrackAppActUrl", "setTrackAppActUrl", "inAppUrl", "getInAppUrl", "setInAppUrl", "inAppListSegUrl", "getInAppListSegUrl", "setInAppListSegUrl", "pushAmpUrl", "getPushAmpUrl", "setPushAmpUrl", "geoFenceUrl", "getGeoFenceUrl", "setGeoFenceUrl", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: SMTSdkInitializeResponse.kt */
        public static final class SmartTechBaseURL {
            public String geoFenceUrl = "";
            public String inAppListSegUrl = "";
            public String inAppUrl = "";
            public String inboxUrl = "";
            public String pushAmpUrl = "";
            public String trackAppActUrl = "";

            public final String getGeoFenceUrl() {
                return this.geoFenceUrl;
            }

            public final String getInAppListSegUrl() {
                return this.inAppListSegUrl;
            }

            public final String getInAppUrl() {
                return this.inAppUrl;
            }

            public final String getInboxUrl() {
                return this.inboxUrl;
            }

            public final String getPushAmpUrl() {
                return this.pushAmpUrl;
            }

            public final String getTrackAppActUrl() {
                return this.trackAppActUrl;
            }

            public final void setGeoFenceUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.geoFenceUrl = str;
            }

            public final void setInAppListSegUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.inAppListSegUrl = str;
            }

            public final void setInAppUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.inAppUrl = str;
            }

            public final void setInboxUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.inboxUrl = str;
            }

            public final void setPushAmpUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.pushAmpUrl = str;
            }

            public final void setTrackAppActUrl(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.trackAppActUrl = str;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("SmartTechBaseURL(trackAppActUrl='");
                outline73.append(this.trackAppActUrl);
                outline73.append("', pushAmpUrl='");
                outline73.append(this.pushAmpUrl);
                outline73.append("', inAppUrl='");
                outline73.append(this.inAppUrl);
                outline73.append("', inAppListSegUrl='");
                outline73.append(this.inAppListSegUrl);
                outline73.append("', inboxUrl='");
                outline73.append(this.inboxUrl);
                outline73.append("', geoFenceUrl='");
                return GeneratedOutlineSupport.outline62(outline73, this.geoFenceUrl, "')");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartTechDebugLevel;", "", "", "toString", "()Ljava/lang/String;", "Lorg/json/JSONArray;", "guids", "Lorg/json/JSONArray;", "getGuids", "()Lorg/json/JSONArray;", "setGuids", "(Lorg/json/JSONArray;)V", "", "logLevel", "I", "getLogLevel", "()I", "setLogLevel", "(I)V", "", "logEnabled", "Z", "getLogEnabled", "()Z", "setLogEnabled", "(Z)V", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: SMTSdkInitializeResponse.kt */
        public static final class SmartTechDebugLevel {
            public JSONArray guids = new JSONArray();
            public boolean logEnabled;
            public int logLevel;

            public final JSONArray getGuids() {
                return this.guids;
            }

            public final boolean getLogEnabled() {
                return this.logEnabled;
            }

            public final int getLogLevel() {
                return this.logLevel;
            }

            public final void setGuids(JSONArray jSONArray) {
                Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
                this.guids = jSONArray;
            }

            public final void setLogEnabled(boolean z) {
                this.logEnabled = z;
            }

            public final void setLogLevel(int i) {
                this.logLevel = i;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("SmartTechDebugLevel(logEnabled=");
                outline73.append(this.logEnabled);
                outline73.append(", logLevel=");
                outline73.append(this.logLevel);
                outline73.append(", guids=");
                outline73.append(this.guids);
                outline73.append(')');
                return outline73.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings;", "", "", "push", "Z", "getPush", "()Z", "setPush", "(Z)V", "allevents", "getAllevents", "setAllevents", "appinbox", "getAppinbox", "setAppinbox", "lifecycle", "getLifecycle", "setLifecycle", "inapp", "getInapp", "setInapp", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: SMTSdkInitializeResponse.kt */
        public static final class SmartechEventSettings {
            public boolean allevents = true;
            public boolean appinbox = true;
            public boolean inapp = true;
            public boolean lifecycle = true;
            public boolean push = true;

            public final boolean getAllevents() {
                return this.allevents;
            }

            public final boolean getAppinbox() {
                return this.appinbox;
            }

            public final boolean getInapp() {
                return this.inapp;
            }

            public final boolean getLifecycle() {
                return this.lifecycle;
            }

            public final boolean getPush() {
                return this.push;
            }

            public final void setAllevents(boolean z) {
                this.allevents = z;
            }

            public final void setAppinbox(boolean z) {
                this.appinbox = z;
            }

            public final void setInapp(boolean z) {
                this.inapp = z;
            }

            public final void setLifecycle(boolean z) {
                this.lifecycle = z;
            }

            public final void setPush(boolean z) {
                this.push = z;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\tR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings;", "", "", "toString", "()Ljava/lang/String;", "serverRefreshGeoFenceDistanceConfig", "Ljava/lang/String;", "getServerRefreshGeoFenceDistanceConfig", "setServerRefreshGeoFenceDistanceConfig", "(Ljava/lang/String;)V", "", "geoFenceDistance", "I", "getGeoFenceDistance", "()I", "setGeoFenceDistance", "(I)V", "", "geoFenceEnabled", "Z", "getGeoFenceEnabled", "()Z", "setGeoFenceEnabled", "(Z)V", "appRefreshGeoFenceDistanceConfig", "getAppRefreshGeoFenceDistanceConfig", "setAppRefreshGeoFenceDistanceConfig", "", "geoFenceLastModified", "J", "getGeoFenceLastModified", "()J", "setGeoFenceLastModified", "(J)V", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: SMTSdkInitializeResponse.kt */
        public static final class SmartechGeoFenceSettings {
            public String appRefreshGeoFenceDistanceConfig = "";
            public int geoFenceDistance = 50;
            public boolean geoFenceEnabled;
            public long geoFenceLastModified;
            public String serverRefreshGeoFenceDistanceConfig = "";

            public final String getAppRefreshGeoFenceDistanceConfig() {
                return this.appRefreshGeoFenceDistanceConfig;
            }

            public final int getGeoFenceDistance() {
                return this.geoFenceDistance;
            }

            public final boolean getGeoFenceEnabled() {
                return this.geoFenceEnabled;
            }

            public final long getGeoFenceLastModified() {
                return this.geoFenceLastModified;
            }

            public final String getServerRefreshGeoFenceDistanceConfig() {
                return this.serverRefreshGeoFenceDistanceConfig;
            }

            public final void setAppRefreshGeoFenceDistanceConfig(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.appRefreshGeoFenceDistanceConfig = str;
            }

            public final void setGeoFenceDistance(int i) {
                this.geoFenceDistance = i;
            }

            public final void setGeoFenceEnabled(boolean z) {
                this.geoFenceEnabled = z;
            }

            public final void setGeoFenceLastModified(long j) {
                this.geoFenceLastModified = j;
            }

            public final void setServerRefreshGeoFenceDistanceConfig(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.serverRefreshGeoFenceDistanceConfig = str;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("SmartTechBaseURL(geoFenceEnabled='");
                outline73.append(this.geoFenceEnabled);
                outline73.append("', geoFenceDistance='");
                outline73.append(this.geoFenceDistance);
                outline73.append("', geoFenceLastModified='");
                return GeneratedOutlineSupport.outline58(outline73, this.geoFenceLastModified, "')");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/netcore/android/network/models/SMTSdkInitializeResponse$SmartTechSettings$SmartechInAppFrequencySettings;", "", "", "day", "I", "getDay", "()I", "setDay", "(I)V", "week", "getWeek", "setWeek", "enable", "getEnable", "setEnable", "month", "getMonth", "setMonth", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: SMTSdkInitializeResponse.kt */
        public static final class SmartechInAppFrequencySettings {
            public int day;
            public int enable;
            public int month;
            public int week;

            public final int getDay() {
                return this.day;
            }

            public final int getEnable() {
                return this.enable;
            }

            public final int getMonth() {
                return this.month;
            }

            public final int getWeek() {
                return this.week;
            }

            public final void setDay(int i) {
                this.day = i;
            }

            public final void setEnable(int i) {
                this.enable = i;
            }

            public final void setMonth(int i) {
                this.month = i;
            }

            public final void setWeek(int i) {
                this.week = i;
            }
        }

        public final String getBaseUrl() {
            return this.baseUrl;
        }

        public final int getBatchInterval() {
            return this.batchInterval;
        }

        public final int getBatchSize() {
            return this.batchSize;
        }

        public final SmartTechDebugLevel getDebuglevel() {
            return this.debuglevel;
        }

        public final int getEventLimit() {
            return this.eventLimit;
        }

        public final boolean getFetchLocation() {
            return this.fetchLocation;
        }

        public final int getMediaCachingSize() {
            return this.mediaCachingSize;
        }

        public final int getMessageCachePeriod() {
            return this.messageCachePeriod;
        }

        public final boolean getPaEnabled() {
            return this.paEnabled;
        }

        public final int getPaInterval() {
            return this.paInterval;
        }

        public final boolean getPanelActive() {
            return this.panelActive;
        }

        public final boolean getSdkActive() {
            return this.sdkActive;
        }

        public final int getSessionInterval() {
            return this.sessionInterval;
        }

        public final SmartechEventSettings getSmartechEventSettings() {
            return this.smartechEventSettings;
        }

        public final SmartechGeoFenceSettings getSmartechGeoFenceSettings() {
            return this.smartechGeoFenceSettings;
        }

        public final SmartechInAppFrequencySettings getSmartechInAppFrequencySettings() {
            return this.smartechInAppFrequencySettings;
        }

        public final SmartTechBaseURL getSmartechURL() {
            return this.smartechURL;
        }

        public final int getTokenInterval() {
            return this.tokenInterval;
        }

        public final boolean isAppInboxEnabled() {
            return this.isAppInboxEnabled;
        }

        public final void setAppInboxEnabled(boolean z) {
            this.isAppInboxEnabled = z;
        }

        public final void setBaseUrl(String str) {
            this.baseUrl = str;
        }

        public final void setBatchInterval(int i) {
            this.batchInterval = i;
        }

        public final void setBatchSize(int i) {
            this.batchSize = i;
        }

        public final void setDebuglevel(SmartTechDebugLevel smartTechDebugLevel) {
            this.debuglevel = smartTechDebugLevel;
        }

        public final void setEventLimit(int i) {
            this.eventLimit = i;
        }

        public final void setFetchLocation(boolean z) {
            this.fetchLocation = z;
        }

        public final void setMediaCachingSize(int i) {
            this.mediaCachingSize = i;
        }

        public final void setMessageCachePeriod(int i) {
            this.messageCachePeriod = i;
        }

        public final void setPaEnabled(boolean z) {
            this.paEnabled = z;
        }

        public final void setPaInterval(int i) {
            this.paInterval = i;
        }

        public final void setPanelActive(boolean z) {
            this.panelActive = z;
        }

        public final void setSdkActive(boolean z) {
            this.sdkActive = z;
        }

        public final void setSessionInterval(int i) {
            this.sessionInterval = i;
        }

        public final void setSmartechEventSettings(SmartechEventSettings smartechEventSettings2) {
            this.smartechEventSettings = smartechEventSettings2;
        }

        public final void setSmartechGeoFenceSettings(SmartechGeoFenceSettings smartechGeoFenceSettings2) {
            this.smartechGeoFenceSettings = smartechGeoFenceSettings2;
        }

        public final void setSmartechInAppFrequencySettings(SmartechInAppFrequencySettings smartechInAppFrequencySettings2) {
            this.smartechInAppFrequencySettings = smartechInAppFrequencySettings2;
        }

        public final void setSmartechURL(SmartTechBaseURL smartTechBaseURL) {
            this.smartechURL = smartTechBaseURL;
        }

        public final void setTokenInterval(int i) {
            this.tokenInterval = i;
        }

        public final String toLimitString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SmartTechSettings(batchInterval=");
            outline73.append(this.batchInterval);
            outline73.append(", batchSize=");
            outline73.append(this.batchSize);
            outline73.append(", fetchLocation=");
            outline73.append(this.fetchLocation);
            outline73.append(", paEnabled=");
            outline73.append(this.paEnabled);
            outline73.append(", paInterval=");
            outline73.append(this.paInterval);
            outline73.append(", panelActive=");
            outline73.append(this.panelActive);
            outline73.append(", sdkActive=");
            outline73.append(this.sdkActive);
            outline73.append(", sessionInterval=");
            return GeneratedOutlineSupport.outline56(outline73, this.sessionInterval, ')');
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SmartTechSettings(batchInterval=");
            outline73.append(this.batchInterval);
            outline73.append(", batchSize=");
            outline73.append(this.batchSize);
            outline73.append(", fetchLocation=");
            outline73.append(this.fetchLocation);
            outline73.append(", paEnabled=");
            outline73.append(this.paEnabled);
            outline73.append(", paInterval=");
            outline73.append(this.paInterval);
            outline73.append(", panelActive=");
            outline73.append(this.panelActive);
            outline73.append(", sdkActive=");
            outline73.append(this.sdkActive);
            outline73.append(", sessionInterval=");
            outline73.append(this.sessionInterval);
            outline73.append(", baseUrl=");
            outline73.append(this.baseUrl);
            outline73.append(", smartechURL=");
            outline73.append(this.smartechURL);
            outline73.append(", debuglevel=");
            outline73.append(this.debuglevel);
            outline73.append(')');
            return outline73.toString();
        }
    }

    public final ArrayList<b> getInAppRules() {
        return this.inAppRules;
    }

    public final SmartTechSettings getSmartechSettings() {
        return this.smartechSettings;
    }

    public final boolean isListAndSegmentPresent() {
        return this.isListAndSegmentPresent;
    }

    public final void setInAppRules(ArrayList<b> arrayList) {
        this.inAppRules = arrayList;
    }

    public final void setListAndSegmentPresent(boolean z) {
        this.isListAndSegmentPresent = z;
    }

    public final void setSmartechSettings(SmartTechSettings smartTechSettings) {
        this.smartechSettings = smartTechSettings;
    }
}
