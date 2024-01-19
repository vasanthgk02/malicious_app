package com.mpl.androidapp.miniprofile.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/CometChatPayload;", "Landroid/os/Parcelable;", "chatGroupId", "", "chatGroupName", "cometChatMsgId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatGroupId", "()Ljava/lang/String;", "getChatGroupName", "getCometChatMsgId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CometChatPayload.kt */
public final class CometChatPayload implements Parcelable {
    public static final android.os.Parcelable.Creator<CometChatPayload> CREATOR = new Creator();
    @SerializedName("groupId")
    public final String chatGroupId;
    @SerializedName("groupName")
    public final String chatGroupName;
    @SerializedName("cometChatMsgId")
    public final String cometChatMsgId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CometChatPayload.kt */
    public static final class Creator implements android.os.Parcelable.Creator<CometChatPayload> {
        public final CometChatPayload createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CometChatPayload(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final CometChatPayload[] newArray(int i) {
            return new CometChatPayload[i];
        }
    }

    public CometChatPayload(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "chatGroupId", str2, "chatGroupName", str3, "cometChatMsgId");
        this.chatGroupId = str;
        this.chatGroupName = str2;
        this.cometChatMsgId = str3;
    }

    public static /* synthetic */ CometChatPayload copy$default(CometChatPayload cometChatPayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cometChatPayload.chatGroupId;
        }
        if ((i & 2) != 0) {
            str2 = cometChatPayload.chatGroupName;
        }
        if ((i & 4) != 0) {
            str3 = cometChatPayload.cometChatMsgId;
        }
        return cometChatPayload.copy(str, str2, str3);
    }

    public final String component1() {
        return this.chatGroupId;
    }

    public final String component2() {
        return this.chatGroupName;
    }

    public final String component3() {
        return this.cometChatMsgId;
    }

    public final CometChatPayload copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "chatGroupId");
        Intrinsics.checkNotNullParameter(str2, "chatGroupName");
        Intrinsics.checkNotNullParameter(str3, "cometChatMsgId");
        return new CometChatPayload(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CometChatPayload)) {
            return false;
        }
        CometChatPayload cometChatPayload = (CometChatPayload) obj;
        return Intrinsics.areEqual(this.chatGroupId, cometChatPayload.chatGroupId) && Intrinsics.areEqual(this.chatGroupName, cometChatPayload.chatGroupName) && Intrinsics.areEqual(this.cometChatMsgId, cometChatPayload.cometChatMsgId);
    }

    public final String getChatGroupId() {
        return this.chatGroupId;
    }

    public final String getChatGroupName() {
        return this.chatGroupName;
    }

    public final String getCometChatMsgId() {
        return this.cometChatMsgId;
    }

    public int hashCode() {
        return this.cometChatMsgId.hashCode() + GeneratedOutlineSupport.outline11(this.chatGroupName, this.chatGroupId.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CometChatPayload(chatGroupId=");
        outline73.append(this.chatGroupId);
        outline73.append(", chatGroupName=");
        outline73.append(this.chatGroupName);
        outline73.append(", cometChatMsgId=");
        return GeneratedOutlineSupport.outline59(outline73, this.cometChatMsgId, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.chatGroupId);
        parcel.writeString(this.chatGroupName);
        parcel.writeString(this.cometChatMsgId);
    }
}
