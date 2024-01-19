package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTInboxMessageContent implements Parcelable {
    public static final Creator<CTInboxMessageContent> CREATOR = new Creator<CTInboxMessageContent>() {
        public Object createFromParcel(Parcel parcel) {
            return new CTInboxMessageContent(parcel);
        }

        public Object[] newArray(int i) {
            return new CTInboxMessageContent[i];
        }
    };
    public String actionUrl;
    public String contentType;
    public Boolean hasLinks;
    public Boolean hasUrl;
    public String icon;
    public JSONArray links;
    public String media;
    public String message;
    public String messageColor;
    public String posterUrl;
    public String title;
    public String titleColor;

    public CTInboxMessageContent() {
    }

    public int describeContents() {
        return 0;
    }

    public String getLinkBGColor(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("bg") ? jSONObject.getString("bg") : "";
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to get Link Text Color with JSON - "));
            return null;
        }
    }

    public String getLinkColor(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("color") ? jSONObject.getString("color") : "";
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to get Link Text Color with JSON - "));
            return null;
        }
    }

    public String getLinkText(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("text") ? jSONObject.getString("text") : "";
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to get Link Text with JSON - "));
            return null;
        }
    }

    public String getLinkUrl(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("url") ? jSONObject.getJSONObject("url") : null;
            if (jSONObject2 == null) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.has("android") ? jSONObject2.getJSONObject("android") : null;
            return (jSONObject3 == null || !jSONObject3.has("text")) ? "" : jSONObject3.getString("text");
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to get Link URL with JSON - "));
            return null;
        }
    }

    public String getLinktype(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("type") ? jSONObject.getString("type") : "";
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to get Link Type with JSON - "));
            return null;
        }
    }

    public CTInboxMessageContent initWithJSON(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.has("title") ? jSONObject2.getJSONObject("title") : null;
            String str2 = "";
            if (jSONObject3 != null) {
                if (jSONObject3.has("text")) {
                    str = str2;
                    str2 = jSONObject3.getString("text");
                } else {
                    str = str2;
                }
                this.title = str2;
                this.titleColor = jSONObject3.has("color") ? jSONObject3.getString("color") : str;
            } else {
                str = str2;
            }
            JSONObject jSONObject4 = jSONObject2.has("message") ? jSONObject2.getJSONObject("message") : null;
            if (jSONObject4 != null) {
                this.message = jSONObject4.has("text") ? jSONObject4.getString("text") : str;
                this.messageColor = jSONObject4.has("color") ? jSONObject4.getString("color") : str;
            }
            JSONObject jSONObject5 = jSONObject2.has("icon") ? jSONObject2.getJSONObject("icon") : null;
            if (jSONObject5 != null) {
                this.icon = jSONObject5.has("url") ? jSONObject5.getString("url") : str;
            }
            JSONObject jSONObject6 = jSONObject2.has("media") ? jSONObject2.getJSONObject("media") : null;
            if (jSONObject6 != null) {
                this.media = jSONObject6.has("url") ? jSONObject6.getString("url") : str;
                this.contentType = jSONObject6.has("content_type") ? jSONObject6.getString("content_type") : str;
                this.posterUrl = jSONObject6.has("poster") ? jSONObject6.getString("poster") : str;
            }
            JSONObject jSONObject7 = jSONObject2.has("action") ? jSONObject2.getJSONObject("action") : null;
            if (jSONObject7 != null) {
                boolean z = true;
                this.hasUrl = Boolean.valueOf(jSONObject7.has("hasUrl") && jSONObject7.getBoolean("hasUrl"));
                if (!jSONObject7.has("hasLinks") || !jSONObject7.getBoolean("hasLinks")) {
                    z = false;
                }
                this.hasLinks = Boolean.valueOf(z);
                JSONObject jSONObject8 = jSONObject7.has("url") ? jSONObject7.getJSONObject("url") : null;
                if (jSONObject8 != null && this.hasUrl.booleanValue()) {
                    JSONObject jSONObject9 = jSONObject8.has("android") ? jSONObject8.getJSONObject("android") : null;
                    if (jSONObject9 != null) {
                        this.actionUrl = jSONObject9.has("text") ? jSONObject9.getString("text") : str;
                    }
                }
                if (jSONObject8 != null && this.hasLinks.booleanValue()) {
                    this.links = jSONObject7.has("links") ? jSONObject7.getJSONArray("links") : null;
                }
            }
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to init CTInboxMessageContent with JSON - "));
        }
        return this;
    }

    public boolean mediaIsAudio() {
        String str = this.contentType;
        return (str == null || this.media == null || !str.startsWith("audio")) ? false : true;
    }

    public boolean mediaIsGIF() {
        String str = this.contentType;
        return (str == null || this.media == null || !str.equals("image/gif")) ? false : true;
    }

    public boolean mediaIsImage() {
        String str = this.contentType;
        return str != null && this.media != null && str.startsWith(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY) && !str.equals("image/gif");
    }

    public boolean mediaIsVideo() {
        String str = this.contentType;
        return (str == null || this.media == null || !str.startsWith("video")) ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.titleColor);
        parcel.writeString(this.message);
        parcel.writeString(this.messageColor);
        parcel.writeString(this.media);
        parcel.writeByte(this.hasUrl.booleanValue() ? (byte) 1 : 0);
        parcel.writeByte(this.hasLinks.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.icon);
        if (this.links == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.links.toString());
        }
        parcel.writeString(this.contentType);
        parcel.writeString(this.posterUrl);
    }

    public CTInboxMessageContent(Parcel parcel) {
        this.title = parcel.readString();
        this.titleColor = parcel.readString();
        this.message = parcel.readString();
        this.messageColor = parcel.readString();
        this.media = parcel.readString();
        boolean z = true;
        this.hasUrl = Boolean.valueOf(parcel.readByte() != 0);
        this.hasLinks = Boolean.valueOf(parcel.readByte() == 0 ? false : z);
        this.actionUrl = parcel.readString();
        this.icon = parcel.readString();
        try {
            this.links = parcel.readByte() == 0 ? null : new JSONArray(parcel.readString());
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Unable to init CTInboxMessageContent with Parcel - "));
        }
        this.contentType = parcel.readString();
        this.posterUrl = parcel.readString();
    }
}
