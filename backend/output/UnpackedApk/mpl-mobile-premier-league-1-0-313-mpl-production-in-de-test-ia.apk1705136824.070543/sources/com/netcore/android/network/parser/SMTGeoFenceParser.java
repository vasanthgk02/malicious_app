package com.netcore.android.network.parser;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.geofence.b;
import com.netcore.android.geofence.c;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTHttpRequestClient.NetworkResponse;
import com.netcore.android.network.models.SMTGeoFenceResponse;
import com.netcore.android.network.models.SMTGeoFenceResponse.SMTGeoFenceList;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u001e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001a\u0010\nR\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001b\u0010\nR\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/netcore/android/network/parser/SMTGeoFenceParser;", "", "Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "networkResponse", "Lcom/netcore/android/network/models/SMTGeoFenceResponse;", "parse$smartech_release", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTGeoFenceResponse;", "parse", "", "END_TIME", "Ljava/lang/String;", "DWELL_TIME", "GEOFENCE_NAME", "FREQUENCY_TYPE", "GROUP_NAME", "GROUP_ID", "LATITUDE", "DELETED_GROUP_IDS", "GEOFENCE_GROUPS", "FENCE_ID", "GEOFENCES", "kotlin.jvm.PlatformType", "TAG", "CREATED_DATE", "UPDATED_DATE", "RADIUS", "START_TIME", "DELETED_FENCE_IDS", "LONGITUDE", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTGeoFenceParser.kt */
public final class SMTGeoFenceParser {
    public final String CREATED_DATE = "createdDate";
    public final String DELETED_FENCE_IDS = "deletedFenceIds";
    public final String DELETED_GROUP_IDS = "deletedGroupIds";
    public final String DWELL_TIME = "dwellTime";
    public final String END_TIME = "endTime";
    public final String FENCE_ID = "fenceId";
    public final String FREQUENCY_TYPE = "frequencyType";
    public final String GEOFENCES = "geoFences";
    public final String GEOFENCE_GROUPS = "geoFenceGroups";
    public final String GEOFENCE_NAME = "geoFenceName";
    public final String GROUP_ID = "groupId";
    public final String GROUP_NAME = "groupName";
    public final String LATITUDE = "latitude";
    public final String LONGITUDE = "longitude";
    public final String RADIUS = "radius";
    public final String START_TIME = "startTime";
    public final String TAG = SMTGeoFenceParser.class.getSimpleName();
    public final String UPDATED_DATE = "updatedDate";

