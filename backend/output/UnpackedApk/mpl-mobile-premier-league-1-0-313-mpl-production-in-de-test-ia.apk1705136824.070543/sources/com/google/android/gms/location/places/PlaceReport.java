package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.Arrays;

@Class
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new zza();
    @Field
    public final String tag;
    @VersionField
    public final int versionCode;
    @Field
    public final String zza;
    @Field
    public final String zzb;

    @Constructor
    public PlaceReport(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3) {
        this.versionCode = i;
        this.zza = str;
        this.tag = str2;
        this.zzb = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return Objects.equal(this.zza, placeReport.zza) && Objects.equal(this.tag, placeReport.tag) && Objects.equal(this.zzb, placeReport.zzb);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.tag, this.zzb});
    }

    public String toString() {
        ToStringHelper toStringHelper = new ToStringHelper(this);
        toStringHelper.add("placeId", this.zza);
        toStringHelper.add(InlineAnimation.TAG, this.tag);
        if (!"unknown".equals(this.zzb)) {
            toStringHelper.add(DefaultSettingsSpiCall.SOURCE_PARAM, this.zzb);
        }
        return toStringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.versionCode;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.tag, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzb, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
