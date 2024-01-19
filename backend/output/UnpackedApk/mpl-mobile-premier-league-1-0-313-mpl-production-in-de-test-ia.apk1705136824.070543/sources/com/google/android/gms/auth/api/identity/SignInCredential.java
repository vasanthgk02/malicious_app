package com.google.android.gms.auth.api.identity;

import android.net.Uri;
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
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Creator<SignInCredential> CREATOR = new zbm();
    @Field
    public final String zba;
    @Field
    public final String zbb;
    @Field
    public final String zbc;
    @Field
    public final String zbd;
    @Field
    public final Uri zbe;
    @Field
    public final String zbf;
    @Field
    public final String zbg;
    @Field
    public final String zbh;

    @Constructor
    public SignInCredential(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) String str3, @Param(id = 4) String str4, @Param(id = 5) Uri uri, @Param(id = 6) String str5, @Param(id = 7) String str6, @Param(id = 8) String str7) {
        Preconditions.checkNotEmpty(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = uri;
        this.zbf = str5;
        this.zbg = str6;
        this.zbh = str7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!Objects.equal(this.zba, signInCredential.zba) || !Objects.equal(this.zbb, signInCredential.zbb) || !Objects.equal(this.zbc, signInCredential.zbc) || !Objects.equal(this.zbd, signInCredential.zbd) || !Objects.equal(this.zbe, signInCredential.zbe) || !Objects.equal(this.zbf, signInCredential.zbf) || !Objects.equal(this.zbg, signInCredential.zbg) || !Objects.equal(this.zbh, signInCredential.zbh)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zba, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zbd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zbe, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zbf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zbg, false);
        SafeParcelWriter.writeString(parcel, 8, this.zbh, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
