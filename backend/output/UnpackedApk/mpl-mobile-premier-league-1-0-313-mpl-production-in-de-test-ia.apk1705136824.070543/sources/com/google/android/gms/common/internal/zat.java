package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zat extends AbstractSafeParcelable {
    public static final Creator<zat> CREATOR = new zau();
    @VersionField
    public final int zaa;
    @Field
    public final Account zab;
    @Field
    public final int zac;
    @Field
    public final GoogleSignInAccount zad;

    @Constructor
    public zat(@Param(id = 1) int i, @Param(id = 2) Account account, @Param(id = 3) int i2, @Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.zaa = i;
        this.zab = account;
        this.zac = i2;
        this.zad = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        int i3 = this.zac;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zad, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public zat(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.zaa = 2;
        this.zab = account;
        this.zac = i;
        this.zad = googleSignInAccount;
    }
}