    public final SMTGeoFenceResponse parse$smartech_release(NetworkResponse networkResponse) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        SMTGeoFenceResponse sMTGeoFenceResponse = new SMTGeoFenceResponse();
        SMTGeoFenceList sMTGeoFenceList = new SMTGeoFenceList();
        try {
            networkResponse.getResponse();
            JSONObject jSONObject = new JSONObject(networkResponse.getResponse());
            JSONArray optJSONArray = jSONObject.optJSONArray(this.GEOFENCE_GROUPS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    String optString = optJSONObject.optString(this.GROUP_NAME);
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonGeoFenceGroup.optString(GROUP_NAME)");
                    cVar.e(optString);
                    String optString2 = optJSONObject.optString(this.GROUP_ID);
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonGeoFenceGroup.optString(GROUP_ID)");
                    cVar.d(optString2);
                    String optString3 = optJSONObject.optString(this.CREATED_DATE);
                    Intrinsics.checkNotNullExpressionValue(optString3, "jsonGeoFenceGroup.optString(CREATED_DATE)");
                    cVar.a(optString3);
                    String optString4 = optJSONObject.optString(this.UPDATED_DATE);
                    Intrinsics.checkNotNullExpressionValue(optString4, "jsonGeoFenceGroup.optString(UPDATED_DATE)");
                    cVar.g(optString4);
                    String optString5 = optJSONObject.optString(this.FREQUENCY_TYPE);
                    Intrinsics.checkNotNullExpressionValue(optString5, "jsonGeoFenceGroup.optString(FREQUENCY_TYPE)");
                    cVar.c(optString5);
                    String optString6 = optJSONObject.optString(this.START_TIME);
                    Intrinsics.checkNotNullExpressionValue(optString6, "jsonGeoFenceGroup.optString(START_TIME)");
                    cVar.f(optString6);
                    String optString7 = optJSONObject.optString(this.END_TIME);
                    Intrinsics.checkNotNullExpressionValue(optString7, "jsonGeoFenceGroup.optString(END_TIME)");
                    cVar.b(optString7);
                    cVar.a(optJSONObject.optInt(this.DWELL_TIME));
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(this.GEOFENCES);
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        b bVar = new b();
                        String optString8 = optJSONObject2.optString(this.FENCE_ID);
                        Intrinsics.checkNotNullExpressionValue(optString8, "jsonGeoFence.optString(FENCE_ID)");
                        bVar.b(optString8);
                        String optString9 = optJSONObject2.optString(this.GEOFENCE_NAME);
                        Intrinsics.checkNotNullExpressionValue(optString9, "jsonGeoFence.optString(GEOFENCE_NAME)");
                        bVar.c(optString9);
                        String optString10 = optJSONObject2.optString(this.LATITUDE);
                        Intrinsics.checkNotNullExpressionValue(optString10, "jsonGeoFence.optString(LATITUDE)");
                        bVar.e(optString10);
                        String optString11 = optJSONObject2.optString(this.LONGITUDE);
                        Intrinsics.checkNotNullExpressionValue(optString11, "jsonGeoFence.optString(LONGITUDE)");
                        bVar.f(optString11);
                        String optString12 = optJSONObject2.optString(this.RADIUS);
                        Intrinsics.checkNotNullExpressionValue(optString12, "jsonGeoFence.optString(RADIUS)");
                        bVar.g(optString12);
                        String optString13 = optJSONObject2.optString(this.CREATED_DATE);
                        Intrinsics.checkNotNullExpressionValue(optString13, "jsonGeoFence.optString(CREATED_DATE)");
                        bVar.a(optString13);
                        String optString14 = optJSONObject2.optString(this.UPDATED_DATE);
                        Intrinsics.checkNotNullExpressionValue(optString14, "jsonGeoFence.optString(UPDATED_DATE)");
                        bVar.h(optString14);
                        cVar.e().add(bVar);
                    }
                    sMTGeoFenceList.getGeoFenceGroups().add(cVar);
                }
            }
            if (jSONObject.optJSONArray(this.DELETED_FENCE_IDS) != null) {
                jSONArray = jSONObject.optJSONArray(this.DELETED_FENCE_IDS);
            } else {
                jSONArray = new JSONArray();
            }
            int length3 = jSONArray.length();
            for (int i3 = 0; i3 < length3; i3++) {
                sMTGeoFenceList.getDeletedFenceIds().add(jSONArray.optString(i3));
            }
            if (jSONObject.optJSONArray(this.DELETED_GROUP_IDS) != null) {
                jSONArray2 = jSONObject.optJSONArray(this.DELETED_GROUP_IDS);
            } else {
                jSONArray2 = new JSONArray();
            }
            int length4 = jSONArray2.length();
            for (int i4 = 0; i4 < length4; i4++) {
                sMTGeoFenceList.getDeletedGroupIds().add(jSONArray2.optString(i4));
            }
            sMTGeoFenceResponse.setGeoFenceList(sMTGeoFenceList);
        } catch (Exception e2) {
            e2.printStackTrace();
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.TAG;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("geoFenceResponse: ");
        SMTGeoFenceList geoFenceList = sMTGeoFenceResponse.getGeoFenceList();
        outline73.append(geoFenceList != null ? geoFenceList.getGeoFenceGroups() : null);
        outline73.toString();
        return sMTGeoFenceResponse;
    }
}
