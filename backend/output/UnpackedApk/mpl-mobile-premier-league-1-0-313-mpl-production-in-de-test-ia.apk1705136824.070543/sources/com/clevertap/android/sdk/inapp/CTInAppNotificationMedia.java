package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class CTInAppNotificationMedia implements Parcelable {
    public static final Creator<CTInAppNotificationMedia> CREATOR = new Creator<CTInAppNotificationMedia>() {
        public Object createFromParcel(Parcel parcel) {
            return new CTInAppNotificationMedia(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CTInAppNotificationMedia[i];
        }
    };
    public String cacheKey;
    public String contentType;
    public String mediaUrl;
    public int orientation;

    public CTInAppNotificationMedia() {
    }

    public int describeContents() {
        return 0;
    }

    public CTInAppNotificationMedia initWithJSON(JSONObject jSONObject, int i) {
        this.orientation = i;
        try {
            String str = "";
            this.contentType = jSONObject.has("content_type") ? jSONObject.getString("content_type") : str;
            if (jSONObject.has("url")) {
                str = jSONObject.getString("url");
            }
            if (!str.isEmpty()) {
                if (this.contentType.startsWith(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY)) {
                    this.mediaUrl = str;
                    if (jSONObject.has("key")) {
                        this.cacheKey = UUID.randomUUID().toString() + jSONObject.getString("key");
                    } else {
                        this.cacheKey = UUID.randomUUID().toString();
                    }
                } else {
                    this.mediaUrl = str;
                }
            }
        } catch (JSONException e2) {
            GeneratedOutlineSupport.outline105(e2, GeneratedOutlineSupport.outline73("Error parsing Media JSONObject - "));
        }
        if (this.contentType.isEmpty()) {
            return null;
        }
        return this;
    }

    public boolean isAudio() {
        String str = this.contentType;
        return (str == null || this.mediaUrl == null || !str.startsWith("audio")) ? false : true;
    }

    public boolean isGIF() {
        String str = this.contentType;
        return (str == null || this.mediaUrl == null || !str.equals("image/gif")) ? false : true;
    }

    public boolean isImage() {
        String str = this.contentType;
        return str != null && this.mediaUrl != null && str.startsWith(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY) && !str.equals("image/gif");
    }

    public boolean isVideo() {
        String str = this.contentType;
        return (str == null || this.mediaUrl == null || !str.startsWith("video")) ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mediaUrl);
        parcel.writeString(this.contentType);
        parcel.writeString(this.cacheKey);
        parcel.writeInt(this.orientation);
    }

    public CTInAppNotificationMedia(Parcel parcel, AnonymousClass1 r2) {
        this.mediaUrl = parcel.readString();
        this.contentType = parcel.readString();
        this.cacheKey = parcel.readString();
        this.orientation = parcel.readInt();
    }
}
