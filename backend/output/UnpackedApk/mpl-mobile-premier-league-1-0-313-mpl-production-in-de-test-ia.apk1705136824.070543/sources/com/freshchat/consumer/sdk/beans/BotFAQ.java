package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;

public class BotFAQ implements Parcelable {
    public static final Creator<BotFAQ> CREATOR = new Creator<BotFAQ>() {
        public BotFAQ createFromParcel(Parcel parcel) {
            return new BotFAQ(parcel);
        }

        public BotFAQ[] newArray(int i) {
            return new BotFAQ[i];
        }
    };
    public String alias;
    public String contentType;
    public String created;
    public String id;
    public TemplateContentPayloads templateContentPayloads;
    public String templateHash;
    public String updated;

    public BotFAQ(Parcel parcel) {
        this.id = parcel.readString();
        this.alias = parcel.readString();
        this.contentType = parcel.readString();
        try {
            String readString = parcel.readString();
            if (as.isEmpty(readString)) {
                this.templateContentPayloads = (TemplateContentPayloads) ab.in().fromJson(readString, TemplateContentPayloads.class);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        this.created = parcel.readString();
        this.updated = parcel.readString();
        this.templateHash = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCreated() {
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public TemplateContentPayloads getTemplateContentPayloads() {
        return this.templateContentPayloads;
    }

    public String getTemplateHash() {
        return this.templateHash;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.alias);
        parcel.writeString(this.contentType);
        parcel.writeString(this.templateContentPayloads != null ? ab.in().toJson(this.templateContentPayloads) : null);
        parcel.writeString(this.created);
        parcel.writeString(this.updated);
        parcel.writeString(this.templateHash);
    }
}
