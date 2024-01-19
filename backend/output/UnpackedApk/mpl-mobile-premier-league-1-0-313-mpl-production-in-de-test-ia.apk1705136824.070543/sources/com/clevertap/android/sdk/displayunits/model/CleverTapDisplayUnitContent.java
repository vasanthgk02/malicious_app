package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import org.json.JSONObject;

public class CleverTapDisplayUnitContent implements Parcelable {
    public static final Creator<CleverTapDisplayUnitContent> CREATOR = new Creator<CleverTapDisplayUnitContent>() {
        public Object createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnitContent(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CleverTapDisplayUnitContent[i];
        }
    };
    public String actionUrl;
    public String contentType;
    public String error;
    public String icon;
    public String media;
    public String message;
    public String messageColor;
    public String posterUrl;
    public String title;
    public String titleColor;

    public CleverTapDisplayUnitContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.title = str;
        this.titleColor = str2;
        this.message = str3;
        this.messageColor = str4;
        this.icon = str5;
        this.media = str6;
        this.contentType = str7;
        this.posterUrl = str8;
        this.actionUrl = str9;
        this.error = str10;
    }

    public static CleverTapDisplayUnitContent toContent(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = null;
            JSONObject jSONObject4 = jSONObject2.has("title") ? jSONObject2.getJSONObject("title") : null;
            String str9 = "";
            if (jSONObject4 != null) {
                String string = jSONObject4.has("text") ? jSONObject4.getString("text") : str9;
                str = jSONObject4.has("color") ? jSONObject4.getString("color") : str9;
                str2 = string;
            } else {
                str2 = str9;
                str = str2;
            }
            JSONObject jSONObject5 = jSONObject2.has("message") ? jSONObject2.getJSONObject("message") : null;
            if (jSONObject5 != null) {
                String string2 = jSONObject5.has("text") ? jSONObject5.getString("text") : str9;
                str3 = jSONObject5.has("color") ? jSONObject5.getString("color") : str9;
                str4 = string2;
            } else {
                str4 = str9;
                str3 = str4;
            }
            JSONObject jSONObject6 = jSONObject2.has("icon") ? jSONObject2.getJSONObject("icon") : null;
            if (jSONObject6 != null) {
                str5 = jSONObject6.has("url") ? jSONObject6.getString("url") : str9;
            } else {
                str5 = str9;
            }
            JSONObject jSONObject7 = jSONObject2.has("media") ? jSONObject2.getJSONObject("media") : null;
            if (jSONObject7 != null) {
                String string3 = jSONObject7.has("url") ? jSONObject7.getString("url") : str9;
                String string4 = jSONObject7.has("content_type") ? jSONObject7.getString("content_type") : str9;
                str6 = jSONObject7.has("poster") ? jSONObject7.getString("poster") : str9;
                str7 = string4;
                str8 = string3;
            } else {
                str8 = str9;
                str7 = str8;
                str6 = str7;
            }
            JSONObject jSONObject8 = jSONObject2.has("action") ? jSONObject2.getJSONObject("action") : null;
            if (jSONObject8 != null) {
                JSONObject jSONObject9 = jSONObject8.has("url") ? jSONObject8.getJSONObject("url") : null;
                if (jSONObject9 != null) {
                    if (jSONObject9.has("android")) {
                        jSONObject3 = jSONObject9.getJSONObject("android");
                    }
                    if (jSONObject3 != null && jSONObject3.has("text")) {
                        str9 = jSONObject3.getString("text");
                    }
                }
            }
            CleverTapDisplayUnitContent cleverTapDisplayUnitContent = new CleverTapDisplayUnitContent(str2, str, str4, str3, str5, str8, str7, str6, str9, null);
            return cleverTapDisplayUnitContent;
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to init CleverTapDisplayUnitContent with JSON - ");
            outline73.append(e2.getLocalizedMessage());
            Logger.d("DisplayUnit : ", outline73.toString());
            CleverTapDisplayUnitContent cleverTapDisplayUnitContent2 = new CleverTapDisplayUnitContent("", "", "", "", "", "", "", "", "", GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline73("Error Creating DisplayUnit Content from JSON : ")));
            return cleverTapDisplayUnitContent2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[ title:");
        outline73.append(this.title);
        outline73.append(", titleColor:");
        outline73.append(this.titleColor);
        outline73.append(" message:");
        outline73.append(this.message);
        outline73.append(", messageColor:");
        outline73.append(this.messageColor);
        outline73.append(", media:");
        outline73.append(this.media);
        outline73.append(", contentType:");
        outline73.append(this.contentType);
        outline73.append(", posterUrl:");
        outline73.append(this.posterUrl);
        outline73.append(", actionUrl:");
        outline73.append(this.actionUrl);
        outline73.append(", icon:");
        outline73.append(this.icon);
        outline73.append(", error:");
        return GeneratedOutlineSupport.outline62(outline73, this.error, " ]");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.titleColor);
        parcel.writeString(this.message);
        parcel.writeString(this.messageColor);
        parcel.writeString(this.icon);
        parcel.writeString(this.media);
        parcel.writeString(this.contentType);
        parcel.writeString(this.posterUrl);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.error);
    }

    public CleverTapDisplayUnitContent(Parcel parcel, AnonymousClass1 r2) {
        this.title = parcel.readString();
        this.titleColor = parcel.readString();
        this.message = parcel.readString();
        this.messageColor = parcel.readString();
        this.icon = parcel.readString();
        this.media = parcel.readString();
        this.contentType = parcel.readString();
        this.posterUrl = parcel.readString();
        this.actionUrl = parcel.readString();
        this.error = parcel.readString();
    }
}
