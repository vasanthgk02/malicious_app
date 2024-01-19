package com.inbrain.sdk.model;

import android.text.TextUtils;
import android.util.JsonWriter;
import com.mpl.androidapp.config.ConfigConstant;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Configuration {
    public final String appUserId;
    public final String clientId;
    public final String clientSecret;
    public final HashMap<String, String> dataPoints;
    public final String deviceId;
    public final String language;
    public final String placeId;
    public final String sessionUid;
    public final String surveyId;

    public Configuration(String str, String str2, String str3, String str4, String str5, String str6, String str7, HashMap<String, String> hashMap, String str8) {
        this.clientId = str;
        this.clientSecret = str2;
        this.appUserId = str3;
        this.deviceId = str4;
        this.surveyId = str5;
        this.placeId = str6;
        this.sessionUid = str7;
        this.dataPoints = hashMap;
        this.language = str8;
    }

    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        jsonWriter.beginObject();
        jsonWriter.name(PaymentConstants.CLIENT_ID).value(this.clientId);
        jsonWriter.name("client_secret").value(this.clientSecret);
        jsonWriter.name("app_uid").value(this.appUserId);
        jsonWriter.name(ConfigConstant.DEVICE_ID).value(this.deviceId);
        if (!TextUtils.isEmpty(this.surveyId)) {
            jsonWriter.name("survey_id").value(this.surveyId);
        }
        if (!TextUtils.isEmpty(this.placeId)) {
            jsonWriter.name("placement_id").value(this.placeId);
        }
        if (!TextUtils.isEmpty(this.sessionUid)) {
            jsonWriter.name("session_uid").value(this.sessionUid);
        }
        if (this.dataPoints != null) {
            jsonWriter.name("data_points").beginArray();
            for (Entry next : this.dataPoints.entrySet()) {
                jsonWriter.beginObject();
                jsonWriter.name((String) next.getKey()).value((String) next.getValue());
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
        }
        if (!TextUtils.isEmpty(this.language)) {
            jsonWriter.name("language").value(this.language);
        }
        jsonWriter.endObject();
        jsonWriter.close();
        return stringWriter.toString();
    }
}
