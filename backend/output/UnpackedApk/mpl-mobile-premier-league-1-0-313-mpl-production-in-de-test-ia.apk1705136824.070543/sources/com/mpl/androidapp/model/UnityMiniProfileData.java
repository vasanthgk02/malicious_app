package com.mpl.androidapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.mpl.payment.braintree.BraintreeConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006,"}, d2 = {"Lcom/mpl/androidapp/model/UnityMiniProfileData;", "Landroid/os/Parcelable;", "()V", "profileId", "", "gameplayCount", "extraInfo", "", "isGameComplete", "", "gameID", "(IILjava/lang/String;ZI)V", "getExtraInfo", "()Ljava/lang/String;", "setExtraInfo", "(Ljava/lang/String;)V", "getGameID", "()I", "setGameID", "(I)V", "getGameplayCount", "setGameplayCount", "()Z", "setGameComplete", "(Z)V", "getProfileId", "setProfileId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
/* compiled from: UnityMiniProfileData.kt */
public final class UnityMiniProfileData implements Parcelable {
    public static final android.os.Parcelable.Creator<UnityMiniProfileData> CREATOR = new Creator();
    @SerializedName("extraInfo")
    public String extraInfo;
    @SerializedName("gameID")
    public int gameID;
    @SerializedName("gameplayCount")
    public int gameplayCount;
    @SerializedName("isGameComplete")
    public boolean isGameComplete;
    @SerializedName("profileId")
    public int profileId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityMiniProfileData.kt */
    public static final class Creator implements android.os.Parcelable.Creator<UnityMiniProfileData> {
        public final UnityMiniProfileData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            UnityMiniProfileData unityMiniProfileData = new UnityMiniProfileData(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
            return unityMiniProfileData;
        }

        public final UnityMiniProfileData[] newArray(int i) {
            return new UnityMiniProfileData[i];
        }
    }

    public UnityMiniProfileData(int i, int i2, String str, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(str, BraintreeConstants.NS_EXTRAINFO);
        this.profileId = i;
        this.gameplayCount = i2;
        this.extraInfo = str;
        this.isGameComplete = z;
        this.gameID = i3;
    }

    public static /* synthetic */ UnityMiniProfileData copy$default(UnityMiniProfileData unityMiniProfileData, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = unityMiniProfileData.profileId;
        }
        if ((i4 & 2) != 0) {
            i2 = unityMiniProfileData.gameplayCount;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            str = unityMiniProfileData.extraInfo;
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            z = unityMiniProfileData.isGameComplete;
        }
        boolean z2 = z;
        if ((i4 & 16) != 0) {
            i3 = unityMiniProfileData.gameID;
        }
        return unityMiniProfileData.copy(i, i5, str2, z2, i3);
    }

    public final int component1() {
        return this.profileId;
    }

    public final int component2() {
        return this.gameplayCount;
    }

    public final String component3() {
        return this.extraInfo;
    }

    public final boolean component4() {
        return this.isGameComplete;
    }

    public final int component5() {
        return this.gameID;
    }

    public final UnityMiniProfileData copy(int i, int i2, String str, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(str, BraintreeConstants.NS_EXTRAINFO);
        UnityMiniProfileData unityMiniProfileData = new UnityMiniProfileData(i, i2, str, z, i3);
        return unityMiniProfileData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityMiniProfileData)) {
            return false;
        }
        UnityMiniProfileData unityMiniProfileData = (UnityMiniProfileData) obj;
        return this.profileId == unityMiniProfileData.profileId && this.gameplayCount == unityMiniProfileData.gameplayCount && Intrinsics.areEqual(this.extraInfo, unityMiniProfileData.extraInfo) && this.isGameComplete == unityMiniProfileData.isGameComplete && this.gameID == unityMiniProfileData.gameID;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final int getGameID() {
        return this.gameID;
    }

    public final int getGameplayCount() {
        return this.gameplayCount;
    }

    public final int getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.extraInfo, ((this.profileId * 31) + this.gameplayCount) * 31, 31);
        boolean z = this.isGameComplete;
        if (z) {
            z = true;
        }
        return ((outline11 + (z ? 1 : 0)) * 31) + this.gameID;
    }

    public final boolean isGameComplete() {
        return this.isGameComplete;
    }

    public final void setExtraInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraInfo = str;
    }

    public final void setGameComplete(boolean z) {
        this.isGameComplete = z;
    }

    public final void setGameID(int i) {
        this.gameID = i;
    }

    public final void setGameplayCount(int i) {
        this.gameplayCount = i;
    }

    public final void setProfileId(int i) {
        this.profileId = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnityMiniProfileData(profileId=");
        outline73.append(this.profileId);
        outline73.append(", gameplayCount=");
        outline73.append(this.gameplayCount);
        outline73.append(", extraInfo=");
        outline73.append(this.extraInfo);
        outline73.append(", isGameComplete=");
        outline73.append(this.isGameComplete);
        outline73.append(", gameID=");
        return GeneratedOutlineSupport.outline56(outline73, this.gameID, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.profileId);
        parcel.writeInt(this.gameplayCount);
        parcel.writeString(this.extraInfo);
        parcel.writeInt(this.isGameComplete ? 1 : 0);
        parcel.writeInt(this.gameID);
    }

    public UnityMiniProfileData() {
        this(0, 0, "", false, 0);
    }
}
