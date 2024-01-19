package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SignInPassword extends AbstractSafeParcelable {
    public static final Creator<SignInPassword> CREATOR = new zbo();
    @Field
    public final String zba;
    @Field
    public final String zbb;

    @Constructor
    public SignInPassword(@Param(id = 1) String str, @Param(id = 2) String str2) {
        Preconditions.checkNotNull(str, "Account identifier cannot be null");
        String trim = str.trim();
        Preconditions.checkNotEmpty(trim, "Account identifier cannot be empty");
        this.zba = trim;
        Preconditions.checkNotEmpty(str2);
        this.zbb = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        if (!Objects.equal(this.zba, signInPassword.zba) || !Objects.equal(this.zbb, signInPassword.zbb)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zba, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
