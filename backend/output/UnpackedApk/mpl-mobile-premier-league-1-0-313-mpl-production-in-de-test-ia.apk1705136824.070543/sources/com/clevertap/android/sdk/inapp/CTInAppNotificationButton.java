package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CTInAppNotificationButton implements Parcelable {
    public static final Creator<CTInAppNotificationButton> CREATOR = new Creator<CTInAppNotificationButton>() {
        public Object createFromParcel(Parcel parcel) {
            return new CTInAppNotificationButton(parcel);
        }

        public Object[] newArray(int i) {
            return new CTInAppNotificationButton[i];
        }
    };
    public String actionUrl;
    public String backgroundColor;
    public String borderColor;
    public String borderRadius;
    public String error;
    public JSONObject jsonDescription;
    public HashMap<String, String> keyValues;
    public String text;
    public String textColor;

    public CTInAppNotificationButton() {
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009a A[Catch:{ JSONException -> 0x00cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.clevertap.android.sdk.inapp.CTInAppNotificationButton initWithJSON(org.json.JSONObject r10) {
        /*
            r9 = this;
            java.lang.String r0 = "android"
            java.lang.String r1 = "actions"
            java.lang.String r2 = "radius"
            java.lang.String r3 = "border"
            java.lang.String r4 = "bg"
            java.lang.String r5 = "color"
            java.lang.String r6 = "text"
            r9.jsonDescription = r10     // Catch:{ JSONException -> 0x00cd }
            boolean r7 = r10.has(r6)     // Catch:{ JSONException -> 0x00cd }
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x001d
            java.lang.String r6 = r10.getString(r6)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x001e
        L_0x001d:
            r6 = r8
        L_0x001e:
            r9.text = r6     // Catch:{ JSONException -> 0x00cd }
            boolean r6 = r10.has(r5)     // Catch:{ JSONException -> 0x00cd }
            if (r6 == 0) goto L_0x002b
            java.lang.String r5 = r10.getString(r5)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x002d
        L_0x002b:
            java.lang.String r5 = "#0000FF"
        L_0x002d:
            r9.textColor = r5     // Catch:{ JSONException -> 0x00cd }
            boolean r5 = r10.has(r4)     // Catch:{ JSONException -> 0x00cd }
            java.lang.String r6 = "#FFFFFF"
            if (r5 == 0) goto L_0x003c
            java.lang.String r4 = r10.getString(r4)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x003d
        L_0x003c:
            r4 = r6
        L_0x003d:
            r9.backgroundColor = r4     // Catch:{ JSONException -> 0x00cd }
            boolean r4 = r10.has(r3)     // Catch:{ JSONException -> 0x00cd }
            if (r4 == 0) goto L_0x0049
            java.lang.String r6 = r10.getString(r3)     // Catch:{ JSONException -> 0x00cd }
        L_0x0049:
            r9.borderColor = r6     // Catch:{ JSONException -> 0x00cd }
            boolean r3 = r10.has(r2)     // Catch:{ JSONException -> 0x00cd }
            if (r3 == 0) goto L_0x0056
            java.lang.String r2 = r10.getString(r2)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x0057
        L_0x0056:
            r2 = r8
        L_0x0057:
            r9.borderRadius = r2     // Catch:{ JSONException -> 0x00cd }
            boolean r2 = r10.has(r1)     // Catch:{ JSONException -> 0x00cd }
            if (r2 == 0) goto L_0x0064
            org.json.JSONObject r10 = r10.getJSONObject(r1)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x0065
        L_0x0064:
            r10 = 0
        L_0x0065:
            if (r10 == 0) goto L_0x0079
            boolean r1 = r10.has(r0)     // Catch:{ JSONException -> 0x00cd }
            if (r1 == 0) goto L_0x0071
            java.lang.String r8 = r10.getString(r0)     // Catch:{ JSONException -> 0x00cd }
        L_0x0071:
            boolean r0 = r8.isEmpty()     // Catch:{ JSONException -> 0x00cd }
            if (r0 != 0) goto L_0x0079
            r9.actionUrl = r8     // Catch:{ JSONException -> 0x00cd }
        L_0x0079:
            java.lang.String r0 = "kv"
            if (r10 == 0) goto L_0x0097
            java.lang.String r1 = "type"
            boolean r2 = r10.has(r1)     // Catch:{ JSONException -> 0x00cd }
            if (r2 == 0) goto L_0x0097
            java.lang.String r1 = r10.getString(r1)     // Catch:{ JSONException -> 0x00cd }
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x00cd }
            if (r1 == 0) goto L_0x0097
            boolean r1 = r10.has(r0)     // Catch:{ JSONException -> 0x00cd }
            if (r1 == 0) goto L_0x0097
            r1 = 1
            goto L_0x0098
        L_0x0097:
            r1 = 0
        L_0x0098:
            if (r1 == 0) goto L_0x00d1
            org.json.JSONObject r10 = r10.getJSONObject(r0)     // Catch:{ JSONException -> 0x00cd }
            if (r10 == 0) goto L_0x00d1
            java.util.Iterator r0 = r10.keys()     // Catch:{ JSONException -> 0x00cd }
            if (r0 == 0) goto L_0x00d1
        L_0x00a6:
            boolean r1 = r0.hasNext()     // Catch:{ JSONException -> 0x00cd }
            if (r1 == 0) goto L_0x00d1
            java.lang.Object r1 = r0.next()     // Catch:{ JSONException -> 0x00cd }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x00cd }
            java.lang.String r2 = r10.getString(r1)     // Catch:{ JSONException -> 0x00cd }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00cd }
            if (r3 != 0) goto L_0x00a6
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.keyValues     // Catch:{ JSONException -> 0x00cd }
            if (r3 != 0) goto L_0x00c7
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ JSONException -> 0x00cd }
            r3.<init>()     // Catch:{ JSONException -> 0x00cd }
            r9.keyValues = r3     // Catch:{ JSONException -> 0x00cd }
        L_0x00c7:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r9.keyValues     // Catch:{ JSONException -> 0x00cd }
            r3.put(r1, r2)     // Catch:{ JSONException -> 0x00cd }
            goto L_0x00a6
        L_0x00cd:
            java.lang.String r10 = "Invalid JSON"
            r9.error = r10
        L_0x00d1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotificationButton.initWithJSON(org.json.JSONObject):com.clevertap.android.sdk.inapp.CTInAppNotificationButton");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeString(this.textColor);
        parcel.writeString(this.backgroundColor);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.borderColor);
        parcel.writeString(this.borderRadius);
        if (this.jsonDescription == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.jsonDescription.toString());
        }
        parcel.writeString(this.error);
        parcel.writeMap(this.keyValues);
    }

    public CTInAppNotificationButton(Parcel parcel) {
        this.text = parcel.readString();
        this.textColor = parcel.readString();
        this.backgroundColor = parcel.readString();
        this.actionUrl = parcel.readString();
        this.borderColor = parcel.readString();
        this.borderRadius = parcel.readString();
        try {
            this.jsonDescription = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.error = parcel.readString();
        this.keyValues = parcel.readHashMap(null);
    }
}
