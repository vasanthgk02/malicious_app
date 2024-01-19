package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTInboxMessage implements Parcelable {
    public static final Creator<CTInboxMessage> CREATOR = new Creator<CTInboxMessage>() {
        public Object createFromParcel(Parcel parcel) {
            return new CTInboxMessage(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CTInboxMessage[i];
        }
    };
    public String actionUrl;
    public String bgColor;
    public String body;
    public String campaignId;
    public JSONObject customData;
    public JSONObject data;
    public long date;
    public long expires;
    public String imageUrl;
    public ArrayList<CTInboxMessageContent> inboxMessageContents = new ArrayList<>();
    public boolean isRead;
    public String messageId;
    public String orientation;
    public List<String> tags = new ArrayList();
    public String title;
    public CTInboxMessageType type;
    public JSONObject wzrkParams;

    public CTInboxMessage(JSONObject jSONObject) {
        long j;
        long j2;
        this.data = jSONObject;
        try {
            this.messageId = jSONObject.has("id") ? jSONObject.getString("id") : "0";
            this.campaignId = jSONObject.has("wzrk_id") ? jSONObject.getString("wzrk_id") : "0_0";
            if (jSONObject.has(DatePickerDialogModule.ARG_DATE)) {
                j = jSONObject.getLong(DatePickerDialogModule.ARG_DATE);
            } else {
                j = System.currentTimeMillis() / 1000;
            }
            this.date = j;
            if (jSONObject.has("wzrk_ttl")) {
                j2 = jSONObject.getLong("wzrk_ttl");
            } else {
                j2 = System.currentTimeMillis() + 86400000;
            }
            this.expires = j2;
            this.isRead = jSONObject.has("isRead") && jSONObject.getBoolean("isRead");
            Logger.d("CTInboxMessage:constructor called at  " + new Date() + " | setting inbox isread= " + this.isRead + " for id:" + this.messageId);
            JSONObject jSONObject2 = null;
            JSONArray jSONArray = jSONObject.has("tags") ? jSONObject.getJSONArray("tags") : null;
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.tags.add(jSONArray.getString(i));
                }
            }
            JSONObject jSONObject3 = jSONObject.has("msg") ? jSONObject.getJSONObject("msg") : null;
            if (jSONObject3 != null) {
                String str = "";
                this.type = jSONObject3.has("type") ? CTInboxMessageType.fromString(jSONObject3.getString("type")) : CTInboxMessageType.fromString(str);
                this.bgColor = jSONObject3.has("bg") ? jSONObject3.getString("bg") : str;
                JSONArray jSONArray2 = jSONObject3.has("content") ? jSONObject3.getJSONArray("content") : null;
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        CTInboxMessageContent cTInboxMessageContent = new CTInboxMessageContent();
                        cTInboxMessageContent.initWithJSON(jSONArray2.getJSONObject(i2));
                        this.inboxMessageContents.add(cTInboxMessageContent);
                    }
                }
                this.orientation = jSONObject3.has("orientation") ? jSONObject3.getString("orientation") : str;
            }
            this.wzrkParams = jSONObject.has("wzrkParams") ? jSONObject.getJSONObject("wzrkParams") : jSONObject2;
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to init CTInboxMessage with JSON - "));
        }
    }

    public int describeContents() {
        return 0;
    }

    public JSONObject getWzrkParams() {
        JSONObject jSONObject = this.wzrkParams;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.actionUrl);
        parcel.writeLong(this.date);
        parcel.writeLong(this.expires);
        parcel.writeString(this.messageId);
        if (this.data == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.data.toString());
        }
        if (this.customData == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.customData.toString());
        }
        parcel.writeByte(this.isRead ? (byte) 1 : 0);
        parcel.writeValue(this.type);
        if (this.tags == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeList(this.tags);
        }
        parcel.writeString(this.bgColor);
        if (this.inboxMessageContents == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeList(this.inboxMessageContents);
        }
        parcel.writeString(this.orientation);
        parcel.writeString(this.campaignId);
        if (this.wzrkParams == null) {
            parcel.writeByte(0);
            return;
        }
        parcel.writeByte(1);
        parcel.writeString(this.wzrkParams.toString());
    }

    public CTInboxMessage(Parcel parcel, AnonymousClass1 r5) {
        try {
            this.title = parcel.readString();
            this.body = parcel.readString();
            this.imageUrl = parcel.readString();
            this.actionUrl = parcel.readString();
            this.date = parcel.readLong();
            this.expires = parcel.readLong();
            this.messageId = parcel.readString();
            JSONObject jSONObject = null;
            this.data = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this.customData = parcel.readByte() == 0 ? null : new JSONObject(parcel.readString());
            this.isRead = parcel.readByte() != 0;
            this.type = (CTInboxMessageType) parcel.readValue(CTInboxMessageType.class.getClassLoader());
            if (parcel.readByte() == 1) {
                ArrayList arrayList = new ArrayList();
                this.tags = arrayList;
                parcel.readList(arrayList, String.class.getClassLoader());
            } else {
                this.tags = null;
            }
            this.bgColor = parcel.readString();
            if (parcel.readByte() == 1) {
                ArrayList<CTInboxMessageContent> arrayList2 = new ArrayList<>();
                this.inboxMessageContents = arrayList2;
                parcel.readList(arrayList2, CTInboxMessageContent.class.getClassLoader());
            } else {
                this.inboxMessageContents = null;
            }
            this.orientation = parcel.readString();
            this.campaignId = parcel.readString();
            if (parcel.readByte() != 0) {
                jSONObject = new JSONObject(parcel.readString());
            }
            this.wzrkParams = jSONObject;
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to parse CTInboxMessage from parcel - "));
        }
    }
}
