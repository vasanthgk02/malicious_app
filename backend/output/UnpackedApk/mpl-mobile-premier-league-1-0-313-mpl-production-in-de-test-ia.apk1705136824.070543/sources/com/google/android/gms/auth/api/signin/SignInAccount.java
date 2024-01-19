package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zbc();
    @Field
    @Deprecated
    public String zba;
    @Field
    @Deprecated
    public String zbb;
    @Field
    public GoogleSignInAccount zbc;

    @Constructor
    public SignInAccount(@Param(id = 4) String str, @Param(id = 7) GoogleSignInAccount googleSignInAccount, @Param(id = 8) String str2) {
        this.zbc = googleSignInAccount;
        Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.zba = str;
        Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.zbb = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.zba, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zbc, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zbb, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
