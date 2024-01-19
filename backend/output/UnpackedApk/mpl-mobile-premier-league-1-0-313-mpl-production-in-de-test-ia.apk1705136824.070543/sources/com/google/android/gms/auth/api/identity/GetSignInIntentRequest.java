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
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Creator<GetSignInIntentRequest> CREATOR = new zbf();
    @Field
    public final String zba;
    @Field
    public final String zbb;
    @Field
    public String zbc;
    @Field
    public final String zbd;
    @Field
    public final boolean zbe;
    @Field
    public final int zbf;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
        public String zba;
        public String zbb;
        public String zbc;
        public String zbd;
        public boolean zbe;
        public int zbf;
    }

    @Constructor
    public GetSignInIntentRequest(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) String str3, @Param(id = 4) String str4, @Param(id = 5) boolean z, @Param(id = 6) int i) {
        Preconditions.checkNotNull(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = z;
        this.zbf = i;
    }

    public static Builder zba(GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.checkNotNull(getSignInIntentRequest);
        Builder builder = new Builder();
        String str = getSignInIntentRequest.zba;
        Preconditions.checkNotNull(str);
        builder.zba = str;
        builder.zbd = getSignInIntentRequest.zbd;
        builder.zbb = getSignInIntentRequest.zbb;
        builder.zbe = getSignInIntentRequest.zbe;
        builder.zbf = getSignInIntentRequest.zbf;
        String str2 = getSignInIntentRequest.zbc;
        if (str2 != null) {
            builder.zbc = str2;
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!Objects.equal(this.zba, getSignInIntentRequest.zba) || !Objects.equal(this.zbd, getSignInIntentRequest.zbd) || !Objects.equal(this.zbb, getSignInIntentRequest.zbb) || !Objects.equal(Boolean.valueOf(this.zbe), Boolean.valueOf(getSignInIntentRequest.zbe)) || this.zbf != getSignInIntentRequest.zbf) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbd, Boolean.valueOf(this.zbe), Integer.valueOf(this.zbf)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zba, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zbd, false);
        boolean z = this.zbe;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        int i2 = this.zbf;
        parcel.writeInt(262150);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
